package com.tencent.mm.plugin.appbrand.c;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

public final class b {
    public a hGH = new a(this) {
        final /* synthetic */ b iDK;

        {
            this.iDK = r1;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            w.i("MicroMsg.AppbrandCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
        }

        public final byte[] i(String str, byte[] bArr) {
            w.i("MicroMsg.AppbrandCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
            return null;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2;
            a aVar;
            String str3 = "MicroMsg.AppbrandCdnService";
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
            w.i(str3, str4, objArr);
            c Qb = c.Qb();
            if (!bg.mA(str)) {
                for (a aVar2 : Qb.iDL.values()) {
                    if (bg.mz(aVar2.mediaId).equals(str)) {
                        aVar = aVar2;
                        break;
                    }
                }
            }
            w.e("MicroMsg.AppbrandMediaCdnItemManager", "getItemByMediaID error, media id is null or nil");
            aVar = null;
            if (aVar == null) {
                w.e("MicroMsg.AppbrandCdnService", "get item by media id failed, media is : %s", new Object[]{str});
                return 0;
            } else if (i == -21005) {
                w.i("MicroMsg.AppbrandCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
                return 0;
            } else if (i != 0) {
                w.e("MicroMsg.AppbrandCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                this.iDK.a(false, aVar.fJz, aVar.mediaId, null);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                int i2;
                w.i("MicroMsg.AppbrandCdnService", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
                int i3 = 0;
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                    i3 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                }
                if (i3 < 0) {
                    i2 = 0;
                } else if (i3 > 100) {
                    i2 = 100;
                } else {
                    i2 = i3;
                }
                b bVar = this.iDK;
                boolean z2 = aVar.iDD;
                int i4 = aVar.fIL;
                String str5 = aVar.fJz;
                str4 = aVar.mediaId;
                w.i("MicroMsg.AppbrandCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z2), Integer.valueOf(i4), Integer.valueOf(i2), str5, str4});
                if (bVar.iDH != null && bVar.iDH.size() > 0) {
                    Iterator it = bVar.iDH.iterator();
                    while (it.hasNext()) {
                        ((d.a) it.next()).v(i2, str5);
                    }
                }
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.AppbrandCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        this.iDK.a(false, aVar.fJz, aVar.mediaId, null);
                    } else {
                        w.i("MicroMsg.AppbrandCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                        if (aVar != null) {
                            if (aVar.iDC == null) {
                                aVar.iDC = new a.a();
                            }
                            if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
                                w.e("MicroMsg.AppBrandMediaCdnItem", "sceneResult info is null");
                            } else {
                                aVar.iDC.field_aesKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
                                aVar.iDC.field_fileId = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
                                aVar.iDC.field_fileUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
                                aVar.iDC.field_fileLength = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
                                aVar.iDB = aVar.iDC.field_fileId;
                            }
                            c.Qb().a(aVar);
                            this.iDK.a(true, aVar.fJz, aVar.iDB, aVar.iDC.field_fileUrl);
                        }
                    }
                }
                return 0;
            }
        }
    };
    public Vector<com.tencent.mm.plugin.appbrand.c.d.b> iDG = new Vector();
    public Vector<d.a> iDH = new Vector();
    public HashMap<String, d.c> iDI = new HashMap();
    public i.a iDJ = new i.a(this) {
        final /* synthetic */ b iDK;

        {
            this.iDK = r1;
        }

        public final void onMoovReady(String str, int i, int i2) {
            w.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on moov ready [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            d.c cVar = (d.c) this.iDK.iDI.get(str);
            if (cVar != null) {
                cVar.bj(i, i2);
            }
        }

        public final void onDataAvailable(String str, int i, int i2) {
            w.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on data available [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            d.c cVar = (d.c) this.iDK.iDI.get(str);
            if (cVar != null) {
                cVar.bk(i, i2);
            }
        }

        public final void f(String str, int i, int i2) {
            w.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on progress [%s %d %d]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            d.c cVar = (d.c) this.iDK.iDI.get(str);
            if (cVar != null) {
                cVar.bl(i, i2);
            }
        }

        public final void w(String str, int i) {
            w.i("MicroMsg.AppbrandCdnService", "appbrand cdn service on finish [%s %d]", new Object[]{str, Integer.valueOf(i)});
            d.c cVar = (d.c) this.iDK.iDI.get(str);
            if (cVar != null) {
                cVar.w(str, i);
            }
        }
    };

    public final void a(com.tencent.mm.plugin.appbrand.c.d.b bVar) {
        if (this.iDG != null && bVar != null) {
            this.iDG.remove(bVar);
        }
    }

    public final void a(d.a aVar) {
        if (this.iDH != null && aVar != null) {
            this.iDH.remove(aVar);
        }
    }

    public final void a(boolean z, String str, String str2, String str3) {
        if (this.iDG != null && this.iDG.size() > 0) {
            Iterator it = this.iDG.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.plugin.appbrand.c.d.b) it.next()).b(z, str, str2, str3);
            }
        }
    }

    public static boolean nW(String str) {
        a nY = c.Qb().nY(str);
        if (nY != null) {
            return g.El().iO(nY.mediaId);
        }
        w.e("MicroMsg.AppbrandCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public final void nX(String str) {
        this.iDI.remove(str);
    }
}
