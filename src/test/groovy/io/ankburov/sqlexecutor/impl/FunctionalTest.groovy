package io.ankburov.sqlexecutor.impl

import groovy.transform.CompileStatic
import io.ankburov.sqlexecutor.Main
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@CompileStatic
@RunWith(MockitoJUnitRunner)
class FunctionalTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    void main() throws Exception {
        def scriptFile = folder.newFile("script.sql")
        scriptFile.write("CREATE SCHEMA TEST_SCHEMA;")

        Main.main(scriptFile.path, "jdbc:h2:mem:test_mem", "sa", "", "org.h2.Driver", ";")
    }

    @Test(expected = IllegalArgumentException)
    void testWrongNumberOfArguments() throws Exception {
        Main.main()
    }

    @Test(expected = IllegalArgumentException)
    void testNonExistentFile() throws Exception {
        Main.main("123.sql", "jdbc:h2:mem:test_mem", "sa", "", "org.h2.Driver", ";")
    }
}
