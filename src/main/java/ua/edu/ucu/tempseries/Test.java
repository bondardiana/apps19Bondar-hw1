package ua.edu.ucu.tempseries;
import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        double[] temps = {3.0, 5.9 ,2.7 , 7.77};
        double [] ttt ={222.5, 44.5, 334.6, 5453.6, 54.6};
        TemperatureSeriesAnalysis  t = new TemperatureSeriesAnalysis(temps);
        System.out.println(t.GetTemperatures());
        t.addTemps(ttt);
        System.out.println(t.GetTemperatures());
//        System.out.println(t.average());
//        System.out.println(t.deviation());

        //System.out.println(t.findTempsLessThen(90));



    }
}