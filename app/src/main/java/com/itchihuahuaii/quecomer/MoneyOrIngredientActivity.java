package com.itchihuahuaii.quecomer;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.itchihuahuaii.quecomer.adapter.MoneyIngredientAdapter;

public class MoneyOrIngredientActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_or_ingredient);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter adapter = new MoneyIngredientAdapter(this);
        viewPager.setAdapter(adapter);
    }

}
