# PM2 Aufgabenblatt A06

Youssef Benlemlih, Jonas Krukenberg
12.05.2020

## Java Denksportaufgaben

### 1. RandomNumbers
Die vorliegende Methode zur Ermittlung einer Pseudozufallszahl gibt als Ergebnis den Rest einer ganzzahligen Division einer
Zufallszahl zwischen 0 und 2^31 mit n zurück.
Der Anwender kann diese Zufallszahl mit dem Paramater `n` beeinflussen, also eine bestimmte Wahrscheinlichkeit vorgeben.  
Bloß verhält sich die Methode nicht wie erwartet. Erst, wenn man den Wertebereich für die Zufallszahl mit 
`rand.nextInt(n)` mit `n` als upperBound anstelle der ganzzahligen Division angibt, bekommt man die Zufallszahlen mit
der erwarteten Wahrscheinlichkeit.   
Anmerkung: Da `rand.nextInt()` für immer dasselbe Objekt `static Rand rand = new Random()` verwendet wird,
sollte die Zufallszahlenfolge immer die selbe sein. Allerdings wurde kein Seed gesetzt. Wenn man Reproduzierbarkeit in Tests
möglich machen möchte, könnte man auch einen Seed festlegen: z.B. `new Random(39939)`.  

Möchte man die Zufallszahl aus einem Stream generieren, ginge das mit
`return rand.ints(1, 0, n + 1).findFirst().orElse(-1);`

### 2. NaturalOrder
Es erschließt sich uns keine Fehlfunktion der Methode. Die Anwendung `list.sort(naterualOrder())` funktioniert 
wunderbar: Die Integer-Werte in der ArrayList list werden korrekt sortiert.