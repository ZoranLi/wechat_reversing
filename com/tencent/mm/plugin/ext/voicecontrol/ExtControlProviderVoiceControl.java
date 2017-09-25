package com.tencent.mm.plugin.ext.voicecontrol;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import com.qq.wx.voice.embed.recognizer.b;
import com.qq.wx.voice.embed.recognizer.c;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.pluginsdk.f.a.a;
import com.tencent.mm.protocal.c.da;
import com.tencent.mm.protocal.c.dc;
import com.tencent.mm.protocal.c.df;
import com.tencent.mm.protocal.c.dg;
import com.tencent.mm.protocal.c.dh;
import com.tencent.mm.protocal.c.di;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class ExtControlProviderVoiceControl extends ExtContentProviderBase implements e {
    private static final String[] lqe = new String[]{"retCode"};
    private Context context;
    private String[] lqq = null;
    private int lqr = -1;
    private int lrp = 4;
    private long lrq;
    private long lrr;
    private long lrs;
    a lrt = new a();
    private long lru = 0;
    private boolean lrv;
    private c lrw = new c(this) {
        final /* synthetic */ ExtControlProviderVoiceControl lrB;

        {
            this.lrB = r1;
        }

        public final void a(com.qq.wx.voice.embed.recognizer.a aVar) {
            if (aVar == null) {
                w.w("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetResult restult is null");
                return;
            }
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl use time2:%s,text: %s,name: %s", Long.valueOf(System.currentTimeMillis() - this.lrB.lru), aVar.text, aVar.name);
            if (!bg.mA(aVar.name)) {
                this.lrB.lrv = true;
                this.lrB.vD(aVar.name);
            }
        }

        public final void cO(int i) {
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl onGetError:%s", Integer.valueOf(i));
        }
    };

    static /* synthetic */ void a(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        extControlProviderVoiceControl.lrv = false;
        extControlProviderVoiceControl.lru = System.currentTimeMillis();
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "localVoiceControl  hasInit:%s", Boolean.valueOf(ab.bIY().getBoolean("hasInitVoiceControlData", true)));
        if (ab.bIY().getBoolean("hasInitVoiceControlData", true)) {
            byte[] d = com.tencent.mm.a.e.d(str, 0, -1);
            b bVar = a.aIN;
            int a = bVar.aIM.a(extControlProviderVoiceControl.lrw, d);
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "recognize ret:%s", Integer.valueOf(a));
        }
    }

    static /* synthetic */ void c(ExtControlProviderVoiceControl extControlProviderVoiceControl, String str) {
        Intent intent;
        if (com.tencent.mm.modelbiz.e.ib(str)) {
            intent = new Intent();
            intent.putExtra("enterprise_biz_name", str);
            intent.putExtra("enterprise_biz_display_name", n.eK(str));
            d.a(extControlProviderVoiceControl.context, ".ui.conversation.EnterpriseConversationUI", intent);
        } else if (com.tencent.mm.modelbiz.e.dr(str)) {
            intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 7);
            d.a(extControlProviderVoiceControl.context, ".ui.bizchat.BizChatConversationUI", intent);
        } else if (com.tencent.mm.modelbiz.e.ic(str)) {
            BizInfo hW = com.tencent.mm.modelbiz.e.hW(str);
            String CL = hW == null ? null : hW.CL();
            if (CL == null) {
                CL = "";
            }
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", CL);
            intent2.putExtra("useJs", true);
            intent2.putExtra("srcUsername", str);
            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            intent2.addFlags(67108864);
            d.b(extControlProviderVoiceControl.context, "webview", ".ui.tools.WebViewUI", intent2);
        } else {
            intent = new Intent();
            intent.putExtra("Chat_User", str);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            intent.addFlags(WXMediaMessage.THUMB_LENGTH_LIMIT);
            com.tencent.mm.plugin.ext.a.imv.e(intent, extControlProviderVoiceControl.context);
        }
    }

    public ExtControlProviderVoiceControl(String[] strArr, int i, Context context) {
        this.lqq = strArr;
        this.lqr = i;
        this.context = context;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] query(), ApiId=%s", Integer.valueOf(this.lqr));
        this.lrq = 0;
        this.lrr = 0;
        a(uri, this.context, this.lqr, this.lqq);
        if (uri == null) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "uri == null");
            bS(3, 5);
            return ExtContentProviderBase.me(5);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (bg.mA(this.lqz)) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "AppID == null");
            bS(3, 7);
            return ExtContentProviderBase.me(7);
        } else if (bg.mA(aqX())) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "PkgName == null");
            bS(3, 6);
            return ExtContentProviderBase.me(6);
        } else {
            currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
            long currentTimeMillis2 = System.currentTimeMillis() - System.currentTimeMillis();
            int aqY = aqY();
            if (aqY != 1) {
                w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "invalid appid ! return code = " + aqY);
                bS(2, aqY);
                return ExtContentProviderBase.me(aqY);
            }
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] getAppIdAndPkg = %s, checkIsLogin = %s", Long.valueOf(currentTimeMillis), Long.valueOf(currentTimeMillis2));
            switch (this.lqr) {
                case JsApiChooseImage.CTRL_INDEX /*29*/:
                    w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "voiceControl");
                    if (strArr2 == null || strArr2.length < 4) {
                        w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        bS(3, 3501);
                        this.lrp = 3501;
                        return ExtContentProviderBase.me(3501);
                    }
                    final String str3 = strArr2[0];
                    final String str4 = strArr2[1];
                    final String str5 = strArr2[2];
                    final String str6 = strArr2[3];
                    final String str7 = strArr2[4];
                    w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] args: %s, %s, %s, %s %s", str3, str4, str5, str6, str7);
                    if (bg.mA(str3) || bg.mA(str4) || bg.mA(str5) || bg.mA(str6) || bg.mA(str7)) {
                        bS(3, 3502);
                        w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] wrong args");
                        return ExtContentProviderBase.me(3502);
                    } else if (com.tencent.mm.a.e.aO(str7)) {
                        this.lrq = System.currentTimeMillis();
                        ap.vd().a(985, (e) this);
                        this.lrt.b(13000, new Runnable(this) {
                            final /* synthetic */ ExtControlProviderVoiceControl lrB;

                            public final void run() {
                                int i = bg.getInt(str3, 4);
                                if (i == 1) {
                                    ExtControlProviderVoiceControl.a(this.lrB, str7);
                                } else {
                                    w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] not pcm, don't run localVoiceControl");
                                }
                                if (!ExtControlProviderVoiceControl.a(this.lrB.lqz, i, bg.getInt(str4, 4), bg.getInt(str5, 16000), bg.getInt(str6, 16), str7)) {
                                    w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] !ok countDown");
                                    this.lrB.lrp = 3504;
                                    this.lrB.lrt.countDown();
                                }
                            }
                        });
                        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[extApiCost][voiceControl] finish uploadVoice = %s, getResult = %s", Long.valueOf(this.lrr - this.lrq), Long.valueOf(System.currentTimeMillis() - this.lrr));
                        ap.vd().b(985, (e) this);
                        z(10, 0, 1);
                        if (1 != this.lrp) {
                            z(11, 4, 1);
                        } else {
                            z(10, 0, 1);
                        }
                        md(0);
                        return ExtContentProviderBase.me(this.lrp);
                    } else {
                        w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] speex file not exist");
                        bS(3, 3503);
                        return ExtContentProviderBase.me(3503);
                    }
                default:
                    bS(3, 15);
                    return ExtContentProviderBase.me(15);
            }
        }
    }

    public static boolean a(String str, int i, int i2, int i3, int i4, String str2) {
        String str3;
        byte[] d;
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "uploadVoiceStart ");
        if (i != 4) {
            str3 = str2 + ".speex";
            com.tencent.mm.c.c.d dVar = new com.tencent.mm.c.c.d();
            if (!com.tencent.mm.c.c.d.t(str2, str3)) {
                w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] decodePCMToSpeex error,pcmPath:%s,speexFilePath:%s", str2, str3);
                return false;
            }
        }
        str3 = str2;
        int aN = com.tencent.mm.a.e.aN(str3);
        di diVar = new di();
        diVar.tgM = 4;
        diVar.tgN = 4;
        diVar.tgO = i3;
        diVar.tgP = i4;
        dh dhVar = new dh();
        dhVar.tgJ = aN;
        dhVar.tgK = 0;
        if (aN <= 16384) {
            dhVar.tgL = aN;
            d = com.tencent.mm.a.e.d(str3, 0, aN);
        } else {
            dhVar.tgL = 16384;
            d = com.tencent.mm.a.e.d(str3, 0, 16384);
        }
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoice appId=%s, FileType=%s, EncodeType=%s, sampleRate=%s, bps=%s, fileLen=%s, limit=%s", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(aN), Integer.valueOf(16384));
        if (d == null || d.length <= 0) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty");
            return false;
        }
        dg dgVar = new dg();
        dgVar.tgH = diVar;
        dgVar.tgB = dhVar;
        dgVar.tgI = com.tencent.mm.bd.b.aU(d);
        int hashCode = (bg.Nz()).hashCode();
        ap.vd().a(new a(hashCode != Integer.MIN_VALUE ? Math.abs(hashCode) : Integer.MIN_VALUE, str, aN, str3, dgVar), 0);
        return true;
    }

    private static boolean a(a aVar, int i, int i2) {
        if (aVar == null) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue netscene null");
            return false;
        } else if (aVar.lrH == null) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue uploadCmd null");
            return false;
        } else if (aVar.lrH.tgB == null) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue UploadCtx null");
            return false;
        } else {
            dg dgVar = new dg();
            dg dgVar2 = aVar.lrH;
            dgVar2.tgB.tgK = i;
            dgVar2.tgB.tgL = i2;
            byte[] d = com.tencent.mm.a.e.d(aVar.lrG, i, i2);
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue %s, startPos=%s, dataLen=%s", Integer.valueOf(aVar.lrE), Integer.valueOf(i), Integer.valueOf(i2));
            if (d == null || d.length <= 0) {
                w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] buf empty, %s", aVar.lrG);
                return false;
            }
            dgVar2.tgI = com.tencent.mm.bd.b.aU(d);
            k aVar2 = new a(aVar.lrE, aVar.appId, aVar.hrs, aVar.lrG, dgVar2);
            aVar2.hrt = aVar.hrt;
            ap.vd().a(aVar2, 0);
            return true;
        }
    }

    public final boolean a(int i, String str, com.tencent.mm.bd.b bVar) {
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getVoiceControlResult voiceId=%s, appId=%s", Integer.valueOf(i), str);
        if (this.lrr == 0) {
            this.lrr = System.currentTimeMillis();
        }
        this.lrs = System.currentTimeMillis();
        da daVar = new da();
        daVar.tgu = bVar;
        ap.vd().a(new a(i, str, daVar, this.lrr), 0);
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] onSceneEnd errType=%s, errCode=%s, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar == null) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene null, countDown");
            this.lrp = 3506;
            this.lrt.countDown();
        } else if (i == 0 && i2 == 0) {
            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene.getType()=%s", Integer.valueOf(kVar.getType()));
            if (kVar.getType() != 985) {
                return;
            }
            if (this.lrv) {
                w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] localVoiceControlSucess, no need to process");
                return;
            }
            final a aVar = (a) kVar;
            a aVar2 = (a) kVar;
            final dc dcVar = (aVar2.gUA == null || aVar2.gUA.hsk.hsr == null) ? null : (dc) aVar2.gUA.hsk.hsr;
            if (dcVar == null) {
                w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp null, countDown");
                this.lrp = 3508;
                this.lrt.countDown();
                return;
            }
            aVar.lrF = dcVar.tgu;
            String str2 = "MicroMsg.ext.ExtControlProviderVoiceControl";
            String str3 = "[voiceControl] opCode=%s, resp.Cookies=%s";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(aVar.fJA);
            objArr[1] = dcVar.tgu == null ? "null" : new String(dcVar.tgu.sYA);
            w.i(str2, str3, objArr);
            if ((aVar.fJA == 1 ? 1 : null) != null) {
                if (dcVar.tgB == null) {
                    w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp.UploadCtx is null");
                }
                w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadMode resp: Interval=%s, Timeout=%s, StartPos=%s, DataLen=%s", Integer.valueOf(dcVar.tgz), Integer.valueOf(dcVar.tgA), Integer.valueOf(dcVar.tgB.tgK), Integer.valueOf(dcVar.tgB.tgL));
                if (dcVar.tgB.tgK >= aVar.hrs) {
                    af.f(new Runnable(this) {
                        final /* synthetic */ ExtControlProviderVoiceControl lrB;

                        public final void run() {
                            w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode getVoiceControlResult");
                            a aVar = aVar;
                            w.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] setGetResultTimeOut %s", Integer.valueOf(dcVar.tgA));
                            aVar.lrJ = r1;
                            this.lrB.a(aVar.lrE, aVar.appId, aVar.lrF);
                        }
                    }, (long) dcVar.tgz);
                    return;
                }
                w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] continue upload voice");
                if (dcVar.tgB.tgK == 0 || dcVar.tgB.tgK != aVar.hrt) {
                    aVar.hrt = dcVar.tgB.tgK;
                    if (dcVar.tgB.tgK + dcVar.tgB.tgL < aVar.hrs) {
                        if (!a(aVar, dcVar.tgB.tgK, dcVar.tgB.tgL)) {
                            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail1, countDown");
                            this.lrp = 3510;
                            this.lrt.countDown();
                            return;
                        }
                        return;
                    } else if (!a(aVar, dcVar.tgB.tgK, aVar.hrs - dcVar.tgB.tgK)) {
                        w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] uploadVoiceContinue fail2, countDown");
                        this.lrp = 3510;
                        this.lrt.countDown();
                        return;
                    } else {
                        return;
                    }
                }
                w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] avoid duplicate doscene");
                return;
            }
            if ((aVar.fJA == 2 ? 1 : null) != null) {
                Object obj;
                w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "");
                if (System.currentTimeMillis() - aVar.lrK > ((long) aVar.lrJ)) {
                    w.w("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] isGetResultTimeOut %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.lrK), Integer.valueOf(aVar.lrJ));
                    obj = 1;
                } else {
                    w.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] time %s, %s", Long.valueOf(System.currentTimeMillis() - aVar.lrK), Integer.valueOf(aVar.lrJ));
                    obj = null;
                }
                if (obj != null) {
                    this.lrp = 3509;
                    this.lrt.countDown();
                    return;
                }
                if (dcVar.tgC != null) {
                    w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] getResultMode resp VoiceId=%s, RecognizeRet=%s", Integer.valueOf(dcVar.tgC.tgv), Integer.valueOf(dcVar.tgC.tgD));
                }
                if (dcVar.tgC == null || dcVar.tgC.tgD != 0) {
                    if (System.currentTimeMillis() - this.lrs >= ((long) dcVar.tgz)) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ ExtControlProviderVoiceControl lrB;

                            public final void run() {
                                this.lrB.a(aVar.lrE, aVar.appId, aVar.lrF);
                            }
                        });
                        return;
                    }
                    long currentTimeMillis = ((long) dcVar.tgz) - (System.currentTimeMillis() - this.lrs);
                    if (currentTimeMillis > ((long) dcVar.tgz)) {
                        currentTimeMillis = (long) dcVar.tgz;
                    }
                    af.f(new Runnable(this) {
                        final /* synthetic */ ExtControlProviderVoiceControl lrB;

                        public final void run() {
                            this.lrB.a(aVar.lrE, aVar.appId, aVar.lrF);
                        }
                    }, currentTimeMillis);
                } else if (dcVar.tgC.tgE == null) {
                    w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo null, countDown");
                    this.lrp = 3511;
                    this.lrt.countDown();
                } else if (dcVar.tgC.tgE.tgF == null || dcVar.tgC.tgE.tgF.size() <= 0) {
                    w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] SearchContactResultInfo.Items null, countDown");
                    this.lrp = 3511;
                    this.lrt.countDown();
                } else if (dcVar.tgC.tgE.tgF.size() == 0) {
                    this.lrp = 3511;
                    this.lrt.countDown();
                } else if (dcVar.tgC.tgE.tgF.size() == 1) {
                    vD(((df) dcVar.tgC.tgE.tgF.get(0)).tgG);
                } else {
                    String[] strArr = new String[dcVar.tgC.tgE.tgF.size()];
                    for (int i3 = 0; i3 < strArr.length; i3++) {
                        strArr[i3] = ((df) dcVar.tgC.tgE.tgF.get(i3)).tgG;
                        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] resp result item: %s", strArr[i3]);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", aVar.lrE);
                    intent.putExtra("VoiceSearchResultUI_IsVoiceControl", true);
                    intent.setFlags(67108864);
                    intent.putExtra("VoiceSearchResultUI_ShowType", 1);
                    d.a(this.context, ".ui.voicesearch.VoiceSearchResultUI", intent);
                    w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] scene end countDown");
                    this.lrp = 1;
                    this.lrt.countDown();
                }
            }
        } else {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] errType、errCode not ok, countDown");
            this.lrp = 3507;
            this.lrt.countDown();
        }
    }

    private void vD(final String str) {
        ap.yY();
        com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
            w.e("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] username is not contact, countDown");
            this.lrp = 3505;
            this.lrt.countDown();
            return;
        }
        com.tencent.mm.compatible.a.a.a(11, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ ExtControlProviderVoiceControl lrB;

            public final void run() {
                ExtControlProviderVoiceControl.c(this.lrB, str);
            }
        });
        this.lrp = 1;
        w.i("MicroMsg.ext.ExtControlProviderVoiceControl", "[voiceControl] jump to chattingUI : %s, countDown", str);
        this.lrt.countDown();
    }
}
