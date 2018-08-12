import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;

public class MyMapTest {

	private MyMap<Integer, String> myMap;

	@Before
	public void setUp() {
		myMap = new MyMap<Integer, String>();
	}

	@Test
	public void keySetShouldBeEmpty() {
		Set<Integer> keySet = myMap.keySet();

		assertThat(keySet.isEmpty(), is(true));
	}

	@Test
	public void keySetShouldNotBeEmpty() {
		myMap.put(1, "1");
		Set<Integer> keySet = myMap.keySet();

		assertThat(keySet.isEmpty(), is(false));
		assertThat(keySet.size(), is(1));
		assertThat(keySet.contains(1), is(true));
	}

	@Test
	public void testRemoveProperly() {
		myMap.put(1, "1");
		myMap.put(2, "2");
		myMap.put(3, "3");
		myMap.remove(2);
		myMap.remove(4);
		Set<Integer> keySet = myMap.keySet();

		assertThat(keySet.isEmpty(), is(false));
		assertThat(keySet.size(), is(2));
		assertThat(keySet.containsAll(Arrays.asList(1,3)), is(true));
	}

	@Test
	public void testGetProperly() {
		myMap.put(1, "1");
		myMap.put(2, "2");
		myMap.put(3, "3");

		assertThat(myMap.get(1), is("1"));
		assertThat(myMap.get(2), is("2"));
		assertThat(myMap.get(3), is("3"));
		assertThat(myMap.get(4), is(nullValue()));
	}
}
