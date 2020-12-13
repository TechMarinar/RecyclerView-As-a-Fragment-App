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

public class StudentData {
    private String name;
    private int pic;
    //counter to count the number of created studentData object
    private int numbersOfStudentCreated=0;

    public StudentData() {
        //default constructor
        //updating the counter
        numbersOfStudentCreated++;
    }

    public StudentData(String name, int pic) {
        this.name = name;
        this.pic = pic;
        //updating the counter
        numbersOfStudentCreated++;
    }

    public String getName() {
        return name;
    }

    public int getPic() {
        return pic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }


    //return count of created studentData object
    public int getNumbersOfStudentCreated() {
        return numbersOfStudentCreated;
    }
}
