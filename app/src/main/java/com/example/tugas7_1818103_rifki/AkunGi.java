package com.example.tugas7_1818103_rifki;

public class AkunGi {
    private String _uid, _ign, _harga;

    public AkunGi (String uid, String ign, String harga) {
        this._uid = uid;
        this._ign = ign;
        this._harga = harga;

    }
    public AkunGi() {
    }
    public String get_uid() {
        return _uid;
    }
    public void set_uid(String _uid) {
        this._uid = _uid;
    }
    public String get_ign() {
        return _ign;
    }
    public void set_ign(String _judul) { this._ign = _ign;}
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
