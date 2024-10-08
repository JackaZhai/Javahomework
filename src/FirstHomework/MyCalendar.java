package FirstHomework;//在Java homework项目中完成以下类
//
//设计一个日历类MyCalendar。
//
//1）日历类定义年份与月份的属性
//
//2）日历类定义一个有参的构造法，输入年份与月份后，能构造一个日历对象，
//
//3）日历类重写toString的方法，实现打印日历对象，显示以下效果。比如通过构造方法，构造2023年9月对象，打印该对象后如下图所示：

//---------2023年9月----------
//一,二,三,四,五,六 ,日
//,,,,1,2,3
//4,5,6,7 8,9,10
//11,12,13,14,15,16,17
//18,19,20,21,22,23,24
//25,26,27,28,29,30,

//4）日历类定义一个方法，可以获得一个月的天数。
//
//5）日历类定义一个方法，可以获得某年某月某日是星期几。
//
//6）通过引入类和注释@Test实现测试（目前没有实现）

import java.util.Calendar;

public class MyCalendar {
    private int year;
    private int month;

    // getter和setter方法
    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // 构造方法
    public MyCalendar(int year, int month) {
        this.year = year;
        this.month = month;
    }

    // 获取一个月的天数
    public int getDaysInMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    // 获取某年某月某日是星期几
    public String getDayOfWeek(int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        String[] days = {"日", "一", "二", "三", "四", "五", "六"};
        return days[dayOfWeek - 1];
    }

    // 打印日历对象
    public void printCalendar() {
        System.out.println(this);
    }

    // 打印某年某月某日是星期几
    public void printDayOfWeek(int day) {
        System.out.println("星期: " + getDayOfWeek(day));
    }

    // 重写toString方法
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------").append(year).append("年").append(month).append("月").append("----------\n");
        sb.append("一\t二\t三\t四\t五\t六\t日\n");

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int firstDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        int daysInMonth = getDaysInMonth();

        for (int i = 0; i < firstDayOfWeek; i++) {
            sb.append("\t");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            sb.append(day).append("\t");
            if ((day + firstDayOfWeek) % 7 == 0) {
                sb.append("\n");
            }
        }

        return sb.toString();
    }

}
