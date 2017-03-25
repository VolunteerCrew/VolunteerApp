package com.example.cc_3.volunteerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEntryActivity extends AppCompatActivity {

    private EditText mSponsorField;
    private EditText mTitleField;
    private EditText mAddressField;
    private EditText mPhoneField;
    private EditText mDescriptionField;
    private EditText mCreatedField;


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
        mAddressField = (EditText) findViewById(R.id.addr_field);
        mPhoneField = (EditText) findViewById(R.id.phone_field);
        mDescriptionField = (EditText) findViewById(R.id.desc_field);
        mCreatedField = (EditText) findViewById(R.id.created);


        mUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sponsor = mSponsorField.getText().toString();
                String title = mTitleField.getText().toString();
                String address = mAddressField.getText().toString();
                String phone = mPhoneField.getText().toString();
                String description = mDescriptionField.getText().toString();
                String created = mCreatedField.getText().toString();

                OppDataModel commData = new OppDataModel(
                        sponsor,
                        title,
                        address,
                        phone,
                        description,
                        created,
                        "The Day After Tomorrow"
                );

            }
        });
    }
}
