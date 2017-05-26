package com.example.shaloin.remoteaccess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtPhoneNo;
    EditText txtMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhoneNo=(EditText)this.findViewById(R.id.txtPhoneNo);
        txtMessage=(EditText)this.findViewById(R.id.txtMessage);
        btnSend=(Button)this.findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNo=txtPhoneNo.getText().toString();
                String message=txtMessage.getText().toString();
                if(phoneNo.length()>0 && message.length()>0){
                    sendMessage(phoneNo,message);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please enter valid credentials", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    private void sendMessage(String phoneNo, String message){
        try{
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo,null,message,null,null);
            Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Message Sending Failed. Try again.", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
