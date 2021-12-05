package com.example.tugas7_1818103_rifki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private DatabaseAkunGi db;
    private List<AkunGi> List_akun = new ArrayList<AkunGi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new DatabaseAkunGi(this);

        adapter_off = new CustomListAdapter(this, List_akun);
        mListView = (ListView) findViewById(R.id.list_akun);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        List_akun.clear();

        List<AkunGi> contacts = db.ReadAkunGi();
        for (AkunGi cn : contacts) {
            AkunGi judulModel = new AkunGi();
            judulModel.set_uid(cn.get_uid());
            judulModel.set_ign(cn.get_ign());
            judulModel.set_harga(cn.get_harga());
            List_akun.add(judulModel);

            if ((List_akun.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        AkunGi obj_itemDetails = (AkunGi) o;

        String Suid = obj_itemDetails.get_uid();
        String Sign = obj_itemDetails.get_ign();


        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iuid", Suid);
        goUpdel.putExtra("Iign", Sign);
        startActivity(goUpdel);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List_akun.clear();
        mListView.setAdapter(adapter_off);

        List<AkunGi> contacts = db.ReadAkunGi();
        for (AkunGi cn : contacts) {
            AkunGi judulModel = new AkunGi();
            judulModel.set_uid(cn.get_uid());
            judulModel.set_ign(cn.get_ign());
            List_akun.add(judulModel);

            if ((List_akun.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data", Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
