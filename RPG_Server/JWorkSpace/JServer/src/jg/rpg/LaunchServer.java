package jg.rpg;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import jg.rpg.common.exceptions.InitException;
import jg.rpg.common.manager.SessionMgr;
import jg.rpg.common.manager.DefEntityMgr;
import jg.rpg.config.ConfigMgr;
import jg.rpg.dao.db.DBHelper;
import jg.rpg.dao.db.DBMgr;
import jg.rpg.dao.db.RSHHelper;
import jg.rpg.entity.msgEntity.Cat;
import jg.rpg.msg.MsgMgr;
import jg.rpg.net.NetworkMgr;

public class LaunchServer {
	
	public static void main(String[] args) throws PropertyVetoException, SQLException {	
			try {
				ConfigMgr.getInstance().init();
				DefEntityMgr.getInstance().init();
				DBMgr.getInstance().init();
				SessionMgr.getInstance().init();
				MsgMgr.getInstance().init();
				NetworkMgr.getInstance().init(null);
			} catch (InitException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
