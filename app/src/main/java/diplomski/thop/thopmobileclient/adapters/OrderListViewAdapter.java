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


public class OrderListViewAdapter extends BaseAdapter{

    public static final String ID_COLUMN="ID";
    public static final String ORDERED_BY_COLUMN="Ordered by";
    public static final String ADRESS_COLUMN="Adress";
    public static final String ORDER_DATE_COLUMN="Order Date";
    public static final String NOTES_COLUMN = "Additional Notes";
    public static final String STATUS_COLUMN = "Status";

    public ArrayList<HashMap<String, String>> list;
    Activity activity;

    public OrderListViewAdapter(Activity activity, ArrayList<HashMap<String, String>> list){
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
        return 0;
    }

    private class ViewHolder{
        TextView txtID;
        TextView txtOrderedBy;
        TextView txtAdress;
        TextView txtOrderDate;
        TextView txtAdditionalNotes;
        TextView txtStatus;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();
        if(convertView != null){
            convertView = inflater.inflate(R.layout.order_layout, null);
            holder = new ViewHolder();
            holder.txtID = (TextView)convertView.findViewById(R.id.orderID);
            holder.txtOrderedBy = (TextView)convertView.findViewById(R.id.orderedBy);
            holder.txtAdress = (TextView)convertView.findViewById(R.id.adress);
            holder.txtOrderDate = (TextView)convertView.findViewById(R.id.orderDate);
            holder.txtAdditionalNotes = (TextView)convertView.findViewById(R.id.additionalNotes);
            holder.txtStatus = (TextView)convertView.findViewById(R.id.status);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        HashMap<String, String> map = list.get(position);
        holder.txtID.setText(map.get(ID_COLUMN));
        holder.txtID.setText(map.get(ORDERED_BY_COLUMN));
        holder.txtID.setText(map.get(ADRESS_COLUMN));
        holder.txtID.setText(map.get(ORDER_DATE_COLUMN));
        holder.txtID.setText(map.get(NOTES_COLUMN));
        holder.txtID.setText(map.get(STATUS_COLUMN));


        return convertView;
    }
}
