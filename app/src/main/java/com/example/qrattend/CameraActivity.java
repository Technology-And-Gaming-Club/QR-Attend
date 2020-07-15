package com.example.qrattend;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CameraActivity extends AppCompatActivity {

    public static final int CAMERA_PIC_REQ = 1;
    public static final int GALLERY_REQ = 2;
    public static final int RESULT_CAM = 3;
    public static final int RESULT_GAL = 0;
    Bitmap imageData;
    ImageView image;
    String currentImagePath;
    File photoFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void TakePictureButtonClick(View v) {
        Intent pic = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        photoFile = null;
        try {
            photoFile = createImageFile();
        } catch (IOException ex) {
            //File creation error
        }
        if (photoFile != null) {
            Uri PhotoURI = FileProvider.getUriForFile(this, "com.example.android.fileprovider", photoFile);
            pic.putExtra(MediaStore.EXTRA_OUTPUT, PhotoURI);
            startActivityForResult(pic, CAMERA_PIC_REQ);
        }
    }

    public void GalleryButtonClick(View v1) {
        openGallery();
    }

    public void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, GALLERY_REQ);
    }

    private File createImageFile() throws IOException {
        String TimeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + TimeStamp + "_";
        File StorageDirectory = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", StorageDirectory);
        currentImagePath = image.getAbsolutePath();
        return image;
    }

    private void AddtoGallery() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(currentImagePath);
        Uri contentUri = Uri.fromFile(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    private void loadImageFromStorage(String path) {

        try {
            File f = new File(path, "");
            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
            ImageView img = findViewById(R.id.CameraImage);
            img.setImageBitmap(b);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_PIC_REQ) {
            loadImageFromStorage(currentImagePath);
            AddtoGallery();
        } else {
            ImageView image = findViewById(R.id.CameraImage);
            Uri imageuri = data.getData();
            image.setImageURI(imageuri);
        }
    }

    public void AnalyzeButtonClick(View v3) {

    }
}

