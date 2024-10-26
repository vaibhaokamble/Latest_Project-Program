package vaibhao.vk;

import java.util.*;
import java.util.stream.Collectors;

public class FilterArrayElement {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);
		numbers.add(6);
		numbers.add(7);
		numbers.add(8);
		numbers.add(9);
		numbers.add(10);

		System.out.println("Original list:");
		numbers.forEach(System.out::println);

		List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());

		System.out.println("\nFiltered even numbers:");
		evenNumbers.forEach(System.out::println);

	}

}
