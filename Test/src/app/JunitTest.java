package app;

public class JunitTest {

    public void testSer() {
        Node node = new Node("1");
        node.setNext(new Node("2"));

        Node node2 = node.getNext();
        node2.setNext(new Node("3"));

        Node node3 = node2.getNext();

        Node insert1=new Node("insert1");
        node.setNext(insert1);
    }
}