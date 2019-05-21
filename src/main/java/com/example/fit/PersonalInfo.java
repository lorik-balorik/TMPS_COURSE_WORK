package com.example.fit;

import java.io.Serializable;

public class PersonalInfo implements Serializable {
    String name;
    String phone;
    String email;
    int age;
    int height;
    int weight;
    boolean gender;


        public void setName(String name){
            this.name = name;
        }

        public void setPhone(String phone){
            this.phone = phone;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public void setAge(int age){
            this.age = age;
        }

        public void setHeight(int age){
            this.height = height;
        }

        public void setWeight(int weight){
            this.weight = weight;
        }

        public void setGender(boolean gender){
            this.gender = gender;
        }

        public void printInConsoleAllData(){
            String genderLocal = "";
            if(gender)
                    genderLocal = "female";
                else
                    genderLocal = "male";

            System.out.println("Name:"+name+" Phone: "+phone+" Email: "+email+" Age: "+age+" Height: "+height+" Weight: "+weight+" Gender: "+genderLocal);
        }

}
