package com.example.davidwolfs.projet_annonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class RechercheArticlePrixActivity extends AppCompatActivity {

    private Button btnRetour;
    private Button btnRechercherParPrix;
    private EditText eTxtPrixMin;
    private EditText eTxtPrixMax;
    private TextView txtVMsgError;
    private ListView listView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_article_prix);

        this.btnRetour=(Button)findViewById(R.id.btnRetour);
        this.eTxtPrixMin=(EditText)findViewById(R.id.eTxtPrixMin);
        this.eTxtPrixMax=(EditText)findViewById(R.id.eTxtPrixMax);
        this.btnRechercherParPrix=(Button)findViewById(R.id.btnRechercherParPrix);
        this.txtVMsgError=(TextView)findViewById(R.id.txtVMsgError);
        this.listView=(ListView)findViewById(R.id.listView);

        btnRechercherParPrix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double prixMin = Double.parseDouble(eTxtPrixMin.getText().toString());
                double prixMax = Double.parseDouble(eTxtPrixMax.getText().toString());

                Intent otherActivity = new Intent(getApplicationContext(), AfficherArticleParPrixActivity.class);
                otherActivity.putExtra("PRIXMIN", prixMin+"");
                otherActivity.putExtra("PRIXMAX", prixMax+"");
                startActivity(otherActivity);
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
        if (!(eTxtPrixMin.getText().length() == 0) &&
                (!(eTxtPrixMax.getText().length() == 0)))
        {
            res = true;
        } else {
            txtVMsgError.setText("Tous les champs (*) sont obligatoires.");
            res = false;
        }
        System.out.println("OK METHOD IS VALID");
        return res;
    }
}
