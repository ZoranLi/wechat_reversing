package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.mq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.preference.AccountInfoPreference;
import com.tencent.mm.q.a.a;
import com.tencent.mm.q.c;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.AddressUI;
import com.tencent.wcdb.database.SQLiteDatabase;

public class s extends a implements b {
    public f isJ;
    private a pmt = new a(this) {
        final /* synthetic */ s uVj;

        {
            this.uVj = r1;
        }

        public final void eE(int i) {
            if (i == 262145 || i == 266260 || i == 262157 || i == 266267 || i == 262158) {
                this.uVj.bQt();
                this.uVj.aZU();
            } else if (i == 262147) {
                this.uVj.bQu();
            } else if (i == 262156) {
                this.uVj.bQw();
            } else if (i == 262152) {
                this.uVj.bQs();
            }
            this.uVj.isJ.notifyDataSetChanged();
        }

        public final void eF(int i) {
        }

        public final void a(w.a aVar) {
            if (aVar == w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC) {
                this.uVj.bQs();
            } else if (aVar == w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC) {
                this.uVj.bQs();
            } else if (aVar == w.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC) {
                this.uVj.bQw();
            }
            this.uVj.isJ.notifyDataSetChanged();
        }
    };

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!ap.zb() || ap.uP()) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MoreTabUI", "Create MoreTabUI when accready:%b ishold:%b", Boolean.valueOf(ap.zb()), Boolean.valueOf(ap.uP()));
        }
    }

    public final int ON() {
        return R.o.ftS;
    }

    public final boolean biv() {
        return false;
    }

    public final boolean Xb() {
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
    }

    public final void onActivityCreated(Bundle bundle) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.MoreTabUI", "onActivityCreated");
        super.onActivityCreated(bundle);
        this.isJ = this.vrv;
        this.isJ.aV("more_setting", true);
        this.isJ.aV("settings_emoji_store", true);
        this.isJ.aV("settings_mm_wallet", true);
        this.isJ.aV("settings_mm_cardpackage", true);
        this.isJ.aV("settings_mm_favorite", true);
        this.isJ.aV("settings_my_album", true);
        this.isJ.aV("settings_my_address", true);
        this.isJ.aV("more_tab_setting_personal_info", true);
        this.isJ.aV("more_uishow", true);
    }

    public final boolean a(f fVar, Preference preference) {
        if (preference.igL.equals("more_tab_setting_personal_info")) {
            d.b(this.uSU.uTo, "setting", ".ui.setting.SettingsPersonalInfoUI", new Intent());
            return true;
        } else if (preference.igL.equals("settings_my_address")) {
            r0 = new Intent(this.uSU.uTo, AddressUI.class);
            r0.putExtra("Contact_GroupFilter_Type", "@biz.contact");
            startActivity(r0);
            return true;
        } else if (preference.igL.equals("settings_my_add_contact")) {
            d.b(this.uSU.uTo, "subapp", ".ui.pluginapp.AddMoreFriendsUI", new Intent());
            return true;
        } else if (preference.igL.equals("settings_mm_wallet")) {
            boolean aC = c.uk().aC(262156, 266248);
            r3 = c.uk().aD(262156, 266248);
            g.oUh.A(10958, "9");
            g gVar = g.oUh;
            Object[] objArr = new Object[1];
            r0 = (aC || r3) ? 1 : 0;
            objArr[0] = Integer.valueOf(r0);
            gVar.i(13341, objArr);
            g.oUh.i(14419, Integer.valueOf(0));
            com.tencent.mm.sdk.b.b mqVar = new mq();
            mqVar.fTW.context = this.uSU.uTo;
            r1 = new Intent();
            r1.putExtra("key_wallet_has_red", r3);
            mqVar.fTW.intent = r1;
            com.tencent.mm.sdk.b.a.urY.m(mqVar);
            c.uk().aE(262156, 266248);
            c.uk().c(w.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, w.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1));
            return true;
        } else if (preference.igL.equals("settings_mm_cardpackage")) {
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, (Object) "");
            r0 = new Intent();
            r0.putExtra("key_from_scene", 22);
            d.b(this.uSU.uTo, "card", ".ui.CardHomePageUI", r0);
            return true;
        } else if (preference.igL.equals("settings_my_album")) {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                ap.yY();
                String str = (String) com.tencent.mm.u.c.vr().get(2, null);
                r1 = new Intent();
                r1.putExtra("sns_userName", str);
                r1.setFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                r1.addFlags(67108864);
                ap.yY();
                r0 = u.g((Integer) com.tencent.mm.u.c.vr().get(68389, null));
                ap.yY();
                com.tencent.mm.u.c.vr().set(68389, Integer.valueOf(r0 + 1));
                d.b(this.uSU.uTo, "sns", ".ui.SnsUserUI", r1);
                return true;
            }
            com.tencent.mm.ui.base.s.eP(this.uSU.uTo);
            return true;
        } else if (preference.igL.equals("settings_mm_favorite")) {
            g.oUh.A(10958, "8");
            g.oUh.i(14103, Integer.valueOf(0));
            d.w(this.uSU.uTo, "favorite", ".ui.FavoriteIndexUI");
            r0 = new Intent();
            r0.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            r0.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            sendBroadcast(r0);
            return true;
        } else if (preference.igL.equals("settings_emoji_store")) {
            g.oUh.A(10958, "7");
            c.uk().aE(262147, 266244);
            c.uk().aE(262149, 266244);
            r0 = new Intent();
            r0.putExtra("preceding_scence", 2);
            d.b(this.uSU.uTo, "emoji", ".ui.v2.EmojiStoreV2UI", r0);
            g.oUh.i(12065, Integer.valueOf(1));
            return true;
        } else if (preference.igL.equals("more_setting")) {
            r3 = c.uk().aC(262145, 266242);
            c.uk().aE(262145, 266242);
            c.uk().aE(262157, 266261);
            c.uk().aE(262158, 266264);
            d.b(this.uSU.uTo, "setting", ".ui.setting.SettingsUI", new Intent());
            ap.yY();
            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            ap.yY();
            r0 = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if (r3 || intValue <= r0) {
                return true;
            }
            ap.yY();
            com.tencent.mm.u.c.vr().a(w.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            IconPreference iconPreference = (IconPreference) fVar.Td("more_setting");
            if (iconPreference != null) {
                iconPreference.Au(8);
            }
            c.uk().aE(266260, 266241);
            return true;
        } else if (!preference.igL.equals("more_uishow")) {
            return false;
        } else {
            h.h(com.tencent.mm.plugin.ag.a.a.a.class);
            r0 = new Intent();
            return true;
        }
    }

    public final void aZU() {
        if (d.Jt("sns")) {
            this.isJ.aV("settings_my_album", false);
        } else {
            this.isJ.aV("settings_my_album", true);
        }
    }

    public final void bQs() {
        l.c cVar = l.a.sBv;
        if (cVar == null || !((cVar.afJ() || cVar.afK()) && d.Jt("card"))) {
            this.isJ.aV("settings_mm_cardpackage", true);
            return;
        }
        String str = "";
        if (cVar != null) {
            CharSequence afL = cVar.afL();
        } else {
            Object obj = str;
        }
        boolean aD = c.uk().aD(262152, 266256);
        boolean aC = c.uk().aC(262152, 266256);
        boolean a = c.uk().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_REDDOT_WORDING_STRING_SYNC, w.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_REDDOT_WORDING_STRING_SYNC);
        boolean a2 = c.uk().a(w.a.NEW_BANDAGE_DATASOURCE_NEW_CARD_ICON_STRING_SYNC, w.a.NEW_BANDAGE_WATCHER_SETTING_CARD_ENTRY_ICON_STRING_SYNC);
        this.isJ.aV("settings_mm_cardpackage", false);
        final IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_mm_cardpackage");
        if (iconPreference != null) {
            iconPreference.setTitle(R.l.eSP);
            if (aC) {
                iconPreference.As(0);
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                iconPreference.Au(8);
                iconPreference.setSummary(null);
                iconPreference.P(null);
                iconPreference.Aw(8);
                iconPreference.cN("", -1);
                iconPreference.At(8);
                return;
            }
            ap.yY();
            String str2 = (String) com.tencent.mm.u.c.vr().get(w.a.USERINFO_CARD_REDOT_ICON_URL_STRING_SYNC, (Object) "");
            if (!a2 || TextUtils.isEmpty(str2)) {
                iconPreference.P(null);
                iconPreference.Aw(8);
            } else {
                int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.aYE);
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hIO = e.hgu;
                n.GX();
                aVar.hJg = null;
                aVar.hIN = m.sw(str2);
                aVar.hIL = true;
                aVar.hJi = true;
                aVar.hIJ = true;
                aVar.hIS = dimensionPixelOffset;
                aVar.hIR = dimensionPixelOffset;
                n.GW().a(str2, iconPreference.nvU, aVar.Hg(), new com.tencent.mm.ah.a.c.g(this) {
                    final /* synthetic */ s uVj;

                    public final void jK(String str) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 uVl;

                            {
                                this.uVl = r1;
                            }

                            public final void run() {
                                iconPreference.Aw(0);
                                iconPreference.Av(R.g.bhq);
                            }
                        });
                    }

                    public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                        if (bVar.bitmap != null) {
                            final Bitmap bitmap = bVar.bitmap;
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 uVl;

                                public final void run() {
                                    iconPreference.P(bitmap);
                                    iconPreference.Aw(0);
                                }
                            });
                            return;
                        }
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 uVl;

                            {
                                this.uVl = r1;
                            }

                            public final void run() {
                                iconPreference.P(null);
                                iconPreference.Aw(8);
                            }
                        });
                    }
                });
            }
            if (aD) {
                iconPreference.Au(0);
            } else {
                iconPreference.Au(8);
            }
            if (a) {
                iconPreference.cM("", -1);
                iconPreference.As(8);
                if (a2) {
                    iconPreference.setSummary(null);
                    if (u.mA(afL)) {
                        iconPreference.cN("", -1);
                        iconPreference.At(8);
                        return;
                    }
                    iconPreference.R(afL, -1, getResources().getColor(R.e.aUo));
                    iconPreference.At(0);
                    return;
                }
                iconPreference.cN("", -1);
                iconPreference.At(8);
                if (u.mA(afL)) {
                    iconPreference.setSummary(null);
                    return;
                } else {
                    iconPreference.setSummary(afL);
                    return;
                }
            }
            iconPreference.At(8);
            iconPreference.As(8);
            iconPreference.setSummary(null);
        }
    }

    public final void bQt() {
        this.isJ.aV("more_setting", false);
        IconPreference iconPreference = (IconPreference) this.isJ.Td("more_setting");
        if (iconPreference != null) {
            iconPreference.Ax(8);
            boolean aC = c.uk().aC(262145, 266242);
            if (aC) {
                iconPreference.As(0);
                iconPreference.cM(getString(R.l.dHO), R.g.bhC);
            } else {
                iconPreference.As(8);
                iconPreference.cM("", -1);
            }
            ap.yY();
            if (((Integer) com.tencent.mm.u.c.vr().get(9, Integer.valueOf(0))).intValue() != 0) {
                if (com.tencent.mm.u.m.xT()) {
                    iconPreference.setSummary((CharSequence) "");
                } else {
                    iconPreference.setSummary(R.l.eNJ);
                }
            }
            iconPreference.Au(8);
            if (!aC) {
                ap.yY();
                int intValue = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_SETTING_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
                ap.yY();
                int intValue2 = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_SETTING_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue();
                if ((((com.tencent.mm.plugin.welab.a.a.c) h.h(com.tencent.mm.plugin.welab.a.a.c.class)).bAK() || ((com.tencent.mm.plugin.welab.a.a.c) h.h(com.tencent.mm.plugin.welab.a.a.c.class)).bAL() || intValue > intValue2) && !aC) {
                    iconPreference.Au(0);
                    iconPreference.As(8);
                    iconPreference.cM("", -1);
                    return;
                }
                iconPreference.Au(8);
                if (c.uk().aD(262157, 266261)) {
                    iconPreference.Au(0);
                    iconPreference.As(8);
                    iconPreference.cM("", -1);
                } else if (c.uk().aD(262158, 266264)) {
                    iconPreference.Au(0);
                    iconPreference.As(8);
                    iconPreference.cM("", -1);
                }
            }
        }
    }

    public final void bQu() {
        if (d.Jt("emoji")) {
            d.bGP();
            this.isJ.aV("settings_emoji_store", false);
            boolean aC = c.uk().aC(262147, 266244);
            boolean aC2 = c.uk().aC(262149, 266244);
            final IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_emoji_store");
            if (iconPreference != null) {
                if (aC) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                } else if (aC2) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHq), R.g.bhC);
                } else {
                    iconPreference.As(8);
                    iconPreference.cM("", -1);
                }
                if (aC2 || aC) {
                    ap.yY();
                    n.GW().a((String) com.tencent.mm.u.c.vr().get(229633, null), iconPreference.nvU, new com.tencent.mm.ah.a.c.g(this) {
                        final /* synthetic */ s uVj;

                        public final void jK(String str) {
                        }

                        public final void a(String str, View view, com.tencent.mm.ah.a.d.b bVar) {
                            if (bVar.status != 0 || bVar.bitmap == null) {
                                af.v(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 uVn;

                                    {
                                        this.uVn = r1;
                                    }

                                    public final void run() {
                                        iconPreference.Aw(8);
                                    }
                                });
                                return;
                            }
                            final Bitmap bitmap = bVar.bitmap;
                            af.v(new Runnable(this) {
                                final /* synthetic */ AnonymousClass4 uVn;

                                public final void run() {
                                    iconPreference.P(bitmap);
                                    iconPreference.Aw(0);
                                }
                            });
                        }
                    });
                    return;
                }
                iconPreference.Aw(8);
                return;
            }
            return;
        }
        this.isJ.aV("settings_emoji_store", false);
    }

    private void bQv() {
        boolean xU = com.tencent.mm.u.m.xU();
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "wallet status: is open" + xU);
        this.isJ.aV("settings_mm_wallet", !xU);
        this.vrv.notifyDataSetChanged();
    }

    public final void bQw() {
        ap.yY();
        int g = u.g((Integer) com.tencent.mm.u.c.vr().get(204820, null));
        ap.yY();
        int g2 = g + u.g((Integer) com.tencent.mm.u.c.vr().get(204817, null));
        boolean aC = c.uk().aC(262156, 266248);
        boolean aD = c.uk().aD(262156, 266248);
        boolean b = c.uk().b(w.a.NEW_BANDAGE_DATASOURCE_WALLET_MORE_TAB_STRING_SYNC, w.a.NEW_BANDAGE_WATCHER_WALLET_COMMON_STRING_SYNC);
        ap.yY();
        String str = (String) com.tencent.mm.u.c.vr().get(w.a.USERINFO_WALLET_MORE_TAB_REDDOT_WORDING_STRING_SYNC, (Object) "");
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_mm_wallet");
        if (iconPreference != null) {
            boolean z;
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "isShowNew : " + aC);
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "isShowDot : " + aD);
            ap.yY();
            String str2 = (String) com.tencent.mm.u.c.vr().get(w.a.USERINFO_LQT_WALLET_RED_DOT_WORDING_STRING, (Object) "");
            ap.yY();
            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_LQT_WALLET_RED_DOT_INT, Integer.valueOf(-1))).intValue();
            if (aC || aD) {
                ap.yY();
                long longValue = ((Long) com.tencent.mm.u.c.vr().get(w.a.USERINFO_WALLET_ENTRY_REDDOT_PUSH_DATE_LONG_SYNC, Long.valueOf(-1))).longValue();
                long mB = u.mB(com.tencent.mm.i.g.sV().getValue("PayWalletRedDotExpire"));
                long j = 86400000 * mB;
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.MoreTabUI", "pushTick: %s, expireTime: %s, expireTick: %s, currentTick: %s, passDay: %s", Long.valueOf(longValue), Long.valueOf(mB), Long.valueOf(j), Long.valueOf(System.currentTimeMillis()), Double.valueOf((((double) System.currentTimeMillis()) - ((double) longValue)) / 8.64E7d));
                if (longValue > 0 && mB > 0 && r20 >= ((double) mB)) {
                    aD = false;
                    z = false;
                    c.uk().s(262156, false);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s", Boolean.valueOf(aD), Boolean.valueOf(z));
                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "bankcardDot : " + b);
                    if (b) {
                        if (aD) {
                            iconPreference.As(0);
                            iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                            iconPreference.Au(8);
                        } else if (g2 > 99) {
                            iconPreference.As(0);
                            iconPreference.cM(getString(R.l.fkz), com.tencent.mm.ui.tools.s.fg(this.uSU.uTo));
                            iconPreference.Au(8);
                        } else if (g2 > 0) {
                            iconPreference.As(0);
                            iconPreference.cM(String.valueOf(g2), com.tencent.mm.ui.tools.s.fg(this.uSU.uTo));
                            iconPreference.Au(8);
                        } else if (z) {
                            iconPreference.cM("", -1);
                            iconPreference.As(8);
                            iconPreference.Au(0);
                        } else if (intValue != 1) {
                            iconPreference.cM("", -1);
                            iconPreference.As(8);
                            iconPreference.At(0);
                            iconPreference.kY(true);
                            if (!u.mA(str2)) {
                                iconPreference.R(str2, -1, Color.parseColor("#888888"));
                            }
                            iconPreference.Ax(8);
                        } else {
                            iconPreference.cM("", -1);
                            iconPreference.As(8);
                            iconPreference.Au(8);
                            iconPreference.At(8);
                            iconPreference.cN("", -1);
                        }
                    } else if (bg.mA(str)) {
                        iconPreference.At(0);
                        iconPreference.R(str, -1, -7566196);
                        iconPreference.kY(true);
                        iconPreference.Au(8);
                    } else {
                        iconPreference.cN("", -1);
                        iconPreference.At(8);
                        iconPreference.Au(0);
                    }
                }
            }
            z = aD;
            aD = aC;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.MoreTabUI", "after check, isShowNew: %s, isShowDot: %s", Boolean.valueOf(aD), Boolean.valueOf(z));
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "bankcardDot : " + b);
            if (b) {
                if (aD) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.dHO), R.g.bhC);
                    iconPreference.Au(8);
                } else if (g2 > 99) {
                    iconPreference.As(0);
                    iconPreference.cM(getString(R.l.fkz), com.tencent.mm.ui.tools.s.fg(this.uSU.uTo));
                    iconPreference.Au(8);
                } else if (g2 > 0) {
                    iconPreference.As(0);
                    iconPreference.cM(String.valueOf(g2), com.tencent.mm.ui.tools.s.fg(this.uSU.uTo));
                    iconPreference.Au(8);
                } else if (z) {
                    iconPreference.cM("", -1);
                    iconPreference.As(8);
                    iconPreference.Au(0);
                } else if (intValue != 1) {
                    iconPreference.cM("", -1);
                    iconPreference.As(8);
                    iconPreference.Au(8);
                    iconPreference.At(8);
                    iconPreference.cN("", -1);
                } else {
                    iconPreference.cM("", -1);
                    iconPreference.As(8);
                    iconPreference.At(0);
                    iconPreference.kY(true);
                    if (u.mA(str2)) {
                        iconPreference.R(str2, -1, Color.parseColor("#888888"));
                    }
                    iconPreference.Ax(8);
                }
            } else if (bg.mA(str)) {
                iconPreference.cN("", -1);
                iconPreference.At(8);
                iconPreference.Au(0);
            } else {
                iconPreference.At(0);
                iconPreference.R(str, -1, -7566196);
                iconPreference.kY(true);
                iconPreference.Au(8);
            }
        }
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        int aC = u.aC(obj);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.MoreTabUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(aC), mVar);
        ap.yY();
        if (mVar != com.tencent.mm.u.c.vr() || aC <= 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.MoreTabUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(aC), mVar);
        } else if (204817 == aC || 204820 == aC) {
            bQw();
        } else if (40 == aC) {
            bQv();
        } else if ("208899".equals(Integer.valueOf(i))) {
            bQu();
        }
    }

    protected final void bOl() {
        this.isJ = this.vrv;
    }

    protected final void bOm() {
        this.isJ = this.vrv;
        ap.yY();
        com.tencent.mm.u.c.vr().a(this);
        c.uk().a(this.pmt);
        this.isJ.aV("more_tab_setting_personal_info", false);
        AccountInfoPreference accountInfoPreference = (AccountInfoPreference) this.vrv.Td("more_tab_setting_personal_info");
        String xM = com.tencent.mm.u.m.xM();
        if (u.mA(xM)) {
            xM = com.tencent.mm.u.m.xL();
            if (x.QQ(xM)) {
                accountInfoPreference.sRO = null;
            } else {
                accountInfoPreference.sRO = xM;
            }
        } else {
            accountInfoPreference.sRO = xM;
        }
        accountInfoPreference.userName = com.tencent.mm.u.m.xL();
        CharSequence xN = com.tencent.mm.u.m.xN();
        if (u.mA(xN)) {
            xN = com.tencent.mm.u.m.xL();
        }
        accountInfoPreference.sRN = com.tencent.mm.pluginsdk.ui.d.h.a(this.uSU.uTo, xN);
        ((AccountInfoPreference) this.isJ.Td("more_tab_setting_personal_info")).sRQ = new OnClickListener(this) {
            final /* synthetic */ s uVj;

            {
                this.uVj = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11264, Integer.valueOf(1));
                this.uVj.startActivity(new Intent(this.uVj.uSU.uTo, SelfQRCodeUI.class));
            }
        };
        IconPreference iconPreference = (IconPreference) this.isJ.Td("settings_my_address");
        if (iconPreference != null) {
            int Km = com.tencent.mm.av.l.Ky().Km();
            if (Km > 0) {
                iconPreference.As(0);
                iconPreference.cM(String.valueOf(Km), R.g.bhC);
            } else {
                iconPreference.As(8);
                iconPreference.cM("", -1);
            }
        }
        aZU();
        bQu();
        bQt();
        if (d.Jt("favorite")) {
            this.isJ.aV("settings_mm_favorite", false);
        } else {
            this.isJ.aV("settings_mm_favorite", true);
        }
        bQw();
        bQv();
        bQs();
        if (h.vE().g(com.tencent.mm.plugin.ag.a.a.class)) {
            this.isJ.aV("more_uishow", false);
        } else {
            this.isJ.aV("more_uishow", true);
        }
        this.isJ.notifyDataSetChanged();
        final View findViewById = findViewById(R.h.cbT);
        if (findViewById != null && findViewById.getVisibility() != 8) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ s uVj;

                public final void run() {
                    findViewById.setVisibility(8);
                    findViewById.startAnimation(AnimationUtils.loadAnimation(this.uVj.uSU.uTo, R.a.aQY));
                }
            });
        }
    }

    protected final void bOn() {
    }

    protected final void bOo() {
        c.uk().b(this.pmt);
        ap.yY();
        com.tencent.mm.u.c.vr().b(this);
    }

    protected final void bOp() {
    }

    protected final void bOq() {
    }

    public final void bOs() {
        if (this.isJ != null) {
            this.isJ.removeAll();
        }
        this.mUX.setAdapter(null);
    }

    public final void bOt() {
        if (this.isJ != null) {
            this.isJ.removeAll();
            this.isJ.addPreferencesFromResource(R.o.ftS);
        }
        this.mUX.setAdapter(this.vrv);
    }

    public final void bOv() {
    }

    public final void bPh() {
    }
}
