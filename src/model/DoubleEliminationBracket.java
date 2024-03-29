package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleEliminationBracket extends Bracket {

    List<Team> upperBracketTeams = new ArrayList<>();
    List<Team> lowerBracketTeams = new ArrayList<>();

    public DoubleEliminationBracket(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        upperBracketTeams.addAll(createTeams(numberOfTeams));
    }

    private void computeMatchQueue(List<Team> winners) {
        int remainingTeams = winners.size();
        Collections.shuffle(winners);

        if (remainingTeams % 2 == 0) {
            for (int i = 0; i < remainingTeams; i += 2) {
                Match newMatch = new Match(winners.get(i), winners.get(i + 1));
                matchQueue.add(newMatch);
            }
        } else {
            for (int i = 0; i < remainingTeams - 1; i += 2) {
                Match newMatch = new Match(winners.get(i), winners.get(i + 1));
                matchQueue.add(newMatch);
            }
        }
    }

    @Override
    public void computeMatches() {
        for (Team upperBracketTeam : upperBracketTeams) {
            System.out.print(upperBracketTeam.getTeamName());
        }
        System.out.println();
        for (Team lowerBracketTeam : lowerBracketTeams) {
            System.out.print(lowerBracketTeam.getTeamName());
        }
        System.out.println();

        if (upperBracketTeams.size() == 1 && lowerBracketTeams.size() == 1) {
            Match newMatch = new Match(upperBracketTeams.get(0), lowerBracketTeams.get(0));
            matchQueue.add(newMatch);
        } else {
            computeMatchQueue(upperBracketTeams);
            computeMatchQueue(lowerBracketTeams);
        }
    }

    @Override
    public void declareWinner(Match match, Team winner) {
        match.setWinner(winner);
        matchQueue.remove(match);
        playedMatches.add(match);

        if (upperBracketTeams.contains(match.getLoser())) {
            lowerBracketTeams.add(match.getLoser());
            upperBracketTeams.remove(match.getLoser());
        } else {
            lowerBracketTeams.remove(match.getLoser());
        }

        match.getWinner().wonGame();
    }
}
