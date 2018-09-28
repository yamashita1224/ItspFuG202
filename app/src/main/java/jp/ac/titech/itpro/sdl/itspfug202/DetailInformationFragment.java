package jp.ac.titech.itpro.sdl.itspfug202;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import jp.ac.titech.itpro.sdl.itspfug202.model.Restaurant;

public class DetailInformationFragment extends Fragment {

    public DetailInformationFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_detail_information, container, false);
        TextView detailName = view.findViewById(R.id.detail_shop_name);
        TextView detailAddress = view.findViewById(R.id.detail_shop_address);
        TextView mondayTime = view.findViewById(R.id.monday_time);
        TextView tuesdayTime = view.findViewById(R.id.tuesday_time);
        TextView wednesdayTime = view.findViewById(R.id.wednesday_time);
        TextView thursdayTime = view.findViewById(R.id.thursday_time);
        TextView fridayTime = view.findViewById(R.id.friday_time);
        TextView saturdayTime = view.findViewById(R.id.saturday_time);
        TextView sundayTime = view.findViewById(R.id.sunday_time);
        final Restaurant restaurant = (Restaurant) getArguments().getSerializable("restaurant");
        if(restaurant != null){
            detailName.setText(restaurant.getName());
            detailAddress.setText(restaurant.getAddress());
            mondayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.MONDAY));
            tuesdayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.TUESDAY));
            wednesdayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.WEDNESDAY));
            thursdayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.THURSDAY));
            fridayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.FRIDAY));
            saturdayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.SATURDAY));
            sundayTime.setText(restaurant.getTimeSpan(Restaurant.DayOfWeek.SUNDAY));

            Button mapButton = view.findViewById(R.id.mapbutton);
            mapButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uri = Uri.parse("geo:0,0?q="+restaurant.getAddress());
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    intent.setPackage("com.google.android.apps.maps");
                    startActivity(intent);
                }
            });
        }
        //redraw_buttonの動作
        Button redrawButton = view.findViewById(R.id.redraw_button);
        redrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RestaurantDetailActivity.class);
                intent.putExtra("random", "true");
                startActivity(intent);
            }
        });



        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
    }
}
