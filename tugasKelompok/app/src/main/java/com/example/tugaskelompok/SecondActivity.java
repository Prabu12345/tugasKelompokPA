package com.example.tugaskelompok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tampilNik, tampilNama, tampilJenisKelamin, tampilTempatLahir, tampilTanggalLahir, tampilAlamat, tampilEmail, tampilTelpon;
    private String getNik = "nik", getNama = "nama", getJenisKelamin = "jenisKelamin", getTempatLahir = "tempatLahir", getTanggalLahir = "tanggalLahir", getAlamat = "alamat", getEmail = "email", getTelpon = "telpon";
    private String setNik, setNama, setJenisKelamin, setTempatLahir, setTanggalLahir, setAlamat, setEmail, setTelpon;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tampilNik = findViewById(R.id.nikValue);
        tampilNama = findViewById(R.id.namaValue);
        tampilJenisKelamin = findViewById(R.id.jkValue);
        tampilTempatLahir = findViewById(R.id.tempatLahirValue);
        tampilTanggalLahir = findViewById(R.id.tanggalLahirValue);
        tampilAlamat = findViewById(R.id.alamatValue);
        tampilEmail = findViewById(R.id.emailValue);
        tampilTelpon = findViewById(R.id.telponValue);
        button = findViewById(R.id.buttonSend);

        Intent terima = getIntent();
        setNik = terima.getStringExtra(getNik);
        setNama = terima.getStringExtra(getNama);
        setJenisKelamin = terima.getStringExtra(getJenisKelamin);
        setTempatLahir = terima.getStringExtra(getTempatLahir);
        setTanggalLahir = terima.getStringExtra(getTanggalLahir);
        setAlamat = terima.getStringExtra(getAlamat);
        setEmail = terima.getStringExtra(getEmail);
        setTelpon = terima.getStringExtra(getTelpon);

        tampilNik.setText(setNik);
        tampilNama.setText(setNama);
        tampilJenisKelamin.setText(setJenisKelamin);
        tampilTempatLahir.setText(setTempatLahir);
        tampilTanggalLahir.setText(setTanggalLahir);
        tampilAlamat.setText(setAlamat);
        tampilEmail.setText(setEmail);
        tampilTelpon.setText(setTelpon);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent balik = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(balik);
            }
        });
    }
}