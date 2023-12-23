package homework_2023_12_20;

import com.github.javafaker.Faker;

import java.util.*;


public class Game {
    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {

        Map<Team<Participant>, Integer> allTeams = new HashMap<>();

        List<Team<Pupil>> teamsPupil = teamsGenerate(10, 4, Pupil.class);
        List<Team<Teenager>> teamsTeenager = teamsGenerate(2, 4, Teenager.class);
        List<Team<Adult>> teamsAdult = teamsGenerate(2, 4, Adult.class);

        playTeams(teamsPupil);
        playTeams(teamsTeenager);
        playTeams(teamsAdult);

        Map<String, Integer> mapScorePupil = tableScoreTeams(teamsPupil);
        Map<String, Integer> mapScoreTeenager = tableScoreTeams(teamsTeenager);
        Map<String, Integer> mapScoreAdult = tableScoreTeams(teamsAdult);

//        for (Map.Entry<String, Integer> entry : mapScorePupil.entrySet()) {
//            System.out.println("Название команды: " + entry.getKey() + " | Очки команды - " + entry.getValue());
//        }
//        System.out.println();
//        for (Map.Entry<String, Integer> entry : mapScoreTeenager.entrySet()) {
//            System.out.println("Название команды: " + entry.getKey() + " | Очки команды - " + entry.getValue());
//        }
//        System.out.println();
//        for (Map.Entry<String, Integer> entry : mapScoreAdult.entrySet()) {
//            System.out.println("Название команды: " + entry.getKey() + " | Очки команды - " + entry.getValue());
//        }

        addTeamsToAllTeams(allTeams, teamsPupil);
        addTeamsToAllTeams(allTeams, teamsTeenager);
        addTeamsToAllTeams(allTeams, teamsAdult);

        for (Map.Entry<Team<Participant>, Integer> team : allTeams.entrySet()) {
            System.out.println("Команда: " + team.getKey().getName() + " | Очки команды - " + team.getValue());
        }
    }

    public static <T extends Participant> List<Team<T>> teamsGenerate(int countTeam, int countParticipant, Class<T> type) {
        List<Team<T>> listTeam = new ArrayList<>();

        for (int i = 0; i < countTeam; i++) {
            Team<T> team = new Team<>(FAKER.team().name());
            team.generateTeam(countParticipant, type);
            listTeam.add(team);
        }

        return listTeam;
    }

    public static <T extends Participant> void playTeams(List<Team<T>> teams) {
        for (int i = 0; i < teams.size() - 1; i++) {
            for (int j = i + 1; j < teams.size(); j++) {
                teams.get(i).play(teams.get(j));
            }
        }
    }

    public static <T extends Participant> Map<String, Integer> tableScoreTeams(List<Team<T>> teams) {
        Map<String, Integer> mapScore = new HashMap<>();

        for (Team<T> team : teams) {
            mapScore.put(team.getName(), team.getScore());
        }

        Map<String, Integer> mapSorted = sortByValue(mapScore);


        return mapSorted;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        Map<K, V> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static<T extends Participant> void addTeamsToAllTeams(Map<Team<Participant>, Integer> allTeams, List<Team<T>> teamsParticipant) {
        for(Team<T> team : teamsParticipant) {
            allTeams.put((Team<Participant>) team, team.getScore());
        }
    }
}