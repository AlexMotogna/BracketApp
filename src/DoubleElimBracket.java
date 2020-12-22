import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleElimBracket extends Bracket {

    List<Team> upperBracketTeams;
    List<Team> lowerBracketTeams;

    public DoubleElimBracket(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        upperBracketTeams = createTeams(numberOfTeams);
        lowerBracketTeams = new ArrayList<Team>();
        numberOfLayers = numberOfTeams;
    }

    public void computeMatchesAux(List<Team> winners) {
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
        computeMatchesAux(upperBracketTeams);
        computeMatchesAux(lowerBracketTeams);
    }

    @Override
    public void declareWinner(Match match, Team winner) {
        match.setWinner(winner);
        matchQueue.remove(match);
        playedMatches.add(match);

        if(upperBracketTeams.contains(match.getLoser())){
            lowerBracketTeams.add(match.getLoser());
            upperBracketTeams.remove(match.getLoser());
        } else {
            lowerBracketTeams.remove(match.getLoser());
        }

        match.getWinner().wonGame();
        match.getLoser().lostGame();
    }
}
