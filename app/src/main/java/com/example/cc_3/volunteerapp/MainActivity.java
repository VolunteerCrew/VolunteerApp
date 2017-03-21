package com.example.cc_3.volunteerapp;

import android.content.Intent;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.firebase.ui.auth.ResultCodes;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 123;

    private FragmentTransaction mFragmentTransaction;
    private HomeFragment mHomeFragment;
    private CommunityServiceFragment mCommunityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        // This checks to see if someone is logged in.
        if (auth.getCurrentUser() != null) {
            // already signed in
        } else {

            // not signed in
            startActivityForResult(
                    // Get an instance of AuthUI based on the default app
                    AuthUI.getInstance().createSignInIntentBuilder().build(),
                    RC_SIGN_IN);
        }

        mHomeFragment = new HomeFragment();

        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container, mHomeFragment);
        mFragmentTransaction.commit();
    }

    /**
     * We're going to use this to do something when our authentication activity returns
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {

            IdpResponse response = IdpResponse.fromResultIntent(data);

            // Then this is our AuthUI Activity
            if (resultCode == ResultCodes.OK){
                // TODO: Figure out what we should do if everything works out.
            } else {

                if (response == null) {
                    // TODO: Do something if the user cancels sign in
                }

                if (response.getErrorCode() == ErrorCodes.NO_NETWORK) {
                    Toast.makeText(this, "You Need To Be Connected To The Internet", Toast.LENGTH_LONG).show();
                }

                if (response.getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                    Toast.makeText(this, "Something Unexpected Happened.  Try Again", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void goToCommService() {

        mFragmentTransaction.replace(R.id.fragment_container, mCommunityFragment);
        mFragmentTransaction.commit();

    }
}
