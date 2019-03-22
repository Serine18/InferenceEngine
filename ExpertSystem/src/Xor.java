
public class Xor implements LogicalRule {
private LogicalRule l,r;
public Xor(LogicalRule l,LogicalRule r)
{this.l=l;
this.r=r;}

public boolean verify() {
	return l.verify()^r.verify();
	}

@Override
public boolean match() {
	System.out.println("match "+l+" xor "+r);
	return l.match()^r.match();}

public String toString()
{return l+" ^ "+r;}
}
