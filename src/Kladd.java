
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kladd extends JFrame implements MouseListener, ActionListener {
    List<String> stringList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " ");
    int[] plats = new int[15];

    JLabel ett, två, tre, fyra, fem, sex, sju, åtta, nio, tio, elva, tolv, tretton, fjorton, femton, blank;
    List<JLabel> labelList = Arrays.asList(ett, två, tre, fyra, fem, sex, sju, åtta, nio, tio, elva, tolv,
            tretton, fjorton, femton, blank);
    JPanel spelGrid = new JPanel();
    JButton nyttSpelKnapp = new JButton("Nytt spel!");
    JPanel panel = new JPanel();
    JLabel winnerMess = new JLabel("Du vann!");//ändra till "" -> när allt är ordnat 1-15 ändrar man till "Du vann!" för winnerMess i lämplig actionListener

    public Kladd() {
        spelGrid.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < labelList.size(); i++) {
            labelList.set(i, new JLabel(stringList.get(i)));
            spelGrid.add(labelList.get(i));
            labelList.get(i).addMouseListener(this);
        }

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

            for (JLabel jl : labelList) {
                if (jl.getText().equals(" ")) {
                    indexBlank = labelList.indexOf(jl);
                }
            }
            int hej = 0;
            for (JLabel j : labelList) {
                plats[hej] = labelList.indexOf(j);
                System.out.println(j.getText() + " " + plats[hej]);

            }

                System.out.println("index " + indexBlank + " " + indexSiffra);


                int platsJLabel = 0;
                int platsBlank = 0;

                if (indexBlank % 4 == indexSiffra % 4 && Math.abs((indexBlank / 4) - (indexSiffra / 4)) == 1) {//den byter bara plats med 12:an
                    Collections.swap(labelList, indexSiffra, indexBlank);
                    //lägg i lista; se plats för 0, och om den man klickar på är inom plats +1, -1, +4 eller -4 kan man byta!
                    revalidate();
                    repaint();
                }

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
            for (int i = 0; i < labelList.size(); i++) {
               spelGrid.add(labelList.get(i));
            }
            revalidate();
            repaint();
        }
    }

    public static void main(String[] args) {
        new Kladd();
    }


}
