package org.example.proyecto.PaneManager;
import javafx.scene.layout.Pane;
import java.util.List;

public class PaneManager {

    /**
     * This method will hide all panes in the list except for the pane to show.
     * @param panes List of all panes to manage.
     * @param paneToShow The pane that should be visible.
     */
    public static void showOnlyPane(List<Pane> panes, Pane paneToShow) {
        for (Pane pane : panes) {
            pane.setVisible(pane == paneToShow);
        }
    }
}

