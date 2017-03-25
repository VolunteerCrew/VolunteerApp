package com.example.cc_3.volunteerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEntryActivity extends AppCompatActivity {

    private EditText mSponsorField;
    private EditText mTitleField;

    private Button mUploadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        // Grabbing the button from the layout
        mUploadButton = (Button) findViewById(R.id.upload_data);

        // Grabbing references to the EditTexts inside the layout
        mSponsorField = (EditText) findViewById(R.id.sponsor_field);
        mTitleField = (EditText) findViewById(R.id.title_field);

        mUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sponsor = mSponsorField.getText().toString();
                String title = mTitleField.getText().toString();

                OppDataModel commData = new OppDataModel(
                        sponsor,
                        title,
                        "7801 Candelaria Rd NE",
                        "575-914-1826",
                        "Help with Food Drive at Sandia High School",
                        "Tomorrow",
                        "The Day After Tomorrow"
                );

            }
        });
    }
}
