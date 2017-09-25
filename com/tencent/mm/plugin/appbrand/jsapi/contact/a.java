package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.b;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.m.o;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.c.abl;
import com.tencent.mm.protocal.c.abm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    public static int iPF = 0;
    public m iNv;
    private String iRV;
    public String iRW;
    public String iRX;
    public String iRY;
    public boolean iRZ;
    public int iSa = 1;
    private String sessionFrom;

    public final void a(final m mVar, JSONObject jSONObject, final int i) {
        if (jSONObject == null) {
            mVar.x(i, d("fail", null));
            w.e("MicroMsg.JsApiEnterContact", "data is null");
            return;
        }
        w.i("MicroMsg.JsApiEnterContact", "enterContact appId:%s, data:%s", new Object[]{mVar.ivH, jSONObject.toString()});
        this.iNv = mVar;
        this.sessionFrom = jSONObject.optString("sessionFrom");
        this.iRV = jSONObject.optString("businessId");
        this.iRW = jSONObject.optString("sendMessageTitle");
        this.iRX = jSONObject.optString("sendMessagePath");
        this.iRY = jSONObject.optString("sendMessageImg");
        this.iRZ = jSONObject.optBoolean("showMessageCard", false);
        this.iSa = 1;
        if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            w.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        if (this.iRZ) {
            if (s.eq(this.iRY, "http://") || s.eq(this.iRY, "https://")) {
                this.iSa = 4;
            } else if (!bg.mA(this.iRY) && this.iRY.startsWith("wxfile://")) {
                AppBrandLocalMediaObject aH = c.aH(mVar.ivH, this.iRY);
                if (!(aH == null || TextUtils.isEmpty(aH.hos))) {
                    this.iRY = aH.hos;
                    this.iSa = 2;
                }
            } else if (!bg.mA(this.iRY)) {
                Bitmap g = l.g(mVar.ixr, this.iRY);
                if (g != null) {
                    this.iRY = c.aC(mVar.ivH, "share_" + System.currentTimeMillis());
                    try {
                        d.a(g, 100, CompressFormat.PNG, this.iRY, true);
                        this.iSa = 3;
                        if (!(g == null || g.isRecycled())) {
                            g.recycle();
                        }
                    } catch (IOException e) {
                        w.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", new Object[]{e});
                        if (!(g == null || g.isRecycled())) {
                            g.recycle();
                        }
                    } catch (Exception e2) {
                        w.w("MicroMsg.JsApiEnterContact", "save temp bitmap to file failed, . exception : %s", new Object[]{e2});
                        if (!(g == null || g.isRecycled())) {
                            g.recycle();
                        }
                    } catch (Throwable th) {
                        if (!(g == null || g.isRecycled())) {
                            g.recycle();
                        }
                    }
                }
            }
            if (this.iRZ && this.iSa == 1) {
                this.iRY = c.aC(mVar.ivH, "share_" + System.currentTimeMillis());
                e.a(mVar.ivH, new b(this) {
                    final /* synthetic */ a iSb;

                    public final void a(com.tencent.mm.plugin.appbrand.e.c r7) {
                        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1431)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1453)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
                        /*
                        r6 = this;
                        r0 = r9;
                        r0 = r0.ivH;
                        com.tencent.mm.plugin.appbrand.e.b(r0, r6);
                        r0 = r9;
                        r1 = com.tencent.mm.plugin.appbrand.jsapi.share.i.b(r0);
                        if (r1 == 0) goto L_0x001b;
                    L_0x000f:
                        r0 = 100;
                        r2 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r3 = r6.iSb;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r3 = r3.iRY;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4 = 1;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        com.tencent.mm.sdk.platformtools.d.a(r1, r0, r2, r3, r4);	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                    L_0x001b:
                        if (r1 == 0) goto L_0x0026;
                    L_0x001d:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0026;
                    L_0x0023:
                        r1.recycle();
                    L_0x0026:
                        return;
                    L_0x0027:
                        r0 = move-exception;
                        r2 = "MicroMsg.JsApiEnterContact";	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4 = 1;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r5 = 0;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4[r5] = r0;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        if (r1 == 0) goto L_0x0026;
                    L_0x0039:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0026;
                    L_0x003f:
                        r1.recycle();
                        goto L_0x0026;
                    L_0x0043:
                        r0 = move-exception;
                        r2 = "MicroMsg.JsApiEnterContact";	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r3 = "save temp bitmap to file failed, . exception : %s";	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4 = 1;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r5 = 0;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        r4[r5] = r0;	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r4);	 Catch:{ IOException -> 0x0027, Exception -> 0x0043, all -> 0x005f }
                        if (r1 == 0) goto L_0x0026;
                    L_0x0055:
                        r0 = r1.isRecycled();
                        if (r0 != 0) goto L_0x0026;
                    L_0x005b:
                        r1.recycle();
                        goto L_0x0026;
                    L_0x005f:
                        r0 = move-exception;
                        if (r1 == 0) goto L_0x006b;
                    L_0x0062:
                        r2 = r1.isRecycled();
                        if (r2 != 0) goto L_0x006b;
                    L_0x0068:
                        r1.recycle();
                    L_0x006b:
                        throw r0;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.contact.a.1.a(com.tencent.mm.plugin.appbrand.e$c):void");
                    }
                });
            }
        }
        if (TextUtils.isEmpty(this.iRV)) {
            w.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            ae("", i);
            return;
        }
        w.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new abl();
        aVar.hsn = new abm();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar.hsl = 1303;
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.y.b BE = aVar.BE();
        abl com_tencent_mm_protocal_c_abl = (abl) BE.hsj.hsr;
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(mVar.ivH);
        if (mY != null) {
            com_tencent_mm_protocal_c_abl.username = mY.fCJ;
            w.i("MicroMsg.JsApiEnterContact", "req.username:%s", new Object[]{com_tencent_mm_protocal_c_abl.username});
        } else {
            w.e("MicroMsg.JsApiEnterContact", "getSysConfig is null, username is empty");
        }
        com_tencent_mm_protocal_c_abl.tHd = this.iRV;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(BE, new com.tencent.mm.ipcinvoker.wx_extension.b.a(this) {
            final /* synthetic */ a iSb;

            public final void a(int i, int i2, String str, com.tencent.mm.y.b bVar) {
                if (i == 0 && i2 == 0 && bVar.hsk.hsr != null) {
                    final abm com_tencent_mm_protocal_c_abm = (abm) bVar.hsk.hsr;
                    w.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", new Object[]{com_tencent_mm_protocal_c_abm.tHe});
                    mVar.jbY.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass2 iSd;

                        public final void run() {
                            this.iSd.iSb.ae(com_tencent_mm_protocal_c_abm.tHe, i);
                        }
                    });
                    return;
                }
                w.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, bVar.hsk.hsr});
                mVar.x(i, this.iSb.d("fail:cgi fail", null));
            }
        });
    }

    public final void ae(String str, final int i) {
        String str2 = "";
        String str3 = "";
        String str4 = "";
        final com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
        if (this.iNv.jde != null) {
            str4 = this.iNv.jde.jdU;
        }
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(this.iNv.ivH);
        if (mY != null) {
            str2 = mY.fCJ;
            str3 = mY.fGs;
            aVar.appId = this.iNv.ivH;
            aVar.username = mY.fCJ;
            aVar.fFa = mY.fGs;
            aVar.iconUrl = mY.iEP;
            aVar.izV = mY.iFk.izV;
            aVar.izW = mY.iFk.izW;
            aVar.iGd = mY.iFk.izZ;
            aVar.fFr = 5;
            aVar.iGe = str4;
            aVar.iGf = n.nx(this.iNv.ivH);
        }
        str4 = str3;
        str3 = str2;
        if (bg.mA(str3)) {
            w.e("MicroMsg.JsApiEnterContact", "onInsertView username is empty!!!");
        }
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        if (TextUtils.isEmpty(str)) {
            jsApiChattingTask.username = str3;
            jsApiChattingTask.fFa = str4;
        } else {
            jsApiChattingTask.username = str;
            jsApiChattingTask.fFa = "";
        }
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.iMD = new Runnable(this) {
            final /* synthetic */ a iSb;

            public final void run() {
                w.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", aVar.RL());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (this.iSb.iRZ) {
                    intent.putExtra("sendMessageTitle", this.iSb.iRW);
                    intent.putExtra("sendMessagePath", this.iSb.iRX);
                    intent.putExtra("sendMessageImg", this.iSb.iRY);
                    intent.putExtra("isBitmapFrom", this.iSb.iSa);
                }
                intent.putExtra("showMessageCard", this.iSb.iRZ);
                MMActivity mMActivity = (MMActivity) this.iSb.iNv.mContext;
                if (mMActivity == null) {
                    this.iSb.iNv.x(i, this.iSb.d("fail", null));
                    w.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    return;
                }
                mMActivity.uSV = new com.tencent.mm.ui.MMActivity.a(this) {
                    final /* synthetic */ AnonymousClass3 iSg;

                    {
                        this.iSg = r1;
                    }

                    public final void a(int i, int i2, Intent intent) {
                        if (i == 1) {
                            if (a.iPF > 0) {
                                a.iPF--;
                                this.iSg.iSb.iNv.ixr.PA();
                            }
                            w.i("MicroMsg.JsApiEnterContact", "mmOnActivityResult lockCount:%d", new Object[]{Integer.valueOf(a.iPF)});
                            jsApiChattingTask.SN();
                            Map hashMap = new HashMap();
                            Object obj = "";
                            Object hashMap2 = new HashMap();
                            if (i2 == -1 && intent != null) {
                                String ap = bg.ap(intent.getStringExtra("keyOutPagePath"), "");
                                obj = o.qW(ap);
                                hashMap2 = o.qX(ap);
                            }
                            hashMap.put("path", obj);
                            hashMap.put("query", hashMap2);
                            w.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", new Object[]{obj, hashMap2.toString()});
                            this.iSg.iSb.iNv.x(i, this.iSg.iSb.d("ok", hashMap));
                        }
                    }
                };
                com.tencent.mm.bb.d.a(this.iSb.iNv.mContext, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                if (a.iPF > 0) {
                    a.iPF--;
                    this.iSb.iNv.ixr.PA();
                }
                if (a.iPF == 0) {
                    a.iPF++;
                    this.iSb.iNv.ixr.Pz();
                }
                e.a(this.iSb.iNv.ivH, new b(this) {
                    final /* synthetic */ AnonymousClass3 iSg;

                    {
                        this.iSg = r1;
                    }

                    public final void onDestroy() {
                        w.i("MicroMsg.JsApiEnterContact", "onDestroy");
                        if (a.iPF > 0) {
                            a.iPF--;
                            this.iSg.iSb.iNv.ixr.PA();
                        }
                        jsApiChattingTask.SN();
                        e.b(this.iSg.iSb.iNv.ivH, this);
                    }
                });
                w.i("MicroMsg.JsApiEnterContact", "doEnterChatting lockCount:%d", new Object[]{Integer.valueOf(a.iPF)});
            }
        };
        jsApiChattingTask.SM();
        AppBrandMainProcessService.a(jsApiChattingTask);
    }
}
