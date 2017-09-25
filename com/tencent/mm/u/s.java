package com.tencent.mm.u;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Message;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class s {
    ae handler;
    private a hlF = null;
    public boolean hlG = false;
    public BlockingQueue<c> hlH = new ArrayBlockingQueue(80);
    public b hlI = null;

    class a implements Runnable {
        final /* synthetic */ s hlJ;
        boolean hlM = true;

        a(s sVar) {
            this.hlJ = sVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r14 = this;
            r4 = 0;
            r12 = 1;
            r2 = 0;
            r14.hlM = r2;
            r1 = r2;
        L_0x0006:
            r0 = r14.hlM;
            if (r0 != 0) goto L_0x0010;
        L_0x000a:
            r0 = 10;
            if (r1 <= r0) goto L_0x0011;
        L_0x000e:
            r14.hlM = r12;
        L_0x0010:
            return;
        L_0x0011:
            r0 = r14.hlJ;	 Catch:{ Exception -> 0x0330, all -> 0x0325 }
            r0 = r0.hlH;	 Catch:{ Exception -> 0x0330, all -> 0x0325 }
            r6 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
            r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ Exception -> 0x0330, all -> 0x0325 }
            r0 = r0.poll(r6, r3);	 Catch:{ Exception -> 0x0330, all -> 0x0325 }
            r0 = (com.tencent.mm.u.s.c) r0;	 Catch:{ Exception -> 0x0330, all -> 0x0325 }
            if (r0 == 0) goto L_0x0029;
        L_0x0021:
            r3 = r0.url;	 Catch:{ Exception -> 0x0339, all -> 0x0325 }
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);	 Catch:{ Exception -> 0x0339, all -> 0x0325 }
            if (r3 == 0) goto L_0x002d;
        L_0x0029:
            r0 = r1 + 1;
            r1 = r0;
            goto L_0x0006;
        L_0x002d:
            r1 = "MicroMsg.GetPicService";
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = "Thread get :";
            r3.<init>(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = " file:";
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = r0.filename;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.d(r1, r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = r0.filename;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = com.tencent.mm.a.e.aO(r1);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r1 == 0) goto L_0x0074;
        L_0x005a:
            r1 = "MicroMsg.GetPicService";
            r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = "Thread exist file:";
            r3.<init>(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = r0.filename;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.append(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.toString();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.d(r1, r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = r2;
            goto L_0x0006;
        L_0x0074:
            r1 = r14.hlJ;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r6 = 0;
            r8 = 1;
            r1.d(r6, r8);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r6 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = "MicroMsg.GetPicService";
            r3 = "get GetPicRunnable, run, url:%s";
            r5 = 1;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8 = 0;
            r9 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5[r8] = r9;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.d(r1, r3, r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = android.webkit.URLUtil.isHttpsUrl(r1);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r1 == 0) goto L_0x022f;
        L_0x009a:
            r1 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1 = com.tencent.mm.network.b.mi(r1);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.Ha();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 == 0) goto L_0x00cb;
        L_0x00a6:
            r3 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.jF(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 == 0) goto L_0x00cb;
        L_0x00ae:
            r3 = com.tencent.mm.protocal.d.sYN;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.gb(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = "MicroMsg.GetPicService";
            r8 = "webp referer:%s";
            r9 = 1;
            r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r10 = 0;
            r9[r10] = r3;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.d(r5, r8, r9);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8 = "Referer";
            r5.setRequestProperty(r8, r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
        L_0x00cb:
            r3 = "MicroMsg.GetPicService";
            r5 = "getCookie = %s, url = %s";
            r8 = 2;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r9 = 0;
            r10 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r9 = 1;
            r10 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r5, r8);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 != 0) goto L_0x00f3;
        L_0x00e9:
            r3 = "Cookie";
            r5 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
        L_0x00f3:
            r3 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = 1;
            r3.setUseCaches(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r3.setConnectTimeout(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r3.setReadTimeout(r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r1.ifc;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r3.getInputStream();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r8 = new byte[r5];	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9.<init>();	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r10 = ".tmp";
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = r9.toString();	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r5.<init>(r9);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
        L_0x012c:
            r9 = r3.read(r8);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r10 = -1;
            if (r9 == r10) goto L_0x0179;
        L_0x0133:
            r10 = 0;
            r5.write(r8, r10, r9);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            goto L_0x012c;
        L_0x0138:
            r1 = move-exception;
            r6 = r5;
            r5 = r3;
            r3 = r0;
            r0 = r2;
        L_0x013d:
            r7 = "MicroMsg.GetPicService";
            r8 = "exception:%s";
            r9 = 1;
            r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x032c }
            r10 = 0;
            r1 = com.tencent.mm.sdk.platformtools.bg.g(r1);	 Catch:{ all -> 0x032c }
            r9[r10] = r1;	 Catch:{ all -> 0x032c }
            com.tencent.mm.sdk.platformtools.w.e(r7, r8, r9);	 Catch:{ all -> 0x032c }
            r1 = r14.hlJ;	 Catch:{ all -> 0x032c }
            r8 = 2;
            r10 = 1;
            r1.d(r8, r10);	 Catch:{ all -> 0x032c }
            if (r3 == 0) goto L_0x016c;
        L_0x015b:
            r1 = r3.url;	 Catch:{ all -> 0x032c }
            r1 = com.tencent.mm.ah.p.jF(r1);	 Catch:{ all -> 0x032c }
            if (r1 == 0) goto L_0x016c;
        L_0x0163:
            r1 = r14.hlJ;	 Catch:{ all -> 0x032c }
            r8 = 15;
            r10 = 1;
            r1.d(r8, r10);	 Catch:{ all -> 0x032c }
        L_0x016c:
            if (r6 == 0) goto L_0x0171;
        L_0x016e:
            r6.close();	 Catch:{ Exception -> 0x031f }
        L_0x0171:
            if (r5 == 0) goto L_0x0176;
        L_0x0173:
            r5.close();	 Catch:{ Exception -> 0x031f }
        L_0x0176:
            r1 = r0;
            goto L_0x0006;
        L_0x0179:
            r8 = new java.io.File;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9.<init>();	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r10 = ".tmp";
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9 = r9.toString();	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r8.<init>(r9);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9 = new java.io.File;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r9.<init>(r10);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r8.renameTo(r9);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r1 = r1.ifc;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r1 = r1.getContentType();	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r8 = "MicroMsg.GetPicService";
            r9 = "contentType:%s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            r11 = 0;
            r10[r11] = r1;	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
            com.tencent.mm.sdk.platformtools.w.d(r8, r9, r10);	 Catch:{ Exception -> 0x0138, all -> 0x0302 }
        L_0x01b3:
            r8 = com.tencent.mm.ah.p.Ha();	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r8 == 0) goto L_0x030f;
        L_0x01b9:
            r8 = r0.url;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = com.tencent.mm.ah.p.jF(r8);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r8 == 0) goto L_0x030f;
        L_0x01c1:
            r8 = com.tencent.mm.sdk.platformtools.bg.mA(r1);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r8 != 0) goto L_0x030f;
        L_0x01c7:
            r8 = "image/webp";
            r1 = r1.equals(r8);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r1 == 0) goto L_0x030f;
        L_0x01d0:
            r1 = "MicroMsg.GetPicService";
            r8 = "receive a webp picture";
            com.tencent.mm.sdk.platformtools.w.d(r1, r8);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1 = 1;
            r0.hlN = r1;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1 = r14.hlJ;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = 13;
            r10 = 1;
            r1.d(r8, r10);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
        L_0x01e5:
            r1 = new android.os.Message;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1.<init>();	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1.obj = r0;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = r0.pos;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1.arg1 = r8;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = r14.hlJ;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = r8.handler;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8.sendMessage(r1);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r6 = r8 - r6;
            r1 = "MicroMsg.GetPicService";
            r8 = "download image used: %dms";
            r9 = 1;
            r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r10 = 0;
            r11 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r9[r10] = r11;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            com.tencent.mm.sdk.platformtools.w.d(r1, r8, r9);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r1 = r14.hlJ;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = 4;
            r1.d(r8, r6);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r0 == 0) goto L_0x0224;
        L_0x0219:
            r1 = r0.hlN;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            if (r1 == 0) goto L_0x0224;
        L_0x021d:
            r1 = r14.hlJ;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            r8 = 17;
            r1.d(r8, r6);	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
        L_0x0224:
            r5.close();	 Catch:{ Exception -> 0x031b }
            if (r3 == 0) goto L_0x022c;
        L_0x0229:
            r3.close();	 Catch:{ Exception -> 0x031b }
        L_0x022c:
            r1 = r2;
            goto L_0x0006;
        L_0x022f:
            r1 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = 0;
            r1 = com.tencent.mm.network.b.a(r1, r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.Ha();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 == 0) goto L_0x025c;
        L_0x023c:
            r3 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.jF(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 == 0) goto L_0x025c;
        L_0x0244:
            r3 = com.tencent.mm.protocal.d.sYN;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.ah.p.gb(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = "MicroMsg.GetPicService";
            r8 = "webp referer:%s";
            r9 = 1;
            r9 = new java.lang.Object[r9];	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r10 = 0;
            r9[r10] = r3;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.d(r5, r8, r9);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1.mj(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
        L_0x025c:
            r3 = "MicroMsg.GetPicService";
            r5 = "getCookie = %s, url = %s";
            r8 = 2;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r9 = 0;
            r10 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r9 = 1;
            r10 = r0.url;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            com.tencent.mm.sdk.platformtools.w.i(r3, r5, r8);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = com.tencent.mm.sdk.platformtools.bg.mA(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            if (r3 != 0) goto L_0x0282;
        L_0x027a:
            r3 = "Cookie";
            r5 = r0.hlO;	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r1.setRequestProperty(r3, r5);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
        L_0x0282:
            r3 = 1;
            r1.setUseCaches(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r1.setConnectTimeout(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = 3000; // 0xbb8 float:4.204E-42 double:1.482E-320;
            r1.setReadTimeout(r3);	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r3 = r1.getInputStream();	 Catch:{ Exception -> 0x0342, all -> 0x0325 }
            r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
            r8 = new byte[r5];	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r5 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9.<init>();	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r10 = ".tmp";
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r9 = r9.toString();	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
            r5.<init>(r9);	 Catch:{ Exception -> 0x0349, all -> 0x0328 }
        L_0x02b3:
            r9 = r3.read(r8);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r10 = -1;
            if (r9 == r10) goto L_0x02c6;
        L_0x02ba:
            r10 = 0;
            r5.write(r8, r10, r9);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            goto L_0x02b3;
        L_0x02bf:
            r1 = move-exception;
            r6 = r5;
            r5 = r3;
            r3 = r0;
            r0 = r2;
            goto L_0x013d;
        L_0x02c6:
            r8 = new java.io.File;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9.<init>();	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r10 = ".tmp";
            r9 = r9.append(r10);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9 = r9.toString();	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r8.<init>(r9);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9 = new java.io.File;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r10 = r0.filename;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r9.<init>(r10);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r8.renameTo(r9);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r1 = r1.ieZ;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r1 = r1.getContentType();	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r8 = "MicroMsg.GetPicService";
            r9 = "contentType:%s";
            r10 = 1;
            r10 = new java.lang.Object[r10];	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            r11 = 0;
            r10[r11] = r1;	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            com.tencent.mm.sdk.platformtools.w.d(r8, r9, r10);	 Catch:{ Exception -> 0x02bf, all -> 0x0302 }
            goto L_0x01b3;
        L_0x0302:
            r0 = move-exception;
            r4 = r3;
        L_0x0304:
            if (r5 == 0) goto L_0x0309;
        L_0x0306:
            r5.close();	 Catch:{ Exception -> 0x0323 }
        L_0x0309:
            if (r4 == 0) goto L_0x030e;
        L_0x030b:
            r4.close();	 Catch:{ Exception -> 0x0323 }
        L_0x030e:
            throw r0;
        L_0x030f:
            r1 = 0;
            r0.hlN = r1;	 Catch:{ Exception -> 0x0314, all -> 0x0302 }
            goto L_0x01e5;
        L_0x0314:
            r1 = move-exception;
            r6 = r5;
            r5 = r3;
            r3 = r0;
            r0 = r2;
            goto L_0x013d;
        L_0x031b:
            r0 = move-exception;
            r1 = r2;
            goto L_0x0006;
        L_0x031f:
            r1 = move-exception;
            r1 = r0;
            goto L_0x0006;
        L_0x0323:
            r1 = move-exception;
            goto L_0x030e;
        L_0x0325:
            r0 = move-exception;
            r5 = r4;
            goto L_0x0304;
        L_0x0328:
            r0 = move-exception;
            r5 = r4;
            r4 = r3;
            goto L_0x0304;
        L_0x032c:
            r0 = move-exception;
            r4 = r5;
            r5 = r6;
            goto L_0x0304;
        L_0x0330:
            r0 = move-exception;
            r3 = r4;
            r5 = r4;
            r6 = r4;
            r13 = r0;
            r0 = r1;
            r1 = r13;
            goto L_0x013d;
        L_0x0339:
            r3 = move-exception;
            r5 = r4;
            r6 = r4;
            r13 = r3;
            r3 = r0;
            r0 = r1;
            r1 = r13;
            goto L_0x013d;
        L_0x0342:
            r1 = move-exception;
            r3 = r0;
            r5 = r4;
            r6 = r4;
            r0 = r2;
            goto L_0x013d;
        L_0x0349:
            r1 = move-exception;
            r5 = r3;
            r6 = r4;
            r3 = r0;
            r0 = r2;
            goto L_0x013d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.u.s.a.run():void");
        }
    }

    public interface b {
        void a(String str, String str2, int i);
    }

    class c {
        String filename;
        final /* synthetic */ s hlJ;
        boolean hlN = false;
        String hlO;
        int pos;
        String url;

        public c(s sVar, String str, String str2, int i, String str3) {
            this.hlJ = sVar;
            this.url = str;
            if (p.Ha() && sVar.hlG) {
                this.url = p.jE(this.url);
            }
            this.filename = str2;
            this.pos = i;
            this.hlN = false;
            this.hlO = str3;
        }
    }

    public s(boolean z) {
        h.vJ();
        this.handler = new ae(this, h.vL().nJF.getLooper()) {
            final /* synthetic */ s hlJ;

            public final void handleMessage(Message message) {
                try {
                    if (this.hlJ.hlI != null) {
                        final c cVar = (c) message.obj;
                        if (cVar.hlN && p.Ha()) {
                            String jG = p.jG(cVar.url);
                            w.d("MicroMsg.GetPicService", "convert webp, originPicFormat:%s, file:%s, url:%s", new Object[]{jG, cVar.filename, cVar.url});
                            Bitmap Pg = d.Pg(cVar.filename);
                            if (Pg == null) {
                                w.d("MicroMsg.GetPicService", "decode webp picture failed");
                                this.hlJ.d(14, 1);
                            } else if (!bg.mA(jG)) {
                                if (jG.toLowerCase().contains("png")) {
                                    w.d("MicroMsg.GetPicService", "convert webp to png");
                                    d.a(Pg, 100, CompressFormat.PNG, cVar.filename, true);
                                } else {
                                    w.d("MicroMsg.GetPicService", "convert webp to jpg");
                                    d.a(Pg, 100, CompressFormat.JPEG, cVar.filename, true);
                                }
                            }
                        }
                        int aN = e.aN(cVar.filename);
                        if (aN > 0 && h.vG().uV()) {
                            com.tencent.mm.u.ag.a.hlT.aH(aN, 0);
                        }
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 hlL;

                            public final void run() {
                                if (this.hlL.hlJ.hlI != null) {
                                    this.hlL.hlJ.hlI.a(cVar.url, cVar.filename, cVar.pos);
                                }
                            }
                        });
                    }
                } catch (Throwable e) {
                    w.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bg.g(e)});
                }
            }
        };
        this.hlF = null;
        this.hlG = z;
        w.d("MicroMsg.GetPicService", "getPicService, isFromWebView:%b", new Object[]{Boolean.valueOf(z)});
    }

    public final void yE() {
        if (this.hlF != null) {
            this.hlF.hlM = true;
        }
        this.hlF = null;
    }

    public final String c(String str, int i, int i2, String str2) {
        String str3;
        if (str == null) {
            str3 = null;
        } else if (h.vG().uV()) {
            str3 = com.tencent.mm.plugin.n.b.xb() + "/reader_" + i + "_" + g.n(str.getBytes()) + ".jpg";
        } else {
            w.i("MicroMsg.GetPicService", "genFileName, account not ready");
            File file = new File(h.vI().gYe + "/imagecache");
            if (!file.exists()) {
                file.mkdirs();
            }
            str3 = file.getAbsolutePath() + "/reader_" + i + "_" + g.n(str.getBytes()) + ".jpg";
        }
        w.d("MicroMsg.GetPicService", "getPicfileByUrl type:" + i + " url:" + str);
        try {
            if (e.aO(str3)) {
                return str3;
            }
        } catch (Throwable e) {
            w.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bg.g(e)});
        }
        try {
            this.hlH.add(new c(this, str, str3, i2, str2));
            if (this.hlF == null || !com.tencent.mm.sdk.f.e.T(this.hlF)) {
                com.tencent.mm.sdk.f.e.remove(this.hlF);
                this.hlF = new a(this);
                com.tencent.mm.sdk.f.e.post(this.hlF, "GetPicService_getPic");
            }
        } catch (Throwable e2) {
            w.e("MicroMsg.GetPicService", "exception:%s", new Object[]{bg.g(e2)});
        }
        return null;
    }

    public final void d(long j, long j2) {
        if (this.hlG) {
            w.d("MicroMsg.GetPicService", "doIdKeyStat, key:%d, val:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
            com.tencent.mm.plugin.report.service.g.oUh.a(86, j, j2, false);
        }
    }
}
