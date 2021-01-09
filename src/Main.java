import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int numberOfTeams = 0;
    static boolean done = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
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


        Bracket bracket = new DoubleElimBracket(numberOfTeams);
        System.out.println(bracket.numberOfLayers);
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
                DeclareWinnerListener team1Listener = new DeclareWinnerListener(bracket, matches.get(j), matches.get(j).getTeam1());
                btn1.addActionListener(team1Listener);
                panel.add(btn1);

                JButton btn2 = new JButton("Team2");
                DeclareWinnerListener team2Listener = new DeclareWinnerListener(bracket, matches.get(j), matches.get(j).getTeam2());
                btn2.addActionListener(team2Listener);
                panel.add(btn2);

                mainPanel.add(panel, BorderLayout.CENTER);
                System.out.println(matches.get(j).toString());
            }

            frame.setContentPane(mainPanel);
            frame.setVisible(true);

            while (!matches.isEmpty()) {
                //int matchNb = in.nextInt();
                // matches = bracket.getMatchesToBePlayed();
                // bracket.declareWinner(matches.get(matchNb), matches.get(matchNb).getTeam1());
            }


            bracket.computeMatches();
            matches = bracket.getMatchesToBePlayed();
            i++;
        }

        List<Match> playedMatches = bracket.getPlayedMatches();
        System.out.println(playedMatches.get(playedMatches.size() - 1).toString());
        frame.setVisible(false);
        frame.dispose();
    }

}
