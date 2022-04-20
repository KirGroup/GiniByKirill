package com.example.ginibykirill.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ginibykirill.model.Post;
import com.example.ginibykirill.viewModel.PostsAdapter;
import com.example.ginibykirill.R;
import com.example.ginibykirill.model.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    PostsAdapter adapter;
    Post numbersList = new Post();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostsAdapter(numbersList);
        recyclerView.setAdapter(adapter);

        fetchPosts();

        if(numbersList.getNumbers() != null){
//            TextView textView = new TextView(this);
//            textView.setText("success");
//            recyclerView.addView(textView);
//            setContentView(recyclerView);
            Map<Integer, Boolean> sortNumbers = numbersList.returnNumbersList();
            int i = 0;
            for (Map.Entry<Integer, Boolean> entry : sortNumbers.entrySet()) {


                TableLayout tableLayout = new TableLayout(this);
                TableRow tableRow1 = new TableRow(this);

//            for (int i = 0; i < sortNumbers.size(); i++) {
                if (i % 3 == 0)
                    tableRow1 = new TableRow(this);

                TextView textView1 = new TextView(this);
                textView1.setText(String.valueOf(entry.getKey().toString()));
//                if()

                switch (i % 3) {
                    case 0:
                        textView1.setGravity(Gravity.START);
                        textView1.setPadding(200, 0, 0, 0);
                        textView1.setBackgroundColor(Color.rgb(255, 165, 0));
                        break;
                    case 1:
                        textView1.setGravity(Gravity.CENTER);
                        textView1.setBackgroundColor(Color.rgb(255, 165, 0));
                        break;
                    case 2:
                        textView1.setGravity(Gravity.END);
                        textView1.setPadding(0, 0, 200, 0);
                        textView1.setBackgroundColor(Color.rgb(255, 165, 0));
                        break;
                }
                tableRow1.addView(textView1, new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1f));

                if (i % 3 == 0) {
                    tableLayout.setGravity(Gravity.FILL_HORIZONTAL);
                    tableLayout.addView(tableRow1, TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT);


                }
                i++;
                setContentView(tableLayout);
            }
            Log.i("AppGini", "success");
        }

    }



    private void fetchPosts() {


        RetrofitClient.getRetrofitClient().getPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful() && response.body() !=null){
                    numbersList.copyNumbers(response.body());
                    adapter.notifyDataSetChanged();
                    numbersList.returnNumbersList();

                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            Log.i("App121212", t.getMessage());
            }
        });

    }
}