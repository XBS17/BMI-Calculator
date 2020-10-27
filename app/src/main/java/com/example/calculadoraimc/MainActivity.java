package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final float[] IMC = new float[1];
        final Button btnCalcular= (Button)findViewById(R.id.btnCalcular);
        imagen = (ImageView) findViewById(R.id.imagen);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editPeso = (TextView) findViewById(R.id.editPeso);
                TextView editAltura = (TextView) findViewById(R.id.editAltura);
                TextView resultado = (TextView) findViewById(R.id.resultado);
                TextView descripcion = (TextView) findViewById(R.id.descripcion);
                int peso = Integer.parseInt(editPeso.getText().toString());
                float altura = Float.parseFloat(editAltura.getText().toString());
                IMC[0] = peso / (altura * altura);




                    if (IMC[0] < 18.5) {
                        resultado.setText(IMC[0] + "");
                        imagen.setImageResource(R.drawable.bajpeso);
                        descripcion.setText("Estás en bajo peso.");
                    } else {
                        if (IMC[0] < 25) {
                            resultado.setText(IMC[0] + "");
                            imagen.setImageResource(R.drawable.normal);
                            descripcion.setText("Estás en el peso normal.");

                        } else {
                            if (IMC[0] < 30) {
                                resultado.setText(IMC[0] + "");
                                imagen.setImageResource(R.drawable.sobrepeso);
                                descripcion.setText("Tienes sobrepeso.");
                            } else {
                                resultado.setText(IMC[0] + "");
                                imagen.setImageResource(R.drawable.obesidad);
                                descripcion.setText("Tienes obesidad.");
                            }
                        }
                    }

            }

        });

    }
}