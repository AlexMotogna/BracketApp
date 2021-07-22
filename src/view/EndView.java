package view;

import controller.EndController;
import model.Bracket;
import model.Match;
import model.Team;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EndView extends JFrame {

    JButton newTournamentButton;

    public EndView() {
        this.setTitle("Bracket App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
        newTournamentButton = new JButton("New Tournament");
    }

    public void setEndingPanelContent(Bracket bracket) {
        List<Match> playedMatches = bracket.getPlayedMatches();
        System.out.println(playedMatches.get(playedMatches.size() - 1).toString());

        JPanel endPanel = new JPanel();

        JLabel winnerLabel = new JLabel("WINNER: " + playedMatches.get(playedMatches.size() - 1).getWinner().getTeamName());
        endPanel.add(winnerLabel, BorderLayout.PAGE_START);

        List<Team> teams = bracket.getTeams();
        System.out.println(teams.size());
        for (Team team : teams) {
            JLabel teamLabel = new JLabel(team.getTeamName() + ": " + team.getMatchesWon() + " wins");
            endPanel.add(teamLabel);
        }

        endPanel.add(newTournamentButton);

        endPanel.setLayout(new BoxLayout(endPanel, BoxLayout.Y_AXIS));
        this.setContentPane(endPanel);
        this.setVisible(true);
    }

    public void setNewTournamentButtonListener(EndController.NewTournamentButtonListener listener) {
        newTournamentButton.addActionListener(listener);
    }


}
