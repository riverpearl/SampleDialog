package com.tacademy.sampledialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by Tacademy on 2016-08-02.
 */
public class MyPopupWindow extends PopupWindow {

    public MyPopupWindow(final Context context) {
        super(context);

        View view = LayoutInflater.from(context).inflate(R.layout.popup_button_menu, null);
        setContentView(view);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setOutsideTouchable(true);

        Button btn = (Button)view.findViewById(R.id.btn_yes);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Yes click", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
}
