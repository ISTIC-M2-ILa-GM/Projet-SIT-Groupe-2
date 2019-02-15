package fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.activities;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.MultiAutoCompleteTextView;

import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.R;
import fr.univ_rennes1.istic.sit.groupe2.dronemissionplanner.utils.NetUtils;
import retrofit2.Retrofit;

public class RestTestActivity extends AppCompatActivity {
    MultiAutoCompleteTextView jsnoBodyTxtView;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_test);
        this.jsnoBodyTxtView = findViewById(R.id.jsonBody);
        this.progressDialog = new ProgressDialog(this);
        this.progressDialog.setCancelable(false);
    }

    public void postMission(View view) {
        new HttpRequestAsync().execute();
    }

    private class HttpRequestAsync extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected void onPreExecute() {
            RestTestActivity.this.progressDialog.show();
            RestTestActivity.this.progressDialog.setMessage("HTTP request is being processed...");
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean result = false;
            Retrofit client = NetUtils.getClient();

            return result;
        }

        @Override
        protected void onPostExecute(Boolean aBool) {
            RestTestActivity.this.progressDialog.dismiss();
        }
    }
}
