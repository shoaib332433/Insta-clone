package com.example.instagramclone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Userstab extends Fragment {

    public Userstab() {
        // Required empty public constructor
    }

    ListView listView;
    ArrayList arrayList;
    ArrayAdapter arrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_userstab, container, false);


        listView=v.findViewById(R.id.usersdata);
        arrayList=new ArrayList();
        arrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,arrayList);


        ParseQuery<ParseUser> parseQuery=ParseUser.getQuery();

        parseQuery.whereNotEqualTo("username",ParseUser.getCurrentUser().getUsername());

        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> users, ParseException e) {
                if (e==null){

                    if (users.size()>0){

                        for (ParseUser parseUser:users){
                            arrayList.add(parseUser.getUsername());
                        }
                        listView.setAdapter(arrayAdapter);
                    }

                }
            }
        });




        return v;
    }
}
