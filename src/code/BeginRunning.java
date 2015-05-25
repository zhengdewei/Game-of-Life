package code;


public class BeginRunning implements Runnable {
		
	public void run() {
    		
    		while(LifeGame.pause == false) {
    			
    			LifeGame.jbS.setText("GENERATION "+LifeGame.generation);
    			
    			new Update(50,50).BeginGame();
    			try {
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	}
    }