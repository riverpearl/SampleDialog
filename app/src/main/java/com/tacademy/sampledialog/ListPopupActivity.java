package com.tacademy.sampledialog;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListPopupWindow;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

public class ListPopupActivity extends AppCompatActivity {

    ListPopupWindow listPopup;
    ArrayAdapter<String> mAdapter;
    EditText keywordView;

    boolean isForced = false;
    Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_popup);

        keywordView = (EditText)findViewById(R.id.edit_keyword);
        listPopup = new ListPopupWindow(this);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        listPopup.setAdapter(mAdapter);
        listPopup.setAnchorView(keywordView);
        listPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = mAdapter.getItem(i);
                isForced = true;
                keywordView.setText(text);
                isForced = false;
                listPopup.dismiss();
            }
        });

        keywordView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isForced) return;

                final String text = charSequence.toString();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String[] list = { text+"01", text+"02", text+"03" };
                        mAdapter.clear();
                        mAdapter.addAll(list);
                        listPopup.show();
                    }
                }, 500);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
