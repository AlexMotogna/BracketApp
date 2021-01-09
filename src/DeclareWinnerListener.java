import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeclareWinnerListener implements ActionListener {

    Bracket bracket;
    Match match;
    Team team;

    public DeclareWinnerListener(Bracket bracket, Match match, Team team) {
        this.bracket = bracket;
        this.match = match;
        this.team = team;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bracket.declareWinner(match, team);
        System.out.println(match.toString());
    }
}
