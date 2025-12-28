package preparations.leetcode;


import java.util.HashMap;

public class NumberToRoman {
    private static HashMap<Integer,String> map = new HashMap<>();

    static{
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
    }
    public static void main(String[] args) {
        int num = 58;
        System.out.println(numberToRoman(num));
    }

    private static String numberToRoman(int num){
        StringBuilder ans  = new StringBuilder();
        int count = 1;
        while(num>0){
            int digit = num %10;
            String str = getRomanString(digit,count);
            ans.insert(0,str);
            count*=10;
            num = num/10;
        }
        return ans.toString();
    }

    private static String getRomanString(int digit,int count) {
        int[]arr = {1000,500,100,50,10,5,1};
        StringBuilder str = new StringBuilder();
        if(digit==4 || digit==9){
            str.append(map.get(count));
            str.append(map.get(digit*count+count));
        }
        else{
             digit=digit*count;
             while(digit>0){
                 int maxValue = 0;
                 for(int i=0;i< arr.length;i++){
                     if(arr[i]<=digit){
                         maxValue=arr[i];
                         break;
                     }
                 }
                 str.append(map.get(maxValue));
                 digit-=maxValue;
             }
        }
        return str.toString();
    }



}
