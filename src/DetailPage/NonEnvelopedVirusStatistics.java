package DetailPage;

import java.util.Map;
import java.util.stream.Collectors;

import VirusInformation.NonEnvelopedVirus;
import VirusMenu.NonEnvelopedVirusMenu;
import application.NonEnvelopedPage;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class NonEnvelopedVirusStatistics {
    private final NonEnvelopedPage NEVPage;
    private final Stage stage;
    private final HostServices hostServices;
    private final NonEnvelopedVirusMenu NEVmenu;

    public NonEnvelopedVirusStatistics(NonEnvelopedPage NEVPage, HostServices hostServices, NonEnvelopedVirusMenu NEVmenu) {
        this.NEVPage = NEVPage;
        this.hostServices = hostServices;
        this.NEVmenu = NEVmenu;
        this.stage = new Stage();
    }

    public void show() {
        stage.setTitle("Virus Statistics");

        BorderPane root = new BorderPane();

        // Create title
        Label title = new Label("NonEnveloped Virus Statistics");
        title.setFont(new Font(30));
        title.setTextFill(Color.INDIGO);
        
        HBox titleBox = new HBox(title);
        titleBox.setStyle("-fx-alignment: center; -fx-padding: 10;");
        root.setTop(titleBox);

        // Create charts
        HBox topCharts = new HBox(10, createSeverityChart(), createGeneticMaterialChart());
        topCharts.setStyle("-fx-alignment: center; -fx-padding: 10;");

        HBox bottomCharts = new HBox(10, createIncubationPeriodChart(), createMutationRateChart());
        bottomCharts.setStyle("-fx-alignment: center; -fx-padding: 10;");

        VBox chartsBox = new VBox(10, topCharts, bottomCharts);
        root.setCenter(chartsBox);

        // Create button to return to menu
        Button returnButton = new Button("Return to Menu");
        returnButton.setOnAction(e -> {
            NEVPage.returnToMenu();
            stage.close();
        });

        // Place button at the bottom-left corner
        HBox buttonBox = new HBox(returnButton);
        buttonBox.setStyle("-fx-alignment: bottom-left; -fx-padding: 10;");
        root.setBottom(buttonBox);

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    private BarChart<String, Number> createSeverityChart() {
        // Create a bar chart for virus severity
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Virus Severity");

        // Count occurrences of each severity level
        Map<String, Long> severityCount = NEVmenu.getVirusInMenu().stream()
                .collect(Collectors.groupingBy(NonEnvelopedVirus::getSeverity, Collectors.counting()));

        // Populate the chart data
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        severityCount.forEach((severity, count) -> dataSeries.getData().add(new XYChart.Data<>(severity, count)));

        barChart.getData().add(dataSeries);

        // Set the preferred size of the chart
        barChart.setPrefWidth(450);
        barChart.setPrefHeight(300);

        return barChart;
    }

    private PieChart createGeneticMaterialChart() {
        // Create a pie chart for genetic material type distribution
        PieChart pieChart = new PieChart();
        pieChart.setTitle("Genetic Material Type Distribution");

        // Count occurrences of each genetic material type
        Map<String, Long> geneticMaterialCount = NEVmenu.getVirusInMenu().stream()
                .collect(Collectors.groupingBy(NonEnvelopedVirus::getGeneticMaterialType, Collectors.counting()));

        // Populate the chart data
        geneticMaterialCount.forEach((type, count) -> pieChart.getData().add(new PieChart.Data(type, count)));

        // Set the preferred size of the chart
        pieChart.setPrefWidth(450);
        pieChart.setPrefHeight(300);

        return pieChart;
    }

    private BarChart<String, Number> createMutationRateChart() {
        // Create a bar chart for virus mutation rate
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Virus Mutation Rate");

        // Define categories for mutation rate ranges
        String[] categories = { "0-0.001", "0.001-0.002", "0.002-0.005", "0.005+" };
        xAxis.setCategories(FXCollections.observableArrayList(categories));

        // Count occurrences of viruses in each mutation rate range
        Map<String, Long> mutationRateCount = NEVmenu.getVirusInMenu().stream()
                .collect(Collectors.groupingBy(virus -> {
                    double mutationRate = virus.getMutationRate();
                    if (mutationRate <= 0.001) return categories[0];
                    else if (mutationRate <= 0.002) return categories[1];
                    else if (mutationRate <= 0.005) return categories[2];
                    else return categories[3];
                }, Collectors.counting()));

        // Populate the chart data
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        mutationRateCount.forEach((range, count) -> dataSeries.getData().add(new XYChart.Data<>(range, count)));

        barChart.getData().add(dataSeries);

        // Set the preferred size of the chart
        barChart.setPrefWidth(450);
        barChart.setPrefHeight(300);

        return barChart;
    }

    private BarChart<String, Number> createIncubationPeriodChart() {
        // Create a bar chart for virus incubation period
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Virus Incubation Period");

        // Define categories for incubation period ranges
        String[] categories = { "0-5", "5-10", "10-15", "15+" };
        xAxis.setCategories(FXCollections.observableArrayList(categories));

        // Count occurrences of viruses in each incubation period range
        Map<String, Long> incubationPeriodCount = NEVmenu.getVirusInMenu().stream()
                .collect(Collectors.groupingBy(virus -> {
                    int incubationPeriod = virus.getIncubationPeriod();
                    if (incubationPeriod <= 5) return categories[0];
                    else if (incubationPeriod <= 10) return categories[1];
                    else if (incubationPeriod <= 15) return categories[2];
                    else return categories[3];
                }, Collectors.counting()));

        // Populate the chart data
        XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
        incubationPeriodCount.forEach((range, count) -> dataSeries.getData().add(new XYChart.Data<>(range, count)));

        barChart.getData().add(dataSeries);

        // Set the preferred size of the chart
        barChart.setPrefWidth(450);
        barChart.setPrefHeight(300);

        return barChart;
    }

    public HostServices getHostServices() {
        return hostServices;
    }
}
