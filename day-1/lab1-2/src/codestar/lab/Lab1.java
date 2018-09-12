package codestar.lab;

/**
 *
 * @author myx
 */
public class Lab1 {

    double tax(double price) {
        return price * 7 / 100;
    }

    double areaOfCircle(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    double areaOfRectangle(double width, double height) {
        return width * height;
    }

    String hello(String name) {
        return "Hello " + name;
    }

    double carTax(int cc, int seat, int door) {
        return cc * 0.75 + seat * 65 + door * 120;
    }

    public static void main(String[] args) {
        Lab1 lab = new Lab1();
        System.out.println("1.tax :" + lab.tax(5));
        System.out.println("2.areaOfCircle :" + lab.areaOfCircle(10));
        System.out.println("3.areaOfRectangle :" + lab.areaOfRectangle(2, 9.5));
        System.out.println("4.hello :" + lab.hello("myx"));
        System.out.println("5.carTax :" + lab.carTax(1800, 5, 4));
    }
}
