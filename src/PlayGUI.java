import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PlayGUI extends JFrame implements ActionListener, MouseListener{

        int rows = 4;
        int columns = 4;//här kan man senare lägga till egna värden från användaren
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " ");
        int[] arrayNumbers = {1, 2, 3, 4, 5, 6, 7, 8 , 9, 10, 11, 12, 13, 14, 15, 0};
        String[] arrayNumbersString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " "};

        JButton[][] buttons = new JButton[rows][columns];
        JButton button1 = new JButton("button1");
        JPanel spelGrid = new JPanel();
        JButton nyttSpelKnapp = new JButton("Nytt spel!");
        JPanel panel = new JPanel();

    int[][] myMultiArray = new int[rows][columns];
        JLabel winnerMess = new JLabel("Vinnare eller förlorare?");//ändra till "" -> när allt är ordnat 1-15 ändrar man till "Du vann!" för winnerMess i lämplig actionListener

        public PlayGUI() {
            spelGrid.setLayout(new GridLayout(4, 4));
            int räknare=0;
            String räknare2 = "1";

            for (int row = 0; row < buttons.length; row++) {//mindre än 4...
                for (int column = 0; column < buttons[row].length; column++) {//mindre än 4...
                    buttons[row][column]=new JButton(arrayNumbersString[räknare]);

             //       buttons[row][column]=new JButton(räknare2);
                    buttons[row][column].setBackground(new Color(180,123,123));
               //     System.out.println(buttons[row][column].getText());

                    spelGrid.add(buttons[row][column]);
                    buttons[row][column].addActionListener(this);

                    if(!(column==buttons[row].length-2 && row==buttons.length-1)){
                        System.out.println("column: " + column + " of row length: " + buttons[row].length + " row: "+ row + " buttons length: " + buttons.length);
                        buttons[row][column].setActionCommand(arrayNumbersString[räknare]);
                    }
                    räknare++;//eftersom vi tar från stringList, ordning från 1, slutar på 0
                }
            }

           /* for (int i = 0; i < buttons.length; i++) {
                spelGrid.add(buttons[i][j]);
                labelList.get(i).addMouseListener(this);
            }*/

            panel.setLayout(new BorderLayout());
            panel.add(nyttSpelKnapp, BorderLayout.NORTH);
            panel.add(spelGrid, BorderLayout.CENTER);

            panel.add(winnerMess, BorderLayout.SOUTH);
            nyttSpelKnapp.addActionListener(this);

            add(panel);
            spelGrid.setPreferredSize(new Dimension(400, 300));
            pack();
            setVisible(true);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        }


        @Override
        public void mouseClicked(MouseEvent e) {



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
            int[] tecken = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
            int t = 0;
            int räknare = 0;
            Random random = new Random();
            if (e.getSource() == nyttSpelKnapp) {
                // spelGrid.removeAll();
                for (int i = 0; i < buttons.length; i++) {//length blir 4 här, applicera dubbel loop med rows och columns
                    int swapSomeIndex = random.nextInt(buttons.length);//den kan ge samma värden för flera... ändra detta
                    int temp = tecken[swapSomeIndex];
                    tecken[swapSomeIndex] = tecken[i];
                    tecken[i] = temp;

                    System.out.println(tecken[i]);
                  /*  for (int row = 0; row < buttons.length; row++) {
                        for (int column = 0; column < buttons[row].length; column++) {
                            räknare++;

                            buttons[row][column]=räknare;
                            if(column==buttons[row].length-1 && row==buttons.length-1){
                                buttons[row][column]=0;
                            }
                            System.out.println(buttons[row][column]);
                        }
                    }*/
                }
          //      Collections.shuffle(buttons);
          //      for (int i = 0; i < labelList.size(); i++) {
            //        labelList.get(i).setText(stringList.get(i));
              //  }

                repaint();
            }
            /* else if (e.getSource() instanceof JButton) {
                ((JButton) (e.getSource())).setBackground(Color.blue);
                ArrayClass ac = new ArrayClass(4, 4);
           //     int tempJButtonClicked = Integer.parseInt((JButton) (e.getSource())).getText());
                //kommer på en int multiArray returnerad. koppla denna på något sätt.
            //    ac.swapPlacesInArray();

            }*/
           // ArrayClass ac = new ArrayClass(4, 4);
            JButtonArrayClass jbac = new JButtonArrayClass(4,4);
            String cmd = e.getActionCommand();
            if ( cmd == "1"){
                System.out.println("1");
            } else if ( cmd == "2"){
                System.out.println("2");
            } else if ( cmd == "3"){
                System.out.println("3");
            } else if ( cmd == "4"){
                System.out.println("4");
            } else if ( cmd == "5"){
                System.out.println("5");
            } else if ( cmd == "6"){
                System.out.println("6");
            } else if ( cmd == "7"){
                System.out.println("7");
            } else if ( cmd == "8"){
                System.out.println("8");
            } else if ( cmd == "9"){
                System.out.println("9");
            } else if ( cmd == "10"){
                System.out.println("10");
            } else if ( cmd == "11"){
                System.out.println("11");
            } else if ( cmd == "12"){
                System.out.println("Vald siffra: 12");
                buttons = jbac.returnJButtonArray("12", buttons);
            } else if ( cmd == "13"){
                System.out.println("Vald siffra 13\n");
                buttons = jbac.returnJButtonArray("13", buttons);
            } else if ( cmd == "14"){
                System.out.println("Vald siffra 14\n");
                buttons = jbac.returnJButtonArray("14", buttons);
            } else if ( cmd == "15"){
                System.out.println("Vald siffra 15\n");
                buttons = jbac.returnJButtonArray("15", buttons);
              /*  int rowOfButton = 0;
                int columnOfButton = 0;
                for (int row = 0; row < buttons.length; row++) {//mindre än 4...
                    for (int column = 0; column < buttons[row].length; column++) {//mindre än 4...
                        if(buttons[row][column].getText().equals("15")){
                            rowOfButton=row;
                            columnOfButton=column;
                            System.out.println("row of button: " + rowOfButton + " column of button: " + columnOfButton);

                            buttons = jbac.swapPlacesInArray(rowOfButton, columnOfButton, buttons);
                            for (int r = 0; r < buttons.length; r++) {//mindre än 4...
                                for (int c = 0; c < buttons[r].length; c++) {//mindre än 4...
                                    System.out.println(buttons[r][c].getText());
                                }
                            }
                          //  System.out.println(jbac.swapPlacesInArray(rowOfButton, columnOfButton, buttons));
                        }
                    }
                }*/
            }else {
                System.out.println("nope, can't switch nothing with nothing");//lägg till en nyttSpel-knapp också hehe
            }
            revalidate();
            repaint();
        }



        public static void main(String[] args) {
            new PlayGUI();
        }




}
