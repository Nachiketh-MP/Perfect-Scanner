package com.example.perfectscanner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class option extends AppCompatActivity {
    private static final int REQUEST_CAMERA_CODE =200 ;
    ImageView aadharCard, voterId, passport, panCard, idCard, singleDoc, multipleDocs, book,photo;
    TextView aadharCardText, voterIDText, passportText, panCardText, idCardText, singleDocText, multipleDocsText, bookText ,photoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        singleDoc=findViewById(R.id.single_doc);
        photo=findViewById(R.id.photo);
        multipleDocs=findViewById(R.id.multiple_doc);
        book=findViewById(R.id.book);
        aadharCard=findViewById(R.id.aadhar_card);
        voterId=findViewById(R.id.voter_id);
        passport=findViewById(R.id.passport);
        panCard=findViewById(R.id.pan_card);
        idCard=findViewById(R.id.id_card);
        aadharCardText=findViewById(R.id.aadhar_card_text);
        voterIDText=findViewById(R.id.voter_id_text);
        passportText=findViewById(R.id.passport_text);
        panCardText=findViewById(R.id.pan_card_text);
        idCardText=findViewById(R.id.id_card_text);
        singleDocText=findViewById(R.id.single_doc_text);
        multipleDocsText=findViewById(R.id.multiple_doc_text);
        bookText=findViewById(R.id.book_text);
        photoText=findViewById(R.id.photo_text);


        aadharCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAadharActivity();
                finish();
            }
        });
        aadharCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startAadharActivity();
                finish();
            }
        });
        voterId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoterIDActivity();
                finish();
            }
        });
        voterIDText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startVoterIDActivity();
                finish();
            }
        });
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPassportActivity();
                finish();
            }
        });
        passportText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPassportActivity();
                finish();
            }
        });
        panCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPanCardActivity();
                finish();
            }
        });
        panCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPanCardActivity();
                finish();
            }
        });
        idCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIDCardActivity();
                finish();
            }
        });
        idCardText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startIDCardActivity();
                finish();
            }
        });
        singleDoc.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                        if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                            showCamera();
                            finish();
                        }
                        else{
                            if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                                Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                            }
                            requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                        }
                    }
                });
        singleDocText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });

        multipleDocs.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });
        multipleDocsText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });
        bookText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });
        photoText.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                    showCamera();
                    finish();
                }
                else{
                    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)){
                        Toast.makeText(option.this, "Camera Permission Needed", Toast.LENGTH_SHORT).show();
                    }
                    requestPermissions(new String[]{Manifest.permission.CAMERA},REQUEST_CAMERA_CODE);

                }
            }
        });

    }

    private void showCamera() {
        Intent i_camera= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(i_camera);

    }

    public void startPanCardActivity(){
        Intent i_panCard= new Intent(option.this,panCard.class);
        startActivity(i_panCard);
    }
    public void startPassportActivity(){
        Intent i_passport= new Intent(option.this,passport.class);
        startActivity(i_passport);
    }
    public void startVoterIDActivity(){
        Intent i_voterID= new Intent(option.this,voterID.class);
        startActivity(i_voterID);
    }
    public void startAadharActivity(){
        Intent i= new Intent(option.this,aadhaarCard.class);
        startActivity(i);
    }
    public void startIDCardActivity(){
        Intent i_idCard= new Intent(option.this,idCard.class);
        startActivity(i_idCard);
    }

}