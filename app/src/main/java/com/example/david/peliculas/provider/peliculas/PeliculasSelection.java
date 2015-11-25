package com.example.david.peliculas.provider.peliculas;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.david.peliculas.provider.base.AbstractSelection;

/**
 * Selection for the {@code peliculas} table.
 */
public class PeliculasSelection extends AbstractSelection<PeliculasSelection> {
    @Override
    protected Uri baseUri() {
        return PeliculasColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PeliculasCursor} object, which is positioned before the first entry, or null.
     */
    public PeliculasCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PeliculasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PeliculasCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PeliculasCursor} object, which is positioned before the first entry, or null.
     */
    public PeliculasCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PeliculasCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PeliculasCursor query(Context context) {
        return query(context, null);
    }


    public PeliculasSelection id(long... value) {
        addEquals("peliculas." + PeliculasColumns._ID, toObjectArray(value));
        return this;
    }

    public PeliculasSelection idNot(long... value) {
        addNotEquals("peliculas." + PeliculasColumns._ID, toObjectArray(value));
        return this;
    }

    public PeliculasSelection orderById(boolean desc) {
        orderBy("peliculas." + PeliculasColumns._ID, desc);
        return this;
    }

    public PeliculasSelection orderById() {
        return orderById(false);
    }

    public PeliculasSelection adult(Boolean value) {
        addEquals(PeliculasColumns.ADULT, toObjectArray(value));
        return this;
    }

    public PeliculasSelection orderByAdult(boolean desc) {
        orderBy(PeliculasColumns.ADULT, desc);
        return this;
    }

    public PeliculasSelection orderByAdult() {
        orderBy(PeliculasColumns.ADULT, false);
        return this;
    }

    public PeliculasSelection backdropPath(String... value) {
        addEquals(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection backdropPathNot(String... value) {
        addNotEquals(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection backdropPathLike(String... value) {
        addLike(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection backdropPathContains(String... value) {
        addContains(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection backdropPathStartsWith(String... value) {
        addStartsWith(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection backdropPathEndsWith(String... value) {
        addEndsWith(PeliculasColumns.BACKDROP_PATH, value);
        return this;
    }

    public PeliculasSelection orderByBackdropPath(boolean desc) {
        orderBy(PeliculasColumns.BACKDROP_PATH, desc);
        return this;
    }

    public PeliculasSelection orderByBackdropPath() {
        orderBy(PeliculasColumns.BACKDROP_PATH, false);
        return this;
    }

    public PeliculasSelection idpelicula(Integer... value) {
        addEquals(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection idpeliculaNot(Integer... value) {
        addNotEquals(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection idpeliculaGt(int value) {
        addGreaterThan(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection idpeliculaGtEq(int value) {
        addGreaterThanOrEquals(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection idpeliculaLt(int value) {
        addLessThan(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection idpeliculaLtEq(int value) {
        addLessThanOrEquals(PeliculasColumns.IDPELICULA, value);
        return this;
    }

    public PeliculasSelection orderByIdpelicula(boolean desc) {
        orderBy(PeliculasColumns.IDPELICULA, desc);
        return this;
    }

    public PeliculasSelection orderByIdpelicula() {
        orderBy(PeliculasColumns.IDPELICULA, false);
        return this;
    }

    public PeliculasSelection originalLanguage(String... value) {
        addEquals(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection originalLanguageNot(String... value) {
        addNotEquals(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection originalLanguageLike(String... value) {
        addLike(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection originalLanguageContains(String... value) {
        addContains(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection originalLanguageStartsWith(String... value) {
        addStartsWith(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection originalLanguageEndsWith(String... value) {
        addEndsWith(PeliculasColumns.ORIGINAL_LANGUAGE, value);
        return this;
    }

    public PeliculasSelection orderByOriginalLanguage(boolean desc) {
        orderBy(PeliculasColumns.ORIGINAL_LANGUAGE, desc);
        return this;
    }

    public PeliculasSelection orderByOriginalLanguage() {
        orderBy(PeliculasColumns.ORIGINAL_LANGUAGE, false);
        return this;
    }

    public PeliculasSelection originalTitle(String... value) {
        addEquals(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection originalTitleNot(String... value) {
        addNotEquals(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection originalTitleLike(String... value) {
        addLike(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection originalTitleContains(String... value) {
        addContains(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection originalTitleStartsWith(String... value) {
        addStartsWith(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection originalTitleEndsWith(String... value) {
        addEndsWith(PeliculasColumns.ORIGINAL_TITLE, value);
        return this;
    }

    public PeliculasSelection orderByOriginalTitle(boolean desc) {
        orderBy(PeliculasColumns.ORIGINAL_TITLE, desc);
        return this;
    }

    public PeliculasSelection orderByOriginalTitle() {
        orderBy(PeliculasColumns.ORIGINAL_TITLE, false);
        return this;
    }

    public PeliculasSelection overview(String... value) {
        addEquals(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewNot(String... value) {
        addNotEquals(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewLike(String... value) {
        addLike(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewContains(String... value) {
        addContains(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewStartsWith(String... value) {
        addStartsWith(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection overviewEndsWith(String... value) {
        addEndsWith(PeliculasColumns.OVERVIEW, value);
        return this;
    }

    public PeliculasSelection orderByOverview(boolean desc) {
        orderBy(PeliculasColumns.OVERVIEW, desc);
        return this;
    }

    public PeliculasSelection orderByOverview() {
        orderBy(PeliculasColumns.OVERVIEW, false);
        return this;
    }

    public PeliculasSelection releaseDate(String... value) {
        addEquals(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection releaseDateNot(String... value) {
        addNotEquals(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection releaseDateLike(String... value) {
        addLike(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection releaseDateContains(String... value) {
        addContains(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection releaseDateStartsWith(String... value) {
        addStartsWith(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection releaseDateEndsWith(String... value) {
        addEndsWith(PeliculasColumns.RELEASE_DATE, value);
        return this;
    }

    public PeliculasSelection orderByReleaseDate(boolean desc) {
        orderBy(PeliculasColumns.RELEASE_DATE, desc);
        return this;
    }

    public PeliculasSelection orderByReleaseDate() {
        orderBy(PeliculasColumns.RELEASE_DATE, false);
        return this;
    }

    public PeliculasSelection posterPath(String... value) {
        addEquals(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection posterPathNot(String... value) {
        addNotEquals(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection posterPathLike(String... value) {
        addLike(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection posterPathContains(String... value) {
        addContains(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection posterPathStartsWith(String... value) {
        addStartsWith(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection posterPathEndsWith(String... value) {
        addEndsWith(PeliculasColumns.POSTER_PATH, value);
        return this;
    }

    public PeliculasSelection orderByPosterPath(boolean desc) {
        orderBy(PeliculasColumns.POSTER_PATH, desc);
        return this;
    }

    public PeliculasSelection orderByPosterPath() {
        orderBy(PeliculasColumns.POSTER_PATH, false);
        return this;
    }

    public PeliculasSelection popularity(Double... value) {
        addEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityNot(Double... value) {
        addNotEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityGt(double value) {
        addGreaterThan(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityGtEq(double value) {
        addGreaterThanOrEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityLt(double value) {
        addLessThan(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection popularityLtEq(double value) {
        addLessThanOrEquals(PeliculasColumns.POPULARITY, value);
        return this;
    }

    public PeliculasSelection orderByPopularity(boolean desc) {
        orderBy(PeliculasColumns.POPULARITY, desc);
        return this;
    }

    public PeliculasSelection orderByPopularity() {
        orderBy(PeliculasColumns.POPULARITY, false);
        return this;
    }

    public PeliculasSelection title(String... value) {
        addEquals(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection titleNot(String... value) {
        addNotEquals(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection titleLike(String... value) {
        addLike(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection titleContains(String... value) {
        addContains(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection titleStartsWith(String... value) {
        addStartsWith(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection titleEndsWith(String... value) {
        addEndsWith(PeliculasColumns.TITLE, value);
        return this;
    }

    public PeliculasSelection orderByTitle(boolean desc) {
        orderBy(PeliculasColumns.TITLE, desc);
        return this;
    }

    public PeliculasSelection orderByTitle() {
        orderBy(PeliculasColumns.TITLE, false);
        return this;
    }

    public PeliculasSelection video(Boolean value) {
        addEquals(PeliculasColumns.VIDEO, toObjectArray(value));
        return this;
    }

    public PeliculasSelection orderByVideo(boolean desc) {
        orderBy(PeliculasColumns.VIDEO, desc);
        return this;
    }

    public PeliculasSelection orderByVideo() {
        orderBy(PeliculasColumns.VIDEO, false);
        return this;
    }

    public PeliculasSelection voteAverage(Double... value) {
        addEquals(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection voteAverageNot(Double... value) {
        addNotEquals(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection voteAverageGt(double value) {
        addGreaterThan(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection voteAverageGtEq(double value) {
        addGreaterThanOrEquals(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection voteAverageLt(double value) {
        addLessThan(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection voteAverageLtEq(double value) {
        addLessThanOrEquals(PeliculasColumns.VOTE_AVERAGE, value);
        return this;
    }

    public PeliculasSelection orderByVoteAverage(boolean desc) {
        orderBy(PeliculasColumns.VOTE_AVERAGE, desc);
        return this;
    }

    public PeliculasSelection orderByVoteAverage() {
        orderBy(PeliculasColumns.VOTE_AVERAGE, false);
        return this;
    }

    public PeliculasSelection voteCont(Integer... value) {
        addEquals(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection voteContNot(Integer... value) {
        addNotEquals(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection voteContGt(int value) {
        addGreaterThan(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection voteContGtEq(int value) {
        addGreaterThanOrEquals(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection voteContLt(int value) {
        addLessThan(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection voteContLtEq(int value) {
        addLessThanOrEquals(PeliculasColumns.VOTE_CONT, value);
        return this;
    }

    public PeliculasSelection orderByVoteCont(boolean desc) {
        orderBy(PeliculasColumns.VOTE_CONT, desc);
        return this;
    }

    public PeliculasSelection orderByVoteCont() {
        orderBy(PeliculasColumns.VOTE_CONT, false);
        return this;
    }

    public PeliculasSelection synctime(Date... value) {
        addEquals(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctimeNot(Date... value) {
        addNotEquals(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctime(Long... value) {
        addEquals(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctimeAfter(Date value) {
        addGreaterThan(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctimeAfterEq(Date value) {
        addGreaterThanOrEquals(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctimeBefore(Date value) {
        addLessThan(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection synctimeBeforeEq(Date value) {
        addLessThanOrEquals(PeliculasColumns.SYNCTIME, value);
        return this;
    }

    public PeliculasSelection orderBySynctime(boolean desc) {
        orderBy(PeliculasColumns.SYNCTIME, desc);
        return this;
    }

    public PeliculasSelection orderBySynctime() {
        orderBy(PeliculasColumns.SYNCTIME, false);
        return this;
    }
}
