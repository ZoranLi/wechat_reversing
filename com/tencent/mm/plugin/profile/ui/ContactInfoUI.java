package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelstat.d;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.protocal.c.my;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.x.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public class ContactInfoUI extends MMPreference implements a, j.a, b {
    private f isJ;
    private x jiL;
    private String ktm = "";
    private com.tencent.mm.pluginsdk.d.a osL;
    private boolean osM;
    private boolean osN;
    private int osO;
    private String osP;
    private byte[] osQ;
    private boolean osR = false;
    String osS = null;
    private String osT = "";
    private boolean osU = false;

    public final int ON() {
        return R.o.ftF;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bDZ()) {
            w.i("MicroMsg.ContactInfoUI", "onCreate MMCore.accHasReady[%b]", new Object[]{Boolean.valueOf(ap.zb())});
            this.osS = getIntent().getStringExtra("Contact_Search_Mobile");
            ap.yY();
            c.wR().a(this);
            ap.yY();
            c.wS().a(this);
            KC();
            return;
        }
        w.e("MicroMsg.ContactInfoUI", "onCreate acc not ready finish");
        w.bIQ();
        finish();
        g.oUh.a(598, 8, 1, false);
    }

    public void onDestroy() {
        ap.yY();
        c.wR().b(this);
        ap.yY();
        c.wS().b(this);
        if (this.osL != null) {
            this.osL.adI();
        }
        if (m.pQA != null) {
            m.pQA.Q(this);
        }
        super.onDestroy();
    }

    public void onResume() {
        d.a(3, "ContactInfoUI" + aFO(), hashCode());
        com.tencent.mm.modelbiz.w.DH().c(this);
        super.onResume();
        View focusedChild = ((ViewGroup) this.uSU.ipu).getFocusedChild();
        if (focusedChild != null) {
            focusedChild.clearFocus();
            w.i("MicroMsg.ContactInfoUI", "try to clear focus. id:%s", new Object[]{Integer.valueOf(focusedChild.getId())});
        }
    }

    protected void onRestart() {
        super.onRestart();
        this.osU = false;
    }

    public void onPause() {
        d.a(4, "ContactInfoUI" + aFO(), hashCode());
        com.tencent.mm.modelbiz.w.DH().f(this);
        super.onPause();
        ap.vL().H(new Runnable(this) {
            final /* synthetic */ ContactInfoUI osV;

            {
                this.osV = r1;
            }

            public final void run() {
                ap.yY();
                c.vr().jY(true);
            }
        });
    }

    protected final String aFO() {
        if (this.jiL == null || ((int) this.jiL.gTQ) == 0 || bg.mA(this.jiL.field_username)) {
            return "";
        }
        w.i("MicroMsg.ContactInfoUI", "getIdentString %s", new Object[]{this.jiL.field_username});
        if (e.dr(this.jiL.field_username)) {
            return "_EnterpriseChat";
        }
        if (e.ib(this.jiL.field_username)) {
            return "_EnterpriseFatherBiz";
        }
        if (e.ia(this.jiL.field_username)) {
            return "_EnterpriseChildBiz";
        }
        if (this.jiL.bLe()) {
            return "_bizContact";
        }
        if (o.dH(this.jiL.field_username)) {
            return "_chatroom";
        }
        if (o.eO(this.jiL.field_username)) {
            return "_bottle";
        }
        if (o.eP(this.jiL.field_username)) {
            return "_QQ";
        }
        if (o.fE(this.jiL.field_username)) {
            return "_" + this.jiL.field_username;
        }
        return "";
    }

    protected final void KC() {
        String str;
        this.isJ = this.vrv;
        this.isJ.removeAll();
        this.osO = getIntent().getIntExtra("Contact_Scene", 9);
        this.osP = getIntent().getStringExtra("Verify_ticket");
        this.osM = getIntent().getBooleanExtra("Chat_Readonly", false);
        this.osN = getIntent().getBooleanExtra("User_Verify", false);
        this.ktm = getIntent().getStringExtra("Contact_ChatRoomId");
        String mz = bg.mz(getIntent().getStringExtra("Contact_User"));
        String mz2 = bg.mz(getIntent().getStringExtra("Contact_Alias"));
        String mz3 = bg.mz(getIntent().getStringExtra("Contact_Encryptusername"));
        if (mz.endsWith("@stranger")) {
            mz3 = mz;
        }
        ap.yY();
        this.jiL = c.wR().Rc(mz);
        if (this.jiL != null) {
            this.jiL.uIG = mz;
        }
        com.tencent.mm.plugin.profile.a.imw.a(this.jiL);
        String stringExtra = getIntent().getStringExtra("Contact_Nick");
        int intExtra = getIntent().getIntExtra("Contact_Sex", 0);
        String stringExtra2 = getIntent().getStringExtra("Contact_Province");
        String stringExtra3 = getIntent().getStringExtra("Contact_City");
        String stringExtra4 = getIntent().getStringExtra("Contact_Signature");
        int intExtra2 = getIntent().getIntExtra("Contact_VUser_Info_Flag", 0);
        String stringExtra5 = getIntent().getStringExtra("Contact_VUser_Info");
        String stringExtra6 = getIntent().getStringExtra("Contact_Distance");
        int intExtra3 = getIntent().getIntExtra("Contact_KWeibo_flag", 0);
        String stringExtra7 = getIntent().getStringExtra("Contact_KWeibo");
        String stringExtra8 = getIntent().getStringExtra("Contact_KWeiboNick");
        String stringExtra9 = getIntent().getStringExtra("Contact_KFacebookName");
        long longExtra = getIntent().getLongExtra("Contact_KFacebookId", 0);
        this.osT = getIntent().getStringExtra("Contact_BrandIconURL");
        String stringExtra10 = getIntent().getStringExtra("Contact_RegionCode");
        this.osQ = getIntent().getByteArrayExtra("Contact_customInfo");
        int intExtra4 = getIntent().getIntExtra("Contact_Ext_Flag", 0);
        boolean booleanExtra = getIntent().getBooleanExtra("force_get_contact", false);
        w.i("MicroMsg.ContactInfoUI", "dkverify forceAddContact:%s  user:%s  roomid:%s ", new Object[]{Boolean.valueOf(booleanExtra), mz, this.ktm});
        if (booleanExtra) {
            w.d("MicroMsg.ContactInfoUI", "initView, forceAddContact, user = " + mz);
            if (this.jiL == null || !com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                ag.a.hlS.J(mz, "");
            } else {
                ag.a.hlS.J(mz, this.ktm);
            }
        }
        if (this.jiL != null && ((int) this.jiL.gTQ) > 0 && (!o.fF(this.jiL.field_username) || (x.QO(this.jiL.field_username) && !o.eT(this.jiL.field_username)))) {
            BizInfo hW = e.hW(this.jiL.field_username);
            Object obj = (this.jiL.bLe() && com.tencent.mm.modelbiz.a.Cy()) ? 1 : null;
            if (hW == null || (hW.CB() && obj == null)) {
                w.d("MicroMsg.ContactInfoUI", "update contact, verifyFlag %d.", new Object[]{Integer.valueOf(intExtra2)});
                ag.a.hlS.J(this.jiL.field_username, com.tencent.mm.j.a.ez(this.jiL.field_type) ? "" : this.ktm);
                com.tencent.mm.x.b.he(this.jiL.field_username);
            } else if (this.jiL.bLh() && obj == null) {
                w.d("MicroMsg.ContactInfoUI", "update contact, last check time=%d", new Object[]{Integer.valueOf(this.jiL.gkI)});
                ag.b bVar = ag.a.hlS;
                String str2 = this.jiL.field_username;
                if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                    str = "";
                } else {
                    str = this.ktm;
                }
                bVar.J(str2, str);
                com.tencent.mm.x.b.he(this.jiL.field_username);
            }
        }
        int intExtra5 = getIntent().getIntExtra("Contact_verify_Scene", 9);
        if (this.jiL == null || ((int) this.jiL.gTQ) == 0 || bg.mz(this.jiL.field_username).length() <= 0) {
            this.jiL = new x();
            this.jiL.setUsername(mz);
            this.jiL.bO(mz2);
            this.jiL.bR(stringExtra);
            this.jiL.bS(getIntent().getStringExtra("Contact_PyInitial"));
            this.jiL.bT(getIntent().getStringExtra("Contact_QuanPin"));
            this.jiL.di(intExtra);
            this.jiL.cf(stringExtra2);
            this.jiL.cg(stringExtra3);
            this.jiL.ce(stringExtra4);
            this.jiL.de(intExtra2);
            this.jiL.cj(stringExtra5);
            this.jiL.ch(stringExtra6);
            this.jiL.do(intExtra5);
            this.jiL.ci(stringExtra7);
            this.jiL.dd(intExtra3);
            this.jiL.bU(stringExtra8);
            this.jiL.r(longExtra);
            this.jiL.bZ(stringExtra9);
            this.jiL.ck(stringExtra10);
            this.jiL.dr(intExtra4);
            if (!bg.mA(this.osS) && this.osO == 15) {
                ap.yY();
                bb AI = c.wS().AI(mz);
                com.tencent.mm.sdk.e.c bbVar = new bb(mz);
                bbVar.field_conRemark = AI.field_conRemark;
                bbVar.field_conDescription = AI.field_conDescription;
                bbVar.field_contactLabels = AI.field_contactLabels;
                bbVar.field_conPhone = this.osS;
                ap.yY();
                c.wS().a(bbVar);
                this.osS = null;
            }
        } else {
            if (this.jiL.gkr == 0) {
                this.jiL.di(intExtra);
            }
            if (!(stringExtra2 == null || stringExtra2.equals(""))) {
                this.jiL.cf(stringExtra2);
            }
            if (!(stringExtra3 == null || stringExtra3.equals(""))) {
                this.jiL.cg(stringExtra3);
            }
            if (stringExtra10 != null) {
                if (!stringExtra10.equals("")) {
                    this.jiL.ck(stringExtra10);
                }
            }
            if (!(!bg.mA(this.jiL.signature) || stringExtra4 == null || stringExtra4.equals(""))) {
                this.jiL.ce(stringExtra4);
            }
            if (intExtra2 != 0) {
                this.jiL.de(intExtra2);
            }
            if (!(!bg.mA(this.jiL.gkG) || stringExtra5 == null || stringExtra5.equals(""))) {
                this.jiL.cj(stringExtra5);
            }
            if (!(!bg.mA(this.jiL.field_nickname) || stringExtra == null || stringExtra.equals(""))) {
                this.jiL.bR(stringExtra);
            }
            w.i("MicroMsg.ContactInfoUI", "searchMobilePhone:%s", new Object[]{bg.mz(this.osS)});
            if (!bg.mA(this.osS) && this.osO == 15) {
                obj = 1;
                stringExtra = this.jiL.gkQ;
                if (stringExtra != null) {
                    for (String str3 : this.jiL.gkQ.split(",")) {
                        if (str3.equals(this.osS)) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                    }
                }
                if (obj != null) {
                    this.jiL.cr(stringExtra + this.osS + ",");
                    this.osS = null;
                }
                w.i("MicroMsg.ContactInfoUI", "contact PhoneList:%s", new Object[]{bg.mz(this.jiL.gkQ)});
                this.jiL.setSource(15);
            }
            this.jiL.ch(stringExtra6);
            this.jiL.do(intExtra5);
            this.jiL.r(longExtra);
            this.jiL.bZ(stringExtra9);
        }
        if (!bg.mA(mz3)) {
            this.jiL.bX(mz3);
        }
        if (this.jiL == null) {
            w.e("MicroMsg.ContactInfoUI", "contact = null");
        } else {
            bb AI2;
            if (!bg.mA(mz3)) {
                ap.yY();
                AI2 = c.wS().AI(mz3);
                if (!(AI2 == null || bg.mA(AI2.field_encryptUsername))) {
                    this.jiL.bP(AI2.field_conRemark);
                }
            }
            if (!bg.mA(mz)) {
                ap.yY();
                AI2 = c.wS().AI(mz);
                if (!(AI2 == null || bg.mA(AI2.field_encryptUsername))) {
                    this.jiL.bP(AI2.field_conRemark);
                }
            }
        }
        getIntent().putExtra("Contact_User", this.jiL.field_username);
        if (!booleanExtra && ((int) this.jiL.gTQ) <= 0 && this.jiL.bLe() && (this.osO == 17 || this.osO == 41)) {
            w.d("MicroMsg.ContactInfoUI", "come from card, getContact %s", new Object[]{this.jiL.field_username});
            ag.a.hlS.J(this.jiL.field_username, "");
            com.tencent.mm.x.b.he(this.jiL.field_username);
        }
        str3 = "MicroMsg.ContactInfoUI";
        mz2 = "contact.getRemarkDesc() (%s, %s, %s)";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.jiL.gkK == null);
        objArr[1] = Integer.valueOf(this.jiL.gkK == null ? 0 : this.jiL.gkK.length());
        if (this.jiL.gkK == null) {
            mz3 = "";
        } else {
            mz3 = bg.Qj(this.jiL.gkK);
        }
        objArr[2] = mz3;
        w.i(str3, mz2, objArr);
        if (!booleanExtra && ((int) this.jiL.gTQ) <= 0 && this.osO == 34) {
            w.i("MicroMsg.ContactInfoUI", "come from chatroom accessverify, getContact %s", new Object[]{this.jiL.field_username});
            ag.a.hlS.K(this.jiL.field_username, getIntent().getStringExtra("key_add_contact_verify_ticket"));
            com.tencent.mm.x.b.u(this.jiL.field_username, 3);
        }
        if (this.jiL.field_username.equals(com.tencent.mm.u.m.xL())) {
            x xVar;
            ap.yY();
            long j = bg.getLong((String) c.vr().get(65825, null), 0);
            if (j > 0) {
                this.jiL.r(j);
                xVar = this.jiL;
                ap.yY();
                xVar.bZ((String) c.vr().get(65826, null));
            }
            xVar = this.jiL;
            ap.yY();
            xVar.cn((String) c.vr().get(286721, null));
            xVar = this.jiL;
            ap.yY();
            xVar.co((String) c.vr().get(286722, null));
            xVar = this.jiL;
            ap.yY();
            xVar.cp((String) c.vr().get(286723, null));
        }
        if (this.jiL.field_username != null && this.jiL.field_username.equals(x.QR(com.tencent.mm.u.m.xL()))) {
            com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
            str3 = bg.mz(zL.getProvince());
            mz2 = bg.mz(zL.getCity());
            if (!bg.mA(str3)) {
                this.jiL.cf(str3);
            }
            if (!bg.mA(mz2)) {
                this.jiL.cg(mz2);
            }
            if (!bg.mA(zL.countryCode)) {
                this.jiL.ck(RegionCodeDecoder.ab(zL.countryCode, zL.hnP, zL.hnO));
            }
            int a = bg.a(Integer.valueOf(zL.gkr), 0);
            mz3 = bg.mz(zL.signature);
            this.jiL.di(a);
            this.jiL.ce(mz3);
        }
        if (bg.mA(this.jiL.field_username)) {
            w.e("MicroMsg.ContactInfoUI", "username is null %s", new Object[]{mz});
            finish();
            return;
        }
        zi(o.fE(this.jiL.field_username) ? R.l.eTF : R.l.eal);
        if (o.dH(this.jiL.field_username)) {
            zi(R.l.dZs);
        }
        str3 = this.osT;
        if (o.eR(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "sport");
        } else if (o.eY(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "qqmail");
        } else if (o.eZ(this.jiL.field_username)) {
            this.osL = new e(this);
            zi(R.l.eTF);
        } else if (o.fb(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "bottle");
            zi(R.l.eTF);
        } else if (o.fa(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "tmessage");
            zi(R.l.eTF);
        } else if (o.eS(this.jiL.field_username)) {
            this.osL = new h(this);
        } else if (o.fg(this.jiL.field_username)) {
            this.osL = new m(this);
        } else if (x.eO(this.jiL.field_username)) {
            this.osL = new d(this);
        } else if (o.fi(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "nearby");
        } else if (o.fj(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "shake");
        } else if (o.fk(this.jiL.field_username)) {
            this.osL = new j(this);
        } else if (o.fl(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.x(this, "readerapp", "widget_type_news");
        } else if (o.ft(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.x(this, "readerapp", "widget_type_weibo");
        } else if (o.fd(this.jiL.field_username)) {
            this.osL = new f(this);
        } else if (o.fe(this.jiL.field_username)) {
            this.osL = com.tencent.mm.bb.d.N(this, "masssend");
        } else if (o.ff(this.jiL.field_username)) {
            this.osL = new g(this);
        } else if (this.jiL.bLe()) {
            my myVar;
            try {
                myVar = this.osQ == null ? null : (my) new my().aD(this.osQ);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ContactInfoUI", e, "", new Object[0]);
                myVar = null;
            }
            com.tencent.mm.pluginsdk.d.a cVar = new c(this, str3, myVar);
            if (!bg.mA(this.osP)) {
                cVar.osP = this.osP;
            }
            this.osL = cVar;
        } else if (o.fo(this.jiL.field_username)) {
            this.osL = new n(this);
        } else if (o.fp(this.jiL.field_username)) {
            this.osL = new i(this);
        } else {
            this.osL = new k(this);
        }
        if (this.osL != null) {
            this.osL.a(this.isJ, this.jiL, this.osM, this.osO);
            str3 = bg.mz(af.FY().iZ(this.jiL.field_username).EX()).replace(" ", "");
            if (!this.osU && com.tencent.mm.j.a.ez(this.jiL.field_type) && (this.osL instanceof k)) {
                int i;
                int i2;
                if (bg.mA(this.jiL.gkQ)) {
                    i = 0;
                } else {
                    i = this.jiL.gkQ.split(",").length;
                }
                if (bg.mA(str3)) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                i2 += i;
                g gVar = g.oUh;
                Object[] objArr2 = new Object[4];
                objArr2[0] = this.jiL.field_username;
                objArr2[1] = Integer.valueOf(1);
                if (bg.mA(str3)) {
                    i = 0;
                } else {
                    i = 1;
                }
                objArr2[2] = Integer.valueOf(i);
                if (i2 >= 5) {
                    i = 5;
                } else {
                    i = i2;
                }
                objArr2[3] = Integer.valueOf(i);
                gVar.i(12040, objArr2);
                this.osU = true;
            }
            if (!((this.osL instanceof k) || (this.osL instanceof c))) {
                ap.yY();
                mz3 = (String) c.vr().get(com.tencent.mm.storage.w.a.uHw, "");
                if (mz3.contains(this.jiL.field_username)) {
                    mz3 = mz3.replaceAll(this.jiL.field_username + ",*", "");
                    ap.yY();
                    c.vr().a(com.tencent.mm.storage.w.a.uHw, mz3);
                    w.i("MicroMsg.ContactInfoUI", "mark plugin read, userName:%s, newVal:%s", new Object[]{this.jiL.field_username, mz3});
                    if (bg.mA(mz3)) {
                        com.tencent.mm.q.c.uk().t(262158, false);
                    }
                }
            }
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactInfoUI osV;

            {
                this.osV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if ((o.fk(this.osV.jiL.field_username) && !com.tencent.mm.u.m.yf()) || ((o.fc(this.osV.jiL.field_username) && !com.tencent.mm.u.m.yb()) || ((o.fe(this.osV.jiL.field_username) && !com.tencent.mm.u.m.yl()) || (o.eY(this.osV.jiL.field_username) && !com.tencent.mm.u.m.yn())))) {
                    Intent intent = new Intent();
                    intent.addFlags(67108864);
                    com.tencent.mm.plugin.profile.a.imv.t(intent, this.osV);
                }
                this.osV.finish();
                return true;
            }
        });
        n.Bz().hg(this.jiL.field_username);
        if ((o.fk(this.jiL.field_username) && com.tencent.mm.u.m.yf()) || ((o.fc(this.jiL.field_username) && com.tencent.mm.u.m.yb()) || ((o.fe(this.jiL.field_username) && com.tencent.mm.u.m.yl()) || (o.eY(this.jiL.field_username) && com.tencent.mm.u.m.yn())))) {
            this.osR = true;
        } else {
            this.osR = false;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.osL != null) {
            this.osL.onActivityResult(i, i2, intent);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.ContactInfoUI", str + " item has been clicked!");
        if (this.osL != null) {
            this.osL.sa(str);
        }
        return false;
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.ContactInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(final String str, l lVar) {
        new ae().post(new Runnable(this) {
            final /* synthetic */ ContactInfoUI osV;

            public final void run() {
                w.d("MicroMsg.ContactInfoUI", "onNotifyChange verify:%b, contact.user:%s, notify.user:%s", new Object[]{Boolean.valueOf(this.osV.osN), this.osV.jiL.field_username, str});
                if (this.osV.jiL != null && !bg.mA(this.osV.jiL.field_username)) {
                    if (this.osV.jiL.field_username.equals(str) || this.osV.jiL.field_username.equals(x.QR(str))) {
                        if (this.osV.osL != null) {
                            this.osV.osL.adI();
                            this.osV.isJ.removeAll();
                        }
                        this.osV.KC();
                    }
                }
            }
        });
    }

    public final void a(final bb bbVar) {
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ ContactInfoUI osV;

            public final void run() {
                if (this.osV.jiL != null && bbVar != null && !bg.mA(this.osV.jiL.field_username) && this.osV.jiL.field_username.equals(bbVar.field_encryptUsername) && !o.fF(this.osV.jiL.field_username)) {
                    this.osV.jiL.bP(bbVar.field_conRemark);
                    this.osV.getIntent().putExtra("Contact_User", this.osV.jiL.field_username);
                    if (this.osV.osL != null) {
                        this.osV.osL.adI();
                        this.osV.isJ.removeAll();
                    }
                    this.osV.KC();
                }
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.ContactInfoUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        NormalUserFooterPreference normalUserFooterPreference;
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.aTG();
                        return;
                    }
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ ContactInfoUI osV;

                        {
                            this.osV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.osV.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ ContactInfoUI osV;

                        {
                            this.osV = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (iArr[0] == 0) {
                    normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
                    if (normalUserFooterPreference != null) {
                        normalUserFooterPreference.aTF();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                    final /* synthetic */ ContactInfoUI osV;

                    {
                        this.osV = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.osV.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }
}
