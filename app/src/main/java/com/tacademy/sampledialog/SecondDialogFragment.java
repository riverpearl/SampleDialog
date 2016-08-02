package com.tacademy.sampledialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

/**
 * Created by Tacademy on 2016-08-02.
 */
public class SecondDialogFragment extends DialogFragment {

    String message;

    public static SecondDialogFragment newInstance(String message) {
        SecondDialogFragment sdf = new SecondDialogFragment();
        Bundle b = new Bundle();
        b.putString("message", message);
        sdf.setArguments(b);
        return sdf;
    }

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState) {
        if (getArguments() != null)
            message = getArguments().getString("message");

        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("select item");
        builder.setMessage("item : " + message);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), "OK click", Toast.LENGTH_SHORT).show();
            }
        });

        return builder.show();
    }
}
