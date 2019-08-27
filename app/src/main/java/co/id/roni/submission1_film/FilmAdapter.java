package co.id.roni.submission1_film;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film_list, viewGroup, false);
        }
//        viewHolder.btnSeeDetails.setTag(i);
        viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }


    private class ViewHolder {
        private TextView txtNameFilm;
        private TextView txtOverviewFilm;
        private ImageView imgPhotoFilm;

        ViewHolder(View view) {
            txtNameFilm = view.findViewById(R.id.txt_name_film);
            txtOverviewFilm = view.findViewById(R.id.txt_overview_film);
            imgPhotoFilm = view.findViewById(R.id.img_film);

        }

        void bind(Film film) {
            txtNameFilm.setText(film.getNameFilm());
            txtOverviewFilm.setText(film.getOverviewFilm());
            imgPhotoFilm.setImageResource(film.getPhotoFilm());
        }
    }
}
