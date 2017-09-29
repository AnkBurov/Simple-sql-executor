package io.ankburov.sqlexecutor

import groovy.transform.CompileStatic
import io.ankburov.sqlexecutor.impl.ServiceInstanceFactory

@CompileStatic
class Main {

    /**
     * $filename, $url, $user, $password, $driverName, $queryDelimiter
     */
    static void main(String[] args) {
        if (args.size() != 6) {
            throw new IllegalArgumentException("Terrible number of arguments. Should be 6: sql file, url, user, password, driverName, queryDelimiter")
        }
        def file = new File(args[0])
        if (!file.exists()) {
            throw new IllegalArgumentException("File ${args[0]} doesn't exist")
        }
        def sqlExecutorService = ServiceInstanceFactory.getSqlExecutorService(args[1], args[2], args[3], args[4], args[5])
        sqlExecutorService.executeScript(file)
    }
}
