
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

public class Kladd extends JFrame implements ActionListener {
    List<JLabel> labelList = new ArrayList<>();
    List<JLabel> correctList = new ArrayList<>();
    JPanel spelGrid = new JPanel();
    JButton nyttSpelKnapp = new JButton("««★\uD83C\uDF1FNytt spel!\uD83C\uDF1F★✴»»");
    JPanel panel = new JPanel();
    JLabel winnerMess = new JLabel(" ");
    ImageIcon backgroundImage;
    JLabel labelBackgroundImage;
    Border border = BorderFactory.createLineBorder(new Color(139, 84, 154, 147), 1);

    public Kladd() {
        setTitle("Femtonspelet á rosa");

        nyttSpelKnapp.setBackground(new Color(0x794086));
        nyttSpelKnapp.setForeground(new Color(0xCBCBE0));
        nyttSpelKnapp.setPreferredSize(new Dimension(330,40));
        nyttSpelKnapp.setFont(new Font("Monospaced", Font.BOLD, 18));
        nyttSpelKnapp.setFocusPainted(false);

        backgroundImage = new ImageIcon(this.getClass().getResource("pinkDroplet.jpg"));
        labelBackgroundImage = new JLabel(backgroundImage);

        spelGrid.add(labelBackgroundImage);
        labelBackgroundImage.setLayout(new GridLayout(4,4));
        labelBackgroundImage.setPreferredSize(new Dimension(330,330));


        for (int i = 0; i < 16; i++) {
            labelList.add(new JLabel(String.valueOf(i+1)));
            labelBackgroundImage.add(labelList.get(i));
            labelList.get(i).addMouseListener(this);
            correctList.add(labelList.get(i));

            labelList.get(i).setForeground(new Color(136, 61, 132, 163));
            labelList.get(i).setFont(new Font("Bold Serif", Font.BOLD, 18));
            labelList.get(i).setHorizontalAlignment(CENTER);
            labelList.get(i).setBorder(border);

        }
        labelList.get(labelList.size()-1).setText(" ");

        panel.setLayout(new BorderLayout());
        panel.add(nyttSpelKnapp, BorderLayout.NORTH);
        panel.add(spelGrid, BorderLayout.CENTER);
        panel.setBackground(new Color(0x794086));

        panel.add(winnerMess, BorderLayout.SOUTH);
        winnerMess.setFont(new Font("Monospaced", Font.BOLD, 18));
        winnerMess.setForeground(new Color(0xFFFFFF));
      //  winnerMess.setBackground(new Color(0x402757));
        winnerMess.setHorizontalAlignment(CENTER);
        winnerMess.setPreferredSize(new Dimension(330, 40));
        nyttSpelKnapp.addActionListener(this);

        add(panel);
        panel.setPreferredSize(new Dimension(400, 420));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    MouseListener mouseClickListener = new MouseAdapter(){
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
    };
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
