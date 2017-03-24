package com.example.cc_3.volunteerapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by PM57M on 3/23/2017.
 */

public class SportsFragment extends Fragment {

    FloatingActionButton mAddButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sports, container, false);

        mAddButton = (FloatingActionButton) rootView.findViewById(R.id.add_new_opportunity);
        mAddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String key = ((MainActivity) getActivity()).mDatabase.getReference().push().getKey();

                OppDataModel commData = new OppDataModel(
                        "Jose Vargas",
                        "ABQ Little League",
                        "7892 Able Rd SE",
                        "505-358-5772",
                        "Need Neutral Umpire for Championship Match",
                        "Tomorrow",
                        "The Day After Tomorrow"
                );

                Map<String, Object> commValues = commData.toMap();

                Map<String, Object> childUpdates = new HashMap<>();
                childUpdates.put("/sports/" + key, commValues);
                ((MainActivity) getActivity()).mDatabase.getReference()
                        .updateChildren(childUpdates);

                // These two below are just left behind as examples
                //childUpdates.put("/grassroots/" + key, commValues);
                //childUpdates.put("/sports-events/" + key, commValues);
            }
        });
        return rootView;
        }
}
