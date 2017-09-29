package io.ankburov.sqlexecutor.impl

import org.junit.Test

import static io.ankburov.sqlexecutor.impl.TestConst.DRIVER_NAME
import static io.ankburov.sqlexecutor.impl.TestConst.PASSWORD
import static io.ankburov.sqlexecutor.impl.TestConst.QUERY_DELIMITER
import static io.ankburov.sqlexecutor.impl.TestConst.TEST_URL
import static io.ankburov.sqlexecutor.impl.TestConst.USER
import static org.junit.Assert.assertNotNull
import static org.junit.Assert.assertTrue

class ServiceInstanceFactoryTest {

    @Test
    void getSqlExecutorService() throws Exception {
        def service = ServiceInstanceFactory.getSqlExecutorService(TEST_URL, USER, PASSWORD, DRIVER_NAME, QUERY_DELIMITER)
        assertNotNull service
        assertTrue service instanceof SqlExecutorService
    }

    @Test(expected = RuntimeException)
    void getSqlExecutorServiceWrongDriver() throws Exception {
        ServiceInstanceFactory.getSqlExecutorService(TEST_URL, USER, PASSWORD, DRIVER_NAME + 1, QUERY_DELIMITER)
    }
}
