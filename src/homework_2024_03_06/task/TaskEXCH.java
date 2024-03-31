package homework_2024_03_06.task;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Exchanger;

import static homework_2024_03_06.task.TaskEXCH.*;


public class TaskEXCH {
    protected static final Exchanger<Action> EXCHANGER = new Exchanger<>();
    protected static final Faker FAKER = new Faker();
    protected static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Team team1 = new Team(FAKER.team().name());
        Team team2 = new Team(FAKER.team().name());

        team1.createTeam();
        team2.createTeam();

        System.out.println("TEAM " + team1.getName() + " | SCORE - " + team1.scoreTeam());
        System.out.println("TEAM " + team2.getName() + " | SCORE - " + team2.scoreTeam());

        team1.play(team2);

        System.out.println("TEAM " + team1.getName() + " | SCORE - " + team1.scoreTeam());
        System.out.println("TEAM " + team2.getName() + " | SCORE - " + team2.scoreTeam());
    }
}

@Getter
class Team {
    private String name;
    private List<Player> playerList;

    public Team(String name) {
        this.name = name;
        this.playerList = new ArrayList<>();
    }

    public void createTeam() {
        for (int i = 0; i < 3; i++) {
            playerList.add(new Player(FAKER.funnyName().name(), EXCHANGER, getListActionOf10()));
        }
    }

    private List<Action> getListActionOf10() {
        List<Action> actionList = new ArrayList<>();
        Action[] actions = Action.values();

        for (int i = 0; i < 3; i++) {
            actionList.add(actions[RANDOM.nextInt(actions.length)]);
        }
        return actionList;
    }

    public void play(Team opponent) {
        if (playerList.size() != opponent.getPlayerList().size()) {
            throw new IllegalArgumentException("Teams must have equal number of players to play.");
        }
        int numPlayers = Math.min(playerList.size(), opponent.getPlayerList().size());
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numPlayers; i++) {
            Player player1 = playerList.get(i);
            Player player2 = opponent.getPlayerList().get(i);
            Thread thread1 = new Thread(player1);
            Thread thread2 = new Thread(player2);
            thread1.start();
            thread2.start();
            threads.add(thread1);
            threads.add(thread2);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public double scoreTeam() {
        return playerList.stream()
                .mapToDouble(Player::getScore)
                .sum();
    }
}

class Player extends Thread {
    private String name;
    private Exchanger<Action> exchanger;
    private List<Action> actionList;
    @Getter
    private double score;

    public Player(String name, Exchanger<Action> exchanger, List<Action> actionList) {
        this.name = name;
        this.exchanger = exchanger;
        this.actionList = actionList;
        this.score = 0;
    }

    private void getWinner(Action p1, Action p2) {
        if (p1 == Action.PAPER && p2 == Action.STONE ||
                p1 == Action.SCISSORS && p2 == Action.PAPER ||
                p1 == Action.STONE && p2 == Action.SCISSORS) {
            System.out.println("WINNER - " + name);
            score++;
        } else if (p1 == Action.PAPER && p2 == Action.PAPER ||
                p1 == Action.SCISSORS && p2 == Action.SCISSORS ||
                p1 == Action.STONE && p2 == Action.STONE) {
            score += 0.5;
        }
    }

    @Override
    public void run() {
        Action get;
        for (Action action : actionList) {
            try {
                get = exchanger.exchange(action);
                getWinner(action, get);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

enum Action {
    SCISSORS,
    STONE,
    PAPER
}