package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.pluginsdk.j.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f {
    public static final ByteOrder iyH = ByteOrder.BIG_ENDIAN;
    private volatile int akP = -1;
    private final File iyI;
    private volatile FileChannel iyJ = null;
    volatile boolean iyK = true;
    private volatile int iyL = 0;
    private volatile int iyM = 0;
    private volatile int iyN = -1;
    private volatile Map<String, a> iyO = null;

    public static final class a {
        public final String fyF;
        public final int iyP;
        public final int iyQ;

        public a(String str, int i, int i2) {
            this.fyF = str;
            this.iyP = i;
            this.iyQ = i2;
        }
    }

    f(File file) {
        int i;
        boolean z = true;
        this.iyI = file;
        if (this.iyI == null || !this.iyI.exists()) {
            i = 0;
        } else if (this.iyI.length() <= 14) {
            i = 0;
        } else {
            boolean z2 = true;
        }
        if (i == 0 || !Qi()) {
            z = false;
        }
        this.iyK = z;
    }

    public final void close() {
        if (this.iyJ != null) {
            try {
                this.iyJ.close();
                this.iyJ = null;
            } catch (IOException e) {
            }
        }
    }

    final InputStream nC(String str) {
        int i = 0;
        if (this.iyO == null || bg.mA(str)) {
            String str2 = "MicroMsg.AppBrandWxaPkg";
            String str3 = "openReadFile, mFileMap null = %b, mFileMap size = %d, fileName = %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.iyO == null);
            if (this.iyO != null) {
                i = this.iyO.size();
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = str;
            w.e(str2, str3, objArr);
            return null;
        }
        a aVar = (a) this.iyO.get(a.nA(str));
        if (aVar == null) {
            return null;
        }
        try {
            ByteBuffer map = this.iyJ.map(MapMode.READ_ONLY, (long) aVar.iyP, (long) aVar.iyQ);
            map.order(iyH);
            map.limit(aVar.iyQ);
            return new c(map);
        } catch (Throwable e) {
            w.e("MicroMsg.AppBrandWxaPkg", "openReadFile, fileName = %s, fileOffset = %d, fileLength = %d, exp = %s", new Object[]{r10, Integer.valueOf(aVar.iyP), Integer.valueOf(aVar.iyQ), bg.g(e)});
            return null;
        }
    }

    final boolean Qg() {
        if (!this.iyK || this.iyJ == null || this.iyL <= 4) {
            w.e("MicroMsg.AppBrandWxaPkg", "readInfo, valid = %b, (null == mFileChannel) = %b, mBodyInfoLength = %d, skip", new Object[]{Boolean.valueOf(this.iyK), this.iyJ, Integer.valueOf(this.iyM)});
            return false;
        } else if (this.iyO != null && this.iyN >= 0 && this.iyN == this.iyO.size()) {
            return true;
        } else {
            try {
                this.iyJ.position(14);
                ByteBuffer allocate = ByteBuffer.allocate(this.iyL);
                allocate.order(iyH);
                this.iyJ.read(allocate);
                byte[] array = allocate.array();
                this.iyN = a.n(array, 0);
                Map aVar = new android.support.v4.e.a();
                a aVar2 = null;
                int i = 4;
                for (int i2 = 0; i2 < this.iyN; i2++) {
                    int n = a.n(array, i);
                    i += 4;
                    String str = new String(array, i, n);
                    i += n;
                    int n2 = a.n(array, i);
                    i += 4;
                    int n3 = a.n(array, i);
                    i += 4;
                    aVar2 = new a(str, n2, n3);
                    aVar.put(str, aVar2);
                }
                this.iyO = aVar;
                if (aVar2 == null || ((long) (aVar2.iyP + aVar2.iyQ)) <= this.iyI.length()) {
                    return true;
                }
                w.e("MicroMsg.AppBrandWxaPkg", "readInfo, lastFileOffset(%d) + lastFileLength(%d) > totalFileLength(%d)", new Object[]{Integer.valueOf(aVar2.iyP), Integer.valueOf(aVar2.iyQ), Long.valueOf(this.iyI.length())});
                return false;
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrandWxaPkg", "readInfo, exp = %s", new Object[]{bg.g(e)});
                return false;
            }
        }
    }

    final List<a> Qh() {
        List<a> linkedList = new LinkedList();
        for (a add : this.iyO.values()) {
            linkedList.add(add);
        }
        return linkedList;
    }

    private boolean Qi() {
        if (this.iyJ == null) {
            try {
                this.iyJ = new RandomAccessFile(this.iyI, "r").getChannel();
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrandWxaPkg", "open(), exp = %s", new Object[]{bg.g(e)});
            }
        }
        if (this.iyJ == null) {
            return false;
        }
        try {
            this.iyJ.position(0);
            ByteBuffer allocate = ByteBuffer.allocate(14);
            allocate.order(iyH);
            this.iyJ.read(allocate);
            if ((byte) -66 != allocate.get(0) || (byte) -19 != allocate.get(13)) {
                return false;
            }
            byte[] array = allocate.array();
            this.akP = a.n(array, 1);
            this.iyL = a.n(array, 5);
            this.iyM = a.n(array, 9);
            return true;
        } catch (Throwable e2) {
            w.e("MicroMsg.AppBrandWxaPkg", "parseHeader, exp = %s", new Object[]{bg.g(e2)});
        }
    }
}
