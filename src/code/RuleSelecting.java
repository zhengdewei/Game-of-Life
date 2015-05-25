package code;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
public class RuleSelecting {
	
	public void ruleSelect(File file) {
		    
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
      //  System.out.println(buffer.toString());
        
        ObjectMapper mapper = new ObjectMapper();
        
        try {
        	
			GameRule resultfile = mapper.readValue(buffer.toString(), GameRule.class);
			LifeGame.rules = resultfile;
			
			
			for(int i = 0; i < 3; i++) {

				if( resultfile.getStatus().get(i).getName().equals("sick")) {
					
					LifeGame.sick = resultfile.getStatus().get(i).getEnabled();

					if(LifeGame.sick == true) {
						
						LifeGame.rule = 3;
					} else {
						LifeGame.rule = 2;
					}
					break;
				}
			}
			
			System.out.println(LifeGame.rule);
			
			if(LifeGame.rule == -1) {
				JOptionPane.showMessageDialog( null, "Rule文件格式错误！", null, JOptionPane.ERROR_MESSAGE);
			} 
			
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( null, "Rule文件格式错误！", null, JOptionPane.ERROR_MESSAGE);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( null, "Rule文件格式错误！", null, JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog( null, "Rule文件格式错误！", null, JOptionPane.ERROR_MESSAGE);
		}
        

	}
}

