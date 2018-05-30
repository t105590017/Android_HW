package com.example.gging.hw10;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchContact extends Fragment {

    private MainActivity mainActivity;

    private static final int MENU_ADD = Menu.FIRST,
                            MENU_SEARCH = Menu.FIRST + 1;

    public EditText medtname,
                    medtnumber,
                    medtphonetype;
    LinearLayout bg;

    public SearchContact() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search_contact, container, false);

        mainActivity = (MainActivity) this.getActivity();

        bg = view.findViewById(R.id.search_bg);
        registerForContextMenu(bg);

        medtname = view.findViewById(R.id.edt_nam_list);
        medtnumber = view.findViewById(R.id.edt_number_list);
        medtphonetype = view.findViewById(R.id.edt_phonetype_list);
        return view;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(1, MENU_ADD, 0, getResources().getString(R.string.add_new_contact));
        menu.add(1, MENU_SEARCH, 1, getResources().getString(R.string.search_contact));
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ADD:
                break;
            case MENU_SEARCH:
                mainActivity.ContactList(medtname, medtnumber, medtphonetype);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
