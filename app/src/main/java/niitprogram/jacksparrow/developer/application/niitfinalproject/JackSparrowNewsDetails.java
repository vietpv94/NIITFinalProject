/*
 * Copyright (c) $2015. Just For Fun :)
 */

package niitprogram.jacksparrow.developer.application.niitfinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Jack Sparrow on 6/7/2015.
 */
public class JackSparrowNewsDetails extends ActionBarActivity {
    TextView mTitle,mContent;
    JackSparrowJsonParser jackSparrowJsonParser2;
    static final String URL="http://10.0.3.2:8080/AndroidNIIT/GetNewsDetail.php?Id=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_detail);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mTitle= (TextView) findViewById(R.id.articleTitle);
        mContent= (TextView) findViewById(R.id.articleNewsDetail);

        Intent intentReceivor=getIntent();
        Bundle bundleReceivor=intentReceivor.getBundleExtra("ShipID");
        String idArticle=bundleReceivor.getString("ArticleID");
        Log.d("mytag", "Id Nhan duoc la"+ idArticle);

        jackSparrowJsonParser2=new JackSparrowJsonParser(JackSparrowNewsDetails.this);

        String jsonInfoString=jackSparrowJsonParser2.getXmnFromUrl(URL +idArticle);

        JackSparrowArticle getInfo=getArticleInfo(jsonInfoString);

        mTitle.setText(getInfo.getName());
        mContent.setText(getInfo.getContent());
    }

    private JackSparrowArticle getArticleInfo(String jsonString){
        JackSparrowArticle info=new JackSparrowArticle();
        try {
            JSONArray jsonArray=new JSONArray(jsonString);
            JSONObject jsonObject=jsonArray.getJSONObject(0);
            String titleArticle=jsonObject.getString("name");
            String contentArticle=jsonObject.getString("content");

            Log.d("mytag", "Nhan duoc la"+ titleArticle);

            info.setName(titleArticle);
            info.setContent(contentArticle);
        }
        catch (Exception e){
            Log.d("mytag", "Nhan duoc la Loi :(");
        }
        return info;
    }
}
