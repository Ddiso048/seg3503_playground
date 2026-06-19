# SEG3503 Lab 03 — Mesures de couverture

## Objectif
Ce laboratoire porte sur l'exécution de JaCoCo, l'amélioration de la couverture des tests en boîte blanche et la refactorisation de `Date.java` par petits changements.

## Structure

```text
lab03/
  computation/
    src/Computation.java
    test/ComputationTest.java
    report/index.html
    report.csv
    test-results.txt
  date/
    src/Date.java
    test/DateTest.java
    test/DateCoverageTest.java
    report/index.html
    report.csv
    test-results.txt
```

## Commandes utilisées

### Date

```bash
cd date
rm -rf dist report jacoco.exec report.xml report.csv dist_src_only
mkdir dist
javac --release 8 -cp lib/junit-platform-console-standalone-1.7.1.jar -d dist src/*.java test/*.java
java -javaagent:lib/jacocoagent.jar=includes=Date* -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path > test-results.txt
mkdir -p dist_src_only
cp dist/Date.class dist_src_only/
java -jar lib/jacococli.jar report jacoco.exec --classfiles dist_src_only --sourcefiles src --html report --xml report.xml --csv report.csv
```

### Computation

```bash
cd computation
rm -rf dist report jacoco.exec report.xml report.csv dist_src_only
mkdir dist
javac --release 8 -cp lib/junit-platform-console-standalone-1.7.1.jar -d dist src/*.java test/*.java
java -javaagent:lib/jacocoagent.jar=includes=Computation* -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path > test-results.txt
mkdir -p dist_src_only
cp dist/Computation.class dist_src_only/
java -jar lib/jacococli.jar report jacoco.exec --classfiles dist_src_only --sourcefiles src --html report --xml report.xml --csv report.csv
```

## Résultats de couverture

### Date.java après refactorisation

`Date.java` atteint 100 % pour les lignes, les méthodes, les instructions, les branches et la complexité cyclomatique selon JaCoCo.

| Métrique | Résultat |
|---|---:|
| Instructions | 288 / 288 |
| Branches | 44 / 44 |
| Lignes | 45 / 45 |
| Méthodes | 14 / 14 |
| Complexité | 36 / 36 |

### Computation.java

Les tests existants ont été complétés pour couvrir les méthodes principales. La couverture n'est pas à 100 % parce que le bloc `catch` dans `catchesException()` est inatteignable avec l'état actuel du code (`i` vaut toujours 0 avant le `if (i == 13)`).

| Métrique | Résultat |
|---|---:|
| Instructions | 86 / 94 |
| Branches | 9 / 10 |
| Lignes | 29 / 32 |
| Méthodes | 7 / 7 |
| Complexité | 11 / 12 |

## Tests ajoutés

### `DateCoverageTest.java`

Les tests ajoutés couvrent :

- dates valides aux frontières : février bissextile, février non bissextile, mois de 30 jours, mois de 31 jours, année 0;
- dates invalides : jour trop petit, jour trop grand, mois trop petit, mois trop grand, année négative;
- transitions de `nextDate()` : jour normal, fin de mois, février bissextile, février non bissextile, fin d'année;
- règles d'année bissextile : divisible par 4, non divisible par 4, siècle non divisible par 400, siècle divisible par 400;
- `equals()` : même date, objet d'un autre type, année différente, mois différent, jour différent;
- `toString()`.

### `ComputationTest.java`

Les tests ont été complétés pour vérifier :

- `add()` avec valeurs normales et `Integer.MIN_VALUE`;
- `substract()` avec résultat positif et négatif;
- `divide()` avec division normale et division par zéro;
- `multiply()` avec boucle exécutée et boucle non exécutée;
- `justALoop()`;
- `catchesException()` sans exception propagée.

## Refactorisation de Date.java

Refactorisation effectuée :

- extraction de la logique de nombre de jours dans `daysInMonth()`;
- simplification de `setDay()` avec une seule validation basée sur `daysInMonth()`;
- simplification de `isEndOfMonth()`;
- conservation de l'API publique : constructeur, getters, `nextDate()`, `isLeapYear()`, `toString()`, `equals()`.

Cette refactorisation rend la logique plus lisible et plus facile à couvrir sans modifier le comportement attendu par les tests existants.
