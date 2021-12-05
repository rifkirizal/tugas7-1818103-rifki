package com.example.tugas7_1818103_rifki;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAkunGi extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_penjualanAkunGi";
    private static final String tb_penjualanAkun = "tb_penjualanAkun";
    private static final String tb_uid = "tb_uidAkun";
    private static final String tb_ign = "tb_ingamenickname";
    private static final String tb_harga = "tb_harga";


    private static final String CREATE_TABLE_AKUNGi = "CREATE TABLE " + tb_penjualanAkun + "("
            + tb_uid+ " INTEGER PRIMARY KEY ,"
            + tb_ign+ "TEXT,"
            + tb_harga+ " TEXT"+ ")";

    public DatabaseAkunGi(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_AKUNGi );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateAkunGi (AkunGi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_uid, mdNotif.get_uid());
        values.put(tb_ign, mdNotif.get_ign());
        values.put(tb_harga, mdNotif.get_harga());
        db.insert(tb_penjualanAkun, null, values);
        db.close();
    }

    public List<AkunGi> ReadAkunGi() {
        List<AkunGi> PenjualanAkunGi = new ArrayList<AkunGi>();
        String selectQuery = "SELECT  * FROM " + tb_penjualanAkun;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                AkunGi mdKontak = new AkunGi();
                mdKontak.set_uid(cursor.getString(0));
                mdKontak.set_ign(cursor.getString(1));
                mdKontak.set_harga(cursor.getString(2));
                PenjualanAkunGi.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return PenjualanAkunGi;
    }

    public int UpdateAkunGi (AkunGi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(tb_uid, mdNotif.get_uid());
        values.put(tb_ign, mdNotif.get_ign());
        values.put(tb_harga, mdNotif.get_harga());

        return db.update(tb_penjualanAkun, values, tb_uid+ " = ?",
                new String[] { String.valueOf(mdNotif.get_uid())});
    }

    public void DeleteAkunGi (AkunGi mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_penjualanAkun, tb_uid+ " = ?",
                new String[]{String.valueOf(mdNotif.get_uid())});
        db.close();
    }
}
