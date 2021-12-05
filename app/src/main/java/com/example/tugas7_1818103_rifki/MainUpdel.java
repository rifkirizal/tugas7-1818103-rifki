package com.example.tugas7_1818103_rifki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private DatabaseAkunGi db;
    private String Suid, Sign, Sharga;
    private EditText Euid, Eign, Eharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new DatabaseAkunGi(this);

        Intent i = this.getIntent();
        Suid = i.getStringExtra("Iuid");
        Sign = i.getStringExtra("Iign");
        Sharga = i.getStringExtra("Iharga");


        Euid = (EditText) findViewById(R.id.update_UID_akun);
        Eign = (EditText) findViewById(R.id.update_IGN_akun);


        Euid.setText(Suid);
        Eign.setText(Sign);
        Eharga.setText(Sharga);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Suid = String.valueOf(Euid.getText());
                Sign = String.valueOf(Eign.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Suid.equals("")){
                    Euid.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi UID anda", Toast.LENGTH_SHORT).show();
                } else if (Sign.equals("")){
                    Eign.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi IGN anda", Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga akun anda ", Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateAkunGi(new AkunGi(Suid, Sign, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteAkunGi(new AkunGi(Suid, Sign, Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
