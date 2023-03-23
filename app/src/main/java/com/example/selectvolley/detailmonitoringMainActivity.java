package com.example.selectvolley;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailmonitoringMainActivity<PNG> extends AppCompatActivity {
    public static final String URLSELECTM = "http://192.168.1.11/PROJEK/SELECTINDI.php";
    TextView idmtext, tglmtext, nistext, jamtext, kegiatantext, lokasitext, usertext;
    String idmtextA, tglmtextA, nistextA, jamtextA, kegiatantextA, lokasitextA, usertextA, stringImage;
    ImageView gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring_main);


        idmtext = findViewById(R.id.idm2);
        tglmtext = findViewById(R.id.tglmm2);
        nistext = findViewById(R.id.nism2);
        jamtext = findViewById(R.id.jamm2);
        kegiatantext = findViewById(R.id.kegiatanm2);
        lokasitext = findViewById(R.id.lokasim2);
        usertext = findViewById(R.id.user2);
        gambar = findViewById(R.id.foto2);


        idmtextA = getIntent().getStringExtra("idm");
        tglmtextA = getIntent().getStringExtra("tgl");
        nistextA = getIntent().getStringExtra("nis");
        jamtextA = getIntent().getStringExtra("jam");
        kegiatantextA = getIntent().getStringExtra("kegiatan");
        lokasitextA = getIntent().getStringExtra("lokasi");
        usertextA = getIntent().getStringExtra("user");
        stringImage = getIntent().getStringExtra("gambar");


        idmtext.setText(idmtextA);
        tglmtext.setText(tglmtextA);
        nistext.setText(nistextA);
        jamtext.setText(jamtextA);
        kegiatantext.setText(kegiatantextA);
        lokasitext.setText(lokasitextA);
        usertext.setText(usertextA);
//        fototext.set(fototextA);
        byte[] decodedString = Base64.decode(stringImage, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        gambar.setImageBitmap(decodedByte);


    }

}

