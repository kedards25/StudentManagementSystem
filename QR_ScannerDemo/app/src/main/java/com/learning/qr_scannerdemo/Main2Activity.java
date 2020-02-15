package com.learning.qr_scannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    TextView txtAttendanceDetails;
    Button btnMrkAtt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtAttendanceDetails=findViewById(R.id.textView);
        btnMrkAtt=findViewById(R.id.button);
        showDetails();
        btnMrkAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Main2Activity.this,"Attendance Marked",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showDetails() {
        Intent intent=getIntent();
        Bundle recvdBundle= intent.getExtras();
        String details=recvdBundle.getString("QR_Data");
        txtAttendanceDetails.setText(details);
    }
}
