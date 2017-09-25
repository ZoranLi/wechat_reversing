package com.tencent.mm.plugin.webview.c;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.fj;
import com.tencent.mm.e.a.oy;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c implements a {
    public com.tencent.mm.sdk.b.c pRm = new com.tencent.mm.sdk.b.c<oy>(this) {
        final /* synthetic */ c rVQ;

        {
            this.rVQ = r2;
            this.usg = oy.class.getName().hashCode();
        }

        private boolean a(oy oyVar) {
            if ((oyVar instanceof oy) && oyVar.fVU.fEG == 2) {
                w.i("MicroMsg.FTS.FTSWebViewImageLogic", "Download callback %s", new Object[]{oyVar.fVU.mediaId});
                if (this.rVQ.rVK.containsKey(oyVar.fVU.mediaId)) {
                    synchronized (this.rVQ.rVK) {
                        int intValue = ((Integer) this.rVQ.rVN.get(oyVar.fVU.mediaId)).intValue();
                        HashSet hashSet = (HashSet) this.rVQ.rVK.get(oyVar.fVU.mediaId);
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String str2 = "weixin://fts/sns?path=" + oyVar.fVU.path;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str);
                                jSONObject.put("src", str2);
                            } catch (JSONException e) {
                            }
                            jSONArray.put(jSONObject);
                        }
                        h.wH(intValue).Kj(jSONArray.toString());
                        this.rVQ.rVK.remove(oyVar.fVU.mediaId);
                        this.rVQ.rVN.remove(oyVar.fVU.mediaId);
                    }
                }
            }
            return false;
        }
    };
    private HashMap<String, HashSet<String>> rVJ = new HashMap();
    public HashMap<String, HashSet<String>> rVK = new HashMap();
    public HashMap<String, HashSet<String>> rVL = new HashMap();
    private HashMap<String, Integer> rVM = new HashMap();
    public HashMap<String, Integer> rVN = new HashMap();
    public HashMap<String, Integer> rVO = new HashMap();
    public com.tencent.mm.sdk.b.c<fj> rVP = new com.tencent.mm.sdk.b.c<fj>(this) {
        final /* synthetic */ c rVQ;

        {
            this.rVQ = r2;
            this.usg = fj.class.getName().hashCode();
        }

        private boolean a(fj fjVar) {
            if (fjVar.fJV.fEG == 2) {
                w.i("MicroMsg.FTS.FTSWebViewImageLogic", "Emoji Download callback %s", new Object[]{fjVar.fJV.fFW});
                if (this.rVQ.rVL.containsKey(fjVar.fJV.fFW)) {
                    synchronized (this.rVQ.rVL) {
                        int intValue = ((Integer) this.rVQ.rVO.get(fjVar.fJV.fFW)).intValue();
                        HashSet hashSet = (HashSet) this.rVQ.rVL.get(fjVar.fJV.fFW);
                        JSONArray jSONArray = new JSONArray();
                        Iterator it = hashSet.iterator();
                        while (it.hasNext()) {
                            String str = (String) it.next();
                            String str2 = "weixin://fts/emoji?path=" + fjVar.fJW.path;
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str);
                                jSONObject.put("src", str2);
                            } catch (JSONException e) {
                            }
                            jSONArray.put(jSONObject);
                        }
                        h.wH(intValue).Kj(jSONArray.toString());
                        this.rVQ.rVL.remove(fjVar.fJV.fFW);
                        this.rVQ.rVO.remove(fjVar.fJV.fFW);
                    }
                }
            }
            return false;
        }
    };

    public c() {
        this.pRm.bIy();
        this.rVP.bIy();
        n.Bm().c(this);
    }

    public final boolean N(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchAvatarList");
        String o = e.o(map, SlookAirButtonFrequentContactAdapter.DATA);
        int n = bg.n(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(o);
            JSONArray jSONArray2 = new JSONArray();
            int i = 0;
            Object obj = null;
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                String string2 = jSONObject.getString("userName");
                int i2 = jSONObject.getInt(Columns.TYPE);
                Object string3 = jSONObject.getString("imageUrl");
                String string4 = jSONObject.getString("bigImageUrl");
                switch (i2) {
                    case 1:
                    case 4:
                    case 64:
                        break;
                    case 32:
                        com.tencent.mm.x.h hVar = new com.tencent.mm.x.h();
                        hVar.username = string2;
                        hVar.hrB = string4;
                        hVar.hrA = string3;
                        hVar.fRW = -1;
                        hVar.gkq = 3;
                        hVar.aV(true);
                        n.Bm().a(hVar);
                        break;
                }
                n.Bl();
                o = d.r(string2, false);
                if (FileOp.aO(o)) {
                    w.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file exist %s", new Object[]{o});
                    string3 = "weixin://fts/avatar?path=" + o;
                } else {
                    w.i("MicroMsg.FTS.FTSWebViewImageLogic", "avatar file not exist %s", new Object[]{o});
                    this.rVM.put(string2, Integer.valueOf(n));
                    HashSet hashSet = (HashSet) this.rVJ.get(string2);
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(string);
                    this.rVJ.put(string2, hashSet);
                    b.bEa().bf(string2);
                    string3 = obj;
                }
                if (string3 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string);
                    jSONObject2.put("src", string3);
                    jSONArray2.put(jSONObject2);
                    string3 = null;
                }
                i++;
                obj = string3;
            }
            if (jSONArray2.length() > 0) {
                h.wH(n).Kj(jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean O(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchSnsImageList");
        String o = e.o(map, SlookAirButtonFrequentContactAdapter.DATA);
        int n = bg.n(map.get("webview_instance_id"), -1);
        try {
            JSONArray jSONArray = new JSONArray(o);
            JSONArray jSONArray2 = new JSONArray();
            Object obj = null;
            int i = 0;
            while (i < jSONArray.length()) {
                Object obj2;
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                String string2 = jSONObject.getString("objectXmlDesc");
                int i2 = jSONObject.getInt("index");
                bfc kL = ((l) com.tencent.mm.kernel.h.h(l.class)).kL(string2);
                if (kL.ufB.tsO.size() > i2) {
                    alh com_tencent_mm_protocal_c_alh = (alh) kL.ufB.tsO.get(i2);
                    com.tencent.mm.sdk.b.b oyVar = new oy();
                    oyVar.fVU.fEG = 3;
                    oyVar.fVU.mediaId = com_tencent_mm_protocal_c_alh.mQY;
                    com.tencent.mm.sdk.b.a.urY.m(oyVar);
                    w.i("MicroMsg.FTS.FTSWebViewImageLogic", "generatePath: %s", new Object[]{oyVar.fVU.path});
                    if (FileOp.aO(oyVar.fVU.path)) {
                        obj2 = "weixin://fts/sns?path=" + oyVar.fVU.path;
                    } else {
                        synchronized (this.rVK) {
                            HashSet hashSet;
                            if (this.rVK.containsKey(com_tencent_mm_protocal_c_alh.mQY)) {
                                hashSet = (HashSet) this.rVK.get(com_tencent_mm_protocal_c_alh.mQY);
                            } else {
                                hashSet = new HashSet();
                            }
                            hashSet.add(string);
                            this.rVK.put(com_tencent_mm_protocal_c_alh.mQY, hashSet);
                            this.rVN.put(com_tencent_mm_protocal_c_alh.mQY, Integer.valueOf(n));
                        }
                        oyVar = new oy();
                        oyVar.fVU.fEG = 1;
                        oyVar.fVU.fVV = com_tencent_mm_protocal_c_alh;
                        com.tencent.mm.sdk.b.a.urY.m(oyVar);
                        obj2 = obj;
                    }
                    if (obj2 != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, string);
                        jSONObject2.put("src", obj2);
                        jSONArray2.put(jSONObject2);
                        obj2 = null;
                    }
                } else {
                    obj2 = obj;
                }
                i++;
                obj = obj2;
            }
            if (jSONArray2.length() > 0) {
                h.wH(n).Kj(jSONArray2.toString());
            }
        } catch (JSONException e) {
        }
        return false;
    }

    public final boolean P(Map<String, Object> map) {
        w.i("MicroMsg.FTS.FTSWebViewImageLogic", "getSearchImageList");
        int c = e.c(map, "requestType", 0);
        String o = e.o(map, SlookAirButtonFrequentContactAdapter.DATA);
        int n = bg.n(map.get("webview_instance_id"), -1);
        boolean isWifi = am.isWifi(ab.getContext());
        switch (c) {
            case 1:
                try {
                    JSONArray jSONArray = new JSONArray(o);
                    JSONArray jSONArray2 = new JSONArray();
                    int i = 0;
                    Object obj = null;
                    while (i < jSONArray.length()) {
                        Object obj2;
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        int optInt = jSONObject.optInt("emojiType");
                        String optString = jSONObject.optString(SlookAirButtonFrequentContactAdapter.ID);
                        if (optInt == 2) {
                            com.tencent.mm.sdk.b.b fjVar = new fj();
                            fjVar.fJV.fEG = 3;
                            fjVar.fJV.fFW = jSONObject.optString("md5");
                            fjVar.fJV.fJX = jSONObject.optString("designerId");
                            fjVar.fJV.aeskey = jSONObject.optString("aesKey");
                            fjVar.fJV.fJY = jSONObject.optString("encryptUrl");
                            fjVar.fJV.fGa = jSONObject.optString("productID");
                            fjVar.fJV.name = jSONObject.optString("express");
                            fjVar.fJV.thumbUrl = jSONObject.optString("imageUrl");
                            com.tencent.mm.sdk.b.a.urY.m(fjVar);
                            if (FileOp.aO(fjVar.fJW.path)) {
                                obj2 = "weixin://fts/emoji?path=" + fjVar.fJW.path;
                                w.i("MicroMsg.FTS.FTSWebViewImageLogic", "path=%s", new Object[]{fjVar.fJW.path});
                            } else if (isWifi) {
                                synchronized (this.rVL) {
                                    HashSet hashSet;
                                    if (this.rVL.containsKey(fjVar.fJV.fFW)) {
                                        hashSet = (HashSet) this.rVL.get(fjVar.fJV.fFW);
                                    } else {
                                        hashSet = new HashSet();
                                    }
                                    hashSet.add(optString);
                                    this.rVL.put(fjVar.fJV.fFW, hashSet);
                                    this.rVO.put(fjVar.fJV.fFW, Integer.valueOf(n));
                                }
                                fjVar.fJV.fEG = 1;
                                com.tencent.mm.sdk.b.a.urY.m(fjVar);
                                obj2 = obj;
                            } else {
                                obj2 = jSONObject.optString("imageUrl");
                            }
                            if (obj2 != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                                jSONObject2.put("src", obj2);
                                jSONArray2.put(jSONObject2);
                                obj2 = null;
                            }
                        } else if (optInt == 4) {
                            r9 = new JSONObject();
                            r9.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                            if (isWifi) {
                                r9.put("src", jSONObject.optString("raw"));
                            } else {
                                r9.put("src", jSONObject.optString("imageUrl"));
                            }
                            jSONArray2.put(r9);
                            obj2 = obj;
                        } else {
                            r9 = new JSONObject();
                            r9.put(SlookAirButtonFrequentContactAdapter.ID, optString);
                            r9.put("src", jSONObject.optString("imageUrl"));
                            jSONArray2.put(r9);
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                    if (jSONArray2.length() > 0) {
                        h.wH(n).Kj(jSONArray2.toString());
                        break;
                    }
                } catch (Exception e) {
                    break;
                }
                break;
            default:
                try {
                    JSONArray jSONArray3 = new JSONArray(o);
                    JSONArray jSONArray4 = new JSONArray();
                    for (c = 0; c < jSONArray3.length(); c++) {
                        JSONObject jSONObject3 = jSONArray3.getJSONObject(c);
                        JSONObject jSONObject4 = new JSONObject();
                        String string = jSONObject3.getString(SlookAirButtonFrequentContactAdapter.ID);
                        String string2 = jSONObject3.getString("imageUrl");
                        jSONObject4.put(SlookAirButtonFrequentContactAdapter.ID, string);
                        jSONObject4.put("src", string2);
                        jSONArray4.put(jSONObject4);
                    }
                    h.wH(n).Kj(jSONArray4.toString());
                    break;
                } catch (JSONException e2) {
                    break;
                }
        }
        return false;
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (lVar != null && lVar.obj != null) {
            synchronized (this.rVJ) {
                w.i("MicroMsg.FTS.FTSWebViewImageLogic", "event %s，eventData %s", new Object[]{str, lVar.toString()});
                String obj = lVar.obj.toString();
                if (this.rVJ.containsKey(obj) && this.rVM.containsKey(obj)) {
                    w.i("MicroMsg.FTS.FTSWebViewImageLogic", "notify avatar changed %s", new Object[]{obj});
                    int intValue = ((Integer) this.rVM.get(obj)).intValue();
                    HashSet hashSet = (HashSet) this.rVJ.get(obj);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str2 = (String) it.next();
                        n.Bl();
                        String str3 = "weixin://fts/avatar?path=" + d.r(obj, false);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(SlookAirButtonFrequentContactAdapter.ID, str2);
                            jSONObject.put("src", str3);
                        } catch (JSONException e) {
                        }
                        jSONArray.put(jSONObject);
                    }
                    h.wH(intValue).Kj(jSONArray.toString());
                    this.rVJ.remove(obj);
                    this.rVM.remove(obj);
                }
            }
        }
    }
}
