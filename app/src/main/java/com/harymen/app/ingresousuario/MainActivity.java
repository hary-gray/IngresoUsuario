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

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre;
    private EditText etCell;
    private EditText etMail;
    private EditText etDescription;
    private TextView tvFecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=(EditText) findViewById(R.id.etNombre);
        etCell=(EditText) findViewById(R.id.etCell);
        etMail=(EditText) findViewById(R.id.etMail);
        etDescription=(EditText) findViewById(R.id.etDescription);
        tvFecha=(TextView) findViewById(R.id.tvFecha);
        Bundle parametros = getIntent().getExtras();
        try {
            String name     = parametros.getString(getResources().getString(R.string.fullName));
            String date     =parametros.getString(getResources().getString(R.string.dateOfBird));
            String mail     =parametros.getString(getResources().getString(R.string.eMail));
            String cel      =parametros.getString(getResources().getString(R.string.cellNumber));
            String comment  =parametros.getString(getResources().getString(R.string.comentary));
            String dob = tvFecha.getText().toString()+ " "+ date;
            etNombre.setText(name);
            etCell.setText(cel);
            etMail.setText(mail);
            etDescription.setText(comment);
            tvFecha.setText(dob);
        }catch (Exception e){}

    }
    public void nextPage(View v) {
        EditText etNombre = (EditText) findViewById(R.id.etNombre);
        DatePicker dpMyPicker= (DatePicker) findViewById(R.id.dpMyPicker);
        int year = dpMyPicker.getYear();
        int month = dpMyPicker.getMonth() + 1;
        int day = dpMyPicker.getDayOfMonth() ;
        String  date = year + "/" + month + "/" + day;
        EditText etCell = (EditText) findViewById(R.id.etCell);
        EditText etMail= (EditText) findViewById(R.id.etMail);
        EditText etDescription= (EditText) findViewById(R.id.etDescription);
        Intent intent=new Intent(this,ConfirmarUsurio.class);
        intent.putExtra(getResources().getString(R.string.fullName),etNombre.getText().toString() );
        intent.putExtra(getResources().getString(R.string.cellNumber),etCell.getText().toString());
        intent.putExtra(getResources().getString(R.string.eMail),etMail.getText().toString());
        intent.putExtra(getResources().getString(R.string.comentary),etDescription.getText().toString());
        intent.putExtra(getResources().getString(R.string.dateOfBird),date);
        startActivity(intent);
    }
}