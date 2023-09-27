package es.upm.miw.iwvg_devops.code;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserTest {
    private User user1, user2;
    private ArrayList<Fraction> fractions;
    @BeforeEach
    void before() {
        fractions= new ArrayList<Fraction>();
        fractions.add(new Fraction(1,2));
        fractions.add(new Fraction(2,3));
        user1 = new User();
        user2 = new User("id2", "John", "Foo", fractions);
    }

    @Test
    void testUserDefault() {
        assertNull(user1.getId());
        assertNull(user1.getName());
        assertNull(user1.getFamilyName());
        assertEquals(new ArrayList<Fraction>(), user1.getFractions());
    }

    @Test
    void testUserStringStringStringFractionList() {
        assertEquals("id2", user2.getId());
        assertEquals("John", user2.getName());
        assertEquals("Foo", user2.getFamilyName());
        assertEquals("John Foo", user2.fullName());
        assertEquals("J.", user2.initials());
        assertEquals(fractions, user2.getFractions());
    }

    @Test
    void testUserSetters() {
        user2.setName("Mark");
        user2.setFamilyName("Hills");
        ArrayList<Fraction> f2 = new ArrayList<Fraction>();
        f2.add(new Fraction(4,1));
        user2.setFractions(f2);
        user2.addFraction(new Fraction(5, 2));

        f2.add(new Fraction(5,2));


        assertEquals("Mark", user2.getName());
        assertEquals("Hills", user2.getFamilyName());
        assertEquals(f2, user2.getFractions());
    }

    @Test
    void testUserToString() {
        assertEquals("User{id='id2', name='John', familyName='Foo', fractions=[Fraction{numerator=1, denominator=2}, Fraction{numerator=2, denominator=3}]}", user2.toString());
    }
}
