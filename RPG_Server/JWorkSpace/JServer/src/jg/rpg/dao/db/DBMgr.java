package jg.rpg.dao.db;

public class DBMgr {

	private DBMgr inst;
	
	private DBMgr getInstance(){
		if(inst == null){
			inst = new DBMgr();
		}
		return inst;
	}
	
	private DBMgr(){
		init();
	}

	private void init() {
		//TODO 初始化数据库连接信息
		
		
	}
	
}
