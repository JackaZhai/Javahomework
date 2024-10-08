import FirstHomework.MyCalendar;
import FirstHomework.Phone;
import FirstHomework.Triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请选择要运行的程序：");
            System.out.println("0. 退出");
            System.out.println("1. FirstHomework.Phone");
            System.out.println("2. FirstHomework.MyCalendar");
            System.out.println("3. FirstHomework.Triangle");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("程序已退出");
                    return;
                case 1:
                    Phone phone = new Phone();
                    System.out.println(phone);
                    break;
                case 2:
                    System.out.print("输入年份：");
                    int year = scanner.nextInt();
                    System.out.print("输入月份：");
                    int month = scanner.nextInt();
                    MyCalendar myCalendar = new MyCalendar(year, month);

                    // 子菜单
                    while (true) {
                        System.out.println("请选择要运行的程序：");
                        System.out.println("0. 返回主菜单");
                        System.out.println("1. 打印日历对象");
                        System.out.println("2. 输入月份一个月的天数");
                        System.out.println("3. 获得某年某月某日是星期几");
                        System.out.println("4. 修改年和月");
                        int subChoice = scanner.nextInt();

                        switch (subChoice) {
                            case 0:
                                System.out.println("返回主菜单");
                                break;
                            case 1:
                                myCalendar.printCalendar();
                                break;
                            case 2:
                                System.out.println("天数: " + myCalendar.getDaysInMonth());
                                break;
                            case 3:
                                System.out.print("输入日期：");
                                int day = scanner.nextInt();
                                myCalendar.printDayOfWeek(day);
                                break;
                            case 4:
                                System.out.print("输入新的年份：");
                                year = scanner.nextInt();
                                System.out.print("输入新的月份：");
                                month = scanner.nextInt();
                                myCalendar = new MyCalendar(year, month);
                                System.out.println("已更新日历对象");
                                break;
                            default:
                                System.out.println("无效的选择");
                                break;
                        }
                        if (subChoice == 0) {
                            break;
                        }
                    }
                    break;
                case 3:
                    try {
                        Triangle triangle = new Triangle();
                        System.out.println(triangle);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("无效的选择");
                    break;
            }
        }
    }
}