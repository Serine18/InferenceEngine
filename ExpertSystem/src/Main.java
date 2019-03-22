
public class Main {

	public static void main(String[] args) {
		InferenceEngine.create();
		//InferenceEngine.addPredicate(new Predicate("is fat"));
		//InferenceEngine.addPartial(new Predicate("John"));
		InferenceEngine.addImply(new Implies(new Predicate("PC slow"),new Predicate("RAM")));
		InferenceEngine.addImply(new Implies(new And(new Predicate("RAM"),new Predicate("Connectivity")),new Predicate("Motherboard")));
		//InferenceEngine.addImply(new Implies(new And(new Predicate("is fat"),new Predicate("John")),new Predicate("drives BMW")));
		InferenceEngine.findSolution();
		System.out.println(InferenceEngine.getString());

	}

}
