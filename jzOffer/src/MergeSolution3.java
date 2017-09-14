
public class MergeSolution3 {
    public static void main(String[] args){
        ListNode1 head = new ListNode1(0);
        ListNode1 listNode = head;
        for(int i=1;i<5;i++){
            ListNode1 node = new ListNode1(i);
            listNode.next = node;
            listNode = node;
        }
        ListNode1 head1 = new ListNode1(6);
        ListNode1 listNode1 = head1;
        for(int i=7;i<10;i++){
            ListNode1 node = new ListNode1(i);
            listNode1.next = node;
            listNode1 = node;
        }
        ListNode1 list = Merge(head1,head);
        while(list!=null){
            System.out.println(list.val);
            list = list.next;
        }
    }
    public static ListNode1 Merge(ListNode1 list1,ListNode1 list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode1 head = null;
        if(list1.val <= list2.val){
            head = list1;
            list1 = list1.next;
            head.next = Merge(list1,list2);
        }else{
            head = list2;
            list2 = list2.next;
            head.next = Merge(list1,list2);
        }
        return head;
    }
}
class ListNode1{
    int val;
    ListNode1 next;
    public ListNode1(int val){
        this.val = val;
    }
}