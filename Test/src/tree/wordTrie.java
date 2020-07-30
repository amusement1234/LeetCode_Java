package tree;

//字典树
public class wordTrie {
    public trieNode root = new trieNode();

    public void insert(String s) {
        trieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.child[c - 'a'] == null)
                cur.child[c - 'a'] = new trieNode();
            cur = cur.child[c - 'a'];
        }
        cur.isLeaf = true;
        cur.val = s;
    }
}