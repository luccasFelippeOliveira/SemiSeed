package com.luccas.semiseed.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lfo and O2junior on 18/11/2016.
 */

public class DatabaseCreator extends SQLiteOpenHelper {
    private static final String DB_NAME = "seed.db";
    private static final int DB_VERSION = 1;
    //planta
     static final String TABELA_PLANTA = "planta";
     static final String ID_Planta = "id_planta";
     static final String AGUA = "agua";
     static final String ADUBO = "adubo";
     static final String IMAGEM = "imagem";
     static final String TP_PLANTA = "tipoPlanta";
    //dicas
     static final String TABELA_DICAS = "dicas";
     static final String ID_Dicas = "id_dicas";
     static final String DICA_TEXTO = "dicaTexto";
    static final String DICA_TP_PLANTA = "tipoPlanta";
    //TipoPlanta
     static final String TABELA_TP_PLANTA = "tipo_planta";
     static final String ID_TP_PLANTA = "id_tpplanta";
     static final String NOME_TP_PLANTA = "nome";

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
