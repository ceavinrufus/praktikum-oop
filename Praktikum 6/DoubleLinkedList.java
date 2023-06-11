/**
 * LinkedList.java
 * [Jelaskan kegunaan class ini]
 * 
 * @author 18221162 Ceavin Rufus De Prayer Purba
 */

public class DoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Konstruktor
     * buat Double linked list dengan size = 0 dan head = tail = null
     */
    public DoubleLinkedList() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Cari elemen yang terletak pada posisi position
     * 
     * @param position
     * @return elemen pada posisi position jika ada, null jika tidak ada
     */
    public Node<T> getNode(int position) {
        int i = 0;
        Node<T> loc = this.head;
        while ((loc != null) && (i < position)) {
            loc = loc.getNext();
            i++;
        }
        return loc;
    }

    /**
     * Tambah elemen dengan nilai item dengan menambahkan
     * node sebagai elemen paling belakang
     * 
     * @param item
     */
    public void add(T item) {
        Node<T> loc = new Node<T>(item, this.tail, null);
        if (this.size == 0) {
            this.head = loc;
        } else {
            this.tail.setNext(loc);
        }
        this.tail = loc;
        size++;
    }

    /**
     * Cari nilai elemen pada posisi position
     * 
     * @param position
     * @return nilai elemen pada posisi position jika ada, null jika tidak ada
     */
    public T get(int position) {
        int i = 0;
        Node<T> loc = this.head;
        T value = null;

        while ((loc != null) && (i < position)) {
            loc = loc.getNext();
            i++;
        }

        if (loc != null) {
            value = loc.getValue();
        }

        return value;
    }

    /**
     * Ubah nilai elemen pada posisi position menjadi nilai item jika ada
     * 
     * @param position
     * @param item
     */
    public void set(int position, T item) {
        int i = 0;
        Node<T> loc = this.head;

        while ((loc != null) && (i < position)) {
            loc = loc.getNext();
            i++;
        }
        if (loc != null) {
            loc.setValue(item);
        }
    }

    /**
     * Hapus elemen pada posisi position jika ada
     * 
     * @param position
     */
    public void remove(int position) {
        int i = 0;
        Node<T> loc = this.head;
        Node<T> prev = null;
        if (position < getSize()) {
            while ((loc != null) && (i < position)) {
                prev = loc;
                loc = loc.getNext();
                i++;
            }
            if ((loc.getNext() != null) && prev != null) {
                prev.setNext(loc.getNext());
                (loc.getNext()).setPrev(prev);
            }
            if (loc.getPrev() == null) {
                this.head = loc.getNext();
                if (this.head != null) {
                    (this.head).setPrev(null);
                }
            }
            if (loc.getNext() == null) {
                this.tail = loc.getPrev();
                if (this.tail != null) {
                    (this.tail).setNext(null);
                }
            }
            loc.setNext(null);
            loc.setPrev(null);
            this.size--;
        }
    }

    /**
     * Hapus semua elemen dari Double Linked List
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Getter size
     * 
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * Menampilkan keseluruhan isi Double Linked List
     * Format yang dikeluarkan adalah sebagai berikut, misal isi list adalah
     * [1,2,3,4]
     * Maka output yang dihasilkan adalah (dengan enter) :
     * 1 2 3 4
     */
    public void display() {
        Node<T> curr = this.head;
        while ((curr != null)) {
            System.out.print(curr.getValue());
            if (curr.getNext() != null) {
                System.out.print(" ");
            }
            curr = curr.getNext();
        }
        System.out.println("");
    }

    /**
     * Find element position
     * jika terdapat lebih dari 1 elemen dengan nilai yang sama, maka ambil posisi
     * yang ditemukan pertama kali dari head
     * Jika posisi elemen tidak ditemukan maka return -1
     * 
     * @return posisi dari sebuah item mulai dari head dengan zero indexing
     */
    public Integer find(T item) {
        Node<T> curr = head;
        int idx = 0;
        while (curr != null) {
            if (curr.getValue().equals(item))
                return idx;
            else {
                curr = curr.getNext();
                idx++;
            }
        }
        return -1;
    }
}
