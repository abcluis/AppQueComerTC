package com.itchihuahuaii.quecomer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itchihuahuaii.quecomer.R;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>{


    ArrayList<Ingredient> ingredients;
    Context context;
    String available_ingredients = "";

    public IngredientAdapter(ArrayList<Ingredient> ingredients, Context context){
        this.ingredients = ingredients;
        this.context = context;
    }

    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_ingredient,parent,false);

        return new IngredientViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final IngredientViewHolder holder, final int position) {
        final Ingredient ingredient = ingredients.get(position);

        holder.txt_ingredient_name.setText(ingredient.getName());
        holder.txt_ingredient_description.setText(ingredient.getDescription());

        Picasso.with(context)
                .load(ingredient.getImage())
                .into(holder.img_ingredient);

        holder.cbx_ingredient_available.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    available_ingredients = available_ingredients.concat(String.valueOf(ingredient.getId()) + ',');
                }else{
                    available_ingredients = available_ingredients.replace(String.valueOf(ingredient.getId()) + ',',"");
                }
            }
        });
    }

    public String getAvailableIngredients(){
        return available_ingredients;
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    public static class IngredientViewHolder extends RecyclerView.ViewHolder{

        TextView txt_ingredient_name;
        TextView txt_ingredient_description;
        ImageView img_ingredient;
        CheckBox cbx_ingredient_available;

        public IngredientViewHolder(View itemView){
            super(itemView);
            txt_ingredient_name = (TextView) itemView.findViewById(R.id.txt_ingredient_name);
            txt_ingredient_description = (TextView) itemView.findViewById(R.id.txt_ingredient_description);
            img_ingredient = (ImageView) itemView.findViewById(R.id.img_ingredient);
            cbx_ingredient_available = (CheckBox) itemView.findViewById(R.id.cbx_ingredient_available);
        }

    }

}
