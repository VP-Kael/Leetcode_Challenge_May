/*
 Given a singly linked list, group all odd nodes together followed by the even nodes.
 Please note here we are talking about the node number and not the value in the nodes.

 Example 1:
    Input: 1->2->3->4->5->NULL
    Output: 1->3->5->2->4->NULL

 Example 2:
    Input: 2->1->3->5->6->4->7->NULL
    Output: 2->3->6->7->1->5->4->NULL
 */

public class Day16_OddEvenLinkedList {
    public static void main(String[] args){
        Day16_OddEvenLinkedList test = new Day16_OddEvenLinkedList();
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(4, node7);
        ListNode node5 = new ListNode(6, node6);
        ListNode node4 = new ListNode(5, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node = test.oddEvenList(node1);
        while(true){
            System.out.print(node.val + "\t");
            if (node.next != null){
                node = node.next;
            }else{
                break;
            }
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode prevOdd=null;
        ListNode prevEven=null;
        ListNode headOfEven=null;
        ListNode current=head;

        int count=1;
        while(current!=null){
            if((count%2)==0){
                if(prevEven==null){
                    headOfEven=current;
                }
                else{
                    prevEven.next=current;
                }
                prevEven=current;
            }
            else{
                if(prevOdd!=null){
                    prevOdd.next=current;
                }
                prevOdd=current;
            }
            current=current.next;
            count++;
        }

        if(prevOdd!=null)
            prevOdd.next = headOfEven;
        if(prevEven!=null)
            prevEven.next = null;
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
