package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.plugin.report.service.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.VoipAddressUI;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.ui.tools.s;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class u extends q {
    private static final int[] uVS = new int[]{2, 1, 4, 10, 3, Integer.MAX_VALUE};
    public LayoutInflater Du;
    public Context mContext;
    public SparseArray<c> uVO;
    private a uVQ;
    t uVR = null;

    private class a extends BaseAdapter {
        final /* synthetic */ u uVT;

        private a(u uVar) {
            this.uVT = uVar;
        }

        public final int getCount() {
            return this.uVT.uVO.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar = (c) this.uVT.uVO.get(i);
            View inflate = this.uVT.Du.inflate(R.i.djs, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(R.h.title);
            if (!bg.mA(cVar.uVX.uVY)) {
                textView.setText(cVar.uVX.uVY);
            }
            if (cVar.uVX.textColor > 0) {
                textView.setTextColor(com.tencent.mm.bg.a.b(ab.getContext(), cVar.uVX.textColor));
            }
            ImageView imageView = (ImageView) inflate.findViewById(R.h.icon);
            if (cVar.uVX.icon > 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(((c) this.uVT.uVO.get(i)).uVX.icon);
            } else {
                imageView.setVisibility(8);
            }
            if (!bg.mA(cVar.uVX.uVZ)) {
                imageView.setContentDescription(cVar.uVX.uVZ);
            }
            View findViewById = inflate.findViewById(R.h.cnS);
            textView = (TextView) inflate.findViewById(R.h.cKI);
            textView.setBackgroundResource(s.fg(this.uVT.mContext));
            View findViewById2 = inflate.findViewById(R.h.cne);
            if (cVar.uVV) {
                findViewById.setVisibility(0);
            } else if (cVar.fCK > 0) {
                textView.setVisibility(0);
                if (cVar.fCK > 99) {
                    textView.setText(R.l.eYP);
                } else {
                    textView.setText(cVar.fCK);
                }
            } else if (cVar.uVW) {
                findViewById2.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
                textView.setVisibility(8);
                findViewById2.setVisibility(8);
            }
            if (i == getCount() - 1) {
                inflate.setBackgroundResource(R.g.bkp);
            } else {
                inflate.setBackgroundResource(R.g.bko);
            }
            return inflate;
        }
    }

    public static class b {
        int hTw;
        int id;
        int order;
        int uVU;

        public b(int i, int i2, int i3) {
            this(i, i2, i3, 0);
        }

        public b(int i, int i2, int i3, int i4) {
            this.id = i;
            this.uVU = i2;
            this.hTw = i3;
            this.order = i4;
        }
    }

    public static class c {
        int fCK = 0;
        boolean uVV = false;
        boolean uVW = false;
        d uVX;

        public c(d dVar) {
            this.uVX = dVar;
        }
    }

    public static class d {
        int icon;
        int textColor;
        String uVY;
        String uVZ;
        int uWa;

        public d(int i, String str, String str2, int i2, int i3) {
            this.uVY = str;
            this.uVZ = str2;
            this.icon = i2;
            this.uWa = i;
            this.textColor = i3;
        }
    }

    public u(ActionBarActivity actionBarActivity) {
        super(actionBarActivity);
        this.mContext = actionBarActivity;
        this.Du = LayoutInflater.from(actionBarActivity);
        lL(false);
        this.uVR = t.bQy();
    }

    public final boolean dL() {
        int i = 0;
        this.uVR.kA(false);
        if (this.uVR.uVO.size() != 0) {
            this.uVO = this.uVR.uVO;
        } else {
            w.d("MicroMsg.PlusSubMenuHelper", "dyna plus config is null, we use default one");
            if (this.uVO != null) {
                this.uVO.clear();
            } else {
                this.uVO = new SparseArray();
            }
            for (int i2 = 0; i2 < uVS.length; i2++) {
                this.uVO.put(i2, new c(zw(uVS[i2])));
            }
        }
        try {
            ap.yY();
            if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                while (i < this.uVO.size() && ((c) this.uVO.get(i)).uVX.uWa != 2147483646) {
                    i++;
                }
                if (i == this.uVO.size()) {
                    this.uVO.put(this.uVO.size(), new c(zw(2147483646)));
                }
            }
        } catch (Exception e) {
        }
        if (this.uVQ != null) {
            this.uVQ.notifyDataSetChanged();
        }
        return super.dL();
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean z = true;
        boolean z2 = false;
        if (this.mContext instanceof ActionBarActivity) {
            ((ActionBarActivity) this.mContext).aQ();
        }
        int i2 = ((c) this.uVO.get(i)).uVX.uWa;
        g.oUh.i(11104, Integer.valueOf(i2));
        Intent intent;
        String str;
        int a;
        Intent intent2;
        com.tencent.mm.u.bg zM;
        switch (i2) {
            case 1:
                new Intent().putExtra("invite_friend_scene", 2);
                com.tencent.mm.bb.d.b(this.mContext, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
                break;
            case 2:
                intent = new Intent(this.mContext, SelectContactUI.class);
                intent.putExtra("titile", this.mContext.getString(R.l.dCS));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", com.tencent.mm.ui.contact.s.q(com.tencent.mm.ui.contact.s.vYP, 256, 512));
                intent.putExtra("scene", 7);
                this.mContext.startActivity(intent);
                break;
            case 3:
                intent = new Intent();
                intent.setClassName(this.mContext, "com.tencent.mm.ui.tools.ShareImageRedirectUI");
                this.mContext.startActivity(intent);
                break;
            case 4:
                com.tencent.mm.sdk.b.b qkVar = new qk();
                qkVar.fXu.fXw = true;
                com.tencent.mm.sdk.b.a.urY.m(qkVar);
                str = qkVar.fXv.fXy;
                if (!bg.mA(str)) {
                    w.v("MicroMsg.PlusSubMenuHelper", "Talkroom is on: " + str);
                    com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.eXz), "", this.mContext.getString(R.l.dHT), this.mContext.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ u uVT;

                        {
                            this.uVT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.sdk.b.b qkVar = new qk();
                            qkVar.fXu.fXx = true;
                            com.tencent.mm.sdk.b.a.urY.m(qkVar);
                            VoipAddressUI.eY(this.uVT.mContext);
                            dialogInterface.dismiss();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ u uVT;

                        {
                            this.uVT = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    break;
                }
                VoipAddressUI.eY(this.mContext);
                break;
            case 5:
                ap.yY();
                if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.eP(this.mContext);
                    break;
                }
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(2, null);
                Intent intent3 = new Intent();
                intent3.putExtra("sns_userName", str);
                intent3.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                intent3.addFlags(67108864);
                ap.yY();
                a = bg.a((Integer) com.tencent.mm.u.c.vr().get(68389, null), 0);
                ap.yY();
                com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(a + 1));
                com.tencent.mm.bb.d.b(this.mContext, "sns", ".ui.SnsUserUI", intent3);
                break;
            case 6:
                com.tencent.mm.bb.d.w(this.mContext, "favorite", ".ui.FavoriteIndexUI");
                break;
            case 7:
                com.tencent.mm.bb.d.b(this.mContext, "mall", ".ui.MallIndexUI", new Intent());
                break;
            case 8:
                intent = new Intent();
                intent.putExtra("preceding_scence", 2);
                com.tencent.mm.bb.d.b(this.mContext, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                break;
            case 9:
                com.tencent.mm.bb.d.b(this.mContext, "setting", ".ui.setting.SelfQRCodeUI", new Intent());
                break;
            case 10:
                g.oUh.i(11265, Integer.valueOf(3));
                if (!(com.tencent.mm.n.a.aI(this.mContext) || com.tencent.mm.n.a.aH(this.mContext))) {
                    com.tencent.mm.bb.d.w(this.mContext, "scanner", ".ui.BaseScanUI");
                    break;
                }
            case 11:
                ap.yY();
                if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.eP(this.mContext);
                    break;
                }
                f.rY(10);
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(68377, null);
                ap.yY();
                com.tencent.mm.u.c.vr().set(68377, "");
                intent2 = new Intent();
                intent2.putExtra("sns_timeline_NeedFirstLoadint", true);
                boolean z3 = bg.mA(str);
                if (m.pQC == null) {
                    z2 = z3;
                } else if (m.pQC.Kr() <= 0) {
                    z2 = z3;
                }
                intent2.putExtra("sns_resume_state", z2);
                com.tencent.mm.bb.d.b(this.mContext, "sns", ".ui.En_424b8e16", intent2);
                break;
            case 12:
                ap.yY();
                if (!com.tencent.mm.u.c.isSDCardAvailable()) {
                    com.tencent.mm.ui.base.s.eP(this.mContext);
                    break;
                }
                com.tencent.mm.bb.d.w(this.mContext, "game", ".ui.GameCenterUI");
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ u uVT;

                    {
                        this.uVT = r1;
                    }

                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        this.uVT.mContext.sendBroadcast(intent);
                    }
                }, 100);
                break;
            case 13:
                com.tencent.mm.sdk.b.a.urY.m(new mk());
                com.tencent.mm.bb.d.w(this.mContext, "shake", ".ui.ShakeReportUI");
                break;
            case 14:
                ap.yY();
                if (!bg.f((Boolean) com.tencent.mm.u.c.vr().get(4103, null))) {
                    com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyFriendsIntroUI");
                    break;
                }
                zM = com.tencent.mm.u.bg.zM();
                if (zM != null) {
                    String mz = bg.mz(zM.getProvince());
                    a = bg.a(Integer.valueOf(zM.gkr), 0);
                    if (!bg.mA(mz) && a != 0) {
                        ap.yY();
                        Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4104, null);
                        if (bool != null && bool.booleanValue()) {
                            View inflate = View.inflate(this.mContext, R.i.dgJ, null);
                            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.h.caW);
                            checkBox.setChecked(false);
                            com.tencent.mm.ui.base.g.a(this.mContext, this.mContext.getString(R.l.dIO), inflate, new OnClickListener(this) {
                                final /* synthetic */ u uVT;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    if (checkBox != null) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(4104, Boolean.valueOf(!checkBox.isChecked()));
                                    }
                                    LauncherUI bPI = LauncherUI.bPI();
                                    if (bPI != null) {
                                        bPI.uRM.SD("tab_find_friend");
                                    }
                                    com.tencent.mm.az.a.dl(this.uVT.mContext);
                                }
                            }, null);
                            break;
                        }
                        LauncherUI bPI = LauncherUI.bPI();
                        if (bPI != null) {
                            bPI.uRM.SD("tab_find_friend");
                        }
                        com.tencent.mm.az.a.dl(this.mContext);
                        break;
                    }
                    com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                    break;
                }
                com.tencent.mm.bb.d.w(this.mContext, "nearby", ".ui.NearbyPersonalInfoUI");
                break;
            case 15:
                zM = com.tencent.mm.u.bg.zL();
                if (bg.a(Integer.valueOf(zM.gkr), 0) > 0 && !bg.mA(zM.getProvince())) {
                    com.tencent.mm.bb.d.w(this.mContext, "bottle", ".ui.BottleBeachUI");
                    break;
                } else {
                    com.tencent.mm.bb.d.w(this.mContext, "bottle", ".ui.BottleWizardStep1");
                    break;
                }
            case 16:
                ap.yY();
                if (!com.tencent.mm.u.c.wM()) {
                    com.tencent.mm.bb.d.w(this.mContext, "webwx", ".ui.WebWeiXinIntroductionUI");
                    break;
                } else {
                    com.tencent.mm.bb.d.w(this.mContext, "webwx", ".ui.WebWXLogoutUI");
                    break;
                }
            case 17:
                if ((com.tencent.mm.u.m.xW() & 65536) != 0) {
                    z = false;
                }
                if (!z) {
                    com.tencent.mm.bb.d.b(this.mContext, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                    break;
                } else {
                    com.tencent.mm.bb.d.w(this.mContext, "masssend", ".ui.MassSendHistoryUI");
                    break;
                }
            case 18:
                com.tencent.mm.bb.d.w(this.mContext, "radar", ".ui.RadarSearchUI");
                break;
            case 19:
                com.tencent.mm.bb.d.w(this.mContext, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
                break;
            case 20:
                Context context = this.mContext;
                intent2 = new Intent();
                intent2.putExtra("key_from_scene", 2);
                com.tencent.mm.bb.d.b(context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                if (com.tencent.mm.q.c.uk().aD(262159, 266248)) {
                    com.tencent.mm.q.c.uk().aE(262159, 266248);
                    g.oUh.i(14396, Integer.valueOf(2));
                    break;
                }
                break;
            case 22:
                e.P(this.mContext, 1);
                break;
            case 2147483645:
                intent2 = new Intent();
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_CROWDTEST_FEEDBACK_LINK_STRING, (Object) "");
                if (!bg.mA(str)) {
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("show_bottom", false);
                    com.tencent.mm.bb.d.b(this.mContext, "webview", ".ui.tools.WebViewUI", intent2);
                    break;
                }
                com.tencent.mm.pluginsdk.d.dq(this.mContext);
                break;
            case 2147483646:
                intent = new Intent();
                intent.putExtra("key_from_scene", 2);
                com.tencent.mm.bb.d.b(this.mContext, "offline", ".ui.WalletOfflineEntranceUI", intent);
                break;
            case Integer.MAX_VALUE:
                g.oUh.A(10919, "1-6");
                com.tencent.mm.pluginsdk.d.dq(this.mContext);
                break;
        }
        this.uVR.zv(i2);
        dismiss();
    }

    public static d zw(int i) {
        Context context = ab.getContext();
        switch (i) {
            case 1:
                if (HomeUI.uQf.booleanValue()) {
                    return new d(1, context.getString(R.l.eAJ), "", R.k.dyf, R.e.aWu);
                }
                return new d(1, context.getString(R.l.eAJ), "", R.k.dyg, 0);
            case 2:
                if (HomeUI.uQg.booleanValue()) {
                    return new d(2, context.getString(R.l.eAM), "", R.k.dyo, R.e.aWu);
                }
                return new d(2, context.getString(R.l.eAM), "", R.k.dyp, 0);
            case 3:
                return new d(3, context.getString(R.l.eAN), "", R.k.dvr, 0);
            case 4:
                if (1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0)) {
                    return new d(4, context.getString(R.l.eAO), "", R.k.dyz, 0);
                }
                return new d(4, context.getString(R.l.eAK), "", R.k.dyh, 0);
            case 5:
                return new d(5, context.getString(R.l.eTb), "", R.k.dyu, 0);
            case 6:
                return new d(6, context.getString(R.l.eSQ), "", R.k.dyl, 0);
            case 7:
                return new d(7, context.getString(R.l.eSR), "", R.k.dyj, 0);
            case 8:
                return new d(8, context.getString(R.l.ecZ), "", R.k.dyk, 0);
            case 9:
                return new d(9, context.getString(R.l.eTd), "", R.k.dys, 0);
            case 10:
                return new d(10, context.getString(R.l.ekf), "", R.k.dyv, 0);
            case 11:
                return new d(11, context.getString(R.l.eWO), "", R.k.dyr, 0);
            case 12:
                return new d(12, context.getString(R.l.epp), "", R.k.dyn, 0);
            case 13:
                return new d(13, context.getString(R.l.eVJ), "", R.k.dyy, 0);
            case 14:
                return new d(14, context.getString(R.l.eDc), "", R.k.dyt, 0);
            case 15:
                return new d(15, context.getString(R.l.dPj), "", R.k.dyi, 0);
            case 16:
                return new d(16, context.getString(R.l.eRV), "", R.k.dyA, 0);
            case 17:
                return new d(17, context.getString(R.l.eAA), "", R.k.dyq, 0);
            case 18:
                return new d(18, context.getString(R.l.ekg), "", R.k.dyw, 0);
            case 19:
                return new d(19, context.getString(R.l.ekh), "", R.k.dsL, 0);
            case 20:
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() <= 1) {
                    return new d(20, context.getString(R.l.dCR), "", R.k.dzf, 0);
                }
                break;
            case 22:
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue() == 8) {
                    return new d(22, context.getString(R.l.fiH), "", R.k.dye, 0);
                }
                break;
            case 2147483645:
                return new d(2147483645, context.getString(R.l.eSp), "", R.k.dym, 0);
            case 2147483646:
                return new d(2147483646, "TIT", "", R.k.dyj, 0);
            case Integer.MAX_VALUE:
                return new d(Integer.MAX_VALUE, context.getString(R.l.eSy), "", R.k.dym, 0);
        }
        return null;
    }

    protected final BaseAdapter aeC() {
        if (this.uVQ == null) {
            this.uVQ = new a();
        }
        return this.uVQ;
    }
}
