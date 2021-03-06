package jg.rpg.net.handlers;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.apache.log4j.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jg.rpg.entity.MsgPacker;
import jg.rpg.utils.MsgUtils;

public class DataEnsureHandler extends SimpleChannelInboundHandler<Object> {
	private Logger logger = Logger.getLogger(getClass());

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws InterruptedException, IOException{
		ByteBuf in = (ByteBuf) msg;
		logger.debug(in.readableBytes());
		while(in.isReadable()){
			System.out.print((char)in.readByte());
		}
		MsgPacker _msg = new MsgPacker();
		StringBuffer sb = new StringBuffer();
		
		for(int i=0 ; i < 1024*1024*20; i++){
			sb.append("h");
		}
		try {
			_msg.addInt(10);
			_msg.addDouble(521);
			_msg.addString("hello client");
		} catch (IOException e) {
			e.printStackTrace();
		}
		ByteBuf buff = MsgUtils.serializerMsg(_msg);
		String str = "您已经开启与服务端链接"+" "+new Date()+" "+ctx.channel().localAddress();
		ByteBuf buf = Unpooled.buffer(str.getBytes().length);
		buf.writeBytes(str.getBytes("UTF-8"));
		ctx.writeAndFlush(buff);
		
	}

}
