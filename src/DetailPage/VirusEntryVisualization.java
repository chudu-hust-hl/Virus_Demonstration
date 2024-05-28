package DetailPage;

import VirusInformation.EnvelopedVirus;
import VirusInformation.Virus;
import application.EnvelopedPage;
import application.NonEnvelopedPage;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class VirusEntryVisualization {

    private static final double WIDTH = 900;
    private static final double HEIGHT = 600;
    private final Virus virus;
    private final EnvelopedPage EVPage;
    private final NonEnvelopedPage NEVPage;
    private final Stage stage;
    private final HostServices hostServices;

    public VirusEntryVisualization(Virus virus, EnvelopedPage EVPage, NonEnvelopedPage NEVPage, HostServices hostServices) {
        this.virus = virus;
		this.EVPage = EVPage;
		this.NEVPage = NEVPage;
        this.stage = new Stage();
		this.hostServices = hostServices;
    }

    public void show() {
        stage.setTitle("Virus Entry Visualization");

        BorderPane root = new BorderPane();
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawHostCell(gc);
        Circle virusCircle = createVirus();
        root.getChildren().addAll(canvas, virusCircle);

        // Display virus information
        displayVirusInfo(root, virus);

        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        animateVirusEntry(virusCircle);
    }

    private void drawHostCell(GraphicsContext gc) {
        gc.setFill(Color.LIGHTBLUE);
        gc.fillOval(300, 200, 200, 200);
        gc.setFill(Color.DARKBLUE);
        gc.fillText("Host Cell", 370, 320);
    }

    private Circle createVirus() {
        Circle virus = new Circle(30, Color.RED);
        virus.setCenterX(100);
        virus.setCenterY(300);
        return virus;
    }

    private void animateVirusEntry(Circle virus) {
        Timeline timeline = new Timeline();

        // Move virus to the host cell
        KeyFrame moveToCell = new KeyFrame(Duration.seconds(2),
                new KeyValue(virus.centerXProperty(), 400),
                new KeyValue(virus.centerYProperty(), 300));

        // Simulate fusion and entry
        KeyFrame fusion = new KeyFrame(Duration.seconds(4),
                new KeyValue(virus.radiusProperty(), 0),
                new KeyValue(virus.fillProperty(), Color.TRANSPARENT));

        timeline.getKeyFrames().addAll(moveToCell, fusion);
        timeline.setCycleCount(1);
        timeline.play();
    }

    private void displayVirusInfo(Pane root, Virus virus) {
        if (virus instanceof EnvelopedVirus) {
            EnvelopedVirus envelopedVirus = (EnvelopedVirus) virus;
            Label envelopeInfoLabel = new Label(
                    "Envelope Composition: " + envelopedVirus.getEnvelopeComposition()
            );
            envelopeInfoLabel.setLayoutX(50);
            envelopeInfoLabel.setLayoutY(250);
            root.getChildren().add(envelopeInfoLabel);
        }
    }
    
    

	public HostServices getHostServices() {
		return hostServices;
	}
}
