package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.c.g;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.p;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.t.k;
import com.tencent.mm.t.l;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

final class bf extends com.tencent.mm.ui.chatting.ah.b {
    public static final int vCT = (com.tencent.mm.bg.a.dO(ab.getContext()) - ((int) (com.tencent.mm.bg.a.getDensity(ab.getContext()) * 60.0f)));
    public static final int vCU = (((int) com.tencent.mm.bg.a.getDensity(ab.getContext())) * 167);
    public static final int vCV = (((int) com.tencent.mm.bg.a.getDensity(ab.getContext())) * 50);
    private int oKp = 0;
    private int oKq = 0;
    private boolean vCW = false;
    private int vCX = 0;
    private long vCY = 0;
    private boolean vCZ = false;
    public com.tencent.mm.ui.chatting.En_5b8fbb1e.a vCd;

    public static class a implements g {
        public final void jK(String str) {
            w.d("MicroMsg.ChattingItemBizFrom", "onImageLoadStart, url: %s", str);
            com.tencent.mm.plugin.report.service.g.oUh.a(86, 0, 1, false);
        }

        public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
            if (bVar.fFr == 2) {
                boolean z;
                w.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, url:%s, contentType: %s", str, bVar.gam);
                if (p.Ha() && !bg.mA(bVar.gam) && p.jF(str) && bVar.gam.equals("image/webp")) {
                    z = true;
                } else {
                    z = false;
                }
                w.d("MicroMsg.ChattingItemBizFrom", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z), Integer.valueOf(bVar.status));
                switch (bVar.status) {
                    case 0:
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(86, 13, 1, false);
                            return;
                        }
                        return;
                    case 1:
                        com.tencent.mm.plugin.report.service.g.oUh.a(86, 2, 1, false);
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(86, 15, 1, false);
                            return;
                        }
                        return;
                    case 3:
                        if (z) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(86, 14, 1, false);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public static class b implements com.tencent.mm.ah.a.c.b {
        public final com.tencent.mm.ah.a.d.b jI(String str) {
            w.d("MicroMsg.ChattingBizImgDownloader", "get image data from url:%s", str);
            try {
                com.tencent.mm.ah.a.d.b bVar;
                long currentTimeMillis = System.currentTimeMillis();
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(15000);
                httpURLConnection.setReadTimeout(20000);
                if (p.jF(str)) {
                    httpURLConnection.setRequestProperty("Referer", p.gc(d.sYN));
                }
                if (httpURLConnection.getResponseCode() >= e.CTRL_INDEX) {
                    httpURLConnection.disconnect();
                    w.w("MicroMsg.ChattingBizImgDownloader.HttpClientFactory", "httpURLConnectionGet 300");
                    bVar = null;
                } else {
                    InputStream inputStream = httpURLConnection.getInputStream();
                    bVar = new com.tencent.mm.ah.a.d.b(com.tencent.mm.ah.a.b.e.g(inputStream), httpURLConnection.getContentType(), (byte) 0);
                }
                if (bVar == null) {
                    return bVar;
                }
                boolean z;
                long currentTimeMillis2 = System.currentTimeMillis();
                if (p.Ha() && !bg.mA(bVar.gam) && p.jF(str) && bVar.gam.equals("image/webp")) {
                    z = true;
                } else {
                    z = false;
                }
                w.d("MicroMsg.ChattingBizImgDownloader", "getImageData, isDownloadWebp: %b", Boolean.valueOf(z));
                long j = currentTimeMillis2 - currentTimeMillis;
                w.d("MicroMsg.ChattingBizImgDownloader", "download used %d ms", Long.valueOf(j));
                com.tencent.mm.plugin.report.service.g.oUh.a(86, 4, j, false);
                if (!z) {
                    return bVar;
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(86, 17, j, false);
                return bVar;
            } catch (Exception e) {
                w.e("MicroMsg.ChattingBizImgDownloader", "get image data failed.:%s", e.toString());
                return new com.tencent.mm.ah.a.d.b(null, null, (byte) 0);
            }
        }
    }

    public bf() {
        super(26);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view == null || view.getTag() == null || ((com.tencent.mm.ui.chatting.ah.a) view.getTag()).type != this.knu) {
            view = new bj(layoutInflater, R.i.cXz);
            r rVar = new r(this.knu);
            rVar.kxi = (TextView) view.findViewById(R.h.bBA);
            rVar.vBY = view.findViewById(R.h.bAH);
            rVar.vzQ = (LinearLayout) view.findViewById(R.h.bAk);
            rVar.vzR.oKs = view.findViewById(R.h.cJo);
            rVar.vzR.iUO = (TextView) rVar.vzR.oKs.findViewById(R.h.title);
            rVar.vzR.mzk = (TextView) rVar.vzR.oKs.findViewById(R.h.cIm);
            rVar.vzR.oKu = (ImageView) rVar.vzR.oKs.findViewById(R.h.bGY);
            rVar.vzR.vzS = rVar.vzR.oKs.findViewById(R.h.bHb);
            rVar.vzR.vzT = (TextView) rVar.vzR.oKs.findViewById(R.h.cJf);
            rVar.vzR.oKO = (TextView) rVar.vzR.oKs.findViewById(R.h.bJv);
            rVar.vzR.vzU = (TextView) rVar.vzQ.findViewById(R.h.bIt);
            rVar.vzR.lKt = (ProgressBar) view.findViewById(R.h.bZu);
            rVar.vzR.oKw = view.findViewById(R.h.bKf);
            rVar.mfD = (CheckBox) view.findViewById(R.h.bAd);
            rVar.nRW = view.findViewById(R.h.bAX);
            rVar.vyE = (TextView) view.findViewById(R.h.bzy);
            rVar.vyU = (ChattingItemFooter) view.findViewById(R.h.aTR);
            view.setTag(rVar);
        }
        eV(layoutInflater.getContext());
        return view;
    }

    private void eV(Context context) {
        this.oKp = context.getResources().getDimensionPixelSize(R.f.aXR);
        this.oKq = context.getResources().getDimensionPixelSize(R.f.aWZ);
    }

    protected final boolean bUp() {
        return false;
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar, String str) {
        this.vCd = aVar2;
        eV(aVar2.uSU.uTo);
        r rVar = (r) aVar;
        for (q qVar : rVar.oKE) {
            if (rVar.oKE.indexOf(qVar) != rVar.oKE.size() - 1) {
                eo.J(qVar.oKs, 1);
            } else {
                eo.J(qVar.oKs, 2);
            }
            rVar.vzQ.removeView(qVar.oKs);
        }
        rVar.oKE.clear();
        k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
        String str2 = rV.gxD;
        if (str2 == null || str2.length() == 0) {
            rVar.vyE.setVisibility(8);
        } else {
            rVar.vyE.setVisibility(0);
            ah.b(aVar2, rVar.vyE, (Object) dt.TF(str2));
        }
        List list = rV.hkm;
        int size = list.size();
        if (size == 0) {
            rVar.vzQ.setVisibility(8);
            rVar.vzR.oKs.setVisibility(8);
            return;
        }
        int size2;
        rVar.vzQ.setVisibility(0);
        rVar.vzR.oKs.setVisibility(0);
        boolean b = rVar.vyU.b(rV.hhm, auVar.field_talker, true);
        LayoutInflater layoutInflater = aVar2.bPj().getLayoutInflater();
        for (size2 = rVar.oKE.size() + 2; size2 < size; size2++) {
            View Be = eo.Be(1);
            if (Be == null) {
                Be = layoutInflater.inflate(R.i.cXA, null);
            }
            rVar.dm(Be);
        }
        if (size > 1) {
            if (b) {
                Be = eo.Be(1);
                if (Be == null) {
                    Be = layoutInflater.inflate(R.i.cXA, null);
                }
                rVar.dm(Be);
            } else {
                Be = eo.Be(2);
                if (Be == null) {
                    Be = layoutInflater.inflate(R.i.cXB, null);
                }
                rVar.dm(Be);
            }
            rVar.vzR.oKs.setBackgroundResource(R.g.biR);
            rVar.vzR.oKs.setPadding(this.oKq, this.oKq, this.oKq, this.oKp);
            this.vCW = true;
        } else {
            if (b) {
                rVar.vzR.oKs.setBackgroundResource(R.g.biR);
                rVar.vzR.oKs.setPadding(this.oKq, this.oKq, this.oKq, this.oKp);
            } else {
                rVar.vzR.oKs.setBackgroundResource(R.g.biT);
                rVar.vzR.oKs.setPadding(this.oKq, this.oKq, this.oKq, 0);
            }
            this.vCW = false;
        }
        for (size2 = 0; size2 < rVar.oKE.size(); size2++) {
            ((q) rVar.oKE.get(size2)).oKs.setVisibility(8);
        }
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            Object TC;
            dt dtVar;
            if (i2 == 0) {
                TextView textView;
                TextView textView2 = rVar.vzR.vzU;
                int i3 = size > 1 ? 8 : u.mA(lVar.url) ? 4 : 0;
                textView2.setVisibility(i3);
                rVar.vzR.iUO.setVisibility(size > 1 ? 8 : 0);
                rVar.vzR.mzk.setVisibility(size > 1 ? 8 : 0);
                rVar.vzR.vzT.setVisibility(size > 1 ? 0 : 8);
                rVar.vzR.lKt.setVisibility(8);
                rVar.vzR.oKw.setVisibility(8);
                if (u.mA(lVar.hks)) {
                    rVar.vzR.vzS.setVisibility(8);
                    rVar.vzR.oKu.setVisibility(8);
                    rVar.vzR.vzT.setVisibility(8);
                    rVar.vzR.iUO.setVisibility(0);
                    rVar.vzR.oKO.setVisibility(u.mA(lVar.hku) ? 8 : 0);
                    textView = rVar.vzR.oKO;
                    size2 = 0;
                    i3 = size > 1 ? this.oKp : 0;
                } else {
                    rVar.vzR.vzS.setVisibility(0);
                    rVar.vzR.oKu.setVisibility(0);
                    str2 = lVar.hks;
                    ImageView imageView = rVar.vzR.oKu;
                    int i4 = auVar.field_type;
                    if (p.Ha()) {
                        str2 = p.jE(str2);
                    }
                    com.tencent.mm.ah.a.a GW = n.GW();
                    com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
                    aVar3.hJe = R.e.aUx;
                    aVar3.hIL = true;
                    aVar3 = aVar3.aO(vCT, vCU);
                    aVar3.hIB = new b();
                    aVar3.hIN = s.n(str2, i4, "@T");
                    GW.b(str2, imageView, aVar3.Hg(), new a());
                    textView2 = rVar.vzR.oKO;
                    i3 = (size > 1 || u.mA(lVar.hku)) ? 8 : 0;
                    textView2.setVisibility(i3);
                    textView = rVar.vzR.oKO;
                    size2 = 0;
                    i3 = this.oKq;
                }
                textView.setPadding(size2, i3, 0, 0);
                rVar.vzR.oKO.setText(lVar.hku);
                rVar.vzR.iUO.setText(lVar.title);
                rVar.vzR.mzk.setText(o.Z(aVar2.getString(R.l.elp), lVar.time));
                rVar.vzR.vzT.setText(lVar.title);
                rVar.vzR.vzT.setContentDescription(lVar.title);
                if (!(lVar.hkv == 0 || lVar.hkv == 1)) {
                    rVar.vzR.vzT.setVisibility(4);
                }
                TC = aVar2.TC(lVar.url);
                if (TextUtils.isEmpty(TC)) {
                    dtVar = new dt(auVar, false, i, lVar.url, 6, this.vCW, aVar2.bVS(), rV.fUR, rV.fUS, lVar.title);
                    a(dtVar, lVar, auVar);
                } else {
                    w.d("MicroMsg.ChattingItemBizFrom", "productId:%s", TC);
                    dtVar = new dt(auVar, false, i, lVar.url, 8, this.vCW, aVar2.bVS(), rV.fUR, rV.fUS, lVar.title, TC, null, false, true);
                }
                dtVar.rXI = auVar.field_msgSvrId;
                dtVar.rXJ = 0;
                rVar.vzR.oKs.setTag(dtVar);
                if (com.tencent.mm.t.h.em(lVar.hkx)) {
                    a(lVar, rVar.vzR.oKs);
                } else {
                    rVar.vzR.oKs.setOnClickListener(aVar2.vBD.vEW);
                }
                rVar.vzR.oKs.setOnLongClickListener(aVar2.vBD.vEY);
                rVar.vzR.oKs.setOnTouchListener(aVar2.vBD.vFa);
            } else {
                q qVar2 = (q) rVar.oKE.get(i2 - 1);
                qVar2.iUO.setText(lVar.title);
                qVar2.lKt.setVisibility(8);
                qVar2.oKw.setVisibility(8);
                qVar2.iUO.setTextColor(aVar2.getResources().getColor(R.e.black));
                if (u.mA(lVar.hks)) {
                    qVar2.oKt.setVisibility(8);
                } else {
                    qVar2.oKu.setVisibility(0);
                    str2 = lVar.hks;
                    if (p.Ha()) {
                        str2 = p.jE(lVar.hks);
                    }
                    com.tencent.mm.ah.a.a GW2 = n.GW();
                    ImageView imageView2 = qVar2.oKu;
                    com.tencent.mm.ah.a.a.c.a aVar4 = new com.tencent.mm.ah.a.a.c.a();
                    aVar4.hIN = s.n(str2, auVar.field_type, "@S");
                    aVar4.hIL = true;
                    aVar4.hIB = new b();
                    aVar4.hJe = R.e.aUx;
                    GW2.a(str2, imageView2, aVar4.aO(vCV, vCV).Hg(), new a());
                    if (lVar.hkv == 0 || lVar.hkv == 1) {
                        qVar2.oKt.setVisibility(0);
                    } else {
                        qVar2.oKt.setVisibility(8);
                        qVar2.iUO.setTextColor(aVar2.getResources().getColor(R.e.aUo));
                    }
                }
                if (!u.mA(lVar.hku) && lVar.type == 3) {
                    qVar2.vzP.setText(lVar.hku);
                    qVar2.vzP.setVisibility(0);
                }
                qVar2.oKs.setVisibility(0);
                TC = aVar2.TC(lVar.url);
                if (TextUtils.isEmpty(TC)) {
                    dtVar = new dt(auVar, false, i, lVar.url, 6, this.vCW, aVar2.bVS(), rV.fUR, rV.fUS);
                    a(dtVar, lVar, auVar);
                } else {
                    w.d("MicroMsg.ChattingItemBizFrom", "productId:%s", TC);
                    dtVar = new dt(auVar, false, i, lVar.url, 8, this.vCW, aVar2.bVS(), rV.fUR, rV.fUS, lVar.title, TC, null, false, true);
                }
                dtVar.rXI = auVar.field_msgSvrId;
                dtVar.rXJ = i2;
                qVar2.oKs.setTag(dtVar);
                if (com.tencent.mm.t.h.em(lVar.hkx)) {
                    a(lVar, qVar2.oKs);
                } else {
                    qVar2.oKs.setOnClickListener(aVar2.vBD.vEW);
                }
                qVar2.oKs.setOnLongClickListener(aVar2.vBD.vEY);
                qVar2.oKs.setOnTouchListener(aVar2.vBD.vFa);
            }
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, au auVar) {
        dt dtVar = (dt) view.getTag();
        if (dtVar == null) {
            return false;
        }
        this.vCX = dtVar.rXJ;
        int i = dtVar.position;
        k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
        if (rV == null) {
            w.w("MicroMsg.ChattingItemBizFrom", "onCreateContextMenu reader is null");
            return false;
        }
        this.vCZ = false;
        if (this.vCX >= 0 && this.vCX < rV.hkm.size() && com.tencent.mm.t.h.em(((l) rV.hkm.get(this.vCX)).hkx)) {
            this.vCZ = true;
        }
        if (!(this.vCd.bVJ() || aa.aj(auVar))) {
            contextMenu.add(i, 111, 0, view.getContext().getString(R.l.eLH));
        }
        if (com.tencent.mm.bb.d.Jt("favorite") && !this.vCZ) {
            contextMenu.add(i, 125, 0, view.getContext().getString(R.l.eGa));
        }
        return true;
    }

    private void a(dt dtVar, l lVar, au auVar) {
        int i;
        Bundle bundle = new Bundle();
        switch (com.tencent.mm.u.p.G(a(this.vCd, auVar), this.vCd.bUg())) {
            case 1:
                i = 3;
                break;
            case 2:
                i = 2;
                break;
            case 6:
            case 7:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        bundle.putString("share_report_pre_msg_url", lVar.url);
        bundle.putString("share_report_pre_msg_title", lVar.title);
        bundle.putString("share_report_pre_msg_desc", lVar.hku);
        bundle.putString("share_report_pre_msg_icon_url", lVar.hks);
        bundle.putString("share_report_pre_msg_appid", "");
        bundle.putInt("share_report_from_scene", i);
        if (i == 5) {
            bundle.putString("share_report_biz_username", this.vCd.bUg());
        }
        dtVar.vNe = bundle;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        this.vCY = u.Ny();
        String a;
        com.tencent.mm.u.q.b n;
        String a2;
        switch (menuItem.getItemId()) {
            case 111:
                String fQ;
                if (this.vCZ) {
                    if (!this.vCZ) {
                        w.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg not AppBrandMsg!");
                        break;
                    }
                    k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
                    if (rV != null) {
                        if (this.vCX >= 0 && this.vCX < rV.hkm.size()) {
                            l lVar = (l) rV.hkm.get(this.vCX);
                            a = com.tencent.mm.t.f.a.a(ac.a(auVar.field_talker, lVar), null, null);
                            if (!u.mA(a)) {
                                Serializable hashMap = new HashMap();
                                hashMap.put("desc", lVar.hku);
                                hashMap.put(Columns.TYPE, Integer.valueOf(2));
                                hashMap.put("title", lVar.title);
                                hashMap.put("app_id", lVar.hkB);
                                hashMap.put("pkg_type", Integer.valueOf(lVar.hkA));
                                hashMap.put("pkg_version", Integer.valueOf(lVar.hkz));
                                hashMap.put("img_url", lVar.hkC);
                                hashMap.put("is_dynamic", Boolean.valueOf(false));
                                hashMap.put("cache_key", "");
                                hashMap.put("path", lVar.hky);
                                Intent intent = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                                intent.putExtra("appbrand_params", hashMap);
                                intent.putExtra("Retr_Msg_content", a);
                                intent.putExtra("Retr_Msg_Type", 2);
                                intent.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vCX);
                                intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
                                intent.putExtra("Retr_MsgFromScene", 3);
                                a = auVar.field_talker;
                                fQ = q.fQ(auVar.field_msgSvrId);
                                intent.putExtra("reportSessionId", fQ);
                                n = q.yC().n(fQ, true);
                                n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                                n.l("preUsername", a);
                                n.l("preChatName", a);
                                n.l("preMsgIndex", Integer.valueOf(this.vCX));
                                n.l("sendAppMsgScene", Integer.valueOf(1));
                                aVar.startActivity(intent);
                                break;
                            }
                        }
                    }
                    w.w("MicroMsg.ChattingItemBizFrom", "transmitAppBrandMsg reader is null");
                    break;
                }
                a2 = a(auVar, aVar.uSU.uTo, this.vCX);
                if (!u.mA(a2)) {
                    Intent intent2 = new Intent(aVar.uSU.uTo, MsgRetransmitUI.class);
                    intent2.putExtra("Retr_Msg_content", a2);
                    intent2.putExtra("Retr_Msg_Type", 2);
                    intent2.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vCX);
                    intent2.putExtra("Retr_Msg_Id", auVar.field_msgId);
                    intent2.putExtra("Retr_MsgFromScene", 1);
                    a2 = auVar.field_talker;
                    fQ = q.fQ(auVar.field_msgSvrId);
                    intent2.putExtra("reportSessionId", fQ);
                    n = q.yC().n(fQ, true);
                    n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                    n.l("preUsername", a2);
                    n.l("preChatName", a2);
                    n.l("preMsgIndex", Integer.valueOf(this.vCX));
                    n.l("sendAppMsgScene", Integer.valueOf(1));
                    aVar.startActivity(intent2);
                    break;
                }
                break;
            case 114:
                a2 = a(auVar, aVar.uSU.uTo, 0);
                if (!u.mA(a2)) {
                    eh.c(auVar, a2, aVar.uSU.uTo);
                    break;
                }
                break;
            case 125:
                a2 = auVar.field_talker;
                a = q.fQ(auVar.field_msgSvrId);
                n = q.yC().n(a, true);
                n.l("prePublishId", "msg_" + auVar.field_msgSvrId);
                n.l("preUsername", a2);
                n.l("preChatName", a2);
                n.l("preMsgIndex", Integer.valueOf(this.vCX));
                n.l("sendAppMsgScene", Integer.valueOf(1));
                cb cbVar = new cb();
                cbVar.fFA.fFE = this.vCX;
                cbVar.fFA.fFF = a;
                cbVar.fFA.ov = aVar;
                cbVar.fFA.fFH = 40;
                com.tencent.mm.pluginsdk.model.e.a(cbVar, auVar);
                com.tencent.mm.sdk.b.a.urY.m(cbVar);
                if (cbVar.fFB.ret == 0) {
                    com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(a(auVar, aVar.uSU.uTo, this.vCX));
                    if (auVar.axO()) {
                        com.tencent.mm.modelstat.b.hUp.c(auVar, ek != null ? ek.type : 0);
                    } else {
                        com.tencent.mm.modelstat.b.hUp.t(auVar);
                    }
                    if (!(ek == null || ek.type != 5 || ek.url == null)) {
                        w.d("MicroMsg.ChattingItemBizFrom", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", Integer.valueOf(13378), ek.url, Long.valueOf(this.vCY), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                        a2 = "";
                        try {
                            a2 = URLEncoder.encode(ek.url, "UTF-8");
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.ChattingItemBizFrom", e, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(13378, a2, Long.valueOf(this.vCY), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
                        break;
                    }
                }
                break;
        }
        return false;
    }

    protected static String a(au auVar, Context context, int i) {
        if (context == null) {
            w.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: context is null");
            return null;
        } else if (auVar == null) {
            w.w("MicroMsg.ChattingItemBizFrom", "getReaderAppMsgContent: msg is null");
            return null;
        } else {
            ap.yY();
            if (c.isSDCardAvailable()) {
                try {
                    k rV = ((com.tencent.mm.plugin.biz.a.a) h.h(com.tencent.mm.plugin.biz.a.a.class)).rV(auVar.field_content);
                    List list = rV.hkm;
                    if (list != null && list.size() > 0 && i < list.size()) {
                        l lVar = (l) list.get(i);
                        com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                        aVar.title = lVar.title;
                        aVar.description = lVar.hku;
                        aVar.action = "view";
                        aVar.type = 5;
                        aVar.url = lVar.url;
                        aVar.fUR = rV.fUR;
                        aVar.fUS = rV.fUS;
                        aVar.gxD = rV.gxD;
                        aVar.thumburl = lVar.hks;
                        if (u.mA(aVar.thumburl)) {
                            com.tencent.mm.x.h hs = com.tencent.mm.x.n.Bm().hs(auVar.field_talker);
                            if (hs != null) {
                                aVar.thumburl = hs.Bs();
                            }
                        }
                        return com.tencent.mm.t.f.a.a(aVar, null, null);
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ChattingItemBizFrom", e, "", new Object[0]);
                    w.e("MicroMsg.ChattingItemBizFrom", "retransmit app msg error : %s", e.getLocalizedMessage());
                }
                return null;
            }
            com.tencent.mm.ui.base.s.eP(context);
            return null;
        }
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar, au auVar) {
        return false;
    }

    private void a(final l lVar, View view) {
        if (view != null && lVar != null) {
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ bf vDa;

                public final void onClick(View view) {
                    dt dtVar = (dt) view.getTag();
                    w.i("MicroMsg.ChattingItemBizFrom", "on app brand(%s) button1 click", lVar.hkx);
                    com.tencent.mm.sdk.b.b prVar = new pr();
                    prVar.fWB.userName = lVar.hkx;
                    prVar.fWB.fWD = lVar.hky;
                    prVar.fWB.fWE = lVar.hkA;
                    prVar.fWB.fWF = lVar.hkz;
                    prVar.fWB.fWH = true;
                    prVar.fWB.scene = 1076;
                    prVar.fWB.fCN = this.vDa.vCd.bUg() + ":" + dtVar.fTk.field_msgSvrId + ":" + dtVar.rXJ;
                    com.tencent.mm.sdk.b.a.urY.m(prVar);
                }
            });
        }
    }
}
