package eco.lab.practicasemana5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    private TextView resultadosT;
    private TextView finalT;
    private String nombreM;
    private String notaFinalM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        nombreM = getIntent().getExtras().getString("nombreMostrar");
        notaFinalM = getIntent().getExtras().getString("mostrarFinal");

        resultadosT = findViewById(R.id.resultadosT);
        finalT = findViewById(R.id.finalT);

        resultadosT.setText("Resultados para " + nombreM);
        finalT.setText("Total: " + notaFinalM);
    }
}
