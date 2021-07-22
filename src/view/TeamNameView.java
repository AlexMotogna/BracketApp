package view;

import com.sun.media.sound.InvalidDataException;
import controller.TeamNameController;
import model.Team;

import javax.swing.*;

public class TeamNameView extends JFrame {

    JLabel label;
    JTextField nameField;
    JButton submitBtn;

    public TeamNameView() {
        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        label = new JLabel();
        nameField = new JTextField();
        submitBtn = new JButton("Submit");

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label)
                                .addComponent(nameField)
                                .addComponent(submitBtn)
                        )
        );

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(label)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(nameField)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(submitBtn)
                        )
        );

        this.setContentPane(panel);
        this.setTitle("Bracket App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
    }

    public void setSubmitNameButtonListener(TeamNameController.SubmitNameButtonListener listener) {
        this.submitBtn.addActionListener(listener);
    }

    public String getInsertedName() throws InvalidDataException {
        if (!nameField.getText().equals("")) {
            return nameField.getText();
        } else {
            throw new InvalidDataException("Name can't be empty");
        }
    }

    public void clearNameField() {
        nameField.setText("");
    }

    public void setLabelText(Team team) {
        label.setText("Insert " + team.getTeamName() + " name:");
    }

    public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }


}
