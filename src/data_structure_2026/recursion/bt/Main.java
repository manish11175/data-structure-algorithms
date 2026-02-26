package data_structure_2026.recursion.bt;

public class Main {
    public static void main(String[] args) {
            int num = 2736;
            int max = -1;
            int index = 0;
            int i=0;
            int temp = num;
            int len = (int) (Math.log10(num)+1);
            while(temp!=0){
                int digit = temp%10;
                i+=1;
                if(digit>max){
                    index=i;
                    max=digit;
                }

                temp/=10;
            }

        String str = String.valueOf(num);
        char[] arr = str.toCharArray();

        int idx = len-index;
        char first = arr[0];
        arr[0] = arr[idx];
        arr[idx] = first;
        System.out.println(index);
        int ans= Integer.parseInt(new String(arr));

        }
}
