package com.harymen.app.ingresousuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ConfirmarUsurio extends AppCompatActivity {
   private TextView tvConfirmName;
   private TextView  tvConfirmDate;
   private TextView  tvConfirmCell;
   private TextView  tvConfirmMail;
   private TextView  tvConfirmDescription;
    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_usurio);
        Bundle parametros = getIntent().getExtras();
        tvConfirmCell=(TextView) findViewById(R.id.tvConfirmCell);
        tvConfirmName=(TextView) findViewById(R.id.tvConfirmName);
        tvConfirmDate=(TextView) findViewById(R.id.tvConfirmDate);
        tvConfirmMail=(TextView) findViewById(R.id.tvConfirmMail);
        tvConfirmDescription=(TextView) findViewById(R.id.tvConfirmDescription);

        String name= parametros.getString(getResources().getString(R.string.fullName));
        String date=parametros.getString(getResources().getString(R.string.dateOfBird));
        String mail=parametros.getString(getResources().getString(R.string.eMail));
        String cel=parametros.getString(getResources().getString(R.string.cellNumber));
        String comment=parametros.getString(getResources().getString(R.string.comentary));

        tvConfirmName.setText(name);
        tvConfirmDate.setText(date);
        tvConfirmCell.setText(cel);
        tvConfirmMail.setText(mail);
        tvConfirmDescription.setText(comment);
    }
    public void editar(View v){
        Intent intent =new Intent(ConfirmarUsurio.this,MainActivity.class);
        intent.putExtra(getResources().getString(R.string.fullName),tvConfirmName.getText().toString() );
        intent.putExtra(getResources().getString(R.string.cellNumber),tvConfirmCell.getText().toString());
        intent.putExtra(getResources().getString(R.string.eMail),tvConfirmMail.getText().toString());
        intent.putExtra(getResources().getString(R.string.comentary),tvConfirmDescription.getText().toString());
        intent.putExtra(getResources().getString(R.string.dateOfBird),tvConfirmDate.getText().toString());
        startActivity(intent);
    }
}