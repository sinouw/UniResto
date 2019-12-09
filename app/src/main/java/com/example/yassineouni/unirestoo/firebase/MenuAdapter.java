package com.example.yassineouni.unirestoo.firebase;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yassineouni.unirestoo.R;
import com.example.yassineouni.unirestoo.models.Menu;
import com.example.yassineouni.unirestoo.ui.addmenu.AddMenuFragment;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

	ArrayList<Menu> menus;

	private FirebaseDatabase mFirebaseDatabase;

	private DatabaseReference mDatabaseRef;

	private ChildEventListener mChildEventListener;

	public MenuAdapter() {

		mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;

		mDatabaseRef = FirebaseUtil.mDatabaseRef;

		menus = FirebaseUtil.menus;

		mChildEventListener =  new ChildEventListener() {

			@Override
			public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

				Menu menu =  dataSnapshot.getValue(Menu.class);

				Log.i("MenusAdapter", menu.getTitle());

				menu.setId(dataSnapshot.getKey());

				menus.add(menu);

				notifyItemInserted(menus.size() - 1);

			}

			@Override
			public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

			}

			@Override
			public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

			}

			@Override
			public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

			}

			@Override
			public void onCancelled(@NonNull DatabaseError databaseError) {

			}
		};

		mDatabaseRef.addChildEventListener(mChildEventListener);
	}

	@NonNull
	@Override
	public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		Context context = parent.getContext();

		View itemView = LayoutInflater.from(context).inflate(R.layout.menu_row, parent, false);

		return  new MenuViewHolder(itemView);
	}

	@Override
	public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
		Menu menu = menus.get(position);

		holder.bind(menu);
	}

	@Override
	public int getItemCount() {
		return menus.size();
	}

	public class MenuViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		TextView textTitle, textDescription, textDate;

		public MenuViewHolder(@NonNull View itemView) {
			super(itemView);

			textTitle = itemView.findViewById(R.id.text_menu_title);

			textDescription = itemView.findViewById(R.id.text_menu_description);

			textDate = itemView.findViewById(R.id.text_menu_date);

			itemView.setOnClickListener(this);


		}

		public void bind(Menu menu) {
			textTitle.setText(menu.getTitle());

			textDate.setText("TND "+ menu.getType());

			textDescription.setText(menu.getDescription());
		}

		@Override
		public void onClick(View v) {
			int position = getAdapterPosition();

			Menu selectedMenu = menus.get(position);

			Intent i = new Intent(v.getContext(), AddMenuFragment.class);

			i.putExtra("Menu", selectedMenu);


			v.getContext().startActivity(i);

		}
	}
}
