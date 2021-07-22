import controller.StartViewController;
import view.StartView;

public class Main {

    public static void main(String[] args) {
        StartView mainFrame = new StartView();
        StartViewController controller = new StartViewController(mainFrame);
        mainFrame.setVisible(true);
    }

}
