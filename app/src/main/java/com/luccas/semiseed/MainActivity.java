package com.luccas.semiseed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.luccas.semiseed.customview.GradeItemView;
import com.luccas.semiseed.customview.GridViewAdapter;

public class MainActivity extends AppCompatActivity {

    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        grid = (GridView) findViewById(R.id.grid_view);
        grid.setAdapter(new GridViewAdapter(this));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sobre_seed_item:
                Toast.makeText(this, "Sobre o Seed", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_item:
                GradeItemView grade = new GradeItemView(this);
                grade.setCropText("Added");
                GridViewAdapter gridViewAdapter = (GridViewAdapter) grid.getAdapter();
                gridViewAdapter.addGradeView(grade);
                gridViewAdapter.notifyDataSetChanged();
                grid.setAdapter(gridViewAdapter);
                break;
            default:
                break;
        }
        return true;
    }
}
