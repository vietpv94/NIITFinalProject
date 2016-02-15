/*
 * Copyright (c) $2015. Just For Fun :)
 *//*


package niitprogram.jacksparrow.developer.application.niitfinalproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

*/
/**
 * Created by Jack Sparrow on 6/1/2015.
 *//*

public class JackSparrowImageLoader {
    MemoryCache jackSparrowCache;
    FileCache fileCache;
    private Map<ImageView,String> imageViewStringMap= Collections.synchronizedMap(new WeakHashMap<ImageView, String>());*/
/*Các yếu tố trong một weak hashmap  có thể được phục hồi bởi các bộ thu rác thải nếu không có Strong Ref khác cho đối tượng, điều này làm cho chúng hữu ích cho việc lưu trữ cache / tra cứu*//*

    ExecutorService executorService;

    public JackSparrowImageLoader(Context mContext) {
        fileCache=new FileCache(mContext);
        executorService= Executors.newFixedThreadPool(5);
    }
    final int stub_id=R.drawable.no_image;
    public void DisplayJackSparrowImage(String url,ImageView imageView){
         imageViewStringMap.put(imageView,url);
        Bitmap bitmap =jackSparrowCache.get(url);
        if (bitmap!=null){
            imageView.setImageBitmap(bitmap);
        }else {
            queuePhoto(imageView,url);
        }

    }
 */
/*   private void queuePhoto(ImageView imageView,String url)
    {
        PhotoToLoad p=new PhotoToLoad(url, imageView);
        executorService.submit(new PhotosLoader(p));
    }*//*

    //Nhiệm vụ cho các hàng đợi
    private class PhotoToLoad
    {
        public String url;
        public ImageView imageView;
        public PhotoToLoad(String u, ImageView i){
            url=u;
            imageView=i;
        }
    }
  */
/*  private Bitmap getBitmap(String url){
        File jackFile=fileCache.getFile(url);
        //khoi phuc laj anh de khoi phai load lai tu Sd Cache
        Bitmap bitmap=decodeFile(jackFile);
        if (bitmap!=null){
            return  bitmap;
        }
        try{
            Bitmap jackMap=null;
            URL imageUrl=new URL(url);
            HttpURLConnection jackConnection=(HttpURLConnection)imageUrl.openConnection();
            jackConnection.setConnectTimeout(30000);
            jackConnection.setReadTimeout(30000);
            jackConnection.setInstanceFollowRedirects(true);
            InputStream is=jackConnection.getInputStream();
            OutputStream os=new FileOutputStream(jackFile);
            Utils.CopyStream(is,os);
            os.close();
            jackMap=decodeFile(jackFile);
            return jackMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }*//*


    private Bitmap decodeFile(File jackFile) {
        try {
            // kích thước hình ảnh giải mã
            BitmapFactory.Options jackSparrowOption=new BitmapFactory.Options();
            jackSparrowOption.inJustDecodeBounds=true;
            BitmapFactory.decodeStream(new FileInputStream(jackFile),null,jackSparrowOption);

            final int REQUIRED_SIZE=70;
            int width_tmp=jackSparrowOption.outWidth,height_tmp=jackSparrowOption.outHeight;
            int scale=1;
            while (true){
                if(width_tmp/2<REQUIRED_SIZE || height_tmp/2<REQUIRED_SIZE)
                    break;
                width_tmp/=2;
                height_tmp/=2;
                scale*=2;
            }
            //giải mã với inSampleSize
            BitmapFactory.Options vietPhamOption=new BitmapFactory.Options();
            vietPhamOption.inSampleSize=scale;
            return BitmapFactory.decodeStream(new FileInputStream(jackFile),null,vietPhamOption);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

*/
/*

    class PhotosLoader implements Runnable {
        PhotoToLoad photoToLoad;
        PhotosLoader(PhotoToLoad photoToLoad){
            this.photoToLoad=photoToLoad;
        }

        @Override
        public void run() {
            if(imageViewReused(photoToLoad))
                return;
            Bitmap bmp=getBitmap(photoToLoad.url);
            jackSparrowCache.put(photoToLoad.url, bmp);
            if(imageViewReused(photoToLoad))
                return;
            BitmapDisplayer bd=new BitmapDisplayer(bmp, photoToLoad);
            Activity a=(Activity)photoToLoad.imageView.getContext();
            a.runOnUiThread(bd);
        }
    }
*//*


    private boolean imageViewReused(PhotoToLoad photoToLoad) {
        String tag=imageViewStringMap.get(photoToLoad.imageView);
        if(tag==null || !tag.equals(photoToLoad.url))
            return true;
        return false;
    }
    */
/*sử dụng để hiển thị bitmap trong thread UI*//*

    class BitmapDisplayer implements Runnable
    {
        Bitmap bitmap;
        PhotoToLoad photoToLoad;
        public BitmapDisplayer(Bitmap b, PhotoToLoad p){bitmap=b;photoToLoad=p;}
        public void run()
        {
            if(imageViewReused(photoToLoad))
                return;
            if(bitmap!=null)
                photoToLoad.imageView.setImageBitmap(bitmap);
            else
                photoToLoad.imageView.setImageResource(stub_id);
        }
    }
    public void clearCache() {
        jackSparrowCache.clear();
        fileCache.clear();
    }
}
*/
