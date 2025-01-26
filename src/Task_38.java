class User {
    protected String name;
    protected int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class Worker extends User {
    private double salary;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class Student extends User {
    private double grant;
    private int course;

    public void setGrant(double grant) {
        this.grant = grant;
    }

    public double getGrant() {
        return grant;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getCourse() {
        return course;
    }
}

public class Task_38 {
    public static void main(String[] args) {
        Worker ivan = new Worker();
        ivan.setName("Иван");
        ivan.setAge(25);
        ivan.setSalary(1000);

        Worker vasya = new Worker();
        vasya.setName("Вася");
        vasya.setAge(26);
        vasya.setSalary(2000);

        double total = ivan.getSalary() + vasya.getSalary();
        System.out.println("Сумма зарплат Ивана и Васи: " + total);
    }
}
