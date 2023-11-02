package com.avidesousa.casopracticointensimplicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.avidesousa.casopracticointensimplicitos.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url=binding.txtUrl.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW);
                Intent chooser=Intent.createChooser(i,"elija el navegador");
                i.setData(Uri.parse(url));
                startActivity(i);

            }
        });

        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String coordenadas=binding.txtLatitud.getText().toString();
                coordenadas=","+binding.txtLong.getText().toString();
                Intent i=new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo"+coordenadas));

                Intent chooser=Intent.createChooser(i,"elija el navegador");

                startActivity(chooser);
            }
        });

        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto"+binding.txtEmail.getText().toString()));

                //destinatario

                String[]array_destinatario=new String[]{binding.txtEmail.getText().toString(),"aliciaramos@riberadeltajo.es"};
                i.putExtra(Intent.EXTRA_EMAIL,array_destinatario);

                

            }
        });
    }
}