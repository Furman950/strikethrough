package controller;

import javafx.scene.input.MouseEvent;
import model.UserData;
import model.WeightTracker;

import java.io.IOException;

public class WeightTrackerController {

    private String trackWeight;
    private StrikethroughMainController strikethrough = new StrikethroughMainController();
    private UserData userD = strikethrough.getUserD();

    public WeightTrackerController() throws IOException {
    }

    public void weightTracker(MouseEvent e)
    {
        WeightTracker tracked = new WeightTracker(Integer.parseInt(trackWeight));

        //userD.setWeights(tracked);
    }

}
