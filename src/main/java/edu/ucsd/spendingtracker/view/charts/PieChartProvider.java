package edu.ucsd.spendingtracker.view.charts;

import edu.ucsd.spendingtracker.model.Category;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.Node;
import java.util.Map;

public class PieChartProvider implements IChartProvider {
    @Override
    public Node createChart(Map<Category, Double> data) {
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();

        data.forEach((cat, sum) -> {
            chartData.add(new PieChart.Data(cat.name(), sum));
        });

        PieChart chart = new PieChart(chartData);

        for (PieChart.Data entry : chartData) {
            String color = Category.valueOf(entry.getName()).color;
            System.out.println(entry.getName());
            Node slice = entry.getNode();
            if (slice != null) {
                slice.setStyle("-fx-pie-color: " + color + ";");
            }
        }

        chart.setLegendVisible(false);

        return chart;
    }

    @Override
    public String getDisplayName() {
        return "Pie Chart";
    }

}
