import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxScoreAfterZeroingSubtreesTest {

    @Test
    void testExample1() {
        MaxScoreAfterZeroingSubtrees solution = new MaxScoreAfterZeroingSubtrees();
        int[] parent = {-1, 0, 0, 0, 1, 2, 3, 3};
        int[] op = {1, 1, 0, 0, 1, 1, 0, 1};
        int[] score = {5, 6, 1, 2, 3, 2, 3, -3};

        long actual = solution.maxScore(parent, op, score);
        assertEquals(16L, actual);
    }

    @Test
    void testExample2() {
        MaxScoreAfterZeroingSubtrees solution = new MaxScoreAfterZeroingSubtrees();
        int[] parent = {-1, 0, 0};
        int[] op = {0, 0, 0};
        int[] score = {1, 2, 3};

        assertEquals(6L, solution.maxScore(parent, op, score));
    }

    @Test
    void testSingleNodeLeaf() {
        MaxScoreAfterZeroingSubtrees solution = new MaxScoreAfterZeroingSubtrees();
        int[] parent = {-1};
        int[] op = {1};
        int[] score = {-10};

        assertEquals(-10L, solution.maxScore(parent, op, score));
    }
}

