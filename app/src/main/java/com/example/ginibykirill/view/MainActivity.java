package com.example.ginibykirill.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ginibykirill.model.Post;
import com.example.ginibykirill.viewModel.PostsAdapter;
import com.example.ginibykirill.R;
import com.example.ginibykirill.model.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

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