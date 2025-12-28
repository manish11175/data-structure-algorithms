package preparations.leetcode;

import data_structure.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Problem101 {
    public static void main(String[] args) {
        Node left = new Node(2,new Node(3,null,null),new Node(4,null,null));
        Node right = new Node(2,new Node(4,null,null),new Node(3,null,null));
        Node root= new Node(1,left,right);
        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
        StringBuilder str = new StringBuilder();
    }

    private static boolean isSymmetric(Node root) {
        return isSymmetric(root,root);
    }

    private static boolean isSymmetric(Node root, Node root1) {
        if(root==null && root1==null){
            return true;
        }
        if((root==null && root1!=null) || root1==null && root!=null){
            return false;
        }
        if(root.getVal()!= root1.getVal()){
            return false;
        }
        boolean left = isSymmetric(root.getLeft(),root1.getRight());
        boolean right = isSymmetric(root.getRight(),root1.getLeft());
        System.out.println("----------------> "+root.getVal()+" "+ root1.getVal());
        return left && right && (root.getVal()== root1.getVal());
    }
}
