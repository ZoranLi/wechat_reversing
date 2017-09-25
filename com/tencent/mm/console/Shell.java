package com.tencent.mm.console;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.e.a.gf;
import com.tencent.mm.e.a.ht;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;

public final class Shell {
    public static HashMap<String, a> gTK = new HashMap();
    public static IntentFilter gTL = new IntentFilter();
    private static Runnable gTM = new Runnable() {
        public final void run() {
            w.d("MicroMsg.Shell", "dkcrash begin tid:%d [%s]", Long.valueOf(Thread.currentThread().getId()), Thread.currentThread().getName());
            Object[] objArr = new Object[1];
            String str = null;
            objArr[0] = Integer.valueOf(str.length());
            w.d("MicroMsg.Shell", "%d ", objArr);
        }
    };
    public Receiver gTJ = null;

    public static class Receiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            a aVar = (a) Shell.gTK.get(intent.getAction());
            if (aVar == null) {
                w.e("MicroMsg.Shell", "no action found for %s", r1);
                return;
            }
            w.e("MicroMsg.Shell", "shell action %s", r1);
            aVar.m(intent);
        }
    }

    public interface a {
        void m(Intent intent);
    }

    static {
        a("wechat.shell.SET_NEXTRET", new a() {
            public final void m(Intent intent) {
                int intExtra = intent.getIntExtra(Columns.TYPE, Integer.MAX_VALUE);
                int intExtra2 = intent.getIntExtra("error", 0);
                if (intExtra != Integer.MAX_VALUE && intExtra2 != 0) {
                    w.w("MicroMsg.Shell", "kiro set Test.pushNextErrorRet(type=%d, err=%d)", Integer.valueOf(intExtra), Integer.valueOf(intExtra2));
                    r.bf(intExtra, intExtra2);
                }
            }
        });
        a("wechat.shell.SET_LOGLEVEL", new a() {
            public final void m(Intent intent) {
                int intExtra = intent.getIntExtra("level", 0);
                w.w("MicroMsg.Shell", "kiro set Log.level=%d", Integer.valueOf(w.getLogLevel()));
                w.yu(intExtra);
            }
        });
        a("wechat.shell.SET_CDNTRANS", new a() {
            public final void m(Intent intent) {
                r.iiQ = intent.getBooleanExtra(Columns.VALUE, false);
                w.w("MicroMsg.Shell", "kiro set Test.forceCDNTrans=%b", Boolean.valueOf(r.iiQ));
            }
        });
        a("wechat.shell.SET_DKTEST", new a() {
            public final void m(Intent intent) {
                r.iiW = intent.getIntExtra("key", 0);
                r.iiX = intent.getIntExtra("val", 0);
                r.iiY = intent.getStringExtra("str");
                w.w("MicroMsg.Shell", "dkshell set [%d %d] [%s]", Integer.valueOf(r.iiW), Integer.valueOf(r.iiX), r.iiY);
                if (10009 == r.iiW) {
                    int i = r.iiX;
                    Shell.sX();
                } else if (10014 == r.iiW && ab.bJb()) {
                    q.Hy().a(7, 1, "");
                } else if (10015 == r.iiW && ab.bJc()) {
                    b gfVar = new gf();
                    gfVar.fLw.type = 13;
                    com.tencent.mm.sdk.b.a.urY.m(gfVar);
                }
            }
        });
        a("wechat.shell.NET_DNS_TEST", new a() {
            public final void m(Intent intent) {
                r.iiV = intent.getIntExtra(Columns.VALUE, 0);
                w.w("MicroMsg.Shell", "dkdnstd set Test.netDnsSimulateFault=%s", Integer.toBinaryString(r.iiV));
            }
        });
        a("wechat.shell.IDC_ERROR", new a() {
            public final void m(Intent intent) {
                r.iiZ = intent.getStringExtra("errmsg");
                w.w("MicroMsg.Shell", "tiger set tigerIDCErrMsg =%s", r.iiZ);
            }
        });
        a("wechat.shell.SET_DK_WT_TEST", new a() {
            public final void m(Intent intent) {
                r.ija = intent.getStringExtra("acc");
                r.ijb = intent.getStringExtra("pass");
                w.w("MicroMsg.Shell", "dkwt shell [%s %s]", r.ija, r.ijb);
            }
        });
        a("wechat.shell.SET_MUTE_ROOM_TEST", new a() {
            public final void m(Intent intent) {
                r.ijC = intent.getIntExtra("flag", 0);
                w.w("MicroMsg.Shell", "dkwt shell [%d]", Integer.valueOf(r.ijC));
            }
        });
        a("wechat.shell.HOTPATCH_TEST", new a() {
            public final void m(Intent intent) {
                b htVar = new ht();
                htVar.fNn.fNs = intent.getExtras().getString("path", "/data/local/tmp/test.apk");
                w.w("MicroMsg.Shell", "hotpatch test [%s]", htVar.fNn.fNs);
                com.tencent.mm.sdk.b.a.urY.m(htVar);
            }
        });
        a("wechat.shell.EXEC_SQL", new a() {
            public final void m(Intent intent) {
                if (ab.bJb()) {
                    final String string = intent.getExtras().getString("sql", null);
                    if (string != null && string.length() != 0) {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 gTO;

                            public final void run() {
                                /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                                /*
                                r9 = this;
                                r1 = 0;
                                r2 = 0;
                                com.tencent.mm.u.ap.yY();
                                r0 = com.tencent.mm.u.c.wO();
                                r0 = r0.bNN();
                                r4 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r3 = com.tencent.wcdb.database.SQLiteDirectCursor.FACTORY;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = 0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r8 = 0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r1 = r0.rawQueryWithFactory(r3, r6, r7, r8);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = r1.getColumnNames();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                if (r6 != 0) goto L_0x008a;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0021:
                                r3 = r2;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0022:
                                r0 = "MicroMsg.Shell";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r8 = "Executing SQL from shell: ";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7.<init>(r8);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r8 = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = r7.append(r8);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = r7.toString();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                com.tencent.mm.sdk.platformtools.w.i(r0, r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                if (r3 <= 0) goto L_0x0059;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x003c:
                                r0 = "MicroMsg.Shell";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r8 = " > ";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7.<init>(r8);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r8 = " | ";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = android.text.TextUtils.join(r8, r6);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = r7.append(r6);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = r6.toString();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                com.tencent.mm.sdk.platformtools.w.i(r0, r6);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0059:
                                r6 = new java.lang.StringBuilder;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.<init>(r0);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0060:
                                r0 = r1.moveToNext();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                if (r0 == 0) goto L_0x00cc;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0066:
                                r0 = 0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.setLength(r0);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = " > ";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.append(r0);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = r2;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0071:
                                if (r0 >= r3) goto L_0x00c1;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0073:
                                r7 = r1.getType(r0);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                switch(r7) {
                                    case 0: goto L_0x008d;
                                    case 4: goto L_0x00b3;
                                    default: goto L_0x007a;
                                };	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x007a:
                                r7 = r1.getString(r0);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.append(r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x0081:
                                r7 = " | ";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.append(r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = r0 + 1;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                goto L_0x0071;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x008a:
                                r0 = r6.length;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r3 = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                goto L_0x0022;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x008d:
                                r7 = "(null)";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.append(r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                goto L_0x0081;
                            L_0x0094:
                                r0 = move-exception;
                                r2 = "MicroMsg.Shell";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r3 = "Failed to execute SQL '%s': %s";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r4 = 2;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r4 = new java.lang.Object[r4];	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5 = 0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r4[r5] = r6;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5 = 1;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = r0.getMessage();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r4[r5] = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                if (r1 == 0) goto L_0x00b2;
                            L_0x00af:
                                r1.close();
                            L_0x00b2:
                                return;
                            L_0x00b3:
                                r7 = "(blob)";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6.append(r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                goto L_0x0081;
                            L_0x00ba:
                                r0 = move-exception;
                                if (r1 == 0) goto L_0x00c0;
                            L_0x00bd:
                                r1.close();
                            L_0x00c0:
                                throw r0;
                            L_0x00c1:
                                r0 = "MicroMsg.Shell";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r7 = r6.toString();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                com.tencent.mm.sdk.platformtools.w.i(r0, r7);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                goto L_0x0060;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                            L_0x00cc:
                                r2 = java.lang.System.currentTimeMillis();	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r2 = r2 - r4;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r0 = "MicroMsg.Shell";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r4 = "Finish executing SQL in %d ms: %s";	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5 = 2;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5 = new java.lang.Object[r5];	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r6 = 0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r2 = java.lang.Long.valueOf(r2);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5[r6] = r2;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r2 = 1;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r3 = r0;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                r5[r2] = r3;	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                com.tencent.mm.sdk.platformtools.w.i(r0, r4, r5);	 Catch:{ RuntimeException -> 0x0094, all -> 0x00ba }
                                if (r1 == 0) goto L_0x00b2;
                            L_0x00eb:
                                r1.close();
                                goto L_0x00b2;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.Shell.2.1.run():void");
                            }
                        });
                    }
                }
            }
        });
    }

    public static void sX() {
    }

    private static void a(String str, a aVar) {
        gTL.addAction(str);
        gTK.put(str, aVar);
    }
}
