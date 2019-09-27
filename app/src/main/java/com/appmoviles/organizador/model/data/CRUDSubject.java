package com.appmoviles.organizador.model.data;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.appmoviles.organizador.app.OrganizadorApp;
import com.appmoviles.organizador.model.driver.DBDriver;
import com.appmoviles.organizador.model.entity.Subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CRUDSubject {

    public static void insert(Subject newSbject){
        DBDriver driver=DBDriver.getInstance(OrganizadorApp.getContex());
        SQLiteDatabase db=driver.getWritableDatabase();
        String query="INSERT INTO $TABLE ($ID,$NAME,$DATE) VALUES('$VID','$VNAME',$VDATE)";
        query=query.replace("$TABLE",DBDriver.SUBJECT_TABLE)
                .replace("$ID",DBDriver.SUBJECT_ID)
                .replace("$NAME",DBDriver.SUBJECT_NAME)
                .replace("$DATE",DBDriver.SUBJECT_DATE)
                .replace("$VID",newSbject.getId())
                .replace("$VNAME",newSbject.getName())
                .replace("$VDATE",newSbject.getDate().getTime()+"");

        db.execSQL(query);
        db.close();
    }
    public static List<Subject> getAllSubjects() {
        DBDriver driver = DBDriver.getInstance(OrganizadorApp.getContex());
        SQLiteDatabase db = driver.getReadableDatabase();
        String query="SELECT * FROM "+DBDriver.SUBJECT_TABLE;
        List<Subject> ret=new ArrayList<>();
        Cursor cursor=db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                String id=cursor.getString(cursor.getColumnIndex(DBDriver.SUBJECT_ID));
                String name=cursor.getString(cursor.getColumnIndex(DBDriver.SUBJECT_NAME));
                long date=cursor.getLong(cursor.getColumnIndex(DBDriver.SUBJECT_DATE));
                Date d=new Date(date);
                ret.add(new Subject(id,name,d));
            }while(cursor.moveToNext());
        }

        db.close();
        return ret;
    }

}
