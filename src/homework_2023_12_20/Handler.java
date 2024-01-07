package homework_2023_12_20;

import java.util.*;

public class Handler {
    private static Set<Team<? extends Participant>> teams = new HashSet<>();
    private static Map<Team<? extends Participant>, Double> tableAllGroups = new LinkedHashMap<>();
    private static Map<Map<Team<? extends Participant>, Team<? extends Participant>>, List<Double>> historyMatches = new LinkedHashMap<>();

    public static Map<Map<Team<? extends Participant>, Team<? extends Participant>>, List<Double>> getHistoryMatches() {
        return historyMatches;
    }

    public static Set<Team<? extends Participant>> getTeams() {
        return teams;
    }

    public static <T extends Participant> void addTeam(Team<T> team) {
        teams.add(team);
    }

    public static void setTableAllGroups(Map<Team<? extends Participant>, Double> tableAllGroups) {
        Handler.tableAllGroups = tableAllGroups;
    }

    public static Map<Team<? extends Participant>, Double> getTableAllGroups() {
        return tableAllGroups;
    }

    public static <T extends Participant> void addTeamResult(Team<T> team) {
        tableAllGroups.put(team, team.getScore());
    }

    public static <T extends Participant> void addHistoryMatch(Team<T> first, Team<T> second, double score) {
        Map<Team<? extends Participant>, Team<? extends Participant>> innerMap = new LinkedHashMap<>();
        innerMap.put(first, second);

        historyMatches.computeIfAbsent(innerMap, k -> new ArrayList<>()).add(score);
    }

}
