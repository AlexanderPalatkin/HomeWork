package lesson05;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;

    public int getAge() {
        return age;
    }

    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee information:\n" +
                "name: " + fullName + "\n" +
                "position: " + position + "\n" +
                "email: " + email + "\n" +
                "phoneNumber: " + phoneNumber + "\n" +
                "salary: " + salary + "\n" +
                "age: " + age;
    }
}
