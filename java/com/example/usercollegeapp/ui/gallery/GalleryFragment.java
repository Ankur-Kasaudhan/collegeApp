package com.example.usercollegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.usercollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    private RecyclerView convoRecycler,otherRecycler;
    private  GalleryAdapter adapter;
    private DatabaseReference reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convoRecycler = view.findViewById(R.id.convoRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");
        getConvoImage();
        getOtherImage();
        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                otherRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter=new GalleryAdapter(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),4));
                convoRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}