package com.tencent.mm.plugin.backup.b;

import android.os.HandlerThread;
import com.tencent.mm.a.k;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.e.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;

public final class a implements com.tencent.mm.plugin.backup.f.b.a {
    public static final byte[] jBB = "GSMW".getBytes();
    public String jBC;
    public int jBD;
    public ae jBE = null;
    public a jBF;
    public int mode = 0;

    public interface a {
        void a(int i, int i2, byte[] bArr);
    }

    public final boolean a(PString pString, PInt pInt) {
        this.mode = 0;
        w.i("MicroMsg.BackupCEngine", "listen before server.stop");
        Java2C.stop();
        w.i("MicroMsg.BackupCEngine", "listen after server.stop");
        w.i("MicroMsg.BackupCEngine", "listen before server.start listener");
        Server.hbn = new com.tencent.mm.lan_cs.Server.a(this) {
            final /* synthetic */ a jBG;

            {
                this.jBG = r1;
            }

            public final void eS(int i) {
                if (this.jBG.mode == 1) {
                    b.jp(i);
                }
            }

            public final void onRecv(String str, int i, byte[] bArr) {
                this.jBG.jBC = str;
                this.jBG.jBD = i;
                try {
                    this.jBG.O(bArr);
                } catch (IOException e) {
                    this.jBG.a(true, 0, 10006, ("server readErr:" + e.toString()).getBytes());
                }
            }

            public final void wh() {
                this.jBG.a(true, 0, 10011, "listen server onDisconnect".getBytes());
            }

            public final void onConnect(String str, int i) {
                this.jBG.jBC = str;
                this.jBG.jBD = i;
            }
        };
        Object[] start = Java2C.start();
        if (start == null || start.length != 3) {
            w.e("MicroMsg.BackupCEngine", "listen error");
            return false;
        }
        w.i("MicroMsg.BackupCEngine", "listen result: %d, %s, %d", new Object[]{start[0], start[1], start[2]});
        if (((Integer) start[0]).intValue() != 1) {
            return false;
        }
        pString.value = (String) start[1];
        pInt.value = ((Integer) start[2]).intValue();
        this.mode = 1;
        return true;
    }

    public final void connect(String str, int i) {
        this.mode = 2;
        this.jBC = str;
        this.jBD = i;
        Client.hbm = new com.tencent.mm.lan_cs.Client.a(this) {
            final /* synthetic */ a jBG;

            {
                this.jBG = r1;
            }

            public final void onRecv(String str, int i, byte[] bArr) {
                this.jBG.jBC = str;
                this.jBG.jBD = i;
                try {
                    this.jBG.O(bArr);
                } catch (IOException e) {
                    this.jBG.a(true, 0, 10006, ("client readErr:" + e.toString()).getBytes());
                }
            }

            public final void wh() {
                this.jBG.a(true, 0, 10011, "client onDisconnect".getBytes());
            }
        };
    }

    public final void stop() {
        w.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            b.aaO();
            this.mode = 0;
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.aaO();
            this.mode = 0;
        }
    }

    public final void i(int i, byte[] bArr) {
        final long Nz = bg.Nz();
        w.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bg.bn(bArr))});
        if (this.jBE == null || !this.jBE.getLooper().getThread().isAlive()) {
            HandlerThread Qu = e.Qu("BackupCEngine_sendHandler");
            Qu.setPriority(10);
            Qu.start();
            this.jBE = new ae(Qu.getLooper());
            w.w("MicroMsg.BackupCEngine", "BackupCEngine new writerHandler:%d", new Object[]{Long.valueOf(Qu.getId())});
        }
        final int i2 = i;
        final byte[] bArr2 = bArr;
        this.jBE.post(new Runnable(this) {
            final /* synthetic */ a jBG;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r12 = this;
                r11 = 4;
                r10 = 3;
                r9 = 2;
                r8 = 1;
                r1 = 0;
                r2 = com.tencent.mm.sdk.platformtools.bg.Nz();
                r0 = "MicroMsg.BackupCEngine";
                r4 = "before send server mode:%d  seq:%d  buff:%d time:[%d]";
                r5 = new java.lang.Object[r11];
                r6 = r12.jBG;
                r6 = r6.mode;
                r6 = java.lang.Integer.valueOf(r6);
                r5[r1] = r6;
                r6 = r2;
                r6 = java.lang.Integer.valueOf(r6);
                r5[r8] = r6;
                r6 = r3;
                r6 = com.tencent.mm.sdk.platformtools.bg.bn(r6);
                r6 = java.lang.Integer.valueOf(r6);
                r5[r9] = r6;
                r6 = r4;
                r6 = r2 - r6;
                r6 = java.lang.Long.valueOf(r6);
                r5[r10] = r6;
                com.tencent.mm.sdk.platformtools.w.i(r0, r4, r5);
                r0 = r12.jBG;
                r0 = r0.mode;
                if (r0 != 0) goto L_0x004c;
            L_0x0042:
                r0 = "MicroMsg.BackupCEngine";
                r1 = "sendImp err mode!!";
                com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            L_0x004b:
                return;
            L_0x004c:
                r0 = r12.jBG;
                r0 = r0.mode;
                if (r0 != r8) goto L_0x00a8;
            L_0x0052:
                r0 = r12.jBG;
                r0 = r0.jBC;
                r4 = r12.jBG;
                r4 = r4.jBD;
                r5 = r3;
                r0 = com.tencent.mm.lan_cs.Server.Java2C.send(r0, r4, r5);
                if (r0 == 0) goto L_0x0062;
            L_0x0062:
                r4 = r3;
                r4 = com.tencent.mm.sdk.platformtools.bg.bn(r4);
                com.tencent.mm.plugin.backup.f.b.jp(r4);
                r4 = "MicroMsg.BackupCEngine";
                r5 = "send result[%d], seq[%d], buff[%d], time[%d,%d]";
                r6 = 5;
                r6 = new java.lang.Object[r6];
                r0 = java.lang.Integer.valueOf(r0);
                r6[r1] = r0;
                r0 = r2;
                r0 = java.lang.Integer.valueOf(r0);
                r6[r8] = r0;
                r0 = r3;
                r0 = com.tencent.mm.sdk.platformtools.bg.bn(r0);
                r0 = java.lang.Integer.valueOf(r0);
                r6[r9] = r0;
                r0 = r4;
                r0 = com.tencent.mm.sdk.platformtools.bg.aA(r0);
                r0 = java.lang.Long.valueOf(r0);
                r6[r10] = r0;
                r0 = com.tencent.mm.sdk.platformtools.bg.aA(r2);
                r0 = java.lang.Long.valueOf(r0);
                r6[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);
                goto L_0x004b;
            L_0x00a8:
                r0 = r12.jBG;
                r0 = r0.mode;
                if (r0 != r9) goto L_0x00bd;
            L_0x00ae:
                r0 = r12.jBG;
                r0 = r0.jBC;
                r4 = r12.jBG;
                r4 = r4.jBD;
                r5 = r3;
                r0 = com.tencent.mm.lan_cs.Client.Java2C.send(r0, r4, r5);
                goto L_0x0062;
            L_0x00bd:
                r0 = r1;
                goto L_0x0062;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.b.a.4.run():void");
            }
        });
    }

    public final int j(int i, byte[] bArr) {
        int send;
        long Nz = bg.Nz();
        if (this.mode == 1) {
            send = Java2C.send(this.jBC, this.jBD, bArr);
        } else if (this.mode == 2) {
            send = Client.Java2C.send(this.jBC, this.jBD, bArr);
            b.jp(bg.bn(bArr));
        } else {
            send = 0;
        }
        w.i("MicroMsg.BackupCEngine", "send result:%d seq:%d  buff:%d time[%d]", new Object[]{Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(bg.bn(bArr)), Long.valueOf(bg.aA(Nz))});
        return send;
    }

    public final void O(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[4];
        dataInputStream.read(bArr2);
        if (Arrays.equals(jBB, bArr2)) {
            int readInt = dataInputStream.readInt();
            short readShort = dataInputStream.readShort();
            short readShort2 = dataInputStream.readShort();
            int readInt2 = dataInputStream.readInt();
            String format;
            if (readInt2 > 16777216) {
                format = String.format("loopRead size too large, size:%d", new Object[]{Integer.valueOf(readInt2)});
                w.e("MicroMsg.BackupCEngine", format);
                a(true, readInt, 10007, format.getBytes());
                return;
            }
            int readInt3 = dataInputStream.readInt();
            w.i("MicroMsg.BackupCEngine", "read buf size:%d, seq:%d, version:%d, type:%d", new Object[]{Integer.valueOf(readInt2), Integer.valueOf(readInt), Short.valueOf(readShort), Short.valueOf(readShort2)});
            byte[] bArr3 = new byte[(readInt2 - 20)];
            if (dataInputStream.read(bArr3) == bArr3.length) {
                Object obj;
                PByteArray pByteArray = new PByteArray();
                b.jp(bg.bn(bArr3));
                byte[] bArr4 = jBB;
                int aah = b.aah();
                if (readShort != (short) 1) {
                    format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
                    w.e("MicroMsg.BackupPacker", format);
                    pByteArray.value = format.getBytes();
                    obj = -1;
                } else if (aah != 1 || readInt3 == c.a(bArr4, readInt, readShort, readShort2, readInt2, bArr3)) {
                    if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                        bArr3 = k.a(bArr3, com.tencent.mm.plugin.backup.a.e.aai());
                    }
                    pByteArray.value = bArr3;
                    obj = null;
                } else {
                    new CRC32().update(bArr3);
                    String Q = c.Q(bArr3);
                    format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(r0), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), Q});
                    w.e("MicroMsg.BackupPacker", format);
                    pByteArray.value = format.getBytes();
                    obj = -2;
                }
                if (obj != null) {
                    a(true, readInt, 10007, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
                } else if (this.jBF != null) {
                    this.jBF.a(readInt, readShort2, pByteArray.value);
                } else {
                    a(false, readInt, readShort2, pByteArray.value);
                }
            }
        }
    }

    public final void a(boolean z, int i, int i2, byte[] bArr) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        af.v(new Runnable(this) {
            final /* synthetic */ a jBG;

            public final void run() {
                b.b(z2, i3, i4, bArr2);
            }
        });
    }
}
