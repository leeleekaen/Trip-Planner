package nautilussoup.tripplanner.Views;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nautilussoup.tripplanner.Controllers.EventsAdapter;
import nautilussoup.tripplanner.Controllers.PeopleAdapter;
import nautilussoup.tripplanner.Models.Trip;
import nautilussoup.tripplanner.Models.Trips;
import nautilussoup.tripplanner.R;
import nautilussoup.tripplanner.RecyclerViewClickListener;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TripEventsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TripEventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TripEventsFragment extends Fragment implements RecyclerViewClickListener {
    public RecyclerView eventRecyclerView;
    private RecyclerView.Adapter eventAdapter;
    private int adapterPosition;
    private OnFragmentInteractionListener mListener;
    private Trip tripToDetail;
    private Trips trips;
    private int tripPosition;

    public TripEventsFragment() {}

    public static TripEventsFragment newInstance(int tripPosition) {
        TripEventsFragment fragment = new TripEventsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tripPosition", tripPosition);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_trip_events, container, false);

        trips = Trips.getInstance();

        if (getArguments() != null) {
            tripPosition = getArguments().getInt("tripPosition");
            tripToDetail = trips.getTripList().get(tripPosition);
        }

        //create the recyclerview
        eventRecyclerView = (RecyclerView) rootView.findViewById(R.id.rvPeople);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        eventRecyclerView.setHasFixedSize(false);
        // use a linear layout manager
        LinearLayoutManager llm = new LinearLayoutManager(rootView.getContext());
        eventRecyclerView.setLayoutManager(llm);

        // specify an adapter (see also next example)
        eventAdapter = new EventsAdapter(rootView.getContext(), tripToDetail, this);
        eventRecyclerView.setAdapter(eventAdapter);

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void recyclerViewListClicked(View v, int position) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}