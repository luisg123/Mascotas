package com.lgcs.mascotas;

import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import javax.mail.AuthenticationFailedException;
import javax.mail.MessagingException;

public class ActivityContact extends AppCompatActivity {

    private EditText user;
    private EditText pass;
    private EditText subject;
    private EditText body;
    private EditText recipient;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);
        subject = (EditText) findViewById(R.id.subject);
        body = (EditText) findViewById(R.id.body);
        recipient = (EditText) findViewById(R.id.recipient);

        Button btn = (Button) findViewById(R.id.btnSend);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

    }
    private void sendMessage() {
        String[] recipients = { recipient.getText().toString() };
        SendEmailAsyncTask email = new SendEmailAsyncTask();
        email.activity = this;
        email.m = new Mail(user.getText().toString(), pass.getText()
                .toString());
        email.m.set_from(user.getText().toString());
        email.m.setBody(body.getText().toString());
        email.m.set_to(recipients);
        email.m.set_subject(subject.getText().toString());
        email.execute();
    }

    public void displayMessage(String message) {
        Snackbar.make(findViewById(R.id.btnSend), message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }
}

class SendEmailAsyncTask extends AsyncTask<Void, Void, Boolean> {
    Mail m;
    ActivityContact activity;

    public SendEmailAsyncTask() {}

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            if (m.send()) {
                activity.displayMessage("Email sent.");
            } else {
                activity.displayMessage("Email failed to send.");
            }

            return true;
        } catch (AuthenticationFailedException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Bad account details");
            e.printStackTrace();
            activity.displayMessage("Authentication failed.");
            return false;
        } catch (MessagingException e) {
            Log.e(SendEmailAsyncTask.class.getName(), "Email failed");
            e.printStackTrace();
            activity.displayMessage("Email failed to send.");
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            activity.displayMessage("Unexpected error occured.");
            return false;
        }
    }
}
