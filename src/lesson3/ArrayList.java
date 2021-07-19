package lesson3;

public class ArrayList {
    /*
     * 元素数量*/
    private int size;
    /*
     * 所有的元素*/
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 2;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = new int[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    //清除元素
    public void clear() {
        size = 0;

    }

    //元素个数
    public int size() {
        return size;
    }

    //是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //是否包含某个元素
    public boolean contains(int element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //添加元素到尾部
    public void add(int element) {
        add(size,element);

    }

    //获取index位置的元素
    public int get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    //设置index位置的元素
    public int set(int index, int element) {
        rangeCheck(index);
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    //在index位置插入元素
    public void add(int index, int element) {
       rangeCheckforAdd(index);

    ensureCapacity(size+1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];

        }
        elements[index] = element;
        size++;
    }

    //删除index位置元素
    public int remove(int index) {
      rangeCheck(index);
        int old=elements[index];
        for (int i =index; i < size; i++) {
            elements[i]=elements[i+1];
        }
        size--;
        return old;
    }

    //查看元素索引
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == element) {
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }
    /*保证有容量*/
    private void ensureCapacity(int capacity){
    int oldCapacity=elements.length;
    if(oldCapacity>=capacity) {
        return;
    }
//右移1除以2
    int newCapacity=oldCapacity+(oldCapacity>>1);
    int[] newElements =new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i]=elements[i];
        }
        elements=newElements;
        System.out.println("扩容:"+oldCapacity+"_"+newCapacity);

    }
    private void outOfBounds(int index){
        throw new IndexOutOfBoundsException("Index" + index + ",Size" + size);
    }
    private void rangeCheck(int index){
        if (index < 0 || index >= size) {
            outOfBounds(index);
        }
    }
    private void rangeCheckforAdd(int index){
        if (index < 0 || index > size) {
            outOfBounds(index);
        }
    }

    @Override
    public String toString() {
        //size=3,[99,88,77]
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(",[");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(elements[i]);

//                     if(i!=size-1){
//              string.append(", ");
//            }
//             }


        }
        string.append("]");
        return string.toString();
    }
        //元素遍历
        public void print(){
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i] + " ");
            }
        }
    }
