package com.koreait;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CalcTests {
    @Test
    @DisplayName("1 - 1 == 0")
    void t1(){
        assertThat(Calc.run("1 - 1")).isEqualTo(0);
    }

    @Test
    @DisplayName("1000 + 200 == 1200")
    void t2(){
        assertThat(Calc.run("1000 + 200")).isEqualTo(1000+200);
    }

    @Test
    @DisplayName("2 - 3 - 5 == -6")
    void t3(){
        assertThat(Calc.run("2 - 3 - 5")).isEqualTo(-6);
    }

    @Test
    @DisplayName("50 + 30 + 10 == 90")
    void t4(){
        assertThat(Calc.run("50 + 30 + 10")).isEqualTo(90);
    }

    @Test
    @DisplayName("50 + 30 - 10 == 10")
    void t5(){
        assertThat(Calc.run("50 + 30 - 70")).isEqualTo(10);
    }

    @Test
    @DisplayName("10 - 20 + 30 == 20")
    void t6(){
        assertThat(Calc.run("10 - 20 + 30")).isEqualTo(20);
    }

    @Test
    @DisplayName("10 - 10 - 10 - 10 + 10 + 10 - 10 == -10")
    void t7(){
        assertThat(Calc.run("10 - 10 - 10 - 10 + 10 + 10 - 10")).isEqualTo(-10);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t8(){
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }

    @Test
    @DisplayName("10 + 5 * 2 == 20")
    void t9(){
        assertThat(Calc.run("10 + 5 * 2")).isEqualTo(20);
    }

    @Test
    @DisplayName("10 + 5 * 2 * 10 == 110")
    void t10(){
        assertThat(Calc.run("10 + 5 * 2 * 10")).isEqualTo(110);
    }
    @Test
    @DisplayName("(10 + 20) + 10 == 40")
    void t11(){
        assertThat(Calc.run("(10 + 20) + 10")).isEqualTo(40);
    }

    @Test
    @DisplayName("(10 + 5) * 3 == 45")
    void t12(){
        assertThat(Calc.run("(10 + 5) * 3")).isEqualTo(45);
    }

    @Test
    @DisplayName("10 + (10 + 5) == 25")
    void t13(){
        assertThat(Calc.run("10 + (10 + 5)")).isEqualTo(25);
    }

    @Test
    @DisplayName("10 + (10 + 5) * 10 == 160")
    void t14(){
        assertThat(Calc.run("10 + (10 + 5) * 10")).isEqualTo(160);
    }


    @Test
    @DisplayName("-(10 + 5) == -15")
    void t15(){
        assertThat(Calc.run("-(10 + 5)")).isEqualTo(-15);
    }


    @Test
    @DisplayName("3 * 1 + (1 - (4 * 1 - (1 - 1))) == -3")
    void t16(){
        assertThat(Calc.run("3 * 1 + (1 - (4 * 1 - (1 - 1)))")).isEqualTo(0);
    }

    @Test
    @DisplayName("-(8 + 2) * -(7 + 3) + 5 == 105")
    void t17(){
        assertThat(Calc.run("-(8 + 2) * -(7 + 3) + 5")).isEqualTo(105);
    }

    @Test
    @DisplayName("12 + 1 + 1 * (1 + 2) == 16")
    void t18(){
        assertThat(Calc.run("12 + 1 + 1 * (1 + 2)")).isEqualTo(16);
    }

    }



