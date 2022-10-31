
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

public class Kladd extends JFrame implements MouseListener, ActionListener {
    List<JLabel> labelList = new ArrayList<>();
    List<JLabel> correctList = new ArrayList<>();
    JPanel spelGrid = new JPanel();
    JButton nyttSpelKnapp = new JButton("Nytt spel!");
    JPanel panel = new JPanel();
    JPanel imagePanel = new JPanel();
    JLabel winnerMess = new JLabel(" ");
    ImageIcon backgroundImage;
    JLabel labelBackgroundImage;
    Border border = BorderFactory.createLineBorder(new Color(139, 84, 154, 147), 1);

    public Kladd() {
        nyttSpelKnapp.setBackground(new Color(0x79110226, true));
        nyttSpelKnapp.setForeground(new Color(0xCBCBE0));


        backgroundImage = new ImageIcon(this.getClass().getResource("pinkDroplet.jpg"));
        labelBackgroundImage = new JLabel(backgroundImage);
       // spelGrid.setLayout(new GridLayout(4, 4));



        spelGrid.add(labelBackgroundImage);
        labelBackgroundImage.setLayout(new GridLayout(4,4));
        labelBackgroundImage.setPreferredSize(new Dimension(330,330));


        for (int i = 0; i < 16; i++) {
            labelList.add(new JLabel(String.valueOf(i+1)));
         //   spelGrid.add(labelList.get(i));
            labelBackgroundImage.add(labelList.get(i));
            labelList.get(i).addMouseListener(this);
            correctList.add(labelList.get(i));


            labelList.get(i).setForeground(new Color(136, 61, 132, 163));
            labelList.get(i).setFont(new Font("Bold Serif", Font.BOLD, 16));
            labelList.get(i).setHorizontalAlignment(CENTER);
            labelList.get(i).setBorder(border);

        }
        labelList.get(labelList.size()-1).setText(" ");

        panel.setLayout(new BorderLayout());
        panel.add(nyttSpelKnapp, BorderLayout.NORTH);
        panel.add(spelGrid, BorderLayout.CENTER);
        panel.setBackground(new Color(0x794086));


        panel.add(winnerMess, BorderLayout.SOUTH);
        nyttSpelKnapp.addActionListener(this);



        add(panel);
     //   imagePanel.setLayout(new GridLayout(1,1));
        // ->> imagePanel.add(labelBackgroundImage);
       // labelBackgroundImage.setLayout(new GridLayout(1,1));
        //labelBackgroundImage.add(panel);
      //  labelBackgroundImage.add(panel);
        //  imagePanel.add(panel);
     //   add(labelBackgroundImage);

        panel.setPreferredSize(new Dimension(400, 370));
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
            SwitchPlaces sp = new SwitchPlaces(labelBackgroundImage, labelList, correctList, indexBlank, indexSiffra, winnerMess);
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
            labelBackgroundImage.removeAll();
            Collections.shuffle(labelList);
            for (JLabel jLabel : labelList) {
                labelBackgroundImage.add(jLabel);
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
