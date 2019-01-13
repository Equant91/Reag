package com.reag.application;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ContentMainActivity extends AppCompatActivity  implements BlankFragment.onSomeEventListener, View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener, BlankFragment.OnFragmentInteractionListener{

    BlankFragment fragmentMain = null;
    BlankFragmentNext fragmentNext = null;
    BlankFragmentMail fragmentMail = null;

    android.app.FragmentManager fragmentManager;
    android.app.FragmentTransaction fragmentTransaction;

    ImageButton buttonVK, buttonPhone0, buttonSite, buttonHome, buttonMail, buttonPhone, buttonPhoneMe;
    TextView textView, textView2;
    Animation animationCallShow, animationCallMeShow, animationCallHide, animationCallMeHide;

  ArrayOfStringFragment ValueStringFragment = new ArrayOfStringFragment();


    public static final int PROMOTION_CONST = 0;
    public static final int SPECIALOFFER_CONST = 1;
    public static final int BACK_HOME = 50;

    boolean booPhone0 = true;
    private static String FRAGMENT_INSTANCE_NAME = "fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentMain = (BlankFragment) fragmentManager.findFragmentByTag(FRAGMENT_INSTANCE_NAME);

        fragmentNext = new BlankFragmentNext();
        fragmentMail = new BlankFragmentMail();


        if (fragmentMain == null) {
            fragmentMain = new BlankFragment();


            fragmentTransaction.add(R.id.conteiner, fragmentMain, FRAGMENT_INSTANCE_NAME);
            ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragment);
            fragmentTransaction.commit();
        }

        animationCallShow = AnimationUtils.loadAnimation(this, R.anim.animation_show_for_button_call);
        animationCallMeShow = AnimationUtils.loadAnimation(this, R.anim.animation_show_for_button_call_me);
        animationCallHide = AnimationUtils.loadAnimation(this, R.anim.animation_hide_for_button_call);
        animationCallMeHide = AnimationUtils.loadAnimation(this, R.anim.animation_hide_for_button_call_me);

        buttonVK = findViewById(R.id.iButtonVK);
        buttonPhone0 = findViewById(R.id.iButtonPhone);
        buttonPhone = findViewById(R.id.buttonPhone);
        buttonPhoneMe = findViewById(R.id.buttonPhoneMe);
        buttonSite = findViewById(R.id.iButtonSait);
        buttonHome = findViewById(R.id.iButtonHome);
        buttonMail = findViewById(R.id.iButtonMail);
        textView = findViewById(R.id.textView3);
        textView2 = findViewById(R.id.textView4);

        buttonHome.setOnClickListener(this);
        buttonVK.setOnClickListener(this);
        buttonPhone0.setOnClickListener(this);
        buttonPhone.setOnClickListener(this);
        buttonPhoneMe.setOnClickListener(this);
        buttonSite.setOnClickListener(this);
        buttonMail.setOnClickListener(this);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {
            ValueStringFragment.deleteStringFragment();
            super.onBackPressed();

        }
    }
/////////////////////////////////////////////////////////
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
switch (id){
    case R.id.home_menu:
        onButtonHomePressed();
        break;
    case R.id.special_offer_menu:
        OnButtonSpecialOfferPressed();
        Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();
        break;
    case R.id.exit:
        finish();
        break;
       
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    @Override
    public void onFragmentInteraction(Uri uri) {

    }





    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {

            case R.id.iButtonVK:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://vk.me/enspirion"));
                startActivity(intent);
                break;

            case R.id.iButtonPhone: ///////////////////////////центральная кнопка
               onButtonPhonePressed();
                break;

            case R.id.buttonPhone:
                intent = new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:89876543210"));
                startActivity(intent);
                onButtonPhonePressed();
                break;
            case R.id.buttonPhoneMe:
                if (ValueStringFragment.getStringFragment() != ValueStringFragment.ValueBlankFragmentMailPhone) {
                    if (ValueStringFragment.getStringFragment() == ValueStringFragment.ValueBlankFragmentMailMail) {
                        fragmentMail = new BlankFragmentMail();

                    }
                    BlankFragmentMail.Int_0_MailOr_1_Phone = 1;
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.conteiner, fragmentMail);
                    fragmentTransaction.addToBackStack("frag");
                    ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragmentMailPhone);
                    fragmentTransaction.commit();
                    onButtonPhonePressed();
                }
                break;
            case R.id.iButtonSait:
              /* intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://Enspirion.ru"));
                startActivity(intent);*/
                Toast.makeText(this, "asd"+ValueStringFragment.getStringFragment(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.iButtonHome:
              onButtonHomePressed();
                break;

            case R.id.iButtonMail:
                if (ValueStringFragment.getStringFragment() != ValueStringFragment.ValueBlankFragmentMailMail) {
                    if (ValueStringFragment.getStringFragment() == ValueStringFragment.ValueBlankFragmentMailPhone) {
                        fragmentMail = new BlankFragmentMail();

                    }
                    BlankFragmentMail.Int_0_MailOr_1_Phone = 0;
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.conteiner, fragmentMail);
                    fragmentTransaction.addToBackStack("frag");
                    ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragmentMailMail);
                    fragmentTransaction.commit();
                    break;
                }
        }
    }




    @Override
    public void someEvent(int button) {

        switch (button) {
            case PROMOTION_CONST:
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.conteiner, fragmentNext);
                fragmentTransaction.addToBackStack("frag");
                ArrayOfImage.numberOfArrey = PROMOTION_CONST;
                ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragmentNext);
                fragmentTransaction.commit();
                break;
            case SPECIALOFFER_CONST:

               OnButtonSpecialOfferPressed();
                break;
            case BACK_HOME:
                onBackPressed();

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(buttonPhoneMe.getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragment); ;

        }

    }



    /////////////////////////////////////////////////////////////////// цунтральная кнопка
    private void onButtonPhonePressed(){
        if (booPhone0 == true) {

            buttonPhone.startAnimation(animationCallShow);
            textView.startAnimation(animationCallShow);
            buttonPhoneMe.startAnimation(animationCallMeShow);
            textView2.startAnimation(animationCallMeShow);



            booPhone0 = false;


        } else {


            buttonPhone.startAnimation(animationCallHide);
            textView.startAnimation(animationCallHide);
            buttonPhoneMe.startAnimation(animationCallMeHide);
            textView2.startAnimation(animationCallMeHide);
            booPhone0 = true;
        }
    }
    private void onButtonHomePressed() {        ///////////////////////////////////////////////////////////кнопки домой
        if (ValueStringFragment.getStringFragment() != ValueStringFragment.ValueBlankFragment){
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.conteiner, fragmentMain);
            fragmentTransaction.addToBackStack("frag");
            ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragment);
            fragmentTransaction.commit();


        }
        else
            Toast.makeText(this, "Вы уже дома.", Toast.LENGTH_SHORT).show();
    }


    private void OnButtonSpecialOfferPressed() {////////////////////////////////// кнопка спец предложение
        if (ValueStringFragment.getStringFragment() != ValueStringFragment.ValueBlankFragmentNext) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.conteiner, fragmentNext);
            fragmentTransaction.addToBackStack("frag");
            ArrayOfImage.numberOfArrey = SPECIALOFFER_CONST;
            ValueStringFragment.addStringFragment(ValueStringFragment.ValueBlankFragmentNext);
            ;
            fragmentTransaction.commit();
        }
    }

}