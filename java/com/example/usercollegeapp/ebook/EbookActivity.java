package com.example.usercollegeapp.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.usercollegeapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private  EbookAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmer_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //It will set a closing Arrow on the top of Ebook Activity:-
        getSupportActionBar().setTitle("Ebooks");                //it will set the title on the top of Ebook activity instead of User College App:-

        ebookRecycler = findViewById(R.id.ebbokRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
        shimmer_layout = findViewById(R.id.shimmer_layout);


        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    EbookData data = snapshot1.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);

                //stopping shimmer layout:
                shimmerFrameLayout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(EbookActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Methods for Shimmer Layout
    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}