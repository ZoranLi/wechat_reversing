package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.ah.o;
import com.tencent.mm.as.j;
import com.tencent.mm.as.m;
import com.tencent.mm.av.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.gm;
import com.tencent.mm.e.a.hk;
import com.tencent.mm.e.a.ia;
import com.tencent.mm.e.a.id;
import com.tencent.mm.e.a.ii;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.mk;
import com.tencent.mm.e.a.mm;
import com.tencent.mm.e.a.ns;
import com.tencent.mm.e.a.od;
import com.tencent.mm.e.a.oe;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.e.a.py;
import com.tencent.mm.e.a.qw;
import com.tencent.mm.e.a.sn;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.ipcall.a.e.i;
import com.tencent.mm.pluginsdk.l.aa;
import com.tencent.mm.pluginsdk.l.e;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ak;
import com.tencent.mm.u.al;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.account.FacebookFriendUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;
import com.tencent.mm.ui.friend.FriendSnsPreference;
import com.tencent.mm.ui.tools.s;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public class g extends a implements a, b, ak, al {
    public f isJ;
    public ae mHandler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ g uPE;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.uPE.isJ != null) {
                        this.uPE.ki(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public CheckBox nVW;
    private h nVY = null;
    c pWv = new c<py>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = py.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.FindMoreFriendsUI", "mark sns read %d", Integer.valueOf(((py) bVar).fWZ.fJA));
            if (((py) bVar).fWZ.fJA == 9) {
                new ae(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass11 uPO;

                    {
                        this.uPO = r1;
                    }

                    public final void run() {
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(68377, "");
                        if (this.uPO.uPE.isJ != null) {
                            this.uPO.uPE.isJ.notifyDataSetChanged();
                        }
                    }
                });
            }
            return true;
        }
    };
    private c<sn> pgl = new c<sn>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = sn.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.uPE.uSU.ipu.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 uPF;

                {
                    this.uPF = r1;
                }

                public final void run() {
                    if (this.uPF.uPE.isAdded()) {
                        this.uPF.uPE.bPc();
                    }
                }
            });
            return false;
        }
    };
    private com.tencent.mm.pluginsdk.e.a sRX = new com.tencent.mm.pluginsdk.e.a(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r1;
        }

        public final void j(com.tencent.mm.sdk.b.b bVar) {
            w.d("MicroMsg.FindMoreFriendsUI", "onMStorageNotifyEvent, %s ", bVar);
            if (bVar instanceof id) {
                this.uPE.WS();
            }
        }
    };
    private com.tencent.mm.pluginsdk.e.a uPA = new com.tencent.mm.pluginsdk.e.a(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r1;
        }

        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof gm) {
                g gVar = this.uPE;
                gVar.bPg();
                gVar.isJ.notifyDataSetChanged();
            }
        }
    };
    private com.tencent.mm.pluginsdk.e.a uPB = new com.tencent.mm.pluginsdk.e.a(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r1;
        }

        public final void j(com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof oe) {
                this.uPE.WS();
            }
        }
    };
    private c uPC = new c<od>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = od.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((od) bVar) instanceof od) {
                this.uPE.WS();
            }
            return false;
        }
    };
    o.a uPD = new o.a(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r1;
        }

        public final void g(final String str, final Bitmap bitmap) {
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 uPH;

                public final void run() {
                    w.i("MicroMsg.FindMoreFriendsUI", "download url " + str + " , result " + (bitmap == null));
                    IconPreference iconPreference = (IconPreference) this.uPH.uPE.isJ.Td("jd_market_entrance");
                    if (iconPreference != null) {
                        if (str.equals(this.uPH.uPE.uPn)) {
                            iconPreference.drawable = new BitmapDrawable(this.uPH.uPE.uSU.uTo.getResources(), bitmap);
                            this.uPH.uPE.uPn = null;
                        } else if (str.equals(this.uPH.uPE.uPq)) {
                            iconPreference.P(bitmap);
                            this.uPH.uPE.uPq = null;
                        }
                        this.uPH.uPE.isJ.notifyDataSetChanged();
                    }
                    if (str.equals(this.uPH.uPE.uPo)) {
                        ((IconPreference) this.uPH.uPE.isJ.Td("find_friends_by_look")).drawable = new BitmapDrawable(this.uPH.uPE.uSU.uTo.getResources(), bitmap);
                        this.uPH.uPE.uPo = null;
                        this.uPH.uPE.isJ.notifyDataSetChanged();
                    }
                    if (str.equals(this.uPH.uPE.uPp)) {
                        ((IconPreference) this.uPH.uPE.isJ.Td("find_friends_by_search")).drawable = new BitmapDrawable(this.uPH.uPE.uSU.uTo.getResources(), bitmap);
                        this.uPH.uPE.uPp = null;
                        this.uPH.uPE.isJ.notifyDataSetChanged();
                    }
                }
            });
        }
    };
    private View uPj;
    private boolean uPk = false;
    private String uPl = "";
    private int uPm = 0;
    public String uPn = null;
    public String uPo = null;
    public String uPp = null;
    public String uPq = null;
    private boolean uPr = false;
    private boolean uPs = false;
    private boolean uPt = false;
    public boolean uPu = true;
    private String uPv;
    private boolean uPw = false;
    private c<ns> uPx = new c<ns>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = ns.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            return bPi();
        }

        private boolean bPi() {
            this.uPE.bPc();
            return true;
        }
    };
    c uPy = new c<ia>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = ia.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (aa.sBG != null) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11178, bg.mz(r0.bmV()), r0.bmW().bmH(), Integer.valueOf(g.bPe()));
            }
            this.uPE.ki(true);
            return true;
        }
    };
    c uPz = new c<cg>(this) {
        final /* synthetic */ g uPE;

        {
            this.uPE = r2;
            this.usg = cg.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            w.i("MicroMsg.FindMoreFriendsUI", "dynamic config file change");
            this.uPE.mHandler.sendEmptyMessage(1);
            return true;
        }
    };

    public final int ON() {
        return R.o.ftL;
    }

    public final boolean biv() {
        return false;
    }

    public final boolean Xb() {
        return true;
    }

    public final void bPc() {
        Object obj = 1;
        try {
            Object obj2;
            Object obj3;
            int i;
            CharSequence optString;
            String optString2;
            IconPreference iconPreference;
            Bitmap gS;
            m Iw;
            JSONObject kb = j.kb("discoverRecommendEntry");
            if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).La("labs_browse")) {
                if (!((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).KY("labs_browse")) {
                    obj2 = null;
                    obj3 = null;
                } else if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).KZ("labs_browse")) {
                    obj2 = 1;
                    obj3 = 1;
                } else {
                    obj2 = null;
                    int i2 = 1;
                }
                Object obj4 = obj2;
                obj2 = obj3;
                obj3 = obj4;
            } else if (kb.optInt("entrySwitch") == 1) {
                obj3 = null;
                i = 1;
            } else {
                obj3 = null;
                obj2 = null;
            }
            if (obj2 != null) {
                optString = kb.optString("wording");
                optString2 = kb.optString("androidIcon");
                iconPreference = (IconPreference) this.isJ.Td("find_friends_by_look");
                if (bg.mA(optString)) {
                    iconPreference.setTitle(getString(R.l.eki));
                } else {
                    iconPreference.setTitle(optString);
                }
                if (bg.mA(optString2)) {
                    iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxh);
                    this.uPo = null;
                } else {
                    n.GR();
                    gS = com.tencent.mm.ah.b.gS(optString2);
                    if (gS != null) {
                        iconPreference.drawable = new BitmapDrawable(this.uSU.uTo.getResources(), gS);
                        this.uPo = null;
                    } else {
                        w.i("MicroMsg.FindMoreFriendsUI", "load look icon from disk and net %s ", optString2);
                        iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxh);
                        n.GV().a(optString2, this.uPD);
                        this.uPo = optString2;
                    }
                }
                this.isJ.aV("find_friends_by_look", false);
                if (obj3 != null) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                } else {
                    iconPreference.As(8);
                }
                Iw = m.Iw();
                if (Iw.valid() && (Iw.hQm.hQp & 2) == 2) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
                if (obj3 != null) {
                    iconPreference.Az(0);
                } else {
                    iconPreference.Az(8);
                }
            } else {
                this.isJ.aV("find_friends_by_look", true);
            }
            kb = j.kb("discoverSearchEntry");
            if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).La("labs1de6f3")) {
                if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).KY("labs1de6f3")) {
                    if (((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).KZ("labs1de6f3")) {
                        obj2 = 1;
                        obj3 = 1;
                    } else {
                        i = 1;
                        obj3 = null;
                    }
                }
                obj2 = null;
                obj3 = null;
            } else {
                if (kb.optInt("entrySwitch") == 1) {
                    i = 1;
                    obj3 = null;
                }
                obj2 = null;
                obj3 = null;
            }
            if (obj2 != null) {
                optString = kb.optString("wording");
                optString2 = kb.optString("androidIcon");
                iconPreference = (IconPreference) this.isJ.Td("find_friends_by_search");
                if (bg.mA(optString)) {
                    iconPreference.setTitle(getString(R.l.ekm));
                } else {
                    iconPreference.setTitle(optString);
                }
                if (bg.mA(optString2)) {
                    iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxk);
                    this.uPp = null;
                } else {
                    n.GR();
                    gS = com.tencent.mm.ah.b.gS(optString2);
                    if (gS != null) {
                        iconPreference.drawable = new BitmapDrawable(this.uSU.uTo.getResources(), gS);
                        this.uPp = null;
                    } else {
                        w.i("MicroMsg.FindMoreFriendsUI", "load search icon from disk and net %s ", optString2);
                        iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxk);
                        n.GV().a(optString2, this.uPD);
                        this.uPp = optString2;
                    }
                }
                if (obj3 != null) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                } else {
                    iconPreference.As(8);
                }
                Iw = m.Iw();
                if (!(Iw.valid() && (Iw.hQm.hQp & 1) == 1)) {
                    obj = null;
                }
                if (obj != null) {
                    iconPreference.Az(0);
                } else {
                    iconPreference.Az(8);
                }
                this.isJ.aV("find_friends_by_search", false);
                return;
            }
            this.isJ.aV("find_friends_by_search", true);
        } catch (Throwable e) {
            w.e("MicroMsg.FindMoreFriendsUI", bg.g(e));
        }
    }

    private void bPd() {
        boolean z = true;
        int i = 0;
        this.uPw = false;
        if (this.isJ != null) {
            com.tencent.mm.sdk.b.b ohVar = new oh();
            ohVar.fVq.fVs = true;
            com.tencent.mm.sdk.b.a.urY.m(ohVar);
            f fVar = this.isJ;
            String str = "app_brand_entrance";
            if (ohVar.fVr.fVt) {
                z = false;
            }
            fVar.aV(str, z);
            IconPreference iconPreference = (IconPreference) this.isJ.Td("app_brand_entrance");
            if (ohVar.fVr.fVt) {
                int i2;
                if (ohVar.fVr.fVv) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                iconPreference.As(i2);
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                if (!ohVar.fVr.fVu) {
                    i = 8;
                }
                iconPreference.Au(i);
            }
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        w.i("MicroMsg.FindMoreFriendsUI", "onActivityCreated");
        this.isJ = this.vrv;
    }

    public final void WS() {
        f fVar;
        boolean z;
        int Kr;
        Boolean valueOf;
        boolean z2 = true;
        w.i("MicroMsg.FindMoreFriendsUI", "ConfigStorageLogic.getPluginFlagFromUserInfo() %s", Integer.valueOf(com.tencent.mm.u.m.xW()));
        String str = "MicroMsg.FindMoreFriendsUI";
        String str2 = "sns plugin %s %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(d.Jt("sns"));
        objArr[1] = Boolean.valueOf((com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0);
        w.i(str, str2, objArr);
        boolean z3;
        f fVar2;
        String str3;
        IconPreference iconPreference;
        boolean z4;
        int Kr2;
        String ap;
        int xP;
        k kVar;
        if (d.Jt("sns")) {
            this.isJ.aV("album_dyna_photo_ui_title", false);
            FriendSnsPreference friendSnsPreference = (FriendSnsPreference) this.isJ.Td("album_dyna_photo_ui_title");
            if (friendSnsPreference != null) {
                z3 = (com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0;
                if (z3) {
                    friendSnsPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxj);
                    ap.yY();
                    boolean f = bg.f((Boolean) com.tencent.mm.u.c.vr().get(48, null));
                    friendSnsPreference.As(8);
                    friendSnsPreference.Ay(8);
                    if (f) {
                        friendSnsPreference.As(0);
                        friendSnsPreference.cM(getString(R.l.dHO), R.g.bhC);
                    }
                    ap.yY();
                    this.uPl = (String) com.tencent.mm.u.c.vr().get(68377, null);
                    w.i("MicroMsg.FindMoreFriendsUI", "newer snsobj %s", bg.ap(this.uPl, ""));
                    friendSnsPreference.Ax(0);
                    if (bg.mA(this.uPl)) {
                        ap.yY();
                        if (((Boolean) com.tencent.mm.u.c.vr().get(589825, Boolean.valueOf(false))).booleanValue()) {
                            friendSnsPreference.Av(R.k.dyc);
                            friendSnsPreference.Aw(0);
                            friendSnsPreference.Ay(8);
                        } else {
                            friendSnsPreference.Aw(8);
                        }
                    } else {
                        friendSnsPreference.Aw(0);
                        ap.yY();
                        friendSnsPreference.Ay(bg.b((Boolean) com.tencent.mm.u.c.vr().get(68384, null), true) ? 0 : 8);
                        str = this.uPl;
                        friendSnsPreference.vqO = null;
                        friendSnsPreference.vqP = -1;
                        friendSnsPreference.wgM = str;
                        if (friendSnsPreference.nvU != null) {
                            com.tencent.mm.pluginsdk.ui.a.b.a(friendSnsPreference.nvU, str);
                        }
                    }
                    if (com.tencent.mm.plugin.sns.b.m.pQC != null) {
                        this.uPm = com.tencent.mm.plugin.sns.b.m.pQC.Kr();
                    }
                    if (this.uPm != 0) {
                        friendSnsPreference.As(0);
                        friendSnsPreference.cM(this.uPm, s.fg(this.uSU.uTo));
                    }
                    friendSnsPreference.Au(8);
                    friendSnsPreference.At(8);
                    com.tencent.mm.sdk.b.a.urY.m(new qw());
                }
                fVar2 = this.isJ;
                str3 = "album_dyna_photo_ui_title";
                if (z3) {
                    fVar = fVar2;
                    str = str3;
                    z = false;
                } else {
                    fVar = fVar2;
                    str = str3;
                    z = true;
                }
            }
            if (d.Jt("nearby")) {
                fVar = this.isJ;
                str = "find_friends_by_near";
                z = true;
            } else {
                this.isJ.aV("find_friends_by_near", false);
                iconPreference = (IconPreference) this.isJ.Td("find_friends_by_near");
                if (iconPreference != null) {
                    com.tencent.mm.sdk.b.b iiVar;
                    iiVar = new ii();
                    iiVar.fNT.fJA = 7;
                    com.tencent.mm.sdk.b.a.urY.m(iiVar);
                    if (iiVar.fNU.fFj) {
                        iconPreference.Aw(0);
                        iconPreference.Av(R.g.bgY);
                        iconPreference.vqU = new LayoutParams(-2, -2);
                        iconPreference.vqU.addRule(13);
                        if (iconPreference.nvU != null) {
                            iconPreference.nvU.setLayoutParams(iconPreference.vqU);
                        }
                    } else {
                        iconPreference.Aw(8);
                    }
                    Kr = l.Kz().Kr();
                    if (com.tencent.mm.az.a.bCj()) {
                        if (Kr <= 0) {
                            iconPreference.As(0);
                            iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                        } else {
                            iconPreference.As(8);
                            iconPreference.cM("", -1);
                        }
                    } else if (Kr <= 0) {
                        iconPreference.Au(0);
                    } else {
                        iconPreference.Au(8);
                    }
                    if ((com.tencent.mm.u.m.xW() & 512) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar = this.isJ;
                    str = "find_friends_by_near";
                    if (z) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (d.Jt("shake")) {
                    fVar = this.isJ;
                    str = "find_friends_by_shake";
                    z = true;
                } else {
                    this.isJ.aV("find_friends_by_shake", false);
                    iconPreference = (IconPreference) this.isJ.Td("find_friends_by_shake");
                    if (iconPreference != null) {
                        z4 = (com.tencent.mm.u.m.xW() & 256) != 0;
                        if (z4) {
                            Kr2 = l.KA().Kr() + com.tencent.mm.pluginsdk.l.a.bCn().baL();
                            if (Kr2 <= 0) {
                                iconPreference.As(0);
                                iconPreference.cM(String.valueOf(Kr2), R.g.bkU);
                            } else {
                                iconPreference.As(8);
                                iconPreference.cM("", -1);
                            }
                            iconPreference.Aw(8);
                            com.tencent.mm.pluginsdk.l.a.bCn().baM();
                            if (com.tencent.mm.pluginsdk.l.a.bCn().baN()) {
                                z3 = false;
                            } else {
                                z3 = com.tencent.mm.q.c.uk().aD(262154, 266258);
                            }
                            if (z3) {
                                iconPreference.Au(8);
                            } else {
                                ap.yY();
                                str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                                if (TextUtils.isEmpty(str)) {
                                    iconPreference.Au(8);
                                    iconPreference.As(0);
                                    iconPreference.cM(str, R.g.bkU);
                                } else if (Kr2 <= 0) {
                                    iconPreference.Au(0);
                                } else {
                                    iconPreference.Au(0);
                                    iconPreference.As(8);
                                    iconPreference.cM("", -1);
                                }
                            }
                            ap.yY();
                            ap = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
                            ap.yY();
                            valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                            ap.yY();
                            Kr = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                            if (valueOf.booleanValue() || ap == null || ap.equals("") || Kr2 > 0 || z3) {
                                iconPreference.At(8);
                            } else if (Kr == 0) {
                                iconPreference.Au(8);
                                iconPreference.At(0);
                                String[] split = ap.split(",");
                                if (split.length > 0) {
                                    iconPreference.R(split[0], -1, Color.parseColor("#8c8c8c"));
                                }
                                iconPreference.kY(true);
                                iconPreference.Ax(8);
                            } else if (Kr == 1) {
                                iconPreference.At(8);
                                iconPreference.As(0);
                                iconPreference.vqZ = true;
                            }
                        }
                        fVar2 = this.isJ;
                        str3 = "find_friends_by_shake";
                        if (z4) {
                            fVar = fVar2;
                            str = str3;
                            z = true;
                        } else {
                            fVar = fVar2;
                            str = str3;
                            z = false;
                        }
                    }
                    if (d.Jt("bottle")) {
                        w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                        this.isJ.aV("voice_bottle", true);
                    } else {
                        this.isJ.aV("voice_bottle", false);
                        if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                            if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            this.uPk = z;
                            w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                            fVar2 = this.isJ;
                            str2 = "voice_bottle";
                            if (this.uPk) {
                                z = true;
                            } else {
                                z = false;
                            }
                            fVar2.aV(str2, z);
                            if (this.uPk) {
                                iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                                if (iconPreference != null) {
                                    Kr = com.tencent.mm.u.h.xI();
                                    if (Kr > 0) {
                                        iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                                    }
                                    xP = com.tencent.mm.u.m.xP();
                                    if (Kr > 0 || (WXMediaMessage.THUMB_LENGTH_LIMIT & xP) != 0) {
                                        iconPreference.As(8);
                                    } else {
                                        iconPreference.As(0);
                                    }
                                }
                            }
                        }
                    }
                    if (d.Jt("game")) {
                        this.isJ.aV("more_tab_game_recommend", true);
                    } else {
                        this.isJ.aV("more_tab_game_recommend", false);
                        kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                        if (kVar != null) {
                            if (kVar.aBI()) {
                                this.isJ.aV("more_tab_game_recommend", true);
                            } else {
                                bPg();
                            }
                        }
                    }
                    if (d.Jt("scanner")) {
                        this.isJ.aV("find_friends_by_qrcode", true);
                    } else {
                        this.isJ.aV("find_friends_by_qrcode", false);
                    }
                    this.isJ.aV("find_friends_by_facebook", true);
                    ki(false);
                    this.isJ.aV("settings_emoji_store", true);
                    this.isJ.notifyDataSetChanged();
                    if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                        this.isJ.aV("ip_call_entrance", true);
                        return;
                    }
                    this.isJ.aV("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
                    ap.yY();
                    if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                        iconPreference.As(0);
                        iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                    } else {
                        iconPreference.As(8);
                    }
                    iconPreference.Ax(8);
                    ap.yY();
                    if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        iconPreference.kY(true);
                        iconPreference.As(8);
                        z3 = true;
                    } else {
                        iconPreference.kY(false);
                        z3 = false;
                    }
                    ap.yY();
                    str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                    iconPreference.R(str, -1, -7566196);
                    if (bg.mA(str)) {
                        z2 = z3;
                    }
                    if (z2) {
                        iconPreference.At(8);
                    } else {
                        iconPreference.At(0);
                    }
                    this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
                }
                fVar.aV(str, z);
                if (d.Jt("bottle")) {
                    this.isJ.aV("voice_bottle", false);
                    if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                        if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                            z = false;
                        } else {
                            z = true;
                        }
                        this.uPk = z;
                        w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                        fVar2 = this.isJ;
                        str2 = "voice_bottle";
                        if (this.uPk) {
                            z = false;
                        } else {
                            z = true;
                        }
                        fVar2.aV(str2, z);
                        if (this.uPk) {
                            iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                            if (iconPreference != null) {
                                Kr = com.tencent.mm.u.h.xI();
                                if (Kr > 0) {
                                    iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                                }
                                xP = com.tencent.mm.u.m.xP();
                                if (Kr > 0) {
                                }
                                iconPreference.As(8);
                            }
                        }
                    }
                } else {
                    w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.isJ.aV("voice_bottle", true);
                }
                if (d.Jt("game")) {
                    this.isJ.aV("more_tab_game_recommend", false);
                    kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                    if (kVar != null) {
                        if (kVar.aBI()) {
                            bPg();
                        } else {
                            this.isJ.aV("more_tab_game_recommend", true);
                        }
                    }
                } else {
                    this.isJ.aV("more_tab_game_recommend", true);
                }
                if (d.Jt("scanner")) {
                    this.isJ.aV("find_friends_by_qrcode", false);
                } else {
                    this.isJ.aV("find_friends_by_qrcode", true);
                }
                this.isJ.aV("find_friends_by_facebook", true);
                ki(false);
                this.isJ.aV("settings_emoji_store", true);
                this.isJ.notifyDataSetChanged();
                if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                    this.isJ.aV("ip_call_entrance", true);
                    return;
                }
                this.isJ.aV("ip_call_entrance", false);
                iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.As(8);
                } else {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                }
                iconPreference.Ax(8);
                ap.yY();
                if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.kY(false);
                    z3 = false;
                } else {
                    iconPreference.kY(true);
                    iconPreference.As(8);
                    z3 = true;
                }
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.R(str, -1, -7566196);
                if (bg.mA(str)) {
                    z2 = z3;
                }
                if (z2) {
                    iconPreference.At(8);
                } else {
                    iconPreference.At(0);
                }
                this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
            }
            fVar.aV(str, z);
            if (d.Jt("shake")) {
                this.isJ.aV("find_friends_by_shake", false);
                iconPreference = (IconPreference) this.isJ.Td("find_friends_by_shake");
                if (iconPreference != null) {
                    if ((com.tencent.mm.u.m.xW() & 256) != 0) {
                    }
                    if (z4) {
                        Kr2 = l.KA().Kr() + com.tencent.mm.pluginsdk.l.a.bCn().baL();
                        if (Kr2 <= 0) {
                            iconPreference.As(8);
                            iconPreference.cM("", -1);
                        } else {
                            iconPreference.As(0);
                            iconPreference.cM(String.valueOf(Kr2), R.g.bkU);
                        }
                        iconPreference.Aw(8);
                        com.tencent.mm.pluginsdk.l.a.bCn().baM();
                        if (com.tencent.mm.pluginsdk.l.a.bCn().baN()) {
                            z3 = false;
                        } else {
                            z3 = com.tencent.mm.q.c.uk().aD(262154, 266258);
                        }
                        if (z3) {
                            iconPreference.Au(8);
                        } else {
                            ap.yY();
                            str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                            if (TextUtils.isEmpty(str)) {
                                iconPreference.Au(8);
                                iconPreference.As(0);
                                iconPreference.cM(str, R.g.bkU);
                            } else if (Kr2 <= 0) {
                                iconPreference.Au(0);
                                iconPreference.As(8);
                                iconPreference.cM("", -1);
                            } else {
                                iconPreference.Au(0);
                            }
                        }
                        ap.yY();
                        ap = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
                        ap.yY();
                        valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                        ap.yY();
                        Kr = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                        if (valueOf.booleanValue()) {
                        }
                        iconPreference.At(8);
                    }
                    fVar2 = this.isJ;
                    str3 = "find_friends_by_shake";
                    if (z4) {
                        fVar = fVar2;
                        str = str3;
                        z = false;
                    } else {
                        fVar = fVar2;
                        str = str3;
                        z = true;
                    }
                }
                if (d.Jt("bottle")) {
                    w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.isJ.aV("voice_bottle", true);
                } else {
                    this.isJ.aV("voice_bottle", false);
                    if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                        if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.uPk = z;
                        w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                        fVar2 = this.isJ;
                        str2 = "voice_bottle";
                        if (this.uPk) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar2.aV(str2, z);
                        if (this.uPk) {
                            iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                            if (iconPreference != null) {
                                Kr = com.tencent.mm.u.h.xI();
                                if (Kr > 0) {
                                    iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                                }
                                xP = com.tencent.mm.u.m.xP();
                                if (Kr > 0) {
                                }
                                iconPreference.As(8);
                            }
                        }
                    }
                }
                if (d.Jt("game")) {
                    this.isJ.aV("more_tab_game_recommend", true);
                } else {
                    this.isJ.aV("more_tab_game_recommend", false);
                    kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                    if (kVar != null) {
                        if (kVar.aBI()) {
                            this.isJ.aV("more_tab_game_recommend", true);
                        } else {
                            bPg();
                        }
                    }
                }
                if (d.Jt("scanner")) {
                    this.isJ.aV("find_friends_by_qrcode", true);
                } else {
                    this.isJ.aV("find_friends_by_qrcode", false);
                }
                this.isJ.aV("find_friends_by_facebook", true);
                ki(false);
                this.isJ.aV("settings_emoji_store", true);
                this.isJ.notifyDataSetChanged();
                if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                    this.isJ.aV("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
                    ap.yY();
                    if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                        iconPreference.As(0);
                        iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                    } else {
                        iconPreference.As(8);
                    }
                    iconPreference.Ax(8);
                    ap.yY();
                    if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        iconPreference.kY(true);
                        iconPreference.As(8);
                        z3 = true;
                    } else {
                        iconPreference.kY(false);
                        z3 = false;
                    }
                    ap.yY();
                    str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                    iconPreference.R(str, -1, -7566196);
                    if (bg.mA(str)) {
                        z2 = z3;
                    }
                    if (z2) {
                        iconPreference.At(0);
                    } else {
                        iconPreference.At(8);
                    }
                    this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
                }
                this.isJ.aV("ip_call_entrance", true);
                return;
            }
            fVar = this.isJ;
            str = "find_friends_by_shake";
            z = true;
            fVar.aV(str, z);
            if (d.Jt("bottle")) {
                this.isJ.aV("voice_bottle", false);
                if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                    if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.uPk = z;
                    w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                    fVar2 = this.isJ;
                    str2 = "voice_bottle";
                    if (this.uPk) {
                        z = false;
                    } else {
                        z = true;
                    }
                    fVar2.aV(str2, z);
                    if (this.uPk) {
                        iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                        if (iconPreference != null) {
                            Kr = com.tencent.mm.u.h.xI();
                            if (Kr > 0) {
                                iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                            }
                            xP = com.tencent.mm.u.m.xP();
                            if (Kr > 0) {
                            }
                            iconPreference.As(8);
                        }
                    }
                }
            } else {
                w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.isJ.aV("voice_bottle", true);
            }
            if (d.Jt("game")) {
                this.isJ.aV("more_tab_game_recommend", false);
                kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    if (kVar.aBI()) {
                        bPg();
                    } else {
                        this.isJ.aV("more_tab_game_recommend", true);
                    }
                }
            } else {
                this.isJ.aV("more_tab_game_recommend", true);
            }
            if (d.Jt("scanner")) {
                this.isJ.aV("find_friends_by_qrcode", false);
            } else {
                this.isJ.aV("find_friends_by_qrcode", true);
            }
            this.isJ.aV("find_friends_by_facebook", true);
            ki(false);
            this.isJ.aV("settings_emoji_store", true);
            this.isJ.notifyDataSetChanged();
            if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                this.isJ.aV("ip_call_entrance", true);
                return;
            }
            this.isJ.aV("ip_call_entrance", false);
            iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                iconPreference.As(8);
            } else {
                iconPreference.As(0);
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
            }
            iconPreference.Ax(8);
            ap.yY();
            if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                iconPreference.kY(false);
                z3 = false;
            } else {
                iconPreference.kY(true);
                iconPreference.As(8);
                z3 = true;
            }
            ap.yY();
            str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            iconPreference.R(str, -1, -7566196);
            if (bg.mA(str)) {
                z2 = z3;
            }
            if (z2) {
                iconPreference.At(8);
            } else {
                iconPreference.At(0);
            }
            this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
        }
        fVar = this.isJ;
        str = "album_dyna_photo_ui_title";
        z = true;
        fVar.aV(str, z);
        if (d.Jt("nearby")) {
            this.isJ.aV("find_friends_by_near", false);
            iconPreference = (IconPreference) this.isJ.Td("find_friends_by_near");
            if (iconPreference != null) {
                iiVar = new ii();
                iiVar.fNT.fJA = 7;
                com.tencent.mm.sdk.b.a.urY.m(iiVar);
                if (iiVar.fNU.fFj) {
                    iconPreference.Aw(0);
                    iconPreference.Av(R.g.bgY);
                    iconPreference.vqU = new LayoutParams(-2, -2);
                    iconPreference.vqU.addRule(13);
                    if (iconPreference.nvU != null) {
                        iconPreference.nvU.setLayoutParams(iconPreference.vqU);
                    }
                } else {
                    iconPreference.Aw(8);
                }
                Kr = l.Kz().Kr();
                if (com.tencent.mm.az.a.bCj()) {
                    if (Kr <= 0) {
                        iconPreference.As(8);
                        iconPreference.cM("", -1);
                    } else {
                        iconPreference.As(0);
                        iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                    }
                } else if (Kr <= 0) {
                    iconPreference.Au(8);
                } else {
                    iconPreference.Au(0);
                }
                if ((com.tencent.mm.u.m.xW() & 512) != 0) {
                    z = false;
                } else {
                    z = true;
                }
                fVar = this.isJ;
                str = "find_friends_by_near";
                if (z) {
                    z = false;
                } else {
                    z = true;
                }
            }
            if (d.Jt("shake")) {
                fVar = this.isJ;
                str = "find_friends_by_shake";
                z = true;
            } else {
                this.isJ.aV("find_friends_by_shake", false);
                iconPreference = (IconPreference) this.isJ.Td("find_friends_by_shake");
                if (iconPreference != null) {
                    if ((com.tencent.mm.u.m.xW() & 256) != 0) {
                    }
                    if (z4) {
                        Kr2 = l.KA().Kr() + com.tencent.mm.pluginsdk.l.a.bCn().baL();
                        if (Kr2 <= 0) {
                            iconPreference.As(0);
                            iconPreference.cM(String.valueOf(Kr2), R.g.bkU);
                        } else {
                            iconPreference.As(8);
                            iconPreference.cM("", -1);
                        }
                        iconPreference.Aw(8);
                        com.tencent.mm.pluginsdk.l.a.bCn().baM();
                        if (com.tencent.mm.pluginsdk.l.a.bCn().baN()) {
                            z3 = com.tencent.mm.q.c.uk().aD(262154, 266258);
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            ap.yY();
                            str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                            if (TextUtils.isEmpty(str)) {
                                iconPreference.Au(8);
                                iconPreference.As(0);
                                iconPreference.cM(str, R.g.bkU);
                            } else if (Kr2 <= 0) {
                                iconPreference.Au(0);
                            } else {
                                iconPreference.Au(0);
                                iconPreference.As(8);
                                iconPreference.cM("", -1);
                            }
                        } else {
                            iconPreference.Au(8);
                        }
                        ap.yY();
                        ap = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
                        ap.yY();
                        valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                        ap.yY();
                        Kr = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                        if (valueOf.booleanValue()) {
                        }
                        iconPreference.At(8);
                    }
                    fVar2 = this.isJ;
                    str3 = "find_friends_by_shake";
                    if (z4) {
                        fVar = fVar2;
                        str = str3;
                        z = true;
                    } else {
                        fVar = fVar2;
                        str = str3;
                        z = false;
                    }
                }
                if (d.Jt("bottle")) {
                    w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                    this.isJ.aV("voice_bottle", true);
                } else {
                    this.isJ.aV("voice_bottle", false);
                    if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                        if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        this.uPk = z;
                        w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                        fVar2 = this.isJ;
                        str2 = "voice_bottle";
                        if (this.uPk) {
                            z = true;
                        } else {
                            z = false;
                        }
                        fVar2.aV(str2, z);
                        if (this.uPk) {
                            iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                            if (iconPreference != null) {
                                Kr = com.tencent.mm.u.h.xI();
                                if (Kr > 0) {
                                    iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                                }
                                xP = com.tencent.mm.u.m.xP();
                                if (Kr > 0) {
                                }
                                iconPreference.As(8);
                            }
                        }
                    }
                }
                if (d.Jt("game")) {
                    this.isJ.aV("more_tab_game_recommend", true);
                } else {
                    this.isJ.aV("more_tab_game_recommend", false);
                    kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                    if (kVar != null) {
                        if (kVar.aBI()) {
                            this.isJ.aV("more_tab_game_recommend", true);
                        } else {
                            bPg();
                        }
                    }
                }
                if (d.Jt("scanner")) {
                    this.isJ.aV("find_friends_by_qrcode", true);
                } else {
                    this.isJ.aV("find_friends_by_qrcode", false);
                }
                this.isJ.aV("find_friends_by_facebook", true);
                ki(false);
                this.isJ.aV("settings_emoji_store", true);
                this.isJ.notifyDataSetChanged();
                if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                    this.isJ.aV("ip_call_entrance", false);
                    iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
                    ap.yY();
                    if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                        iconPreference.As(0);
                        iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                    } else {
                        iconPreference.As(8);
                    }
                    iconPreference.Ax(8);
                    ap.yY();
                    if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                        iconPreference.kY(true);
                        iconPreference.As(8);
                        z3 = true;
                    } else {
                        iconPreference.kY(false);
                        z3 = false;
                    }
                    ap.yY();
                    str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                    iconPreference.R(str, -1, -7566196);
                    if (bg.mA(str)) {
                        z2 = z3;
                    }
                    if (z2) {
                        iconPreference.At(0);
                    } else {
                        iconPreference.At(8);
                    }
                    this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
                }
                this.isJ.aV("ip_call_entrance", true);
                return;
            }
            fVar.aV(str, z);
            if (d.Jt("bottle")) {
                this.isJ.aV("voice_bottle", false);
                if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                    if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.uPk = z;
                    w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                    fVar2 = this.isJ;
                    str2 = "voice_bottle";
                    if (this.uPk) {
                        z = false;
                    } else {
                        z = true;
                    }
                    fVar2.aV(str2, z);
                    if (this.uPk) {
                        iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                        if (iconPreference != null) {
                            Kr = com.tencent.mm.u.h.xI();
                            if (Kr > 0) {
                                iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                            }
                            xP = com.tencent.mm.u.m.xP();
                            if (Kr > 0) {
                            }
                            iconPreference.As(8);
                        }
                    }
                }
            } else {
                w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.isJ.aV("voice_bottle", true);
            }
            if (d.Jt("game")) {
                this.isJ.aV("more_tab_game_recommend", false);
                kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    if (kVar.aBI()) {
                        bPg();
                    } else {
                        this.isJ.aV("more_tab_game_recommend", true);
                    }
                }
            } else {
                this.isJ.aV("more_tab_game_recommend", true);
            }
            if (d.Jt("scanner")) {
                this.isJ.aV("find_friends_by_qrcode", false);
            } else {
                this.isJ.aV("find_friends_by_qrcode", true);
            }
            this.isJ.aV("find_friends_by_facebook", true);
            ki(false);
            this.isJ.aV("settings_emoji_store", true);
            this.isJ.notifyDataSetChanged();
            if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                this.isJ.aV("ip_call_entrance", true);
                return;
            }
            this.isJ.aV("ip_call_entrance", false);
            iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                iconPreference.As(8);
            } else {
                iconPreference.As(0);
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
            }
            iconPreference.Ax(8);
            ap.yY();
            if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                iconPreference.kY(false);
                z3 = false;
            } else {
                iconPreference.kY(true);
                iconPreference.As(8);
                z3 = true;
            }
            ap.yY();
            str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            iconPreference.R(str, -1, -7566196);
            if (bg.mA(str)) {
                z2 = z3;
            }
            if (z2) {
                iconPreference.At(8);
            } else {
                iconPreference.At(0);
            }
            this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
        }
        fVar = this.isJ;
        str = "find_friends_by_near";
        z = true;
        fVar.aV(str, z);
        if (d.Jt("shake")) {
            this.isJ.aV("find_friends_by_shake", false);
            iconPreference = (IconPreference) this.isJ.Td("find_friends_by_shake");
            if (iconPreference != null) {
                if ((com.tencent.mm.u.m.xW() & 256) != 0) {
                }
                if (z4) {
                    Kr2 = l.KA().Kr() + com.tencent.mm.pluginsdk.l.a.bCn().baL();
                    if (Kr2 <= 0) {
                        iconPreference.As(8);
                        iconPreference.cM("", -1);
                    } else {
                        iconPreference.As(0);
                        iconPreference.cM(String.valueOf(Kr2), R.g.bkU);
                    }
                    iconPreference.Aw(8);
                    com.tencent.mm.pluginsdk.l.a.bCn().baM();
                    if (com.tencent.mm.pluginsdk.l.a.bCn().baN()) {
                        z3 = false;
                    } else {
                        z3 = com.tencent.mm.q.c.uk().aD(262154, 266258);
                    }
                    if (z3) {
                        iconPreference.Au(8);
                    } else {
                        ap.yY();
                        str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_SHAKE_CARD_ENTRANCE_RED_DOT_TEXT_STRING_SYNC, (Object) "");
                        if (TextUtils.isEmpty(str)) {
                            iconPreference.Au(8);
                            iconPreference.As(0);
                            iconPreference.cM(str, R.g.bkU);
                        } else if (Kr2 <= 0) {
                            iconPreference.Au(0);
                            iconPreference.As(8);
                            iconPreference.cM("", -1);
                        } else {
                            iconPreference.Au(0);
                        }
                    }
                    ap.yY();
                    ap = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
                    ap.yY();
                    valueOf = Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false));
                    ap.yY();
                    Kr = ((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_SHAKE_TAB_DISPLAY_INT, Integer.valueOf(0))).intValue();
                    if (valueOf.booleanValue()) {
                    }
                    iconPreference.At(8);
                }
                fVar2 = this.isJ;
                str3 = "find_friends_by_shake";
                if (z4) {
                    fVar = fVar2;
                    str = str3;
                    z = false;
                } else {
                    fVar = fVar2;
                    str = str3;
                    z = true;
                }
            }
            if (d.Jt("bottle")) {
                w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
                this.isJ.aV("voice_bottle", true);
            } else {
                this.isJ.aV("voice_bottle", false);
                if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                    if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.uPk = z;
                    w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                    fVar2 = this.isJ;
                    str2 = "voice_bottle";
                    if (this.uPk) {
                        z = true;
                    } else {
                        z = false;
                    }
                    fVar2.aV(str2, z);
                    if (this.uPk) {
                        iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                        if (iconPreference != null) {
                            Kr = com.tencent.mm.u.h.xI();
                            if (Kr > 0) {
                                iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                            }
                            xP = com.tencent.mm.u.m.xP();
                            if (Kr > 0) {
                            }
                            iconPreference.As(8);
                        }
                    }
                }
            }
            if (d.Jt("game")) {
                this.isJ.aV("more_tab_game_recommend", true);
            } else {
                this.isJ.aV("more_tab_game_recommend", false);
                kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    if (kVar.aBI()) {
                        this.isJ.aV("more_tab_game_recommend", true);
                    } else {
                        bPg();
                    }
                }
            }
            if (d.Jt("scanner")) {
                this.isJ.aV("find_friends_by_qrcode", true);
            } else {
                this.isJ.aV("find_friends_by_qrcode", false);
            }
            this.isJ.aV("find_friends_by_facebook", true);
            ki(false);
            this.isJ.aV("settings_emoji_store", true);
            this.isJ.notifyDataSetChanged();
            if (com.tencent.mm.plugin.ipcall.d.aDM()) {
                this.isJ.aV("ip_call_entrance", false);
                iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
                ap.yY();
                if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                } else {
                    iconPreference.As(8);
                }
                iconPreference.Ax(8);
                ap.yY();
                if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                    iconPreference.kY(true);
                    iconPreference.As(8);
                    z3 = true;
                } else {
                    iconPreference.kY(false);
                    z3 = false;
                }
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
                iconPreference.R(str, -1, -7566196);
                if (bg.mA(str)) {
                    z2 = z3;
                }
                if (z2) {
                    iconPreference.At(0);
                } else {
                    iconPreference.At(8);
                }
                this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
            }
            this.isJ.aV("ip_call_entrance", true);
            return;
        }
        fVar = this.isJ;
        str = "find_friends_by_shake";
        z = true;
        fVar.aV(str, z);
        if (d.Jt("bottle")) {
            this.isJ.aV("voice_bottle", false);
            if (((IconPreference) this.isJ.Td("voice_bottle")) != null) {
                if ((com.tencent.mm.u.m.xW() & 64) != 0) {
                    z = false;
                } else {
                    z = true;
                }
                this.uPk = z;
                w.i("MicroMsg.FindMoreFriendsUI", "user enable bottle, %b", Boolean.valueOf(this.uPk));
                fVar2 = this.isJ;
                str2 = "voice_bottle";
                if (this.uPk) {
                    z = false;
                } else {
                    z = true;
                }
                fVar2.aV(str2, z);
                if (this.uPk) {
                    iconPreference = (IconPreference) this.isJ.Td("voice_bottle");
                    if (iconPreference != null) {
                        Kr = com.tencent.mm.u.h.xI();
                        if (Kr > 0) {
                            iconPreference.cM(String.valueOf(Kr), s.fg(this.uSU.uTo));
                        }
                        xP = com.tencent.mm.u.m.xP();
                        if (Kr > 0) {
                        }
                        iconPreference.As(8);
                    }
                }
            }
        } else {
            w.e("MicroMsg.FindMoreFriendsUI", "bottle plugin cannot loaded.");
            this.isJ.aV("voice_bottle", true);
        }
        if (d.Jt("game")) {
            this.isJ.aV("more_tab_game_recommend", false);
            kVar = com.tencent.mm.pluginsdk.l.a.sBw;
            if (kVar != null) {
                if (kVar.aBI()) {
                    bPg();
                } else {
                    this.isJ.aV("more_tab_game_recommend", true);
                }
            }
        } else {
            this.isJ.aV("more_tab_game_recommend", true);
        }
        if (d.Jt("scanner")) {
            this.isJ.aV("find_friends_by_qrcode", false);
        } else {
            this.isJ.aV("find_friends_by_qrcode", true);
        }
        this.isJ.aV("find_friends_by_facebook", true);
        ki(false);
        this.isJ.aV("settings_emoji_store", true);
        this.isJ.notifyDataSetChanged();
        if (com.tencent.mm.plugin.ipcall.d.aDM()) {
            this.isJ.aV("ip_call_entrance", true);
            return;
        }
        this.isJ.aV("ip_call_entrance", false);
        iconPreference = (IconPreference) this.isJ.Td("ip_call_entrance");
        ap.yY();
        if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() >= com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
            iconPreference.As(8);
        } else {
            iconPreference.As(0);
            iconPreference.cM(getString(R.l.dHO), R.g.bhC);
        }
        iconPreference.Ax(8);
        ap.yY();
        if (!((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            iconPreference.kY(false);
            z3 = false;
        } else {
            iconPreference.kY(true);
            iconPreference.As(8);
            z3 = true;
        }
        ap.yY();
        str = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
        iconPreference.R(str, -1, -7566196);
        if (bg.mA(str)) {
            z2 = z3;
        }
        if (z2) {
            iconPreference.At(8);
        } else {
            iconPreference.At(0);
        }
        this.isJ.a(new PreferenceSmallCategory(this.uSU.uTo));
    }

    public final void ki(boolean z) {
        String value;
        if (v.bIK()) {
            value = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigName");
        } else if (v.bIL()) {
            value = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.i.g.sV().getValue("JDEntranceConfigIconUrl");
        Object obj = 1;
        com.tencent.mm.pluginsdk.l.l lVar = aa.sBG;
        if (lVar != null) {
            String bmV = lVar.bmV();
            if (!(bg.mA(value) || bg.mA(value2) || bg.mA(bmV))) {
                Object obj2;
                CharSequence charSequence;
                IconPreference iconPreference;
                Bitmap gS;
                Bitmap gS2;
                com.tencent.mm.plugin.subapp.jdbiz.b bVar = (com.tencent.mm.plugin.subapp.jdbiz.b) lVar.bmW();
                if ((bVar.qSE < System.currentTimeMillis() / 1000 ? 1 : null) != null) {
                    if (bVar.qSF == 0 || bVar.qSF >= System.currentTimeMillis() / 1000) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        if (!bg.mA(bVar.iconUrl)) {
                            value2 = bVar.iconUrl;
                        }
                        if (!bg.mA(bVar.title)) {
                            charSequence = bVar.title;
                            iconPreference = (IconPreference) this.isJ.Td("jd_market_entrance");
                            n.GR();
                            gS = com.tencent.mm.ah.b.gS(value2);
                            if (gS == null) {
                                iconPreference.drawable = new BitmapDrawable(this.uSU.uTo.getResources(), gS);
                                this.uPn = null;
                            } else {
                                iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxx);
                                n.GV().a(value2, this.uPD);
                                this.uPn = value2;
                            }
                            iconPreference.setTitle(charSequence);
                            iconPreference.As(8);
                            iconPreference.Au(8);
                            iconPreference.At(8);
                            iconPreference.kY(false);
                            iconPreference.Ax(8);
                            if (lVar.bmN() && bVar.axD() && !bVar.bmF()) {
                                if (!bg.mA(bVar.qSA)) {
                                    iconPreference.As(8);
                                    iconPreference.Au(8);
                                    iconPreference.R(bVar.qSA, -1, -7566196);
                                    iconPreference.At(0);
                                }
                                if (!bg.mA(bVar.qSB)) {
                                    n.GR();
                                    gS2 = com.tencent.mm.ah.b.gS(bVar.qSB);
                                    iconPreference.Ax(0);
                                    iconPreference.Aw(0);
                                    iconPreference.Ay(0);
                                    iconPreference.kY(false);
                                    if (gS2 == null) {
                                        this.uPq = null;
                                        iconPreference.P(gS2);
                                    } else {
                                        n.GV().a(bVar.qSB, this.uPD);
                                        this.uPq = bVar.qSB;
                                    }
                                } else if (!bg.mA(bVar.qSA)) {
                                    iconPreference.kY(true);
                                } else if (bVar.qSz) {
                                    iconPreference.Au(0);
                                    iconPreference.cM("", -1);
                                    iconPreference.As(8);
                                }
                            }
                            this.isJ.aV("jd_market_entrance", false);
                            if (z) {
                                this.isJ.notifyDataSetChanged();
                            }
                            if (!this.uPr) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11178, bmV, lVar.bmW().bmH(), Integer.valueOf(bPe()));
                                this.uPr = true;
                            }
                            obj = null;
                        }
                    }
                }
                obj2 = value;
                iconPreference = (IconPreference) this.isJ.Td("jd_market_entrance");
                n.GR();
                gS = com.tencent.mm.ah.b.gS(value2);
                if (gS == null) {
                    iconPreference.drawable = com.tencent.mm.bg.a.a(this.uSU.uTo, R.k.dxx);
                    n.GV().a(value2, this.uPD);
                    this.uPn = value2;
                } else {
                    iconPreference.drawable = new BitmapDrawable(this.uSU.uTo.getResources(), gS);
                    this.uPn = null;
                }
                iconPreference.setTitle(charSequence);
                iconPreference.As(8);
                iconPreference.Au(8);
                iconPreference.At(8);
                iconPreference.kY(false);
                iconPreference.Ax(8);
                if (bg.mA(bVar.qSA)) {
                    iconPreference.As(8);
                    iconPreference.Au(8);
                    iconPreference.R(bVar.qSA, -1, -7566196);
                    iconPreference.At(0);
                }
                if (!bg.mA(bVar.qSB)) {
                    n.GR();
                    gS2 = com.tencent.mm.ah.b.gS(bVar.qSB);
                    iconPreference.Ax(0);
                    iconPreference.Aw(0);
                    iconPreference.Ay(0);
                    iconPreference.kY(false);
                    if (gS2 == null) {
                        n.GV().a(bVar.qSB, this.uPD);
                        this.uPq = bVar.qSB;
                    } else {
                        this.uPq = null;
                        iconPreference.P(gS2);
                    }
                } else if (!bg.mA(bVar.qSA)) {
                    iconPreference.kY(true);
                } else if (bVar.qSz) {
                    iconPreference.Au(0);
                    iconPreference.cM("", -1);
                    iconPreference.As(8);
                }
                this.isJ.aV("jd_market_entrance", false);
                if (z) {
                    this.isJ.notifyDataSetChanged();
                }
                if (this.uPr) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11178, bmV, lVar.bmW().bmH(), Integer.valueOf(bPe()));
                    this.uPr = true;
                }
                obj = null;
            }
        }
        if (obj != null) {
            this.isJ.aV("jd_market_entrance", true);
        }
    }

    public static int bPe() {
        com.tencent.mm.pluginsdk.l.l lVar = aa.sBG;
        if (lVar == null) {
            return 1;
        }
        e bmW = lVar.bmW();
        if (!lVar.bmN() || !bmW.axD() || bmW.bmF()) {
            return 1;
        }
        if (TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL.equals(bmW.bmK()) && !bg.mA(bmW.bmL())) {
            return 6;
        }
        if (!bg.mA(bmW.bmI())) {
            return 3;
        }
        if (bmW.bmJ()) {
            return 2;
        }
        return 1;
    }

    public final boolean a(f fVar, Preference preference) {
        Intent intent;
        com.tencent.mm.sdk.b.b hkVar;
        if ("album_dyna_photo_ui_title".equals(preference.igL)) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                boolean z;
                com.tencent.mm.plugin.report.service.f.rY(10);
                ap.yY();
                this.uPl = (String) com.tencent.mm.u.c.vr().get(68377, null);
                intent = new Intent();
                com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b(701, 1);
                bVar.bp(!bg.mA(this.uPl));
                bVar.kG(this.uPm);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.putExtra("is_from_find_more", true);
                String str = "enter_by_red";
                if (!bg.mA(this.uPl) || this.uPm > 0) {
                    z = true;
                } else {
                    z = false;
                }
                intent.putExtra(str, z);
                ap.yY();
                intent.putExtra("is_sns_notify_open", bg.b((Boolean) com.tencent.mm.u.c.vr().get(68384, null), true));
                intent.putExtra("sns_unread_count", com.tencent.mm.plugin.sns.b.m.pQC.Kr());
                if (!bg.mA(this.uPl)) {
                    ap.yY();
                    intent.putExtra("new_feed_id", bg.ap((String) com.tencent.mm.u.c.vr().get(68418, null), ""));
                }
                bVar.b(intent, "enter_log");
                hkVar = new hk();
                com.tencent.mm.sdk.b.a.urY.m(hkVar);
                if (hkVar.fMQ.fMR) {
                    z = true;
                } else {
                    if (bg.mA(this.uPl)) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (com.tencent.mm.plugin.sns.b.m.pQC != null) {
                        this.uPm = com.tencent.mm.plugin.sns.b.m.pQC.Kr();
                        if (this.uPm > 0) {
                            z = false;
                        }
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(68377, "");
                }
                ap.yY();
                com.tencent.mm.u.c.vr().set(589825, Boolean.valueOf(false));
                intent.putExtra("sns_resume_state", z);
                d.b(this.uSU.uTo, "sns", ".ui.En_424b8e16", intent);
                com.tencent.mm.plugin.report.service.g.oUh.A(10958, "1");
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ g uPE;

                    {
                        this.uPE = r1;
                    }

                    public final void run() {
                        Intent intent = new Intent();
                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
                        this.uPE.sendBroadcast(intent);
                    }
                }, 500);
                return true;
            }
            com.tencent.mm.ui.base.s.eP(this.uSU.uTo);
            return true;
        } else if ("find_friends_by_near".equals(preference.igL)) {
            w.i("MicroMsg.FindMoreFriendsUI", "summerper checkPermission checkLocation[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)));
            if (!com.tencent.mm.pluginsdk.i.a.a(bPj(), "android.permission.ACCESS_COARSE_LOCATION", 66, null, null)) {
                return true;
            }
            bPf();
            return true;
        } else if ("find_friends_by_shake".equals(preference.igL)) {
            if (!this.uPs && com.tencent.mm.u.m.yt().booleanValue()) {
                r0 = (IconPreference) fVar.Td("find_friends_by_shake");
                if (r0 != null) {
                    r0.Au(8);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(340231, Boolean.valueOf(true));
                    ap.yY();
                    com.tencent.mm.u.c.vr().jY(true);
                    com.tencent.mm.plugin.report.service.g.oUh.a(232, 4, 1, false);
                }
            }
            com.tencent.mm.plugin.report.service.g.oUh.A(10958, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
            ap.yY();
            r1 = bg.ap((String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_BEACONINFO_STRING, null), "");
            ap.yY();
            Boolean valueOf = (!Boolean.valueOf(bg.b((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, null), false)).booleanValue() || r1 == null || r1.equals("")) ? Boolean.valueOf(false) : Boolean.valueOf(true);
            if (valueOf.booleanValue()) {
                com.tencent.mm.plugin.report.service.g.oUh.i(12653, Integer.valueOf(2), Integer.valueOf(2));
            }
            com.tencent.mm.sdk.b.a.urY.m(new mk());
            d.w(this.uSU.uTo, "shake", ".ui.ShakeReportUI");
            return true;
        } else if ("voice_bottle".equals(preference.igL)) {
            com.tencent.mm.plugin.report.service.g.oUh.A(10958, "5");
            com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
            if (bg.a(Integer.valueOf(zL.gkr), 0) <= 0 || bg.mA(zL.getProvince())) {
                d.w(this.uSU.uTo, "bottle", ".ui.BottleWizardStep1");
                return true;
            }
            d.w(this.uSU.uTo, "bottle", ".ui.BottleBeachUI");
            return true;
        } else if ("find_friends_by_qrcode".equals(preference.igL)) {
            if (com.tencent.mm.n.a.aI(this.uSU.uTo) || com.tencent.mm.n.a.aH(this.uSU.uTo)) {
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.A(10958, "2");
            r0 = new Intent();
            r0.putExtra("BaseScanUI_qrcode_right_btn_direct_album", true);
            com.tencent.mm.plugin.report.service.g.oUh.i(11265, Integer.valueOf(2));
            d.b(this.uSU.uTo, "scanner", ".ui.BaseScanUI", r0);
            return true;
        } else if (preference.igL.equals("more_tab_game_recommend")) {
            com.tencent.mm.plugin.report.service.g.oUh.A(10958, "6");
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                intent = new Intent();
                intent.putExtra("from_find_more_friend", this.uPu);
                intent.putExtra("game_report_from_scene", 901);
                if (this.uPu) {
                    com.tencent.mm.sdk.b.b ljVar = new lj();
                    com.tencent.mm.sdk.b.a.urY.m(ljVar);
                    r0 = (IconPreference) fVar.Td("more_tab_game_recommend");
                    if (!(ljVar.fSk.fSl == null || r0 == null)) {
                        n.GW().hIc.a(new com.tencent.mm.ah.a.c(r0.nvU, ljVar.fSk.fSl));
                    }
                }
                d.b(this.uSU.uTo, "game", ".ui.GameCenterUI", intent);
                return true;
            }
            com.tencent.mm.ui.base.s.eP(this.uSU.uTo);
            return true;
        } else if ("find_friends_by_micromsg".equals(preference.igL)) {
            d.b(this.uSU.uTo, "subapp", ".ui.pluginapp.ContactSearchUI", new Intent());
            return true;
        } else if ("find_friends_by_mobile".equals(preference.igL)) {
            if (com.tencent.mm.modelfriend.m.Fl() != com.tencent.mm.modelfriend.m.a.SUCC) {
                r0 = new Intent(this.uSU.uTo, BindMContactIntroUI.class);
                r0.putExtra("key_upload_scene", 6);
                MMWizardActivity.z(this.uSU.uTo, r0);
                return true;
            }
            startActivity(new Intent(this.uSU.uTo, MobileFriendUI.class));
            return true;
        } else if ("find_friends_by_facebook".equals(preference.igL)) {
            startActivity(new Intent(this.uSU.uTo, FacebookFriendUI.class));
            return true;
        } else if ("settings_mm_card_package".equals(preference.igL)) {
            d.w(this.uSU.uTo, "card", ".ui.CardHomePageUI");
            return true;
        } else if (preference.igL.equals("jd_market_entrance")) {
            com.tencent.mm.pluginsdk.wallet.f.xT(9);
            com.tencent.mm.pluginsdk.l.l lVar = aa.sBG;
            if (lVar != null) {
                r0 = aa.sBG.bmV();
                com.tencent.mm.plugin.report.service.g.oUh.i(11179, r0, lVar.bmW().bmH(), Integer.valueOf(bPe()));
                lVar.bmQ();
                lVar.bmP();
                ((IconPreference) preference).cM("", -1);
                if (!bg.mA(r0)) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("KPublisherId", "jd_store");
                    d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }
            } else {
                r0 = null;
            }
            w.i("MicroMsg.FindMoreFriendsUI", "jump to url: " + r0);
            return true;
        } else if ("ip_call_entrance".equals(preference.igL)) {
            boolean z2;
            r0 = (IconPreference) fVar.Td("ip_call_entrance");
            r0.Au(8);
            r0.At(8);
            r0.kY(false);
            r0.Ax(8);
            ap.yY();
            r0 = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            ap.yY();
            if (((Boolean) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
                i.D(1, -1, -1);
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_NEWXML_BOOLEAN, Boolean.valueOf(false));
                z2 = true;
            } else {
                z2 = false;
            }
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(0))).intValue() < com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13254, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(-1), Integer.valueOf(-1), Integer.valueOf(-1));
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_REDDOT_INT, Integer.valueOf(com.tencent.mm.i.g.sV().getInt("WCOEntranceRedDot", 0)));
                z2 = true;
            }
            if (!bg.mA(r0)) {
                ap.yY();
                com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_FIND_WORDING_STRING, (Object) "");
            }
            if (z2) {
                com.tencent.mm.sdk.b.a.urY.m(new qw());
            }
            if (com.tencent.mm.n.a.tQ()) {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, R.l.eCb, 0, null, null);
                return true;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(12061, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
            d.b(this.uSU.uTo, "ipcall", ".ui.IPCallAddressUI", new Intent());
            return true;
        } else if ("app_brand_entrance".equals(preference.igL)) {
            if (this.uPw) {
                return true;
            }
            d.w(this.uSU.uTo, "appbrand", ".ui.AppBrandLauncherUI");
            this.uPw = true;
            return true;
        } else if ("find_friends_by_search".equals(preference.igL)) {
            if (com.tencent.mm.as.d.Ii()) {
                r1 = j.kb("discoverSearchEntry").optString("wording");
                if (bg.mA(r1)) {
                    w.e("MicroMsg.FindMoreFriendsUI", "empty title");
                    return true;
                }
                r0 = m.Iw();
                r2 = r0.hQm;
                r2.hQp &= -2;
                r0.save();
                ((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs1de6f3");
                com.tencent.mm.as.i.c("", 0, 0, 20);
                r2 = com.tencent.mm.as.d.Il();
                r2.putExtra("ftsbizscene", 20);
                r3 = com.tencent.mm.as.d.a(20, true, 0);
                r0 = com.tencent.mm.as.d.gm(bg.PY((String) r3.get("scene")));
                r3.put("sessionId", r0);
                r2.putExtra("title", r1);
                r2.putExtra("ftsneedkeyboard", true);
                r2.putExtra("ftssessionid", r0);
                r2.putExtra("rawUrl", com.tencent.mm.as.d.m(r3));
                r2.putExtra("key_load_js_without_delay", true);
                d.b(this.uSU.uTo, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", r2);
                return true;
            }
            w.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            return true;
        } else if (!"find_friends_by_look".equals(preference.igL)) {
            return false;
        } else {
            if (com.tencent.mm.as.d.Ii()) {
                r1 = j.kb("discoverRecommendEntry").optString("wording");
                if (bg.mA(r1)) {
                    w.e("MicroMsg.FindMoreFriendsUI", "empty query");
                    return true;
                }
                w.i("MicroMsg.FindMoreFriendsUI", "look one look clikced");
                r0 = m.Iw();
                r2 = r0.hQm;
                r2.hQp &= -3;
                r0.save();
                ((com.tencent.mm.plugin.welab.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.welab.a.a.a.class)).open("labs_browse");
                r2 = com.tencent.mm.as.d.Il();
                r2.putExtra("ftsbizscene", 21);
                r2.putExtra("ftsQuery", r1);
                r2.putExtra("title", r1);
                r2.putExtra("isWebwx", r1);
                r2.putExtra("ftscaneditable", false);
                r2.putExtra("key_load_js_without_delay", true);
                r3 = com.tencent.mm.as.d.a(21, false, 2);
                r3.put("query", r1);
                r3.put("sceneActionType", "2");
                r3.put("sessionId", com.tencent.mm.as.d.gm(bg.PY((String) r3.get("scene"))));
                r2.putExtra("rawUrl", com.tencent.mm.as.d.m(r3));
                hkVar = new kh();
                hkVar.fQJ.scene = 0;
                com.tencent.mm.sdk.b.a.urY.m(hkVar);
                d.b(this.uSU.uTo, "webview", ".ui.tools.fts.FTSWebViewUI", r2);
                com.tencent.mm.as.i.q(21, r1);
                com.tencent.mm.as.i.aX(21, 0);
                return true;
            }
            w.e("MicroMsg.FindMoreFriendsUI", "fts h5 template not avail");
            return true;
        }
    }

    public final void bPf() {
        com.tencent.mm.plugin.report.service.g.oUh.A(10958, "4");
        ap.yY();
        if (bg.f((Boolean) com.tencent.mm.u.c.vr().get(4103, null))) {
            com.tencent.mm.u.bg zM = com.tencent.mm.u.bg.zM();
            if (zM == null) {
                d.w(this.uSU.uTo, "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            String mz = bg.mz(zM.getProvince());
            int a = bg.a(Integer.valueOf(zM.gkr), 0);
            if (bg.mA(mz) || a == 0) {
                d.w(this.uSU.uTo, "nearby", ".ui.NearbyPersonalInfoUI");
                return;
            }
            ap.yY();
            Boolean bool = (Boolean) com.tencent.mm.u.c.vr().get(4104, null);
            if (bool == null || !bool.booleanValue()) {
                LauncherUI launcherUI = (LauncherUI) this.uSU.uTo;
                if (launcherUI != null) {
                    launcherUI.uRM.SD("tab_find_friend");
                }
                com.tencent.mm.az.a.dl(this.uSU.uTo);
                return;
            }
            if (this.uPj == null) {
                this.uPj = View.inflate(this.uSU.uTo, R.i.dgJ, null);
                this.nVW = (CheckBox) this.uPj.findViewById(R.h.caW);
                this.nVW.setChecked(false);
            }
            if (this.nVY == null) {
                this.nVY = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.dIO), this.uPj, new OnClickListener(this) {
                    final /* synthetic */ g uPE;

                    {
                        this.uPE = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (this.uPE.nVW != null) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(4104, Boolean.valueOf(!this.uPE.nVW.isChecked()));
                        }
                        LauncherUI launcherUI = (LauncherUI) this.uPE.uSU.uTo;
                        if (launcherUI != null) {
                            launcherUI.uRM.SD("tab_find_friend");
                        }
                        com.tencent.mm.az.a.dl(this.uPE.uSU.uTo);
                    }
                }, null);
                return;
            } else {
                this.nVY.show();
                return;
            }
        }
        d.w(this.uSU.uTo, "nearby", ".ui.NearbyFriendsIntroUI");
    }

    final void bPg() {
        IconPreference iconPreference = (IconPreference) this.isJ.Td("more_tab_game_recommend");
        if (iconPreference != null) {
            final com.tencent.mm.sdk.b.b ljVar = new lj();
            com.tencent.mm.sdk.b.a.urY.m(ljVar);
            iconPreference.Au(8);
            String str = ljVar.fSk.fSm;
            String str2 = ljVar.fSk.appId;
            int i = ljVar.fSk.msgType;
            String str3 = ljVar.fSk.fDE;
            if (ljVar.fSk.showType == 1) {
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                b(str2, i, str, str3, ljVar.fSk.showType);
            } else if (ljVar.fSk.showType == 2) {
                iconPreference.R(eR(ljVar.fSk.appName, ljVar.fSk.appId), -1, Color.parseColor("#8c8c8c"));
                a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                b(str2, i, str, str3, ljVar.fSk.showType);
            } else if (ljVar.fSk.showType == 3) {
                if (bg.mA(ljVar.fSk.fSl)) {
                    iconPreference.P(com.tencent.mm.pluginsdk.model.app.g.b(ljVar.fSk.appId, 1, com.tencent.mm.bg.a.getDensity(this.uSU.uTo)));
                    a(iconPreference, 8, 8, 8, false, 0, 0, 0);
                    return;
                }
                com.tencent.mm.ah.a.a GW = n.GW();
                String str4 = ljVar.fSk.fSl;
                r6 = iconPreference;
                r7 = str2;
                r8 = i;
                r9 = str;
                r10 = str3;
                GW.a(str4, iconPreference.nvU, new com.tencent.mm.ah.a.c.g(this) {
                    final /* synthetic */ g uPE;

                    public final void jK(String str) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 uPL;

                            {
                                this.uPL = r1;
                            }

                            public final void run() {
                                this.uPL.uPE.uPu = false;
                                g.a((IconPreference) this.uPL.uPE.isJ.Td("more_tab_game_recommend"), 8, 8, 8, false, 8, 8, 8);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass6 uPL;

                                {
                                    this.uPL = r1;
                                }

                                public final void run() {
                                    this.uPL.uPE.uPu = true;
                                    IconPreference iconPreference = (IconPreference) this.uPL.uPE.isJ.Td("more_tab_game_recommend");
                                    iconPreference.cM(this.uPL.uPE.getString(R.l.dHO), R.g.bhC);
                                    g.a(iconPreference, 0, 8, 8, false, 8, 8, 8);
                                    this.uPL.uPE.b(r7, r8, r9, r10, 1);
                                }
                            });
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 uPL;

                            public final void run() {
                                this.uPL.uPE.uPu = true;
                                r6.P(bitmap);
                                g.a(r6, 8, 8, 8, false, 0, 0, 0);
                                this.uPL.uPE.b(r7, r8, r9, r10, ljVar.fSk.showType);
                            }
                        });
                    }
                });
            } else if (ljVar.fSk.showType == 4) {
                final String eR = eR(ljVar.fSk.appName, ljVar.fSk.appId);
                if (bg.mA(eR)) {
                    this.uPu = true;
                    a(iconPreference, 8, 8, 8, false, 8, 8, 8);
                    return;
                }
                iconPreference.R(eR, -1, Color.parseColor("#8c8c8c"));
                if (bg.mA(ljVar.fSk.fSl)) {
                    iconPreference.P(com.tencent.mm.pluginsdk.model.app.g.b(ljVar.fSk.appId, 1, com.tencent.mm.bg.a.getDensity(this.uSU.uTo)));
                    a(iconPreference, 8, 8, 0, false, 0, 0, 0);
                    return;
                }
                com.tencent.mm.ah.a.a GW2 = n.GW();
                String str5 = ljVar.fSk.fSl;
                r6 = iconPreference;
                r7 = str2;
                r8 = i;
                r9 = str;
                r10 = str3;
                GW2.a(str5, iconPreference.nvU, new com.tencent.mm.ah.a.c.g(this) {
                    final /* synthetic */ g uPE;

                    public final void jK(String str) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 uPM;

                            {
                                this.uPM = r1;
                            }

                            public final void run() {
                                this.uPM.uPE.uPu = false;
                                g.a((IconPreference) this.uPM.uPE.isJ.Td("more_tab_game_recommend"), 8, 8, 8, false, 8, 8, 8);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                        if (bVar.status != 0 || bVar.bitmap == null) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass7 uPM;

                                {
                                    this.uPM = r1;
                                }

                                public final void run() {
                                    this.uPM.uPE.uPu = true;
                                    IconPreference iconPreference = (IconPreference) this.uPM.uPE.isJ.Td("more_tab_game_recommend");
                                    iconPreference.R(eR, -1, Color.parseColor("#8c8c8c"));
                                    g.a(iconPreference, 8, 8, 0, true, 8, 8, 8);
                                    this.uPM.uPE.b(r7, r8, r9, r10, 2);
                                }
                            });
                            return;
                        }
                        final Bitmap bitmap = bVar.bitmap;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 uPM;

                            public final void run() {
                                this.uPM.uPE.uPu = true;
                                r6.P(bitmap);
                                g.a(r6, 8, 8, 0, false, 0, 0, 0);
                                this.uPM.uPE.b(r7, r8, r9, r10, ljVar.fSk.showType);
                            }
                        });
                    }
                });
            } else if (ljVar.fSk.showType == 5) {
                this.uPu = true;
                a(iconPreference, 8, 0, 8, false, 8, 8, 8);
                b(str2, i, str, str3, ljVar.fSk.showType);
            } else {
                this.uPu = true;
                a(iconPreference, 8, 8, 8, false, 8, 8, 8);
            }
        }
    }

    public final void b(String str, int i, String str2, String str3, int i2) {
        if (str2 != null && !str2.equals(this.uPv)) {
            String encode;
            this.uPv = str2;
            com.tencent.mm.sdk.b.b mmVar = new mm();
            mmVar.fTK.scene = 9;
            mmVar.fTK.fTL = 901;
            mmVar.fTK.action = 1;
            mmVar.fTK.appId = str;
            mmVar.fTK.msgType = i;
            mmVar.fTK.fSm = str2;
            mmVar.fTK.fDE = str3;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("function_type", "resource");
                jSONObject.put("function_value", String.valueOf(i2));
            } catch (JSONException e) {
                w.e("MicroMsg.FindMoreFriendsUI", e.getMessage());
            }
            try {
                encode = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e2) {
                UnsupportedEncodingException unsupportedEncodingException = e2;
                encode = "";
                w.e("MicroMsg.FindMoreFriendsUI", unsupportedEncodingException.getMessage());
            }
            mmVar.fTK.fTM = encode;
            com.tencent.mm.sdk.b.a.urY.m(mmVar);
        }
    }

    private String eR(String str, String str2) {
        return !bg.mA(str) ? str : com.tencent.mm.pluginsdk.model.app.g.m(this.uSU.uTo, str2);
    }

    public static void a(IconPreference iconPreference, int i, int i2, int i3, boolean z, int i4, int i5, int i6) {
        iconPreference.As(i);
        iconPreference.Au(i2);
        iconPreference.At(i3);
        iconPreference.kY(z);
        iconPreference.Ax(i4);
        iconPreference.Aw(i5);
        iconPreference.Ay(i6);
    }

    public final void yL() {
        if ((com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            this.uPm++;
            WS();
        }
    }

    public final void yM() {
        if ((com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            WS();
        }
    }

    public final void yN() {
    }

    public final void yP() {
        if (this.isJ != null) {
            WS();
        }
    }

    protected final void bOl() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab create");
        this.isJ = this.vrv;
        w.i("MicroMsg.FindMoreFriendsUI", "on tab create end");
    }

    protected final void bOm() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab resume");
        com.tencent.mm.pluginsdk.e.a.a(id.class.getName(), this.sRX);
        com.tencent.mm.pluginsdk.e.a.a(gm.class.getName(), this.uPA);
        com.tencent.mm.pluginsdk.e.a.a(oe.class.getName(), this.uPB);
        com.tencent.mm.sdk.b.a.urY.b(this.uPy);
        com.tencent.mm.sdk.b.a.urY.b(this.uPx);
        com.tencent.mm.sdk.b.a.urY.b(this.uPz);
        com.tencent.mm.sdk.b.a.urY.b(this.pWv);
        com.tencent.mm.sdk.b.a.urY.b(this.uPC);
        com.tencent.mm.sdk.b.a.urY.a(this.pgl);
        l.KA().c(this);
        ap.yY();
        com.tencent.mm.u.c.wW().a(this);
        ap.yY();
        com.tencent.mm.u.c.a(this);
        ap.yY();
        com.tencent.mm.u.c.vr().a(this);
        if (com.tencent.mm.plugin.sns.b.m.pQE != null) {
            com.tencent.mm.plugin.sns.b.m.pQE.a(this);
        }
        WS();
        final View findViewById = findViewById(R.h.cbT);
        if (!(findViewById == null || findViewById.getVisibility() == 8)) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ g uPE;

                public final void run() {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this.uPE.uSU.uTo, R.a.aQY));
                }
            });
        }
        bPc();
        bPd();
        w.i("MicroMsg.FindMoreFriendsUI", "on tab resume end");
    }

    protected final void bOn() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab start");
    }

    protected final void bOo() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab pause");
        if (ap.zb()) {
            com.tencent.mm.pluginsdk.e.a.b(id.class.getName(), this.sRX);
            com.tencent.mm.pluginsdk.e.a.b(gm.class.getName(), this.uPA);
            com.tencent.mm.pluginsdk.e.a.b(oe.class.getName(), this.uPB);
            com.tencent.mm.sdk.b.a.urY.c(this.uPy);
            com.tencent.mm.sdk.b.a.urY.c(this.uPx);
            com.tencent.mm.sdk.b.a.urY.c(this.uPz);
            com.tencent.mm.sdk.b.a.urY.c(this.pWv);
            com.tencent.mm.sdk.b.a.urY.c(this.uPC);
            com.tencent.mm.sdk.b.a.urY.c(this.pgl);
            l.KA().f(this);
            ap.yY();
            com.tencent.mm.u.c.wW().b(this);
            ap.yY();
            com.tencent.mm.u.c.b(this);
            ap.yY();
            com.tencent.mm.u.c.vr().b(this);
            if (this.uPn != null) {
                n.GR().jm(this.uPn);
            }
            if (this.uPq != null) {
                n.GR().jm(this.uPq);
            }
        }
        if (com.tencent.mm.plugin.sns.b.m.pQE != null) {
            com.tencent.mm.plugin.sns.b.m.pQE.b(this);
        }
    }

    protected final void bOp() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab stop");
    }

    protected final void bOq() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab destroy");
    }

    public final void bOs() {
        w.i("MicroMsg.FindMoreFriendsUI", "turn to bg");
    }

    public final void bOt() {
        w.i("MicroMsg.FindMoreFriendsUI", "turn to fg");
    }

    public final void bOv() {
        w.i("MicroMsg.FindMoreFriendsUI", "on tab recreate ui");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        WS();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        WS();
    }

    public final void bPh() {
        j.gt(20);
        bPd();
        bPc();
    }

    public final void yO() {
        if ((com.tencent.mm.u.m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
            if (com.tencent.mm.plugin.sns.b.m.pQC != null) {
                this.uPm = com.tencent.mm.plugin.sns.b.m.pQC.Kr();
            }
            WS();
        }
    }
}
