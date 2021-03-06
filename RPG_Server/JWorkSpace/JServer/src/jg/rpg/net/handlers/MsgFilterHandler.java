package jg.rpg.net.handlers;

import org.apache.log4j.Logger;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jg.rpg.entity.MsgUnPacker;

public class MsgFilterHandler extends SimpleChannelInboundHandler<MsgUnPacker> {
	private Logger logger = Logger.getLogger(getClass());
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, MsgUnPacker msg)
			throws Exception {
		logger.debug("MsgFilterHandler");
		ctx.fireChannelRead(msg);
	}

}
