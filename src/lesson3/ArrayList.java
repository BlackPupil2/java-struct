package lesson3;

public class ArrayList {
    private int size;
    private int[] elements;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND=-1;
    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    //清除元素
    public void clear() {
        size=0;

    }

    //元素个数
    public int size() {
        return size;
    }

    //是否为空
    public boolean isEmpty() {
        return size==0;
    }

    //是否包含某个元素
    public boolean contains(int element) {
        return indexOf(element)!=ELEMENT_NOT_FOUND;
    }

    //添加元素到尾部
    public void add(int element) {
        elements[size]=element;
        size++;

    }

    //获取index位置的元素
    public int get(int index) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index"+index+",Size"+size);
        }
        return elements[index];
    }

    //设置index位置的元素
    public int set(int index, int element) {
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("Index"+index+",Size"+size);
        }
        int old=elements[index];
        elements[index]=element;
        return old;
    }

    //在index位置插入元素
    public void add(int index, int element) {

    }

    //删除index位置元素
    public int remove(int index) {
        return 0;
    }

    //查看元素索引
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if(elements[i]==element){
                return i;}
        }
        return ELEMENT_NOT_FOUND;
    }
}
