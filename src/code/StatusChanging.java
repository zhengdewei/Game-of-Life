package code;

public class StatusChanging {
	
	private int num_sum;
	private int num_sick;
	private int i;
	private int j;
	private double sick = 0;
	private double dead = 0;
	private double chance = 0;
	private GameRule rul = LifeGame.rules;
	
	public StatusChanging(int num_sum,int num_alive,int num_sick,int i, int j) {
		
		this.num_sick = num_sick;
		this.num_sum = num_sum;
		this.i = i;
		this.j = j;
	}


	public void statusChanging01() {
		
		//System.out.println(num_sum);
	//	System.out.println("执行了");
		
		if(LifeGame.map[i][j] == 1) {
			//alives

			if((num_sum > 3) || (num_sum <= 1)) {

				sick = rul.getRules().get(0).getAlive().get(0).getFuture().getSick();
				dead = rul.getRules().get(0).getAlive().get(0).getFuture().getDead();
				System.out.println((sick+dead));
				chance = Math.random();
				System.out.println(chance);
				if(chance > sick) {
					LifeGame.newmap[i][j] = 2;

				} else {
					LifeGame.newmap[i][j] = 3;
				}
			} else {

				if(num_sick == 3) {
					sick = rul.getRules().get(0).getAlive().get(1).getFuture().getSick();
					dead = rul.getRules().get(0).getAlive().get(1).getFuture().getDead();
					chance = Math.random();
					System.out.println((sick+dead));
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 2) {
					sick = rul.getRules().get(0).getAlive().get(2).getFuture().getSick();
					dead = rul.getRules().get(0).getAlive().get(2).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 1) {
					sick = rul.getRules().get(0).getAlive().get(3).getFuture().getSick();
					dead = rul.getRules().get(0).getAlive().get(3).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 0) {
					sick = rul.getRules().get(0).getAlive().get(4).getFuture().getSick();
					dead = rul.getRules().get(0).getAlive().get(4).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				}
				
			}
		} else if(LifeGame.map[i][j] == 3) {
			//sick
			if(num_sum > 3 ||  num_sum <= 1) {
				
				sick = rul.getRules().get(0).getSick().get(0).getFuture().getSick();
				dead = rul.getRules().get(0).getSick().get(0).getFuture().getDead();

				chance = Math.random();
				if(chance > sick) {
					LifeGame.newmap[i][j] = 2;
				} else {
					LifeGame.newmap[i][j] = 3;
				}
			} else {
				if(num_sick == 3) {
					sick = rul.getRules().get(0).getSick().get(1).getFuture().getSick();
					dead = rul.getRules().get(0).getSick().get(1).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 2) {
					sick = rul.getRules().get(0).getSick().get(2).getFuture().getSick();
					dead = rul.getRules().get(0).getSick().get(2).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 1) {
					sick = rul.getRules().get(0).getSick().get(3).getFuture().getSick();
					dead = rul.getRules().get(0).getSick().get(3).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				} else if(num_sick == 0) {
					sick = rul.getRules().get(0).getSick().get(4).getFuture().getSick();
					dead = rul.getRules().get(0).getSick().get(4).getFuture().getDead();
					chance = Math.random();
					if(chance < (sick+dead)) {
						if(chance < dead) {
							LifeGame.newmap[i][j] = 2;
						} else {
							LifeGame.newmap[i][j] = 3;
						}
					} else {
						LifeGame.newmap[i][j] = 1;
					}
				}
				
			}
		} else {
			
			//dead
			if(LifeGame.map[i][j] == 2) {
				
				if(num_sum == 3) {
					LifeGame.newmap[i][j] = 1;
				}
			}
		}

	}
}
//	public void statusChanging() {
//	
//	num_sum = num_sick + num_alive;
//	//System.out.println(num_sum);
//	if(LifeGame.map[i][j] == 1) {
//		//cell is alive
//		double p = poisson(3,num_sum);
//	//	System.out.println(p);
//		double rand1 = Math.random();
//		if(rand1 < p) {
//			double p_unsick = poisson(1,num_sick);
//			double rand2 = Math.random();
//			if(rand2 < p_unsick) {
//				
//				LifeGame.newmap[i][j] = 1;
//			} else {
//				LifeGame.newmap[i][j] = 3;
//			}
//		} else {
//			LifeGame.newmap[i][j] = 2;
//		}
//	}
//		
////		if((num_sum != 2) && (num_sum != 3)) {
////			
////			LifeGame.newmap[i][j] = 2;
////		} else {
////			
////			double rand = Math.random(); 
////			chance = Math.pow(0.25,num_sick);//alive概率
////			
////			if(rand < chance) {
////				LifeGame.newmap[i][j] = 1;
////			} else {
////				LifeGame.newmap[i][j] = 3;
////			}
////		}
////	}
//	else if(LifeGame.map[i][j] == 3) {
//		//cell is sick
////		if((num_sum != 2) && (num_sum != 3)) {
////			
////			LifeGame.newmap[i][j] = 2;
////		} else {
////			
////			double rand1= Math.random(); 
////			double rand2 = Math.random(); 
////			chance = Math.pow(0.25,num_sick);//alive概率
////			
////			if(rand1 < 0.55) {
////				LifeGame.newmap[i][j] = 2;
////			} else {
////				if(rand2 < chance) {
////				LifeGame.newmap[i][j] = 3;
////				} else {
////					LifeGame.newmap[i][j] = 1;
////				}
////			}
////		}
//		
//		double p = poisson(3,num_sum);
//		double rand1 = Math.random();
//		if(rand1 < p) {
//			double p_sick = poisson(1,num_alive);
//			double rand2 = Math.random();
//			if(rand2 < p_sick) {
//				
//				LifeGame.newmap[i][j] = 3;
//			} else {
//				LifeGame.newmap[i][j] = 1;
//			}
//		} else {
//			LifeGame.newmap[i][j] = 2;
//		}
//	} else {
//		//cell is dead
////		if(num_sum == 3) {
////			LifeGame.newmap[i][j] = 1;
////		} else {
////			LifeGame.newmap[i][j] = 2;
////		}
//		double p = poisson(3,num_sum);
//		double rand1 = Math.random();
//		if(rand1 < p) {
//			
//			LifeGame.newmap[i][j] = 1;
//		} else {
//			
//			LifeGame.newmap[i][j] = 2;
//		}
//	}
//}
//
//public int jiecheng(int k) {
//	
//	int kj = 1;
//	for(int i = 1; i <= k; i++) {
//		kj = kj*i;
//	}
//	System.out.println(kj);
//	return kj;
//}
//public double poisson(int n,int k) {
//	
//	double p;
//	double e = Math.E;
//	double x = Math.pow(e, n);
//	double y = Math.pow(n, k);
//	int kj = jiecheng(k);
//	p = (y)/(kj*x);
//	return p;
//}
//if(LifeGame.map[i][j] == 1) {
////cell is alive
//
//if((num_sum != 2) && (num_sum != 3)) {
//	
//	LifeGame.newmap[i][j] = 2;
//} else {
//	
//	double rand1 = Math.random();
//	double rand2 = Math.random(); 
//	chance = Math.pow((1-LifeGame.alive_to_sick),num_sick);//alive概率
//	if(rand1 < LifeGame.native_dead) {
//		
//		LifeGame.newmap[i][j] = 2;
//	} else {
//		if(rand2 < chance) {
//			LifeGame.newmap[i][j] = 1;
//		} else {
//			LifeGame.newmap[i][j] = 3;
//		}
//	}
//}
//}
//else if(LifeGame.map[i][j] == 3) {
////cell is sick
//if((num_sum != 2) && (num_sum != 3)) {
//	
//	LifeGame.newmap[i][j] = 2;
//} else {
//	
//	double rand1= Math.random(); 
//	double rand2 = Math.random(); 
//	chance = Math.pow((1-LifeGame.sick_to_dead),num_sick);//每个不健康的细胞有0.25的几率让其恶化
//	//0.05概率直接死亡
//	if(rand1 < LifeGame.native_dead) {
//		LifeGame.newmap[i][j] = 2;
//	} else {
//		if(rand2 < chance) {
//		LifeGame.newmap[i][j] = 3;
//		} else {
//			LifeGame.newmap[i][j] = 2;
//		}
//	}
//}
//} else {
////cell is dead
//if(num_sum == 3) {
//	LifeGame.newmap[i][j] = 1;
//} else {
//	LifeGame.newmap[i][j] = 2;
//}
//
//}