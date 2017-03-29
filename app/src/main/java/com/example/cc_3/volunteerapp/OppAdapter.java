package com.example.cc_3.volunteerapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by johnborden on 3/28/17.
 */

public class OppAdapter extends ArrayAdapter<OppDataModel> {

    Context mContext;
    List<OppDataModel> mOpps;

    public OppAdapter(Context context, List<OppDataModel> opps) {

        super(context, R.layout.list_item_opp, opps);

        mContext = context;
        mOpps = opps;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Object holder;

        if (convertView == null) {
            // First time displaying the list?  Then create convertView
            convertView = LayoutInflater.from(mContext).inflate(R.layout.list_item_opp,
                    parent, false);
            holder = new OppViewHolder(mContext, parent, convertView);
            convertView.setTag(holder);
        } else {
            holder = convertView.getTag();
        }
        ((OppViewHolder) holder).populateLayout(mOpps.get(position));

        // Always return convertView
        return convertView;

    }
}
