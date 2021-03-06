package jg.rpg.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageUnpacker;
import org.msgpack.value.ArrayValue;
import org.msgpack.value.MapValue;
import org.msgpack.value.Value;

public class MsgUnPacker {

	private MessageUnpacker unpacker ;
	private byte[] buff;
	public MsgUnPacker(byte[] buff) throws IOException{
		if(buff != null){
			this.buff = buff;
			unpacker = MessagePack.newDefaultUnpacker(buff);
		}else{
			throw new IOException("Construct msgUnreturn unpacker error Buff is null");
		}
		
	}
	public MsgUnPacker(InputStream in) throws IOException{
		if(in != null){
			int len = in.available();
			buff = new byte[len];
			in.read(buff);
			unpacker = MessagePack.newDefaultUnpacker(buff);
		}else{
			throw new IOException("Construct msgUnreturn unpacker error intream is null");
		}
	}
	
	public void close() throws IOException{
		unpacker.close();
	}
	public MsgUnPacker reset() throws IOException{
		this.close();
		return new MsgUnPacker(buff);
	}
	
	public boolean hasNext() throws IOException{
		return unpacker.hasNext();
	}
	
	
	public Value popValue() throws IOException{
			return unpacker.unpackValue();
	}
	
	public int popInt() throws IOException{
		return  unpacker.unpackInt();
	}
	
	public  float popFloat() throws IOException{
		return unpacker.unpackFloat();
	}
	
	public double popDouble() throws IOException{
		return unpacker.unpackDouble();
	}
	
	public  String popString() throws IOException{
		return unpacker.unpackString();
	}
	
	public  Short popShort() throws IOException{
		return unpacker.unpackShort();
	}
	
	public long popLong() throws IOException{
		return unpacker.unpackLong();
	}
	
	public  byte popByte() throws IOException{
		return unpacker.unpackByte();
	}
	
	public  boolean popBool() throws IOException{
		return unpacker.unpackBoolean();
	}
	
	public  int[] popIntArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		int[] arr = new int[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackInt();
		}
		return arr;
	}
	
	public  float[] popFloatArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		float[] arr = new float[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackFloat();
		}
		return arr;
	}
	public  double[] popDoubleArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		double[] arr = new double[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackDouble();
		}
		return arr;
	}
	
	public  String[] popStringArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		String[] arr = new String[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackString();
		}
		return arr;
	}
	
	public  byte[] popByteArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		byte[] arr = new byte[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackByte();
		}
		return arr;
	}
	
	public Value[] popArray() throws IOException{
		int len = unpacker.unpackArrayHeader();
		Value[] arr = new Value[len];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = unpacker.unpackValue();
		}
		return arr;
	}
	public  Map<String , Value> popKSingMap() throws IOException{
		int len = unpacker.unpackMapHeader();
		if(len <= 0){
			return null;
		}
		Map<String , Value> map = new HashMap<String , Value>();
		for(int i=0 ; i<len ; i++){
			String key = unpacker.unpackString();
			Value v = unpacker.unpackValue();
			map.put(key, v);
		}
		return map;
	}
	
	public  Map<Value , Value> popMap() throws IOException{
		int len = unpacker.unpackMapHeader();
		if(len <= 0){
			return null;
		}
		Map<Value , Value> map = new HashMap<Value , Value>();
		for(int i=0 ; i<len ; i++){
			Value key = unpacker.unpackValue();
			Value v = unpacker.unpackValue();
			map.put(key, v);
		}
		return map;
	}
	
	public Value getValue(int index) throws IOException{
		MessageUnpacker  _unpacker = MessagePack.newDefaultUnpacker(buff);
		for(int i=0 ; i<index && _unpacker.hasNext(); i++){
			_unpacker.skipValue();
		}
		return _unpacker.unpackValue();
	}
	
	public int getInt(int index) throws IOException{
		return getValue(index).asIntegerValue().toInt();
	}
	
	public float getFloat(int index) throws IOException{
		return getValue(index).asFloatValue().toFloat();
	}
	
	public Double getDoublet(int index) throws IOException{
		return getValue(index).asFloatValue().toDouble();
	}
	public String getString(int index) throws IOException{
		return getValue(index).asStringValue().asString();
	}
	public boolean getBool(int index) throws IOException{
		return getValue(index).asBooleanValue().getBoolean();
	}
	

	public ArrayValue getArray(int index) throws IOException{
		return getValue(index).asArrayValue();
	}
	
	public int[] getIntArray(int index) throws IOException{
		ArrayValue av = getArray(index);
		int len = av.size();
		int[] arr = new int[len];
		for(int i=0 ; i<len; i++){
			arr[i] = av.get(i).asIntegerValue().toInt();
		}
		return arr;
	}
	
	public float[] getFloatArray(int index) throws IOException{
		ArrayValue av = getArray(index);
		int len = av.size();
		float[] arr = new float[len];
		for(int i=0 ; i<len; i++){
			arr[i] = av.get(i).asFloatValue().toFloat();
		}
		return arr;
	}
	
	public double[] getDoubleArray(int index) throws IOException{
		ArrayValue av = getArray(index);
		int len = av.size();
		double[] arr = new double[len];
		for(int i=0 ; i<len; i++){
			arr[i] = av.get(i).asFloatValue().toDouble();
		}
		return arr;
	}
	
	
	public boolean[] getBoolArray(int index) throws IOException{
		ArrayValue av = getArray(index);
		int len = av.size();
		boolean[] arr = new boolean[len];
		for(int i=0 ; i<len; i++){
			arr[i] = av.get(i).asBooleanValue().getBoolean();
		}
		return arr;
	}
	
	public String[] getStringArray(int index) throws IOException{
		ArrayValue av = getArray(index);
		int len = av.size();
		String[] arr = new String[len];
		for(int i=0 ; i<len; i++){
			arr[i] = av.get(i).asStringValue().toString();
		}
		return arr;
	}
	
	public MapValue getMapValue(int index) throws IOException{
		return getValue(index).asMapValue();
	}
	
	
}
