package com.luccas.semiseed.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lfo on 18/11/2016.
 */

public class DatabaseCreator extends SQLiteOpenHelper {
    private static final String DB_NAME = "seed.db";
    private static final int DB_VERSION = 1;

    public DatabaseCreator(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE tipo_planta (" +
                      "id integer primary key autoincrement, " +
                      "nome text" +
                       ")";
        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE planta (" +
                "id integer primary key autoincrement, " +
                "agua integer," +
                "adubo integer," +
                "imagem text," +
                "tipo_id integer," +
                "foreign key(tipo_id) references tipo_planta(id)" +
                ")";

        sqLiteDatabase.execSQL(sql);

        sql = "CREATE TABLE dicas (" +
                "id integer primary key autoincrement, " +
                "text_dica text," +
                "tipo_id integer," +
                "foreign key(tipo_id) references tipo_planta(id)" +
                ")";

        sqLiteDatabase.execSQL(sql);

        //Insercao das plantas e dicas aqui.

        //Teste
        sqLiteDatabase.execSQL("INSERT INTO TABLE tipo_planta(nome) VALUES (\"Erva-Doce\")");
        sqLiteDatabase.execSQL("INSERT INTO TABLE tipo_planta(nome) VALUES (\"Alecrim\")");

        sqLiteDatabase.execSQL("INSERT INTO TABLE planta(agua, adubo, imagem, tipo_id)" +
                " VALUES (10,10,\"null\", 1)");
        sqLiteDatabase.execSQL("INSERT INTO TABLE planta(agua, adubo, imagem, tipo_id)" +
                " VALUES (25,50,\"null\", 2)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS planta");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS dicas");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS tipo_planta");
        onCreate(sqLiteDatabase);
    }
}
