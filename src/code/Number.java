package code;

public class Number {
	public void numPrint() {
		
		LifeGame.JT2.setText("green:"+LifeGame.greenNum+"        blue:"+LifeGame.blueNum);
		LifeGame.JT3.setText("Generation:"+LifeGame.generation);
}
	
	public void numCount() {
	  for (int i = 0; i < 50; i++) {
      	
     		for (int j = 0; j < 50; j++) {
     			
     			if(LifeGame.map[i][j] == 1) {
     				
     				LifeGame.blueNum++;
     			}
     			else if(LifeGame.map[i][j] == 3) {
     				
     				LifeGame.greenNum++;
     			}
     			else {
     				LifeGame.whiteNum++;
     			}
	       	}
      }

	  numPrint();
	  LifeGame.blueNum = 0;
	  LifeGame.greenNum = 0;
	  LifeGame.whiteNum = 0;
	}

}
