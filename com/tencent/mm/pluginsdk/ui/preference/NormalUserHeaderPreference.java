package com.tencent.mm.pluginsdk.ui.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.a;
import com.tencent.mm.pluginsdk.ui.ProfileDescribeView;
import com.tencent.mm.pluginsdk.ui.ProfileLabelView;
import com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.f;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.d;
import junit.framework.Assert;

public class NormalUserHeaderPreference extends Preference implements a, b, d.a {
    public MMActivity fCi;
    public x jiL;
    public boolean lib = false;
    private TextView nsG;
    private TextView osA;
    private String osP;
    private ImageView osx;
    private boolean ouF = false;
    private boolean ouy;
    private boolean ovH = false;
    int prC;
    private ImageView pri;
    public String sJG;
    public String sJH;
    private Button sSA;
    public FMessageListView sSB;
    private int sSC = 0;
    private boolean sSD = false;
    private boolean sSE = false;
    private boolean sSF = false;
    private boolean sSG = false;
    public boolean sSH = false;
    private boolean sSI = false;
    private boolean sSJ = false;
    private boolean sSK = false;
    private String sSL;
    private ProfileMobilePhoneView sSM;
    private ProfileDescribeView sSN;
    private ProfileLabelView sSO;
    private TextView sSP;
    public OnClickListener sSQ;
    public String sSR = null;
    private TextView sSo;
    private TextView sSp;
    private TextView sSq;
    private View sSr;
    private Button sSs;
    private Button sSt;
    private TextView sSu;
    private ImageView sSv;
    private CheckBox sSw;
    private ImageView sSx;
    private ImageView sSy;
    private LinearLayout sSz;

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        this.lib = false;
    }

    public NormalUserHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fCi = (MMActivity) context;
        this.lib = false;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        if (this.sSB != null) {
            this.sSB.detach();
        }
        return super.onCreateView(viewGroup);
    }

    public final void onBindView(View view) {
        w.d("MicroMsg.ContactInfoHeader", "onBindView");
        this.nsG = (TextView) view.findViewById(R.h.bFu);
        this.osA = (TextView) view.findViewById(R.h.bFL);
        this.sSu = (TextView) view.findViewById(R.h.bEV);
        this.sSo = (TextView) view.findViewById(R.h.bFa);
        this.sSp = (TextView) view.findViewById(R.h.bFv);
        this.sSs = (Button) view.findViewById(R.h.bFA);
        this.sSt = (Button) view.findViewById(R.h.bFI);
        this.sSM = (ProfileMobilePhoneView) view.findViewById(R.h.ckH);
        ProfileMobilePhoneView profileMobilePhoneView = this.sSM;
        ap.yY();
        profileMobilePhoneView.sJQ = ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.uBN, Boolean.valueOf(false))).booleanValue();
        this.sSN = (ProfileDescribeView) view.findViewById(R.h.bIa);
        this.sSO = (ProfileLabelView) view.findViewById(R.h.cac);
        this.sSP = (TextView) view.findViewById(R.h.cCG);
        this.sSN.setOnClickListener(this.sSQ);
        this.sSO.setOnClickListener(this.sSQ);
        this.sSP.setOnClickListener(this.sSQ);
        if (m.eH(this.jiL.field_username) || (!bg.mA(this.jiL.field_username) && o.fx(this.jiL.field_username))) {
            this.sSP.setVisibility(8);
            this.sSM.setVisibility(8);
            this.sSN.setVisibility(8);
            this.sSO.setVisibility(8);
        } else {
            ProfileMobilePhoneView profileMobilePhoneView2 = this.sSM;
            w.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", new Object[]{this.sJG, this.sJH});
            profileMobilePhoneView2.sJG = r2;
            profileMobilePhoneView2.sJH = r3;
            profileMobilePhoneView2.aTR();
            if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                this.sSM.setVisibility(0);
            } else {
                this.sSM.setVisibility(8);
            }
            boolean L = this.sSN.L(this.jiL);
            boolean L2 = this.sSO.L(this.jiL);
            if (L || L2) {
                this.sSP.setVisibility(8);
            } else {
                if (this.sSJ || this.sSH) {
                    this.sSP.setVisibility(8);
                } else {
                    this.sSP.setVisibility(0);
                }
                if (this.sSR != null && (this.sSR.equals("ContactWidgetBottleContact") || this.sSR.equals("ContactWidgetQContact"))) {
                    this.sSP.setVisibility(8);
                }
            }
        }
        this.sSq = (TextView) view.findViewById(R.h.bFi);
        this.sSA = (Button) view.findViewById(R.h.bFe);
        this.sSB = (FMessageListView) view.findViewById(R.h.bFf);
        a.a aVar = new a.a();
        aVar.fJL = this.jiL.field_username;
        aVar.scene = this.prC;
        aVar.osP = this.osP;
        aVar.type = 0;
        if (this.prC == 18) {
            aVar.type = 1;
        } else if (ay.fc(this.prC)) {
            aVar.type = 2;
        }
        this.sSB.sRR = aVar;
        a.sRR = aVar;
        this.sSr = view.findViewById(R.h.cFB);
        this.sSz = (LinearLayout) view.findViewById(R.h.bVU);
        this.osx = (ImageView) view.findViewById(R.h.bEX);
        this.pri = (ImageView) view.findViewById(R.h.bFF);
        this.sSv = (ImageView) view.findViewById(R.h.bFR);
        this.sSw = (CheckBox) view.findViewById(R.h.bFJ);
        this.sSx = (ImageView) view.findViewById(R.h.bFH);
        this.sSy = (ImageView) view.findViewById(R.h.bFG);
        this.lib = true;
        KC();
        if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            w.d("MicroMsg.ContactInfoHeader", "initAddContent, showFMessageList false");
            this.sSB.setVisibility(8);
            if (this.sSB.getVisibility() == 8 && this.sSP.getVisibility() == 8 && this.sSO.getVisibility() == 8 && this.sSN.getVisibility() == 8 && this.sSq.getVisibility() == 8) {
                this.sSr.setVisibility(8);
            }
        } else if (this.osP == null || this.osP.length() == 0) {
            w.d("MicroMsg.ContactInfoHeader", "initAddContent, FMessageListView gone, addScene = " + this.prC + ", verifyTicket = " + this.osP);
            this.sSB.setVisibility(8);
            if (this.sSB.getVisibility() == 8 && this.sSP.getVisibility() == 8 && this.sSO.getVisibility() == 8 && this.sSN.getVisibility() == 8 && this.sSq.getVisibility() == 8) {
                this.sSr.setVisibility(8);
            }
        } else {
            b[] a;
            w.d("MicroMsg.ContactInfoHeader", "initAddContent, scene = " + this.prC);
            if (this.prC == 18) {
                w.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is lbs");
                a = b.a(this.fCi, l.Kz().le(this.jiL.field_username));
            } else if (ay.fc(this.prC)) {
                w.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is shake");
                a = b.a(this.fCi, l.KA().lj(this.jiL.field_username));
            } else {
                w.d("MicroMsg.ContactInfoHeader", "initAddContent, scene is other");
                a = b.a(this.fCi, l.Kx().kZ(this.jiL.field_username));
            }
            if (a == null || a.length == 0) {
                w.e("MicroMsg.ContactInfoHeader", "initAddContent, providerList is null");
                this.sSB.setVisibility(8);
                if (this.sSB.getVisibility() == 8 && this.sSP.getVisibility() == 8 && this.sSO.getVisibility() == 8 && this.sSN.getVisibility() == 8 && this.sSq.getVisibility() == 8) {
                    this.sSr.setVisibility(8);
                }
            } else {
                w.d("MicroMsg.ContactInfoHeader", "initAddContent, providerList size = " + a.length);
                for (b bVar : a) {
                    if (bVar != null) {
                        w.d("MicroMsg.ContactInfoHeader", "initAddContent, username = " + bVar.username + ", nickname = " + bVar.fFa + ", digest = " + bVar.hku + ", addScene = " + bVar.prC);
                    }
                }
                this.sSB.setVisibility(0);
                if (this.sSB.getVisibility() == 0 || this.sSP.getVisibility() == 0 || this.sSO.getVisibility() == 0 || this.sSN.getVisibility() == 0 || this.sSq.getVisibility() == 0) {
                    this.sSr.setVisibility(0);
                }
                for (b a2 : a) {
                    this.sSB.a(a2);
                }
            }
        }
        super.onBindView(view);
    }

    public final boolean aTv() {
        return this.lib && this.jiL != null;
    }

    private void aXo() {
        com.tencent.mm.pluginsdk.ui.a.b.a(this.osx, this.jiL.field_username);
        if (this.osx != null) {
            int T = com.tencent.mm.bg.a.T(this.mContext, R.f.aWB);
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.fCi, 88);
            if (T <= fromDPToPix) {
                fromDPToPix = T;
            }
            LayoutParams layoutParams = new LinearLayout.LayoutParams(fromDPToPix, fromDPToPix);
            layoutParams.setMargins(0, 0, com.tencent.mm.bg.a.U(this.mContext, R.f.aXu), 0);
            this.osx.setLayoutParams(layoutParams);
        }
    }

    private void KC() {
        int i = 0;
        if (!aTv()) {
            w.w("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lib + "contact = " + this.jiL);
        } else if (this.ouF) {
            this.sSu.setVisibility(0);
            this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.tK()) + " ", this.nsG.getTextSize()));
            aXo();
            this.sSA.setVisibility(8);
            this.osA.setVisibility(8);
            this.sSB.setVisibility(8);
            if (this.sSB.getVisibility() == 8 && this.sSP.getVisibility() == 8 && this.sSO.getVisibility() == 8 && this.sSN.getVisibility() == 8 && this.sSq.getVisibility() == 8) {
                this.sSr.setVisibility(8);
            }
            this.sSs.setVisibility(8);
            this.sSt.setVisibility(8);
            this.sSw.setVisibility(8);
            if (this.sSO != null) {
                this.sSO.setVisibility(8);
            }
            if (this.sSM != null) {
                this.sSM.setVisibility(8);
            }
            if (this.sSN != null) {
                this.sSN.setVisibility(8);
            }
            if (this.sSP != null) {
                this.sSP.setVisibility(8);
            }
            if (this.sSp != null) {
                this.sSp.setVisibility(8);
            }
        } else {
            boolean eO = x.eO(this.jiL.field_username);
            if (eO) {
                this.nsG.setText("");
                if (x.QR(m.xL()).equals(this.jiL.field_username)) {
                    this.sSA.setVisibility(0);
                    this.sSA.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ NormalUserHeaderPreference sSS;

                        {
                            this.sSS = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.bb.d.w(this.sSS.fCi, "bottle", ".ui.BottlePersonalInfoUI");
                        }
                    });
                }
            } else {
                this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.tK()) + " ", this.nsG.getTextSize()));
            }
            this.pri.setVisibility(0);
            this.sSF = true;
            if (this.jiL.gkr == 1) {
                this.pri.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.dxs));
                this.pri.setContentDescription(this.mContext.getString(R.l.eHb));
            } else if (this.jiL.gkr == 2) {
                this.pri.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.dxr));
                this.pri.setContentDescription(this.mContext.getString(R.l.eHa));
            } else if (this.jiL.gkr == 0) {
                this.pri.setVisibility(8);
                this.sSF = false;
            }
            if (this.jiL.field_verifyFlag != 0) {
                Bitmap c;
                this.sSv.setVisibility(0);
                if (ag.a.hlU != null) {
                    c = BackwardSupportUtil.b.c(ag.a.hlU.eY(this.jiL.field_verifyFlag), 2.0f);
                } else {
                    c = null;
                }
                this.sSv.setImageBitmap(c);
                this.sSC = c == null ? 0 : c.getWidth();
            }
            aXo();
            this.osx.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference sSS;

                {
                    this.sSS = r1;
                }

                public final void onClick(View view) {
                    String str = this.sSS.jiL.field_username;
                    f fVar = new f(this.sSS.fCi, str);
                    if (x.eO(str)) {
                        x.QR(str);
                    }
                    fVar.bEf();
                }
            });
            if (x.QO(this.jiL.field_username)) {
                this.osA.setText(this.mContext.getString(R.l.dHd) + this.jiL.tM());
            } else if (x.QM(this.jiL.field_username)) {
                this.osA.setText(this.mContext.getString(R.l.dHm) + this.jiL.tM());
            } else if (this.ouy) {
                if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                    bGn();
                } else if (this.jiL.gkD == null || this.jiL.gkD.equals("")) {
                    this.osA.setText(R.l.dGO);
                } else {
                    this.osA.setText(this.jiL.gkD);
                }
            } else if (eO) {
                this.osA.setText((bg.mz(n.eM(this.jiL.getProvince())) + " " + bg.mz(this.jiL.getCity())).trim());
            } else {
                if (!x.QN(this.jiL.field_username) && this.fCi.getIntent().getBooleanExtra("Contact_ShowUserName", true)) {
                    if (bg.mA(this.jiL.pA()) && (x.aO(this.jiL.field_username, true) || o.eT(this.jiL.field_username))) {
                        this.osA.setVisibility(8);
                    } else if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                        bGn();
                    }
                }
                this.osA.setVisibility(8);
            }
            if (o.fx(this.jiL.field_username)) {
                this.sSq.setVisibility(0);
            } else {
                this.sSq.setVisibility(8);
            }
            bGp();
            bGo();
            bGq();
            if (bg.mA(this.sSL)) {
                this.sSo.setVisibility(8);
            } else {
                if (!m.eH(this.jiL.field_username) && bg.mz(this.jiL.field_conRemark).length() > 0) {
                    this.osA.setVisibility(8);
                }
                this.sSo.setVisibility(0);
                this.sSo.setText(h.b(this.fCi, this.fCi.getString(R.l.dXO) + this.sSL, this.sSo.getTextSize()));
            }
            this.sSs.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference sSS;

                {
                    this.sSS = r1;
                }

                public final void onClick(View view) {
                    this.sSS.sSH = false;
                    Preference preference = this.sSS;
                    ap.yY();
                    af Rc = c.wR().Rc(preference.jiL.field_username);
                    if (!(Rc == null || ((int) Rc.gTQ) == 0 || !Rc.field_username.equals(preference.jiL.field_username))) {
                        preference.jiL = Rc;
                    }
                    if (com.tencent.mm.j.a.ez(preference.jiL.field_type)) {
                        Intent intent = new Intent();
                        intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ContactRemarkInfoModUI");
                        intent.putExtra("Contact_Scene", preference.prC);
                        intent.putExtra("Contact_User", preference.jiL.field_username);
                        intent.putExtra("Contact_RoomNickname", preference.fCi.getIntent().getStringExtra("Contact_RoomNickname"));
                        ((Activity) preference.mContext).startActivity(intent);
                        return;
                    }
                    intent = new Intent();
                    intent.setClassName(preference.mContext, "com.tencent.mm.ui.contact.ModRemarkNameUI");
                    intent.putExtra("Contact_Scene", preference.prC);
                    intent.putExtra("Contact_mode_name_type", 0);
                    intent.putExtra("Contact_ModStrangerRemark", true);
                    intent.putExtra("Contact_User", preference.jiL.field_username);
                    intent.putExtra("Contact_Nick", preference.jiL.field_nickname);
                    intent.putExtra("Contact_RemarkName", preference.jiL.field_conRemark);
                    ((Activity) preference.mContext).startActivity(intent);
                }
            });
            this.sSt.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NormalUserHeaderPreference sSS;

                {
                    this.sSS = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_userName", this.sSS.jiL.field_username);
                    intent.putExtra("sns_permission_anim", true);
                    intent.putExtra("sns_permission_block_scene", 3);
                    com.tencent.mm.bb.d.b(this.sSS.fCi, "sns", ".ui.SnsPermissionUI", intent);
                }
            });
            if (this.sSF) {
                i = com.tencent.mm.bg.a.fromDPToPix(this.fCi, 17) + 0;
            }
            int i2 = this.sSC + i;
            if (this.sSD) {
                i2 += com.tencent.mm.bg.a.fromDPToPix(this.fCi, 27);
            }
            if (this.sSE) {
                i2 += com.tencent.mm.bg.a.fromDPToPix(this.fCi, 27);
            }
            if (this.sSG) {
                i2 += com.tencent.mm.bg.a.fromDPToPix(this.fCi, 30);
            }
            if (com.tencent.mm.bg.a.dM(this.mContext)) {
                i2 += com.tencent.mm.bg.a.fromDPToPix(this.fCi, 88);
            } else {
                i2 += com.tencent.mm.bg.a.fromDPToPix(this.fCi, 64);
            }
            this.nsG.setMaxWidth(this.fCi.getResources().getDisplayMetrics().widthPixels - (i2 + com.tencent.mm.bg.a.fromDPToPix(this.fCi, 60)));
        }
    }

    private void bGn() {
        x.bLd();
        this.osA.setVisibility(0);
        if (!bg.mA(this.jiL.pA())) {
            this.osA.setText(this.mContext.getString(R.l.dHi) + this.jiL.pA());
        } else if (x.aO(this.jiL.field_username, true) || o.eT(this.jiL.field_username)) {
            this.osA.setVisibility(8);
        } else {
            this.osA.setText(this.mContext.getString(R.l.dHi) + bg.mz(this.jiL.tM()));
        }
    }

    public final void aM(String str, boolean z) {
        if (str != null && str.equals(this.jiL.field_username)) {
            this.sSH = z;
        }
    }

    public final void aN(String str, boolean z) {
        if (str != null && str.equals(this.jiL.field_username)) {
            this.sSI = z;
        }
    }

    public final void a(x xVar, int i, String str) {
        boolean z;
        boolean z2 = true;
        onDetach();
        ap.yY();
        c.wR().a(this);
        ap.yY();
        c.wS().a(this);
        com.tencent.mm.x.n.Bl().d(this);
        this.jiL = xVar;
        this.prC = i;
        this.osP = str;
        this.ouy = this.fCi.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.sSK = this.fCi.getIntent().getBooleanExtra("Contact_ShowFMessageList", false);
        this.sSH = this.fCi.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.sSI = this.fCi.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.sSJ = this.fCi.getIntent().getBooleanExtra("Contact_AlwaysShowRemarkBtn", false);
        this.ovH = this.fCi.getIntent().getBooleanExtra("Contact_AlwaysShowSnsPreBtn", false);
        this.sSL = this.fCi.getIntent().getStringExtra("Contact_RoomNickname");
        if (xVar.field_deleteFlag == 1) {
            z = true;
        } else {
            z = false;
        }
        this.ouF = z;
        String str2 = "initView: contact username is null";
        if (bg.mz(xVar.field_username).length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        KC();
    }

    public final void onDetach() {
        if (this.sSB != null) {
            this.sSB.detach();
        }
        if (this.sSK) {
            l.Ky().kW(this.jiL.field_username);
        }
        this.fCi.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.sSH);
        this.fCi.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.sSI);
        ap.yY();
        c.wR().b(this);
        com.tencent.mm.x.n.Bl().e(this);
        ap.yY();
        c.wS().b(this);
    }

    public final void bGo() {
        int i = 0;
        if (this.sSx != null && o.eN(this.jiL.field_username)) {
            this.sSE = this.jiL.tF();
            this.sSx.setVisibility(this.sSE ? 0 : 8);
        }
        if (this.sSy != null && o.eN(this.jiL.field_username)) {
            boolean P;
            String str = this.jiL.field_username;
            if (com.tencent.mm.plugin.sns.b.m.pQD != null) {
                P = com.tencent.mm.plugin.sns.b.m.pQD.P(str, 5);
            } else {
                P = false;
            }
            this.sSD = P;
            ImageView imageView = this.sSy;
            if (!this.sSD) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    public final void bGp() {
        if (m.eH(this.jiL.field_username) || bg.mz(this.jiL.field_conRemark).length() <= 0) {
            this.sSp.setVisibility(8);
            this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.tK()) + " ", this.nsG.getTextSize()));
            if (this.sSJ) {
                this.sSs.setVisibility(0);
                this.sSP.setVisibility(8);
            } else if (this.sSH) {
                this.sSs.setVisibility(0);
                this.sSP.setVisibility(8);
            } else {
                if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                    this.sSs.setVisibility(8);
                }
                boolean L = this.sSN.L(this.jiL);
                boolean L2 = this.sSO.L(this.jiL);
                if (L || L2) {
                    this.sSP.setVisibility(8);
                }
            }
        } else {
            this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.field_conRemark) + " ", this.nsG.getTextSize()));
            this.sSp.setVisibility(0);
            this.sSp.setText(h.b(this.fCi, this.mContext.getString(R.l.dYU) + this.jiL.tK(), this.sSp.getTextSize()));
            this.sSs.setVisibility(8);
        }
        if (this.ovH && !com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            this.sSt.setVisibility(0);
        } else if (this.sSI) {
            this.sSt.setVisibility(0);
            if (com.tencent.mm.bg.a.dM(this.fCi)) {
                this.sSt.setTextSize(0, (float) this.fCi.getResources().getDimensionPixelSize(R.f.aXs));
                this.sSs.setTextSize(0, (float) this.fCi.getResources().getDimensionPixelSize(R.f.aXs));
            }
        } else {
            this.sSt.setVisibility(8);
        }
        if (x.eO(this.jiL.field_username)) {
            this.nsG.setText("");
        }
        if (this.prC == 76 && this.jiL.field_username != null && this.jiL.field_username.endsWith("@stranger")) {
            this.nsG.setText(h.b(this.fCi, bg.mz(this.jiL.field_nickname) + " ", this.nsG.getTextSize()));
        }
        if (this.sSt.getVisibility() == 0 && this.sSp.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.sSp.getLayoutParams();
            layoutParams.topMargin = this.mContext.getResources().getDimensionPixelSize(R.f.aXR);
            this.sSp.setLayoutParams(layoutParams);
        }
    }

    public final void bGq() {
        this.sSw.setClickable(false);
        if (o.eN(this.jiL.field_username) && com.tencent.mm.j.a.ez(this.jiL.field_type) && !m.eH(this.jiL.field_username)) {
            this.sSw.setVisibility(0);
            if (this.jiL.tC()) {
                this.sSw.setChecked(true);
                this.sSG = true;
                return;
            }
            this.sSw.setChecked(false);
            this.sSw.setVisibility(8);
            this.sSG = false;
            return;
        }
        this.sSG = false;
        this.sSw.setVisibility(8);
    }

    public final void ho(String str) {
        if (!aTv()) {
            w.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lib + "contact = " + this.jiL);
        } else if (bg.mz(str).length() <= 0) {
            w.e("MicroMsg.ContactInfoHeader", "notifyChanged: user = " + str);
        } else if (str.equals(this.jiL.field_username)) {
            KC();
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        w.d("MicroMsg.ContactInfoHeader", "onNotifyChange event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
        if (obj == null || !(obj instanceof String)) {
            w.e("MicroMsg.ContactInfoHeader", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[]{Integer.valueOf(i), mVar, obj});
            return;
        }
        String str = (String) obj;
        w.d("MicroMsg.ContactInfoHeader", "onNotifyChange username = " + str + ", contact = " + this.jiL);
        if (!aTv()) {
            w.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.lib + "contact = " + this.jiL);
        } else if (bg.mz(str).length() > 0 && this.jiL != null && this.jiL.field_username.equals(str)) {
            ap.yY();
            this.jiL = c.wR().Rc(str);
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ NormalUserHeaderPreference sSS;

                {
                    this.sSS = r1;
                }

                public final void run() {
                    int i = 0;
                    this.sSS.bGp();
                    this.sSS.bGq();
                    this.sSS.bGo();
                    if (this.sSS.sSB != null) {
                        boolean z;
                        FMessageListView fMessageListView = this.sSS.sSB;
                        if (com.tencent.mm.j.a.ez(this.sSS.jiL.field_type)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        int childCount = fMessageListView.getChildCount();
                        w.d("MicroMsg.FMessageListView", "setReplyBtnVisible, visible = " + z + ", current child count = " + childCount);
                        if (childCount <= 2) {
                            w.e("MicroMsg.FMessageListView", "setReplyBtnVisible fail, childCount invalid = " + childCount);
                            return;
                        }
                        if (fMessageListView.sSa != null) {
                            fMessageListView.sSa.setVisibility(z ? 0 : 8);
                        }
                        if (fMessageListView.sSb != null) {
                            a aVar = fMessageListView.sSb;
                            if (!z) {
                                i = 8;
                            }
                            aVar.setVisibility(i);
                        }
                    }
                }
            });
        }
    }

    public final void a(final bb bbVar) {
        com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
            final /* synthetic */ NormalUserHeaderPreference sSS;

            public final void run() {
                if (this.sSS.jiL != null && bbVar != null && this.sSS.jiL.field_username.equals(bbVar.field_encryptUsername)) {
                    this.sSS.jiL.bP(bbVar.field_conRemark);
                    if (this.sSS.aTv()) {
                        this.sSS.bGp();
                    } else {
                        w.e("MicroMsg.ContactInfoHeader", "initView : bindView = " + this.sSS.lib + "contact = " + this.sSS.jiL.field_username);
                    }
                }
            }
        });
    }
}
