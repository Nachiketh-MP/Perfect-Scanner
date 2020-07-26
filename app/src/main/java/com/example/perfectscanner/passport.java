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

public class passport extends AppCompatActivity {
    private static final int REQUEST_CAMERA =1000 ;
    ImageView passportImg, docs_passport;
    Uri images_passport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);
        Toast.makeText(this, "Click on + to open Camera", Toast.LENGTH_LONG).show();
        passportImg=findViewById(R.id.passport_img);
        docs_passport=findViewById(R.id.docs_passport);

        passportImg.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCameraPerviewPassport();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(passport.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA);

                }

            }
        });
        docs_passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent docs= new Intent(passport.this,MainActivity.class);
                startActivity(docs);
                finish();
            }
        });
    }
    private void showCameraPerviewPassport() {
        ContentValues values_passport = new ContentValues();
        values_passport.put(MediaStore.Images.Media.TITLE, "New Picture");
        images_passport = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values_passport);
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camera.putExtra(MediaStore.EXTRA_OUTPUT, images_passport);
        startActivityForResult(camera, 100);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            passportImg.setImageURI(images_passport);
        }
    }
}