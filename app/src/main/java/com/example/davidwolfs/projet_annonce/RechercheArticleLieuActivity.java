package com.example.davidwolfs.projet_annonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RechercheArticleLieuActivity extends AppCompatActivity {

    private Button btnRetour;
    private Button btnRechercherVille;
    private EditText editTextVille;
    private TextView txtVMsgError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_article_ville);

        this.btnRetour=(Button)findViewById(R.id.btnRetour);
        this.btnRechercherVille=(Button)findViewById(R.id.btnRechercherVille);
        this.editTextVille = (EditText)findViewById(R.id.editTextVille);
        this.txtVMsgError=(TextView)findViewById(R.id.txtVMsgError);

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
            }
        });

        btnRechercherVille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isValid())
                {
                    String ville = editTextVille.getText().toString();
                    RechercherArticleLieu rechercherArticlePrix = new RechercherArticleLieu(ville);
                    //rechercherArticleLieu.execute();
                    Intent otherActivity = new Intent(getApplicationContext(), RechercheArticleLieuActivity.class);
                    startActivity(otherActivity);
                }
            }
        });

        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
            }
        });
    }

    public boolean isValid() {
        boolean res = false;
        if (!(btnRechercherVille.getText().equals("")))
        {
            res = true;
        }
        else
        {
            txtVMsgError.setText("Tous les champs (*) sont obligatoires.");
            res = false;
        }
        System.out.println("OK METHOD IS VALID");
        return res;
    }
}
