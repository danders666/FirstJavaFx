/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstproject;

/**
 *
 * @author csstudent
 */
public class DataPoint {
       private DataInfo dim;
    private int Value;
    public DataPoint() {
    }
    
    
    
    @Override
    public String toString() {
        return "" + dim.getCountry() + " in " + dim.getYear() + ": " + Value + "% immunized";
    }
}
