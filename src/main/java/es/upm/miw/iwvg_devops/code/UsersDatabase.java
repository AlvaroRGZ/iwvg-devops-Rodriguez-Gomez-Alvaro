package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;

public class UsersDatabase {

    public Stream<User> findAll() {

        List<Fraction> fractions1 = List.of(
                new Fraction(0, 1),
                new Fraction(1, 1),
                new Fraction(2, 1)
        );
        List<Fraction> fractions2 = List.of(
                new Fraction(2, 1),
                new Fraction(-1, 5),
                new Fraction(2, 4),
                new Fraction(4, 3)
        );
        List<Fraction> fractions3 = List.of(
                new Fraction(1, 5),
                new Fraction(3, -6),
                new Fraction(1, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions4 = List.of(
                new Fraction(2, 2),
                new Fraction(4, 4)
        );
        List<Fraction> fractions5 = List.of(
                new Fraction(0, 1),
                new Fraction(0, -2),
                new Fraction(0, 3)
        );

        List<Fraction> fractions6 = List.of(
                new Fraction(0, 0),
                new Fraction(1, 0),
                new Fraction(1, 1)
        );

        return Stream.of(
                new User("1", "Oscar", "Fernandez", fractions1),
                new User("2", "Ana", "Blanco", fractions2),
                new User("3", "Oscar", "López", fractions3),
                new User("4", "Paula", "Torres", fractions4),
                new User("5", "Antonio", "Blanco", fractions5),
                new User("6", "Paula", "Torres", fractions6)
        );
    }

    public Fraction findFractionSubtractionByUserName(String name) {
        List<User> usersList = findAll().filter(user -> user.getName().equals(name)).toList();
        if (!usersList.isEmpty()) {
            return usersList.get(0).getFractions().stream()
                    .reduce((a, b) -> a.add(new Fraction(-b.getNumerator(), b.getDenominator())))
                    .orElse(new Fraction());
        } else {
            return new Fraction();
        }
    }

    public Fraction findHighestFraction() {
        return findAll()
                .flatMap(user -> user.getFractions().stream())
                .max(Comparator.comparingDouble(f -> (double) f.decimal()))
                .orElse(new Fraction());
    }
}