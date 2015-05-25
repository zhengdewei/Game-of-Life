package code;

import java.io.File;

import org.codehaus.jackson.map.ObjectMapper;

import net.sf.json.JSONArray;



public class StatusDataMemory {

	private int map[][] = LifeGame.map;	
	JSONArray array = new JSONArray();
	//Map<Object, Integer> mmap = new HashMap<Object, Integer>();
	String timer = new Timing().time();
	
	public void memory() throws Exception {
		
		StatusData status = new StatusData(); 
	    ObjectMapper mapper = new ObjectMapper();

	    for(int i = 0; i < 50; i++) {
			for(int j = 0; j < 50; j++) {
				if(map[i][j] != 2) {
					StatusData.Pixel n =new StatusData.Pixel();
					n.setX(i);
					n.setY(j);
					status.setPixel(n);
					status.setStatus(map[i][j]);
					array.add(status);
				}
				else {
					continue;
				}
			}
	    }
	    System.out.println(array);
	    mapper.writeValue(new File("E:\\JAVAA\\Copy (2) of Game of Life\\save\\"+timer+".json"), array);
	    warn();
	}
	public void warn() {
		LifeGame.JT4.setText(timer+".json");
	}
}

