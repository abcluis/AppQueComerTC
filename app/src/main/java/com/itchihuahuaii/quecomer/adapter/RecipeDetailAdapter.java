package com.itchihuahuaii.quecomer.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.itchihuahuaii.quecomer.R;
import com.itchihuahuaii.quecomer.RecipeActivity;
import com.itchihuahuaii.quecomer.RecipeDetailActivity;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.pojo.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/28/2017.
 */

public class RecipeDetailAdapter extends RecyclerView.Adapter<RecipeDetailAdapter.TitularViewHolder>{

    ArrayList<Ingredient> ingredients;
    Context context;

    public RecipeDetailAdapter(ArrayList<Ingredient> ingredients, Context context){
        this.ingredients = ingredients;
        this.context = context;
    }


    @Override
    public TitularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recipe_detail,parent,false);
        return new TitularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TitularViewHolder holder, final int position) {
        Ingredient ingredient = ingredients.get(position);

        holder.txt_ingredient_name.setText(ingredient.getName());
        holder.txt_ingredient_quantity.setText(String.valueOf(ingredient.getQuantityIngredient()));
        holder.txt_ingredient_meassure.setText(ingredient.getMeasure());
        Picasso.with(context)
                .load(ingredient.getImage())
                .placeholder(R.drawable.toolbar)
                .into(holder.img_ingredient);

    }



    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class TitularViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_ingredient_name;
        private TextView txt_ingredient_quantity;
        private TextView txt_ingredient_meassure;
        private ImageView img_ingredient;


        public TitularViewHolder(View itemView){
            super(itemView);
            txt_ingredient_name = (TextView) itemView.findViewById(R.id.txt_ingredient_name);
            txt_ingredient_quantity = (TextView) itemView.findViewById(R.id.txt_ingredient_quantity);
            txt_ingredient_meassure = (TextView) itemView.findViewById(R.id.txt_ingredient_meassure);
            img_ingredient = (ImageView) itemView.findViewById(R.id.img_ingredient);


        }
    }

}
