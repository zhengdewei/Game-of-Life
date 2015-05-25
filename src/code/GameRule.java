package code;

import java.util.ArrayList;

public class GameRule {
	ArrayList<Status>  status = new ArrayList<Status>();
	ArrayList<Rules>  rules = new ArrayList<Rules>();
	public ArrayList<Status> getStatus() {
		return status;
	}
	public void setStatus(ArrayList<Status> status) {
		this.status = status;
	}
	public ArrayList<Rules> getRules() {
		return rules;
	}
	public void setRules(ArrayList<Rules> rules) {
		this.rules = rules;
	}
}