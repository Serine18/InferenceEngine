
public class Implies implements Rule {
	private LogicalRule r;
	private Predicate p;
	
	public Implies(LogicalRule r,Predicate p)
	{this.p=p;
	this.r=r;}
	
	public boolean verify() {
		if(r.verify())
			{InferenceEngine.addPartial(p);
			System.out.println(p+" is true");
			return true;}
		return false;
	}
	
	public boolean findsolution()
	{System.out.println("findsol "+r+" => "+p);
	boolean cond=false;
	cond=r.match()||p.match();
	return true;		
	}

	public boolean match() {
		System.out.println("match "+r+" => "+p);
		if((!InferenceEngine.contains(p))&&r.match())
			{System.out.println(p+" is true\n");
			if(!InferenceEngine.checkpremise(p))
			InferenceEngine.addnewPredicate(p);
			else InferenceEngine.addPartial(p);
			return true;}
		return false;
	}
	
	public boolean checkres(Predicate pred)
	{if(pred.equals(p))
		return true;
		return false;}
	
	public boolean matchres(Predicate pred)
	{if(checkres(pred)){
		System.out.println("Test "+this);
		return r.match();}
	return false;}
	
	public String toString()
	{return r+" => "+p;}

	public  boolean checkpremise(Predicate p)
	{return this.r.contains(p);}
}
