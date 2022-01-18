package com.example.edt30;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    List<String> array = new ArrayList<>();

    private Integer[] imageIDs = {
            R.drawable.jigg,
            R.drawable.cyn,
            R.drawable.patrat,
            R.drawable.sentret

    };
    String[] imageText = {"Jigglypuff",
    "Cyndaquil",
    "Patrat",
    "Sentret"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        for (int i = 1; i < 16; i++) {
            array.add("" + i);
        }

        /*ArrayAdapter<String> dataAdapter ;
        dataAdapter = new ArrayAdapter<>(this,
                R.layout.support_simple_spinner_dropdown_item,
                array);

        gridView.setAdapter(dataAdapter);*/

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        registerForContextMenu(gridView);



       /* @Override
        public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo
        menuInfo){
            super.onCreateContextMenu(menu, v, menuInfo);
            menu.setHeaderTitle("Choose an option");
            menu.add(0, 1, 1, "Deletes");
            menu.add(0, 2, 2, "Shares");
            menu.add(0, 3, 3, "Webs");
        }

        @Override
        public boolean onContextItemSelected (@NonNull MenuItem item){

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.item1:
                    //delete
                    return true;
                case R.id.item2:
                    //share
                    Intent i2 = new Intent(Intent.ACTION_VIEW);
                    return true;
                case R.id.item3:
                    //send mail
                    return true;
                default:
                    return super.onContextItemSelected(item);

            }
        }*/




    }

    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imageIDs.length;
        }

        @Override
        public Object getItem(int position) {
            return imageIDs[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.row_data,null);
            TextView textRow = view.findViewById(R.id.textRow);
            ImageView imageRow = view.findViewById(R.id.imageRow);
            textRow.setText(imageText[position]);
            imageRow.setImageResource(imageIDs[position]);
            return view;
        }

    }
}