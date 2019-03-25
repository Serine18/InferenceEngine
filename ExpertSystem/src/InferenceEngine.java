import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InferenceEngine {
private static InferenceEngine ie=null;
private static List<Implies> implylist;
private static List<Predicate> predicatelist,newpredicatelist,partialsolutions;

private InferenceEngine(){
	implylist=new ArrayList<Implies>();
	predicatelist=new ArrayList<Predicate>();
	partialsolutions=new ArrayList<Predicate>();
	newpredicatelist=new ArrayList<Predicate>();}

public static InferenceEngine create(){
	ie=new InferenceEngine();
	return ie;}

public static boolean contains(Predicate p){
	for(Predicate q:predicatelist)
		if(q.equals(p)){
			System.out.println(p+" is true");
			return true;}
	for(Predicate q:partialsolutions)
		if(q.equals(p)){
			System.out.println(p+" is true");
			return true;}
	for(Predicate q:newpredicatelist)
		if(q.equals(p)){
			System.out.println(p+" is true");
			return true;}
	return false;}

public static void addPartial(Predicate p){
	partialsolutions.add(p);}

public static void addImply(Implies i){
	implylist.add(i);}

public static void addPredicate(Predicate p) {
	predicatelist.add(p);}

public static void addnewPredicate(Predicate p) {
	newpredicatelist.add(p);}

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

public static boolean checksol(Predicate p)
{boolean solfound=false;
	for(Implies i:implylist)
{if(i.checkres(p))
	solfound=true;}
	return solfound;}

public static boolean matchsol(Predicate p)
{{boolean solfound=false;
for(Implies i:implylist)
{if(i.matchres(p))
solfound=true;}
return solfound;}}


public static String getString()
{String aux="";
aux+="\nPredicate list\n";
for(Predicate p:predicatelist)
	aux+=p+"\n";
aux+="\nImply list\n";
for(Implies i:implylist)
	aux+=i+"\n";
aux+="\nPartial solutions\n";
for(Predicate p:partialsolutions)
	aux+=p+"\n";
aux+="\nSolutions\n";
for(Predicate p:newpredicatelist)
	aux+=p+"\n";
return aux;}

public static void insertpredicate()
{System.out.println("Insert a predicate: ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try {
	String pred=br.readLine();
	System.out.println("predicate "+pred);
	addPredicate(new Predicate(pred));
} catch (IOException e) {
   System.out.println("predicate not read");}
}

public static void readdata()
{char c;
do {
	System.out.println("Insert a predicate ? y/n ");	
try {
	c=(char) new BufferedReader(new InputStreamReader(System.in)).read();
	if(c=='y')
	insertpredicate();
} catch (IOException e) {
	c='n';
}
}
while(c=='y');
}



}
