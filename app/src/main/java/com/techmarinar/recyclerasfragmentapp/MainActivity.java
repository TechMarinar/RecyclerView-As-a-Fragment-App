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

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Toast;

import com.techmarinar.recyclerasfragmentapp.data.StudentData;

public class MainActivity extends AppCompatActivity implements StudentDataAdapter.OnItemClickedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void OnItemClicked(int position) {

        Toast.makeText(getBaseContext(), "wowo"+position, Toast.LENGTH_SHORT).show();
    }

//   //this method for dynamic fragment only
//    private void setUpFragmentHelperMethod(StudentData studentData) {
//
//        //init fragment
//        StudentListFragment studentFragment= new StudentListFragment();
//        //set data to the fragment
//        studentFragment.setmStudentData(studentData);
//        studentFragment.setmContext(this);
//
//        //setup the fragment manger and begin transactions
//        FragmentManager manager =getSupportFragmentManager();
//        manager.beginTransaction().add(R.id.student_frame,studentFragment).commit();
//    }
}