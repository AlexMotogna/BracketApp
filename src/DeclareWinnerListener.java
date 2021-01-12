import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeclareWinnerListener implements ActionListener {

    Bracket bracket;
    Match match;
    Team team;
    JPanel panel;

    public DeclareWinnerListener(Bracket bracket, Match match, Team team, JPanel panel) {
        this.bracket = bracket;
        this.match = match;
        this.team = team;
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bracket.declareWinner(match, team);
        panel.hide();
        System.out.println(match.toString());
    }
}
