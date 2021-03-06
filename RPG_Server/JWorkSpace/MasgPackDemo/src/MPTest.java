import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.msgpack.core.MessagePack;
import org.msgpack.core.MessagePacker;
import org.msgpack.core.MessageUnpacker;

public class MPTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
	        MessagePacker packer = MessagePack.newDefaultPacker(out);
	        packer
	                .packInt(1)
	                .packString("leo")
	                .packArrayHeader(2)
	                .packString("xxx-xxxx")
	                .packString("yyy-yyyy");
	        packer.close();

	        // Deserialize with MessageUnpacker
	        MessageUnpacker unpacker = MessagePack.newDefaultUnpacker(out.toByteArray());
	        int id = unpacker.unpackInt();             // 1
	        String name = unpacker.unpackString();     // "leo"
	        int numPhones = unpacker.unpackArrayHeader();  // 2
	        String[] phones = new String[numPhones];
	        for (int i = 0; i < numPhones; ++i) {
	            phones[i] = unpacker.unpackString();   // phones = {"xxx-xxxx", "yyy-yyyy"}
	        }
	        unpacker.close();

	        System.out.println(String.format("id:%d, name:%s, phone:[%s]", id, name, join(phones)));
	}
    private static String join(String[] in)
    {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < in.length; ++i) {
            if (i > 0) {
                s.append(", ");
            }
            s.append(in[i]);
        }
        return s.toString();
    }

}
