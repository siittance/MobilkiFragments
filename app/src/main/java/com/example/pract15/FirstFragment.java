package com.example.pract15;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {

    TextView tv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        tv = view.findViewById(R.id.text_view);
        registerForContextMenu(tv);

        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info){
        super.onCreateContextMenu(menu, v, info);
        getActivity().getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int Id = item.getItemId();
        if (Id == R.id.first) {
            tv.setText("Добрый день");
            return true;
        } else if (Id == R.id.second) {
            tv.setText("Добрый вечер");
            return true;
        }
        else if (Id == R.id.third){
            tv.setText("Доброй ночи");
            return true;
        }
        return false;
    }
}
