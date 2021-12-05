package com.example.multiplicationtableapp1to20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> arrayList=new ArrayList<>(); //Create ArrayList
        for(int i=1;i<11;i++) {
            arrayList.add(10+" x "+i+" = "+(10*i));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
        ((ListView) findViewById(R.id.listView)).setAdapter(arrayAdapter); //set arrayAdapter into ListView
        //below code, click on listView item, open another page
        ((ListView) findViewById(R.id.listView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str1=((TextView) view).getText().toString();
                Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT).show();
            }
        });
        ((SeekBar) findViewById(R.id.seekBar)).setMax(20);
        ((SeekBar) findViewById(R.id.seekBar)).setProgress(10);
        ((SeekBar) findViewById(R.id.seekBar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int a1=((SeekBar) findViewById(R.id.seekBar)).getProgress();
                ((TextView) findViewById(R.id.textView3)).setText("Selected Number = "+a1);
                ArrayList<String> arrayList=new ArrayList<>(); //Create ArrayList
                for(int j=1;j<11;j++) {
                    arrayList.add(a1+" x "+j+" = "+(a1*j));
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,arrayList);
                ((ListView) findViewById(R.id.listView)).setAdapter(arrayAdapter); //set arrayAdapter into ListView
                //below code, click on listView item, open another page
                ((ListView) findViewById(R.id.listView)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        String str1=((TextView) view).getText().toString();
                        Toast.makeText(MainActivity.this, str1, Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //none
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //none
            }
        });
    }
}
