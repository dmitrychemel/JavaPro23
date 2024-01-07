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
        for (Team<? extends Participant> team : Handler.getTableAllGroups().keySet()) {
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
            if (team.getParticipants().get(0).getClass().isAssignableFrom(type)) {
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
            if (team == null) {
                team = team1;
            }
            if (team1.getScore() > team.getScore()) {
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
            if (team.getScore() == 0) {
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

    public static void teamHigherAverage() {
        System.out.println("Команды выше среднего результата - " + averageScoreTeams());
        for (Team<? extends Participant> team : Handler.getTeams()) {
            if (team.getScore() > averageScoreTeams()) {
                System.out.println("Название команды: " + team.getName() + " | Очки команды - " + team.getScore());
            }
        }
    }

    private static double averageScoreTeams() {
        double allScore = 0;
        for (Team<? extends Participant> team : Handler.getTeams()) {
            allScore += team.getScore();
        }

        return allScore / Handler.getTeams().size();
    }

    public static <T extends Participant> void searchByClass(Class<T> type) {
        for (Team<? extends Participant> team : Handler.getTeams()) {
            if (team.getParticipants().get(0).getClass().isAssignableFrom(type)) {
                System.out.println("Название команды - " + team.getName());
            }
        }
    }

    public static <T extends Participant> void findingWinnersOverTeam(Team<T> team) {
        for (Map.Entry<Map<Team<? extends Participant>, Team<? extends Participant>>, List<Double>> match : Handler.getHistoryMatches().entrySet()) {
            for (Map.Entry<Team<? extends Participant>, Team<? extends Participant>> players : match.getKey().entrySet()) {
                if (players.getKey().equals(team) || match.getValue().contains(0D)) {
                    for (Double score : match.getValue()) {
                        if (score == 0) {
                            System.out.println("Данная команда: " + players.getValue().getName() + " | Выграла - " + players.getKey().getName());
                        }
                    }
                }
                if (players.getValue().equals(team) || match.getValue().contains(1D)) {
                    for (Double score : match.getValue()) {
                        if (score == 1) {
                            System.out.println("Данная команда: " + players.getValue().getName() + " | Выграла - " + players.getKey().getName());
                        }
                    }
                }
            }
        }
    }

    public static void findingYoungestPlayer() {
        Participant youngestPlayer = null;

        for (Team<? extends Participant> team : Handler.getTeams()) {
            for (Participant participant : team.getParticipants()) {
                if (youngestPlayer == null || youngestPlayer.getAge() > participant.getAge()) {
                    youngestPlayer = participant;
                }
            }
        }

        System.out.println("Самы молодой игрок - " + youngestPlayer.getName());
    }

    public static <T extends Participant> void findingExperiencedTeam() {
        Team<T> experiencedTeam = null;
        int teamAge = 0;

        for (Team<? extends Participant> team : Handler.getTeams()) {
            int countAge = 0;
            for (Participant participant : team.getParticipants()) {
                countAge += participant.getAge();
            }
            if (experiencedTeam == null || teamAge < countAge) {
                experiencedTeam = (Team<T>) team;
                teamAge = countAge;
            }
        }

        System.out.println("Самая опытная команда: " + experiencedTeam.getName() + " | Суммарный возраст - " + teamAge);
    }

    public static void findingByDiapasonAge(int from, int to) {
        for (Team<? extends Participant> team : Handler.getTeams()) {
            if (checkDiapason(team, from, to)) {
                System.out.println("Название команды: " + team.getName());
                for (Participant participant : team.getParticipants()) {
                    System.out.println("Игрок: " + participant.getName() + " | Возраст " + participant.getAge());
                }
            }

        }
    }

    private static boolean checkDiapason(Team<? extends Participant> team, int from, int to) {
        for (Participant participant : team.getParticipants()) {
            if (participant.getAge() < from || participant.getAge() > to) {
                return false;
            }
        }

        return true;
    }

    public static void sortParticipantByAge() {
        ArrayList<Participant> sortByAge = new ArrayList<>();
        for (Team<? extends Participant> team : Handler.getTeams()) {
            for (Participant participant : team.getParticipants()) {
                sortByAge.add(participant);
            }
        }

        sortByAge.sort(Comparator.comparing(Participant::getAge, Comparator.reverseOrder()));
        for (Participant participant : sortByAge) {
            System.out.println("Имя: " + participant.getName() + " | Возраст - " + participant.getAge());
        }
    }

    public static <T extends Participant> void findingBiggestDiapasonByAge() {
        Team<T> team = null;
        int diapason = 0;

        for (Team<? extends Participant> team1 : Handler.getTeams()) {
            if (team == null) {
                team = (Team<T>) team1;
            }
            int ageMax = Integer.MIN_VALUE;
            int ageMin = Integer.MAX_VALUE;
            for (Participant participant : team1.getParticipants()) {
                if (participant.getAge() > ageMax) {
                    ageMax = participant.getAge();
                } else if (participant.getAge() < ageMin) {
                    ageMin = participant.getAge();
                }
            }
            if (diapason < ageMax - ageMin) {
                team = (Team<T>) team1;
                diapason = ageMax - ageMin;
            }
        }

        System.out.println("Самый большая разница в возрасте у команды: " + team.getName() + " | Разница - " + diapason);
    }

    public static void findingAllTeamsWithTotalAge() {
        List<Team<? extends Participant>> teamList = new ArrayList<>(Handler.getTeams());
        Iterator<Team<? extends Participant>> iterator = teamList.iterator();

        while (iterator.hasNext()) {
            Set<Team<? extends Participant>> teamsWithTotalAge = new HashSet<>();
            Team<? extends Participant> team = iterator
            teamsWithTotalAge.add(team);
            int totalAge = totalAgeTeam(team);
        }
        for (Team<? extends Participant> team : teamList) {
            Set<Team<? extends Participant>> teamsWithTotalAge = new HashSet<>();
            teamsWithTotalAge.add(team);
            int totalAge = totalAgeTeam(team);

            for (Team<? extends Participant> teamNext : teamList) {
                if(team.equals(teamNext)) {
                    continue;
                }
                if (totalAgeTeam(teamNext) == totalAge) {
                    teamsWithTotalAge.add(teamNext);
                }
            }
            if (teamsWithTotalAge.size() > 1) {
                teamList.removeAll(teamsWithTotalAge);
            } else {
                System.out.println("Суммарный возраст - " + totalAge);
                for (Team<? extends Participant> teamSet : teamList) {
                    System.out.println("Название команды: " + teamSet.getName() + " | Суммарный возраст - " + totalAge);
                }
                System.out.println();
                teamList.removeAll(teamsWithTotalAge);
            }
        }
    }

    private static int totalAgeTeam(Team<? extends Participant> team) {
        int totalAge = 0;
        for(Participant participant : team.getParticipants()) {
            totalAge += participant.getAge();
        }
        return totalAge;
    }
}
