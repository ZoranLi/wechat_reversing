package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.wearable.a.a;
import com.google.android.gms.wearable.n.b;
import com.google.android.gms.wearable.n.c;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.r;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao extends k<x> {
    private final y<b> aHA = new y();
    private final y<c> aHB = new y();
    private final Map<String, y<a>> aHC = new HashMap();
    final ExecutorService aHu = Executors.newCachedThreadPool();
    private final y<r.a> aHv = new y();
    private final y<q.a> aHw = new y();
    private final y<com.google.android.gms.wearable.b.a> aHx = new y();
    private final y<com.google.android.gms.wearable.c.b> aHy = new y();
    private final y<com.google.android.gms.wearable.k.a> aHz = new y();

    class AnonymousClass1 implements Callable<Boolean> {
        final /* synthetic */ ParcelFileDescriptor aHD;
        final /* synthetic */ ao aHE;
        final /* synthetic */ byte[] aHo;

        AnonymousClass1(ao aoVar, ParcelFileDescriptor parcelFileDescriptor, byte[] bArr) {
            this.aHE = aoVar;
            this.aHD = parcelFileDescriptor;
            this.aHo = bArr;
        }

        private java.lang.Boolean mG() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0082 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r1 = 3;
            r0 = "WearableClient";
            r0 = android.util.Log.isLoggable(r0, r1);
            if (r0 == 0) goto L_0x0017;
        L_0x000a:
            r0 = new java.lang.StringBuilder;
            r1 = "processAssets: writing data to FD : ";
            r0.<init>(r1);
            r1 = r4.aHD;
            r0.append(r1);
        L_0x0017:
            r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream;
            r0 = r4.aHD;
            r1.<init>(r0);
            r0 = r4.aHo;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r1.write(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r1.flush();	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = "WearableClient";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = 3;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = android.util.Log.isLoggable(r0, r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            if (r0 == 0) goto L_0x003d;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        L_0x0030:
            r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "processAssets: wrote data: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = r4.aHD;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
        L_0x003d:
            r0 = 1;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00ab }
            r3 = 3;	 Catch:{ IOException -> 0x00ab }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00ab }
            if (r2 == 0) goto L_0x0059;	 Catch:{ IOException -> 0x00ab }
        L_0x004c:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00ab }
            r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00ab }
            r2.<init>(r3);	 Catch:{ IOException -> 0x00ab }
            r3 = r4.aHD;	 Catch:{ IOException -> 0x00ab }
            r2.append(r3);	 Catch:{ IOException -> 0x00ab }
        L_0x0059:
            r1.close();	 Catch:{ IOException -> 0x00ab }
        L_0x005c:
            return r0;
        L_0x005d:
            r0 = move-exception;
            r0 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = "processAssets: writing data failed: ";	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.<init>(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r2 = r4.aHD;	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0.append(r2);	 Catch:{ IOException -> 0x005d, all -> 0x008b }
            r0 = "WearableClient";
            r2 = 3;
            r0 = android.util.Log.isLoggable(r0, r2);
            if (r0 == 0) goto L_0x0082;
        L_0x0075:
            r0 = new java.lang.StringBuilder;
            r2 = "processAssets: closing: ";
            r0.<init>(r2);
            r2 = r4.aHD;
            r0.append(r2);
        L_0x0082:
            r1.close();
        L_0x0085:
            r0 = 0;
            r0 = java.lang.Boolean.valueOf(r0);
            goto L_0x005c;
        L_0x008b:
            r0 = move-exception;
            r2 = "WearableClient";	 Catch:{ IOException -> 0x00a7 }
            r3 = 3;	 Catch:{ IOException -> 0x00a7 }
            r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x00a7 }
            if (r2 == 0) goto L_0x00a3;	 Catch:{ IOException -> 0x00a7 }
        L_0x0096:
            r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x00a7 }
            r3 = "processAssets: closing: ";	 Catch:{ IOException -> 0x00a7 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x00a7 }
            r3 = r4.aHD;	 Catch:{ IOException -> 0x00a7 }
            r2.append(r3);	 Catch:{ IOException -> 0x00a7 }
        L_0x00a3:
            r1.close();	 Catch:{ IOException -> 0x00a7 }
        L_0x00a6:
            throw r0;
        L_0x00a7:
            r1 = move-exception;
            goto L_0x00a6;
        L_0x00a9:
            r0 = move-exception;
            goto L_0x0085;
        L_0x00ab:
            r1 = move-exception;
            goto L_0x005c;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ao.1.mG():java.lang.Boolean");
        }

        public final /* synthetic */ Object call() {
            return mG();
        }
    }

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Uri aGO;
        final /* synthetic */ boolean aGP;
        final /* synthetic */ ao aHE;
        final /* synthetic */ com.google.android.gms.common.api.k.b aHF;
        final /* synthetic */ String aHG;

        AnonymousClass2(ao aoVar, Uri uri, com.google.android.gms.common.api.k.b bVar, boolean z, String str) {
            this.aHE = aoVar;
            this.aGO = uri;
            this.aHF = bVar;
            this.aGP = z;
            this.aHG = str;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r4 = this;
            r0 = "WearableClient";
            r1 = 2;
            android.util.Log.isLoggable(r0, r1);
            r0 = "file";
            r1 = r4.aGO;
            r1 = r1.getScheme();
            r0 = r0.equals(r1);
            if (r0 != 0) goto L_0x0026;
        L_0x0016:
            r0 = r4.aHF;
            r1 = new com.google.android.gms.common.api.Status;
            r2 = 10;
            r3 = "Channel.receiveFile used with non-file URI";
            r1.<init>(r2, r3);
            r0.c(r1);
        L_0x0025:
            return;
        L_0x0026:
            r1 = new java.io.File;
            r0 = r4.aGO;
            r0 = r0.getPath();
            r1.<init>(r0);
            r2 = 536870912; // 0x20000000 float:1.0842022E-19 double:2.652494739E-315;
            r0 = r4.aGP;
            if (r0 == 0) goto L_0x0058;
        L_0x0037:
            r0 = 33554432; // 0x2000000 float:9.403955E-38 double:1.6578092E-316;
        L_0x0039:
            r0 = r0 | r2;
            r1 = android.os.ParcelFileDescriptor.open(r1, r0);	 Catch:{ FileNotFoundException -> 0x005a }
            r0 = r4.aHE;	 Catch:{ RemoteException -> 0x0073 }
            r0 = r0.jY();	 Catch:{ RemoteException -> 0x0073 }
            r0 = (com.google.android.gms.wearable.internal.x) r0;	 Catch:{ RemoteException -> 0x0073 }
            r2 = new com.google.android.gms.wearable.internal.an$i;	 Catch:{ RemoteException -> 0x0073 }
            r3 = r4.aHF;	 Catch:{ RemoteException -> 0x0073 }
            r2.<init>(r3);	 Catch:{ RemoteException -> 0x0073 }
            r3 = r4.aHG;	 Catch:{ RemoteException -> 0x0073 }
            r0.a(r2, r3, r1);	 Catch:{ RemoteException -> 0x0073 }
            r1.close();	 Catch:{ IOException -> 0x0056 }
            goto L_0x0025;
        L_0x0056:
            r0 = move-exception;
            goto L_0x0025;
        L_0x0058:
            r0 = 0;
            goto L_0x0039;
        L_0x005a:
            r0 = move-exception;
            r0 = new java.lang.StringBuilder;
            r2 = "File couldn't be opened for Channel.receiveFile: ";
            r0.<init>(r2);
            r0.append(r1);
            r0 = r4.aHF;
            r1 = new com.google.android.gms.common.api.Status;
            r2 = 13;
            r1.<init>(r2);
            r0.c(r1);
            goto L_0x0025;
        L_0x0073:
            r0 = move-exception;
            r0 = r4.aHF;	 Catch:{ all -> 0x0086 }
            r2 = new com.google.android.gms.common.api.Status;	 Catch:{ all -> 0x0086 }
            r3 = 8;
            r2.<init>(r3);	 Catch:{ all -> 0x0086 }
            r0.c(r2);	 Catch:{ all -> 0x0086 }
            r1.close();	 Catch:{ IOException -> 0x0084 }
            goto L_0x0025;
        L_0x0084:
            r0 = move-exception;
            goto L_0x0025;
        L_0x0086:
            r0 = move-exception;
            r1.close();	 Catch:{ IOException -> 0x008b }
        L_0x008a:
            throw r0;
        L_0x008b:
            r1 = move-exception;
            goto L_0x008a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.ao.2.run():void");
        }
    }

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar, h hVar) {
        super(context, looper, 14, hVar, bVar, cVar);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            if (i == 0) {
                this.aHv.u(iBinder);
                this.aHw.u(iBinder);
                this.aHy.u(iBinder);
                this.aHz.u(iBinder);
                this.aHA.u(iBinder);
                this.aHB.u(iBinder);
                synchronized (this.aHC) {
                    for (y u : this.aHC.values()) {
                        u.u(iBinder);
                    }
                }
            }
            super.a(i, iBinder, bundle, i2);
        }
        if (i == 0) {
            this.aHv.u(iBinder);
            this.aHw.u(iBinder);
            this.aHy.u(iBinder);
            this.aHz.u(iBinder);
            this.aHA.u(iBinder);
            this.aHB.u(iBinder);
            synchronized (this.aHC) {
                while (r2.hasNext()) {
                    u.u(iBinder);
                }
            }
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void a(e eVar) {
        int i = 7887000;
        if (!jl()) {
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", FileUtils.S_IWUSR).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 7887000);
                }
                if (i < com.google.android.gms.common.b.amc) {
                    new StringBuilder("Android Wear out of date. Requires API version ").append(com.google.android.gms.common.b.amc).append(" but found ").append(i);
                    Context context = this.mContext;
                    Context context2 = this.mContext;
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter(SlookAirButtonFrequentContactAdapter.ID, "com.google.android.wearable.app.cn").build());
                    }
                    a(eVar, new ConnectionResult(6, PendingIntent.getActivity(context, 0, intent, 0)));
                    return;
                }
            } catch (NameNotFoundException e) {
                a(eVar, new ConnectionResult(16, null));
                return;
            }
        }
        super.a(eVar);
    }

    public final void disconnect() {
        this.aHv.a(this);
        this.aHw.a(this);
        this.aHy.a(this);
        this.aHz.a(this);
        this.aHA.a(this);
        this.aHB.a(this);
        synchronized (this.aHC) {
            for (y a : this.aHC.values()) {
                a.a(this);
            }
        }
        super.disconnect();
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return x.a.t(iBinder);
    }

    protected final String jT() {
        return com.google.android.gms.common.k.kC().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }

    public final boolean jl() {
        return !com.google.android.gms.common.k.kC().a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
    }

    protected final String jm() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String jn() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }
}
