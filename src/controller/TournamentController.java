package controller;

import model.Bracket;
import view.EndView;
import view.TournamentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TournamentController {

    private final TournamentView view;
    private final Bracket bracket;

    public TournamentController(TournamentView view, Bracket bracket) {
        this.view = view;
        this.bracket = bracket;
        this.view.setNextRoundButtonListener(new NextRoundButtonListener());
        this.bracket.computeMatches();
        this.view.setMainPanelContent(bracket);
    }

    public class NextRoundButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (bracket.getMatchesToBePlayed().isEmpty()) {
                bracket.computeMatches();
                view.setMainPanelContent(bracket);

                if (bracket.getMatchesToBePlayed().isEmpty()) {
                    EndView endView = new EndView();
                    EndController controller = new EndController(endView, bracket);
                    endView.setVisible(true);

                    view.setVisible(false);
                    view.dispose();
                }
            } else {
                view.displayMessage("Round not ended!");
            }
        }
    }

}
