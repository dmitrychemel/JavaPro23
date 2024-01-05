package homework_2023_12_20;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Handler {

    private static Set<Team<? extends Participant>> teams = new HashSet<>();
    private static Map<Team<? extends Participant>, Double> tableAllGroups = new LinkedHashMap<>();
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

}
