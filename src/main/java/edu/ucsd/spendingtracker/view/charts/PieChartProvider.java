
package edu.ucsd.spendingtracker.view.charts;
import java.util.Map;

import edu.ucsd.spendingtracker.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.chart.*;

public class PieChartProvider implements IChartProvider{
    
    @Override
    public Node createChart(Map<Category, Double> data){
        
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(); 
        data.forEach((cat, sum) -> {
            list.add(new PieChart.Data(cat.name(), sum));
        });

        PieChart pieChart = new PieChart(list);

        for(PieChart.Data entry : list){
            String color = Category.valueOf(entry.getName()).color;
            Node slice = entry.getNode();
            if(slice != null){
                slice.setStyle("-fx-pie-color:" + color + ";");
            }
        }

        pieChart.setLegendVisible(false);
        return (Node)pieChart;
    }

    @Override
    public String getDisplayName(){
        return "Pie Chart";
    }
}
