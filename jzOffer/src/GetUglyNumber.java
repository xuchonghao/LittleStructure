public class GetUglyNumber {
    public static void main(String[] args) {
        int a = solution(4);
        System.out.println(a);;
    }
    public static int solution(int index) {
        if (index == 1)
            return 1;
        int n = 1;
        int t = n;
        int count = 1;
        while(count < index){
            while(t % 2 == 0){
                t = t / 2;
            }
            while(t % 3 == 0){
                t = t / 3;
            }
            while(t % 5 == 0){
                t = t / 5;
            }
            if(t == 1)
                count++;
        }
        return count;
    }
}
