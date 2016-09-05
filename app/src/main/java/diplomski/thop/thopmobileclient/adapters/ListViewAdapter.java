package diplomski.thop.thopmobileclient.adapters;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.model.Constants;

public class ListViewAdapter extends BaseAdapter {

    public ArrayList<HashMap<String, String>> list;
    Activity activity;

    public ListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list) {
        super();
        this.activity = activity;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView txtFirst;
        TextView txtSecond;
        TextView txtThird;
        TextView txtSixth;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.colmn_row, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.TextFirst);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.TextSecond);
            holder.txtThird = (TextView) convertView.findViewById(R.id.TextThird);
            holder.txtSixth = (TextView) convertView.findViewById(R.id.TextSixth);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> map = list.get(position);
        holder.txtFirst.setText(map.get(Constants.FIRST_COLUMN));
        holder.txtSecond.setText(map.get(Constants.SECOND_COLUMN));
        holder.txtThird.setText(map.get(Constants.THIRD_COLUMN));
        holder.txtSixth.setText(map.get(Constants.SIXTH_COLUMN));
        return convertView;
    }

}
