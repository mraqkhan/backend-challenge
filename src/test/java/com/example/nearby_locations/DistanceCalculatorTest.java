package com.example.nearby_locations;

import com.example.nearby_locations.util.DistanceCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.util.AssertionErrors.*;


@SpringBootTest
class DistanceCalculatorTest {

    @Test
    void test0() {
        double distance = DistanceCalculator.distance(0, 0, 0, 1);
        assertTrue("1 degree distance check", Math.abs(distance - DistanceCalculator.ONE_DEGREE_DISTANCE) < 1);
    }

    @Test
    void test1() {
        double distance = DistanceCalculator.distance(0, 0, 0, 180);
        assertTrue("Checking the maximum distance along the equator", Math.abs(distance - DistanceCalculator.EQUATOR/2) < 25);
    }

    @Test
    void test2() {
        double distance = DistanceCalculator.distance(0, 0, -179, 179);
        assertTrue("Checking the distance at the junction of the hemispheres", Math.abs(distance - DistanceCalculator.ONE_DEGREE_DISTANCE * 2) < 1);
    }

    @Test
    void test3() {
        double distanceOnEquator = DistanceCalculator.distance(0, 0, 0, 1);
        double distanceOnFirstDegree = DistanceCalculator.distance(1, 1, 0, 1);

        assertFalse("Checking whether we take into account the curvature of the earth", distanceOnFirstDegree == distanceOnEquator);
    }
}
