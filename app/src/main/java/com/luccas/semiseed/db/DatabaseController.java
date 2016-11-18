package com.luccas.semiseed.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

/**
 * Created by lfo and O2junior on 18/11/2016.
 */

public class DatabaseController {
    private SQLiteDatabase db;
    private DatabaseCreator creator;

    public DatabaseController(Context context) {
        creator = new DatabaseCreator(context);
    }

    //Metodos de Inserção
    public void insertPlanta(Planta planta) {
        ContentValues valoresPlanta;
        long resultInsert;

        db = creator.getWritableDatabase();
        valoresPlanta = new ContentValues();

        valoresPlanta.put(DatabaseCreator.ID_Planta, ""+planta.getId());
        valoresPlanta.put(DatabaseCreator.AGUA, ""+planta.getAgua());
        valoresPlanta.put(DatabaseCreator.ADUBO, ""+planta.getAdubo());
        valoresPlanta.put(DatabaseCreator.IMAGEM, planta.getImagem());
        valoresPlanta.put(DatabaseCreator.TP_PLANTA, planta.getTipoPlanta().getNome());

        resultInsert = db.insert(DatabaseCreator.TABELA_PLANTA, null, valoresPlanta);
        db.close();

        if(resultInsert==-1){
            //return "Erro ao inserir registro";
        }else{
            //return "Registrado com sucesso";
        }

    }

    public void insertDica(Dicas dica) {
        ContentValues valoresDica;
        long resultInsert;

        db = creator.getWritableDatabase();
        valoresDica = new ContentValues();

        valoresDica.put(DatabaseCreator.ID_Dicas, ""+dica.getId());
        valoresDica.put(DatabaseCreator.DICA_TEXTO, dica.getDicaTexto());
        valoresDica.put(DatabaseCreator.DICA_TP_PLANTA, dica.getTipoPlanta().getNome());

        resultInsert = db.insert(DatabaseCreator.TABELA_DICAS, null, valoresDica);
        db.close();

        if(resultInsert==-1){
            //return "Erro ao inserir registro";
        }else{
            //return "Registrado com sucesso";
        }

    }

    public void insertTpPlanta(TipoPlanta TpPlanta) {
        ContentValues valoresTpPlanta;
        long resultInsert;

        db = creator.getWritableDatabase();
        valoresTpPlanta = new ContentValues();

        valoresTpPlanta.put(DatabaseCreator.ID_TP_PLANTA, ""+TpPlanta.getID());
        valoresTpPlanta.put(DatabaseCreator.NOME_TP_PLANTA, TpPlanta.getNome());

        resultInsert = db.insert(DatabaseCreator.TABELA_TP_PLANTA, null, valoresTpPlanta);
        db.close();

        if(resultInsert==-1){
            //return "Erro ao inserir registro";
        }else{
            //return "Registrado com sucesso";
        }

    }

    //Carregar Dados pelo ID
    public Cursor carregaDadoByIdPlanta(int id){
        Cursor cursor;
        String[] campos =  {creator.ID_Planta,creator.AGUA,creator.ADUBO,creator.IMAGEM,creator.TP_PLANTA};
        String where = DatabaseCreator.ID_Planta + "=" + id;
        db = creator.getReadableDatabase();
        cursor = db.query(DatabaseCreator.TABELA_PLANTA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoByIdDica(int id){
        Cursor cursor;
        String[] campos =  {creator.ID_Dicas,creator.DICA_TEXTO,creator.DICA_TP_PLANTA};
        String where = DatabaseCreator.ID_Dicas + "=" + id;
        db = creator.getReadableDatabase();
        cursor = db.query(DatabaseCreator.TABELA_DICAS,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoByIdTpPlanta(int id){
        Cursor cursor;
        String[] campos =  {creator.ID_TP_PLANTA,creator.NOME_TP_PLANTA};
        String where = DatabaseCreator.ID_TP_PLANTA + "=" + id;
        db = creator.getReadableDatabase();
        cursor = db.query(DatabaseCreator.TABELA_TP_PLANTA,campos,where, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    //Metodos de alteração
    public void alterarPlanta(Planta planta) {
        ContentValues valoresPlanta;
        String where;

        db = creator.getWritableDatabase();
        where = DatabaseCreator.ID_Planta + "=" + planta.getId();

        valoresPlanta = new ContentValues();

        valoresPlanta.put(DatabaseCreator.ID_Planta, ""+planta.getId());
        valoresPlanta.put(DatabaseCreator.AGUA, ""+planta.getAgua());
        valoresPlanta.put(DatabaseCreator.ADUBO, ""+planta.getAdubo());
        valoresPlanta.put(DatabaseCreator.IMAGEM, planta.getImagem());
        valoresPlanta.put(DatabaseCreator.TP_PLANTA, planta.getTipoPlanta().getNome());

        db.update(DatabaseCreator.TABELA_PLANTA, valoresPlanta, where, null);
        db.close();

    }

    public void alterarDica(Dicas dica) {
        ContentValues valoresDica;
        String where;

        db = creator.getWritableDatabase();
        where = DatabaseCreator.ID_Dicas + "=" + dica.getId();

        valoresDica = new ContentValues();

        valoresDica.put(DatabaseCreator.ID_Dicas, ""+dica.getId());
        valoresDica.put(DatabaseCreator.DICA_TEXTO, dica.getDicaTexto());
        valoresDica.put(DatabaseCreator.DICA_TP_PLANTA, dica.getTipoPlanta().getNome());

        db.update(DatabaseCreator.TABELA_DICAS, valoresDica, where, null);
        db.close();

    }

    public void alterarTPPlanta(TipoPlanta TpPlanta) {
        ContentValues valoresTpPlanta;
        String where;

        db = creator.getWritableDatabase();
        where = DatabaseCreator.ID_Planta + "=" + TpPlanta.getID();

        valoresTpPlanta = new ContentValues();

        valoresTpPlanta.put(DatabaseCreator.ID_TP_PLANTA, ""+TpPlanta.getID());
        valoresTpPlanta.put(DatabaseCreator.NOME_TP_PLANTA, TpPlanta.getNome());

        db.update(DatabaseCreator.TABELA_DICAS, valoresTpPlanta, where, null);
        db.close();

    }

    //deletes
        public void deletaRegistroPlanta(int id){
        String where = DatabaseCreator.ID_Planta + "=" + id;
        db = creator.getReadableDatabase();
        db.delete(DatabaseCreator.TABELA_PLANTA,where,null);
        db.close();
    }

    public void deletaRegistroDica(int id){
        String where = DatabaseCreator.ID_Dicas + "=" + id;
        db = creator.getReadableDatabase();
        db.delete(DatabaseCreator.TABELA_DICAS,where,null);
        db.close();
    }

    public void deletaRegistroTpPlanta(int id){
        String where = DatabaseCreator.ID_TP_PLANTA + "=" + id;
        db = creator.getReadableDatabase();
        db.delete(DatabaseCreator.TABELA_TP_PLANTA,where,null);
        db.close();
    }

}
