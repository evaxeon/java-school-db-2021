package java8.streams_examples;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtils {


    public static List<String> sortEmployeeList(List<Employee> emps) {
        return emps.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .map(emp -> emp.getName())
                .collect(Collectors.toList());
    }

    public static Map<String, Employee> employeeToNameMap(List<Employee> emps) {
        return emps.stream().collect(Collectors.toMap(Employee::getName, Function.identity()));
    }

    public static int totalSalary(List<Employee> employees) {
        return employees.stream().mapToInt(Employee::getSalary).sum();
    }

    //todo do not use this on numbers - this way is for reducing objects, not promitives
    public static int totalSalaryReduceSolution(List<Employee> employees) {
        Optional<Integer> integerOptional = employees.stream()
                .filter(employee -> employee.getName().startsWith("A"))
                .map(Employee::getSalary)
                .reduce(Integer::sum);

        return integerOptional.get();

    }


}
