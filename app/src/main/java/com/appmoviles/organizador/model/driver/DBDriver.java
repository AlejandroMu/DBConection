package com.appmoviles.organizador.model.driver;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBDriver extends SQLiteOpenHelper {

    private static DBDriver instance;

    public static synchronized DBDriver getInstance(Context con){
        return instance=instance==null?new DBDriver(con):instance;
    }
    public static final String DB_NAME = "organizadora";
    public static final int DB_VERSION = 1;

    //SUBJECT TABLE
    public static final String SUBJECT_TABLE="SUBJECT";
    public static final String SUBJECT_ID="ID";
    public static final String SUBJECT_NAME="NAME";
    public static final String SUBJECT_DATE="DATE";

    //TASK TABLE
    public static final String TASK_TABLE="TASK_TABLE";
    public static final String TASK_ID="ID";
    public static final String TASK_NAME="NAME";
    public static final String TASK_DESC="DESCRIPTION";
    public static final String TASK_COMPLETE="COMPLETE";
    public static final String SUBJECT_ID_PK="SUBJECT_ID";


    private DBDriver(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLES
        String createSubject="CREATE TABLE $TABLE ($ID TEXT PRIMARY KEY, $NAME TEXT, $DATE INTEGER)";
        createSubject.replace("$TABLE",SUBJECT_TABLE)
                .replace("$ID",SUBJECT_ID)
                .replace("$NAME",SUBJECT_NAME)
                .replace("$DATE",SUBJECT_DATE);

        String createTask="CREATE TABLE $TABLE ($ID TEXT PRIMARY KEY, $NAME TEXT, $DESC TEXT,$COMPLETE INTEGER,$FK TEXT, FOREING KEY ($FK) REFERENCES $FTABLE($FID))";
        createTask.replace("$TABLE",TASK_TABLE)
                .replace("$ID",TASK_ID)
                .replace("$NAME",TASK_NAME)
                .replace("$DESC",TASK_DESC)
                .replace("$COMPLETE",TASK_COMPLETE)
                .replace("$FK",SUBJECT_ID_PK)
                .replace("$FTABLE",SUBJECT_TABLE)
                .replace("$FID",SUBJECT_ID);


        db.execSQL(createSubject);
        db.execSQL(createTask);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TASK_TABLE);
        db.execSQL("DROP TABLE IF EXISTS "+SUBJECT_TABLE);
        onCreate(db);
    }
}
