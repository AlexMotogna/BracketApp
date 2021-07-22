package controller;

import model.Bracket;
import view.EndView;
import view.StartView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndController {

    private final EndView view;

    public EndController(EndView view, Bracket bracket) {
        this.view = view;
        this.view.setEndingPanelContent(bracket);
        this.view.setNewTournamentButtonListener(new NewTournamentButtonListener());
    }

    public class NewTournamentButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StartView startView = new StartView();
            StartViewController controller = new StartViewController(startView);
            startView.setVisible(true);

            view.setVisible(false);
            view.dispose();
        }
    }


}
