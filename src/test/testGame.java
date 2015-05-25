package test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import junit.framework.TestCase;
import net.sf.json.JSONArray;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import code.LifeGame;
import code.StatusData;
import code.Update;

public class testGame {
	
	@BeforeClass
	public static void open() throws JsonParseException, JsonMappingException, IOException {
		int x;
		int y;
		StatusData data;
		LifeGame game = new LifeGame(50,50);
		LifeGame.rule = 1;
		new Update(50,50).resetMap();
		File file = new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-02.json");
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
		ObjectMapper mapper = new ObjectMapper();
		
		
		for(int s = 0; s < jo.size(); s++) {
			
			data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
			
			x = data.getPixel().getX();
			y = data.getPixel().getY();
			
			LifeGame.map[x][y] = data.getStatus();
			// LifeGame.newmap[x][y] = LifeGame.map[x][y];
		}
	}
	public JSONArray load(File file) throws JsonParseException, JsonMappingException, IOException {
		
		int x;
		int y;

		StatusData data;
		
		//File file = new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-15-50-18.json");
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
		// LifeGame.map = LifeGame.newmap;
		return jo;
			// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			
		}
		@Before
		public void begin() {
			new Update(50,50).BeginGame();
		}
		@Test
		public void test1() throws JsonParseException, JsonMappingException, IOException {
			
			JSONArray jo = load(new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-05.json"));
			int count = 0;
			int x = 0;
			int y = 0;
			StatusData data = new StatusData();
			int [][] testmap = new int[50][50];
			ObjectMapper mapper = new ObjectMapper();
						
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					testmap[i][j] = 2; 
				}
			}
			for(int s = 0; s < jo.size(); s++) {
				
				data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
				
				x = data.getPixel().getX();
				y = data.getPixel().getY();
				
				testmap[x][y] = data.getStatus();
				// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			}

			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 50; j++) {
					if(testmap[i][j] == LifeGame.map[i][j]) {
						count++;
				}
			}
		}
		TestCase.assertEquals(2500, count);
	}
		@Test
		public void test2() throws JsonParseException, JsonMappingException, IOException {
			
			JSONArray jo = load(new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-07.json"));
			int count = 0;
			int x = 0;
			int y = 0;
			StatusData data = new StatusData();
			int [][] testmap = new int[50][50];
			ObjectMapper mapper = new ObjectMapper();
						
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					testmap[i][j] = 2; 
				}
			}
			for(int s = 0; s < jo.size(); s++) {
				
				data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
				
				x = data.getPixel().getX();
				y = data.getPixel().getY();
				
				testmap[x][y] = data.getStatus();
				// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			}

			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 50; j++) {
					if(testmap[i][j] == LifeGame.map[i][j]) {
						count++;
				}
			}
		}
		TestCase.assertEquals(2500, count);
	}
		@Test
		public void test3() throws JsonParseException, JsonMappingException, IOException {
			
			JSONArray jo = load(new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-09.json"));
			int count = 0;
			int x = 0;
			int y = 0;
			StatusData data = new StatusData();
			int [][] testmap = new int[50][50];
			ObjectMapper mapper = new ObjectMapper();
						
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					testmap[i][j] = 2; 
				}
			}
			for(int s = 0; s < jo.size(); s++) {
				
				data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
				
				x = data.getPixel().getX();
				y = data.getPixel().getY();
				
				testmap[x][y] = data.getStatus();
				// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			}

			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 50; j++) {
					if(testmap[i][j] == LifeGame.map[i][j]) {
						count++;
				}
			}
		}
		TestCase.assertEquals(2500, count);
	}
		@Test
		public void test4() throws JsonParseException, JsonMappingException, IOException {
			
			JSONArray jo = load(new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-11.json"));
			int count = 0;
			int x = 0;
			int y = 0;
			StatusData data = new StatusData();
			int [][] testmap = new int[50][50];
			ObjectMapper mapper = new ObjectMapper();
						
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					testmap[i][j] = 2; 
				}
			}
			for(int s = 0; s < jo.size(); s++) {
				
				data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
				
				x = data.getPixel().getX();
				y = data.getPixel().getY();
				
				testmap[x][y] = data.getStatus();
				// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			}

			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 50; j++) {
					if(testmap[i][j] == LifeGame.map[i][j]) {
						count++;
				}
			}
		}
		TestCase.assertEquals(2500, count);
	}
		@Test
		public void test5() throws JsonParseException, JsonMappingException, IOException {
			
			JSONArray jo = load(new File("E:\\JAVAA\\Copy (2) of Game of Life\\test\\test (1)\\2015-05-15-16-40-13.json"));
			int count = 0;
			int x = 0;
			int y = 0;
			StatusData data = new StatusData();
			int [][] testmap = new int[50][50];
			ObjectMapper mapper = new ObjectMapper();
						
			for(int i = 0; i < 50; i++) {
				
				for(int j = 0; j < 50; j++) {
					
					testmap[i][j] = 2; 
				}
			}
			for(int s = 0; s < jo.size(); s++) {
				
				data = mapper.readValue(jo.getJSONObject(s).toString(), StatusData.class);
				
				x = data.getPixel().getX();
				y = data.getPixel().getY();
				
				testmap[x][y] = data.getStatus();
				// LifeGame.newmap[x][y] = LifeGame.map[x][y];
			}

			for(int i = 0; i < 50; i++) {
				for(int j = 0; j < 50; j++) {
					if(testmap[i][j] == LifeGame.map[i][j]) {
						count++;
				}
			}
		}
		TestCase.assertEquals(2500, count);
	}
}

