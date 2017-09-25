package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.bcp;
import com.tencent.mm.protocal.c.su;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.aq;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.t;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.d.d;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsPrivacyUI extends MMPreference {
    private String gKJ = "";
    private f isJ;
    private HashMap<Integer, Integer> jWK = new HashMap();
    boolean ktv = false;
    private boolean pjZ = false;
    private boolean plH = true;
    private boolean plI = false;
    private boolean plJ = false;
    private boolean plK = false;
    private boolean plL = true;
    private int plM = d.uOz;
    private int status;

    public final h a(SharedPreferences sharedPreferences) {
        return new a(this, sharedPreferences);
    }

    public final int ON() {
        return R.o.eRW;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        this.isJ = this.vrv;
        this.status = m.xP();
        this.gKJ = m.xL();
        ap.yY();
        this.plL = bg.b((Boolean) c.vr().get(68384, null), true);
        this.plM = getIntent().getIntExtra("enter_scene", d.uOz);
        w.d("MicroMsg.SettingPrivacy", "sns Notify " + this.plL);
        KC();
        g.oUh.i(14098, new Object[]{Integer.valueOf(9)});
        if (this.plM == d.uOA || this.plM == d.uOB) {
            bcp com_tencent_mm_protocal_c_bcp = new bcp();
            if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                com_tencent_mm_protocal_c_bcp = com.tencent.mm.plugin.sns.b.m.pQB.Ey(this.gKJ);
            }
            if (com_tencent_mm_protocal_c_bcp != null) {
                boolean z2;
                int i = com_tencent_mm_protocal_c_bcp.udF;
                this.plI = (i & 512) > 0;
                if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.plJ = z2;
                if ((i & 2048) <= 0) {
                    z = false;
                }
                this.plK = z;
            }
            bao();
        }
    }

    protected void onResume() {
        super.onResume();
        this.status = m.xP();
        bap();
        if (!this.ktv) {
            String stringExtra = getIntent().getStringExtra("need_matte_high_light_item");
            if (!bg.mA(stringExtra)) {
                final int Tf = this.isJ.Tf(stringExtra);
                setSelection(Tf - 3);
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ SettingsPrivacyUI plN;

                    public final void run() {
                        View a = ((a) this.plN.isJ).a(Tf, this.plN.mUX);
                        if (a != null) {
                            com.tencent.mm.ui.h.a.b(this.plN.uSU.uTo, a);
                        }
                    }
                }, 10);
            }
            this.ktv = true;
        }
    }

    public void onPause() {
        super.onPause();
        ap.yY();
        c.vr().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.jWK.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            com.tencent.mm.bd.a suVar = new su();
            suVar.tAG = intValue;
            suVar.tAH = intValue2;
            ap.yY();
            c.wQ().b(new e.a(23, suVar));
            w.d("MicroMsg.SettingPrivacy", "switch  " + intValue + " " + intValue2);
        }
        this.jWK.clear();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.SettingPrivacy", str + " item has been clicked!");
        if (str.equals("settings_need_verify")) {
            return c(((CheckBoxPreference) fVar.Td("settings_need_verify")).isChecked(), 32, 4);
        }
        if (str.equals("settings_recommend_mobilefriends_to_me")) {
            return c(!((CheckBoxPreference) fVar.Td("settings_recommend_mobilefriends_to_me")).isChecked(), 256, 7);
        } else if (str.equals("settings_about_blacklist")) {
            aq fT = t.fT(getString(R.l.eqF));
            Intent intent = new Intent();
            intent.putExtra("filter_type", fT.getType());
            intent.putExtra("titile", getString(R.l.eTM));
            intent.putExtra("list_attr", WXMediaMessage.THUMB_LENGTH_LIMIT);
            com.tencent.mm.plugin.setting.a.imv.g(this, intent);
            return true;
        } else {
            Intent intent2;
            if (str.equals("timline_outside_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 4);
                intent2.putExtra("k_sns_from_settings_about_sns", 1);
                com.tencent.mm.bb.d.b(this, "sns", ".ui.SnsBlackDetailUI", intent2);
            } else if (str.equals("edit_timeline_group")) {
                com.tencent.mm.bb.d.w(this, "sns", ".ui.SnsTagPartlyUI");
            } else if (str.equals("timeline_black_permiss")) {
                intent2 = new Intent();
                intent2.putExtra("k_sns_tag_id", 5);
                intent2.putExtra("k_sns_from_settings_about_sns", 2);
                intent2.putExtra("k_tag_detail_sns_block_scene", 8);
                com.tencent.mm.bb.d.b(this, "sns", ".ui.SnsTagDetailUI", intent2);
            } else if (str.equals("timeline_stranger_show")) {
                this.pjZ = !this.pjZ;
                if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                    com.tencent.mm.plugin.sns.b.m.pQB.am(this.gKJ, this.pjZ);
                }
                if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                    com.tencent.mm.bd.a an = com.tencent.mm.plugin.sns.b.m.pQB.an(this.gKJ, this.pjZ);
                    com.tencent.mm.plugin.sns.b.m.pQB.a(this.gKJ, an);
                    if (an == null) {
                        w.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                        return false;
                    }
                    w.d("MicroMsg.SettingPrivacy", "dancy userinfo " + an.toString());
                    ap.yY();
                    c.wQ().b(new e.a(51, an));
                }
            } else if (str.equals("settings_find_google_contact")) {
                c(!((CheckBoxPreference) fVar.Td("settings_find_google_contact")).isChecked(), 1048576, 29);
                return true;
            } else if (str.equals("settings_add_me_way")) {
                startActivity(new Intent(this, SettingsAddMeUI.class));
                return true;
            } else if (str.equals("timeline_recent_show_select")) {
                bao();
            } else if (str.equals("timeline_open_entrance")) {
                int i;
                this.plH = !this.plH;
                w.i("MicroMsg.SettingPrivacy", "iSnsOpenEntrance  " + this.plH + ", checkBox status " + ((CheckBoxPreference) preference).isChecked());
                int xW = m.xW();
                if (this.plH) {
                    i = xW & -32769;
                } else {
                    i = xW | WXMediaMessage.THUMB_LENGTH_LIMIT;
                }
                if (this.plH) {
                    g.oUh.i(14098, new Object[]{Integer.valueOf(1)});
                } else {
                    g.oUh.i(14098, new Object[]{Integer.valueOf(2)});
                }
                w.i("MicroMsg.SettingPrivacy", "update pluginFlag to " + i);
                ap.yY();
                c.vr().set(34, Integer.valueOf(i));
                ap.yY();
                c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
                bap();
            } else if (str.equals("settings_sns_notify")) {
                this.plL = !this.plL;
                if (this.plL) {
                    g.oUh.i(14098, new Object[]{Integer.valueOf(3)});
                } else {
                    g.oUh.i(14098, new Object[]{Integer.valueOf(4)});
                }
                ap.yY();
                c.vr().set(68384, Boolean.valueOf(this.plL));
                bap();
                return true;
            } else if (str.equals("settings_unfamiliar_contact")) {
                startActivity(new Intent(this, UnfamiliarContactUI.class));
            }
            return false;
        }
    }

    private void bao() {
        bcp Ey;
        bcp com_tencent_mm_protocal_c_bcp = new bcp();
        if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
            Ey = com.tencent.mm.plugin.sns.b.m.pQB.Ey(this.gKJ);
        } else {
            Ey = com_tencent_mm_protocal_c_bcp;
        }
        if (Ey == null) {
            w.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        ap.yY();
        int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGF, Integer.valueOf(0))).intValue();
        ap.yY();
        if (intValue > ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGG, Integer.valueOf(0))).intValue()) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uGG, Integer.valueOf(intValue));
            bap();
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this.uSU.uTo);
        aVar.Aa(R.l.dGs);
        aVar.zW(R.l.dYi);
        View inflate = View.inflate(this.uSU.uTo, R.i.div, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.cGZ);
        OnClickListener anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ SettingsPrivacyUI plN;

            public final void onClick(View view) {
                for (int i = 0; i < linearLayout.getChildCount(); i++) {
                    TextView textView = (TextView) linearLayout.getChildAt(i);
                    if (R.h.cIS != textView.getId()) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dzd, 0, 0, 0);
                    }
                }
                ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.k.dze, 0, 0, 0);
                bcp com_tencent_mm_protocal_c_bcp = new bcp();
                if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                    com_tencent_mm_protocal_c_bcp = com.tencent.mm.plugin.sns.b.m.pQB.Ey(this.plN.gKJ);
                }
                if (com_tencent_mm_protocal_c_bcp == null) {
                    w.e("MicroMsg.SettingPrivacy", "userinfo is null");
                    return;
                }
                int intValue = ((Integer) view.getTag()).intValue();
                w.d("MicroMsg.SettingPrivacy", "settings_silence_update_mode choice: %d", new Object[]{Integer.valueOf(intValue)});
                com.tencent.mm.bd.a b;
                if (intValue == 0) {
                    if (this.plN.plM == d.uOA) {
                        g.oUh.i(14090, new Object[]{Integer.valueOf(4)});
                    }
                    this.plN.plI = false;
                    this.plN.plJ = true;
                    this.plN.plK = true;
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                    }
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        b = com.tencent.mm.plugin.sns.b.m.pQB.b(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, b);
                        if (b == null) {
                            w.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                            return;
                        }
                        w.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                        ap.yY();
                        c.wQ().b(new e.a(51, b));
                    }
                } else if (intValue == 1) {
                    if (this.plN.plM == d.uOA) {
                        g.oUh.i(14090, new Object[]{Integer.valueOf(5)});
                    }
                    this.plN.plI = true;
                    this.plN.plJ = false;
                    this.plN.plK = true;
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                    }
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        b = com.tencent.mm.plugin.sns.b.m.pQB.b(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, b);
                        if (b == null) {
                            w.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                            return;
                        }
                        w.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                        ap.yY();
                        c.wQ().b(new e.a(51, b));
                    }
                } else {
                    if (this.plN.plM == d.uOA) {
                        g.oUh.i(14090, new Object[]{Integer.valueOf(6)});
                    }
                    this.plN.plI = false;
                    this.plN.plJ = false;
                    this.plN.plK = true;
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                    }
                    if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
                        b = com.tencent.mm.plugin.sns.b.m.pQB.b(this.plN.gKJ, this.plN.plI, this.plN.plJ, this.plN.plK);
                        com.tencent.mm.plugin.sns.b.m.pQB.a(this.plN.gKJ, b);
                        if (b == null) {
                            w.e("MicroMsg.SettingPrivacy", "userinfo in null !");
                            return;
                        }
                        w.d("MicroMsg.SettingPrivacy", "dancy userinfo " + b.toString());
                        ap.yY();
                        c.wQ().b(new e.a(51, b));
                    }
                }
                view.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 plO;

                    {
                        this.plO = r1;
                    }

                    public final void run() {
                        ((Dialog) linearLayout.getTag()).dismiss();
                        this.plO.plN.bap();
                    }
                });
            }
        };
        int i = Ey.udF;
        a(linearLayout, R.l.dYl, 0, this.plJ, anonymousClass2);
        a(linearLayout, R.l.dYk, 1, this.plI, anonymousClass2);
        int i2 = R.l.dYj;
        boolean z = (this.plI || this.plJ) ? false : true;
        a(linearLayout, i2, 2, z, anonymousClass2);
        aVar.dd(inflate);
        Dialog WJ = aVar.WJ();
        linearLayout.setTag(WJ);
        WJ.show();
        a(WJ);
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, OnClickListener onClickListener) {
        TextView textView = (TextView) View.inflate(this.uSU.uTo, R.i.dlH, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.k.dze, 0, 0, 0);
        }
    }

    protected final void KC() {
        boolean z = false;
        zi(R.l.eRW);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsPrivacyUI plN;

            {
                this.plN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.plN.aHf();
                this.plN.finish();
                return true;
            }
        });
        w.v("MicroMsg.SettingPrivacy", "init function status: " + Integer.toBinaryString(this.status));
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_need_verify");
        checkBoxPreference.vrZ = false;
        checkBoxPreference.vqm = rt(32);
        ap.yY();
        String str = (String) c.vr().get(6, null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.isJ.Td("settings_recommend_mobilefriends_to_me");
        checkBoxPreference2.vrZ = false;
        if (str == null || str.length() <= 0) {
            this.isJ.c(checkBoxPreference2);
        } else {
            checkBoxPreference2.vqm = !rt(256);
        }
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_find_google_contact");
        checkBoxPreference.vrZ = false;
        if (!rt(1048576)) {
            z = true;
        }
        checkBoxPreference.vqm = z;
        ap.yY();
        String str2 = (String) c.vr().get(208903, null);
        if (!bg.Hp() || TextUtils.isEmpty(str2)) {
            this.isJ.c(checkBoxPreference);
        }
        ap.yY();
        if (!(((Boolean) c.vr().get(335873, Boolean.valueOf(true))).booleanValue() && com.tencent.mm.plugin.sns.b.m.pQD.bdy())) {
            this.isJ.aV("edit_timeline_group", true);
        }
        this.isJ.notifyDataSetChanged();
    }

    private boolean rt(int i) {
        return (this.status & i) != 0;
    }

    private boolean c(boolean z, int i, int i2) {
        w.d("MicroMsg.SettingPrivacy", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.jWK.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        return true;
    }

    private void bap() {
        bcp com_tencent_mm_protocal_c_bcp = new bcp();
        if (com.tencent.mm.plugin.sns.b.m.pQB != null) {
            com_tencent_mm_protocal_c_bcp = com.tencent.mm.plugin.sns.b.m.pQB.Ey(this.gKJ);
        }
        if (com_tencent_mm_protocal_c_bcp == null) {
            w.e("MicroMsg.SettingPrivacy", "userinfo is null");
            return;
        }
        boolean z;
        int i = com_tencent_mm_protocal_c_bcp.udF;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("timeline_stranger_show");
        if (checkBoxPreference != null) {
            checkBoxPreference.vrZ = false;
            this.pjZ = (i & 1) > 0;
            if (this.pjZ) {
                checkBoxPreference.vqm = false;
            } else {
                checkBoxPreference.vqm = true;
            }
        }
        IconPreference iconPreference = (IconPreference) this.isJ.Td("timeline_recent_show_select");
        if (iconPreference != null) {
            iconPreference.vrZ = false;
            if ((i & 512) > 0) {
                z = true;
            } else {
                z = false;
            }
            this.plI = z;
            if ((i & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) > 0) {
                z = true;
            } else {
                z = false;
            }
            this.plJ = z;
            if ((i & 2048) > 0) {
                z = true;
            } else {
                z = false;
            }
            this.plK = z;
            if (this.plI) {
                iconPreference.setSummary(R.l.dYk);
            } else if (this.plJ) {
                iconPreference.setSummary(R.l.dYl);
            } else {
                iconPreference.setSummary(R.l.dYj);
            }
            ap.yY();
            i = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGF, Integer.valueOf(0))).intValue();
            ap.yY();
            w.i("MicroMsg.SettingPrivacy", "willShowRecentRedCodeId  %d, currentRecentRedCodeId %d", new Object[]{Integer.valueOf(i), Integer.valueOf(((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGG, Integer.valueOf(0))).intValue())});
            if (i > ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uGG, Integer.valueOf(0))).intValue()) {
                iconPreference.Au(0);
            } else {
                iconPreference.Au(8);
            }
        }
        checkBoxPreference = (CheckBoxPreference) this.isJ.Td("timeline_open_entrance");
        if (checkBoxPreference != null) {
            checkBoxPreference.vrZ = false;
            if (com.tencent.mm.bb.d.Jt("sns") && (m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.plH = z;
            String str = "MicroMsg.SettingPrivacy";
            StringBuilder append = new StringBuilder("isSnsOpenEntrance ").append(this.plH).append(", install ").append(com.tencent.mm.bb.d.Jt("sns")).append(", flag ");
            if ((m.xW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                z = true;
            } else {
                z = false;
            }
            w.i(str, append.append(z).toString());
            if (this.plH) {
                checkBoxPreference.vqm = true;
                this.isJ.aV("settings_sns_notify", false);
            } else {
                checkBoxPreference.vqm = false;
                this.isJ.aV("settings_sns_notify", true);
            }
        }
        if (this.plH) {
            checkBoxPreference = (CheckBoxPreference) this.isJ.Td("settings_sns_notify");
            if (checkBoxPreference != null) {
                checkBoxPreference.vrZ = false;
                ap.yY();
                this.plL = bg.b((Boolean) c.vr().get(68384, null), true);
                if (this.plL) {
                    checkBoxPreference.vqm = true;
                } else {
                    checkBoxPreference.vqm = false;
                }
            }
        }
        this.isJ.notifyDataSetChanged();
    }
}
