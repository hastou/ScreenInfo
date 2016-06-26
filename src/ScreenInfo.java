import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.Formatter;
import java.util.List;
import java.util.Locale;

/**
 * Created by Quentin on 26/06/2016.
 */
public class ScreenInfo extends Application {
    @Override
    public void start(Stage mainStage) {
        List<Screen> screenList = Screen.getScreens();
        String str = "";
        for (Screen screen : screenList) {
            str +=  print(screen);
        }
        VBox root = new VBox();

        Label parameters = new Label("Parameters");
        parameters.setText(str);

        root.getChildren().addAll(parameters);
        Scene scene = new Scene(root, 600,200);
        mainStage.setScene(scene);
        mainStage.setTitle("ScreenInfo");
        mainStage.show();
    }

    public String print(Screen s) {
        String str = "";
        str += "DPI: " + s.getDpi() + "\n";

        str += "Screen Bounds: ";
        Rectangle2D bounds = s.getBounds();
        str += print(bounds);

        str += "Screen Visual Bounds: ";
        Rectangle2D visualBounds = s.getVisualBounds();
        str += print(visualBounds);
        str += "-----------------------\n";
        return str;
    }

    public String print(Rectangle2D r) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.FRANCE);
        str += formatter.format("minX=%.2f, minY=%.2f, width=%.2f, height=%.2f\n",
                r.getMinX(), r.getMinY(), r.getWidth(), r.getHeight());
        return str;
    }
}
