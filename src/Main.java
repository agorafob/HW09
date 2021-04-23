public class Main {

    public static void main(String[] args) {
        MyCollection col = new MyCollection();
        col.add("aaa");
        col.add("bbb");
        col.add("ccc");
        col.add("ddd");

        String[] str = {"ccc", "eee", "fff"};
        col.addAll(str);

        MyCollection test = new MyCollection();
        test.add("111");
        test.add("222");
        test.add("333");
        col.addAll(test);
        col.print();

        System.out.println("0 " + col.get(0));
        System.out.println("5 " + col.get(5));
        System.out.println("Size: " + col.size());
        System.out.println("If contains eee: " + col.contains("eee"));


        col.delete(1);
        col.print();
        col.delete("ccc");
        col.print();
        col.clear();
        col.print();
        col.add("aaa");
        col.add("bbb");
        col.add("ccc");
        col.print();
        System.out.println("0 " + col.get(0));
        System.out.println("2 " + col.get(2));

        MyCollection x1 = new MyCollection();
        x1.add("x");
        x1.add("yx");
        x1.add("z");
        MyCollection x2 = new MyCollection();
        x2.add("x");
        x2.add("yx");
        x2.add("z");
        boolean a = x1.compare(x2);
        System.out.println(a);
    }
}
