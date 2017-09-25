package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.b.b.b;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.pluginsdk.k.a.e.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class h implements com.tencent.mm.pluginsdk.k.a.d.h {
    h() {
    }

    public final void a(q qVar, int i) {
        if (qVar.field_expireTime != 0 && qVar.field_expireTime <= bg.Ny()) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", qVar.field_urlKey, Long.valueOf(qVar.field_expireTime));
            o oVar = a.sGQ;
            String str = qVar.field_urlKey;
            if (oVar.rXW) {
                oVar.sGN.gR(str);
            }
            a.My(qVar.field_filePath);
            a.My(qVar.field_filePath + ".decompressed");
            a.My(qVar.field_filePath + ".decrypted");
            a.sGQ.Mw(qVar.field_urlKey);
        } else if (i == 0) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        } else if (2 == i && 1 == qVar.field_networkType) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        } else if (qVar.field_deleted) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", qVar.field_urlKey);
            a.My(qVar.field_filePath);
            a.My(qVar.field_filePath + ".decompressed");
            a.My(qVar.field_filePath + ".decrypted");
        } else if (qVar.field_status == 2) {
            long BA = a.BA(qVar.field_filePath);
            if (qVar.field_contentLength > BA) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == BA) {
                    if (!qVar.field_needRetry) {
                        w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                        return;
                    } else if (1 != i) {
                        w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        return;
                    } else {
                        for (b bVar : c.sFE.bDq()) {
                            int i2 = qVar.field_resType;
                            i2 = qVar.field_subType;
                            bg.getInt(qVar.field_fileVersion, 0);
                            if (bVar.bDr()) {
                                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", bVar.getClass().getName(), Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                                return;
                            }
                        }
                        qVar.field_fileUpdated = true;
                        c.sFE.f(qVar.field_resType, qVar.field_subType, 0, bg.mz(qVar.field_groupId2).equals("NewXml"));
                        a.sGQ.e(qVar);
                    }
                }
                a.sGQ.d(c.b(qVar));
            } else if (c(qVar)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                d(qVar);
            } else {
                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                b(qVar, 1 == i);
            }
        } else if (qVar.field_status == 1 || qVar.field_status == 0) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(qVar.field_contentLength));
            if (a.sGQ.Mv(qVar.field_urlKey)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                return;
            }
            w.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (c(qVar)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                qVar.field_status = 2;
                qVar.field_contentLength = a.BA(qVar.field_filePath);
                a.sGQ.e(qVar);
                d(qVar);
                return;
            }
            if (0 == a.BA(qVar.field_filePath)) {
                qVar.field_fileUpdated = true;
                a.sGQ.e(qVar);
                c.sFE.f(qVar.field_resType, qVar.field_subType, 0, bg.mz(qVar.field_groupId2).equals("NewXml"));
            }
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.sGQ.d(c.b(qVar));
        } else if (qVar.field_status == 4 || qVar.field_status == 3) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
            qVar.field_status = 0;
            b(qVar, true);
        }
    }

    private static boolean c(q qVar) {
        return bg.mz(g.aV(qVar.field_filePath)).equals(qVar.field_md5);
    }

    private static void b(q qVar, boolean z) {
        a.sGQ.Mw(qVar.field_urlKey);
        a.My(qVar.field_filePath);
        a.My(qVar.field_filePath + ".decompressed");
        a.My(qVar.field_filePath + ".decrypted");
        if (2 == qVar.field_status && !z) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
        } else if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0) {
            qVar.field_retryTimes--;
            qVar.field_fileUpdated = true;
            a.sGQ.e(qVar);
            j.u(qVar.field_reportId, 12);
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            k b = c.b(qVar);
            b.rWc = false;
            a.sGQ.d(b);
        } else {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes));
        }
    }

    private static void d(q qVar) {
        if (qVar.field_fileUpdated) {
            j.u(qVar.field_reportId, 13);
            j.u(qVar.field_reportId, 44);
        }
        if (qVar.field_fileCompress || qVar.field_fileEncrypt) {
            w.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            c.sFE.a(qVar);
            return;
        }
        c.sFE.b(qVar.field_resType, qVar.field_subType, qVar.field_filePath, bg.getInt(qVar.field_fileVersion, 0));
    }
}
