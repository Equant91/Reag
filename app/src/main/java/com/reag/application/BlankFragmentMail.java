package com.reag.application;

import android.app.Activity;
import android.content.Context;
import android.icu.util.GregorianCalendar;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static android.support.v4.content.ContextCompat.getSystemService;


public class BlankFragmentMail extends Fragment implements View.OnClickListener, BlankFragment.onSomeEventListener{

BlankFragment.onSomeEventListener someEventListener;
    FirebaseDatabase database;
    DatabaseReference myRef;

    java.util.GregorianCalendar date;

    private static final String ARG_PARAM1 = "param1";
    public static int Int_0_MailOr_1_Phone;
    private String mParam1;

    Button buttonSendFireBase;
    EditText editTextSend;


    public BlankFragmentMail() {
        // Required empty public constructor
    }


    public static BlankFragmentMail newInstance(String param1) {
        BlankFragmentMail fragment = new BlankFragmentMail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
        database = FirebaseDatabase.getInstance(); //////////////////////////////FireBase
        myRef = database.getReference();

        date = new java.util.GregorianCalendar();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment_mail, container, false);

        buttonSendFireBase = view.findViewById(R.id.buttonSendFireBase);
        buttonSendFireBase.setOnClickListener(this);


        editTextSend = view.findViewById(R.id.eTextSend);
if (Int_0_MailOr_1_Phone == 0) {
    editTextSend.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    editTextSend.setHint("Введите свой Email");
}
   else if(Int_0_MailOr_1_Phone == 1){
    editTextSend.setInputType(InputType.TYPE_CLASS_PHONE);
    editTextSend.setHint("Введите свой номер телефона");

}



        return view;
    }


    public void onButtonPressed(Uri uri) {
       /* if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }*//////////////////////////////////////////
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            someEventListener = (BlankFragment.onSomeEventListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implements onSomeEventListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        someEventListener = null;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonSendFireBase) {
           DateFormat formatter = new SimpleDateFormat("HH:mm");
            String string = formatter.format(date.getTime()) + " - " + editTextSend.getText().toString() ;
            myRef.push().setValue(string);
            Toast.makeText(getActivity(), "Отправлено", Toast.LENGTH_SHORT).show();
            editTextSend.setText("");
someEventListener.someEvent(ContentMainActivity.BACK_HOME);



        }
    }

    @Override
    public void someEvent(int i) {

    }
}
