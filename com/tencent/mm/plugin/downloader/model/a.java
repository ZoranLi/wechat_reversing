package com.tencent.mm.plugin.downloader.model;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.y.d;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.CdnTaskStateInfo;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class a extends i {
    private static final String kGi = (com.tencent.mm.loader.stub.a.hgu + "BigFile");
    private byte[] hAl = new byte[0];
    public com.tencent.mm.modelcdntran.h.a hGH = new a(this);
    private HashMap<String, Long> kGj = new HashMap();
    public HashMap<String, Long> kGk = new HashMap();
    private ConcurrentHashMap<String, Integer> kGl = new ConcurrentHashMap();
    public Context mContext = ab.getContext();

    private class a implements com.tencent.mm.modelcdntran.h.a {
        final /* synthetic */ a kGo;

        public a(a aVar) {
            this.kGo = aVar;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2;
            String str3 = "MicroMsg.FileCDNDownloader";
            String str4 = "on cdn callback mediaId = %s, startRet = %d, keep_ProgressInfo = %s, keep_SceneResult = %s";
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(i);
            objArr[2] = com_tencent_mm_modelcdntran_keep_ProgressInfo == null ? "null" : com_tencent_mm_modelcdntran_keep_ProgressInfo.toString();
            if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                str2 = "null";
            } else {
                str2 = com_tencent_mm_modelcdntran_keep_SceneResult.toString();
            }
            objArr[3] = str2;
            w.d(str3, str4, objArr);
            com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
            if (tH == null) {
                w.i("MicroMsg.FileCDNDownloader", "info is null, return");
            } else if (i == -21006) {
                w.i("MicroMsg.FileCDNDownloader", "duplicate request, ignore this request, media id is %s", str);
            } else if (i != 0) {
                w.e("MicroMsg.FileCDNDownloader", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                tH.field_errCode = Math.abs(i);
                tH.field_status = 4;
                d.b(tH);
                this.kGo.kGM.c(tH.field_downloadId, Math.abs(i), false);
                this.kGo.b(tH.field_downloadUrl, 4, 0, false);
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                Long l = (Long) this.kGo.kGk.get(tH.field_downloadUrl);
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                if (l == null || valueOf.longValue() - l.longValue() >= 500) {
                    int i2;
                    this.kGo.kGk.put(tH.field_downloadUrl, valueOf);
                    d.e(tH.field_downloadId, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength, (long) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength);
                    this.kGo.kGM.aZ(tH.field_downloadId);
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                        i2 = (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f);
                    } else {
                        i2 = 0;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > 100) {
                        i2 = 100;
                    }
                    this.kGo.b(tH.field_downloadUrl, 1, i2, false);
                }
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                    w.e("MicroMsg.FileCDNDownloader", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult);
                    tH.field_errCode = Math.abs(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode);
                    tH.field_status = 4;
                    d.b(tH);
                    this.kGo.kGM.c(tH.field_downloadId, Math.abs(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), false);
                    this.kGo.b(tH.field_downloadUrl, 4, 0, false);
                } else {
                    w.i("MicroMsg.FileCDNDownloader", "cdn trans suceess, media id : %s", str);
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kHc, 1);
                    intent.setClass(this.kGo.mContext, FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, tH.field_downloadId);
                    try {
                        this.kGo.mContext.startService(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.FileCDNDownloader", e.getMessage());
                    }
                    this.kGo.cancelNotification(tH.field_downloadUrl);
                }
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return new byte[0];
        }
    }

    public a(b bVar) {
        super(bVar);
    }

    public final long a(final f fVar) {
        if (fVar == null || bg.mA(fVar.iyZ)) {
            w.e("MicroMsg.FileCDNDownloader", "Invalid Request");
            return -1;
        }
        final String str = fVar.iyZ;
        com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
        if (tH != null) {
            FileDownloadTaskInfo aU = aU(tH.field_downloadId);
            if (aU.status == 1) {
                return aU.id;
            }
        }
        if (!new File(kGi).exists()) {
            w.i("MicroMsg.FileCDNDownloader", "Make download dir result: %b", Boolean.valueOf(new File(kGi).mkdirs()));
        }
        d.tF(str);
        d.tG(fVar.ivH);
        final com.tencent.mm.plugin.downloader.b.a b = g.b(fVar);
        b.field_downloadId = System.currentTimeMillis();
        b.field_status = 1;
        b.field_downloaderType = 3;
        b.field_filePath = kGi + "/" + aa.Pq(str);
        if (tH != null) {
            String str2 = b.field_filePath;
            String str3 = tH.field_filePath;
            if (!(str2 == null || str3 == null || str2.equals(str3))) {
                File file = new File(str3);
                if (file.exists()) {
                    boolean delete = file.delete();
                    w.i("MicroMsg.FileCDNDownloader", "Delete previous file result: %b", Boolean.valueOf(delete));
                }
            }
        }
        b.field_startTime = System.currentTimeMillis();
        d.a(b);
        new Thread(new Runnable(this) {
            final /* synthetic */ a kGo;

            public final void run() {
                w.d("MicroMsg.FileCDNDownloader", "addDownloadTask");
                h hVar = new h();
                hVar.hzk = true;
                hVar.field_mediaId = b.field_downloadUrl;
                hVar.field_fullpath = b.field_filePath;
                hVar.hzg = str;
                hVar.hzl = fVar.kGS;
                hVar.hze = this.kGo.hGH;
                hVar.hzh = 15;
                hVar.hzi = 3600;
                hVar.allow_mobile_net_download = true;
                a.a(hVar, fVar);
                g.El().b(hVar, -1);
                this.kGo.kGM.h(b.field_downloadId, b.field_filePath);
                this.kGo.b(str, 1, 0, true);
            }
        }).start();
        return b.field_downloadId;
    }

    public static void a(h hVar, f fVar) {
        hVar.hzm = new HashMap();
        if (fVar.kGT != 0) {
            hVar.hzm.put("Content-Length", fVar.kGT);
        }
    }

    public final int aT(final long j) {
        new Thread(new Runnable(this) {
            final /* synthetic */ a kGo;

            public final void run() {
                com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
                if (ba != null) {
                    g.El().iP(ba.field_downloadUrl);
                    d.j(ba.field_downloadId, 5);
                    this.kGo.kGM.aX(j);
                    this.kGo.cancelNotification(ba.field_downloadUrl);
                }
            }
        }).start();
        return 1;
    }

    public final FileDownloadTaskInfo aU(long j) {
        FileDownloadTaskInfo fileDownloadTaskInfo = new FileDownloadTaskInfo();
        com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba != null) {
            CdnTaskStateInfo httpMultiSocketDownloadTaskState = CdnLogic.httpMultiSocketDownloadTaskState(ba.field_downloadUrl);
            if (httpMultiSocketDownloadTaskState == null) {
                fileDownloadTaskInfo.status = 0;
            } else {
                switch (httpMultiSocketDownloadTaskState.taskState) {
                    case 100:
                    case 101:
                        fileDownloadTaskInfo.status = 1;
                        break;
                    case 102:
                        fileDownloadTaskInfo.status = 2;
                        break;
                    default:
                        fileDownloadTaskInfo.status = 0;
                        break;
                }
                fileDownloadTaskInfo.fLg = (long) httpMultiSocketDownloadTaskState.completeSize;
                fileDownloadTaskInfo.fLh = (long) httpMultiSocketDownloadTaskState.fileTotalSize;
            }
            fileDownloadTaskInfo.id = j;
            fileDownloadTaskInfo.fLG = ba.field_downloaderType;
            fileDownloadTaskInfo.kHg = ba.field_autoDownload;
            fileDownloadTaskInfo.path = ba.field_filePath;
            fileDownloadTaskInfo.url = ba.field_downloadUrl;
            fileDownloadTaskInfo.fFW = ba.field_md5;
        }
        return fileDownloadTaskInfo;
    }

    public final boolean aV(final long j) {
        new Thread(new Runnable(this) {
            final /* synthetic */ a kGo;

            public final void run() {
                w.d("MicroMsg.FileCDNDownloader", af.NAME);
                com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
                if (ba != null && ba.field_status == 1) {
                    CdnLogic.pauseHttpMultiSocketDownloadTask(ba.field_downloadUrl);
                    d.j(ba.field_downloadId, 2);
                    this.kGo.kGM.aY(j);
                    this.kGo.cancelNotification(ba.field_downloadUrl);
                }
            }
        }).start();
        return true;
    }

    public final boolean aW(final long j) {
        final com.tencent.mm.plugin.downloader.b.a ba = d.ba(j);
        if (ba == null || ba.field_status != 2) {
            return false;
        }
        new Thread(new Runnable(this) {
            final /* synthetic */ a kGo;

            public final void run() {
                w.d("MicroMsg.FileCDNDownloader", ak.NAME);
                CdnLogic.resumeHttpMultiSocketDownloadTask(ba.field_downloadUrl);
                ba.field_startTime = System.currentTimeMillis();
                if (ba.field_status == 2) {
                    ba.field_startState = c.kGD;
                } else {
                    ba.field_startState = c.kGE;
                }
                ba.field_startSize = ba.field_downloadedSize;
                ba.field_status = 1;
                ba.field_errCode = 0;
                d.b(ba);
                this.kGo.kGM.i(j, ba.field_filePath);
                this.kGo.b(ba.field_downloadUrl, 1, 0, true);
            }
        }).start();
        return true;
    }

    public final void b(String str, int i, int i2, boolean z) {
        w.d("MicroMsg.FileCDNDownloader", "state = %d, progress = %d, firstShown = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z));
        com.tencent.mm.plugin.downloader.b.a tH = d.tH(str);
        if (tH == null) {
            w.e("MicroMsg.FileCDNDownloader", "updateNotification failed: null task info");
        } else if (tH.field_showNotification) {
            d dVar = new d(this.mContext);
            if (z) {
                long currentTimeMillis = System.currentTimeMillis();
                this.kGj.put(str, Long.valueOf(currentTimeMillis));
                dVar.b(currentTimeMillis);
            } else {
                Long l = (Long) this.kGj.get(str);
                if (l != null) {
                    dVar.b(l.longValue());
                }
            }
            dVar.a(tH.field_fileName);
            switch (i) {
                case 1:
                    dVar.L(17301633);
                    dVar.b(100, i2, i2 == 0);
                    dVar.b(this.mContext.getString(c.ejX));
                    dVar.j(2, true);
                    long j = tH.field_downloadId;
                    Intent intent = new Intent(this.mContext, FileDownloadConfirmUI.class);
                    intent.putExtra("extra_download_id", j);
                    dVar.rR = PendingIntent.getActivity(this.mContext, (int) System.currentTimeMillis(), intent, SQLiteDatabase.CREATE_IF_NECESSARY);
                    break;
                case 4:
                    dVar.L(17301634);
                    dVar.o(true);
                    dVar.rR = PendingIntent.getActivity(ab.getContext(), 0, new Intent(), 0);
                    dVar.b(this.mContext.getString(c.ejW));
                    break;
                default:
                    cancelNotification(str);
                    return;
            }
            synchronized (this.hAl) {
                if (z) {
                    this.kGl.put(str, Integer.valueOf(((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().b(dVar.build())));
                } else {
                    Integer num = (Integer) this.kGl.get(str);
                    if (num != null) {
                        ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().notify(num.intValue(), dVar.build());
                    }
                }
            }
        }
    }

    public final void cancelNotification(String str) {
        synchronized (this.hAl) {
            Integer num = (Integer) this.kGl.get(str);
            if (num == null) {
                w.i("MicroMsg.FileCDNDownloader", "No notification id found");
                return;
            }
            ((com.tencent.mm.plugin.notification.b.a) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(num.intValue());
            w.i("MicroMsg.FileCDNDownloader", "cancelNotification, id = " + num);
            this.kGl.remove(str);
        }
    }
}
