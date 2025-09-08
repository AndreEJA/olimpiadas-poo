package models;

public class Course {
    private String name;
    private double[][] grades;

    public Course(String name, int numberOfStudents, int numberOfEvaluations) {
        this.name = name;
        this.grades = new double[numberOfStudents][numberOfEvaluations];
    }

    public double getStudentAverage(int studentIndex) {
        if (studentIndex < 0 || studentIndex >= grades.length) {
            System.err.println("Error: Student index " + studentIndex + " is out of bounds.");
            return 0;
        }

        double sum = 0;
        for (double grade : grades[studentIndex]) {
            sum += grade;
        }

        if (grades[studentIndex].length == 0) {
            return 0;
        }

        return sum / grades[studentIndex].length;
    }

    public double getEvaluationAverage(int evaluationIndex) {
        if (getNumberOfStudents() == 0 || evaluationIndex < 0 || evaluationIndex >= getNumberOfEvaluations()) {
            System.err.println("Error: Evaluation index " + evaluationIndex + " is out of bounds.");
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i][evaluationIndex];
        }
        return sum / grades.length;
    }

    public int getTopStudentIndex() {
        if (getNumberOfStudents() == 0) {
            return -1;
        }

        int topStudentIndex = 0;
        double highestAverage = getStudentAverage(0);

        for (int i = 1; i < grades.length; i++) {
            double currentAverage = getStudentAverage(i);
            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                topStudentIndex = i;
            }
        }
        return topStudentIndex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double[][] getGrades() {
        return grades;
    }

    public void setGrades(double[][] grades) {
        this.grades = grades;
    }

    public int getNumberOfStudents() {
        return grades.length;
    }

    public int getNumberOfEvaluations() {
        if (grades.length == 0) {
            return 0;
        }
        return grades[0].length;
    }
}