package com.example.basicbankingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper mydb;
    RecyclerView rvListUsers;
    int id;
    String name,email;
    Double amount;
    ArrayList<CustomerDetail> arrayList = new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new DataBaseHelper(MainActivity.this);
        rvListUsers = findViewById(R.id.recyclerList_id);

        rvListUsers.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        rvListUsers.setLayoutManager(layoutManager);

        delete();
        addUser();

        viewAll();


    }
    public void addUser(){

        boolean check = mydb.insertData("Aditi","akhil@gmail.com",10000);
        boolean c1 = mydb.insertData("Anju","akhil@gmail.com",10000);
        boolean c2 = mydb.insertData("Aryan","akhil@gmail.com",10000);
        boolean c3 = mydb.insertData("Abhishek","akhil@gmail.com",10000);
        boolean c4 = mydb.insertData("Anshika","akhil@gmail.com",10000);
        boolean c5 = mydb.insertData("Arun","akhil@gmail.com",10000);
        boolean c6 = mydb.insertData("Golu","akhil@gmail.com",10000);


       /* if(check){
            Toast.makeText(MainActivity.this,"Inserted Data",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(MainActivity.this,"Not Innserted",Toast.LENGTH_LONG).show();
        }*/
    }
    public void viewAll(){

        Cursor cursor = mydb.getAllData();
        if(cursor.getCount() == 0){
            showAll("Error", "No data found");
            return;
        }
        else
        {
            if(cursor.moveToFirst()){
                do{
                    id = cursor.getInt(0);
                    name = cursor.getString(1);
                    email = cursor.getString(2);
                    amount = cursor.getDouble(3);

                    CustomerDetail customerDetail = new CustomerDetail(id,name,email,amount,1,0.0,0);
                    arrayList.add(customerDetail);

                }while (cursor.moveToNext());
            }
            myAdapter = new MyAdapter(arrayList, MainActivity.this);
            rvListUsers.setAdapter(myAdapter);

        }
    }
    public  void showAll(String title,String message){

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void update(){

        boolean check = mydb.updateData(2,"Madhu","madhu@gmail.com",30000);

    }

    public void delete(){
        long check = mydb.deleteData(19);
    }
}