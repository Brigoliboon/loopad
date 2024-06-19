package com.example.loopad.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loopad.Hotspot.Hotspot;
import com.example.loopad.Hotspot.HotspotAdapter;
import com.example.loopad.Hotspot.HotspotContainer;
import com.example.loopad.Intfs.OnHotspotClicked;
import com.example.loopad.MainActivity;
import com.example.loopad.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ExploreFragment extends Fragment implements OnHotspotClicked {
    public static ArrayList<HotspotContainer> hotspots = new ArrayList<>();
    RecyclerView hotspotRecyclerView;
    public static HotspotAdapter hotspotAdapter;
    TextView noHotspots;
    SearchView searchView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        hotspotRecyclerView = view.findViewById(R.id.fragment_explore_recycler);
        noHotspots = view.findViewById(R.id.no_hotspots);
        searchView = view.findViewById(R.id.search);

        searchView.setIconified(false);
        dummyData();
        recyclerInit();

        return view;
    }

    private void recyclerInit(){
        if (hotspots.isEmpty()){
            noHotspots.setVisibility(View.VISIBLE);
        } else {
            noHotspots.setVisibility(View.GONE);
            hotspotRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            hotspotAdapter = new HotspotAdapter(requireContext(), hotspots, this::onHotspotClicked);
            hotspotRecyclerView.setAdapter(hotspotAdapter);
        }
    }

    @Override
    public void onHotspotClicked(HotspotContainer hotspotContainer, int position, Context context) {
        Toast.makeText(context, hotspotContainer.getHotspot().getName(), Toast.LENGTH_SHORT).show();
    }


    // TODO: 19/06/2024 DUMMY DATA
    private void dummyData(){
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name1", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name2", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name3", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name4", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name5", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name6", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name7", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name8", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name9", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name0", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name11", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name12", "place")));
        hotspots.add(new HotspotContainer(new Hotspot(R.drawable.ic_launcher_background, "name13", "place")));

    }

    private void setupDb(){
        MainActivity.db = FirebaseDatabase.getInstance().getReference();
        MainActivity.listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
    }
}
