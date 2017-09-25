package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class g extends d {
    public g(Context context) {
        super(context);
    }

    public final void cq(String str, String str2) {
        this.mwG = str;
        this.mwH = str2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof c) {
            boolean z;
            this.mpz = (c) view.getTag();
            w.i("MicsoMsg.GameClickListener", "Clicked appid = " + this.mpz.field_appId);
            aBM();
            if (this.mwD == null || !this.mwD.kHg) {
                z = false;
            } else {
                this.mwD.kHg = false;
                if (this.mwE != null) {
                    this.mwE.field_autoInstall = true;
                    this.mwE.field_showNotification = true;
                    this.mwE.field_autoDownload = false;
                    d.b(this.mwE);
                }
                z = true;
            }
            boolean aV;
            if (com.tencent.mm.pluginsdk.model.app.g.n(this.mContext, this.mpz.field_appId)) {
                int i;
                int i2;
                if (this.mpz instanceof c) {
                    int yc = com.tencent.mm.plugin.game.d.c.yc(this.mpz.field_packageName);
                    i = this.mpz.versionCode;
                    i2 = yc;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    w.i("MicsoMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[]{this.mpz.field_appId, Integer.valueOf(i2), Integer.valueOf(i)});
                    l.a(this.mpz.gfc, this.mpz.gfh, this.mpz.fTL, this.mpz.field_appId, this.mwF, "app_update");
                    if (this.mwD.status == 1) {
                        if (!z) {
                            aV = e.akM().aV(this.mwD.id);
                            if (!aV) {
                                w.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + aV);
                                e.akM().aT(this.mwD.id);
                                return;
                            }
                            return;
                        }
                        return;
                    } else if (this.mwD.status == 2) {
                        if (e.akM().aW(this.mwD.id)) {
                            com.tencent.mm.plugin.game.model.e.W(this.mContext, this.mpz.field_appId);
                            ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 4, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                            return;
                        }
                        w.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
                        e.akM().aT(this.mwD.id);
                        eF(true);
                        return;
                    } else if (this.mwD.status != 3) {
                        eF(true);
                        return;
                    } else if (!com.tencent.mm.a.e.aO(this.mwD.path) || com.tencent.mm.plugin.game.d.c.yd(this.mwD.path) <= i2) {
                        e.akM().aT(this.mwD.id);
                        eF(true);
                        return;
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(this.mwD.path)));
                        ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 8, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                        return;
                    }
                }
                w.d("MicsoMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[]{this.mpz.field_appId, this.mpz.field_packageName, this.mpz.field_openId});
                ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 3, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                aBL();
                return;
            } else if (this.mpz.aAy()) {
                com.tencent.mm.plugin.game.d.c.n(this.mContext, this.mpz.moV.muR, "game_center_hv_game");
                ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 29, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                return;
            } else {
                l.a(this.mpz.gfc, this.mpz.gfh, this.mpz.fTL, this.mpz.field_appId, this.mwF, this.mwH);
                switch (this.mStatus) {
                    case 1:
                        if (!z) {
                            aV = e.akM().aV(this.mwD.id);
                            if (!aV) {
                                w.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + aV);
                                e.akM().aT(this.mwD.id);
                                return;
                            }
                            return;
                        }
                        return;
                    case 2:
                        if (am.isWifi(this.mContext)) {
                            aBQ();
                            return;
                        }
                        com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.flW), this.mContext.getString(R.l.flX), this.mContext.getString(R.l.flR), this.mContext.getString(R.l.dGs), false, new OnClickListener(this) {
                            final /* synthetic */ g myp;

                            {
                                this.myp = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.myp.aBQ();
                                dialogInterface.dismiss();
                            }
                        }, new OnClickListener(this) {
                            final /* synthetic */ g myp;

                            {
                                this.myp = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                w.i("MicsoMsg.GameClickListener", "resumeDownloadTask not wifi, user cancel");
                            }
                        }, R.e.aWu);
                        return;
                    case 3:
                        if (bg.mA(this.mwC)) {
                            e.akM().aT(this.mwB);
                            break;
                        }
                        aBK();
                        ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 8, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
                        return;
                }
                eF(false);
                return;
            }
        }
        w.e("MicsoMsg.GameClickListener", "No AppInfo");
    }

    public final void aBQ() {
        this.mwE.field_scene = this.mpz.scene;
        d.b(this.mwE);
        if (e.akM().aW(this.mwE.field_downloadId)) {
            com.tencent.mm.plugin.game.model.e.W(this.mContext, this.mpz.field_appId);
            ai.a(this.mContext, this.mpz.scene, this.mpz.fTL, this.mpz.position, 4, this.mpz.field_appId, this.mqT, this.mpz.fDE, this.mwG);
            return;
        }
        w.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
        e.akM().aT(this.mwE.field_downloadId);
        eF(false);
    }
}
