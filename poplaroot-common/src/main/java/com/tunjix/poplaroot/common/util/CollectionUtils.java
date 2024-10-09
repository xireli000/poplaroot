package com.tunjix.poplaroot.common.util;

import java.util.*;

/**
 * AUTHOR: XirALi · MaMat（西尔艾力·买买提）
 * DATE: 2024/8/7 15:21
 */
public class CollectionUtils {

	
	static final float DEFAULT_LOAD_FACTOR = 0.75f;


	
	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}

	
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	
	public static <K, V> HashMap<K, V> newHashMap(int expectedSize) {
		return new HashMap<>(computeMapInitialCapacity(expectedSize), DEFAULT_LOAD_FACTOR);
	}

	
	public static <K, V> LinkedHashMap<K, V> newLinkedHashMap(int expectedSize) {
		return new LinkedHashMap<>(computeMapInitialCapacity(expectedSize), DEFAULT_LOAD_FACTOR);
	}

	private static int computeMapInitialCapacity(int expectedSize) {
		return (int) Math.ceil(expectedSize / (double) DEFAULT_LOAD_FACTOR);
	}

	
	@SuppressWarnings("unchecked")
	public static <K, V> void mergePropertiesIntoMap(Properties props, Map<K, V> map) {
		if (props != null) {
			for (Enumeration<?> en = props.propertyNames(); en.hasMoreElements();) {
				String key = (String) en.nextElement();
				Object value = props.get(key);
				if (value == null) {
					// Allow for defaults fallback or potentially overridden accessor...
					value = props.getProperty(key);
				}
				map.put((K) key, (V) value);
			}
		}
	}

	
	public static boolean containsInstance(Collection<?> collection, Object element) {
		if (collection != null) {
			for (Object candidate : collection) {
				if (candidate == element) {
					return true;
				}
			}
		}
		return false;
	}


	public static boolean containsAny(Collection<?> source, Collection<?> candidates) {
		return findFirstMatch(source, candidates) != null;
	}


	
	public static <E> E findFirstMatch(Collection<?> source, Collection<E> candidates) {
		if (isEmpty(source) || isEmpty(candidates)) {
			return null;
		}
		for (E candidate : candidates) {
			if (source.contains(candidate)) {
				return candidate;
			}
		}
		return null;
	}

	
	@SuppressWarnings("unchecked")
	
	public static <T> T findValueOfType(Collection<?> collection, Class<T> type) {
		if (isEmpty(collection)) {
			return null;
		}
		T value = null;
		for (Object element : collection) {
			if (type == null || type.isInstance(element)) {
				if (value != null) {
					// More than one value found... no clear single value.
					return null;
				}
				value = (T) element;
			}
		}
		return value;
	}


	public static boolean hasUniqueObject(Collection<?> collection) {
		if (isEmpty(collection)) {
			return false;
		}
		boolean hasCandidate = false;
		Object candidate = null;
		for (Object elem : collection) {
			if (!hasCandidate) {
				hasCandidate = true;
				candidate = elem;
			}
			else if (candidate != elem) {
				return false;
			}
		}
		return true;
	}


	
	public static Class<?> findCommonElementType(Collection<?> collection) {
		if (isEmpty(collection)) {
			return null;
		}
		Class<?> candidate = null;
		for (Object val : collection) {
			if (val != null) {
				if (candidate == null) {
					candidate = val.getClass();
				}
				else if (candidate != val.getClass()) {
					return null;
				}
			}
		}
		return candidate;
	}


	
	public static <T> T firstElement(List<T> list) {
		if (isEmpty(list)) {
			return null;
		}
		return list.get(0);
	}


	
	public static <T> T lastElement(List<T> list) {
		if (isEmpty(list)) {
			return null;
		}
		return list.get(list.size() - 1);
	}

	public static <A, E extends A> A[] toArray(Enumeration<E> enumeration, A[] array) {
		ArrayList<A> elements = new ArrayList<>();
		while (enumeration.hasMoreElements()) {
			elements.add(enumeration.nextElement());
		}
		return elements.toArray(array);
	}

}
