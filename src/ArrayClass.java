import javax.swing.*;
import java.util.Arrays;


// Kolla så att värdet inte är 0
//  if (myMultiArray[row][column] != 0)

//         JButton[][] buttons = new JButton[rows][columns];
//Collections.shuffle JButtons(?) och sedan checka av att de är i ordning
//koppla JButtons till array

    public class ArrayClass extends JFrame {
        ArrayClass(){
            int rows = Integer.parseInt(JOptionPane.showInputDialog("Antal rader"));
            int columns = Integer.parseInt(JOptionPane.showInputDialog("Antal kolumner"));
            int[][] myMultiArray = new int[rows][columns];


            System.out.println(myMultiArray.length);

            int räknare = 0;
            for (int row = 0; row < myMultiArray.length; row++) {
                for (int column = 0; column < myMultiArray[row].length; column++) {
                    räknare++;

                    myMultiArray[row][column]=räknare;
                    if(column==myMultiArray[row].length-1 && row==myMultiArray.length-1){
                        myMultiArray[row][column]=0;
                    }
                    System.out.println(myMultiArray[row][column]);
                }
            }
            System.out.println("\nHur mönstret ser ut...\n" + Arrays.deepToString(myMultiArray));

            swapPlacesInArray(2, 2, myMultiArray);
        }

        public void swapPlacesInArray(int rowOfArray, int columnOfArray, int[][] myMultiArray){
            ArraySwap a = new ArraySwap();
            int[][] placementOfZero = new int[7][7];
            int rowi = 0;
            int columni = 0;
            for (int row = 0; row < myMultiArray.length; row++) {
                for (int column = 0; column < myMultiArray[row].length; column++) {

                    if(myMultiArray[row][column]==0){
                        placementOfZero[row][column]=myMultiArray[row][column];

                        System.out.println(placementOfZero[row][column] + " is of position row: " + row + " column: " + column);
                        rowi=row;
                        columni=column;
                        System.out.println("row " + rowi + " column " + columni);
                    }
                }
            }

            int[][] tempArrayFromPlacementOfZero = new int[rowi][columni];
            int[][] tempArrayFromInput = new int[rowOfArray][columnOfArray];

            int tempRow = rowi;
            int tempColumn = columni;


            // System.out.println("Plats 1: " + indexOfArraySpace(rowOfArray, twoDimensionArray) "\nPlats 2: " + indexOfArraySpace());
            System.out.println("Placement of zero, row: " + rowi + " column: " + columni);

            System.out.println("Placement of input, row: " + rowOfArray + " column: " + columnOfArray);
            System.out.println(rowi-1);


            if(rowOfArray==rowi+1 && columnOfArray==columni){//om talet är på raden nedanför
                rowi = rowOfArray;
                rowOfArray=tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                a.theArraySwap(myMultiArray[rowi][columni], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if(rowOfArray==rowi-1 && columnOfArray==columni){//raden ovanför
                rowi = rowOfArray;
                rowOfArray=tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;

                //sätt in dessa på nya platser i "nätet"...
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                a.theArraySwap(myMultiArray[rowi][columni], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if(rowOfArray==rowi && columnOfArray==columni+1){//kolumnen till höger
                rowi = rowOfArray;
                rowOfArray=tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);
                a.theArraySwap(myMultiArray[rowi][columni], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

            } else if(rowOfArray==rowi && columnOfArray==columni-1){//kolumnen till vänster
                rowi = rowOfArray;
                rowOfArray=tempRow;

                columni = columnOfArray;
                columnOfArray = tempColumn;
                System.out.println("New placement of zero, row: " + rowi + " column: " + columni + " \nNew placement of input,  row: " + rowOfArray + " column: " + columnOfArray);

                a.theArraySwap(myMultiArray[rowi][columni], rowOfArray, columnOfArray, rowi, columni, myMultiArray);

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

        }

        public static void main(String[] args) {
            ArrayClass at = new ArrayClass();
        }
    }

