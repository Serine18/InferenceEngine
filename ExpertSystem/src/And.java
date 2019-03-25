
public class And implements LogicalRule {
	private LogicalRule l,r;
	public And(LogicalRule l,LogicalRule r)
	{this.l=l;
	this.r=r;}

	public boolean verify() {
		return l.verify()&&r.verify();}

	@Override
	public boolean match() {
		System.out.println("match "+l+" and "+r);
		return l.match()&&r.match();
	}
	
	public String toString()
	{return l+" && "+r;}

	@Override
	public boolean contains(Predicate p) {
		return this.l.contains(p)||this.r.contains(p);
	}
}
