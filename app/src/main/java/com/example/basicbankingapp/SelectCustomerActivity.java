package com.example.basicbankingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import java.util.ArrayList;

public class SelectCustomerActivity extends AppCompatActivity {
    private RecyclerView rvSelectUser;
    private DataBaseHelper mydb;
    int idr,id;
    double amount,credit;
    String name,email;
    ArrayList<CustomerDetail> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_customer);

        rvSelectUser = findViewById(R.id.recyclerSelectUser_id);
        rvSelectUser.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SelectCustomerActivity.this);
        rvSelectUser.setLayoutManager(layoutManager);
        mydb = new DataBaseHelper(this);
        Bundle bundle = getIntent().getExtras();
        idr = bundle.getInt("id");
        amount = bundle.getDouble("amount");
        //Toast.makeText(SelectUserActivity.this,"Details : "+idr+" amount : "+amount,Toast.LENGTH_LONG).show();
        viewAll();
    }
    public void viewAll()
    {
        Cursor cursor = mydb.getAllData();
        if (cursor.getCount()>0)
        {
            if (cursor.moveToFirst())
            {
                do {
                    id = cursor.getInt(0);
                    if(id != idr)
                    {
                        name = cursor.getString(1);
                        email = cursor.getString(2);
                        credit = cursor.getDouble(3);

                        CustomerDetail userDetails = new CustomerDetail(id,name,email,credit,2,amount,idr);
                        arrayList.add(userDetails);
                    }
                }while (cursor.moveToNext());
            }
            MyAdapter myAdapter = new MyAdapter(arrayList,this);
            rvSelectUser.setAdapter(myAdapter);
        }
    }
}