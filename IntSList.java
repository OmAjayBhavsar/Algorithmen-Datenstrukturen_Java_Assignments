import aud.SList;

import java.util.function.Predicate;


public class IntSList {
    SList<Integer> li;

    public IntSList() {
        li = new SList<>();
    }

    @Override
    public String toString() {
        return li.toString();
    }

    public void push_front(int obj) {
        li.push_front(obj);
    }


    public IntSList filter(Predicate<Integer> p) {
        IntSList finalList = new IntSList();
        for (int i = 0; i < li.size(); i++) {
            if (p.test(li.at(i))) {
                finalList.push_front(li.at(i));

            }
        }
        return finalList;
    }

    public static void main(String args[]) {
        IntSList l1 = new IntSList();
        int[] input = {85, 72, 93, 81, 74, 42};
        for (int a : input) {
            l1.push_front(a);
        }
        Predicate<Integer> pr1 = (x) -> {
            if (x % 2 == 0) {
                return true;
            } else
                return false;
        };
        Predicate<Integer> pr2 = (x) -> {
            if (x > 42) {
                return true;
            } else
                return false;
        };
        System.out.println(l1.filter(pr1));
        System.out.println(l1.filter(pr2));
    }

}
