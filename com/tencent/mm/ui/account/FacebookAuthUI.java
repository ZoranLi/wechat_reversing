package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ao.i;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.g;
import com.tencent.mm.modelsimple.h;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookAuthUI extends MMPreference implements e {
    public static final String[] uXC = new String[]{"publish_actions", "email"};
    private f isJ;
    private final Map<String, Preference> jWR = new HashMap();
    private OnCancelListener jrX;
    private boolean uXD = false;
    private boolean uXE = false;
    private c uXF = new c<il>(this) {
        final /* synthetic */ FacebookAuthUI uXG;

        {
            this.uXG = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.FacebookAuthUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private com.tencent.mm.ui.g.a.c uXj;
    private ProgressDialog uXk;
    private g uXl;

    private final class a implements com.tencent.mm.ui.g.a.c.a {
        final /* synthetic */ FacebookAuthUI uXG;

        public a(FacebookAuthUI facebookAuthUI) {
            this.uXG = facebookAuthUI;
        }

        public final void m(Bundle bundle) {
            w.d("MicroMsg.FacebookAuthUI", "token:" + this.uXG.uXj.vsE);
            ap.yY();
            com.tencent.mm.u.c.vr().set(65830, this.uXG.uXj.vsE);
            if (this.uXG.uXj.wgd != 0) {
                ap.yY();
                com.tencent.mm.u.c.vr().set(65832, Long.valueOf(this.uXG.uXj.wgd));
            }
            this.uXG.uXk = ProgressDialog.show(this.uXG, this.uXG.getString(R.l.dIO), this.uXG.getString(R.l.egX), true);
            this.uXG.uXk.setOnCancelListener(this.uXG.jrX);
            this.uXG.uXl = new g(1, this.uXG.uXj.vsE);
            ap.vd().a(this.uXG.uXl, 0);
            FacebookAuthUI.kC(true);
            com.tencent.mm.plugin.report.service.g.oUh.a(582, 1, 1, false);
        }

        public final void a(d dVar) {
            w.d("MicroMsg.FacebookAuthUI", "onFacebookError:" + dVar.wgk);
            com.tencent.mm.ui.base.g.b(this.uXG, dVar.getMessage(), this.uXG.getString(R.l.dYb), true);
            FacebookAuthUI.kC(false);
            com.tencent.mm.plugin.report.service.g.oUh.a(582, 2, 1, false);
        }

        public final void a(com.tencent.mm.ui.g.a.b bVar) {
            w.d("MicroMsg.FacebookAuthUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.g.b(this.uXG, bVar.getMessage(), this.uXG.getString(R.l.dYb), true);
            FacebookAuthUI.kC(false);
            com.tencent.mm.plugin.report.service.g.oUh.a(582, 3, 1, false);
        }

        public final void onCancel() {
            w.d("MicroMsg.FacebookAuthUI", "onCancel");
            FacebookAuthUI.kC(false);
            com.tencent.mm.plugin.report.service.g.oUh.a(582, 4, 1, false);
        }
    }

    static /* synthetic */ void kC(boolean z) {
        List arrayList = new ArrayList();
        arrayList.add(new com.tencent.mm.ao.i.a(32, z ? "0" : "1"));
        ap.yY();
        com.tencent.mm.u.c.wQ().b(new i(arrayList));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.isJ = this.vrv;
        KC();
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        ap.vd().a(183, (e) this);
        ap.vd().a((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
        bQK();
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        ap.vd().b(183, (e) this);
        ap.vd().b((int) com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE, (e) this);
    }

    public final int ON() {
        return R.o.ftJ;
    }

    protected final void KC() {
        this.uXD = getIntent().getBooleanExtra("is_force_unbind", false);
        this.uXj = new com.tencent.mm.ui.g.a.c("290293790992170");
        this.jrX = new OnCancelListener(this) {
            final /* synthetic */ FacebookAuthUI uXG;

            {
                this.uXG = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.uXG.uXl != null) {
                    ap.vd().c(this.uXG.uXl);
                }
            }
        };
        this.isJ.addPreferencesFromResource(R.o.ftJ);
        Preference Td = this.isJ.Td("facebook_auth_tip");
        if (Td != null) {
            this.jWR.put("facebook_auth_tip", Td);
        }
        Td = this.isJ.Td("facebook_auth_cat");
        if (Td != null) {
            this.jWR.put("facebook_auth_cat", Td);
        }
        Td = this.isJ.Td("facebook_auth_bind_btn");
        if (Td != null) {
            this.jWR.put("facebook_auth_bind_btn", Td);
        }
        Td = this.isJ.Td("facebook_auth_account");
        if (Td != null) {
            this.jWR.put("facebook_auth_account", Td);
        }
        Td = this.isJ.Td("facebook_auth_cat2");
        if (Td != null) {
            this.jWR.put("facebook_auth_cat2", Td);
        }
        Td = this.isJ.Td("facebook_auth_unbind_btn");
        if (Td != null) {
            this.jWR.put("facebook_auth_unbind_btn", Td);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookAuthUI uXG;

            {
                this.uXG = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = this.uXG.getIntent();
                intent.putExtra("bind_facebook_succ", this.uXG.uXE);
                this.uXG.setResult(-1, intent);
                this.uXG.finish();
                return true;
            }
        });
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str == null) {
            w.e("MicroMsg.FacebookAuthUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (str.equals("facebook_auth_bind_btn")) {
            try {
                this.uXj.fb(this);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
            }
            this.uXj = new com.tencent.mm.ui.g.a.c("290293790992170");
            this.uXj.a((Activity) this, uXC, new a(this));
            return true;
        } else if (!str.equals("facebook_auth_unbind_btn")) {
            return false;
        } else {
            com.tencent.mm.ui.base.g.a((Context) this, R.l.ehb, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ FacebookAuthUI uXG;

                {
                    this.uXG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.uXG.uXk = ProgressDialog.show(this.uXG, this.uXG.getString(R.l.dIO), this.uXG.getString(R.l.ehd), true);
                    this.uXG.uXk.setOnCancelListener(this.uXG.jrX);
                    ap.vd().a(new h(h.hRN), 0);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FacebookAuthUI uXG;

                {
                    this.uXG = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    private void bQK() {
        this.isJ.removeAll();
        boolean ym = this.uXD ? false : m.ym();
        if (this.jWR.containsKey("facebook_auth_tip")) {
            Preference preference = (Preference) this.jWR.get("facebook_auth_tip");
            preference.setTitle(ym ? R.l.ehc : R.l.egW);
            this.isJ.a(preference);
        }
        if (this.jWR.containsKey("facebook_auth_cat")) {
            this.isJ.a((Preference) this.jWR.get("facebook_auth_cat"));
        }
        if (ym) {
            if (this.jWR.containsKey("facebook_auth_account")) {
                preference = (Preference) this.jWR.get("facebook_auth_account");
                StringBuilder append = new StringBuilder().append(getString(R.l.egY));
                ap.yY();
                preference.setTitle(append.append(com.tencent.mm.u.c.vr().get(65826, null)).toString());
                this.isJ.a(preference);
            }
            if (this.jWR.containsKey("facebook_auth_cat2")) {
                this.isJ.a((Preference) this.jWR.get("facebook_auth_cat2"));
            }
            if (this.jWR.containsKey("facebook_auth_unbind_btn")) {
                this.isJ.a((Preference) this.jWR.get("facebook_auth_unbind_btn"));
            }
        } else if (this.jWR.containsKey("facebook_auth_bind_btn")) {
            this.isJ.a((Preference) this.jWR.get("facebook_auth_bind_btn"));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = "MicroMsg.FacebookAuthUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookAuthUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bg.mA(stringExtra));
            objArr2[1] = Integer.valueOf(bg.mA(stringExtra) ? 0 : stringExtra.length());
            objArr2[2] = Integer.valueOf(intExtra);
            w.i(str2, str3, objArr2);
            if (intExtra == -217) {
                try {
                    this.uXj.fb(this);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FacebookAuthUI", e, "", new Object[0]);
                }
                this.uXj = new com.tencent.mm.ui.g.a.c("290293790992170");
                this.uXj.a((Activity) this, uXC, new a(this));
                return;
            }
        }
        this.uXj.e(i, i2, intent);
    }

    public final void a(int i, int i2, String str, k kVar) {
        com.tencent.mm.f.a dn;
        if (kVar.getType() == com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i.CTRL_BYTE) {
            if (i == 0 && i2 == 0) {
                this.uXl = new g(0, "");
                ap.vd().a(this.uXl, 0);
                return;
            }
            if (this.uXk != null) {
                this.uXk.dismiss();
            }
            if (i2 == -82) {
                com.tencent.mm.ui.base.g.a((Context) this, R.l.eRI, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI uXG;

                    {
                        this.uXG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -83) {
                com.tencent.mm.ui.base.g.a((Context) this, R.l.eRF, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI uXG;

                    {
                        this.uXG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -84) {
                com.tencent.mm.ui.base.g.a((Context) this, R.l.eRG, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI uXG;

                    {
                        this.uXG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -85) {
                com.tencent.mm.ui.base.g.a((Context) this, R.l.eRE, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI uXG;

                    {
                        this.uXG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -86) {
                com.tencent.mm.ui.base.g.a((Context) this, R.l.eRJ, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ FacebookAuthUI uXG;

                    {
                        this.uXG = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (i2 == -106) {
                com.tencent.mm.platformtools.m.E(this, str);
            } else if (i2 == -217) {
                com.tencent.mm.platformtools.m.a(this, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
            } else {
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                }
            }
        } else if (kVar.getType() == 183) {
            if (this.uXk != null) {
                this.uXk.dismiss();
            }
            int i3 = ((g) kVar).opType;
            if (i == 0 && i2 == 0) {
                Toast.makeText(this, i3 == 0 ? R.l.dYf : R.l.dYc, 1).show();
                this.uXD = false;
                bQK();
                if (i3 == 1) {
                    ap.yY();
                    com.tencent.mm.u.c.wW().Rl("facebookapp");
                    ap.yY();
                    com.tencent.mm.u.c.wT().Ao("facebookapp");
                    this.uXE = true;
                }
            } else if (i == 4 && i2 == -67) {
                Toast.makeText(this, R.l.egZ, 1).show();
            } else if (i == 4 && i2 == -5) {
                Toast.makeText(this, i3 == 1 ? R.l.egV : R.l.eha, 1).show();
            } else if (i2 == -106) {
                com.tencent.mm.platformtools.m.E(this, str);
            } else {
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                } else {
                    Toast.makeText(this, i3 == 0 ? R.l.dYe : R.l.dYb, 1).show();
                }
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            Intent intent = getIntent();
            intent.putExtra("bind_facebook_succ", this.uXE);
            setResult(-1, intent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
