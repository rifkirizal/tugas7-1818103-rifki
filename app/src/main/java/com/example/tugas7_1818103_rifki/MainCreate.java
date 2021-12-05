package com.example.tugas7_1818103_rifki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private DatabaseAkunGi db;
    private EditText Euid, Eign;
    private String Suid, Sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new DatabaseAkunGi(this);

        Euid = (EditText) findViewById(R.id.create_uid_akun);
        Eign = (EditText) findViewById(R.id.create_ign_akun);


        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Suid = String.valueOf(Euid.getText());
                Sign = String.valueOf(Eign.getText());


                if (Suid.equals("")){
                    Euid.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi UID akun anda", Toast.LENGTH_SHORT).show();
                } else if (Sign.equals("")){
                    Eign.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi IGN akun anda", Toast.LENGTH_SHORT).show();
                } else {
                    Euid.setText("");
                    Eign.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah", Toast.LENGTH_SHORT).show();
                    db.CreateAkunGi(new AkunGi(null, Suid, Sign));

                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }

            }
        });
    }

}