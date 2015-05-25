package code;

import java.util.ArrayList;

public class Rules {
	
	private ArrayList<Cond> alive= new ArrayList<Cond>();
	private ArrayList<Cond> sick= new ArrayList<Cond>();
	private ArrayList<Cond> dead= new ArrayList<Cond>();
	
	public Rules() {

	}
	public Rules(ArrayList<Cond> alive, ArrayList<Cond> sick,
			ArrayList<Cond> dead) {
		super();
		this.alive = alive;
		this.sick = sick;
		this.dead = dead;
	}
	
	public ArrayList<Cond> getAlive() {
		return alive;
	}
	public void setAlive(ArrayList<Cond> alive) {
		this.alive = alive;
	}
	public ArrayList<Cond> getSick() {
		return sick;
	}
	public void setSick(ArrayList<Cond> sick) {
		this.sick = sick;
	}
	public ArrayList<Cond> getDead() {
		return dead;
	}
	public void setDead(ArrayList<Cond> dead) {
		this.dead = dead;
	}
}
	
