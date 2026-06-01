package org.ajay.movieexplorer.database

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.ajay.movieexplorer.MovieDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = MovieDatabase.Schema,
            context = context,
            name = "movie.db"
        )
    }
}