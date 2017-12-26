package stats;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatsTest {
	
	private static final ArrayList<Integer> numIntList = new ArrayList<>(Arrays.asList(9,2,7,4,5,6,3,8,1,10));
	private static final ArrayList<Integer> numNegIntList = new ArrayList<>(Arrays.asList(-9,-2,-7));
	private static final ArrayList<Double> numDoubleList = new ArrayList<>(Arrays.asList(2.2, 100.0, 17.5, 30.2, 31.1));
	private static final ArrayList<Double> numDoubleNegList = new ArrayList<>(Arrays.asList(2.2, 50.0, 17.6, 30.2, 30.1));

	@Test
	public void testClassInitialiser() {
		jblink_stats JBLinkStats = new jblink_stats();
		assertTrue(JBLinkStats.getClass() == jblink_stats.class);
	}
	
	@Test
	public void testAvgUsingIntegerList() {
		assertEquals(5.50, jblink_stats.avg(numIntList, true), 0.0);
	}
	
	@Test
	public void testAvgUsingIntegerListWithIncPositive() {
		assertEquals(5.50, jblink_stats.avg(numIntList, false), 0.0);
	}
	
	@Test
	public void testAvgUsingNegativeIntegerList() {
		assertEquals(-6, jblink_stats.avg(numNegIntList, true), 0.0);
	}
	
	@Test
	public void testAvgUsingNegativeIntegerIncPositiveList() {
		try {
			jblink_stats.avg(numNegIntList, false);
		} catch (Exception e) {
			assertEquals(e.getLocalizedMessage(), "no values are > 0");
			assertEquals(e.getClass(), java.lang.IllegalArgumentException.class);
		}
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
	public void testSumUsingIntegerListWithIncPositive() {
		assertEquals(55, jblink_stats.sum(numIntList, false), 0.0);
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
	public void testMedUsingNegIncDoubleList() {
		assertEquals(30.1, jblink_stats.med(numDoubleNegList), 0.0);
	}
	
	@Test
	public void testSdUsingSmallIntegerList() {
		try {
			jblink_stats.sd(new ArrayList<>(Arrays.asList(9)));
		} catch (Exception e) {
			assertEquals(e.getLocalizedMessage(), "Size of array must be greater than 1");
			assertEquals(e.getClass(), java.lang.IllegalArgumentException.class);
		}
			
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

