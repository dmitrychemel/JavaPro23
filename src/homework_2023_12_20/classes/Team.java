package homework_2023_12_20.classes;

import com.github.javafaker.Faker;
import homework_2023_12_20.exception.ErrorMessage;
import homework_2023_12_20.exception.WrongClassCreateTeamException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Team<P extends Participant> {

    private Faker FAKER = new Faker();
    private String name;
    private double score;
    private int currentStreakWins;
    private int maxStreakWins;
    private List<P> participants = new ArrayList<>(100);

    public Team(String name) {
        this.name = name;
        score = 0;
    }

    public int getCurrentStreakWins() {
        return currentStreakWins;
    }

    public void setCurrentStreakWins(int currentStreakWins) {
        this.currentStreakWins = currentStreakWins;
    }

    public int getMaxStreakWins() {
        return maxStreakWins;
    }

    public void setMaxStreakWins(int maxStreakWins) {
        this.maxStreakWins = maxStreakWins;
    }

    public double getScore() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team<?> team = (Team<?>) o;
        return Objects.equals(name, team.name) && Objects.equals(participants, team.participants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, participants);
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
        Random random = new Random();
        int i = random.nextInt(3);

        if (i == 1) {
            this.score += 1;
            Handler.addHistoryMatch(this, teamPlayWith, 1);
            helperStreakWins(teamPlayWith, 1);
        } else if (i == 2) {
            this.score += 0.5;
            teamPlayWith.score += 0.5;
            Handler.addHistoryMatch(this, teamPlayWith, 0.5);
            helperStreakWins(teamPlayWith, 0.5);
        } else {
            teamPlayWith.score += 1;
            Handler.addHistoryMatch(this, teamPlayWith, 0);
            helperStreakWins(teamPlayWith, 0);
        }
    }

    private void helperStreakWins(Team<P> teamPlayWith, double result) {
        if (result == 1) {
            this.currentStreakWins++;
            if(this.currentStreakWins > maxStreakWins) {
                maxStreakWins = currentStreakWins;
            }
            teamPlayWith.setCurrentStreakWins(0);
        } else if (result == 0) {
            this.currentStreakWins = 0;
            teamPlayWith.setCurrentStreakWins(getCurrentStreakWins() + 1);
            if(teamPlayWith.getCurrentStreakWins() > teamPlayWith.getMaxStreakWins()) {
                teamPlayWith.setMaxStreakWins(teamPlayWith.getCurrentStreakWins());
            }
        } else {
            this.currentStreakWins = 0;
            teamPlayWith.setCurrentStreakWins(0);
        }
    }

    public<T extends Participant> void generateTeam(int countParticipant, Class<T> type) throws WrongClassCreateTeamException {


        if (Pupil.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++)
                this.addNewParticipant((P) new Pupil(FAKER.name().name(), FAKER.number().numberBetween(7, 13)));
        } else if (Teenager.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Teenager(FAKER.name().name(), FAKER.number().numberBetween(13, 19)));
            }
        } else if (Adult.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Adult(FAKER.name().name(), FAKER.number().numberBetween(19, 29)));
            }
        } else if (Child.class.isAssignableFrom(type)) {
            for (int i = 0; i < countParticipant; i++) {
                this.addNewParticipant((P) new Child(FAKER.name().name(), FAKER.number().numberBetween(0, 7)));
            }
        } else {
            throw new WrongClassCreateTeamException(ErrorMessage.WRONG_CLASS_CREATE_TEAM);
        }
    }
}