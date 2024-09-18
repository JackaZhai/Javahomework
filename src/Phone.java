
import java.util.Scanner;

public class Phone {
    public String brand;           // 品牌
    public String model;           // 型号
    public int cpuCount;           // CPU个数
    public int memory;             // 内存大小
    public String operatingSystem; // 操作系统
    public double price;           // 价格
    public String serialNumber;    // 编号（唯一标识手机的序列号）

    // 构造方法
    public Phone() {
        Scanner scanner = getScanner(); // 调用 getScanner() 方法，返回一个 Scanner 对象，用于读取用户输入


        System.out.print("请输入品牌: ");
        this.brand = scanner.nextLine();

        System.out.print("请输入型号: ");
        this.model = scanner.nextLine();

        System.out.print("请输入CPU个数: ");
        this.cpuCount = scanner.nextInt();

        System.out.print("请输入内存大小: ");
        this.memory = scanner.nextInt();

        System.out.print("请输入价格: ");
        this.price = scanner.nextDouble();
    }

    private static Scanner getScanner() {
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    // Getters and Setters
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCpuCount() {
        return cpuCount;
    }

    public void setCpuCount(int cpuCount) {
        this.cpuCount = cpuCount;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}