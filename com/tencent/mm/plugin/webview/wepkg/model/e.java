package com.tencent.mm.plugin.webview.wepkg.model;

import com.tencent.mm.plugin.webview.wepkg.c.b;
import com.tencent.mm.protocal.c.bmy;
import com.tencent.mm.protocal.c.sh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
    private static int sqk = 4;
    private static ByteOrder sql = ByteOrder.BIG_ENDIAN;
    private volatile String gMv = "";
    private File iyI;
    volatile boolean iyK = false;
    private volatile int sqm;
    private volatile int sqn = 0;
    volatile bmy sqo = null;
    private volatile LinkedList<sh> sqp = null;
    private volatile String sqq = "";

    public e(File file) {
        boolean z = false;
        this.iyI = file;
        if (Qi()) {
            z = true;
        }
        this.iyK = z;
    }

    public final WebResourceResponse ea(String str, String str2) {
        if (bg.bV(this.sqp) || this.sqn < sqk || bg.mA(str)) {
            w.e("MicroMsg.Wepkg.WePkgReader", "mFileIndexList is null");
            return null;
        }
        Iterator it = this.sqp.iterator();
        while (it.hasNext()) {
            sh shVar = (sh) it.next();
            if (bg.mz(shVar.tAk).equals(str)) {
                String str3 = shVar.tAm;
                Object obj = (bg.mA(str3) || !(str3.startsWith("video/") || str3.startsWith("audio/"))) ? null : 1;
                if (obj != null) {
                    w.i("MicroMsg.Wepkg.WePkgReader", "filename (%s) is media resource", new Object[]{str});
                    return null;
                } else if (((long) shVar.jNW) <= 5242880) {
                    try {
                        w.i("MicroMsg.Wepkg.WePkgReader", "rid hit big package. rid:%s", new Object[]{str});
                        return new WebResourceResponse(shVar.tAm, str2, new b(this.iyI, ((long) this.sqn) + shVar.tAl, (long) shVar.jNW));
                    } catch (IOException e) {
                        w.e("MicroMsg.Wepkg.WePkgReader", "filename = %s, offset = %d, size = %d, mimeType = %s, e = %s", new Object[]{str, Long.valueOf(shVar.tAl), Integer.valueOf(shVar.jNW), shVar.tAm, e.getMessage()});
                    }
                } else {
                    w.i("MicroMsg.Wepkg.WePkgReader", "fileSize(%d) > limitSize(%d), filename = %s, offset = %d, mimeType = %s", new Object[]{Integer.valueOf(shVar.jNW), Long.valueOf(5242880), str, Long.valueOf(shVar.tAl), shVar.tAm});
                }
            }
        }
        return null;
    }

    private boolean Qi() {
        boolean z = false;
        FileChannel fileChannel = null;
        try {
            fileChannel = new RandomAccessFile(this.iyI, "r").getChannel();
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.WePkgReader", "openfile failed, " + e.getMessage());
        }
        if (fileChannel != null) {
            try {
                fileChannel.position(0);
                ByteBuffer allocate = ByteBuffer.allocate(sqk);
                allocate.order(sql);
                fileChannel.read(allocate);
                this.sqm = allocate.getInt(0);
                z = a(fileChannel);
            } catch (Exception e2) {
                w.e("MicroMsg.Wepkg.WePkgReader", "parseHeader error, " + e2.getMessage());
            } finally {
                b(fileChannel);
            }
        }
        return z;
    }

    private boolean a(FileChannel fileChannel) {
        if (this.sqm <= 0) {
            return false;
        }
        try {
            fileChannel.position((long) sqk);
            ByteBuffer allocate = ByteBuffer.allocate(this.sqm);
            allocate.order(sql);
            fileChannel.read(allocate);
            byte[] array = allocate.array();
            if (array == null || array.length == 0) {
                return false;
            }
            this.sqo = new bmy();
            this.sqo.aD(array);
            this.sqp = this.sqo.ums;
            this.sqq = this.sqo.umt;
            this.gMv = this.sqo.msk;
            this.sqn = sqk + this.sqm;
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.Wepkg.WePkgReader", "dealProtoData error, " + e.getMessage());
            return false;
        }
    }

    private static void b(FileChannel fileChannel) {
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException e) {
            }
        }
    }
}
