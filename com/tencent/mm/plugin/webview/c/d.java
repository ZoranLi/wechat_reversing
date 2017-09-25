package com.tencent.mm.plugin.webview.c;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Base64;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.as.f;
import com.tencent.mm.as.l;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ako;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements com.tencent.mm.y.e {
    public com.tencent.mm.sdk.b.c iOT = new com.tencent.mm.sdk.b.c<jc>(this) {
        final /* synthetic */ d rVZ;

        {
            this.rVZ = r2;
            this.usg = jc.class.getName().hashCode();
        }

        private boolean a(jc jcVar) {
            anf com_tencent_mm_protocal_c_anf = jcVar.fPc.fOY;
            if (com_tencent_mm_protocal_c_anf != null && com.tencent.mm.am.b.d(com_tencent_mm_protocal_c_anf)) {
                switch (jcVar.fPc.action) {
                    case 0:
                    case 1:
                        for (Integer intValue : this.rVZ.rVR) {
                            h.wH(intValue.intValue()).cn(com_tencent_mm_protocal_c_anf.tqY, 1);
                        }
                        break;
                    case 2:
                    case 3:
                    case 4:
                        for (Integer intValue2 : this.rVZ.rVR) {
                            h.wH(intValue2.intValue()).cn(com_tencent_mm_protocal_c_anf.tqY, 0);
                        }
                        break;
                }
            }
            return false;
        }
    };
    public com.tencent.mm.plugin.fts.a.a.a mah;
    public j osJ = new j(this) {
        final /* synthetic */ d rVZ;

        {
            this.rVZ = r1;
        }

        public final void a(final g gVar) {
            if (gVar.aMA == 0) {
                final ArrayList arrayList = new ArrayList();
                for (i iVar : gVar.maj) {
                    arrayList.add(iVar.content);
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 rWb;

                    public final void run() {
                        if (this.rWb.rVZ.mah != null && this.rWb.rVZ.mah.lZK != null) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.g wH = h.wH(((Integer) this.rWb.rVZ.mah.lZK).intValue());
                            String str = gVar.lYe.fRM;
                            w.i("MicroMsg.MsgHandler", "onSearchHistoryCallback: %s", new Object[]{arrayList.toString()});
                            Bundle bundle = new Bundle();
                            bundle.putString("query", str);
                            bundle.putStringArrayList("result", r2);
                            try {
                                if (wH.rXh != null) {
                                    wH.rXh.m(126, bundle);
                                }
                            } catch (RemoteException e) {
                                w.w("MicroMsg.MsgHandler", "onSearchHistoryCallback exception" + e.getMessage());
                            }
                        }
                    }
                });
            }
        }
    };
    private long pff;
    public Set<Integer> rVR;
    private HashMap<String, b> rVS;
    public h rVT;
    private l rVU;
    public e rVV = new e(this);
    public List<anf> rVW;

    private class a implements Runnable {
        public String data;
        final /* synthetic */ d rVZ;
        public boolean rWc;

        public a(d dVar) {
            this.rVZ = dVar;
        }

        public final void run() {
            Object arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONArray(this.data);
                for (int i = 0; i < jSONArray.length(); i++) {
                    bfc kL = ((com.tencent.mm.plugin.sns.b.l) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.l.class)).kL(jSONArray.getString(i));
                    com.tencent.mm.am.a.a aVar = (com.tencent.mm.am.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.am.a.a.class);
                    ap.yY();
                    anf a = aVar.a(com.tencent.mm.u.c.xv(), kL, 9);
                    if (a != null) {
                        arrayList.add(a);
                    }
                }
                if (!this.rWc || this.rVZ.rVW == null) {
                    this.rVZ.rVW = arrayList;
                } else {
                    this.rVZ.rVW.addAll(arrayList);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e, "", new Object[0]);
            }
        }
    }

    private class b {
        String fLL;
        String hPt;
        boolean hRq = false;
        final /* synthetic */ d rVZ;
        long rWd;
        long rWe;
        private String rWf = null;
        int scene;
        int type;

        public b(d dVar) {
            this.rVZ = dVar;
        }

        final String bwd() {
            if (this.rWf == null) {
                this.rWf = "";
                try {
                    JSONArray optJSONArray = new JSONObject(this.fLL).optJSONObject(SlookAirButtonFrequentContactAdapter.DATA).optJSONObject("hotwords").optJSONArray("items");
                    Iterable arrayList = new ArrayList();
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        arrayList.add(Uri.encode(optJSONArray.optJSONObject(i).optString("hotword")));
                    }
                    this.rWf = TextUtils.join("|", arrayList);
                } catch (Exception e) {
                }
            }
            return this.rWf;
        }
    }

    private class c {
        public String fFa;
        public String fRM;
        public int hPu;
        public String iGy;
        public String osT;
        public my otU;
        public int position;
        final /* synthetic */ d rVZ;
        public int rWg;
        public boolean rWh;
        public String rWi;
        public int scene;
        public String signature;
        public String username;

        public c(d dVar) {
            this.rVZ = dVar;
        }
    }

    private class d {
        public String country;
        public String fFa;
        public String fRM;
        public String gkB;
        public String gkC;
        public int gkr;
        public String gtR;
        final /* synthetic */ d rVZ;
        public int rWj;
        public int scene;
        public String signature;
        public String username;

        public d(d dVar) {
            this.rVZ = dVar;
        }
    }

    public class e {
        public boolean fDw;
        public String fRM;
        public int mde;
        final /* synthetic */ d rVZ;
        public boolean rWk = true;
        public boolean rWl;
        public int scene;

        public e(d dVar) {
            this.rVZ = dVar;
        }
    }

    public d() {
        w.i("MicroMsg.FTS.FTSWebViewLogic", "create FTSWebViewLogic");
        this.rVS = new HashMap();
        this.rVR = Collections.synchronizedSet(new HashSet());
        com.tencent.mm.sdk.b.a.urY.b(this.iOT);
    }

    public static Bundle l(int i, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        switch (i) {
            case 2:
                try {
                    bundle2.putString("result", com.tencent.mm.as.j.kb(bundle.getString("key")).toString());
                    break;
                } catch (Exception e) {
                    break;
                }
            case 4:
                Map a = com.tencent.mm.as.d.a(bundle.getInt("scene"), bundle.getBoolean("isHomePage"), bundle.getInt(Columns.TYPE));
                bundle2.putString(Columns.TYPE, (String) a.get(Columns.TYPE));
                bundle2.putString("isMostSearchBiz", (String) a.get("isMostSearchBiz"));
                bundle2.putString("isLocalSug", (String) a.get("isLocalSug"));
                bundle2.putString("isSug", (String) a.get("isSug"));
                bundle2.putString("scene", (String) a.get("scene"));
                break;
        }
        return bundle2;
    }

    public final boolean Q(Map<String, Object> map) {
        switch (e.c(map, "action", 0)) {
            case 1:
                if (com.tencent.mm.as.e.hPI == null) {
                    com.tencent.mm.as.e.In();
                }
                com.tencent.mm.as.e.hPI.jNe.clear();
                SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("fts_history_search_sp", 0);
                try {
                    sharedPreferences.edit().putString(com.tencent.mm.as.e.Io(), Base64.encodeToString(com.tencent.mm.as.e.hPI.toByteArray(), 0)).apply();
                    w.i("MicroMsg.FTS.FTSHistorySearchLogic", "addHistory pbListString %s", new Object[]{r2});
                    break;
                } catch (IOException e) {
                    break;
                }
            case 2:
                int c = e.c(map, Columns.TYPE, 0);
                int c2 = e.c(map, "scene", 0);
                if (System.currentTimeMillis() - this.pff > 1000) {
                    this.pff = System.currentTimeMillis();
                    if (!com.tencent.mm.as.d.Ii()) {
                        w.e("MicroMsg.FTS.FTSWebViewLogic", "fts h5 template not avail");
                        break;
                    }
                    com.tencent.mm.as.i.aW(c, c2);
                    Intent Il = com.tencent.mm.as.d.Il();
                    Il.putExtra("ftsneedkeyboard", true);
                    Il.putExtra("ftsbizscene", c2);
                    Il.putExtra("ftsType", c);
                    Il.putExtra("rawUrl", com.tencent.mm.as.d.m(com.tencent.mm.as.d.a(c2, true, c)));
                    Il.putExtra("key_load_js_without_delay", true);
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il);
                    break;
                }
                break;
        }
        return false;
    }

    public final boolean R(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData: %s", new Object[]{map});
        int c = e.c(map, "scene", 0);
        int c2 = e.c(map, Columns.TYPE, 0);
        int c3 = e.c(map, "requestType", 0);
        int n = bg.n(map.get("webview_instance_id"), -1);
        String p;
        if (c3 == 0) {
            b bVar;
            bwc();
            p = p(c, c2, true);
            if (this.rVS.get(p) == null) {
                bVar = new b(this);
                ako com_tencent_mm_protocal_c_ako = new ako();
                ap.yY();
                String xg = com.tencent.mm.u.c.xg();
                String p2 = p(c, c2, false);
                if (!p2.equals(p(c, c2, true))) {
                    bVar.hRq = true;
                }
                File file = new File(xg, p2);
                byte[] c4 = com.tencent.mm.a.e.c(file.getAbsolutePath(), 0, (int) file.length());
                if (c4 != null) {
                    try {
                        com_tencent_mm_protocal_c_ako.aD(c4);
                        bVar.scene = com_tencent_mm_protocal_c_ako.scene;
                        bVar.fLL = com_tencent_mm_protocal_c_ako.tlt;
                        bVar.rWd = com_tencent_mm_protocal_c_ako.tOi;
                        bVar.rWe = com_tencent_mm_protocal_c_ako.tOj;
                        bVar.hPt = com_tencent_mm_protocal_c_ako.tmb;
                        bVar.type = com_tencent_mm_protocal_c_ako.jOc;
                        w.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(c4.length)});
                    } catch (IOException e) {
                    }
                }
                this.rVS.put(p, bVar);
            }
            bVar = (b) this.rVS.get(p);
            if (!bg.mA(bVar.fLL)) {
                w.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(n)});
                if (bVar.scene != 20 || bVar.type != 0) {
                    h.wH(n).d(c3, bVar.fLL, 1);
                } else if (!bVar.hRq) {
                    h.wH(n).co(bVar.fLL, 1);
                }
            }
            Object obj = bVar.hRq ? null : (bg.mA(bVar.fLL) || (System.currentTimeMillis() / 1000) - bVar.rWe > bVar.rWd) ? null : 1;
            if (obj != null) {
                w.i("MicroMsg.FTS.FTSWebViewLogic", "hit the cache: %d %d %d %d", new Object[]{Integer.valueOf(bVar.scene), Long.valueOf(bVar.rWd), Long.valueOf(bVar.rWe), Integer.valueOf(bVar.type)});
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.as.i.a(bVar.scene, 0, bVar.hPt, bVar.type, 2, bVar.bwd(), 1);
                } else {
                    com.tencent.mm.as.i.a(bVar.scene, 0, bVar.hPt, bVar.type, 1, "", 0);
                }
                return false;
            }
            ap.vd().a(1048, this);
            w.i("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData, webviewID = %d", new Object[]{Integer.valueOf(n)});
            this.rVU = new l(c, c2, com.tencent.mm.as.d.hPo, n, v.ea(ab.getContext()), com.tencent.mm.as.j.kb("discoverSearchEntry").optLong("guideParam"));
            ap.vd().a(this.rVU, 0);
        } else {
            anb Iq = f.Iq();
            try {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject2 = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                for (c = Iq.jNe.size() - 1; c >= 0; c--) {
                    JSONObject jSONObject3 = new JSONObject();
                    ana com_tencent_mm_protocal_c_ana = (ana) Iq.jNe.get(c);
                    if (o.eU(com_tencent_mm_protocal_c_ana.tgG)) {
                        BizInfo hW = com.tencent.mm.modelbiz.e.hW(com_tencent_mm_protocal_c_ana.tgG);
                        if (hW != null) {
                            jSONObject3.put("avatarUrl", hW.field_brandIconURL);
                            jSONObject3.put("userName", hW.field_username);
                            jSONObject3.put("nickName", n.eK(hW.field_username));
                            jSONArray2.put(jSONObject3);
                        }
                    }
                }
                jSONObject2.put("items", jSONArray2);
                jSONObject2.put(Columns.TYPE, 5);
                jSONObject2.put("title", "");
                jSONArray.put(jSONObject2);
                jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                w.d("MicroMsg.FTS.FTSWebViewLogic", "getTeachSearchData returnString=%s", new Object[]{jSONObject.toString()});
                h.wH(n).d(1, p, 1);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebViewLogic", e2, "gen mostSearchBizContactList error", new Object[0]);
            }
        }
        return false;
    }

    public final void bwc() {
        if (this.rVU != null) {
            ap.vd().b(1048, this);
            ap.vd().c(this.rVU);
            this.rVU = null;
        }
    }

    public final boolean a(Map<String, Object> map, com.tencent.mm.plugin.webview.ui.tools.jsapi.g gVar) {
        boolean z;
        Bundle bundle = null;
        this.rVV.rWl = true;
        boolean q = e.q(map, "isTeachPage");
        boolean q2 = e.q(map, "isMoreButton");
        boolean z2 = e.c(map, "isFeedBack", 0) == 1;
        if (e.c(map, "isWeAppMore", 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        if (!z2) {
            int c = e.c(map, Columns.TYPE, 0);
            int c2 = e.c(map, "opType", 0);
            String str;
            if (c2 <= 0) {
                if (!q2) {
                    str = (String) map.get(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    w.i("MicroMsg.FTS.FTSWebViewLogic", "doStartSearchItemDetailPage: type=%d link=%s", new Object[]{Integer.valueOf(c), str});
                    switch (c) {
                        case 1:
                            a(T(map), false);
                            break;
                        case 8:
                            e.o(map, "snsid");
                            String o = e.o(map, "objectXmlDesc");
                            String o2 = e.o(map, "userName");
                            z = e.q(map, "fromMusicItem");
                            com.tencent.mm.plugin.webview.d.f.bwV();
                            bfc kL = ((com.tencent.mm.plugin.sns.b.l) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.l.class)).kL(o);
                            Intent intent = new Intent();
                            intent.putExtra("INTENT_TALKER", o2);
                            intent.putExtra("INTENT_SNSID", new BigInteger(kL.mQY).longValue());
                            intent.putExtra("SNS_FROM_MUSIC_ITEM", z);
                            try {
                                intent.putExtra("INTENT_SNS_TIMELINEOBJECT", kL.toByteArray());
                            } catch (IOException e) {
                            }
                            com.tencent.mm.bb.d.b(ab.getContext(), "sns", ".ui.SnsCommentDetailUI", intent);
                            break;
                        case 32:
                            d dVar = new d(this);
                            dVar.username = e.o(map, "userName");
                            dVar.fFa = e.o(map, "nickName");
                            dVar.gtR = e.o(map, "alias");
                            dVar.signature = e.o(map, "signature");
                            dVar.gkr = e.c(map, "sex", 0);
                            dVar.country = e.o(map, "country");
                            dVar.gkC = e.o(map, "city");
                            dVar.gkB = e.o(map, "province");
                            dVar.rWj = e.c(map, "snsFlag", 0);
                            String o3 = e.o(map, "query");
                            if (bg.mA(o3)) {
                                dVar.scene = 3;
                            } else {
                                dVar.scene = Character.isDigit(o3.charAt(0)) ? 15 : 3;
                                if (dVar.scene == 15) {
                                    if ("mobile".equals(e.o(map, "matchType"))) {
                                        dVar.fRM = o3;
                                    } else {
                                        dVar.scene = 1;
                                    }
                                }
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", dVar.username);
                            intent2.putExtra("Contact_Nick", dVar.fFa);
                            intent2.putExtra("Contact_Alias", dVar.gtR);
                            intent2.putExtra("Contact_Sex", dVar.gkr);
                            intent2.putExtra("Contact_Scene", dVar.scene);
                            intent2.putExtra("Contact_KHideExpose", true);
                            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(dVar.country, dVar.gkB, dVar.gkC));
                            intent2.putExtra("Contact_Signature", dVar.signature);
                            intent2.putExtra("Contact_KSnsIFlag", dVar.rWj);
                            intent2.putExtra("Contact_full_Mobile_MD5", dVar.fRM);
                            com.tencent.mm.bb.d.b(ab.getContext(), "profile", ".ui.ContactInfoUI", intent2);
                            break;
                        default:
                            str = e.o(map, "jumpUrl");
                            w.i("MicroMsg.FTS.FTSWebViewLogic", "jump url = %s", new Object[]{str});
                            if (gVar != null) {
                                bundle = gVar.bzN();
                            }
                            if (!bg.mA(str)) {
                                com.tencent.mm.plugin.webview.d.f.bwV();
                                b(str, bundle);
                                break;
                            }
                            break;
                    }
                }
                str = e.o(map, "query");
                int c3 = e.c(map, "scene", 0);
                String o4 = e.o(map, "searchId");
                Intent intent3 = new Intent();
                intent3.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                intent3.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                intent3.putExtra("neverGetA8Key", true);
                intent3.putExtra("key_load_js_without_delay", true);
                intent3.putExtra("ftsQuery", str);
                intent3.putExtra("ftsType", c);
                Map aV;
                if (!com.tencent.mm.as.n.Iz()) {
                    aV = com.tencent.mm.as.d.aV(c3, c);
                    aV.put("query", str);
                    aV.put("searchId", o4);
                    intent3.putExtra("rawUrl", com.tencent.mm.as.d.c(c3, aV));
                    if (c3 == 20 || c3 == 22) {
                        str = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", str, intent3);
                } else if (z) {
                    aV = com.tencent.mm.as.n.a(c3, false, c);
                    aV.put("query", str);
                    aV.put("searchId", o4);
                    aV.put("subType", String.valueOf(e.c(map, "subType", 0)));
                    aV.put("isWeAppMore", String.valueOf(e.c(map, "isWeAppMore", 0)));
                    intent3.putExtra("key_session_id", com.tencent.mm.modelappbrand.b.AK());
                    intent3.putExtra("rawUrl", com.tencent.mm.as.n.m(aV));
                    intent3.putExtra("ftsbizscene", c3);
                    if (c3 == 20 || c3 == 22) {
                        str = ".ui.AppBrandSOSUI";
                    } else {
                        str = ".ui.AppBrandSearchUI";
                    }
                    com.tencent.mm.bb.d.b(ab.getContext(), "appbrand", str, intent3);
                } else {
                    aV = com.tencent.mm.as.d.a(c3, false, c);
                    aV.put("query", str);
                    aV.put("searchId", o4);
                    intent3.putExtra("rawUrl", com.tencent.mm.as.d.m(aV));
                    if (c3 == 20 || c3 == 22) {
                        str = ".ui.tools.fts.FTSSOSMoreWebViewUI";
                    } else {
                        str = ".ui.tools.fts.FTSSearchTabWebViewUI";
                    }
                    com.tencent.mm.bb.d.b(ab.getContext(), "webview", str, intent3);
                }
            } else {
                switch (c2) {
                    case 2:
                        a(T(map), q);
                        break;
                    case 3:
                        c T = T(map);
                        if (!o.eU(T.username)) {
                            a(T, q);
                            break;
                        }
                        f.jY(T.username);
                        Intent intent4 = new Intent();
                        intent4.putExtra("Chat_User", T.username);
                        intent4.putExtra("finish_direct", true);
                        intent4.putExtra("key_temp_session_show_type", 0);
                        com.tencent.mm.bb.d.a(ab.getContext(), ".ui.chatting.En_5b8fbb1e", intent4);
                        break;
                    case 4:
                        str = e.o(map, "jumpUrl");
                        if (gVar != null) {
                            bundle = gVar.bzN();
                        }
                        com.tencent.mm.plugin.webview.d.f.bwV();
                        b(str, bundle);
                        break;
                    default:
                        break;
                }
            }
        }
        Bundle bzN;
        o = e.o(map, "jumpUrl");
        if (gVar != null) {
            bzN = gVar.bzN();
        } else {
            bzN = null;
        }
        com.tencent.mm.plugin.webview.d.f.bwV();
        b(o, bzN);
        return false;
    }

    public final boolean S(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewLogic", "reportSearchRealTimeReport: %s", new Object[]{map.toString()});
        avb com_tencent_mm_protocal_c_avb = new avb();
        com_tencent_mm_protocal_c_avb.tYG = e.o(map, "logString");
        ap.vd().a(1134, this);
        ap.vd().a(new g(com_tencent_mm_protocal_c_avb), 0);
        return false;
    }

    private static void b(String str, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str);
        intent.putExtra("convertActivityFromTranslucent", false);
        if (!(bundle == null || bg.mA(str))) {
            String str2 = bundle.getString("publishIdPrefix", "gs") + "_" + com.tencent.mm.a.g.n(str.getBytes());
            intent.putExtra("prePublishId", str2);
            intent.putExtra("KPublisherId", str2);
        }
        com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
    }

    private static void a(c cVar, boolean z) {
        int i;
        if (cVar.hPu == 2) {
            i = 89;
        } else if (z) {
            i = 85;
        } else if (cVar.scene != 3 && cVar.scene != 16) {
            i = 39;
        } else if (cVar.rWh) {
            i = 88;
        } else {
            i = 87;
        }
        f.jY(cVar.username);
        Intent intent = new Intent();
        intent.putExtra("Contact_User", cVar.username);
        intent.putExtra("Contact_Nick", cVar.fFa);
        intent.putExtra("Contact_BrandIconURL", cVar.osT);
        intent.putExtra("Contact_Signature", cVar.signature);
        intent.putExtra("Contact_VUser_Info_Flag", cVar.rWg);
        intent.putExtra("Contact_Scene", i);
        if (cVar.otU != null) {
            try {
                intent.putExtra("Contact_customInfo", cVar.otU.toByteArray());
            } catch (IOException e) {
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString("Contact_Ext_Args_Search_Id", cVar.iGy);
        bundle.putString("Contact_Ext_Args_Query_String", cVar.fRM);
        bundle.putInt("Contact_Scene", i);
        bundle.putInt("Contact_Ext_Args_Index", cVar.position);
        bundle.putString("Contact_Ext_Extra_Params", cVar.rWi);
        intent.putExtra("Contact_Ext_Args", bundle);
        com.tencent.mm.bb.d.b(ab.getContext(), "profile", ".ui.ContactInfoUI", intent);
    }

    public static int b(Map<String, Object> map, Map<String, Object> map2) {
        try {
            JSONArray jSONArray = new JSONArray(e.o(map, SlookAirButtonFrequentContactAdapter.DATA));
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                String string2 = jSONObject.getString("userName");
                String eK = n.eK(string2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string);
                jSONObject2.put("userName", string2);
                jSONObject2.put("displayName", eK);
                jSONArray2.put(jSONObject2);
            }
            map2.put("ret", Integer.valueOf(0));
            map2.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray2.toString());
        } catch (JSONException e) {
        }
        return 0;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String p;
        int i3;
        String xg;
        if (kVar instanceof l) {
            ap.vd().b(1048, this);
            if (i == 0 && i2 == 0) {
                l lVar = (l) kVar;
                b bVar = new b(this);
                bVar.scene = lVar.scene;
                bVar.rWd = (long) lVar.hQk.tOo;
                bVar.fLL = lVar.hQk.tlt;
                bVar.rWe = System.currentTimeMillis() / 1000;
                bVar.hPt = lVar.hQk.tOp;
                bVar.type = lVar.hPq;
                p = p(bVar.scene, bVar.type, true);
                if (!bg.mA(bVar.fLL)) {
                    if (bVar.scene == 20 && bVar.type == 0) {
                        h.wH(lVar.fRO).co(bVar.fLL, 0);
                    } else {
                        h.wH(lVar.fRO).d(0, bVar.fLL, 0);
                    }
                    w.i("MicroMsg.FTS.FTSWebViewLogic", "onTeachSearchDataReady, %s", new Object[]{bVar.fLL});
                }
                this.rVS.put(p, bVar);
                File file;
                if (bVar.rWd == 0) {
                    i3 = bVar.scene;
                    int i4 = bVar.type;
                    w.i("MicroMsg.FTS.FTSWebViewLogic", "delete biz cache %d %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
                    ap.yY();
                    xg = com.tencent.mm.u.c.xg();
                    file = new File(xg, p(i3, i4, true));
                    if (file.exists()) {
                        file.delete();
                    }
                    file = new File(xg, p(i3, i4, false));
                    if (file.exists()) {
                        file.delete();
                    }
                } else {
                    ako com_tencent_mm_protocal_c_ako = new ako();
                    com_tencent_mm_protocal_c_ako.scene = bVar.scene;
                    com_tencent_mm_protocal_c_ako.tlt = bVar.fLL;
                    com_tencent_mm_protocal_c_ako.tOi = bVar.rWd;
                    com_tencent_mm_protocal_c_ako.tOj = bVar.rWe;
                    com_tencent_mm_protocal_c_ako.tmb = bVar.hPt;
                    com_tencent_mm_protocal_c_ako.jOc = bVar.type;
                    byte[] bArr = null;
                    try {
                        bArr = com_tencent_mm_protocal_c_ako.toByteArray();
                    } catch (IOException e) {
                    }
                    if (bArr != null) {
                        ap.yY();
                        file = new File(com.tencent.mm.u.c.xg(), p(bVar.scene, bVar.type, true));
                        if (!file.getParentFile().exists()) {
                            file.getParentFile().mkdirs();
                        }
                        if (file.exists()) {
                            file.delete();
                        }
                        com.tencent.mm.a.e.b(file.getAbsolutePath(), bArr, bArr.length);
                        w.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(bArr.length)});
                    } else {
                        w.i("MicroMsg.FTS.FTSWebViewLogic", "save bizCacheFile fail");
                    }
                }
                if (bVar.scene == 20 && bVar.type == 0) {
                    com.tencent.mm.as.i.a(bVar.scene, 1, bVar.hPt, bVar.type, 2, bVar.bwd(), 1);
                } else {
                    com.tencent.mm.as.i.a(bVar.scene, 1, bVar.hPt, bVar.type, 1, "", 0);
                }
            }
        } else if (kVar instanceof g) {
            ap.vd().b(1134, this);
        } else if (kVar instanceof h) {
            ap.vd().b(1161, this);
            if (i == 0 && i2 == 0) {
                p = this.rVT.AS();
                final ArrayList arrayList = new ArrayList();
                try {
                    JSONObject jSONObject = new JSONObject(p);
                    JSONArray optJSONArray = jSONObject.optJSONArray(SlookAirButtonFrequentContactAdapter.DATA);
                    xg = jSONObject.optString("suggestionID", "");
                    jSONObject = null;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                        if (optJSONObject.optInt(Columns.TYPE) != 1) {
                            optJSONObject = jSONObject;
                        }
                        i5++;
                        jSONObject = optJSONObject;
                    }
                    if (jSONObject != null) {
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("items");
                        for (i3 = 0; i3 < optJSONArray2.length(); i3++) {
                            String optString = optJSONArray2.optJSONObject(i3).optString("word");
                            if (!bg.mA(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    p = xg;
                } catch (Exception e2) {
                    p = "";
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ d rVZ;

                    public final void run() {
                        com.tencent.mm.plugin.webview.ui.tools.jsapi.g wH = h.wH(this.rVZ.rVT.rWo.fRO);
                        String str = this.rVZ.rVT.rWo.fDs;
                        String str2 = p;
                        w.i("MicroMsg.MsgHandler", "onSearchSuggestCallback: %s", new Object[]{arrayList.toString()});
                        Bundle bundle = new Bundle();
                        bundle.putString("query", str);
                        bundle.putString("suggestionId", str2);
                        bundle.putStringArrayList("result", r3);
                        try {
                            if (wH.rXh != null) {
                                wH.rXh.m(127, bundle);
                            }
                        } catch (RemoteException e) {
                            w.w("MicroMsg.MsgHandler", "onSearchSuggestCallback exception" + e.getMessage());
                        }
                    }
                });
            }
        }
    }

    private c T(Map<String, Object> map) {
        c cVar = new c(this);
        cVar.username = e.o(map, "userName");
        cVar.fFa = e.o(map, "nickName");
        cVar.osT = e.o(map, "headHDImgUrl");
        cVar.rWg = e.c(map, "verifyFlag", 0);
        cVar.signature = e.o(map, "signature");
        cVar.scene = e.c(map, "scene", 0);
        cVar.hPu = e.c(map, "sceneActionType", 1);
        cVar.otU = new my();
        cVar.otU.hAR = e.c(map, "brandFlag", 0);
        cVar.otU.hAU = e.o(map, "iconUrl");
        cVar.otU.hAT = e.o(map, "brandInfo");
        cVar.otU.hAS = e.o(map, "externalInfo");
        cVar.iGy = e.o(map, "searchId");
        cVar.fRM = e.o(map, "query");
        cVar.position = e.c(map, "position", 0);
        cVar.rWh = e.q(map, "isCurrentDetailPage");
        cVar.rWi = e.o(map, "extraParams");
        return cVar;
    }

    private static String p(int i, int i2, boolean z) {
        String str = "FTS_BizCacheObj" + i + "-" + i2;
        String str2 = str + "-" + v.ea(ab.getContext());
        if (z) {
            return str2;
        }
        ap.yY();
        if (new File(com.tencent.mm.u.c.xg(), str2).exists()) {
            return str2;
        }
        return str;
    }

    public static boolean U(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewLogic", "setSearchInputWord %s", new Object[]{map});
        String o = e.o(map, "word");
        boolean q = e.q(map, "isInputChange");
        String o2 = e.o(map, "custom");
        String o3 = e.o(map, "tagList");
        com.tencent.mm.plugin.webview.ui.tools.jsapi.g wH = h.wH(bg.n(map.get("webview_instance_id"), -1));
        Bundle bundle = new Bundle();
        bundle.putString("fts_key_new_query", o);
        bundle.putString("fts_key_custom_query", o2);
        bundle.putBoolean("fts_key_need_keyboard", q);
        bundle.putString("fts_key_tag_list", o3);
        try {
            if (wH.rXh != null) {
                wH.rXh.m(122, bundle);
            }
        } catch (RemoteException e) {
            w.w("MicroMsg.MsgHandler", "onFTSSearchQueryChange exception" + e.getMessage());
        }
        return false;
    }
}
