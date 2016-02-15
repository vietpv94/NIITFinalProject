/*
 * Copyright (c) $2015. Just For Fun :)
 */

package niitprogram.jacksparrow.developer.application.niitfinalproject;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Jack Sparrow on 6/5/2015.
 */
public class Main extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void showFootballEnglandNew(View view){
        if(!isNetworkConnected())
        {
            Toast.makeText(Main.this, "Bạn cần mở kết nối internet", Toast.LENGTH_LONG).show();
            return;
        }
        Intent englandFootball = new Intent(Main.this,CustomizedListview.class) ;
        Bundle mBundle=new Bundle();
        mBundle.putString("ID","1");
        englandFootball.putExtra("ShipHang",mBundle);
        startActivity(englandFootball);
    }
    public void showFootballVNNew(View view){
        if(!isNetworkConnected())
        {
            Toast.makeText(Main.this, "Bạn cần mở kết nối internet", Toast.LENGTH_LONG).show();
            return;
        }
        Intent vietnamFootball=new Intent(Main.this,CustomizedListview.class) ;
        Bundle mBundle=new Bundle();
        mBundle.putString("ID","6");
        vietnamFootball.putExtra("ShipHang",mBundle);
        startActivity(vietnamFootball);
    }
    public void showFootballYNew(View view){
        if(!isNetworkConnected())
        {
            Toast.makeText(Main.this, "Bạn cần mở kết nối internet", Toast.LENGTH_LONG).show();
            return;
        }
        Intent yFootball=new Intent(Main.this,CustomizedListview.class) ;
        Bundle mBundle=new Bundle();
        mBundle.putString("ID","3");
        yFootball.putExtra("ShipHang", mBundle);
        startActivity(yFootball);
    }
    public void showFootballSpanNew(View view){
        if(!isNetworkConnected())
        {
            Toast.makeText(Main.this, "Bạn cần mở kết nối internet", Toast.LENGTH_LONG).show();
            return;
        }
        Intent spanFootball=new Intent(Main.this,CustomizedListview.class) ;
        Bundle mBundle=new Bundle();
        mBundle.putString("ID","2");
        spanFootball.putExtra("ShipHang",mBundle);
        startActivity(spanFootball);
    }
    public void showFootballUEFANew(View view){
        if(!isNetworkConnected())
        {
            Toast.makeText(Main.this, "Bạn cần mở kết nối internet", Toast.LENGTH_LONG).show();

            return;
        }
        Intent uefaFootball=new Intent(Main.this,CustomizedListview.class) ;
        Bundle mBundle=new Bundle();
        mBundle.putString("ID","4");
        uefaFootball.putExtra("ShipHang",mBundle);
        startActivity(uefaFootball);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            return false;
        } else
            return true;
    }
}
