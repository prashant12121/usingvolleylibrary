package com.freeman.volleylibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by freeman on 25/2/17.
 */

public class Mycustomadapter extends BaseAdapter{

    private Context mycontext;
    private LayoutInflater mylayoutinflator;
    private JSONArray myarrayobjectlist;

     Mycustomadapter(Context context,JSONArray myarrayobjectlist){

        this.myarrayobjectlist = myarrayobjectlist;
        mycontext = context;
        mylayoutinflator = (LayoutInflater) mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return myarrayobjectlist.length();
    }

    @Override
    public Object getItem(int i) {
        return 0;
    }

    @Override
    public long getItemId(int i) {
        return(0);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Get view for row item
        View rowView = mylayoutinflator.inflate(R.layout.list_item,viewGroup, false);
        TextView tv1 = (TextView) rowView.findViewById(R.id.tv1);
        TextView tv2 = (TextView) rowView.findViewById(R.id.tv2);
        TextView tv3 = (TextView) rowView.findViewById(R.id.tv3);

        try {
            JSONObject temp = (JSONObject) myarrayobjectlist.get(i);
            tv1.setText(temp.getString("name"));
            tv2.setText( temp.getString("username"));
            tv3.setText( temp.getString("email"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

            return rowView;
    }
}
