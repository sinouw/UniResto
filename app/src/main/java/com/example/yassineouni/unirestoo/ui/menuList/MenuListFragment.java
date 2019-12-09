package com.example.yassineouni.unirestoo.ui.menuList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yassineouni.unirestoo.R;
import com.example.yassineouni.unirestoo.firebase.FirebaseUtil;
import com.example.yassineouni.unirestoo.firebase.MenuAdapter;

public class MenuListFragment extends Fragment {
    private RecyclerView lsMenus;
    private MenuListViewModel menuListViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        menuListViewModel =
                ViewModelProviders.of(this).get(MenuListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_menulist, container, false);
//        final TextView textView = root.findViewById(R.id.text_menuList);
        menuListViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        FirebaseUtil.openFbReference("menus", getActivity());

        lsMenus.findViewById(R.id.ls_menus);

        final MenuAdapter adapter = new MenuAdapter();

        lsMenus.setAdapter(adapter);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        lsMenus.setLayoutManager(mLayoutManager);
        return root;
    }
}