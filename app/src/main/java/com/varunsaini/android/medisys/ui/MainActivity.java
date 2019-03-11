package com.varunsaini.android.medisys.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.varunsaini.android.medisys.R;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_PIC_REQUEST = 1 ;
    TextView title;
    TextView scan_tv ,upload_tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title =findViewById(R.id.title);
        scan_tv = findViewById(R.id.scan_tv);
        upload_tv = findViewById(R.id.upload_tv);

        Typeface tf = Typeface.createFromAsset(getAssets(),"fonts/ABOVE.ttf");
        Typeface tf1 = Typeface.createFromAsset(getAssets(),"fonts/Karla-Bold.ttf");
        title.setTypeface(tf);
        scan_tv.setTypeface(tf1);
        upload_tv.setTypeface(tf1);
    }

    public void openCameraToScan(View view) {

        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAMERA_PIC_REQUEST){
            if (resultCode == RESULT_OK) {
//                tv.setText("Got picture!");
                Bitmap b = (Bitmap) data.getExtras().get("data");
                Intent i = new Intent(this,DisplayResult.class);
//                i.putExtra("scannedImage",(Bitmap) data.getExtras().get("data"));
                ByteArrayOutputStream bs = new ByteArrayOutputStream();
//                b.compress(Bitmap.CompressFormat.PNG, 50, bs);
                i.putExtra("byteArray", bs.toByteArray());
                startActivity(i);

            } else if (resultCode == RESULT_CANCELED){
//                tv.setText("Cancelled");
            }
    }
}
}
