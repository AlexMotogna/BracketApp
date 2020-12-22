import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleElimBracket extends Bracket {

    private List<Team> currentTeams;
    public int layer;

    public SingleElimBracket(int numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        currentTeams = super.createTeams(this.numberOfTeams);
        layer = 0;
        numberOfLayers = (int) Math.floor(Math.log(numberOfTeams)) + 1;
    }

    @Override
    public void computeMatches() {
        int remainingTeams = currentTeams.size();
        layer++;
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
        match.getLoser().lostGame();
        matchQueue.remove(match);
        playedMatches.add(match);
    }

    public List<Team> getLayerWinners(){
        return currentTeams;
    }
}
