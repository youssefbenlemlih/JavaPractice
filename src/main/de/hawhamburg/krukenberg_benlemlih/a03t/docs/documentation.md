# PM2 Aufgabenblatt A03
Youssef Benlemlih, Jonas Krukenberg  
05.04.2020

## Aufgabe 1
Die Klasse ist in der Tat sehr confusing.   
Wir würden erwarten, dass keiner der Konstruktoren mit dem `null` matcht,
da `null` kein Objekt referenziert, also weder ein `Object`, noch ein `double[]` Array ist.  
Erwartungsgemäß sollte also eine Exception geworfen werden.
  
Führen wir den Code allerdings aus, wird "double array" ausgegeben.  
Also wird offenbar immer der Konstruktor genommen, bei dem der Wert des erwarteten Typs `null` sein kann.  
Schließlich funktioniert das auch mit z.B. String, int[] oder Double, 
aber nicht mit primitiven Typen wie double oder int.

## Aufgabe 2
Es wird `Elvis wears a size -1930 belt.` ausgegeben, weil der Klassenvariablen `CURRENT_YEAR` zu dem Zeitpunkt,
an dem `INSTANCE` initialisiert wird noch kein Wert zugewiesen wurde. Dann wird für `beltSize` einfach 0 - 1930 gerechnet.  
int-Typen, die nicht initialisiert wurden, haben einen default-Wert von 0.  
Initialisiert man `INSTANCE` erst nach `CURRENT_YEAR`, wird `beltSize` auf den erwarteten Wert von 90 gesetzt.