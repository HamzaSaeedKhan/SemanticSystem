package com.cricmantic.parsing;
import java.awt.AWTException;
import java.io.IOException;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.riot.thrift.wire.RDF_Literal;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.XSD;
import org.mindswap.pellet.jena.vocabulary.OWL_1_1;
import org.openrdf.model.vocabulary.RDF;
import org.openrdf.model.vocabulary.RDFS;

public class Cricmantic {
	//URI of ontology to select individuals
	//private static String newuri="http://www.semanticweb.org/tayyab/ontologies/2016/7/untitled-ontology-2#";
	//static String defaultNameSpace = "http://semwebprogramming.org/2009/ont/chp2:#";
	
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		String sumdata=null;
		String in1data=null;
		String in2data=null;
//http://www.cricbuzz.com/cricket-full-commentary/16344/pak-vs-sl-10th-match-asia-cup-2016
		String url=null;
		//"http://www.cricbuzz.com/live-cricket-full-commentary/16488/aus-vs-pak-5th-odi-pakistan-tour-of-australia-2016-17";
	//	in1data="12.5 Irfan to Kohli,  1 run, it's another, this time Irfan oversteps, Kohli guides it to thi";
		//http://www.cricbuzz.com/cricket-full-commentary/16338/ind-vs-pak-4th-match-asia-cup-2016
		url="http://www.cricbuzz.com/live-cricket-full-commentary/16877/ind-vs-eng-2nd-t20i-england-tour-of-india-2016-17";
		parse par=new parse();
		
	//	par.parseCommentary(in1data,2);
		scrap s=new scrap();
		
	try {
			
			sumdata=s.facts(url);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		par.parseFact(sumdata);
		
		try {
			in2data=s.second(url);
			sumdata=s.summary(url);
			in1data=s.first(url);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		par.parseSum(sumdata);
		par.parseCommentary(in1data,1);
		par.parseCommentary(in2data,2);
	
	}
	
}
