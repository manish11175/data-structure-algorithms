package data_structure_2026.binary_search.problems;

public class AllocatePagesToStudent {
    public static void main(String[] args) {
//        int[]books=new int[]{10,20,30,40};
//        int[]books =new int[]{15, 10, 19, 10, 5, 18, 7};
        int[]books = new int[]{22, 23, 67};
        int k = 1;
        System.out.println(allocatePages(books,k));
    }

    private static int allocatePages(int[]arr,int k){
        if(arr.length<k){
            return -1;
        }
        int max=0;
        int sum =0;
        for(int i:arr){
            sum+=i;
            max= Math.max(i,max);
        }

        int start = max;
        int end = sum;
        int result=max;
        while(start<=end){
            int mid = start+(end-start)/2;
            int count = isValid(arr,mid,k);
            if(count<=k){
                result=mid;
                end = mid -1;
            }
            else{
                start=  mid+1;
            }
        }
        return result;
    }

    private static int isValid(int[]arr,int maxPage,int student){

        int count =1;
        int sum =0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];

            if(sum>maxPage){
                count+=1;
                if(count>student){
                    return count;
                }
                sum=arr[i];
            }
        }
        return count;
    }
}
