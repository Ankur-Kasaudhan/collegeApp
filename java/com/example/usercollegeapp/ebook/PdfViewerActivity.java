package com.example.usercollegeapp.ebook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.usercollegeapp.R;
import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Stream;

public class PdfViewerActivity extends AppCompatActivity {

    private String url;
    private PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_viewer);
        url = getIntent().getStringExtra("pdfUrl");
        pdfView = findViewById(R.id.pdfView);

        new pdfDownload().execute(url);

    }

    private class pdfDownload extends AsyncTask<String,Void, InputStream>{

        @Override
        protected InputStream doInBackground(String... strings) {
           InputStream inputStream =null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                if (httpURLConnection.getResponseCode()==200){
                    inputStream=new BufferedInputStream(httpURLConnection.getInputStream());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }


    }
}