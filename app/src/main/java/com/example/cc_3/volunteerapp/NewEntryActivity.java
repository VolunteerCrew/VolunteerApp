package com.example.cc_3.volunteerapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NewEntryActivity extends AppCompatActivity {

    private EditText mSponsorField;
    private EditText mTitleField;
    private EditText mAddressField;
    private EditText mPhoneField;
    private EditText mDescriptionField;
    private EditText mCreatedField;
    private EditText mExpiresField;

    private Button mUploadButton;

    private FirebaseDatabase mDatabase;

    private String callingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);

        callingFragment = getIntent().getExtras().getString("FRAGMENT");

        // Get a connection to the database
        mDatabase = FirebaseDatabase.getInstance();

        // Grabbing the button from the layout
        mUploadButton = (Button) findViewById(R.id.upload_data);

        // Grabbing references to the EditTexts inside the layout
        mSponsorField = (EditText) findViewById(R.id.sponsor_field);
        mTitleField = (EditText) findViewById(R.id.title_field);
        mAddressField = (EditText) findViewById(R.id.address_field);
        mPhoneField = (EditText) findViewById(R.id.phone_field);
        mDescriptionField = (EditText) findViewById(R.id.desc_field);
        mCreatedField = (EditText) findViewById(R.id.created);
        mExpiresField = (EditText) findViewById(R.id.expires);

        mUploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String sponsor = mSponsorField.getText().toString();
                String title = mTitleField.getText().toString();
                String address = mAddressField.getText().toString();
                String phone = mPhoneField.getText().toString();
                String description = mDescriptionField.getText().toString();
                String created = mCreatedField.getText().toString();
                String expires = mExpiresField.getText().toString();

                String key = mDatabase.getReference().push().getKey();

                OppDataModel commData = new OppDataModel(
                        sponsor,
                        title,
                        address,
                        phone,
                        description,
                        created,
                        expires
                );

                Map<String, Object> commValues = commData.toMap();

                Map<String, Object> childUpdates = new HashMap<>();

                if (callingFragment == OrganizationFragment.class.getSimpleName()) {

                    childUpdates.put("/organization/" + key, commValues);

                } else if (callingFragment == GrassrootsFragment.class.getSimpleName()) {

                    childUpdates.put("/grassroots/" + key, commValues);

                } else if (callingFragment == SportsFragment.class.getSimpleName()) {

                    // TODO:

                }

                Task uploadTask = mDatabase.getReference().updateChildren(childUpdates);

                uploadTask.addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {

                        completeForm();
                        return;

                    }
                });

                uploadTask.addOnFailureListener(new OnFailureListener() {

                    @Override
                    public void onFailure(@NonNull Exception e) {
                        failureMessage();
                    }

                });

            }
        });
    }

    private void completeForm() {
        finish();
        return;
    }

    private void failureMessage() {
        Toast.makeText(this, "Couldn't upload data", Toast.LENGTH_LONG).show();
    }
}
