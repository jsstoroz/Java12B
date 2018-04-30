/**
 * @author Jennifer Storozum
 * COSI 12b PA5
 * 8/10/2017
 * This program randomly generates phrases from a text file that contains a BNF grammar.
 */
import java.util.*;

public class GrammarSolver {
	Map<String, ArrayList<String[]>> ruleMap = new TreeMap<String, ArrayList<String[]>>();

	/**
	 * Constructor takes a lists of rules read from a file in main(String[] args) and
	 * creates a new grammar solver object that maps keys to values in ruleMap
	 * @param rules
	 * @throws IllegalArgumentException if rules empty
	 */
	public GrammarSolver(List<String> rules) throws IllegalArgumentException{
		//throw exception if there are no rules in the file
		if(rules.size()==0||rules.equals(null)){
			throw new IllegalArgumentException("List empty.");
		}
		//find the nonterminals first
		for(String rule : rules){
			String[] parts = rule.split("::=");
			String nonTerminal = parts[0];
			String[] termList = parts[1].split("[|]");

			//now add each rule set as a list inside a list
			ArrayList<String> terminalRules = new ArrayList<String>();
			for(String term: termList){
				terminalRules.add(term);
			}		
			
			//now break up each rule set into its component parts
			ArrayList<String[]> terminalRulesList = new ArrayList<String[]>();
			for(String r : terminalRules){
				terminalRulesList.add(r.split("\\s+"));
			}
			
			//throw an exception if there are duplicate keys
			if(ruleMap.containsKey(nonTerminal)){ throw new IllegalArgumentException();}
			//map the nonterminals to the list of list of terminals
			ruleMap.put(nonTerminal, terminalRulesList);
		}	
	}
	
	/**
	 * //contains returns true if the given symbol is a non-terminal in the grammar and false otherwise
	 * @param symbol
	 * @return boolean
	 * @throws IllegalArgumentException if input invalid
	 */
	public boolean contains(String symbol) throws IllegalArgumentException{
		if(symbol.equals(null)||symbol.length()==0){
			throw new IllegalArgumentException("No input");
		}
		return ruleMap.containsKey(symbol);
	}
	
	/**
	 * //getSymbols returns the keyset of nonterminals in the map
	 * @return set of keys of ruleMap
	 */
	public Set<String> getSymbols(){
		return ruleMap.keySet();
	}
	
	/**
	 * generate a string recursively from a non-terminal input
	 * @param symbol
	 * @return phrase generated
	 */
	public String generate(String symbol){
		//throw exception if input invalid
		if(symbol.equals(null)||symbol.length()==0){
			throw new IllegalArgumentException("No input"); 
			}
		
		//base case: symbol is not in the keyset
		if(!(this.contains(symbol))){
			return symbol;
		} else {
			//choose a rule at random using random number generator
			Random rand = new Random();
			int nonTerminalRulesListLen = ruleMap.get(symbol).size();
			int randRuleNumber = rand.nextInt(nonTerminalRulesListLen);
			String[] randRule = ruleMap.get(symbol).get(randRuleNumber);
			
			//recursively build the string 
			StringBuilder phrase = new StringBuilder();
			for(String rule : randRule){
				phrase.append(" " + generate(rule));
			}
			return phrase.toString().trim();			
		}
	}
}
