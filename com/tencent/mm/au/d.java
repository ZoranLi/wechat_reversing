package com.tencent.mm.au;

import com.tencent.mm.a.f;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class d implements e {
    public static int chatType = 0;
    private static d hTS;
    public static final f<Integer, a> hkd = new f(5);
    private int hNR = 3;
    public boolean hpL = false;

    public static class a {
        public int gkr = 0;
        public String hTT = "BeiJing;GuangZhou;ShangHai;";
        public int hTU = 0;
        public int hTV = 2;
        public int hTW = 2;
        public int hTX = 2;
        public int hTY = 10240;
        public int hTZ = 10240000;
        public int hUa = 100;
        public int hUb = 100;
        public int hUc = 100;
        public Random hUd = new Random();
        public List<String> hUe = null;

        public final boolean JN() {
            af yr = m.yr();
            w.d("upload", new StringBuilder("  getRegionCode ").append(yr).toString() != null ? yr.gkH : "");
            String str = yr.gkH;
            if (str == null || str.length() <= 0 || this.hUe == null || this.hUe.size() <= 0) {
                return false;
            }
            String[] split = str.split("_");
            if (split == null || split.length <= 0) {
                return false;
            }
            int i = 0;
            while (i < split.length) {
                if (split[i] != null && split[i].length() > 0) {
                    for (String str2 : this.hUe) {
                        if (str2.trim().toLowerCase().equals(split[i].trim().toLowerCase())) {
                            w.d("upload", "isInRegion");
                            return true;
                        }
                    }
                    continue;
                }
                i++;
            }
            return false;
        }

        public final int JO() {
            switch (d.chatType) {
                case 0:
                    return this.hTV;
                case 1:
                    return this.hTW;
                case 2:
                    return this.hTX;
                default:
                    return this.hTV;
            }
        }

        public final int JP() {
            switch (d.chatType) {
                case 0:
                    return this.hUa;
                case 1:
                    return this.hUb;
                case 2:
                    return this.hUc;
                default:
                    return this.hUa;
            }
        }

        public static a JQ() {
            w.d("upload", "parseFromFile");
            String str = n.HY() + t.Ic().aS(1, 9);
            int aN = com.tencent.mm.a.e.aN(str);
            if (aN == -1) {
                w.e("upload", "read file failed " + aN + str);
                return null;
            }
            byte[] c = com.tencent.mm.a.e.c(str, 0, aN);
            if (c == null) {
                w.e("upload", "read file failed " + aN + str);
                return null;
            }
            str = new String(c);
            if (bg.mA(str)) {
                return null;
            }
            String substring;
            aN = str.indexOf(60);
            if (aN > 0) {
                substring = str.substring(aN);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            a aVar = (a) d.hkd.get(Integer.valueOf(hashCode));
            if (aVar != null) {
                return aVar;
            }
            Map q = bh.q(substring, "Config");
            if (q == null) {
                w.e("upload", "parse msg failed");
                return null;
            }
            try {
                a aVar2 = new a();
                int i = 0;
                while (true) {
                    str = (String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)) + ".$key");
                    w.d("upload", "key " + str);
                    if (str != null) {
                        if (str.equals("region")) {
                            aVar2.hTT = (String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i)));
                            if (aVar2.hTT != null && aVar2.hTT.length() > 0) {
                                String[] split = aVar2.hTT.split(";");
                                aVar2.hUe = new ArrayList();
                                if (split != null && split.length > 0) {
                                    int i2 = 0;
                                    while (i2 < split.length) {
                                        if (split[i2] != null && split[i2].length() > 0) {
                                            aVar2.hUe.add(split[i2]);
                                        }
                                        i2++;
                                    }
                                }
                            }
                        } else if (str.equals("sex")) {
                            r7 = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                r0 = "";
                            } else {
                                r0 = Integer.valueOf(i);
                            }
                            aVar2.gkr = bg.getInt((String) q.get(r7.append(r0).toString()), 0);
                        } else if (str.equals("rate")) {
                            r7 = new StringBuilder(".Config.Item");
                            if (i == 0) {
                                r0 = "";
                            } else {
                                r0 = Integer.valueOf(i);
                            }
                            aVar2.hTU = bg.getInt((String) q.get(r7.append(r0).toString()), 0);
                        } else if (str.equals("minsize")) {
                            aVar2.hTY = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("maxsize")) {
                            aVar2.hTZ = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_single")) {
                            aVar2.hUa = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_chatroom")) {
                            aVar2.hUb = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("daycount_app")) {
                            aVar2.hUc = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_single")) {
                            aVar2.hTV = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_chatroom")) {
                            aVar2.hTW = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        } else if (str.equals("rate_app")) {
                            aVar2.hTX = bg.getInt((String) q.get(".Config.Item" + (i == 0 ? "" : Integer.valueOf(i))), 0);
                        }
                        i++;
                    } else {
                        w.d("upload", "sex " + aVar2.gkr);
                        w.d("upload", "rate_single " + aVar2.hTV);
                        w.d("upload", "rate_chatroom " + aVar2.hTW);
                        w.d("upload", "rate_app " + aVar2.hTX);
                        w.d("upload", "rate " + aVar2.hTU);
                        w.d("upload", "minsize " + aVar2.hTY);
                        w.d("upload", "maxsize " + aVar2.hTZ);
                        w.d("upload", "daycount_single " + aVar2.hUa);
                        w.d("upload", "daycount_chatroom " + aVar2.hUb);
                        w.d("upload", "daycount_app " + aVar2.hUc);
                        w.d("upload", "region " + aVar2.hTT);
                        d.hkd.k(Integer.valueOf(hashCode), aVar2);
                        return aVar2;
                    }
                }
            } catch (Throwable e) {
                w.e("upload", "exception:%s", bg.g(e));
                return null;
            }
        }
    }

    public static final class b {
        public String hRn = "";
        public int hTK = 0;
        public int hTL = 0;
        public int sampleRate = 0;
    }

    public static String getPrefix() {
        switch (chatType) {
            case 0:
                return "single_";
            case 1:
                return "chatroom_";
            case 2:
                return "app_";
            default:
                return "single_";
        }
    }

    public static int kN(String str) {
        int i = 5;
        if (!(str == null || str.length() == 0)) {
            if (str.startsWith("single")) {
            }
            if (str.startsWith("chatroom")) {
                i = 7;
            }
            if (str.startsWith("app")) {
                i = 8;
            }
            w.d("upload", "type " + i);
        }
        return i;
    }

    public static d JK() {
        if (hTS == null) {
            hTS = new d();
        }
        return hTS;
    }

    public final void release() {
        this.hpL = false;
        h.vd().b((int) JsApiGetBackgroundAudioState.CTRL_INDEX, (e) this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof com.tencent.mm.y.m) || ((com.tencent.mm.y.m) kVar).BQ() != 9) {
            w.d("upload", "another scene");
        } else if (kVar.getType() == JsApiGetBackgroundAudioState.CTRL_INDEX) {
            if (i == 0 && i2 == 0) {
                h.vJ();
                h.vI().vr().set(81944, Long.valueOf(bg.Ny()));
            } else {
                int i3 = this.hNR - 1;
                this.hNR = i3;
                if (i3 < 0) {
                    h.vJ();
                    h.vI().vr().set(81944, Long.valueOf(((bg.Nz() - 86400000) + 3600000) / 1000));
                    this.hNR = 3;
                }
            }
            release();
        }
    }

    public static void JL() {
        h.vJ();
        h.vI().vr().set(16646145, Integer.valueOf(0));
    }

    public static void JM() {
        h.vJ();
        Integer valueOf = Integer.valueOf(bg.f((Integer) h.vI().vr().get(16646145, null)));
        if (valueOf.intValue() < 0) {
            valueOf = Integer.valueOf(0);
        }
        h.vJ();
        h.vI().vr().set(16646145, Integer.valueOf(valueOf.intValue() + 1));
    }
}
