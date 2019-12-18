package models;

import java.sql.Timestamp;

public class Film {
    int film_id, release_year, language_id, original_language_id, rental_duration, lenght;
    Float rental_rate, replacement_cost;
    String title, description, rating, special_features;
    Timestamp last_update;

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public int getLanguage_id() {
        return language_id;
    }

    public void setLanguage_id(int language_id) {
        this.language_id = language_id;
    }

    public int getOriginal_language_id() {
        return original_language_id;
    }

    public void setOriginal_language_id(int original_language_id) {
        this.original_language_id = original_language_id;
    }

    public int getRental_duration() {
        return rental_duration;
    }

    public void setRental_duration(int rental_duration) {
        this.rental_duration = rental_duration;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public Float getRental_rate() {
        return rental_rate;
    }

    public void setRental_rate(Float rental_rate) {
        this.rental_rate = rental_rate;
    }

    public Float getReplacement_cost() {
        return replacement_cost;
    }

    public void setReplacement_cost(Float replacement_cost) {
        this.replacement_cost = replacement_cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecial_features() {
        return special_features;
    }

    public void setSpecial_features(String special_features) {
        this.special_features = special_features;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film_id=" + film_id +
                ", release_year=" + release_year +
                ", language_id=" + language_id +
                ", original_language_id=" + original_language_id +
                ", rental_duration=" + rental_duration +
                ", lenght=" + lenght +
                ", rental_rate=" + rental_rate +
                ", replacement_cost=" + replacement_cost +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating='" + rating + '\'' +
                ", special_features='" + special_features + '\'' +
                ", last_update=" + last_update +
                '}';
    }
}
