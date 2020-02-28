package eco.lab.practicasemana5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button registroBtn;
    private EditText nombreT;
    private CheckBox hombreCheck;
    private CheckBox mujerCheck;
    private Switch botSwitch;
    private ProgressBar progresoBar;

    private RatingBar starRate;

    private TextView selecEstrellaT;

    private int randomContador;
    private int progresoTotal;

    private boolean aumentoNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        progresoTotal = 0;
        randomContador = (int) (5 * Math.random()) + 1;

        aumentoNombre = false;

        progresoBar = findViewById(R.id.progresoBar);
        progresoBar.setProgress(progresoTotal);

        nombreT = findViewById(R.id.nombreT);

        selecEstrellaT = findViewById(R.id.selecEstrellaT);
        selecEstrellaT.setText("Escoge " + randomContador + " estrellas");

        //starRate.findViewById(R.id.starRate);

        hombreCheck = findViewById(R.id.hombreCheck);
        mujerCheck = findViewById(R.id.mujerCheck);

        botSwitch = findViewById(R.id.botSwitch);

        registroBtn = findViewById(R.id.registroBtn);


        //Cambiar progreso al escribir el nombre
        nombreT.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!aumentoNombre && nombreT.getText().toString().length() > 0) {
                    progresoTotal += 25;
                    aumentoNombre = true;
                }

                if (aumentoNombre && nombreT.getText().toString().length() == 0) {
                    progresoTotal -= 25;
                    aumentoNombre = false;
                }

                progresoBar.setProgress(progresoTotal);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //Cambiar progreso al elegir un genero
        hombreCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (hombreCheck.isChecked()) {
                    mujerCheck.setChecked(false);
                    progresoTotal += 25;

                } else if (!hombreCheck.isChecked()) {
                    progresoTotal -= 25;
                }

                progresoBar.setProgress(progresoTotal);
            }
        });

        mujerCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (mujerCheck.isChecked()) {
                    hombreCheck.setChecked(false);
                    progresoTotal += 25;

                } else if (!mujerCheck.isChecked()) {
                    progresoTotal -= 25;
                }

                progresoBar.setProgress(progresoTotal);
            }
        });

        //Cambiar progreso al activar el switch
        botSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (botSwitch.isChecked()) {
                    progresoTotal += 25;
                } else {
                    progresoTotal -= 25;
                }
                progresoBar.setProgress(progresoTotal);
            }
        });

        /*starRate.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                int estrella = starRate.getNumStars();
                if (estrella == randomContador) {
                    progresoTotal += 25;
                } else {
                    //progresoTotal -= 25;
                }
                progresoBar.setProgress(progresoTotal);
            }
        });*/

        registroBtn.setOnClickListener(
                (v) -> {
                    String nombreGuardar = nombreT.getText().toString();

                    Intent i = new Intent(MainActivity.this, Calificaciones.class);
                    i.putExtra("nombre", nombreGuardar);
                    startActivity(i);
                }
        );
    }
}
