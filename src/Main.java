import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请选择要运行的程序：");
        System.out.println("1. Phone");
        System.out.println("2. MyCalendar");
        int choice = scanner.nextInt();

        switch (choice) {
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
                System.out.println(myCalendar);
                break;
            default:
                System.out.println("无效的选择");
                break;
        }
    }
}