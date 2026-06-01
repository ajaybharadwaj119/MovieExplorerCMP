package org.ajay.movieexplorer.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.ajay.movieexplorer.MovieDatabase

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = MovieDatabase.Schema,
            name = "movie.db"
        )
    }
}