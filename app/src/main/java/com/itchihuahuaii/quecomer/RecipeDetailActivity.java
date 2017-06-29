package com.itchihuahuaii.quecomer;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.itchihuahuaii.quecomer.Interfaces.IRecipeActivity;
import com.itchihuahuaii.quecomer.Interfaces.IRecipeDetailActivity;
import com.itchihuahuaii.quecomer.adapter.RecipeDetailAdapter;
import com.itchihuahuaii.quecomer.intent.IntentActivity;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.pojo.Recipe;
import com.itchihuahuaii.quecomer.presenter.RecipeDetailActivityPresenter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecipeDetailActivity extends AppCompatActivity implements IRecipeDetailActivity{


    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        Recipe recipe = (Recipe) getIntent().getSerializableExtra("RECIPE");

        ImageView img_toolbar = (ImageView) findViewById(R.id.img_toolbar);

        Picasso.with(this)
                .load(recipe.getImagen())
                .placeholder(R.drawable.toolbar)
                .into(img_toolbar);
        initializeToolbar();
        initializeCollapsing(recipe.getName());

        TextView txt_recipe_description = (TextView) findViewById(R.id.txt_recipe_description);
        TextView txt_recipe_process = (TextView) findViewById(R.id.txt_recipe_process);
        txt_recipe_description.setText(recipe.getDescription());
        txt_recipe_process.setText(recipe.getProcess());

        lista = (RecyclerView) findViewById(R.id.recycler_recipe_detail);
        new RecipeDetailActivityPresenter(this,this,recipe.getId());

    }

    public void initializeCollapsing(String title){
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(title);

    }

    public void initializeToolbar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            IntentActivity.startRecipeActivity(this);;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                IntentActivity.startRecipeActivity(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void generarLinearLayout() {
        lista.setLayoutManager(new LinearLayoutManager(this));
        //lista.setLayoutManager(new GridLayoutManager(this,getResources().getInteger(R.integer.columns_grid_layout_manager)));
    }

    @Override
    public void initializeAdapter(ArrayList<Ingredient> ingredients) {
        RecipeDetailAdapter adapter = new RecipeDetailAdapter(ingredients,this);
        lista.setAdapter(adapter);
    }
}
