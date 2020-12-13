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

package com.techmarinar.recyclerasfragmentapp.data;

import com.techmarinar.recyclerasfragmentapp.R;

import java.util.ArrayList;
import java.util.List;

public class StudentList {

    private static final List<StudentData> studentDataList=new ArrayList<StudentData>(){
        {
            add(new StudentData("Ahmed mohamed", R.drawable.j));
            add(new StudentData("Taha Algorashi", R.drawable.k));
            add(new StudentData("Omer Alimam", R.drawable.l));
            add(new StudentData("princes lyla", R.drawable.m));
            add(new StudentData("mona mohamed", R.drawable.n));
            add(new StudentData("Maram Alaa Aldeen", R.drawable.o));
            add(new StudentData("Lobna Alsaid", R.drawable.l));
            add(new StudentData("Ronald Regan", R.drawable.m));
            add(new StudentData("Neha nao nao", R.drawable.n));
            add(new StudentData("HaHow mohamed", R.drawable.o));
            add(new StudentData("Yao mohamed", R.drawable.j));
            add(new StudentData("Lee mohamed", R.drawable.k));
            add(new StudentData("Yu mohamed", R.drawable.l));
            add(new StudentData("Kuan mohamed", R.drawable.m));
            add(new StudentData("kunal mohamed", R.drawable.n));
            add(new StudentData("Suzane Kumache", R.drawable.o));
            add(new StudentData("Aamer Aseel", R.drawable.j));
            add(new StudentData("Aasif Abarg", R.drawable.k));
        }
    };

    public static List<StudentData> getStudentDataList() {
        return studentDataList;
    }
}
