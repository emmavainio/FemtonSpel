import javax.swing.*;
import java.util.Arrays;


// Kolla så att värdet inte är 0
//  if (myMultiArray[row][column] != 0)

//         JButton[][] buttons = new JButton[rows][columns];
//Collections.shuffle JButtons(?) och sedan checka av att de är i ordning
//koppla JButtons till array

    public class JButtonArrayClass extends JFrame {
        int rows = 0;
        int columns = 0;
        String[] arrayNumbersString = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", " "};
        JButtonArrayClass(int rows, int columns){
            // int rows = Integer.parseInt(JOptionPane.showInputDialog("Antal rader"));
            //int columns = Integer.parseInt(JOptionPane.showInputDialog("Antal kolumner"));
            JButton[][] myMultiArray = new JButton[rows][columns];


            System.out.println(myMultiArray.length);

            int räknare = 0;
            for (int row = 0; row < myMultiArray.length; row++) {
                for (int column = 0; column < myMultiArray[row].length; column++) {

                    myMultiArray[row][column]=new JButton(arrayNumbersString[räknare]);
                    System.out.println(myMultiArray[row][column].getText());
                    räknare++;
                }
            }
           // System.out.println("\nHur mönstret ser ut...\n" + Arrays.deepToString(myMultiArray));

           // JButtonSwapPlacesInArray(2, 2, myMultiArray[rows][columns]);
        }
        public JButton[][] returnJButtonArray(String buttonNumber, JButton[][] buttons){
            int rowOfButton = 0;
            int columnOfButton = 0;
            for (int row = 0; row < buttons.length; row++) {//mindre än 4...
                for (int column = 0; column < buttons[row].length; column++) {//mindre än 4...
                    if(buttons[row][column].getText().equals(buttonNumber)){
                        rowOfButton=row;
                        columnOfButton=column;
                        System.out.println("row of button: " + rowOfButton + " column of button: " + columnOfButton);

                        buttons = swapPlacesInArray(rowOfButton, columnOfButton, buttons);
                        for (int r = 0; r < buttons.length; r++) {//mindre än 4...
                            for (int c = 0; c < buttons[r].length; c++) {//mindre än 4...
                                System.out.println(buttons[r][c].getText());
                            }
                        }
                    }
                }
            }
            return buttons;
        }

        public JButton[][] swapPlacesInArray(int rowOfArray, int columnOfArray, JButton[][] myMultiArray) {
            JButtonSwapPlacesInArray a = new JButtonSwapPlacesInArray();
            JButton[][] placementOfZero = new JButton[4][4];
            int rowi = 0;
            int columni = 0;
            System.out.println("\nNU KÖRS swapPlacesInArray \n");
            for (int row = 0; row < myMultiArray.length; row++) {
                for (int column = 0; column < myMultiArray[row].length; column++) {
                    System.out.println("hojhoj: " + myMultiArray[row][column].getText());

                    if (myMultiArray[row][column].getText().equals(" ")) {
                        placementOfZero[row][column] = myMultiArray[row][column];
                        System.out.println(placementOfZero[row][column].getText() + " is of position row: " + row + " column: " + column);
                        rowi = row;
                        columni = column;
                    }
                }
            }

            JButton[][] tempArrayFromPlacementOfZero = new JButton[rowi][columni];
            JButton[][] tempArrayFromInput = new JButton[rowOfArray][columnOfArray];

            int tempRow = rowi;
            int tempColumn = columni;

            System.out.println("Placement of zero, row: " + rowi + " column: " + columni);

            System.out.println("Placement of input, row: " + rowOfArray + " column: " + columnOfArray);


            if (rowOfArray == rowi + 1 && columnOfArray == columni) {//om talet är på raden nedanför
                System.out.println("\nHALLOJ, DU ÄR I ELSE NR 1");
                rowi = rowOfArray; //inputs föredetta plats
                rowOfArray = tempRow;//nollans föredetta plats

                columni = columnOfArray; //inputs föredetta plats
                columnOfArray = tempColumn;//nollans föredetta plats
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if (rowOfArray == rowi - 1 && columnOfArray == columni) {//raden ovanför
                System.out.println("\nHALLOJ, DU ÄR I ELSE NR 2");
                rowi = rowOfArray;
                rowOfArray = tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;

                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if (rowOfArray == rowi && columnOfArray == columni + 1) {//kolumnen till höger
                System.out.println("\nHALLOJ, DU ÄR I ELSE NR 3");
                rowi = rowOfArray;
                rowOfArray = tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
                return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if (rowOfArray == rowi && columnOfArray == columni - 1) {//kolumnen till vänster
                System.out.println("\nHALLOJ, DU ÄR I ELSE NR 4");
                rowi = rowOfArray;
                rowOfArray = tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                return a.theJButtonArraySwap(myMultiArray[rowi][columni], myMultiArray[rowOfArray][columnOfArray], rowOfArray, columnOfArray, rowi, columni, myMultiArray);
            }

            return myMultiArray;
        }

            //Kanske skicka in siffran 0 på plats rowi, columni, samt siffran x på plats rowOfArray, columnOfArray i en konstruktor till annan metod som har koll på allt?


            //Returna på något sätt de nya placeringarna och sätt in i arrayen...
            //om array-platsen som skickats in ligger bredvid 0, byt platser på dem! - det som skickas in är när man trycker på en JButton

            //LOKALISERA NOLLAN
            //LÄGG I TEMPORÄR ARRAY
            //JÄMFÖR MED DEN ARRAY-PLATS VI FÅR IN
            /*
             * Ex. vi får in row på 1 och column 2. Bara om siffran 0 finns på [0][2], [1][1], [1][3] eller [2][2] kan den bytas...
             *   1  2  3  4
             *   5  6  0  8
             *   9 11 10 12
             *   13 14 15 7
             *
             * Så om t.ex. [1][2] (vår noll-plats) minus ett steg i row-led == [0][2] (dvs. nummer 3 i detta fall) så kan de byta plats
             * Eller om [1][2] plus ett steg i column-led == [1][3] är samma som input... Så om något av följande stämmer kan de byta plats:
             * [i++][u]
             * [i--][u]
             * [i][u++]
             * [i][u--]
             * - annars händer inget, kanske vi blinkar JButton-knappen i rött eller dylikt
             *
             *
             *  */



        public static void main(String[] args) {
            JButtonArrayClass jbac = new JButtonArrayClass(4, 4);
        }
    }

