package es.upm.miw.iwvg_devops.code;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UsersDatabaseTest {
    private UsersDatabase usersDatabase;
    @BeforeEach
    void before() {
        usersDatabase = new UsersDatabase();
    }

    @Test
    void testUsersDatabaseFindAll() {
        List<User> oscarUsers = usersDatabase.findAll()
                .filter(user -> user.getName().equals("Oscar"))
                .toList();

        assertEquals(2, oscarUsers.size());
        assertEquals("Fernandez", oscarUsers.get(0).getFamilyName());
    }
}