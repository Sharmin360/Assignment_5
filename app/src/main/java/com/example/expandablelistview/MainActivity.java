package com.example.expandablelistview;

import android.media.session.PlaybackState;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private CustomAdapter customAdapter;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareListData();
        expandableListView= findViewById(R.id.expandable_Id);
        customAdapter=new CustomAdapter(this,listDataHeader,listDataChild);
        expandableListView.setAdapter(customAdapter);
        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                String groupName=listDataHeader.get(i);
                Toast.makeText(getApplicationContext(),groupName,Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }

    public void prepareListData()
    {
        String[] headerString=getResources().getStringArray(R.array.abbreviations_list_header);
        String[] childString=getResources().getStringArray(R.array.abbreviations_list_child);

        listDataHeader=new ArrayList<>();
        listDataChild=new HashMap<>();

        for(int i=0; i<headerString.length; i++)
        {
            listDataHeader.add(headerString[i]);
            List<String> child= new ArrayList<>();
            child.add(childString[i]);
            listDataChild.put(listDataHeader.get(i),child);
        }
    }
}