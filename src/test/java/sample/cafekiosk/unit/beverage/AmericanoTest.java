package sample.cafekiosk.unit.beverage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AmericanoTest {
    @Test
    void getName() {
        Americano americano = new Americano();
//        assertEquals(americano.getName(), "아메리카노"); // JUnit
        assertThat(americano.getName()).isEqualTo("아메리카노"); // AssertJ
    }

    @Test
    void getPrice() {
        Americano americano = new Americano();
        assertThat(americano.getPrice()).isEqualTo(4000);
    }

}