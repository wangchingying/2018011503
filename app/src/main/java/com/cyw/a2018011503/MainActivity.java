package com.cyw.a2018011503;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //SharedPreferences 將資料存入手機, Key -> Value, 此case的Key就是data1, 有點像Hashmap
    //用Tools下的Android Device Monitor 找 File explore, 裡面的Data內的Data, 再找專案名稱, 裡面有Shared_Pref, 裡面的mydata.xml
    public void clickWrite(View v)
    {
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        EditText ed = (EditText) findViewById(R.id.editText);
        editor.putString("data1", ed.getText().toString());
        editor.commit();
    }
    //SharedPreferences 將資料從手機讀出
    public void clickRead(View v)
    {
        SharedPreferences sp = getSharedPreferences("mydata", MODE_PRIVATE);
        String str = sp.getString("data1", "");
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(str);
    }

}
