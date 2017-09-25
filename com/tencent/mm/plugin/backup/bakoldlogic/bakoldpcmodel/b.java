package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.net.wifi.WifiManager;
import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.a.k;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.backup.f.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements a {
    public static final byte[] jBB = "GSMW".getBytes();
    private Boolean jLp = Boolean.valueOf(false);
    private ServerSocket jLq = null;
    public ae jLr = null;
    private ae jLs = new ae(Looper.getMainLooper());
    public DataOutputStream jLt = null;
    private int jLu = 0;
    private int jLv = 0;
    private long jLw = 0;
    private Socket joZ = null;
    public Object lock = new Object();

    public b() {
        acm();
    }

    public final void b(final int i, final List<me> list) {
        w.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[]{Integer.valueOf(i)});
        acm();
        e.post(new Runnable(this) {
            final /* synthetic */ b jLy;

            public final void run() {
                switch (i) {
                    case 0:
                        this.jLy.jv(((Integer) ((me) list.get(0)).tss.getFirst()).intValue());
                        return;
                    case 1:
                        WifiManager wifiManager = (WifiManager) ab.getContext().getSystemService("wifi");
                        int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
                        int i = wifiManager.getDhcpInfo().netmask;
                        String str = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
                        w.e("MicroMsg.BakOldJavaEngine", "localip:%s, mask:%d", new Object[]{str, Integer.valueOf(i)});
                        String str2 = null;
                        int i2 = 0;
                        for (me meVar : list) {
                            w.i("MicroMsg.BakOldJavaEngine", "try ip:%s", new Object[]{meVar.tsr});
                            if (meVar.tsr != null) {
                                if (meVar.tsr.split("\\.").length >= 4) {
                                    int p = n.p(new byte[]{(byte) (bg.getInt(meVar.tsr.split("\\.")[0], 0) & 255), (byte) (bg.getInt(meVar.tsr.split("\\.")[1], 0) & 255), (byte) (bg.getInt(meVar.tsr.split("\\.")[2], 0) & 255), (byte) (bg.getInt(meVar.tsr.split("\\.")[3], 0) & 255)});
                                    if ((i & p) == (i & ipAddress)) {
                                        this.jLy.ax(meVar.tsr, ((Integer) meVar.tss.getFirst()).intValue());
                                        return;
                                    }
                                    String str3;
                                    int intValue;
                                    if ((p & 65535) == (65535 & ipAddress)) {
                                        str3 = meVar.tsr;
                                        intValue = ((Integer) meVar.tss.getFirst()).intValue();
                                    } else {
                                        intValue = i2;
                                        str3 = str2;
                                    }
                                    str2 = str3;
                                    i2 = intValue;
                                } else {
                                    continue;
                                }
                            }
                        }
                        if (str2 != null) {
                            w.w("MicroMsg.BakOldJavaEngine", "try to connect to secondary:%s, port:%d", new Object[]{str2, Integer.valueOf(i2)});
                            this.jLy.ax(str2, i2);
                            return;
                        }
                        this.jLy.a(true, 0, 10009, String.format("not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str}).getBytes());
                        w.e("MicroMsg.BakOldJavaEngine", "not match ip mask:%d, localip:%s", new Object[]{Integer.valueOf(i), str});
                        return;
                    default:
                        return;
                }
            }
        }, "BackupJavaEngine_connect");
    }

    public final void ack() {
        w.i("MicroMsg.BakOldJavaEngine", "close connect");
        acl();
        a(true, 0, 10003, null);
    }

    public final void acl() {
        this.jLu = 0;
        this.jLv = 0;
        this.jLw = 0;
        this.jLp = Boolean.valueOf(true);
        try {
            synchronized (this.lock) {
                if (this.jLt != null) {
                    this.jLt.close();
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.joZ != null) {
                this.joZ.close();
            }
        } catch (Exception e2) {
        }
    }

    public final void a(boolean z, int i, int i2, byte[] bArr) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final byte[] bArr2 = bArr;
        this.jLs.post(new Runnable(this) {
            final /* synthetic */ b jLy;

            public final void run() {
                com.tencent.mm.plugin.backup.f.b.b(z2, i3, i4, bArr2);
            }
        });
    }

    public final void i(final int i, final byte[] bArr) {
        if (this.jLr != null) {
            T(bArr);
        } else {
            this.jLs.postDelayed(new Runnable(this) {
                final /* synthetic */ b jLy;

                public final void run() {
                    this.jLy.T(bArr);
                }
            }, 200);
        }
    }

    public final int j(int i, byte[] bArr) {
        return 0;
    }

    public final void T(final byte[] bArr) {
        if (this.jLp.booleanValue()) {
            w.e("MicroMsg.BakOldJavaEngine", "engine has stop");
        } else {
            this.jLr.post(new Runnable(this) {
                final /* synthetic */ b jLy;

                public final void run() {
                    try {
                        synchronized (this.jLy.lock) {
                            this.jLy.jLt.write(bArr);
                            this.jLy.jLt.flush();
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.BakOldJavaEngine", "send_error %s", new Object[]{e});
                        this.jLy.acl();
                        this.jLy.a(true, 0, 10008, ("send_error " + e).getBytes());
                    }
                }
            });
        }
    }

    private void acm() {
        if (this.jLr == null || !this.jLr.getLooper().getThread().isAlive()) {
            e.b(new Runnable(this) {
                final /* synthetic */ b jLy;

                {
                    this.jLy = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.jLy.jLr = new ae();
                    Looper.loop();
                }
            }, "BackupJavaEngine_handler").start();
        }
    }

    public final void ax(String str, int i) {
        w.i("MicroMsg.BakOldJavaEngine", "doConnect serverIp:%s, port:%d", new Object[]{str, Integer.valueOf(((i & 255) << 8) | ((i >> 8) & 255))});
        try {
            InetAddress byName = InetAddress.getByName(str);
            w.i("MicroMsg.BakOldJavaEngine", "TCP  Connecting...");
            this.joZ = new Socket(byName, r0);
            this.joZ.setKeepAlive(true);
            w.i("MicroMsg.BakOldJavaEngine", "TCP connected" + this.joZ.toString());
            this.jLt = new DataOutputStream(new BufferedOutputStream(this.joZ.getOutputStream()));
            DataInputStream dataInputStream = new DataInputStream(this.joZ.getInputStream());
            this.jLp = Boolean.valueOf(false);
            a(true, 0, CdnLogic.MediaType_FAVORITE_VIDEO, null);
            while (!this.jLp.booleanValue()) {
                a(dataInputStream);
            }
        } catch (IOException e) {
            w.e("MicroMsg.BakOldJavaEngine", "doConnect %s", new Object[]{e});
            acl();
            a(true, 0, 10004, ("doConnect " + e).getBytes());
        }
    }

    private void a(DataInputStream dataInputStream) {
        int i;
        while (!this.jLp.booleanValue() && this.jLu != 4) {
            try {
                if (jBB[this.jLu] == dataInputStream.readByte()) {
                    this.jLu++;
                } else {
                    long Ny = bg.Ny();
                    if (((long) this.jLv) - (Ny - this.jLw) < 10) {
                        if (this.jLv < 0) {
                            this.jLv = 0;
                        }
                        this.jLv++;
                        this.jLw = Ny;
                        i = 0;
                    } else {
                        boolean z = true;
                    }
                    if (i == 0) {
                        String format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.jLu + 1), Integer.valueOf(jBB[this.jLu] & 255), Integer.valueOf(r1 & 255)});
                        w.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, 10007, format.getBytes());
                    }
                    this.jLu = 0;
                }
            } catch (Exception e) {
                w.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[]{e});
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.jLp.booleanValue()) {
                    a(true, 0, 10006, ("read_error " + e).getBytes());
                }
                acl();
                return;
            }
        }
        this.jLu = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            w.e("MicroMsg.BakOldJavaEngine", format);
            this.jLp = Boolean.valueOf(true);
            a(true, 0, 10007, format.getBytes());
            return;
        }
        int readInt3 = dataInputStream.readInt();
        w.i("MicroMsg.BakOldJavaEngine", "read buf size:" + readInt2);
        byte[] bArr = new byte[(readInt2 - 20)];
        i = 0;
        while (i < bArr.length) {
            int read = dataInputStream.read(bArr, i, bArr.length - i);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = jBB;
        if (readShort != (short) 1) {
            format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
            w.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -1;
        } else if (com.tencent.mm.plugin.backup.f.b.aah() != 1 || readInt3 == com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = k.a(bArr, com.tencent.mm.plugin.backup.a.e.aai());
            }
            pByteArray.value = bArr;
            i = 0;
        } else {
            new CRC32().update(bArr);
            String Q = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.Q(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), Q});
            w.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i = -2;
        }
        w.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[]{Integer.valueOf(i)});
        if (i != 0) {
            a(true, 0, 10007, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            return;
        }
        w.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(readInt), Short.valueOf(readShort2)});
        a(false, readInt, readShort2, pByteArray.value);
    }

    public final void jv(int i) {
        w.i("MicroMsg.BakOldJavaEngine", "doListen port:%d", new Object[]{Integer.valueOf(((i >> 8) & 255) | ((i & 255) << 8))});
        this.jLq = null;
        try {
            w.i("MicroMsg.BakOldJavaEngine", "ip:" + InetAddress.getLocalHost().getHostAddress());
            try {
                w.i("MicroMsg.BakOldJavaEngine", "before init ");
                this.jLq = new ServerSocket(r1);
                w.i("MicroMsg.BakOldJavaEngine", "before accept server:  " + this.jLq.toString());
                this.joZ = this.jLq.accept();
                this.joZ.setKeepAlive(true);
                w.i("MicroMsg.BakOldJavaEngine", "after accept client:  " + this.joZ.toString());
                DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(this.joZ.getInputStream()));
                this.jLt = new DataOutputStream(new BufferedOutputStream(this.joZ.getOutputStream()));
                this.jLp = Boolean.valueOf(false);
                a(true, 0, CdnLogic.MediaType_FAVORITE_FILE, null);
                while (!this.jLp.booleanValue()) {
                    a(dataInputStream);
                }
            } catch (IOException e) {
                w.e("MicroMsg.BakOldJavaEngine", "doListen %s", new Object[]{e});
                acl();
                a(true, 0, 10005, ("doListenErr " + e).getBytes());
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.BakOldJavaEngine", e2, "getHostAddress", new Object[0]);
        }
    }
}
