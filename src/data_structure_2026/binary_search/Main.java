package data_structure_2026.binary_search;

public class Main {
    public static void main(String[] args) {
        int[]arr = new int[]{1,2,2,2,2,2,5,6,6,7,8,9};
        int[]desc = new int[]{12,11,8,4,3,1};
//        System.out.println(BinarySearch.searchIndex(arr,2));
//        System.out.println(BinarySearch.searchInUnknownOrder(desc,1));
//        System.out.println(BinarySearch.searchInUnknownOrder(arr,2));
//        System.out.println(BinarySearch.findFirstIndex(arr,9));
//        System.out.println(BinarySearch.findLastIndex(arr,90));
//        System.out.println(BinarySearch.countOccurrence(arr,9));
        int[]rota=new int[]{4,5,6,7,8,1,1,1,1,1,1,1,2,2,3};
        int[]rotb=new int[]{4,5,6,7,8,1};
        int[]rotc=new int[]{9,4,5,6,7,8};
//        System.out.println(BinarySearch.minIndexInRotated(rota));
//        System.out.println(BinarySearch.minIndexInRotated(rotb));
//        System.out.println(BinarySearch.minIndexInRotated(rotc));
//        System.out.println(BinarySearch.maxIndexInRotated(rota));
//        System.out.println(BinarySearch.maxIndexInRotated(rotb));
//        System.out.println(BinarySearch.maxIndexInRotated(rotc));

//          System.out.println(BinarySearch.numberRotation(rota));
//        System.out.println(BinarySearch.numberRotation(rotb));
//        System.out.println(BinarySearch.numberRotation(rotc));
//        System.out.println(BinarySearch.searchInRotated(rota,1));
//        System.out.println(BinarySearch.searchInRotated(rotb,1));
//        System.out.println(BinarySearch.searchInRotated(rotc,9));
//        int[]nearly = new int[]{5,10,30,20,40};
//        System.out.println(BinarySearch.searchInNearly(nearly,5));
//        System.out.println(BinarySearch.ceil(arr,7));
//        System.out.println(BinarySearch.floor(arr,7));
//        char[]chars = new char[]{'b','c','d','d','e','h','h','h','h','h','h','h'};
//        System.out.println(BinarySearch.nextAlphabet(chars,'e'));
//        System.out.println(BinarySearch.searchInfinite(arr,9));
//        int[]peakArr=new int[]{10, 11, 15, 2,23, 90, 67};
//        System.out.println(BinarySearch.peakIndex(peakArr));

        int[]bitonic= new int[]{4,5,6,7,8,5,3,1};
//        System.out.println(BinarySearch.peakIndex(bitonic));
        System.out.println(BinarySearch.searchInBitonic(arr,1));
//        System.out.println(BinarySearch.searchInBitonic(arr,4));
//        System.out.println(BinarySearch.searchInBitonic(arr,8));
//        System.out.println(BinarySearch.searchInBitonic(arr,5));

          int[][]matrix = new int[][]{
                  {10,20,30,40},
                  {15,25,35,45},
                  {27,29,37,48},
                  {32,33,39,50}
          };

//        System.out.println(BinarySearch.searchInMatrix(matrix,29));
//        System.out.println(BinarySearch.searchInMatrix(matrix,10));
//        System.out.println(BinarySearch.searchInMatrix(matrix,32));
//        System.out.println(BinarySearch.searchInMatrix(matrix,40));
//        System.out.println(BinarySearch.searchInMatrix(matrix,50));

    }


}
