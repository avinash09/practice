package com.spring.security;

import java.util.stream.*;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream.of(2,1,5,4).filter(n->n%2==0).map(n->n*n).forEach(n->System.out.println(n));
	}

}


