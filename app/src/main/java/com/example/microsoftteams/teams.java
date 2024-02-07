package com.example.microsoftteams;

public class teams {
    int image;
    String CourseName;

    public teams(int image, String courseName) {
        this.image = image;
        CourseName = courseName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }
}
