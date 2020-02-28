package eco.lab.practicasemana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class Calificaciones extends AppCompatActivity {

    private Button calcularBtn;

    private EditText parcialUno;
    private EditText parcialDos;
    private EditText tallerUno;
    private EditText tallerDos;
    private EditText quicesTeo;
    private EditText quicesPrac;
    private EditText ejerciciosT;
    private EditText proyectoFinal;

    private String nombreGuardar;

    private double notaCalculada;

    double notaParcialUno;
    double notaParcialDos;
    double notaTallerUno;
    double notaTallerDos;
    double notaQuizTeo;
    double notaQuizPrac;
    double notaEjercicios;
    double notaProyecFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calificaciones);

        calcularBtn = findViewById(R.id.calcularBtn);
        nombreGuardar = getIntent().getExtras().getString("nombre");

        parcialUno = findViewById(R.id.parcialUno);
        parcialDos = findViewById(R.id.parcialDos);
        tallerUno = findViewById(R.id.tallerUno);
        tallerDos = findViewById(R.id.tallerDos);
        quicesTeo = findViewById(R.id.quicesTeo);
        quicesPrac = findViewById(R.id.quicesPrac);
        ejerciciosT = findViewById(R.id.ejerciciosT);
        proyectoFinal = findViewById(R.id.proyectoFinal);


        calcularBtn.setOnClickListener(
                (v) -> {

                    if (parcialUno.getText().toString().equals("") && parcialDos.getText().toString().equals("") &&
                            tallerUno.getText().toString().equals("") && tallerDos.getText().toString().equals("") &&
                            quicesTeo.getText().toString().equals("") && quicesPrac.getText().toString().equals("") &&
                            ejerciciosT.getText().toString().equals("") && proyectoFinal.getText().toString().equals("")) {
                        //Log.e("Prueba", "No hay valores");
                        notaParcialUno = 0.0d;
                        notaParcialDos = 0.0d;
                        notaTallerUno = 0.0d;
                        notaTallerDos = 0.0d;
                        notaQuizTeo = 0.0d;
                        notaQuizPrac = 0.0d;
                        notaEjercicios = 0.0d;
                        notaProyecFinal = 0.0d;

                    } else {
                        notaParcialUno = Double.parseDouble(parcialUno.getText().toString());
                        notaParcialDos = Double.parseDouble(parcialDos.getText().toString());
                        notaTallerUno = Double.parseDouble(tallerUno.getText().toString());
                        notaTallerDos = Double.parseDouble(tallerDos.getText().toString());
                        notaQuizTeo = Double.parseDouble(quicesTeo.getText().toString());
                        notaQuizPrac = Double.parseDouble(quicesPrac.getText().toString());
                        notaEjercicios = Double.parseDouble(ejerciciosT.getText().toString());
                        notaProyecFinal = Double.parseDouble(proyectoFinal.getText().toString());

                    }

                    notaCalculada = (notaParcialUno * 0.15) + (notaParcialDos * 0.15) + (notaTallerUno * 0.15)
                            + (notaTallerDos * 0.15) + (notaQuizTeo * 0.10) + (notaQuizPrac * 0.05) + (notaEjercicios * 0.05)
                            + (notaProyecFinal * 0.20);

                    String notaFinal = String.valueOf(notaCalculada);

                    Intent i = new Intent(Calificaciones.this, Resultados.class);
                    i.putExtra("nombreMostrar", nombreGuardar);
                    i.putExtra("mostrarFinal", notaFinal);



                    startActivity(i);

                }
        );
    }
}
