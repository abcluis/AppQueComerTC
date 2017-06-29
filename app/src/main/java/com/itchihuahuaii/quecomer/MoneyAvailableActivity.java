package com.itchihuahuaii.quecomer;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.aigestudio.wheelpicker.WheelPicker;
import com.itchihuahuaii.quecomer.intent.IntentActivity;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryMoney;

import java.util.ArrayList;
import java.util.List;

public class MoneyAvailableActivity extends AppCompatActivity {

    private Activity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money_available);
        context = this;
        initializeWheelPickerMoney();
    }

    public void initializeWheelPickerMoney(){
        WheelPicker wheelPicker = (WheelPicker) findViewById(R.id.picker_money);
        final List<Integer> lista = new ArrayList<>();
        for (int i=50;i<150;i+=5){
            lista.add(i);
        }
        wheelPicker.setData(lista);

        wheelPicker.setOnItemSelectedListener(new WheelPicker.OnItemSelectedListener() {
            @Override
            public void onItemSelected(WheelPicker picker, Object data, int position) {
                QueryMoney.setMoneyAvailable(getApplicationContext(),lista.get(position));
                IntentActivity.startRecipeActivity(context);
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            IntentActivity.startMoneyOrIngredient(this);
        }
        return super.onKeyDown(keyCode, event);
    }
}
