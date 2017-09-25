package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import java.io.File;

public abstract class d implements OnClickListener {
    protected Context mContext;
    protected int mStatus = -1;
    protected c mpz = null;
    protected int mqT;
    protected long mwB = -1;
    protected String mwC;
    protected FileDownloadTaskInfo mwD;
    protected a mwE;
    protected String mwF;
    protected String mwG;
    protected String mwH;
    private String mwI = "xiaomi";

    public d(Context context) {
        this.mContext = context;
    }

    public final void nC(int i) {
        this.mqT = i;
    }

    protected final void aBK() {
        q.e(this.mContext, Uri.fromFile(new File(this.mwD.path)));
    }

    protected final void aBL() {
        e.V(this.mContext, this.mpz.field_appId);
    }

    protected final void eF(final boolean z) {
        if (am.isNetworkConnected(this.mContext)) {
            ap.yY();
            if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.eoI), 0).show();
                l.aAJ();
                l.a(this.mpz.field_appId, com.tencent.mm.plugin.downloader.model.c.kGA, false, null);
                return;
            } else if (f.G(this.mpz.moT)) {
                if (com.tencent.mm.protocal.d.sYG.toLowerCase().contains(this.mwI)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !this.mContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false)) {
                            g.a(this.mContext, R.l.epC, R.l.epD, R.l.epK, R.l.dGs, false, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ d mwK;

                                {
                                    this.mwK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    this.mwK.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
                                    dialogInterface.cancel();
                                }
                            }, new DialogInterface.OnClickListener(this) {
                                final /* synthetic */ d mwK;

                                {
                                    this.mwK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });
                            this.mContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
                        }
                    } catch (SettingNotFoundException e) {
                        w.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[]{e.getMessage()});
                    }
                }
                if (bg.mA(this.mpz.gfc) || bg.mA(this.mpz.gfh)) {
                    w.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (bg.mA(this.mpz.gfi)) {
                        w.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean aS = q.aS(this.mContext, this.mpz.gfi);
                        w.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[]{Boolean.valueOf(aS)});
                    }
                    if (bg.mA(this.mpz.gfc)) {
                        l.aAJ();
                        l.a(this.mpz.field_appId, com.tencent.mm.plugin.downloader.model.c.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (bg.mA(this.mpz.gfh)) {
                        l.aAJ();
                        l.a(this.mpz.field_appId, com.tencent.mm.plugin.downloader.model.c.kGx, false, null);
                        return;
                    }
                    return;
                }
                ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 4, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                if (am.isWifi(this.mContext)) {
                    eG(z);
                    return;
                }
                g.a(this.mContext, this.mContext.getString(R.l.flW), this.mContext.getString(R.l.flX), this.mContext.getString(R.l.flR), this.mContext.getString(R.l.dGs), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ d mwK;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.mwK.eG(z);
                        dialogInterface.dismiss();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ d mwK;

                    {
                        this.mwK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        w.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
                    }
                }, R.e.aWu);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.eoH), 0).show();
                l.aAJ();
                l.a(this.mpz.field_appId, com.tencent.mm.plugin.downloader.model.c.kGA, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(R.l.eoG), 0).show();
        l.aAJ();
        l.a(this.mpz.field_appId, com.tencent.mm.plugin.downloader.model.c.kGz, false, null);
    }

    public final void eG(boolean z) {
        long a;
        if (z) {
            l.a(this.mpz.gfc, this.mpz.gfh, this.mpz.fTL, this.mpz.field_appId, this.mwF, "app_update");
        } else {
            l.a(this.mpz.gfc, this.mpz.gfh, this.mpz.fTL, this.mpz.field_appId, this.mwF, this.mwH);
        }
        com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
        aVar.tL(this.mpz.gfc);
        aVar.tM(this.mpz.moS);
        aVar.be(this.mpz.moT);
        aVar.tN(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, this.mpz, null));
        aVar.setAppId(this.mpz.field_appId);
        aVar.tO(this.mpz.gfh);
        aVar.dn(true);
        aVar.la(1);
        aVar.bl(this.mpz.field_packageName);
        aVar.kc(this.mpz.fTL);
        if (this.mpz.fLG == 1) {
            com.tencent.mm.plugin.downloader.model.e akM = com.tencent.mm.plugin.downloader.model.e.akM();
            com.tencent.mm.plugin.downloader.model.f fVar = aVar.kHa;
            if (h.vG().uV()) {
                h.vG();
                if (!com.tencent.mm.kernel.a.uP()) {
                    a = akM.akQ().a(fVar);
                }
            }
            a = akM.akO().a(fVar);
            if (a >= 0) {
                com.tencent.mm.plugin.downloader.model.e.kGF.put(Long.valueOf(a), Long.valueOf(0));
                ab.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
                w.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[]{Long.valueOf(a)});
            } else {
                w.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
                akM.akP().a(fVar);
            }
        } else {
            a = com.tencent.mm.plugin.downloader.model.e.akM().a(aVar.kHa);
        }
        w.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[]{Long.valueOf(a), this.mpz.field_appId, Integer.valueOf(this.mpz.fLG)});
        e.W(this.mContext, this.mpz.field_appId);
    }

    protected final void aBM() {
        this.mwE = com.tencent.mm.plugin.downloader.model.d.tE(this.mpz.field_appId);
        this.mwD = com.tencent.mm.plugin.downloader.model.e.akM().tI(this.mpz.field_appId);
        this.mwB = this.mwD.id;
        this.mStatus = this.mwD.status;
        this.mwC = this.mwD.path;
    }
}
