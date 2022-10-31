import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwitchPlaces {
    private JPanel spelGrid = new JPanel();
    private List<JLabel> labelList;
    private List<JLabel> correctList;
    private int indexBlank;
    private int indexSiffra;
    private JLabel winnerMess;

    SwitchPlaces(JPanel spelGrid, List<JLabel> labelList, List<JLabel> correctList, int indexBlank, int indexSiffra, JLabel winnerMess){
        this.spelGrid=spelGrid;
        this.labelList=labelList;
        this.indexBlank=indexBlank;
        this.indexSiffra=indexSiffra;

        for (JLabel jl : labelList) {
            if (jl.getText().equals(" ")) {
                indexBlank = labelList.indexOf(jl);
            }
        }

        if (indexBlank % 4 == indexSiffra % 4 && Math.abs((indexBlank / 4) - (indexSiffra / 4)) == 1
                || Math.abs(indexBlank - indexSiffra) == 1 && !((indexSiffra % 4 == 0 && indexBlank % 4 == 3) ||
                (indexSiffra % 4 == 3 && indexBlank % 4 == 0))) {
            spelGrid.removeAll();
            Collections.swap(labelList, indexSiffra, indexBlank);
            for (JLabel jLabel : labelList) {
                spelGrid.add(jLabel);
            }
            if (labelList.equals(correctList))
                winnerMess.setText("Du vann!");
        }
    }
}
