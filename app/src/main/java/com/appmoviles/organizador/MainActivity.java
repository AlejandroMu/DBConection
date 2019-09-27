package com.appmoviles.organizador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.appmoviles.organizador.model.data.CRUDSubject;
import com.appmoviles.organizador.model.entity.Subject;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CRUDSubject.insert(
                new Subject(UUID.randomUUID().toString(),"AppMovile", Calendar.getInstance().getTime()));
        CRUDSubject.insert(
                new Subject(UUID.randomUUID().toString(),"Integrador", Calendar.getInstance().getTime()));
        CRUDSubject.insert(
                new Subject(UUID.randomUUID().toString(),"APO1", Calendar.getInstance().getTime()));


        List<Subject> subjects=CRUDSubject.getAllSubjects();
        int i=0;
        for(Subject sub:subjects){
            Log.e(">> "+(++i),sub.getName());
        }
    }
}
