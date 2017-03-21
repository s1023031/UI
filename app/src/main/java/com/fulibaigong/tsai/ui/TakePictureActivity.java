package com.fulibaigong.tsai.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;

import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TakePictureActivity extends AppCompatActivity {

    ImageView imvB,imvT;
    Bitmap bmpB;
    String sharePath;
    Uri imgUri;
    View vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_picture);
        imvB = (ImageView)findViewById(R.id.imvB);
        imvT = (ImageView)findViewById(R.id.imvT);

        Intent itc = getIntent();
        String uri = itc.getStringExtra("datab");
        int imageResource = getResources().getIdentifier(uri, null, getPackageName()); //取得圖片Resource位子
        imvT.setImageResource(imageResource);

        imvT.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public void onTakePicture(View view)
    {
        Intent it = new Intent (MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it, 200);
        vv=view;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        imvT.setBackground(null);
        imvB.setBackground(null);
        if(resultCode == Activity.RESULT_OK )
        {
            if(requestCode == 200)
            {
                Bundle extras = data.getExtras();
                bmpB = (Bitmap)extras.get("data");
                imvB.setImageBitmap(bmpB);
                imvT.setBackground(null);

                //---------------------

                Bitmap finBmp = null;
                View rootView ;

                rootView = vv.getRootView();
                rootView.setDrawingCacheEnabled(true);
                rootView.buildDrawingCache();

                Bitmap bitmap = rootView.getDrawingCache();
                finBmp = (Bitmap)ImageCrop(bitmap);


                String path = "/sdcard/Picture";
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdir();
                }

                try{
                    String name = "p" + System.currentTimeMillis() + ".png";
                    String filename = "/sdcard/Picture/" + name;

                    sharePath = filename;
                    String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
                    imgUri = Uri.parse("file://"+dir+"/"+name);

                    FileOutputStream outputStream = new FileOutputStream(imgUri.getPath());
                    finBmp.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
                    try {

                        outputStream.flush();
                        outputStream.close();
                        Toast.makeText(this, "截图已经成功保存", Toast.LENGTH_SHORT)
                                .show();


                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        Toast.makeText(this,"NNNNNNNNNNNNN",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e){
                    Toast.makeText(this,"HHHHH",Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                rootView.destroyDrawingCache(); // 一定要清空 不然會重複上次的截圖
                //---------------------
                /*imvB.setMaxWidth(bmpB.getWidth());
                imvB.setMaxHeight(bmpB.getHeight());*/
            }
        }
        else
            Toast.makeText(this, "沒有拍到照片", Toast.LENGTH_LONG).show();
    }


    public  Bitmap ImageCrop(Bitmap bitmap)
    {
        int[] location = new int[2];
        imvT.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        int w = imvT.getWidth(); // 得到图片的宽，高
        int h = imvT.getHeight();
        //下面这句是关键
        return Bitmap.createBitmap(bitmap, x, y, w, h, null, false);
    }

    public void onMerge(View view) throws IOException {
        Bitmap finBmp = null;
        View rootView ;

        rootView = view.getRootView();
        rootView.setDrawingCacheEnabled(true);
        rootView.buildDrawingCache();

        Bitmap bitmap = rootView.getDrawingCache();
        finBmp = (Bitmap)ImageCrop(bitmap);


        String path = "/sdcard/Picture";
        File file = new File(path);
        if (!file.exists()) {
            file.mkdir();
        }

        try{
            String name = "p" + System.currentTimeMillis() + ".png";
            String filename = "/sdcard/Picture/" + name;

            sharePath = filename;
            String dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            imgUri = Uri.parse("file://"+dir+"/"+name);

            FileOutputStream outputStream = new FileOutputStream(imgUri.getPath());
            finBmp.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            try {

                outputStream.flush();
                outputStream.close();
                Toast.makeText(this, "截图已经成功保存", Toast.LENGTH_SHORT)
                        .show();


            } catch (IOException e) {
                // TODO Auto-generated catch block
                Toast.makeText(this,"NNNNNNNNNNNNN",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        } catch (FileNotFoundException e){
            Toast.makeText(this,"HHHHH",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
        rootView.destroyDrawingCache(); // 一定要清空 不然會重複上次的截圖
    }


    public void onShare(View v)
    {
        if(sharePath!=null)
        {
            Intent it = new Intent(Intent.ACTION_SEND);
            it.setType("image/*");
            it.putExtra(Intent.EXTRA_STREAM, imgUri);
            startActivity(it);
        }
    }
}
