package pl.adrian_komuda.manipulate_volume_object.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestFlags;

class OperationServiceTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlags.UNIT_TEST_FLAG = true;
    }

    @Test
    void test1() {

    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlags.UNIT_TEST_FLAG =  false;
    }

}