package com.example.impotslocaux;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Déclaration des champs
    private EditText nomInput, adresseInput, surfaceInput, piecesInput;
    private CheckBox piscineCheckbox;
    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Liaison XML <-> Java
        nomInput = findViewById(R.id.input_nom);
        adresseInput = findViewById(R.id.input_adresse);
        surfaceInput = findViewById(R.id.input_surface);
        piecesInput = findViewById(R.id.input_pieces);
        piscineCheckbox = findViewById(R.id.checkbox_piscine);
        resultView = findViewById(R.id.result);

        Button btnCalcul = findViewById(R.id.button_calcul);
        btnCalcul.setOnClickListener(v -> calculer());
    }

    private void calculer() {

        // Récupération des données
        String nom = nomInput.getText().toString().trim();
        String adresse = adresseInput.getText().toString().trim();
        double surface = Double.parseDouble(surfaceInput.getText().toString());
        int pieces = Integer.parseInt(piecesInput.getText().toString());
        boolean piscine = piscineCheckbox.isChecked();

        // Calcul des impôts
        double impotBase = surface * 2; // formule de base
        double supplement = pieces * 50 + (piscine ? 100 : 0);
        double total = impotBase + supplement;

        // Affichage formaté comme dans la capture
        String resultat =
                "Nom : " + nom +
                        "\nAdresse : " + adresse +
                        "\n\nImpôt de base  : " + impotBase +
                        "\nimpôt supplémentaire : " + supplement +
                        "\nimpôt Total  : " + total;

        resultView.setText(resultat);
    }
}