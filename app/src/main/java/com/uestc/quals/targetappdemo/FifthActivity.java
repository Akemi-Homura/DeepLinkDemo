package com.uestc.quals.targetappdemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class FifthActivity extends AppCompatActivity {
    private static final String TAG = FifthActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Log.e(TAG, "scheme:" + intent.getScheme());
        Uri uri = intent.getData();
        if (uri == null) {
            return;
        }
        ((TextView) findViewById(R.id.info)).setText(uri.toString());
        Log.e(TAG, "scheme: " + uri.getScheme());
        Log.e(TAG, "host: " + uri.getHost());
        Log.e(TAG, "port: " + uri.getPort());
        Log.e(TAG, "path: " + uri.getPath());
        Log.e(TAG, "queryString: " + uri.getQuery());
        Log.e(TAG, "queryParameter: " + uri.getQueryParameter("func"));

    }
}
