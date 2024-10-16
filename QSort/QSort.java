import java.util.*;

class QSort {
    void quickSort(String names[], int low, int high) {
        if (low < high) {
            int l = low, h = high, p = low;
            String temp;
            while (l < h) {
                while ((names[l].compareToIgnoreCase(names[p]) <= 0) && l < h) {
                    l++;
                }
                while ((names[h].compareToIgnoreCase(names[p]) > 0)) {
                    h--;
                }
                if (l < h) {
                    temp = names[l];
                    names[l] = names[h];
                    names[h] = temp;
                }
            }
            temp = names[h];
            names[h] = names[p];
            names[p] = temp;
            quickSort(names, low, h - 1);
            quickSort(names, h + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of names:");
        int n = sc.nextInt();
        String names[] = new String[n];
        sc.nextLine();
        QSort b = new QSort();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name " + (i + 1) + " ");
            names[i] = sc.nextLine();
        }
        b.quickSort(names, 0, n - 1);
        System.out.println("Sorted List:");
        for (String i : names) {
            System.out.println(i);
        }
    }
}