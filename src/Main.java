import FirstHomework.MyCalendar;
import FirstHomework.Phone;
import FirstHomework.Triangle;
import FourthHomework.NO2.Menu;
import FourthHomework.NO2.Question;
import FourthHomework.StudentInfosAdmin;
import SecondHomework.GradeAdmin;
import FifthHomework.chapter5_1.MyWeather;
import FifthHomework.chapter5_2.FileLoadDown;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentInfosAdmin admin = new StudentInfosAdmin();
        Menu menu = new Menu();

        menu.addQuestion(new Question(1, 1, "Phone") {
            @Override
            public void run() {
                Phone phone = new Phone();
                System.out.println(phone);
            }
        });

        menu.addQuestion(new Question(1, 2, "MyCalendar") {
            @Override
            public void run() {
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
                            return;
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
                }
            }
        });

        menu.addQuestion(new Question(1, 3, "Triangle") {
            @Override
            public void run() {
                try {
                    Triangle triangle = new Triangle();
                    System.out.println(triangle);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        menu.addQuestion(new Question(1, 4, "Grade") {
            @Override
            public void run() {
                GradeAdmin gradeAdmin = new GradeAdmin();
                gradeAdmin.run();
            }
        });

        menu.addQuestion(new Question(1, 5, "学生信息管理系统") {
            @Override
            public void run() {
                // 学生信息管理系统子菜单
                while (true) {
                    System.out.println("学生信息管理系统选项:");
                    System.out.println("0. 返回主菜单");
                    System.out.println("1. 新增学生");
                    System.out.println("2. 修改学生成绩");
                    System.out.println("3. 删除学生");
                    System.out.println("4. 查询学生");
                    System.out.println("5. 信息统计");
                    System.out.print("请选择操作: ");
                    int subChoice = scanner.nextInt();
                    scanner.nextLine();  // 吞掉换行符

                    switch (subChoice) {
                        case 0:
                            System.out.println("返回主菜单");
                            return;
                        case 1:
                            admin.addStudents();
                            break;
                        case 2:
                            System.out.print("输入学生ID: ");
                            int id = scanner.nextInt();
                            System.out.print("输入Java成绩: ");
                            int javaScore = scanner.nextInt();
                            System.out.print("输入HTML成绩: ");
                            int htmlScore = scanner.nextInt();
                            System.out.print("输入SQL成绩: ");
                            int sqlScore = scanner.nextInt();
                            admin.updateStudentScores(id, javaScore, htmlScore, sqlScore);
                            break;
                        case 3:
                            System.out.print("输入学生ID: ");
                            id = scanner.nextInt();
                            admin.deleteStudent(id);
                            break;
                        case 4:
                            System.out.print("输入查询关键词: ");
                            String keyword = scanner.nextLine();
                            admin.searchStudents(keyword);
                            break;
                        case 5:
                            admin.printStatistics();
                            break;
                        default:
                            System.out.println("无效的选择，请重新输入");
                            break;
                    }
                }
            }
        });

        menu.addQuestion(new Question(1, 6, "城市天气查询") {
            @Override
            public void run() {
                MyWeather myWeather = new MyWeather();
                myWeather.showWeather();
            }
        });

        menu.addQuestion(new Question(1, 7, "文件下载") {
            @Override
            public void run() {
                FileLoadDown loadFile = new FileLoadDown();
                String url = "https://tse1-mm.cn.bing.net/th/id/OIP-C.s5BYekl6gfkEmjCLFAOGmwHaFj?rs=1&pid=ImgDetMain";
                String fileName = "图片1";
                String savePath = "/Users/Zhai/IdeaProjects/Javahomework/src/FifthHomework/chapter5_2";
                loadFile.openNetFile(url, fileName, savePath);
            }
        });

        while (true) {
            System.out.println("请选择要运行的程序：");
            System.out.println("0. 退出");
            System.out.println("1. Phone");
            System.out.println("2. MyCalendar");
            System.out.println("3. Triangle");
            System.out.println("4. Grade");
            System.out.println("5. 学生信息管理系统");
            System.out.println("6. 城市天气查询");
            System.out.println("7. 文件下载");
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("程序已退出");
                    return;
                case 1:
                    menu.runQuestion(1, 1);
                    break;
                case 2:
                    menu.runQuestion(1, 2);
                    break;
                case 3:
                    menu.runQuestion(1, 3);
                    break;
                case 4:
                    menu.runQuestion(1, 4);
                    break;
                case 5:
                    menu.runQuestion(1, 5);
                    break;
                case 6:
                    menu.runQuestion(1, 6);
                    break;
                case 7:
                    menu.runQuestion(1, 7);
                    break;
                default:
                    System.out.println("无效的选择");
                    break;
            }
        }
    }
}