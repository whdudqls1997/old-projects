package msrebootstatcalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MSRebootStatCalc {
    
    private Map<Double, Integer> dmgT;
    private Map<Double, Integer> igdT;
    private Map<Double, Integer> atkT;
    
    private Map<Integer, ArrayList<Double>> fullT; // [dmg, igd, atk]

    public MSRebootStatCalc() {
        initTears();
    }
    
    public int getDmgT(double dmg){
        double temp = dmg;
        
        if(temp % 10 >= 5)
            temp = temp - (temp % 10) + 10;
        else
            temp = temp - (temp % 10);
        
        return dmgT.get(temp) + 1;
    }
    
    public int getIgdT(double igd){
        return igdT.get(igd*10) + 1 + 4;
    }
    
    public int getAtkT(double atk){
        double temp = atk;
        
        if(temp % 3 == 2)
            temp = temp + 1;
        else if(temp % 3 == 1)
            temp = temp - 1;
        
        return atkT.get(temp) + 1 + 14;
    }
    
    public ArrayList<Double> getFull(int t){
        return fullT.get(t - 1);
    }
    
    private void initTears(){
        dmgT = new HashMap<>();
        igdT = new HashMap<>();
        atkT = new HashMap<>();
        fullT = new HashMap<>();
        
        int dmg = 0;
        for(double i = 100; i <= 800; i += 10){
            dmgT.put(i, dmg);
            dmg += 1;
        }
        
        int igd = 0;
        for(double i = 900; i <= 970; i += 1){
            igdT.put(i, igd);
            igd += 1;
        }
        
        int atk = 0;
        for(double i = 0; i <= 210; i += 3){
            atkT.put(i, atk);
            atk += 1;
        }
        
        //adding dmgT
        for(int i = 0; i <= 70; i++){
            fullT.put(i, new ArrayList<>());
            fullT.get(i).add((double)100 + i*10);
        }
        
        //adding igdT
        fullT.get(0).add(88.89);
        fullT.get(1).add(89.25);
        fullT.get(2).add(89.58);
        fullT.get(3).add(89.90);
        fullT.get(4).add(90.20);
        fullT.get(5).add(90.48);
        fullT.get(6).add(90.74);
        fullT.get(7).add(90.99);
        fullT.get(8).add(91.23);
        fullT.get(9).add(91.45);
        fullT.get(10).add(91.67);
        fullT.get(11).add(91.87);
        fullT.get(12).add(92.06);
        fullT.get(13).add(92.25);
        fullT.get(14).add(92.42);
        fullT.get(15).add(92.59);
        fullT.get(16).add(92.75);
        fullT.get(17).add(92.91);
        fullT.get(18).add(93.06);
        fullT.get(19).add(93.20);
        fullT.get(20).add(93.33);
        fullT.get(21).add(93.46);
        fullT.get(22).add(93.59);
        fullT.get(23).add(93.71);
        fullT.get(24).add(93.83);
        fullT.get(25).add(93.94);
        fullT.get(26).add(94.05);
        fullT.get(27).add(94.15);
        fullT.get(28).add(94.25);
        fullT.get(29).add(94.35);
        fullT.get(30).add(94.44);
        fullT.get(31).add(94.54);
        fullT.get(32).add(94.62);
        fullT.get(33).add(94.71);
        fullT.get(34).add(94.79);
        fullT.get(35).add(94.87);
        fullT.get(36).add(94.95);
        fullT.get(37).add(95.02);
        fullT.get(38).add(95.10);
        fullT.get(39).add(95.17);
        fullT.get(40).add(95.24);
        fullT.get(41).add(95.31);
        fullT.get(42).add(95.37);
        fullT.get(43).add(95.43);
        fullT.get(44).add(95.50);
        fullT.get(45).add(95.56);
        fullT.get(46).add(95.61);
        fullT.get(47).add(95.67);
        fullT.get(48).add(95.73);
        fullT.get(49).add(95.78);
        fullT.get(50).add(95.83);
        fullT.get(51).add(95.88);
        fullT.get(52).add(95.93);
        fullT.get(53).add(95.98);
        fullT.get(54).add(96.03);
        fullT.get(55).add(96.08);
        fullT.get(56).add(96.12);
        fullT.get(57).add(96.17);
        fullT.get(58).add(96.21);
        fullT.get(59).add(96.25);
        fullT.get(60).add(96.30);
        fullT.get(61).add(96.34);
        fullT.get(62).add(96.38);
        fullT.get(63).add(96.42);
        fullT.get(64).add(96.45);
        fullT.get(65).add(96.49);
        fullT.get(66).add(96.53);
        fullT.get(67).add(96.56);
        fullT.get(68).add(96.60);
        fullT.get(69).add(96.63);
        fullT.get(70).add(96.67);
        
        //adding atkT
        for(int i = 0; i < 14; i++){
            fullT.get(i).add(0.0);
        }
        fullT.get(14).add(2.0);
        for(int i = 15; i <= 70; i++){
            fullT.get(i).add(fullT.get(i-1).get(2) + 3);
        }
    }
}
