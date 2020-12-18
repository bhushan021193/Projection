package com.wcs.optional;

import java.util.Optional;

public class OptioanlExample {

	public static void main(String[] args) {

		String[] str = new String[10];

	//	String lc = str[5].toLowerCase();

	//	System.out.println(lc);
		str[5]="yes present";

		Optional<String> checkNull = Optional.ofNullable(str[5]);
//		if (checkNull.isPresent()) {
//
//			String lc1=str[5].toLowerCase();
//			System.out.println(lc1);
//
//		} else {
//
//			System.out.println("string value is not present");
//		}
checkNull.ifPresent(System.out::println);
	}

}
