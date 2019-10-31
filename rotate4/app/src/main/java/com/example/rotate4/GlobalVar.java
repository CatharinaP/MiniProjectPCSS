package com.example.rotate4;

import android.app.Application;

public class GlobalVar extends Application {
    public static boolean status;
    public boolean getStatus(){
        return status;

    }
    public void setStatus(boolean vStatus){
        status = vStatus
        ;


    }


}
