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
    
    public int getValue(){
        return Value;
    }
    public String getCountry(){
        return dim.getCountry();
    }
    public void setNull(){
        this.Value=-1;
    }
    @Override
    public String toString() {
        return "" + dim.getCountry() + " in " + dim.getYear() + ": " + Value + "% immunized";
    }
}
