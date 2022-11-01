import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

public class Main extends JFrame implements ActionListener {
    List<JLabel> labelList = new ArrayList<>();
    List<JLabel> correctList = new ArrayList<>();
    JPanel gamePanel = new JPanel();
    JButton newGameButton = new JButton("««★\uD83C\uDF1FNytt spel!\uD83C\uDF1F★✴»»");
    JPanel basePanel = new JPanel();
    JLabel winnerMess = new JLabel(" ");
    JLabel labelBackgroundImage = new JLabel(new ImageIcon("src/pinkDroplet.jpg"));
    Border border = BorderFactory.createLineBorder(new Color(139, 84, 154, 147), 1);

    public Main() {
        setTitle("Femtonspelet á rosa");

        newGameButton.setBackground(new Color(0x794086));
        newGameButton.setForeground(new Color(0xCBCBE0));
        newGameButton.setPreferredSize(new Dimension(330, 40));
        newGameButton.setFont(new Font("Monospaced", Font.BOLD, 18));
        newGameButton.setFocusPainted(false);
        newGameButton.addActionListener(this);

        gamePanel.add(labelBackgroundImage);
        labelBackgroundImage.setLayout(new GridLayout(4, 4));
        labelBackgroundImage.setPreferredSize(new Dimension(330, 330));

        for (int i = 0; i < 16; i++) {
            labelList.add(new JLabel(String.valueOf(i + 1)));
            labelBackgroundImage.add(labelList.get(i));
            labelList.get(i).addMouseListener(mouseClickListener);
            correctList.add(labelList.get(i));

            labelList.get(i).setForeground(new Color(136, 61, 132, 163));
            labelList.get(i).setFont(new Font("Bold Serif", Font.BOLD, 18));
            labelList.get(i).setHorizontalAlignment(CENTER);
            labelList.get(i).setBorder(border);

        }
        labelList.get(labelList.size() - 1).setText(" ");

        basePanel.setLayout(new BorderLayout());
        basePanel.add(newGameButton, BorderLayout.NORTH);
        basePanel.add(gamePanel, BorderLayout.CENTER);
        basePanel.add(winnerMess, BorderLayout.SOUTH);
        basePanel.setBackground(new Color(0x794086));
        basePanel.setPreferredSize(new Dimension(400, 420));

        winnerMess.setFont(new Font("Monospaced", Font.BOLD, 18));
        winnerMess.setForeground(new Color(0xFFFFFF));
        //winnerMess.setBackground(new Color(0x402757));
        winnerMess.setHorizontalAlignment(CENTER);
        winnerMess.setPreferredSize(new Dimension(330, 40));

        add(basePanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    MouseListener mouseClickListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            int indexBlank = 0;
            int indexSiffra;

            if (labelList.contains((JLabel) e.getSource())) {
                indexSiffra = labelList.indexOf((JLabel) e.getSource());
                SwitchPlaces sp = new SwitchPlaces();
                sp.switchPlaces(labelBackgroundImage, labelList, correctList, indexBlank, indexSiffra, winnerMess);
                revalidate();
                repaint();
            }
        }
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGameButton) {
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
        new Main();
    }
}

