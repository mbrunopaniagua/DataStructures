import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K,V> {
	private int size;
	private static final Integer DEFAULT_CAPACITY = 16;
	private MyEntry<K,V>[] values = new MyEntry[DEFAULT_CAPACITY];

	public V get(K key) {
		for(int i=0; i<size; i++) {
			if (values[i].getKey().equals(key)) {
				return values[i].getValue();
			}
		}
		return null;
	}

	public void put(K key, V value) {
		boolean insert = true;
		for(int i=0; i<size; i++) {
			if(values[i].getKey().equals(key)) {
				values[i].setValue(value);
				insert = false;
			}
		}

		if (insert) {
			resize();
			values[size++] = new MyEntry<K, V>(key, value);
		}

	}

	public void remove(K key) {
		for(int i=0; i<size; i++) {
			if (values[i].getKey().equals(key)) {
				size--;
				values[i] = null;
				condense(i);
			}
		}
	}

	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for(int i=0; i<size; i++) {
			set.add(values[i].getKey());
		}
		return set;
	}

	private void resize() {
		if (size == values.length) {
			values = Arrays.copyOf(values, values.length * 2);
		}
	}

	private void condense(int start) {
		for(int i=start; i<size; i++) {
			values[i] = values[i+1];
		}
	}
}
