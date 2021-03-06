package com.afreet.campusconnect.Profile;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.afreet.campusconnect.R;

public class OptionsActivity extends AppCompatActivity {
    private static final String TAG = "OptionsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.fragment_name))){
            Log.d(TAG, "getIncomingIntent: Recieved incoming activity "+ intent.getStringExtra(getString(R.string.fragment_name)));
//            setViewPager(pagerAdapter.getFragmentNumber(getString(R.string.edit_profile_fragment)));
            String fragment_name = intent.getStringExtra(getString(R.string.fragment_name));
            if (fragment_name.equals(getString(R.string.fragment_sign_out))){
                SignOutFragment signOutFragment = new SignOutFragment();
                FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, signOutFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();

            } else if (fragment_name.equals(getString(R.string.fragment_user_post))) {
                UserPostFragment userPostFragment = new UserPostFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, userPostFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();

            } else if (fragment_name.equals(getString(R.string.fragment_edit_categories))) {
                EditCategoriesFragment editCategoriesFragment = new EditCategoriesFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, editCategoriesFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();

            }else if(fragment_name.equals(getString(R.string.fragment_about))){
                AboutFragment aboutFragment = new AboutFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, aboutFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();

            } else if (fragment_name.equals(getString(R.string.fragment_feedback))) {
                FeedbackFragment feedbackFragment = new FeedbackFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, feedbackFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();


            } else if (fragment_name.equals(getString(R.string.fragment_terms_and_condition))) {
                Bundle bundle = new Bundle();
                bundle.putString("from", "OA");
                TermsConditionFragment termsConditionFragment = new TermsConditionFragment();
                termsConditionFragment.setArguments(bundle);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, termsConditionFragment);
                transaction.addToBackStack(fragment_name);
                transaction.commit();

            }


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        getSupportFragmentManager().popBackStack();
        finish();
    }
}
