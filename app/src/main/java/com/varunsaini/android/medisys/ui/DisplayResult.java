package com.varunsaini.android.medisys.ui;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.varunsaini.android.medisys.R;

public class DisplayResult extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);

        imageView = findViewById(R.id.imageView);

//        Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("BitmapImage");
//        imageView.setImageBitmap(bitmap);

        Bitmap b = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra("byteArray"),0,getIntent().getByteArrayExtra("byteArray").length);
        imageView.setImageBitmap(b);

    }
}
