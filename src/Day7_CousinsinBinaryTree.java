/*
 In a binary tree, the root node is at depth 0,
 and children of each depth k node are at depth k+1.

 Two nodes of a binary tree are cousins if they have the same depth,
 but have different parents.

 We are given the root of a binary tree with unique values,
 and the values x and y of two different nodes in the tree.

 Return true if and only if the nodes corresponding to the values x and y are cousins.

 Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

 Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

 Example 3:
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day7_CousinsinBinaryTree {
    public static void main(String[] args){
        List list = Arrays.asList(1,2,3,null,4);
        ArrayList<Integer> root = new ArrayList<>(list);
        Day7_CousinsinBinaryTree test = new Day7_CousinsinBinaryTree();
        // System.out.println(test.isCousins(root, 2,3));
    }

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    class Half{
        TreeNode parent;
        int level;

        Half(TreeNode parent, int level){
            this.parent = parent;
            this.level = level;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Half h1 = Investigate(root, x, null, 0);
        Half h2 = Investigate(root, y, null, 0);

        return h1.level == h2.level && h1.parent != h2.parent;
    }

    private Half Investigate(TreeNode root, int val, TreeNode parent, int level){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return new Half(parent, level);
        }
        Half leftHalf = Investigate(root.left, val, root, level + 1);
        Half rightHalf = Investigate(root.right, val, root, level + 1);
        return leftHalf == null ? rightHalf : leftHalf;
    }
}
