package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import net.sf.json.JSONArray;

	public class OpenMemory {
		
		private int x;
		private int y;
		
		public void openmemory(File file) throws Exception {
			
			Scanner scanner = null;
	        StringBuilder buffer = new StringBuilder();
	        try {
	            scanner = new Scanner(file, "utf-8");
	            
	            while (scanner.hasNextLine()) {
	            	
	                buffer.append(scanner.nextLine());
	            }
	
	        } catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block  
	
	        } finally {
	            if (scanner != null) {
	                scanner.close();
	            }
	        }
	
	        JSONArray jo = JSONArray.fromObject(buffer.toString());
	        
	        new Update(50,50).resetMap();
	        for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					LifeGame.map[i][j] = LifeGame.newmap[i][j]; 
				}
			}
	        
	        for(int s = 0; s < jo.size(); s++) {
	        	
	          x = jo.getJSONObject(s).getInt("x");
	          y = jo.getJSONObject(s).getInt("y");
	
	          LifeGame.map[x][y] = jo.getJSONObject(s).getInt("status");
	        }
	     
	        new Update(50,50).paint();
		}
	}
