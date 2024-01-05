package homework_2023_12_20;

import com.github.javafaker.Faker;

import java.util.*;

public class Tournament {
    private static final Faker FAKER = new Faker();

    public static <T extends Participant> void teamsGenerate(int countTeam, int countParticipant, Class<T> type) {

        for (int i = 0; i < countTeam; i++) {
            Team<T> team = new Team<>(FAKER.team().name());
            team.generateTeam(countParticipant, type);
            Handler.addTeam(team);
        }
    }
    public static void makeTournament(Set<Team<? extends Participant>> allTeams) {
        makeGroups(Handler.getTeams(), Pupil.class);
        makeGroups(Handler.getTeams(), Teenager.class);
        makeGroups(Handler.getTeams(), Adult.class);

        for (Team<? extends Participant> team : allTeams) {
            Handler.addTeamResult(team);
        }
    }
    public static void resultTournament() {
        sortedMap();
        for(Team<? extends Participant> team : Handler.getTableAllGroups().keySet()) {
            System.out.println("Название команды - " + team.getName() + " | Очки команды: " + team.getScore() + " | Группа: " + team.getParticipants().get(0).getClass().getSimpleName());
        }
    }
    public static void resultTournamentByGroups() {
        List<Team<Pupil>> groupPupil = resultGroup(Pupil.class);
        List<Team<Teenager>> groupTeenager = resultGroup(Teenager.class);
        List<Team<Adult>> groupAdult = resultGroup(Adult.class);

        groupPupil.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));
        groupTeenager.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));
        groupAdult.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));

        System.out.println("Результаты группы " + Pupil.class.getSimpleName() + ":");
        for (Team<Pupil> team : groupPupil) {
            System.out.println("Название команды - " + team.getName() + " | Очки команды: " + team.getScore());
        }

        System.out.println();
        System.out.println("Результаты группы " + Teenager.class.getSimpleName() + ":");
        for (Team<Teenager> team : groupTeenager) {
            System.out.println("Название команды - " + team.getName() + " | Очки команды: " + team.getScore());
        }

        System.out.println();
        System.out.println("Результаты группы " + Adult.class.getSimpleName() + ":");
        for (Team<Adult> team : groupAdult) {
            System.out.println("Название команды - " + team.getName() + " | Очки команды: " + team.getScore());
        }
    }
    private static <T extends Participant> List<Team<T>> resultGroup(Class<T> type) {
        List<Team<T>> group = new ArrayList<>();
        for (Team<? extends Participant> team : Handler.getTableAllGroups().keySet()) {
            if(team.getParticipants().get(0).getClass().isAssignableFrom(type)) {
                group.add((Team<T>) team);
            }
        }

        return group;
    }
    private static <T extends Participant> void makeGroups(Set<Team<? extends Participant>> allTeams, Class<T> type) {
        List<Team<T>> group = new ArrayList<>();

        for (Team<? extends Participant> team : allTeams) {
            if (team.getParticipants().get(0).getClass().isAssignableFrom(type)) {
                group.add((Team<T>) team);
            }
        }
        playGroup(group);
        checkGroup(group);
        group.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));
    }
    private static <T extends Participant> void checkGroup(List<Team<T>> group) {
        group.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));


        List<Team<T>> leaders = new ArrayList<>();


        if (group.get(0).getScore() == group.get(1).getScore() || group.get(1).getScore() == group.get(2).getScore()) {
            for (int i = 0; i < 5; i++) {
                leaders.add(group.get(i));
            }
        }

        checkLeaders(leaders);
    }
    private static <T extends Participant> void checkLeaders(List<Team<T>> leaders) {

        if (leaders.size() > 1 && helperChecked(leaders)) {
            playGroup(leaders);
            checkLeaders(leaders);
        }
    }
    private static <T extends Participant> boolean helperChecked(List<Team<T>> leaders) {
        leaders.sort(Comparator.comparing(Team::getScore, Comparator.reverseOrder()));
        if (leaders.size() == 2) {
            if (leaders.get(0).getScore() == leaders.get(1).getScore()) {
                return true;
            }
        }
        for (int i = 0; i < 2; i++) {
            if (leaders.get(i).getScore() == leaders.get(i + 1).getScore()) {
                return true;
            }
        }
        return false;
    }
    private static <T extends Participant> void playGroup(List<Team<T>> teams) {
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                teams.get(i).play(teams.get(j));
            }
        }
    }
    private static void sortedMap() {
        Map<Team<? extends Participant>, Double> sortedMap = new LinkedHashMap<>();

        List<Map.Entry<Team<? extends Participant>, Double>> sortedList = new ArrayList<>(Handler.getTableAllGroups().entrySet());
        sortedList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        for (Map.Entry<Team<? extends Participant>, Double> entry : sortedList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        Handler.setTableAllGroups(sortedMap);
    }
    public static void highScoringTeam() {
       Team<? extends Participant> team = null;

       for (Team<? extends Participant> team1 : Handler.getTableAllGroups().keySet()) {
           if(team == null) {
               team = team1;
           }
           if(team1.getScore() > team.getScore()) {
               team = team1;
           }
       }
        System.out.println("Команда с максимальным баллом:");
        System.out.println(team.getName() + " | Очки команды - " + team.getScore() + " | Группа: " + team.getParticipants().get(0).getClass().getSimpleName());
    }
    public static void allScores() {
        double allScores = 0;
        for (Team<? extends Participant> team : Handler.getTeams()) {
            allScores += team.getScore();
        }

        System.out.println("Общее количество баллов - " + allScores);
    }
    public static void ListWithoutScore() {
        System.out.println("Команды без баллов:");
        for (Team<? extends Participant> team : Handler.getTeams()) {
            if(team.getScore() == 0) {
                System.out.println(team.getName());
            }
        }
    }
    public static void averageAgeTeams() {
        for (Team<? extends Participant> team : Handler.getTeams()) {
            System.out.print("Название команды " + team.getName());
            double agesTeams = 0;
            for (Participant participant : team.getParticipants()) {
                agesTeams += participant.getAge();
            }
            System.out.println(" | Средний возраст команды - " + agesTeams / team.getParticipants().size());
        }
    }

}
