package com.tacademy.sampledialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PopupActivity extends AppCompatActivity {

    MyPopupWindow popup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        popup = new MyPopupWindow(this);
        Button btn = (Button)findViewById(R.id.btn_popup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.showAsDropDown(view);
            }
        });


    }
}
