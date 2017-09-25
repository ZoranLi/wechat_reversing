package com.tencent.mm.pluginsdk.k.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

final class f {

    private static final class a {
        public static void a(q qVar, g gVar) {
            if (qVar == null) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
            } else {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", qVar.field_urlKey, qVar.field_url, Long.valueOf(qVar.field_contentLength), Boolean.valueOf(qVar.field_deleted), qVar.field_eccSignature, Long.valueOf(qVar.field_expireTime), Boolean.valueOf(qVar.field_fileCompress), Boolean.valueOf(qVar.field_fileEncrypt), qVar.field_filePath, Boolean.valueOf(qVar.field_fileUpdated), qVar.field_fileVersion, qVar.field_groupId2, Integer.valueOf(qVar.field_keyVersion), Boolean.valueOf(bg.mA(qVar.field_encryptKey)), Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes), qVar.field_sampleId, Integer.valueOf(qVar.field_status));
                w.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", qVar.field_encryptKey);
            }
            if (qVar != null && qVar.field_deleted && gVar.Mo(qVar.field_fileVersion) <= 0) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", qVar.field_fileVersion, gVar.sGq);
            } else if (qVar == null) {
                r0 = gVar.bDt();
                r0.field_fileUpdated = true;
                if (bg.mA(r0.field_encryptKey)) {
                    r0.field_keyVersion = -1;
                }
                w.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + r0);
                a.sGQ.e(r0);
                c.sFE.f(gVar.fEB, gVar.fEC, 0, gVar.fEH);
                a(true, true, r0, gVar);
            } else {
                w.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                qVar.field_networkType = gVar.networkType;
                if (bg.mA(qVar.field_originalMd5)) {
                    qVar.field_originalMd5 = gVar.sFd;
                }
                if (gVar.Mo(qVar.field_fileVersion) > 0) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                    r0 = gVar.bDt();
                    if (qVar.field_keyVersion >= gVar.sFb) {
                        r0.field_keyVersion = qVar.field_keyVersion;
                        r0.field_encryptKey = qVar.field_encryptKey;
                    }
                    r0.field_fileUpdated = true;
                    r0.field_deleted = false;
                    a.sGQ.e(r0);
                    c.sFE.f(gVar.fEB, gVar.fEC, 0, gVar.fEH);
                    a.sGQ.Mw(gVar.sEX);
                    a(false, true, r0, gVar);
                } else if (gVar.Mo(qVar.field_fileVersion) != 0 || qVar.field_needRetry) {
                    if (qVar.field_status == 2 || qVar.field_status == 1 || qVar.field_status == 0) {
                        long BA = com.tencent.mm.pluginsdk.k.a.e.a.BA(qVar.field_filePath);
                        if (qVar.field_contentLength > BA) {
                            w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(qVar.field_contentLength), Long.valueOf(BA));
                            if (0 == BA) {
                                c.sFE.f(gVar.fEB, gVar.fEC, 0, gVar.fEH);
                                a(false, true, qVar, gVar);
                                return;
                            }
                            a(true, false, qVar, gVar);
                            return;
                        } else if (bg.mz(g.aV(i.Mp(gVar.sEX))).equals(qVar.field_md5)) {
                            w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt");
                            qVar.field_status = 2;
                            qVar.field_contentLength = com.tencent.mm.pluginsdk.k.a.e.a.BA(qVar.field_filePath);
                            qVar.field_fileUpdated = false;
                            a.sGQ.e(qVar);
                            j.u(qVar.field_reportId, 13);
                            j.u(qVar.field_reportId, 44);
                            j.a(qVar.field_resType, qVar.field_subType, qVar.field_url, bg.getInt(qVar.field_fileVersion, 0), com.tencent.mm.pluginsdk.k.a.b.j.a.sGb, true, "NewXml".equalsIgnoreCase(qVar.field_groupId2), true, qVar.field_sampleId);
                            if (gVar.sFG || gVar.sFH) {
                                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request");
                                b.a(qVar, false);
                                return;
                            }
                            c.sFE.b(gVar.fEB, gVar.fEC, i.Mp(gVar.sEX), bg.getInt(gVar.sGq, 0));
                            return;
                        }
                    } else if (!(qVar.field_status == 4 || qVar.field_status == 3)) {
                        return;
                    }
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                    a(false, true, qVar, gVar);
                } else {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                }
            }
        }

        private static void a(boolean z, boolean z2, q qVar, g gVar) {
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0 || z2) {
                qVar.field_status = 0;
                if (z2) {
                    qVar.field_maxRetryTimes = gVar.sFh;
                    qVar.field_retryTimes = gVar.sFh;
                    qVar.field_fileUpdated = true;
                    qVar.field_priority = gVar.priority;
                    if (gVar.fileSize > 0) {
                        qVar.field_fileSize = gVar.fileSize;
                    }
                    a.sGQ.e(qVar);
                } else {
                    qVar.field_retryTimes--;
                    qVar.field_priority = gVar.priority;
                    a.sGQ.e(qVar);
                    j.u(qVar.field_reportId, 12);
                }
                if (a.sGQ.Mv(gVar.sEX)) {
                    w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.sEX);
                    if (gVar.fEH) {
                        j.u(gVar.sFf, 9);
                        j.u(gVar.sFf, 44);
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.sEX);
                if (z2 && !z) {
                    c.sFE.f(qVar.field_resType, qVar.field_subType, 0, bg.mz(qVar.field_groupId2).equals("NewXml"));
                }
                k b = c.b(qVar);
                b.rWc = z;
                b.sFF = gVar.sFF;
                if (!z) {
                    com.tencent.mm.pluginsdk.k.a.e.a.My(i.Mp(b.sEX));
                    com.tencent.mm.pluginsdk.k.a.e.a.My(i.Mp(b.sEX) + ".decompressed");
                    com.tencent.mm.pluginsdk.k.a.e.a.My(i.Mp(b.sEX) + ".decrypted");
                }
                a.sGQ.d(b);
                return;
            }
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes));
        }
    }

    private static final class b {
        public static void a(q qVar, boolean z) {
            if (qVar == null) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                return;
            }
            String str = qVar.field_urlKey;
            String str2 = qVar.field_filePath;
            String str3 = qVar.field_md5;
            boolean z2 = qVar.field_fileCompress;
            boolean z3 = qVar.field_fileEncrypt;
            Object obj = qVar.field_eccSignature;
            int i = bg.getInt(qVar.field_fileVersion, 0);
            int i2 = qVar.field_keyVersion;
            String str4 = qVar.field_encryptKey;
            boolean z4 = qVar.field_deleted;
            w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z4 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + qVar.field_originalMd5 + ", fileCompress = " + z2 + ", fileEncrypt = " + z3 + ", eccSignature = " + obj + ", fileVersion = " + i + ", (encrypt key == empty) = " + bg.mA(str4));
            w.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z3) {
                if (z) {
                    j.u(qVar.field_reportId, 53);
                    j.u(qVar.field_reportId, 45);
                }
                if (!z2) {
                    w.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    return;
                }
            }
            if (i2 != i && z3) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
                if (i2 >= 0) {
                    j.u(qVar.field_reportId, 52);
                    j.u(qVar.field_reportId, 45);
                }
            } else if (z4) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                j.u(qVar.field_reportId, 51);
                j.u(qVar.field_reportId, 45);
            } else if (bg.mA(str4) && z3) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                j.u(qVar.field_reportId, 54);
                j.u(qVar.field_reportId, 45);
            } else if (bg.mA(str3) || bg.mA(str2)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
            } else if (a.sGQ.Mv(str)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
            } else if (!bg.mz(g.aV(str2)).equals(str3)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                qVar.field_status = 3;
                a.sGQ.e(qVar);
                j.u(qVar.field_reportId, 56);
                j.u(qVar.field_reportId, 45);
            } else if (!a.sGQ.Mv(str)) {
                w.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request");
                c.sFE.f(qVar.field_resType, qVar.field_subType, 1, bg.mz(qVar.field_groupId2).equals("NewXml"));
                c.sFE.a(qVar);
            }
        }
    }
}
