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
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String DB_TABLE = "Contact";

    private SQLiteDatabase mContactDB;

    private class PageAdapter extends FragmentPagerAdapter {

        PageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new AddNewContact();
                case 1:
                    return new SearchContact();
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

    private static final int MENU_ADD = Menu.FIRST,
                            MENU_SEARCH = Menu.FIRST + 1;

    public void ContactAdd(String name, String number, String phonetype){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("number", number);
        contentValues.put("phonetype", phonetype);
        mContactDB.insert(DB_TABLE, null, contentValues);
    }

    public void ContactList(EditText editname, EditText editnumber, EditText editphonetype) {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPageAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.viewPage);
        mViewPager.setAdapter(mPageAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);

        ContactDbOpenHelper contactDbOpenHelper = new ContactDbOpenHelper(getApplicationContext(),DB_TABLE, null, 1);
        mContactDB = contactDbOpenHelper.getWritableDatabase();

        registerForContextMenu(mViewPager);
    }

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
