package lesson05;

public class MainLesson05 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Shemanov Danil", "Aircraft engineer", "gop@gmail.com", "300", 100000, 28);
        employees[1] = new Employee("Novichkov Kirill", "Smokehouse", "sovietvamdalyubov@gmail.com", "666", 200000, 32);
        employees[2] = new Employee("Zotov Nikita", "Designer", "zot@gmail.com", "667", 100000, 32);
        employees[3] = new Employee("Ermolaev bOris", "Beekeeper", "bo@gmail.com", "999", 100000, 30);
        employees[4] = new Employee("Jesus Christ", "Carpenter", "cat@elephant.horse", "333", 0, 2021);

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee.toString());
            }
        }
    }
}
