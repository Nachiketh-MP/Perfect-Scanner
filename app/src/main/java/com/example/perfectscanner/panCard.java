package com.example.perfectscanner;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class panCard extends AppCompatActivity {
    private static final int REQUEST_CAMERA =1000 ;
    ImageView front_panCard, Back_panCard, docs_pan;
    Uri images_pan, images_pan_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_card);
        Toast.makeText(this, "Click on + to open Camera", Toast.LENGTH_LONG).show();
        front_panCard=findViewById(R.id.pan_front);
        Back_panCard=findViewById(R.id.pan_back);
        docs_pan=findViewById(R.id.docs_panCard);
        front_panCard.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerviewVoter();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(panCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        Back_panCard.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerviewVoter2();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(panCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        docs_pan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docs= new Intent(panCard.this,MainActivity.class);
                startActivity(docs);
                finish();
            }
        });
    }

    private void showCameraPerviewVoter() {
        ContentValues values_voter= new ContentValues();
        values_voter.put(MediaStore.Images.Media.TITLE,"New Picture");
        images_pan= getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values_voter);
        Intent camera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,images_pan);
        startActivityForResult(camera,100);
    }
    private void showCameraPerviewVoter2() {
        ContentValues values2 = new ContentValues();
        values2.put(MediaStore.Images.Media.TITLE, "New Picture");
        images_pan_2 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values2);
        Intent camera2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera2.putExtra(MediaStore.EXTRA_OUTPUT, images_pan_2);
        startActivityForResult(camera2, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            if (requestCode == 100) {
                front_panCard.setImageURI(images_pan);
            } else if (requestCode == 101) {
                Back_panCard.setImageURI(images_pan_2);
            }
        }
    }

}