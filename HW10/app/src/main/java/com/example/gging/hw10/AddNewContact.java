package com.example.gging.hw10;


import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;


@SuppressLint("ValidFragment")
public class AddNewContact extends Fragment {

    private MainActivity mainActivity;

    private EditText mEdtName,
                    mEdtNumber;
    private Spinner mSpnPhoneType;

    private static final int MENU_ADD = Menu.FIRST,
                            MENU_SEARCH = Menu.FIRST + 1;

    LinearLayout bg;

    public AddNewContact() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_new_contact, container, false);

        mainActivity = (MainActivity) this.getActivity();

        bg = view.findViewById(R.id.add_bg);
        registerForContextMenu(bg);

        mEdtName = view.findViewById(R.id.edt_name);
        mEdtNumber = view.findViewById(R.id.edt_number);
        mSpnPhoneType = view.findViewById(R.id.spn_phone_type);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ADD:
                mainActivity.ContactAdd(mEdtName.getText().toString(), mEdtNumber.getText().toString(), mSpnPhoneType.getSelectedItem().toString());
                break;
            case MENU_SEARCH:
                break;
        }
        return super.onContextItemSelected(item);
    }
}
