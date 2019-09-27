package com.appmoviles.organizador.app;

import android.app.Application;
import android.content.Context;

public class OrganizadorApp extends Application {

    public static Context contex;
    @Override
    public void onCreate() {
        super.onCreate();
        OrganizadorApp.contex=getApplicationContext();
    }

    public static Context getContex(){
        return contex;
    }
}
