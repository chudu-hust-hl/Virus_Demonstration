package DetailPage;

import java.io.File;

import VirusInformation.EnvelopedVirus;
import application.EnvelopedPage;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EnvelopedVirusDemo {
    private final EnvelopedVirus virus;
    private final EnvelopedPage EVPage;
    private final Stage stage;
    private final HostServices hostServices;
    private MediaPlayer mediaPlayer;

    public EnvelopedVirusDemo(EnvelopedVirus virus, EnvelopedPage EVPage, HostServices hostServices) {
        this.virus = virus;
        this.EVPage = EVPage;
        this.hostServices = hostServices;
        this.stage = new Stage();
    }

    public void show() {
        stage.setTitle("Virus Infection Demonstration");

        BorderPane root = new BorderPane();

        // Top HBox for title
        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER);
        titleBox.setPadding(new Insets(10));
        Label titleLabel = new Label("Virus Infection Process: " + virus.getName());
        titleLabel.setFont(new Font(30));
        titleLabel.setTextFill(Color.INDIGO);
        titleBox.getChildren().add(titleLabel);
        root.setTop(titleBox);

        // Center box for video and virus name
        VBox centerBox = new VBox();
        centerBox.setAlignment(Pos.CENTER);
        centerBox.setSpacing(10);
        centerBox.setPadding(new Insets(10));

        // Video player setup
        String videoUrl = virus.getInfectVid(); // Assumes this method exists to get the video URL
        File file = new File(videoUrl);
        Media media;
        try {
            media = new Media(file.toURI().toString());
        } catch (Exception e) {
            showAlert("Error loading video", "The video URL is invalid or the file is not accessible.");
            return;
        }

        mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(600);
        mediaView.setPreserveRatio(true);

        Label virusNameLabel = new Label(virus.getName());
        virusNameLabel.setStyle("-fx-font-size: 14px;");

        Button pauseButton = new Button("Pause");
        pauseButton.setOnAction(e -> {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
                pauseButton.setText("Play");
            } else {
                mediaPlayer.play();
                pauseButton.setText("Pause");
            }
        });

        HBox videoControlsBox = new HBox(virusNameLabel, pauseButton);
        videoControlsBox.setAlignment(Pos.CENTER);
        videoControlsBox.setSpacing(10);

        centerBox.getChildren().addAll(mediaView, videoControlsBox);
        root.setCenter(centerBox);

        // Bottom box for comments and return button
        VBox bottomBox = new VBox();
        bottomBox.setAlignment(Pos.CENTER_LEFT);
        bottomBox.setSpacing(10);
        bottomBox.setPadding(new Insets(10));

        TextArea commentsArea = new TextArea();
        commentsArea.setPromptText("Enter your comments about the infection process here...");
        commentsArea.setWrapText(true);
        commentsArea.setPrefRowCount(4);

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        buttonBox.setSpacing(10);

        Button returnButton = new Button("Return to Menu");
        returnButton.setOnAction(e -> {
            mediaPlayer.stop();
            EVPage.returnToMenu();
            stage.close();
        });

        buttonBox.getChildren().add(returnButton);
        bottomBox.getChildren().addAll(commentsArea, buttonBox);
        root.setBottom(bottomBox);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();

        // Start the video
        mediaPlayer.play();
    }

    private void showAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public HostServices getHostServices() {
        return hostServices;
    }
}
