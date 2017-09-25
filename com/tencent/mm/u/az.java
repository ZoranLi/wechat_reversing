package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public final class az {
    public static final Queue<Integer> hnd = new ConcurrentLinkedQueue();
    public static final long[] hne = new long[]{5000, 10000, 30000, 60000, 180000, 300000, 600000, 900000, 1800000, 3600000, 10800000, 21600000, 43200000, 86400000};
    private static final int[] hnf = new int[]{0, 1, 2, 3, 11, 12, 13, 4, 5, 6, 7, 8, 9, 10};
    public static final int[] hng = new int[]{0, 1, 2, 3, 7, 8, 9, 10, 11, 12, 13};
    public static final int[] hnh = new int[]{4, 5, 6};
    private static long hni = 0;
    public static volatile boolean hnj = false;
    public static int[] hnk = new int[hne.length];
    private static long hnl = 0;
    public static volatile boolean hnm = false;

    private static class a {
        long hnn = 0;
        int[] hno = new int[az.hne.length];

        a(long j, int[] iArr) {
            for (int i = 0; i < this.hno.length; i++) {
                this.hno[i] = 0;
            }
            this.hnn = j;
            if (iArr != null) {
                System.arraycopy(iArr, 0, this.hno, 0, iArr.length);
            }
        }

        final void e(int[] iArr) {
            if (iArr != null && this.hno.length == iArr.length) {
                for (int i = 0; i < this.hno.length; i++) {
                    int[] iArr2 = this.hno;
                    iArr2[i] = iArr2[i] + iArr[i];
                }
            }
        }

        final String zv() {
            String str = null;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("firstTime", this.hnn);
                JSONArray jSONArray = new JSONArray();
                if (this.hno != null) {
                    for (int put : this.hno) {
                        jSONArray.put(put);
                    }
                }
                jSONObject.put("counter", jSONArray);
                str = jSONObject.toString();
            } catch (Exception e) {
                w.e("MicroMsg.MsgReporter", "error:" + e.getMessage());
            }
            return str;
        }

        public final boolean zw() {
            for (int i : this.hno) {
                if (i > 0) {
                    return true;
                }
            }
            return false;
        }

        static a go(String str) {
            a aVar;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.has("firstTime")) {
                    return null;
                }
                int[] iArr;
                long j = jSONObject.getLong("firstTime");
                if (jSONObject.has("counter") && (jSONObject.get("counter") instanceof JSONArray)) {
                    JSONArray jSONArray = jSONObject.getJSONArray("counter");
                    int length = jSONArray.length();
                    if (length != az.hne.length) {
                        return null;
                    }
                    int[] iArr2 = new int[length];
                    for (int i = 0; i < length; i++) {
                        iArr2[i] = jSONArray.getInt(i);
                    }
                    iArr = iArr2;
                } else {
                    iArr = null;
                }
                aVar = new a(j, iArr);
                return aVar;
            } catch (Exception e) {
                w.e("MicroMsg.MsgReporter", "error:" + e.getMessage());
                aVar = null;
            }
        }

        final String zx() {
            StringBuilder stringBuilder = new StringBuilder();
            try {
                stringBuilder.append(0);
                stringBuilder.append(",");
                for (int i : az.hng) {
                    stringBuilder.append(this.hno[i]);
                    stringBuilder.append(",");
                }
                stringBuilder.append(this.hnn / 1000);
                stringBuilder.append(",");
                for (int i2 : az.hnh) {
                    stringBuilder.append(this.hno[i2]);
                    stringBuilder.append(",");
                }
                stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MsgReporter", e, null, new Object[0]);
            }
            return stringBuilder.toString();
        }
    }

    private static class b implements Runnable {
        public final void run() {
            boolean th;
            boolean z = false;
            while (!az.hnd.isEmpty()) {
                try {
                    com.tencent.mm.plugin.report.c.oTb.a(592, (long) ((Integer) az.hnd.poll()).intValue(), 1, false);
                } catch (Throwable th2) {
                    th = th2;
                    w.printErrStackTrace("MicroMsg.MsgReporter", th, "", new Object[0]);
                    return;
                } finally {
                    z = 
/*
Method generation error in method: com.tencent.mm.u.az.b.run():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r9_2 'z' boolean) = (r9_0 'z' boolean), (r0_8 'th' boolean) in method: com.tencent.mm.u.az.b.run():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:217)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.addInnerClasses(ClassGen.java:241)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 28 more

*/
                }

                private static class c implements Runnable {
                    final long hnp;

                    c(long j) {
                        this.hnp = j;
                    }

                    public final void run() {
                        try {
                            a aVar;
                            h.vJ();
                            Object obj = h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_MSG_DELAY_STAT_STRING, null);
                            if (obj == null) {
                                aVar = new a(this.hnp, az.hnk);
                                obj = aVar.zv();
                                if (obj == null) {
                                    az.hnm = false;
                                    return;
                                }
                                w.i("MicroMsg.MsgReporter", "[oneliang]kv stat json need to add first:" + obj);
                            } else {
                                aVar = a.go(obj.toString());
                                if (aVar == null) {
                                    az.hnm = false;
                                    az.hnm = false;
                                    return;
                                }
                                aVar.e(az.hnk);
                                obj = aVar.zv();
                                w.i("MicroMsg.MsgReporter", "[oneliang]kv stat json when update:" + obj);
                            }
                            h.vJ();
                            h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_MSG_DELAY_STAT_STRING, obj);
                            az.zt();
                            if (aVar != null && aVar.zw() && this.hnp - aVar.hnn >= 86400000) {
                                String zx = aVar.zx();
                                w.i("MicroMsg.MsgReporter", "[oneliang]report kv string:" + zx);
                                Object zv = new a(this.hnp, null).zv();
                                w.i("MicroMsg.MsgReporter", "[oneliang]need to reset kv stat counter,reset json:" + zv);
                                h.vJ();
                                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_MSG_DELAY_STAT_STRING, zv);
                                h.vJ();
                                h.vI().vr().jY(true);
                                com.tencent.mm.plugin.report.c.oTb.A(14331, zx);
                            }
                            az.hnm = false;
                            az.hnm = false;
                        } catch (Throwable th) {
                            w.printErrStackTrace("MicroMsg.MsgReporter", th, "", new Object[0]);
                        } finally {
                            az.hnm = false;
                        }
                    }
                }

                static {
                    zt();
                }

                public static void zt() {
                    for (int i = 0; i < hnk.length; i++) {
                        hnk[i] = 0;
                    }
                }

                private static long zu() {
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        h.vJ();
                        Object obj = h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, null);
                        if (obj == null) {
                            return 0;
                        }
                        return currentTimeMillis - bg.getLong(obj.toString(), 0);
                    } catch (Throwable th) {
                        w.printErrStackTrace("MicroMsg.MsgReporter", th, "", new Object[0]);
                        return 0;
                    }
                }

                public static void k(String str, long j) {
                    if (str != null) {
                        if (!str.endsWith("@chatroom") || ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str).gkz != 0) {
                            long zu = zu();
                            if (zu <= 0) {
                                w.i("MicroMsg.MsgReporter", "[oneliang]current server time is 0l,then return");
                                return;
                            }
                            w.i("MicroMsg.MsgReporter", "[oneliang]current svr time:%s, msg svr time:%s, intervalTime:%s", Long.valueOf(zu), Long.valueOf(j), Long.valueOf(zu - j));
                            for (int length = hne.length - 1; length >= 0; length--) {
                                if (r4 >= hne[length]) {
                                    hnd.add(Integer.valueOf(hnf[length]));
                                    hnk[length] = hnk[length] + 1;
                                    break;
                                }
                            }
                            long j2 = zu - hni;
                            if (!hnj && (hnd.size() >= 10 || j2 >= 900000)) {
                                w.i("MicroMsg.MsgReporter", "[oneliang]need to report,size:%s,last time:%s,report interval time:%s", Integer.valueOf(hnd.size()), Long.valueOf(hni), Long.valueOf(j2));
                                hnj = true;
                                e.b(new b(), "msg_delay_idkey_report", 1);
                                hni = zu;
                            }
                            j2 = zu - hnl;
                            if (!hnm && j2 >= 900000) {
                                w.i("MicroMsg.MsgReporter", "[oneliang]need to kv stat and report,last time:%s,report interval time:%s", Long.valueOf(hnl), Long.valueOf(j2));
                                hnm = true;
                                e.b(new c(zu), "msg_delay_kv_stat_and_report", 1);
                                hnl = zu;
                            }
                        }
                    }
                }
            }
