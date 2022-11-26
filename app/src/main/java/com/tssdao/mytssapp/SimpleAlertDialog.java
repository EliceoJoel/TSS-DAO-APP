package com.tssdao.mytssapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class SimpleAlertDialog extends AppCompatDialogFragment {

    private String title;
    private String message;
    private String buttonText;

    public SimpleAlertDialog(String title, String message, String buttonText) {
        this.title = title;
        this.message = message;
        this.buttonText = buttonText;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle(this.title)
                .setMessage(this.message)
                .setPositiveButton(this.buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Do nothing, just close the dialog
                    }
                });
        return dialog.create();
    }
}
