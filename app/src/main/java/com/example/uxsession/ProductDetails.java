package com.example.uxsession;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetails extends AppCompatActivity {
    ImageButton backBtn;
    Button purchaseBtn;
    TextView productName,productPrice,productDesc;
    ImageView productImage;
    EditText purchaseQuantity;


    private final String[] name = ProductInfo.name;
    private final String[] price = ProductInfo.price;
    private final String[] desc = ProductInfo.desc;
    private final int[] image = ProductInfo.image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        findViews();

        //get position from intent, then display the data according to the position
        Intent intent = getIntent();
        int selected = intent.getIntExtra("position",0);
        productName.setText(name[selected]);
        productPrice.setText(price[selected]);
        productDesc.setText(desc[selected]);
        productImage.setImageResource(image[selected]);

        backBtn = findViewById(R.id.backButton);
        backBtn.setOnClickListener(v -> finish());

        //purchase Button click
        purchaseBtn.setOnClickListener(v -> {

            String quant = purchaseQuantity.getText().toString();
            int value =getQuantity(quant);
            openDialogue(value);
        });
    }

    public int getQuantity(String quantity)
    {
        try{
            return Integer.parseInt(quantity);
        }catch (Exception ex)
        {
            return 0;
        }
    }
    public void openDialogue(int quantity)
    {
        PurchaseDialog purchaseDialog = new PurchaseDialog(quantity);

        purchaseDialog.show(getSupportFragmentManager(),"wow");
    }

    protected void findViews()
    {
        productName = findViewById(R.id.productDetailName);
        productPrice = findViewById(R.id.productDetailPrice);
        productDesc = findViewById(R.id.productDetailDesc);
        productImage = findViewById(R.id.productDetailImage);
        purchaseBtn = findViewById(R.id.purchaseButton);
        purchaseQuantity = findViewById(R.id.purchaseInput);
    }
}