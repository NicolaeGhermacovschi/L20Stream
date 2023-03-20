package ex;

import model.Department;
import model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
    public Task() {
    }
    private ArrayList<Employee> employees = new ArrayList<>();
    public List<Employee> addEmploye(){
    employees.add(new Employee("Nic", Department.IT,42,false));
    employees.add(new Employee("Nic", Department.HR,22,false));
    employees.add(new Employee("Nic", Department.MANAGEMENT,28,false));
    employees.add(new Employee("Nic", Department.MANAGEMENT,29,true));
    employees.add(new Employee("Nic", Department.SOFTWARE,32,true));

    employees.add(new Employee("NICOLAE", Department.IT,22,true));
    employees.add(new Employee("NICOLAE", Department.SOFTWARE,22,false));
    employees.add(new Employee("NICOLAE", Department.MANAGEMENT,28,true));
    employees.add(new Employee("NICOLAE", Department.MANAGEMENT,29,true));
    employees.add(new Employee("NICOLAE", Department.ACCOUNTING,30,true));

    employees.add(new Employee("Ion", Department.IT,22,true));
    employees.add(new Employee("Ion", Department.HR,22,false));
    employees.add(new Employee("Ion", Department.MANAGEMENT,28,true));
    employees.add(new Employee("Ion", Department.SOFTWARE,29,true));
    employees.add(new Employee("Ion", Department.ACCOUNTING,30,true));
    employees.add(new Employee("Ion", Department.ACCOUNTING,31,false));


    return employees;
    }

    public String showEmpl(List<Employee> employees){
        List<Employee> employeeStream = employees.stream()
                .filter(e -> e.getAge() > 25)
                .filter(e -> e.isPayedPerHour() == true)
                .filter(e ->e.getDepartment().equals(Department.MANAGEMENT))
                .limit(5) // daca scot limita se dubleaza afisarea
               .collect( Collectors.toList());

        return employeeStream.toString();
    }
    public String orderEmployee(List<Employee> employees){
        List<String> order = employees.stream()
                .filter(e -> !e.isPayedPerHour())
                .filter(e -> e.getAge() > 30)
                .map(Employee::getName)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        return order.toString();
    }

    public String showEmlpSoft(List<Employee> employees){
        List<Employee> employeeStream = employees.stream()
                .filter(e -> e.getAge() > 30)
                .filter(e -> e.isPayedPerHour())
                .filter(e ->e.getDepartment().equals(Department.SOFTWARE))
                // trebui sa fie afisat doar unul care indeplineste conditia
                .collect(Collectors.toList());

        return employeeStream.toString();
    }


}
