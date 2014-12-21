/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maplistconverter;

import java.io.IOException;

/**
 *
 * @author Sam
 */
public class MapListConverter {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String fileLocation = "C:\\Users\\Sam\\Documents\\Other\\MapApp\\MapListConverter\\computerlabs_points.txt";
        // TODO code application logic here
        
        PointSet test = new PointSet(fileLocation);
        
        System.out.println(test.toString());
    }
    
}
