/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maplistconverter;

/**
 *
 * @author Sam
 */
public class Point {
    private double latitude;
    private double longitude;
    private String name;
    
    public Point(String name, double latitude, double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public double getLatitude(){
        return this.latitude;
    }
    
    public double getLongitude(){
        return this.longitude;
    }
    
    public String getName(){
        return this.name;
    }
}
