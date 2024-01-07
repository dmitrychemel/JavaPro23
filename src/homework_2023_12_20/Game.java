package homework_2023_12_20;

import com.github.javafaker.Faker;

import java.util.*;


public class Game {
    private static final Faker FAKER = new Faker();

    public static <T extends Participant> void teamsGenerate(int countTeam, int countParticipant, Class<T> type) {

        for (int i = 0; i < countTeam; i++) {
            Team<T> team = new Team<>(FAKER.team().name());
            team.generateTeam(countParticipant, type);
            Handler.addTeam(team);
        }
    }

    public static <T extends Participant> void playTeams(Set<Team<T>> teams, Class<T> type) {
        List<Team<T>> teamArrayList = new ArrayList<>(teams);

        for (int i = 0; i < teamArrayList.size() - 1; i++) {
            for (int j = i + 1; j < teamArrayList.size(); j++) {
                teamArrayList.get(i).play(teamArrayList.get(j));
            }
        }

    }

    public static <T extends Participant> Map<Team<T>, Double> tableScoreTeams(HashSet<Team<T>> teams) {
        Map<Team<T>, Double> mapScore = new HashMap<>();

        for (Team<T> team : teams) {
            mapScore.put(team, team.getScore());
        }

        Map<Team<T>, Double> sorted = sortByValue(mapScore);
        HashSet<Team<T>> leaders = new HashSet<>();

        int countLeaders = 0;
        for (Team<T> entry : sorted.keySet()) {
            if (countLeaders < 5) {
                leaders.add(entry);
                countLeaders++;
            } else {
                break;
            }
        }

//        createLeadersBoard(leaders);

        for (Team<T> team : leaders) {
            sorted.put(team, team.getScore());
        }


        return sortByValue(sorted);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {

        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

//    public static <T extends Participant> void addTeamsToAllTeams(Map<Team<? extends Participant>, Double> allTeams, HashSet<Team<T>> teamsParticipant) {
//
//        for (Team<T> team : teamsParticipant) {
//            allTeams.put(team, team.getScore());
//        }
//    }
//
//    private static <T extends Participant> void createLeadersBoard(HashSet<Team<T>> teams) {
//
//        if (helperLeaderBoard(teams)) {
//            playTeams(teams);
//            createLeadersBoard(teams);
//        }
//    }
//
//    private static <T extends Participant> boolean helperLeaderBoard(HashSet<Team<T>> teams) {
//
//        List<Team<T>> sortedLeaders = new ArrayList<>(teams);
//        sortedLeaders.sort(new ScoreComparator<>());
//
//        for (int i = 0; i < sortedLeaders.size() - 3; i++) {
//            if (sortedLeaders.get(i).getScore() == sortedLeaders.get(i + 1).getScore()) {
//                return true;
//            }
//        }
//        return false;
//    }

    public static <T extends Participant> Team<? extends Participant> mainLeader(Map<Team<? extends Participant>, Double> allTeams) {
        Team<? extends Participant> leader = null;

        for (Team<? extends Participant> entry : allTeams.keySet()) {
            if (leader == null) {
                leader = entry;
            } else if (leader.getScore() < entry.getScore()) {
                leader = entry;
            }
        }

        return leader;
    }

    public static <T extends Participant> double allScoreTeams(Map<Team<? extends Participant>, Double> allTeams) {
        double allScore = 0;

        for (Double entry : allTeams.values()) {
            allScore += entry;
        }

        return allScore;
    }

    public static <T extends Participant> Set<Team<? extends Participant>> allTeamsWithoutScore(Map<Team<? extends Participant>, Double> allTeams) {

        Set<Team<? extends Participant>> teamsWithoutScore = new HashSet<>();

        for (Team<? extends Participant> team : allTeams.keySet()) {
            if (team.getScore() == 0) {
                teamsWithoutScore.add(team);
            }
        }

        return teamsWithoutScore;
    }

    public static <T extends Participant> Map<String, Double> averageAgeTeams(Map<Team<? extends Participant>, Double> allTeams) {
        Map<String, Double> averageAgeTeams = new HashMap<>();

        for (Team<? extends Participant> team : allTeams.keySet()) {
            averageAgeTeams.put(team.getName(), averageAge(team));
        }

        return averageAgeTeams;
    }

    private static <T extends Participant> double averageAge(Team<T> team) {
        double allAge = 0;

        for (T participant : team.getParticipants()) {
            allAge += participant.getAge();
        }

        return allAge / team.getParticipants().size();
    }

    public static <T extends Participant> List<Team<? extends Participant>> teamsHigherOfPoints(Map<Team<? extends Participant>, Double> allTeams) {
        double averageScore = averageScore(allTeams);
        List<Team<? extends Participant>> teamsAboveAverage = new ArrayList<>();

        for (Team<? extends Participant> team : allTeams.keySet()) {
            if (team.getScore() > averageScore) {
                teamsAboveAverage.add(team);
            }
        }

        return teamsAboveAverage;
    }

    private static <T extends Participant> double averageScore(Map<Team<? extends Participant>, Double> allTeams) {
        double averageScore = 0;

        for (Double score : allTeams.values()) {
            averageScore += score;
        }

        return averageScore / allTeams.size();
    }

    public static <T extends Participant> List<Team<T>> searchGroup(HashSet<Team<? extends Participant>> teams, Class<T> type) {
        List<Team<T>> teamsGroup = new ArrayList<>();

        for(Team<? extends Participant> team : teams) {
                if (team.getParticipants().get(0).getClass().isAssignableFrom(type)) {
                    teamsGroup.add((Team<T>) team);
                }
        }

        return teamsGroup;
    }
}