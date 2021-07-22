package controller;

import com.sun.media.sound.InvalidDataException;
import model.Bracket;
import view.TeamNameView;
import view.TournamentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeamNameController {

    private final TeamNameView view;
    private final Bracket bracket;
    private int teamIterator;

    public TeamNameController(TeamNameView view, Bracket bracket) {
        this.view = view;
        this.bracket = bracket;
        this.view.setSubmitNameButtonListener(new SubmitNameButtonListener());
        this.view.setLabelText(bracket.getTeams().get(0));
        teamIterator = 0;
    }

    public class SubmitNameButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                bracket.getTeams().get(teamIterator).setTeamName(view.getInsertedName());
                view.clearNameField();
                teamIterator++;

                if (teamIterator == bracket.getNumberOfTeams()) {
                    System.out.println(bracket.getTeams());

                    TournamentView tournamentView = new TournamentView();
                    TournamentController controller = new TournamentController(tournamentView, bracket);
                    tournamentView.setVisible(true);

                    view.setVisible(false);
                    view.dispose();
                } else {
                    view.setLabelText(bracket.getTeams().get(teamIterator));
                }
            } catch (InvalidDataException exception) {
                view.displayMessage(exception.getMessage());
            }
        }
    }

}
