package com.example.jigneshandroidtops.dialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.jigneshandroidtops.R;
import com.example.jigneshandroidtops.databinding.ActivityMyDialogBinding;
import com.example.jigneshandroidtops.databinding.DialogLayoutBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyDialogActivity extends AppCompatActivity {

    private ActivityMyDialogBinding binding;
    private DialogLayoutBinding binding1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyDialogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAlert.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is Alert Dialog");
            builder.setMessage("This is Message");
            builder.setIcon(R.drawable.ic_android);
            builder.setCancelable(false);

            builder.setPositiveButton("Toast", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Toast.makeText(MyDialogActivity.this, "This is Toast", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("SnackBar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    Snackbar.make(binding.getRoot(),"This is SnackBar",Snackbar.LENGTH_SHORT).show();

                }
            });

            builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder.show();

        });

        binding.btnAlertCustom.setOnClickListener(view -> {

            binding1 = DialogLayoutBinding.inflate(getLayoutInflater());

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("This is Custom Alert Dialog");

            builder.setView(binding1.getRoot());

            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String data = binding1.edtSomething.getText().toString();

                    binding.textView.setText(data);

                }
            });

            builder.show();


        });

        binding.btnProgress.setOnClickListener(view -> {

            ProgressDialog pd = new ProgressDialog(this);

            pd.setTitle("Please Wait");

            pd.setMessage("Downloading....");

            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            pd.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {

                        Thread.sleep(2000);
                        pd.dismiss();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }).start();

//            pd.dismiss();

        });

        binding.btnProgress2.setOnClickListener(view -> {

            ProgressDialog pd = new ProgressDialog(this);

            pd.setTitle("Downloading");

            pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

            pd.setMax(100);

            pd.show();

            new Thread(new Runnable() {
                @Override
                public void run() {

                    for(int i=0;i<=100;i++){

                        try {

                            Thread.sleep(100);

                            pd.setProgress(i);

                            if(i==100){

                                pd.dismiss();
                            }


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }
            }).start();
        });

        binding.btnTimePicker.setOnClickListener(view -> {


            Calendar c = Calendar.getInstance();

            int hour = c.get(Calendar.HOUR_OF_DAY);
            int min = c.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {

                    String hr24 = i+":"+i1;

                    SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");
                    SimpleDateFormat format12 = new SimpleDateFormat("hh:mm a");

                    // convert 24 hr string into 24hr date format

                    try {

                        Date date24 = format24.parse(hr24);

                        String hr12 = format12.format(date24);

                        binding.btnTimePicker.setText(hr12);

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                }
            },hour,min,true);

            dialog.show();

        });

        binding.btnDatePicker.setOnClickListener(view -> {

            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                    binding.btnDatePicker.setText(i2+"/"+(i1+1)+"/"+i);

                }
            },year,month,day);

            dialog.getDatePicker().setMinDate(System.currentTimeMillis());

            c.set(2022,3,21);

            dialog.getDatePicker().setMaxDate(c.getTimeInMillis());


            dialog.show();

        });


    }
}