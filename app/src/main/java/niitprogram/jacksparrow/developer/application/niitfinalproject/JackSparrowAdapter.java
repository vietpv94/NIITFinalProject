/*
 * Copyright (c) $2015. Just For Fun :)
 */

package niitprogram.jacksparrow.developer.application.niitfinalproject;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jack Sparrow on 5/31/2015.
 */
public class JackSparrowAdapter extends ArrayAdapter<JackSparrowArticle> {
    private Context context;
    private ArrayList<JackSparrowArticle> dataObject;
    private static LayoutInflater jackSparrowInflater ;
//    public JackSparrowImageLoader sparrowImageLoader;

    public JackSparrowAdapter(Context context,int resource, ArrayList<JackSparrowArticle> dataObject) {
        super(context,resource,dataObject);
        this.context = context;
        this.dataObject = dataObject;
        jackSparrowInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
   //     sparrowImageLoader = new JackSparrowImageLoader(activity.getApplicationContext());

    }

    @Override
    public int getCount() {
        return dataObject.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder jackHolder = null;
        View jackSparrowView = convertView;

        if (convertView == null) {
            jackHolder = new ViewHolder();
            jackSparrowView = jackSparrowInflater.inflate(R.layout.list_row, null);
            jackHolder.textViewTitle = (TextView) jackSparrowView.findViewById(R.id.title);// tieu de
            jackHolder.textViewDescription = (TextView) jackSparrowView.findViewById(R.id.description);// mo ta ngan
            jackHolder.textViewWhenCreated = (TextView) jackSparrowView.findViewById(R.id.whenCreated);// ngay tao tin
            jackHolder.imageViewArticle = (ImageView) jackSparrowView.findViewById(R.id.list_image);

            jackSparrowView.setTag(jackHolder);
        } else {//khong thi lay ra tu viewholder ma nos duoc lueu
            jackHolder = (ViewHolder) jackSparrowView.getTag();
        }
         /*set gia tri cho thanh phan cau tao len Item
        * moi phan tu cau mang se duoc tao ra 1 item cau listview
        * */
        final JackSparrowArticle article = dataObject.get(position);

        //gan cac gia tri cho no' hien thi :)
        jackHolder.textViewTitle.setText(article.getName());
        jackHolder.textViewDescription.setText(article.getSumary());
        jackHolder.textViewWhenCreated.setText(article.getDate());
      //  sparrowImageLoader.DisplayJackSparrowImage(article.getThumb_url(), jackHolder.imageViewArticle);
        return jackSparrowView;
     }

    public class ViewHolder {
        public ImageView imageViewArticle;
        public TextView textViewTitle;
        public TextView textViewDescription;
        public TextView textViewWhenCreated;
    }
}
