package com.example.ciller.pm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ciller on 1/16/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Budget.db";
    public static final String TABLE_NAME  = "Receivables_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "AMOUNT";
    public static final String COL_4 = "UNIT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AMOUNT INTEGER ,UNIT  TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertReceivable1(ReceivableDetails r)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COL_2, r.getName());
        cV.put(COL_3, r.getAmount());
        cV.put(COL_4, r.getUnit());
        long rez = db.insert(TABLE_NAME, null, cV);
        if(rez == -1 )
            return false;
        else
            return true;
    }


    public boolean insertReceivable(String name, String amount, String unit)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COL_2, name);
        cV.put(COL_3, amount);
        cV.put(COL_4, unit);
        long rez = db.insert(TABLE_NAME, null, cV);
        if(rez == -1 )
            return false;
        else
            return true;
    }

    public Cursor getReceivables()
    {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor p = db.rawQuery("select * from "+TABLE_NAME, null);
            return p;
    }


    public boolean updateReceivable(String id, String name, String amount, String unit)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COL_1, id);
        cV.put(COL_2, name);
        cV.put(COL_3, amount);
        cV.put(COL_4, unit);
        db.update(TABLE_NAME, cV, "ID = ?", new String[]{id});
        return true;
    }

    public boolean updateReceivable1(ReceivableDetails r)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COL_1, r.getId());
        cV.put(COL_2, r.getName());
        cV.put(COL_3, r.getAmount());
        cV.put(COL_4, r.getUnit());
        db.update(TABLE_NAME, cV, "ID = ?", new String[]{r.getId().toString()});
        return true;
    }

    public Integer deleteReceivable(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[] {id});
    }


    public ArrayList<ReceivableDetails> getReceivablesFromDataBase()
    {
        ArrayList<ReceivableDetails> receivablesss = new ArrayList<>();
        SQLiteDatabase s = this.getReadableDatabase();

        Cursor c = s.query(TABLE_NAME, null, null, null, null, null, null );

        while(c.moveToNext())
        {
            String name = c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COL_2));
            int amount = c.getInt(c.getColumnIndexOrThrow(DatabaseHelper.COL_3));
            String unit = c.getString(c.getColumnIndexOrThrow(DatabaseHelper.COL_4));
            int id = c.getInt(c.getColumnIndexOrThrow(DatabaseHelper.COL_1));
            receivablesss.add(new ReceivableDetails(name, amount, unit, id));
        }

        c.close();
        return receivablesss;

    }

}

