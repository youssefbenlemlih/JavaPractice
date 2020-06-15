# PM2 Aufgabenblatt A08

Youssef Benlemlih, Jonas Krukenberg
07.06.2020

## Java Denksportaufgaben

### Grenzen der Parallelisierung
Die Ermittlung der ersten n Mersenne-Primzahlen unterscheidet sich in der Laufzeit gewaltig, wenn dies parallel statt
sequentiell abgearbeitet wird und n immer größer gewählt wird.  
Das liegt daran, dass `primes()` einen unbegrenzten Stream liefert, aber das Ergebnis limitiert wird.  
Wird der Stream parallel gefiltert, geschieht dies ungeordnet. Daher ist selbst bei den ersten n gefundenen Primzahlen
noch nicht gewiss, ob es sich dabei wirklich um die _ersten_ Werte handelt. 
Für dieses Ermittlung steigt der Rechenaufwand gegenüber der seqeuentiellen Verarbeitung stark an.