package com.itchihuahuaii.quecomer.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itchihuahuaii.quecomer.R;
import com.itchihuahuaii.quecomer.intent.IntentActivity;

/**
 * Created by usuario1 on 4/26/2017.
 */

public class MoneyIngredientAdapter extends PagerAdapter {

    Context context;
    int[] imageId = {R.drawable.money,R.drawable.ingredient};
    String[] textId = {"Preparar con dinero disponible","Preparar con ingredientes disponibles"};
    public MoneyIngredientAdapter(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.pager_ingredient_money,container,false);

        ImageView img_ingredient_money = (ImageView) viewItem.findViewById(R.id.img_money_ingredient);
        img_ingredient_money.setImageResource(imageId[position]);

        TextView txt_ingredient_money = (TextView) viewItem.findViewById(R.id.txt_money_ingredient);
        txt_ingredient_money.setText(textId[position]);

        img_ingredient_money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0){
                    IntentActivity.startMoneyAvailable((Activity) context);
                } else {
                    IntentActivity.startIngredient((Activity) context);
                }

            }
        });

        ((ViewPager)container).addView(viewItem);
        return viewItem;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
}
