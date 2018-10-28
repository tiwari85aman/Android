package com.example.aman.vituallab;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        checkInternetConnectivity();
                        imageToApp("https://cdn.earlytorise.com/wp-content/uploads/2017/06/youtube-logo-full-color.png");
                    }
                }
        );



    }

    private void imageToApp(String urlstr){
        //ProgressDialog progressDialog= ProgressDialog.show(this,"Downloading from "+urlstr);
        final String url=urlstr;

        new Thread(){
            public void run(){
                InputStream in =null;
                Message msg = Message.obtain();
                msg.what=1;

                try{
                    in =openHttpConnection(url);
                    Bitmap bitmap= BitmapFactory.decodeStream(in);
                    Bundle b = new Bundle();
                    b.putParcelable("bitmap", bitmap);
                    msg.setData(b);
                    in.close();

                }catch (IOException e1) {
                    e1.printStackTrace();
                }
                messageHandler.sendMessage(msg);
            }
        }.start();
    }

    private InputStream openHttpConnection(String urlStr) {
        InputStream in = null;
        int resCode = -1;
        try {
            URL url = new URL(urlStr);
            URLConnection urlConn = url.openConnection();
            if (!(urlConn instanceof HttpURLConnection)) {
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpConn = (HttpURLConnection) urlConn;
            httpConn.setAllowUserInteraction(false);
            httpConn.setInstanceFollowRedirects(true);
            httpConn.setRequestMethod("GET");
            httpConn.connect();
            resCode = httpConn.getResponseCode();
            if (resCode == HttpURLConnection.HTTP_OK) {
                in = httpConn.getInputStream();
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return in;
    }

    private Handler messageHandler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            img.setImageBitmap((Bitmap) (msg.getData().getParcelable("bitmap")));
            //progressDialog.dismiss();
        }
    };

    private void display(String text){
        Toast.makeText(getBaseContext(),"now--",Toast.LENGTH_SHORT).show();
        Toast.makeText(getBaseContext(),text,Toast.LENGTH_SHORT).show();
    }

    private void checkInternetConnectivity() {
        Context context =this;
        ConnectivityManager check=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info=check.getAllNetworkInfo();

        for(int i=0;i<info.length;i++){
            if(info[i].getState()==NetworkInfo.State.CONNECTED){
                display("Internet is connected");
            }

        }
    }
}
