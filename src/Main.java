import ex.Task;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Task task = new Task();
        task.addEmploye();
        System.out.println("====ex 1=====");
        System.out.println(task.showEmpl(task.addEmploye()));
        System.out.println("====ex 2=====");
        System.out.println(task.orderEmployee(task.addEmploye()));
        System.out.println("====ex 3=====");
        System.out.println(task.showEmlpSoft(task.addEmploye()));



    }
}