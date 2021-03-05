package functional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP06Utilities {

    public static void main(String[] args) {
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCP", "Azure", "Docker", "Kubernetes");
        //Joining
        System.out.println(courses.stream().collect(Collectors.joining(",")));
        //FlatMap
        System.out.println(courses.stream().map(course -> course.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()));
        List<String> courses2 = new ArrayList<>(courses);
        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(course2 -> Arrays.asList(course, course2))).collect(Collectors.toList()));
        System.out.println(courses.stream().flatMap(course -> courses2.stream().map(course2 -> Arrays.asList(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));
        System.out.println(courses.stream().flatMap(course -> courses2.stream().filter(course2 -> course2.length() == course.length()).map(course2 -> Arrays.asList(course, course2)))
                .filter(list -> !list.get(0).equals(list.get(1))).collect(Collectors.toList()));

        //Find First (Performance Comparison)
        System.out.println("With FindFirst");
        courses.stream().peek(System.out::println).filter(course -> course.length() > 11).map(String::toUpperCase).peek(System.out::println).findFirst();
        System.out.println("Without FindFirst");
        courses.stream().peek(System.out::println).filter(course -> course.length() > 11).map(String::toUpperCase).peek(System.out::println).collect(Collectors.toList());

        //List Operations
        courses.replaceAll(String::toUpperCase);
        System.out.println(courses);
        courses2.removeIf(course -> course.length() < 6);
        System.out.println(courses2);
    }

}
