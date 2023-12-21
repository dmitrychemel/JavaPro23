package homework_20_12_2023.ex;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        List<Team<Pupil>> teamPupil = teamsGenerate(25, 4, Pupil.class);
        int count = 1;
        for(Team<Pupil> team : teamPupil) {
            System.out.println("Team " + count + " - " + team);
            count++;
        }
    }

    public static<T extends Participant> List<Team<T>> teamsGenerate(int countTeam, int countParticipant, Class<T> type) {
        List<Team<T>> listTeam = new ArrayList<>();

        for (int i = 0; i < countTeam; i++) {
            Team<T> team = new Team<>(FAKER.team().name());
            team.generateTeam(countParticipant, type);
            listTeam.add(team);
        }

        return listTeam;
    }


}