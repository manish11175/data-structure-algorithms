package preparations.leetcode;

import data_structure.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversalOnTree {
    public static void main(String[] args) {
        Node left = new Node(3,new Node(2,null,null),new Node(4,null,null));
        Node right = new Node(8,new Node(7,null,null),new Node(9,null,null));
        Node root= new Node(5,left,right);
        List<Integer> ans = rightRootLeft(root);
        System.out.println(ans);
    }

    private static List<Integer> rightRootLeft(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightRootLeft(root,ans);
        return ans;
    }

    private static void rightRootLeft(Node root, List<Integer> ans) {
         if(root==null){
             return;
         }
         rightRootLeft(root.getRight(),ans);
         ans.add(root.getVal());
         rightRootLeft(root.getLeft(),ans);
    }
}
