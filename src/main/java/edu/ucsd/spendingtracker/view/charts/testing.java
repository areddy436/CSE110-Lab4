package edu.ucsd.spendingtracker.view.charts;

import javafx.scene.chart.*;

public class testing {

    public static void getNametest(){
        PieChart.Data n = new PieChart.Data("thing", 4);
        System.out.println(n.getName());
    }

    public static void main(String[] args){
        getNametest();
    }
}
