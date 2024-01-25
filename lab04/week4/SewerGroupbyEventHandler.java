package week4;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import week4.sewertools.SewerInfo;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Event Handler for View
 */
public class SewerGroupbyEventHandler implements EventHandler<MouseEvent> {

    private ComboBox groupSelect; //select box ref
    private SewerViewer sewerView; //the sewer view

    /**
     * Constructor
     *
     * @param view reference to SewerView
     */
    public SewerGroupbyEventHandler(SewerViewer view) {
        this.sewerView = view;
        this.groupSelect = view.getGroupSelect();
    }


    /**
     * Handle a mouse event (i.e. a button click)!  This routine will need to:
     * Update circle colors based on the combo-box selection by using each circle id which corresponds to the asset id
     * Finally **save the image of the anchor pane to a file** using SewerViewer.saveAnchorPaneImage(groupName)
     * Replace the groupName parameter with the name of the group that is selected in the combo box.
     *
     * @param mouseEvent the mouse event
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        String event = ((String) groupSelect.getValue());

        if(event == "No Group"){
            Stack<Circle> temp = new Stack<>();
            while (!sewerView.getUndoStack().isEmpty()){
                Circle circle = (Circle) sewerView.getUndoStack().pop();
                circle.setFill(Color.RED);
                temp.add(circle);
            }
            while (!temp.isEmpty()){
                sewerView.getUndoStack().add(temp.pop());
            }
        }

        else if (event == "Asset Type") {
            Map<Long, Color> asset = SewerInfo.groupByAssetType(sewerView.getSewers());
            Stack<Circle> temp = new Stack<>();
            while (!sewerView.getUndoStack().isEmpty()){
                Circle circle = (Circle) sewerView.getUndoStack().pop();
                String id = circle.getId();

                Color color = asset.get(Long.parseLong(circle.getId()));
                circle.setFill(color);
                temp.add(circle);
            }
            while (!temp.isEmpty()){
                sewerView.getUndoStack().add(temp.pop());
            }
        }
        else if (event == "Works Yard") {
            Map<Long, Color> work = SewerInfo.groupByWorksYard(sewerView.getSewers());
            Stack<Circle> temp = new Stack<>();
            while (!sewerView.getUndoStack().isEmpty()){
                Circle circle = (Circle) sewerView.getUndoStack().pop();
                String id = circle.getId();

                Color color = work.get(Long.parseLong(circle.getId()));
                circle.setFill(color);
                temp.add(circle);
            }
            while (!temp.isEmpty()){
                sewerView.getUndoStack().add(temp.pop());
            }
        }
        else if (event == "Ward") {
            Map<Long, Color> work = SewerInfo.groupByWard(sewerView.getSewers());
            Stack<Circle> temp = new Stack<>();
            while (!sewerView.getUndoStack().isEmpty()){
                Circle circle = (Circle) sewerView.getUndoStack().pop();
                String id = circle.getId();

                Color color = work.get(Long.parseLong(circle.getId()));
                circle.setFill(color);
                temp.add(circle);
            }
            while (!temp.isEmpty()){
                sewerView.getUndoStack().add(temp.pop());
            }
        }
        else if (event == "Install Date") {
            Map<Long, Color> work = SewerInfo.groupByInstallDateGroup(sewerView.getSewers());
            Stack<Circle> temp = new Stack<>();
            while (!sewerView.getUndoStack().isEmpty()){
                Circle circle = (Circle) sewerView.getUndoStack().pop();
                String id = circle.getId();

                Color color = work.get(Long.parseLong(circle.getId()));
                circle.setFill(color);
                temp.add(circle);
            }
            while (!temp.isEmpty()){
                sewerView.getUndoStack().add(temp.pop());
            }
        }
        // Save the image of the anchor pane
//        try {
//            sewerView.saveAnchorPaneImage(selectedGroup);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}