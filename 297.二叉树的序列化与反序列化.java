import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/description/
 *
 * algorithms
 * Hard (46.50%)
 * Likes:    182
 * Dislikes: 0
 * Total Accepted:    22.6K
 * Total Submissions: 47.9K
 * Testcase Example:  '[1,2,3,null,null,4,5]'
 *
 * 
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 /
 * 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 
 * 示例: 
 * 
 * 你可以将以下二叉树：
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠    / \
 * ⁠   4   5
 * 
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode
 * 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return rserialize(root, "");

    // //方法一
    // if (root == null)
    //     return "";
    // Queue<TreeNode> queue = new LinkedList<>();
    // queue.offer(root);
    // List<Integer> list = new ArrayList<>();
    // while (!queue.isEmpty()) {
    //     int levelSize = queue.size();
    //     for (int i = 0; i < levelSize; i++) {
    //         TreeNode node = queue.poll();
    //         list.add(node != null ? node.val : null);

    //         if (node.left != null)
    //             queue.offer(node.left); 

    //         if (node.right != null)
    //             queue.offer(node.right); 

    //     }
    // }
    // return list.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    // String[] data_array = data.replace("[", "").replace("]", "").trim().split(",");
    // LinkedList<String> list = new LinkedList<String>(Arrays.asList(data_array));
    // return createBinaryTree(list);

    String[] data_array = data.split(",");
    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
    return rdeserialize(data_list);

  }

  public String rserialize(TreeNode root, String str) {
    // Recursive serialization.
    if (root == null) {
      str += "null,";
    } else {
      str += str.valueOf(root.val) + ",";
      str = rserialize(root.left, str);
      str = rserialize(root.right, str);
    }
    return str;
  }

  public TreeNode rdeserialize(List<String> list) {
    // Recursive deserialization.
    if (list.get(0).equals("null")) {
      list.remove(0);
      return null;
    }

    TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
    list.remove(0);
    root.left = rdeserialize(list);
    root.right = rdeserialize(list);

    return root;
  }

  public static TreeNode createBinaryTree(LinkedList<String> inputList) {
    if (inputList == null || inputList.isEmpty())
      return null;

    Integer data = Integer.valueOf(inputList.removeFirst().trim());
    if (data == null)
      return null;
    TreeNode node = new TreeNode(data);
    node.left = createBinaryTree(inputList);
    node.right = createBinaryTree(inputList);
    return node;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
// @lc code=end
