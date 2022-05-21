package com.example.uxsession;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment {
    TextView name;
    TextView type;
    TextView price;
    ImageView image;

    private final String[]productName = ProductInfo.name;
    private final int[] productImage = ProductInfo.image;
    private final String[] productPrice = ProductInfo.price;
    private final String[] productType = ProductInfo.type;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View contentView = inflater.inflate(R.layout.fragment_product, container, false);

        ListView listView = contentView.findViewById(R.id.listView);

        List<String> list = new ArrayList<>();
        for(int i=0;i<productImage.length;i++)
            list.add("Item "+i);

        CustomAdapter listAdapter = new CustomAdapter(list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener((arg0, arg1, position, arg3) -> {
            // TODO Auto-generated method stub
            OpenDetails(position);
        });
        return contentView;
    }

    private class CustomAdapter extends BaseAdapter {

        public CustomAdapter(List<String> list) {
        }

        @Override
        public int getCount() {
            return productImage.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.product_layout, null);
            name = view.findViewById(R.id.productName);
            type = view.findViewById(R.id.productType);
            price = view.findViewById(R.id.productPrice);
            image = view.findViewById(R.id.productImage);
            name.setText(productName[position]);
            type.setText(productType[position]);
            price.setText(productPrice[position]);
            image.setImageResource(productImage[position]);

            return view;
        }
    }

    //get position of item on listview click
    protected void OpenDetails(int position)
    {
        View view = getLayoutInflater().inflate(R.layout.product_layout, null);
        name = view.findViewById(R.id.productName);
        type = view.findViewById(R.id.productType);
        price = view.findViewById(R.id.productPrice);
        image = view.findViewById(R.id.productImage);
        Intent intent = new Intent(getActivity(), ProductDetails.class);
        String order = Integer.toString(position);
        intent.putExtra("row",order);
        intent.putExtra("position",position);
        startActivity(intent);
    }

}