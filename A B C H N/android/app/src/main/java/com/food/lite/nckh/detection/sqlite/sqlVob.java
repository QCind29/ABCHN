package com.food.lite.nckh.detection.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.food.lite.nckh.detection.DetectGallery;

import com.food.lite.nckh.detection.model.Vob;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

public class sqlVob extends SQLiteAssetHelper {
    private static final String DB_NAME = "TuDien.db";
    private static final int DB_VERSION = 1;

    public sqlVob(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    //Thu nghiem
    public ArrayList<Vob> getAll() {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * from Doituong ORDER BY Iddt ASC", null);
        ArrayList<Vob> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Vob vob = new Vob();
                vob.setIdVob(cursor.getInt(cursor.getColumnIndexOrThrow("Iddt")));
                vob.setTendoituongTA(cursor.getString(cursor.getColumnIndexOrThrow("TendtEN")));
                vob.setTendoituongTV(cursor.getString(cursor.getColumnIndexOrThrow("TendtVN")));
                vob.setAudioEN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaEN")));
                vob.setAudioVN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaVn")));


                result.add(vob);
            } while (cursor.moveToNext());
        }
        return result;
    }


    public ArrayList<Vob> getSen(String sen) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT CauEN, CauVN from Datcau dc join Doituong dt on dc.Iddt = dt.Iddt where TendtEN = ?", new String[]{sen + ""}, null);
        ArrayList<Vob> result = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                Vob vob = new Vob();
                vob.setDatcauTA(cursor.getString(cursor.getColumnIndexOrThrow("CauEN")));
                vob.setDatcauTV(cursor.getString(cursor.getColumnIndexOrThrow("CauVN")));

                result.add(vob);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return result;
    }




        public ArrayList<Vob> getVob () {

            SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT TendtEN, TendtVN, DinhnghiaVn" +
                    " FROM Doituong"
                   , null);

            ArrayList<Vob> result = new ArrayList<>();

            if (cursor.moveToFirst()) {
                do {
                    Vob vob = new Vob();
                    vob.setTendoituongTA(cursor.getString(cursor.getColumnIndexOrThrow("TendtEN")));
                    vob.setTendoituongTV(cursor.getString(cursor.getColumnIndexOrThrow("TendtVN")));
//                    vob.setAudioEN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaEN")));
                    vob.setAudioVN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaVn")));

                    result.add(vob);
                } while (cursor.moveToNext());
            }
//            cursor.close();
            return result;
        }
//    public ArrayList<Vob> getAu () {
//
//        SQLiteDatabase db = getReadableDatabase();
//
//        Cursor cursor = db.rawQuery("SELECT DinhnghiaEN" +
//                        " FROM Doituong"
//                , null);
//
//        ArrayList<Vob> result = new ArrayList<>();
//
//        if (cursor.moveToFirst()) {
//            do {
//                Vob vob = new Vob();
//                vob.setAudioEN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaEN")));
//               // vob.setAudioVN(cursor.getString(cursor.getColumnIndexOrThrow("DinhnghiaVN")));
//
//                result.add(vob);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        return result;
//    }
    }

