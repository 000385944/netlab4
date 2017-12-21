package stats;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatsTest {
	
	private static final ArrayList<Integer> numIntList = new ArrayList<>(Arrays.asList(9,2,7,4,5,6,3,8,1,10));
	private static final ArrayList<Double> numDoubleList = new ArrayList<>(Arrays.asList(2.2, 100.0, 17.5, 30.2, 31.1));

	@Test
	public void testAvgUsingIntegerList() {
		assertEquals(5.50, jblink_stats.avg(numIntList, true), 0.0);
	}
	
	@Test
	public void testAvgUsingDoubleList() {
		assertEquals(36.20, jblink_stats.avg(numDoubleList, true), 0.0);
	}

	@Test
	public void testSumUsingIntegerList() {
		assertEquals(55, jblink_stats.sum(numIntList, true), 0.0);
	}
	
	@Test
	public void testSumUsingDoubleList() {
		assertEquals(181, jblink_stats.sum(numDoubleList, true), 0.0);
	}

	@Test
	public void testMedUsingIntegerList() {
		assertEquals(5.50, jblink_stats.med(numIntList), 0.0);
	}
	
	@Test
	public void testMedUsingDoubleList() {
		assertEquals(30.2, jblink_stats.med(numDoubleList), 0.0);
	}

	@Test
	public void testSdUsingIntegerList() {
		assertEquals(3.03, jblink_stats.sd(numIntList), 0.01);
	}
	
	@Test
	public void testSdUsingDoubleList() {
		assertEquals(37.54, jblink_stats.sd(numDoubleList), 0.01);
	}

	@Test
	public void testMain() {
		String[] args = new String[1];
		jblink_stats.main(args);
	}

}

