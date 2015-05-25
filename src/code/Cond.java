package code;


public class Cond {
	
	
	private String cond;

	

	public Cond() {

	}

	public Cond(String cond, Future f) {
		super();
		this.cond = cond;
		this.f = f;
	}

	public static class Future {
		
		private double sick;
		private double dead;
		
		
		public Future() {

		}
		public Future(double sick, double dead) {
			super();
			this.sick = sick;
			this.dead = dead;
		}
		public double getSick() {
			return sick;
		}
		public void setSick(double sick) {
			this.sick = sick;
		}
		public double getDead() {
			return dead;
		}
		public void setDead(double dead) {
			this.dead = dead;
		}
	}
	
	private Future f;

	public Future getFuture() {
		return f;
	}

	public void setFuture(Future f) {
		this.f = f;
	}
	public String getCond() {
		return cond;
	}

	public void setCond(String cond) {
		this.cond = cond;
	}
	
}
