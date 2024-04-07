package com.example.spaghettichat.chatmanager.chatlist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.spaghettichat.R;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final String[] nameArray;
    private final String[] infoArray;

    public CustomListAdapter(Activity context, String[] nameArrayParam, String[] infoArrayParam){

        super(context,R.layout.x , nameArrayParam);

        this.context=context;
        this.nameArray = nameArrayParam;
        this.infoArray = infoArrayParam;

    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View rowView=inflater.inflate(R.layout.x, null,true);

        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);

        nameTextField.setText(nameArray[position]);
        infoTextField.setText(infoArray[position]);

        return rowView;

    };}


