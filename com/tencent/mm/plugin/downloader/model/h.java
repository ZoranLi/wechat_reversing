package com.tencent.mm.plugin.downloader.model;

import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h extends i {
    public aj irQ = new aj(new a(this) {
        final /* synthetic */ h kHj;

        {
            this.kHj = r1;
        }

        public final boolean oQ() {
            com.tencent.mm.kernel.h.vL().D(new Runnable(this.kHj) {
                final /* synthetic */ h kHj;

                {
                    this.kHj = r1;
                }

                public final void run() {
                    try {
                        Iterator it = this.kHj.kHi.iterator();
                        while (it.hasNext()) {
                            this.kHj.g(Long.valueOf(((Long) it.next()).longValue()));
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.FileDownloaderImpl23", e.getMessage());
                    }
                }
            });
            h hVar = this.kHj;
            boolean z = hVar.kHi == null || hVar.kHi.size() == 0;
            if (z) {
                w.d("MicroMsg.FileDownloaderImpl23", "timer stop");
            } else {
                this.kHj.irQ.v(1000, 1000);
            }
            return false;
        }
    }, false);
    private DownloadManager kHh = ((DownloadManager) this.mContext.getSystemService("download"));
    public CopyOnWriteArraySet<Long> kHi = new CopyOnWriteArraySet();
    private Context mContext = ab.getContext();

    public h(b bVar) {
        super(bVar);
    }

    public final long a(final f fVar) {
        if (fVar == null || bg.mA(fVar.iyZ)) {
            w.e("MicroMsg.FileDownloaderImpl23", "Invalid Request");
            return -1;
        } else if (fVar.kGZ) {
            w.e("MicroMsg.FileDownloaderImpl23", "autoDownloadTask not use system downloader, appid = %s", fVar.ivH);
            return -1;
        } else {
            String str = fVar.iyZ;
            String str2 = "";
            com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
            if (tH != null) {
                FileDownloadTaskInfo bf = bf(tH.field_sysDownloadId);
                if (bf.status == 1) {
                    return bf.id;
                }
                str2 = tH.field_filePath;
                this.kHh.remove(new long[]{tH.field_sysDownloadId});
            }
            String absolutePath = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();
            if (!bg.mA(absolutePath)) {
                File file = new File(absolutePath);
                if (!file.exists()) {
                    boolean mkdir = file.mkdir();
                    w.i("MicroMsg.FileDownloaderImpl23", "download folder not exist, make new one : [%b]", Boolean.valueOf(mkdir));
                }
            }
            i.tQ(str2);
            d.tF(str);
            d.tG(fVar.ivH);
            final com.tencent.mm.plugin.downloader.b.a b = g.b(fVar);
            b.field_downloadId = System.currentTimeMillis();
            b.field_status = 0;
            b.field_downloaderType = 1;
            b.field_filePath = com.tencent.mm.compatible.util.h.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + aa.Pq(str);
            b.field_startTime = System.currentTimeMillis();
            d.a(b);
            com.tencent.mm.kernel.h.vL().D(new Runnable(this) {
                final /* synthetic */ h kHj;

                public final void run() {
                    if (fVar.kGY) {
                        b.field_md5 = g.tP(b.field_downloadUrl);
                    }
                    long c = this.kHj.c(b);
                    if (c > 0) {
                        b.field_sysDownloadId = c;
                        b.field_status = 1;
                        d.b(b);
                        this.kHj.kGM.h(b.field_downloadId, b.field_filePath);
                        e.akM();
                        if (e.bc(b.field_downloadId)) {
                            e.akM();
                            e.g(b.field_downloadId, c);
                        }
                        this.kHj.kHi.add(Long.valueOf(b.field_downloadId));
                        if (this.kHj.irQ.bJq()) {
                            this.kHj.irQ.v(100, 100);
                        }
                        w.i("MicroMsg.FileDownloaderImpl23", "addDownloadTask: id: %d, url: %s, path: %s", Long.valueOf(b.field_downloadId), b.field_downloadUrl, b.field_filePath);
                        return;
                    }
                    b.field_status = 4;
                    d.b(b);
                    this.kHj.kGM.c(b.field_downloadId, c.kGB, false);
                    w.e("MicroMsg.FileDownloaderImpl23", "addDownloadTask Failed: Invalid downloadId");
                }
            });
            return b.field_downloadId;
        }
    }

    public final int aT(long j) {
        int remove;
        Exception e;
        e.akM();
        if (e.bc(j)) {
            e.akM();
            long bd = e.bd(j);
            return this.kHh.remove(new long[]{bd});
        }
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null) {
            w.e("MicroMsg.FileDownloaderImpl23", "Invalid id");
            return 0;
        }
        try {
            remove = this.kHh.remove(new long[]{ba.field_sysDownloadId});
            try {
                w.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: id: %d", Long.valueOf(j));
            } catch (Exception e2) {
                e = e2;
                w.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
                b.deleteFile(ba.field_filePath);
                w.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", ba.field_filePath);
                ba.field_status = 5;
                d.b(ba);
                this.kGM.aX(j);
                this.kHi.remove(Long.valueOf(j));
                return remove;
            }
        } catch (Exception e3) {
            e = e3;
            remove = 0;
            w.e("MicroMsg.FileDownloaderImpl23", "remove task error:[%d], [%s]", Long.valueOf(j), e.toString());
            b.deleteFile(ba.field_filePath);
            w.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", ba.field_filePath);
            ba.field_status = 5;
            d.b(ba);
            this.kGM.aX(j);
            this.kHi.remove(Long.valueOf(j));
            return remove;
        }
        b.deleteFile(ba.field_filePath);
        w.i("MicroMsg.FileDownloaderImpl23", "removeDownloadTask: path: %s", ba.field_filePath);
        ba.field_status = 5;
        d.b(ba);
        this.kGM.aX(j);
        this.kHi.remove(Long.valueOf(j));
        return remove;
    }

    public final FileDownloadTaskInfo aU(long j) {
        e.akM();
        if (e.bc(j)) {
            e.akM();
            FileDownloadTaskInfo bf = bf(e.bd(j));
            bf.id = j;
            bf.fLG = 1;
            return bf;
        }
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null) {
            return new FileDownloadTaskInfo();
        }
        if (ba.field_status == 4 || ba.field_status == 2 || ba.field_status == 5 || ba.field_status == 3) {
            this.kHi.remove(Long.valueOf(j));
        }
        bf = new FileDownloadTaskInfo();
        bf.id = ba.field_downloadId;
        bf.url = ba.field_downloadUrl;
        bf.status = ba.field_status;
        bf.path = ba.field_filePath;
        bf.fFW = ba.field_md5;
        bf.kHg = ba.field_autoDownload;
        bf.fLG = ba.field_downloaderType;
        bf.fLg = ba.field_downloadedSize;
        bf.fLh = ba.field_totalSize;
        return bf;
    }

    public final long c(com.tencent.mm.plugin.downloader.b.a aVar) {
        try {
            Request request = new Request(Uri.parse(aVar.field_downloadUrl));
            request.setAllowedNetworkTypes(3);
            request.setShowRunningNotification(aVar.field_showNotification);
            request.setVisibleInDownloadsUi(aVar.field_showNotification);
            if (!bg.mA(aVar.field_fileName)) {
                request.setTitle(aVar.field_fileName);
            }
            request.setDestinationUri(Uri.fromFile(new File(aVar.field_filePath)));
            long enqueue = this.kHh.enqueue(request);
            if (enqueue > 0) {
                return enqueue;
            }
            w.e("MicroMsg.FileDownloaderImpl23", "addToSysDownloadManager Failed: Invalid downloadId");
            return -1;
        } catch (Exception e) {
            w.e("MicroMsg.FileDownloaderImpl23", "Add download task failed: %s, url: %s", e.toString(), aVar.field_downloadUrl);
            return -1;
        }
    }

    private FileDownloadTaskInfo bf(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        Query query = new Query();
        query.setFilterById(new long[]{j});
        try {
            Cursor query2 = this.kHh.query(query);
            if (query2 == null) {
                w.e("MicroMsg.FileDownloaderImpl23", "query download status failed: cursor is null");
            } else {
                if (query2.moveToFirst()) {
                    int columnIndex = query2.getColumnIndex(DownloadInfo.STATUS);
                    int columnIndex2 = query2.getColumnIndex("uri");
                    int columnIndex3 = query2.getColumnIndex("local_uri");
                    int columnIndex4 = query2.getColumnIndex("bytes_so_far");
                    int columnIndex5 = query2.getColumnIndex("total_size");
                    if (columnIndex != -1) {
                        try {
                            switch (query2.getInt(columnIndex)) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 8:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 16:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.FileDownloaderImpl23", "query download info failed: [%s]", e.toString());
                            fileDownloadTaskInfo.status = 4;
                        }
                    }
                    if (columnIndex2 != -1) {
                        fileDownloadTaskInfo.url = query2.getString(columnIndex2);
                    }
                    if (columnIndex3 != -1) {
                        String string = query2.getString(columnIndex3);
                        if (bg.mA(string)) {
                            w.e("MicroMsg.FileDownloaderImpl23", "get download uri failed");
                        } else {
                            w.i("MicroMsg.FileDownloaderImpl23", "get download uri: [%s]", string);
                            fileDownloadTaskInfo.path = Uri.parse(string).getPath();
                            w.i("MicroMsg.FileDownloaderImpl23", "get download path: [%s]", fileDownloadTaskInfo.path);
                        }
                    }
                    if (columnIndex4 != -1) {
                        fileDownloadTaskInfo.fLg = query2.getLong(columnIndex4);
                    }
                    if (columnIndex5 != -1) {
                        fileDownloadTaskInfo.fLh = query2.getLong(columnIndex5);
                    }
                }
                query2.close();
                w.i("MicroMsg.FileDownloaderImpl23", "querySysDownloadManager: id: %d, status: %d, url: %s, path: %s", Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path);
            }
        } catch (Exception e2) {
            w.e("MicroMsg.FileDownloaderImpl23", "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d", e2.toString(), Long.valueOf(j));
        }
        return fileDownloadTaskInfo;
    }

    public final boolean aV(long j) {
        FileDownloadTaskInfo aU = aU(j);
        if (aU == null) {
            w.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        }
        this.kHi.remove(Long.valueOf(j));
        if (aU.status != 1) {
            w.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task is not running", Long.valueOf(j));
            return true;
        }
        w.i("MicroMsg.FileDownloaderImpl23", "pauseDownloadTask: %d, Task removed: %d", Long.valueOf(j), Integer.valueOf(aT(j)));
        if (aT(j) > 0) {
            return true;
        }
        return false;
    }

    public final boolean aW(long j) {
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null) {
            w.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, record not found", Long.valueOf(j));
            return false;
        } else if (ba.field_downloaderType != 1) {
            w.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, downloader not matched", Long.valueOf(j));
            b.deleteFile(ba.field_filePath);
            d.bb(j);
            return false;
        } else if (ba.field_status == 1) {
            w.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, not in paused status", Long.valueOf(j));
            return false;
        } else {
            this.kHh.remove(new long[]{ba.field_sysDownloadId});
            long c = c(ba);
            if (c > 0) {
                this.kHi.add(Long.valueOf(ba.field_downloadId));
                if (this.irQ.bJq()) {
                    this.irQ.v(100, 100);
                }
                ba.field_sysDownloadId = c;
                ba.field_status = 1;
                d.b(ba);
                return true;
            }
            w.i("MicroMsg.FileDownloaderImpl23", "resumeDownloadTask: %d, restart failed");
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(java.lang.Long r12) {
        /*
        r11 = this;
        r0 = "MicroMsg.FileDownloaderImpl23";
        r1 = "updateDownloadStatus";
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r0 = r12.longValue();
        r1 = com.tencent.mm.plugin.downloader.model.d.ba(r0);
        if (r1 != 0) goto L_0x0014;
    L_0x0013:
        return;
    L_0x0014:
        r0 = new android.app.DownloadManager$Query;
        r0.<init>();
        r2 = 1;
        r2 = new long[r2];
        r3 = 0;
        r4 = r1.field_sysDownloadId;
        r2[r3] = r4;
        r0.setFilterById(r2);
        r2 = r11.kHh;	 Catch:{ Exception -> 0x0041 }
        r2 = r2.query(r0);	 Catch:{ Exception -> 0x0041 }
        if (r2 != 0) goto L_0x0064;
    L_0x002c:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r2 = "query download status failed: cursor is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        r0 = r11.kHi;
        r0.remove(r12);
        r0 = 4;
        r1.field_status = r0;
        com.tencent.mm.plugin.downloader.model.d.b(r1);
        goto L_0x0013;
    L_0x0041:
        r0 = move-exception;
        r2 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query downloadinfo from downloadmanager failed:%s, sysDownloadId:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.toString();
        r4[r5] = r0;
        r0 = 1;
        r4[r0] = r12;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        r0 = r11.kHi;
        r0.remove(r12);
        r0 = 4;
        r1.field_status = r0;
        com.tencent.mm.plugin.downloader.model.d.b(r1);
        goto L_0x0013;
    L_0x0064:
        r0 = r2.moveToFirst();
        if (r0 == 0) goto L_0x00a3;
    L_0x006a:
        r0 = "status";
        r0 = r2.getColumnIndex(r0);
        r3 = "local_uri";
        r3 = r2.getColumnIndex(r3);
        r4 = "bytes_so_far";
        r4 = r2.getColumnIndex(r4);
        r5 = "total_size";
        r5 = r2.getColumnIndex(r5);
        r6 = -1;
        if (r0 == r6) goto L_0x00a3;
    L_0x0089:
        r0 = r2.getInt(r0);	 Catch:{ Exception -> 0x00ca }
        r6 = "MicroMsg.FileDownloaderImpl23";
        r7 = "status = %d";
        r8 = 1;
        r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x00ca }
        r9 = 0;
        r10 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x00ca }
        r8[r9] = r10;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.sdk.platformtools.w.d(r6, r7, r8);	 Catch:{ Exception -> 0x00ca }
        switch(r0) {
            case 1: goto L_0x00a8;
            case 2: goto L_0x00a8;
            case 4: goto L_0x0102;
            case 8: goto L_0x0117;
            case 16: goto L_0x00ea;
            default: goto L_0x00a3;
        };
    L_0x00a3:
        r2.close();
        goto L_0x0013;
    L_0x00a8:
        r0 = -1;
        if (r4 == r0) goto L_0x00b1;
    L_0x00ab:
        r6 = r2.getLong(r4);	 Catch:{ Exception -> 0x00ca }
        r1.field_downloadedSize = r6;	 Catch:{ Exception -> 0x00ca }
    L_0x00b1:
        r0 = -1;
        if (r5 == r0) goto L_0x00ba;
    L_0x00b4:
        r4 = r2.getLong(r5);	 Catch:{ Exception -> 0x00ca }
        r1.field_totalSize = r4;	 Catch:{ Exception -> 0x00ca }
    L_0x00ba:
        r0 = 1;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.plugin.downloader.model.d.b(r1);	 Catch:{ Exception -> 0x00ca }
        r0 = r11.kGM;	 Catch:{ Exception -> 0x00ca }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00ca }
        r0.aZ(r4);	 Catch:{ Exception -> 0x00ca }
        goto L_0x00a3;
    L_0x00ca:
        r0 = move-exception;
        r3 = r11.kHi;
        r3.remove(r12);
        r3 = 4;
        r1.field_status = r3;
        com.tencent.mm.plugin.downloader.model.d.b(r1);
        r1 = "MicroMsg.FileDownloaderImpl23";
        r3 = "query download info failed: [%s]";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = r0.toString();
        r4[r5] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r3, r4);
        goto L_0x00a3;
    L_0x00ea:
        r0 = r11.kHi;	 Catch:{ Exception -> 0x00ca }
        r0.remove(r12);	 Catch:{ Exception -> 0x00ca }
        r0 = com.tencent.mm.plugin.downloader.model.c.kGB;	 Catch:{ Exception -> 0x00ca }
        r3 = 4;
        r1.field_status = r3;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.plugin.downloader.model.d.b(r1);	 Catch:{ Exception -> 0x00ca }
        r3 = r11.kGM;	 Catch:{ Exception -> 0x00ca }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00ca }
        r6 = 0;
        r3.c(r4, r0, r6);	 Catch:{ Exception -> 0x00ca }
        goto L_0x00a3;
    L_0x0102:
        r0 = r11.kHi;	 Catch:{ Exception -> 0x00ca }
        r0.remove(r12);	 Catch:{ Exception -> 0x00ca }
        r0 = 2;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.plugin.downloader.model.d.b(r1);	 Catch:{ Exception -> 0x00ca }
        r0 = r11.kGM;	 Catch:{ Exception -> 0x00ca }
        r4 = r12.longValue();	 Catch:{ Exception -> 0x00ca }
        r0.aY(r4);	 Catch:{ Exception -> 0x00ca }
        goto L_0x00a3;
    L_0x0117:
        r0 = r11.kHi;	 Catch:{ Exception -> 0x00ca }
        r0.remove(r12);	 Catch:{ Exception -> 0x00ca }
        r0 = -1;
        if (r3 == r0) goto L_0x00a3;
    L_0x011f:
        r0 = r1.field_filePath;	 Catch:{ Exception -> 0x00ca }
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ Exception -> 0x00ca }
        if (r0 != 0) goto L_0x012f;
    L_0x0127:
        r0 = r1.field_filePath;	 Catch:{ Exception -> 0x00ca }
        r0 = com.tencent.mm.a.e.aO(r0);	 Catch:{ Exception -> 0x00ca }
        if (r0 != 0) goto L_0x0148;
    L_0x012f:
        r0 = "MicroMsg.FileDownloaderImpl23";
        r3 = "path not exists, path = %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x00ca }
        r5 = 0;
        r6 = r1.field_filePath;	 Catch:{ Exception -> 0x00ca }
        r4[r5] = r6;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.sdk.platformtools.w.e(r0, r3, r4);	 Catch:{ Exception -> 0x00ca }
        r0 = 4;
        r1.field_status = r0;	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.plugin.downloader.model.d.b(r1);	 Catch:{ Exception -> 0x00ca }
        goto L_0x0013;
    L_0x0148:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x00ca }
        r0.<init>();	 Catch:{ Exception -> 0x00ca }
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x00ca }
        r4 = com.tencent.mm.plugin.downloader.model.FileDownloadService.class;
        r0.setClass(r3, r4);	 Catch:{ Exception -> 0x00ca }
        r3 = com.tencent.mm.plugin.downloader.model.FileDownloadService.EXTRA_ID;	 Catch:{ Exception -> 0x00ca }
        r4 = r1.field_downloadId;	 Catch:{ Exception -> 0x00ca }
        r0.putExtra(r3, r4);	 Catch:{ Exception -> 0x00ca }
        r3 = com.tencent.mm.plugin.downloader.model.FileDownloadService.kHc;	 Catch:{ Exception -> 0x00ca }
        r4 = 1;
        r0.putExtra(r3, r4);	 Catch:{ Exception -> 0x00ca }
        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x00ca }
        r0 = r3.startService(r0);	 Catch:{ Exception -> 0x00ca }
        r3 = "MicroMsg.FileDownloaderImpl23";
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ca }
        r5 = "start download service: ";
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ca }
        r5 = r0.getClassName();	 Catch:{ Exception -> 0x00ca }
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ca }
        r5 = ", ";
        r4 = r4.append(r5);	 Catch:{ Exception -> 0x00ca }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x00ca }
        r0 = r4.append(r0);	 Catch:{ Exception -> 0x00ca }
        r0 = r0.toString();	 Catch:{ Exception -> 0x00ca }
        com.tencent.mm.sdk.platformtools.w.d(r3, r0);	 Catch:{ Exception -> 0x00ca }
        goto L_0x00a3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader.model.h.g(java.lang.Long):void");
    }
}
