package com.example.hotel.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DbSmokeTest {
    @Test
    void canConnect() throws Exception {
        assertNotNull(Db.get());
    }
}
