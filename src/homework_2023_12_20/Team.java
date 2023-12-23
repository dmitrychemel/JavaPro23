package homework_2023_12_20;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Team<P extends Participant> {

    private Faker FAKER = new Faker();
    private String name;
    private int score;
    private List<P> participants = new ArrayList<>(100);

    public Team(String name) {
        this.name = name;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<P> getParticipants() {
        return participants;
    }

    public void setParticipants(List<P> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Team{" +
                " name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }

    public void addNewParticipant(P newParticipant) {
        participants.add(newParticipant);
    }

    public void play(Team<P> teamPlayWith) {
        String winner;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 1) {
            winner = this.name;
            this.score++;
        } else {
            winner = teamPlayWith.name;
            teamPlayWith.score++;
        }


    }

    public void generateTeam(int countParticipant, Class<P> type) {
        if (Pupil.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Participant(FAKER.name().name(), FAKER.number().numberBetween(7, 13)));
            }
        }

        if (Teenager.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Participant(FAKER.name().name(), FAKER.number().numberBetween(13, 19)));
            }
        }

        if (Adult.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Participant(FAKER.name().name(), FAKER.number().numberBetween(19, 29)));
            }
        }
    }
}