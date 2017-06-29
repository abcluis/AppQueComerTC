package com.itchihuahuaii.quecomer;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import com.itchihuahuaii.quecomer.Interfaces.IRecipeActivity;
import com.itchihuahuaii.quecomer.adapter.RecipeAdapter;
import com.itchihuahuaii.quecomer.intent.IntentActivity;
import com.itchihuahuaii.quecomer.pojo.Recipe;
import com.itchihuahuaii.quecomer.presenter.RecipeActivityPresenter;
import com.itchihuahuaii.quecomer.sharedpreferences.CurrentSort;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryMoney;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity implements IRecipeActivity{

    private final String TITLE_ACTIVITY = "Recetas";

    RecyclerView lista;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        setActionBar();
        initializeSwipeRefresh();
        initializeRecycler();
        initializeCollapsing();

    }
    public void setActionBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void initializeRecycler(){
        lista = (RecyclerView) findViewById(R.id.recycler);
        swipeRefreshLayout.setRefreshing(true);
        RecipeActivityPresenter recipeActivityPresenter = new RecipeActivityPresenter(this,this);
    }

    public void initializeCollapsing(){
        CollapsingToolbarLayout ctlLayout = (CollapsingToolbarLayout) findViewById(R.id.ctlLayout);
        ctlLayout.setTitle(TITLE_ACTIVITY);
    }

    public void initializeSwipeRefresh(){

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(CurrentSort.getCurrentSort(this).equals(QueryMoney.PREFERENCE_MONEY)){
                IntentActivity.startMoneyAvailable(this);
            }else {
                IntentActivity.startIngredient(this);
            }

        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    public void generateGridLayout() {
        lista.setLayoutManager(new GridLayoutManager(this,getResources().getInteger(R.integer.columns_grid_layout_manager)));
        lista.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initializeAdapter(ArrayList<Recipe> recipes) {
        RecipeAdapter adapter = new RecipeAdapter(recipes,this);
        lista.setAdapter(adapter);
    }

    public SwipeRefreshLayout getSwipeRefreshLayout(){
        return swipeRefreshLayout;
    }
}
