package com.uw.aakarsh.htmlparser;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    Button parseButton;
    String urlFinal;
    String result = null;
    String done;

    public View.OnClickListener buttonListener = new View.OnClickListener() {
        public void onClick (View view){
            urlFinal = editText.getText().toString();
            new getText().execute();
        }};


    public class getText extends AsyncTask<String, Void, String> {


        @Override
        protected String doInBackground(String... strings) {


            Document doc;
            try {
                doc = Jsoup.connect(urlFinal).get();
                done = doc.getAllElements().toString();
            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplication(), "Bad URL", Toast.LENGTH_LONG);
            }
                //Elements info = doc.getAllElements();
                //for (Element i : info)
                  //  result += i.text().toString();



            return null;
        }

        public void onPostExecute(String result) {
            textView.setText(done.toString());

        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        parseButton = (Button) findViewById(R.id.parseButton);
        parseButton.setOnClickListener(buttonListener);

    }

}






