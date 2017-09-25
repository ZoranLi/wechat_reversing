package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.av.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.ap;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.sns.b.g.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.j;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.TextPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import junit.framework.Assert;
import org.json.JSONObject;

public final class k implements a, com.tencent.mm.pluginsdk.d.a, e {
    public String fDY = null;
    private int fJn = 0;
    public Activity fPi;
    private f isJ;
    public x jiL;
    q ktr;
    public String kuC;
    private String mKf;
    private boolean osM;
    private boolean osN;
    int osO;
    private String osP;
    private int ouA = -1;
    private boolean ouB = false;
    private boolean ouC = false;
    private String ouD;
    private boolean ouE = false;
    private boolean ouF = false;
    private String ouG = null;
    private String ouH = null;
    private int ouI;
    String ouJ;
    c<ap> ouK = new c<ap>(this) {
        final /* synthetic */ k ouL;

        {
            this.ouL = r2;
            this.usg = ap.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final ap apVar = (ap) bVar;
            w.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] username:%s inviteer:%s", new Object[]{apVar.fDX.username, apVar.fDX.fDY});
            if (!(bg.mA(apVar.fDX.username) || !apVar.fDX.username.equals(this.ouL.jiL.field_username) || bg.mA(apVar.fDX.fDY))) {
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass5 ouO;

                    public final void run() {
                        final String str = apVar.fDX.fDY;
                        this.ouO.ouL.fPi.getIntent().putExtra("inviteer", str);
                        String eK = this.ouO.ouL.eK(apVar.fDX.fDY);
                        w.i("MicroMsg.ContactWidgetNormal", "[ChatroomMemberInviteerUpdatedEvent callback] inviteer:%s inviteerDisplayName:%s", new Object[]{str, eK});
                        if (bg.mA(eK)) {
                            ag.a.hlS.a(str, "", new ag.b.a(this) {
                                final /* synthetic */ AnonymousClass1 ouQ;

                                public final void p(String str, boolean z) {
                                    w.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.ouQ.ouO.ouL.kuC, Boolean.valueOf(z)});
                                    if (z) {
                                        com.tencent.mm.u.ap.yY();
                                        this.ouQ.ouO.ouL.dd(str, com.tencent.mm.u.c.wR().Rc(str).tK());
                                    }
                                }
                            });
                        } else {
                            this.ouO.ouL.dd(str, eK);
                        }
                    }
                });
            }
            return false;
        }
    };
    private int ouq;
    private bcp oux = new bcp();
    private boolean ouy;
    private String ouz = "";

    public k(Activity activity) {
        this.fPi = activity;
    }

    public final boolean sa(String str) {
        Intent intent;
        if (str.equals("contact_info_sns")) {
            com.tencent.mm.u.ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                intent = this.fPi.getIntent();
                intent.putExtra("sns_source", this.fJn);
                intent.putExtra("sns_signature", this.jiL.signature);
                intent.putExtra("sns_nickName", this.jiL.tK());
                intent.putExtra("sns_title", this.jiL.tL());
                if (m.pQF != null) {
                    intent = m.pQF.f(intent, this.jiL.field_username);
                }
                if (intent == null) {
                    ((MMActivity) this.fPi).finish();
                } else {
                    d.b(this.fPi, "sns", ".ui.SnsUserUI", intent);
                    if ((intent.getFlags() & 67108864) != 0) {
                        ((MMActivity) this.fPi).finish();
                    }
                }
            } else {
                s.eP(this.fPi);
                return true;
            }
        }
        String stringExtra;
        long longExtra;
        if (str.equals("contact_info_more")) {
            Intent intent2 = new Intent();
            intent2.setClass(this.fPi, ContactMoreInfoUI.class);
            intent2.putExtra("Is_RoomOwner", this.fPi.getIntent().getBooleanExtra("Is_RoomOwner", false));
            intent2.putExtra("Contact_User", this.jiL.field_username);
            intent2.putExtra("KLinkedInAddFriendNickName", this.ouG);
            intent2.putExtra("KLinkedInAddFriendPubUrl", this.ouH);
            stringExtra = this.fPi.getIntent().getStringExtra("room_name");
            if (stringExtra == null) {
                stringExtra = this.fPi.getIntent().getStringExtra("Contact_ChatRoomId");
            }
            intent2.putExtra("Contact_ChatRoomId", stringExtra);
            intent2.putExtra("verify_gmail", this.mKf);
            intent2.putExtra("profileName", this.ouD);
            longExtra = this.fPi.getIntent().getLongExtra("Contact_Uin", 0);
            stringExtra = this.fPi.getIntent().getStringExtra("Contact_QQNick");
            intent2.putExtra("Contact_Uin", longExtra);
            intent2.putExtra("Contact_QQNick", stringExtra);
            this.fPi.startActivity(intent2);
        } else if (str.equals("contact_info_social")) {
            intent = new Intent();
            intent.setClass(this.fPi, ContactSocialInfoUI.class);
            intent.putExtra("Contact_User", this.jiL.field_username);
            longExtra = this.fPi.getIntent().getLongExtra("Contact_Uin", 0);
            r1 = this.fPi.getIntent().getStringExtra("Contact_QQNick");
            intent.putExtra("Contact_Uin", longExtra);
            intent.putExtra("Contact_QQNick", r1);
            intent.putExtra("profileName", this.ouD);
            intent.putExtra("verify_gmail", this.mKf);
            r1 = this.fPi.getIntent().getStringExtra("Contact_Mobile_MD5");
            String stringExtra2 = this.fPi.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            intent.putExtra("Contact_Mobile_MD5", r1);
            intent.putExtra("Contact_full_Mobile_MD5", stringExtra2);
            this.fPi.startActivity(intent);
        } else if (str.equals("contact_info_invite_source")) {
            stringExtra = ((KeyValuePreference) this.isJ.Td("contact_info_invite_source")).getExtras().getString("inviteer");
            if (!bg.mA(stringExtra)) {
                r1 = eK(stringExtra);
                Intent intent3 = new Intent();
                intent3.putExtra("Contact_User", stringExtra);
                intent3.putExtra("Contact_RemarkName", r1);
                intent3.putExtra("Contact_RoomNickname", r1);
                intent3.putExtra("Contact_RoomMember", true);
                intent3.putExtra("room_name", this.kuC);
                com.tencent.mm.u.ap.yY();
                intent3.putExtra("Contact_Nick", com.tencent.mm.u.c.wR().Rc(stringExtra).field_nickname);
                intent3.putExtra("Contact_Scene", 14);
                intent3.putExtra("Is_RoomOwner", true);
                intent3.putExtra("Contact_ChatRoomId", this.kuC);
                com.tencent.mm.plugin.profile.a.imv.d(intent3, this.fPi);
            }
        }
        return true;
    }

    final void CG(String str) {
        if (bg.mA(str)) {
            w.w("MicroMsg.ContactWidgetNormal", "view stranger remark, username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Scene", this.osO);
        intent.putExtra("Contact_mode_name_type", 0);
        intent.putExtra("Contact_ModStrangerRemark", true);
        intent.putExtra("Contact_User", this.jiL.field_username);
        intent.putExtra("Contact_Nick", this.jiL.field_nickname);
        intent.putExtra("Contact_RemarkName", this.jiL.field_conRemark);
        com.tencent.mm.plugin.profile.a.imv.r(intent, this.fPi);
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        String stringExtra;
        String str;
        int i2;
        KeyValuePreference keyValuePreference;
        Assert.assertTrue(xVar != null);
        Assert.assertTrue(bg.mz(xVar.field_username).length() > 0);
        Assert.assertTrue(fVar != null);
        this.isJ = fVar;
        this.jiL = xVar;
        this.osM = z;
        this.osO = i;
        this.osN = this.fPi.getIntent().getBooleanExtra("User_Verify", false);
        this.osP = bg.mz(this.fPi.getIntent().getStringExtra("Verify_ticket"));
        this.ouy = this.fPi.getIntent().getBooleanExtra("Contact_IsLBSFriend", false);
        this.ouq = this.fPi.getIntent().getIntExtra("Kdel_from", -1);
        this.ouz = this.fPi.getIntent().getStringExtra("Contact_RemarkName");
        this.fJn = this.fPi.getIntent().getIntExtra("Sns_from_Scene", 0);
        this.ouB = this.fPi.getIntent().getBooleanExtra("Contact_NeedShowChangeRemarkButton", false);
        this.ouC = this.fPi.getIntent().getBooleanExtra("Contact_NeedShowChangeSnsPreButton", false);
        this.ouA = this.fPi.getIntent().getIntExtra("Contact_KSnsIFlag", -1);
        long longExtra = this.fPi.getIntent().getLongExtra("Contact_KSnsBgId", -1);
        String ap = bg.ap(this.fPi.getIntent().getStringExtra("Contact_KSnsBgUrl"), "");
        this.mKf = bg.ap(this.fPi.getIntent().getStringExtra("verify_gmail"), "");
        this.ouD = bg.ap(this.fPi.getIntent().getStringExtra("profileName"), bg.Qi(this.mKf));
        this.oux.hAO = this.ouA;
        this.oux.hAQ = longExtra;
        this.oux.hAP = ap;
        this.ouG = this.fPi.getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.ouH = this.fPi.getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        if (m.pQB != null) {
            this.oux = m.pQB.b(xVar.field_username, this.oux);
        }
        this.kuC = this.fPi.getIntent().getStringExtra("room_name");
        com.tencent.mm.u.ap.yY();
        this.ktr = com.tencent.mm.u.c.xa().fV(this.kuC);
        this.ouF = xVar.field_deleteFlag == 1;
        adI();
        this.isJ.removeAll();
        this.isJ.addPreferencesFromResource(R.o.ftw);
        if (m.pQF != null) {
            m.pQF.a(3, this.jiL.field_username, this);
        }
        com.tencent.mm.u.ap.vd().a(30, this);
        this.ouJ = "";
        w.i("MicroMsg.ContactWidgetNormal", "isCancelMatchPhoneMD5 %s", new Object[]{this.jiL.tH()});
        if (!this.jiL.tH()) {
            com.tencent.mm.modelfriend.b bVar = null;
            stringExtra = this.fPi.getIntent().getStringExtra("Contact_Mobile_MD5");
            ap = this.fPi.getIntent().getStringExtra("Contact_full_Mobile_MD5");
            Object[] objArr;
            if (bg.mA(stringExtra) && bg.mA(ap)) {
                if (!bg.mA(this.jiL.field_username)) {
                    com.tencent.mm.modelfriend.b iZ = com.tencent.mm.modelfriend.af.FY().iZ(this.jiL.field_username);
                    ap = "MicroMsg.ContactWidgetNormal";
                    str = "Contact name: %s AddrUpload IS NULL? %s";
                    objArr = new Object[2];
                    objArr[0] = this.jiL.field_username;
                    objArr[1] = iZ == null ? "true" : "false";
                    w.i(ap, str, objArr);
                    bVar = iZ;
                }
            } else if (!(bg.mA(stringExtra) && bg.mA(ap))) {
                w.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s mobileFullMD5:%s", new Object[]{this.jiL.field_username, stringExtra, ap});
                bVar = com.tencent.mm.modelfriend.af.FY().ja(stringExtra);
                if (bVar == null || bg.mA(bVar.EP())) {
                    bVar = com.tencent.mm.modelfriend.af.FY().ja(ap);
                }
                ap = "MicroMsg.ContactWidgetNormal";
                str = "Contact name: %s AddrUpload IS NULL? %s";
                objArr = new Object[2];
                objArr[0] = this.jiL.field_username;
                objArr[1] = bVar == null ? "true" : "false";
                w.i(ap, str, objArr);
            }
            if (!(bVar == null || bg.mA(bVar.EP()))) {
                this.ouJ = bg.mz(bVar.EX()).replace(" ", "");
                w.i("MicroMsg.ContactWidgetNormal", "Contact name: %s mMobileByMD5: %s", new Object[]{this.jiL.field_username, this.ouJ});
            }
        }
        final NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.isJ.Td("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            x xVar2 = this.jiL;
            i2 = this.osO;
            ap = this.osP;
            str = this.ouJ;
            String str2 = this.jiL.gkQ;
            normalUserHeaderPreference.sJG = str;
            normalUserHeaderPreference.sJH = str2;
            normalUserHeaderPreference.a(xVar2, i2, ap);
            normalUserHeaderPreference.aM(this.jiL.field_username, this.ouB);
            normalUserHeaderPreference.sSQ = new OnClickListener(this) {
                final /* synthetic */ k ouL;

                {
                    this.ouL = r1;
                }

                public final void onClick(View view) {
                    k kVar = this.ouL;
                    if (kVar.jiL == null) {
                        w.e("MicroMsg.ContactWidgetNormal", "contact is null");
                    } else if (com.tencent.mm.j.a.ez(kVar.jiL.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_Scene", kVar.osO);
                        intent.putExtra("Contact_User", kVar.jiL.field_username);
                        intent.putExtra("Contact_RoomNickname", kVar.fPi.getIntent().getStringExtra("Contact_RoomNickname"));
                        intent.putExtra("view_mode", true);
                        intent.putExtra("contact_phone_number_by_md5", kVar.ouJ);
                        intent.putExtra("contact_phone_number_list", kVar.jiL.gkQ);
                        com.tencent.mm.plugin.profile.a.imv.q(intent, kVar.fPi);
                    } else if (bg.mA(kVar.jiL.field_encryptUsername)) {
                        kVar.CG(kVar.jiL.field_username);
                    } else {
                        kVar.CG(kVar.jiL.field_encryptUsername);
                    }
                }
            };
            if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
                this.ouC = false;
            }
            normalUserHeaderPreference.aN(this.jiL.field_username, this.ouC);
        } else {
            this.isJ.c(normalUserHeaderPreference);
        }
        if (bg.mA(this.jiL.getProvince())) {
            this.isJ.Te("contact_info_district");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_district");
            if (keyValuePreference != null) {
                keyValuePreference.setTitle(this.fPi.getString(R.l.dXY));
                keyValuePreference.setSummary(n.eM(this.jiL.getProvince()) + (bg.mA(this.jiL.getCity()) ? "" : "  " + this.jiL.getCity()));
                keyValuePreference.kZ(false);
                keyValuePreference.setEnabled(false);
            }
        }
        if (this.jiL.signature == null || this.jiL.signature.trim().equals("") || com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            this.isJ.Te("contact_info_signature");
        } else {
            keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_signature");
            if (keyValuePreference != null) {
                keyValuePreference.vrl = false;
                keyValuePreference.setTitle(this.fPi.getString(R.l.dZF));
                keyValuePreference.setSummary(h.a(this.fPi, this.jiL.signature));
                keyValuePreference.kZ(false);
            }
        }
        this.isJ.Td("contact_info_facebook");
        this.isJ.Te("contact_info_facebook");
        if ((((this.oux.hAO & 1) > 0 ? 1 : 0) & d.Jt("sns")) == 0 || x.QN(this.jiL.field_username) || this.jiL.tA()) {
            this.isJ.Te("contact_info_sns");
        } else {
            g gVar = (g) this.isJ.Td("contact_info_sns");
            if (!(gVar == null || m.pQB == null)) {
                gVar.Nf(this.jiL.field_username);
            }
        }
        this.isJ.Te("contact_info_verifyuser");
        if (this.osO == 34) {
            this.isJ.Te("contact_info_footer_normal");
        }
        Object obj;
        if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            int[] iArr = new int[7];
            ContactMoreInfoPreference contactMoreInfoPreference = (ContactMoreInfoPreference) this.isJ.Td("contact_info_more");
            if (contactMoreInfoPreference != null) {
                long longExtra2 = this.fPi.getIntent().getLongExtra("Contact_Uin", 0);
                if (longExtra2 == -1 || new o(longExtra2).longValue() <= 0) {
                    contactMoreInfoPreference.rn(8);
                    iArr[0] = 8;
                } else {
                    contactMoreInfoPreference.rn(0);
                    iArr[0] = 0;
                }
                if (bg.mA(this.mKf) || bg.mA(this.ouD)) {
                    contactMoreInfoPreference.rp(8);
                    iArr[1] = 8;
                } else {
                    contactMoreInfoPreference.rp(0);
                    iArr[1] = 0;
                }
                stringExtra = com.tencent.mm.i.g.sV().getValue("LinkedinPluginClose");
                obj = (bg.mA(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0) ? 1 : null;
                if (obj == null || bg.mA(this.jiL.gkM)) {
                    contactMoreInfoPreference.ro(8);
                    iArr[2] = 8;
                } else {
                    contactMoreInfoPreference.ro(0);
                    iArr[2] = 0;
                }
                if (com.tencent.mm.u.m.xL().equals(this.jiL.field_username)) {
                    com.tencent.mm.u.ap.yY();
                    stringExtra = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCg, null);
                } else {
                    stringExtra = this.jiL.gkP;
                }
                if (!bg.mA(stringExtra)) {
                    try {
                        stringExtra = new JSONObject(stringExtra).optString("ShopUrl");
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.ContactWidgetNormal", e, "", new Object[0]);
                    }
                    if (bg.mA(stringExtra)) {
                        contactMoreInfoPreference.rq(0);
                        iArr[3] = 0;
                    } else {
                        contactMoreInfoPreference.rq(8);
                        iArr[3] = 8;
                    }
                    if (bg.mA(this.jiL.signature)) {
                        iArr[4] = 0;
                    } else {
                        iArr[4] = 8;
                    }
                    if (this.jiL.getSource() > 0) {
                        iArr[5] = 8;
                    } else {
                        iArr[5] = 0;
                    }
                    iArr[6] = 8;
                    this.isJ.aV("contact_info_more", false);
                }
                stringExtra = null;
                if (bg.mA(stringExtra)) {
                    contactMoreInfoPreference.rq(8);
                    iArr[3] = 8;
                } else {
                    contactMoreInfoPreference.rq(0);
                    iArr[3] = 0;
                }
                if (bg.mA(this.jiL.signature)) {
                    iArr[4] = 0;
                } else {
                    iArr[4] = 8;
                }
                if (this.jiL.getSource() > 0) {
                    iArr[5] = 0;
                } else {
                    iArr[5] = 8;
                }
                iArr[6] = 8;
                this.isJ.aV("contact_info_more", false);
            }
            this.isJ.Te("contact_info_social");
        } else {
            ContactSocialInfoPreference contactSocialInfoPreference = (ContactSocialInfoPreference) this.isJ.Td("contact_info_social");
            if (contactSocialInfoPreference != null) {
                if (bg.mA(this.ouJ)) {
                    contactSocialInfoPreference.rr(8);
                } else {
                    contactSocialInfoPreference.rr(0);
                    this.ouI = 1;
                }
                com.tencent.mm.u.ap.yY();
                i2 = bg.f((Integer) com.tencent.mm.u.c.vr().get(9, null));
                long longExtra3 = this.fPi.getIntent().getLongExtra("Contact_Uin", 0);
                str2 = this.fPi.getIntent().getStringExtra("Contact_QQNick");
                if (!(longExtra3 == 0 || i2 == 0)) {
                    if (str2 == null || str2.length() == 0) {
                        ad af = com.tencent.mm.modelfriend.af.Gd().af(longExtra3);
                        if (af == null) {
                            af = null;
                        }
                        if (af != null) {
                            af.getDisplayName();
                        }
                    }
                    if (longExtra3 == -1 || new o(longExtra3).longValue() <= 0) {
                        contactSocialInfoPreference.rn(8);
                    } else {
                        contactSocialInfoPreference.rn(0);
                        this.ouI = 1;
                    }
                }
                if (bg.mA(this.mKf) || bg.mA(this.ouD)) {
                    contactSocialInfoPreference.rp(8);
                } else {
                    contactSocialInfoPreference.rp(0);
                    this.ouI = 1;
                }
                stringExtra = com.tencent.mm.i.g.sV().getValue("LinkedinPluginClose");
                obj = (bg.mA(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0) ? 1 : null;
                if (obj == null || bg.mA(this.jiL.gkM)) {
                    contactSocialInfoPreference.ro(8);
                } else {
                    contactSocialInfoPreference.ro(0);
                    this.ouI = 1;
                }
                if (com.tencent.mm.u.m.xL().equals(this.jiL.field_username)) {
                    com.tencent.mm.u.ap.yY();
                    stringExtra = (String) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCg, null);
                } else {
                    stringExtra = this.jiL.gkP;
                }
                ap = null;
                if (!bg.mA(stringExtra)) {
                    try {
                        ap = new JSONObject(stringExtra).optString("ShopUrl");
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.ContactWidgetNormal", e2, "", new Object[0]);
                    }
                }
                w.i("MicroMsg.ContactWidgetNormal", "weiShopInfo:%s, shopUrl:%s", new Object[]{stringExtra, ap});
                if (bg.mA(ap)) {
                    contactSocialInfoPreference.rq(8);
                } else {
                    contactSocialInfoPreference.rq(0);
                    this.ouI = 1;
                }
                if (this.ouI == 0) {
                    this.isJ.Te("contact_info_social");
                }
            }
            this.isJ.Te("contact_info_more");
        }
        if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            this.isJ.Te("contact_info_source");
        } else {
            i2 = this.fPi.getIntent().getIntExtra("Contact_Source_FMessage", 0);
            w.d("MicroMsg.ContactWidgetNormal", "initFriendSource, contact source = " + this.jiL.getSource() + ", sourceFMessage = " + i2);
            if (i2 != 0) {
                keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_source");
                if (this.osN) {
                    switch (i2) {
                        case 1:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.eab);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 3:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.ead);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 4:
                        case 12:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.ekX));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 8:
                        case 14:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                stringExtra = null;
                                com.tencent.mm.av.f la = l.Kx().la(this.jiL.field_username);
                                com.tencent.mm.u.ap.yY();
                                com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(la.field_chatroomName);
                                if (Rc != null) {
                                    stringExtra = Rc.field_nickname;
                                }
                                if (bg.mA(stringExtra)) {
                                    keyValuePreference.setSummary(R.l.dZQ);
                                } else {
                                    keyValuePreference.setSummary(this.fPi.getString(R.l.dZR, new Object[]{stringExtra}));
                                }
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 10:
                        case 13:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.eah);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 15:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZZ);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 17:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                stringExtra = n.eK(this.fPi.getIntent().getStringExtra("source_from_user_name"));
                                if (bg.mA(stringExtra)) {
                                    stringExtra = this.fPi.getIntent().getStringExtra("source_from_nick_name");
                                }
                                if (bg.mA(stringExtra)) {
                                    keyValuePreference.setSummary(R.l.dZO);
                                } else {
                                    keyValuePreference.setSummary(h.a(this.fPi, this.fPi.getString(R.l.dZN, new Object[]{stringExtra})));
                                }
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZT);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 25:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZL);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZW);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 48:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.dZX));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        case bc.CTRL_INDEX /*59*/:
                        case 60:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.epO));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        default:
                            this.isJ.c(keyValuePreference);
                            break;
                    }
                } else if (keyValuePreference != null) {
                    if (i2 == 10) {
                        keyValuePreference.vrl = false;
                        keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                        keyValuePreference.setSummary(this.fPi.getString(R.l.ekW));
                        keyValuePreference.kZ(false);
                    } else {
                        this.isJ.c(keyValuePreference);
                    }
                }
            } else {
                keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_source");
                if (this.osN) {
                    switch (this.jiL.getSource()) {
                        case 18:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZT);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 22:
                        case 23:
                        case 24:
                        case 26:
                        case 27:
                        case 28:
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.eaf);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 30:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(R.l.dZW);
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 34:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.dZJ));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 48:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.dZX));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                        case bc.CTRL_INDEX /*59*/:
                        case 60:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.epO));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        case 76:
                            if (keyValuePreference != null) {
                                keyValuePreference.vrl = false;
                                keyValuePreference.setTitle(this.fPi.getString(R.l.eai));
                                keyValuePreference.setSummary(this.fPi.getString(R.l.dZU));
                                keyValuePreference.kZ(false);
                                break;
                            }
                            break;
                        default:
                            this.isJ.c(keyValuePreference);
                            break;
                    }
                }
                this.isJ.c(keyValuePreference);
            }
        }
        this.isJ.aV("contact_info_invite_source", true);
        boolean booleanExtra = this.fPi.getIntent().getBooleanExtra("Is_RoomOwner", false);
        if (this.osO != 14 || !booleanExtra || this.ktr == null || this.jiL.field_username.equals(this.ktr.field_roomowner)) {
            stringExtra = "MicroMsg.ContactWidgetNormal";
            ap = "[initInviteSource] addContactScene:%s isOwner:%s null == member:%s";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(this.osO);
            objArr2[1] = Boolean.valueOf(booleanExtra);
            objArr2[2] = Boolean.valueOf(this.ktr == null);
            w.i(stringExtra, ap, objArr2);
            this.isJ.aV("contact_info_invite_source", true);
        } else {
            this.fDY = this.fPi.getIntent().getStringExtra("inviteer");
            if (bg.mA(this.fDY)) {
                com.tencent.mm.g.a.a.b QI = this.ktr.QI(this.jiL.field_username);
                this.fDY = QI == null ? "" : bg.ap(QI.gMZ, "");
            }
            if (bg.mA(this.fDY)) {
                this.fDY = j.C(this.jiL.field_username, this.kuC);
            }
            if (bg.mA(this.fDY)) {
                w.w("MicroMsg.ContactWidgetNormal", "mRoomId:%s member:%s , inviteer is null!", new Object[]{this.kuC, this.jiL.field_username});
                this.ouK.bIy();
                ag.a.hlS.a(this.jiL.field_username, this.kuC, new ag.b.a(this) {
                    final /* synthetic */ k ouL;

                    {
                        this.ouL = r1;
                    }

                    public final void p(String str, boolean z) {
                        w.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.ouL.kuC, Boolean.valueOf(z)});
                        this.ouL.ouK.dead();
                    }
                });
            } else {
                this.fPi.getIntent().putExtra("inviteer", this.fDY);
                String eK = eK(this.fDY);
                if (bg.mA(eK)) {
                    ag.a.hlS.a(this.jiL.field_username, "", new ag.b.a(this) {
                        final /* synthetic */ k ouL;

                        {
                            this.ouL = r1;
                        }

                        public final void p(String str, boolean z) {
                            w.i("MicroMsg.ContactWidgetNormal", "username:%s mRoomId:%s succ:%s", new Object[]{str, this.ouL.kuC, Boolean.valueOf(z)});
                            if (z) {
                                com.tencent.mm.u.ap.yY();
                                this.ouL.dd(this.ouL.fDY, com.tencent.mm.u.c.wR().Rc(str).tK());
                            }
                        }
                    });
                } else {
                    dd(this.fDY, eK);
                }
            }
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
        boolean booleanExtra2 = this.fPi.getIntent().getBooleanExtra("User_From_Fmessage", false);
        boolean booleanExtra3 = this.fPi.getIntent().getBooleanExtra("Contact_FMessageCard", false);
        this.fPi.getIntent().getBooleanExtra("Contact_KHideExpose", false);
        long longExtra4 = this.fPi.getIntent().getLongExtra("Contact_Uin", -1);
        if (this.osO == 30) {
            this.ouy = false;
        }
        if (normalUserFooterPreference == null || !normalUserFooterPreference.a(this.jiL, this.osP, this.osM, this.osN, this.ouy, this.osO, this.ouq, booleanExtra3, booleanExtra2, longExtra4, this.ouz)) {
            this.isJ.Te("contact_info_footer_normal");
        } else {
            normalUserFooterPreference.hrc.removeAll();
            normalUserFooterPreference.hrc.a(new NormalUserFooterPreference.e(this) {
                final /* synthetic */ k ouL;

                public final void ae(String str, boolean z) {
                    normalUserHeaderPreference.aM(str, z);
                    normalUserHeaderPreference.ho(this.ouL.jiL.field_username);
                }
            }, Looper.getMainLooper());
        }
        i2 = this.jiL.gkE;
        this.isJ.Te("clear_lbs_info");
        if (this.ouF) {
            this.isJ.removeAll();
            if (normalUserHeaderPreference != null) {
                this.isJ.a(normalUserHeaderPreference);
            }
            if (normalUserFooterPreference != null) {
                this.isJ.a(normalUserFooterPreference);
            }
        }
        com.tencent.mm.u.ap.yY();
        com.tencent.mm.u.c.wR().QY(xVar.field_username);
        boolean equals = com.tencent.mm.u.m.xL().equals(xVar.field_username);
        w.v("MicroMsg.ContactWidgetNormal", "get from extinfo %s", new Object[]{Integer.valueOf(this.oux.hAO)});
        Object obj2 = (this.oux.hAO & 1) > 0 ? 1 : null;
        if (!(xVar.tA() || x.QN(xVar.field_username) || obj2 == null || m.pQF == null)) {
            m.pQF.a(2, xVar.field_username, equals, this.fJn);
        }
        return true;
    }

    public final void dd(String str, String str2) {
        w.i("MicroMsg.ContactWidgetNormal", "[showInviteerView] inviteer:%s inviteerDisplayName:%s", new Object[]{str, str2});
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.isJ.Td("contact_info_invite_source");
        TextPreference textPreference = (TextPreference) this.isJ.Td("contact_info_hint");
        this.isJ.aV("contact_info_invite_source", false);
        CharSequence spannableString = new SpannableString(h.a(this.fPi, this.fPi.getResources().getString(R.l.dYr, new Object[]{str2})));
        spannableString.setSpan(new ForegroundColorSpan(this.fPi.getResources().getColor(R.e.aUd)), 0, str2.length(), 33);
        keyValuePreference.setSummary(spannableString);
        keyValuePreference.getExtras().putString("inviteer", str);
        this.fPi.getIntent().putExtra("inviteer", str);
        if (this.ktr == null || this.ktr.DU().contains(this.jiL.field_username)) {
            this.isJ.aV("contact_info_footer_normal", false);
            return;
        }
        this.isJ.aV("contact_info_footer_normal", true);
        textPreference.O(h.a(this.fPi, this.fPi.getResources().getString(R.l.dYW, new Object[]{eK(this.jiL.field_username)})));
    }

    public final String eK(String str) {
        String str2 = null;
        if (this.ktr == null) {
            return null;
        }
        com.tencent.mm.u.ap.yY();
        com.tencent.mm.e.b.af Rc = com.tencent.mm.u.c.wR().Rc(str);
        if (Rc != null && ((int) Rc.gTQ) > 0) {
            str2 = Rc.field_conRemark;
        }
        if (bg.mA(str2)) {
            str2 = this.ktr.eK(str);
        }
        if (!bg.mA(str2) || Rc == null) {
            return str2;
        }
        return Rc.tK();
    }

    public final boolean adI() {
        if (m.pQF != null) {
            m.pQF.a(this, 3);
        }
        com.tencent.mm.u.ap.vd().b(30, this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.isJ.Td("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
        if (normalUserFooterPreference != null) {
            normalUserFooterPreference.adI();
        }
        FriendPreference friendPreference = (FriendPreference) this.isJ.Td("contact_info_friend_qq");
        if (friendPreference != null) {
            friendPreference.adI();
        }
        friendPreference = (FriendPreference) this.isJ.Td("contact_info_friend_mobile");
        if (friendPreference != null) {
            friendPreference.adI();
        }
        friendPreference = (FriendPreference) this.isJ.Td("contact_info_facebook");
        if (friendPreference != null) {
            friendPreference.adI();
        }
        this.isJ.Td("contact_info_sns");
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 == -1 && intent != null) {
                    String stringExtra = intent.getStringExtra("be_send_card_name");
                    String stringExtra2 = intent.getStringExtra("received_card_name");
                    boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                    String stringExtra3 = intent.getStringExtra("custom_send_text");
                    com.tencent.mm.plugin.messenger.a.d.aJW().k(stringExtra, stringExtra2, booleanExtra);
                    com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra3, stringExtra2);
                    com.tencent.mm.ui.snackbar.a.e(this.fPi, this.fPi.getString(R.l.ekV));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if (kVar.getType() != 30 && kVar.getType() != 458) {
            w.w("MicroMsg.ContactWidgetNormal", "not expected scene,  type = " + kVar.getType());
        } else if (i == 0 && i2 == 0) {
            if (kVar.getType() == 30) {
                com.tencent.mm.pluginsdk.model.n nVar = (com.tencent.mm.pluginsdk.model.n) kVar;
                if (nVar.fJK != 1 && nVar.fJK != 3) {
                    return;
                }
                if (nVar.sCv == null || nVar.sCv.contains(this.jiL.field_username)) {
                    NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.isJ.Td("contact_info_header_normal");
                    NormalUserFooterPreference normalUserFooterPreference = (NormalUserFooterPreference) this.isJ.Td("contact_info_footer_normal");
                    if (normalUserHeaderPreference != null && normalUserFooterPreference != null && normalUserFooterPreference.ovI) {
                        w.d("MicroMsg.ContactWidgetNormal", "happy update remark change");
                        this.ouB = false;
                        this.ouC = false;
                        normalUserHeaderPreference.aM(this.jiL.field_username, false);
                        normalUserHeaderPreference.aN(this.jiL.field_username, false);
                        normalUserHeaderPreference.ho(this.jiL.field_username);
                        this.fPi.getIntent().putExtra("Contact_NeedShowChangeRemarkButton", this.ouB);
                        this.fPi.getIntent().putExtra("Contact_NeedShowChangeSnsPreButton", this.ouC);
                    }
                }
            }
        } else if (i == 4 && i2 == -24 && !bg.mA(str)) {
            Toast.makeText(this.fPi, str, 1).show();
        }
    }

    public final void a(boolean z, boolean z2, String str, boolean z3, boolean z4, int i, long j) {
        g gVar = (g) this.isJ.Td("contact_info_sns");
        if (!(gVar == null || m.pQB == null)) {
            gVar.Nf(this.jiL.field_username);
        }
        this.oux = m.pQB.b(this.jiL.field_username, this.oux);
        this.isJ.notifyDataSetChanged();
        if (z3) {
            w.d("MicroMsg.ContactWidgetNormal", "bg Change!");
            if (m.pQF != null) {
                m.pQF.EA(this.jiL.field_username);
            }
        }
    }

    public final void a(boolean z, String str, boolean z2, boolean z3, int i, long j) {
    }
}
