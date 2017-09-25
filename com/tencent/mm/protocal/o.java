package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.a.g;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class o {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public int fJK = 0;
        public int fRW = 0;
        public int hTw = 0;
        public String sZM = "";
        public byte[] sZN = new byte[0];

        private byte[] bHq() {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeInt(this.hTw);
                dataOutputStream.writeShort(this.sZM.getBytes().length);
                dataOutputStream.write(this.sZM.getBytes());
                dataOutputStream.writeShort(this.sZN.length);
                dataOutputStream.write(this.sZN);
                dataOutputStream.close();
            } catch (IOException e) {
                w.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        private byte[] aX(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                dataOutputStream.writeByte(this.fJK);
                dataOutputStream.writeByte(this.fRW);
                dataOutputStream.write(bArr);
                dataOutputStream.close();
            } catch (IOException e) {
                w.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
            }
            return byteArrayOutputStream.toByteArray();
        }

        public final byte[] zh() {
            byte[] bHq = bHq();
            PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, bHq, o.NK(this.sZv));
            return aX(pByteArray.value);
        }

        public final int zi() {
            return 10;
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean bHp() {
            return true;
        }

        public final boolean Cl() {
            return false;
        }
    }

    public static class b extends e implements k.c {
        public byte[] content;
        public String deviceID;
        private int fJK;
        private int fRW;
        public String hRP;
        private int hTw;

        public b() {
            this.hRP = "";
            this.content = new byte[0];
            this.deviceID = "";
            this.fJK = 0;
            this.fRW = 0;
            this.hTw = 0;
            this.hRP = "";
            this.content = new byte[0];
        }

        public final int getCmdId() {
            return 8;
        }

        public final boolean bHp() {
            return true;
        }

        private byte[] aY(byte[] bArr) {
            if (bArr == null || bArr.length < 2) {
                w.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
                return null;
            }
            byte[] bArr2 = new byte[(bArr.length - 2)];
            try {
                InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                this.fJK = dataInputStream.readByte();
                this.fRW = dataInputStream.readByte();
                dataInputStream.readFully(bArr2);
                w.d("MicroMsg.MMDirectSend", "cmdId:" + this.fJK + ", flag=" + this.fRW + ", tail len=" + bArr2.length);
                byteArrayInputStream.close();
                return bArr2;
            } catch (IOException e) {
                w.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return bArr2;
            }
        }

        public final int y(byte[] bArr) {
            byte[] NK = o.NK(this.deviceID);
            PByteArray pByteArray = new PByteArray();
            if (c.b(pByteArray, aY(bArr), NK) != 0) {
                byte[] bArr2 = new byte[16];
                for (int i = 0; i < 16; i++) {
                    bArr2[i] = (byte) 0;
                }
                if (c.b(pByteArray, aY(bArr), bArr2) != 0) {
                    w.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", bg.bl(NK));
                    return -1;
                }
            }
            byte[] bArr3 = pByteArray.value;
            if (bArr3 == null) {
                w.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
                return 0;
            }
            try {
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
                this.hTw = dataInputStream.readInt();
                w.d("MicroMsg.MMDirectSend", "seq=" + this.hTw);
                short readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("sender empty");
                }
                byte[] bArr4 = new byte[readShort];
                dataInputStream.readFully(bArr4);
                this.hRP = new String(bArr4);
                w.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.hRP);
                readShort = dataInputStream.readShort();
                if (readShort < (short) 0) {
                    throw new IOException("content empty");
                }
                this.content = new byte[readShort];
                dataInputStream.readFully(this.content);
                w.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
                return 0;
            } catch (IOException e) {
                w.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
                return 0;
            }
        }
    }

    public static byte[] NK(String str) {
        Object obj = new byte[16];
        System.arraycopy(str.getBytes(), 0, obj, 0, 15);
        obj[15] = null;
        w.d("MicroMsg.MMDirectSend", "new direct send: key=%s", bg.bl(g.o(obj)));
        return g.o(obj);
    }
}
