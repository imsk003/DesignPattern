package sk.hopvinna.dependencyinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculation {

	@Autowired
	private Addition addition;
	
	public void calc() {
		addition.add(10, 10);
	}
}
