package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.KVStatHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Vector;
import junit.framework.Assert;

public final class j {
    private static Vector<WeakReference<a>> hrd = new Vector();
    public static LinkedList<a> ihK = new LinkedList();

    public interface a {
        void k(String str, Bitmap bitmap);
    }

    private enum b {
        ;
        
        private static DisplayMetrics ihQ;
        private Map<String, c> ihM;
        private Map<String, WeakReference<Bitmap>> ihN;
        private ar ihO;
        private ar ihP;

        static class c {
            boolean ihU;
            int ihV;
            int ihW;

            c() {
            }

            public final String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("fail[").append(this.ihU).append("],");
                stringBuilder.append("tryTimes[").append(this.ihV).append("],");
                stringBuilder.append("lastTS[").append(this.ihW).append("]");
                return stringBuilder.toString();
            }
        }

        private static class a implements com.tencent.mm.sdk.platformtools.ar.a {
            private Bitmap hqW;
            private int ihS;
            private i ihT;

            public a(i iVar) {
                this.ihS = 0;
                this.hqW = null;
                if (j.b(iVar)) {
                    this.ihT = iVar;
                    return;
                }
                throw new IllegalArgumentException("from net, picture strategy here must be validity");
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean Bn() {
                /*
                r12 = this;
                r1 = 0;
                r11 = 0;
                r10 = 1;
                r0 = r12.ihT;
                if (r0 != 0) goto L_0x0011;
            L_0x0007:
                r0 = "MicroMsg.MMPictureLogic";
                r1 = "picStrategy == null";
                com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            L_0x0010:
                return r10;
            L_0x0011:
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0.Nt();	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r5 = new java.io.File;	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = r0.Nm();	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r5.<init>(r0);	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r4 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0.<init>();	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r2 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r2 = "_tmp";
                r0 = r0.append(r2);	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = r0.toString();	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r4.<init>(r0);	 Catch:{ Exception -> 0x02fa, all -> 0x026a }
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r0 = r0.Nn();	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = 0;
                r0 = com.tencent.mm.network.b.a(r0, r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = com.tencent.mm.ah.p.Ha();	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                if (r2 == 0) goto L_0x0073;
            L_0x004f:
                r2 = r12.ihT;	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = r2.Nn();	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = com.tencent.mm.ah.p.jF(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                if (r2 == 0) goto L_0x0073;
            L_0x005b:
                r2 = com.tencent.mm.protocal.d.sYN;	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = com.tencent.mm.ah.p.gc(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r3 = "MicroMsg.MMPictureLogic";
                r6 = "webp referer:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r8 = 0;
                r7[r8] = r2;	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                com.tencent.mm.sdk.platformtools.w.d(r3, r6, r7);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r0.mj(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
            L_0x0073:
                r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
                r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
                r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = "GET";
                r0.setRequestMethod(r2);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                r2 = com.tencent.mm.network.b.a(r0);	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
                if (r2 != 0) goto L_0x0309;
            L_0x0089:
                r3 = r0.getInputStream();	 Catch:{ Exception -> 0x02ff, all -> 0x02ee }
            L_0x008d:
                r0 = r0.ieZ;	 Catch:{ Exception -> 0x0304, all -> 0x02f1 }
                r2 = r0.getContentType();	 Catch:{ Exception -> 0x0304, all -> 0x02f1 }
                r0 = "MicroMsg.MMPictureLogic";
                r6 = "contentType:%s";
                r7 = 1;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r8 = 0;
                r7[r8] = r2;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                com.tencent.mm.sdk.platformtools.w.d(r0, r6, r7);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                if (r3 != 0) goto L_0x00f0;
            L_0x00a4:
                r0 = "MicroMsg.MMPictureLogic";
                r1 = "download %s error, can not open http stream";
                r5 = 1;
                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r6 = 0;
                r7 = r12.ihT;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7 = r7.Nn();	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r5[r6] = r7;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r1, r5);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r0 = r12.ihT;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r1 = 0;
                r0.F(r2, r1);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                if (r3 == 0) goto L_0x00c4;
            L_0x00c1:
                r3.close();	 Catch:{ IOException -> 0x00dd }
            L_0x00c4:
                r4.close();	 Catch:{ IOException -> 0x00c9 }
                goto L_0x0010;
            L_0x00c9:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
                goto L_0x0010;
            L_0x00dd:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
                goto L_0x00c4;
            L_0x00f0:
                r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
                r0 = new byte[r0];	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
            L_0x00f4:
                r6 = r3.read(r0);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7 = -1;
                if (r6 == r7) goto L_0x0157;
            L_0x00fb:
                r7 = r12.ihS;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7 = r7 + r6;
                r12.ihS = r7;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7 = 0;
                r4.write(r0, r7, r6);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                goto L_0x00f4;
            L_0x0105:
                r0 = move-exception;
                r1 = r2;
                r2 = r3;
                r3 = r4;
            L_0x0109:
                r4 = "MicroMsg.MMPictureLogic";
                r5 = "exception:%s";
                r6 = 1;
                r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x02f5 }
                r7 = 0;
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);	 Catch:{ all -> 0x02f5 }
                r6[r7] = r0;	 Catch:{ all -> 0x02f5 }
                com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ all -> 0x02f5 }
                r0 = "MicroMsg.MMPictureLogic";
                r4 = "get url:%s failed.";
                r5 = 1;
                r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x02f5 }
                r6 = 0;
                r7 = r12.ihT;	 Catch:{ all -> 0x02f5 }
                r7 = r7.Nn();	 Catch:{ all -> 0x02f5 }
                r5[r6] = r7;	 Catch:{ all -> 0x02f5 }
                com.tencent.mm.sdk.platformtools.w.w(r0, r4, r5);	 Catch:{ all -> 0x02f5 }
                r0 = r12.ihT;	 Catch:{ all -> 0x02f5 }
                r4 = 0;
                r0.F(r1, r4);	 Catch:{ all -> 0x02f5 }
                if (r2 == 0) goto L_0x013c;
            L_0x0139:
                r2.close();	 Catch:{ IOException -> 0x0256 }
            L_0x013c:
                if (r3 == 0) goto L_0x0010;
            L_0x013e:
                r3.close();	 Catch:{ IOException -> 0x0143 }
                goto L_0x0010;
            L_0x0143:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r3 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r3[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
                goto L_0x0010;
            L_0x0157:
                r0 = "MicroMsg.MMPictureLogic";
                r6 = "get url[%s] ok, bufSize[%d]";
                r7 = 2;
                r7 = new java.lang.Object[r7];	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r8 = 0;
                r9 = r12.ihT;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r9 = r9.Nn();	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7[r8] = r9;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r8 = 1;
                r9 = r12.ihS;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r7[r8] = r9;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                com.tencent.mm.sdk.platformtools.w.i(r0, r6, r7);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r0 = r12.ihT;	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                r6 = 1;
                r0.F(r2, r6);	 Catch:{ Exception -> 0x0105, all -> 0x02f1 }
                if (r3 == 0) goto L_0x0180;
            L_0x017d:
                r3.close();	 Catch:{ IOException -> 0x022e }
            L_0x0180:
                r4.close();	 Catch:{ IOException -> 0x0242 }
            L_0x0183:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c6 }
                r0.<init>();	 Catch:{ Exception -> 0x02c6 }
                r3 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x02c6 }
                r3 = "_tmp";
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x02c6 }
                com.tencent.mm.a.g.aV(r0);	 Catch:{ Exception -> 0x02c6 }
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.Nl();	 Catch:{ Exception -> 0x02c6 }
                if (r0 == 0) goto L_0x029d;
            L_0x01a6:
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c6 }
                r3.<init>();	 Catch:{ Exception -> 0x02c6 }
                r4 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02c6 }
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x02c6 }
                r4 = "_tmp";
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x02c6 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.ms(r3);	 Catch:{ Exception -> 0x02c6 }
                r3 = r0;
            L_0x01c3:
                if (r3 == 0) goto L_0x02bc;
            L_0x01c5:
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02c6 }
                r2 = com.tencent.mm.platformtools.i.a.NET;	 Catch:{ Exception -> 0x02c6 }
                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c6 }
                r4.<init>();	 Catch:{ Exception -> 0x02c6 }
                r6 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02c6 }
                r4 = r4.append(r6);	 Catch:{ Exception -> 0x02c6 }
                r6 = "_tmp";
                r4 = r4.append(r6);	 Catch:{ Exception -> 0x02c6 }
                r4 = r4.toString();	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.a(r3, r2, r4);	 Catch:{ Exception -> 0x02c6 }
            L_0x01e5:
                if (r0 == r3) goto L_0x0203;
            L_0x01e7:
                r2 = r3.isRecycled();	 Catch:{ Exception -> 0x02c6 }
                if (r2 != 0) goto L_0x0203;
            L_0x01ed:
                r2 = "MicroMsg.MMPictureLogic";
                r4 = "recycle bitmap:%s";
                r6 = 1;
                r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x02c6 }
                r7 = 0;
                r8 = r3.toString();	 Catch:{ Exception -> 0x02c6 }
                r6[r7] = r8;	 Catch:{ Exception -> 0x02c6 }
                com.tencent.mm.sdk.platformtools.w.i(r2, r4, r6);	 Catch:{ Exception -> 0x02c6 }
                r3.recycle();	 Catch:{ Exception -> 0x02c6 }
            L_0x0203:
                r2 = com.tencent.mm.platformtools.j.b.ihL;	 Catch:{ Exception -> 0x02c6 }
                r3 = r12.ihT;	 Catch:{ Exception -> 0x02c6 }
                r2.b(r3, r0);	 Catch:{ Exception -> 0x02c6 }
                r2 = new java.io.File;	 Catch:{ Exception -> 0x02c6 }
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c6 }
                r3.<init>();	 Catch:{ Exception -> 0x02c6 }
                r4 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02c6 }
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x02c6 }
                r4 = "_tmp";
                r3 = r3.append(r4);	 Catch:{ Exception -> 0x02c6 }
                r3 = r3.toString();	 Catch:{ Exception -> 0x02c6 }
                r2.<init>(r3);	 Catch:{ Exception -> 0x02c6 }
                r2.delete();	 Catch:{ Exception -> 0x02c6 }
            L_0x022a:
                r12.hqW = r0;
                goto L_0x0010;
            L_0x022e:
                r0 = move-exception;
                r3 = "MicroMsg.MMPictureLogic";
                r6 = "exception:%s";
                r7 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r7[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r3, r6, r7);
                goto L_0x0180;
            L_0x0242:
                r0 = move-exception;
                r3 = "MicroMsg.MMPictureLogic";
                r4 = "exception:%s";
                r6 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r6[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r3, r4, r6);
                goto L_0x0183;
            L_0x0256:
                r0 = move-exception;
                r1 = "MicroMsg.MMPictureLogic";
                r2 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r4[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r1, r2, r4);
                goto L_0x013c;
            L_0x026a:
                r0 = move-exception;
                r4 = r1;
            L_0x026c:
                if (r1 == 0) goto L_0x0271;
            L_0x026e:
                r1.close();	 Catch:{ IOException -> 0x0277 }
            L_0x0271:
                if (r4 == 0) goto L_0x0276;
            L_0x0273:
                r4.close();	 Catch:{ IOException -> 0x028a }
            L_0x0276:
                throw r0;
            L_0x0277:
                r1 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r5 = new java.lang.Object[r10];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r5[r11] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r5);
                goto L_0x0271;
            L_0x028a:
                r1 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);
                r4[r11] = r1;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                goto L_0x0276;
            L_0x029d:
                r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02c6 }
                r0.<init>();	 Catch:{ Exception -> 0x02c6 }
                r3 = r5.getAbsolutePath();	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x02c6 }
                r3 = "_tmp";
                r0 = r0.append(r3);	 Catch:{ Exception -> 0x02c6 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x02c6 }
                r0 = com.tencent.mm.platformtools.j.b.mt(r0);	 Catch:{ Exception -> 0x02c6 }
                r3 = r0;
                goto L_0x01c3;
            L_0x02bc:
                r0 = r12.ihT;	 Catch:{ Exception -> 0x02c6 }
                r4 = com.tencent.mm.platformtools.i.a.NET;	 Catch:{ Exception -> 0x02c6 }
                r0.a(r4, r2);	 Catch:{ Exception -> 0x02c6 }
                r0 = r1;
                goto L_0x01e5;
            L_0x02c6:
                r0 = move-exception;
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "update pic for %s, error";
                r4 = new java.lang.Object[r10];
                r5 = r12.ihT;
                r5 = r5.Nn();
                r4[r11] = r5;
                com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);
                r2 = "MicroMsg.MMPictureLogic";
                r3 = "exception:%s";
                r4 = new java.lang.Object[r10];
                r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                r4[r11] = r0;
                com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
                r0 = r1;
                goto L_0x022a;
            L_0x02ee:
                r0 = move-exception;
                goto L_0x026c;
            L_0x02f1:
                r0 = move-exception;
                r1 = r3;
                goto L_0x026c;
            L_0x02f5:
                r0 = move-exception;
                r1 = r2;
                r4 = r3;
                goto L_0x026c;
            L_0x02fa:
                r0 = move-exception;
                r2 = r1;
                r3 = r1;
                goto L_0x0109;
            L_0x02ff:
                r0 = move-exception;
                r2 = r1;
                r3 = r4;
                goto L_0x0109;
            L_0x0304:
                r0 = move-exception;
                r2 = r3;
                r3 = r4;
                goto L_0x0109;
            L_0x0309:
                r3 = r1;
                goto L_0x008d;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.platformtools.j.b.a.Bn():boolean");
            }

            public final boolean Bo() {
                try {
                    com.tencent.mm.u.ag.a.hlT.aH(this.ihS, 0);
                } catch (Throwable e) {
                    w.e("MicroMsg.MMPictureLogic", "exception:%s", bg.g(e));
                }
                b.a(b.ihL, this.ihT.Nn(), this.ihT.No(), this.hqW);
                this.hqW = null;
                return false;
            }
        }

        private static class b implements com.tencent.mm.sdk.platformtools.ar.a {
            public Bitmap hqW;
            private i ihT;

            public b(i iVar) {
                this.hqW = null;
                if (j.b(iVar)) {
                    this.ihT = iVar;
                    return;
                }
                throw new IllegalArgumentException("from sdcard, picture strategy here must be validity");
            }

            public final boolean Bn() {
                boolean z = false;
                this.hqW = b.mt(this.ihT.Nm());
                if (this.hqW != null) {
                    this.hqW = b.ihL.a(this.ihT, this.hqW);
                }
                String str = "MicroMsg.MMPictureLogic";
                String str2 = "get url[%s] from[%s] result[%B]";
                Object[] objArr = new Object[3];
                objArr[0] = this.ihT.Nn();
                objArr[1] = this.ihT.Nm();
                if (this.hqW != null) {
                    z = true;
                }
                objArr[2] = Boolean.valueOf(z);
                w.v(str, str2, objArr);
                return true;
            }

            public final boolean Bo() {
                if (this.hqW == null) {
                    w.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", this.ihT.Nn());
                    if (b.ihL.ihO == null || b.ihL.ihO.bJx()) {
                        b.ihL.ihO = new ar(1, "readerapp-pic-logic-download", 3);
                    }
                    b.ihL.ihO.c(new a(this.ihT));
                } else {
                    b.a(b.ihL, this.ihT.Nn(), this.ihT.No(), this.hqW);
                    this.hqW = null;
                }
                return false;
            }
        }

        private b(String str) {
            this.ihM = new HashMap();
            this.ihN = new HashMap();
            this.ihO = null;
            this.ihP = null;
        }

        static {
            ihQ = null;
        }

        private Bitmap c(i iVar) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String Nn = iVar.Nn();
            c cVar = (c) this.ihM.get(Nn);
            if (cVar == null) {
                cVar = new c();
            }
            if (cVar.ihU) {
                if (cVar.ihV < 3) {
                    cVar.ihV++;
                } else if (bg.az((long) cVar.ihW) < 120) {
                    w.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", Integer.valueOf(120), Nn);
                    return null;
                } else {
                    cVar.ihV = 0;
                }
                cVar.ihU = false;
                cVar.ihW = (int) bg.Ny();
                this.ihM.put(Nn, cVar);
            } else if (bg.az((long) cVar.ihW) < 120) {
                w.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", Integer.valueOf(120), Nn);
                return null;
            } else {
                cVar.ihV++;
                cVar.ihW = (int) bg.Ny();
                this.ihM.put(Nn, cVar);
            }
            if (iVar.Nq()) {
                Bitmap ms;
                com.tencent.mm.platformtools.i.b Nl = iVar.Nl();
                if (Nl != null) {
                    ms = Nl.ms(iVar.Nm());
                } else {
                    ms = mt(iVar.Nm());
                }
                if (ms != null) {
                    ms = a(iVar, ms);
                    this.ihM.remove(Nn);
                    return ms;
                }
                if (this.ihO == null || this.ihO.bJx()) {
                    this.ihO = new ar(1, "readerapp-pic-logic-download", 3);
                }
                this.ihO.c(new a(iVar));
                return null;
            }
            if (this.ihP == null || this.ihP.bJx()) {
                this.ihP = new ar(1, "readerapp-pic-logic-reader", 1);
            }
            this.ihP.c(new b(iVar));
            return null;
        }

        protected final Bitmap a(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            if (bitmap != null) {
                Bitmap a = iVar.a(bitmap, com.tencent.mm.platformtools.i.a.DISK, iVar.Nm());
                if (!(a == bitmap || bitmap.isRecycled())) {
                    w.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", bitmap.toString());
                    bitmap.recycle();
                }
                b(iVar, a);
                return a;
            }
            iVar.a(com.tencent.mm.platformtools.i.a.DISK, null);
            return bitmap;
        }

        private void b(i iVar, Bitmap bitmap) {
            Assert.assertTrue("picture strategy here must be validity", j.b(iVar));
            String Np = iVar.Np();
            Bitmap bitmap2 = this.ihN.containsKey(Np) ? (Bitmap) ((WeakReference) this.ihN.get(Np)).get() : null;
            if (bitmap2 == null || bitmap2.isRecycled()) {
                this.ihN.remove(Np);
                this.ihN.put(Np, new WeakReference(bitmap));
            }
        }

        public static Bitmap l(String str, int i, int i2) {
            Bitmap bitmap = null;
            if (bg.mA(str)) {
                w.w("MicroMsg.MMPictureLogic", "error input, path is null");
            } else if (i <= 0 || i2 <= 0) {
                w.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
                bitmap = d.a(str, i, i2, decodeResultLogger, 0, new int[0]);
                if (bitmap == null && decodeResultLogger.getDecodeResult() >= MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                    g.oUh.A(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
                }
            }
            return bitmap;
        }

        public static Bitmap mt(String str) {
            if (ihQ == null) {
                ihQ = ab.getContext().getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = ihQ;
            return l(str, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }

        public static Bitmap mu(String str) {
            if (bg.mA(str)) {
                w.w("MicroMsg.MMPictureLogic", "error input, path is null");
                return null;
            }
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            Bitmap a = d.a(str, 0, 0, decodeResultLogger, 0, new int[0]);
            if (a != null || decodeResultLogger.getDecodeResult() < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN) {
                return a;
            }
            g.oUh.A(12712, KVStatHelper.getKVStatString(str, 8, decodeResultLogger));
            return a;
        }
    }

    public static void j(String str, Bitmap bitmap) {
        Collection vector = new Vector();
        for (int i = 0; i < hrd.size(); i++) {
            WeakReference weakReference = (WeakReference) hrd.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.k(str, bitmap);
                } else {
                    vector.add(weakReference);
                }
            }
        }
        hrd.removeAll(vector);
    }

    public static boolean a(a aVar) {
        return hrd.add(new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        ihK.remove(aVar);
        return ihK.add(aVar);
    }

    public static boolean c(a aVar) {
        return ihK.remove(aVar);
    }

    public static Bitmap a(i iVar) {
        if (!b(iVar)) {
            return null;
        }
        if (!h.vI().vu()) {
            return iVar.Ns();
        }
        if (iVar.Nr()) {
            return b.a(b.ihL, iVar);
        }
        return b.b(b.ihL, iVar);
    }

    public static Bitmap mt(String str) {
        return b.mt(str);
    }

    public static Bitmap l(String str, int i, int i2) {
        return b.l(str, i, i2);
    }

    public static Bitmap mu(String str) {
        return b.mu(str);
    }

    public static boolean b(i iVar) {
        if (iVar == null || bg.mA(iVar.Nn())) {
            return false;
        }
        return true;
    }
}
