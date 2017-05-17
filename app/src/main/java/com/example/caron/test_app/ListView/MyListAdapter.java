package com.example.caron.test_app.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.caron.test_app.R;

import java.util.List;

/**
 * Created by CARON on 17/05/2017.
 */

public class MyListAdapter extends ArrayAdapter<MyList> {
    public MyListAdapter(Context context, List<MyList> list) {
        super(context, 0, list);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_theme, parent, false);
        }

        MyListViewHolder viewHolder = (MyListViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new MyListViewHolder();
            viewHolder.theme = (TextView) convertView.findViewById(R.id.theme);
            viewHolder.x = (TextView) convertView.findViewById(R.id.x);
            viewHolder.y = (TextView) convertView.findViewById(R.id.y);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        //Tweet tweet = getItem(position);
        MyList list = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.theme.setText(list.getTheme());
        viewHolder.x.setText(String.valueOf(list.getX()));
        viewHolder.y.setText(String.valueOf(list.getY()));
        viewHolder.img.setImageBitmap(list.getMyImage());
        return convertView;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

private class MyListViewHolder {
    public TextView theme;
    public TextView x;
    public TextView y;
    public ImageView img;
}

    }

