package controller;

import model.Bracket;
import model.DoubleEliminationBracket;
import model.SingleEliminationBracket;
import view.StartView;
import view.TeamNameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartViewController {

    private final StartView view;

    public StartViewController(StartView view) {
        this.view = view;
        this.view.setStartButtonListener(new StartButtonListener());
    }

    public class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Bracket bracket;

            if (view.isSingleButtonSelected()) {
                bracket = new SingleEliminationBracket(view.getTeamCount());
            } else {
                bracket = new DoubleEliminationBracket(view.getTeamCount());
            }

            TeamNameView teamNameView = new TeamNameView();
            TeamNameController controller = new TeamNameController(teamNameView, bracket);
            teamNameView.setVisible(true);

            view.setVisible(false);
            view.dispose();
        }
    }

}
