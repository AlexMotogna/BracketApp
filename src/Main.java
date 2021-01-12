import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int numberOfTeams = 0;
    static boolean done = false;
    static boolean pressed = false;
    static List<String> helper = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bracket App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel panel1 = new JPanel();

        SpinnerModel model = new SpinnerNumberModel(4, 4, 32, 1);
        JSpinner spinner = new JSpinner(model);
        panel1.add(spinner);

        JButton submitBtn = new JButton("Submit");

        JLabel l = new JLabel("Label1 ");
        panel1.add(l);
        panel1.add(submitBtn);

        JRadioButton singleButton = new JRadioButton("Single Elimination Bracket");
        singleButton.setSelected(true);
        JRadioButton doubleButton = new JRadioButton("Double Elimination Bracket");
        ButtonGroup group = new ButtonGroup();
        panel1.add(singleButton);
        panel1.add(doubleButton);
        group.add(singleButton);
        group.add(doubleButton);

        frame.setContentPane(panel1);
        frame.setVisible(true);

        submitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberOfTeams = (Integer) spinner.getValue();
                System.out.println(numberOfTeams);
                done = true;
            }
        });

        while (!done) {
        }

        //CREATE TEAMS

        Bracket bracket;
        if (doubleButton.isSelected()) {
            bracket = new DoubleElimBracket(numberOfTeams);
        } else {
            bracket = new SingleElimBracket(numberOfTeams);
        }

        JPanel teamNamePanel = new JPanel();

        JLabel teamNameLabel = new JLabel("Enter Team Name:");
        JTextField textField = new JTextField("Enter:");
        JButton teamNameButton = new JButton("Submit");
        teamNamePanel.add(teamNameLabel);
        teamNamePanel.add(textField);
        teamNamePanel.add(teamNameButton);
        List<Team> teams = bracket.getTeams();

        teamNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressed = true;
                helper.add(textField.getText());
                System.out.println(helper);
            }
        });

        frame.setContentPane(teamNamePanel);
        frame.setVisible(true);


        for (int i = 0; i < numberOfTeams; i++) {
            pressed = false;
            while (!pressed) {
            }
        }

        for (int i = 0; i < numberOfTeams; i++) {
            teams.get(i).setTeamName(helper.get(i));
        }

        //START TOURNAMENT

        bracket.computeMatches();
        List<Match> matches = bracket.getMatchesToBePlayed();

        int i = 1;
        while (!matches.isEmpty()) {

            JPanel mainPanel = new JPanel();
            JLabel l2 = new JLabel("Round " + i);
            mainPanel.add(l2, BorderLayout.PAGE_START);

            for (int j = 0; j < matches.size(); j++) {

                JPanel panel = new JPanel();

                JLabel l3 = new JLabel("Match " + j);
                panel.add(l3);

                JButton btn1 = new JButton("Team1");
                DeclareWinnerListener team1Listener = new DeclareWinnerListener(bracket, matches.get(j), matches.get(j).getTeam1(), panel);
                btn1.addActionListener(team1Listener);
                panel.add(btn1);

                JButton btn2 = new JButton("Team2");
                DeclareWinnerListener team2Listener = new DeclareWinnerListener(bracket, matches.get(j), matches.get(j).getTeam2(), panel);
                btn2.addActionListener(team2Listener);
                panel.add(btn2);

                mainPanel.add(panel, BorderLayout.CENTER);
                System.out.println(matches.get(j).toString());
            }

            frame.setContentPane(mainPanel);
            frame.setVisible(true);

            while (!matches.isEmpty()) {
            }

            bracket.computeMatches();
            matches = bracket.getMatchesToBePlayed();
            i++;

        }

        //FINISH TOURNAMENT

        List<Match> playedMatches = bracket.getPlayedMatches();
        System.out.println(playedMatches.get(playedMatches.size() - 1).toString());

        JPanel endPanel = new JPanel();
        JLabel winnerLabel = new JLabel("WINNER: " + playedMatches.get(playedMatches.size() - 1).getWinner().getTeamName());
        endPanel.add(winnerLabel);

        teams = bracket.getTeams();
        System.out.println(teams.size());
        for (int k = 0; k < teams.size(); k++) {
            JLabel teamLabel = new JLabel(teams.get(k).getTeamName() + ": " + teams.get(k).getMatchesWon());
            endPanel.add(teamLabel);
        }

        frame.setContentPane(endPanel);
        frame.setVisible(true);

        //frame.setVisible(false);
        //frame.dispose();
    }

}
