package chapter2.student.score;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Grade {
    String studentName;
    int javaScore;
    int htmlScore;
    int sqlScore;
    int totalScore;
    double averageScore;

    // 通过Toolbox录入信息（无参构造法）
    public Grade() {
        this.studentName = Toolbox.getStringInput("请输入学生姓名: ");
        this.javaScore = Toolbox.getIntInput("请输入Java成绩: ");
        this.htmlScore = Toolbox.getIntInput("请输入HTML成绩: ");
        this.sqlScore = Toolbox.getIntInput("请输入SQL成绩: ");
        this.totalScore = this.javaScore + this.htmlScore + this.sqlScore;
        this.averageScore = totalScore / 3.0;
    }

    @Override
    public String toString() {
        return "姓名: " + studentName + ", Java: " + javaScore + ", HTML: " + htmlScore + ", SQL: " + sqlScore
                + ", 总分: " + totalScore + ", 平均分: " + averageScore;
    }
}