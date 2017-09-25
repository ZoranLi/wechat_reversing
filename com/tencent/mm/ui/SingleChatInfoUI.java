package com.tencent.mm.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelmulti.q;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.l.m;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.e;
import com.tencent.mm.ui.contact.s;
import java.util.LinkedList;
import java.util.List;

public class SingleChatInfoUI extends MMPreference implements m {
    private static boolean jWp = false;
    private String fJL;
    private ae handler = new ae(Looper.getMainLooper());
    private SharedPreferences hgx = null;
    private f isJ;
    private x jiL;
    private boolean kmK;
    private String ktD = "";
    private ContactListExpandPreference ktf;
    private CheckBoxPreference ktg;
    private CheckBoxPreference kti;
    private int kts = -1;
    private d ktu = new d(new OnScrollListener(this) {
        final /* synthetic */ SingleChatInfoUI uWq;

        {
            this.uWq = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    boolean ktv = false;

    private static class a implements OnCancelListener {
        public final void onCancel(DialogInterface dialogInterface) {
            SingleChatInfoUI.jWp = true;
        }
    }

    static /* synthetic */ void c(SingleChatInfoUI singleChatInfoUI) {
        g.oUh.A(10170, "1");
        List linkedList = new LinkedList();
        linkedList.add(singleChatInfoUI.fJL);
        linkedList.add(com.tencent.mm.u.m.xL());
        String c = u.c(linkedList, ",");
        Intent intent = new Intent();
        intent.setClass(singleChatInfoUI, SelectContactUI.class);
        intent.putExtra("titile", singleChatInfoUI.getString(R.l.dCS));
        intent.putExtra("list_type", 0);
        intent.putExtra("list_attr", s.vYP);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 2);
        singleChatInfoUI.startActivity(intent);
    }

    static /* synthetic */ void d(SingleChatInfoUI singleChatInfoUI) {
        jWp = false;
        singleChatInfoUI.getString(R.l.dIO);
        final ProgressDialog a = com.tencent.mm.ui.base.g.a((Context) singleChatInfoUI, singleChatInfoUI.getString(R.l.dJd), true, new a());
        ay.a(singleChatInfoUI.jiL.field_username, new com.tencent.mm.u.ay.a(singleChatInfoUI) {
            final /* synthetic */ SingleChatInfoUI uWq;

            public final boolean zs() {
                return SingleChatInfoUI.jWp;
            }

            public final void zr() {
                if (a != null) {
                    a.dismiss();
                }
            }
        });
        singleChatInfoUI.handler.post(new Runnable(singleChatInfoUI) {
            final /* synthetic */ SingleChatInfoUI uWq;

            {
                this.uWq = r1;
            }

            public final void run() {
                q.Hy().gg(7);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
            com.tencent.mm.pluginsdk.l.a.sBr.a(this);
        }
        this.fJL = getIntent().getStringExtra("Single_Chat_Talker");
        ap.yY();
        this.jiL = c.wR().Rc(this.fJL);
        this.ktD = getPackageName() + "_preferences";
        KC();
    }

    public void onResume() {
        ajm();
        if (this.ktf != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.fJL);
            this.ktf.k(this.fJL, linkedList);
        }
        this.isJ.notifyDataSetChanged();
        super.onResume();
        if (!this.ktv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!u.mA(stringExtra)) {
                final int Tf = this.isJ.Tf(stringExtra);
                setSelection(Tf - 3);
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ SingleChatInfoUI uWq;

                    public final void run() {
                        View a = ((com.tencent.mm.ui.base.preference.a) this.uWq.isJ).a(Tf, this.uWq.mUX);
                        if (a != null) {
                            com.tencent.mm.ui.h.a.b(this.uWq.uSU.uTo, a);
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
        if (com.tencent.mm.pluginsdk.l.a.sBr != null) {
            com.tencent.mm.pluginsdk.l.a.sBr.b(this);
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 2:
                    if (i2 == -1) {
                        finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final int ON() {
        return R.o.ftZ;
    }

    protected final void KC() {
        this.isJ = this.vrv;
        qP(getString(R.l.eND));
        this.ktf = (ContactListExpandPreference) this.isJ.Td("roominfo_contact_anchor");
        this.ktf.a(this.isJ, this.ktf.igL);
        this.ktf.ju(true).jv(false);
        if (this.jiL != null && this.jiL.field_deleteFlag == 1) {
            this.ktf.ju(false);
        }
        this.ktg = (CheckBoxPreference) this.isJ.Td("room_notify_new_msg");
        this.kti = (CheckBoxPreference) this.isJ.Td("room_placed_to_the_top");
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        if (this.jiL != null) {
            ap.yY();
            this.hgx.edit().putBoolean("room_placed_to_the_top", c.wW().Rt(this.jiL.field_username)).commit();
            this.kmK = this.jiL.tD();
            this.hgx.edit().putBoolean("room_notify_new_msg", this.kmK).commit();
        } else {
            this.hgx.edit().putBoolean("room_notify_new_msg", false).commit();
            this.kmK = false;
        }
        ap.yY();
        this.kts = c.wT().AA(this.fJL);
        this.isJ.notifyDataSetChanged();
        if (this.ktf != null) {
            List linkedList = new LinkedList();
            linkedList.add(this.fJL);
            this.ktf.k(this.fJL, linkedList);
            this.mUX.setOnScrollListener(this.ktu);
            this.ktf.a(this.ktu);
            this.ktf.a(new com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a(this) {
                final /* synthetic */ SingleChatInfoUI uWq;

                {
                    this.uWq = r1;
                }

                public final void kK(int i) {
                }

                public final void kL(int i) {
                    String xu = this.uWq.ktf.xu(i);
                    String mz = u.mz(this.uWq.ktf.xw(i));
                    if (u.mA(mz)) {
                        ap.yY();
                        bb AI = c.wS().AI(xu);
                        if (!(AI == null || u.mA(AI.field_encryptUsername))) {
                            mz = AI.field_conRemark;
                        }
                    }
                    if (!u.mA(xu)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", xu);
                        intent.putExtra("Contact_RemarkName", mz);
                        intent.putExtra("Contact_Nick", u.mz(this.uWq.ktf.xv(i)));
                        intent.putExtra("Contact_RoomMember", true);
                        ap.yY();
                        af Rc = c.wR().Rc(xu);
                        if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                            e.a(intent, xu);
                        }
                        intent.putExtra("Kdel_from", 0);
                        com.tencent.mm.bb.d.b(this.uWq, "profile", ".ui.ContactInfoUI", intent, 0);
                    }
                }

                public final void ajs() {
                    if (this.uWq.ktf != null) {
                        this.uWq.ktf.bFb();
                    }
                }

                public final void kM(int i) {
                    SingleChatInfoUI.c(this.uWq);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SingleChatInfoUI uWq;

            {
                this.uWq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uWq.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.igL;
        if (str.equals("room_notify_new_msg")) {
            if (this.kmK) {
                z = false;
            }
            this.kmK = z;
            if (this.kmK) {
                o.n(this.jiL);
            } else {
                o.o(this.jiL);
            }
            ap.yY();
            this.jiL = c.wR().Rc(this.fJL);
            if (this.hgx == null) {
                this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
            }
            this.hgx.edit().putBoolean("room_notify_new_msg", this.kmK).commit();
            ajm();
        } else if (str.equals("room_placed_to_the_top")) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ktD, 0);
            if (this.jiL != null) {
                ap.yY();
                if (c.wW().Rt(this.jiL.field_username)) {
                    o.m(this.jiL.field_username, true);
                } else {
                    o.l(this.jiL.field_username, true);
                }
                ap.yY();
                sharedPreferences.edit().putBoolean("room_placed_to_the_top", c.wW().Rt(this.jiL.field_username)).commit();
            }
        } else if (str.equals("room_set_chatting_background")) {
            r0 = new Intent();
            r0.putExtra("isApplyToAll", false);
            r0.putExtra("username", this.jiL.field_username);
            com.tencent.mm.bb.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", r0, 2);
        } else if (str.equals("room_search_chatting_content")) {
            r0 = new Intent();
            r0.putExtra("detail_username", this.fJL);
            com.tencent.mm.bb.d.b((Context) this, "search", ".ui.FTSChattingTalkerUI", r0);
        } else if (str.equals("room_clear_chatting_history")) {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.els, new Object[]{this.jiL.tL()}), "", getString(R.l.dGt), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ SingleChatInfoUI uWq;

                {
                    this.uWq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SingleChatInfoUI.d(this.uWq);
                }
            }, null, R.e.aSJ);
        } else if (str.equals("room_expose")) {
            r0 = new Intent();
            r0.putExtra("k_username", this.fJL);
            r0.putExtra("showShare", false);
            r0.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(39)}));
            com.tencent.mm.bb.d.b((Context) this, "webview", ".ui.tools.WebViewUI", r0);
        } else if (str.equals("chat_app_brand")) {
            r0 = new Intent();
            r0.putExtra("Chat_User", this.fJL);
            com.tencent.mm.bb.d.a((Context) this, ".ui.chatting.gallery.AppBrandHistoryListUI", r0);
            g.oUh.a(219, 25, 1, true);
        }
        return false;
    }

    private void ajm() {
        if (this.hgx == null) {
            this.hgx = getSharedPreferences(getPackageName() + "_preferences", 0);
        }
        this.kmK = this.jiL.tD();
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

    public final void B(String str, String str2, String str3) {
        if (str.equals(this.fJL) && this.ktf != null) {
            this.ktf.notifyChanged();
        }
    }

    public final h a(SharedPreferences sharedPreferences) {
        return new com.tencent.mm.ui.base.preference.a(this, sharedPreferences);
    }
}
