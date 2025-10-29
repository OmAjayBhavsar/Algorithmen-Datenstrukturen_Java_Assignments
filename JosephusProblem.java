import java.util.Queue;
import java.util.LinkedList;

public class JosephusProblem {
    public static Queue<String> solve(String[] persons, int k) {
        Queue<String> queue = new LinkedList<>();
        Queue<String> eliminationOrder = new LinkedList<>();

        for (String person : persons) {
            queue.offer(person);
        }

        while (queue.size() > 1) {
            for (int i = 1; i <= k; i++) {
                String eliminatedPerson = queue.poll();
                if (i != k) {
                    queue.offer(eliminatedPerson);
                } else {
                    eliminationOrder.offer(eliminatedPerson);
                }
            }
        }

        eliminationOrder.offer(queue.poll());
        return eliminationOrder;
    }

    public static void main(String[] args) {
        String[] persons = {"Jan", "Jil", "Ulf", "Kai", "Mark"};
        int k = 5;

        Queue<String> personsEliminationOrder = solve(persons, k);
        System.out.println("Elimination order:");
        while (!personsEliminationOrder.isEmpty()) {
            System.out.print(personsEliminationOrder.poll() + " ");
        }
    }
}
