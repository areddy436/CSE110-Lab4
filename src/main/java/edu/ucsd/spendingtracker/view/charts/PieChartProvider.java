
package edu.ucsd.spendingtracker.view.charts;
import java.util.Map;

import edu.ucsd.spendingtracker.model.*;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.*;

public class PieChartProvider implements IChartProvider{
    
    @Override
    public Node createChart(Map<Category, Double> data){

        ObservableList<PieChart.Data> list = {}; //! here is where i stopped 
    
        PieChart pieChart = new PieChart();

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        data.forEach((cat, sum) -> {
            series.getData().add(new XYChart.Data<>(cat.name(), sum));
        });

        chart.getData().add(series);

        for(XYChart.Data<String, Number> entry : series.getData()){
            String color = Category.valueOf(entry.getXValue()).color;
            Node bar = entry.getNode();
            if(bar != null){
                bar.setStyle("-fx-bar-fill:" + color + ";");
            }
        }

        chart.setLegendVisible(false);
        return (Node)chart;
    }

    @Override
    public String getDisplayName(){
        return "Pie Chart";
    }
}
