package com.student;
public class MarkSheet {
    private int term1Marks;
    private int term2Marks;
    private int term3Marks;
    private double averageMarks;

    public MarkSheet(int term1Marks, int term2Marks, int term3Marks, double averageMarks) {
        this.term1Marks = term1Marks;
        this.term2Marks = term2Marks;
        this.term3Marks = term3Marks;
        this.averageMarks = averageMarks;
    }

    public int getTerm1Marks() {
        return term1Marks;
    }

    public int getTerm2Marks() {
        return term2Marks;
    }

    public int getTerm3Marks() {
        return term3Marks;
    }

    public double getAverageMarks() {
        return averageMarks;
    }
}
