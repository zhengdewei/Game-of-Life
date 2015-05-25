package code;

import java.awt.Color;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Update implements Runnable {
	
    private int i,j;
    
    public Update(int i,int j) {
    	
        this.i = i;
        this.j = j;    
    }
	/**
	 * 
	 * 绘制面板
	 * 
	 */
	public void paint() {
		
		for(int i = 0; i < 50;i++ ) {
			
			for(int j = 0; j < 50;j++ ) {
				
				if(LifeGame.map[i][j] == 1) {
					
					LifeGame.jb[i][j].setBackground(Color.blue);
				}
				else if (LifeGame.map[i][j] == 2){
					
					LifeGame.jb[i][j].setBackground(Color.WHITE);
				}
				else {
					LifeGame.jb[i][j].setBackground(Color.green);
				}
			}
		}
	}

	/**
	 * 
	 * 清屏
	 * 
	 */
	public void Clear() {
		
		for(int i = 0; i < 50; i++) {
			
			for(int j = 0; j < 50; j++) {
				
					LifeGame.map[i][j] = 2; 
					LifeGame.jb[i][j].setBackground(Color.WHITE);
			}
		}
	}
		
	/**
	 * 
	 * 复制地图
	 * 
	 */
	public void copyMap() {
		
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					LifeGame.map[i][j] = LifeGame.newmap[i][j]; 
				}
			}
	}
	/**
	 * 
	 * 清空活细胞
	 * 
	 */
	public void resetMap() {
		
		for(int i = 0; i < 50; i++) {
			
			for(int j = 0; j < 50; j++) {
				LifeGame.newmap[i][j]=2; 
			}
		}
	}
	
	/**
	 * 
	 * 开始单步执行游戏
	 * 
	 */
	public void BeginGame() {
		
		LifeGame.generation++;

		resetMap();
		
	    ExecutorService executor = Executors.newFixedThreadPool(3);
	    
	    //每个细胞作为一个线程        
        for (int i = 0; i < 50; i++) {
        	
       		for (int j = 0; j < 50; j++) {
       			
	       			Runnable worker = new Update(i,j);
//	       			count1++;
	       			executor.execute(worker);
	       	}
        }
       
       //如果任务没有执行完毕，不再接收新任务，如果里面有任务，就执行完，直到所有任务执行完毕。
       while(!executor.isTerminated()) {  	   
    	   executor.shutdown();  
	    }     	
	    copyMap();
	    new Number().numCount();
	    paint();
	}
 
    @Override
    public void run() {
    	
    	nextCellStatus(i,j);
    	//new StatusChanging(int num_sum,int num_alive,int num_sick,int i, int j).statusChanging();

    }
    
    private void nextCellStatus(int i,int j) {
    
    		int num_sick = 0;
    		int num_alive = 0;
    		int num_sum = 0;
    		
    		if (i == 0 && j == 0) {
    			//
    			if (LifeGame.map[49][49] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[49][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[49][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][49] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][49] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i+1][j+1] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if (i == 0 && j == 49) {
    			if (LifeGame.map[49][0] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[49][48] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[49][49] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][0] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j-1] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][0] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if (i == 49 && j == 0) {
    			if (LifeGame.map[i-1][49] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][49] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][49] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][j+1] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if (i == 49 && j ==49) {
    			if (LifeGame.map[48][48] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[48][49] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[48][0] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[49][48] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[49][0] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][48] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][49] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][0] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
    		}
    		else if ( i == 0 && j != 49 && j != 0) {
    			if (LifeGame.map[49][j-1] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[49][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[49][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i+1][j-1] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j+1] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if ( i == 49 && j != 49 && j != 0) {
    			if (LifeGame.map[i-1][j-1] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][j-1] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[0][j+1]!= 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if ( j == 0 && i != 49 && i != 0) {
    			if (LifeGame.map[i-1][49] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i-1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i][49] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][49] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j]!= 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j+1] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
    		}
    		else if ( j == 49 && i != 49 && i != 0) {
    			if (LifeGame.map[i-1][j-1] != 2) {
	       			
    				if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i-1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][0] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][0] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j-1] != 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i+1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][0] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		else if(i < 50 && j < 50 && i > 0 && j > 0) {
       	
	       		if (LifeGame.map[i-1][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i-1][j+1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			} 
	       		}
	       		if (LifeGame.map[i][j-1] != 2) {
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i][j+1] != 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j-1]!= 2) { 	
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j]!= 2) { 
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
	       		if (LifeGame.map[i+1][j+1] != 2) {  
	       			
	       			if(LifeGame.map[49][49] == 1) {
	       				num_alive++;
	       			}else {
	       				num_sick++;
	       			}
	       		}
    		}
    		
    		//newMap(num_sum,num_alive,num_sick,i,j);
    		if(LifeGame.rule == 2) {
    			num_sum = num_alive + num_sick;
    			newMap02(num_sum,num_alive,num_sick,i,j);
    			
    		} else if(LifeGame.rule == 3) {
    			num_sum = num_alive + num_sick;
    			new StatusChanging(num_sum,num_alive,num_sick,i,j).statusChanging01();
    		}
    		
    }
    		public void newMap01(int num_sum,int num_alive,int num_sick,int i,int j) {
    
	    		num_sum = num_alive + num_sick;
	       		if (LifeGame.map[i][j] == 1) {
	   			
	       			// Cell is alive
	       			if (num_sum == 2) {
	       				LifeGame.newmap[i][j] = 1;               
	       			} else if (num_sum == 3) {
	   				
	       				LifeGame.newmap[i][j] = 3;
	       			} else {
	       				LifeGame.newmap[i][j] = 2;
	       			}
	       		} else if (LifeGame.map[i][j] == 2){
	   			
	           			// Cell is dead
	       			if (num_sum == 3) {
	       				LifeGame.newmap[i][j] = 3;
	       			}
	       		}
	       		else {
	       			if (num_sum == 3) {
	       				LifeGame.newmap[i][j] = 3;
	       			}
	       			else if (num_sum == 2) {
	       				LifeGame.newmap[i][j] = 1;
	       			}
	       			else {
	       				LifeGame.newmap[i][j] = 2;
	       			}
	       		}
	//       		new StatusChanging(num_sum,num_alive,num_sick,i,j).statusChanging();
    		}
    		public void newMap02(int num_sum,int num_alive,int num_sick,int i,int j) {
    		    
	    		num_sum = num_alive + num_sick;
	    		
	       		if (LifeGame.map[i][j] == 1) {	   			
	       			// Cell is alive
	       			if (num_sum == 2 || num_sum == 3) {
	       				LifeGame.newmap[i][j] = 1;               
	       			} else {
	       				LifeGame.newmap[i][j] = 2;
	       			}
	       		} else if (LifeGame.map[i][j] == 2) {
	   			
	           			// Cell is dead
	       			if (num_sum == 3) {
	       				LifeGame.newmap[i][j] = 1;
	       			}
	       		}
    		}
}
