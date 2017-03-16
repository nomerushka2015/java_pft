package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {

        hello("baby");
        double len = 5;
        System.out.println("Площадь квадрата со стороной " + len + " = " + area(len));

        double a =4;
        double b = 6;
        System.out.println("Площадь прямоугольникa со сторонами " + a + " и " + b + " = " + area(a,b));

    }
    public  static  void hello(String somebody){
              System.out.println("Hello " + somebody + "!");
    }
    public  static  double area(double len){
        return  len*len;
    }
    public  static  double area(double a, double b){
        return  a * b;
    }
}