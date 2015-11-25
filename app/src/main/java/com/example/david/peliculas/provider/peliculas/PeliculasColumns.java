package com.example.david.peliculas.provider.peliculas;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.david.peliculas.provider.PeliculasProvider;
import com.example.david.peliculas.provider.peliculas.PeliculasColumns;

/**
 * Columns for the {@code peliculas} table.
 */
public class PeliculasColumns implements BaseColumns {
    public static final String TABLE_NAME = "peliculas";
    public static final Uri CONTENT_URI = Uri.parse(PeliculasProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String ADULT = "adult";

    public static final String BACKDROP_PATH = "backdrop_path";

    public static final String IDPELICULA = "idpelicula";

    public static final String ORIGINAL_LANGUAGE = "original_language";

    public static final String ORIGINAL_TITLE = "original_title";

    public static final String OVERVIEW = "overview";

    public static final String RELEASE_DATE = "release_date";

    public static final String POSTER_PATH = "poster_path";

    public static final String POPULARITY = "popularity";

    public static final String TITLE = "title";

    public static final String VIDEO = "video";

    public static final String VOTE_AVERAGE = "vote_average";

    public static final String VOTE_CONT = "vote_cont";

    public static final String SYNCTIME = "syncTime";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            ADULT,
            BACKDROP_PATH,
            IDPELICULA,
            ORIGINAL_LANGUAGE,
            ORIGINAL_TITLE,
            OVERVIEW,
            RELEASE_DATE,
            POSTER_PATH,
            POPULARITY,
            TITLE,
            VIDEO,
            VOTE_AVERAGE,
            VOTE_CONT,
            SYNCTIME
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(ADULT) || c.contains("." + ADULT)) return true;
            if (c.equals(BACKDROP_PATH) || c.contains("." + BACKDROP_PATH)) return true;
            if (c.equals(IDPELICULA) || c.contains("." + IDPELICULA)) return true;
            if (c.equals(ORIGINAL_LANGUAGE) || c.contains("." + ORIGINAL_LANGUAGE)) return true;
            if (c.equals(ORIGINAL_TITLE) || c.contains("." + ORIGINAL_TITLE)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(RELEASE_DATE) || c.contains("." + RELEASE_DATE)) return true;
            if (c.equals(POSTER_PATH) || c.contains("." + POSTER_PATH)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(VIDEO) || c.contains("." + VIDEO)) return true;
            if (c.equals(VOTE_AVERAGE) || c.contains("." + VOTE_AVERAGE)) return true;
            if (c.equals(VOTE_CONT) || c.contains("." + VOTE_CONT)) return true;
            if (c.equals(SYNCTIME) || c.contains("." + SYNCTIME)) return true;
        }
        return false;
    }

}
