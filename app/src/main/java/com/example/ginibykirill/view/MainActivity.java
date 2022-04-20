package com.example.ginibykirill.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
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

    Post numbersList = new Post();
    RecyclerView recyclerView;

    LinearLayoutManager layoutManager;
    PostsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchPosts();
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(layoutManager);
        adapter = new PostsAdapter(numbersList);
        recyclerView.setAdapter(adapter);

    }

    public void giveIntent(){
        Intent showActivity = new Intent(MainActivity.this, ShowActivity.class);
        showActivity.putExtra("data", numbersList.returnNumbersList());
        startActivity(showActivity);
    }

    private void fetchPosts() {
        RetrofitClient.getRetrofitClient().getPost().enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful() && response.body() !=null){
                    numbersList.copyNumbers(response.body());
                    adapter.notifyDataSetChanged();
                    giveIntent();
                }
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
            Log.i("App121212", t.getMessage());
            }
        });
    }
}