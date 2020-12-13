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
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.techmarinar.recyclerasfragmentapp.data.StudentData;
import com.techmarinar.recyclerasfragmentapp.data.StudentList;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDataAdapter extends RecyclerView.Adapter<StudentDataAdapter.ItemViewHolder> {
    private static Context mContext;
    private List<StudentData>studentDataList;
    //var listener
    private static OnItemClickedListener mCallback;
    //


    //constructor
    public StudentDataAdapter(Context mContext,List<StudentData>studentList) {
        this.mContext = mContext;
        this.studentDataList=studentList;

        //setting mCallback to a certain init val
        try {
            mCallback=(OnItemClickedListener)mContext;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ClassCastException(mContext.toString()+"must be implemented at the context activity");
        }

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create the view (rootView)
        View rootView= LayoutInflater.from(mContext)
                .inflate(R.layout.student_list_item,parent,false);

        //return ItemViewHolder
        return new ItemViewHolder(rootView);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        //extracting data from the list of objects (select names from an object) and save it in to a new list
/**
 * to @extract the attributes from List of Object [collector] you should do like this code
 *  List<Long> ids = viewValues.stream().map(ViewValue::getId).collect(Collectors.toList());
 **/

    //getting name from the list of object
      List<String> namesList=studentDataList.stream().map(StudentData::getName)
              .collect(Collectors.toList());

    //getting pictures from the list of object
      final List<Integer> picturesList=studentDataList.stream()
              .map(StudentData::getPic)
              .collect(Collectors.toList());
      //

 /*******************************************************************************************/
    //binding the view with data
    holder.studentName.setText(namesList.get(position));
    holder.studentPic.setImageResource(picturesList.get(position));

    }

    @Override
    public int getItemCount() {
        return studentDataList.size();
    }

    //inner class ItemViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        //Widget variables
        private TextView studentName;
        private ImageView studentPic;

       //creating list items for recycling
        public ItemViewHolder(View itemView) {
            super(itemView);
            //find the item from the list
            studentName=(TextView) itemView.findViewById(R.id.student_name);
            studentPic=(ImageView) itemView.findViewById(R.id.student_pic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //position to be sends with item when its been clicked
                 /*** [getAdapterPosition()] method return integer position.**/
                 mCallback.OnItemClicked(getAdapterPosition());
                }
            });

        }
    }

    //inner Interface
    public interface OnItemClickedListener{
        public void OnItemClicked(int position);
    }

    //get items in the list with there positions
    public StudentData  getStudentAt(int positions){
        return studentDataList.get(positions);

    }

}
