package com.example.uxsession;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class PurchaseDialog  extends AppCompatDialogFragment{

    int purchaseQuantity = 0;
    public PurchaseDialog(int quantity) {
        purchaseQuantity = quantity;
    }

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());

        //purchase quantity validation
        if (purchaseQuantity<1)
        {
            builder.setMessage("Purchase quantity must be more than 0 !").setPositiveButton("Return", (dialog, which) -> {
            });
        }
        else{
            builder.setMessage("Purchase Successful!").setPositiveButton("Return", (dialog, which) -> {
            });
        }
        return builder.create();
    }
}
