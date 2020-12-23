package csNote.ST;

//有序符号表
public interface OrderedST<Key extends Comparable<Key>, Value> {

    int size();

    Value get(Key key);

    void put(Key key, Value value);

    Key min();

    Key max();

    int rank(Key key);

    List<Key> keys(Key l, Key h);
}