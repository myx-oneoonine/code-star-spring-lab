package codestar.lab;

/**
 *
 * @author myx
 */
public class Lab2 {

    int sumOdd(int n) {
        int i = 1;
        int result = 0;
        while (i <= n) {
            if (i % 2 != 0) {
                result += i;
            }
            i++;
        }
        return result;
    }

    int total(int[] a) {
        int i = 0;
        int result = 0;
        while (i < a.length) {
            result += a[i];
            i++;
        }

        return result;
    }

    double average(double[] a) {
        int i = 0;
        int total = 0;
        int result = 0;
        while (i < a.length) {
            total += a[i];
            i++;
        }

        result = total / a.length;

        return result;
    }

    int find(String s, String[] a) {
        int i = 0;
        while (i < a.length) {
            if (a[i].equals(s)) {
                return i;
            }
            i++;
        }
        return -1;
    }
//D:\My Works\git\local\codestart-java\one\src\codestar\lab

    boolean search(String fileName, String folderName) {
        String[] list = new java.io.File(folderName).list();
        int i = 0;
        while (i < list.length) {
            if (list[i].equals(fileName)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        Lab2 lab = new Lab2();
        //1
        System.out.println("1.sumOdd :" + lab.sumOdd(100));
        //2
        int[] x = new int[5];
        x[0] = 2;
        x[1] = 4;
        x[2] = 6;
        x[3] = 8;
        x[4] = 0;
        System.out.println("2.total :" + lab.total(x));
        //3
        double[] y = new double[5];
        y[0] = 1;
        y[1] = 3;
        y[2] = 5;
        y[3] = 7;
        y[4] = 9;
        System.out.println("3.total :" + lab.average(y));
        //4
        String s = "Hermione";
        String[] a = {"Harry", "Ron", "Hermione", "Hagrid"};
        System.out.println("4.find :" + lab.find(s, a));
        //5
        System.out.println("5.serch :" + lab.search("App.java", "D:\\My Works\\git\\local\\codestart-java\\one\\src\\codestar\\lab"));
    }
}
