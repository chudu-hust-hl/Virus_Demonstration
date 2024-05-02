package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VirusStructureDisplay extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(400, 400);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawVirusStructure(gc);

        root.setCenter(canvas);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Virus Structure Display");
        primaryStage.show();
    }

    private void drawVirusStructure(GraphicsContext gc) {
        // Draw virus components
        gc.setFill(Color.RED);
        gc.fillOval(150, 100, 100, 100); // Virus capsid
        gc.setFill(Color.YELLOW);
        gc.fillOval(165, 115, 70, 70); // Nucleic acid
        gc.setFill(Color.BLACK);
        gc.fillRect(190, 185, 20, 30); // Glycoprotein anchor
    }

    public static void main(String[] args) {
        launch(args);
    }
}
