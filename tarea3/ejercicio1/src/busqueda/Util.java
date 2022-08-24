package busqueda;

/*
    Este codigo es del libro Weiss de las paginas 368 y 369
 */
public class Util<T extends Comparable<T>> {

    public static <T extends Comparable<T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<T>> void quicksort(T[] a, int low, int high) {
        if (low + 10 > high) {
            insertionSort(a, low, high);
        } else {
            int middle = (low + high) / 2;
            if (a[middle].compareTo(a[low]) < 0) {
                swapReferences(a, low, middle);
            }
            if (a[high].compareTo(a[low]) < 0) {
                swapReferences(a, low, high);
            }
            if (a[high].compareTo(a[middle]) < 0) {
                swapReferences(a, middle, high);
            }
            // Colocar pivot en la posicion high - 1
            swapReferences(a, middle, high - 1);
            T pivot = a[high - 1];
            int i, j;
            for (i = low, j = high - 1;;) {
                while (a[++i].compareTo(pivot) < 0)
                    ;
                while (pivot.compareTo(a[--j]) < 0)
                    ;
                if (i >= j) {
                    break;
                }
                swapReferences(a, i, j);
            }
            // Restaurar pivot
            swapReferences(a, i, high - 1);

            quicksort(a, low, i - 1); // Ordena elementos pequeños
            quicksort(a, i + 1, high); // Ordena elementos grandes
        }

    }

    private static <T extends Comparable<T>> void swapReferences(T[] a, int x, int y) {
        T temporal = a[x];
        a[x] = a[y];
        a[y] = temporal;
    }

    private static <T extends Comparable<T>> void insertionSort(T[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            T temp = a[i];
            int j = i;
            for (; j > 0 && temp.compareTo(a[j - 1]) < 0; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;
        }

    }

}
