package com.itchihuahuaii.quecomer.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.itchihuahuaii.quecomer.R;
import com.itchihuahuaii.quecomer.RecipeActivity;
import com.itchihuahuaii.quecomer.RecipeDetailActivity;
import com.itchihuahuaii.quecomer.pojo.Recipe;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/26/2017.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.TitularViewHolder>{

    ArrayList<Recipe> recipes;
    RecipeActivity context;

    public RecipeAdapter(ArrayList<Recipe> recipes, RecipeActivity context){
        this.recipes = recipes;
        this.context = context;
        context.getSwipeRefreshLayout().setRefreshing(false);
    }


    @Override
    public TitularViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_recipe,parent,false);
        return new TitularViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TitularViewHolder holder, final int position) {
        Recipe recipe = recipes.get(position);

        holder.txt_name.setText(recipe.getName());
        holder.txt_description.setText(recipe.getDescription());
        holder.txt_price.setText(String.valueOf("$ " + recipe.getPrice()) + " MXN");

        Picasso.with(context)
                .load(recipe.getImagen())
                .resize(300,200)
                .into(holder.img_recipe);

        holder.img_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RecipeDetailActivity.class);
                intent.putExtra("RECIPE",recipes.get(position));
                context.startActivity(intent);
                context.finish();
            }
        });

    }
    


    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class TitularViewHolder extends RecyclerView.ViewHolder{
        private TextView txt_name;
        private TextView txt_description;
        private TextView txt_price;
        private ImageView img_recipe;

        public TitularViewHolder(View itemView){
            super(itemView);
            txt_name = (TextView) itemView.findViewById(R.id.txt_name);
            txt_description = (TextView) itemView.findViewById(R.id.txt_description);
            txt_price = (TextView) itemView.findViewById(R.id.txt_price);
            img_recipe = (ImageView) itemView.findViewById(R.id.img_recipe);
        }
    }

}
