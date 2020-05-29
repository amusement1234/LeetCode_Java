package tree;

import java.util.LinkedList;

import app.TreeNode;

public class BinaryTree {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }

        Integer data = inputList.removeFirst();

        if (data != null) {
            node = new TreeNode(data);
            System.out.println("inputList left:"+inputList);
            node.left = createBinaryTree(inputList);
            preOrderTraveral(node);
            System.out.println("");

            System.out.println("inputList right:"+inputList);
            node.right = createBinaryTree(inputList);
            preOrderTraveral(node);
            System.out.println("");

        }
        return node;
    }

    /**
     * 二叉树前序遍历
     * @param node 二叉树节点
     */
    public static void preOrderTraveral(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val+" ");
        preOrderTraveral(node.left);
        preOrderTraveral(node.right);

    }

    /**
     * 二叉树中序遍历
     * @param node 二叉树节点
     */
    public static void inOrderTraveral(TreeNode node) {
        if (node == null)
            return;
        inOrderTraveral(node.left);
        System.out.println(node.val);
        inOrderTraveral(node.right);

    }

    /**
     * 二叉树后序遍历
     * @param node 二叉树节点
     */
    public static void postOrderTraveral(TreeNode node) {
        if (node == null)
            return;
        postOrderTraveral(node.left);
        postOrderTraveral(node.right);
        System.out.println(node.val);

    }

}