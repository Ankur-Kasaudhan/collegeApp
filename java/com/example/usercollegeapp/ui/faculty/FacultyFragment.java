package com.example.usercollegeapp.ui.faculty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.usercollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FacultyFragment extends Fragment {

    private RecyclerView csDepartment,mechanicalDepartment,physicsDepartment,chemistryDepartment;
    private LinearLayout csNoData,mechanicalNoData,physicsNoData,chemistryNoData;
    private List<TeacherData> list1,list2,list3,list4;
    private DatabaseReference reference,dbref;
    private TeacherAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_faculty, container, false);
        csDepartment = view.findViewById(R.id.csDepartment);
        mechanicalDepartment = view.findViewById(R.id.mechanicalDepartment);
        physicsDepartment = view.findViewById(R.id.physicsDepartment);
        chemistryDepartment = view.findViewById(R.id.chemistryDepartment);

        chemistryNoData = view.findViewById(R.id.chemistryNoData);
        physicsNoData = view.findViewById(R.id.physicsNoData);
        mechanicalNoData = view.findViewById(R.id.mechanicalNoData);
        csNoData = view.findViewById(R.id.csNoData);

        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        mechanicalDepartment();
        physicsDepartment();
        chemistryDepartment();
        return view;
    }
    private void csDepartment() {
        dbref = reference.child("Computer Science");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1=new ArrayList<>();
                if(!snapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }
                else
                {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1,getContext(),"Computer Science");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void mechanicalDepartment() {
        dbref = reference.child("Mechanical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2=new ArrayList<>();
                if(!snapshot.exists()){
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }
                else
                {
                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2,getContext(),"Mechanical");
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void physicsDepartment() {
        dbref = reference.child("Physics");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3=new ArrayList<>();
                if(!snapshot.exists()){
                    physicsNoData.setVisibility(View.VISIBLE);
                    physicsDepartment.setVisibility(View.GONE);
                }
                else
                {
                    physicsNoData.setVisibility(View.GONE);
                    physicsDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    physicsDepartment.setHasFixedSize(true);
                    physicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3,getContext(),"Physics");
                    physicsDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void chemistryDepartment() {
        dbref = reference.child("Chemistry");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4=new ArrayList<>();
                if(!snapshot.exists()){
                    chemistryNoData.setVisibility(View.VISIBLE);
                    chemistryDepartment.setVisibility(View.GONE);
                }
                else
                {
                    chemistryNoData.setVisibility(View.GONE);
                    chemistryDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot1:snapshot.getChildren()){
                        TeacherData data = snapshot1.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    chemistryDepartment.setHasFixedSize(true);
                    chemistryDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4,getContext(),"Chemistry");
                    chemistryDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}