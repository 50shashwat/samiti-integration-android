package com.kalpvaig.samitilauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static String VIDEO_CONF_URL = "https://secure-meet.kalpvaig.com/";
    private static String PACKAGE_NAME = "com.kalpvaig.samiti";

    private EditText inputUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUrl = findViewById(R.id.input);

        findViewById(R.id.button).setOnClickListener(view ->{
            String url = inputUrl.getText().toString();
            inputUrl.setText("");

            if(url.length()>5)
                connect(url);

        });
    }


    public void connect(String patientDoctorConnectionID){
        Uri myAction = Uri.parse(VIDEO_CONF_URL+patientDoctorConnectionID);

        PackageManager packageManager = getPackageManager();
        Intent intent = packageManager.getLaunchIntentForPackage(PACKAGE_NAME);

        if (intent != null) {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(myAction);
            startActivity(intent);
        }
    }
}
