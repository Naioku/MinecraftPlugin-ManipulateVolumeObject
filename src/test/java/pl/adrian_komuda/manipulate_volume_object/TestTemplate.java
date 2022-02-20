package pl.adrian_komuda.manipulate_volume_object;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

/**
 * Add to every test You know it will be calling methods, which require of running bukkit server,
 * but You don't need them to proper testing process.
 */
public abstract class TestTemplate {
    @BeforeAll
    static void setTestFlag() {
        TestFlags.UNIT_TEST_FLAG = true;
    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlags.UNIT_TEST_FLAG =  false;
    }
}
