/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

import com.google.gson.Gson;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author csstudent
 */
public class MainWindowController implements Initializable {
    private PolioImmu dataSet;
    @FXML
    private BarChart chart;
    
    @FXML
    private Slider minimumSlide;
    
    @FXML
    private Slider maximumSlide;
    
    @FXML
    private Label minLabel;
    @FXML
    private Label maxLabel;
    @FXML
    private void handleChangeSlider(MouseEvent mouse){
        XYChart.Series<String, Number> percentImmunized = new XYChart.Series();
        for(DataPoint d : dataSet.getDataPoints()){
            if(d.getCountry()!=null){
                if(d.getValue()>=minimumSlide.getValue() && d.getValue()<= maximumSlide.getValue()){
            percentImmunized.getData().add(new XYChart.Data(d.getCountry(), d.getValue()));
            }
        }
            chart.getData().add(percentImmunized);
        }
    }
        
    
    /*
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    */
    @Override
    public void initialize(URL newURL, ResourceBundle rb) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL myURL = null;
        try {
            myURL = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(myURL.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();
        
        Gson myGSON = new Gson();
        dataSet = myGSON.fromJson(str, PolioImmu.class);
        System.out.println(dataSet.toString());
        //dataSet.removeNulls();
        XYChart.Series<String, Number> percentImmunized = new XYChart.Series();
        for(DataPoint d : dataSet.getDataPoints()){
            if(d.getCountry()!=null){
            percentImmunized.getData().add(new XYChart.Data(d.getCountry(), d.getValue()));
            }
        }
        chart.getData().add(percentImmunized);
         
    }
    
}
