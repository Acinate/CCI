package test.java;

import algorithms.dynamic_programming.MagicIndex.MagicIndex;
import algorithms.dynamic_programming.PowerSet.PowerSet;
import algorithms.dynamic_programming.RecursiveMultiply.RecursiveMultiply;
import algorithms.dynamic_programming.RobotInGrid.RobotInGrid;
import algorithms.dynamic_programming.TripleStep.TripleStep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class TestDynamicProgramming {

    private TripleStep tripleStep = new TripleStep();
    private RobotInGrid robotInGrid = new RobotInGrid();
    private MagicIndex magicIndex = new MagicIndex();
    private PowerSet powerSet = new PowerSet();
    private RecursiveMultiply recursiveMultiply = new RecursiveMultiply();

    @Test
    void TestTripleStep() {
        Assertions.assertEquals(4, tripleStep.count(3));
        Assertions.assertEquals(4, tripleStep.countWays(3));
    }

    @Test
    void TestRobotInGrid() {
        boolean[][] maze = {
                {true, true, false},
                {false, true, false},
                {false, true, false},
                {false, true, true}
        };

        ArrayList<Point> path = robotInGrid.getPath(maze);

        Assertions.assertNotNull(path);
        Assertions.assertEquals(6, path.size());
    }

    @Test
    void TestMagicIndex() {
        int[] array = new int[] {0,1,2,3,5,6,7,8,9,10};
        int[] array2 = new int[] {0,1,1,1,5,6,7,8,9,10};
        Assertions.assertEquals(1,magicIndex.magicFast(array));
        Assertions.assertEquals(1,magicIndex.magicFastNonDistinct(array));
        Assertions.assertEquals(1,magicIndex.magicFastNonDistinct(array2));

    }

    @Test
    void TestPowerSet() {
        ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<ArrayList<Integer>> subsets = powerSet.getSubsets(set);
        Assertions.assertNotNull(subsets);
        Assertions.assertEquals(32, subsets.size());
    }

    @Test
    void RecursiveMultiply() {
        Assertions.assertEquals(0, recursiveMultiply.minProduct(0,2));
        Assertions.assertEquals(2, recursiveMultiply.minProduct(1,2));
        Assertions.assertEquals(4, recursiveMultiply.minProduct(2,2));
        Assertions.assertEquals(6, recursiveMultiply.minProduct(3,2));
    }
}
