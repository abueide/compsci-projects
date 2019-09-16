package driver;

import classes.Grader;
import classes.Student;

public class GraderDemo {
    public static void main(String args[]) {

        double scoresStudent1[] = {90, 90, 90, 90, 90};
        double scoresStudent2[] = {33, 33, 33, 33, 33};

        Student student1 = new Student("Ada", 123, scoresStudent1);
        Student student2 = new Student("Feynman", 124, scoresStudent2);
        Grader grader = new Grader();

        grader.totalScore(student1);
        grader.computeAverageScore(student1);
        System.out.println(student1.toString());
    }
}
