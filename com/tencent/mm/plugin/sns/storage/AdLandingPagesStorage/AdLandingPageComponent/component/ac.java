package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.AsyncTask;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashSet;
import java.util.Set;

public final class ac extends AsyncTask<String, Void, Void> {
    private static Set<String> qku = new HashSet();
    private static byte[] qkv = new byte[0];
    final String filePath;
    final String fyF;
    final ae handler;
    final int qkA;
    private boolean qkB;
    private int qkC;
    final String qkw;
    final String qkx;
    final String qky;
    final a qkz;
    private int scene = 0;

    public interface a {
        void FY(String str);

        void FZ(String str);

        void bL(String str, int i);
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return x((String[]) objArr);
    }

    public ac(String str, String str2, boolean z, int i, int i2, final ae aeVar, final a aVar) {
        FileOp.kl(str);
        this.qky = str;
        this.fyF = str2;
        this.filePath = str + "/" + str2;
        this.qkB = z;
        this.qkC = i;
        this.qkx = "temp_" + str2;
        this.qkw = str + "/" + this.qkx;
        this.handler = aeVar;
        this.qkA = Downloads.SPLIT_RANGE_SIZE_WAP;
        this.qkz = new a(this) {
            final /* synthetic */ ac qkE;

            public final void bL(final String str, final int i) {
                aeVar.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qkH;

                    public final void run() {
                        aVar.bL(str, i);
                    }
                });
            }

            public final void FY(final String str) {
                aeVar.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qkH;

                    public final void run() {
                        aVar.FY(str);
                    }
                });
            }

            public final void FZ(final String str) {
                aeVar.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 qkH;

                    public final void run() {
                        aVar.FZ(str);
                    }
                });
            }
        };
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Void x(java.lang.String... r15) {
        /*
        r14 = this;
        r0 = r14.filePath;
        r0 = com.tencent.mm.modelsfs.FileOp.aO(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = r14.qkz;
        r1 = r14.filePath;
        r0.FZ(r1);
        r0 = 0;
    L_0x0010:
        return r0;
    L_0x0011:
        r1 = qkv;
        monitor-enter(r1);
        r0 = qku;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r2 = r15[r2];	 Catch:{ all -> 0x0022 }
        r0 = r0.contains(r2);	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0025;
    L_0x001f:
        r0 = 0;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        goto L_0x0010;
    L_0x0022:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        throw r0;
    L_0x0025:
        r0 = qku;	 Catch:{ all -> 0x0022 }
        r2 = 0;
        r2 = r15[r2];	 Catch:{ all -> 0x0022 }
        r0.add(r2);	 Catch:{ all -> 0x0022 }
        monitor-exit(r1);	 Catch:{ all -> 0x0022 }
        r8 = com.tencent.mm.sdk.platformtools.bg.Nz();
        r4 = 0;
        r5 = 0;
        r3 = 0;
        r2 = 0;
        r1 = 0;
        r0 = r14.qkw;	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r0 = com.tencent.mm.modelsfs.FileOp.aO(r0);	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        if (r0 == 0) goto L_0x0044;
    L_0x003f:
        r0 = r14.qkw;	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
    L_0x0044:
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r6 = 0;
        r6 = r15[r6];	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r0.<init>(r6);	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0328, all -> 0x0468 }
        r0.connect();	 Catch:{ Exception -> 0x05ca, all -> 0x05a9 }
        r6 = r0.getResponseCode();	 Catch:{ Exception -> 0x05ca, all -> 0x05a9 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r6 == r1) goto L_0x01ae;
    L_0x005d:
        r1 = r14.qkz;	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r7 = "Server returned HTTP ";
        r4.<init>(r7);	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r7 = r0.getResponseCode();	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r4 = r4.append(r7);	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r7 = " ";
        r4 = r4.append(r7);	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r7 = r0.getResponseMessage();	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r4 = r4.append(r7);	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r4 = r4.toString();	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r1.FY(r4);	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        if (r0 == 0) goto L_0x008a;
    L_0x0087:
        r0.disconnect();
    L_0x008a:
        r1 = qkv;
        monitor-enter(r1);
        r0 = qku;	 Catch:{ all -> 0x01a8 }
        r2 = 0;
        r2 = r15[r2];	 Catch:{ all -> 0x01a8 }
        r0.remove(r2);	 Catch:{ all -> 0x01a8 }
        monitor-exit(r1);	 Catch:{ all -> 0x01a8 }
        r0 = 0;
        r0 = r15[r0];
        r0 = com.tencent.smtt.utils.i.aV(r0);
        r1 = r14.bfy();
        r2 = com.tencent.mm.sdk.platformtools.bg.aA(r8);
        r2 = (int) r2;
        r3 = new com.tencent.mm.modelsns.d;
        r3.<init>();
        r4 = "20UrlMd5";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r3.n(r4, r0);
        r0 = "21MediaType";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r4 = ",";
        r1 = r1.append(r4);
        r1 = r1.toString();
        r3.n(r0, r1);
        r1 = "22IsPreload";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = r14.qkB;
        if (r0 == 0) goto L_0x01ab;
    L_0x00eb:
        r0 = 1;
    L_0x00ec:
        r0 = r4.append(r0);
        r4 = ",";
        r0 = r0.append(r4);
        r0 = r0.toString();
        r3.n(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r14.scene;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r2 = "0,";
        r1.<init>(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r8 / r4;
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r3.JG();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r0.i(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x01a8:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x01a8 }
        throw r0;
    L_0x01ab:
        r0 = 0;
        goto L_0x00ec;
    L_0x01ae:
        r0.getContentLength();	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r4 = r0.getInputStream();	 Catch:{ Exception -> 0x05d3, all -> 0x05ad }
        r3 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x05db, all -> 0x05b0 }
        r1 = r14.qkw;	 Catch:{ Exception -> 0x05db, all -> 0x05b0 }
        r3.<init>(r1);	 Catch:{ Exception -> 0x05db, all -> 0x05b0 }
        r1 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r7 = new byte[r1];	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r2 = 0;
        r1 = 0;
    L_0x01c2:
        r10 = r4.read(r7);	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r11 = -1;
        if (r10 == r11) goto L_0x01e1;
    L_0x01c9:
        r11 = 0;
        r3.write(r7, r11, r10);	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r2 = r2 + r10;
        r10 = r14.qkA;	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        if (r10 == 0) goto L_0x01c2;
    L_0x01d2:
        r10 = r2 - r1;
        r11 = r14.qkA;	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        if (r10 < r11) goto L_0x01c2;
    L_0x01d8:
        r1 = r14.qkz;	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r10 = r14.qkw;	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r1.bL(r10, r2);	 Catch:{ Exception -> 0x05e4, all -> 0x05b4 }
        r1 = r2;
        goto L_0x01c2;
    L_0x01e1:
        r1 = r14.qkw;	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        r5 = r14.filePath;	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        com.tencent.mm.modelsfs.FileOp.aj(r1, r5);	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        r1 = r14.qkz;	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        r5 = r14.filePath;	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        r1.FZ(r5);	 Catch:{ Exception -> 0x05ee, all -> 0x05b9 }
        r3.close();	 Catch:{ IOException -> 0x05f9 }
        if (r4 == 0) goto L_0x01f7;
    L_0x01f4:
        r4.close();	 Catch:{ IOException -> 0x05f9 }
    L_0x01f7:
        if (r0 == 0) goto L_0x01fc;
    L_0x01f9:
        r0.disconnect();
    L_0x01fc:
        r1 = qkv;
        monitor-enter(r1);
        r0 = qku;	 Catch:{ all -> 0x0322 }
        r3 = 0;
        r3 = r15[r3];	 Catch:{ all -> 0x0322 }
        r0.remove(r3);	 Catch:{ all -> 0x0322 }
        monitor-exit(r1);	 Catch:{ all -> 0x0322 }
        r0 = 0;
        r0 = r15[r0];
        r0 = com.tencent.smtt.utils.i.aV(r0);
        r1 = r14.bfy();
        r4 = com.tencent.mm.sdk.platformtools.bg.aA(r8);
        r3 = (int) r4;
        r4 = new com.tencent.mm.modelsns.d;
        r4.<init>();
        r5 = "20UrlMd5";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = r5.append(r1);
        r5 = ",";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.n(r0, r1);
        r1 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r14.qkB;
        if (r0 == 0) goto L_0x0325;
    L_0x025d:
        r0 = 1;
    L_0x025e:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r4.n(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r6);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r3 = r14.scene;
        r1 = r1.append(r3);
        r3 = ",";
        r1 = r1.append(r3);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r2 = r8 / r2;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r4.n(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r4.JG();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r2[r3] = r4;
        r0.i(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x0322:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0322 }
        throw r0;
    L_0x0325:
        r0 = 0;
        goto L_0x025e;
    L_0x0328:
        r0 = move-exception;
        r12 = r5;
        r5 = r4;
        r4 = r12;
    L_0x032c:
        r6 = r14.qkz;	 Catch:{ all -> 0x05bf }
        r0 = r0.getMessage();	 Catch:{ all -> 0x05bf }
        r6.FY(r0);	 Catch:{ all -> 0x05bf }
        if (r2 == 0) goto L_0x033a;
    L_0x0337:
        r2.close();	 Catch:{ IOException -> 0x05c7 }
    L_0x033a:
        if (r3 == 0) goto L_0x033f;
    L_0x033c:
        r3.close();	 Catch:{ IOException -> 0x05c7 }
    L_0x033f:
        if (r1 == 0) goto L_0x0344;
    L_0x0341:
        r1.disconnect();
    L_0x0344:
        r1 = qkv;
        monitor-enter(r1);
        r0 = qku;	 Catch:{ all -> 0x0462 }
        r2 = 0;
        r2 = r15[r2];	 Catch:{ all -> 0x0462 }
        r0.remove(r2);	 Catch:{ all -> 0x0462 }
        monitor-exit(r1);	 Catch:{ all -> 0x0462 }
        r0 = 0;
        r0 = r15[r0];
        r0 = com.tencent.smtt.utils.i.aV(r0);
        r1 = r14.bfy();
        r2 = com.tencent.mm.sdk.platformtools.bg.aA(r8);
        r2 = (int) r2;
        r3 = new com.tencent.mm.modelsns.d;
        r3.<init>();
        r5 = "20UrlMd5";
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r0 = r6.append(r0);
        r6 = ",";
        r0 = r0.append(r6);
        r0 = r0.toString();
        r3.n(r5, r0);
        r0 = "21MediaType";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r1 = r5.append(r1);
        r5 = ",";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r3.n(r0, r1);
        r1 = "22IsPreload";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = r14.qkB;
        if (r0 == 0) goto L_0x0465;
    L_0x03a5:
        r0 = 1;
    L_0x03a6:
        r0 = r5.append(r0);
        r5 = ",";
        r0 = r0.append(r5);
        r0 = r0.toString();
        r3.n(r1, r0);
        r0 = "23CostTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "24RetCode";
        r1 = new java.lang.StringBuilder;
        r2 = "-1,";
        r1.<init>(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "25Scene";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r14.scene;
        r1 = r1.append(r2);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "26Size";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "27StartDownloadTime";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r4 = r8 / r4;
        r1 = r1.append(r4);
        r2 = ",";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3.n(r0, r1);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r1 = new java.lang.StringBuilder;
        r2 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r1.<init>(r2);
        r2 = r3.JG();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r4 = 0;
        r2[r4] = r3;
        r0.i(r1, r2);
        r0 = 0;
        goto L_0x0010;
    L_0x0462:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0462 }
        throw r0;
    L_0x0465:
        r0 = 0;
        goto L_0x03a6;
    L_0x0468:
        r0 = move-exception;
        r6 = r4;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x046d:
        if (r2 == 0) goto L_0x0472;
    L_0x046f:
        r2.close();	 Catch:{ IOException -> 0x05a6 }
    L_0x0472:
        if (r3 == 0) goto L_0x0477;
    L_0x0474:
        r3.close();	 Catch:{ IOException -> 0x05a6 }
    L_0x0477:
        if (r0 == 0) goto L_0x047c;
    L_0x0479:
        r0.disconnect();
    L_0x047c:
        r2 = qkv;
        monitor-enter(r2);
        r0 = qku;	 Catch:{ all -> 0x05a0 }
        r3 = 0;
        r3 = r15[r3];	 Catch:{ all -> 0x05a0 }
        r0.remove(r3);	 Catch:{ all -> 0x05a0 }
        monitor-exit(r2);	 Catch:{ all -> 0x05a0 }
        r0 = 0;
        r0 = r15[r0];
        r0 = com.tencent.smtt.utils.i.aV(r0);
        r2 = r14.bfy();
        r10 = com.tencent.mm.sdk.platformtools.bg.aA(r8);
        r3 = (int) r10;
        r4 = new com.tencent.mm.modelsns.d;
        r4.<init>();
        r7 = "20UrlMd5";
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r0 = r10.append(r0);
        r10 = ",";
        r0 = r0.append(r10);
        r0 = r0.toString();
        r4.n(r7, r0);
        r0 = "21MediaType";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r2 = r7.append(r2);
        r7 = ",";
        r2 = r2.append(r7);
        r2 = r2.toString();
        r4.n(r0, r2);
        r2 = "22IsPreload";
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r0 = r14.qkB;
        if (r0 == 0) goto L_0x05a3;
    L_0x04dd:
        r0 = 1;
    L_0x04de:
        r0 = r7.append(r0);
        r7 = ",";
        r0 = r0.append(r7);
        r0 = r0.toString();
        r4.n(r2, r0);
        r0 = "23CostTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "24RetCode";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "25Scene";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r14.scene;
        r2 = r2.append(r3);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "26Size";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r5);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "27StartDownloadTime";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r8 / r6;
        r2 = r2.append(r6);
        r3 = ",";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r4.n(r0, r2);
        r0 = "MicroMsg.LandingpageDowloadAsynTask";
        r2 = new java.lang.StringBuilder;
        r3 = "report logbuffer MM_KVSTAT_AdDownload(13572): ";
        r2.<init>(r3);
        r3 = r4.JG();
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r2 = 13572; // 0x3504 float:1.9018E-41 double:6.7055E-320;
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r5 = 0;
        r3[r5] = r4;
        r0.i(r2, r3);
        throw r1;
    L_0x05a0:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x05a0 }
        throw r0;
    L_0x05a3:
        r0 = 0;
        goto L_0x04de;
    L_0x05a6:
        r2 = move-exception;
        goto L_0x0477;
    L_0x05a9:
        r1 = move-exception;
        r6 = r4;
        goto L_0x046d;
    L_0x05ad:
        r1 = move-exception;
        goto L_0x046d;
    L_0x05b0:
        r1 = move-exception;
        r3 = r4;
        goto L_0x046d;
    L_0x05b4:
        r1 = move-exception;
        r2 = r3;
        r3 = r4;
        goto L_0x046d;
    L_0x05b9:
        r1 = move-exception;
        r5 = r2;
        r2 = r3;
        r3 = r4;
        goto L_0x046d;
    L_0x05bf:
        r0 = move-exception;
        r6 = r5;
        r5 = r4;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x046d;
    L_0x05c7:
        r0 = move-exception;
        goto L_0x033f;
    L_0x05ca:
        r1 = move-exception;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        r13 = r5;
        r5 = r4;
        r4 = r13;
        goto L_0x032c;
    L_0x05d3:
        r1 = move-exception;
        r4 = r5;
        r5 = r6;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x032c;
    L_0x05db:
        r1 = move-exception;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r12 = r0;
        r0 = r1;
        r1 = r12;
        goto L_0x032c;
    L_0x05e4:
        r1 = move-exception;
        r2 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r6;
        r12 = r1;
        r1 = r0;
        r0 = r12;
        goto L_0x032c;
    L_0x05ee:
        r1 = move-exception;
        r5 = r6;
        r12 = r0;
        r0 = r1;
        r1 = r12;
        r13 = r4;
        r4 = r2;
        r2 = r3;
        r3 = r13;
        goto L_0x032c;
    L_0x05f9:
        r1 = move-exception;
        goto L_0x01f7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac.x(java.lang.String[]):java.lang.Void");
    }

    private int bfy() {
        switch (this.qkC) {
            case v.CTRL_BYTE /*41*/:
            case 44:
            case 45:
            case 1000000001:
                return 1;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                return 2;
            case 62:
                return 3;
            default:
                return 0;
        }
    }
}
