package code;

import java.util.Date;
import java.text.SimpleDateFormat;

	public class Timing {
		public String time() {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//设置日期格式
		//	System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
			return df.format(new Date());
		}
	}
