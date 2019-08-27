package co.id.roni.submission1_film;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataNameFilm;
    private String[] dataOverViewFilm;
    private String[] dataUserScoreFilm;
    private TypedArray dataPhotoFilm;
    private FilmAdapter filmAdapter;
    private ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.lv_film);
        getSupportActionBar().setTitle("Movie Db List");

        filmAdapter = new FilmAdapter(this);
        listView.setAdapter(filmAdapter);
        prepareItemFilm();
        addItemFilm();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, FilmDetailActivity.class);
                intent.putExtra(FilmDetailActivity.EXTRA_FILMS, films.get(i));
                startActivity(intent);
            }
        });
    }

    private void prepareItemFilm() {
        dataNameFilm = getResources().getStringArray(R.array.data_name_film);
        dataOverViewFilm = getResources().getStringArray(R.array.data_overview_film);
        dataPhotoFilm = getResources().obtainTypedArray(R.array.data_photo_film);
        dataUserScoreFilm = getResources().getStringArray(R.array.data_user_score);
    }

    private void addItemFilm() {
        films = new ArrayList<>();
        for(int i = 0; i<dataNameFilm.length; i++){
            Film film = new Film();
            film.setPhotoFilm(dataPhotoFilm.getResourceId(i, -1));
            film.setNameFilm(dataNameFilm[i]);
            film.setOverviewFilm(dataOverViewFilm[i]);
            film.setAudienceScoreFilm(dataUserScoreFilm[i]);
            films.add(film);
        }
        filmAdapter.setFilms(films);
    }


}
