package code;

import java.io.BufferedWriter;
import java.io.FileWriter;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

	public class Memory {
		
		private int map[][] = LifeGame.map;
		String timer = new Timing().time();
	
		//Map<Object, Integer> mmap = new HashMap<Object, Integer>();
		
		public void memory() throws Exception {
			
			 	JSONArray array = new JSONArray();
		        JSONObject sto = new JSONObject();
		        
		        for(int i = 0; i < 50; i++) {
					for(int j = 0; j < 50; j++) {
						
						if(map[i][j] != 2) {
							
							sto.put("status", map[i][j]);
							sto.put("x", i);
							sto.put("y", j);
							
							array.add(sto);
						}
					}
		        }
	
			printmemory(array);
	
		}
		public void printmemory(JSONArray array) throws Exception {
			
			JSONArray json = JSONArray.fromObject(array);
			BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\JAVAA\\Copy (2) of Game of Life\\save\\"+timer+".txt"));
	
			bw.write(json.toString());
			warn();
			bw.close();
		}
		public void warn() {
			LifeGame.JT4.setText(timer+".txt");
		}
	}
