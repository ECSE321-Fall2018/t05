package ca.mcgill.ecse321.android_passenger;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem listItem = listItems.get(position);

        holder.textViewDistance.setText(listItem.getDistance()+"KM"); //set heading of current item in list to heading in interface
        holder.textViewVehicleModel.setText(listItem.getVehicleModel()); //set description of current item in list to description in interface
        holder.textViewPrice.setText("$"+listItem.getPrice());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewDistance;
        public TextView textViewVehicleModel;
        public TextView textViewPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewDistance = (TextView) itemView.findViewById(R.id.textViewDistance);
            textViewVehicleModel = (TextView) itemView.findViewById(R.id.textViewVehicleModel);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPrice);

        }
    }
}
