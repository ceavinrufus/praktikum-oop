import java.util.HashMap;
import java.util.Map;

public class PageReplacementLRU {
    private final Integer maxPages;
    // Pair<processID, page>
    private Map<Pair<Integer, Integer>, Node> pages;
    private Node head;
    private Node tail;

    private class Node {
        Pair<Integer, Integer> pageID;
        Integer physicalAddr;
        Node prev;
        Node next;

        public Node(Pair<Integer, Integer> pageID, int physicalAddr) {
            this.pageID = pageID;
            this.physicalAddr = physicalAddr;
            this.prev = null;
            this.next = null;
        }
    }

    private void addNode(Node node) {
        node.prev = null;
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void removeNode(Node node) {
        if (node == head) {
            head = node.next;
        } else if (node == tail) {
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        node.prev = null;
        node.next = null;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    public PageReplacementLRU(Integer maxPages) {
        this.maxPages = maxPages;
        this.pages = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int accessPage(Pair<Integer, Integer> pageID) {
        Node node = pages.get(pageID);
        if (node == null) {
            System.out.println("page fault!");
            return -1;
        }
        moveToHead(node);
        return node.physicalAddr;
    }

    public void addPage(Pair<Integer, Integer> pageID, int physicalAddr) {
        Node node = pages.get(pageID);
        if (node == null) {
            node = new Node(pageID, physicalAddr);
            pages.put(pageID, node);
            addNode(node);
            if (pages.size() > maxPages) {
                pages.remove(tail.pageID);
                removeNode(tail);
            }
        } else {
            node.physicalAddr = physicalAddr;
            moveToHead(node);
        }
    }
}