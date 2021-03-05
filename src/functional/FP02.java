package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP02 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
        addList(numbers);
        sumOfSquares(numbers);
        sumOfCubes(numbers);
        sumOfOdds(numbers);
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
        sortCoursesInReverseOrder(courses);
        sortCoursesByLength(courses);
        System.out.println("Squared Numbers List: " + squaredList(numbers));
        System.out.println("Even Numbers List: " + evenList(numbers));
        System.out.println("Name Lengths List: " + nameLengthsList(courses));
    }

    private static void addList(List<Integer> numbers) {
        int result = numbers.stream().reduce(0, Integer::sum);
        System.out.println("addList = " + result);
    }

    private static void sumOfSquares(List<Integer> numbers) {
        int result = numbers.stream().map(number -> number * number).reduce(0, Integer::sum);
        System.out.println("sum of squares = " + result);
    }

    private static void sumOfCubes(List<Integer> numbers) {
        int result = numbers.stream().map(number -> number * number * number).reduce(0, Integer::sum);
        System.out.println("sum of cubes = " + result);
    }

    private static void sumOfOdds(List<Integer> numbers) {
        int result = numbers.stream().filter(number -> number % 2 == 1).reduce(0, Integer::sum);
        System.out.println("sum of odds = " + result);
    }

    private static void sortCoursesInReverseOrder(List<String> courses) {
        System.out.println("Courses in reverse order");
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void sortCoursesByLength(List<String> courses) {
        System.out.println("Courses sorted by its name length");
        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

    private static List<Integer> squaredList(List<Integer> numbers) {
        return numbers.stream().map(number -> number * number).collect(Collectors.toList());
    }

    private static List<Integer> evenList(List<Integer> numbers) {
        return numbers.stream().filter(number -> number % 2 == 0).collect(Collectors.toList());
    }

    private static List<Integer> nameLengthsList(List<String> courses) {
        return courses.stream().map(String::length).collect(Collectors.toList());
    }
}
