package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.e.a.cm;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.h.a;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.emoji.e.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.protocal.c.px;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.ByteArrayOutputStream;
import java.io.File;

public final class g extends k implements j {
    private final b gUA;
    private e gWW;
    public String hGx;
    private int hPi;
    public boolean htv;
    public String kMS;
    public String kMT;
    public String kMU;
    private int kMV;
    private a kMW;
    public com.tencent.mm.storage.a.a kMX;

    private g(String str, String str2, String str3, int i, int i2) {
        this.hGx = "";
        this.kMW = new a(this) {
            final /* synthetic */ g kMY;

            {
                this.kMY = r1;
            }

            public final int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z) {
                if (bg.mA(this.kMY.hGx) || !str.equals(this.kMY.hGx)) {
                    w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra mediaId is no equal");
                } else if (i == -21006) {
                    w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra  ERR_CNDCOM_MEDIA_IS_DOWNLOADING clientid:%s", new Object[]{this.kMY.hGx});
                    g.d(this.kMY.kMS, 6, 0, this.kMY.hGx);
                } else if (i != 0) {
                    w.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "download emoji pack failed. mProductId:%s:", new Object[]{this.kMY.kMS});
                    g.d(this.kMY.kMS, -1, 0, this.kMY.hGx);
                } else if (com_tencent_mm_modelcdntran_keep_ProgressInfo != null) {
                    if (com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength == com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength) {
                        w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra ignore progress 100%");
                    } else {
                        w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "cdntra progresscallback id:%s finish:%d total:%d", new Object[]{this.kMY.hGx, Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength), Integer.valueOf(com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)});
                        if (!this.kMY.htv) {
                            g.d(this.kMY.kMS, 6, (int) ((((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_finishedLength) / ((float) com_tencent_mm_modelcdntran_keep_ProgressInfo.field_toltalLength)) * 100.0f), this.kMY.hGx);
                        }
                    }
                } else if (com_tencent_mm_modelcdntran_keep_SceneResult != null) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(10625, new Object[]{Integer.valueOf(2), com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId, this.kMY.kMS, com_tencent_mm_modelcdntran_keep_SceneResult.field_transInfo});
                    if (com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode != 0) {
                        w.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji pack faild. ProductId:%s code:%d ", new Object[]{this.kMY.kMS, Integer.valueOf(com_tencent_mm_modelcdntran_keep_SceneResult.field_retCode)});
                        g.d(this.kMY.kMS, -1, 0, this.kMY.hGx);
                    } else {
                        w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "donwload emoji success.");
                        try {
                            c alw = c.alw();
                            String str2 = this.kMY.kMS;
                            if (alw.kJL != null && alw.kJL.contains(str2)) {
                                alw.kJL.remove(str2);
                            }
                            EmojiLogic.a(this.kMY.kMS, this.kMY.kMT, this.kMY.kMX);
                            h.amc().kLa.doNotify();
                            g.d(this.kMY.kMS, 7, 100, this.kMY.hGx);
                            File file = new File(com.tencent.mm.compatible.util.e.gSx + this.kMY.kMS);
                            if (file.isFile() && file.exists()) {
                                file.delete();
                            }
                            g.P(this.kMY.kMS, true);
                        } catch (Exception e) {
                            w.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Error." + bg.bJZ());
                            g.d(this.kMY.kMS, -1, 0, this.kMY.hGx);
                            g.P(this.kMY.kMS, false);
                            return 0;
                        } catch (OutOfMemoryError e2) {
                            w.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "unzip emoji package Out Of Memory Error." + bg.bJZ());
                            g.d(this.kMY.kMS, -1, 0, this.kMY.hGx);
                            g.P(this.kMY.kMS, false);
                            return 0;
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
            }

            public final byte[] i(String str, byte[] bArr) {
                return null;
            }
        };
        this.kMS = str;
        this.kMT = str3;
        this.kMU = str2;
        this.kMX = null;
        this.kMV = i;
        this.hPi = i2;
        b.a aVar = new b.a();
        aVar.hsm = new px();
        aVar.hsn = new py();
        aVar.uri = "/cgi-bin/micromsg-bin/exchangeemotionpack";
        aVar.hsl = 423;
        aVar.hso = com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX;
        aVar.hsp = 1000000213;
        this.gUA = aVar.BE();
    }

    public g(String str, String str2, String str3) {
        this(str, str2, str3, 0, 0);
    }

    public g(String str, String str2) {
        this(str, null, str2, 0, 0);
    }

    public g(String str) {
        this(str, null, "", 1, 0);
    }

    public g(String str, byte b) {
        this(str, null, "", 1, 1);
    }

    public final int getType() {
        return 423;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            if (this.hPi == 0) {
                File file = new File(com.tencent.mm.compatible.util.e.gSx);
                if (!file.exists()) {
                    file.mkdirs();
                }
                long currentTimeMillis = System.currentTimeMillis();
                StringBuilder stringBuilder = new StringBuilder();
                ap.yY();
                this.hGx = d.a("downzip", currentTimeMillis, stringBuilder.append(com.tencent.mm.u.c.uH()).toString(), "emoji");
                pf pfVar = ((py) this.gUA.hsk.hsr).tvU;
                com.tencent.mm.modelcdntran.h hVar = new com.tencent.mm.modelcdntran.h();
                hVar.field_mediaId = this.hGx;
                hVar.field_fullpath = com.tencent.mm.compatible.util.e.gSx + this.kMS;
                hVar.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FILE;
                hVar.field_totalLen = pfVar.tsR;
                hVar.field_aesKey = pfVar.tus;
                hVar.field_fileId = pfVar.msN;
                hVar.field_priority = com.tencent.mm.modelcdntran.b.hxL;
                hVar.hze = this.kMW;
                hVar.field_needStorage = true;
                this.htv = false;
                if (!com.tencent.mm.modelcdntran.g.El().b(hVar, -1)) {
                    w.e("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add task failed:");
                }
            } else {
                w.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "add custom emoji.need no download pack");
            }
            this.gWW.a(i2, i3, str, this);
            ap.vd().a(new k(this.kMS), 0);
            return;
        }
        this.gWW.a(i2, i3, str, this);
        d(this.kMS, -1, 0, this.hGx);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.emoji.NetSceneExchangeEmotionPack", "doScene");
        this.gWW = eVar2;
        if (this.hPi == 0) {
            d(this.kMS, 6, 0, this.hGx);
        }
        px pxVar = (px) this.gUA.hsj.hsr;
        pxVar.tgW = this.kMS;
        pxVar.tvS = this.kMU;
        pxVar.tvT = this.kMV;
        pxVar.tdM = this.hPi;
        return a(eVar, this.gUA, this);
    }

    public static void d(String str, int i, int i2, String str2) {
        h.ame().d(str, i, i2, str2);
    }

    protected final void cancel() {
        super.cancel();
        this.htv = true;
    }

    public static void P(String str, boolean z) {
        if (!bg.mA(str)) {
            w.i("MicroMsg.emoji.NetSceneExchangeEmotionPack", "[cpan] publicStoreEmojiDownLoadTaskEvent productId:%s success:%b", new Object[]{str, Boolean.valueOf(z)});
            com.tencent.mm.sdk.b.b cmVar = new cm();
            cmVar.fFV.fFW = str;
            cmVar.fFV.fEG = 2;
            cmVar.fFV.success = z;
            com.tencent.mm.sdk.b.a.urY.m(cmVar);
        }
    }
}
