package co.id.roni.submission1_film;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private int photoFilm;
    private String nameFilm;
    private String overviewFilm;
    private String audienceScoreFilm;

    public int getPhotoFilm() {
        return photoFilm;
    }

    public void setPhotoFilm(int photoFilm) {
        this.photoFilm = photoFilm;
    }

    public String getNameFilm() {
        return nameFilm;
    }

    public void setNameFilm(String nameFilm) {
        this.nameFilm = nameFilm;
    }

    public String getOverviewFilm() {
        return overviewFilm;
    }

    public void setOverviewFilm(String overviewFilm) {
        this.overviewFilm = overviewFilm;
    }

    public String getAudienceScoreFilm() {
        return audienceScoreFilm;
    }

    public void setAudienceScoreFilm(String audienceScoreFilm) {
        this.audienceScoreFilm = audienceScoreFilm;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.photoFilm);
        dest.writeString(this.nameFilm);
        dest.writeString(this.overviewFilm);
        dest.writeString(this.audienceScoreFilm);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.photoFilm = in.readInt();
        this.nameFilm = in.readString();
        this.overviewFilm = in.readString();
        this.audienceScoreFilm = in.readString();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
