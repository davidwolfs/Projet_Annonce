package com.example.davidwolfs.projet_annonce;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AjouterArticleActivity extends AppCompatActivity {

    private Button btnRetour;
    private Button btnAjouter;
    private EditText eTxtNom;
    private EditText eTxtDescriptifDetaille;
    private EditText eTxtPrix;
    private EditText eTxtVille;
    private TextView txtVMsgError;
    private RadioGroup etat;
    private RadioGroup livraison;
    private RadioButton rBtnNeuf;
    private RadioButton rBtnUtilise;
    private RadioButton rBtnEnvoi;
    private RadioButton rBtnLivraison;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_article);

        etat = (RadioGroup) findViewById(R.id.rGrpEtat);
        livraison = (RadioGroup) findViewById(R.id.rGrpLivraison);
        btnRetour=(Button)findViewById(R.id.btnRetour);
        btnAjouter=(Button)findViewById(R.id.btnAjouter);
        eTxtNom=(EditText)findViewById(R.id.eTxtNom);
        eTxtDescriptifDetaille=(EditText)findViewById(R.id.eTxtDescriptifDetaille);
        eTxtPrix=(EditText)findViewById(R.id.eTxtPrix);
        eTxtVille=(EditText)findViewById(R.id.eTxtVille);
        rBtnNeuf=(RadioButton)findViewById(R.id.rBtnNeuf);
        rBtnUtilise=(RadioButton)findViewById(R.id.rBtnUtilise);
        rBtnEnvoi=(RadioButton)findViewById(R.id.rBtnEnvoi);
        rBtnLivraison=(RadioButton)findViewById(R.id.rBtnLivraison);
        txtVMsgError=(TextView)findViewById(R.id.txtVMsgError);


        btnRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(otherActivity);
            }
        });

        btnAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isValid())
                {
                    System.out.println("ARTICLE AJOUTÉ");
                    Toast.makeText(getApplicationContext(), "ARTICLE AJOUTÉ", Toast.LENGTH_SHORT).show();
                    String nom = eTxtNom.getText().toString();
                    String descriptif = eTxtDescriptifDetaille.getText().toString();
                    double prix = Double.parseDouble(eTxtPrix.getText().toString());
                    String etat =  "";
                    if(rBtnNeuf.isChecked())
                    {
                        etat = "Neuf";
                    }
                    else
                    {
                        etat = "Utilisé";
                    }
                    String ville = eTxtVille.getText().toString();
                    String livraison = "";
                    if(rBtnEnvoi.isChecked())
                    {
                        livraison = "Envoyé";
                    }
                    else
                    {
                        livraison = "Main propres";
                    }

                    CreerArticle article = new CreerArticle(nom, descriptif, prix, etat, ville, livraison);
                    article.execute();
                    Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(otherActivity);
                }
            }
        });
    }

    public boolean isValid()
    {
        boolean res=false;
        if (!(eTxtNom.getText().length()==0) &&
                (!(eTxtDescriptifDetaille.getText().length()==0)) &&
                (!(eTxtPrix.getText().length()==0)) &&
                ((rBtnNeuf.isChecked() || rBtnUtilise.isChecked()) || (rBtnNeuf.isChecked()) ||
                        (rBtnUtilise.isChecked())) &&
                (!(eTxtVille.getText().length()==0)))
        {
            res=true;
        }
        else
        {
            txtVMsgError.setText("Tous les champs (*) sont obligatoires.");
            res=false;
        }
        System.out.println("OK METHOD IS VALID");
        return res;
    }
}
