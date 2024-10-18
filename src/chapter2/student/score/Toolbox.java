package chapter2.student.score;

import java.util.Scanner;

public class Toolbox {
    public static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("输入无效，请输入一个整数。");
            scanner.next(); // 清除无效输入
            System.out.print(prompt);
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // 清除换行符
        return input;
    }
}