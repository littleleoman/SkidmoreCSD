package com.example.jesus.skidmorecsd;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jesus on 10/16/17.
 */

public class FacultyMembers {

    public List<FacultyMembers> faculty;

    String memberName;
    String title;
    String email;
    String office;
    String ID;

    FacultyMembers(Context c) {
        faculty = new ArrayList<>();

        faculty.add(new FacultyMembers("MECKMANN", "Michael Eckmann", "Department Associate Chair & Associate " +
                "Professor of Computer Science", "meckmann@skidmore.edu", "Harder 219"));
        faculty.add(new FacultyMembers("TOCONNEL", "Thomas O\' Connell", "Department Chair and Associate " +
                "Professor of Computer Science", "toconnel@skidmore.edu", "Dana 292"));
        faculty.add(new FacultyMembers("APRASAD", "Aarathi Prasad", "Assistant Professor",
                "aprasad@skidmore.edu", "Harder 204D"));
        faculty.add(new FacultyMembers("CREILLY", "Christine Reilly", "Assistant Professor",
                "creilly@skidmore.edu", "Harder 204B"));
        faculty.add(new FacultyMembers("DREAD", "David Read", "Lecturer",
                "dread@skidmore.edu", "Harder 224"));

    }

    FacultyMembers(String ID, String memberName, String title, String email, String office) {
        this.ID = ID;
        this.memberName = memberName;
        this.title = title;
        this.email = email;
        this.office = office;
    }

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String courseName) { this.memberName = memberName; }

    public String getTitle() { return title; }
    public void setTitle(String credits) { this.title = title; }

    public String getEmail() { return email; }
    public void setEmail(String ID) { this.email = email; }

    public String getOffice() { return office; }
    public void setOffice(String prereq) { this.office = office; }
}
