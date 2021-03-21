package dev.webfx.demo.charts;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.Chart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.logging.Logger;

public final class ChartDemo extends Application {

    Logger LOG = Logger.getLogger(ChartDemo.class.getName());

    XYChart.Series<String, Number> tpSeries = new XYChart.Series<>(); // true positives
    XYChart.Series<String, Number> fpSeries = new XYChart.Series<>(); // false positives

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        LOG.info("---------------- start(Stage primaryStage) -----------------");

        scene.widthProperty().addListener(v -> {
            LOG.info("------------- scene width: " + v + " -------------");
        });

        Chart chart = createChart();

        chart.widthProperty().addListener(v -> {
            LOG.info("------------- chart width: " + v + " -------------");
        });

        chart.prefWidthProperty().addListener(v -> {
            LOG.info("------------- chart prefWidth: " + v + " -------------");
        });

        chart.prefWidthProperty().bind(scene.widthProperty());
        chart.prefHeightProperty().bind(scene.heightProperty());

        root.getChildren().add(chart);

        primaryStage.show();
    }

    private Chart createChart() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        javafx.scene.chart.StackedBarChart<String, Number> chart = new javafx.scene.chart.StackedBarChart<>(xAxis, yAxis);
        ObservableList<XYChart.Series<String, Number>> chartData = FXCollections.observableArrayList();

        tpSeries.getData().add(new XYChart.Data<>("Foo", 55));
        tpSeries.getData().add(new XYChart.Data<>("Bar", 33));
        tpSeries.getData().add(new XYChart.Data<>("Baz", 9));

        fpSeries.getData().add(new XYChart.Data<>("Foo", 66));
        fpSeries.getData().add(new XYChart.Data<>("Bar", 12));
        fpSeries.getData().add(new XYChart.Data<>("Baz", 9));

        chartData.add(tpSeries);
        chartData.add(fpSeries);
        chart.setData(chartData);
        chart.setAnimated(false);
        chart.setTitle("Some Chart");
        return chart;
    }
}
