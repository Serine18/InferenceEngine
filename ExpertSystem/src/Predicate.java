import java.io.IOException;

public class Predicate implements LogicalRule {
private String name;

public Predicate(String name) {
	this.name=name;}

public boolean verify() {
	return InferenceEngine.contains(this);}

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
	System.out.println(name+"? y/n");
	while(true) {
	try {char c=(char) System.in.read();
		if(c=='y') {
			break;}
		else if(c=='n'){
			return false;}
	} catch (IOException e) {
	}}
	System.out.println(name+"\n");
	InferenceEngine.addPartial(this);
	return true;
}

public String toString(){
	return name;}
}
