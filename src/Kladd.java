
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kladd extends JFrame implements MouseListener, ActionListener {
    List<JLabel> labelList = new ArrayList<>();
    List<JLabel> correctList = new ArrayList<>();
    JPanel spelGrid = new JPanel();
    JButton nyttSpelKnapp = new JButton("Nytt spel!");
    JPanel panel = new JPanel();
    JLabel winnerMess = new JLabel(" ");

    public Kladd() {
        spelGrid.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 16; i++) {
            labelList.add(new JLabel(String.valueOf(i+1)));
            spelGrid.add(labelList.get(i));
            labelList.get(i).addMouseListener(this);
            correctList.add(labelList.get(i));
        }
        labelList.get(labelList.size()-1).setText(" ");

        panel.setLayout(new BorderLayout());
        panel.add(nyttSpelKnapp, BorderLayout.NORTH);
        panel.add(spelGrid, BorderLayout.CENTER);

        panel.add(winnerMess, BorderLayout.SOUTH);
        nyttSpelKnapp.addActionListener(this);

        add(panel);
        spelGrid.setPreferredSize(new Dimension(70, 70));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int indexBlank = 0;
        int indexSiffra;
        if (e.getSource() instanceof JLabel) {
            indexSiffra = labelList.indexOf((JLabel) e.getSource());
            SwitchPlaces sp = new SwitchPlaces(spelGrid, labelList, correctList, indexBlank, indexSiffra, winnerMess);
            revalidate();
            repaint();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == nyttSpelKnapp) {
            spelGrid.removeAll();
            Collections.shuffle(labelList);
            for (JLabel jLabel : labelList) {
                spelGrid.add(jLabel);
            }
            winnerMess.setText(" ");
            revalidate();
            repaint();
        }
    }
    public static void main(String[] args) {
        new Kladd();
    }
}
