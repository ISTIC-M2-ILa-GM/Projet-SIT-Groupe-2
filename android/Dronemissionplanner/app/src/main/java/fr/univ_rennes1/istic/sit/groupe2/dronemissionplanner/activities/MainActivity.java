package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            OsmFragment osmFragment = new OsmFragment();
            fragmentTransaction.add(R.id.frameOsmFragment, osmFragment);
            fragmentTransaction.commit();
        }

    }
}
