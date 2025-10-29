import java.util.ArrayList;
import java.util.Random;

public class HashLinQuad {

    private int[] table_;
    private int capacity_;


    public HashLinQuad(int capacity) {
        this.capacity_ = capacity;
        table_ = new int[capacity];
    }


    public int addLin(int obj) {
        int collisionsLin = 0;
        if (table_[obj % capacity_] == 0) {
            table_[obj % capacity_] = obj;
        } else {
            int linCounter = 0;
            while (table_[((obj % capacity_) + linCounter) % capacity_] != 0) {
                linCounter++;
                collisionsLin++;
            }
            table_[((obj % capacity_) + linCounter) % capacity_] = obj;

        }
        return collisionsLin;
    }

    public int addQuad(int obj) {

        int collisionsQuad = 0;

        int quadCounter = 0;
        if (table_[obj % capacity_] == 0) {
            table_[obj % capacity_] = obj;
        } else {
            while (table_[Math.abs((obj % capacity_) + (quadCounter * quadCounter)) % capacity_] != 0) {
                ++collisionsQuad;
                ++quadCounter;
            }
            table_[Math.abs((obj % capacity_) + (quadCounter * quadCounter)) % capacity_] = obj;
        }
        return collisionsQuad;
    }


    public String toString() {

        return "";
    }


    public static void main(String[] args) {

        HashLinQuad obj = new HashLinQuad(1249);
        HashLinQuad obj2 = new HashLinQuad(1249);
        Random ran = new Random();
        ArrayList<Integer> storeLinCollisions = new ArrayList<>();
        ArrayList<Integer> storeQuadCollisions = new ArrayList<>();
        for (int i = 0; i < 1249; i++) {
            int x = ran.nextInt(1000);
            storeLinCollisions.add(obj.addLin(x));
            storeQuadCollisions.add(obj2.addQuad(x));
        }
        int linColSum = 0;
        int QuadColSum = 0;
        for (int i = 0; i < 1249; i++) {
            linColSum = linColSum + storeLinCollisions.get(i);
            QuadColSum = QuadColSum + storeQuadCollisions.get(i);
        }
        System.out.println("Total Numbers of collisions in Linear " + linColSum);
        System.out.println("Total Numbers of collisions in Quad " + QuadColSum);
    }
}