//在Javahomework项目中完成以下类
//
//三角形类的设计
//
//1、定义一个三角形的类，并定义三条边长属性，注意属性的封装。
//
//2、定义一个无参的构造法，利用键盘输入三个边长属性，构造三角形对象。如果输入不能构造三角形则抛异常。
//
//3、重写toString的方法，实现打印三角形对象，能显示三角形类型（等边、等腰、直角等等）和三角形的面积（保留两位小数））


import java.util.Scanner;

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    // No-argument constructor
    public Triangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入边长A：");
        this.sideA = scanner.nextDouble();
        System.out.print("输入边长B：");
        this.sideB = scanner.nextDouble();
        System.out.print("输入边长C：");
        this.sideC = scanner.nextDouble();

        if (!isValidTriangle()) {
            throw new IllegalArgumentException("输入的边长不能构成三角形");
        }
    }

    // Method to check if the sides form a valid triangle
    private boolean isValidTriangle() {
        return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    // Method to calculate the area of the triangle using Heron's formula
    private double calculateArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    // Method to determine the type of the triangle
    private String getTriangleType() {
        if (sideA == sideB && sideB == sideC) {
            return "等边三角形";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return "等腰三角形";
        } else if (isRightTriangle()) {
            return "直角三角形";
        } else {
            return "普通三角形";
        }
    }

    // Method to check if the triangle is a right triangle
    private boolean isRightTriangle() {
        double a2 = sideA * sideA;
        double b2 = sideB * sideB;
        double c2 = sideC * sideC;
        return (a2 + b2 == c2) || (a2 + c2 == b2) || (b2 + c2 == a2);
    }

    // Override toString method
    @Override
    public String toString() {
        return "三角形类型：" + getTriangleType() + "\n" +
               "面积：" + String.format("%.2f", calculateArea());
    }

    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle();
            System.out.println(triangle);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}