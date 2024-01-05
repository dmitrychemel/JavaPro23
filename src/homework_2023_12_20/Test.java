package homework_2023_12_20;

public class Test {
    public static void main(String[] args) {
        // Generate teams - Pupil, Teenager, Adult
        Tournament.teamsGenerate(5, 4, Pupil.class);
        Tournament.teamsGenerate(5, 4, Teenager.class);
        Tournament.teamsGenerate(5, 4, Adult.class);

        Tournament.makeTournament(Handler.getTeams());
//        Tournament.resultTournamentByGroups();
//        Tournament.resultTournament();
//        Tournament.highScoringTeam();
//        Tournament.allScores();
//        Tournament.ListWithoutScore();
        Tournament.averageAgeTeams();
    }
}
