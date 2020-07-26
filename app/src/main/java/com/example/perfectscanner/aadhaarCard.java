package com.example.perfectscanner;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URI;

public class aadhaarCard extends AppCompatActivity {
    private static final int REQUEST_CAMERA =1000 ;
    ImageView frontImg, BackImg, docs_aadhar;
    Uri images_uri, images_uri_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhaar_card);
        Toast.makeText(this, "Click on + to open Camera", Toast.LENGTH_LONG).show();
        frontImg=findViewById(R.id.frontImg);
        BackImg=findViewById(R.id.backImg);
        docs_aadhar=findViewById(R.id.docs_aadharCard);

        frontImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerview();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(aadhaarCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        BackImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerview2();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(aadhaarCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        docs_aadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docs= new Intent(aadhaarCard.this,MainActivity.class);
                startActivity(docs);
                finish();
            }
        });
    }

    private void showCameraPerview() {
        ContentValues values= new ContentValues();
        values.put(MediaStore.Images.Media.TITLE,"New Picture");
        images_uri= getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        Intent camera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,images_uri);
        startActivityForResult(camera,100);
    }
    private void showCameraPerview2() {
        ContentValues values2 = new ContentValues();
        values2.put(MediaStore.Images.Media.TITLE, "New Picture");
        images_uri_2 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values2);
        Intent camera2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera2.putExtra(MediaStore.EXTRA_OUTPUT, images_uri_2);
        startActivityForResult(camera2, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                frontImg.setImageURI(images_uri);
            } else if (requestCode == 101) {
                BackImg.setImageURI(images_uri_2);
            }
        }
    }

}