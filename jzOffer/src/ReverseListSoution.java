import java.util.List;
/**
 *
 * 我这里使用p表示当前，pre表示前一，q表示前二
 * 这样不好，应该用p表示当前，pre表示前一，q表示后一*/
public class ReverseListSoution {
    public static ListNode ReverseList(ListNode head) {
        ListNode p,pre,q;
        if(head == null){//以后要注意边界的安全判断------》这里是指程序的鲁棒性
            return null;
        }
        if(head.next != null){
            p = head.next;
        }else
            p = null;

        pre = head;
        q = null;
        while(p != null){
            pre.next = q;

            q = pre;
            pre = p;
            p = p.next;
        }//这种情况下，把最后一种情况找出来画一下就好，重在实践
        pre.next = q;
        head = pre;
        while(pre != null){
            System.out.println(pre.value);
            pre = pre.next;
        }
        return head;
    }
    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode listNode = head;
        for(int i=1;i<5;i++){
             ListNode node = new ListNode(i);
            listNode.next = node;
            listNode = node;
        }
    /*ListNode node2 = head;
    while(node2 != null){
        System.out.println(node2.value);
        node2 = node2.next;
    }*/
   // ReverseList(head);
        int[] a = new int[]{1,2,3,4,5};
        int[] arr = new int[]{9,7,8,6};
        //a = testArray(a);
        a = arr;
        arr[2] = 99;
        for(int i=0;i<3;i++){
            System.out.println(a[i]);
        }
}
public static int[] testArray(int[] array){
          int[] arr = new int[]{9,7,8,6};
          array = new int[]{0,10,11,12};
          array = arr;
          return array;
}
    public void reOrderArray(int [] array) {
        int len = array.length;
        int [] arr = new int[len];
        int p = 0;
        int i=0;
        while(i < len){
            if(array[i] % 2 == 1)
                arr[p++] = array[i];
            i++;
        }
        i = 0;
        while(i < len){
            if(array[i] % 2 == 0)
                arr[p++] = array[i];
            i++;
        }

        for(i=0;i<len;i++){
            array[i] = arr[i];
        }
    }
}
class ListNode{
    int value;
    ListNode next;
    public ListNode(int value){
        this.value = value;
    }
}