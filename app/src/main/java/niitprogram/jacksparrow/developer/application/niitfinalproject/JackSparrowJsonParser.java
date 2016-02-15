/*
 * Copyright (c) $2015. Just For Fun :)
 */

package niitprogram.jacksparrow.developer.application.niitfinalproject;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Created by Windows 8.1 on 6/2/2015.
 */
public class JackSparrowJsonParser  {
    private Context mContext;
    public JackSparrowJsonParser(Context context) {
        this.mContext=context;
    }

    /**
     * Lấy XML từ URL trả từ HTTP request
     *
     * @param url string
     */
    public String getXmnFromUrl(String url) {
        String articleInfo = null;
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(url);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            HttpEntity httpEntity = httpResponse.getEntity();
            articleInfo = EntityUtils.toString(httpEntity);

        }  catch (Exception ex){
            articleInfo="Can't get Information";
            Log.e("Error","loi cmnr !");
        }
        return articleInfo;
    }
}
