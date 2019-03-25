import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RuleParser {

public RuleParser() {
	super();
	
}

public static void parse(String filename)
{BufferedReader jsonfile;
	try {
	jsonfile=new BufferedReader(new FileReader(filename));
} catch (FileNotFoundException e) {
	e.printStackTrace();
	System.out.println("File "+filename+" can't be opened");
	return;}
	String line="";
	try {
		while((line=jsonfile.readLine())!=null)
		{
			readline(line);
		}
	} catch (IOException e) {
		System.out.println("Syntax Error : "+line);
	}
}

public static void readline(String jsonline)
{try {
	JSONObject obj = new JSONObject(jsonline);
	String expr=obj.getString("expr");
	String val="";
	JSONObject val1=null,conc=null;
	if(expr.equals("predicate"))
		try {val=obj.getString("val");
				InferenceEngine.addPredicate(new Predicate(val));
		}catch(JSONException e)	{
				System.out.println("Error predicate:"+val+" in "+jsonline);}
	else 
		if(expr.equals("implies")){
			LogicalRule lr=null;
			
			try {
				val1=obj.getJSONObject("val");
				lr=parserule(obj.getJSONObject("val").toString());
			}catch(JSONException e) {
				System.out.println("Error implies:"+(val1==null?"":val1)+" in "+jsonline);
				/*return;*/}
			
			try {
				conc=obj.getJSONObject("conc");
				val=conc.getString("val");
				Predicate p=new Predicate(val.toString());
				if(lr!=null)
					InferenceEngine.addImply(new Implies(lr,p));
			}catch(JSONException e) {
				System.out.println("Error conclusion:"+(conc==null?"":conc)+"|"+(val1==null?"":val1)+" in "+jsonline);
				e.printStackTrace();}
		}
} catch (JSONException e) {
	System.out.println("JSON syntax error: "+jsonline);
}
}
public static LogicalRule parserule(String rule)
{try {
	JSONObject obj = new JSONObject(rule);
	String expr=obj.getString("expr");
	if(expr.equals("not")){
		LogicalRule e=parserule(obj.getJSONObject("val").toString());
		return e==null?null:new Not(e);}
	else 
		if(expr.equals("and")){
			LogicalRule l=parserule(obj.getJSONObject("l").toString());
			LogicalRule r=parserule(obj.getJSONObject("r").toString());
			return l==null||r==null?null:new And(l,r);}
		else 
			if(expr.equals("or")){
				LogicalRule l=parserule(obj.getJSONObject("l").toString());
				LogicalRule r=parserule(obj.getJSONObject("r").toString());
				return l==null||r==null?null:new Or(l,r);}
			else
				if(expr.equals("xor")){
					LogicalRule l=parserule(obj.getJSONObject("l").toString());
					LogicalRule r=parserule(obj.getJSONObject("r").toString());
					return l==null||r==null?null:new Xor(l,r);}
				else 
					if(expr.equals("predicate")) {
						String val=obj.getString("val");
						return new Predicate(val);}
					else {
						return null;}
} catch (JSONException e) {
	System.out.println("Rule syntax error: "+rule);
	return null;
}
}
}
