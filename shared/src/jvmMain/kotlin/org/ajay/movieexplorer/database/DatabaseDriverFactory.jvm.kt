package org.ajay.movieexplorer.database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        val driver = JdbcSqliteDriver(
            url = "jdbc:sqlite:movie.db"
        )

        MovieDatabase.Schema.create(driver)

        return driver
    }
}