package com.cekucek.golek;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<String> mData;
    List<String> mDataFiltered = null;

    public ListAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.mData = data;
        this.mDataFiltered = data;
    }

    @Override
    public int getCount() {
        return mDataFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_item, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.text_item);
        textView.setText(mDataFiltered.get(position));

        return  rowView;
    }

    public void filter(String text) {

        text = text.toLowerCase();
        List<String> mFiltered = new ArrayList<String>();
        if (text != null && text.length() > 0) {
            for (int i=0; i<mData.size(); i++) {
                if (mData.get(i).toLowerCase().contains(text)) {
                    mFiltered.add(mData.get(i));
                }
            }
        } else {
            mFiltered.addAll(mData);
        }
        mDataFiltered = mFiltered;
        notifyDataSetChanged();
    }
}
