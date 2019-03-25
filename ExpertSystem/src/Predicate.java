import java.io.IOException;

public class Predicate implements LogicalRule {
private String name;

public Predicate(String name) {
	this.name=name;}

public boolean verify() {
	return InferenceEngine.contains(this)&&!InferenceEngine.falsePredicate(this);}

public boolean equals(Object o) {
	if(o instanceof Predicate)
	{return ((Predicate)o).name.equals(this.name);}
	return true;}

@Override
public boolean match() {
	System.out.println("Test "+name);
	if(InferenceEngine.contains(this))
		return true;
	if(InferenceEngine.checksol(this))
		return InferenceEngine.matchsol(this);
	if(InferenceEngine.falsePredicate(this))
		return false;
	System.out.println(name+"? y/n");
	while(true) {
	try {char c=(char) System.in.read();
		if(c=='y') {
			break;}
		else if(c=='n'){
			InferenceEngine.addfalsePredicate(this);
			System.out.println(this+" is false"+"\n");
			return false;}
	} catch (IOException e) {
	}}
	System.out.println(this+" is true"+"\n");
	InferenceEngine.addPartial(this);
	return true;
}

public String toString(){
	return name;}

@Override
public boolean contains(Predicate p) {
	return this.equals(p);
}
}
