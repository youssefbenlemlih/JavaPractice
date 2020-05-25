# PM2 Aufgabenblatt A06

Youssef Benlemlih, Jonas Krukenberg
12.05.2020

## Java Denksportaufgaben

### 1. RandomNumbers
Die vorliegende Methode zur Ermittlung einer Pseudozufallszahl gibt als Ergebnis den Rest einer ganzzahligen Division einer
Zufallszahl zwischen 0 und 2^31 mit n zurück.

Der Absolutbetrag (Math.abs) von Integer.MIN_VALUE ist Integer.MIN_VALUE (negativ!), da -2^31 nicht +2^31 sein kann, weil es nur bis
2^(31-1) geht.

Aktuelle Empfehlung: **ThreadLocalRandom** - schneller und bessere Zufallszahlen

### 2. NaturalOrder
Es erschließt sich uns keine Fehlfunktion der Methode. Die Anwendung `list.sort(naterualOrder())` funktioniert 
wunderbar: Die Integer-Werte in der ArrayList list werden korrekt sortiert.