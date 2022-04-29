package com.example.jigneshandroidtops;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StoreFetchData {

    public static void storeData(String fileName,Activity activity,String data){

        try {

            FileOutputStream os = activity.openFileOutput(fileName,MODE_PRIVATE);
            os.write(data.getBytes());
            os.close();

            Toast.makeText(activity, "Data Write SuccessFully", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String readData(String fileName, Activity activity){

        String data = null;

        try {

            FileInputStream fis = activity.openFileInput(fileName);
            byte[] arr = new byte[fis.available()];
            fis.read(arr);

            data = new String(arr);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;

    }

}
