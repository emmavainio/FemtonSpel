
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kladd extends JFrame implements MouseListener, ActionListener {
    JLabel ett, två, tre, fyra, fem, sex, sju, åtta, nio, tio, elva, tolv, tretton, fjorton, femton, blank;
    List<JLabel> labelList = Arrays.asList(ett, två, tre, fyra, fem, sex, sju, åtta, nio, tio, elva, tolv,
            tretton, fjorton, femton, blank);
    JPanel spelGrid = new JPanel();
    JButton nyttSpelKnapp = new JButton("Nytt spel!");
    JPanel panel = new JPanel();
    JLabel winnerMess = new JLabel(" ");

    public Kladd() {
        spelGrid.setLayout(new GridLayout(4, 4));

        for (int i = 0; i < labelList.size(); i++) {
            labelList.set(i, new JLabel(String.valueOf(i+1)));
            spelGrid.add(labelList.get(i));
            labelList.get(i).addMouseListener(this);
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

            for (JLabel jl : labelList) {
                if (jl.getText().equals(" ")) {
                    indexBlank = labelList.indexOf(jl);
                }
            }
            System.out.println("index " + indexBlank + " " + indexSiffra);

            if (indexBlank % 4 == indexSiffra % 4 && Math.abs((indexBlank / 4) - (indexSiffra / 4)) == 1
            || Math.abs(indexBlank - indexSiffra) == 1 && !((indexSiffra % 4 == 0 && indexBlank % 4 == 3) ||
                    (indexSiffra % 4 == 3 && indexBlank % 4 == 0))) {
                spelGrid.removeAll();
                Collections.swap(labelList, indexSiffra, indexBlank);
                for (JLabel jLabel : labelList) {
                    spelGrid.add(jLabel);
                }
                //lägg in att visa vinnarmeddelande när alla stämmer
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
            winnerMess.setText(" ");
            revalidate();
            repaint();
        }
    }

    public static void main(String[] args) {
        new Kladd();
    }


}
