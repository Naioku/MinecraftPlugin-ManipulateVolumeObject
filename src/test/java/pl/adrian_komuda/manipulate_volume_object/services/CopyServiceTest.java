package pl.adrian_komuda.manipulate_volume_object.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.adrian_komuda.manipulate_volume_object.TestFlag;

class CopyServiceTest {

    @BeforeAll
    static void setTestFlag() {
        TestFlag.TEST_FLAG = true;
    }

    @Test
    void test1() {

    }

    @AfterAll
    static void unsetTestFlag() {
        TestFlag.TEST_FLAG =  false;
    }

}