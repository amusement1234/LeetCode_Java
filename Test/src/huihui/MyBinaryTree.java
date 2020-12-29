package huihui;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import app.TreeNode;

public class MyBinaryTree {
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty())
            return null;

        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;
    }

    //前序遍历
    public static void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //非递归 前序遍历
    public static void preOrderTraversal2(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }

    }

    //层序遍历
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);//尾部添加
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();//移除头部
            System.out.println(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }

    }

    // public static void inOrderTraversal(TreeNode root) {
    //     if (root == null)
    //         return;
    //     preOrderTraversal(root.left);
    //     System.out.println(root.val);
    //     preOrderTraversal(root.right);
    // }

    // public static void postOrderTraversal(TreeNode root) {
    //     if (root == null)
    //         return;
    //     preOrderTraversal(root.left);
    //     preOrderTraversal(root.right);
    //     System.out.println(root.val);
    // }

    //上浮 调整
    public static void upAdjust(int[] array) {
        int childIndex = array.length - 1;
        int parentIndex = (childIndex - 1) / 2;
        int temp = array[childIndex];
        while (childIndex > 0 && temp < array[parentIndex]) {
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    //下沉
    public static void downAdjust(int[] array, int parentIndex, int length) {
        int temp = array[parentIndex];
        int childIndex = 2 * parentIndex + 1;
        while (childIndex < length) {
            if (childIndex + 1 < length && array[childIndex + 1] < array[childIndex])
                childIndex++;
            if (temp <= array[childIndex])
                break;
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;

        }
        array[parentIndex] = temp;
    }

    public static void buildHeap(int[] array) {
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
             downAdjust(array, i, array.length);
        }
    }
}