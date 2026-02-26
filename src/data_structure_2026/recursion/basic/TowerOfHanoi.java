package data_structure_2026.recursion.basic;

public class TowerOfHanoi {
    public static void main(String[] args) {
        toh(30,"A","B","C");
    }
    private static void toh(int n, String source, String helper, String destination){
        if(n==1){
            System.out.println(String.format("Move {%s} from source {%s} to Destination {%s}", new Object[]{n, source, destination}));
            return;
        }

        toh(n-1,source,destination,helper);
        System.out.println(String.format("Move {%s} from source {%s} to Destination {%s}", new Object[]{n, source, destination}));
        toh(n-1,helper,source,destination);
    }
}
