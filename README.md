# Représentation de formules

## Description du projet

Dans cette planche de TP, vous allez implémenter des classes pour générer des formules mathématiques. Chaque classe 
correspondra à un type de formule (constantes, variable, addition, multiplication, ... ).

Chaque classe devra implémenter l'interface Formula suivante :

```java
public interface Formula {

  /**
   * Compute the value of the formula
   *
   * @param xValue the value of the variable x
   * @return the value of the function when the variable x has value {@code xValue}
   */
  double eval(double xValue);

  /**
   * Compute a {@code String} representation of the formula.
   * @return the formula as a {@code String}
   */
  String toString();

  /**
   * Compute the derivative of the formula.
   * @return the derivative of the formula
   */
  Formula derivative();
}
```

Une classe implémentant `Formula` devra donc avoir trois fonctionnalités :

- le calcul de sa valeur étant donnée une valeur pour la variable $x$ : méthode `eval`,
- la représentation en chaîne de caractères de la formule : méthode `toString`,
- le calcul de sa dérivée sous la forme d'une autre formule : méthode `derivative`.


## Membres du projet

- NOM, prénom
- NOM, prénom
