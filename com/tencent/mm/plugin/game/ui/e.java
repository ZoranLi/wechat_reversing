package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.ay;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class e {
    private Context mContext;
    public Dialog mnu;
    int mqT = 0;
    String mwG = null;
    private g mwX = null;
    private u mwY = null;
    private p mwZ = null;
    private t mxa = null;
    OnClickListener mxb = null;
    private int mxc = 3000;
    private aj mxd = new aj(Looper.getMainLooper(), new a(this) {
        final /* synthetic */ e mxe;

        {
            this.mxe = r1;
        }

        public final boolean oQ() {
            if (this.mxe.mnu != null) {
                this.mxe.mnu.cancel();
            }
            return true;
        }
    }, false);

    public e(Context context) {
        this.mContext = context;
    }

    public final void a(c cVar, m mVar) {
        if (cVar == null || mVar == null) {
            w.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            return;
        }
        View view = new View(this.mContext);
        view.setTag(cVar);
        w.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(cVar.status), Integer.valueOf(mVar.mode), Integer.valueOf(mVar.status)});
        if (g.n(this.mContext, cVar.field_appId) || cVar.aAy()) {
            mVar.mode = 1;
        }
        if (mVar.mode == 3) {
            ay.aBw();
            int e = ay.e(this.mContext, "com.tencent.android.qqdownloader", cVar.gfr);
            w.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[]{Integer.valueOf(e), Integer.valueOf(cVar.gfr)});
            if (e == -1 || e == 1 || e == 2) {
                mVar.mode = 1;
            }
        }
        FileDownloadTaskInfo tI;
        switch (cVar.status) {
            case 0:
            case 3:
            case 4:
                com.tencent.mm.sdk.e.c xP = SubCoreGameCenter.aBB().xP(cVar.field_appId);
                if (xP != null) {
                    w.i("MicroMsg.GameActionBtnHandler", "delete msg, appid = " + xP.field_appId);
                    SubCoreGameCenter.aBB().a(xP, new String[0]);
                }
                switch (mVar.mode) {
                    case 3:
                        tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(cVar.field_appId);
                        if (tI != null && tI.id > 0) {
                            com.tencent.mm.plugin.downloader.model.e.akM().aT(tI.id);
                        }
                        if (this.mwY == null) {
                            this.mwY = new u(this.mContext);
                        }
                        u uVar = this.mwY;
                        int i = this.mqT;
                        String str = this.mwG;
                        uVar.mqT = i;
                        uVar.mwG = str;
                        this.mwY.onClick(view);
                        break;
                    case 4:
                        if (!bg.mA(cVar.gfi)) {
                            w.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            q.aS(this.mContext, cVar.gfi);
                            ai.a(this.mContext, cVar.scene, cVar.fTL, cVar.position, 25, cVar.field_appId, this.mqT, cVar.fDE, this.mwG);
                            break;
                        }
                        break;
                    default:
                        w.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[]{Integer.valueOf(mVar.mode)});
                        if (this.mwX == null) {
                            this.mwX = new g(this.mContext);
                        }
                        this.mwX.nC(this.mqT);
                        this.mwX.cq(this.mwG, "");
                        this.mwX.onClick(view);
                        break;
                }
                if (cVar.moK) {
                    Set ch = com.tencent.mm.plugin.game.model.e.ch(this.mContext);
                    if (!a(ch, cVar.field_appId)) {
                        if (mVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(R.i.deE, null);
                            ((LinearLayout) inflate.findViewById(R.h.ckb)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(R.h.cka);
                            TextView textView2 = (TextView) inflate.findViewById(R.h.cke);
                            ((ImageView) inflate.findViewById(R.h.ckd)).setBackgroundResource(R.g.beD);
                            textView.setText(R.l.eoM);
                            textView2.setText(R.l.eoL);
                            this.mnu = new i(this.mContext, R.m.fov);
                            this.mnu.setContentView(inflate);
                            this.mnu.setCancelable(true);
                            this.mnu.setCanceledOnTouchOutside(true);
                            this.mnu.show();
                            long j = (long) this.mxc;
                            this.mxd.v(j, j);
                        }
                        SubCoreGameCenter.aBE();
                        com.tencent.mm.plugin.game.model.w.b(cVar.field_appId, 1, 0, null, null);
                        ch.add(cVar.field_appId);
                        this.mContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", ch).commit();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.mxa == null) {
                    this.mxa = new t(this.mContext);
                    this.mxa.mFB = this.mxb;
                }
                this.mxa.mqT = this.mqT;
                this.mxa.onClick(view);
                ai.a(this.mContext, cVar.scene, cVar.fTL, cVar.position, 9, cVar.field_appId, this.mqT, cVar.fDE, this.mwG);
                return;
            case 2:
                tI = com.tencent.mm.plugin.downloader.model.e.akM().tI(cVar.field_appId);
                if (tI != null && tI.id > 0) {
                    com.tencent.mm.plugin.downloader.model.e.akM().aT(tI.id);
                }
                if (this.mwZ == null) {
                    this.mwZ = new p(this.mContext);
                }
                this.mwZ.jZM = this.mqT;
                this.mwZ.mDy = cVar.gfm;
                this.mwZ.onClick(view);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.widget.ProgressBar r8, android.widget.Button r9, com.tencent.mm.plugin.game.model.c r10, com.tencent.mm.plugin.game.model.m r11) {
        /*
        r7 = this;
        r4 = 3;
        r6 = 1;
        r3 = 12;
        r2 = 8;
        r5 = 0;
        if (r8 == 0) goto L_0x000b;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        r9.setEnabled(r6);
        r9.setVisibility(r5);
        r0 = r7.mContext;
        r0 = com.tencent.mm.pluginsdk.model.app.g.a(r0, r10);
        if (r0 == 0) goto L_0x007e;
    L_0x001a:
        r0 = r10.field_packageName;
        r0 = com.tencent.mm.plugin.game.d.c.yc(r0);
        r1 = r10.versionCode;
        if (r1 <= r0) goto L_0x0068;
    L_0x0024:
        r1 = r11.status;
        if (r1 != r6) goto L_0x0052;
    L_0x0028:
        r8.setVisibility(r5);
        r1 = r11.progress;
        r8.setProgress(r1);
        r9.setVisibility(r2);
    L_0x0033:
        r1 = "MicroMsg.GameActionBtnHandler";
        r2 = "AppId: %s installed, local: %d, server: %d";
        r3 = new java.lang.Object[r4];
        r4 = r10.field_appId;
        r3[r5] = r4;
        r0 = java.lang.Integer.valueOf(r0);
        r3[r6] = r0;
        r0 = 2;
        r4 = r10.versionCode;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x000b;
    L_0x0052:
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0062;
    L_0x0056:
        r1 = com.tencent.mm.R.l.eoA;
        r9.setText(r1);
    L_0x005b:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x0033;
    L_0x0062:
        r1 = com.tencent.mm.R.l.eop;
        r9.setText(r1);
        goto L_0x005b;
    L_0x0068:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r1 = r10.scene;
        if (r1 != r3) goto L_0x0078;
    L_0x0072:
        r1 = com.tencent.mm.R.l.eoy;
        r9.setText(r1);
        goto L_0x0033;
    L_0x0078:
        r1 = com.tencent.mm.R.l.eoX;
        r9.setText(r1);
        goto L_0x0033;
    L_0x007e:
        r0 = r10.aAy();
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0095;
    L_0x008e:
        r0 = com.tencent.mm.R.l.eoy;
        r9.setText(r0);
        goto L_0x000b;
    L_0x0095:
        r0 = com.tencent.mm.R.l.eoX;
        r9.setText(r0);
        goto L_0x000b;
    L_0x009c:
        r0 = r10.status;
        switch(r0) {
            case 0: goto L_0x00c7;
            case 1: goto L_0x014c;
            case 2: goto L_0x016d;
            case 3: goto L_0x017a;
            case 4: goto L_0x01e0;
            default: goto L_0x00a1;
        };
    L_0x00a1:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
    L_0x00a7:
        r0 = "MicroMsg.GameActionBtnHandler";
        r1 = "updateBtnStateAndText: %s, Status: %d, Text: %s";
        r2 = new java.lang.Object[r4];
        r3 = r10.field_appId;
        r2[r5] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r6] = r3;
        r3 = 2;
        r4 = r9.getText();
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        goto L_0x000b;
    L_0x00c7:
        if (r11 != 0) goto L_0x00d1;
    L_0x00c9:
        r9.setVisibility(r2);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x00d1:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x00d7;
            case 1: goto L_0x0105;
            case 2: goto L_0x0125;
            case 3: goto L_0x013c;
            default: goto L_0x00d6;
        };
    L_0x00d6:
        goto L_0x00a7;
    L_0x00d7:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x00ff;
    L_0x00db:
        r0 = r10.moK;
        if (r0 == 0) goto L_0x00f9;
    L_0x00df:
        r0 = r10.field_appId;
        r1 = r7.mContext;
        r1 = com.tencent.mm.plugin.game.model.e.ch(r1);
        r0 = a(r1, r0);
        if (r0 != 0) goto L_0x00f9;
    L_0x00ed:
        r0 = com.tencent.mm.R.l.eoF;
        r9.setText(r0);
    L_0x00f2:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x00f9:
        r0 = com.tencent.mm.R.l.eoT;
        r9.setText(r0);
        goto L_0x00f2;
    L_0x00ff:
        r0 = com.tencent.mm.R.l.eoS;
        r9.setText(r0);
        goto L_0x00f2;
    L_0x0105:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x0115;
    L_0x0109:
        r0 = com.tencent.mm.R.l.eoV;
        r9.setText(r0);
    L_0x010e:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0115:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00a7;
    L_0x0119:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00a7;
    L_0x0125:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0136;
    L_0x0129:
        r0 = com.tencent.mm.R.l.eoE;
        r9.setText(r0);
    L_0x012e:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0136:
        r0 = com.tencent.mm.R.l.eoU;
        r9.setText(r0);
        goto L_0x012e;
    L_0x013c:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x0146;
    L_0x0140:
        r0 = com.tencent.mm.R.l.eoR;
        r9.setText(r0);
        goto L_0x010e;
    L_0x0146:
        r0 = com.tencent.mm.R.l.eoQ;
        r9.setText(r0);
        goto L_0x010e;
    L_0x014c:
        r0 = r10.moD;
        if (r0 == 0) goto L_0x0160;
    L_0x0150:
        r9.setEnabled(r5);
        r0 = com.tencent.mm.R.l.eon;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x0160:
        r0 = com.tencent.mm.R.l.eom;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x016d:
        r0 = com.tencent.mm.R.l.eol;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x017a:
        if (r11 != 0) goto L_0x0189;
    L_0x017c:
        r0 = com.tencent.mm.R.l.eok;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x000b;
    L_0x0189:
        r0 = r11.status;
        switch(r0) {
            case 0: goto L_0x0190;
            case 1: goto L_0x019d;
            case 2: goto L_0x01b9;
            case 3: goto L_0x01d0;
            default: goto L_0x018e;
        };
    L_0x018e:
        goto L_0x00a7;
    L_0x0190:
        r0 = com.tencent.mm.R.l.eok;
        r9.setText(r0);
    L_0x0195:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x019d:
        r0 = r11.mode;
        if (r0 != r4) goto L_0x01a8;
    L_0x01a1:
        r0 = com.tencent.mm.R.l.eoV;
        r9.setText(r0);
        goto L_0x00a7;
    L_0x01a8:
        r0 = r11.mode;
        if (r0 != r6) goto L_0x00a7;
    L_0x01ac:
        r0 = r11.progress;
        r8.setProgress(r0);
        r9.setVisibility(r2);
        r8.setVisibility(r5);
        goto L_0x00a7;
    L_0x01b9:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01ca;
    L_0x01bd:
        r0 = com.tencent.mm.R.l.eoE;
        r9.setText(r0);
    L_0x01c2:
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
    L_0x01ca:
        r0 = com.tencent.mm.R.l.eoU;
        r9.setText(r0);
        goto L_0x01c2;
    L_0x01d0:
        r0 = r10.scene;
        if (r0 != r3) goto L_0x01da;
    L_0x01d4:
        r0 = com.tencent.mm.R.l.eoR;
        r9.setText(r0);
        goto L_0x0195;
    L_0x01da:
        r0 = com.tencent.mm.R.l.eoQ;
        r9.setText(r0);
        goto L_0x0195;
    L_0x01e0:
        r0 = com.tencent.mm.R.l.eoo;
        r9.setText(r0);
        r9.setVisibility(r5);
        r8.setVisibility(r2);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.ui.e.a(android.widget.ProgressBar, android.widget.Button, com.tencent.mm.plugin.game.model.c, com.tencent.mm.plugin.game.model.m):void");
    }

    private static boolean a(Set<String> set, String str) {
        if (set == null || set.isEmpty() || !set.contains(str)) {
            return false;
        }
        return true;
    }
}
