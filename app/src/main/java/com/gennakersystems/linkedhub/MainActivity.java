package com.gennakersystems.linkedhub;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    private UserQuery mUserQuery;

    private Button mAuthButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userQuery = "users/pizzimenti";
        String ghUrl = "https://api.github.com/" + userQuery;

        if (isNetworkAvailable()) {

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(ghUrl)
                    .build();

            Call call = client.newCall(request);


            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        String jsonData = response.body().string();
                        Log.v(TAG, jsonData);
                        if (response.isSuccessful()) {
                            mUserQuery = getUserDetails(jsonData);
                        } else {
                            alertUserAboutError();
                        }
                    } catch (IOException e) {
                        Log.e(TAG, "Exception caught :) ", e);
                    } catch (JSONException e) {
                        Log.e(TAG, "Exception caught :) ", e);
                    }
                }
            });
        }
        else {
            Toast.makeText(this, R.string.network_unavailable, Toast.LENGTH_LONG).show();
        }


        Log.d(TAG, "Main UI code is running");


        mAuthButton = (Button) findViewById(R.id.authButton);

        mAuthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, linkedInQuery.class);
                startActivity(intent);
            }
        });
    }

    private UserQuery getUserDetails(String jsonData) throws JSONException {
        JSONObject ghUserObj = new JSONObject(jsonData);
        String name = ghUserObj.getString("name");
        Log.i(TAG, "fromJSON: " + name);

        UserQuery userQuery = new UserQuery();
        userQuery.setId(ghUserObj.getInt("id"));
        userQuery.setName(ghUserObj.getString("name"));
        userQuery.setLogin(ghUserObj.getString("login"));
        userQuery.setAvatarUrl(ghUserObj.getString("avatar_url"));
        userQuery.setUrl(ghUserObj.getString("url"));
        userQuery.setHtmlUrl(ghUserObj.getString("html_url"));
        userQuery.setFollowers(ghUserObj.getInt("followers"));
        userQuery.setFollowers(ghUserObj.getInt("following"));
        userQuery.setFollowersUrl(ghUserObj.getString("followers_url"));
        userQuery.setFollowingUrl(ghUserObj.getString("following_url"));
        userQuery.setReposUrl(ghUserObj.getString("repos_url"));

//        causes runtime error, see UserQuery class
//        Log.d(TAG, userQuery.getFormattedDateAcctCreated());

        return userQuery;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    private void alertUserAboutError() {
        AlertDialogFragment dialog = new AlertDialogFragment();
        dialog.show(getFragmentManager(), "error_dialog");
    }
}
