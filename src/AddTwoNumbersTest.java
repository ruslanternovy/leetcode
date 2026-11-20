import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
  2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order,
 and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
 */
class AddTwoNumbersTest {
    private ListNode toList(int... digits) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i : digits) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        return dummy.next;
    }

    private List<Integer> toArrayList(ListNode head) {
        List<Integer> result = new ArrayList<>();
        while(head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

    @Test
    void example1_equalLengthNoFinalCarry() {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = toList(2, 4, 3); // 342
        ListNode l2 = toList(5, 6, 4); // 465

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertEquals(List.of(7, 0, 8), toArrayList(result)); // 807
    }

    @Test
    void example2_bothZero() {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = toList(0);
        ListNode l2 = toList(0);

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertEquals(List.of(0), toArrayList(result));
    }

    @Test
    void example3_unequalLengthsWithCascadingCarry() {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = toList(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = toList(9, 9, 9, 9);

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertEquals(List.of(8, 9, 9, 9, 0, 0, 0, 1), toArrayList(result));
    }

    @Test
    void singleDigitsWithFinalCarry() {
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode l1 = toList(5);
        ListNode l2 = toList(5);

        ListNode result = solution.addTwoNumbers(l1, l2);
        assertEquals(List.of(0, 1), toArrayList(result)); // 5 + 5 = 10
    }
}