package com.example.paulr.adapterlessonsumsungtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {

    private ImageView albumImage;
    private TextView artist;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        albumImage =  findViewById(R.id.albumImage);
        artist =  findViewById(R.id.artistName);
        description =  findViewById(R.id.artistDescription);

        Intent intent = getIntent();

       // albumImage.setImageResource(intent.getExtra("Imaage"));

        artist.setText(intent.getStringExtra("Name"));
        description.setText(intent.getStringExtra("Description"));
//        Bundle bundle = this.getIntent().getExtras();
//        int pic = bundle.getInt("image");
//        albumImage.setImageResource(pic);


    }
}
