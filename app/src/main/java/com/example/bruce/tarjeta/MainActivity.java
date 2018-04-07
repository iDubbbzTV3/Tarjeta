package com.example.bruce.tarjeta;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickListener(View v) {
        Uri uri = Uri.parse("http://www.github.com/iDubbbzTV3");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onClickListener2(View v) {
        Uri uri = Uri.parse("http://www.twitter.com/BruceMontenegr1");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void onCallListener(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:78716096"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(callIntent);
    }

    public void onMailListener(View v){
        Intent mailClient = new Intent(Intent.ACTION_VIEW);
        mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
        startActivity(mailClient);
    }

    public void shareImage(View v){
        Uri imageuri = Uri.parse("android.resource://com.example.bruce.tarjeta/drawable"+R.drawable.idubbbz);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("intent/*");
        intent.putExtra(Intent.EXTRA_STREAM, imageuri);
    }

}
