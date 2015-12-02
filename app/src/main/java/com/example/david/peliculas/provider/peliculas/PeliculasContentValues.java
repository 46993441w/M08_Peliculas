package com.example.david.peliculas.provider.peliculas;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.david.peliculas.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code peliculas} table.
 */
public class PeliculasContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PeliculasColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PeliculasSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PeliculasSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PeliculasContentValues putAdult(@Nullable Boolean value) {
        mContentValues.put(PeliculasColumns.ADULT, value);
        return this;
    }

    public PeliculasContentValues putAdultNull() {
        mContentValues.putNull(PeliculasColumns.ADULT);
        return this;
    }

    public PeliculasContentValues putBackdropPath(@Nullable String value) {
        mContentValues.put(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasContentValues putBackdropPathNull() {
        mContentValues.putNull(PeliculasColumns.BACKDROP_PATH);
        return this;
    }

    public PeliculasContentValues putIdpelicula(@Nullable Integer value) {
        mContentValues.put(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasContentValues putIdpeliculaNull() {
        mContentValues.putNull(PeliculasColumns.IDPELICULA);
        return this;
    }

    public PeliculasContentValues putOriginalLanguage(@Nullable String value) {
        mContentValues.put(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasContentValues putOriginalLanguageNull() {
        mContentValues.putNull(PeliculasColumns.ORIGINAL_LANGUAGE);
        return this;
    }

    public PeliculasContentValues putOriginalTitle(@Nullable String value) {
        mContentValues.put(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasContentValues putOriginalTitleNull() {
        mContentValues.putNull(PeliculasColumns.ORIGINAL_TITLE);
        return this;
    }

    public PeliculasContentValues putOverview(@Nullable String value) {
        mContentValues.put(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasContentValues putOverviewNull() {
        mContentValues.putNull(PeliculasColumns.OVERVIEW);
        return this;
    }

    public PeliculasContentValues putReleaseDate(@Nullable String value) {
        mContentValues.put(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasContentValues putReleaseDateNull() {
        mContentValues.putNull(PeliculasColumns.RELEASE_DATE);
        return this;
    }

    public PeliculasContentValues putPosterPath(@Nullable String value) {
        mContentValues.put(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasContentValues putPosterPathNull() {
        mContentValues.putNull(PeliculasColumns.POSTER_PATH);
        return this;
    }

    public PeliculasContentValues putPopularity(@Nullable Double value) {
        mContentValues.put(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasContentValues putPopularityNull() {
        mContentValues.putNull(PeliculasColumns.POPULARITY);
        return this;
    }

    public PeliculasContentValues putTitle(@Nullable String value) {
        mContentValues.put(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasContentValues putTitleNull() {
        mContentValues.putNull(PeliculasColumns.TITLE);
        return this;
    }

    public PeliculasContentValues putVideo(@Nullable Boolean value) {
        mContentValues.put(PeliculasColumns.VIDEO, value);
        return this;
    }

    public PeliculasContentValues putVideoNull() {
        mContentValues.putNull(PeliculasColumns.VIDEO);
        return this;
    }

    public PeliculasContentValues putVoteAverage(@Nullable Double value) {
        mContentValues.put(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasContentValues putVoteAverageNull() {
        mContentValues.putNull(PeliculasColumns.VOTE_AVERAGE);
        return this;
    }

    public PeliculasContentValues putVoteCont(@Nullable Integer value) {
        mContentValues.put(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasContentValues putVoteContNull() {
        mContentValues.putNull(PeliculasColumns.VOTE_CONT);
        return this;
    }

    public PeliculasContentValues putSynctime(@Nullable Date value) {
        mContentValues.put(PeliculasColumns.SYNCTIME, value == null ? null : value.getTime());
        return this;
    }

    public PeliculasContentValues putSynctimeNull() {
        mContentValues.putNull(PeliculasColumns.SYNCTIME);
        return this;
    }

    public PeliculasContentValues putSynctime(@Nullable Long value) {
        mContentValues.put(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasContentValues putMovieslist(@Nullable String value) {
        mContentValues.put(PeliculasColumns.MOVIESLIST, value);
        return this;
    }

    public PeliculasContentValues putMovieslistNull() {
        mContentValues.putNull(PeliculasColumns.MOVIESLIST);
        return this;
    }
}
