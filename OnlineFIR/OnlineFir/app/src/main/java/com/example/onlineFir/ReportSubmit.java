package com.example.onlineFir;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.onlineFir.Common.Common;
import com.example.onlineFir.Model.Report;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ReportSubmit extends AppCompatActivity {


    TextView tvDisplayDate, categoryI, regDate;
    EditText aadhaar, iname, ifname, iage, iphone, ioccupation, oplace, oarea, odate, otime, oday, odescription, sname, sfname, saddress;
    Button btnRL1prev, btnRL1next;
    LinearLayout RL2, RL1, RL3;
    Calendar mCurrentDate;
    int day, month, year, hour, minute;
    String format;
    private static final String TAG = "ReportSubmit";

    String index;

    String aadhaar1;
    String iname1;
    String ifname1;
    String iage1;
    String iphone1;
    String ioccupation1;
    String oplace1;
    String oarea1;
    String odate1;
    String otime1;
    String oday1;
    String odescription1;
    String regDate1;
    String sfname1;
    String sname1;
    String saddress1;
    FirebaseDatabase database;
    DatabaseReference table_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_submit);

        //Init Firebase
        database = FirebaseDatabase.getInstance();
        table_report = database.getReference("Report");


        if (getIntent().hasExtra("info")){
            index = getIntent().getStringExtra("info");
        }

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvDisplayDate = findViewById(R.id.tvDisplayDate);
                                long dateTime = System.currentTimeMillis();
                                SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy hh:mm:ss a");
                                String dateString = sdf.format(dateTime);
                                tvDisplayDate.setText(dateString);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        t.start();


        btnRL1prev = findViewById(R.id.btn_RL1_prev);
        btnRL1next = findViewById(R.id.btn_RL1_next);
        aadhaar = findViewById(R.id.txt_adhaar_number_informant);
        iname = findViewById(R.id.txt_name);
        ifname = findViewById(R.id.txt_fname_informant);
        iage = findViewById(R.id.txt_age);
        iphone = findViewById(R.id.txt_phone_number);
        ioccupation = findViewById(R.id.txt_occupation_informant);
        oplace = findViewById(R.id.txt_place_of_offence);
        oarea = findViewById(R.id.txt_offence_area);
        odate = findViewById(R.id.txt_date_of_offence);
        otime = findViewById(R.id.txt_time_of_offence);
        oday = findViewById(R.id.txt_day_of_offence);
        odescription=findViewById(R.id.txt_description_of_offence);
        sname = findViewById(R.id.txt_name_of_suspect);
        sfname = findViewById(R.id.txt_fname_of_suspect);
        saddress = findViewById(R.id.txt_address_of_suspect);
        regDate = findViewById(R.id.tvDisplayDate);



        RL1 = findViewById(R.id.RL1);
        RL2 = findViewById(R.id.RL2);
        RL3 = findViewById(R.id.RL3);


        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        hour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
        minute = mCurrentDate.get(Calendar.MINUTE);


        month = month + 1;
        odate.setText(day + "/" + month + "/" + year);

        odate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ReportSubmit.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        odate.setText(dayOfMonth + "/" + month + "/" + year);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        selectedTimeFormat(hour);
        otime.setText(hour+" : "+minute+"  "+format );
        otime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ReportSubmit.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        selectedTimeFormat(hourOfDay);
                        otime.setText(hourOfDay+" : "+minute+" "+format);
                    }
                },hour,minute,true);
                timePickerDialog.show();
            }
        });



        btnRL1next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RL1.getVisibility() == View.VISIBLE) {
                    validateOne();
                }

                else if (RL2.getVisibility() == View.VISIBLE) {
                    validateTwo();
                }

                else if (RL3.getVisibility() == View.VISIBLE) {

                    aadhaar1 = aadhaar.getText().toString();
                    iname1 = iname.getText().toString();
                    ifname1 = ifname.getText().toString();
                    iage1 = iage.getText().toString();
                    iphone1 = iphone.getText().toString();
                    ioccupation1 = ioccupation.getText().toString();
                    oplace1 = oplace.getText().toString();
                    oarea1 = oarea.getText().toString();
                    odate1 = odate.getText().toString();
                    otime1 = otime.getText().toString();
                    oday1 = oday.getText().toString();
                    odescription1 = odescription.getText().toString();
                    regDate1 = regDate.getText().toString();
                    sfname1 = sfname.getText().toString();
                    sname1 = sname.getText().toString();
                    saddress1 = saddress.getText().toString();
                    showAlertDialog();
                }
            }
        });

        btnRL1prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (RL1.getVisibility() == View.VISIBLE) {
                    Intent intent = new Intent(ReportSubmit.this, HomeActivity.class);
                    startActivity(intent);
                } else if (RL2.getVisibility() == View.VISIBLE) {
                    RL2.setVisibility(View.GONE);
                    RL1.setVisibility(View.VISIBLE);
                } else if (RL3.getVisibility() == View.VISIBLE) {
                    RL3.setVisibility(View.GONE);
                    RL2.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void selectedTimeFormat(int hour)
    {
        if(hour == 0){
            hour += 12;
            format = "AM";
        }else if(hour == 12){
            format = "PM";
        }else if(hour > 12){
            hour -= 12;
            format = "PM";
        }else{
            format = "AM";
        }
    }

    private void validateTwo() {

        oplace1 = oplace.getText().toString().trim();
        oarea1 = oarea.getText().toString().trim();
        odate1 = odate.getText().toString().trim();
        otime1 = otime.getText().toString().trim();
        oday1 = oday.getText().toString().trim();
        odescription1 = odescription.getText().toString().trim();

        if(validateSecond()){
            RL3.setVisibility(View.VISIBLE);
            RL2.setVisibility(View.GONE);
        }

    }

    private boolean validateSecond() {
        boolean valid = true;
        if(oplace1.isEmpty()){
            oplace.setError("Please enter Address");
            valid = false;
        }
        if(oarea1.isEmpty()){
            oarea.setError("Please enter Area");
            valid = false;
        }
        if(odate1.isEmpty()){
            odate.setError("Please enter Date");
            valid = false;
        }
        if(otime1.isEmpty()){
            otime.setError("Please enter Time");
            valid = false;
        }
        if(oday1.isEmpty()){
            oday.setError("Please enter Day");
            valid = false;
        }
        if(odescription1.isEmpty()){
            odescription.setError("Please enter Description");
            valid = false;
        }
        return valid;

    }

    private void validateOne() {

        aadhaar1 = aadhaar.getText().toString().trim();
        iname1 = iname.getText().toString().trim();
        ifname1 = ifname.getText().toString().trim();
        iage1 = iage.getText().toString().trim();
        iphone1 = iphone.getText().toString().trim();
        ioccupation1 = ioccupation.getText().toString().trim();

        if(validateFirst()){
            String num = aadhaar.getText().toString();
            boolean result = Verhoeff.validateVerhoeff(num);
            String msg = String.valueOf(result);

            if (msg == "true") {
                RL2.setVisibility(View.VISIBLE);
                RL1.setVisibility(View.GONE);
            } else
                Toast.makeText(ReportSubmit.this, "Check Aadhaar Number", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean validateFirst() {
        boolean valid = true;
        if(aadhaar1.isEmpty()){
            aadhaar.setError("Please enter Adhaar number");
            valid = false;
        }
        if(iname1.isEmpty()){
            iname.setError("Please enter Full Name");
            valid = false;
        }
        if(ifname1.isEmpty()){
            ifname.setError("Please enter Father's Name");
            valid = false;
        }
        if(iage1.isEmpty()){
            iage.setError("Please enter your Age");
            valid = false;
        }
        if(iphone1.isEmpty()){
            iphone.setError("Please enter Phone number");
            valid = false;
        }
        if(ioccupation1.isEmpty()){
            ioccupation.setError("Please enter Occupation");
            valid = false;
        }
        return valid;
    }


    private void insertData() {

        if (Common.isConnectedToInternet(getBaseContext())) {

            final ProgressDialog mDialog = new ProgressDialog(ReportSubmit.this);
            mDialog.setMessage("Please Wait...");
            mDialog.show();

            String Uid = table_report.push().getKey();
           /* Report fir = new Report("fe","efe","","",
                    "","","","","",
                    "","","","","",
                    "",""); */

            Report fir = new Report(aadhaar1,
                    iname1,
                    ifname1,
                    iage1,
                    iphone1,
                    ioccupation1,
                    oplace1,
                    oarea1,
                    odate1,
                    oday1,
                    odescription1,
                    otime1,
                    regDate1,
                    sname1,
                    sfname1,
                    saddress1);



            if(index.equalsIgnoreCase("0"))
                table_report.child("Accident").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("1"))
                table_report.child("Eve_Tease").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("2"))
                table_report.child("Theft").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("3"))
                table_report.child("Violence").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("4"))
                table_report.child("Kidnap").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("5"))
                table_report.child("Murder").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("6"))
                table_report.child("Racism").child(Uid).setValue(fir);
            else if(index.equalsIgnoreCase("7"))
                table_report.child("Fraud").child(Uid).setValue(fir);

            Toast.makeText(ReportSubmit.this, "FIR Registered Successful", Toast.LENGTH_SHORT).show();
            finish();

            Intent last = new Intent(ReportSubmit.this,Last.class);
            startActivity(last);

        /*     table_report.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mDialog.dismiss();
                   Report fir = new Report(aadhaar.getText().toString(),
                            iname.getText().toString(),
                            ifname.getText().toString(),
                            iage.getText().toString(),
                            iphone.getText().toString(),
                            ioccupation.getText().toString(),
                            oplace.getText().toString(),
                            oarea.getText().toString(),
                            odate.getText().toString(),
                            otime.getText().toString(),
                            oday.getText().toString(),
                            odescription.getText().toString(),
                            regDate.getText().toString(),
                            sfname.getText().toString(),
                            sname.getText().toString(),
                            saddress.getText().toString());

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(ReportSubmit.this, "FIR Registered Successful", Toast.LENGTH_SHORT).show();
                    Log.d("", databaseError.getDetails());
                }
            });  */
        } else {
            Toast.makeText(ReportSubmit.this, "Please check your connection !!", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ReportSubmit.this);
        alertDialog.setTitle("Agreement !");
        alertDialog.setMessage("I hereby agree that all information is totally correct and i'm responsible for any punishment if this information is wrong");

        alertDialog.setIcon(R.drawable.ic_verified_user_black_24dp);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Create new Request
                     insertData();
                   finish();
            }
        });

        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }



}
