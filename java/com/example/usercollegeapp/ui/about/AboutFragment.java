package com.example.usercollegeapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.usercollegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;
    private ImageView ImageView;
    private ImageView aboutmap;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view= inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.computer,"Computer Science Engineering","Computer science. Computer science (sometimes called computation science or computing science, but not to be confused with computational science or software engineering) is the study of processes that interact with data and that can be represented as data in the form of programs."));
        list.add(new BranchModel(R.drawable.wrench,"Mechanical Engineering","Mechanical engineers develop, design, build, test, and inspect mechanical devices and systems, such as machines, tools, and engines. Since mechanical engineering is a very broad field"));
        list.add(new BranchModel(R.drawable.astronomer,"AeroSpace Engineering","Aerospace engineering, also called aeronautical engineering, or astronautical engineering, field of engineering concerned with the design, development, construction, testing, and operation of vehicles operating in the Earth’s atmosphere or in outer space."));
        list.add(new BranchModel(R.drawable.lightbulb,"Electrical Engineering","An Electrical Engineer, or Electronics Engineer, is responsible for developing electrical devices and testing them for safety and efficiency."));
        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView = view.findViewById(R.id.college_image);
        Glide.with(getContext())
                .load("https://www.timeshighereducation.com/sites/default/files/institution/header_image/header-image_0.jpg")
                .into(ImageView);

        //+//Opening Map:->>
        aboutmap=view.findViewById(R.id.aboutmap);
        aboutmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        return view;
    }
    private void openMap()
    {
        Uri uri = Uri.parse("geo:0, 0?q= Vellore Institute of Technology vellore");
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}