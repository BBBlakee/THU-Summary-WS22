private static <E> Set<Set<E>> allSubsets(E[] arr,int maxIndex) {
Set<Set<E>> resultSet = new HashSet<Set<E>>();
if (maxIndex >= 0) {
// Menge ist nicht leer, wähle letztes Element im gegebenen Feldbereich
E selected = arr[maxIndex];
// bilde rekursiv alle Teilmengen ohne das gewählte Element selected
Set<Set<E>> resultSet1 = allSubsets(arr, maxIndex - 1);
// nimm jede dieser Mengen zum Ergebnis hinzu
resultSet.addAll(resultSet1);
// bilde alle Teilmengen, die selected enthalten
for (Set<E> set1 : resultSet1) {
// Erzeuge Kopie der Menge aus resultSet1 und nimm
// gewähltes Element dazu
Set<E> set2 = new HashSet<E>(set1);
set2.add(selected);
// füge die ergänzte Kopie zum Ergebnis hinzu
resultSet.add(set2);
}
} else {
// Menge ist leer. Leere Menge hat nur leere Menge als
// einzige Teilmenge
Set<E> emptySet = new HashSet<>();
resultSet.add(emptySet);
}
return resultSet;
}