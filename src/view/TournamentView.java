package view;

import controller.DeclareWinnerListener;
import controller.TournamentController;
import model.Bracket;
import model.Match;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TournamentView extends JFrame {

    JPanel mainPanel;
    JButton nextRoundButton;

    public TournamentView() {
        this.setTitle("Bracket App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        nextRoundButton = new JButton("Next Round");
    }

    public void setMainPanelContent(Bracket bracket) {
        mainPanel = new JPanel();
        JLabel l2 = new JLabel("Round -------");
        mainPanel.add(l2, BorderLayout.PAGE_START);
        List<Match> matches = bracket.getMatchesToBePlayed();

        for (Match match : matches) {
            JPanel panel = new JPanel();

            JLabel l3 = new JLabel(match.toString());
            panel.add(l3);

            JButton btn1 = new JButton(match.getTeam1().getTeamName());
            DeclareWinnerListener team1Listener = new DeclareWinnerListener(bracket, match, match.getTeam1(), panel);
            btn1.addActionListener(team1Listener);
            panel.add(btn1);

            JButton btn2 = new JButton(match.getTeam2().getTeamName());
            DeclareWinnerListener team2Listener = new DeclareWinnerListener(bracket, match, match.getTeam2(), panel);
            btn2.addActionListener(team2Listener);
            panel.add(btn2);

            mainPanel.add(panel);
            System.out.println(match.toString());
        }

        mainPanel.add(nextRoundButton);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public void setNextRoundButtonListener(TournamentController.NextRoundButtonListener listener) {
        nextRoundButton.addActionListener(listener);
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

}
