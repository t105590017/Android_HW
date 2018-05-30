package com.example.gging.hw10;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowContentFrameStats;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String DB_TABLE = "Contact";

    private SQLiteDatabase mContactDB;

    private AddNewContact addNewContact;
    private SearchContact searchContact;

    private class PageAdapter extends FragmentPagerAdapter {

        PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    addNewContact = new AddNewContact();
                    return addNewContact;
                case 1:
                    searchContact = new SearchContact();
                    return searchContact;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.add_new_contact);
                case 1:
                    return getResources().getString(R.string.search_contact);
                default:
                    return null;
            }
        }
    }

    PageAdapter mPageAdapter;
    ViewPager mViewPager;
    SearchView mSearch;

    private static final int MENU_ADD = Menu.FIRST,
                            MENU_SEARCH = Menu.FIRST + 1;

    public void ContactAdd(String name, String number, String phonetype){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("number", number);
        contentValues.put("phonetype", phonetype);
        mContactDB.insert(DB_TABLE, null, contentValues);
    }

    public void ContactList(TextView editname, TextView editnumber, TextView editphonetype) {
        Cursor cursor = mContactDB.query(true, DB_TABLE,
                new String[]{"name", "number", "phonetype"},
                null, null, null, null, null, null);

        if (cursor == null) {
            return;
        }
        if(cursor.getCount() == 0) {
            editname.setText("沒有資料");
        }
        else {
            cursor.moveToFirst();
            editname.setText(cursor.getString(0));
            editnumber.setText(cursor.getString(1));
            editphonetype.setText(cursor.getString(2));
            while (cursor.moveToNext()) {
                editname.append("\n" + cursor.getString(0));
                editnumber.append("\n" + cursor.getString(1));
                editphonetype.append("\n" + cursor.getString(2));
            }
        }
    }

    public void SetCursorToText(Cursor cursor, TextView textView,int columnlndex) {
        if (cursor == null) {
            return;
        }
        if(cursor.getCount() == 0) {
            textView.setText("沒有資料");
        }
        else {
            cursor.moveToFirst();
            textView.setText(cursor.getString(columnlndex));
            while (cursor.moveToNext()) {
                textView.append("\n" + cursor.getString(columnlndex));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPageAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewPage);
        mViewPager.setAdapter(mPageAdapter);
        mSearch = findViewById(R.id.search);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);

        ContactDbOpenHelper contactDbOpenHelper = new ContactDbOpenHelper(getApplicationContext(),DB_TABLE, null, 1);
        mContactDB = contactDbOpenHelper.getWritableDatabase();

        registerForContextMenu(mViewPager);
        mSearch.setOnQueryTextListener(SearchOnQuery);
    }

    SearchView.OnQueryTextListener SearchOnQuery = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            Cursor cursor = null;
            if(!newText.equals("")) {
                cursor = mContactDB.query(true, DB_TABLE, new String[]{"name", "number", "phonetype"},
                        "name=" + "\"" + newText + "\"", null, null, null, null, null);

                if (cursor == null) {
                    return false;
                }
                if(cursor.getCount() == 0) {
                    searchContact.medtname.setText("沒有資料");
                    searchContact.medtnumber.setText("");
                    searchContact.medtphonetype.setText("");
                }
                else {
                    cursor.moveToFirst();
                    searchContact.medtname.setText(cursor.getString(0));
                    searchContact.medtnumber.setText(cursor.getString(1));
                    searchContact.medtphonetype.setText(cursor.getString(2));
                    while (cursor.moveToNext()) {
                        searchContact.medtname.append("\n" + cursor.getString(0));
                        searchContact.medtnumber.append("\n" + cursor.getString(1));
                        searchContact.medtphonetype.append("\n" + cursor.getString(2));
                    }
                }
            }
            return false;
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mContactDB.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_ADD, 0, getResources().getString(R.string.add_new_contact));
        menu.add(0, MENU_SEARCH, 1, getResources().getString(R.string.search_contact));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ADD:
                break;
            case MENU_SEARCH:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (menu.size() == 0) {
           onCreateOptionsMenu(menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        onOptionsItemSelected(item);
        return super.onContextItemSelected(item);
    }
}
