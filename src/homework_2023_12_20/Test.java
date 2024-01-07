package homework_2023_12_20;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        // Generate teams - Pupil, Teenager, Adult
        Tournament.teamsGenerate(25, 4, Pupil.class);
//        Tournament.teamsGenerate(2, 4, Teenager.class);
//        Tournament.teamsGenerate(2, 4, Adult.class);

        Tournament.makeTournament(Handler.getTeams(), Pupil.class);
//        Tournament.resultTournamentByGroups(Pupil.class);
//        Tournament.resultTournament();
//        Tournament.highScoringTeam();
//        Tournament.allScores();
//        Tournament.ListWithoutScore();
//        Tournament.averageAgeTeams();
        Team<Pupil> teamFirst = null;
        Team<Pupil> teamSecond = null;
        for (Team<? extends Participant> team1 : Handler.getTeams()) {
            if(teamFirst == null) {
                teamFirst = (Team<Pupil>) team1;
                continue;
            }
            if(teamSecond == null) {
                teamSecond = (Team<Pupil>) team1;
            }
        }
//        Tournament.findingWinnersOverTeam(team);
//        Tournament.findingByDiapasonAge(10, 15);
//        Tournament.sortParticipantByAge();
//        Tournament.findingAllTeamsWithTotalAge();
//        Tournament.teamScoreBeBetter();
//        Tournament.findingTeamsWithDraw(team);
//        Tournament.resultMatchesBetweenTeams(teamFirst, teamSecond);
//        Tournament.infoAboutTeams(teamFirst, teamSecond);
//        Tournament.teamsStreakWins();
        Tournament.teamsStreakDraws();

    }
}
