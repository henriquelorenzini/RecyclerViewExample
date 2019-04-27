package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

class Movie{
    private String title;
    private String director;
    private String year;

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }
    public Movie(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }


}

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewMovie;
    private List<Movie> movies = Arrays.asList(
            new Movie("Donnie Darko", "Richard Kelly", "2001"),
            new Movie("Back to the future", "Robert Zemeckis ", "1985"),
            new Movie("US", "Jordan Peele", "2019"),
            new Movie("HER", "Spike Jonze", "2014")

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewMovie = findViewById(R.id.recyclerViewMovie);

        //ADAPTER

        MoviesAdapter adapter = new MoviesAdapter(movies);

        //  MANAGER
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getApplicationContext()
        );

        recyclerViewMovie.setLayoutManager(manager);
        recyclerViewMovie.setAdapter(adapter);
        recyclerViewMovie.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewMovie,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "ITEM: " + movies.get(position).getTitle(),
                                        Toast.LENGTH_LONG
                                ).show();

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {
                                Toast.makeText(
                                        getApplicationContext(),
                                        "long ITEM: " + movies.get(position).getTitle(),
                                        Toast.LENGTH_LONG
                                ).show();

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

    }
}
