package com.example.david.peliculas.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.david.peliculas.BuildConfig;
import com.example.david.peliculas.provider.peliculas.PeliculasColumns;

public class PeliculasSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = PeliculasSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "peliculas.db";
    private static final int DATABASE_VERSION = 1;
    private static PeliculasSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final PeliculasSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_PELICULAS = "CREATE TABLE IF NOT EXISTS "
            + PeliculasColumns.TABLE_NAME + " ( "
            + PeliculasColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PeliculasColumns.ADULT + " INTEGER, "
            + PeliculasColumns.BACKDROP_PATH + " TEXT, "
            + PeliculasColumns.IDPELICULA + " INTEGER, "
            + PeliculasColumns.ORIGINAL_LANGUAGE + " TEXT, "
            + PeliculasColumns.ORIGINAL_TITLE + " TEXT, "
            + PeliculasColumns.OVERVIEW + " TEXT, "
            + PeliculasColumns.RELEASE_DATE + " TEXT, "
            + PeliculasColumns.POSTER_PATH + " TEXT, "
            + PeliculasColumns.POPULARITY + " REAL, "
            + PeliculasColumns.TITLE + " TEXT, "
            + PeliculasColumns.VIDEO + " INTEGER, "
            + PeliculasColumns.VOTE_AVERAGE + " REAL, "
            + PeliculasColumns.VOTE_CONT + " INTEGER "
            + " );";

    // @formatter:on

    public static PeliculasSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static PeliculasSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static PeliculasSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new PeliculasSQLiteOpenHelper(context);
    }

    private PeliculasSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new PeliculasSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static PeliculasSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new PeliculasSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private PeliculasSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new PeliculasSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_PELICULAS);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
