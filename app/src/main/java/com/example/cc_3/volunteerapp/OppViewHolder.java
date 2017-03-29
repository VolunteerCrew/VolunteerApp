package com.example.cc_3.volunteerapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by johnborden on 3/28/17.
 */

public class OppViewHolder {

    TextView mSponsor;
    TextView mTitles;
    TextView mDescription;
    TextView mAddress;
    TextView mPhoneNumber;
    TextView mDateCreated;
    TextView mDateExpires;

    public OppViewHolder(Context context, ViewGroup parent, View convertView) {

        mSponsor = (TextView) convertView.findViewById(R.id.sponsor);
        mTitles = (TextView) convertView.findViewById(R.id.title);
        mDescription = (TextView) convertView.findViewById(R.id.description);
        mAddress = (TextView) convertView.findViewById(R.id.address);
        mPhoneNumber = (TextView) convertView.findViewById(R.id.phoneNumber);
        mDateCreated = (TextView) convertView.findViewById(R.id.dateCreated);
        mDateExpires = (TextView) convertView.findViewById(R.id.dateExpires);
    }

    public void populateLayout(OppDataModel opp) {

        mSponsor.setText(opp.sponsor);
        mTitles.setText(opp.title);
        mDescription.setText(opp.description);
        mAddress.setText(opp.address);
        mPhoneNumber.setText(opp.phoneNumber);
        mDateCreated.setText(opp.dateCreated);
        mDateExpires.setText(opp.dateExpires);

    }

}
