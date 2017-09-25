package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class g extends k {
    public b gUA;
    public e gUD;
    public int rED = 0;
    public String rEE = "";
    public int rEF = 0;
    public String rEG = "";
    public int rEH = 0;
    public String wDY = "";
    public String wDZ = "";
    public String wEa = "";
    public boolean wEb = false;
    protected String wEc;
    public boolean wEd = false;
    private Map<String, String> wEe = new HashMap();

    public abstract String HP(String str);

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract void a(b bVar, avw com_tencent_mm_protocal_c_avw);

    public abstract void b(b bVar, avw com_tencent_mm_protocal_c_avw);

    public abstract int bti();

    public abstract l c(b bVar);

    public abstract void y(boolean z, boolean z2);

    public void a(c cVar, JSONObject jSONObject) {
    }

    public final void al(Map<String, String> map) {
        map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        if (this.wEe == null) {
            this.wEe = new HashMap();
        }
        if (this.wEe != null) {
            this.wEe.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        Object[] toArray = map.keySet().toArray();
        for (Object obj : toArray) {
            String str = (String) map.get(obj);
            if (this.wEe.containsKey(obj)) {
                this.wEe.remove(obj);
            }
            this.wEe.put((String) obj, str);
        }
        x(this.wEe);
    }

    public final void x(Map<String, String> map) {
        if (map == null) {
            map = new HashMap();
        }
        if (map != null) {
            map.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        this.wEe = map;
        y(true, true);
        if (map != null) {
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!bg.mA(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    b(stringBuilder, str);
                    i = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.bIu()) {
                w.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bti() + ", req = " + stringBuilder.toString() + " " + toString() + " " + bg.bJZ().toString());
            } else {
                w.d("MicroMsg.NetScenePayBase", "RQ: Cmd : " + bti() + ", req = " + stringBuilder.toString() + " " + toString());
            }
            String HP = HP(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(HP);
            a(this.gUA, new avw().bb(stringBuilder.toString().getBytes()));
        }
        w.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", new Object[]{Integer.valueOf(bti()), Integer.valueOf(getType()), toString(), this.gUA.uri});
    }

    public void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final void am(Map<String, String> map) {
        y(false, false);
        if (map != null) {
            at btK = h.btK();
            if (btK != null) {
                w.i("MicroMsg.NetScenePayBase", "location found");
                map.put("province", btK.gkB);
                if (!map.containsKey("city")) {
                    map.put("city", btK.gkC);
                }
                map.put("location_timestamp", btK.tdW);
                map.put("encrypt_key", btK.tea);
                map.put("encrypt_userinfo", btK.tdZ);
            }
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!bg.mA(str)) {
                    if (z) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    z = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.bIu()) {
                w.d("MicroMsg.NetScenePayBase", "Cmd : " + bti() + ", wxreq = " + stringBuilder.toString());
            }
            w.d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            b(this.gUA, new avw().bb(stringBuilder.toString().getBytes()));
        }
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        a(payInfo, map, map2, false);
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (payInfo == null) {
            w.e("MicroMsg.NetScenePayBase", "Cmd : " + bti() + ", payInfo is null");
            map2.put("devicename", Build.MODEL);
            am(map2);
            return;
        }
        map.put("req_key", payInfo.fJH);
        map.put("partner_id", payInfo.partnerId);
        map.put("pay_sign", payInfo.sYc);
        if (payInfo.sYj >= 0) {
            map.put("auto_deduct_flag", payInfo.sYj);
        }
        if (payInfo.fRv > 0) {
            map.put("pay_scene", payInfo.fRv);
        }
        if (payInfo.fRw >= 0) {
            map.put("bindbankscene", payInfo.fRw);
        }
        if (!bg.mA(payInfo.sYk)) {
            map.put("deduct_bank_type", payInfo.sYk);
        }
        if (!bg.mA(payInfo.sYl)) {
            map.put("deduct_bind_serial", payInfo.sYl);
        }
        if (z) {
            map.put("use_touch", "0");
        } else {
            map.put("use_touch", payInfo.sYf);
        }
        map.put("fp_identify_num", payInfo.sYg);
        if (!TextUtils.isEmpty(payInfo.fLU)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.fLU));
        }
        if (!TextUtils.isEmpty(payInfo.fLV)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.fLV));
        }
        map2.put("uuid", payInfo.mry);
        map2.put("appid", payInfo.appId);
        map2.put("appsource", payInfo.rPJ);
        map2.put("channel", payInfo.fRr);
        map2.put("devicename", Build.MODEL);
        map2.put("soter_req", payInfo.fRe);
    }

    public final void d(int i, int i2, String str, p pVar) {
        String str2;
        int i3;
        JSONObject jSONObject;
        String optString;
        JSONObject jSONObject2;
        Exception e;
        c cVar;
        Map q;
        Exception exception;
        if (r.ijQ && 1686 == bti()) {
            i = 3;
            i2 = -1;
        }
        w.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", new Object[]{Integer.valueOf(getType()), Integer.valueOf(pVar.getType()), pVar.getUri(), Integer.valueOf(bti()), Integer.valueOf(i), Integer.valueOf(i2), str, toString()});
        l c = c((b) pVar);
        int i4 = c.tKo;
        String str3 = c.tKp;
        int i5 = c.wEg;
        String str4 = c.leS;
        String string = ab.getContext().getString(R.l.ffj);
        JSONObject jSONObject3 = null;
        String b = n.b(c.tKn);
        if (bg.mA(b)) {
            w.w("MicroMsg.NetScenePayBase", "hy: respString is null");
            b = str4;
            str2 = string;
            i3 = -10088;
        } else {
            try {
                jSONObject = new JSONObject(b);
                try {
                    this.wEc = jSONObject.optString("error_detail_url");
                    int i6 = jSONObject.getInt("retcode");
                    optString = jSONObject.optString("retmsg");
                    try {
                        this.wDY = jSONObject.optString("pay_flag");
                        this.wDZ = jSONObject.optString("return_url");
                        this.wEa = jSONObject.optString("wappay_jumped_url");
                        this.rED = jSONObject.optInt("is_gen_cert");
                        this.rEE = jSONObject.optString("crt_token");
                        this.rEF = jSONObject.optInt("is_hint_crt");
                        JSONObject optJSONObject = jSONObject.optJSONObject("crt_wording");
                        if (optJSONObject != null) {
                            this.rEG = optJSONObject.toString();
                        } else {
                            this.rEG = "";
                        }
                        this.rEH = jSONObject.optInt("is_ignore_crt");
                        if (jSONObject.optInt("del_cert", 0) != 0) {
                            q.ccj();
                            w.i("MicroMsg.NetScenePayBase", "clean token %s", new Object[]{q.cci()});
                            q.ccj().UF(string);
                        }
                        this.wEd = true;
                        i3 = i6;
                        b = str4;
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                    } catch (Exception e2) {
                        e = e2;
                        w.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                        i3 = -10089;
                        b = ab.getContext().getString(R.l.fgk);
                        jSONObject2 = jSONObject;
                        str2 = optString;
                        jSONObject3 = jSONObject2;
                        if (com.tencent.mm.sdk.a.b.bIu()) {
                            w.i("MicroMsg.NetScenePayBase", "RP:hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bti()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                        }
                        cVar = new c(i, i2, str);
                        if (i == 0) {
                        }
                        w.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                        q = bh.q(str, "e");
                        if (q == null) {
                            if (i2 != -1) {
                            }
                            w.w("MicroMsg.NetScenePayBase", "hy: network error");
                            cVar.fPf = ab.getContext().getString(R.l.fgK);
                        } else {
                            w.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                            cVar.fPf = (String) q.get(".e.Content");
                        }
                        if (jSONObject3 != null) {
                            w.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                        } else {
                            if (cVar.errType == 0) {
                            }
                            w.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                        }
                        a(cVar, jSONObject3);
                        if (this.wEb) {
                            w.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                        } else {
                            this.gUD.a(cVar.errType, cVar.errCode, cVar.fPf, this);
                        }
                    }
                } catch (Exception e3) {
                    exception = e3;
                    optString = string;
                    e = exception;
                    w.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                    i3 = -10089;
                    b = ab.getContext().getString(R.l.fgk);
                    jSONObject2 = jSONObject;
                    str2 = optString;
                    jSONObject3 = jSONObject2;
                    if (com.tencent.mm.sdk.a.b.bIu()) {
                        w.i("MicroMsg.NetScenePayBase", "RP:hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bti()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                    }
                    cVar = new c(i, i2, str);
                    if (i == 0) {
                    }
                    w.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                    q = bh.q(str, "e");
                    if (q == null) {
                        w.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                        cVar.fPf = (String) q.get(".e.Content");
                    } else {
                        if (i2 != -1) {
                        }
                        w.w("MicroMsg.NetScenePayBase", "hy: network error");
                        cVar.fPf = ab.getContext().getString(R.l.fgK);
                    }
                    if (jSONObject3 != null) {
                        if (cVar.errType == 0) {
                        }
                        w.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                    } else {
                        w.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                    }
                    a(cVar, jSONObject3);
                    if (this.wEb) {
                        w.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                    } else {
                        this.gUD.a(cVar.errType, cVar.errCode, cVar.fPf, this);
                    }
                }
            } catch (Exception e4) {
                exception = e4;
                jSONObject = null;
                optString = string;
                e = exception;
                w.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                i3 = -10089;
                b = ab.getContext().getString(R.l.fgk);
                jSONObject2 = jSONObject;
                str2 = optString;
                jSONObject3 = jSONObject2;
                if (com.tencent.mm.sdk.a.b.bIu()) {
                    w.i("MicroMsg.NetScenePayBase", "RP:hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bti()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
                }
                cVar = new c(i, i2, str);
                if (i == 0) {
                }
                w.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
                q = bh.q(str, "e");
                if (q == null) {
                    if (i2 != -1) {
                    }
                    w.w("MicroMsg.NetScenePayBase", "hy: network error");
                    cVar.fPf = ab.getContext().getString(R.l.fgK);
                } else {
                    w.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                    cVar.fPf = (String) q.get(".e.Content");
                }
                if (jSONObject3 != null) {
                    w.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
                } else {
                    if (cVar.errType == 0) {
                    }
                    w.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
                }
                a(cVar, jSONObject3);
                if (this.wEb) {
                    this.gUD.a(cVar.errType, cVar.errCode, cVar.fPf, this);
                } else {
                    w.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
                }
            }
        }
        if (com.tencent.mm.sdk.a.b.bIu()) {
            w.i("MicroMsg.NetScenePayBase", "RP:hy: FOR UNIT TEST: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(bti()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i4), str3, Integer.valueOf(i5), b, Integer.valueOf(i3), str2, jSONObject3, toString()});
        }
        cVar = new c(i, i2, str);
        if (i == 0 || i2 != 0) {
            w.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            q = bh.q(str, "e");
            if (q == null) {
                w.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                cVar.fPf = (String) q.get(".e.Content");
            } else if (i2 != -1 || i2 == -500) {
                w.w("MicroMsg.NetScenePayBase", "hy: network error");
                cVar.fPf = ab.getContext().getString(R.l.fgK);
            } else {
                w.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                cVar.fPf = ab.getContext().getString(R.l.ffj);
            }
        } else if (i4 != 0) {
            w.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            cVar.c(1000, i4, str3, 1);
        } else if (i5 != 0) {
            w.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            cVar.c(1000, i5, b, 2);
        } else if (i3 != 0) {
            w.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i3 == -10089 || i3 == -10088) {
                cVar.c(1000, 2, str2, 2);
            } else {
                cVar.c(1000, i3, str2, 2);
            }
        } else {
            w.i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (jSONObject3 != null) {
            w.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((cVar.errType == 0 || cVar.errCode != 0) && !aXd()) {
            w.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        } else {
            a(cVar.errCode, cVar.fPf, jSONObject3);
        }
        a(cVar, jSONObject3);
        if (this.wEb) {
            w.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.gUD.a(cVar.errType, cVar.errCode, cVar.fPf, this);
        }
    }

    public String aQZ() {
        return null;
    }

    public boolean aXd() {
        return false;
    }

    public boolean aQi() {
        this.hsE = bg.NA();
        this.hsF = -1;
        this.aIo = -99;
        return false;
    }

    public final int aHY() {
        return bti();
    }

    public final String cbX() {
        return this.wEc;
    }

    public boolean aQj() {
        return true;
    }
}
