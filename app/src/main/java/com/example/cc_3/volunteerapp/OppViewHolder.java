package com.example.cc_3.volunteerapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by johnborden on 3/28/17.
 */

public class OppViewHolder {

    TextView mSponsor;

    public OppViewHolder(Context context, ViewGroup parent, View convertView) {

        mSponsor = (TextView) convertView.findViewById(R.id.sponsor);
    }

    public void populateLayout(OppDataModel opp) {

        mSponsor.setText(opp.sponsor);

    }

}
