package homework_2023_12_20;

import java.util.Comparator;

public class ScoreComparator<T extends Participant> implements Comparator<Team<T>> {

    @Override
    public int compare(Team<T> o1, Team<T> o2) {
        return o1.getScore() - o2.getScore();
    }
}
