//在JavaHomework项目中定义一个学生成绩类Grade
//1、Grade中包括学生姓名，java，html，sql三个门课的成绩属性、总分、平均分的属性
//2、Grade定义一个无参的构造法，在构造法中通过Scanner录入信息属性构造成绩对象。
//3、成绩管理类GradeAdmin来实现，以下功能：
//  1）GradeAdmin类中定一个Grade[] grades数组来报错成绩对象。
//  2）能通过输入关键字实现对学生姓名的模糊查询，可以返回多个学生成绩信息，并打印输出。如输入李，能显示所有学生姓名包含“李”的学生成绩信息。
//  3）能通过表格形式显示输出全部学生成绩，并统计出平均分，总分，排名。并能按排名顺序（升序或降序）打印显示
// 4）定义一个方法如下图所示，组合功能
//-------学生成绩系统-------
//1---学生成绩录入
//2---学生成绩查询打印
//3---学生成绩排序
//0---退出
package SecondHomework;

import java.util.Scanner;

public class GradeAdmin {
    private Grade[] grades;

    public GradeAdmin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入学生数量：");
        int n = scanner.nextInt();
        grades = new Grade[n];
        for (int i = 0; i < n; i++) {
            grades[i] = new Grade();
        }
    }

    // 通过关键字查询学生成绩
    public void queryGrade(String keyword) {
        for (Grade grade : grades) {
            if (grade.getName().contains(keyword)) {
                System.out.println(grade);
            }
        }
    }


    // 打印学生成绩
    public void printGrade() {
        double total = 0;
        for (Grade grade : grades) {
            System.out.println(grade);
            total += grade.getTotalGrade();
        }
        System.out.println("总分：" + total + "，平均分：" + total / grades.length);
    }

    public void sortGrade(boolean ascending) {
        for (int i = 0; i < grades.length - 1; i++) {
            for (int j = 0; j < grades.length - 1 - i; j++) {
                if (ascending) {
                    if (grades[j].getTotalGrade() > grades[j + 1].getTotalGrade()) {
                        Grade temp = grades[j];
                        grades[j] = grades[j + 1];
                        grades[j + 1] = temp;
                    }
                } else {
                    if (grades[j].getTotalGrade() < grades[j + 1].getTotalGrade()) {
                        Grade temp = grades[j];
                        grades[j] = grades[j + 1];
                        grades[j + 1] = temp;
                    }
                }
            }
        }
        for (Grade grade : grades) {
            System.out.println(grade);
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------学生成绩系统-------");
            System.out.println("1---学生成绩录入");
            System.out.println("2---学生成绩查询打印");
            System.out.println("3---学生成绩排序");
            System.out.println("0---退出");
            System.out.print("请输入功能编号：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new GradeAdmin();
                    break;
                case 2:
                    System.out.print("输入关键字：");
                    queryGrade(scanner.next());
                    break;
                case 3:
                    System.out.print("输入排序方式（升序true/降序false）：");
                    sortGrade(scanner.nextBoolean());
                    break;
                case 0:
                    return;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    public static void main(String[] args) {
        new GradeAdmin().run();
    }
}