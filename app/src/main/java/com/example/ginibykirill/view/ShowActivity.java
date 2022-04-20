package com.example.ginibykirill.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.ginibykirill.R;
import com.example.ginibykirill.model.Post;

import java.util.Map;
import java.util.TreeMap;

public class ShowActivity extends AppCompatActivity {
    int[] arrayFromPost;
    Map<Integer,Boolean> resultList = new TreeMap<Integer,Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        takeIntent();
        checkColorOfNumbers(arrayFromPost);
        createActivity();
    }

    public Map<Integer, Boolean> checkColorOfNumbers(int[] array) {
            int currentKey;
            boolean currentValue;

            for (int i = 0; i <array.length; i++){
                resultList.put(array[i], false);
                }

            for (Map.Entry<Integer, Boolean> entry : resultList.entrySet()){
                currentKey = entry.getKey();
                if(currentKey==0 || resultList.containsKey(-1 * currentKey)){
                    resultList.put(currentKey, true);
                }
            }
        return  resultList;
    }

    public void takeIntent(){
        Bundle extras = getIntent().getExtras();
        arrayFromPost = extras.getIntArray("data");
    }

    public void createActivity(){
        int i = 0;
        TableLayout tableLayout = new TableLayout(this);
        TableRow tableRow1 = new TableRow(this);
        for (Map.Entry<Integer, Boolean> entry : resultList.entrySet()) {
            if (i % 3 == 0)
                tableRow1 = new TableRow(this);

            TextView textView1 = new TextView(this);
            textView1.setText(entry.getKey().toString());
            textView1.setHeight(100);
                if(entry.getValue()){
                    textView1.setBackgroundColor(Color.rgb(255, 0, 0));
                    tableRow1.setGravity(Gravity.CENTER_HORIZONTAL);
                    textView1.setHeight(150);
                }
                else {
                    textView1.setBackgroundColor(Color.rgb(255, 165, 0));
                }

            switch (i % 3) {
                case 0:
                    textView1.setGravity(Gravity.START);
                    textView1.setPadding(200, 0, 0, 0);
                    break;
                case 1:
                    textView1.setGravity(Gravity.CENTER);
                    break;
                case 2:
                    textView1.setGravity(Gravity.END);
                    textView1.setPadding(0, 0, 200, 0);
                    break;
            }
            tableRow1.addView(textView1, new TableRow.LayoutParams(
                    TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));
            if (i % 3 == 0) {
                tableLayout.setGravity(Gravity.FILL_HORIZONTAL);
                tableLayout.addView(tableRow1, TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);
            }
            i++;
        }
        setContentView(tableLayout);
    }
}