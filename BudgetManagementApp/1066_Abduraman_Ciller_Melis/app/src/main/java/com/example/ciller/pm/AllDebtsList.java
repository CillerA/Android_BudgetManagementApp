package com.example.ciller.pm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AllDebtsList extends AppCompatActivity {

public static List<DebtDetails> datorii = new ArrayList<DebtDetails>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_debts_list);

        ListView lv = (ListView)findViewById(R.id.listViewDebts);
        ListaDatoriiAdapter adapter = new ListaDatoriiAdapter(getApplicationContext(),R.layout.row_layout, datorii);
        lv.setAdapter(adapter);
    }

    protected void metodaHarta(View view)
    {
        Intent it = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(it);

    }

}
