package code;

import java.util.Date;
import java.text.SimpleDateFormat;

	public class Timing {
		public String time() {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");//�������ڸ�ʽ
		//	System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
			return df.format(new Date());
		}
	}
