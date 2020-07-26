package com.example.quizstudio.models;

public class subjectModel {
    private String subjectName;
    private int subjectImage;
    private String subjectdiscription;

    public subjectModel() {
    }

    public subjectModel(String subjectName, int subjectImage,String subjectdiscription) {
        this.subjectName = subjectName;
        this.subjectImage = subjectImage;
        this.subjectdiscription = subjectdiscription;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getSubjectImage() {
        return subjectImage;
    }

    public void setSubjectImage(int subjectImage) {
        this.subjectImage = subjectImage;
    }
    public String getSubjectdiscription() {
        return subjectdiscription;
    }

    public void setSubjectdiscription(String subjectdiscription) {
        this.subjectdiscription = subjectdiscription;
    }
}

