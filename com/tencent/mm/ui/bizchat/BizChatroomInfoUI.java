package com.tencent.mm.ui.bizchat;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.re;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.d.a;
import com.tencent.mm.modelbiz.a.d.a.b;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.a.u;
import com.tencent.mm.modelbiz.a.x;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.gq;
import com.tencent.mm.protocal.c.gs;
import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.c.ms;
import com.tencent.mm.protocal.c.mt;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class BizChatroomInfoUI extends MMPreference implements m, e {
    private static boolean ktG = false;
    private int fromScene;
    private SharedPreferences hgx = null;
    private f isJ;
    private ProgressDialog isv = null;
    private boolean jWp = false;
    private long kbc;
    private String kbi;
    private boolean kmK;
    private SignaturePreference ktb;
    private ContactListExpandPreference ktf;
    private CheckBoxPreference ktg;
    private CheckBoxPreference kth;
    private CheckBoxPreference kti;
    private boolean kto = false;
    private int ktp;
    private d ktu = new d(new OnScrollListener(this) {
        final /* synthetic */ BizChatroomInfoUI vwM;

        {
            this.vwM = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            n.GW().bi(i);
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ktv = false;
    private j otS = null;
    private a vvJ = new a(this) {
        final /* synthetic */ BizChatroomInfoUI vwM;

        {
            this.vwM = r1;
        }

        public final void a(b bVar) {
            if (bVar != null && bVar.hwR != null && bVar.hwG == this.vwM.kbc && bVar.hwQ != a.a.hwN) {
                w.i("MicroMsg.BizChatroomInfoUI", "bizChatExtension bizChat change");
                this.vwM.vve = com.tencent.mm.modelbiz.w.DJ().aa(this.vwM.kbc);
                this.vwM.bTx();
            }
        }
    };
    private c vve = null;
    private String vwG;
    private boolean vwH = false;
    private boolean vwI;
    private boolean vwJ;
    private int vwK;
    private j vwL = null;

    static /* synthetic */ void a(BizChatroomInfoUI bizChatroomInfoUI, int i) {
        boolean z = true;
        j AH = bizChatroomInfoUI.AH(i);
        if (AH == null) {
            String str = "MicroMsg.BizChatroomInfoUI";
            String str2 = "onItemNormalClick userInfo == null:%s";
            Object[] objArr = new Object[1];
            if (AH != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.w(str, str2, objArr);
            return;
        }
        w.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick field_userId:%s", AH.field_userId);
        String str3 = AH.field_userId;
        gt gtVar = new gt();
        gs gsVar = new gs();
        gsVar.tkM = str3;
        gtVar.tkN.add(gsVar);
        bizChatroomInfoUI.a(null, gtVar);
    }

    static /* synthetic */ boolean a(BizChatroomInfoUI bizChatroomInfoUI, String str, CharSequence charSequence) {
        String trim = charSequence == null ? "" : charSequence.toString().trim();
        if (trim.equals(str)) {
            w.d("MicroMsg.BizChatroomInfoUI", "same room name return");
            return true;
        } else if (trim.length() == 0) {
            g.bl(bizChatroomInfoUI.uSU.uTo, bizChatroomInfoUI.getString(R.l.eMa));
            return false;
        } else {
            com.tencent.mm.sdk.b.a.urY.m(new re());
            bizChatroomInfoUI.vwG = bizChatroomInfoUI.vve.field_chatName;
            bizChatroomInfoUI.vwK = bizChatroomInfoUI.vve.field_bitFlag;
            bizChatroomInfoUI.vve.field_chatName = trim;
            com.tencent.mm.modelbiz.w.DJ().b(bizChatroomInfoUI.vve);
            gq gqVar = new gq();
            gqVar.tkF = bizChatroomInfoUI.vve.field_bizChatServId;
            gqVar.name = trim;
            gqVar.tkH = bizChatroomInfoUI.vwK;
            com.tencent.mm.modelbiz.w.DN();
            h.a(bizChatroomInfoUI.vve.field_brandUserName, gqVar, (m) bizChatroomInfoUI);
            bizChatroomInfoUI.ajo();
            bizChatroomInfoUI.isJ.notifyDataSetChanged();
            return true;
        }
    }

    static /* synthetic */ void c(BizChatroomInfoUI bizChatroomInfoUI) {
        Intent intent = new Intent();
        if (bizChatroomInfoUI.vwH) {
            if (bg.mA(bizChatroomInfoUI.vve.field_addMemberUrl)) {
                w.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
                Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dOV), 0).show();
                return;
            }
            intent.putExtra("rawUrl", bizChatroomInfoUI.vve.field_addMemberUrl);
        } else if (bizChatroomInfoUI.otS == null || bg.mA(bizChatroomInfoUI.otS.field_addMemberUrl)) {
            w.w("MicroMsg.BizChatroomInfoUI", "dealAddMemberBtn: addMemberUrl is null");
            Toast.makeText(bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dOV), 0).show();
            return;
        } else {
            intent.putExtra("rawUrl", bizChatroomInfoUI.otS.field_addMemberUrl);
        }
        intent.putExtra("useJs", true);
        com.tencent.mm.bb.d.b(bizChatroomInfoUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent, 1);
    }

    static /* synthetic */ void d(BizChatroomInfoUI bizChatroomInfoUI) {
        w.i("MicroMsg.BizChatroomInfoUI", "deleteChatroom");
        com.tencent.mm.modelbiz.w.DN();
        com.tencent.mm.kernel.h.vH().gXC.a(new u(bizChatroomInfoUI.kbi, bizChatroomInfoUI.vve.field_bizChatServId), 0);
        bizChatroomInfoUI.jWp = false;
        bizChatroomInfoUI.getString(R.l.dIO);
        final ProgressDialog a = g.a((Context) bizChatroomInfoUI, bizChatroomInfoUI.getString(R.l.dJd), true, new OnCancelListener(bizChatroomInfoUI) {
            final /* synthetic */ BizChatroomInfoUI vwM;

            {
                this.vwM = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.vwM.jWp = true;
            }
        });
        com.tencent.mm.u.g.a(bizChatroomInfoUI.kbi, bizChatroomInfoUI.kbc, new ay.a(bizChatroomInfoUI) {
            final /* synthetic */ BizChatroomInfoUI vwM;

            public final boolean zs() {
                return this.vwM.jWp;
            }

            public final void zr() {
                if (a != null) {
                    com.tencent.mm.modelbiz.w.DK().V(this.vwM.kbc);
                    com.tencent.mm.modelbiz.w.DJ().V(this.vwM.kbc);
                    a.dismiss();
                }
            }
        });
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Contact_User", bizChatroomInfoUI.kbi);
        com.tencent.mm.bb.d.b(bizChatroomInfoUI.uSU.uTo, "brandservice", ".ui.BizChatConversationUI", intent);
        bizChatroomInfoUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.modelbiz.w.DJ().a(this.vvJ, Looper.getMainLooper());
        this.fromScene = getIntent().getIntExtra("key_biz_chat_info_from_scene", -1);
        this.kbi = getIntent().getStringExtra("Chat_User");
        this.kbc = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.vve = com.tencent.mm.modelbiz.w.DJ().aa(this.kbc);
        if (this.vve != null) {
            this.vwG = this.vve.field_chatName;
            this.vwH = com.tencent.mm.modelbiz.a.e.is(this.vve.field_bizChatServId);
            if (!this.vwH) {
                this.otS = com.tencent.mm.modelbiz.w.DL().iD(this.vve.field_bizChatServId);
            }
            this.vwL = com.tencent.mm.modelbiz.w.DL().iE(this.kbi);
        }
        KC();
        if (this.vve != null && this.vve.field_bizChatServId != null && this.kbi != null) {
            if (this.vve.DV()) {
                com.tencent.mm.modelbiz.w.DN();
                h.Z(this.vve.field_bizChatServId, this.kbi);
                return;
            }
            com.tencent.mm.modelbiz.w.DN();
            h.a(this.vve.field_bizChatServId, this.kbi, (m) this);
        }
    }

    public void onResume() {
        ajo();
        ajj();
        ajm();
        aTC();
        bTw();
        ajk();
        this.isJ.notifyDataSetChanged();
        super.onResume();
        if (!this.ktv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bg.mA(stringExtra)) {
                final int Tf = this.isJ.Tf(stringExtra);
                setSelection(Tf - 3);
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ BizChatroomInfoUI vwM;

                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) this.vwM.isJ).a(Tf, this.vwM.mUX);
                        if (a != null) {
                            com.tencent.mm.ui.h.a.b(this.vwM.uSU.uTo, a);
                        }
                    }
                }, 10);
            }
            this.ktv = true;
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        com.tencent.mm.ui.h.a.dismiss();
        com.tencent.mm.ui.h.a.dismiss();
        com.tencent.mm.modelbiz.w.DJ().a(this.vvJ);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    boolean Tl;
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra != null) {
                        w.i("MicroMsg.BizChatroomInfoUI", "bundle != null");
                        String string = bundleExtra.getString("enterprise_members");
                        w.i("MicroMsg.BizChatroomInfoUI", "enterprise_members:%s", string);
                        if (this.vwH) {
                            Tl = Tl(string);
                        } else {
                            ss ssVar = new ss();
                            c cVar = new c();
                            cVar.field_addMemberUrl = this.vwL != null ? this.vwL.field_addMemberUrl : null;
                            cVar.field_brandUserName = this.kbi;
                            if (com.tencent.mm.modelbiz.a.e.a(cVar, string, this.otS.field_userId, ssVar)) {
                                com.tencent.mm.modelbiz.w.DN();
                                final com.tencent.mm.modelbiz.a.n a = h.a(this.kbi, ssVar, (m) this);
                                getString(R.l.dIO);
                                this.isv = g.a((Context) this, getString(R.l.dCi), true, new OnCancelListener(this) {
                                    final /* synthetic */ BizChatroomInfoUI vwM;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(a);
                                    }
                                });
                                Tl = true;
                            } else {
                                Tl = false;
                            }
                        }
                    } else {
                        Tl = false;
                    }
                    if (!Tl) {
                        Toast.makeText(this, getString(R.l.eLX), 0).show();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private boolean Tl(String str) {
        if (str != null) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                gt gtVar = new gt();
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar;
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString(SlookAirButtonFrequentContactAdapter.ID);
                    j iD = com.tencent.mm.modelbiz.w.DL().iD(string);
                    if (iD == null) {
                        iD = new j();
                        iD.field_userId = string;
                        jVar = iD;
                    } else {
                        jVar = iD;
                    }
                    jVar.field_userName = jSONObject.getString("nick_name");
                    jVar.field_brandUserName = this.kbi;
                    jVar.field_headImageUrl = jSONObject.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject.getString("profile_url");
                    jVar.field_UserVersion = jSONObject.getInt("ver");
                    jVar.field_addMemberUrl = this.vwL != null ? this.vwL.field_addMemberUrl : null;
                    if (!com.tencent.mm.modelbiz.w.DL().b(jVar)) {
                        com.tencent.mm.modelbiz.w.DL().a(jVar);
                    }
                    gs gsVar = new gs();
                    gsVar.tkM = jVar.field_userId;
                    gtVar.tkN.add(gsVar);
                }
                a(gtVar, null);
                return true;
            } catch (Throwable e) {
                w.i("MicroMsg.BizChatroomInfoUI", "parse memberJson Exception:%s", e.getMessage());
                w.printErrStackTrace("MicroMsg.BizChatroomInfoUI", e, "", new Object[0]);
            }
        }
        return false;
    }

    private void a(gt gtVar, gt gtVar2) {
        w.i("MicroMsg.BizChatroomInfoUI", "updateBizChatMemberList()");
        String string = gtVar == null ? getString(R.l.eMd) : getString(R.l.dCi);
        com.tencent.mm.modelbiz.w.DN();
        final x a = h.a(this.vve.field_brandUserName, this.vve.field_bizChatServId, gtVar, gtVar2, this);
        getString(R.l.dIO);
        this.isv = g.a((Context) this, string, true, new OnCancelListener(this) {
            final /* synthetic */ BizChatroomInfoUI vwM;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(a);
            }
        });
    }

    public final int ON() {
        return R.o.fth;
    }

    protected final void KC() {
        this.isJ = this.vrv;
        String str = null;
        if (this.vve != null) {
            str = this.vve.field_ownerUserId;
            this.ktp = this.vve.DU().size();
        }
        if (bg.mA(str)) {
            this.kto = false;
        } else {
            this.kto = str.equals(com.tencent.mm.modelbiz.w.DL().iF(this.kbi));
        }
        w.d("MicroMsg.BizChatroomInfoUI", "initBaseChatRoomView()");
        this.ktf = (ContactListExpandPreference) this.isJ.Td("roominfo_contact_anchor");
        this.ktf.a(this.isJ, this.ktf.igL);
        this.ktb = (SignaturePreference) this.isJ.Td("room_name");
        this.ktg = (CheckBoxPreference) this.isJ.Td("room_notify_new_msg");
        this.kti = (CheckBoxPreference) this.isJ.Td("room_placed_to_the_top");
        this.kth = (CheckBoxPreference) this.isJ.Td("room_save_to_contact");
        ContactListExpandPreference contactListExpandPreference = this.ktf;
        boolean z = this.vwH;
        if (contactListExpandPreference.sNk != null) {
            contactListExpandPreference.sNk.sMx.sMM = z;
        }
        contactListExpandPreference = this.ktf;
        z = this.kto;
        if (contactListExpandPreference.sNk != null) {
            contactListExpandPreference.sNk.sMx.sML = z;
        }
        if (this.kto) {
            this.ktf.ju(true).jv(true);
        } else {
            this.ktf.ju(true).jv(false);
        }
        if (this.vve != null) {
            this.ktf.MT(this.vve.field_ownerUserId);
        }
        this.ktf.bFa();
        this.ktf.bFd();
        if (!this.vwH) {
            this.isJ.aV("room_save_to_contact", true);
            this.isJ.aV("room_name", true);
            this.isJ.aV("room_del_quit", true);
        }
        bTw();
        aTC();
        ajm();
        if (this.ktf != null) {
            this.mUX.setOnScrollListener(this.ktu);
            this.ktf.a(this.ktu);
            this.ktf.a(new ContactListExpandPreference.a(this) {
                final /* synthetic */ BizChatroomInfoUI vwM;

                {
                    this.vwM = r1;
                }

                public final void kK(int i) {
                    BizChatroomInfoUI.a(this.vwM, i);
                }

                public final void kL(int i) {
                    boolean z = true;
                    j AH = this.vwM.AH(i);
                    if (AH == null || bg.mA(AH.field_profileUrl)) {
                        String str = "MicroMsg.BizChatroomInfoUI";
                        String str2 = "onItemNormalClick userInfo == null:%s";
                        Object[] objArr = new Object[1];
                        if (AH != null) {
                            z = false;
                        }
                        objArr[0] = Boolean.valueOf(z);
                        w.w(str, str2, objArr);
                        return;
                    }
                    w.i("MicroMsg.BizChatroomInfoUI", "onItemNormalClick Url:%s", AH.field_profileUrl);
                    com.tencent.mm.modelbiz.w.DN();
                    h.a(AH.field_userId, AH.field_brandUserName, this.vwM);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", AH.field_profileUrl);
                    intent.putExtra("useJs", true);
                    com.tencent.mm.bb.d.b(this.vwM.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                }

                public final void ajs() {
                    if (this.vwM.ktf != null) {
                        this.vwM.ktf.bFb();
                    }
                }

                public final void kM(int i) {
                    BizChatroomInfoUI.c(this.vwM);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatroomInfoUI vwM;

            {
                this.vwM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vwM.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.igL;
        if (str.equals("room_name")) {
            String str2 = "";
            if (ajp()) {
                str2 = this.vve.field_chatName;
            }
            g.a(this.uSU.uTo, getString(R.l.eMQ), str2, "", 32, new g.b(this) {
                final /* synthetic */ BizChatroomInfoUI vwM;

                public final boolean u(CharSequence charSequence) {
                    return BizChatroomInfoUI.a(this.vwM, str2, charSequence);
                }
            });
        } else if (str.equals("room_notify_new_msg")) {
            this.kmK = !this.kmK;
            q(this.kmK, 1);
            ajm();
        } else if (str.equals("room_placed_to_the_top")) {
            if (this.vwJ) {
                z = false;
            }
            this.vwJ = z;
            q(this.vwJ, 16);
            if (this.vve != null) {
                if (this.vwJ) {
                    com.tencent.mm.modelbiz.w.DK().Y(this.vve.field_bizChatLocalId);
                } else {
                    com.tencent.mm.modelbiz.w.DK().Z(this.vve.field_bizChatLocalId);
                }
            }
        } else if (str.equals("room_del_quit")) {
            w.d("MicroMsg.BizChatroomInfoUI", " quit " + this.kbc);
            g.a(this.uSU.uTo, getString(R.l.ebq), "", new OnClickListener(this) {
                final /* synthetic */ BizChatroomInfoUI vwM;

                {
                    this.vwM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    BizChatroomInfoUI.d(this.vwM);
                }
            }, null);
        } else if (str.equals("room_save_to_contact")) {
            if (this.vwI) {
                z = false;
            }
            this.vwI = z;
            q(this.vwI, 8);
            bTw();
        }
        return false;
    }

    private void q(boolean z, int i) {
        this.vwK = this.vve.field_bitFlag;
        this.vwG = this.vve.field_chatName;
        if (this.vwH) {
            c cVar;
            if (z) {
                cVar = this.vve;
                cVar.field_bitFlag |= i;
            } else {
                cVar = this.vve;
                cVar.field_bitFlag &= i ^ -1;
            }
            w.i("MicroMsg.BizChatroomInfoUI", "dealSetMute:bitFlag %s", Integer.valueOf(this.vve.field_bitFlag));
            com.tencent.mm.modelbiz.w.DJ().b(this.vve);
        } else {
            j jVar;
            if (z) {
                jVar = this.otS;
                jVar.field_bitFlag |= i;
            } else {
                jVar = this.otS;
                jVar.field_bitFlag &= i ^ -1;
            }
            com.tencent.mm.modelbiz.w.DL().b(this.otS);
            this.vve.field_bitFlag = this.otS.field_bitFlag;
            com.tencent.mm.modelbiz.w.DJ().b(this.vve);
        }
        gq gqVar = new gq();
        gqVar.tkF = this.vve.field_bizChatServId;
        gqVar.tkH = this.vve.field_bitFlag;
        com.tencent.mm.modelbiz.w.DN();
        h.a(this.vve.field_brandUserName, gqVar, (m) this);
    }

    public final j AH(int i) {
        if (this.ktf.getItem(i) instanceof j) {
            return (j) this.ktf.getItem(i);
        }
        return null;
    }

    private void ajk() {
        if (this.ktf != null) {
            List ac;
            if (this.vwH) {
                ac = com.tencent.mm.modelbiz.a.e.ac(this.kbc);
            } else {
                ac = new LinkedList();
                ac.add(this.vve.field_bizChatServId);
            }
            if (ac != null) {
                this.ktp = ac.size();
            } else {
                this.ktp = 0;
            }
            if (this.ktp <= 1) {
                this.ktf.ju(true).jv(false);
            } else {
                this.ktf.ju(true).jv(this.kto);
            }
            this.ktf.k(this.kbi, ac);
        }
    }

    private void bTw() {
        w.d("MicroMsg.BizChatroomInfoUI", "updateSaveToContact()");
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.vwH) {
            this.vwI = this.vve.fu(8);
            this.vwK = this.vve.field_bitFlag;
        } else {
            this.vwI = this.otS.fu(8);
            this.vwK = this.otS.field_bitFlag;
        }
        if (this.vwI) {
            if (this.kth != null) {
                this.hgx.edit().putBoolean("room_save_to_contact", true).commit();
            }
        } else if (this.kth != null) {
            this.hgx.edit().putBoolean("room_save_to_contact", false).commit();
        }
        this.isJ.notifyDataSetChanged();
    }

    private void aTC() {
        w.d("MicroMsg.BizChatroomInfoUI", "updatePlaceTop()");
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.vwH) {
            this.vwJ = this.vve.fu(16);
            this.vwK = this.vve.field_bitFlag;
        } else {
            this.vwJ = this.otS.fu(16);
            this.vwK = this.otS.field_bitFlag;
        }
        if (this.kti != null) {
            this.hgx.edit().putBoolean("room_placed_to_the_top", this.vwJ).commit();
        }
        this.isJ.notifyDataSetChanged();
    }

    private void ajm() {
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.vwH) {
            this.kmK = this.vve.fu(1);
            this.vwK = this.vve.field_bitFlag;
        } else {
            this.kmK = this.otS.fu(1);
            this.vwK = this.otS.field_bitFlag;
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

    private void ajo() {
        if (this.vve != null && this.ktb != null) {
            if (ajp()) {
                CharSequence charSequence = this.vve.field_chatName;
                if (charSequence != null && charSequence.length() > 50) {
                    charSequence = charSequence.substring(0, 32);
                }
                w.i("MicroMsg.BizChatroomInfoUI", "updateRoomName chatName:%s", charSequence);
                SignaturePreference signaturePreference = this.ktb;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = getString(R.l.eUe);
                }
                signaturePreference.setSummary(com.tencent.mm.pluginsdk.ui.d.h.a((Context) this, charSequence));
                return;
            }
            this.ktb.setSummary(getString(R.l.eMA));
        }
    }

    private void ajj() {
        if (this.vwH) {
            this.ktp = com.tencent.mm.modelbiz.a.e.ab(this.kbc);
            if (this.ktp != 0) {
                qP(getString(R.l.eln, new Object[]{getString(R.l.eND), Integer.valueOf(this.ktp)}));
                return;
            }
        }
        qP(getString(R.l.eND));
    }

    private boolean ajp() {
        if (bg.mA(this.vwH ? this.vve.field_chatName : this.otS.field_userName)) {
            return false;
        }
        return true;
    }

    public final void a(int i, k kVar) {
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (kVar.getType() == 1355) {
            mt Eb = ((com.tencent.mm.modelbiz.a.n) kVar).Eb();
            ms Ec = ((com.tencent.mm.modelbiz.a.n) kVar).Ec();
            c iq = com.tencent.mm.modelbiz.w.DJ().iq(Eb.ttc.tAE.tkF);
            if (iq == null) {
                Toast.makeText(ab.getContext(), getString(R.l.eLX), 0).show();
            } else if (this.fromScene == 2) {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("biz_chat_need_to_jump_to_chatting_ui", true);
                r2.putExtra("Contact_User", Ec.tkL);
                r2.putExtra("biz_chat_chat_id", iq.field_bizChatLocalId);
                com.tencent.mm.bb.d.a((Context) this, ".ui.bizchat.BizChatConversationUI", r2);
            } else {
                r2 = new Intent();
                r2.addFlags(67108864);
                r2.putExtra("Chat_User", Ec.tkL);
                r2.putExtra("key_biz_chat_id", iq.field_bizChatLocalId);
                r2.putExtra("finish_direct", true);
                r2.putExtra("key_need_send_video", false);
                r2.putExtra("key_is_biz_chat", true);
                com.tencent.mm.plugin.chatroom.a.imv.e(r2, (Context) this);
            }
        } else if (kVar.getType() == 1356) {
            if (i != 0) {
                bTy();
            }
        } else if (kVar.getType() == 1353 && i >= 0 && this.otS != null) {
            this.otS = com.tencent.mm.modelbiz.w.DL().iD(this.otS.field_userId);
            bTx();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar == null) {
            w.e("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], scene is null", Integer.valueOf(i), Integer.valueOf(i2), str);
            return;
        }
        w.i("MicroMsg.BizChatroomInfoUI", "onSceneEnd: [%d], [%d], [%s], sceneType[%d]", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(kVar.getType()));
        this.ktp = com.tencent.mm.modelbiz.a.e.ab(this.kbc);
        w.d("MicroMsg.BizChatroomInfoUI", "now is " + this.ktp);
        if (this.isv != null) {
            this.isv.dismiss();
        }
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn != null) {
            dn.a(this, null, null);
        } else if (i == 0 && i2 == 0) {
            kVar.getType();
        } else {
            w.w("MicroMsg.BizChatroomInfoUI", "willen onSceneEnd err:Network not ok");
            bTy();
        }
    }

    private void bTx() {
        if (this.ktf != null) {
            ajo();
            ajj();
            ajm();
            ajk();
            bTw();
            aTC();
            this.ktf.notifyChanged();
        }
        this.isJ.notifyDataSetChanged();
    }

    private void bTy() {
        w.i("MicroMsg.BizChatroomInfoUI", "dealModChatNameFail reset bizChatName");
        this.vve.field_chatName = this.vwG;
        this.vve.field_bitFlag = this.vwK;
        this.kmK = this.vve.fu(1);
        this.vwI = this.vve.fu(8);
        this.vwJ = this.vve.fu(16);
        com.tencent.mm.modelbiz.w.DJ().b(this.vve);
        if (this.vwJ) {
            com.tencent.mm.modelbiz.w.DK().Y(this.vve.field_bizChatLocalId);
        } else if (!this.vwJ) {
            com.tencent.mm.modelbiz.w.DK().Z(this.vve.field_bizChatLocalId);
        }
        this.hgx.edit().putBoolean("room_placed_to_the_top", com.tencent.mm.modelbiz.w.DK().X(this.vve.field_bizChatLocalId)).commit();
        ajo();
        ajm();
        aTC();
        bTw();
        Toast.makeText(this, getString(R.l.eLY), 0).show();
    }

    public final com.tencent.mm.ui.base.preference.h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
