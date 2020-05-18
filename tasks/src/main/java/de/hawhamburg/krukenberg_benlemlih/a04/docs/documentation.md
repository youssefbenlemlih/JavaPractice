# PM2 Aufgabenblatt A04

Youssef Benlemlih, Jonas Krukenberg
20.04.2020

## Java Denksportaufgaben

### 1.

Bei dieser Aufgabe reicht es eine Unterklasse `MyThing` von `Thing` zu erstellen,
die den Kontruktur der Oberklasse mit `super(parameter)` aufruft.
In der Klasse `MyThing` ist das Instanzattribut `parameter` mit dem Schlusselwort
`final` deklariert. D.h es kann nur bei der Initialisierung ein Wert zugewiesen werden.
Mit der Methode `getParameter()` bekommt man den Wert, der bei dem Konstruktor von
`Thing` übergeben wurde.

### 2.

#### 2.1

Beim Ausführen des Programmes, wird `Hello world!`, in der Konsole ausgegeben.

#### 2.2

In Java, kann man auf die Klasssenmethoden direkt bei den Instanzen zugreifen.
Es wird das `null`-Objekt zu einer `null`-Instanz der Klasse `Null` gecastet.
Dann rufen wir mit dieser Instanz die _Klassenmethode_ `Null.greet()` auf.

#### 2.3

Beim Abschreiben dieses Code, haben wir in IntelliJ die folgende Warnung bekommen:
`Static member 'src.main.de.hawhamburg.Null.greet()' accessed via instance reference`.
Sie weist darauf zu, dass man auf die Klassenmethode durch die Instanz zugreift und es wird vorgeschlagen,
`((Null) null).greet();` durch `greet()` zu ersetzen (da `main` auch eine Klassenmethode ist).
Man soll zwischen Klassen- und Instanzmethoden unterscheiden und auf keinen Fall die Warnung durch die
Annotation `@SupressWarnings` stummschalten.

## Datum und Uhrzeit

### 1.

In Java kannman Zeitlängen mithilfe der Klasse `Period` aus `java.time`.
Eine Periode kann man beispielswise mithilfe der Klassenmethode `between` erstellen, die 2 Instanzen
von `LocalDate` als Parameter bekommt.
Die Klasse `Period` stellt uns nutzliche Methoden zurverfügung wie : `getDays()`, `getMonths()` und `getYears()`.

```java
    LocalDate startDate = LocalDate.parse("2017-02-13");
    LocalDate now = LocalDate.now();
    Period period = Period.between(startDate, endDate);
    System.out.println("Zwischen " + startDate + "und heute gibt es "+
                        period.getYears() + " Jahre, oder" +
                        period.getMonths() + " Monate, oder" +
                        period.getDays() + " Tage.");
```

### 2.
#### 2.1 und 2.2
Wir haben eine Zahlungsreihe in der Klasse `Payment` modeliert. Attribute sind:
 * Der Zinssatz `rate` in 1/100 %
 * Die Zahlungen der Zahlungsreihe als HashMap in `payments`: Eine Zahlung wird durch den Schlüssel in 
Form des Zahldatums referenziert.

Der Vorteil an der Modellierung der Zahlungsreihe ist, dass es dann keinen Unterschied mehr macht,
ob es sich um lediglich eine Zahlung in der Zukunft (Aufgabe 2.1) handelt (=> Collection hat nur ein Element), 
oder ob der Barwert einer Zahlungsreihe (Aufgabe 2.2) ermittelt werden soll. 

#### 2.3

Um die Nullstelle einer Methode zuberechnen, haben wir in
unserem Code das Intervallhalbierungsverfahren angewendet.
Dazu haben wir das Interface `Function` definiert, der eine
mathematische Funktion der Form `f(x)=y` representiert.
Die Nullstelleberechnung findet in der UtilityKlassse `FunctionUtils` statt und zwar mithilfe
folgender Klassenmethode:

```
public static double getZeroPoint(Function function,
                                  double rangeStart,
                                  double rangeEnd,
                                  double precision)
```

In FunctionUtilsTest wurde, getestet ob:

- die Function `f(x) = x-1` die Nullstelle 1 im Intervall [-1,5] hat.
- die Function `f(x) = -x²+81` die Nullstelle 9 im Intervall [0,500] hat.
- die Function `f(x) = -x²+81` keine Nullstelle im Intervall [0,8] hat.

### 3.

Wir haben ein Beispiel zur Formatierung vom Datum in der Klasse `DateFormattings`.
Dafür haben wir die Klasse `Locale` gebraucht, die eine Region spezifiziert, 
als auch `DateTimeFormatter`aus `java.time.LocalDate`,
`java.time.format.DateTimeFormatter` und `java.util.Locale`.

*Ausgabe von `src.main.de.hawhamburg.DateFormattings.main` in der Konsole:*
```
Arabisches Format :الأحد، 19 أبريل 2020
Deutsches Format  :Sonntag, 19. April 2020
```