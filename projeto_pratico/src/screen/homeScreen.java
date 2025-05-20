package screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class homeScreen {
    private javax.swing.JDesktopPane dskPainel;
    private JPanel panel1;
    private JButton manterAnimaisButton;
    private JButton manterPessoasButton;

    public homeScreen() {
        manterAnimaisButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animalScreen AnimalScreen = new animalScreen();

                AnimalScreen.show();
            }
        });
        manterPessoasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                peopleScreen PeopleScreen = new peopleScreen();

                PeopleScreen.show();
            }
        });
    }

    public void show() {
        JFrame frame = new JFrame("homeScreen");
        frame.setContentPane(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("homeScreen");
        frame.setContentPane(new homeScreen().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
