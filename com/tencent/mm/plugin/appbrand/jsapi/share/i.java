package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;

public final class i {

    static class AnonymousClass1 extends b {
        final /* synthetic */ String fxR;
        final /* synthetic */ m iTc;
        final /* synthetic */ String iVk;

        class AnonymousClass1 implements Runnable {
            final /* synthetic */ Bundle iVJ;
            final /* synthetic */ AnonymousClass1 iVK;

            AnonymousClass1(AnonymousClass1 anonymousClass1, Bundle bundle) {
                this.iVK = anonymousClass1;
                this.iVJ = bundle;
            }

            public final void run() {
                e.a("com.tencent.mm", this.iVJ, a.class, null);
            }
        }

        public final void a(com.tencent.mm.plugin.appbrand.e.c r7) {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r6 = this;
            r0 = r6.fxR;
            com.tencent.mm.plugin.appbrand.e.b(r0, r6);
            r0 = r6.iTc;
            r1 = com.tencent.mm.plugin.appbrand.jsapi.share.i.b(r0);
            if (r1 == 0) goto L_0x0042;
        L_0x000d:
            r0 = r1.isRecycled();	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            if (r0 != 0) goto L_0x0042;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
        L_0x0013:
            r0 = 100;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r2 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = r6.iVk;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = 1;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            com.tencent.mm.sdk.platformtools.d.a(r1, r0, r2, r3, r4);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r0 = new android.os.Bundle;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r0.<init>();	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r2 = "delay_load_img_path";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = "file://";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3.<init>(r4);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = r6.iVk;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = r3.append(r4);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = r3.toString();	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r0.putString(r2, r3);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r2 = new com.tencent.mm.plugin.appbrand.jsapi.share.i$1$1;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r2.<init>(r6, r0);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            com.tencent.mm.bk.a.post(r2);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
        L_0x0042:
            if (r1 == 0) goto L_0x004d;
        L_0x0044:
            r0 = r1.isRecycled();
            if (r0 != 0) goto L_0x004d;
        L_0x004a:
            r1.recycle();
        L_0x004d:
            return;
        L_0x004e:
            r0 = move-exception;
            r2 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = 1;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r5 = 0;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4[r5] = r0;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            if (r1 == 0) goto L_0x004d;
        L_0x0060:
            r0 = r1.isRecycled();
            if (r0 != 0) goto L_0x004d;
        L_0x0066:
            r1.recycle();
            goto L_0x004d;
        L_0x006a:
            r0 = move-exception;
            r2 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = 1;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r5 = 0;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            r4[r5] = r0;	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x004e, Exception -> 0x006a, all -> 0x0086 }
            if (r1 == 0) goto L_0x004d;
        L_0x007c:
            r0 = r1.isRecycled();
            if (r0 != 0) goto L_0x004d;
        L_0x0082:
            r1.recycle();
            goto L_0x004d;
        L_0x0086:
            r0 = move-exception;
            if (r1 == 0) goto L_0x0092;
        L_0x0089:
            r2 = r1.isRecycled();
            if (r2 != 0) goto L_0x0092;
        L_0x008f:
            r1.recycle();
        L_0x0092:
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.i.1.a(com.tencent.mm.plugin.appbrand.e$c):void");
        }

        AnonymousClass1(String str, m mVar, String str2) {
            this.fxR = str;
            this.iTc = mVar;
            this.iVk = str2;
        }
    }

    public static java.lang.String a(com.tencent.mm.plugin.appbrand.g.m r7, java.lang.String r8) {
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
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        if (r7 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7.ivH;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r2 == 0) goto L_0x002d;
    L_0x000c:
        r0 = new java.lang.StringBuilder;
        r2 = "share_";
        r0.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r0 = com.tencent.mm.plugin.appbrand.appstorage.c.aC(r1, r0);
        r2 = new com.tencent.mm.plugin.appbrand.jsapi.share.i$1;
        r2.<init>(r1, r7, r0);
        com.tencent.mm.plugin.appbrand.e.a(r1, r2);
        goto L_0x0003;
    L_0x002d:
        r2 = "wxfile://";
        r2 = r8.startsWith(r2);
        if (r2 == 0) goto L_0x0047;
    L_0x0036:
        r1 = com.tencent.mm.plugin.appbrand.appstorage.c.aH(r1, r8);
        if (r1 == 0) goto L_0x0003;
    L_0x003c:
        r2 = r1.hos;
        r2 = android.text.TextUtils.isEmpty(r2);
        if (r2 != 0) goto L_0x0003;
    L_0x0044:
        r0 = r1.hos;
        goto L_0x0003;
    L_0x0047:
        r2 = "http://";
        r2 = r8.startsWith(r2);
        if (r2 != 0) goto L_0x0003;
    L_0x0050:
        r2 = "https://";
        r2 = r8.startsWith(r2);
        if (r2 != 0) goto L_0x0003;
    L_0x0059:
        r0 = new java.lang.StringBuilder;
        r2 = "share_";
        r0.<init>(r2);
        r2 = java.lang.System.currentTimeMillis();
        r0 = r0.append(r2);
        r0 = r0.toString();
        r0 = com.tencent.mm.plugin.appbrand.appstorage.c.aC(r1, r0);
        r1 = r7.ixr;
        r2 = com.tencent.mm.plugin.appbrand.g.l.g(r1, r8);
        if (r2 == 0) goto L_0x0003;
    L_0x0079:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0003;
    L_0x007f:
        r1 = 100;
        r3 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r4 = 1;	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.d.a(r2, r1, r3, r0, r4);	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        if (r2 == 0) goto L_0x0003;
    L_0x0089:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0003;
    L_0x008f:
        r2.recycle();
        goto L_0x0003;
    L_0x0094:
        r1 = move-exception;
        r3 = "MicroMsg.ShareHelper";	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r4 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r5 = 1;	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r6 = 0;	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        r5[r6] = r1;	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        com.tencent.mm.sdk.platformtools.w.w(r3, r4, r5);	 Catch:{ IOException -> 0x0094, all -> 0x00b1 }
        if (r2 == 0) goto L_0x0003;
    L_0x00a6:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x0003;
    L_0x00ac:
        r2.recycle();
        goto L_0x0003;
    L_0x00b1:
        r0 = move-exception;
        if (r2 == 0) goto L_0x00bd;
    L_0x00b4:
        r1 = r2.isRecycled();
        if (r1 != 0) goto L_0x00bd;
    L_0x00ba:
        r2.recycle();
    L_0x00bd:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.i.a(com.tencent.mm.plugin.appbrand.g.m, java.lang.String):java.lang.String");
    }

    public static Bitmap b(m mVar) {
        if (mVar == null) {
            return null;
        }
        View view = mVar.jde.getView();
        if (view == null) {
            return null;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        if (width == 0 || height == 0) {
            return null;
        }
        view.scrollTo(0, 0);
        Bitmap cW = d.cW(view);
        Bitmap createBitmap = Bitmap.createBitmap(cW, 0, 0, width, height);
        cW.recycle();
        view.scrollTo(scrollX, scrollY);
        w.v("MicroMsg.ShareHelper", "crop cover(w : %s, h : %s, x : %s, y : %s)", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(scrollX), Integer.valueOf(scrollY)});
        return createBitmap;
    }
}
