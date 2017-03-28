package com.example.cc_3.volunteerapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by johnborden on 3/20/17.
 */

public class OrganizationFragment extends Fragment {

    FloatingActionButton mAddButton;

    ListView mList;
    ArrayAdapter mAdapter;
    ArrayList<String> mTitles;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_organization, container, false);

        mAddButton = (FloatingActionButton) rootView.findViewById(R.id.add_new_opportunity);

        mList = (ListView) rootView.findViewById(R.id.list);
        mTitles = new ArrayList<>();
        mAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, mTitles);
        mList.setAdapter(mAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Transition to the NewEntryActivity
                Intent intent = new Intent(getActivity(), NewEntryActivity.class);
                // Give it some extra data informing it which activity called it
                // (And thus, where to upload data to).
                intent.putExtra("FRAGMENT", OrganizationFragment.class.getSimpleName());

                int requestCode = ((MainActivity) getActivity()).NEW_ENTRY_ACTIVITY_CODE;
                startActivityForResult(intent, requestCode);

            }
        });

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        FirebaseDatabase database = ((MainActivity) getActivity()).mDatabase;

        database.getReference("organization").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                // Temporarily store the data inside something called an Iterable
                Iterable<DataSnapshot> opportunities = dataSnapshot.getChildren();

                // Just zero out all the old data
                mTitles.clear();

                // Iterate through the iterable, and for each animal add them to the mAnimals
                // ArrayList
                HashMap<String, Object> child;
                for (DataSnapshot opportunity : opportunities) {

                    child = (HashMap<String, Object>) opportunity.getValue();

                    // Add
                    mTitles.add(child.get("title").toString());

                }

                // Because we zero'd out the data, we need to tell the Adapter that we changed
                // the original data
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
