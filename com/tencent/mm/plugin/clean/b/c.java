package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements com.tencent.mm.plugin.clean.b.a.a.a, Runnable {
    public static final Long kyu = Long.valueOf(604800000);
    public static final Long kyv = Long.valueOf(7776000000L);
    public static final int kyw = (com.tencent.mm.u.c.xv().length() - 1);
    private long endTime = 0;
    private ae hgN = new ae(Looper.getMainLooper());
    public boolean isStop;
    public int kyA = 0;
    public ConcurrentHashMap<String, b> kyB = new ConcurrentHashMap();
    public long kyC;
    public long kyD;
    public boolean kyE = true;
    public int[] kyF = new int[10];
    private com.tencent.mm.plugin.clean.b.a.b kyx;
    public f kyy;
    public int kyz = 0;
    private long startTime = 0;

    public class a extends com.tencent.mm.plugin.clean.b.a.a {
        final /* synthetic */ c kyH;
        private String username;

        public a(c cVar, String str) {
            this.kyH = cVar;
            super(cVar);
            this.username = str;
        }

        public final String KO() {
            return "username[" + this.username + "]" + super.KO();
        }

        public final void execute() {
            Throwable e;
            Cursor cursor;
            ap.yY();
            int AA = com.tencent.mm.u.c.wT().AA(this.username);
            if (AA <= 0) {
                w.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d]", new Object[]{this.username, Integer.valueOf(AA)});
                return;
            }
            int a;
            b bVar = new b();
            bVar.username = this.username;
            bVar.kyt = new ArrayList();
            bVar.fLh = 0;
            Cursor cursor2 = null;
            int i = 0;
            while (i < AA) {
                try {
                    ap.yY();
                    cursor2 = com.tencent.mm.u.c.wT().E(this.username, i, 50);
                    if (cursor2 == null) {
                        break;
                    }
                    a = a(cursor2, bVar);
                    if (!(cursor2 == null || cursor2.isClosed())) {
                        cursor2.close();
                    }
                    if (a <= 0) {
                        break;
                    }
                    i += a;
                    if (this.kyH.isStop) {
                        break;
                    }
                } catch (Throwable e2) {
                    Throwable th = e2;
                    a = i;
                    cursor = cursor2;
                    w.printErrStackTrace("MicroMsg.CleanController", th, "execute analyse Task error.", new Object[0]);
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    e2 = th2;
                    cursor2 = cursor;
                }
            }
            a = i;
            if (cursor2 != null) {
                cursor2.close();
            }
            if (bVar.kyt.size() > 0) {
                this.kyH.kyB.put(this.username, bVar);
            }
            w.i("MicroMsg.CleanController", "Finish user:%s allMsgCount[%d] alreadyHandleCount[%d] isStop[%b] ", new Object[]{this.username, Integer.valueOf(AA), Integer.valueOf(a), Boolean.valueOf(this.kyH.isStop)});
            return;
            if (cursor2 != null) {
                cursor2.close();
            }
            throw e2;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private int a(android.database.Cursor r14, com.tencent.mm.plugin.clean.b.b r15) {
            /*
            r13 = this;
            r1 = 0;
            r0 = r14.moveToFirst();
            if (r0 != 0) goto L_0x001d;
        L_0x0007:
            r0 = "MicroMsg.CleanController";
            r1 = "Message count of user:%s is empty";
            r2 = 1;
            r2 = new java.lang.Object[r2];
            r3 = 0;
            r4 = r13.username;
            r2[r3] = r4;
            com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);
            r14.close();
            r10 = 0;
        L_0x001c:
            return r10;
        L_0x001d:
            r0 = 0;
        L_0x001e:
            r2 = r14.isAfterLast();
            if (r2 != 0) goto L_0x0188;
        L_0x0024:
            r10 = r1 + 1;
            r11 = new com.tencent.mm.storage.au;
            r11.<init>();
            r11.b(r14);
            r1 = r11.field_type;
            r1 = com.tencent.mm.pluginsdk.model.app.l.xb(r1);
            switch(r1) {
                case 3: goto L_0x005d;
                case 43: goto L_0x0180;
                case 44: goto L_0x0180;
                case 49: goto L_0x0056;
                case 62: goto L_0x0180;
                default: goto L_0x0037;
            };
        L_0x0037:
            if (r0 == 0) goto L_0x0046;
        L_0x0039:
            r1 = r15.kyt;
            r1.add(r0);
            r2 = r15.fLh;
            r0 = r0.size;
            r0 = r0 + r2;
            r15.fLh = r0;
            r0 = 0;
        L_0x0046:
            r1 = r14.moveToNext();
            if (r1 == 0) goto L_0x0052;
        L_0x004c:
            r1 = r13.kyH;
            r1 = r1.isStop;
            if (r1 == 0) goto L_0x018b;
        L_0x0052:
            r14.close();
            goto L_0x001c;
        L_0x0056:
            r0 = r13.username;
            r0 = com.tencent.mm.plugin.clean.b.c.a(r11, r0);
            goto L_0x0037;
        L_0x005d:
            r5 = r13.username;
            r0 = com.tencent.mm.ah.n.GS();
            r1 = r11.field_imgPath;
            r2 = 1;
            r2 = r0.v(r1, r2);
            r0 = r11.field_isSend;
            r1 = 1;
            if (r0 != r1) goto L_0x0083;
        L_0x006f:
            r0 = com.tencent.mm.ah.n.GS();
            r6 = r11.field_msgId;
            r1 = (int) r6;
            r6 = (long) r1;
            r0 = r0.aj(r6);
            r6 = r0.hEY;
            r8 = 0;
            r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
            if (r1 != 0) goto L_0x008d;
        L_0x0083:
            r0 = com.tencent.mm.ah.n.GS();
            r6 = r11.field_msgSvrId;
            r0 = r0.ai(r6);
        L_0x008d:
            r1 = 0;
            r3 = r11.field_isSend;
            r4 = 1;
            if (r3 != r4) goto L_0x00e1;
        L_0x0093:
            r3 = com.tencent.mm.ah.n.GS();
            r0 = r0.hEZ;
            r4 = "";
            r6 = "";
            r3 = r3.m(r0, r4, r6);
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
            if (r0 != 0) goto L_0x00de;
        L_0x00a9:
            r0 = com.tencent.mm.a.e.aO(r3);
            if (r0 == 0) goto L_0x00de;
        L_0x00af:
            r0 = "MicroMsg.CleanController";
            r1 = new java.lang.StringBuilder;
            r4 = "bigImgPath ";
            r1.<init>(r4);
            r1 = r1.append(r3);
            r4 = " ";
            r1 = r1.append(r4);
            r4 = com.tencent.mm.a.e.aN(r3);
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.v(r0, r1);
            r1 = new com.tencent.mm.plugin.clean.b.a;
            r4 = 1;
            r6 = r11.field_msgId;
            r8 = r11.field_createTime;
            r1.<init>(r2, r3, r4, r5, r6, r8);
        L_0x00de:
            r0 = r1;
            goto L_0x0037;
        L_0x00e1:
            r3 = r0.GA();
            if (r3 == 0) goto L_0x00de;
        L_0x00e7:
            r3 = com.tencent.mm.ah.n.GS();
            r4 = r0.hEZ;
            r6 = "";
            r7 = "";
            r12 = r3.m(r4, r6, r7);
            r3 = "";
            r4 = r0.GB();
            if (r4 == 0) goto L_0x015f;
        L_0x0100:
            r4 = r0.GB();
            if (r4 == 0) goto L_0x017e;
        L_0x0106:
            r4 = com.tencent.mm.ah.n.GS();
            r6 = r0.hFi;
            r4 = r4.fT(r6);
            if (r4 == 0) goto L_0x017e;
        L_0x0112:
            if (r4 == 0) goto L_0x015f;
        L_0x0114:
            r0 = r4.equals(r0);
            if (r0 != 0) goto L_0x015f;
        L_0x011a:
            r0 = com.tencent.mm.ah.n.GS();
            r3 = r4.hEZ;
            r4 = "";
            r6 = "";
            r3 = r0.m(r3, r4, r6);
            r0 = "MicroMsg.CleanController";
            r4 = new java.lang.StringBuilder;
            r6 = "hdPath ";
            r4.<init>(r6);
            r4 = r4.append(r3);
            r6 = " ";
            r4 = r4.append(r6);
            r6 = com.tencent.mm.a.e.aN(r3);
            r4 = r4.append(r6);
            r4 = r4.toString();
            com.tencent.mm.sdk.platformtools.w.v(r0, r4);
            r0 = com.tencent.mm.a.e.aO(r3);
            if (r0 == 0) goto L_0x015f;
        L_0x0155:
            r1 = new com.tencent.mm.plugin.clean.b.a;
            r4 = 1;
            r6 = r11.field_msgId;
            r8 = r11.field_createTime;
            r1.<init>(r2, r3, r4, r5, r6, r8);
        L_0x015f:
            r0 = com.tencent.mm.a.e.aO(r12);
            if (r0 == 0) goto L_0x00de;
        L_0x0165:
            r0 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
            if (r0 != 0) goto L_0x00de;
        L_0x016b:
            r0 = r12.equals(r3);
            if (r0 != 0) goto L_0x00de;
        L_0x0171:
            r1 = new com.tencent.mm.plugin.clean.b.a;
            r4 = 1;
            r6 = r11.field_msgId;
            r8 = r11.field_createTime;
            r3 = r12;
            r1.<init>(r2, r3, r4, r5, r6, r8);
            goto L_0x00de;
        L_0x017e:
            r4 = r0;
            goto L_0x0112;
        L_0x0180:
            r0 = r13.username;
            r0 = com.tencent.mm.plugin.clean.b.c.b(r11, r0);
            goto L_0x0037;
        L_0x0188:
            r10 = r1;
            goto L_0x0052;
        L_0x018b:
            r1 = r10;
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.b.c.a.a(android.database.Cursor, com.tencent.mm.plugin.clean.b.b):int");
        }
    }

    class b extends com.tencent.mm.plugin.clean.b.a.a {
        private String filePath;
        private long fileSize;
        final /* synthetic */ c kyH;
        int kyI = 0;

        public b(c cVar, String str) {
            this.kyH = cVar;
            super(cVar);
            this.filePath = str;
            this.fileSize = 0;
        }

        public final String KO() {
            return "filePath[" + this.filePath + "] scanCount[" + this.kyI + "]" + super.KO();
        }

        public final void execute() {
            int[] iArr;
            if (tw(this.filePath) && this.kyH.kyE) {
                w.i("MicroMsg.CleanController", "Delete[%b] temp folder: %s ", new Object[]{Boolean.valueOf(this.kyH.kyE), this.filePath});
                tv(this.filePath);
                File parentFile = new File(this.filePath).getParentFile();
                if (parentFile.list() == null || parentFile.list().length == 0) {
                    parentFile.delete();
                }
            } else {
                tx(this.filePath);
            }
            if (tw(this.filePath)) {
                iArr = this.kyH.kyF;
                iArr[1] = (int) (((long) iArr[1]) + this.fileSize);
            } else {
                String str = this.filePath;
                ap.yY();
                if (str.startsWith(com.tencent.mm.u.c.xv())) {
                    iArr = this.kyH.kyF;
                    iArr[0] = (int) (((long) iArr[0]) + this.fileSize);
                } else {
                    iArr = this.kyH.kyF;
                    iArr[2] = (int) (((long) iArr[2]) + this.fileSize);
                }
            }
            if (this.filePath.endsWith(File.separator + "image2")) {
                iArr = this.kyH.kyF;
                iArr[3] = (int) (((long) iArr[3]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                iArr = this.kyH.kyF;
                iArr[4] = (int) (((long) iArr[4]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                iArr = this.kyH.kyF;
                iArr[5] = (int) (((long) iArr[5]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "voice2")) {
                iArr = this.kyH.kyF;
                iArr[6] = (int) (((long) iArr[6]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "WeiXin")) {
                iArr = this.kyH.kyF;
                iArr[7] = (int) (((long) iArr[7]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "WeChat")) {
                iArr = this.kyH.kyF;
                iArr[8] = (int) (((long) iArr[8]) + this.fileSize);
            }
            if (this.filePath.endsWith(File.separator + "xlog")) {
                iArr = this.kyH.kyF;
                iArr[9] = (int) (((long) iArr[9]) + this.fileSize);
            }
        }

        private void tv(String str) {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str2 : list) {
                        tv(str + File.separator + str2);
                    }
                }
                w.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
                file.delete();
                return;
            }
            w.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
            this.kyH.kyC += file.length();
            file.delete();
        }

        private static boolean tw(String str) {
            if (str.length() <= c.kyw || str.substring(c.kyw).indexOf("temp") != 0) {
                return false;
            }
            return true;
        }

        private void tx(String str) {
            int i = 0;
            this.kyI++;
            if (str.endsWith(File.separator + "sns")) {
                w.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[]{str});
                ty(str);
            } else if (str.endsWith(File.separator + "music")) {
                w.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[]{str});
                tz(str);
            } else {
                File file = new File(str);
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null) {
                        int length = list.length;
                        while (i < length) {
                            tx(str + "/" + list[i]);
                            i++;
                        }
                        return;
                    }
                    return;
                }
                i = e.aN(str);
                this.kyH.aO((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            }
        }

        private void ty(String str) {
            int i = 0;
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        ty(str + "/" + list[i]);
                        i++;
                    }
                }
            } else if (System.currentTimeMillis() - file.lastModified() <= c.kyu.longValue() || !this.kyH.kyE) {
                i = e.aN(str);
                this.kyH.aO((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            } else {
                w.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
                file.delete();
            }
        }

        private void tz(String str) {
            int i = 0;
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        tz(str + "/" + list[i]);
                        i++;
                    }
                }
            } else if (System.currentTimeMillis() - file.lastModified() <= c.kyv.longValue() || !this.kyH.kyE) {
                i = e.aN(str);
                this.kyH.aO((long) i);
                this.fileSize = ((long) i) + this.fileSize;
            } else {
                w.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[]{str});
                file.delete();
            }
        }
    }

    static {
        ap.yY();
    }

    public c(com.tencent.mm.plugin.clean.b.a.b bVar, f fVar) {
        this.kyy = fVar;
        this.kyx = bVar;
    }

    public final void run() {
        int i;
        w.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        long NA = bg.NA();
        String str = com.tencent.mm.compatible.util.e.hgu;
        w.v("MicroMsg.CleanController", "root path: %s", new Object[]{str});
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str3 = str + str2;
                    if (str2.length() >= 32) {
                        w.v("MicroMsg.CleanController", "add subfile list: %s", new Object[]{str2});
                        Collection tu = tu(str3);
                        if (arrayList.size() > 0) {
                            arrayList.addAll(0, tu);
                        } else {
                            arrayList.addAll(tu);
                        }
                    } else {
                        w.v("MicroMsg.CleanController", "subfile: %s", new Object[]{str2});
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str3);
                        } else {
                            arrayList.add(str3);
                        }
                    }
                }
            }
        } else {
            aO((long) e.aN(str));
        }
        int i2 = -1;
        int i3 = -1;
        for (i = 0; i < arrayList.size(); i++) {
            String str4 = (String) arrayList.get(i);
            if (str4.contains("image2")) {
                i2 = i;
            }
            if (str4.contains("voice2")) {
                i3 = i;
            }
        }
        if (i3 != -1) {
            arrayList.add(0, (String) arrayList.remove(i3));
        }
        if (i2 != -1) {
            arrayList.add(0, (String) arrayList.remove(i2));
        }
        w.d("MicroMsg.CleanController", "scan is finish [%s]", new Object[]{Long.valueOf(bg.aB(NA))});
        long NA2 = bg.NA();
        ArrayList ajJ = ajJ();
        w.d("MicroMsg.CleanController", "user is finish [%s]", new Object[]{Long.valueOf(bg.aB(NA2))});
        this.kyz = arrayList.size() + ajJ.size();
        if (this.kyz == 0) {
            w.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            ajG();
            return;
        }
        w.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[]{Integer.valueOf(this.kyz)});
        i = 0;
        while (!this.isStop && i < arrayList.size()) {
            w.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), (String) arrayList.get(i)});
            com.tencent.mm.plugin.clean.b.a.a bVar = new b(this, str4);
            while (!this.kyx.b(bVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e) {
                }
            }
            w.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[]{str4});
            i++;
        }
        i = 0;
        while (!this.isStop && i < ajJ.size()) {
            w.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[]{Integer.valueOf(i), (String) ajJ.get(i)});
            bVar = new a(this, str4);
            while (!this.kyx.b(bVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e2) {
                }
            }
            w.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[]{str4});
            i++;
        }
    }

    public final void a(com.tencent.mm.plugin.clean.b.a.a aVar) {
        if (aVar instanceof a) {
            w.d("MicroMsg.CleanController", "AnalyseTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.KO()});
        } else {
            w.d("MicroMsg.CleanController", "ScanSpaceTask is finish [%d] cost[%s]", new Object[]{Integer.valueOf(aVar.hashCode()), aVar.KO()});
        }
        com.tencent.mm.sdk.f.e.O(this);
        this.kyA++;
        if (!(this.kyy == null || this.isStop)) {
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ c kyH;

                {
                    this.kyH = r1;
                }

                public final void run() {
                    this.kyH.kyy.bL(this.kyH.kyA, this.kyH.kyz);
                }
            });
        }
        if (this.kyA == this.kyz) {
            ajG();
        }
    }

    private void ajG() {
        this.endTime = System.currentTimeMillis();
        w.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.kyy != null && !this.isStop) {
            final Object arrayList = new ArrayList();
            for (b add : this.kyB.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ c kyH;

                public final void run() {
                    this.kyH.kyy.a(this.kyH.kyC, this.kyH.kyD, arrayList);
                }
            });
        }
    }

    public static long ajH() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.hgs);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long ajI() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.hgs);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static a a(au auVar, String str) {
        com.tencent.mm.t.f.a ek;
        String PX = bg.PX(auVar.field_content);
        if (PX != null) {
            ek = com.tencent.mm.t.f.a.ek(PX);
        } else {
            ek = null;
        }
        if (ek == null) {
            w.e("MicroMsg.CleanController", "content is null");
            return null;
        }
        String v = n.GS().v(auVar.field_imgPath, true);
        com.tencent.mm.pluginsdk.model.app.b LW;
        switch (ek.type) {
            case 2:
                LW = an.abL().LW(ek.fCW);
                if ((LW == null || !LW.azf()) && (auVar.field_isSend != 1 || LW == null || !LW.field_isUpload)) {
                    return null;
                }
                String str2 = LW.field_fileFullPath;
                if (!e.aO(str2)) {
                    return null;
                }
                w.v("MicroMsg.CleanController", "image " + str2);
                return new a(v, str2, 1, str, auVar.field_msgId, auVar.field_createTime);
            case 6:
                LW = an.abL().LW(ek.fCW);
                if ((LW == null || !LW.azf()) && (auVar.field_isSend != 1 || LW == null || !LW.field_isUpload)) {
                    return null;
                }
                w.v("MicroMsg.CleanController", "full path " + LW.field_fileFullPath);
                if (!e.aO(LW.field_fileFullPath)) {
                    return null;
                }
                return new a(v, LW.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            case 7:
                LW = an.abL().LW(ek.fCW);
                if ((LW == null || !LW.azf()) && (auVar.field_isSend != 1 || LW == null || !LW.field_isUpload)) {
                    return null;
                }
                w.v("MicroMsg.CleanController", "full path " + LW.field_fileFullPath);
                if (!e.aO(LW.field_fileFullPath)) {
                    return null;
                }
                return new a(v, LW.field_fileFullPath, 4, str, auVar.field_msgId, auVar.field_createTime);
            default:
                return null;
        }
    }

    public static a b(au auVar, String str) {
        o.KV();
        String lv = s.lv(auVar.field_imgPath);
        String str2 = auVar.field_imgPath;
        if (!bg.mA(str2)) {
            o.KV().ls(str2);
        }
        o.KV();
        String lw = s.lw(auVar.field_imgPath);
        if (!new File(lv).exists()) {
            return null;
        }
        return new a(lw, lv, 3, str, auVar.field_msgId, auVar.field_createTime);
    }

    private static ArrayList<String> ajJ() {
        ArrayList<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (Object add : com.tencent.mm.u.o.hly) {
            linkedList.add(add);
        }
        ap.yY();
        Cursor c = com.tencent.mm.u.c.wW().c(com.tencent.mm.u.o.hlr, linkedList, "*");
        if (c.moveToFirst()) {
            do {
                aj aeVar = new com.tencent.mm.storage.ae();
                aeVar.b(c);
                if (!bg.mA(aeVar.field_username)) {
                    ap.yY();
                    if (!x.yC(com.tencent.mm.u.c.wR().Rc(aeVar.field_username).field_verifyFlag)) {
                        arrayList.add(aeVar.field_username);
                    }
                }
                if (!c.moveToNext()) {
                    break;
                }
            } while (!c.isAfterLast());
        }
        c.close();
        return arrayList;
    }

    private static ArrayList<String> tu(String str) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + File.separator + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        return arrayList;
    }

    public final synchronized void aO(long j) {
        if (j < 0) {
            w.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", new Object[]{Long.valueOf(j)});
            this.kyD += 60;
        } else {
            this.kyD += j;
        }
    }
}
