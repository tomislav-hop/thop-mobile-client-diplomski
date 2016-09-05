package diplomski.thop.thopmobileclient.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import diplomski.thop.thopmobileclient.R;
import diplomski.thop.thopmobileclient.model.Constants;

public class ListViewAdapterItems extends BaseAdapter {

    public ArrayList<HashMap<String, String>> list;
    Activity activity;

    public ListViewAdapterItems(Activity activity, ArrayList<HashMap<String, String>> list) {
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
        TextView txtFourth;
        TextView txtFifth;
        TextView txtSixth;
        TextView txtSeventh;
        TextView txtEigth;
        TextView txtNinth;
        TextView txtTenth;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.colmn_row_items, null);
            holder = new ViewHolder();
            holder.txtFirst = (TextView) convertView.findViewById(R.id.TextFirst);
            holder.txtSecond = (TextView) convertView.findViewById(R.id.TextSecond);
            holder.txtThird = (TextView) convertView.findViewById(R.id.TextThird);
            holder.txtFourth = (TextView) convertView.findViewById(R.id.TextFourth);
            holder.txtFifth = (TextView) convertView.findViewById(R.id.TextFifth);
            holder.txtSixth = (TextView) convertView.findViewById(R.id.TextSixth);
            holder.txtSeventh = (TextView) convertView.findViewById(R.id.TextSeventh);
            holder.txtEigth = (TextView) convertView.findViewById(R.id.TextEigth);
            holder.txtNinth = (TextView) convertView.findViewById(R.id.TextNinth);
            holder.txtTenth = (TextView) convertView.findViewById(R.id.TextTenth);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HashMap<String, String> map = list.get(position);
        holder.txtFirst.setText(map.get(Constants.FIRST_COLUMN));
        holder.txtSecond.setText(map.get(Constants.SECOND_COLUMN));
        holder.txtThird.setText(map.get(Constants.THIRD_COLUMN));
        holder.txtFourth.setText(map.get(Constants.FOURTH_COLUMN));
        holder.txtFifth.setText(map.get(Constants.FIFTH_COLUMN));
        holder.txtSixth.setText(map.get(Constants.SIXTH_COLUMN));

        holder.txtSeventh.setText(map.get(Constants.SEVENTH_COLUMN));
        holder.txtEigth.setText(map.get(Constants.EIGTH_COLUMN));
        holder.txtNinth.setText(map.get(Constants.NINTH_COLUMN));
        holder.txtTenth.setText(map.get(Constants.TENTH_COLUMN));
        return convertView;
    }

}
