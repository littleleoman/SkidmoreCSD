package com.example.jesus.skidmorecsd;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Courses extends Fragment {

    TextView courseName;
    TextView credits;
    TextView prereq;

    List<TableRow> courseRows = new ArrayList<>();
    List<TableRow> detailsRows = new ArrayList<>();
    TableRow course;
    TableRow details;

    private RecyclerView rv;
    RecyclerView.Adapter courseAdapter;
    private List<Course> courses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_courses, container, false);

        // Code related to recycler view
        rv = (RecyclerView) v.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        Course c = new Course(getActivity());
        courses = c.courses;
        courseAdapter = new CourseAdapter(courses);
        rv.setAdapter(courseAdapter);

        return v;
    }

    public class CourseHolder extends RecyclerView.ViewHolder  {

        public CourseHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_course, parent, false));

            courseName = (TextView) itemView.findViewById(R.id.courseName);
            credits = (TextView) itemView.findViewById(R.id.credits);
            prereq = (TextView) itemView.findViewById(R.id.prereq);
            course = (TableRow) itemView.findViewById(R.id.course);
            details = (TableRow) itemView.findViewById(R.id.courseDetails);
        }

        public void bind (final Course c, final int position) {
            courseName.setText(c.getCourseName());
            credits.setText(c.getCredits());
            prereq.setText(c.getPrereq());

            courseRows.add(course);
            detailsRows.add(details);
            detailsRows.get(position).setVisibility(View.GONE);

            courseRows.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(detailsRows.get(position).getVisibility() == View.GONE) {
                        detailsRows.get(position).setVisibility(View.VISIBLE);
                    } else {
                        detailsRows.get(position).setVisibility(View.GONE);
                    }
                }
            });

            detailsRows.get(position).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent descriptionIntent = new Intent(getActivity(), CourseDescription.class);
                    descriptionIntent.putExtra("ID", c.getID());
                    startActivity(descriptionIntent);
                }
            });

            Log.d("Courses: ", "Bind " + c.getCourseName());
        }
    }

    public class CourseAdapter extends RecyclerView.Adapter<CourseHolder> {
        private List<Course> courses;

        public CourseAdapter(List<Course> courseList) {
            courses = courseList;
        }

        public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new CourseHolder(inflater, parent);
        }

        public int getItemCount() {
            Log.d("Courses: ", "Size of course list - " + courses.size());
            return courses.size();
        }

        public void onBindViewHolder(CourseHolder holder, int position) {
            Course course = courses.get(position);
            holder.bind(course, position);
        }

    }
}