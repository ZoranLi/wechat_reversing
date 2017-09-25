package com.tencent.mm.plugin.webview.c;

import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.as.n;
import com.tencent.mm.e.a.ho;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.k.a.b.m;
import com.tencent.mm.protocal.c.anw;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.bqr;
import com.tencent.mm.protocal.c.ma;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    public bov hPH;
    public com.tencent.mm.plugin.fts.a.a.a mah;
    private j osJ = new j(this) {
        final /* synthetic */ b rVG;

        {
            this.rVG = r1;
        }

        public final void a(g gVar) {
            switch (gVar.aMA) {
                case -3:
                case -2:
                case -1:
                    h.wH(((Integer) this.rVG.mah.lZK).intValue()).Kb("");
                    return;
                case 0:
                    if (gVar.maj == null || gVar.maj.size() == 0) {
                        w.i("MicroMsg.FTS.FTSWebSearchLogic", "local contact search size 0");
                        h.wH(((Integer) this.rVG.mah.lZK).intValue()).Kb("");
                        return;
                    }
                    try {
                        JSONObject jSONObject = new JSONObject();
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject2 = new JSONObject();
                        JSONArray jSONArray2 = new JSONArray();
                        for (i iVar : gVar.maj) {
                            if (iVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                                jSONArray2.put(e.a(iVar, gVar.lYe.fRM, bg.f(gVar.mai)));
                            }
                        }
                        jSONObject2.put("items", jSONArray2);
                        jSONObject2.put("title", ab.getContext().getString(R.l.enq));
                        jSONObject2.put("count", jSONArray2.length());
                        jSONObject2.put(Columns.TYPE, 3);
                        jSONArray.put(jSONObject2);
                        jSONObject.put(SlookAirButtonFrequentContactAdapter.DATA, jSONArray);
                        jSONObject.put("ret", 0);
                        h.wH(((Integer) this.rVG.mah.lZK).intValue()).Kb(jSONObject.toString());
                        return;
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "onSearchDone", new Object[0]);
                        return;
                    }
                default:
                    return;
            }
        }
    };
    public int rVD = 0;
    public a rVE = new a(this);
    public b rVF = new b(this);

    private class a {
        final /* synthetic */ b rVG;
        public com.tencent.mm.as.a rVH;

        public a(b bVar) {
            this.rVG = bVar;
        }

        public static String a(com.tencent.mm.as.d.b bVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(bVar.fDs);
            stringBuffer.append(bVar.hPq);
            stringBuffer.append(bVar.scene);
            stringBuffer.append(bVar.hPp);
            stringBuffer.append(bVar.hPu);
            stringBuffer.append(bVar.offset);
            if (bVar.hPE != null) {
                Iterator it = bVar.hPE.iterator();
                while (it.hasNext()) {
                    anw com_tencent_mm_protocal_c_anw = (anw) it.next();
                    stringBuffer.append(com_tencent_mm_protocal_c_anw.tSW);
                    stringBuffer.append(com_tencent_mm_protocal_c_anw.tSX);
                    stringBuffer.append(com_tencent_mm_protocal_c_anw.tSY);
                }
            }
            return com.tencent.mm.a.g.n(stringBuffer.toString().getBytes());
        }
    }

    private class b {
        public final /* synthetic */ b rVG;
        public com.tencent.mm.as.b rVI;

        public b(b bVar) {
            this.rVG = bVar;
        }
    }

    public b() {
        w.d("MicroMsg.FTS.FTSWebSearchLogic", "create FTSWebSearchLogic");
    }

    private static boolean vO(int i) {
        return i == bh.CTRL_INDEX;
    }

    public final boolean L(Map<String, Object> map) {
        JSONArray jSONArray;
        int i;
        w.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData: %s", new Object[]{map.toString()});
        com.tencent.mm.as.d.b bVar = new com.tencent.mm.as.d.b();
        bVar.fDs = e.o(map, "query");
        bVar.offset = e.c(map, "offset", 0);
        bVar.hPq = e.c(map, Columns.TYPE, 0);
        bVar.scene = e.c(map, "scene", 3);
        bVar.hPv = e.o(map, "sugId");
        bVar.hPx = e.c(map, "sugType", 0);
        bVar.hPw = e.o(map, "prefixSug");
        bVar.hPp = e.q(map, "isHomePage") ? 1 : 0;
        bVar.hPt = e.o(map, "searchId");
        bVar.hPu = e.c(map, "sceneActionType", 1);
        bVar.hPz = e.c(map, "displayPattern", 2);
        bVar.hPA = e.c(map, "sugPosition", 0);
        bVar.hPB = e.o(map, "sugBuffer");
        String o = e.o(map, "extReqParams");
        if (!bg.mA(o)) {
            try {
                jSONArray = new JSONArray(o);
                for (i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    ma maVar = new ma();
                    maVar.arH = jSONObject.optString("key", "");
                    maVar.tsi = (long) jSONObject.optInt("uintValue", 0);
                    maVar.tsj = jSONObject.optString("textValue", "");
                    bVar.hPD.add(maVar);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e, "commKvJSONArray", new Object[0]);
            }
        }
        o = e.o(map, "matchUser");
        if (!bg.mA(o)) {
            try {
                JSONObject jSONObject2 = new JSONObject(o);
                bin com_tencent_mm_protocal_c_bin = new bin();
                com_tencent_mm_protocal_c_bin.jNj = jSONObject2.optString("userName");
                com_tencent_mm_protocal_c_bin.uit = jSONObject2.optString("matchWord");
                if (!TextUtils.isEmpty(com_tencent_mm_protocal_c_bin.jNj)) {
                    bVar.hPs.add(com_tencent_mm_protocal_c_bin);
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2, "matchUserJSONArray", new Object[0]);
            }
        }
        o = e.o(map, "prefixQuery");
        if (!bg.mA(o)) {
            try {
                jSONArray = new JSONArray(o);
                for (i = 0; i < jSONArray.length(); i++) {
                    bVar.hPy.add(jSONArray.getString(i));
                }
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e22, "prefixQueryJSONArray", new Object[0]);
            }
        }
        o = e.o(map, "tagInfo");
        if (!bg.mA(o)) {
            try {
                jSONObject2 = new JSONObject(o);
                bVar.hPC = new beo();
                bVar.hPC.ufn = jSONObject2.optString("tagText");
                bVar.hPC.ufm = jSONObject2.optInt("tagType");
                bVar.hPC.ufo = jSONObject2.optString("tagExtValue");
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e222, "tagInfoObj", new Object[0]);
            }
        }
        o = e.o(map, "numConditions");
        if (!bg.mA(o)) {
            try {
                jSONArray = new JSONArray(o);
                for (i = 0; i < jSONArray.length(); i++) {
                    jSONObject = jSONArray.optJSONObject(i);
                    anw com_tencent_mm_protocal_c_anw = new anw();
                    com_tencent_mm_protocal_c_anw.tSX = jSONObject.optLong("from");
                    com_tencent_mm_protocal_c_anw.tSY = jSONObject.optLong("to");
                    com_tencent_mm_protocal_c_anw.tSW = jSONObject.optInt("field");
                    bVar.hPE.add(com_tencent_mm_protocal_c_anw);
                }
            } catch (Throwable e2222) {
                w.printErrStackTrace("MicroMsg.FTS.FTSWebSearchLogic", e2222, "numConditionsArray", new Object[0]);
            }
        }
        bVar.fRO = bg.n(map.get("webview_instance_id"), -1);
        bVar.aQd = v.ea(ab.getContext());
        bVar.hPr = e.c(map, "subType", 0);
        if (n.Iz()) {
            bVar.hPF = e.c(map, "isWeAppMore", 0);
            if (bVar.hPF == 1) {
                bVar.hPG = new bqr();
                com.tencent.mm.sdk.b.b hoVar = new ho();
                com.tencent.mm.sdk.b.a.urY.m(hoVar);
                bVar.hPG.uoF = hoVar.fNc.fNd;
                bVar.hPG.uoI = com.tencent.mm.modelappbrand.b.hpR;
                bVar.hPG.uoG = e.c(map, "subType", 0);
                bVar.hPG.uoH = com.tencent.mm.modelappbrand.b.hpQ;
                bVar.hPG.uoK = bVar.hPA;
                ap.yY();
                Object obj = c.vr().get(com.tencent.mm.storage.w.a.uFX, null);
                if (obj != null && (obj instanceof String)) {
                    bVar.hPG.uoJ = (String) obj;
                }
            }
        }
        if (this.rVD == 1) {
            bVar.hPH = this.hPH;
        } else {
            bVar.hPH = null;
        }
        a aVar = this.rVE;
        if (bg.mA(bVar.fDs)) {
            w.i("MicroMsg.FTS.FTSWebSearchLogic", "error query %d %d %d %d %s %d", new Object[]{Integer.valueOf(bVar.hPq), Integer.valueOf(bVar.scene), Integer.valueOf(bVar.hPp), Integer.valueOf(bVar.hPu), bVar.hPt, Integer.valueOf(bVar.offset)});
        } else {
            switch (bVar.scene) {
                case 20:
                    ((l) com.tencent.mm.kernel.h.j(l.class)).addSOSHistory(bVar.fDs);
                    break;
            }
            o = a.a(bVar);
            w.i("MicroMsg.FTS.FTSWebSearchLogic", "start New NetScene %s %s %d", new Object[]{bVar.fDs, o, Integer.valueOf(bVar.fRO)});
            if (aVar.rVH != null) {
                ap.vd().c(aVar.rVH);
            }
            d.e eVar = f.bwV().rVV;
            int i2 = bVar.scene;
            String str = bVar.fDs;
            int i3 = bVar.hPq;
            eVar.fRM = str;
            eVar.scene = i2;
            eVar.fDw = false;
            eVar.mde = i3;
            eVar.rWl = false;
            eVar.rWk = false;
            com.tencent.mm.as.a lVar = !n.Iz() ? vO(bVar.scene) ? new com.tencent.mm.modelappbrand.l(bVar) : new f(bVar) : new f(bVar);
            lVar.hPg = bVar.fRO;
            aVar.rVH = lVar;
            ap.vd().a(aVar.rVH.getType(), aVar.rVG);
            ap.vd().a(aVar.rVH, 0);
            w.i("MicroMsg.FTS.FTSWebSearchLogic", "doScene(type : %s)", new Object[]{Integer.valueOf(aVar.rVH.getType())});
        }
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.FTS.FTSWebSearchLogic";
        String str3 = "onSceneEnd(type : %s), errType : %s, errCode : %s, errMsg : %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Integer.valueOf(kVar != null ? kVar.getType() : 0);
        w.v(str2, str3, objArr);
        if (kVar instanceof com.tencent.mm.as.a) {
            ap.vd().b(kVar.getType(), this);
            com.tencent.mm.as.a aVar = (com.tencent.mm.as.a) kVar;
            if (i == 0 && i2 == 0) {
                boolean z;
                str2 = aVar.AS();
                int AT = aVar.AT();
                w.i("MicroMsg.FTS.FTSWebSearchLogic", "callback %s", new Object[]{aVar.hPh});
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g wH = h.wH(aVar.hPg);
                if (aVar.wa == 0) {
                    z = true;
                } else {
                    z = false;
                }
                wH.aA(str2, z);
                if (AT > 0) {
                    w.i("MicroMsg.FTS.FTSWebSearchLogic", "updateCode %d, need update", new Object[]{Integer.valueOf(AT)});
                    com.tencent.mm.pluginsdk.k.a.b.b bVar = com.tencent.mm.pluginsdk.k.a.b.b.c.sFE;
                    w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, resType = %d", new Object[]{Integer.valueOf(27)});
                    com.tencent.mm.kernel.h.vG();
                    z = com.tencent.mm.kernel.a.uU();
                    boolean equals = ao.hlW.A("login_user_name", "").equals("");
                    if (z || !equals) {
                        com.tencent.mm.kernel.h.vH().gXC.a(new m(27), 0);
                        return;
                    } else {
                        w.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "doCheck, not login, skip");
                        return;
                    }
                }
                return;
            }
            w.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{aVar.hPh});
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret", 0);
            } catch (JSONException e) {
            }
            h.wH(aVar.hPg).aA(jSONObject.toString(), true);
        } else if (kVar instanceof com.tencent.mm.as.b) {
            ap.vd().b(kVar.getType(), this);
            com.tencent.mm.as.b bVar2 = (com.tencent.mm.as.b) kVar;
            if (i == 0 && i2 == 0) {
                h.wH(bVar2.hPg).Kb(bVar2.AS());
                return;
            }
            w.i("MicroMsg.FTS.FTSWebSearchLogic", "net scene fail %s", new Object[]{bVar2.hPj});
            h.wH(bVar2.hPg).Kb("{}");
        }
    }

    public final boolean M(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebSearchLogic", "getSuggestionData %s", new Object[]{map});
        com.tencent.mm.as.d.b bVar = new com.tencent.mm.as.d.b();
        bVar.fDs = e.o(map, "query");
        try {
            bVar.fDs = URLDecoder.decode(bVar.fDs, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        bVar.hPq = e.c(map, Columns.TYPE, 0);
        bVar.scene = e.c(map, "scene", 3);
        bVar.hPp = e.q(map, "isHomePage") ? 1 : 0;
        bVar.fRO = bg.n(map.get("webview_instance_id"), -1);
        bVar.hPy.add(e.o(map, "prefixQuery"));
        int c = e.c(map, "requestType", 0);
        bVar.hPr = e.c(map, "subtype", 0);
        w.i("MicroMsg.FTS.FTSWebSearchLogic", "getSearchData, webviewID = %d", new Object[]{Integer.valueOf(bVar.fRO)});
        if (n.Iz()) {
            bVar.hPF = e.c(map, "isWeAppMore", 0);
            if (bVar.hPF == 1) {
                bVar.hPG = new bqr();
                com.tencent.mm.sdk.b.b hoVar = new ho();
                com.tencent.mm.sdk.b.a.urY.m(hoVar);
                bVar.hPG.uoF = hoVar.fNc.fNd;
                bVar.hPG.uoI = com.tencent.mm.modelappbrand.b.hpR;
                bVar.hPG.uoG = e.c(map, "subType", 0);
                bVar.hPG.uoH = com.tencent.mm.modelappbrand.b.hpQ;
                ap.yY();
                Object obj = c.vr().get(com.tencent.mm.storage.w.a.uFX, null);
                if (obj != null && (obj instanceof String)) {
                    bVar.hPG.uoJ = (String) obj;
                }
            }
        }
        switch (c) {
            case 0:
                b bVar2 = this.rVF;
                if (bVar2.rVI != null) {
                    ap.vd().b(bVar2.rVI.getType(), bVar2.rVG);
                    ap.vd().c(bVar2.rVI);
                    bVar2.rVI = null;
                }
                if (bVar2.rVI == null) {
                    com.tencent.mm.as.b mVar = !n.Iz() ? vO(bVar.scene) ? new com.tencent.mm.modelappbrand.m(bVar.fDs, bVar.scene, bVar.fRO) : new h(bVar) : new h(bVar);
                    bVar2.rVI = mVar;
                    ap.vd().a(bVar2.rVI.getType(), bVar2.rVG);
                    ap.vd().a(bVar2.rVI, 0);
                    break;
                }
                break;
            case 1:
                String str = bVar.fDs;
                int i = bVar.hPq;
                int i2 = bVar.fRO;
                if (!bg.mA(str)) {
                    int[] iArr;
                    if (this.mah != null) {
                        ((l) com.tencent.mm.kernel.h.j(l.class)).cancelSearchTask(this.mah);
                        this.mah = null;
                    }
                    switch (i) {
                        case 8:
                            iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
                            break;
                        default:
                            iArr = null;
                            break;
                    }
                    if (iArr != null) {
                        com.tencent.mm.plugin.fts.a.a.f fVar = new com.tencent.mm.plugin.fts.a.a.f();
                        fVar.lZZ = 16;
                        fVar.fRM = str;
                        fVar.maa = iArr;
                        fVar.mad = 5;
                        fVar.maf = com.tencent.mm.plugin.fts.a.b.b.maC;
                        fVar.mae = new HashSet();
                        fVar.mag = this.osJ;
                        this.mah = ((l) com.tencent.mm.kernel.h.j(l.class)).search(2, fVar);
                        this.mah.lZK = Integer.valueOf(i2);
                        break;
                    }
                }
                break;
            case 2:
                h.wH(bVar.fRO).Kb(com.tencent.mm.as.e.Ip());
                break;
        }
        return false;
    }
}
