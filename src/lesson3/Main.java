package lesson3;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> persons =new ArrayList<>();

        persons.add(new Person(11,"gas"));
        persons.add(new Person(12,"gas2"));
        persons.add(new Person(13,"gas3"));
        Assert.test(persons.size() ==4);
  //  persons.clear();
    //提醒jvm回收
    //    System.gc();
    }


    static void test(){
        //int 包装类 Integer
        //new向堆空间申请内存
        //所有类都继承object
        ArrayList<Person> persons =new ArrayList<>();
        ArrayList<Integer> list2 =new ArrayList<>();
        persons.add(new Person(11,"gas"));
        persons.add(new Person(12,"gas2"));
        persons.add(new Person(13,"gas3"));
        System.out.println(persons);

//        System.out.println(list.size());
//
//
//        for (int i = 0; i < 20; i++) {
//            list.add(i);
//        }
//
//        System.out.println(list);

        ;
        //   System.out.println(list);


    }
}
