package com.luccas.semiseed.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lfo on 18/11/2016.
 */

public class DatabaseController {
    private SQLiteDatabase db;
    private DatabaseCreator creator;

    public DatabaseController(Context context) {
        creator = new DatabaseCreator(context);
    }

    public void insertPlanta(Planta planta) {

    }
}
