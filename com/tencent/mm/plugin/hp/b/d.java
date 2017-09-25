package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.e.a.aw;
import com.tencent.mm.e.a.bd;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.ps;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.tinker.lib.d.a;
import java.util.HashMap;

public final class d implements am {
    private final c<aw> kOg = new c<aw>(this) {
        final /* synthetic */ d mLo;

        {
            this.mLo = r2;
            this.usg = aw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            aw awVar = (aw) bVar;
            if (this.mLo.mLi) {
                Context context = ab.getContext();
                String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_after_install", "");
                com.tencent.tinker.lib.d.d dVar = a.hp(context).xgv;
                String str = dVar == null ? "" : dVar.xgA;
                w.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isAfterInstallDialogHaveShow currentVersion :%s tinkerVersion:%s", new Object[]{string, str});
                boolean z = bg.mA(string) || bg.mA(str) || !(bg.mA(string) || bg.mA(str) || !string.equalsIgnoreCase(str));
                if (!z) {
                    str = ab.getContext().getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_msg_key", "");
                    awVar.fEp.fEq = true;
                    awVar.fEp.fEr = str;
                    if (!bg.mA(str)) {
                        a.nW(2);
                    }
                    context = ab.getContext();
                    Object string2 = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_patch_version_key", "");
                    if (!TextUtils.isEmpty(string2)) {
                        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_after_install", string2).apply();
                    }
                }
                this.mLo.mLi = false;
            }
            return false;
        }
    };
    public boolean mLi = true;
    private final h mLj = new h();
    private final c<cg> mLk = new c<cg>(this) {
        final /* synthetic */ d mLo;

        {
            this.mLo = r2;
            this.usg = cg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            g.cr(ab.getContext());
            com.tinkerboots.sdk.a.chU().El(g.cs(ab.getContext()));
            return false;
        }
    };
    private final f mLl = new f();
    private final c<bd> mLm = new c<bd>(this) {
        final /* synthetic */ d mLo;

        {
            this.mLo = r2;
            this.usg = bd.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ap.vd().a(new com.tencent.mm.plugin.hp.c.a(), 0);
            return false;
        }
    };
    private final c<ps> mLn = new c<ps>(this) {
        final /* synthetic */ d mLo;

        {
            this.mLo = r2;
            this.usg = ps.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ps psVar = (ps) bVar;
            if (psVar == null || psVar.fWP == null || psVar.fWP.context == null || psVar.fWP.fWQ == null) {
                w.i("Tinker.SubCoreHotpatch", "Context is NULL.");
            } else {
                com.tencent.mm.plugin.hp.d.d.a(new Intent(), ap.vd().hsZ, new com.tencent.mm.plugin.hp.d.b(psVar.fWP.fWQ));
                com.tencent.mm.bb.d.w(psVar.fWP.context, "sandbox", ".updater.AppUpdaterUI");
                w.d("Tinker.SubCoreHotpatch", "publish startActivity from subCore Hot patch ");
            }
            return false;
        }
    };

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        com.tencent.mm.pluginsdk.b.b.a(new g(), new String[]{"//tinker"});
        ap.getSysCmdMsgExtension().a("checktinkerupdate", this.mLj, true);
        com.tencent.mm.sdk.b.a.urY.b(this.kOg);
        this.mLk.bIy();
        com.tencent.mm.sdk.b.a.urY.b(this.mLl);
        com.tencent.mm.sdk.b.a.urY.b(this.mLm);
        com.tencent.mm.sdk.b.a.urY.b(this.mLn);
        w.d("Tinker.SubCoreHotpatch", "onAccountPostReset");
        g.cr(ab.getContext());
        try {
            ap.yY();
            long longValue = ((Long) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uIl, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue >= 3600000) {
                com.tinkerboots.sdk.a.chU().mm(true);
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uIl, Long.valueOf(currentTimeMillis));
                w.i("Tinker.SubCoreHotpatch", "try to fetch patch update true when onAccountPostReset. current:%d lastUpdate:%d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(longValue)});
            } else {
                com.tinkerboots.sdk.a.chU().mm(false);
                w.i("Tinker.SubCoreHotpatch", "try to fetch patch update false when onAccountPostReset.");
            }
            f.cp(currentTimeMillis);
            com.tencent.mm.plugin.hp.a.a.aDa();
        } catch (Throwable e) {
            w.printErrStackTrace("Tinker.SubCoreHotpatch", e, "", new Object[0]);
        }
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.pluginsdk.b.b.B(new String[]{"//tinker"});
        ap.getSysCmdMsgExtension().b("checktinkerupdate", this.mLj, true);
        com.tencent.mm.sdk.b.a.urY.c(this.kOg);
        this.mLk.dead();
        com.tencent.mm.sdk.b.a.urY.c(this.mLl);
        com.tencent.mm.sdk.b.a.urY.c(this.mLm);
        com.tencent.mm.sdk.b.a.urY.c(this.mLn);
        w.d("Tinker.SubCoreHotpatch", "onAccountRelease");
    }
}
