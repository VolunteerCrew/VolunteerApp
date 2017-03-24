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
                int requestCode = ((MainActivity) getActivity()).NEW_ENTRY_ACTIVITY_CODE;
                startActivityForResult(intent, requestCode);

                /*
                String key = ((MainActivity) getActivity()).mDatabase.getReference().push().getKey();

                OppDataModel commData = new OppDataModel(
                        "Road Runner Food Bank",
                        "Jared Long",
                        "7801 Candelaria Rd NE",
                        "575-914-1826",
                        "Help with Food Drive at Sandia High School",
                        "Tomorrow",
                        "The Day After Tomorrow"
                );

                Map<String, Object> commValues = commData.toMap();

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/organization/" + key, commValues);
                ((MainActivity) getActivity()).mDatabase.getReference()
                        .updateChildren(childUpdates);

                // These two below are just left behind as examples
                //childUpdates.put("/grassroots/" + key, commValues);
                //childUpdates.put("/sports-events/" + key, commValues);
                */

            }
        });

        return rootView;
    }
}
