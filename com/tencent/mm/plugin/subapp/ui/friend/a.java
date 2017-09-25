package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.av.b;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class a implements OnItemClickListener {
    private Context context;
    private boolean hsq = false;
    private b qTB;

    public a(Context context, b bVar, boolean z) {
        this.context = context;
        this.qTB = bVar;
        this.hsq = z;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.hsq) {
            i--;
        }
        b bVar = (b) this.qTB.getItem(i);
        if (bVar == null) {
            w.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, item is null, pos = " + i);
        } else {
            g(this.context, bVar.field_talker, false);
        }
    }

    public static void g(Context context, String str, boolean z) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.FConversationOnItemClickListener", "dealOnClick fail, talker is null");
            return;
        }
        w.d("MicroMsg.FConversationOnItemClickListener", "dealOnClick, talker = " + str);
        l.Ky().kW(str);
        f lb = l.Kx().lb(str);
        if (lb == null) {
            w.e("MicroMsg.FConversationOnItemClickListener", "onItemClick, lastRecvFmsg is null, talker = " + str);
        } else if (lb.field_type == 0) {
            ap.yY();
            com.tencent.mm.storage.au.a Av = c.wT().Av(lb.field_msgContent);
            if (Av != null && Av.rUK.length() > 0) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("Contact_ShowFMessageList", true);
                bundle.putInt("Contact_Source_FMessage", Av.scene);
                ap.yY();
                af Rc = c.wR().Rc(Av.rUK);
                if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                    com.tencent.mm.plugin.subapp.b.imw.a(context, Rc, Av, bundle, "");
                } else if (Av.ovb > 0) {
                    if (bg.mA(Av.hCj) && bg.mA(Av.hCg) && !bg.mA(Av.fFa)) {
                        bundle.putString("Contact_QQNick", Av.fFa);
                    }
                    com.tencent.mm.plugin.subapp.b.imw.a(context, Av, bundle);
                } else if (bg.mA(Av.uJX) && bg.mA(Av.uJY)) {
                    com.tencent.mm.plugin.subapp.b.imw.a(context, Av, bundle);
                } else {
                    com.tencent.mm.modelfriend.b ja = com.tencent.mm.modelfriend.af.FY().ja(Av.uJX);
                    if (ja == null || ja.EP() == null || ja.EP().length() <= 0) {
                        ja = com.tencent.mm.modelfriend.af.FY().ja(Av.uJY);
                        if (ja == null || ja.EP() == null || ja.EP().length() <= 0) {
                            if (Rc == null || ((int) Rc.gTQ) <= 0) {
                                com.tencent.mm.plugin.subapp.b.imw.a(context, Av, bundle);
                            } else {
                                com.tencent.mm.plugin.subapp.b.imw.a(context, Rc, Av, bundle, "");
                            }
                            w.e("MicroMsg.FConversationOnItemClickListener", "error : this is not the mobile contact, MD5 = " + Av.uJX + " fullMD5:" + Av.uJY);
                            return;
                        }
                    }
                    if (ja.getUsername() == null || ja.getUsername().length() <= 0) {
                        ja.username = Av.rUK;
                        ja.fRW = FileUtils.S_IWUSR;
                        if (com.tencent.mm.modelfriend.af.FY().a(ja.EP(), ja) == -1) {
                            w.e("MicroMsg.FConversationOnItemClickListener", "update mobile contact username failed");
                            return;
                        }
                    }
                    com.tencent.mm.plugin.subapp.b.imw.a(context, Av, bundle);
                }
            }
        } else {
            a(context, lb, z);
        }
    }

    public static void a(Context context, f fVar, boolean z) {
        String str = fVar.field_msgContent;
        w.w("MicroMsg.FConversationOnItemClickListener", "dealClickVerifyMsgEvent : " + str);
        if (str != null && str.length() > 0) {
            ap.yY();
            d Au = c.wT().Au(str);
            if (Au != null && !bg.mA(Au.rUK)) {
                Assert.assertTrue(Au.rUK.length() > 0);
                ap.yY();
                af Rc = c.wR().Rc(Au.rUK);
                Intent intent = new Intent();
                if (z) {
                    intent.putExtra("Accept_NewFriend_FromOutside", true);
                }
                intent.putExtra("Contact_ShowUserName", false);
                intent.putExtra("Contact_ShowFMessageList", true);
                intent.putExtra("Contact_Scene", Au.scene);
                intent.putExtra("Verify_ticket", Au.osP);
                intent.putExtra("Contact_Source_FMessage", Au.scene);
                if (Rc == null || ((int) Rc.gTQ) <= 0 || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                    if (fVar.field_type == 1 || fVar.field_type == 2) {
                        intent.putExtra("User_Verify", true);
                    }
                    intent.putExtra("Contact_User", Au.rUK);
                    intent.putExtra("Contact_Alias", Au.gtR);
                    intent.putExtra("Contact_Nick", Au.fFa);
                    intent.putExtra("Contact_QuanPin", Au.hCf);
                    intent.putExtra("Contact_PyInitial", Au.hCe);
                    intent.putExtra("Contact_Sex", Au.gkr);
                    intent.putExtra("Contact_Signature", Au.signature);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", Au.getCity());
                    intent.putExtra("Contact_Province", Au.getProvince());
                    intent.putExtra("Contact_Mobile_MD5", Au.uJX);
                    intent.putExtra("Contact_full_Mobile_MD5", Au.uJY);
                    intent.putExtra("Contact_KSnsBgUrl", Au.uKi);
                } else {
                    intent.putExtra("Contact_User", Rc.field_username);
                    com.tencent.mm.plugin.subapp.b.imw.a(intent, Rc.field_username);
                }
                str = Au.content;
                if (bg.mz(str).length() <= 0) {
                    switch (Au.scene) {
                        case 18:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case JsApiChooseImage.CTRL_INDEX /*29*/:
                            str = context.getString(R.l.dTI);
                            break;
                        default:
                            str = context.getString(R.l.dTE);
                            break;
                    }
                }
                intent.putExtra("Contact_Content", str);
                if (Au.uKk == 1 && !bg.mA(Au.uKm)) {
                    intent.putExtra("Safety_Warning_Detail", Au.uKm);
                }
                intent.putExtra("Contact_verify_Scene", Au.scene);
                if ((Au.scene == 14 || Au.scene == 8) && !bg.mA(Au.chatroomName)) {
                    ap.yY();
                    q fV = c.xa().fV(Au.chatroomName);
                    if (fV != null) {
                        intent.putExtra("Contact_RoomNickname", fV.eK(Au.rUK));
                    }
                }
                intent.putExtra("Contact_Uin", Au.ovb);
                intent.putExtra("Contact_QQNick", Au.hCg);
                intent.putExtra("Contact_Mobile_MD5", Au.uJX);
                intent.putExtra("User_From_Fmessage", true);
                intent.putExtra("Contact_from_msgType", 37);
                if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                    intent.putExtra("Contact_KSnsIFlag", 0);
                }
                intent.putExtra("Contact_KSnsBgUrl", Au.uKi);
                intent.putExtra("verify_gmail", Au.ovd);
                intent.putExtra("source_from_user_name", Au.sLS);
                intent.putExtra("source_from_nick_name", Au.sLT);
                com.tencent.mm.bb.d.b(context, "profile", ".ui.ContactInfoUI", intent);
            }
        }
    }
}
