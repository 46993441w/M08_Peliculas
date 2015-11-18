package com.example.david.peliculas.provider.peliculas;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.david.peliculas.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code peliculas} table.
 */
public class PeliculasCursor extends AbstractCursor implements PeliculasModel {
    public PeliculasCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PeliculasColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code adult} value.
     * Can be {@code null}.
     */
    @Nullable
    public Boolean getAdult() {
        Boolean res = getBooleanOrNull(PeliculasColumns.ADULT);
        return res;
    }

    /**
     * Get the {@code backdrop_path} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBackdropPath() {
        String res = getStringOrNull(PeliculasColumns.BACKDROP_PATH);
        return res;
    }

    /**
     * Get the {@code id} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getId() {
        Integer res = getIntegerOrNull(PeliculasColumns.ID);
        return res;
    }

    /**
     * Get the {@code original_language} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOriginalLanguage() {
        String res = getStringOrNull(PeliculasColumns.ORIGINAL_LANGUAGE);
        return res;
    }

    /**
     * Get the {@code original_title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOriginalTitle() {
        String res = getStringOrNull(PeliculasColumns.ORIGINAL_TITLE);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOverview() {
        String res = getStringOrNull(PeliculasColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code release_date} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getReleaseDate() {
        String res = getStringOrNull(PeliculasColumns.RELEASE_DATE);
        return res;
    }

    /**
     * Get the {@code poster_path} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterPath() {
        String res = getStringOrNull(PeliculasColumns.POSTER_PATH);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getPopularity() {
        Double res = getDoubleOrNull(PeliculasColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(PeliculasColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code video} value.
     * Can be {@code null}.
     */
    @Nullable
    public Boolean getVideo() {
        Boolean res = getBooleanOrNull(PeliculasColumns.VIDEO);
        return res;
    }

    /**
     * Get the {@code vote_average} value.
     * Can be {@code null}.
     */
    @Nullable
    public Double getVoteAverage() {
        Double res = getDoubleOrNull(PeliculasColumns.VOTE_AVERAGE);
        return res;
    }

    /**
     * Get the {@code vote_cont} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getVoteCont() {
        Integer res = getIntegerOrNull(PeliculasColumns.VOTE_CONT);
        return res;
    }
}
