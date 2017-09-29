# Simple SQL executor #
[![Build Status](https://travis-ci.org/AnkBurov/Simple-sql-executor.svg?branch=master)](https://travis-ci.org/AnkBurov/Simple-sql-executor) [![Coverage Status](https://coveralls.io/repos/github/AnkBurov/Simple-sql-executor/badge.svg?branch=master)](https://coveralls.io/github/AnkBurov/Simple-sql-executor?branch=master)

Derived version of full gradle plugin data database-update-plugin.

Executes all SQL queries in the single specified file.

## Usage ##
* clone repository
* add needed JDBC driver to the lib directory
* gradlew shadowjar
* copy fat jar file from build/libs
* java -jar jarname $filename, $url, $user, $password, $driverName, $queryDelimiter