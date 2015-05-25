package code;
	
	
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.*;
	 /**
	  * 
	  * 
	  * @author mmagiccer
	  * 
	  *
	  */
	public class LifeGame extends JFrame {
		
		private static final long serialVersionUID = 1L;
	    protected static boolean pause = false;
	    protected static int generation = 1;
	    static int greenNum = 0;
	    static int blueNum = 0;
	    static int whiteNum = 0;
	    public static int rule = -1;
	    protected static boolean sick;
	    protected static GameRule rules;
	    public static int count = 0;
    
	    private FileDialog openDia = new FileDialog(this, "打开", FileDialog.LOAD);
	    
		JLabel label1=new JLabel("Label 1",JLabel.CENTER);                            	       
	    JLabel label2=new JLabel("Label 2",JLabel.CENTER);    
	
		static JButton jbS=new JButton("BEGIN");
		static JButton jbSs=new JButton("STEP");
		static JButton jbF=new JButton("EXIT");
		static JButton jbC=new JButton("CLEAR");
		static JButton jbP=new JButton("PAUSE");
		static JButton jbSt=new JButton("OPEN");
		static JButton jbStt=new JButton("STORE");
		static JLabel JL1, JL2,FileInfo,FilePath,FileInfo1,FileInfo2,FileInfo3,FileInfo4,FilePath1,FilePath2,FilePath3,FilePath4;
		static JTextField JT1;
		static JTextField JT2;
		static JTextField JT3;
		static JTextField JT4;
		static JTextField JT5;
		
		
		static JMenu warning = new JMenu("warning");
	    JMenuItem rule02 = new JMenuItem("rule02");
	    JMenuItem rule03 = new JMenuItem("rule03");
	    JMenuItem rule04 = new JMenuItem("rule04");
	    JMenuItem rule05 = new JMenuItem("rule05");
	    JMenuItem saveTxt = new JMenuItem("saveTxt");
	    JMenuItem saveJson = new JMenuItem("saveJson");
	    JMenuItem openTxt = new JMenuItem("openTxt");
	    JMenuItem openJson = new JMenuItem("openJson");
		
		JMenu mstart=new JMenu("Start");              
        JMenu mpause=new JMenu("Pause");            
        JMenu mopen=new JMenu("Open");          
        JMenu msave=new JMenu("Save");
        JMenu mclose=new JMenu("Exit");
        JMenu mclear=new JMenu("Clear");            
        JMenu mstep=new JMenu("Step");
        JMenu mrule=new JMenu("Rule");

		static MyButton[][] jb = new MyButton[50][50];
		
		JPanel jpl= new JPanel();
		JPanel jpr= new JPanel();
		JMenuBar bar = new JMenuBar();
		
		public  static int map[][];
		public  static int newmap[][];
		
	/**
	 * 构造函数	
	 * @param Row
	 * @param Column
	 */
		
	public LifeGame(int Row,int Column) {
		
			this.setTitle("Game of Life");
			Image gif=this.getToolkit().getImage("a.jpg");
	        this.setIconImage(gif);
	        JT1 = new JTextField(15);
	        JT1.setEditable(false);
	        FileInfo = new JLabel(" FileName: ");
	        FilePath = new JLabel(" ");
	        JT2 = new JTextField(15);
	        JT2.setEditable(false);
	        FileInfo1 = new JLabel(" Status: ");
	        FilePath1 = new JLabel(" ");
	        JT3 = new JTextField(15);
	        JT3.setEditable(false);
	        FileInfo2 = new JLabel(" Generation: ");
	        FilePath2 = new JLabel(" ");
	        JT4 = new JTextField(15);
	        JT4.setEditable(false);
	        FileInfo3 = new JLabel(" Warn: ");
	        FilePath3 = new JLabel(" ");
	        JT5 = new JTextField(15);
	        JT5.setEditable(false);
	        FileInfo4 = new JLabel(" Rule: ");
	        FilePath4 = new JLabel(" ");
			
		    map = new int[Row][Column]; 
		    newmap = new int[Row][Column];
		    
		    this.add(bar,BorderLayout.NORTH);
	        Container contentPane=this.getContentPane();
	        JSplitPane splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,false,jpl,jpr);
	        
	        splitPane1.setDividerLocation(600);
	        splitPane1.setOneTouchExpandable(true);
	        splitPane1.setDividerSize(10);

	        contentPane.add(splitPane1);
	        
	        jpl.setBackground(Color.WHITE);
	        
	        //设置网格布局
	        jpl.setLayout(new GridLayout(50, 50));
	        
	        //设置Button
	        setButton();
	        setMenu();
	        
	        //初始化面板
	        new Update(50,50).resetMap();
	        new Update(50,50).paint();
	        paintLabel();	
	        jpr.add(FileInfo);
	        jpr.add(JT1);
	        jpr.add(FileInfo1);
	        jpr.add(JT2);
	        jpr.add(FileInfo2);
	        jpr.add(JT3);
	        jpr.add(FileInfo4);
	        jpr.add(JT5);
	        jpr.add(FileInfo3);
	        jpr.add(JT4);
	        
	        this.setSize(800, 600);		      
	        this.setVisible(true);
	        }
	public LifeGame() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * 加入按钮
	 * 
	 */
	public void setButton() {
		
		 for (int i = 0; i < 50; i++) {
			 
	         for (int j = 0; j < 50; j++) {
	        	 
	        	 jb[i][j] = new MyButton();
	        	 jb[i][j].setText("");
	        	 jpl.add(jb[i][j]);
	         }
		 }
	}
	/**
	 * 
	 * 监听
	 * 
	 */
	public void ob() {

		mrule.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
					
					pause = true;
					
			        openDia.setVisible(true);
			        String dirPath = openDia.getDirectory();
			        String fileName = openDia.getFile();
			        System.out.println(dirPath + "...." + fileName);
			            
			        if (dirPath == null || fileName == null)
			            return;
			            
			        File file = new File(dirPath, fileName);

		            String Path = dirPath+fileName;
		            FileInfo.setText("FileName：");

		            JT5.setText(fileName);

			        	try {
							new RuleSelecting().ruleSelect(file);
			        		//new StatusDataOpen().openmemory(file);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

				}
        });
		mclose.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		mpause.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				pause = true;
			}
		});
		mclear.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				new Update(50,50).Clear();
			}
		});
		mstart.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				
				if(rule != -1) {
					pause = false;
					Runnable runnable = new BeginRunning(); 
					Thread s = new Thread(runnable);
					s.start();	
				} else {
					JOptionPane.showMessageDialog( null, "No Rule ! ! !", getWarningString(), JOptionPane.ERROR_MESSAGE);
				}
			}	
		});
		saveTxt.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
				
					try {
						new Memory().memory();
						//new StatusDataMemory().memory();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}	
		});
		saveJson.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
				
					try {
						new StatusDataMemory().memory();;
						//new StatusDataMemory().memory();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
			}	
		});
		mstep.addMouseListener(new MouseAdapter() {
			
				public void mouseClicked(MouseEvent e) {
				
					if(rule != -1) {
						pause = false;
						new Update(50,50).BeginGame();
						jbSs.setText("GENERATION "+generation);	
					} else {
						JOptionPane.showMessageDialog( null, "No Rule ! ! !", getWarningString(), JOptionPane.ERROR_MESSAGE);
					}
				}
		});

		openTxt.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
				
				pause = true;
				
		        openDia.setVisible(true);
		        String dirPath = openDia.getDirectory();
		        String fileName = openDia.getFile();
		        System.out.println(dirPath + "...." + fileName);
		            
		        if (dirPath == null || fileName == null)
		            return;
		            
		        File file = new File(dirPath, fileName);
//		        Txt.setText("");
	            String Path = dirPath+fileName;
	            FileInfo.setText("FileName：");
	            //FilePath.setText(Path);
	            JT1.setText(fileName);

		        	try {
						new OpenMemory().openmemory(file);
		        		//new StatusDataOpen().openmemory(file);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		openJson.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e) {
				
				pause = true;
				
		        openDia.setVisible(true);
		        String dirPath = openDia.getDirectory();
		        String fileName = openDia.getFile();
		        System.out.println(dirPath + "...." + fileName);
		            
		        if (dirPath == null || fileName == null)
		            return;
		            
		        File file = new File(dirPath, fileName);
//		        Txt.setText("");
	            String Path = dirPath+fileName;
	            FileInfo.setText("FileName：");
	            //FilePath.setText(Path);
	            JT1.setText(fileName);

		        	try {
						new StatusDataOpen().openmemory(file);
		        		//new StatusDataOpen().openmemory(file);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

			}
		});
		try{
			for (int a = 0; a < 50; a++) {
				
				for (int b = 0; b < 50; b++) {
	        	 
					int c = a;int d = b;
					
					jb[a][b].addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
		        					
		        					if(e.getButton() == MouseEvent.BUTTON1) {
		        			            // 左键点击
		        						setHealthyCell(c,d);
		        			        } else if(e.getButton() == MouseEvent.BUTTON3) {
		        			            // 右键点击
		        			        	setSubhealthyCell(c,d);
		        			        }
							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub
								
							}

							
					});
	        	 	}
	         	}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
//

	}
	/**
	 * 
	 * 设置面板细胞状态
	 * @param i
	 * @param j
	 * 
	 */
	public void setHealthyCell(int i,int j) {
		
		map[i][j] = 1;
		jb[i][j].setBackground(Color.blue);
	}
	public void setSubhealthyCell(int i,int j) {
		
		map[i][j] = 3;
		jb[i][j].setBackground(Color.green);
	}

	/**
	 * 
	 * 初始化细胞面板
	 * 
	 */
	public void paintLabel() {
		
		for (int i = 0; i < 50; i++) {
			
	         for (int j = 0; j < 50; j++) {
	        	 
	        	 double random = Math.random();
	        	 
	        	 if(random < 0.8) {
	        		 
	        		 jb[i][j].setBackground(Color.WHITE);
	        		 map[i][j] = 2;
	        	 }
	        	 else {
	        		 
	        		 jb[i][j].setBackground(Color.blue);
	        		 map[i][j] = 1;
	        	 }
	         }
		}
	}
	/**
	 * setMenu
	 */
	public void setMenu() {	
		  
		bar.add(mrule);
		bar.add(mstart);                             
        bar.add(mstep);
        bar.add(mclear);
        bar.add(mpause);
        bar.add(msave);
        msave.add(saveTxt);
        msave.add(saveJson);
        bar.add(mopen); 
        mopen.add(openTxt);
        mopen.add(openJson);
        bar.add(mclose);
      
	}

	/**
	 * main 函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
	    LifeGame game = new LifeGame(50,50);

	    //监听
	    game.ob();
	}
}
   
