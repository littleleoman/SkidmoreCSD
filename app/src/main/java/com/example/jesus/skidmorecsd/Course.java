package com.example.jesus.skidmorecsd;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 10/15/17.
 */

public class Course {

    public List<Course> courses;

    String ID;
    String courseName;
    String credits;
    String prereq;

    Course(Context c) {
        courses = new ArrayList<>();

        courses.add(new Course("CS106", "CS 106 - Introduction to Computer Science I", "4", "None"));
        courses.add(new Course("CS206", "CS 206 - Introduction to Computer Science II", "4", "CS106"));
        courses.add(new Course("CS230", "CS 230 - Programming Languages", "4", "CS206"));
        courses.add(new Course("CS275", "CS 275 - Introduction to Research", "1", "None"));
        courses.add(new Course("CS305", "CS 305 - Design and Analysis of Algorithms", "4", "CS206"));
        courses.add(new Course("CS306", "CS 306 - Computability, Complexity and Heuristics", "4", "CS305"));
        courses.add(new Course("CS318", "CS 318 - Introduction to Computer Organization", "4", "CS206"));
        courses.add(new Course("CS322", "CS 322 - Artificial Intelligence", "4", "CS305"));
        courses.add(new Course("CS323", "CS 323 - Software Design", "3", "CS206"));
        courses.add(new Course("CS324", "CS 324 - Concurrent Programming", "3", "CS206"));
        courses.add(new Course("CS325", "CS 325 - Computer Graphics", "4", "CS206"));
        courses.add(new Course("CS371", "CS 371 - Independent Study", "3", "None"));
        courses.add(new Course("CS381", "CS 381 - Senior Thesis", "3", "None"));
    }

    Course(String ID, String courseName, String credits, String prereq) {
        this.ID = ID;
        this.courseName = courseName;
        this.credits = credits;
        this.prereq = prereq;
    }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getCredits() { return credits; }
    public void setCredits(String credits) { this.credits = credits; }

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getPrereq() { return prereq; }
    public void setPrereq(String prereq) { this.prereq = prereq; }
}


