package com.reag.application;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NextActivity extends AppCompatActivity {
    ListView listView;
    final String ATTRIBUTE_NAME_IMAGE = "image";

    Button send;
    EditText address, subject, emailtext;
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_next);

            // Наши поля и кнопка
            send = (Button) findViewById(R.id.emailsendbutton);
            address = (EditText) findViewById(R.id.emailaddress);
            subject = (EditText) findViewById(R.id.emailsubject);
            emailtext = (EditText) findViewById(R.id.emailtext);

            send.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);

                    emailIntent.setType("plain/text");
                    // Кому
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[] { address.getText().toString() });
                    // Зачем
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                            subject.getText().toString());
                    // О чём
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
                            emailtext.getText().toString());


                    emailIntent.setType("text/video");
                    // Поехали!
                    NextActivity.this.startActivity(Intent.createChooser(emailIntent,
                            "Отправка письма..."));
                }
            });
        }
    }


