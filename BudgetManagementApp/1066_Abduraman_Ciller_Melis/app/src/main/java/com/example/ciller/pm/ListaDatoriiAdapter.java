package com.example.ciller.pm;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.ciller.pm.DebtDetails;
import com.example.ciller.pm.R;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.List;

/**
 * Created by Ciller on 12/2/2017.
 */

public class ListaDatoriiAdapter extends ArrayAdapter<DebtDetails> {
    private List<DebtDetails>listaDatorii;
    private int idLayout;

    public ListaDatoriiAdapter(@NonNull Context context, int resource, @NonNull List<DebtDetails> objects) {
        super(context, resource, objects);
        idLayout = resource;
        listaDatorii = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater li = LayoutInflater.from(getContext());
        View view = li.inflate(this.idLayout, parent, false);

        TextView nameTV = (TextView)view.findViewById(R.id.numeTV);
        TextView categoryTV = (TextView)view.findViewById(R.id.categoryTV);
        TextView amountTV = (TextView)view.findViewById(R.id.amountTV);
        TextView unitTV = (TextView)view.findViewById(R.id.unitTV);
        TextView dayCreatedTV  = (TextView)view.findViewById(R.id.dayCreatedTV1);
        TextView monthCreatedTV = (TextView)view.findViewById(R.id.monthCreatedTV);
        TextView yearCreatedTV = (TextView)view.findViewById(R.id.yearCreatedTV);
        TextView dayDueTV = (TextView)view.findViewById(R.id.dayDueTV);
        TextView monthDueTV = (TextView)view.findViewById(R.id.monthDueTV);
        TextView yearDueTV =  (TextView)view.findViewById(R.id.yearDueTV);
        TextView paymentTV  = (TextView) view.findViewById(R.id.paymentTV1);
        TextView descriptionTV = (TextView)view.findViewById(R.id.descriptionTV);
        Switch reminderTV =(Switch)view.findViewById(R.id.reminderTV1);


        DebtDetails debt = listaDatorii.get(position);

        nameTV.setText(debt.getName());
        categoryTV.setText(debt.getCategory());
        amountTV.setText(debt.getAmount());
        unitTV.setText(debt.getUnit());
        dayCreatedTV.setText(Integer.toString(debt.getCreatedDay()));
        monthCreatedTV.setText(Integer.toString(debt.getCreatedMonth()));
        yearCreatedTV.setText(Integer.toString(debt.getCreatedYear()));
        dayDueTV.setText(Integer.toString(debt.getDueDay()));
        monthDueTV.setText(Integer.toString(debt.getDueMonth()));
        yearDueTV.setText(Integer.toString(debt.getDueYear()));
        paymentTV.setText(debt.getPayment());
        descriptionTV.setText(debt.getDescription());
        reminderTV.setChecked(debt.isReminder());
        return view;


    }

}
