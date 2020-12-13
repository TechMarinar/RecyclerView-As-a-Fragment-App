/*
 * Copyright 2020 Mohamed Ahmed Dahab
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.techmarinar.recyclerasfragmentapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.techmarinar.recyclerasfragmentapp.data.StudentData;
import com.techmarinar.recyclerasfragmentapp.data.StudentList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class StudentListFragment extends Fragment{

    private List<StudentData> mStudentData=new ArrayList<>();
    private Context mContext;
    private StudentDataAdapter adapter;

    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_studen_list, container, false);

        //finding the recycler
        RecyclerView recyclerView=(RecyclerView) view.findViewById(R.id.recycler_view);

        //setting StudentData list of object
        mStudentData= StudentList.getStudentDataList();

        //setting the context
        mContext=getContext();

        //initiating the adapter
        adapter=new StudentDataAdapter(mContext,mStudentData);

        //setLayout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        //set adapter to the recyclerView
        recyclerView.setAdapter(adapter);

        //creating ItemTouchHelper [to listen t swipe and drags]
        ItemTouchHelper itemTouch= new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT ) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,RecyclerView.ViewHolder target) {

                final int fromPosition = viewHolder.getAdapterPosition();
                final int toPosition = target.getAdapterPosition();
//                if (fromPosition < toPosition) {
//                    for (int i = fromPosition; i < toPosition; i++) {
//                        Collections.swap(mStudentData, i, i + 1);
//                    }
//                } else {
//                    for (int i = fromPosition; i > toPosition; i--) {
//                        Collections.swap(mStudentData, i, i - 1);
//                    } }
            //
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                    int itemsPositions=viewHolder.getAdapterPosition();
                    String mesage=removeListItemsHelper(itemsPositions);

                Toast.makeText(mContext, "item is removed", Toast.LENGTH_SHORT).show();

            }
        });

        //attach itemTouch to recyclerView
        itemTouch.attachToRecyclerView(recyclerView);

        return view;
    }

    //helper method to remove an item from the list
    private String removeListItemsHelper(int itemsPositions) {
        //remove the item
        mStudentData.remove(itemsPositions);
        //notify the adapter
        adapter.notifyItemRemoved(itemsPositions);
        adapter.notifyDataSetChanged();

        //return Status message
        String meSage="item is removed";
        return meSage;
    }

}