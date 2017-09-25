package com.tencent.mm.plugin.sport.c;

import android.os.RemoteException;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.sport.PluginSport;
import com.tencent.mm.protocal.c.bna;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONObject;

public final class f {
    public static e htR = new e() {
        public final void a(int i, int i2, String str, k kVar) {
            if (kVar instanceof d) {
                h.vd().b(1947, f.htR);
                if (i == 0 && i2 == 0) {
                    bna com_tencent_mm_protocal_c_bna = ((d) kVar).qRv;
                    w.i("MicroMsg.Sport.SportConfigLogic", "onSceneEnd config=%s", new Object[]{com_tencent_mm_protocal_c_bna.tfJ});
                    String str2 = com_tencent_mm_protocal_c_bna.tfJ;
                    if (ab.bJb()) {
                        ((PluginSport) h.j(PluginSport.class)).getSportFileStorage().setString(2, str2);
                        f.Hi(com_tencent_mm_protocal_c_bna.tfJ);
                        com.tencent.mm.plugin.sport.a.a aVar = ((PluginSport) h.j(PluginSport.class)).getDeviceStepManager().qRo;
                        if (aVar != null) {
                            try {
                                aVar.Hh(com_tencent_mm_protocal_c_bna.tfJ);
                            } catch (RemoteException e) {
                            }
                        }
                        if (f.qRz != null) {
                            f.qRz.bmh();
                            return;
                        }
                        return;
                    }
                    throw new RuntimeException(String.format("not support set value in %s process", new Object[]{ab.um()}));
                }
            }
        }
    };
    private static long qRx;
    private static JSONObject qRy;
    public static a qRz;

    public interface a {
        void bmh();
    }

    public static boolean bmu() {
        if (qRx == 0) {
            qRx = h.F(1, 0);
        }
        if (System.currentTimeMillis() - qRx > 86400000) {
            qRx = System.currentTimeMillis();
            h.G(1, qRx);
            w.i("MicroMsg.Sport.SportConfigLogic", "start to request sport config");
            h.vd().a(1947, htR);
            h.vd().a(new d(), 0);
            return true;
        }
        w.i("MicroMsg.Sport.SportConfigLogic", "last request time is %s", new Object[]{k.aq(qRx)});
        return false;
    }

    public static void Hi(String str) {
        if (!bg.mA(str)) {
            try {
                qRy = new JSONObject(str);
            } catch (Exception e) {
                qRy = null;
            }
        }
    }

    public static JSONObject bmv() {
        if (qRy == null) {
            String str = "";
            String string = ab.bJb() ? ((PluginSport) h.j(PluginSport.class)).getSportFileStorage().getString(2, str) : new g(com.tencent.mm.plugin.sport.b.a.qRj).getString(2, str);
            str = "";
            if (!bg.mA(string)) {
                try {
                    qRy = new JSONObject(string);
                    string = "server config";
                } catch (Exception e) {
                }
                if (qRy == null) {
                    qRy = bmw();
                    string = "asset";
                }
                if (qRy == null) {
                    qRy = new JSONObject();
                    string = "new";
                }
                w.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{string, qRy.toString()});
            }
            string = str;
            if (qRy == null) {
                qRy = bmw();
                string = "asset";
            }
            if (qRy == null) {
                qRy = new JSONObject();
                string = "new";
            }
            w.i("MicroMsg.Sport.SportConfigLogic", "get sport config from %s: %s", new Object[]{string, qRy.toString()});
        }
        return qRy;
    }

    private static JSONObject bmw() {
        JSONObject jSONObject;
        InputStream inputStream = null;
        try {
            inputStream = ab.getContext().getAssets().open("sport_config.json");
            jSONObject = new JSONObject(new String(b.c(inputStream)));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Sport.SportConfigLogic", e2, "get assets sport config json", new Object[0]);
            jSONObject = new JSONObject();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e4) {
                }
            }
        }
        return jSONObject;
    }

    public static void a(a aVar) {
        qRz = aVar;
    }
}
