import aud.DList;

public class MyDList<T> extends DList<T> {

    public MyDList() {
        super();
    }

    public void append(MyDList<T> li) {

        MyDList<T> newList = new MyDList<>();
        int i = 0, j = 0;

        while (j < this.size()) {
            newList.push_front(this.at(j));
            j++;
        }
        int k = 0, l = 0;

        while (k < li.size()) {
            newList.push_front(li.at(k));
            k++;
        }
        this.clear();

        while (l < newList.size()) {
            this.push_front(newList.at(l));
            l++;
        }
        System.out.println(this);
    }
    public void addNode(int position, T value){
        MyDList <T> newList = new MyDList<>();
        
    }

    public void insert(int n, MyDList<T> li) {

        int k = 0, l = 0;
        MyDList<T> newList = new MyDList<>();

        for (int i = 0; i < this.size() + 1; i++) {
            if (i == n) {
                newList.append(li);
            } else {
                newList.push_back(this.at(l));
                l++;
            }
        }
        this.clear();
        while (k < newList.size()) {
            this.push_back(newList.at(k));
            k++;
        }
        System.out.println(this);
    }



    public static void main(String[] args) {
        MyDList<String> li = new MyDList<>();
        MyDList<String> li2 = new MyDList<>();
        li2.insert(0, "0");
        li2.insert(1, "1");
        li2.insert(2, "2");
        li2.insert(3, "3");
        li.insert(0, "100");
        li.insert(1, "200");
        li.insert(2, "300");

        li2.insert(3, li);
    }
}