/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datagrapher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *
 * @author dwheadon
 */
public class Singleton implements java.io.Serializable {
    private static Singleton instance;
    private double minValue;
    private double maxValue;
    /*
    private String filterValue = "all";
    public transient static Singleton instance;
    private Map<Integer, Integer> failedInspections;
    */
    private Singleton() {
    }
    
    private static void init() {
        if (instance == null) {
            try
            {
               FileInputStream fileIn = new FileInputStream("settings.ser");
               ObjectInputStream in = new ObjectInputStream(fileIn);
               instance = (Singleton) in.readObject();
               in.close();
               fileIn.close();
            }catch(IOException i)
            {
               instance = new Singleton();
               return;
            }catch(ClassNotFoundException c)
            {
               System.out.println("Employee class not found");
               c.printStackTrace();
               return;
            }            
        }
    }
    
    public static void stop(){
        init();
        
    }
    
    public static double getMaxValue() {
        init();
        return instance.maxValue;
    }
    public static double getMinValue(){
        return instance.minValue;
    }
    /*
    public static void setFailures(Map<Integer, Integer> data) {
        init();
        instance.failedInspections = data;
    }
    */
    
    public static void setMinValue(double val) {
        init();
        instance.minValue = val;
    }
    public static void setMaxValue(double val) {
        init();
        instance.maxValue = val;
    }
    
    public static void save() {
        init();
        try {
           FileOutputStream fileOut =
           new FileOutputStream("settings.ser");
           ObjectOutputStream out = new ObjectOutputStream(fileOut);
           out.writeObject(instance);
           out.close();
           fileOut.close();
           System.out.printf("Serialized data is saved in settings.ser");
        }catch(IOException i) {
            i.printStackTrace();
        }    
    }
}
