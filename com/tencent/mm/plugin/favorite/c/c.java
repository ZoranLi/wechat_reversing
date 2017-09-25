package com.tencent.mm.plugin.favorite.c;

import android.database.Cursor;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.favorite.b.b;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class c {
    private Queue<com.tencent.mm.plugin.favorite.b.a> fBi = new LinkedList();
    private Map<String, com.tencent.mm.compatible.util.g.a> fBk = new HashMap();
    public boolean fBm = false;
    public boolean fBn = false;
    public int fBo = 0;
    public long fBp = 0;
    public aj fBt = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c lFZ;

        {
            this.lFZ = r1;
        }

        public final boolean oQ() {
            try {
                this.lFZ.pq();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavCdnService", e, "", new Object[0]);
            }
            return false;
        }

        public final String toString() {
            return super.toString() + "|scenePusher";
        }
    }, false);
    private com.tencent.mm.modelcdntran.h.a hGH = new com.tencent.mm.modelcdntran.h.a(this) {
        final /* synthetic */ c lFZ;

        {
            this.lFZ = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.d("MicroMsg.FavCdnService", "cdn transfer callback, mediaid=%s, totallen=%d, offset=%d", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength)});
            }
            String str2 = "";
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                str2 = com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId;
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                str2 = com_tencent_mm_modelcdntran_keep_SceneResult.mediaId;
            }
            if (i == -21006 || i == -21005) {
                this.lFZ.wg(str2);
                return 0;
            }
            if (!bg.mA(str2)) {
                str = str2;
            }
            com.tencent.mm.plugin.favorite.b.a vN = h.asV().vN(str);
            if (vN == null) {
                w.e("MicroMsg.FavCdnService", "klem onCdnCallback info null");
                this.lFZ.wg(str);
                return 0;
            }
            if (i != 0) {
                w.w("MicroMsg.FavCdnService", "cdn transfer callback, startRet=%d", new Object[]{Integer.valueOf(i)});
                g.oUh.i(10660, new Object[]{Integer.valueOf(vN.field_type), Integer.valueOf(i)});
                vN.field_status = 4;
                h.asV().a(vN, new String[0]);
                c.d(vN);
                this.lFZ.wg(str);
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                vN.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                vN.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                vN.field_status = 1;
                h.asV().a(vN, new String[0]);
            } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                String str3;
                if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                    vN.field_status = 3;
                    if (1 == vN.field_type) {
                        str2 = vN.field_path + ".temp";
                        str3 = vN.field_path;
                        int i2 = vN.field_dataType;
                        if (!(str2 == null || str3 == null)) {
                            if (i2 == -2 && !c.wf(str2) && c.cb(str2, str3)) {
                                w.v("MicroMsg.FavCdnService", "renameAndCopyFile write amr head ok!");
                            } else {
                                File file = new File(str2);
                                File file2 = new File(str3);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    w.v("MicroMsg.FavCdnService", "rename file suc:%b, old:%s, new:%s", new Object[]{Boolean.valueOf(renameTo), str2, file2});
                                }
                            }
                        }
                    } else {
                        vN.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                        vN.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                    }
                    h.asV().a(vN, new String[0]);
                    c.a(vN, com_tencent_mm_modelcdntran_keep_SceneResult);
                    h.asV().b(vN, "dataId");
                    this.lFZ.lFU.remove(vN.field_dataId);
                    w.i("MicroMsg.FavCdnService", "transfer done, mediaid=%s, md5=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str});
                    w.d("MicroMsg.FavCdnService", "transfer done, completeInfo=%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.toString()});
                } else {
                    w.e("MicroMsg.FavCdnService", "transfer error, mediaid=%s, retCode:%d", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                    a aVar = (a) this.lFZ.lFU.get(vN.field_dataId);
                    if (aVar != null) {
                        aVar.errCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                    }
                    if (-6101 != com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                        switch (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                            case -5103015:
                                g.oUh.a(141, 8, 1, true);
                                break;
                            case -21020:
                                g.oUh.a(141, 7, 1, true);
                                break;
                            case -21014:
                                g.oUh.a(141, 6, 1, true);
                                break;
                            case -21009:
                                g.oUh.a(141, 5, 1, true);
                                break;
                            case -21000:
                                g.oUh.a(141, 4, 1, true);
                                break;
                            case -10005:
                                g.oUh.a(141, 3, 1, true);
                                break;
                            case -10003:
                                g.oUh.a(141, 2, 1, true);
                                break;
                            default:
                                g.oUh.a(141, 0, 1, true);
                                break;
                        }
                    }
                    int i3;
                    vN.field_extFlag |= 1;
                    g.oUh.a(141, 1, 1, true);
                    str3 = "MicroMsg.FavCdnService";
                    String str4 = "transfer error, mediaid=%s, retCode:-6101,try time = %d,info.field_type: %d , info.field_dataType: %d";
                    Object[] objArr = new Object[4];
                    objArr[0] = com_tencent_mm_modelcdntran_keep_SceneResult.mediaId;
                    if (aVar != null) {
                        i3 = aVar.ihV;
                    } else {
                        i3 = 1;
                    }
                    objArr[1] = Integer.valueOf(i3);
                    objArr[2] = Integer.valueOf(vN.field_type);
                    objArr[3] = Integer.valueOf(vN.field_dataType);
                    w.e(str3, str4, objArr);
                    vN.field_status = 4;
                    g.oUh.i(10660, new Object[]{Integer.valueOf(vN.field_type), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                    h.asV().a(vN, new String[0]);
                    c.d(vN);
                }
                this.lFZ.wg(str);
                g.oUh.i(10625, new Object[]{Integer.valueOf(1), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, "", com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
            }
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };
    public m hyk = new com.tencent.mm.network.m.a(this) {
        final /* synthetic */ c lFZ;

        {
            this.lFZ = r1;
        }

        public final void cU(int i) {
            try {
                boolean isWifi = am.isWifi(ab.getContext());
                w.i("MicroMsg.FavCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", new Object[]{Integer.valueOf(i), Boolean.valueOf(isWifi), Boolean.valueOf(this.lFZ.lFS)});
                if (i == 4 || i == 6) {
                    c cVar;
                    if (this.lFZ.lFS && !isWifi) {
                        com.tencent.mm.plugin.favorite.b.a aVar;
                        cVar = this.lFZ;
                        w.v("MicroMsg.FavCdnService", "pauseAll");
                        Cursor rawQuery = h.asV().gUz.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
                        if (rawQuery != null && rawQuery.moveToFirst()) {
                            while (rawQuery.moveToNext()) {
                                aVar = new com.tencent.mm.plugin.favorite.b.a();
                                aVar.b(rawQuery);
                                if (aVar.field_dataType != 2 && ((long) aVar.field_totalLen) > x.atK()) {
                                    w.v("MicroMsg.FavCdnService", "pauseAll, pauseUpload dataId:%s", new Object[]{aVar.field_dataId});
                                    aVar.field_status = 4;
                                    h.asV().a(aVar, "dataId");
                                    com.tencent.mm.modelcdntran.g.El().iO(aVar.field_dataId);
                                    c.d(h.asV().vN(aVar.field_dataId));
                                    cVar.wg(aVar.field_dataId);
                                }
                            }
                            rawQuery.close();
                        }
                        rawQuery = h.asV().gUz.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
                        if (rawQuery != null && rawQuery.moveToFirst()) {
                            while (rawQuery.moveToNext()) {
                                aVar = new com.tencent.mm.plugin.favorite.b.a();
                                aVar.b(rawQuery);
                                if (aVar.field_dataType != 2 && ((long) aVar.field_totalLen) > x.atJ()) {
                                    w.v("MicroMsg.FavCdnService", "pauseAll, pauseDownload dataId:%s", new Object[]{aVar.field_dataId});
                                    aVar.field_status = 4;
                                    h.asV().a(aVar, "dataId");
                                    com.tencent.mm.modelcdntran.g.El().iP(aVar.field_dataId);
                                    c.d(h.asV().vN(aVar.field_dataId));
                                    cVar.wg(aVar.field_dataId);
                                }
                            }
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                    if (!this.lFZ.lFS && isWifi) {
                        cVar = this.lFZ;
                        w.i("MicroMsg.FavCdnService", "startAll");
                        h.asV().gUz.eE("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
                        cVar.run();
                    }
                    this.lFZ.lFS = isWifi;
                    return;
                }
                this.lFZ.lFS = isWifi;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavCdnService", e, "", new Object[0]);
            }
        }
    };
    public boolean lFS = am.isWifi(ab.getContext());
    public Map<String, a> lFU = new HashMap();
    public Set<String> lFV = new HashSet();
    public int lFW = 0;
    public boolean lFX = true;
    private Runnable lFY = new Runnable(this) {
        final /* synthetic */ c lFZ;

        {
            this.lFZ = r1;
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis() - this.lFZ.fBp;
            if (this.lFZ.fBn) {
                if (currentTimeMillis >= 300000) {
                    w.e("MicroMsg.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.lFZ.fBn + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.lFZ.fBn);
                } else {
                    return;
                }
            }
            w.i("MicroMsg.FavCdnService", "do run cdn job, wait time %d", new Object[]{Long.valueOf(currentTimeMillis)});
            this.lFZ.fBm = false;
            this.lFZ.fBn = true;
            this.lFZ.lFW = 0;
            this.lFZ.fBo = 3;
            this.lFZ.fBt.v(100, 100);
        }

        public final String toString() {
            return super.toString() + "|run";
        }
    };

    private class a {
        int errCode = 0;
        int ihV;
        final /* synthetic */ c lFZ;
        long lGc;

        public a(c cVar) {
            this.lFZ = cVar;
        }
    }

    public c() {
        ap.a(this.hyk);
    }

    public final void dZ(final boolean z) {
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ c lFZ;

            public final void run() {
                this.lFZ.lFX = z;
                this.lFZ.lFW = 0;
            }
        });
    }

    public final void wd(final String str) {
        w.d("MicroMsg.FavCdnService", "add force job %s", new Object[]{str});
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ c lFZ;

            public final void run() {
                this.lFZ.lFV.add(str);
            }
        });
    }

    public final void run() {
        w.v("MicroMsg.FavCdnService", "run fav cdn server");
        ap.vL().bJl().removeCallbacks(this.lFY);
        ap.vL().D(this.lFY);
    }

    public final void pq() {
        this.fBp = System.currentTimeMillis();
        if (!this.fBm && this.fBi.size() == 0) {
            if (f.rZ()) {
                b asV = h.asV();
                Cursor a = asV.gUz.a("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null, 2);
                List list;
                if (a == null) {
                    list = null;
                } else if (a.moveToFirst()) {
                    list = new LinkedList();
                    do {
                        com.tencent.mm.plugin.favorite.b.a aVar = new com.tencent.mm.plugin.favorite.b.a();
                        aVar.b(a);
                        list.add(aVar);
                    } while (a.moveToNext());
                    a.close();
                } else {
                    a.close();
                    list = null;
                }
                if (!(r0 == null || r0.size() == 0)) {
                    for (com.tencent.mm.plugin.favorite.b.a aVar2 : r0) {
                        com.tencent.mm.plugin.favorite.b.a aVar22;
                        if (this.fBk.containsKey(aVar22.field_dataId)) {
                            w.d("MicroMsg.FavCdnService", "File is Already running:" + aVar22.field_dataId);
                        } else {
                            this.fBi.add(aVar22);
                            this.fBk.put(aVar22.field_dataId, null);
                        }
                    }
                    w.d("MicroMsg.FavCdnService", "klem GetNeedRun procing:" + this.fBk.size() + ",send:" + this.fBi.size() + "]");
                    this.fBi.size();
                }
            } else {
                w.e("MicroMsg.FavCdnService", "klem getNeedRunInfo sdcard not available");
                pr();
            }
        }
        if (!this.fBm && this.fBi.size() <= 0) {
            pr();
            w.d("MicroMsg.FavCdnService", "klem No Data Any More , Stop Service");
        } else if (!this.fBm && this.fBi.size() > 0) {
            aVar22 = (com.tencent.mm.plugin.favorite.b.a) this.fBi.poll();
            if (aVar22 != null && !bg.mA(aVar22.field_dataId)) {
                boolean z;
                com.tencent.mm.modelcdntran.h hVar;
                a aVar3 = (a) this.lFU.get(aVar22.field_dataId);
                if (aVar3 == null) {
                    aVar3 = new a(this);
                    aVar3.ihV = 1;
                    aVar3.lGc = bg.Nz();
                    this.lFU.put(aVar22.field_dataId, aVar3);
                } else if (bg.Nz() - aVar3.lGc > 180000 && aVar3.errCode != -6101) {
                    aVar3.ihV = 1;
                    aVar3.lGc = bg.Nz();
                    this.lFU.put(aVar22.field_dataId, aVar3);
                } else if (aVar3.ihV <= 3) {
                    aVar3.ihV++;
                    this.lFU.put(aVar22.field_dataId, aVar3);
                } else {
                    w.e("MicroMsg.FavCdnService", "check favCDN:match transfer limit 3times , localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                    c(aVar22);
                    z = false;
                    if (!z) {
                        this.fBm = true;
                        if (aVar22 == null) {
                            w.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar22.field_dataId});
                            hVar = new com.tencent.mm.modelcdntran.h();
                            hVar.hze = this.hGH;
                            hVar.field_mediaId = aVar22.field_dataId;
                            if (aVar22.field_type == 0) {
                                hVar.fZK = true;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                                hVar.field_needStorage = true;
                                hVar.field_isStreamMedia = aVar22.atb();
                                hVar.field_fullpath = aVar22.field_path;
                                if (!FileOp.aO(hVar.field_fullpath)) {
                                    w.e("MicroMsg.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{aVar22.field_path});
                                }
                                if (aVar22.atb()) {
                                    hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                } else {
                                    hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                }
                                hVar.field_force_aeskeycdn = true;
                                hVar.field_trysafecdn = false;
                                w.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                                com.tencent.mm.modelcdntran.g.El().b(hVar);
                                return;
                            }
                            hVar.fZK = false;
                            hVar.field_totalLen = aVar22.field_totalLen;
                            hVar.field_aesKey = aVar22.field_cdnKey;
                            hVar.field_fileId = aVar22.field_cdnUrl;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                            hVar.hze = this.hGH;
                            hVar.field_fullpath = aVar22.field_path + ".temp";
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar22.atb();
                            if (aVar22.atb()) {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                            d(aVar22);
                        }
                    } else if (this.lFW >= 10) {
                        pr();
                    } else {
                        this.fBt.v(500, 500);
                    }
                }
                if (aVar22.field_type == 0) {
                    w.i("MicroMsg.FavCdnService", "check favCDN:force job[can upload], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                } else if (this.lFV.contains(aVar22.field_dataId) || x.wa(aVar22.field_dataId)) {
                    w.i("MicroMsg.FavCdnService", "check favCDN:force job[normal], localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                } else {
                    if (!am.isWifi(ab.getContext())) {
                        w.i("MicroMsg.FavCdnService", "check favCDN:not force job, NOT WIFI, pause it, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                        c(aVar22);
                        z = false;
                    } else if (aVar22.field_type == 0) {
                        w.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI & SENDING, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                    } else if (!this.lFX) {
                        w.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, not auto limit, localid %d, dataid %s, type %d, dataType %d", new Object[]{Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                        this.lFW = 0;
                    } else if (this.lFW < 10) {
                        w.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, auto limit %d, current index %d, retryTimes %dlocalid %d, dataid %s, type %d, dataType %d", new Object[]{Integer.valueOf(10), Integer.valueOf(this.lFW), Integer.valueOf(aVar3.ihV), Long.valueOf(aVar22.field_favLocalId), aVar22.field_dataId, Integer.valueOf(aVar22.field_type), Integer.valueOf(aVar22.field_dataType)});
                        if (aVar3.ihV == 1) {
                            this.lFW++;
                        }
                    } else {
                        w.i("MicroMsg.FavCdnService", "check favCDN:not force job, IN WIFI, match auto limit %d", new Object[]{Integer.valueOf(10)});
                        z = false;
                    }
                    if (!z) {
                        this.fBm = true;
                        if (aVar22 == null) {
                            w.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar22.field_dataId});
                            hVar = new com.tencent.mm.modelcdntran.h();
                            hVar.hze = this.hGH;
                            hVar.field_mediaId = aVar22.field_dataId;
                            if (aVar22.field_type == 0) {
                                hVar.fZK = false;
                                hVar.field_totalLen = aVar22.field_totalLen;
                                hVar.field_aesKey = aVar22.field_cdnKey;
                                hVar.field_fileId = aVar22.field_cdnUrl;
                                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                                hVar.hze = this.hGH;
                                hVar.field_fullpath = aVar22.field_path + ".temp";
                                hVar.field_needStorage = true;
                                hVar.field_isStreamMedia = aVar22.atb();
                                if (aVar22.atb()) {
                                    hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                                } else {
                                    hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                                }
                                com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                                d(aVar22);
                            }
                            hVar.fZK = true;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar22.atb();
                            hVar.field_fullpath = aVar22.field_path;
                            if (FileOp.aO(hVar.field_fullpath)) {
                                w.e("MicroMsg.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{aVar22.field_path});
                            }
                            if (aVar22.atb()) {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            } else {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            }
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                            w.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                            com.tencent.mm.modelcdntran.g.El().b(hVar);
                            return;
                        }
                    } else if (this.lFW >= 10) {
                        this.fBt.v(500, 500);
                    } else {
                        pr();
                    }
                }
                z = true;
                if (!z) {
                    this.fBm = true;
                    if (aVar22 == null) {
                        w.d("MicroMsg.FavCdnService", "doTransfer, md5:%s", new Object[]{aVar22.field_dataId});
                        hVar = new com.tencent.mm.modelcdntran.h();
                        hVar.hze = this.hGH;
                        hVar.field_mediaId = aVar22.field_dataId;
                        if (aVar22.field_type == 0) {
                            hVar.fZK = true;
                            hVar.field_priority = com.tencent.mm.modelcdntran.b.hxK;
                            hVar.field_needStorage = true;
                            hVar.field_isStreamMedia = aVar22.atb();
                            hVar.field_fullpath = aVar22.field_path;
                            if (FileOp.aO(hVar.field_fullpath)) {
                                w.e("MicroMsg.FavCdnService", "favcdnservice upload, but file not exsit,filePath = %s ", new Object[]{aVar22.field_path});
                            }
                            if (aVar22.atb()) {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                            } else {
                                hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                            }
                            hVar.field_force_aeskeycdn = true;
                            hVar.field_trysafecdn = false;
                            w.i("MicroMsg.FavCdnService", "summersafecdn send force_aeskeycdn[%b] trysafecdn[%b]", new Object[]{Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn)});
                            com.tencent.mm.modelcdntran.g.El().b(hVar);
                            return;
                        }
                        hVar.fZK = false;
                        hVar.field_totalLen = aVar22.field_totalLen;
                        hVar.field_aesKey = aVar22.field_cdnKey;
                        hVar.field_fileId = aVar22.field_cdnUrl;
                        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                        hVar.hze = this.hGH;
                        hVar.field_fullpath = aVar22.field_path + ".temp";
                        hVar.field_needStorage = true;
                        hVar.field_isStreamMedia = aVar22.atb();
                        if (aVar22.atb()) {
                            hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO);
                        } else {
                            hVar.field_fileType = bX(aVar22.field_extFlag, com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE);
                        }
                        com.tencent.mm.modelcdntran.g.El().b(hVar, -1);
                        d(aVar22);
                    }
                } else if (this.lFW >= 10) {
                    pr();
                } else {
                    this.fBt.v(500, 500);
                }
            }
        }
    }

    private static void c(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (1 == aVar.field_type) {
            aVar.field_status = 2;
        } else {
            aVar.field_status = 4;
        }
        h.asV().a(aVar, "dataId");
        d(aVar);
    }

    public final void pauseDownload(String str) {
        if (!bg.mA(str) && this.fBk.containsKey(str)) {
            com.tencent.mm.modelcdntran.g.El().iP(str);
            w.v("MicroMsg.FavCdnService", "pause download md5%s", new Object[]{str});
            d(h.asV().vN(str));
            wg(str);
        }
    }

    public final void we(String str) {
        if (!bg.mA(str)) {
            com.tencent.mm.modelcdntran.g.El().iO(str);
            w.v("MicroMsg.FavCdnService", "pause upload md5%s", new Object[]{str});
            d(h.asV().vN(str));
            wg(str);
        }
    }

    public final void pr() {
        this.fBi.clear();
        this.fBk.clear();
        this.fBn = false;
        this.fBm = false;
    }

    private static int bX(int i, int i2) {
        if ((i & 1) == 0) {
            return i2;
        }
        w.w("MicroMsg.FavCdnService", "NEED To Exchange Type, defType %d", new Object[]{Integer.valueOf(i2)});
        if (com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO == i2) {
            return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_FILE;
        }
        return com.tencent.mm.modelcdntran.b.MediaType_FAVORITE_VIDEO;
    }

    static boolean cb(String str, String str2) {
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream;
        Throwable e;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    byte[] bArr = new byte[16384];
                    fileOutputStream.write("#!AMR\n".getBytes());
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    boolean z = true;
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.FavCdnService", e2, "", new Object[0]);
                        z = false;
                    }
                    try {
                        fileOutputStream.close();
                        return z;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Exception e3) {
                    e22 = e3;
                    fileInputStream2 = fileInputStream;
                    try {
                        w.printErrStackTrace("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable e222) {
                                w.printErrStackTrace("MicroMsg.FavCdnService", e222, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            return false;
                        }
                        try {
                            fileOutputStream.close();
                            return false;
                        } catch (Throwable e2222) {
                            w.printErrStackTrace("MicroMsg.FavCdnService", e2222, "", new Object[0]);
                            return false;
                        }
                    } catch (Throwable th) {
                        e2222 = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e4) {
                                w.printErrStackTrace("MicroMsg.FavCdnService", e4, "", new Object[0]);
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e5) {
                                w.printErrStackTrace("MicroMsg.FavCdnService", e5, "", new Object[0]);
                            }
                        }
                        throw e2222;
                    }
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e6) {
                e2222 = e6;
                fileOutputStream = null;
                fileInputStream2 = fileInputStream;
                w.printErrStackTrace("MicroMsg.FavCdnService", e2222, "", new Object[0]);
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th3) {
                e2222 = th3;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        } catch (Exception e7) {
            e2222 = e7;
            fileOutputStream = null;
            w.printErrStackTrace("MicroMsg.FavCdnService", e2222, "", new Object[0]);
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th4) {
            e2222 = th4;
            fileOutputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }

    static boolean wf(String str) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.FavCdnService", e2, "", new Object[0]);
                        return false;
                    }
                }
                String str2 = new String(bArr);
                w.d("MicroMsg.FavCdnService", "head " + str2 + "   AmrFileOperator.AMR_NB_HEAD #!AMR\n");
                boolean endsWith = str2.endsWith("#!AMR\n");
                try {
                    randomAccessFile.close();
                } catch (Throwable e3) {
                    w.printErrStackTrace("MicroMsg.FavCdnService", e3, "", new Object[0]);
                }
                return endsWith;
            } catch (Exception e4) {
                e2 = e4;
                try {
                    w.printErrStackTrace("MicroMsg.FavCdnService", e2, "", new Object[0]);
                    if (randomAccessFile != null) {
                        return false;
                    }
                    try {
                        randomAccessFile.close();
                        return false;
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.FavCdnService", e22, "", new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e22 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e32) {
                            w.printErrStackTrace("MicroMsg.FavCdnService", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            randomAccessFile = null;
            w.printErrStackTrace("MicroMsg.FavCdnService", e22, "", new Object[0]);
            if (randomAccessFile != null) {
                return false;
            }
            randomAccessFile.close();
            return false;
        } catch (Throwable th2) {
            e22 = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e22;
        }
    }

    public final void wg(String str) {
        this.fBm = false;
        this.fBk.remove(str);
        pauseDownload(str);
        if (this.fBo > 0) {
            pq();
            return;
        }
        w.d("MicroMsg.FavCdnService", "klem stopFlag <= 0 , Stop Service");
        pr();
    }

    public static void a(com.tencent.mm.plugin.favorite.b.a aVar, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        j bT = h.ata().bT(aVar.field_favLocalId);
        if (bT == null) {
            w.e("MicroMsg.FavCdnService", "klem onCdnTranFinish item info null!");
            return;
        }
        Iterator it = bT.field_favProto.tzn.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (!aVar.field_dataId.equals(rmVar.lKv)) {
                if (aVar.field_dataId.equals(x.vZ(rmVar.lKv))) {
                    rmVar.NO(aVar.field_cdnKey);
                    rmVar.NN(aVar.field_cdnUrl);
                    bT.field_xml = j.b(bT);
                    h.ata().a(bT, "localId");
                    w.v("MicroMsg.FavCdnService", "klem onCdnTranFinish thumb key and url updated, md5:%s, cdnUrl:%s", new Object[]{aVar.field_dataId, aVar.field_cdnUrl});
                    break;
                }
            }
            rmVar.NQ(aVar.field_cdnKey);
            rmVar.NP(aVar.field_cdnUrl);
            if (aVar.field_type == 0 && aVar.atb()) {
                w.v("MicroMsg.FavCdnService", "video stream, id:%s", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId});
                rmVar.Oe(com_tencent_mm_modelcdntran_keep_SceneResult.field_videoFileId);
            }
            bT.field_xml = j.b(bT);
            h.ata().a(bT, "localId");
            w.v("MicroMsg.FavCdnService", "klem onCdnTranFinish data key and url updated, md5:%s, cdnUrl:%s", new Object[]{aVar.field_dataId, aVar.field_cdnUrl});
        }
        d(aVar);
    }

    public static void d(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar.field_type == 0) {
            e(aVar);
        } else if (aVar.field_type == 1) {
            f(aVar);
        }
    }

    public static void e(com.tencent.mm.plugin.favorite.b.a aVar) {
        int m = h.asV().m(aVar.field_favLocalId, 0);
        w.v("MicroMsg.FavCdnService", "klem updateUploadStatus, upload data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(m), Long.valueOf(aVar.field_favLocalId)});
        j bT = h.ata().bT(aVar.field_favLocalId);
        if (bT == null) {
            w.e("MicroMsg.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (bT.atn()) {
            w.i("MicroMsg.FavCdnService", "klem updateUploadStatus waiting server upload skip.");
        } else if (aVar.field_status == 3 && m != aVar.field_status && bT.field_type == 18 && h.asV().vN(aVar.field_dataId).field_status == 3) {
            a(aVar, bT);
        } else {
            switch (m) {
                case 0:
                    return;
                case 1:
                    if (bT.atm()) {
                        h.ata().r(15, aVar.field_favLocalId);
                    } else {
                        h.ata().r(4, aVar.field_favLocalId);
                    }
                    w.i("MicroMsg.FavCdnService", "klem updateUploadStatus, continue upload data, favlocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                    return;
                case 2:
                    h.ata().r(6, aVar.field_favLocalId);
                    w.i("MicroMsg.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                    return;
                case 3:
                    if (bT.field_type == 18) {
                        a(aVar, bT);
                        return;
                    } else if (bT.atm()) {
                        h.ata().r(17, aVar.field_favLocalId);
                        w.i("MicroMsg.FavCdnService", "klem updateUploadStatus start mod faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                        h.asS().run();
                        return;
                    } else {
                        h.ata().r(9, aVar.field_favLocalId);
                        w.i("MicroMsg.FavCdnService", "klem updateUploadStatus start send faviteminfo, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                        h.asQ().run();
                        return;
                    }
                case 4:
                    if (bT.atm()) {
                        h.ata().r(16, aVar.field_favLocalId);
                    } else {
                        h.ata().r(6, aVar.field_favLocalId);
                    }
                    g.oUh.i(10659, new Object[]{Integer.valueOf(0), Integer.valueOf(bT.field_type), Integer.valueOf(-5), Long.valueOf(x.k(bT)), Long.valueOf(x.bY(bT.field_localId))});
                    w.i("MicroMsg.FavCdnService", "klem updateUploadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                    return;
                default:
                    return;
            }
        }
    }

    public static void f(com.tencent.mm.plugin.favorite.b.a aVar) {
        w.v("MicroMsg.FavCdnService", "klem updateDownloadStatus, download data status:%d, favlocalId:%d", new Object[]{Integer.valueOf(h.asV().m(aVar.field_favLocalId, 1)), Long.valueOf(aVar.field_favLocalId)});
        j bT = h.ata().bT(aVar.field_favLocalId);
        if (bT == null) {
            w.e("MicroMsg.FavCdnService", "klem updateDownloadStatus iteminfo null");
        } else if (bT.atn() || bT.ati() || bT.atj()) {
            w.i("MicroMsg.FavCdnService", "klem updateDownloadStatus, status upload, skip. isWaitServerUpload:%b  isUploadding:%b  isUploadFailed:%b", new Object[]{Boolean.valueOf(bT.atn()), Boolean.valueOf(bT.ati()), Boolean.valueOf(bT.atj())});
        } else {
            switch (r0) {
                case 0:
                    w.i("MicroMsg.FavCdnService", "klem updateDownloadStatus init, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id)});
                    h.ata().r(10, aVar.field_favLocalId);
                    return;
                case 1:
                    x.bZ(bT.field_localId);
                    h.ata().r(7, aVar.field_favLocalId);
                    return;
                case 2:
                    w.i("MicroMsg.FavCdnService", "klem updateUploadStatus pause, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id)});
                    h.ata().r(8, aVar.field_favLocalId);
                    return;
                case 3:
                    w.i("MicroMsg.FavCdnService", "klem updateDownloadStatus finish, favLocalId:%d, favId:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id)});
                    g.oUh.i(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(bT.field_type), Integer.valueOf(0), Long.valueOf(x.k(bT)), Long.valueOf(x.bY(bT.field_localId))});
                    h.ata().r(10, aVar.field_favLocalId);
                    return;
                case 4:
                    w.i("MicroMsg.FavCdnService", "klem updateDownloadStatus, error, favLocalId:%d, favId:%d, itemStatus:%d", new Object[]{Long.valueOf(aVar.field_favLocalId), Integer.valueOf(bT.field_id), Integer.valueOf(bT.field_itemStatus)});
                    g.oUh.i(10659, new Object[]{Integer.valueOf(1), Integer.valueOf(bT.field_type), Integer.valueOf(-5), Long.valueOf(x.k(bT)), Long.valueOf(x.bY(bT.field_localId))});
                    h.ata().r(8, aVar.field_favLocalId);
                    return;
                default:
                    return;
            }
        }
    }

    private static void a(com.tencent.mm.plugin.favorite.b.a aVar, j jVar) {
        Iterator it = jVar.field_favProto.tzn.iterator();
        int i = 0;
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (!(rmVar.aMw == 1 || rmVar.aMw == 6)) {
                int i2;
                if (bg.mA(rmVar.txi)) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        if (i != 0) {
            return;
        }
        if (jVar.field_id > 0) {
            h.ata().r(17, aVar.field_favLocalId);
            h.asS().run();
            return;
        }
        h.ata().r(9, aVar.field_favLocalId);
        h.asQ().run();
    }

    public final void g(com.tencent.mm.plugin.favorite.b.a aVar) {
        if (aVar != null) {
            this.fBi.add(aVar);
        }
    }
}
