package chapter2.student.score;

import java.util.Arrays;
import java.util.Comparator;

public class GradeAdmin {
    private Grade[] grades; // 存储成绩对象的数组
    private int size; // 当前存储的成绩数量

    public GradeAdmin() {
        grades = new Grade[5]; // 初始容量为5
        size = 0;
    }

    public void show() {
        while (true) {
            System.out.println("\n-------学生成绩系统-------");
            System.out.println("1---学生成绩录入");
            System.out.println("2---学生成绩查询打印");
            System.out.println("3---学生成绩排序");
            System.out.println("0---退出");
            String choice = Toolbox.getStringInput("请选择操作: ");

            switch (choice) {
                case "1":
                    inputGrades();
                    break;
                case "2":
                    find();
                    break;
                case "3":
                    sortAndPrintGrades();
                    break;
                case "0":
                    System.out.println("退出系统。");
                    return;
                default:
                    System.out.println("错误输入，请重新输入。");
            }
        }
    }

    // 成绩录入功能
    private void inputGrades() {
        System.out.println("\n------学生成绩录入------");
        while (true) {
            try {
                if (size >= grades.length) {
                    expandArray();
                }
                grades[size++] = new Grade();
            } catch (Exception e) {
                System.out.println("录入过程中出错，请重新录入。");
                Toolbox.scanner.nextLine(); // 清除错误输入
                continue;
            }
            String choice = Toolbox.getStringInput("是否继续录入（y/n）: ");
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    // 扩容方法
    private void expandArray() {
        grades = Arrays.copyOf(grades, grades.length * 2);
    }

    // 成绩查询功能
    private void find() {
        String keyword = Toolbox.getStringInput("\n输入要查询的学生姓名关键词: ");
        Grade[] matchedGrades = findStudentGradeInfos(keyword);
        if (matchedGrades.length == 0) {
            System.out.println("未找到匹配的学生成绩。");
        } else {
            printGrades(matchedGrades);
        }
    }

    // 根据关键字模糊查询学生成绩
    private Grade[] findStudentGradeInfos(String keyword) {
        Grade[] matchedGrades = new Grade[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (grades[i].getStudentName().contains(keyword)) {
                matchedGrades[count++] = grades[i];
            }
        }
        Grade[] result = new Grade[count];
        System.arraycopy(matchedGrades, 0, result, 0, count);
        return result;
    }

    // 打印成绩列表
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

    // 成绩排序并打印功能
    public void sortAndPrintGrades() {
        if (size == 0) {
            System.out.println("无任何学生成绩记录，请先进行成绩录入。");
            return;
        }

        label:
        // label跳出多循环
        while (true) {
            System.out.println("\n请选择排序方式：");
            System.out.println("1-升序");
            System.out.println("2-降序");
            System.out.println("3-退出");
            String choice = Toolbox.getStringInput("请选择操作: ");

            switch (choice) {
                case "1":
                    Arrays.sort(grades, 0, size, Comparator.comparingInt(Grade::getTotalScore));
                    break;
                case "2":
                    Arrays.sort(grades, 0, size, Comparator.comparingInt(Grade::getTotalScore).reversed());
                    break;
                case "3":
                    break label;
                default:
                    System.out.println("错误输入，请重新输入。");
                    break;
            }
            printGrades(Arrays.copyOf(grades, size));
        }
    }
}