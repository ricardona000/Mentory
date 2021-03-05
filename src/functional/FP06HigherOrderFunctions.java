package functional;

import java.util.function.Predicate;

public class FP06HigherOrderFunctions {

    public static void main(String[] args) {
        Predicate<Course> reviewScoreGreaterThan95Predicate = createPredicateWithMinimumReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90Predicate = createPredicateWithMinimumReviewScore(90);
    }

    //Higher Order Function: a function that returns another function
    private static Predicate<Course> createPredicateWithMinimumReviewScore(int minimumScore) {
        return course -> course.getReviewScore() > minimumScore;
    }

}
