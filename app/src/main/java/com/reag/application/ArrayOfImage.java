package com.reag.application;

import android.widget.Switch;



public class ArrayOfImage {

    public static int numberOfArrey ;
    public static int [] getArray () {
        switch (numberOfArrey){
            case ContentMainActivity.PROMOTION_CONST:
                int[] arrayImage = new int[]{R.drawable.home, R.drawable.internet, R.drawable.home, R.drawable.internet, R.drawable.home, R.drawable.internet, R.drawable.phone};
                return arrayImage;
            case ContentMainActivity.SPECIALOFFER_CONST:
                int[] arrayImage1 = new int[]{ R.drawable.call_finish, R.drawable.home, R.drawable.internet, R.drawable.home, R.drawable.internet, R.drawable.phone};
                return arrayImage1;
        }

        return null;
    }
}
