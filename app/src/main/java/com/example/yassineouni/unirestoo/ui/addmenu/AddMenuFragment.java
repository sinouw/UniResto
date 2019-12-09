package com.example.yassineouni.unirestoo.ui.addmenu;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.yassineouni.unirestoo.R;
import com.example.yassineouni.unirestoo.firebase.FirebaseUtil;
import com.example.yassineouni.unirestoo.models.Menu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddMenuFragment extends Fragment {
    private FirebaseDatabase mFirebaseDatabase;

    private DatabaseReference mDatabaseRef;

    private static final String TAG = "Add Menu";

    EditText title, date, description;
    ImageView v;
    TextView dateM;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    Menu menu;


    private AddMenuViewModel sendViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(AddMenuViewModel.class);
        View root = inflater.inflate(R.layout.fragment_addmenu, container, false);
//        final TextView textView = root.findViewById(R.id.text_send);
        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

// instance of firebase
        FirebaseUtil.openFbReference("menus", getActivity());

        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;

        mDatabaseRef = FirebaseUtil.mDatabaseRef;

        title.findViewById(R.id.text_menu_title);

        date.findViewById(R.id.text_menu_date);

        description.findViewById(R.id.text_menu_description);

        Intent intent = getActivity().getIntent();

        Menu menu = (Menu) intent.getSerializableExtra("Deal");

        if (menu == null) {
            menu = new Menu();
        }

        this.menu = menu;

        title.setText(menu.getTitle());
        description.setText(menu.getDescription());
        date.setText(menu.getDateMenu().toString());
        return root;
    }
}