import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		InferenceEngine.create();
		//InferenceEngine.addPredicate(new Predicate("is fat"));
		//InferenceEngine.addPartial(new Predicate("Johnn"));
		InferenceEngine.addImply(new Implies(new Or(new Predicate("Clicking sound"),new Predicate("Corrupt files")),new Predicate("HDD")));
		InferenceEngine.addImply(new Implies(new And(new Predicate("Connectivity"),new Predicate("RAM")),new Predicate("Motherboard")));
		InferenceEngine.addImply(new Implies(new Predicate("PC slow"),new Predicate("RAM")));
		//InferenceEngine.addImply(new Implies(new And(new Predicate("is fat"),new Predicate("John")),new Predicate("drives BMW")));
		System.out.println(new java.io.File("").getAbsolutePath());
		RuleParser.parse("knowledgebase.txt");
		System.out.println(InferenceEngine.getString());
		InferenceEngine.readdata();
		InferenceEngine.findSolution();
		System.out.println(InferenceEngine.getString());
		try {
			new BufferedReader(new InputStreamReader(System.in)).readLine();
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
