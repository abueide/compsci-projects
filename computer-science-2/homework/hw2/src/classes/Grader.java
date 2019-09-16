package classes;

public class Grader {
    public Grader(){}

    public void totalScore(Student student){
        double total = 0;

        for(int i = 0; i < student.getScores().length; i++){
            student.setTotalScore(total);
        }
    }

    public void computeAverageScore(Student student){
        double averageScore = 0;
        averageScore = student.getTotalScore() / student.getScores().length;
        student.setAvgScore(averageScore);
    }
}
