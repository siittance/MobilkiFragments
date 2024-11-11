package com.example.pract15;

import static com.example.pract15.R.id.counter_text_view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView tvv;
    private int count = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                            Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        tvv = view.findViewById(R.id.counter_text_view);

        tvv.setOnClickListener(v -> PopupMenu(v));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private void PopupMenu(View view) {
        PopupMenu men = new PopupMenu(getActivity(), view);
        MenuInflater inflater = men.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, men.getMenu());



        men.setOnMenuItemClickListener(item -> {
            int Id = item.getItemId();
            if (Id == R.id.plus) {
                count++;
                tvv.setText("Счетчик: " + count);
                return true;
            } else if (Id == R.id.minus) {
                count--;
                tvv.setText("Счетчик: " + count);
            }
            return false;
        });

        men.show();
    }
}
