package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ao.k;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.preference.SignaturePreference;
import com.tencent.mm.protocal.c.ama;
import com.tencent.mm.protocal.c.amb;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.i;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.d;

@Deprecated
public class RoomInfoDetailUI extends MMPreference implements a {
    private boolean fOg;
    private f isJ;
    private boolean jWp = false;
    private x jiL;
    private String ktD;
    private SignaturePreference ktb;
    private CheckBoxPreference ktg;
    private String ktm;
    private boolean ktq = false;
    private int kvr;
    private CheckBoxPreference kvs;
    private CheckBoxPreference kvt;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    public void onResume() {
        super.onResume();
        ajm();
        ajw();
        if (!(this.jiL == null || this.kvs == null)) {
            ap.yY();
            q fW = c.xa().fW(this.ktm);
            SharedPreferences sharedPreferences = getSharedPreferences(this.ktD, 0);
            if (fW.bKX()) {
                this.kvs.vqm = true;
                sharedPreferences.edit().putBoolean("room_msg_show_username", true).commit();
            } else {
                this.kvs.vqm = false;
                sharedPreferences.edit().putBoolean("room_msg_show_username", false).commit();
            }
        }
        this.isJ.notifyDataSetChanged();
    }

    protected final void KC() {
        zi(R.l.eNC);
        this.isJ = this.vrv;
        this.ktD = getPackageName() + "_preferences";
        this.fOg = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ktm = getIntent().getStringExtra("RoomInfo_Id");
        if (this.ktm == null) {
            this.ktm = getIntent().getStringExtra("Single_Chat_Talker");
        }
        ap.yY();
        this.jiL = c.wR().Rc(this.ktm);
        if (this.fOg) {
            this.kvr = this.jiL.gkz;
            this.ktb = (SignaturePreference) this.isJ.Td("room_name");
            this.ktg = (CheckBoxPreference) this.isJ.Td("room_msg_notify");
            this.kvt = (CheckBoxPreference) this.isJ.Td("room_show_msg_count");
            this.kvs = (CheckBoxPreference) this.isJ.Td("room_msg_show_username");
            this.kvt.vrZ = false;
        } else {
            this.kvr = 1;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomInfoDetailUI kvu;

            {
                this.kvu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kvu.finish();
                return true;
            }
        });
    }

    public final void a(String str, l lVar) {
    }

    public final int ON() {
        return R.o.ftX;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = true;
        String str = preference.igL;
        w.d("MicroMsg.RoomInfoDetailUI", "click key : %s", new Object[]{str});
        if (str.equals("room_name")) {
            Intent intent = new Intent();
            intent.setClass(this, d.c.class);
            intent.putExtra("Contact_mode_name_type", 4);
            String xL = m.xL();
            intent.putExtra("Contact_Nick", aje());
            intent.putExtra("Contact_User", xL);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
            intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
            this.uSU.uTo.startActivityForResult(intent, 2);
        }
        if (str.equals("room_msg_show_username")) {
            ap.yY();
            q fV = c.xa().fV(this.ktm);
            fV.jX(!fV.bKX());
            this.ktq = true;
        }
        if (str.equals("room_msg_notify")) {
            int i;
            if (this.kvr == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.kvr = i;
            ap.yY();
            c.wQ().b(new k(this.ktm, this.kvr));
            ap.yY();
            this.jiL = c.wR().Rc(this.ktm);
            this.jiL.dm(this.kvr);
            ap.yY();
            c.wR().a(this.ktm, this.jiL);
            ajm();
            ap.yY();
            this.jiL = c.wR().Rc(this.ktm);
            this.isJ.notifyDataSetChanged();
        }
        if (str.equals("room_set_chatting_background")) {
            intent = new Intent();
            intent.putExtra("isApplyToAll", false);
            intent.putExtra("username", this.jiL.field_username);
            com.tencent.mm.bb.d.b(this, "setting", ".ui.setting.SettingsChattingBackgroundUI", intent, 1);
        }
        if (str.equals("room_clear_chatting_history")) {
            g.a(this, this.fOg ? getString(R.l.elt) : getString(R.l.els, new Object[]{this.jiL.tL()}), new String[]{getString(R.l.eMb)}, null, new g.c(this) {
                final /* synthetic */ RoomInfoDetailUI kvu;

                {
                    this.kvu = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            this.kvu.jWp = false;
                            Context context = this.kvu;
                            this.kvu.getString(R.l.dIO);
                            final ProgressDialog a = g.a(context, this.kvu.getString(R.l.dJd), true, new OnCancelListener(this) {
                                final /* synthetic */ AnonymousClass2 kvv;

                                {
                                    this.kvv = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.kvv.kvu.jWp = true;
                                }
                            });
                            if (i.er(this.kvu.jiL.field_username)) {
                                com.tencent.mm.plugin.chatroom.a.imw.bp(this.kvu.jiL.field_username);
                            }
                            ay.a(this.kvu.jiL.field_username, new ay.a(this) {
                                final /* synthetic */ AnonymousClass2 kvv;

                                public final boolean zs() {
                                    return this.kvv.kvu.jWp;
                                }

                                public final void zr() {
                                    if (a != null) {
                                        a.dismiss();
                                    }
                                }
                            });
                            return;
                        default:
                            return;
                    }
                }
            });
        }
        if (str.equals("room_placed_to_the_top")) {
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
        }
        if ("room_show_msg_count".equals(str)) {
            boolean z2;
            boolean tE = tE();
            w.d("MicroMsg.RoomInfoDetailUI", "old value undeliver[%B], now set show msg count[%B]", new Object[]{Boolean.valueOf(tE), Boolean.valueOf(tE)});
            if (tE) {
                z2 = false;
            } else {
                z2 = true;
            }
            ap.yY();
            com.tencent.mm.sdk.e.c fV2 = c.xa().fV(this.ktm);
            if (z2) {
                fV2.eA(0);
            } else {
                fV2.eA(2);
            }
            w.d("MicroMsg.RoomInfoDetailUI", "update show msg count[%B]", new Object[]{Boolean.valueOf(z2)});
            ap.yY();
            c.xa().c(fV2, new String[0]);
            xL = m.xL();
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_amb = new amb();
            com_tencent_mm_protocal_c_amb.ttq = this.ktm;
            com_tencent_mm_protocal_c_amb.jNj = xL;
            com_tencent_mm_protocal_c_amb.tQD = 2;
            com_tencent_mm_protocal_c_amb.oTE = z2 ? 2 : 1;
            ap.yY();
            c.wQ().b(new e.a(49, com_tencent_mm_protocal_c_amb));
            if (this.kvt != null) {
                CheckBoxPreference checkBoxPreference = this.kvt;
                if (tE) {
                    z = false;
                }
                checkBoxPreference.vqm = z;
            }
            this.isJ.notifyDataSetChanged();
        }
        return false;
    }

    public void onPause() {
        int i = 1;
        super.onPause();
        if (this.ktq) {
            ap.yY();
            com.tencent.mm.sdk.e.c fV = c.xa().fV(this.ktm);
            ap.yY();
            c.xa().c(fV, new String[0]);
            String xL = m.xL();
            boolean bKX = fV.bKX();
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_amb = new amb();
            com_tencent_mm_protocal_c_amb.ttq = this.ktm;
            com_tencent_mm_protocal_c_amb.jNj = xL;
            com_tencent_mm_protocal_c_amb.tQD = 1;
            if (!bKX) {
                i = 0;
            }
            com_tencent_mm_protocal_c_amb.oTE = i;
            ap.yY();
            c.wQ().b(new e.a(49, com_tencent_mm_protocal_c_amb));
        }
    }

    private boolean tE() {
        ap.yY();
        return (c.xa().fV(this.ktm).field_chatroomdataflag & 2) == 0;
    }

    private String aje() {
        ap.yY();
        q fV = c.xa().fV(this.ktm);
        if (fV == null) {
            return "";
        }
        return fV.field_selfDisplayName;
    }

    private void ajw() {
        if (this.jiL != null && this.ktb != null) {
            CharSequence aje = aje();
            if (bg.mA(aje)) {
                aje = m.xN();
            }
            if (bg.mA(aje)) {
                this.ktb.setSummary("");
                return;
            }
            SignaturePreference signaturePreference = this.ktb;
            if (aje.length() <= 0) {
                aje = getString(R.l.eUe);
            }
            signaturePreference.setSummary(h.a(this, aje));
        }
    }

    private void ajm() {
        boolean z = true;
        if (this.fOg) {
            SharedPreferences sharedPreferences = getSharedPreferences(this.ktD, 0);
            if (this.kvr == 0) {
                zo(0);
                if (this.ktg != null) {
                    this.ktg.vqm = true;
                    sharedPreferences.edit().putBoolean("room_msg_notify", true).commit();
                }
                if (this.kvt != null) {
                    this.kvt.vqm = tE();
                }
            } else if (this.kvr == 1) {
                zo(8);
                if (this.ktg != null) {
                    this.ktg.vqm = false;
                    sharedPreferences.edit().putBoolean("room_msg_notify", false).commit();
                }
            }
            f fVar = this.isJ;
            String str = "room_show_msg_count";
            if (this.kvr != 1) {
                z = false;
            }
            fVar.aV(str, z);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        setResult(-1);
                        finish();
                        return;
                    }
                    return;
                case 2:
                    if (intent != null) {
                        String ap = bg.ap(intent.getStringExtra("Contact_Nick"), "");
                        if (!bg.mA(ap)) {
                            String xL = m.xL();
                            ap.yY();
                            com.tencent.mm.sdk.e.c fV = c.xa().fV(this.ktm);
                            if (fV == null) {
                                fV = new q();
                            }
                            fV.field_chatroomname = this.ktm;
                            fV.field_selfDisplayName = ap;
                            ap.yY();
                            c.xa().c(fV, new String[0]);
                            com.tencent.mm.bd.a com_tencent_mm_protocal_c_ama = new ama();
                            com_tencent_mm_protocal_c_ama.ttq = this.ktm;
                            com_tencent_mm_protocal_c_ama.jNj = xL;
                            com_tencent_mm_protocal_c_ama.tqa = bg.mz(ap);
                            ap.yY();
                            c.wQ().b(new e.a(48, com_tencent_mm_protocal_c_ama));
                            ajw();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
