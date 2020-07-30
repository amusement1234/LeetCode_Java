package tree;

//字典树结点
public class trieNode {
    public String val;
    public trieNode[] child = new trieNode[26];
    public boolean isLeaf = false;
}