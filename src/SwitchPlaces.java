import javax.swing.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SwitchPlaces {

    SwitchPlaces(JLabel backgroundPanel, List<JLabel> labelList, List<JLabel> correctList, int indexBlank, int indexSiffra, JLabel winnerMess){//JPanel spelGrid,
        for (JLabel jl : labelList) {
            if (jl.getText().equals(" ")) {
                indexBlank = labelList.indexOf(jl);
            }
        }

        if (indexBlank % 4 == indexSiffra % 4 && Math.abs((indexBlank / 4) - (indexSiffra / 4)) == 1
                || Math.abs(indexBlank - indexSiffra) == 1 && !((indexSiffra % 4 == 0 && indexBlank % 4 == 3) ||
                (indexSiffra % 4 == 3 && indexBlank % 4 == 0))) {
            //spelGrid.removeAll();
            backgroundPanel.removeAll();
            Collections.swap(labelList, indexSiffra, indexBlank);
            for (JLabel jLabel : labelList) {
                //spelGrid.add(jLabel);
                backgroundPanel.add(jLabel);
            }
            if (labelList.equals(correctList))
                winnerMess.setText("\uD83D\uDD25DU VANN‼\uD83D\uDD25");
        }
    }
}
