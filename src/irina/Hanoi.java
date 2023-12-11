package irina;

public class Hanoi {
    public static void main(String[] args) {
        int nDisks = 4;
        doTowers(nDisks, 'A', 'B', 'C');
    }
    public static void doTowers(int topN, char from, char inter, char to) {
        if (topN == 1) {
            System.out.println("Диск 1 от " + from + " до " + to);
        } else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Диск " + topN + " от " + from + " до " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }
}
