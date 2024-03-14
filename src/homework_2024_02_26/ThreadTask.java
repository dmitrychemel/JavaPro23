package homework_2024_02_26;

public class ThreadTask {
    public static void main(String[] args) {
        sumThread();
    }

    public static void sumThread() {
        TreadFirst t1 = new TreadFirst();
        TreadSecond t2 = new TreadSecond();
        TreadThird t3 = new TreadThird();
        TreadFourth t4 = new TreadFourth();

        Thread T1 = new Thread(t1);
        Thread T2 = new Thread(t2);
        Thread T3 = new Thread(t3);
        Thread T4 = new Thread(t4);

        T1.start();
        T2.start();
        T3.start();
        T4.start();

        try {
            T1.join();
            T2.join();
            T3.join();
            T4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int result = t1.getSum() + t2.getSum() + t3.getSum() + t4.getSum();
        System.out.println("RESULT -> " + result);
    }
}



class TreadFirst implements Runnable {
    private int sum = 0;

    public int getSum() {
        return sum;
    }
    @Override
    public void run() {
        for (int i = 0; i < 25; i++) {
            sum += i;
        }
    }
}

class TreadSecond implements Runnable {

    private int sum = 0;

    public int getSum() {
        return sum;
    }

    @Override
    public void run() {
        for (int i = 25; i < 50; i++) {
            sum += i;
        }
    }
}

class TreadThird implements Runnable {
    private int sum = 0;

    public int getSum() {
        return sum;
    }
    @Override
    public void run() {
        for (int i = 50; i < 75; i++) {
            sum += i;
        }
    }
}

class TreadFourth implements Runnable {
    private int sum = 0;

    public int getSum() {
        return sum;
    }
    @Override
    public void run() {
        for (int i = 75; i <= 100; i++) {
            sum += i;
        }
    }
}
