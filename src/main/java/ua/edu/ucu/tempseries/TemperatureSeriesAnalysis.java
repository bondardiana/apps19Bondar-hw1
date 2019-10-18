package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    double [] temperatures= new double[10];
    int l=10;
    public TemperatureSeriesAnalysis() {

    }

    public String GetTemperatures() {
        String line = "";
        for (int i = 0; i < l; i++) {
            line += Double.toString(temperatures[i]);
            line += "  ";
        }
        return line;
    }


    public TemperatureSeriesAnalysis(double[] temperatureSeries) throws InputMismatchException {
        double [] emply_list= new double [0];
        boolean is_emty=false;
        for (double i:temperatureSeries){
            if (i< -273){
                throw new InputMismatchException();
            }
        }
        if (!is_emty) {
            this.temperatures = temperatureSeries;
            l = temperatures.length;
        }

    }

    public double average() throws IllegalArgumentException  {
        double sum = 0;
        if (l==0){
            throw new IllegalArgumentException();
        }
        for (double i : temperatures) {
            sum += i;
        }

        double av = sum / l;
        return av;


    }

    public double deviation() {
        double av=average();
        double D=0;
        for (double i:temperatures) {
            D += (i - av) * (i - av) / l;

        }
        return Math.sqrt(D);
    }

    public double min() {
        double min = temperatures[l];
        for (double i : temperatures) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    public double max() {
        double max = -273;
        for (double i : temperatures) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

        public double findTempClosestToValue ( double tempValue){
            double r_d=Math.abs(temperatures[0]-tempValue);
            double l_d=Math.abs(temperatures[0]-tempValue);
            double r_i=temperatures[0];
            double l_i=temperatures[0];
            double d;
            for (double i:temperatures){
                if (i==tempValue){
                    return tempValue;
                }
                if (i>tempValue){
                    d=Math.abs(i-tempValue);
                    if (d < r_d){
                        r_d=d;
                        r_i=i;
                    }
                }
                if (i<tempValue){
                    d=Math.abs(i-tempValue);
                    if (d<l_d){
                        l_d=d;
                        l_i=i;
                    }
                }
            }
            if (r_d>=l_d){
                return l_i;
            }
            return r_i;


        }

        public double [] findTempsLessThen(double tempValue){
        double [] new_arr= new double[l];
        int new_l=0;
            for (int i=0; i<l; i++){
                if (temperatures[i] < tempValue) {
                    System.out.println(i);
                    new_arr[new_l] = temperatures[i];
                    new_l++;
                }
            }
            return new_arr;
        }

        public double[] findTempsGreaterThen(double tempValue){
            double [] new_arr= new double[l];
            int new_l=0;
            for (int i=0; i<l; i++){
                if (temperatures[i] > tempValue) {
                    System.out.println(i);
                    new_arr[new_l] = temperatures[i];
                    new_l++;
                }
            }
            return new_arr;
        }


        public TempSummaryStatistics summaryStatistics () {
            TempSummaryStatistics t_s_s= new TempSummaryStatistics(average(),deviation(),min(), max());
            return t_s_s;
        }

        public int addTemps ( double...temps) throws InputMismatchException {
            int new_len= 0;
            double []new_arr = new double[l+temps.length];

            for (double i:temps){
                if (i< -273){
                    throw new InputMismatchException();
                }
                new_arr[new_len]=i;
                new_len++;
            }
            for (double i:temperatures) {
                new_arr[new_len]=i;
                new_len++;
            }
            l=new_len;
            temperatures=new_arr;
            return new_len;
        }

    }
