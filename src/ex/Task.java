package ex;

import model.Department;
import model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {
     ArrayList<Employee> employees = new ArrayList<>(
             Arrays.asList(new Employee("Nic", Department.IT,42,false),
                     new Employee("Nic", Department.HR,22,false),
                     new Employee("Nic", Department.MANAGEMENT,28,false),
                     new Employee("Nic", Department.MANAGEMENT,29,true),
                     new Employee("Nic", Department.MANAGEMENT,29,true),
                     new Employee("Nic", Department.SOFTWARE,32,true),

                     new Employee("NICOLAE", Department.IT,22,true),
                     new Employee("NICOLAE", Department.SOFTWARE,22,false),
                     new Employee("NICOLAE", Department.MANAGEMENT,28,true),
                     new Employee("NICOLAE", Department.MANAGEMENT,29,true),
                     new Employee("NICOLAE", Department.ACCOUNTING,30,true),

                     new Employee("Ion", Department.IT,22,true),
                     new Employee("Ion", Department.HR,22,false),
                     new Employee("Ion", Department.MANAGEMENT,28,true),
                     new Employee("Ion", Department.SOFTWARE,29,true),
                     new Employee("Ion", Department.ACCOUNTING,30,true),
                     new Employee("Ion", Department.ACCOUNTING,31,false)
             )
     );
    public Task() {
    }
//    public List<Employee> addEmploye(){
//    employees.add(new Employee("Nic", Department.IT,42,false));
//    employees.add(new Employee("Nic", Department.HR,22,false));
//    employees.add(new Employee("Nic", Department.MANAGEMENT,28,false));
//    employees.add(new Employee("Nic", Department.MANAGEMENT,29,true));
//    employees.add(new Employee("Nic", Department.SOFTWARE,32,true));
//
//    employees.add(new Employee("NICOLAE", Department.IT,22,true));
//    employees.add(new Employee("NICOLAE", Department.SOFTWARE,22,false));
//    employees.add(new Employee("NICOLAE", Department.MANAGEMENT,28,true));
//    employees.add(new Employee("NICOLAE", Department.MANAGEMENT,29,true));
//    employees.add(new Employee("NICOLAE", Department.ACCOUNTING,30,true));
//
//    employees.add(new Employee("Ion", Department.IT,22,true));
//    employees.add(new Employee("Ion", Department.HR,22,false));
//    employees.add(new Employee("Ion", Department.MANAGEMENT,28,true));
//    employees.add(new Employee("Ion", Department.SOFTWARE,29,true));
//    employees.add(new Employee("Ion", Department.ACCOUNTING,30,true));
//    employees.add(new Employee("Ion", Department.ACCOUNTING,31,false));
//
//        System.out.println("empl size : " + employees.size());
//    return employees;
//    }

    public String showEmpl(){
        List<Employee> employeeStream = employees.stream()
                .filter(e -> e.getAge() > 25)
                .filter(e -> e.isPayedPerHour() == true)
                .filter(e ->e.getDepartment().equals(Department.MANAGEMENT))
                .limit(5) // daca scot limita se dubleaza afisarea
               .collect( Collectors.toList());

        return employeeStream.toString();
    }
    public String orderEmployee( ){
        List<String> order = employees.stream()
                .filter(e -> !e.isPayedPerHour())
                .filter(e -> e.getAge() > 30)
              //  .map(Employee::getName)
                .map(e ->e.getName())
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        return order.toString();
    }

    public String showEmlpSoft( ){
        List<Employee> employeeStream = employees.stream()
                .distinct()
                .filter(e -> e.getAge() > 30)
                .filter(e -> e.isPayedPerHour())
                .filter(e ->e.getDepartment().equals(Department.SOFTWARE))
                .collect(Collectors.toList());

       return employeeStream.toString();

    }


}
