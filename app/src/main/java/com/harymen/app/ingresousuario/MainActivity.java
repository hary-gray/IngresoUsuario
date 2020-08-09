package com.harymen.app.ingresousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etCell;
    private EditText etMail;
    private EditText etDescription;
    private TextView tvFecha;
    private DatePicker dpMyPicker;
    private int year;
    private int month;
    private int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etCell=(EditText) findViewById(R.id.etCell);
        etMail=(EditText) findViewById(R.id.etMail);
        etDescription=(EditText) findViewById(R.id.etDescription);
        tvFecha=(TextView) findViewById(R.id.tvFecha);
        dpMyPicker=(DatePicker) findViewById(R.id.dpMyPicker);

        year=dpMyPicker.getYear();
        month=dpMyPicker.getMonth();
        day=dpMyPicker.getDayOfMonth();
        Bundle parametros = getIntent().getExtras();
        try {
            String name     = parametros.getString(getResources().getString(R.string.fullName));
            String date     =parametros.getString(getResources().getString(R.string.dateOfBird));
            String mail     =parametros.getString(getResources().getString(R.string.eMail));
            String cel      =parametros.getString(getResources().getString(R.string.cellNumber));
            String comment  =parametros.getString(getResources().getString(R.string.comentary));
            String dob = date;

            year =parametros.getInt(getResources().getString(R.string.year));
            month =parametros.getInt(getResources().getString(R.string.month));
            day =parametros.getInt(getResources().getString(R.string.day));

            etNombre.setText(name);
            etCell.setText(cel);
            etMail.setText(mail);
            etDescription.setText(comment);
            tvFecha.setText(dob);
        }catch (Exception e){}

        dpMyPicker.init(year, month ,day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                tvFecha.setText(i+ "/" + (i1 +1) + "/" + i2);
            }
        });
        tvFecha.setText(year + "/" + (month +1) + "/" + day);
    }
    public void nextPage(View v) {
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        DatePicker dpMyPicker= (DatePicker) findViewById(R.id.dpMyPicker);
        year = dpMyPicker.getYear();
        month = dpMyPicker.getMonth() ;
        day = dpMyPicker.getDayOfMonth() ;
        String  date = year + "/" + (month+1) + "/" + day;
        EditText etCell = (EditText) findViewById(R.id.etCell);
        EditText etMail= (EditText) findViewById(R.id.etMail);
        EditText etDescription= (EditText) findViewById(R.id.etDescription);
        Intent intent=new Intent(this,ConfirmarUsurio.class);
        intent.putExtra(getResources().getString(R.string.fullName),etNombre.getText().toString() );
        intent.putExtra(getResources().getString(R.string.cellNumber),etCell.getText().toString());
        intent.putExtra(getResources().getString(R.string.eMail),etMail.getText().toString());
        intent.putExtra(getResources().getString(R.string.comentary),etDescription.getText().toString());
        intent.putExtra(getResources().getString(R.string.dateOfBird),date);
        intent.putExtra(getResources().getString(R.string.year),year);
        intent.putExtra(getResources().getString(R.string.month),month);
        intent.putExtra(getResources().getString(R.string.day),day);
        startActivity(intent);
    }

}