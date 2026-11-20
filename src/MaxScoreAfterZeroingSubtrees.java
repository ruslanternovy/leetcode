import java.util.ArrayList;

/*
You are given an integer array parent of length n representing a rooted tree with nodes labeled from 0 to n - 1,
where parent[i] denotes the parent of node i. The tree is rooted at node 0, so parent[0] = -1.

You are also given two integer arrays op and score, both of length n, where op[i] determines the operation allowed
at node i, and score[i] represents its score.

You need to process each non-leaf node i according to the following rules:

If op[i] = 0, you can choose at most one child of node i and set the scores of all nodes in that child's subtree to 0.
If op[i] = 1, you must choose exactly one child of node i and set the scores of all nodes in that child's subtree to 0.
Each non-leaf node must be processed exactly once. You may process the nodes in any order.

Return the maximum possible sum of the scores after performing the operations.
*/
import java.util.List;

public class MaxScoreAfterZeroingSubtrees {
    private List<Integer>[] tree;
    private int[] op;
    private int[] score;

    public long maxScore(int[] parent, int[] op, int[] score) {
        int n = parent.length;
        this.op = op;
        this.score = score;
        this.tree = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        return dfs(0);
    }

    private long dfs(int u) {
        long sum = score[u];
        if (tree[u].isEmpty()) {
            return sum;
        }

        long minChild = Long.MAX_VALUE;
        for (int c : tree[u]) {
            long childVal = dfs(c);
            sum += childVal;
            if (childVal < minChild) {
                minChild = childVal;
            }
        }

        long zeroOneChild = sum - minChild;
        if (op[u] == 1) {
            return zeroOneChild;
        }
        return Math.max(sum, zeroOneChild);
    }
}
