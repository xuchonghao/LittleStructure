
public class MergeSolution {
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        for(int i=1;i<5;i++){
            ListNode node = new ListNode(i);
            listNode.next = node;
            listNode = node;
        }
        ListNode head1 = new ListNode(6);
        ListNode listNode1 = head1;
        for(int i=7;i<10;i++){
            ListNode node = new ListNode(i);
            listNode1.next = node;
            listNode1 = node;
        }
        ListNode list = Merge(head1,head);
        while(list!=null){
            System.out.println(list.value);
            list = list.next;
        }
    }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        ListNode first = list1;
        ListNode second = list2;
        ListNode head ;//
        ListNode list ;
        if(first.value <= second.value){
            head = new ListNode(first.value);
            first = first.next;
        }else{
            head = new ListNode(second.value);
            second = second.next;
        }
        list = head;
        //ListNode head = null;//
        //ListNode list = head;
        while(first != null && second != null){
            if(first.value <= second.value){
               // head = new ListNode(first.value);
                ListNode node = new ListNode(first.value);
                head.next = node;
                head = head.next;
                first = first.next;
            }else {
                head.next = new ListNode(second.value);
                head = head.next;
                second = second.next;
            }
        }
        while(first != null){
            head.next = new ListNode(first.value);
            head = head.next;
            first = first.next;
        }
        while(second != null){
            head.next = new ListNode(second.value);
            head = head.next;
            second = second.next;
        }

        return list;
    }
}
