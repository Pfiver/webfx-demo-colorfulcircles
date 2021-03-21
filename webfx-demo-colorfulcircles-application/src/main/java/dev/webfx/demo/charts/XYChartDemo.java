package dev.webfx.demo.charts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

public class XYChartDemo extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("Line Chart Sample");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        xAxis.setLabel("Minth");

        final NumberAxis yAxis = new NumberAxis();

        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Stock");

        //defining a series
        javafx.scene.chart.XYChart.Series<Number, Number> series = new javafx.scene.chart.XYChart.Series<>();
        series.setName("Portfolioho");

        //populating the series with data
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(1, 23));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(2, 14));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(3, 15));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(4, 24));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(5, 34));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(6, 36));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(7, 22));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(8, 45));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(9, 43));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(10, 17));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(11, 29));
        series.getData().add(new javafx.scene.chart.XYChart.Data<>(12, 25));

        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
    }
}
