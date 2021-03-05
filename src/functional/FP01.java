package functional;

import java.util.Arrays;
import java.util.List;

public class FP01 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 9, 13, 4, 6, 2, 4, 12, 15);
        printAllNumbersInList(numbers);
        printAllEvenNumbersInList(numbers);
        printSquaresOfEvenNumbersInList(numbers);
        printAllOddNumbersInList(numbers);
        printCubesOfOddNumbersInList(numbers);
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
        printAllCourses(courses);
        printSpringCourses(courses);
        printCoursesWithLongName(courses);
        printNameLengthOfCourses(courses);
    }

    private static void printAllNumbersInList(List<Integer> numbers) {
        System.out.println("All numbers:");
        numbers.forEach(System.out::println);
    }

    private static void printAllEvenNumbersInList(List<Integer> numbers) {
        System.out.println("Even numbers:");
        numbers.stream().filter(FP01::isEven).forEach(System.out::println);
    }

    private static void printSquaresOfEvenNumbersInList(List<Integer> numbers) {
        System.out.println("Squares of even numbers:");
        numbers.stream().filter(FP01::isEven).map(number -> number * number).forEach(System.out::println);
    }

    private static void printAllOddNumbersInList(List<Integer> numbers) {
        System.out.println("Odd numbers:");
        numbers.stream().filter(number -> number % 2 == 1).forEach(System.out::println);
    }

    private static void printCubesOfOddNumbersInList(List<Integer> numbers) {
        System.out.println("Cubes of odd numbers:");
        numbers.stream().filter(number -> number % 2 == 1).map(number -> Math.pow(number, 3)).forEach(System.out::println);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static void printAllCourses(List<String> courses) {
        System.out.println("All courses:");
        courses.forEach(System.out::println);
    }

    private static void printSpringCourses(List<String> courses) {
        System.out.println("Spring courses:");
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    private static void printCoursesWithLongName(List<String> courses) {
        System.out.println("Courses with long name:");
        courses.stream().filter(course -> course.length() > 3).forEach(System.out::println);
    }

    private static void printNameLengthOfCourses(List<String> courses) {
        System.out.println("Name length of courses:");
        courses.stream().map(String::length).forEach(System.out::println);
    }

}
