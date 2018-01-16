package com.cyw.a2018011503;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //SharedPreferences 將資料存入手機, Key -> Value, 此case的Key就是data1, 有點像Hashmap
    //用Tools下的Android Device Monitor 找 File explore, 裡面的Data內的Data, 再找專案名稱, 裡面有Shared_Pref, 裡面的mydata.xml
    //右上角選磁碟片icon, 可 pull a file on the device, 存到電腦裡
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
    public void clickSetting(View v)
    {
        Intent it = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(it);
    }

    public void clickReadS(View v)
    {
        //以下兩種寫法皆可, 第二種寫法系統會自動取得default的xml檔, 第一種是自己從Android Device Monitor
        //SharedPreferences sp = getSharedPreferences("com.cyw.a2018011503_preferences", MODE_PRIVATE);
        SharedPreferences sp=getDefaultSharedPreferences(this);
        String str = sp.getString("example_text", "");//去res下的xml找UI裡的key或去檔案中找
        TextView tv1 = (TextView) findViewById(R.id.textView2);
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
        tv1.setText(str);


    }
}
