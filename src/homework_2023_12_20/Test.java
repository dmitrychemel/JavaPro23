package homework_2023_12_20;

public class Test {
    public static void main(String[] args) {
        // Generate teams - Pupil, Teenager, Adult
        Tournament.teamsGenerate(25, 4, Pupil.class);
        Tournament.teamsGenerate(25, 4, Teenager.class);
        Tournament.teamsGenerate(25, 4, Adult.class);

        Tournament.makeTournament(Handler.getTeams());
//        Tournament.resultTournamentByGroups();
//        Tournament.resultTournament();
//        Tournament.highScoringTeam();
//        Tournament.allScores();
//        Tournament.ListWithoutScore();
//        Tournament.averageAgeTeams();
//        Team<? extends Participant> team = null;
//        for (Team<? extends Participant> team1 : Handler.getTeams()) {
//            team = team1;
//        }
//        Tournament.findingWinnersOverTeam(team);
//        Tournament.findingByDiapasonAge(10, 15);
//        Tournament.sortParticipantByAge();
        Tournament.findingAllTeamsWithTotalAge();
    }
}