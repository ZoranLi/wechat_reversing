package com.tencent.mm.plugin.sport.ui.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.exdevice.ui.ExdeviceRankDataSourceUI;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class a implements com.tencent.mm.pluginsdk.d.a, e {
    public Context context;
    private f isJ;
    public x jiL;
    private p jiM;
    private CheckBoxPreference qRQ;
    private CheckBoxPreference qRR;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        this.isJ = fVar;
        this.jiL = xVar;
        fVar.addPreferencesFromResource(R.o.ftD);
        this.qRQ = (CheckBoxPreference) fVar.Td("contact_info_top_sport");
        this.qRR = (CheckBoxPreference) fVar.Td("contact_info_not_disturb");
        adH();
        return true;
    }

    public final boolean adI() {
        return true;
    }

    public final boolean sa(String str) {
        if ("contact_info_record_data".equals(str)) {
            this.context.startActivity(new Intent(this.context, ExdeviceRankDataSourceUI.class));
        } else if ("contact_info_top_sport".equals(str)) {
            if (this.qRQ.isChecked()) {
                d.mN(20);
                o.l(this.jiL.field_username, true);
            } else {
                d.mN(21);
                o.m(this.jiL.field_username, true);
            }
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.qRR.isChecked()) {
                d.mN(22);
                o.n(this.jiL);
            } else {
                d.mN(23);
                o.o(this.jiL);
            }
        } else if ("contact_info_go_to_sport".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.jiL.field_username);
            r0.putExtra("finish_direct", true);
            com.tencent.mm.bb.d.a(this.context, ".ui.chatting.En_5b8fbb1e", r0);
            d.mN(19);
        } else if ("contact_info_go_to_my_profile".equals(str)) {
            String xL = m.xL();
            if (bg.mA(xL)) {
                w.e("MicroMsg.Sport.ContactWidgetSport", "Get username from UserInfo return null or nil.");
            } else {
                Intent intent = new Intent();
                intent.putExtra("username", xL);
                com.tencent.mm.bb.d.b(this.context, "exdevice", ".ui.ExdeviceProfileUI", intent);
                d.mN(3);
            }
        } else if ("contact_info_invite_friend".equals(str)) {
            r0 = new Intent();
            r0.putExtra("Select_Talker_Name", this.jiL.field_username);
            r0.putExtra("Select_block_List", this.jiL.field_username);
            r0.putExtra("Select_Conv_Type", 3);
            r0.putExtra("Select_Send_Card", true);
            r0.putExtra("mutil_select_is_ret", true);
            com.tencent.mm.bb.d.a(this.context, ".ui.transmit.SelectConversationUI", r0, 1);
            d.mN(4);
        } else if ("contact_info_common_problem".equals(str)) {
            r0 = new Intent();
            r0.putExtra("KPublisherId", "custom_menu");
            r0.putExtra("pre_username", this.jiL.field_username);
            r0.putExtra("prePublishId", "custom_menu");
            r0.putExtra("preUsername", this.jiL.field_username);
            r0.putExtra("preChatName", this.jiL.field_username);
            r0.putExtra("preChatTYPE", com.tencent.mm.u.p.G(this.jiL.field_username, this.jiL.field_username));
            r0.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            r0.putExtra("geta8key_username", this.jiL.field_username);
            r0.putExtra("from_scence", 1);
            com.tencent.mm.bb.d.b(this.context, "webview", ".ui.tools.WebViewUI", r0);
            d.mN(5);
        } else if ("contact_info_privacy_and_notification".equals(str)) {
            com.tencent.mm.bb.d.w(this.context, "exdevice", ".ui.ExdeviceSettingUI");
        } else if ("contact_info_sport_install".equals(str)) {
            d.mN(13);
            Context context = this.context;
            this.context.getString(R.l.dIO);
            this.jiM = g.a(context, this.context.getString(R.l.eTE), true, null);
            this.jiM.show();
            ap.vd().a(30, this);
            List linkedList = new LinkedList();
            linkedList.add("gh_43f2581f6fd6");
            List linkedList2 = new LinkedList();
            linkedList2.add(Integer.valueOf(1));
            ap.vd().a(new n(1, linkedList, linkedList2, "", ""), 0);
        } else if ("contact_info_sport_uninstall".equals(str)) {
            d.mN(14);
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a qRS;

                {
                    this.qRS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ((com.tencent.mm.pluginsdk.f) h.h(com.tencent.mm.pluginsdk.f.class)).a(com.tencent.mm.modelbiz.e.hW(this.qRS.jiL.field_username), (Activity) this.qRS.context, this.qRS.jiL);
                    this.qRS.adH();
                }
            }, null);
        } else if ("contact_info_clear_data".equals(str)) {
            g.a(this.context, this.context.getString(R.l.dXP), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ a qRS;

                {
                    this.qRS = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    d.mN(25);
                    ap.yY();
                    c.wT().Ao("gh_43f2581f6fd6");
                }
            }, null);
        }
        return false;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (intent != null) {
                        List<String> f = bg.f(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra = intent.getStringExtra("custom_send_text");
                        for (String str : f) {
                            com.tencent.mm.plugin.messenger.a.d.aJW().k("gh_43f2581f6fd6", str, o.dH(str));
                            if (!bg.mA(stringExtra)) {
                                b nvVar = new nv();
                                nvVar.fVa.fVb = str;
                                nvVar.fVa.content = stringExtra;
                                nvVar.fVa.type = o.fG(str);
                                nvVar.fVa.flags = 0;
                                com.tencent.mm.sdk.b.a.urY.m(nvVar);
                            }
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final void adH() {
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.eaj));
        if (com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            helperHeaderPreference.kg(1);
            this.isJ.aV("contact_info_sport_install", true);
            this.isJ.aV("contact_info_sport_uninstall", false);
            this.isJ.aV("contact_info_go_to_sport", false);
            this.isJ.aV("contact_info_go_to_my_profile", false);
            this.isJ.aV("contact_info_invite_friend", false);
            this.isJ.aV("contact_info_common_problem", false);
            this.isJ.aV("contact_info_record_data", false);
            this.isJ.aV("contact_info_privacy_and_notification", false);
            this.isJ.aV("contact_info_top_sport", false);
            this.isJ.aV("contact_info_not_disturb", false);
            ap.yY();
            if (c.wW().Rt(this.jiL.field_username)) {
                this.qRQ.vqm = true;
            } else {
                this.qRQ.vqm = false;
            }
            if (this.jiL.tD()) {
                this.qRR.vqm = true;
                return;
            } else {
                this.qRR.vqm = false;
                return;
            }
        }
        helperHeaderPreference.kg(0);
        this.isJ.aV("contact_info_sport_install", false);
        this.isJ.aV("contact_info_sport_uninstall", true);
        this.isJ.aV("contact_info_go_to_sport", true);
        this.isJ.aV("contact_info_go_to_my_profile", true);
        this.isJ.aV("contact_info_invite_friend", true);
        this.isJ.aV("contact_info_common_problem", true);
        this.isJ.aV("contact_info_record_data", true);
        this.isJ.aV("contact_info_privacy_and_notification", true);
        this.isJ.aV("contact_info_top_sport", true);
        this.isJ.aV("contact_info_not_disturb", true);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof n) {
            ap.vd().b(30, this);
            if (i == 0 && i2 == 0) {
                String bCI = ((n) kVar).bCI();
                w.i("MicroMsg.Sport.ContactWidgetSport", "bind fitness contact %s success", new Object[]{bCI});
                ap.yY();
                af Rc = c.wR().Rc("gh_43f2581f6fd6");
                if (Rc == null || bg.mA(bCI)) {
                    w.e("MicroMsg.Sport.ContactWidgetSport", "respUsername == " + bCI + ", contact = " + Rc);
                } else {
                    BizInfo bizInfo = null;
                    if (o.eT(Rc.field_username)) {
                        String mz = bg.mz(Rc.field_username);
                        bizInfo = com.tencent.mm.modelbiz.e.hW(mz);
                        if (bizInfo != null) {
                            bizInfo.field_username = bCI;
                        }
                        com.tencent.mm.modelbiz.w.DH().hP(mz);
                        Rc.bX(mz);
                    }
                    Rc.setUsername(bCI);
                    if (((int) Rc.gTQ) == 0) {
                        ap.yY();
                        c.wR().S(Rc);
                    }
                    if (((int) Rc.gTQ) <= 0) {
                        w.e("MicroMsg.Sport.ContactWidgetSport", "addContact : insert contact failed");
                    } else {
                        o.p(Rc);
                        ap.yY();
                        af Rc2 = c.wR().Rc(Rc.field_username);
                        if (bizInfo != null) {
                            com.tencent.mm.modelbiz.w.DH().d(bizInfo);
                        } else {
                            bizInfo = com.tencent.mm.modelbiz.e.hW(Rc2.field_username);
                            if (bizInfo == null || bizInfo.CB()) {
                                w.d("MicroMsg.Sport.ContactWidgetSport", "shouldUpdate");
                                com.tencent.mm.u.ag.a.hlS.J(Rc2.field_username, "");
                                com.tencent.mm.x.b.he(Rc2.field_username);
                            } else if (Rc2.bLh()) {
                                w.d("MicroMsg.Sport.ContactWidgetSport", "update contact, last check time=%d", new Object[]{Integer.valueOf(Rc2.gkI)});
                                com.tencent.mm.u.ag.a.hlS.J(Rc2.field_username, "");
                                com.tencent.mm.x.b.he(Rc2.field_username);
                            }
                        }
                    }
                }
                com.tencent.mm.modelbiz.w.DH().e(com.tencent.mm.modelbiz.w.DH().hO(Rc.field_username));
                ap.yY();
                c.vr().set(327825, Boolean.valueOf(true));
            } else {
                w.e("MicroMsg.Sport.ContactWidgetSport", "errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 4 && i2 == -24 && !bg.mA(str)) {
                    Toast.makeText(ab.getContext(), str, 1).show();
                }
            }
            if (this.jiM != null) {
                this.jiM.dismiss();
            }
            adH();
        }
    }
}
