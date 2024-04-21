package com.example.tugaskelompok;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText nik, nama, tempatLahir, tanggalLahir, alamat, email, telpon;
    private RadioGroup jenisKelamin;
    private RadioButton pilihanJenisKelamin;
    private String inputNik, inputNama, inputPilihanJenisKelamin, inputTempatLahir, inputTanggalLahir, inputAlamat, inputEmail, inputTelpon;
    private Button button;
    private int idPilihanJenisKelamin, tahun, bulan, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nik = findViewById(R.id.nikText);
        nama = findViewById(R.id.namaText);
        jenisKelamin = findViewById(R.id.jenisKelamin);
        tempatLahir = findViewById(R.id.tempatLahirText);
        tanggalLahir = findViewById(R.id.tanggalLahirText);
        alamat = findViewById(R.id.alamatText);
        email = findViewById(R.id.emailText);
        telpon = findViewById(R.id.telponText);
        button = findViewById(R.id.buttonSend);

        tanggalLahir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar kalender = Calendar.getInstance();
                tahun = kalender.get(Calendar.YEAR);
                bulan = kalender.get(Calendar.MONTH);
                tanggal = kalender.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tahun = year;
                        bulan = month;
                        tanggal = dayOfMonth;

                        tanggalLahir.setText(tanggal + "-" + bulan + "-" + tahun);
                    }
                }, tahun, bulan, tanggal);
                dialog.show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idPilihanJenisKelamin = jenisKelamin.getCheckedRadioButtonId();
                pilihanJenisKelamin = findViewById(idPilihanJenisKelamin);

                inputNik = nik.getText().toString();
                inputNama = nama.getText().toString();
                inputPilihanJenisKelamin = pilihanJenisKelamin.getText().toString();
                inputTempatLahir = tempatLahir.getText().toString();
                inputTanggalLahir = tanggalLahir.getText().toString();
                inputAlamat = alamat.getText().toString();
                inputEmail = email.getText().toString();
                inputTelpon = telpon.getText().toString();

                Intent kirim = new Intent(MainActivity.this, SecondActivity.class);
                kirim.putExtra("nik", inputNik);
                kirim.putExtra("nama", inputNama);
                kirim.putExtra("jenisKelamin", inputPilihanJenisKelamin);
                kirim.putExtra("tempatLahir", inputTempatLahir);
                kirim.putExtra("tanggalLahir", inputTanggalLahir);
                kirim.putExtra("alamat", inputAlamat);
                kirim.putExtra("email", inputEmail);
                kirim.putExtra("telpon", inputTelpon);
                startActivity(kirim);
            }
        });
    }
}