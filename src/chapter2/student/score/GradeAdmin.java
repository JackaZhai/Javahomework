package chapter2.student.score;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class GradeAdmin {
    private Grade[] grades; // 存储成绩对象的数组
    private int n; // 当前学生数量

    public GradeAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入要录入的学生数量: ");
        while (true) {
            try {
                int max = scanner.nextInt();
                scanner.nextLine(); // 吞掉换行符
                if (max <= 0) {
                    throw new NumberFormatException("学生数量必须大于0。");
                }
                this.grades = new Grade[max];
                this.n = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("无效输入，请输入一个正整数。");
                System.out.print("请输入要录入的学生数量: ");
                scanner.nextLine(); // 吞掉无效输入
            }
        }
    }

    public void show() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n-------学生成绩系统-------");
            System.out.println("1---学生成绩录入");
            System.out.println("2---学生成绩查询打印");
            System.out.println("3---学生成绩排序");
            System.out.println("0---退出");
            System.out.print("请选择操作: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    inputGrades(scanner);
                    break;
                case "2":
                    find(scanner);
                    break;
                case "3":
                    sortAndPrintGrades(scanner);
                    break;
                case "0":
                    System.out.println("退出系统。");
                    return;
                default:
                    System.out.println("错误输入，请重新输入。");
            }
        }
    }

    //成绩录入功能
    private void inputGrades(Scanner scanner) {
        System.out.println("\n------学生成绩录入------");
        while (n < grades.length) {
            try {
                grades[n] = new Grade();
                n++;
            } catch (Exception e) {
                System.out.println("录入过程中出错，请重新录入。");
                scanner.nextLine(); // 清除错误输入
                continue;
            }
            if (n >= grades.length) {
                System.out.println("已达到预定录入数量。");
                break;
            }
            System.out.print("是否继续录入（y/n）: ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    // 成绩查询功能
    private void find(Scanner scanner) {
        System.out.print("\n输入要查询的学生姓名关键词: ");
        String keyword = scanner.nextLine();
        Grade[] matchedGrades = findStudentGradeInfos(keyword);
        if (matchedGrades.length == 0) {
            System.out.println("未找到匹配的学生成绩。");
        } else {
            printGrades(matchedGrades);
        }
    }

    //根据关键字模糊查询学生成绩
    private Grade[] findStudentGradeInfos(String keyword) {
        Grade[] temp = new Grade[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (grades[i].getStudentName().contains(keyword)) {             //contains方法判断是否包含关键字，仅当且仅当此字符串包含指定的字符序列时返回 true。
                temp[count] = grades[i];
                count++;
            }
        }
        return Arrays.copyOf(temp, count);
    }

    //打印成绩列表
    public void printGrades(Grade[] studentGradeInfos) {
        System.out.println("\n-----------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "姓名", "Java", "SQL", "HTML", "总分", "平均分");
        System.out.println("-----------------------------------------------------------------");
        for (Grade grade : studentGradeInfos) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10d %-10.2f%n",
                    grade.getStudentName(),
                    grade.getJavaScore(),
                    grade.getSqlScore(),
                    grade.getHtmlScore(),
                    grade.getTotalScore(),
                    grade.getAverageScore());
        }
        System.out.println("-----------------------------------------------------------------");
    }

    //成绩排序并打印功能
    public void sortAndPrintGrades(Scanner scanner) {
        if (n == 0) {
            System.out.println("无任何学生成绩记录，请先进行成绩录入。");
            return;
        }

        label://label用于跳出多重循环
        while (true) {
            System.out.println("\n请选择排序方式：");
            System.out.println("1-升序");
            System.out.println("2-降序");
            System.out.println("3-退出");
            System.out.print("请选择操作: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Arrays.sort(grades, 0, n, Comparator.comparingInt(Grade::getTotalScore));
                    printGrades(Arrays.copyOf(grades, n));

                    break;
                case "2":
                    Arrays.sort(grades, 0, n, Comparator.comparingInt(Grade::getTotalScore).reversed());
                    printGrades(Arrays.copyOf(grades, n));

                    break;
                case "3":
                    break label;
                default:
                    System.out.println("错误输入，请重新输入。");
                    break;
            }
        }
    }

}
