package com.example.selectvolley;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class detailmonitoringMainActivity<PNG> extends AppCompatActivity {
    public static final String URLSELECTM = "http://192.168.56.2/PROJEK/SELECTINDI.php";
    TextView idmtext, tglmtext,nistext, jamtext, kegiatantext, lokasitext, usertext;
    String idmtextA, tglmtextA,nistextA, jamtextA, kegiatantextA, lokasitextA, usertextA;
    TextView fototext;
    Drawable fototextA;



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
        fototext = findViewById(R.id.foto2);


        idmtextA = getIntent().getStringExtra("idm");
        tglmtextA = getIntent().getStringExtra("tglm");
        nistextA = getIntent().getStringExtra("nis");
        jamtextA = getIntent().getStringExtra("jam");
        kegiatantextA = getIntent().getStringExtra("kegiatan");
        lokasitextA = getIntent().getStringExtra("lokasi");
        usertextA = getIntent().getStringExtra("user");
//        fototextA = getIntent()d.get("foto");

        idmtext.setText(idmtextA);
        tglmtext.setText(tglmtextA);
        nistext.setText(nistextA);
        jamtext.setText(jamtextA);
        kegiatantext.setText(kegiatantextA);
        lokasitext.setText(lokasitextA);
        usertext.setText(usertextA);
//        fototext.set(fototextA);



}

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 100){
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//
//        }
//    }

    }

