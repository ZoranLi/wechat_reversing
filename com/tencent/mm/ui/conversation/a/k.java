package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.az.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.a.e;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;

public final class k extends b {
    protected aw wfk = null;

    public k(Context context, aw awVar) {
        super(context);
        this.wfk = awVar;
        if (this.view != null) {
            OnClickListener anonymousClass3;
            MMImageView mMImageView = (MMImageView) this.view.findViewById(R.h.cgY);
            TextView textView = (TextView) this.view.findViewById(R.h.cgZ);
            switch (this.wfk.type) {
                case 1:
                    mMImageView.setImageResource(R.k.dAk);
                    textView.setText(R.l.dMT);
                    break;
                case 2:
                    mMImageView.setImageResource(R.k.dAl);
                    textView.setText(R.l.ekr);
                    break;
                case 3:
                    mMImageView.setImageResource(R.k.dAj);
                    textView.setText(R.l.dNb);
                    break;
                case 4:
                    mMImageView.setImageResource(R.k.dAq);
                    textView.setText(R.l.dMV);
                    break;
                case 6:
                    mMImageView.setImageResource(R.k.dAm);
                    textView.setText(R.l.dMZ);
                    break;
                case 7:
                    mMImageView.setImageResource(R.k.dAn);
                    textView.setText(R.l.dMY);
                    break;
                case 8:
                    mMImageView.setImageResource(R.k.dAo);
                    textView.setText(R.l.dNa);
                    break;
                case 9:
                    mMImageView.setImageResource(R.k.dAp);
                    textView.setText(R.l.dMW);
                    break;
                case 10:
                    mMImageView.setImageResource(R.k.dAi);
                    textView.setText(R.l.dMS);
                    break;
            }
            View view = this.view;
            final int i = this.wfk.type;
            final int i2 = this.wfk.showType;
            switch (i) {
                case 1:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            k.m((Context) this.wfm.sNB.get(), false);
                        }
                    };
                    break;
                case 2:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            k.m((Context) this.wfm.sNB.get(), true);
                        }
                    };
                    break;
                case 3:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            Context context = (Context) this.wfm.sNB.get();
                            if (context != null) {
                                ap.yY();
                                if (c.isSDCardAvailable()) {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    g.oUh.i(11002, Integer.valueOf(4), Integer.valueOf(1));
                                    return;
                                }
                                s.eP(context);
                            }
                        }
                    };
                    break;
                case 4:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            Context context = (Context) this.wfm.sNB.get();
                            if (context != null) {
                                g.oUh.i(11002, Integer.valueOf(5), Integer.valueOf(1));
                                ap.yY();
                                boolean f = bg.f((Boolean) c.vr().get(4103, null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (f) {
                                    com.tencent.mm.u.bg zM = com.tencent.mm.u.bg.zM();
                                    if (zM == null) {
                                        d.w(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    String mz = bg.mz(zM.getProvince());
                                    int a = bg.a(Integer.valueOf(zM.gkr), 0);
                                    if (bg.mA(mz) || a == 0) {
                                        d.w(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    LauncherUI bPI = LauncherUI.bPI();
                                    if (bPI != null) {
                                        bPI.uRM.SD("tab_find_friend");
                                    }
                                    a.dl(context);
                                    return;
                                }
                                d.w(context, "nearby", ".ui.NearbyFriendsIntroUI");
                            }
                        }
                    };
                    break;
                case 6:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            Context context = (Context) this.wfm.sNB.get();
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            d.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            g.oUh.i(11002, Integer.valueOf(10), Integer.valueOf(1));
                            g.oUh.i(12065, Integer.valueOf(2));
                        }
                    };
                    break;
                case 7:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            d.w((Context) this.wfm.sNB.get(), "game", ".ui.GameCenterUI");
                            g.oUh.i(11002, Integer.valueOf(9), Integer.valueOf(1));
                        }
                    };
                    break;
                case 8:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            int i;
                            ax.zj().aJ(i, i2);
                            Context context = (Context) this.wfm.sNB.get();
                            if ((m.xW() & 65536) == 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                d.w(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            g.oUh.i(11002, Integer.valueOf(11), Integer.valueOf(1));
                        }
                    };
                    break;
                case 9:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            boolean z;
                            ax.zj().aJ(i, i2);
                            Context context = (Context) this.wfm.sNB.get();
                            ap.yY();
                            String str = (String) c.vr().get(68377, null);
                            ap.yY();
                            c.vr().set(68377, "");
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (bg.mA(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (com.tencent.mm.plugin.sns.b.m.pQC != null && com.tencent.mm.plugin.sns.b.m.pQC.Kr() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            d.b(context, "sns", ".ui.En_424b8e16", intent);
                            g.oUh.i(11002, Integer.valueOf(8), Integer.valueOf(1));
                        }
                    };
                    break;
                case 10:
                    anonymousClass3 = new OnClickListener(this) {
                        final /* synthetic */ k wfm;

                        public final void onClick(View view) {
                            ax.zj().aJ(i, i2);
                            d.b((Context) this.wfm.sNB.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                        }
                    };
                    break;
                default:
                    anonymousClass3 = null;
                    break;
            }
            view.setOnClickListener(anonymousClass3);
        }
    }

    public final int getLayoutId() {
        return R.i.dhJ;
    }

    public static void m(Context context, boolean z) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            intent.putExtra("is_bind_for_contact_sync", z);
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.z(context, intent);
            e gu = com.tencent.mm.u.a.g.Ae().gu("4");
            if (gu != null && !bg.mA(gu.value) && (gu.value.equals("1") || gu.value.equals("2"))) {
                com.tencent.mm.u.a.g.Ae().gu("4").result = "1";
                f.gz("4");
                if (gu.value.equals("1")) {
                    ap.yY();
                    c.vr().set(328195, Boolean.valueOf(true));
                    return;
                }
                ap.yY();
                c.vr().set(328196, Boolean.valueOf(true));
            } else if (z) {
                g.oUh.i(11002, Integer.valueOf(3), Integer.valueOf(1));
            } else {
                g.oUh.i(11002, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
    }

    public final void destroy() {
    }
}
