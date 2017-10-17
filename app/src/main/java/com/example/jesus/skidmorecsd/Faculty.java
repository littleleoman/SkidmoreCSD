package com.example.jesus.skidmorecsd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Fragment {

    TextView memberName;
    TextView office;
    ImageView profPic;

    TableRow name;
    TableRow memberInfo;

    RecyclerView rv;
    FacultyAdapter facultyAdapter;
    List<FacultyMembers> faculty = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_faculty, container, false);

        // Code related to recycler view
        rv = (RecyclerView) v.findViewById(R.id.recyclerView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        FacultyMembers fm = new FacultyMembers(getActivity());
        faculty = fm.faculty;
        facultyAdapter = new Faculty.FacultyAdapter(faculty);
        rv.setAdapter(facultyAdapter);

        return v;
    }

    public class FacultyHolder extends RecyclerView.ViewHolder  {

        public FacultyHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_faculty, parent, false));

            memberName = (TextView) itemView.findViewById(R.id.memberName);
            office = (TextView) itemView.findViewById(R.id.office);
            profPic = (ImageView) itemView.findViewById(R.id.profPic);

            name = (TableRow) itemView.findViewById(R.id.name);
            memberInfo = (TableRow) itemView.findViewById(R.id.memberInfo);
        }

        public void bind (final FacultyMembers member) {
            memberName.setText(member.getMemberName());
            office.setText(member.getOffice());

            // Get profPic based on member's ID
            int id = getContext().getResources().getIdentifier(member.getID().toLowerCase(), "drawable", getContext().getPackageName());
            if(id != 0) {
                profPic.setImageResource(id);
            } else {
                // Do nothing, placeholder will be shown.
            }

            profPic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moreInfoIntent = new Intent(getActivity(), FacultyInfo.class);
                    moreInfoIntent.putExtra("EMAIL", member.getEmail());
                    moreInfoIntent.putExtra("TITLE", member.getTitle());
                    moreInfoIntent.putExtra("ID", member.getID());
                    startActivity(moreInfoIntent);
                }
            });
            name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moreInfoIntent = new Intent(getActivity(), FacultyInfo.class);
                    moreInfoIntent.putExtra("EMAIL", member.getEmail());
                    moreInfoIntent.putExtra("TITLE", member.getTitle());
                    moreInfoIntent.putExtra("ID", member.getID());
                    startActivity(moreInfoIntent);
                }
            });
            memberInfo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent moreInfoIntent = new Intent(getActivity(), FacultyInfo.class);
                    moreInfoIntent.putExtra("EMAIL", member.getEmail());
                    moreInfoIntent.putExtra("TITLE", member.getTitle());
                    moreInfoIntent.putExtra("ID", member.getID());
                    startActivity(moreInfoIntent);
                }
            });

            Log.d("Faculty: ", "Bind " + member.getMemberName());
        }
    }

    public class FacultyAdapter extends RecyclerView.Adapter<Faculty.FacultyHolder> {
        private List<FacultyMembers> faculty;

        public FacultyAdapter(List<FacultyMembers> facultyList) {
            faculty = facultyList;
        }

        public Faculty.FacultyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            return new Faculty.FacultyHolder(inflater, parent);
        }

        public int getItemCount() {
            Log.d("Faculty: ", "Size of faculty list - " + faculty.size());
            return faculty.size();
        }

        public void onBindViewHolder(Faculty.FacultyHolder holder, int position) {
            FacultyMembers member = faculty.get(position);
            holder.bind(member);
        }

    }


}
