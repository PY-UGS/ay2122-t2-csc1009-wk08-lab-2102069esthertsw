package com.esther.lab.wk08;
import java.text.DecimalFormat;
import java.util.Scanner;
// java com.esther.lab.wk08.CircleWithException

public class Q1CircleWithException {
    private double radius;
    private double area;
    private double diameter;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Q1CircleWithException(double r) throws IllegalArgumentException, Exception{
        if (r<0) throw new IllegalArgumentException("Radius must be positive.");
        this.radius = r;
    }
    public void setRadius(double r)throws IllegalArgumentException, Exception{
        if (r<0) throw new IllegalArgumentException("Radius must be positive.");
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea() throws Exception{
        this.area = Math.PI * radius * radius;
        if(area > 1000) throw new Exception("Area of circle is bigger than 1000");
        return area;
    }

    public double getDiameter(){
        this.diameter = 2*radius;
        return diameter;
    }

    public static void main(String[] args){
        try{
            Scanner input = new Scanner(System.in);
            System.out.println("Enter radius of circle: ");
            Q1CircleWithException aCircle = new Q1CircleWithException(input.nextDouble());
            System.out.println("Area of circle: " + df.format(aCircle.getArea()));
            System.out.println("Diameter of circle: " + df.format(aCircle.getDiameter()));
            System.out.println("Enter new radius of circle: ");
            aCircle.setRadius(input.nextDouble());
            System.out.println("Area of circle: " + df.format(aCircle.getArea()));
            System.out.println("Diameter of circle: " + df.format(aCircle.getDiameter()));
        } catch(IllegalArgumentException e){
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
