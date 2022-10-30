

import java.util.Arrays;

public class ArraySwap {



    public int[][] theArraySwap(int chosenNumber, int rowForChosenNr, int columnForChosenNr, int rowForZero, int columnForZero, int[][] myMultiArray){
        myMultiArray[rowForChosenNr][columnForChosenNr]=chosenNumber;
        myMultiArray[rowForZero][columnForZero]=0;
        System.out.println(Arrays.deepToString(myMultiArray));
        return myMultiArray;
    }


}
