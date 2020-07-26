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

public class idCard extends AppCompatActivity {
    private static final int REQUEST_CAMERA =1000 ;
    ImageView frontImgID, BackImgID, docs_id;
    Uri images_id, images_id_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_card);
        Toast.makeText(this, "Click on + to open Camera", Toast.LENGTH_LONG).show();
        frontImgID=findViewById(R.id.front_id);
        BackImgID=findViewById(R.id.back_id);
        docs_id=findViewById(R.id.docs_idCard);
        frontImgID.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerviewVoter();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(idCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        BackImgID.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerviewVoter2();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(idCard.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        docs_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docs= new Intent(idCard.this,MainActivity.class);
                startActivity(docs);
                finish();
            }
        });
    }

    private void showCameraPerviewVoter() {
        ContentValues values_voter= new ContentValues();
        values_voter.put(MediaStore.Images.Media.TITLE,"New Picture");
        images_id= getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values_voter);
        Intent camera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT,images_id);
        startActivityForResult(camera,100);
    }
    private void showCameraPerviewVoter2() {
        ContentValues values2 = new ContentValues();
        values2.put(MediaStore.Images.Media.TITLE, "New Picture");
        images_id_2 = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values2);
        Intent camera2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera2.putExtra(MediaStore.EXTRA_OUTPUT, images_id_2);
        startActivityForResult(camera2, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                frontImgID.setImageURI(images_id);
            } else if (requestCode == 101) {
                BackImgID.setImageURI(images_id_2);
            }
        }
    }

}