package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

public final class h extends f<g> {
    private a hGH = new a(this) {
        final /* synthetic */ h oOq;

        {
            this.oOq = r1;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            w.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, startRet[%d], mediaId[%s]", Integer.valueOf(i), str);
            if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.v("MicroMsg.RecordMsgCDNService", "cdn transfer callback, mediaid[%s], totallen[%d], offset[%d]", com_tencent_mm_modelcdntran_keep_ProgressInfo.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength));
            }
            if (i == -21006 || i == -21005) {
                this.oOq.aWB();
                return 0;
            }
            final g Do = s.aWF().Do(str);
            if (Do == null) {
                w.w("MicroMsg.RecordMsgCDNService", "onCdnCallback info null, mediaId[%s]", str);
                this.oOq.aWB();
                return 0;
            }
            if (i != 0) {
                w.w("MicroMsg.RecordMsgCDNService", "tran fail, startRet[%d], mediaId[%s], type[%d]", Integer.valueOf(i), str, Integer.valueOf(Do.field_type));
                if (-5103059 == i) {
                    Do.field_status = 4;
                } else {
                    Do.field_status = 3;
                }
                Do.field_errCode = i;
                s.aWF().b(Do, "localId");
            } else {
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    Do.field_offset = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength;
                    Do.field_totalLen = com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                    Do.field_status = 1;
                    s.aWF().b(Do, "localId");
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    w.i("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload attach by cdn, retCode:%d isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], aesKey[%s], md5[%s]", Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Boolean.valueOf(z), Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_exist_whencheck), bg.Qj(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey), com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5);
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode >= 0) {
                        Do.field_status = 2;
                        if (1 == Do.field_type) {
                            String str2 = Do.field_path + ".temp";
                            String str3 = Do.field_path;
                            if (bg.mA(str2) || bg.mA(str3)) {
                                w.w("MicroMsg.RecordMsgCDNService", "do rename and copy file, but path error");
                            } else {
                                File file = new File(str2);
                                File file2 = new File(str3);
                                if (file.exists()) {
                                    boolean renameTo = file.renameTo(file2);
                                    w.v("MicroMsg.RecordMsgCDNService", "rename file suc:%b, old:%s, new:%s", Boolean.valueOf(renameTo), str2, file2);
                                }
                            }
                            s.aWF().a(Do, "localId");
                        } else {
                            w.i("MicroMsg.RecordMsgCDNService", "transfer done, mediaid=%s, md5=%s", com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, str);
                            w.d("MicroMsg.RecordMsgCDNService", "transfer done, completeInfo=%s", com_tencent_mm_modelcdntran_keep_SceneResult);
                            w.d("MicroMsg.RecordMsgCDNService", "summersafecdn cdnCallback upload field_aesKey[%s], field_fileId[%s]", com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
                            if (com_tencent_mm_modelcdntran_keep_SceneResult.isUploadBySafeCDNWithMD5()) {
                                w.i("MicroMsg.RecordMsgCDNService", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s], newmd5[%s]", Boolean.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_upload_by_safecdn), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_UploadHitCacheType), Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc), com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5);
                                ap.vd().a(new aa(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_mp4identifymd5, com_tencent_mm_modelcdntran_keep_SceneResult.field_filecrc, new aa.a(this) {
                                    final /* synthetic */ AnonymousClass1 oOt;

                                    public final void H(String str, int i, int i2) {
                                        w.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 callback [%d, %d], [%s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                        if (i == 4 && i2 == 102) {
                                            w.i("MicroMsg.RecordMsgCDNService", "summersafecdn NetSceneCheckMd5 MM_ERR_GET_AESKEY_FAILED old status[%d, %d, %d]", Integer.valueOf(Do.field_status), Integer.valueOf(Do.field_offset), Integer.valueOf(Do.field_totalLen));
                                            Do.field_offset = 0;
                                            Do.field_totalLen = 0;
                                            Do.field_status = 0;
                                            s.aWF().b(Do, "localId");
                                            this.oOt.oOq.a(Do, false);
                                            return;
                                        }
                                        Do.field_cdnKey = str;
                                        Do.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                                        s.aWF().b(Do, "localId");
                                        this.oOt.oOq.aWB();
                                    }
                                }), 0);
                                return 0;
                            }
                            Do.field_cdnKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                            Do.field_cdnUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                            s.aWF().b(Do, "localId");
                        }
                    } else {
                        w.e("MicroMsg.RecordMsgCDNService", "transfer error, mediaid=%s, retCode:%d", com_tencent_mm_modelcdntran_keep_SceneResult.mediaId, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode));
                        if (-5103059 == com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode) {
                            Do.field_status = 4;
                        } else {
                            Do.field_status = 3;
                        }
                        Do.field_errCode = com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode;
                        s.aWF().b(Do, "localId");
                    }
                }
                return 0;
            }
            this.oOq.aWB();
            return 0;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        public final byte[] i(String str, byte[] bArr) {
            return null;
        }
    };

    protected final /* bridge */ /* synthetic */ void a(f.a aVar) {
        a((g) aVar, true);
    }

    protected final List<g> aWA() {
        i aWF = s.aWF();
        List<g> linkedList = new LinkedList();
        Cursor a = aWF.gUz.a("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2", null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                g gVar = new g();
                gVar.b(a);
                linkedList.add(gVar);
            }
            a.close();
        }
        w.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", Integer.valueOf(linkedList.size()));
        w.d("MicroMsg.RecordMsgCDNService", "get to do jobs, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    public final void a(g gVar, boolean z) {
        w.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, md5:%s, mediaId:%s, jobType[%d], jobStatus[%s]", gVar.field_dataId, gVar.field_mediaId, Integer.valueOf(gVar.field_type), Integer.valueOf(gVar.field_status));
        com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
        hVar.hze = this.hGH;
        hVar.field_mediaId = gVar.field_mediaId;
        if (2 == gVar.field_type) {
            hVar.fZK = true;
            hVar.field_priority = b.hxK;
            hVar.field_needStorage = false;
            hVar.field_totalLen = gVar.field_totalLen;
            hVar.field_aesKey = gVar.field_cdnKey;
            hVar.field_fileId = gVar.field_cdnUrl;
            hVar.hze = this.hGH;
            hVar.field_fullpath = gVar.field_path;
            hVar.field_fileType = gVar.field_fileType;
            hVar.field_talker = gVar.field_toUser;
            hVar.field_force_aeskeycdn = false;
            hVar.field_trysafecdn = true;
            hVar.field_enable_hitcheck = z;
            w.i("MicroMsg.RecordMsgCDNService", "summersafecdn doJob TYPE_UPLOAD addSendTask field_force_aeskeycdn:%b, type[%d], aesKey[%s], fileId[%s], force_aeskeycdn[%b] trysafecdn[%b] enable_hitcheck[%b]", Boolean.valueOf(hVar.field_force_aeskeycdn), Integer.valueOf(hVar.field_fileType), hVar.field_aesKey, hVar.field_fileId, Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), Boolean.valueOf(hVar.field_enable_hitcheck));
            g.El().b(hVar);
        } else {
            hVar.fZK = false;
            hVar.field_priority = b.hxL;
            hVar.field_needStorage = false;
            hVar.field_totalLen = gVar.field_totalLen;
            hVar.field_aesKey = gVar.field_cdnKey;
            hVar.field_fileId = gVar.field_cdnUrl;
            hVar.hze = this.hGH;
            hVar.field_fullpath = gVar.field_path + ".temp";
            hVar.field_fileType = gVar.field_fileType;
            g.El().b(hVar, -1);
        }
        w.d("MicroMsg.RecordMsgCDNService", "summersafecdn doJob, isSend:%B totallen:%d, aseKey:%s, url[%s], fullPath[%s], fileType[%d], enable_hitcheck[%b], force_aeskeycdn[%b]", Boolean.valueOf(hVar.fZK), Integer.valueOf(hVar.field_totalLen), hVar.field_aesKey, hVar.field_fileId, hVar.field_fullpath, Integer.valueOf(hVar.field_fileType), Boolean.valueOf(hVar.field_enable_hitcheck), Boolean.valueOf(hVar.field_force_aeskeycdn));
    }
}
