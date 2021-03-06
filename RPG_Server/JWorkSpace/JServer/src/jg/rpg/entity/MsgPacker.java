package jg.rpg.entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;

public class MsgPacker {
	Logger logger = Logger.getLogger(MsgPacker.class);
	private ByteArrayOutputStream out;
	private MessagePacker packer;
	
	public MsgPacker(){
		out =  new ByteArrayOutputStream();
		packer = MessagePack.newDefaultPacker(out);
	}
	public byte[] Serialize() throws IOException{
		packer.close();
		return out.toByteArray();
	}
	
	
	public void close() throws IOException{
		packer.close();
	}
	
	public MsgPacker setMsgType(int msgType) throws IOException{
		return addInt(msgType);
	}
	
	public MsgPacker addInt(int num) throws IOException{
		packer.packInt(num);
		return this;

	}
	
	public MsgPacker addFloat(float num) throws IOException{
		packer.packFloat(num);
		return this;

	}
	public MsgPacker addDouble(double num) throws IOException{
		packer.packDouble(num);
		return this;
	}
	
	public MsgPacker addString(String str) throws IOException{
		packer.packString(str);
		return this;
	}
	public MsgPacker addShort(short s) throws IOException{
		packer.packShort(s);
		return this;
	}
	public MsgPacker addLong(long l) throws IOException{
		packer.packLong(l);
		return this;
	}
	public MsgPacker addByte(byte b) throws IOException{
		packer.packByte(b);
		return this;
	}
	
	public MsgPacker addBool(boolean b) throws IOException{
		packer.packBoolean(b);
		return this;
	}
	
	public  MsgPacker addIntArray(int[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packInt(arr[i]);
		}
		return this;
	}
	
	public  MsgPacker addFloatArray(float[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packFloat(arr[i]);
		}
		return this;
	}
	public  MsgPacker addDoubleArray(double[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packDouble(arr[i]);
		}
		return this;
	}
	public  MsgPacker addStringArray(String[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packString(arr[i]);
		}
		return this;
	}
	
	public  MsgPacker addShortArray(short[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packShort(arr[i]);
		}
		return this;
	}
	
	public  MsgPacker addLongArray(long[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packLong(arr[i]);
		}
		return this;
	}
	
	public  MsgPacker addByteArray(byte[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packByte(arr[i]);
		}
		return this;
	}
	public  MsgPacker addBoolArray(boolean[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			packer.packBoolean(arr[i]);
		}
		return this;
	}
	public <T> MsgPacker addArray(T[] arr) throws IOException{
		packer.packArrayHeader(arr.length);
		for(int i=0 ; i<arr.length ; i++){
			this.addValue(arr[i]);
		}
		return this;
	}
	
	
	
	public <K,V> MsgPacker addKV(K k , V v) throws IOException{
		packer.packMapHeader(1);
		this.addValue(k);
		this.addValue(v);
		return this;
	}
	
	
	public <K ,V> MsgPacker addMap(Map<K,V> map) throws IOException{
		packer.packMapHeader(map.size());
		Set<Entry<K , V>> es = map.entrySet();
		for(Entry<K , V> entry : es){
			this.addValue(entry.getKey());
			this.addValue(entry.getValue());
		}
		return this;
	}
	
	public <T> MsgPacker addValue(T t) throws IOException{
		if(t instanceof Integer){
			this.addInt((Integer)t);
		}else if(t instanceof String){
			this.addString((String)t);
		}else if(t instanceof Boolean){
			this.addBool((Boolean)t);
		}else if(t instanceof Short){
			this.addShort((Short)t);
		}else if(t instanceof Long){
			this.addLong((Long)t);
		}else if(t instanceof Float){
			this.addFloat((Float)t);
		}else if(t instanceof Double){
			this.addDouble((Double)t);
		}else if(t instanceof Byte){
			this.addByte((Byte)t);
		}else{
			throw new IOException("add no support type error");
		}
		return this;
	}
	

}
