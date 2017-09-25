package com.tencent.mm.plugin.webview.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.h;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.util.Iterator;
import java.util.Vector;

public final class ab implements e {
    private a hGH = new a(this) {
        final /* synthetic */ ab rWV;

        {
            this.rWV = r1;
        }

        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            w.i("MicroMsg.WebviewFileChooserCdnService", "getCdnAuthInfo, mediaId = %s", new Object[]{str});
        }

        public final byte[] i(String str, byte[] bArr) {
            w.i("MicroMsg.WebviewFileChooserCdnService", "decodePrepareResponse, mediaId = %s", new Object[]{str});
            return null;
        }

        public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
            String str2;
            WebViewJSSDKFileItem webViewJSSDKFileItem;
            String str3 = "MicroMsg.WebviewFileChooserCdnService";
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
            ac bwZ = f.bwZ();
            if (!bg.mA(str)) {
                for (WebViewJSSDKFileItem webViewJSSDKFileItem2 : bwZ.rWZ.values()) {
                    if (bg.mz(webViewJSSDKFileItem2.mediaId).equals(str)) {
                        webViewJSSDKFileItem = webViewJSSDKFileItem2;
                        break;
                    }
                }
            }
            w.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByMediaID error, media id is null or nil");
            webViewJSSDKFileItem = null;
            if (webViewJSSDKFileItem == null) {
                w.e("MicroMsg.WebviewFileChooserCdnService", "get item by media id failed, media is : %s", new Object[]{str});
                return 0;
            } else if (i == -21005) {
                w.i("MicroMsg.WebviewFileChooserCdnService", "duplicate request, ignore this request, media id is %s", new Object[]{str});
                return 0;
            } else if (i != 0) {
                w.e("MicroMsg.WebviewFileChooserCdnService", "start failed : %d, media id is :%s", new Object[]{Integer.valueOf(i), str});
                this.rWV.a(false, webViewJSSDKFileItem.fJz, webViewJSSDKFileItem.mediaId, null);
                return 0;
            } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                w.i("MicroMsg.WebviewFileChooserCdnService", "progressInfo : %s", new Object[]{com_tencent_mm_modelcdntran_keep_ProgressInfo.toString()});
                int i2 = 0;
                if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength > 0) {
                    i2 = (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength * 100) / com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength;
                }
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 100) {
                    i2 = 100;
                }
                this.rWV.b(webViewJSSDKFileItem.iDD, webViewJSSDKFileItem.fIL, i2, webViewJSSDKFileItem.fJz, webViewJSSDKFileItem.mediaId);
                return 0;
            } else {
                if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.WebviewFileChooserCdnService", "cdntra clientid:%s sceneResult.retCode:%d sceneResult[%s]", new Object[]{str, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode), com_tencent_mm_modelcdntran_keep_SceneResult});
                        this.rWV.a(false, webViewJSSDKFileItem.fJz, webViewJSSDKFileItem.mediaId, null);
                    } else {
                        w.i("MicroMsg.WebviewFileChooserCdnService", "cdn trans suceess, media id : %s", new Object[]{str});
                        if (webViewJSSDKFileItem != null) {
                            webViewJSSDKFileItem.b(com_tencent_mm_modelcdntran_keep_SceneResult);
                            if (webViewJSSDKFileItem.iDD && webViewJSSDKFileItem.iDF) {
                                e eVar = this.rWV;
                                if (webViewJSSDKFileItem == null) {
                                    w.e("MicroMsg.WebviewFileChooserCdnService", "uploadCdnInfo failed, item is null");
                                } else {
                                    akb com_tencent_mm_protocal_c_akb = new akb();
                                    com_tencent_mm_protocal_c_akb.tNW = webViewJSSDKFileItem.rWX.field_aesKey;
                                    com_tencent_mm_protocal_c_akb.tpP = webViewJSSDKFileItem.rWX.field_fileLength;
                                    com_tencent_mm_protocal_c_akb.tNV = webViewJSSDKFileItem.rWX.field_fileId;
                                    com_tencent_mm_protocal_c_akb.type = webViewJSSDKFileItem.bwo();
                                    w.d("MicroMsg.WebviewFileChooserCdnService", "appId:%s, localId:%s, aes_key:%s， file_size:%d, fileId:%s", new Object[]{webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fJz, com_tencent_mm_protocal_c_akb.tNW, Integer.valueOf(com_tencent_mm_protocal_c_akb.tpP), com_tencent_mm_protocal_c_akb.tNV});
                                    com_tencent_mm_protocal_c_akb.tNX = webViewJSSDKFileItem.bwn();
                                    ap.vd().a(1034, eVar);
                                    ap.vd().a(new w(webViewJSSDKFileItem.appId, webViewJSSDKFileItem.fJz, com_tencent_mm_protocal_c_akb), 0);
                                }
                            } else {
                                this.rWV.a(true, webViewJSSDKFileItem.fJz, webViewJSSDKFileItem.iDB, webViewJSSDKFileItem.rWX.field_fileUrl);
                            }
                        }
                    }
                }
                return 0;
            }
        }
    };
    private Vector<b> iDG = new Vector();
    private Vector<c.a> iDH = new Vector();

    public final void a(c.a aVar) {
        if (this.iDH != null && aVar != null && !this.iDH.contains(aVar)) {
            this.iDH.add(aVar);
        }
    }

    public final void a(b bVar) {
        if (this.iDG != null && bVar != null) {
            this.iDG.remove(bVar);
        }
    }

    public final void b(c.a aVar) {
        if (this.iDH != null && aVar != null) {
            this.iDH.remove(aVar);
        }
    }

    public final void a(boolean z, String str, String str2, String str3) {
        if (this.iDG != null && this.iDG.size() > 0) {
            Iterator it = this.iDG.iterator();
            while (it.hasNext()) {
                ((b) it.next()).b(z, str, str2, str3);
            }
        }
    }

    public final void b(boolean z, int i, int i2, String str, String str2) {
        w.i("MicroMsg.WebviewFileChooserCdnService", "notifyProgressCallback, upload : %b, mediaType : %d, percent : %d, localId : %s, mediaId : %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), str, str2});
        if (this.iDH != null && this.iDH.size() > 0) {
            Iterator it = this.iDH.iterator();
            while (it.hasNext()) {
                ((c.a) it.next()).a(z, i, i2, str, str2);
            }
        }
    }

    public final boolean a(String str, String str2, b bVar) {
        ac bwZ = f.bwZ();
        if (!bg.mA(str2)) {
            for (WebViewJSSDKFileItem webViewJSSDKFileItem : bwZ.rWZ.values()) {
                if (bg.mz(webViewJSSDKFileItem.iDB).equals(str2)) {
                    break;
                }
            }
        }
        w.e("MicroMsg.WebViewJSSDKFileItemManager", "getItemByServerId error, media id is null or nil");
        WebViewJSSDKFileItem webViewJSSDKFileItem2 = null;
        if (webViewJSSDKFileItem2 != null) {
            webViewJSSDKFileItem2.appId = str;
            w.i("MicroMsg.WebviewFileChooserCdnService", "the file item has alreay in local : appid : %s, serverId : %s, localId : %s", new Object[]{str, str2, webViewJSSDKFileItem2.fJz});
            bVar.b(true, webViewJSSDKFileItem2.fJz, webViewJSSDKFileItem2.iDB, null);
        } else {
            ap.vd().a(1035, this);
            ap.vd().a(new f(str, str2), 0);
            this.iDG.add(bVar);
        }
        return true;
    }

    private void a(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        h hVar = new h();
        hVar.hze = this.hGH;
        hVar.fZK = false;
        hVar.field_mediaId = webViewJSSDKFileItem.mediaId;
        hVar.field_fullpath = webViewJSSDKFileItem.iDA;
        hVar.field_totalLen = webViewJSSDKFileItem.rWX.field_fileLength;
        hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
        hVar.field_fileId = webViewJSSDKFileItem.rWX.field_fileId;
        hVar.field_aesKey = webViewJSSDKFileItem.rWX.field_aesKey;
        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
        hVar.field_needStorage = false;
        hVar.field_isStreamMedia = false;
        w.i("MicroMsg.WebviewFileChooserCdnService", "add download cdn task : %b, localid : %s", new Object[]{Boolean.valueOf(g.El().b(hVar, -1)), webViewJSSDKFileItem.iDB});
        if (!g.El().b(hVar, -1)) {
            a(false, null, null, null);
        }
    }

    public final boolean a(String str, String str2, int i, int i2, int i3, b bVar) {
        WebViewJSSDKFileItem IS = f.bwZ().IS(str2);
        if (IS == null) {
            w.e("MicroMsg.WebviewFileChooserCdnService", "addUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str2});
            return false;
        }
        IS.appId = str;
        if (bVar != null) {
            this.iDG.add(bVar);
        }
        if (i2 == com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX) {
            IS.iDF = false;
        }
        IS.iDD = true;
        h hVar = new h();
        hVar.hze = this.hGH;
        hVar.fZK = true;
        hVar.field_mediaId = IS.mediaId;
        hVar.field_fullpath = IS.iDA;
        hVar.field_fileType = i;
        hVar.field_talker = "weixin";
        hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
        if (i == com.tencent.mm.modelcdntran.b.hxO) {
            hVar.field_needStorage = true;
        } else {
            hVar.field_needStorage = false;
        }
        hVar.field_isStreamMedia = false;
        hVar.field_appType = i2;
        hVar.field_bzScene = i3;
        hVar.field_force_aeskeycdn = true;
        hVar.field_trysafecdn = false;
        w.i("MicroMsg.WebviewFileChooserCdnService", "summersafecdn add upload cdn task : %b, force_aeskeycdn: %b, trysafecdn: %b, localid : %s ", new Object[]{Boolean.valueOf(g.El().b(hVar)), Boolean.valueOf(hVar.field_force_aeskeycdn), Boolean.valueOf(hVar.field_trysafecdn), str2});
        return g.El().b(hVar);
    }

    public final boolean b(String str, String str2, b bVar) {
        return a(str, str2, com.tencent.mm.modelcdntran.b.MediaType_FILE, 0, 0, bVar);
    }

    public static boolean nW(String str) {
        WebViewJSSDKFileItem IS = f.bwZ().IS(str);
        if (IS != null) {
            return g.El().iO(IS.mediaId);
        }
        w.e("MicroMsg.WebviewFileChooserCdnService", "cancelUploadTask get webview file chooser item  by local id failed : %s", new Object[]{str});
        return false;
    }

    public static boolean IO(String str) {
        w.i("MicroMsg.WebviewFileChooserCdnService", "cancelDownloadTask get webview file chooser item  by local id : %s", new Object[]{str});
        return g.El().iP(str);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WebviewFileChooserCdnService", "onSceneEnd, errType = %d, errCode = %d, funcType = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(kVar.getType())});
        String str2;
        String str3;
        String str4;
        String str5;
        switch (kVar.getType()) {
            case 1034:
                ap.vd().b(1034, this);
                w wVar = (w) kVar;
                str2 = ((akh) wVar.gUA.hsk.hsr).tNY;
                str3 = wVar.appId;
                str4 = wVar.fJz;
                WebViewJSSDKFileItem IS = f.bwZ().IS(str4);
                String str6 = "MicroMsg.WebviewFileChooserCdnService";
                str5 = "get server server id : %s from server for appid : %s, localId = %s, item == null ? %b";
                Object[] objArr = new Object[4];
                objArr[0] = str2;
                objArr[1] = str3;
                objArr[2] = str4;
                objArr[3] = Boolean.valueOf(IS == null);
                w.i(str6, str5, objArr);
                if (i != 0 || i2 != 0) {
                    w.e("MicroMsg.WebviewFileChooserCdnService", "upload cdn info failed");
                    if (IS != null) {
                        a(false, IS.fJz, IS.mediaId, null);
                        return;
                    }
                    return;
                } else if (!bg.mA(str3) && !bg.mA(str2) && IS != null) {
                    IS.iDB = str2;
                    b(true, IS.fIL, 100, IS.fJz, IS.iDB);
                    a(true, IS.fJz, IS.iDB, IS.rWX.field_fileUrl);
                    return;
                } else {
                    return;
                }
            case 1035:
                ap.vd().b(1035, this);
                if (i == 0 && i2 == 0) {
                    f fVar = (f) kVar;
                    str2 = fVar.appId;
                    str3 = fVar.iDB;
                    akb com_tencent_mm_protocal_c_akb = ((akd) fVar.gUA.hsk.hsr).tNZ;
                    str5 = "MicroMsg.WebviewFileChooserCdnService";
                    String str7 = "appid = %s, serverId = %s, cdninfo == null ? %b";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = str2;
                    objArr2[1] = str3;
                    objArr2[2] = Boolean.valueOf(com_tencent_mm_protocal_c_akb == null);
                    w.i(str5, str7, objArr2);
                    if (!bg.mA(str2) && !bg.mA(str3) && com_tencent_mm_protocal_c_akb != null) {
                        str4 = com_tencent_mm_protocal_c_akb.type;
                        w.i("MicroMsg.WebviewFileChooserCdnService", "cdn info type = %s", new Object[]{str4});
                        if (!bg.mA(str4)) {
                            WebViewJSSDKFileItem IQ;
                            if (str4.toLowerCase().equals("voice")) {
                                IQ = WebViewJSSDKFileItem.IQ(ah.IZ(str2));
                            } else if (str4.toLowerCase().equals(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                                IQ = WebViewJSSDKFileItem.IR(ah.IT(bg.Nz()));
                            } else {
                                IQ = WebViewJSSDKFileItem.IP(ah.IT(bg.Nz()));
                            }
                            IQ.iDD = false;
                            IQ.appId = str2;
                            IQ.iDB = str3;
                            if (IQ.rWX == null) {
                                IQ.rWX = new WebViewJSSDKFileItem.a();
                            }
                            if (com_tencent_mm_protocal_c_akb == null) {
                                w.e("MicroMsg.WebViewJSSDKFileItem", "jsapidcdn info is null");
                            } else {
                                IQ.rWX.field_aesKey = com_tencent_mm_protocal_c_akb.tNW;
                                IQ.rWX.field_fileId = com_tencent_mm_protocal_c_akb.tNV;
                                IQ.rWX.field_fileLength = com_tencent_mm_protocal_c_akb.tpP;
                            }
                            f.bwZ().b(IQ);
                            a(IQ);
                            return;
                        }
                        return;
                    }
                    return;
                }
                w.e("MicroMsg.WebviewFileChooserCdnService", "download cdn info failed");
                a(false, null, null, null);
                return;
            default:
                return;
        }
    }
}
