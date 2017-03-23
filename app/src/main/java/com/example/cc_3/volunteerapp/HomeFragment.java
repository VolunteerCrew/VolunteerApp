package com.example.cc_3.volunteerapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by johnborden on 3/20/17.
 */

public class HomeFragment extends Fragment {

    Button mOrganizaitonBtn;
    Button mGrassrootsBtn;
    Button mSportsBtn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        mOrganizaitonBtn = (Button) rootView.findViewById(R.id.organization_btn);
        mGrassrootsBtn = (Button) rootView.findViewById(R.id.grass_btn);
        mSportsBtn = (Button) rootView.findViewById(R.id.sport_btn);

        mOrganizaitonBtn.setOnClickListener(new BtnListener());
        mGrassrootsBtn.setOnClickListener(new BtnListener());
        mSportsBtn.setOnClickListener(new BtnListener());

        return rootView;
    }

    public class BtnListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int buttonID = v.getId();

            if (buttonID == R.id.organization_btn) {
                ((MainActivity) getActivity()).goToCommService();
            } else if (buttonID == R.id.grass_btn) {
                // TODO:
            } else if (buttonID == R.id.sport_btn) {
                // TODO:
            }

        }
    }
}
