package com.example.uxsession;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;


public class HomeFragment extends Fragment {
    private final String[]imageName = ProductInfo.name;
    private final String[] imageType = ProductInfo.type;
    private final int[] imageImg = ProductInfo.image;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //Set username
        TextView userNameDisplay;
        String userName = null;
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        Bundle getUsername = getArguments();
        userNameDisplay = view.findViewById(R.id.userNameDisplay);
        if (getUsername != null)
        {
            userName = getUsername.getString("uName");
        }
        userNameDisplay.setText(userName+'!');

        //Image slider buttons
        ImageButton previous,next;
        previous = (ImageButton) view.findViewById(R.id.previousImage);
        next =(ImageButton) view.findViewById(R.id.nextImage);

        //View Flipper config
        ViewFlipper viewFlipper;
        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewFlipper);
        viewFlipper.setInAnimation(this.getContext(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this.getContext(),android.R.anim.slide_out_right);
        viewFlipper.setFlipInterval(5000);
        viewFlipper.startFlipping();

        //Click previous button
        previous.setOnClickListener(v -> {
            viewFlipper.setInAnimation(this.getContext(),android.R.anim.slide_in_left);
            viewFlipper.setOutAnimation(this.getContext(),android.R.anim.slide_out_right);

            viewFlipper.showPrevious();
            viewFlipper.stopFlipping();
            viewFlipper.setFlipInterval(5000);
            viewFlipper.startFlipping();

        });

        //Click next button
        next.setOnClickListener(v -> {
            viewFlipper.setInAnimation(this.getContext(),R.anim.slide_in_right);
            viewFlipper.setOutAnimation(this.getContext(),R.anim.slide_out_left);
            viewFlipper.showNext();
            viewFlipper.stopFlipping();
            viewFlipper.setFlipInterval(5000);
            viewFlipper.startFlipping();
        });

        //Input data for the carousel
        TextView name1,name2,name3,name4;
        TextView type1,type2,type3,type4;
        ImageView image1,image2,image3,image4;

        name1 = (TextView) view.findViewById(R.id.SliderName1);
        name2 = (TextView) view.findViewById(R.id.SliderName2);
        name3 = (TextView) view.findViewById(R.id.SliderName3);
        name4 = (TextView) view.findViewById(R.id.SliderName4);

        type1 = (TextView) view.findViewById(R.id.SliderType1);
        type2 = (TextView) view.findViewById(R.id.SliderType2);
        type3 = (TextView) view.findViewById(R.id.SliderType3);
        type4 = (TextView) view.findViewById(R.id.SliderType4);

        image1 = (ImageView) view.findViewById(R.id.SliderImage1);
        image2 = (ImageView) view.findViewById(R.id.SliderImage2);
        image3 = (ImageView) view.findViewById(R.id.SliderImage3);
        image4 = (ImageView) view.findViewById(R.id.SliderImage4);

        name1.setText(imageName[0]);
        type1.setText(imageType[0]);
        image1.setImageResource(imageImg[0]);

        name2.setText(imageName[1]);
        type2.setText(imageType[1]);
        image2.setImageResource(imageImg[1]);

        name3.setText(imageName[3]);
        type3.setText(imageType[3]);
        image3.setImageResource(imageImg[3]);

        name4.setText(imageName[2]);
        type4.setText(imageType[2]);
        image4.setImageResource(imageImg[2]);

        return view;
    }


}