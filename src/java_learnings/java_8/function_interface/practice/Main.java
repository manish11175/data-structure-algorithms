package java_learnings.java_8.function_interface.practice;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
//        Sort Employees by Salary using Lambda

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,34,26));
        employeeList.add(new Employee(54,89,45));
        employeeList.add(new Employee(6,98,21));
        employeeList.add(new Employee(5,76,19));
//        System.out.println(employeeList);
//
//        employeeList.sort((a,b)->Integer.compare(a.salary,b.salary));
//        System.out.println(employeeList);
//        List<Employee> descEmployee =employeeList.stream().sorted((a,b)->Integer.compare(b.salary,a.salary)).toList();
//        System.out.println(descEmployee);

/**
        Processor toTrim= s-> s.trim();
        Processor toUppercase = s->s.toUpperCase(Locale.ROOT);
        Processor toReverse = s->{
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString();
        };
        System.out.println(toTrim.process("    This is trimmed   "));
        System.out.println(toUppercase.process("Manish"));
        System.out.println(toReverse.process("manish"));
 **/

//### 3️⃣ Function Composition
//
//        Chain two functions:
//
//        - Multiply by 2
//                - Add 10

        Function<Integer,Integer> multiply =x->x*2;
        Function<Integer,Integer> add = x-> x+10;
        Function<Integer,Integer> result = multiply.andThen(add);
        System.out.println(result.apply(5));

        //### 4️⃣ Predicate Chaining
        //
        //Filter:
        //
        //- Age > 25
        //- Salary > 50

        Predicate<Employee> age = e->e.age>25;
        Predicate<Employee> salary = e-> e.salary>50;
        Predicate<Employee> empFilter = age.and(salary);
        System.out.println(employeeList.stream().filter(empFilter).toList());

        //Convert List of Strings to Uppercase
//        String[]strs = new String[]{"manish","kias","kiaabhj"};
//        Function<String,String>  toUpper = x->x.toUpperCase(Locale.ROOT);
//        System.out.println(Arrays.stream(strs).map(x->toUpper.apply(x)).toList());

        //Second highest salary

        int secondSalary = employeeList.stream().distinct().sorted((x,y)->Integer.compare(y.salary,x.salary)).skip(1).findFirst().get().getSalary();
        System.out.println(secondSalary);


        //convert employees to employees without salary
//        Map<Integer, Integer> em= employeeList.stream().collect(Collectors.toMap(
//                Employee::getId,
//                Employee::getAge
//        ));
//        System.out.println(em);

//        IntPredicate intPredicate = x->x%2==0;
//        System.out.println(intPredicate.test(907));
//          Supplier<Double> generateOtp =()-> Math.random();
//        System.out.println(generateOtp.get());

//        BiFunction<Integer,Integer,Integer> taxCalculator = (amount,tax)->(amount*tax)/100;
//        System.out.println("Total tax will be "+ taxCalculator.apply(846,20));
//         Employee manish = new Employee(1,34,90);
//        Consumer<Employee> printEmp = employee -> System.out.println(employee.toString());
//        Consumer<Employee> logging = employee -> System.err.println(employee.toString());
//        Consumer<Employee> console = printEmp.andThen(logging);
//        console.accept(manish);

//        BinaryOperator<Integer> sum = (b,c)->b*c;
//        System.out.println("sum "+ sum.apply(5,6));
        UnaryOperator<Integer> s=(a)->a*a;

        IntPredicate intPredicate = a->a%10==0;
        System.out.println(intPredicate.test(904));
        Consumer<Object> print = System.out::println;

       print.accept(IntStream.range(1,1_000_1000).filter(intPredicate).count());
        System.out.println("dd  ");
    }

}
