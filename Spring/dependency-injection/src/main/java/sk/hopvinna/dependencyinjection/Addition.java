package sk.hopvinna.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class Addition {

	public void add(int a, int b) {
		System.out.println("Addition : " + (a+b));
	}
}
