package sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    private QuickSort underTest;

    @BeforeEach
    void setUp() {
        underTest = new QuickSort();
    }

    @Test
    void shouldSortedArray() {
        // given
        int[] input = {42, 12, 23, 4, 15, 3, 2, 8, 36, 1, 9, 6, 100};
        int[] expectedResult = {1, 2, 3, 4, 6, 8, 9, 12, 15, 23, 36, 42, 100};

        // when
        underTest.sort(input);

        // then
        assertThat(input).isEqualTo(expectedResult);
    }

}
