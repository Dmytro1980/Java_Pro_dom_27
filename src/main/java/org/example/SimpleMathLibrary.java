package org.example;

public class SimpleMathLibrary {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    public static int[] createNewArray(int[] array) {
        int numberLastPlace = -1;   //  индекс элемента массива содержащий последнюю цифру 4
        int[] newArray;             // новый массив

        // цикл проходит исходный массив и ищет индекс элемента массива содержащий последнюю цифру 4
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4) {
                numberLastPlace = i;
            }
        }
        if (numberLastPlace != -1) {                        // если найдена цифра 4
            if (numberLastPlace == array.length - 1) {      // если цифра 4 не последняя
                return new int[0];
            } else {
                newArray = new int[array.length - numberLastPlace - 1];
                for (int i = numberLastPlace + 1, j = 0; i < array.length; i++, j++) {
                    newArray[j] = array[i];
                }
                return newArray;
            }
        } else {
            throw new RuntimeException();
        }
    }

    public static boolean checkArray(int[] array) {
        boolean isOnePresent = false;
        boolean isFourPresent = false;
        boolean isOtherNumberPresent = false;
        for (int i : array) {
            if (i == 1) {
                isOnePresent = true;
            } else if (i == 4) {
                isFourPresent = true;
            } else isOtherNumberPresent = true;
        }

        if (isOnePresent & isFourPresent & !isOtherNumberPresent) return true;

        return false;
    }
}
