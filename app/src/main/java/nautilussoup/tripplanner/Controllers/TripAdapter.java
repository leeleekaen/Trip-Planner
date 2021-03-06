package nautilussoup.tripplanner.Controllers;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nautilussoup.tripplanner.Models.Trip;
import nautilussoup.tripplanner.R;
import nautilussoup.tripplanner.RecyclerViewClickListener;
import nautilussoup.tripplanner.Views.TripActivity;
import nautilussoup.tripplanner.Views.TripDetails;

public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {
    private static final String TAG = "";
    private List<Trip> trips;
    private Context context;
    private RecyclerViewClickListener itemListener;

    public class TripViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        CardView cvTrip;
        TextView tripName;
        TextView tripBudget;

        TripViewHolder(View itemView) {
            super(itemView);
            cvTrip = (CardView) itemView.findViewById(R.id.cvTrip);
            tripName = (TextView) itemView.findViewById(R.id.trip_name);
            tripBudget = (TextView) itemView.findViewById(R.id.trip_budget);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getAdapterPosition());
            Intent tripDetailsIntent = new Intent(context, TripDetails.class);
            tripDetailsIntent.putExtra("tripPosition", (Integer)getAdapterPosition());
            //Bundle mBundle = new Bundle();
            //mBundle.putSerializable(TripActivity.SER_KEY, trips.get(getAdapterPosition()));
            //tripDetailsIntent.putExtras(mBundle);
            context.startActivity(tripDetailsIntent);
        }

        @Override
        public boolean onLongClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getAdapterPosition());
            itemView.showContextMenu();
            return true;
        }
    }

    public TripAdapter(Context context, List<Trip> trips, RecyclerViewClickListener itemListener) {
        this.context = context;
        this.itemListener = itemListener;
        this.trips = trips;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.content_trip, viewGroup, false);
        return new TripViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(TripViewHolder tripViewHolder, int i) {
        String budgetToSet = "Budget: " + Double.toString(
                trips.get(i).getTripBudget().getMaxBudget());
        tripViewHolder.tripName.setText(trips.get(i).getTripName());
        tripViewHolder.tripBudget.setText(budgetToSet);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return trips.size();
    }
}