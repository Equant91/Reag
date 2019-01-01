package com.reag.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class BlankFragment extends Fragment implements View.OnClickListener {



    public interface onSomeEventListener{
        public void someEvent(int i);
    }
    onSomeEventListener someEventListener;


    ImageButton buttonSpecialOffer, buttonPromotion;

    private OnFragmentInteractionListener mListener;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);

        buttonPromotion = view.findViewById(R.id.iButtonPromotion);
        buttonSpecialOffer = view.findViewById(R.id.iButtonSpecialOffer);

        buttonSpecialOffer.setOnClickListener(this);
        buttonPromotion.setOnClickListener(this);

        return view;
    }




    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            someEventListener = (onSomeEventListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString()+ "must implements onSomeEventListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

switch (v.getId()){

    case R.id.iButtonSpecialOffer:
        someEventListener.someEvent(ContentMainActivity.SPECIALOFFER_CONST);
                break;
    case R.id.iButtonPromotion:
        someEventListener.someEvent(ContentMainActivity.PROMOTION_CONST);
        break;
        }


    }



    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
