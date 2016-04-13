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
public class PolioImmu {
    private DataPoint[] fact;
    
    public DataPoint[] getDataPoints(){
        return fact;
    }
    public void removeNulls(){
        for(int i = 0; i<fact.length; i++){
            if(fact[i].getCountry() == null){
                fact[i].setNull();
            }
        }
    }
    @Override
    public String toString(){
        String outputString = "";
        for(DataPoint dp : fact){
            outputString+= dp.toString();
            outputString+= "\n";
        }
        return outputString;
    }
}
