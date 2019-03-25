import java.io.IOException;

public class Not implements LogicalRule {
private LogicalRule r;
public Not(LogicalRule r)
{this.r=r;}

public boolean verify() {
	return !r.verify();}

@Override
public boolean match() {
	System.out.println("not"+r);
	return r.match();
}

public String toString()
{return " not "+r;}

@Override
public boolean contains(Predicate p) {
	return this.r.contains(p);
}

}
