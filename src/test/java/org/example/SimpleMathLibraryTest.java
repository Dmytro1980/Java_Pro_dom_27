package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class SimpleMathLibraryTest {

    @Test
    void testAdd_exp() {
        Assertions.assertEquals(5.32, SimpleMathLibrary.add(2.21, 3.11), 0.01);
    }

    @Test
    void testAdd_unexp() {
        Assertions.assertNotEquals(7.0, SimpleMathLibrary.add(3.1, 4.1), 0.01);
    }

    @Test
    void testMinus_exp() {
        Assertions.assertEquals(3.1, SimpleMathLibrary.minus(5.3, 2.2), 0.01);
    }

    @Test
    void testMinus_unexp() {
        Assertions.assertNotEquals(3.0, SimpleMathLibrary.minus(5.3, 2.2), 0.01);
    }

    // несколько шт
    int[] array1 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
    int[] array1_1 = {1, 2, 4, 4, 2, 3, 2, 54, 4, 2, 1, 7};
    int[] array1_2 = {4, 4, 4, 4, 4, 3};

    // 1 шт
    int[] array2 = {1, 2, 3, 7, 2, 3, 3, 1, 4};  // 1 шт в конце
    int[] array2_1 = {4};  // 1 шт
    int[] array3 = {4, 2, 3, 7, 2, 3, 3, 1, 8};  // 1 шт в начале

    // 0 шт
    int[] array4 = {5, 2, 3, 7, 2, 3, 3, 1, 8};  // 0 шт
    int[] array4_1 = {5};

    int[] array5 = {4, 2, 3, 4, 2, 3, 3, 1, 4};  // 3 шт в начале, в середине и в конце
    int[] array6 = {4, 4, 4, 4, 4, 4, 4, 4, 4};  // все 4

    @Test
    void testCreateArray_fewNumbers01() {
        Assertions.assertArrayEquals(new int[]{1, 7}, SimpleMathLibrary.createNewArray(array1));
    }

    @Test
    void testCreateArray_fewNumbers02() {
        Assertions.assertArrayEquals(new int[]{2, 1, 7}, SimpleMathLibrary.createNewArray(array1_1));
    }

    @Test
    void testCreateArray_fewNumbers03() {
        Assertions.assertArrayEquals(new int[]{3}, SimpleMathLibrary.createNewArray(array1_2));
    }

    @Test
    void testCreateArray_numberInEnd() {
        Assertions.assertArrayEquals(new int[]{}, SimpleMathLibrary.createNewArray(array2));
    }

    @Test
    void testCreateArray_oneNumber() {
        Assertions.assertArrayEquals(new int[]{}, SimpleMathLibrary.createNewArray(array2_1));
    }

    @Test
    void testCreateArray_numberInBegin() {
        Assertions.assertArrayEquals(new int[]{2, 3, 7, 2, 3, 3, 1, 8}, SimpleMathLibrary.createNewArray(array3));
    }

    @Test
    void testCreateArray_manyOtherNumbers() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> SimpleMathLibrary.createNewArray(array4));
    }

    @Test
    void testCreateArray_oneOtherNumber() {
        Assertions.assertThrowsExactly(RuntimeException.class, () -> SimpleMathLibrary.createNewArray(array4_1));
    }

    @Test
    void testCreateArray_numberInBeginAndEnd() {
        Assertions.assertArrayEquals(new int[]{}, SimpleMathLibrary.createNewArray(array5));
    }

    @Test
    void testCreateArray_AllNumbers() {
        Assertions.assertArrayEquals(new int[]{}, SimpleMathLibrary.createNewArray(array6));
    }

    int[] array7 = {1, 1, 1, 4, 4, 1, 4, 4};    //  -> true
    int[] array8 = {1, 1, 1, 1, 1, 1};          // -> false
    int[] array8_1 = {1};                       // -> false
    int[] array8_2 = {4};                       // -> false
    int[] array9 = {4, 4, 4, 4};                 // -> false
    int[] array10 = {1, 4, 4, 1, 1, 4, 3};       // -> false
    int[] array10_1 = {5, 7, 7, 8, 1};       // -> false
    int[] array10_2 = {5, 7, 7, 8, 4};       // -> false
    int[] array11 = {11, 44, 5, 3, 6, 2, 2};       // -> false

    @Test
    void testCheckArray_expTrue() {
        Assertions.assertTrue(SimpleMathLibrary.checkArray(array7));
    }

    @Test
    void testCheckArray_expFalseOnlyOne() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array8));
    }

    @Test
    void testCheckArray_expFalseOnlyOne_oneNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array8_1));
    }

    @Test
    void testCheckArray_expFalseOnlyFour_oneNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array8_2));
    }

    @Test
    void testCheckArray_expFalseOnlyFour() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array9));
    }

    @Test
    void testCheckArray_expFalseOneFourAndOtherNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array10));
    }

    @Test
    void testCheckArray_expFalseOneAndOtherNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array10_1));
    }

    @Test
    void testCheckArray_expFalseFourAndOtherNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array10_2));
    }

    @Test
    void testCheckArray_expFalseOtherNumber() {
        Assertions.assertFalse(SimpleMathLibrary.checkArray(array11));
    }
}