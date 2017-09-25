package com.tencent.mm.protocal;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;

public final class aa {

    public static class a extends d implements com.tencent.mm.protocal.k.b {
        public byte[] gXJ;
        public byte[] hKD = new byte[0];
        public int netType;
        public int sZE;
        public int uin = 0;

        public final void dj(int i) {
            this.uin = i;
        }

        public final byte[] zh() {
            String str = "MicroMsg.MMSyncCheck";
            String str2 = "toProtoBuf dksynccheck uin:%d keybuf:%d, stack[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.uin);
            objArr[1] = Integer.valueOf(this.hKD == null ? -1 : this.hKD.length);
            objArr[2] = bg.bJZ();
            w.d(str, str2, objArr);
            if (this.uin == 0 || bg.bm(this.hKD)) {
                return new byte[0];
            }
            int length = (((this.uin >> 13) & 524287) | (this.hKD.length << 19)) ^ 1442968193;
            int length2 = 1442968193 ^ (((this.hKD.length >> 13) & 524287) | (this.uin << 19));
            Object obj = new byte[(this.hKD.length + 32)];
            w.d("MicroMsg.MMSyncCheck", "dksynccheck uin=[%d/%d], keyBufLen=[%d/%d] outBuf=[%d]", Integer.valueOf(this.uin), Integer.valueOf(length), Integer.valueOf(this.hKD.length), Integer.valueOf(length2), Integer.valueOf(obj.length));
            obj[0] = (byte) ((length >> 24) & 255);
            obj[1] = (byte) ((length >> 16) & 255);
            obj[2] = (byte) ((length >> 8) & 255);
            obj[3] = (byte) (length & 255);
            obj[4] = (byte) ((length2 >> 24) & 255);
            obj[5] = (byte) ((length2 >> 16) & 255);
            obj[6] = (byte) ((length2 >> 8) & 255);
            obj[7] = (byte) (length2 & 255);
            System.arraycopy(this.hKD, 0, obj, 8, this.hKD.length);
            obj[obj.length - 24] = (byte) ((d.sYN >> 24) & 255);
            obj[obj.length - 23] = (byte) ((d.sYN >> 16) & 255);
            obj[obj.length - 22] = (byte) ((d.sYN >> 8) & 255);
            obj[obj.length - 21] = (byte) (d.sYN & 255);
            String locale = Locale.getDefault().toString();
            if (locale.length() > 8) {
                locale = locale.substring(0, 8);
            }
            Object bytes = locale.getBytes();
            System.arraycopy(bytes, 0, obj, obj.length - 20, bytes.length);
            w.d("MicroMsg.MMSyncCheck", "language:%x" + Arrays.toString(bytes));
            obj[obj.length - 12] = null;
            obj[obj.length - 11] = null;
            obj[obj.length - 10] = null;
            obj[obj.length - 9] = 2;
            obj[obj.length - 8] = (byte) ((this.netType >> 24) & 255);
            obj[obj.length - 7] = (byte) ((this.netType >> 16) & 255);
            obj[obj.length - 6] = (byte) ((this.netType >> 8) & 255);
            obj[obj.length - 5] = (byte) (this.netType & 255);
            obj[obj.length - 4] = (byte) ((this.sZE >> 24) & 255);
            obj[obj.length - 3] = (byte) ((this.sZE >> 16) & 255);
            obj[obj.length - 2] = (byte) ((this.sZE >> 8) & 255);
            obj[obj.length - 1] = (byte) (this.sZE & 255);
            w.d("MicroMsg.MMSyncCheck", "outbuf:%x" + Arrays.toString(obj));
            this.gXJ = g.o(obj);
            return obj;
        }

        public final int zi() {
            return 0;
        }

        public final int getCmdId() {
            return cf.CTRL_INDEX;
        }

        public final boolean bHp() {
            return true;
        }

        public final boolean Cl() {
            return false;
        }
    }

    public static class b extends e implements c {
        private String fQX = null;
        public byte[] gXJ = null;
        public long taj = 7;
        private byte[] tak;

        @TargetApi(9)
        public final String bHr() {
            if (this.gXJ == null) {
                return "";
            }
            if (this.fQX == null) {
                byte[] aesDecrypt = MMProtocalJni.aesDecrypt(this.tak, this.gXJ);
                if (bg.bm(aesDecrypt)) {
                    return "";
                }
                if (VERSION.SDK_INT >= 9) {
                    this.fQX = new String(aesDecrypt, Charset.forName("UTF-8"));
                } else {
                    this.fQX = new String(aesDecrypt);
                }
            }
            return this.fQX;
        }

        public final int y(byte[] bArr) {
            int i;
            if (bArr == null || bArr.length < 12) {
                String str = "MicroMsg.MMSyncCheck";
                StringBuilder stringBuilder = new StringBuilder("dksynccheck err resp buf:");
                if (bArr == null) {
                    i = -1;
                } else {
                    i = bArr.length;
                }
                w.e(str, stringBuilder.append(i).toString());
                return -1;
            }
            this.taj = (long) ((((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24));
            i = (((bArr[7] & 255) | ((bArr[6] & 255) << 8)) | ((bArr[5] & 255) << 16)) | ((bArr[4] & 255) << 24);
            int i2 = (((bArr[11] & 255) | ((bArr[10] & 255) << 8)) | ((bArr[9] & 255) << 16)) | ((bArr[8] & 255) << 24);
            w.d("MicroMsg.MMSyncCheck", " fromProtoBuf oreh synccheck resp selector:%d, redCode:%d, keyLen:%d", Long.valueOf(this.taj), Integer.valueOf(i), Integer.valueOf(i2));
            if (i != -3002) {
                this.fQX = "";
                return i;
            } else if (i2 == bArr.length - 12 || i2 == (bArr.length - 12) - 16) {
                if (i2 == (bArr.length - 12) - 16) {
                    this.gXJ = new byte[16];
                    System.arraycopy(bArr, bArr.length - 16, this.gXJ, 0, 16);
                }
                this.tak = new byte[i2];
                System.arraycopy(bArr, 12, this.tak, 0, i2);
                return i;
            } else {
                w.e("MicroMsg.MMSyncCheck", " the key len is invalid keyLen:%d, bufLen:%d", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                return -1;
            }
        }

        public final int getCmdId() {
            return 1000000205;
        }

        public final boolean bHp() {
            return true;
        }
    }
}
