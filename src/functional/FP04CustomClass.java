package functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {

    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudents;

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name + ":" + numberOfStudents + ":" + reviewScore;
    }

    public Course(String name, String category, int reviewScore, int numberOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudents = numberOfStudents;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(
                new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000)
        );

        //All, None and Any Match
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
        System.out.println("All >95? " + courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println("None <90? " + courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println("At least one <90? " + courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println("At least one >95? " + courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        //Sorted
        Comparator<Course> comparingByNumberOfStudents = Comparator.comparingInt(Course::getNumberOfStudents);
        Comparator<Course> comparingByNumberOfStudentsDesc = Comparator.comparingInt(Course::getNumberOfStudents).reversed();
        Comparator<Course> comparingByNumberOfStudentsAndReviewScoreDesc = Comparator.comparingInt(Course::getNumberOfStudents)
                .thenComparing(Course::getReviewScore).reversed();
        System.out.println("Sorted courses: " + courses.stream().sorted(comparingByNumberOfStudents).collect(Collectors.toList()));
        System.out.println("Sorted courses desc: " + courses.stream().sorted(comparingByNumberOfStudentsDesc).collect(Collectors.toList()));
        System.out.println("Sorted courses by number of students and review score desc: "
                + courses.stream().sorted(comparingByNumberOfStudentsAndReviewScoreDesc).collect(Collectors.toList()));

        //Limit
        System.out.println("Sorted courses by number of students and review score desc (limit 5): "
                + courses.stream().sorted(comparingByNumberOfStudentsAndReviewScoreDesc).limit(5).collect(Collectors.toList()));
        //Skip
        System.out.println("Sorted courses by number of students and review score desc (skip 3 - limit 5): "
                + courses.stream().sorted(comparingByNumberOfStudentsAndReviewScoreDesc).skip(3).limit(5).collect(Collectors.toList()));

        //Take While and Drop While (Java 9?)
        //courses.stream().takeWhile(course -> course.getReviewScore >= 95).collect(Collectors.toList());
        //courses.stream().dropWhile(course -> course.getReviewScore > 95).collect(Collectors.toList());

        //Max
        System.out.println("Max Number of Students Course: " + courses.stream().max(comparingByNumberOfStudentsAndReviewScoreDesc));
        //Min
        System.out.println("Max Number of Students Course: " + courses.stream().min(comparingByNumberOfStudentsAndReviewScoreDesc));

        //Find First
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst());
        //Find Any
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny());

        //Sum, Avg, Count, Max, Min
        System.out.println("Total students: " + courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStudents).sum());
        System.out.println("Average students: " + courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStudents).average());
        System.out.println("Count: " + courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStudents).count());
        System.out.println("Max students: " + courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStudents).max());
        System.out.println("Min students: " + courses.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStudents).min());

        //Grouping By
        System.out.println("Courses grouped by category: " + courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
        System.out.println("Count by category: " + courses.stream().collect(Collectors.groupingBy(Course::getCategory,
                Collectors.counting())));
        System.out.println("Get Max Review Score by category: " + courses.stream().collect(Collectors.groupingBy(Course::getCategory,
                Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
        System.out.println("Name courses grouped by category: " + courses.stream().collect(Collectors.groupingBy(Course::getCategory,
                Collectors.mapping(Course::getName, Collectors.toList()))));
    }

}
