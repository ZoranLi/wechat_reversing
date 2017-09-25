package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.gv;
import com.tencent.mm.e.a.jj;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.e.a.qk;
import com.tencent.mm.e.a.re;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.report.kvdata.IMBehavior;
import com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.preference.RoomCardPreference;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.ajc;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.i;
import com.tencent.mm.u.j;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ChatroomInfoUI extends MMPreference implements m, com.tencent.mm.sdk.e.j.a, b, e {
    private static boolean ktG = false;
    private boolean fOg;
    private ae handler = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ ChatroomInfoUI ktJ;

        public final void handleMessage(Message message) {
            ChatroomInfoUI.a(this.ktJ);
        }
    };
    private SharedPreferences hgx = null;
    private f isJ;
    private p isP = null;
    private ProgressDialog isv = null;
    private boolean jWp = false;
    private x jiL;
    private boolean kmK;
    private boolean ksZ;
    int ktA;
    String ktB;
    private c ktC = new c<kr>(this) {
        final /* synthetic */ ChatroomInfoUI ktJ;

        {
            this.ktJ = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kr krVar = (kr) bVar;
            CharSequence charSequence = krVar.fRk.fRm;
            int i = krVar.fRk.ret;
            if (i == 0 || charSequence == null) {
                if (i == 0 && this.ktJ.kty) {
                    if (this.ktJ.ktA == 27) {
                        com.tencent.mm.sdk.b.a.urY.m(new re());
                        this.ktJ.jiL.bR(this.ktJ.ktB);
                        ap.yY();
                        com.tencent.mm.u.c.wR().Q(this.ktJ.jiL);
                        this.ktJ.ajo();
                    } else if (this.ktJ.ktA == 48 && this.ktJ.ktr != null) {
                        this.ktJ.ktr.field_chatroomname = this.ktJ.ktm;
                        this.ktJ.ktr.field_selfDisplayName = this.ktJ.ktF;
                        ap.yY();
                        com.tencent.mm.u.c.xa().c(this.ktJ.ktr, new String[0]);
                        this.ktJ.ajl();
                    }
                }
            } else if (this.ktJ.ktz != null && this.ktJ.ktA == 27) {
                ap.yY();
                com.tencent.mm.u.c.wQ().c(this.ktJ.ktz);
            } else if (this.ktJ.ktE != null && this.ktJ.ktA == 48) {
                ap.yY();
                com.tencent.mm.u.c.wQ().c(this.ktJ.ktE);
                Toast.makeText(this.ktJ.uSU.uTo, charSequence, 1).show();
            }
            if (this.ktJ.isP != null) {
                this.ktJ.isP.dismiss();
            }
            return false;
        }
    };
    private String ktD = "";
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a ktE;
    private String ktF;
    private String ktH = null;
    private com.tencent.mm.pluginsdk.e.b ktI = new com.tencent.mm.pluginsdk.e.b(this) {
        final /* synthetic */ ChatroomInfoUI ktJ;

        {
            this.ktJ = r2;
        }

        public final void a(int i, int i2, String str, com.tencent.mm.sdk.b.b bVar) {
            if (bVar instanceof jj) {
                jj jjVar = (jj) bVar;
                w.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
                if (this.ktJ.isv != null) {
                    this.ktJ.isv.dismiss();
                }
                if (i == 0 && i2 == 0) {
                    if (i == 0 && i2 == 0 && this.ktJ.ktf != null) {
                        ArrayList ad = ChatroomInfoUI.ad(jjVar.fPO.fPA);
                        ContactListExpandPreference m = this.ktJ.ktf;
                        if (m.sNk != null) {
                            com.tencent.mm.pluginsdk.ui.applet.f fVar = m.sNk.sMx;
                            fVar.ad(ad);
                            fVar.notifyChanged();
                        }
                        if (this.ktJ.isJ != null) {
                            this.ktJ.isJ.notifyDataSetChanged();
                        }
                        this.ktJ.qP(this.ktJ.getResources().getQuantityString(R.j.dsB, ad.size(), new Object[]{Integer.valueOf(ad.size())}));
                    }
                    this.ktJ.ajj();
                } else if (i2 == -21) {
                    g.a(this.ktJ, this.ktJ.getString(R.l.eMD), this.ktJ.getString(R.l.dIO), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass23 ktW;

                        {
                            this.ktW = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.ktW.ktJ.finish();
                        }
                    });
                } else {
                    g.b(this.ktJ, this.ktJ.getString(R.l.eMF), this.ktJ.getString(R.l.dIO), true);
                }
            }
        }
    };
    private RoomCardPreference kta;
    private SignaturePreference ktb;
    private Preference ktc;
    private NormalIconPreference ktd;
    private NormalIconPreference kte;
    private ContactListExpandPreference ktf;
    private CheckBoxPreference ktg;
    private CheckBoxPreference kth;
    private CheckBoxPreference kti;
    private SignaturePreference ktj;
    private CheckBoxPreference ktk;
    private boolean ktl;
    private String ktm;
    private boolean ktn;
    private boolean kto = false;
    private int ktp;
    private boolean ktq = false;
    private q ktr = null;
    private int kts = -1;
    private boolean ktt = true;
    private d ktu = new d(new OnScrollListener(this) {
        final /* synthetic */ ChatroomInfoUI ktJ;

        {
            this.ktJ = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ktv = false;
    private c ktw = new c<gv>(this) {
        final /* synthetic */ ChatroomInfoUI ktJ;

        {
            this.ktJ = r2;
            this.usg = gv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            if (((gv) bVar) instanceof gv) {
                this.ktJ.ajd();
            }
            return false;
        }
    };
    int ktx = -1;
    private boolean kty = false;
    private com.tencent.mm.plugin.messenger.foundation.a.a.e.a ktz;

    static class a implements OnCancelListener {
        a() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            ChatroomInfoUI.ktG = true;
        }
    }

    static /* synthetic */ void a(jj jjVar) {
        jjVar.fPN.fPm = true;
        com.tencent.mm.sdk.b.a.urY.m(jjVar);
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI) {
        chatroomInfoUI.ajj();
        ap.yY();
        String fY = com.tencent.mm.u.c.xa().fY(chatroomInfoUI.ktm);
        if (chatroomInfoUI.ktH != null && !chatroomInfoUI.ktH.equals(fY)) {
            chatroomInfoUI.ajq();
        }
    }

    static /* synthetic */ void a(ChatroomInfoUI chatroomInfoUI, String str) {
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 4, 1, true);
        chatroomInfoUI.ktF = str;
        String xL = com.tencent.mm.u.m.xL();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ama = new ama();
        com_tencent_mm_protocal_c_ama.ttq = chatroomInfoUI.ktm;
        com_tencent_mm_protocal_c_ama.jNj = xL;
        com_tencent_mm_protocal_c_ama.tqa = bg.mz(str);
        chatroomInfoUI.ktE = new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(48, com_tencent_mm_protocal_c_ama);
        chatroomInfoUI.ktA = 48;
        Context context = chatroomInfoUI.uSU.uTo;
        chatroomInfoUI.getString(R.l.dIO);
        chatroomInfoUI.isP = g.a(context, chatroomInfoUI.getString(R.l.dXM), false, null);
        chatroomInfoUI.kty = true;
        ap.yY();
        com.tencent.mm.u.c.wQ().b(chatroomInfoUI.ktE);
    }

    static /* synthetic */ boolean a(ChatroomInfoUI chatroomInfoUI, int i, int i2, String str) {
        w.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        w.d("MicroMsg.ChatroomInfoUI", "pre is " + chatroomInfoUI.ktp);
        chatroomInfoUI.ktp = j.eC(chatroomInfoUI.ktm);
        w.d("MicroMsg.ChatroomInfoUI", "now is " + chatroomInfoUI.ktp);
        if (chatroomInfoUI.isv != null) {
            chatroomInfoUI.isv.dismiss();
        }
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn == null) {
            return false;
        }
        dn.a(chatroomInfoUI, null, null);
        return true;
    }

    static /* synthetic */ void x(ChatroomInfoUI chatroomInfoUI) {
        ap.yY();
        long j = com.tencent.mm.u.c.wT().Ah(chatroomInfoUI.ktm).field_msgSvrId;
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.d(chatroomInfoUI.ktm, j));
        chatroomInfoUI.jWp = false;
        chatroomInfoUI.getString(R.l.dIO);
        final ProgressDialog a = g.a(chatroomInfoUI, chatroomInfoUI.getString(R.l.dJd), true, new OnCancelListener(chatroomInfoUI) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            {
                this.ktJ = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.ktJ.jWp = true;
            }
        });
        if (i.er(chatroomInfoUI.ktm)) {
            com.tencent.mm.plugin.chatroom.a.imw.bp(chatroomInfoUI.ktm);
        }
        ay.a(chatroomInfoUI.ktm, new com.tencent.mm.u.ay.a(chatroomInfoUI) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            public final boolean zs() {
                return this.ktJ.jWp;
            }

            public final void zr() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.b(chatroomInfoUI.ktm));
        ap.yY();
        com.tencent.mm.u.c.wW().Rl(chatroomInfoUI.ktm);
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.c(chatroomInfoUI.ktm));
        ap.yY();
        com.tencent.mm.plugin.messenger.foundation.a.a.d wQ = com.tencent.mm.u.c.wQ();
        ap.yY();
        wQ.b(new com.tencent.mm.ao.p((String) com.tencent.mm.u.c.vr().get(2, null), chatroomInfoUI.ktm));
        j.ey(chatroomInfoUI.ktm);
        Intent intent = new Intent();
        intent.addFlags(67108864);
        com.tencent.mm.plugin.chatroom.a.imv.t(intent, chatroomInfoUI.uSU.uTo);
        chatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(223, this);
        ap.vd().a(179, this);
        ap.vd().a(480, this);
        ap.vd().a(610, this);
        com.tencent.mm.pluginsdk.e.b.a(jj.class.getName(), this.ktI);
        this.ktw.bIy().a(this);
        this.ktC.bIy().a(this);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this);
        ap.yY();
        com.tencent.mm.u.c.xa().c(this);
        if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
            com.tencent.mm.pluginsdk.l.a.sBr.a(this);
        }
        this.ktm = getIntent().getStringExtra("RoomInfo_Id");
        ap.yY();
        this.jiL = com.tencent.mm.u.c.wR().Rc(this.ktm);
        this.ktt = true;
        this.fOg = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ksZ = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.ktD = getPackageName() + "_preferences";
        if (this.fOg) {
            ap.yY();
            this.ktr = com.tencent.mm.u.c.xa().fV(this.ktm);
        }
        KC();
        if (this.fOg) {
            final com.tencent.mm.u.ag.b.a anonymousClass22 = new com.tencent.mm.u.ag.b.a(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final void p(final String str, boolean z) {
                    if (z && this.ktJ.ktm.equals(str)) {
                        ap.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass22 ktV;

                            public final void run() {
                                ap.yY();
                                com.tencent.mm.u.c.xa().g(str, System.currentTimeMillis());
                            }

                            public final String toString() {
                                return super.toString() + "|getContactCallBack";
                            }
                        });
                    }
                }
            };
            if (this.ktr == null) {
                com.tencent.mm.u.ag.a.hlS.a(this.ktm, "", anonymousClass22);
            } else if (System.currentTimeMillis() - this.ktr.field_modifytime >= 86400000) {
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ ChatroomInfoUI ktJ;

                    public final void run() {
                        com.tencent.mm.u.ag.a.hlS.a(this.ktJ.ktr.field_chatroomname, "", anonymousClass22);
                    }

                    public final String toString() {
                        return super.toString() + "|getContactCallBack2";
                    }
                });
            }
        }
    }

    private void ajd() {
        w.i("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] :%s", new Object[]{this.ktm});
        new com.tencent.mm.plugin.chatroom.d.c(this.ktm).BC().c(this).e(new com.tencent.mm.vending.c.a<com.tencent.mm.y.a.a<wq>, com.tencent.mm.y.a.a<wq>>(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            {
                this.ktJ = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
                if (ChatroomInfoUI.a(this.ktJ, aVar.errType, aVar.errCode, aVar.fPf)) {
                    return null;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i != 0 || i2 != 0) {
                    w.e("MicroMsg.ChatroomInfoUI", "[doChatroomDetailCgi] roomId:%s", new Object[]{this.ktJ.ktm});
                    return null;
                } else if (i != 0 || i2 != 0) {
                    return aVar;
                } else {
                    String str = ((wq) aVar.fYb).tDl;
                    int i3 = ((wq) aVar.fYb).tDm;
                    long j = (long) ((wq) aVar.fYb).tDo;
                    String str2 = ((wq) aVar.fYb).tDn;
                    w.i("MicroMsg.ChatroomInfoUI", "dz[onSceneEnd : get announcement successfully!] roomId:%s newVersion:%s AnnouncementPublishTime:%s", new Object[]{this.ktJ.ktm, Integer.valueOf(i3), Long.valueOf(j)});
                    j.a(this.ktJ.ktm, bg.mz(str), str2, j, i3);
                    return aVar;
                }
            }
        }).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<wq>>(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            {
                this.ktJ = r1;
            }

            public final /* synthetic */ Object call(Object obj) {
                com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
                if (aVar == null) {
                    return wCE;
                }
                int i = aVar.errType;
                int i2 = aVar.errCode;
                if (i == 0 && i2 == 0) {
                    if (this.ktJ.ktr != null) {
                        this.ktJ.ktp = this.ktJ.ktr.DU().size();
                    }
                    if ((!this.ktJ.kto && this.ktJ.ktp >= com.tencent.mm.pluginsdk.ui.applet.f.sMG) || (this.ktJ.kto && this.ktJ.ktp >= com.tencent.mm.pluginsdk.ui.applet.f.sMG - 1)) {
                        this.ktJ.isJ.aV("see_room_member", false);
                        this.ktJ.ktc.setTitle(this.ktJ.getString(R.l.eQk));
                    }
                }
                this.ktJ.ajn();
                this.ktJ.ajo();
                this.ktJ.ajj();
                return wCE;
            }
        });
    }

    public void onResume() {
        boolean q;
        String stringExtra;
        super.onResume();
        ap.vd().a(120, this);
        this.isJ.notifyDataSetChanged();
        if (this.ktr != null) {
            com.tencent.mm.g.a.a.a bKY = this.ktr.bKY();
            if (bKY != null) {
                q = j.q(this.ktr.field_chatroomname, bKY.gMW);
                w.i("MicroMsg.ChatroomInfoUI", "roomId:%s newVer:%s localVer:%s owner:%s", new Object[]{this.ktr.field_chatroomname, Integer.valueOf(bKY.gMW), Integer.valueOf(this.ktr.field_chatroomVersion), this.ktr.field_roomowner});
                if (j.ev(this.ktm) || r0) {
                    ajd();
                }
                ajn();
                ajj();
                ajm();
                if (this.fOg) {
                    ajo();
                    ajl();
                }
                if (this.ktt) {
                    ajk();
                    this.ktt = false;
                }
                stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
                if (!this.ktv) {
                    if (!bg.mA(stringExtra)) {
                        to(stringExtra);
                    }
                    this.ktv = true;
                }
                if (!bg.mA(stringExtra) && stringExtra.equals("room_notify_new_notice") && !this.ktv) {
                    to("room_card");
                    this.ktv = true;
                    return;
                }
                return;
            }
        }
        q = false;
        ajd();
        ajn();
        ajj();
        ajm();
        if (this.fOg) {
            ajo();
            ajl();
        }
        if (this.ktt) {
            ajk();
            this.ktt = false;
        }
        stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
        if (this.ktv) {
            if (bg.mA(stringExtra)) {
                to(stringExtra);
            }
            this.ktv = true;
        }
        if (!bg.mA(stringExtra)) {
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.ktf.notifyChanged();
    }

    private void to(String str) {
        final int Tf = this.isJ.Tf(str);
        this.mUX.smoothScrollToPosition(Tf);
        new ae().postDelayed(new Runnable(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            public final void run() {
                View a = ((com.tencent.mm.ui.base.preference.a) this.ktJ.isJ).a(Tf, this.ktJ.mUX);
                if (a != null) {
                    com.tencent.mm.ui.h.a.b(this.ktJ.uSU.uTo, a);
                }
            }
        }, 10);
    }

    public void onPause() {
        super.onPause();
        ap.vd().b(120, this);
        if (this.ktq && this.fOg && this.ktr != null) {
            j.a(this.ktm, this.ktr, this.ktl);
        }
    }

    public void onDestroy() {
        if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
            com.tencent.mm.pluginsdk.l.a.sBr.a(this);
        }
        com.tencent.mm.ui.h.a.dismiss();
        ap.vd().b(223, this);
        ap.vd().b(179, this);
        ap.vd().b(480, this);
        ap.vd().b(610, this);
        com.tencent.mm.sdk.b.a.urY.c(this.ktC);
        com.tencent.mm.sdk.b.a.urY.c(this.ktw);
        com.tencent.mm.pluginsdk.e.b.b(jj.class.getName(), this.ktI);
        if (ap.zb()) {
            ap.yY();
            com.tencent.mm.u.c.wR().b(this);
            ap.yY();
            com.tencent.mm.u.c.xa().f(this);
        }
        if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
            com.tencent.mm.pluginsdk.l.a.sBr.b(this);
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        final String stringExtra;
        switch (i) {
            case 1:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    ap.yY();
                    q fV = com.tencent.mm.u.c.xa().fV(this.ktm);
                    if (fV == null) {
                        return;
                    }
                    if (fV.bKV() != 2 || this.kto) {
                        n(stringExtra, null, R.l.dCi);
                        return;
                    } else {
                        com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, getString(R.l.eLG), getString(R.l.eIw), getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                            final /* synthetic */ ChatroomInfoUI ktJ;

                            public final void a(boolean z, String str, int i) {
                                if (z) {
                                    this.ktJ.n(stringExtra, str, R.l.etf);
                                }
                            }
                        });
                        return;
                    }
                }
                return;
            case 2:
                if (i2 == -1) {
                    finish();
                    return;
                }
                return;
            case 4:
                if (i2 == -1) {
                    stringExtra = intent.getStringExtra("room_name");
                    if (!bg.mA(stringExtra)) {
                        com.tencent.mm.sdk.b.a.urY.m(new re());
                        this.jiL.bR(stringExtra);
                        ap.yY();
                        com.tencent.mm.u.c.wR().Q(this.jiL);
                        ajo();
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (i2 == 0) {
                    this.ktx = -1;
                    return;
                }
                return;
            case 7:
                if (intent != null) {
                    stringExtra = intent.getStringExtra("Select_Contact");
                    if (stringExtra != null && !stringExtra.equals("")) {
                        final k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.ktm, bg.f(stringExtra.split(",")));
                        getString(R.l.dIO);
                        this.isv = g.a(this, getString(R.l.eMd), true, new OnCancelListener(this) {
                            final /* synthetic */ ChatroomInfoUI ktJ;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(gVar);
                            }
                        });
                        ap.vd().a(gVar, 0);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final int ON() {
        return R.o.ftY;
    }

    protected final void KC() {
        this.isJ = this.vrv;
        String str;
        if (this.fOg) {
            af Rc;
            q fV;
            if (this.ktp == 0) {
                qP(getString(R.l.eND));
            } else {
                if (this.ktr != null) {
                    this.ktp = this.ktr.DU().size();
                }
                qP(getString(R.l.eln, new Object[]{getString(R.l.eND), Integer.valueOf(this.ktp)}));
            }
            str = null;
            if (this.ktr != null) {
                str = this.ktr.field_roomowner;
                this.ktp = this.ktr.DU().size();
            }
            if (bg.mA(str)) {
                this.ktn = false;
                this.kto = false;
            } else {
                this.ktn = true;
                this.kto = str.equals(com.tencent.mm.u.m.xL());
            }
            w.d("MicroMsg.ChatroomInfoUI", "initBaseChatRoomView()");
            this.ktf = (ContactListExpandPreference) this.isJ.Td("roominfo_contact_anchor");
            this.ktf.a(this.isJ, this.ktf.igL);
            this.kte = (NormalIconPreference) this.isJ.Td("del_selector_btn");
            this.ktd = (NormalIconPreference) this.isJ.Td("add_selector_btn");
            this.ktb = (SignaturePreference) this.isJ.Td("room_name");
            this.kta = (RoomCardPreference) this.isJ.Td("room_card");
            this.ktc = this.isJ.Td("see_room_member");
            this.ktg = (CheckBoxPreference) this.isJ.Td("room_notify_new_msg");
            this.kth = (CheckBoxPreference) this.isJ.Td("room_save_to_contact");
            this.kti = (CheckBoxPreference) this.isJ.Td("room_placed_to_the_top");
            this.ktj = (SignaturePreference) this.isJ.Td("room_nickname");
            this.ktf.ju(true).jv(true).bFc();
            if (!this.kto) {
                this.isJ.aV("del_selector_btn", true);
            } else if (j.eC(this.ktm) > 2) {
                this.isJ.aV("manage_room", false);
                if (this.ktr != null) {
                    this.ktf.MT(this.ktr.field_roomowner);
                    if (!bg.mA(this.ktr.field_roomowner)) {
                        this.ktf.sNk.sMx.sNa = true;
                    }
                }
                this.ktf.bFa();
                this.ktf.bFd();
                this.isJ.aV("add_selector_btn", true);
                this.isJ.aV("del_selector_btn", true);
                this.isJ.aV("room_name", false);
                this.isJ.aV("room_qr_code", false);
                this.isJ.aV("chatroom_info_chexboxes", true);
                this.isJ.aV("room_card", false);
                this.isJ.aV("room_upgrade_entry", true);
                if ((!this.kto || this.ktp < com.tencent.mm.pluginsdk.ui.applet.f.sMG) && (!this.kto || this.ktp < com.tencent.mm.pluginsdk.ui.applet.f.sMG - 1)) {
                    this.isJ.aV("see_room_member", true);
                } else {
                    this.isJ.aV("see_room_member", false);
                    this.ktc.setTitle(getString(R.l.eQk, new Object[]{Integer.valueOf(this.ktp)}));
                }
                w.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
                if (this.hgx == null) {
                    this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.kti != null) {
                    if (this.jiL == null) {
                        ap.yY();
                        this.hgx.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.u.c.wW().Rt(this.jiL.field_username)).commit();
                    } else {
                        this.hgx.edit().putBoolean("room_placed_to_the_top", false).commit();
                    }
                }
                this.isJ.notifyDataSetChanged();
                w.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
                if (this.hgx == null) {
                    this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                if (this.kth != null) {
                    ap.yY();
                    Rc = com.tencent.mm.u.c.wR().Rc(this.ktm);
                    if (Rc != null) {
                        w.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                        w.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                        if (this.hgx == null) {
                            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
                        }
                        ap.yY();
                        fV = com.tencent.mm.u.c.xa().fV(this.ktm);
                        if (fV != null) {
                            w.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                        } else {
                            this.ktl = fV.bKX();
                            this.ktk = (CheckBoxPreference) this.isJ.Td("room_msg_show_username");
                            if (this.ktk != null) {
                                this.hgx.edit().putBoolean("room_msg_show_username", this.ktl).commit();
                            }
                            this.isJ.notifyDataSetChanged();
                        }
                        ap.yY();
                        this.kts = com.tencent.mm.u.c.wT().AA(this.ktm);
                    } else {
                        this.hgx.edit().putBoolean("room_save_to_contact", com.tencent.mm.j.a.ez(Rc.field_type)).commit();
                    }
                }
                this.isJ.notifyDataSetChanged();
                w.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                if (this.hgx == null) {
                    this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
                }
                ap.yY();
                fV = com.tencent.mm.u.c.xa().fV(this.ktm);
                if (fV != null) {
                    this.ktl = fV.bKX();
                    this.ktk = (CheckBoxPreference) this.isJ.Td("room_msg_show_username");
                    if (this.ktk != null) {
                        this.hgx.edit().putBoolean("room_msg_show_username", this.ktl).commit();
                    }
                    this.isJ.notifyDataSetChanged();
                } else {
                    w.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                }
                ap.yY();
                this.kts = com.tencent.mm.u.c.wT().AA(this.ktm);
            }
            this.isJ.aV("manage_room", true);
            if (this.ktr != null) {
                this.ktf.MT(this.ktr.field_roomowner);
                if (bg.mA(this.ktr.field_roomowner)) {
                    this.ktf.sNk.sMx.sNa = true;
                }
            }
            this.ktf.bFa();
            this.ktf.bFd();
            this.isJ.aV("add_selector_btn", true);
            this.isJ.aV("del_selector_btn", true);
            this.isJ.aV("room_name", false);
            this.isJ.aV("room_qr_code", false);
            this.isJ.aV("chatroom_info_chexboxes", true);
            this.isJ.aV("room_card", false);
            this.isJ.aV("room_upgrade_entry", true);
            if (this.kto) {
            }
            this.isJ.aV("see_room_member", true);
            w.d("MicroMsg.ChatroomInfoUI", "updatePlaceTop()");
            if (this.hgx == null) {
                this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.kti != null) {
                if (this.jiL == null) {
                    this.hgx.edit().putBoolean("room_placed_to_the_top", false).commit();
                } else {
                    ap.yY();
                    this.hgx.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.u.c.wW().Rt(this.jiL.field_username)).commit();
                }
            }
            this.isJ.notifyDataSetChanged();
            w.d("MicroMsg.ChatroomInfoUI", "updateSaveToContact()");
            if (this.hgx == null) {
                this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            if (this.kth != null) {
                ap.yY();
                Rc = com.tencent.mm.u.c.wR().Rc(this.ktm);
                if (Rc != null) {
                    this.hgx.edit().putBoolean("room_save_to_contact", com.tencent.mm.j.a.ez(Rc.field_type)).commit();
                } else {
                    w.e("MicroMsg.ChatroomInfoUI", "contact == null !!!");
                    w.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
                    if (this.hgx == null) {
                        this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
                    }
                    ap.yY();
                    fV = com.tencent.mm.u.c.xa().fV(this.ktm);
                    if (fV != null) {
                        w.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
                    } else {
                        this.ktl = fV.bKX();
                        this.ktk = (CheckBoxPreference) this.isJ.Td("room_msg_show_username");
                        if (this.ktk != null) {
                            this.hgx.edit().putBoolean("room_msg_show_username", this.ktl).commit();
                        }
                        this.isJ.notifyDataSetChanged();
                    }
                    ap.yY();
                    this.kts = com.tencent.mm.u.c.wT().AA(this.ktm);
                }
            }
            this.isJ.notifyDataSetChanged();
            w.d("MicroMsg.ChatroomInfoUI", "updateDisplayNickname()");
            if (this.hgx == null) {
                this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ap.yY();
            fV = com.tencent.mm.u.c.xa().fV(this.ktm);
            if (fV != null) {
                this.ktl = fV.bKX();
                this.ktk = (CheckBoxPreference) this.isJ.Td("room_msg_show_username");
                if (this.ktk != null) {
                    this.hgx.edit().putBoolean("room_msg_show_username", this.ktl).commit();
                }
                this.isJ.notifyDataSetChanged();
            } else {
                w.e("MicroMsg.ChatroomInfoUI", "members == null !!!");
            }
            ap.yY();
            this.kts = com.tencent.mm.u.c.wT().AA(this.ktm);
        } else if (this.ksZ) {
            this.kto = false;
            qP(getString(R.l.eMG));
            this.ktf = (ContactListExpandPreference) this.isJ.Td("roominfo_contact_anchor");
            this.ktf.a(this.isJ, this.ktf.igL);
            this.ktf.ju(false).jv(false);
            this.ktf.a(new com.tencent.mm.pluginsdk.ui.applet.g.b(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final boolean kJ(int i) {
                    return true;
                }
            });
            this.isJ.removeAll();
            this.isJ.a(new PreferenceCategory(this));
            this.isJ.a(this.ktf);
            str = this.ktm;
            final com.tencent.mm.sdk.b.b jjVar = new jj();
            jjVar.fPN.fNV = str;
            com.tencent.mm.sdk.b.a.urY.m(jjVar);
            getString(R.l.dIO);
            this.isv = g.a(this, getString(R.l.eME), true, new OnCancelListener(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                public final void onCancel(DialogInterface dialogInterface) {
                    ChatroomInfoUI.a(jjVar);
                }
            });
            this.isJ.notifyDataSetChanged();
        }
        if (this.ktf != null) {
            if (!this.fOg && this.ksZ) {
                this.ktf.ae(new ArrayList());
            }
            this.mUX.setOnScrollListener(this.ktu);
            this.ktf.a(this.ktu);
            this.ktf.a(new com.tencent.mm.pluginsdk.ui.applet.g.b(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final boolean kJ(int i) {
                    return true;
                }
            });
            ContactListExpandPreference contactListExpandPreference = this.ktf;
            View.OnClickListener anonymousClass3 = new View.OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final void onClick(View view) {
                }
            };
            if (contactListExpandPreference.sNk != null) {
                contactListExpandPreference.sNk.oPX = anonymousClass3;
            }
            this.ktf.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final void kK(int i) {
                    this.ktJ.ajg();
                }

                public final void kL(int i) {
                    String xu = this.ktJ.ktf.xu(i);
                    String mz = bg.mz(this.ktJ.ktf.xw(i));
                    if (bg.mA(mz)) {
                        ap.yY();
                        bb AI = com.tencent.mm.u.c.wS().AI(xu);
                        if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                            mz = AI.field_conRemark;
                        }
                    }
                    if (!bg.mA(xu)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", xu);
                        intent.putExtra("Contact_RemarkName", mz);
                        if (this.ktJ.fOg && this.ktJ.ktr != null) {
                            intent.putExtra("Contact_RoomNickname", this.ktJ.ktr.eK(xu));
                        }
                        intent.putExtra("Contact_Nick", bg.mz(this.ktJ.ktf.xv(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        intent.putExtra("room_name", this.ktJ.jiL.field_username);
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(xu);
                        if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                            com.tencent.mm.sdk.b.b nzVar = new nz();
                            nzVar.fVf.intent = intent;
                            nzVar.fVf.username = xu;
                            com.tencent.mm.sdk.b.a.urY.m(nzVar);
                        }
                        if (this.ktJ.fOg) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(219, 9, 1, true);
                            if (Rc != null && Rc.bLe()) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, Rc.field_username + ",14");
                            }
                            intent.putExtra("Contact_Scene", 14);
                        } else if (this.ktJ.ksZ) {
                            intent.putExtra("Contact_Scene", 44);
                            if (!com.tencent.mm.u.m.eH(Rc.field_username)) {
                                intent.putExtra("Contact_IsLBSFriend", true);
                            }
                        }
                        intent.putExtra("Is_RoomOwner", this.ktJ.kto);
                        intent.putExtra("Contact_ChatRoomId", this.ktJ.ktm);
                        com.tencent.mm.plugin.chatroom.a.imv.d(intent, this.ktJ);
                    }
                }

                public final void ajs() {
                    if (this.ktJ.ktf != null) {
                        this.ktJ.ktf.bFb();
                    }
                }

                public final void kM(int i) {
                    this.ktJ.ajf();
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            {
                this.ktJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ktJ.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        int i = 1;
        String str = preference.igL;
        int i2;
        Intent intent;
        if (str.equals("room_name")) {
            str = com.tencent.mm.i.g.sV().getValue("ChatRoomOwnerModTopic");
            if (bg.mA(str)) {
                i2 = 0;
            } else {
                i2 = bg.PY(str);
            }
            if (bg.mA(this.ktr.field_roomowner) || r0 <= 0 || this.kto || r0 >= this.ktp) {
                str = "";
                if (ajp()) {
                    str = this.jiL.tL();
                }
                intent = new Intent();
                intent.setClass(this, ModRemarkRoomNameUI.class);
                intent.putExtra("room_name", str);
                intent.putExtra("RoomInfo_Id", this.ktm);
                startActivityForResult(intent, 4);
                com.tencent.mm.plugin.report.service.g.oUh.a(219, 3, 1, true);
            } else {
                g.a(this, getString(R.l.eNk, new Object[]{ajh()}), null, getString(R.l.dHw), new OnClickListener(this) {
                    final /* synthetic */ ChatroomInfoUI ktJ;

                    {
                        this.ktJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        } else if (str.equals("room_upgrade_entry")) {
            bM(this);
        } else if (str.equals("room_qr_code")) {
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 5, 1, true);
            r0 = new Intent();
            r0.putExtra("from_userName", this.ktm);
            com.tencent.mm.bb.d.b(this, "setting", ".ui.setting.SelfQRCodeUI", r0);
        } else if (str.equals("room_card")) {
            if (!bg.mA(j.eE(this.ktm)) || this.kto) {
                r0 = new Intent();
                r0.setClass(this, RoomCardUI.class);
                r0.putExtra("RoomInfo_Id", this.ktm);
                r0.putExtra("room_name", this.kta.iJF.toString());
                this.ktp = j.eA(this.ktm).size();
                r0.putExtra("room_member_count", this.ktp);
                r0.putExtra("room_owner_name", ajh());
                r0.putExtra("room_notice", j.eE(this.ktm));
                r0.putExtra("room_notice_publish_time", j.eG(this.ktm));
                r0.putExtra("room_notice_editor", j.eF(this.ktm));
                r0.putExtra("Is_RoomOwner", this.kto);
                startActivityForResult(r0, 6);
            } else {
                g.a(this, getString(R.l.eLV), null, getString(R.l.eLW), null, null, null);
            }
        } else if (str.equals("room_notify_new_msg")) {
            this.kmK = !this.kmK;
            if (this.fOg) {
                i2 = this.kmK ? 0 : 1;
                ap.yY();
                com.tencent.mm.u.c.wQ().b(new com.tencent.mm.ao.k(this.ktm, i2));
                ap.yY();
                this.jiL = com.tencent.mm.u.c.wR().Rc(this.ktm);
                this.jiL.dm(i2);
                ap.yY();
                com.tencent.mm.u.c.wR().a(this.ktm, this.jiL);
            }
            r0 = com.tencent.mm.modelstat.b.hUp;
            r2 = this.ktm;
            boolean z = this.kmK;
            if (r0.JT() && r0.ba(r2)) {
                IMBehavior iMBehavior = new IMBehavior();
                iMBehavior.opType = 1;
                iMBehavior.chattingOp = new IMBehaviorChattingOP();
                IMBehaviorChattingOP iMBehaviorChattingOP = iMBehavior.chattingOp;
                if (!z) {
                    i = 2;
                }
                iMBehaviorChattingOP.changeNotifyStatus = i;
                synchronized (r0.lock) {
                    r0.hUo.oplist_.add(iMBehavior);
                }
            }
            ajm();
        } else if (str.equals("room_save_to_contact")) {
            if (this.hgx == null) {
                this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(this.ktm);
            if (Rc != null) {
                boolean ez = com.tencent.mm.j.a.ez(Rc.field_type);
                this.hgx.edit().putBoolean("room_save_to_contact", !ez).commit();
                if (ez) {
                    Rc.td();
                    o.t(Rc);
                    g.bl(this, getString(R.l.eMV));
                    com.tencent.mm.modelstat.b.hUp.B(this.ktm, false);
                } else {
                    o.q(Rc);
                    g.bl(this, getString(R.l.eNd));
                    com.tencent.mm.modelstat.b.hUp.B(this.ktm, true);
                }
                this.isJ.notifyDataSetChanged();
            }
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ktD, 0);
            if (this.jiL != null) {
                ap.yY();
                if (com.tencent.mm.u.c.wW().Rt(this.jiL.field_username)) {
                    o.m(this.jiL.field_username, true);
                    com.tencent.mm.modelstat.b.hUp.b(false, this.ktm, false);
                } else {
                    o.l(this.jiL.field_username, true);
                    com.tencent.mm.modelstat.b.hUp.b(false, this.ktm, true);
                }
                ap.yY();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.u.c.wW().Rt(this.jiL.field_username)).commit();
            }
        } else if (str.equals("room_nickname")) {
            r2 = aje();
            if (bg.mA(r2)) {
                r2 = com.tencent.mm.u.m.xN();
            }
            g.a(this.uSU.uTo, getString(R.l.eMP), r2, getString(R.l.eMv), 32, new g.b(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                public final boolean u(CharSequence charSequence) {
                    String charSequence2 = charSequence == null ? "" : charSequence.toString();
                    String sE = com.tencent.mm.i.b.sE();
                    if (bg.mA(sE) || !charSequence2.matches(".*[" + sE + "].*")) {
                        if (!(charSequence2 == null || charSequence2.equals(r2))) {
                            ChatroomInfoUI.a(this.ktJ, charSequence2);
                        }
                        return true;
                    }
                    g.bl(this.ktJ.uSU.uTo, this.ktJ.getString(R.l.esK, new Object[]{sE}));
                    return false;
                }
            });
        } else if (str.equals("room_msg_show_username")) {
            getSharedPreferences(this.ktD, 0).edit().putBoolean("room_msg_show_username", !this.ktl).commit();
            this.ktl = !this.ktl;
            this.ktq = true;
        } else if (str.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.jiL.field_username);
            com.tencent.mm.bb.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.ktm);
            com.tencent.mm.bb.d.b(this, "search", ".ui.FTSChattingTalkerUI", r0);
        } else if (str.equals("room_clear_chatting_history")) {
            g.a(this.uSU.uTo, getString(R.l.elt), "", getString(R.l.dGt), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ChatroomInfoUI.ktG = false;
                    Context context = this.ktJ;
                    this.ktJ.getString(R.l.dIO);
                    final ProgressDialog a = g.a(context, this.ktJ.getString(R.l.dJd), true, new a());
                    if (i.er(this.ktJ.jiL.field_username)) {
                        com.tencent.mm.plugin.chatroom.a.imw.bp(this.ktJ.jiL.field_username);
                    }
                    ay.a(this.ktJ.jiL.field_username, new com.tencent.mm.u.ay.a(this) {
                        final /* synthetic */ AnonymousClass10 ktM;

                        public final boolean zs() {
                            return ChatroomInfoUI.ktG;
                        }

                        public final void zr() {
                            if (a != null) {
                                a.dismiss();
                            }
                        }
                    });
                }
            }, null, R.e.aSJ);
        } else if (str.equals("room_report_it")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.ktm);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(36)}));
            com.tencent.mm.bb.d.b(this, "webview", ".ui.tools.WebViewUI", r0);
            r0 = com.tencent.mm.modelstat.b.hUp;
            String str2 = this.ktm;
            if (r0.JT() && r0.ba(str2)) {
                IMBehavior iMBehavior2 = new IMBehavior();
                iMBehavior2.opType = 1;
                iMBehavior2.chattingOp = new IMBehaviorChattingOP();
                iMBehavior2.chattingOp.expose = 1;
                synchronized (r0.lock) {
                    r0.hUo.oplist_.add(iMBehavior2);
                }
            }
        } else if (str.equals("room_del_quit")) {
            w.d("MicroMsg.ChatroomInfoUI", " quit " + this.ktm);
            com.tencent.mm.sdk.b.b qkVar = new qk();
            qkVar.fXu.fXw = true;
            com.tencent.mm.sdk.b.a.urY.m(qkVar);
            final boolean z2 = !bg.mA(this.ktm) && this.ktm.equals(qkVar.fXv.fXy);
            if (z2) {
                w.d("MicroMsg.ChatroomInfoUI", " quit talkroom" + this.ktm);
            } else if (this.kto && this.ktr.DU().size() > 2) {
                g.a(this, "", new String[]{getString(R.l.eMT)}, getString(R.l.dGs), new g.c(this) {
                    final /* synthetic */ ChatroomInfoUI ktJ;

                    {
                        this.ktJ = r1;
                    }

                    public final void hq(int i) {
                        switch (i) {
                            case 0:
                                w.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click room_owner_delete_direct]");
                                ChatroomInfoUI.x(this.ktJ);
                                if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
                                    com.tencent.mm.pluginsdk.l.a.sBz.AY(this.ktJ.ktm);
                                    return;
                                }
                                return;
                            default:
                                w.d("MicroMsg.ChatroomInfoUI", "dz[dealQuitChatRoom owner click cancel]");
                                return;
                        }
                    }
                });
            }
            g.a(this.uSU.uTo, getString(R.l.ebq), "", getString(R.l.dHT), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.ktJ.ktm == null || this.ktJ.ktm.length() <= 0) {
                        w.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : invalid args");
                        return;
                    }
                    if (z2) {
                        com.tencent.mm.sdk.b.b qkVar = new qk();
                        qkVar.fXu.fXx = true;
                        com.tencent.mm.sdk.b.a.urY.m(qkVar);
                    }
                    ap.yY();
                    if (com.tencent.mm.u.c.wR().Re(this.ktJ.ktm)) {
                        ChatroomInfoUI.x(this.ktJ);
                        if (com.tencent.mm.pluginsdk.l.a.sBz != null) {
                            com.tencent.mm.pluginsdk.l.a.sBz.AY(this.ktJ.ktm);
                            return;
                        }
                        return;
                    }
                    w.e("MicroMsg.ChatroomInfoUI", "quitChatRoom : room[" + this.ktJ.ktm + "] is not exist");
                }
            }, null, R.e.aSJ);
        } else if (str.equals("add_selector_btn")) {
            ajf();
        } else if (str.equals("del_selector_btn")) {
            ajg();
        } else if (str.equals("see_room_member")) {
            intent = new Intent();
            intent.setClass(this.uSU.uTo, SeeRoomMemberUI.class);
            intent.putExtra("Block_list", com.tencent.mm.u.m.xL());
            List eA = j.eA(this.ktm);
            if (eA != null) {
                this.ktp = eA.size();
            }
            intent.putExtra("Chatroom_member_list", bg.c(eA, ","));
            intent.putExtra("RoomInfo_Id", this.ktm);
            intent.putExtra("room_owner_name", this.ktr.field_roomowner);
            intent.putExtra("Is_RoomOwner", this.kto);
            intent.putExtra("room_member_count", this.ktp);
            intent.putExtra("Add_address_titile", getString(R.l.eNg));
            if (this.fOg) {
                intent.putExtra("Contact_Scene", 14);
            } else if (this.ksZ) {
                intent.putExtra("Contact_Scene", 44);
                if (!com.tencent.mm.u.m.eH(this.jiL.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            r2 = "offset";
            View childAt = this.mUX.getChildAt(0);
            intent.putExtra(r2, childAt == null ? 0 : -childAt.getTop());
            intent.putExtra("first_pos", this.mUX.getFirstVisiblePosition());
            intent.putExtra("room_name", this.jiL.field_username);
            startActivityForResult(intent, 5);
            this.ktx = 5;
        } else if (str.equals("manage_room")) {
            r0 = new Intent();
            r0.setClass(this.uSU.uTo, ManageChatroomUI.class);
            r0.putExtra("RoomInfo_Id", this.ktm);
            r0.putExtra("room_owner_name", this.ktr.field_roomowner);
            startActivity(r0);
        } else if (str.equals("chat_room_app_brand")) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.ktm);
            com.tencent.mm.bb.d.a(this, ".ui.chatting.gallery.AppBrandHistoryListUI", r0);
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 25, 1, true);
        }
        return false;
    }

    private String aje() {
        if (this.ktr == null) {
            return "";
        }
        return this.ktr.field_selfDisplayName;
    }

    private void ajf() {
        List eA;
        if (this.fOg) {
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 7, 1, true);
            eA = j.eA(this.ktm);
            String c = bg.c(eA, ",");
            if (eA != null) {
                this.ktp = eA.size();
            }
            Intent intent = new Intent();
            intent.putExtra("titile", getString(R.l.dCT));
            intent.putExtra("list_type", 1);
            intent.putExtra("list_attr", s.vYO);
            intent.putExtra("always_select_contact", c);
            intent.putExtra("scene", 3);
            com.tencent.mm.bb.d.a(this, ".ui.contact.SelectContactUI", intent, 1);
            return;
        }
        com.tencent.mm.plugin.report.service.g.oUh.A(10170, "1");
        eA = new LinkedList();
        eA.add(this.ktm);
        eA.add(com.tencent.mm.u.m.xL());
        String c2 = bg.c(eA, ",");
        Intent intent2 = new Intent();
        intent2.putExtra("titile", getString(R.l.dCS));
        intent2.putExtra("list_type", 0);
        intent2.putExtra("list_attr", s.vYP);
        intent2.putExtra("always_select_contact", c2);
        com.tencent.mm.bb.d.a(this, ".ui.contact.SelectContactUI", intent2);
    }

    private void ajg() {
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 8, 1, true);
        List eA = j.eA(this.ktm);
        String c = bg.c(eA, ",");
        this.ktp = eA.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", this.ktm);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", this.ktp);
        intent.putExtra("Is_RoomOwner", this.kto);
        intent.putExtra("list_attr", s.vYO);
        intent.putExtra("room_name", this.jiL.field_username);
        intent.putExtra("room_owner_name", this.ktr.field_roomowner);
        intent.setClass(this, SelectDelRoomMemberUI.class);
        startActivityForResult(intent, 7);
    }

    private void n(String str, String str2, int i) {
        if (o.eN(str)) {
            boolean z;
            if (bg.mz(com.tencent.mm.u.m.xL()).equals(str)) {
                z = true;
            } else {
                List<String> eA = j.eA(this.ktm);
                if (eA == null) {
                    z = false;
                } else {
                    z = false;
                    for (String equals : eA) {
                        boolean z2;
                        if (equals.equals(str)) {
                            z2 = true;
                        } else {
                            z2 = z;
                        }
                        z = z2;
                    }
                }
            }
            if (z) {
                g.b(this, getString(R.l.dCc), getString(R.l.dIO), true);
                return;
            }
            List f = bg.f(str.split(","));
            if (f != null) {
                final k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.ktm, f, str2);
                getString(R.l.dIO);
                this.isv = g.a(this, getString(i), true, new OnCancelListener(this) {
                    final /* synthetic */ ChatroomInfoUI ktJ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(dVar);
                    }
                });
                ap.vd().a(dVar, 0);
                return;
            }
            return;
        }
        g.b(this, getString(R.l.eML), getString(R.l.dIO), true);
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        String str = "";
        String str2 = "";
        String string = ab.getContext().getString(R.l.dTc);
        final List list = dVar.ksL;
        final List list2 = dVar.ksN;
        final List list3 = dVar.fPw;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            boolean z;
            ap.yY();
            q fW = com.tencent.mm.u.c.xa().fW(this.ktm);
            if (i == -116 && aji() && !bg.mA(fW.field_roomowner)) {
                str = getString(R.l.eMI);
                str2 = getString(R.l.eMH);
                z = true;
            } else {
                z = false;
            }
            if (i == -23) {
                str = getString(R.l.eMO);
                str2 = getString(R.l.eMN);
            }
            if (i == -109) {
                str = getString(R.l.eMK);
                str2 = getString(R.l.eMJ);
            }
            if (i == -122) {
                str = getString(R.l.eMO);
                str2 = getString(R.l.eMM, new Object[]{ajh(), Integer.valueOf(fW.bKW())});
            }
            list2 = dVar.ksM;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fOw && (list2 == null || list2.size() <= 0 || dVar.fOw != list3.size() + list2.size()))) {
                list2 = dVar.ksM;
                if (list2 != null && list2.size() > 0) {
                    str2 = str2 + getString(R.l.elw, new Object[]{bg.c(ae(list2), string)});
                }
                list2 = dVar.fPv;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCa);
                    str2 = str2 + getString(R.l.elD, new Object[]{bg.c(ae(list2), string)});
                }
                list2 = dVar.fPt;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCa);
                    str2 = str2 + getString(R.l.elx, new Object[]{bg.c(ae(list2), string)});
                }
                Collection collection = dVar.ksN;
                List arrayList = new ArrayList();
                if (!(list3 == null || list3.isEmpty())) {
                    arrayList.addAll(list3);
                }
                if (collection != null && collection.size() > 0) {
                    arrayList.addAll(collection);
                }
                if (i != -2028) {
                    d(dVar.chatroomName, list3);
                }
                str2 = str2 + getString(R.l.elm, new Object[]{bg.c(ae(arrayList), string)});
                if (list3 != null && list3.isEmpty()) {
                    str2 = null;
                }
                if (str2 != null && str2.length() > 0) {
                    if (z) {
                        g.a(this, str2, str, new OnClickListener(this) {
                            final /* synthetic */ ChatroomInfoUI ktJ;

                            {
                                this.ktJ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.ktJ.bM(this.ktJ);
                            }
                        }, null);
                        return;
                    } else {
                        g.b(this, str2, str, true);
                        return;
                    }
                }
                return;
            }
            List linkedList = new LinkedList();
            for (int i2 = 0; i2 < list3.size(); i2++) {
                linkedList.add(list3.get(i2));
            }
            str2 = "";
            String string2 = ab.getContext().getString(R.l.dTc);
            if (!(list2 == null || list2.isEmpty())) {
                str2 = getString(R.l.ell, new Object[]{bg.c(ae(list2), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(R.l.elm, new Object[]{bg.c(ae(linkedList), string2)});
            }
            g.a(this, str2, "", getString(R.l.elg), new OnClickListener(this) {
                final /* synthetic */ ChatroomInfoUI ktJ;

                {
                    this.ktJ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ktJ.ajq();
                }
            });
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCb);
        String string3 = getString(R.l.esL);
        String string4 = getString(R.l.dGs);
        final com.tencent.mm.plugin.chatroom.d.d dVar2 = dVar;
        AnonymousClass18 anonymousClass18 = new OnClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ktJ.d(dVar2.chatroomName, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final k kVar = new com.tencent.mm.plugin.chatroom.d.k(this.ktJ.ktm, arrayList);
                ap.vd().a(kVar, 0);
                ChatroomInfoUI chatroomInfoUI = this.ktJ;
                Context context = this.ktJ;
                this.ktJ.getString(R.l.dIO);
                chatroomInfoUI.isv = g.a(context, this.ktJ.getString(R.l.eMC), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass18 ktU;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(kVar);
                    }
                });
            }
        };
        g.a(this, string, null, string3, string4, anonymousClass18, new OnClickListener(this) {
            final /* synthetic */ ChatroomInfoUI ktJ;

            {
                this.ktJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String ajh() {
        String str;
        String str2 = null;
        ap.yY();
        af Rc = com.tencent.mm.u.c.wR().Rc(this.ktr.field_roomowner);
        if (Rc == null || ((int) Rc.gTQ) <= 0) {
            str = null;
        } else {
            str = Rc.field_conRemark;
        }
        if (bg.mA(str)) {
            str = this.ktr.field_roomowner;
            if (this.ktr != null) {
                str2 = this.ktr.eK(str);
            }
        } else {
            str2 = str;
        }
        if (bg.mA(str2) && Rc != null && ((int) Rc.gTQ) > 0) {
            str2 = Rc.tK();
        }
        if (bg.mA(str2)) {
            return this.ktr.field_roomowner;
        }
        return str2;
    }

    private static boolean aji() {
        return bg.getInt(com.tencent.mm.i.g.sV().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private void bM(Context context) {
        if (context != null && aji()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", getString(R.l.dSY, new Object[]{v.bIN()}));
            intent.putExtra("geta8key_username", com.tencent.mm.u.m.xL());
            intent.putExtra("showShare", false);
            com.tencent.mm.bb.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            i.a(str, linkedList, getString(R.l.dTb), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private void ajj() {
        if (this.fOg) {
            this.ktp = j.eC(this.ktm);
            if (this.ktp == 0) {
                qP(getString(R.l.eND));
                return;
            }
            qP(getString(R.l.eln, new Object[]{getString(R.l.eND), Integer.valueOf(this.ktp)}));
        }
    }

    private void ajk() {
        if (this.ktf == null) {
            return;
        }
        List eA;
        if (this.fOg) {
            ap.yY();
            this.ktH = com.tencent.mm.u.c.xa().fY(this.ktm);
            eA = j.eA(this.ktm);
            if (eA != null) {
                this.ktp = eA.size();
            } else {
                this.ktp = 0;
            }
            if (this.ktp > com.tencent.mm.pluginsdk.ui.applet.f.sMG + 1) {
                eA = eA.subList(0, com.tencent.mm.pluginsdk.ui.applet.f.sMG + 1);
                if (!(this.ktr == null || eA.contains(this.ktr.field_roomowner))) {
                    eA.add(0, this.ktr.field_roomowner);
                }
            }
            if (this.ktp <= 1) {
                this.isJ.aV("del_selector_btn", true);
                this.ktf.ju(true).jv(false).bFc();
            } else {
                this.ktf.ju(true).jv(this.kto).bFc();
            }
            this.ktf.k(this.ktm, eA);
            return;
        }
        eA = new LinkedList();
        eA.add(this.ktm);
        this.ktf.k(this.ktm, eA);
    }

    private void ajl() {
        if (this.jiL != null) {
            CharSequence aje = aje();
            if (bg.mA(aje)) {
                aje = com.tencent.mm.u.m.xN();
            }
            if (bg.mA(aje)) {
                this.ktj.setSummary("");
            } else {
                SignaturePreference signaturePreference = this.ktj;
                if (aje.length() <= 0) {
                    aje = getString(R.l.eUe);
                }
                signaturePreference.setSummary(h.a(this, aje));
            }
            if (this.isJ != null) {
                this.isJ.notifyDataSetChanged();
            }
        }
    }

    private void ajm() {
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.fOg) {
            this.kmK = this.jiL.gkz == 0;
        } else if (!this.ksZ) {
            this.kmK = this.jiL.tD();
        }
        if (this.kmK) {
            zo(0);
            if (this.ktg != null) {
                this.hgx.edit().putBoolean("room_notify_new_msg", true).commit();
            }
        } else {
            zo(8);
            if (this.ktg != null) {
                this.hgx.edit().putBoolean("room_notify_new_msg", false).commit();
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    private void ajn() {
        if (this.jiL != null && this.kta != null) {
            CharSequence eE = j.eE(this.ktm);
            if (eE == null || eE.length() <= 0) {
                this.kta.fEq = false;
            } else {
                this.kta.fEq = true;
                this.kta.sSU = h.a(this, eE);
            }
            ap.yY();
            this.jiL = com.tencent.mm.u.c.wR().Rc(this.ktm);
            if (ajp()) {
                eE = this.jiL.tL();
                RoomCardPreference roomCardPreference = this.kta;
                if (eE.length() <= 0) {
                    eE = getString(R.l.eUe);
                }
                roomCardPreference.iJF = h.a(this, eE);
            } else {
                this.kta.iJF = getString(R.l.eMA);
            }
            this.isJ.notifyDataSetChanged();
        }
    }

    private void ajo() {
        if (this.jiL != null && this.ktb != null) {
            ap.yY();
            this.jiL = com.tencent.mm.u.c.wR().Rc(this.ktm);
            if (ajp()) {
                CharSequence tL = this.jiL.tL();
                SignaturePreference signaturePreference = this.ktb;
                if (tL.length() <= 0) {
                    tL = getString(R.l.eUe);
                }
                signaturePreference.setSummary(h.a(this, tL));
                if (this.isJ != null) {
                    this.isJ.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.ktb.setSummary(getString(R.l.eMA));
        }
    }

    private boolean ajp() {
        String str = this.jiL.field_nickname;
        if (bg.mA(str) || str.length() > 50) {
            return false;
        }
        return true;
    }

    public static ArrayList<x> ad(List<ajc> list) {
        ArrayList<x> arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        for (ajc com_tencent_mm_protocal_c_ajc : list) {
            x xVar = new x();
            xVar.setUsername(com_tencent_mm_protocal_c_ajc.jNj);
            xVar.bR(com_tencent_mm_protocal_c_ajc.jOp);
            arrayList.add(xVar);
        }
        return arrayList;
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ap.zb()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ap.yY();
            com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.ChatroomInfoUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        w.d("MicroMsg.ChatroomInfoUI", "pre is " + this.ktp);
        this.ktp = j.eC(this.ktm);
        w.d("MicroMsg.ChatroomInfoUI", "now is " + this.ktp);
        if (this.isv != null) {
            this.isv.dismiss();
        }
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn != null) {
            dn.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            if (i == 0 && i2 == 0) {
                switch (kVar.getType()) {
                    case 120:
                        a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                        ajq();
                        break;
                    case 179:
                        ajq();
                        break;
                    case 610:
                        if (this.ktx != 5) {
                            g.b(this, getString(R.l.esX), null, true);
                            break;
                        }
                        break;
                }
                if (this.ktr != null) {
                    this.ktp = this.ktr.DU().size();
                }
                if ((!this.kto && this.ktp >= com.tencent.mm.pluginsdk.ui.applet.f.sMG) || (this.kto && this.ktp >= com.tencent.mm.pluginsdk.ui.applet.f.sMG - 1)) {
                    this.isJ.aV("see_room_member", false);
                    this.ktc.setTitle(getString(R.l.eQk));
                }
            }
            ajj();
        } else {
            if (kVar.getType() == 120 && this.ktx != 5) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                ajq();
            }
            if (kVar.getType() == 179 && this.ktx != 5 && i2 == -66) {
                g.b(this, getString(R.l.ebr), getString(R.l.dIO), true);
                ajq();
            }
            if (kVar.getType() == 610 && this.ktx != 5) {
                g.b(this, getString(R.l.esW), getString(R.l.dIO), true);
            }
        }
    }

    private void ajq() {
        if (this.ktf != null) {
            if (this.fOg) {
                ajk();
            } else if (!this.ksZ) {
                List linkedList = new LinkedList();
                linkedList.add(this.ktm);
                this.ktf.k(this.ktm, linkedList);
            }
            this.ktf.notifyChanged();
        }
        if (!this.kto || j.eC(this.ktm) <= 2) {
            this.isJ.aV("manage_room", true);
        } else {
            this.isJ.aV("manage_room", false);
        }
        if ((this.kto || this.ktp < com.tencent.mm.pluginsdk.ui.applet.f.sMG) && (!this.kto || this.ktp < com.tencent.mm.pluginsdk.ui.applet.f.sMG - 1)) {
            this.isJ.aV("see_room_member", true);
        } else {
            this.isJ.aV("see_room_member", false);
            this.ktc.setTitle(getString(R.l.eQk, new Object[]{Integer.valueOf(this.ktp)}));
        }
        this.isJ.notifyDataSetChanged();
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (obj == null || !(obj instanceof String)) {
            w.d("MicroMsg.ChatroomInfoUI", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        a((String) obj, null);
    }

    public final void a(String str, l lVar) {
        if (!bg.mA(str)) {
            if (str.endsWith("@chatroom")) {
                w.d("MicroMsg.ChatroomInfoUI", "event:" + str);
                if (this.fOg && str.equals(this.ktm)) {
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ ChatroomInfoUI ktJ;

                        {
                            this.ktJ = r1;
                        }

                        public final void run() {
                            ChatroomInfoUI chatroomInfoUI = this.ktJ;
                            ap.yY();
                            chatroomInfoUI.ktr = com.tencent.mm.u.c.xa().fV(this.ktJ.ktm);
                            if (this.ktJ.ktr == null) {
                                w.e("MicroMsg.ChatroomInfoUI", "member is null");
                            } else if (bg.mA(this.ktJ.ktr.field_roomowner)) {
                                w.e("MicroMsg.ChatroomInfoUI", "roomowner is null");
                            } else {
                                this.ktJ.handler.sendEmptyMessage(0);
                                this.ktJ.kto = this.ktJ.ktr.field_roomowner.equals(com.tencent.mm.u.m.xL());
                                this.ktJ.ktf.MT(this.ktJ.ktr.field_roomowner);
                            }
                        }

                        public final String toString() {
                            return super.toString() + "|onNotifyChange";
                        }
                    });
                }
                ajq();
                return;
            }
            w.d("MicroMsg.ChatroomInfoUI", "event:" + str + " cancel");
        }
    }

    public final void B(String str, String str2, String str3) {
        if (str.equals(this.ktm) && this.ktf != null) {
            this.ktf.notifyChanged();
        }
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
