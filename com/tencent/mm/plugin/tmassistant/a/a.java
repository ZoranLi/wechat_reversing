package com.tencent.mm.plugin.tmassistant.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import android.support.v4.app.y;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fv;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.plugin.downloader.model.FileDownloadService;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.plugin.downloader.model.i;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.downloadservice.TMAssistantDownloadSDKService;
import com.tencent.tmassistantsdk.storage.TMAssistantFile;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends i {
    private byte[] hAl = new byte[0];
    private TMAssistantDownloadSDKClient mClient = null;
    public Context mContext = ab.getContext();
    public aj mxd = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ a raB;

        {
            this.raB = r1;
        }

        public final boolean oQ() {
            if (!this.raB.boh()) {
                this.raB.mxd.v(240000, 240000);
            }
            return true;
        }
    }, false);
    private HashMap<String, Long> rat = new HashMap();
    public HashMap<String, Long> rau = new HashMap();
    private ConcurrentHashMap<String, Integer> rav = new ConcurrentHashMap();
    public HashSet<Long> raw = new HashSet();
    public Map<String, String> rax = null;
    private ITMAssistantDownloadSDKClientListener ray = new ITMAssistantDownloadSDKClientListener(this) {
        final /* synthetic */ a raB;

        {
            this.raB = r1;
        }

        public final void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
            w.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Service unavailable");
            Iterator it = this.raB.raw.iterator();
            while (it.hasNext()) {
                com.tencent.mm.plugin.downloader.b.a ba = d.ba(((Long) it.next()).longValue());
                if (ba != null) {
                    d.j(ba.field_downloadId, 4);
                    a.g(ba.field_downloadId, c.kGu, false);
                    this.raB.b(ba.field_downloadUrl, 5, 0, false);
                }
            }
            this.raB.raw.clear();
            a.a(101, 0, "");
        }

        public final void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i, int i2, String str2, boolean z, boolean z2) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "OnDownloadSDKTaskStateChanged State: " + i + " | ErrorCode: " + i2 + " | ErrorMsg: " + str2);
            com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
            if (tH == null) {
                w.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                return;
            }
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "State: %d, Id: %d, Path: %s, File Exists: %b, URL: %s", new Object[]{Integer.valueOf(i), Long.valueOf(tH.field_downloadId), tH.field_filePath, Boolean.valueOf(new File(tH.field_filePath).exists()), str});
            switch (i) {
                case 1:
                    return;
                case 2:
                    d.j(tH.field_downloadId, 1);
                    return;
                case 3:
                    d.j(tH.field_downloadId, 2);
                    this.raB.cancelNotification(str);
                    this.raB.raw.remove(Long.valueOf(tH.field_downloadId));
                    return;
                case 4:
                    w.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant Download Succeed event received");
                    if (z2) {
                        b gnVar = new gn();
                        gnVar.fLN.appId = tH.field_appId;
                        gnVar.fLN.opType = 6;
                        com.tencent.mm.sdk.b.a.urY.m(gnVar);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kHc, 1);
                    intent.setClass(this.raB.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, tH.field_downloadId);
                    intent.putExtra(FileDownloadService.kHf, z);
                    try {
                        this.raB.mContext.startService(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.FileDownloaderImplTMAssistant", e.getMessage());
                    }
                    this.raB.cancelNotification(str);
                    this.raB.raw.remove(Long.valueOf(tH.field_downloadId));
                    return;
                case 5:
                    this.raB.b(str, i, 0, false);
                    this.raB.raw.remove(Long.valueOf(tH.field_downloadId));
                    tH.field_errCode = i2;
                    tH.field_status = 4;
                    d.b(tH);
                    a.g(tH.field_downloadId, i2, z);
                    if (i2 == 601 || i2 == 602 || i2 == 603 || i2 == 605 || i2 == 606) {
                        w.d("MicroMsg.FileDownloaderImplTMAssistant", "releaseTimer 4 min");
                        this.raB.mxd.v(240000, 240000);
                        return;
                    }
                    return;
                case 6:
                    this.raB.cancelNotification(str);
                    this.raB.raw.remove(Long.valueOf(tH.field_downloadId));
                    d.j(tH.field_downloadId, 5);
                    a.I(5, tH.field_downloadId);
                    return;
                default:
                    return;
            }
        }

        public final void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            Long l = (Long) this.raB.rau.get(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                this.raB.rau.put(str, valueOf);
                w.i("MicroMsg.FileDownloaderImplTMAssistant", "onProgressChanged");
                this.raB.b(str, 2, (int) ((100 * j) / j2), false);
                com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
                if (tH == null) {
                    w.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadInfoByURL failed");
                    return;
                }
                d.e(tH.field_downloadId, j, j2);
                a.I(7, tH.field_downloadId);
            }
        }
    };

    public a() {
        super(null);
        Map hashMap = new HashMap();
        String property = System.getProperty("http.agent");
        w.i("MicroMsg.FileDownloaderImplTMAssistant", property);
        if (bg.mA(property)) {
            property = "Mozilla/5.0 (Linux; Android) AppleWebkit (KHTML, like Gecko)";
        }
        property = property + " MicroMessenger";
        PackageInfo az = az(this.mContext, ab.getPackageName());
        if (az != null) {
            property = ((property + "/") + az.versionName) + "." + az.versionCode;
        }
        w.i("MicroMsg.FileDownloaderImplTMAssistant", "User-Agent: %s", new Object[]{property + " NetType/" + am.getNetTypeString(ab.getContext())});
        hashMap.put("User-Agent", property);
        this.rax = hashMap;
    }

    public final long a(f fVar) {
        if (fVar == null || bg.mA(fVar.iyZ)) {
            w.e("MicroMsg.FileDownloaderImplTMAssistant", "Invalid Request");
            return -1;
        }
        final String str = fVar.iyZ;
        final String str2 = fVar.kGS;
        final long j = fVar.kGT;
        String str3 = fVar.ivH;
        com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
        if (tH != null) {
            FileDownloadTaskInfo aU = aU(tH.field_downloadId);
            if (aU.status == 1) {
                return aU.id;
            }
        }
        boi();
        d.tF(str);
        d.tG(str3);
        final com.tencent.mm.plugin.downloader.b.a b = g.b(fVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_status = 0;
        b.field_downloaderType = 2;
        b.field_startTime = System.currentTimeMillis();
        d.a(b);
        final f fVar2 = fVar;
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ a raB;

            public final void run() {
                Exception exception;
                int i;
                if (fVar2.kGY) {
                    b.field_md5 = g.tP(b.field_downloadUrl);
                }
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = this.raB.getClient().getDownloadTaskState(str);
                    if (downloadTaskState != null && downloadTaskState.mState == 4) {
                        a.tQ(downloadTaskState.mSavePath);
                        w.i("MicroMsg.FileDownloaderImplTMAssistant", "Previous task file removed: %s, %s", new Object[]{downloadTaskState.mUrl, downloadTaskState.mSavePath});
                    }
                    this.raB.getClient().cancelDownloadTask(str);
                    int startDownloadTask = this.raB.getClient().startDownloadTask(str, str2, j, 0, "resource/tm.android.unknown", aa.Pq(str), this.raB.rax);
                    if (startDownloadTask == 0) {
                        try {
                            TMAssistantDownloadTaskInfo downloadTaskState2 = this.raB.getClient().getDownloadTaskState(str);
                            w.i("MicroMsg.FileDownloaderImplTMAssistant", "Task Info from TMAssistant: URL: %s, PATH: %s", new Object[]{str, downloadTaskState2.mSavePath});
                            long j = b.field_downloadId;
                            String str = downloadTaskState2.mSavePath;
                            com.tencent.mm.plugin.downloader.b.b wX = d.wX();
                            if (!(wX == null || bg.mA(str))) {
                                wX.eE("FileDownloadInfo", "update FileDownloadInfo set filePath = \"" + str + "\" where downloadId = " + j);
                            }
                            d.e(b.field_downloadId, downloadTaskState2.mReceiveDataLen, downloadTaskState2.mTotalDataLen);
                            this.raB.raw.add(Long.valueOf(b.field_downloadId));
                            this.raB.b(str, downloadTaskState2.mState, 0, true);
                            a.a(1, b.field_downloadId, downloadTaskState2.mSavePath);
                            w.i("MicroMsg.FileDownloaderImplTMAssistant", "addDownloadTask: id: %d, url: %s, path: %s", new Object[]{Long.valueOf(b.field_downloadId), str, b.field_filePath});
                            return;
                        } catch (Exception e) {
                            exception = e;
                            i = startDownloadTask;
                            w.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{exception.toString()});
                            b.field_errCode = c.kGv;
                            b.field_status = 4;
                            d.b(b);
                            w.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(i), str});
                            a.g(b.field_downloadId, c.kGv, false);
                        }
                    }
                    i = startDownloadTask;
                    b.field_errCode = c.kGv;
                    b.field_status = 4;
                    d.b(b);
                    w.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(i), str});
                    a.g(b.field_downloadId, c.kGv, false);
                } catch (Exception e2) {
                    exception = e2;
                    i = -1;
                    w.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding task to TMAssistant failed: ", new Object[]{exception.toString()});
                    b.field_errCode = c.kGv;
                    b.field_status = 4;
                    d.b(b);
                    w.e("MicroMsg.FileDownloaderImplTMAssistant", "Adding Task via TMAssistant Failed: %d, url: %s", new Object[]{Integer.valueOf(i), str});
                    a.g(b.field_downloadId, c.kGv, false);
                }
            }
        });
        return b.field_downloadId;
    }

    public final int aT(final long j) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ a raB;

            public final void run() {
                com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
                if (ba != null) {
                    try {
                        this.raB.getClient().cancelDownloadTask(ba.field_downloadUrl);
                        com.tencent.mm.loader.stub.b.deleteFile(ba.field_filePath);
                        d.j(ba.field_downloadId, 5);
                        a.I(5, ba.field_downloadId);
                        this.raB.raw.remove(Long.valueOf(ba.field_downloadId));
                        this.raB.cancelNotification(ba.field_downloadUrl);
                        w.i("MicroMsg.FileDownloaderImplTMAssistant", "removeDownloadTask: id: %d, path: %s", new Object[]{Long.valueOf(j), ba.field_filePath});
                    } catch (Exception e) {
                        w.e("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistant remove task failed: " + e.toString());
                    }
                }
            }
        });
        return 1;
    }

    public final FileDownloadTaskInfo aU(long j) {
        final FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        fileDownloadTaskInfo.id = j;
        final com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (!(ba == null || bg.mA(ba.field_downloadUrl))) {
            fileDownloadTaskInfo.url = ba.field_downloadUrl;
            fileDownloadTaskInfo.status = ba.field_status;
            new bb<Void>(this) {
                final /* synthetic */ a raB;

                protected final /* synthetic */ Object run() {
                    return boj();
                }

                private Void boj() {
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = this.raB.getClient().getDownloadTaskState(fileDownloadTaskInfo.url);
                        if (downloadTaskState == null) {
                            fileDownloadTaskInfo.status = 0;
                        } else {
                            switch (downloadTaskState.mState) {
                                case 1:
                                case 2:
                                    fileDownloadTaskInfo.status = 1;
                                    break;
                                case 3:
                                    fileDownloadTaskInfo.status = 2;
                                    break;
                                case 4:
                                    fileDownloadTaskInfo.status = 3;
                                    break;
                                case 5:
                                    fileDownloadTaskInfo.status = 4;
                                    break;
                                case 6:
                                    fileDownloadTaskInfo.status = 5;
                                    break;
                                default:
                                    fileDownloadTaskInfo.status = 0;
                                    break;
                            }
                            fileDownloadTaskInfo.path = downloadTaskState.mSavePath;
                            fileDownloadTaskInfo.fLg = downloadTaskState.mReceiveDataLen;
                            fileDownloadTaskInfo.fLh = downloadTaskState.mTotalDataLen;
                            fileDownloadTaskInfo.fFW = ba.field_md5;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.FileDownloaderImplTMAssistant", "getDownloadTaskState faile: " + e.toString());
                    }
                    return null;
                }
            }.b(ap.vL().bJl());
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "queryDownloadTask: id: %d, status: %d, url: %s, path: %s", new Object[]{Long.valueOf(j), Integer.valueOf(fileDownloadTaskInfo.status), fileDownloadTaskInfo.url, fileDownloadTaskInfo.path});
        }
        return fileDownloadTaskInfo;
    }

    public final boolean boh() {
        if (this.raw == null || this.raw.size() == 0) {
            TMAssistantDownloadSDKManager.getInstance(this.mContext).releaseDownloadSDKClient("WechatDownloadClient");
            if (this.mClient != null) {
                this.mClient.unRegisterDownloadTaskListener(this.ray);
            }
            this.mClient = null;
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
            try {
                this.mContext.stopService(new Intent(this.mContext, TMAssistantDownloadSDKService.class));
            } catch (Exception e) {
                w.e("MicroMsg.FileDownloaderImplTMAssistant", "Error occurred when stopping TMAssistant Service: " + e.toString());
            }
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "TMAssistantSDK Client released");
            return true;
        }
        w.i("MicroMsg.FileDownloaderImplTMAssistant", "Still have tasks running");
        return false;
    }

    public final TMAssistantDownloadSDKClient getClient() {
        if (this.mClient == null) {
            this.mClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient("WechatDownloadClient");
            this.mClient.registerDownloadTaskListener(this.ray);
        }
        this.mxd.v(240000, 240000);
        return this.mClient;
    }

    public final void b(String str, int i, int i2, boolean z) {
        com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
        if (tH == null) {
            w.e("MicroMsg.FileDownloaderImplTMAssistant", "updateNotification failed: null task info");
        } else if (tH.field_showNotification) {
            y.d dVar = new y.d(this.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                this.rat.put(str, Long.valueOf(currentTimeMillis));
                dVar.b(currentTimeMillis);
            } else {
                Long l = (Long) this.rat.get(str);
                if (l != null) {
                    dVar.b(l.longValue());
                }
            }
            dVar.a(tH.field_fileName);
            switch (i) {
                case 1:
                case 2:
                case 3:
                    boolean z2;
                    dVar.L(17301633);
                    if (i2 == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    dVar.b(100, i2, z2);
                    dVar.b(this.mContext.getString(R.l.ejX));
                    dVar.j(2, true);
                    long j = tH.field_downloadId;
                    Intent intent = new Intent(this.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.rR = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), intent, SQLiteDatabase.CREATE_IF_NECESSARY);
                    break;
                case 4:
                case 6:
                    cancelNotification(str);
                    return;
                case 5:
                    dVar.L(17301634);
                    dVar.o(true);
                    dVar.rR = PendingIntent.getActivity(ab.getContext(), 0, new Intent(), 0);
                    dVar.b(this.mContext.getString(R.l.ejW));
                    break;
            }
            synchronized (this.hAl) {
                if (z) {
                    this.rav.put(str, Integer.valueOf(ap.getNotification().b(dVar.build())));
                } else {
                    Integer num = (Integer) this.rav.get(str);
                    if (num != null) {
                        ap.getNotification().notify(num.intValue(), dVar.build());
                    }
                }
            }
        }
    }

    public final void cancelNotification(String str) {
        synchronized (this.hAl) {
            Integer num = (Integer) this.rav.get(str);
            if (num == null) {
                w.i("MicroMsg.FileDownloaderImplTMAssistant", "No notification id found");
                return;
            }
            ap.getNotification().cancel(num.intValue());
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "cancelNotification, id = " + num);
            this.rav.remove(str);
        }
    }

    private static PackageInfo az(Context context, String str) {
        PackageInfo packageInfo = null;
        if (str == null) {
            w.e("MicroMsg.FileDownloaderImplTMAssistant", "getPackageInfo fail, packageName is null");
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }

    private static void boi() {
        if (!new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").exists()) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "Make download dir result: %b", new Object[]{Boolean.valueOf(new File(TMAssistantFile.getSavePathRootDir() + "/.tmp/").mkdirs())});
        }
    }

    public final boolean aV(final long j) {
        final com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || bg.mA(ba.field_downloadUrl)) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (ba.field_downloaderType != 2) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.loader.stub.b.deleteFile(ba.field_filePath);
            d.bb(j);
            return false;
        } else {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a raB;

                public final void run() {
                    try {
                        TMAssistantDownloadTaskInfo downloadTaskState = this.raB.getClient().getDownloadTaskState(ba.field_downloadUrl);
                        if (downloadTaskState.mState == 1 || downloadTaskState.mState == 2) {
                            this.raB.getClient().pauseDownloadTask(ba.field_downloadUrl);
                            d.j(ba.field_downloadId, 2);
                            a.I(2, ba.field_downloadId);
                            this.raB.raw.remove(Long.valueOf(ba.field_downloadId));
                            this.raB.cancelNotification(ba.field_downloadUrl);
                            w.i("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %d ", new Object[]{Long.valueOf(j)});
                        }
                    } catch (Throwable e) {
                        w.e("MicroMsg.FileDownloaderImplTMAssistant", "pauseDownloadTask: %s", new Object[]{e.toString()});
                        w.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                    }
                }
            });
            return true;
        }
    }

    public final boolean aW(final long j) {
        final com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || bg.mA(ba.field_downloadUrl)) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, record not found", new Object[]{Long.valueOf(j)});
            return false;
        } else if (ba.field_downloaderType != 2) {
            w.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d, downloader type not matched", new Object[]{Long.valueOf(j)});
            com.tencent.mm.loader.stub.b.deleteFile(ba.field_filePath);
            d.bb(j);
            return false;
        } else {
            ba.field_startTime = System.currentTimeMillis();
            if (ba.field_status == 2) {
                ba.field_startState = c.kGD;
            } else {
                ba.field_startState = c.kGE;
            }
            ba.field_startSize = ba.field_downloadedSize;
            ba.field_errCode = 0;
            boi();
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a raB;

                public final void run() {
                    try {
                        if (this.raB.getClient().getDownloadTaskState(ba.field_downloadUrl).mState != 3) {
                            w.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask, not paused");
                            return;
                        }
                        if (this.raB.getClient().startDownloadTask(ba.field_downloadUrl, ba.field_secondaryUrl, ba.field_fileSize, 0, "resource/tm.android.unknown", ba.field_fileName, this.raB.rax) == 0) {
                            ba.field_status = 1;
                            d.b(ba);
                            this.raB.raw.add(Long.valueOf(ba.field_downloadId));
                            this.raB.b(ba.field_downloadUrl, 2, 0, true);
                            a.a(6, ba.field_downloadId, ba.field_filePath);
                            w.i("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %d", new Object[]{Long.valueOf(j)});
                            return;
                        }
                        ba.field_status = 4;
                        ba.field_errCode = c.kGw;
                        d.b(ba);
                        a.g(ba.field_downloadId, c.kGw, false);
                    } catch (Throwable e) {
                        w.e("MicroMsg.FileDownloaderImplTMAssistant", "resumeDownloadTask: %s", new Object[]{e.toString()});
                        w.printErrStackTrace("MicroMsg.FileDownloaderImplTMAssistant", e, "", new Object[0]);
                    }
                }
            });
            return true;
        }
    }

    public static void I(int i, long j) {
        a(i, j, "", 0, false);
    }

    public static void g(long j, int i, boolean z) {
        a(4, j, "", i, z);
    }

    public static void a(int i, long j, String str) {
        a(i, j, str, 0, false);
    }

    private static void a(int i, long j, String str, int i2, boolean z) {
        b fvVar = new fv();
        fvVar.fKZ.fLa = i;
        fvVar.fKZ.id = j;
        fvVar.fKZ.errCode = i2;
        fvVar.fKZ.path = str;
        fvVar.fKZ.fLb = z;
        com.tencent.mm.sdk.b.a.urY.m(fvVar);
    }
}
