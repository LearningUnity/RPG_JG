package jg.rpg.common.intf;

import jg.rpg.entity.MsgUnPacker;
import jg.rpg.entity.Session;

public interface IMsgHandler {
	void handleMsg(Session session , MsgUnPacker unpacker );
}
