package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleEliminationBracket extends Bracket {

    private final List<Team> currentTeams = new ArrayList<>();

    public SingleEliminationBracket(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        currentTeams.addAll(super.createTeams(this.numberOfTeams));
    }

    @Override
    public void computeMatches() {
        int remainingTeams = currentTeams.size();
        Collections.shuffle(currentTeams);

        if (remainingTeams % 2 == 0) {
            for (int i = 0; i < remainingTeams; i += 2) {
                Match newMatch = new Match(currentTeams.get(i), currentTeams.get(i + 1));
                matchQueue.add(newMatch);
            }
        } else {
            for (int i = 0; i < remainingTeams - 1; i += 2) {
                Match newMatch = new Match(currentTeams.get(i), currentTeams.get(i + 1));
                matchQueue.add(newMatch);
            }
        }
    }

    @Override
    public void declareWinner(Match match, Team winner) {
        match.setWinner(winner);
        currentTeams.remove(match.getLoser());
        match.getWinner().wonGame();
        matchQueue.remove(match);
        playedMatches.add(match);
    }

}
