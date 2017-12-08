package leetcode.link;

/**
 * Linked List Cycle
 * 
 * Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 * 
 * 题解：时间复杂度 O(n)，空间复杂度 O(1) 的。设置两个指针，一个快一个慢，快的指针每次走两步，慢的指针每次走一步，如果快指针和慢指针相遇，则说明有环。
 * 
 * 
 * Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up: Can you solve it without using extra space?
 * 
 * 题解:
 * 从链表起始处到环入口长度为：a，从环入口到Faster和Slower相遇点长度为：x，整个环长为：c。
 *
 * 明确了以上信息，就可以开始做运算了。。
 * 假设从开始到相遇，Slower走过的路程长为s，由于Faster的步速是Slower的2倍，那么Faster在这段时间走的路程长为2s。
 * 而对于Faster来说，他走的路程还等于之前绕整个环跑的n圈的路程nc，加上最后这一次遇见Slower的路程s。
 *  所以我们有：
 *                  2s = nc + s 
 * 对于Slower来说，他走的路程长度s还等于他从链表起始处到相遇点的距离，所以有：
 *                   s = a + x 
 * 通过以上两个式子代入化简有：
 *                   a + x = nc
 *                   a = nc - x
 *                   a = (n-1)c + c-x
 *                   a = kc + (c-x)
 * 那么可以看出，c-x，就是从相遇点继续走回到环入口的距离。上面整个式子可以看出，如果此时有个pointer1从起始点出发并且同时还有个pointer2从相遇点出发继续往前走（都只迈一步），那么绕过k圈以后， pointer2会和pointer1在环入口相遇。这样，换入口就找到了。
 * 
 * 
 */
public class LinkedListCycle {
    boolean hasCycle(ListNode head) {
        // 设置两个指针，一个快一个慢
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public ListNode findCycleEntrance(ListNode head) {
        if (head == null || head.next == null)
            return null;
        //双指针：快指针，慢指针
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                break;
        }
        //slow back to start point
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        //when slow == fast, it is where cycle begins
        return slow; 
    }

}