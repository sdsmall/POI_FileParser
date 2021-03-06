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


import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

public class PointSet {
    private ArrayList<Point> pointList;
    private String pointType;
    
    private String[] destNames;
    private double[] latitude;
    private double[] longitude;

    public PointSet(InputStream fis) throws IOException{
        this.pointList = new ArrayList<>();

        BufferedReader br = null;
        
        try{
	//Construct BufferedReader from InputStreamReader
	br = new BufferedReader(new InputStreamReader(fis));
 
	String line = null;
        int count = 0;
	while ((line = br.readLine()) != null) {
                if(count == 0){
                    this.pointType = line;
                }
                else{
                    String[] segments = line.split(Pattern.quote("|"));
                    
                    double tempLat = Double.parseDouble(segments[1]);
                    double tempLong = Double.parseDouble(segments[2]);
                    addPoint(segments[0],tempLat,tempLong);                                 
                }
                count++;                
	}
        destNames = new String[count];
        latitude = new double[count];
        longitude = new double[count];
        for(int ii = 0; ii<count-1; ii++){
            destNames[ii] = pointList.get(ii).getName();
            latitude[ii] = pointList.get(ii).getLatitude();
            longitude[ii] = pointList.get(ii).getLongitude();
        }        
        
        } catch(IOException e){
        
        }
        finally{
            br.close();
            fis.close();
        }         	
    }
     
    private void addPoint(String name, double latitude, double longitude){
        this.pointList.add(new Point(name,latitude,longitude));
    }
    
    public String getPointType(){
        return this.pointType;
    }
    
    public ArrayList getPoints(){
        return this.pointList;
    }
    
    public String[] getDestNames(){
        return this.destNames;
    }
    
    public double[] getLatitudes(){
        return this.latitude;
    }
    
    public double[] getLongitudes(){
        return this.longitude;
    }
    
    public String toString(){
        StringBuilder str = new StringBuilder(this.pointType+"\n");
    
        if(this.pointList.size()>0){
            for(int ii = 0; ii<this.pointList.size(); ii++){
                String temp = "\t"+this.pointList.get(ii).getName()+"("+this.pointList.get(ii).getLatitude()+", "+this.pointList.get(ii).getLongitude()+")"+"\n";
                str.append(temp);
            }
        }
        
        return str.toString();
    }
}
