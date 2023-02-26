import java.util.Arrays;

public class MyCollection implements CustomCollection {

    private int size = 0;
    private Link first;
    private Link last;
/**
This is JavaDoc
 */
    @Override
    public boolean add(String str) {
        addLast(str);
        return true;
    }

    private void addLast(String str) {
        Link l = this.last;
        Link newEntry = new Link(l, str, null);
        this.last = newEntry;
        if (l == null) {
            this.first = newEntry;
            first.setIndex(size);
        } else {
            l.setNext(newEntry);
            l.setIndex(size);
            first.setIndex(0);
            last.setIndex(size);
        }
        size++;
    }

    /**
     * @param strArr "Array of strings"
     * @return boolean
     * @// TODO: 26.02.2023 read more
     */
    @Override
    public boolean addAll(String[] strArr) {
        if (strArr.length == 0) {
            System.out.println(" Array is empty");
        } else {
            for (String s : strArr) {
                add(s);
            }
        }
        return true;
    }

    @Override
    public boolean addAll(MyCollection strColl) {
        if (strColl.size == 0) {
            System.out.println(" Collection is empty");
            return false;
        } else {
            for (int i = 0; i < strColl.size; i++) {
                add(strColl.get(i));
            }
        }
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index == this.first.getIndex()) {
            this.first = this.first.getNext();
            newIndex();
        } else if (index == this.last.getIndex()) {
            this.last = this.last.getPrev();
            this.last.setNext(null);
            newIndex();
        } else {
            Link x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.getNext();
            }
            x.getPrev().setNext(x.getNext());
            x.getNext().setPrev(x.getPrev());
            newIndex();
        }
        size--;
        return true;
    }

    private void newIndex() {
        Link x = this.first;
        for (int i = 0; i < this.last.getIndex(); i++) {
            x.setIndex(i);
            x = x.getNext();
        }
    }

    @Override
    public boolean delete(String str) {
        if (contains(str)) {
            int index;
            Link x = this.first;
            for (int i = 0; i <= this.last.getIndex(); i++) {
                if (x.getData().equals(str)) {
                    index = x.getIndex();
                    delete(index);
                }
                x = x.getNext();
            }
        } else {
            System.out.println("No such data");
        }
        return true;
    }

    @Override
    public String get(int index) {
        Link x = this.first;
        for (int i = 0; i < index; i++) {
            x = x.getNext();
        }
        return x.getData();
    }

    @Override
    public boolean contains(String str) {
        Link x = this.first;
        boolean result = false;
        for (int i = 0; i < this.last.getIndex(); i++) {
            x = x.getNext();
            if (x.getData().equals(str)) {
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean clear() {
        this.first.setNext(this.last);
        this.last.setPrev(this.first);
        this.first = null;
        this.last = null;
        this.size = 0;
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean trim() {
        return true;
    }

    @Override
    public boolean compare(MyCollection coll) {
        int count = 0;
        if (coll.size != this.size) {
            return false;
        } else {
            Link x = this.first;
            for (int i = 0; i <= this.last.getIndex(); i++) {
                if (x.getData().equals(coll.get(i))) {
                    count++;
                    x = x.getNext();
                }
            }
        }
        return count == size;
    }

    public void print() {
        String[] collection = new String[size];
        Link x = this.first;
        while (x != null) {
            for (int i = 0; i <= this.last.getIndex(); i++) {
                collection[i] = x.getData();
                x = x.getNext();
            }
        }
        System.out.println(Arrays.toString(collection));
    }
}
