package com.tencent.mm.plugin.recharge.model;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.l;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class f extends k implements j {
    public String appId;
    public int cmdId;
    public String desc;
    public int errCode;
    public String fPf;
    private b gUA;
    private e gUD;
    public boolean oLo;
    public ArrayList<m> oLp;
    public ArrayList<m> oLq;
    public d oLr;
    public d oLs;
    public d oLt;
    public d oLu;
    public d oLv;
    public l oLw;
    public List<a> oLx;
    public boolean oLy;
    public String ota;

    public f(String str) {
        this(str, 0);
    }

    public f(String str, int i) {
        this.ota = "";
        this.appId = "";
        this.oLo = false;
        this.desc = "";
        this.errCode = 0;
        this.fPf = "";
        this.oLy = false;
        this.ota = str;
        a aVar = new a();
        aVar.hsm = new apg();
        aVar.hsn = new aph();
        aVar.uri = "/cgi-bin/mmpay-bin/paychargeproxy";
        aVar.hsl = 1571;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        apg com_tencent_mm_protocal_c_apg = (apg) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_apg.tsa = i;
        this.cmdId = i;
        w.i("MicroMsg.NetScenePayChargeProxy", "cmdId: %d", new Object[]{Integer.valueOf(i)});
        if (!bg.mA(this.ota)) {
            w.i("MicroMsg.NetScenePayChargeProxy", "hy: requesting phone num: %s", new Object[]{this.ota});
            com_tencent_mm_protocal_c_apg.tUo = String.format("phone=%s", new Object[]{this.ota});
        }
    }

    public final int getType() {
        return 1571;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetScenePayChargeProxy", "hy: NetScenePayChargeProxy end: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.errCode = i3;
        if (i2 == 0 && i3 == 0) {
            try {
                int i4;
                String optString;
                String optString2;
                JSONArray optJSONArray;
                JSONObject optJSONObject;
                String optString3;
                JSONObject jSONObject = new JSONObject(((aph) ((b) pVar).hsk.hsr).tUp);
                w.d("MicroMsg.NetScenePayChargeProxy", "tofutest: json: %s", new Object[]{jSONObject.toString()});
                this.appId = jSONObject.optString("appId");
                this.errCode = jSONObject.optInt("errCode", -1);
                this.fPf = jSONObject.optString("errMsg", ab.getContext().getString(R.l.fgk));
                if (this.errCode < 0) {
                    this.oLo = true;
                } else {
                    this.oLo = false;
                }
                this.desc = jSONObject.optString("desc");
                JSONArray optJSONArray2 = jSONObject.optJSONArray("productList");
                if (optJSONArray2 != null) {
                    this.oLp = new ArrayList();
                    this.oLq = new ArrayList();
                    for (i4 = 0; i4 < optJSONArray2.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray2.getJSONObject(i4);
                        m mVar = new m();
                        mVar.desc = jSONObject2.optString("desc", "");
                        mVar.id = jSONObject2.optString(SlookAirButtonFrequentContactAdapter.ID, "");
                        mVar.name = jSONObject2.optString("name", "");
                        mVar.status = jSONObject2.optInt(DownloadInfo.STATUS, 0);
                        mVar.url = jSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL, "");
                        mVar.type = jSONObject2.optInt(Columns.TYPE);
                        mVar.ryh = jSONObject2.optString("typeName");
                        mVar.ryj = jSONObject2.optString("isColor", "0");
                        mVar.ryk = jSONObject2.optString("colorCode", "0");
                        if (mVar.type == 1) {
                            this.oLp.add(mVar);
                        } else {
                            mVar.ryi = jSONObject2.optString("productAttr");
                            this.oLq.add(mVar);
                        }
                    }
                } else {
                    this.oLp = null;
                    this.oLq = null;
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("weSim");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bg.mA(optString) || bg.mA(optString2)) {
                        w.w("MicroMsg.NetScenePayChargeProxy", "tf: weSim is missing");
                        this.oLu = null;
                    } else {
                        this.oLu = new d();
                        this.oLu.url = optString;
                        this.oLu.name = optString2;
                    }
                }
                optJSONObject2 = jSONObject.optJSONObject("wxRemind");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bg.mA(optString) || bg.mA(optString2)) {
                        w.w("MicroMsg.NetScenePayChargeProxy", "hy: remind unicom unnecessary element missing");
                    } else {
                        this.oLr = new d();
                        this.oLr.url = optString;
                        this.oLr.name = optString2;
                        optJSONObject2 = jSONObject.optJSONObject("wxCard");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (!bg.mA(optString) || bg.mA(optString2)) {
                                w.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                            } else {
                                this.oLs = new d();
                                this.oLs.url = optString;
                                this.oLs.name = optString2;
                                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    optString2 = optJSONObject2.optString("name");
                                    if (!bg.mA(optString) || bg.mA(optString2)) {
                                        w.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                                    } else {
                                        this.oLt = new d();
                                        this.oLt.url = optString;
                                        this.oLt.name = optString2;
                                        optJSONObject2 = jSONObject.optJSONObject("banner");
                                        if (optJSONObject2 == null) {
                                            this.oLw = new l();
                                            this.oLw.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                            this.oLw.name = optJSONObject2.optString("name");
                                            this.oLw.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                        } else {
                                            this.oLw = null;
                                        }
                                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                        if (optJSONObject2 != null) {
                                            optString = optJSONObject2.optString("name");
                                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                            if (!bg.mA(optString) || bg.mA(optString2)) {
                                                w.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                            } else {
                                                this.oLv = new d();
                                                this.oLv.name = optString;
                                                this.oLv.url = optString2;
                                                optJSONArray = jSONObject.optJSONArray("numberList");
                                                if (optJSONArray != null) {
                                                    if (bg.mA(this.ota)) {
                                                        this.oLy = true;
                                                    }
                                                    if (optJSONArray.length() <= 0) {
                                                        w.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                        this.oLx = null;
                                                    } else {
                                                        this.oLx = new ArrayList();
                                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                                            if (optJSONObject != null) {
                                                                optString3 = optJSONObject.optString("number");
                                                                optString = optJSONObject.optString("desc");
                                                                if (!bg.mA(optString3)) {
                                                                    this.oLx.add(new a(optString3, "", optString, 2));
                                                                }
                                                            }
                                                        }
                                                        w.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.oLx.size())});
                                                    }
                                                } else {
                                                    this.oLx = null;
                                                    w.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                                }
                                            }
                                        }
                                        this.oLv = null;
                                        optJSONArray = jSONObject.optJSONArray("numberList");
                                        if (optJSONArray != null) {
                                            this.oLx = null;
                                            w.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                        } else {
                                            if (bg.mA(this.ota)) {
                                                this.oLy = true;
                                            }
                                            if (optJSONArray.length() <= 0) {
                                                this.oLx = new ArrayList();
                                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                                    if (optJSONObject != null) {
                                                        optString3 = optJSONObject.optString("number");
                                                        optString = optJSONObject.optString("desc");
                                                        if (!bg.mA(optString3)) {
                                                            this.oLx.add(new a(optString3, "", optString, 2));
                                                        }
                                                    }
                                                }
                                                w.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.oLx.size())});
                                            } else {
                                                w.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                                this.oLx = null;
                                            }
                                        }
                                    }
                                }
                                this.oLt = null;
                                optJSONObject2 = jSONObject.optJSONObject("banner");
                                if (optJSONObject2 == null) {
                                    this.oLw = null;
                                } else {
                                    this.oLw = new l();
                                    this.oLw.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                                    this.oLw.name = optJSONObject2.optString("name");
                                    this.oLw.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                }
                                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                                if (optJSONObject2 != null) {
                                    optString = optJSONObject2.optString("name");
                                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                                    if (bg.mA(optString)) {
                                    }
                                    w.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                                }
                                this.oLv = null;
                                optJSONArray = jSONObject.optJSONArray("numberList");
                                if (optJSONArray != null) {
                                    if (bg.mA(this.ota)) {
                                        this.oLy = true;
                                    }
                                    if (optJSONArray.length() <= 0) {
                                        w.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                        this.oLx = null;
                                    } else {
                                        this.oLx = new ArrayList();
                                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                            optJSONObject = optJSONArray.optJSONObject(i4);
                                            if (optJSONObject != null) {
                                                optString3 = optJSONObject.optString("number");
                                                optString = optJSONObject.optString("desc");
                                                if (!bg.mA(optString3)) {
                                                    this.oLx.add(new a(optString3, "", optString, 2));
                                                }
                                            }
                                        }
                                        w.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.oLx.size())});
                                    }
                                } else {
                                    this.oLx = null;
                                    w.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                                }
                            }
                        }
                        this.oLs = null;
                        optJSONObject2 = jSONObject.optJSONObject("wxWt");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            optString2 = optJSONObject2.optString("name");
                            if (bg.mA(optString)) {
                            }
                            w.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                        }
                        this.oLt = null;
                        optJSONObject2 = jSONObject.optJSONObject("banner");
                        if (optJSONObject2 == null) {
                            this.oLw = new l();
                            this.oLw.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                            this.oLw.name = optJSONObject2.optString("name");
                            this.oLw.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                        } else {
                            this.oLw = null;
                        }
                        optJSONObject2 = jSONObject.optJSONObject("headEnter");
                        if (optJSONObject2 != null) {
                            optString = optJSONObject2.optString("name");
                            optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                            if (bg.mA(optString)) {
                            }
                            w.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                        }
                        this.oLv = null;
                        optJSONArray = jSONObject.optJSONArray("numberList");
                        if (optJSONArray != null) {
                            this.oLx = null;
                            w.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                        } else {
                            if (bg.mA(this.ota)) {
                                this.oLy = true;
                            }
                            if (optJSONArray.length() <= 0) {
                                this.oLx = new ArrayList();
                                for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    optJSONObject = optJSONArray.optJSONObject(i4);
                                    if (optJSONObject != null) {
                                        optString3 = optJSONObject.optString("number");
                                        optString = optJSONObject.optString("desc");
                                        if (!bg.mA(optString3)) {
                                            this.oLx.add(new a(optString3, "", optString, 2));
                                        }
                                    }
                                }
                                w.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.oLx.size())});
                            } else {
                                w.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                                this.oLx = null;
                            }
                        }
                    }
                }
                this.oLr = null;
                optJSONObject2 = jSONObject.optJSONObject("wxCard");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bg.mA(optString)) {
                    }
                    w.w("MicroMsg.NetScenePayChargeProxy", "hy: phone card necessary element missing");
                }
                this.oLs = null;
                optJSONObject2 = jSONObject.optJSONObject("wxWt");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    optString2 = optJSONObject2.optString("name");
                    if (bg.mA(optString)) {
                    }
                    w.w("MicroMsg.NetScenePayChargeProxy", "hy: phone hall necessary element missing");
                }
                this.oLt = null;
                optJSONObject2 = jSONObject.optJSONObject("banner");
                if (optJSONObject2 == null) {
                    this.oLw = null;
                } else {
                    this.oLw = new l();
                    this.oLw.id = optJSONObject2.getInt(SlookAirButtonFrequentContactAdapter.ID);
                    this.oLw.name = optJSONObject2.optString("name");
                    this.oLw.url = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                }
                optJSONObject2 = jSONObject.optJSONObject("headEnter");
                if (optJSONObject2 != null) {
                    optString = optJSONObject2.optString("name");
                    optString2 = optJSONObject2.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (bg.mA(optString)) {
                    }
                    w.w("MicroMsg.NetScenePayChargeProxy", "tf: headEnter is missing");
                }
                this.oLv = null;
                optJSONArray = jSONObject.optJSONArray("numberList");
                if (optJSONArray != null) {
                    if (bg.mA(this.ota)) {
                        this.oLy = true;
                    }
                    if (optJSONArray.length() <= 0) {
                        w.w("MicroMsg.NetScenePayChargeProxy", "number length is short! %s", new Object[]{Integer.valueOf(optJSONArray.length())});
                        this.oLx = null;
                    } else {
                        this.oLx = new ArrayList();
                        for (i4 = 0; i4 < optJSONArray.length(); i4++) {
                            optJSONObject = optJSONArray.optJSONObject(i4);
                            if (optJSONObject != null) {
                                optString3 = optJSONObject.optString("number");
                                optString = optJSONObject.optString("desc");
                                if (!bg.mA(optString3)) {
                                    this.oLx.add(new a(optString3, "", optString, 2));
                                }
                            }
                        }
                        w.i("MicroMsg.NetScenePayChargeProxy", "number list: %s", new Object[]{Integer.valueOf(this.oLx.size())});
                    }
                } else {
                    this.oLx = null;
                    w.w("MicroMsg.NetScenePayChargeProxy", "empty numberList");
                }
            } catch (Exception e) {
                w.e("MicroMsg.NetScenePayChargeProxy", "hy: exception occurred when parsing json: %s", new Object[]{e.toString()});
                this.oLo = true;
                this.fPf = ab.getContext().getString(R.l.fgk);
            }
        } else {
            this.oLo = true;
            if (bg.mA(str)) {
                str = ab.getContext().getString(R.l.ffj);
            }
            this.fPf = str;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
