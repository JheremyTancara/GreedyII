# Exercise Analysis Greedy II
### Improve the asnwers of Greedy II
- [ ] Author: Jheremy Kevin Tancara Zambrana
_ _ _
_ _ _
### Analyze the problem E of the contest:
***
- Explication Problem:
  This problem is about finding the minimum number of line segments needed to cover the segment [0, M]. Each segment is represented by a pair of coordinates [Li, Ri]. The objective is to select a set of segments such that they cover the entire segment [0, M], and then print these segments sorted by their left coordinate (Li).


- Questionnaire:
    * Identify the greedy choice
    - In the greedy case, the algorithm makes local decisions at each step to maximize the coverage of the segment [0, M]. Instead of evaluating all possible combinations, the algorithm selects the rightmost segments first, which may not lead to the optimal solution.

    * Identify the optimal substructure
    - SO: La solución óptima, es decir, la cantidad mínima de segmentos necesarios para cubrir el segmento [0, M].
      G: La solución global, es decir, la cantidad de segmentos que seleccionamos con el algoritmo greedy.
      L1: La solución local 1, que es la primera decisión local tomada por el algoritmo greedy.

      Podemos expresar la relación entre estas soluciones de la siguiente manera:
       SO=L1+G
       Esto significa que la solución óptima (SO) es igual a la primera decisión local (L1) más la cantidad de segmentos seleccionados por el algoritmo greedy (G). 

    * What is the time complexity of your solution?
    - The complexity of the problem is:
      Data Input: O(t) - t is a constant (It is the number of test cases).
      Sorting: Sort with a sort that has a complexity of O(n log n).
      Main Loop: The but case loop is O(n^2) the best case of O(n).
      Data output: O(t) - t is a constant (It is the number of test cases).
      The complexity could be expressed as:
      O(t * (n log n + n^2)) or in a simplified way O(n^2) the worst case, and the best case O(n log n)


### Analyze the problem Coco Birthday of the contest:
***
- Explication Problem:
  Coco is organizing a birthday party and has invited n of his friends.
  It is the day of the party, and all the guests are in line; each guest takes one minute to enter; the first to enter enters at minute 1, the second to enter enters at minute 2, and so on. Her guests have a happiness x that decreases every minute they do not enter the party. Coco knows that guests will leave the party if they have negative happiness. So she wants to maximize the number of people that join the party.
  Coco notices that sometimes it is convenient for people to enter the party in a different order than in which they are in line. However, if at any time t, m other guests enter the party before the guest in the front row, the guest in the front row will decrease their happiness by m additional points.
  Help Coco maximize the number of people that enter her party.

- Questionnaire:

  * Identify the greedy choice
  - The greedy choice lies in the process of determining which friends can enter the party in a way that maximizes the number of attendees.
  
  * Identify the optimal substructure
  - La solución óptima (SO) se puede definir como la suma de las felicidades acumuladas de los invitados que permanecen en la fiesta.
    La solución local 1 (L1) sería la decisión local que tomamos en cada minuto para permitir o no la entrada del siguiente invitado, basada en si su felicidad es mayor que el tiempo actual o no.
    La solución global (G) sería la estrategia general de dejar entrar a los invitados en orden descendente de felicidad.
    Entonces, podemos expresar la relación entre estas soluciones con la siguiente fórmula:

    SO=L1+G
    Sin embargo, en este caso, la solución local 1 (L1) y la solución global (G) están estrechamente relacionadas, ya que la estrategia global (G) de permitir que los invitados más felices entren primero influye directamente en la decisión local (L1) de permitir la entrada de un invitado en cada minuto.
    Podríamos redefinir la fórmula como:
    SO=G

  * What is the time complexity of your solution?
  - The complexity of the problem is:
    Data Input: O(t) - t is a constant (It is the number of test cases).
    Sorting: Sort with a sort that has a complexity of O(n log n).
    Data output: O(t) - t is a constant (It is the number of test cases).
    The complexity could be expressed as:
    O(t * (n log n) or in a simplified way O(n log n) the worst case, and the best case O(n log n)
