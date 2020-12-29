package huihui;

import app.Node;

//单链表
public class MyLinkedList {

    private Node head;
    private Node last;
    private int size;

    public void insert(int data, int index) throws Exception {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出范围");
        Node thisNode = new Node(data);
        if (size == 0) {
            head = thisNode;
            last = thisNode;
        } else if (index == 0) {
            thisNode.next = head;
            head = thisNode;
        } else if (size == index) {
            last.next = thisNode;
            last = thisNode;
        } else {
            Node prev = get(index - 1);
            thisNode.next = prev.next;
            prev.next = thisNode;
        }
        size++;
    }

    public Node remove(int index) throws Exception {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出范围");
        Node removeNode = null;
        if (index == 0) {
            removeNode = head;
            head = head.next;

        } else if (index == size) {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            Node prevNode = get(index - 1);
            removeNode = prevNode.next;
            prevNode.next = prevNode.next.next;
        }
        size--;
        return removeNode;
    }

    public Node get(int index) throws Exception {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("超出范围");
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void oupPut() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
