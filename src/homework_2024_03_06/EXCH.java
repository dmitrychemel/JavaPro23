package homework_2024_03_06;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

public class EXCH {

    private static final Exchanger<Action> EXCHANGER = new Exchanger<>();
    private static final Faker FAKER = new Faker();

    private static final Random RANDOM = new Random();

    private static List<Action> getListActionOf10() {
        List<Action> actionList = new ArrayList<>();
        Action[] actions = Action.values();

        for (int i = 0; i < 10; i++) {
            actionList.add(actions[RANDOM.nextInt(actions.length)]);
        }
        return actionList;
    }

    public static void main(String[] args) {
        new Player(FAKER.funnyName().name(), EXCHANGER, getListActionOf10());
        new Player(FAKER.funnyName().name(), EXCHANGER, getListActionOf10());
    }
}

enum Action {
    SCISSORS,
    STONE,
    PAPER
}

class Player extends Thread {
    private String name;
    private Exchanger<Action> exchanger;
    private List<Action> actionList;

    public Player(String name, Exchanger<Action> exchanger, List<Action> actionList) {
        this.name = name;
        this.exchanger = exchanger;
        this.actionList = actionList;
        this.start();
    }

    private void getWinner(Action p1, Action p2) {
        if (p1 == Action.PAPER && p2 == Action.STONE ||
                p1 == Action.SCISSORS && p2 == Action.PAPER ||
                p1 == Action.STONE && p2 == Action.SCISSORS) {
            System.out.println("WINNER - " + name);
        }
    }

    @Override
    public void run() {
        Action get;
        for (Action action : actionList) {
            try {
                Thread.sleep(1111);
                get = exchanger.exchange(action);
                getWinner(action, get);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
