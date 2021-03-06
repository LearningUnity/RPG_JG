package jg.rpg.msg;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jg.rpg.common.anotation.HandlerMsg;
import jg.rpg.common.intf.IMsgHandler;
import jg.rpg.config.ConfigMgr;
import jg.rpg.entity.MsgHandlerItem;
import jg.rpg.entity.MsgUnPacker;
import jg.rpg.entity.Session;

import org.apache.log4j.Logger;

public class MsgMgr implements IMsgHandler{
	private Logger logger = Logger.getLogger(getClass());
	private static MsgMgr inst;
	private MsgMgr(){}
	private Map<Integer , IMsgHandler> handlers;
	public static MsgMgr getInstance(){
		synchronized (MsgMgr.class) {
			if(inst == null){
				inst = new MsgMgr();
			}
		}
		return inst;
	}
	
	public void init() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		handlers = new HashMap<Integer,IMsgHandler>();
		registerAllHandlers(ConfigMgr.getInstance().getHandlerNames());
	}
	
	public void registerAllHandlers(List<String> handlerNames) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(handlerNames == null || handlerNames.isEmpty()) return;
		for(String name : handlerNames){
			Class c = Class.forName(name);
			Object obj = c.newInstance();
			registerHandler(obj);
		}
	}
	
	public void registerHandler(Object handler){
		List<Method> mList = getHandlerMsgMothods(handler.getClass());
		for(Method m : mList){
			MsgHandlerItem item = new MsgHandlerItem();
			item.setHandlerMethod(m);
			item.setObj(handler);
			int msgType = getHandlerType(m);
			if(msgType > 0){
				handlers.put(msgType, item);
			}
		}
	}
	private int getHandlerType(Method m){
		if(isHandlerMsgMethod(m)){
			HandlerMsg hma = m.getAnnotation(HandlerMsg.class);
			return hma.msgType();
		}else{
			return -1;
		}
	}
	
	private List<Method> getHandlerMsgMothods(Class c){
		List<Method> mList = new ArrayList<Method>();
		Method[] methods = c.getMethods();
		for(Method m : methods){
			if(isHandlerMsgMethod(m)){
				mList.add(m);
			}
		}
		return mList;
	}
	private boolean isHandlerMsgMethod(Method m){
		return m.isAnnotationPresent(HandlerMsg.class);
	}
	
	@Override
	public void handleMsg(Session session, MsgUnPacker unpacker) {
		int type = -1;
		try {
			type = unpacker.popInt();
			logger.debug("MsgType : " + type);
			if(handlers.containsKey(type))
				handlers.get(type).handleMsg(session, unpacker);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
