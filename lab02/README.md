# Lab 02 - Classes d'équivalence

## Exercice 1

| Cas de Test | Entrée (y, m, d) | Résultat Escompté | Résultat Actuel | Verdict |
|:-----------:|:----------------:|:-----------------:|:---------------:|:-------:|
| TC1  | 1700, 06, 20 | 1700/June/21       | 1700/June/21       | Succès |
| TC2  | 2005, 04, 15 | 2005/April/16      | 2005/April/16      | Succès |
| TC3  | 1901, 07, 20 | 1901/July/21       | 1901/July/21       | Succès |
| TC4  | 3456, 03, 27 | 3456/March/28      | 3456/March/28      | Succès |
| TC5  | 1500, 02, 17 | 1500/February/18   | 1500/February/18   | Succès |
| TC6  | 1700, 06, 29 | 1700/June/30       | 1700/June/30       | Succès |
| TC7  | 1800, 11, 29 | 1800/November/30   | 1800/November/30   | Succès |
| TC8  | 3453, 01, 29 | 3453/January/30    | 3453/January/30    | Succès |
| TC9  | 444, 02, 29  | 444/March/1        | 444/March/1        | Succès |
| TC10 | 2005, 04, 30 | 2005/May/1         | 2005/May/1         | Succès |
| TC11 | 3453, 01, 30 | 3453/January/31    | 3453/January/31    | Succès |
| TC12 | 3456, 03, 30 | 3456/March/31      | 3456/March/31      | Succès |
| TC13 | 1901, 07, 31 | 1901/August/1      | 1901/August/1      | Succès |
| TC14 | 3453, 01, 31 | 3453/February/1    | 3453/February/1    | Succès |
| TC15 | 3456, 12, 31 | 3457/January/1     | 3457/January/1     | Succès |
| TC16 | 1500, 02, 31 | IllegalArgumentException | IllegalArgumentException | Succès |
| TC17 | 1500, 02, 29 | IllegalArgumentException | IllegalArgumentException | Succès |
| TC18 | -1, 10, 20   | IllegalArgumentException | IllegalArgumentException | Succès |
| TC19 | 1458, 15, 12 | IllegalArgumentException | IllegalArgumentException | Succès |
| TC20 | 1975, 06, -50 | IllegalArgumentException | IllegalArgumentException | Succès |

## Exercice 2

J'ai créé trois fichiers de tests :

- `DateTest.java` : 20 tests JUnit 5 explicites, un par cas de test
- `DateNextDateOkTest.java` : tests paramétrés JUnit 4 pour les cas valides (TC1 à TC15)
- `DateNextDateExceptionTest.java` : tests paramétrés JUnit 4 pour les cas qui lancent une exception (TC16 à TC20)
