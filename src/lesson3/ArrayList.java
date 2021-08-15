package lesson3;

import java.util.Objects;

public class ArrayList<E> {
    /*
     * 元素数量*/
    private int size;
    /*
     * 所有的元素*/
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 2;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        capacity = (capacity < DEFAULT_CAPACITY) ? DEFAULT_CAPACITY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    //清除元素
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i]=null;
        }
    size=0;
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
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //添加元素到尾部
    public void add(E element) {
        add(size,element);

    }

    //获取index位置的元素
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    //设置index位置的元素
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    //在index位置插入元素
    public void add(int index, E element) {
//        if(element==null) {
//            return;
//        }
       rangeCheckforAdd(index);

    ensureCapacity(size+1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];

        }
        elements[index] = element;
        size++;
    }

    //删除index位置元素
    public E remove(int index) {
      rangeCheck(index);
        E old=elements[index];
        for (int i =index+1; i < size; i++) {
            elements[i-1]=elements[i];
        }

        elements[--size]=null;
        return old;
    }
    public void remove(E element){
        remove(indexOf(element));
    }
    //查看元素索引
    public int indexOf(E element) {
        if(element == null){
            for (int i = 0; i < size; i++) {
                if (elements[i]==null) {
                    return i;
                }
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
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
    E[] newElements = (E[]) new Object[newCapacity];
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
