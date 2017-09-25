package com.tencent.mm.plugin.accountsync.a;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.k.a.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class c implements am {
    public static int hZa = 0;
    public static int irO = a.irV;
    private static aj irQ = null;
    private a irN = null;
    private com.tencent.mm.plugin.accountsync.model.a irP;
    private m irR = new m(this) {
        final /* synthetic */ c irT;

        {
            this.irT = r1;
        }

        public final void b(String str, Map<String, String> map) {
            if (bg.mz(str).equals("ChangeLaunchImage") && map != null) {
                w.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", (String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType"));
                if (!bg.D(r0, r1, r2)) {
                    int PY = bg.PY(r2);
                    if (PY > 0) {
                        SharedPreferences sharedPreferences = ab.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", bg.PZ(r0)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", PY).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", bg.PZ(r1)).commit();
                        b bVar = c.sFE;
                        c.mP(b.dF(43, PY));
                    }
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c irS = new com.tencent.mm.sdk.b.c<bb>(this) {
        final /* synthetic */ c irT;

        {
            this.irT = r2;
            this.usg = bb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bb bbVar = (bb) bVar;
            int i = ab.getContext().getSharedPreferences("system_config_prefs", 0).getInt("new_launch_image_sub_type", 0);
            if (bbVar.fEA.fEB == 43 && i > 0 && i == bbVar.fEA.fEC) {
                w.i("MicroMsg.SubCoreAccountSync", "filePath: %s", bbVar.fEA.filePath);
                c.mP(r0);
            }
            return false;
        }
    };

    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] irU = new int[a.OB().length];

        static {
            try {
                irU[a.irW - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                irU[a.irV - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                irU[a.irX - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        public static int[] OB() {
            return (int[]) irY.clone();
        }

        static {
            irV = 1;
            irW = 2;
            irX = 3;
            irY = new int[]{irV, irW, irX};
        }
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.urY.c(this.irP.isd);
        this.irP = null;
        ((n) h.j(n.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.irR);
        this.irS.dead();
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        this.irP = new com.tencent.mm.plugin.accountsync.model.a();
        ((n) h.j(n.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.irR);
        this.irS.bIy();
    }

    public final void aN(boolean z) {
    }

    public static void hj(int i) {
        irO = i;
        switch (AnonymousClass4.irU[i - 1]) {
            case 1:
                hZa = 0;
                if (irQ == null) {
                    irQ = new aj(new com.tencent.mm.sdk.platformtools.aj.a() {
                        public final boolean oQ() {
                            int i = c.hZa + 1;
                            c.hZa = i;
                            if (i == 1 || c.hZa == 16 || c.hZa % 96 == 0) {
                                ap.getNotification().qj();
                            }
                            return true;
                        }
                    }, true);
                }
                w.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                irQ.v(900000, 900000);
                return;
            case 2:
            case 3:
                if (irQ != null) {
                    irQ.KH();
                }
                w.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                irO = a.irV;
                ap.getNotification().qk();
                hZa = 0;
                irQ = null;
                return;
            default:
                return;
        }
    }

    public static void mP(String str) {
        w.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
        if (!bg.mA(str)) {
            File file = new File(str);
            if (file.exists()) {
                String str2 = e.hgq + "splashWelcomeImg";
                if (com.tencent.mm.loader.stub.b.deleteFile(str2)) {
                    com.tencent.mm.a.e.p(file.getAbsolutePath(), str2);
                }
            }
        }
    }
}
