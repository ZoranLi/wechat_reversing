package com.tencent.mm.plugin.card.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public static List<WeakReference<a>> kcI = new ArrayList();

    public interface a {
        void aB(String str, int i);

        void bA(String str, String str2);

        void fail(String str);
    }

    public static void a(a aVar) {
        if (kcI == null) {
            kcI = new ArrayList();
        }
        if (aVar == null) {
            w.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            return;
        }
        w.i("MicroMsg.CDNDownloadHelpper", "register:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
        kcI.add(new WeakReference(aVar));
    }

    public static void b(a aVar) {
        if (kcI != null && aVar != null) {
            w.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", new Object[]{Integer.valueOf(aVar.hashCode())});
            for (int i = 0; i < kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) kcI.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        kcI.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public static void f(final String str, String str2, int i, int i2) {
        int i3 = 0;
        if (str == null || str2 == null || i == 0) {
            w.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            return;
        }
        String str3;
        String Pq = aa.Pq(str);
        File file = new File(m.kfx);
        if (!file.mkdirs()) {
            w.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + file.exists());
        }
        String str4 = i2 == 2 ? ".jpeg" : ".mp4";
        if (file.getAbsolutePath().endsWith("/")) {
            str3 = file.getAbsolutePath() + Pq + str4;
        } else {
            str3 = file.getAbsolutePath() + File.separator + Pq + str4;
        }
        w.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", new Object[]{Pq, str3});
        w.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3});
        w.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.aN(str3));
        WeakReference weakReference;
        a aVar;
        if (e.aO(str3) && e.aN(str3) == i) {
            while (i3 < kcI.size()) {
                weakReference = (WeakReference) kcI.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bA(str, str3);
                    }
                }
                i3++;
            }
            return;
        }
        w.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", new Object[]{str3});
        h hVar = new h();
        hVar.hze = new com.tencent.mm.modelcdntran.h.a() {
            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (i == -21005) {
                    w.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", new Object[]{str});
                } else if (i != 0) {
                    w.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                    for (r1 = 0; r1 < a.kcI.size(); r1++) {
                        r0 = (WeakReference) a.kcI.get(r1);
                        if (r0 != null) {
                            r0 = (a) r0.get();
                            if (r0 != null) {
                                r0.fail(str);
                            }
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    w.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                        r1 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                    } else {
                        r1 = 0;
                    }
                    if (r1 < 0) {
                        r1 = 0;
                    } else if (r1 > 100) {
                        r1 = 100;
                    }
                    for (int i2 = 0; i2 < a.kcI.size(); i2++) {
                        r0 = (WeakReference) a.kcI.get(i2);
                        if (r0 != null) {
                            r0 = (a) r0.get();
                            if (r0 != null) {
                                r0.aB(str, r1);
                            }
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        for (r1 = 0; r1 < a.kcI.size(); r1++) {
                            r0 = (WeakReference) a.kcI.get(r1);
                            if (r0 != null) {
                                r0 = (a) r0.get();
                                if (r0 != null) {
                                    r0.fail(str);
                                }
                            }
                        }
                    } else {
                        w.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", new Object[]{com_tencent_mm_modelcdntran_keep_SceneResult});
                        for (r1 = 0; r1 < a.kcI.size(); r1++) {
                            r0 = (WeakReference) a.kcI.get(r1);
                            if (r0 != null) {
                                r0 = (a) r0.get();
                                if (r0 != null) {
                                    r0.bA(str, str3);
                                }
                            }
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                w.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
            }

            public final byte[] i(String str, byte[] bArr) {
                w.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", new Object[]{str});
                return null;
            }
        };
        hVar.fZK = false;
        hVar.field_mediaId = d.a("cardgiftfile", bg.Nz(), str, str);
        hVar.field_fullpath = str3;
        hVar.field_totalLen = i;
        hVar.field_fileType = b.hxO;
        hVar.field_fileId = str;
        hVar.field_aesKey = str2;
        hVar.field_priority = b.hxL;
        hVar.field_needStorage = true;
        w.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", new Object[]{Boolean.valueOf(g.El().b(hVar, -1)), hVar.field_fileId});
        if (!g.El().b(hVar, -1)) {
            while (i3 < kcI.size()) {
                weakReference = (WeakReference) kcI.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.fail(str);
                    }
                }
                i3++;
            }
            w.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
    }
}
