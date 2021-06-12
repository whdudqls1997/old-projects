package hexagon;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;

public class Hexagon {

    public HashMap<Point2D, ArrayList<Point2D>> map;
    
    public Hexagon(){
        map = null;
    }
    
    public void activate(){
        map = new HashMap<>();
        populate(map, new Point2D.Double(0,0));
        System.out.println(map.keySet().size());
        System.out.println(map);
    }
    
    public void populate(HashMap<Point2D, ArrayList<Point2D>> map, Point2D p){
        
        if(p == null)
            return;
        
        if(0 > -p.getY() + 1/2 * p.getX() + 12 
                || 0 > -p.getY() - p.getX() + 24 
                || 0 > -p.getY() + 2 * p.getX() + 24
                || 0 < -p.getY() + 2 * p.getX() - 24
                || 0 < -p.getY() + 1/2 * p.getX() - 12
                || 0 < -p.getY() - p.getX() - 24)
            return;
        
        if(map.get(p) == null)
            map.put(p, new ArrayList<>());

        ArrayList<Point2D> tempArr = map.get(p);
        
        Point2D tempP;
        
        tempP = new Point2D.Double(p.getX() + 1.5, p.getY() + 1.5);
        tempArr.add(tempP);
        populate(map, tempP);
        
        tempP = new Point2D.Double(p.getX() + 1.5, p.getY());
        tempArr.add(tempP);
        //populate(map, tempP);
        
        tempP = new Point2D.Double(p.getX(), p.getY() - 1.5);
        tempArr.add(tempP);
        //populate(map, tempP);
        
        tempP = new Point2D.Double(p.getX() - 1.5, p.getY() - 1.5);
        tempArr.add(tempP);
        //populate(map, tempP);
        
        tempP = new Point2D.Double(p.getX() - 1.5, p.getY());
        tempArr.add(tempP);
        //populate(map, tempP);
        
        tempP = new Point2D.Double(p.getX(), p.getY() + 15);
        tempArr.add(tempP);
        //populate(map, tempP);
    }
    
    public HashMap<Point2D, ArrayList<Point2D>> returnMap(){
        return map;
    }
}
