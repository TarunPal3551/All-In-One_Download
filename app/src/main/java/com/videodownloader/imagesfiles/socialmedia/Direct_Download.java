package com.videodownloader.imagesfiles.socialmedia;

import android.app.DownloadManager;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.videodownloader.imagesfiles.socialmedia.Fragments.MainFrag;

public class Direct_Download extends AppCompatActivity {
    Button download;
    EditText url_edittext;
    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direct__download);
        download=(Button)findViewById(R.id.button_download);
        url_edittext=(EditText)findViewById(R.id.editText_url);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=url_edittext.getText().toString();
               // mainFrag.download(url);
                download(url);

            }
        });
    }
    public void download(String uurl) {
        if (uurl != null) {

            Log.d("URL NOT VALID", String.valueOf(URLUtil.isValidUrl(uurl)));

            if (URLUtil.isValidUrl(uurl)) {


                downloadManager = (DownloadManager) getApplicationContext().getSystemService(getApplicationContext().DOWNLOAD_SERVICE);


                Uri uri = Uri.parse(uurl);
                String name = URLUtil.guessFileName(uurl, null, null);
                DownloadManager.Request req = new DownloadManager.Request(uri);

                req.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI
                        | DownloadManager.Request.NETWORK_MOBILE)
                        .setAllowedOverRoaming(true)
                        .setTitle(name)
                        .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
                        .setDescription("Downloading File")
                        .setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,
                                name);
                downloadManager.enqueue(req);

            } else {
                Toast.makeText(Direct_Download.this, "Invalid Url", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Direct_Download.this, "Invalid Url", Toast.LENGTH_SHORT).show();
        }


    }
}
