package niitprogram.jacksparrow.developer.application.niitfinalproject;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

/**
 * Created by Jack Sparrow on 6/1/2015.
 */
public class CustomizedListview extends ActionBarActivity {
    /* Khai bao bien Hang*/
    static final String URL = "http://10.0.3.2:8080/AndroidNIIT/GetCategory.php?Id=";


    static final String KEY_ID = "id";
    static final String KEY_NAME = "name";
    static final String KEY_SUMARY = "sumary";
    static final String KEY_DATE = "date";
    static final String KEY_IMAGE = "image";

    ListView listNews;
    JackSparrowAdapter jackSparrowAdapter;
    ArrayList<JackSparrowArticle> articleList;
    JackSparrowJsonParser jackSparrowXMLParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy =
                    new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        articleList = new ArrayList<JackSparrowArticle>();
        Intent intentReceiver= getIntent();

        Bundle bundleReceiver=intentReceiver.getBundleExtra("ShipHang");
        String idReceived=bundleReceiver.getString("ID");
        createData(idReceived);
        listNews = (ListView) findViewById(R.id.list);
        jackSparrowAdapter = new JackSparrowAdapter(this, R.layout.list_row, articleList);
        listNews.setAdapter(jackSparrowAdapter);

        listNews.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("mytag", "Viet dep trai");
                JackSparrowArticle mJackSparrowArticle=articleList.get(position);
                String articleId=mJackSparrowArticle.getId();
                Log.d("mytag", "Viet dep trai"+articleId);
                Bundle mBundle=new Bundle();
                mBundle.putString("ArticleID",articleId);
                Intent newsDetail = new Intent(CustomizedListview.this, JackSparrowNewsDetails.class);
                newsDetail.putExtra("ShipID",mBundle);
                startActivity(newsDetail);
            }
        });
    }

    private JackSparrowArticle getArticleInfo(JSONObject jsonObject) {
        JackSparrowArticle info = new JackSparrowArticle();
        try {

            String jackName=jsonObject.getString(KEY_NAME);
            int jackId = jsonObject.getInt(KEY_ID);
            String jackSumary = jsonObject.getString(KEY_SUMARY);
            String jackWhenCreated = jsonObject.getString(KEY_DATE);
            String jackImage = jsonObject.getString(KEY_IMAGE);

            info.setSumary(jackSumary + "");
            info.setId(jackId + "");
            info.setName(jackName + "");
            info.setImage(jackImage + "");
            info.setDate(jackWhenCreated + "");
        } catch (Exception e) {

        }
        return info;
    }

    public void createData(String id) {
        try {
            jackSparrowXMLParser = new JackSparrowJsonParser(CustomizedListview.this);
            String xml = jackSparrowXMLParser.getXmnFromUrl(URL + id);
            JSONArray jsonArray = new JSONArray(xml);
            Log.d("mytag",jsonArray.length()+"");
            for(int i=0;i<jsonArray.length();i++) {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                JackSparrowArticle info = getArticleInfo(jsonObject);
                articleList.add(info);
            }
        } catch (Exception e) {
            Log.e("Error:","loi fuck");
        }
    }
}
