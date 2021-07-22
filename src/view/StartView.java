package view;

import controller.StartViewController;

import javax.swing.*;

public class StartView extends JFrame {

    SpinnerModel model;
    JSpinner spinner;
    JButton submitBtn;
    JRadioButton singleButton;
    JRadioButton doubleButton;
    JLabel label;

    public StartView() {
        JPanel panel = new JPanel();

        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        model = new SpinnerNumberModel(4, 4, 32, 1);
        spinner = new JSpinner(model);
        submitBtn = new JButton("Submit");
        label = new JLabel("Number of Teams");
        singleButton = new JRadioButton("Single Elimination Bracket");
        singleButton.setSelected(true);
        doubleButton = new JRadioButton("Double Elimination Bracket");
        ButtonGroup group = new ButtonGroup();
        group.add(singleButton);
        group.add(doubleButton);

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label)
                                .addComponent(spinner)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(singleButton)
                                .addComponent(doubleButton)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(submitBtn)
                        )
        );

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(label)
                                .addComponent(singleButton)
                                .addComponent(submitBtn)
                        )
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(spinner)
                                .addComponent(doubleButton)
                        )
        );

        this.setContentPane(panel);
        this.setTitle("Bracket App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 600);
    }

    public void setStartButtonListener(StartViewController.StartButtonListener listener) {
        this.submitBtn.addActionListener(listener);
    }

    public int getTeamCount() {
        return (int) spinner.getValue();
    }

    public boolean isSingleButtonSelected() {
        return singleButton.isSelected();
    }
}
