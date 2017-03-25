package com.example.cc_3.volunteerapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by johnborden on 3/20/17.
 */

public class OrganizationFragment extends Fragment {

    FloatingActionButton mAddButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_organization, container, false);

        mAddButton = (FloatingActionButton) rootView.findViewById(R.id.add_new_opportunity);

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
}
