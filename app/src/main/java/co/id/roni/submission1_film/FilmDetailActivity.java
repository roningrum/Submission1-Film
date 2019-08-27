package co.id.roni.submission1_film;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FilmDetailActivity extends AppCompatActivity {

    public static final String EXTRA_FILMS = "extra_movie";
    private TextView tvNameFilmDetail, tvOverviewFilmDetail, tvUserScoreFilmDetail;
    private ImageView imgPhotoFilmDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_detail);

        tvNameFilmDetail = findViewById(R.id.tv_name_film_detail);
        tvOverviewFilmDetail = findViewById(R.id.tv_overview_film_detail);
        tvUserScoreFilmDetail = findViewById(R.id.tv_user_score_film_detail);
        imgPhotoFilmDetail = findViewById(R.id.img_photo_film_detail);

        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail");
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getDetailFromAdapter();
    }

    private void getDetailFromAdapter() {
        Film film = getIntent().getParcelableExtra(EXTRA_FILMS);
        tvNameFilmDetail.setText(film.getNameFilm());
        tvOverviewFilmDetail.setText(film.getOverviewFilm());
        tvUserScoreFilmDetail.setText(film.getAudienceScoreFilm());
        imgPhotoFilmDetail.setImageResource(film.getPhotoFilm());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}
