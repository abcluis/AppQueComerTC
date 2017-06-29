package com.itchihuahuaii.quecomer;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.itchihuahuaii.quecomer.Interfaces.IIngredientActivity;
import com.itchihuahuaii.quecomer.adapter.IngredientAdapter;
import com.itchihuahuaii.quecomer.intent.IntentActivity;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.presenter.IngredientActivityPresenter;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryIngredient;

import java.util.ArrayList;

public class IngredientActivity extends AppCompatActivity implements IIngredientActivity{

    private final String TITLE_ACTIVITY = "Ingredientes";

    private RecyclerView lista;
    private IngredientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredient);
        lista = (RecyclerView) findViewById(R.id.recycler_ingredient);
        initializeCollapsing();
        new IngredientActivityPresenter(this,this);
    }

    public void startRecipeActivity(View v){
        if(validateIngredientsAvailable(adapter.getAvailableIngredients())){
            String ingredients_available = adapter.getAvailableIngredients().substring(0,adapter.getAvailableIngredients().length()-1);
            QueryIngredient.setIngredientAvailable(this,ingredients_available);
            IntentActivity.startRecipeActivity(this);
        }else {
            Snackbar.make(v,"Selecciona al menos un ingrediente",Snackbar.LENGTH_SHORT).show();
        }
    }

    public boolean validateIngredientsAvailable(String ingredients){
        return ingredients.length()>0;
    }

    public void initializeCollapsing(){
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(TITLE_ACTIVITY);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            IntentActivity.startMoneyOrIngredient(this);;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void generateGridLayout() {
        lista.setLayoutManager(new GridLayoutManager(this,getResources().getInteger(R.integer.columns_grid_layout_manager)));
        lista.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initializeAdapter(ArrayList<Ingredient> ingredients) {
        adapter = new IngredientAdapter(ingredients,this);
        lista.setAdapter(adapter);
    }
}
