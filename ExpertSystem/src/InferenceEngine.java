import java.util.ArrayList;
import java.util.List;

public class InferenceEngine {
private static InferenceEngine ie=null;
private static List<Implies> implylist;
private static List<Predicate> predicatelist,partialsolutions;

private InferenceEngine(){
	implylist=new ArrayList<Implies>();
	predicatelist=new ArrayList<Predicate>();
	partialsolutions=new ArrayList<Predicate>();}

public static InferenceEngine create(){
	ie=new InferenceEngine();
	return ie;}

public static boolean contains(Predicate p){
	for(Predicate q:predicatelist)
		if(q.equals(p))
			return true;
	for(Predicate q:partialsolutions)
		if(q.equals(p))
			return true;
	return false;}

public static void addPartial(Predicate p){
	partialsolutions.add(p);}

public static void addImply(Implies i){
	implylist.add(i);}

public static void addPredicate(Predicate p) {
	predicatelist.add(p);}

public static void findSolution()
{
int cnt;	
do{cnt=0;
	List<Predicate> auxlist=new ArrayList<Predicate>();
for(Predicate p:partialsolutions)
	auxlist.add(p);
for(Implies i:implylist)
	{if(i.match())
			cnt++;}
}while(cnt!=0);
}


public static String getString()
{String aux="";
aux+="Predicate list\n";
for(Predicate p:predicatelist)
	aux+=p+"\n";
aux+="Imply list\n";
for(Implies i:implylist)
	aux+=i+"\n";
aux+="Partial solutions\n";
for(Predicate p:partialsolutions)
	aux+=p+"\n";
return aux;}

}
