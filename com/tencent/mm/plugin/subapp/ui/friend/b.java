package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.av.l;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k;
import java.util.LinkedList;

public final class b extends k<com.tencent.mm.av.b> {
    private Context context;
    private OnClickListener qTC = new OnClickListener(this) {
        final /* synthetic */ b qTE;

        {
            this.qTE = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                w.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
                final com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                if (bVar == null || bg.mA(bVar.username)) {
                    w.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                    return;
                }
                final f lb = l.Kx().lb(bVar.username);
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.qTE.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass2 qTH;

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        if (z) {
                            ap.yY();
                            x Rc = c.wR().Rc(bVar.username);
                            if (((int) Rc.gTQ) == 0) {
                                Rc = com.tencent.mm.pluginsdk.ui.preference.b.b(lb);
                                ap.yY();
                                if (!c.wR().R(Rc)) {
                                    w.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    return;
                                }
                            }
                            o.p(Rc);
                            l.Ky().D(bVar.username, 1);
                            g.bl(this.qTH.qTE.context, this.qTH.qTE.context.getString(R.l.dDk));
                            b.a(this.qTH.qTE, bVar.username);
                        } else if (z2) {
                            l.Ky().D(bVar.username, 2);
                        } else {
                            w.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + bVar.username);
                            return;
                        }
                        this.qTH.qTE.notifyDataSetChanged();
                    }
                });
                w.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(bVar.prC));
                aVar.b(bVar.username, linkedList, true);
            }
        }
    };
    private OnClickListener qTD = new OnClickListener(this) {
        final /* synthetic */ b qTE;

        {
            this.qTE = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                w.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                final f lb = l.Kx().lb(bVar.username);
                if (lb == null || lb.field_msgContent == null) {
                    w.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar.username);
                    return;
                }
                d RI = d.RI(lb.field_msgContent);
                w.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (RI.uKk == 1) {
                    g.a(this.qTE.context, RI.uKl, null, this.qTE.context.getString(R.l.ela), this.qTE.context.getString(R.l.dGs), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 qTI;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.a(this.qTI.qTE.context, lb, false);
                        }
                    }, null);
                    return;
                }
                ap.yY();
                bb AI = c.wS().AI(bVar.username);
                Intent intent = new Intent();
                intent.putExtra("Contact_User", bVar.username);
                intent.putExtra("Contact_Nick", bVar.fFa);
                if (AI != null) {
                    intent.putExtra("Contact_RemarkName", AI.field_conRemark);
                }
                if (!bg.mA(RI.chatroomName)) {
                    ap.yY();
                    q fV = c.xa().fV(RI.chatroomName);
                    if (fV != null) {
                        intent.putExtra("Contact_RoomNickname", fV.eK(RI.rUK));
                    }
                }
                intent.putExtra("Contact_Scene", RI.scene);
                intent.putExtra("Verify_ticket", RI.osP);
                intent.putExtra("sayhi_with_sns_perm_send_verify", false);
                intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                intent.putExtra("sayhi_with_sns_perm_set_label", true);
                intent.putExtra("sayhi_with_jump_to_profile", true);
                com.tencent.mm.bb.d.b(this.qTE.context, "profile", ".ui.SayHiWithSnsPermissionUI", intent);
            }
        }
    };

    static class a {
        public TextView ovh;
        public MaskLayout qTJ;
        public Button qTK;
        public Button qTL;
        public TextView qTM;
        public TextView qTN;
        public TextView qTO;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.av.b) obj;
        if (obj == null) {
            obj = new com.tencent.mm.av.b();
        }
        obj.b(cursor);
        return obj;
    }

    static /* synthetic */ void a(b bVar, final String str) {
        if (bVar.context instanceof FMessageConversationUI) {
            af.f(new Runnable(bVar) {
                final /* synthetic */ b qTE;

                public final void run() {
                    a.g(this.qTE.context, str, false);
                }
            }, 200);
        }
    }

    public b(Context context) {
        super(context, new com.tencent.mm.av.b());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, R.i.ddl, null);
            a aVar2 = new a();
            aVar2.qTJ = (MaskLayout) view.findViewById(R.h.bQr);
            aVar2.ovh = (TextView) view.findViewById(R.h.bQu);
            aVar2.qTO = (TextView) view.findViewById(R.h.bQs);
            aVar2.qTK = (Button) view.findViewById(R.h.bQo);
            aVar2.qTK.setOnClickListener(this.qTC);
            aVar2.qTL = (Button) view.findViewById(R.h.bQx);
            aVar2.qTL.setOnClickListener(this.qTD);
            aVar2.qTM = (TextView) view.findViewById(R.h.bQv);
            aVar2.qTN = (TextView) view.findViewById(R.h.bQq);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.av.b bVar = (com.tencent.mm.av.b) getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) aVar.qTJ.view, bVar.field_talker);
        aVar.ovh.setText(h.b(this.context, bVar.field_displayName, aVar.ovh.getTextSize()));
        com.tencent.mm.pluginsdk.ui.preference.b a;
        com.tencent.mm.e.b.af Rc;
        f lb;
        int i2;
        View findViewById;
        int i3;
        if (bVar.field_fmsgSysRowId <= 0) {
            w.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            f la = l.Kx().la(bVar.field_talker);
            if (la == null) {
                w.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + bVar.field_talker);
                aVar.qTK.setVisibility(8);
                aVar.qTL.setVisibility(8);
                aVar.qTM.setVisibility(8);
                aVar.qTN.setVisibility(8);
                aVar.qTO.setVisibility(8);
            } else {
                a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, la);
                w.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + bVar.field_talker);
                if (bVar.field_state == 1) {
                    ap.yY();
                    Rc = c.wR().Rc(bVar.field_talker);
                    if (!(Rc == null || ((int) Rc.gTQ) == 0 || com.tencent.mm.j.a.ez(Rc.field_type))) {
                        l.Ky().D(bVar.field_talker, 0);
                    }
                }
                if (a != null) {
                    w.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                    aVar.qTK.setVisibility(8);
                    aVar.qTL.setVisibility(8);
                    aVar.qTM.setVisibility(8);
                    aVar.qTN.setVisibility(8);
                    aVar.qTO.setVisibility(8);
                } else {
                    a.prC = bVar.field_addScene;
                    aVar.qTO.setText(h.b(this.context, a.hku, aVar.qTO.getTextSize()));
                    switch (bVar.field_state) {
                        case 0:
                            if (bVar.field_fmsgSysRowId > 0) {
                                w.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                lb = l.Kx().lb(a.username);
                                i2 = lb != null ? 0 : lb.field_type;
                            } else {
                                i2 = bVar.field_recvFmsgType;
                            }
                            if (i2 != 0 || i2 == 3) {
                                aVar.qTK.setVisibility(0);
                                aVar.qTK.setTag(a);
                                aVar.qTL.setVisibility(8);
                            } else {
                                aVar.qTL.setVisibility(0);
                                aVar.qTL.setTag(a);
                                aVar.qTK.setVisibility(8);
                            }
                            aVar.qTM.setVisibility(8);
                            aVar.qTN.setVisibility(8);
                            break;
                        case 1:
                            aVar.qTN.setVisibility(0);
                            aVar.qTK.setVisibility(8);
                            aVar.qTL.setVisibility(8);
                            aVar.qTM.setVisibility(8);
                            break;
                        case 2:
                            aVar.qTM.setVisibility(0);
                            aVar.qTK.setVisibility(8);
                            aVar.qTL.setVisibility(8);
                            aVar.qTN.setVisibility(8);
                            break;
                        default:
                            aVar.qTK.setVisibility(8);
                            aVar.qTL.setVisibility(8);
                            aVar.qTM.setVisibility(8);
                            aVar.qTN.setVisibility(8);
                            break;
                    }
                    findViewById = view.findViewById(R.h.bQt);
                    if (bVar.field_isNew != 0) {
                        i3 = R.g.bgZ;
                    } else {
                        i3 = R.g.ben;
                    }
                    findViewById.setBackgroundResource(i3);
                }
            }
        } else {
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, bVar.field_fmsgSysRowId, bVar.field_fmsgIsSend % 2 == 0, bVar.field_talker, bVar.field_fmsgContent, bVar.field_fmsgType, bVar.field_contentFromUsername, bVar.field_contentNickname, bVar.field_contentPhoneNumMD5, bVar.field_contentFullPhoneNumMD5, bVar.field_contentVerifyContent, bVar.field_addScene);
            w.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + bVar.field_fmsgSysRowId + ", talker = " + bVar.field_talker);
            if (bVar.field_state == 1) {
                ap.yY();
                Rc = c.wR().Rc(bVar.field_talker);
                l.Ky().D(bVar.field_talker, 0);
            }
            if (a != null) {
                a.prC = bVar.field_addScene;
                aVar.qTO.setText(h.b(this.context, a.hku, aVar.qTO.getTextSize()));
                switch (bVar.field_state) {
                    case 0:
                        if (bVar.field_fmsgSysRowId > 0) {
                            i2 = bVar.field_recvFmsgType;
                        } else {
                            w.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                            lb = l.Kx().lb(a.username);
                            if (lb != null) {
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                        aVar.qTK.setVisibility(0);
                        aVar.qTK.setTag(a);
                        aVar.qTL.setVisibility(8);
                        aVar.qTM.setVisibility(8);
                        aVar.qTN.setVisibility(8);
                        break;
                    case 1:
                        aVar.qTN.setVisibility(0);
                        aVar.qTK.setVisibility(8);
                        aVar.qTL.setVisibility(8);
                        aVar.qTM.setVisibility(8);
                        break;
                    case 2:
                        aVar.qTM.setVisibility(0);
                        aVar.qTK.setVisibility(8);
                        aVar.qTL.setVisibility(8);
                        aVar.qTN.setVisibility(8);
                        break;
                    default:
                        aVar.qTK.setVisibility(8);
                        aVar.qTL.setVisibility(8);
                        aVar.qTM.setVisibility(8);
                        aVar.qTN.setVisibility(8);
                        break;
                }
                findViewById = view.findViewById(R.h.bQt);
                if (bVar.field_isNew != 0) {
                    i3 = R.g.ben;
                } else {
                    i3 = R.g.bgZ;
                }
                findViewById.setBackgroundResource(i3);
            } else {
                w.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                aVar.qTK.setVisibility(8);
                aVar.qTL.setVisibility(8);
                aVar.qTM.setVisibility(8);
                aVar.qTN.setVisibility(8);
                aVar.qTO.setVisibility(8);
            }
        }
        return view;
    }

    public final void OK() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(l.Ky().Kk());
            notifyDataSetChanged();
            return;
        }
        af.v(new Runnable(this) {
            final /* synthetic */ b qTE;

            {
                this.qTE = r1;
            }

            public final void run() {
                this.qTE.setCursor(l.Ky().Kk());
                this.qTE.notifyDataSetChanged();
            }
        });
    }

    protected final void OL() {
        aEW();
        OK();
    }
}
