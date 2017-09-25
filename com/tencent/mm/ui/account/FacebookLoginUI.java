package com.tencent.mm.ui.account;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;

public class FacebookLoginUI extends MMPreference implements e {
    private String fWY = "";
    private OnCancelListener jrX;
    private String oVk;
    private c uXF = new c<il>(this) {
        final /* synthetic */ FacebookLoginUI uXT;

        {
            this.uXT = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicroMsg.FacebookLoginUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private com.tencent.mm.ui.g.a.c uXO;
    private String uXP = "";
    private u uXQ;
    private b uXR;
    boolean uXS = true;
    private ProgressDialog uXk;

    private final class a implements com.tencent.mm.ui.g.a.c.a {
        final /* synthetic */ FacebookLoginUI uXT;

        public a(FacebookLoginUI facebookLoginUI) {
            this.uXT = facebookLoginUI;
        }

        public final void m(Bundle bundle) {
            this.uXT.uXk = ProgressDialog.show(this.uXT, this.uXT.getString(R.l.dIO), this.uXT.getString(R.l.egX), true);
            this.uXT.uXk.setOnCancelListener(this.uXT.jrX);
            this.uXT.uXP = this.uXT.uXO.vsE;
            w.i("MicroMsg.FacebookLoginUI", "dkwt Ready to Facebook auth user[%s] token[%d][%s]", "facebook@wechat_auth", Integer.valueOf(this.uXT.uXP.length()), this.uXT.uXP.substring(0, 4));
            this.uXT.uXQ = new u("facebook@wechat_auth", this.uXT.uXP, 0, "", "", "", 0, "", true, false);
            ap.vd().a(this.uXT.uXQ, 0);
            FacebookLoginUI.kD(true);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uXT.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
            g.oUh.a(582, 6, 1, false);
        }

        public final void a(d dVar) {
            w.d("MicroMsg.FacebookLoginUI", "onFacebookError:" + dVar.wgk);
            com.tencent.mm.ui.base.g.b(this.uXT, dVar.getMessage(), this.uXT.getString(R.l.dYb), true);
            FacebookLoginUI.kD(false);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uXT.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
            g.oUh.a(582, 7, 1, false);
        }

        public final void a(com.tencent.mm.ui.g.a.b bVar) {
            w.d("MicroMsg.FacebookLoginUI", "onError:" + bVar.getMessage());
            com.tencent.mm.ui.base.g.b(this.uXT, bVar.getMessage(), this.uXT.getString(R.l.dYb), true);
            FacebookLoginUI.kD(false);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uXT.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
            g.oUh.a(582, 8, 1, false);
        }

        public final void onCancel() {
            w.d("MicroMsg.FacebookLoginUI", "onCancel");
            FacebookLoginUI.kD(false);
            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uXT.getClass().getName() + ",L14," + ap.ec("L14") + ",2");
            g.oUh.a(582, 9, 1, false);
        }
    }

    static /* synthetic */ void kD(boolean z) {
        int i = z ? 19 : 20;
        ap.yW().set(i, Integer.valueOf(bg.a((Integer) ap.yW().get(i), 0) + 1));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.bpJ);
        com.tencent.mm.plugin.c.a.imw.ox();
        this.oVk = com.tencent.mm.plugin.c.b.Oz();
        KC();
        ap.vd().a(701, (e) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(701, (e) this);
    }

    protected void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        com.tencent.mm.plugin.c.b.b(true, ap.uY() + "," + getClass().getName() + ",L100_200_FB," + ap.ec("L100_200_FB") + ",1");
        com.tencent.mm.plugin.c.b.mM("L100_200_FB");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",L100_200_FB," + ap.ec("L100_200_FB") + ",2");
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    private void goBack() {
        com.tencent.mm.plugin.c.b.mN(this.oVk);
        finish();
    }

    private void bQL() {
        try {
            if (this.uXO != null) {
                this.uXO.fb(this);
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FacebookLoginUI", e, "", new Object[0]);
        }
        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",L14," + ap.ec("L14") + ",1");
        this.uXO = new com.tencent.mm.ui.g.a.c("290293790992170");
        this.uXO.a((Activity) this, FacebookAuthUI.uXC, new a(this));
        g.oUh.a(582, 5, 1, false);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.FacebookLoginUI", "dkwt onSceneEnd: hash:%d type:%d [%d,%d,%s]", Integer.valueOf(kVar.hashCode()), Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.uXk != null) {
            this.uXk.dismiss();
            this.uXk = null;
        }
        if (bg.bp(this) && (kVar instanceof u)) {
            boolean z;
            this.fWY = ((u) kVar).Jh();
            if (kVar.getType() == 701 && i == 4 && (i2 == -16 || i2 == -17)) {
                ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                    final /* synthetic */ FacebookLoginUI uXT;

                    {
                        this.uXT = r1;
                    }

                    public final void a(com.tencent.mm.network.e eVar) {
                        if (eVar != null) {
                            com.tencent.mm.network.c Cc = eVar.Cc();
                            byte[] bArr = new byte[0];
                            ap.yY();
                            Cc.i(bArr, com.tencent.mm.u.c.uH());
                        }
                    }
                }), 0);
                z = true;
            } else {
                z = false;
            }
            if (z || (i == 0 && i2 == 0)) {
                ap.unhold();
                m.mv("");
                com.tencent.mm.modelsimple.d.bc(this);
                m.a(this, new Runnable(this) {
                    final /* synthetic */ FacebookLoginUI uXT;

                    {
                        this.uXT = r1;
                    }

                    public final void run() {
                        ap.yY();
                        Intent ak;
                        if ((bg.a((Integer) com.tencent.mm.u.c.vr().get(65833, null), 0) > 0 ? 1 : 0) != 0) {
                            ak = com.tencent.mm.plugin.c.a.imv.ak(this.uXT);
                            ak.addFlags(67108864);
                            Intent intent = new Intent(this.uXT.uSU.uTo, BindMContactIntroUI.class);
                            intent.putExtra("key_upload_scene", 1);
                            MMWizardActivity.b(this.uXT, intent, ak);
                        } else {
                            ak = com.tencent.mm.plugin.c.a.imv.ak(this.uXT);
                            ak.addFlags(67108864);
                            this.uXT.startActivity(ak);
                            com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + this.uXT.getClass().getName() + ",L14," + ap.ec("L14") + ",4");
                        }
                        this.uXT.finish();
                    }
                }, false, 2);
            } else if (i2 == -106) {
                m.E(this, str);
            } else if (i2 == -217) {
                m.a(this, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
            } else if (i2 == -6 || i2 == -311 || i2 == -310) {
                if (this.uXR == null) {
                    this.uXR = new b(this) {
                        final /* synthetic */ FacebookLoginUI uXT;

                        {
                            this.uXT = r1;
                        }

                        public final k a(k kVar, String str) {
                            return new u("facebook@wechat_auth", this.uXT.uXP, ((u) kVar).Ji(), str, ((u) kVar).FJ(), ((u) kVar).Jj(), 0, "", true, false);
                        }
                    };
                }
                SecurityImage.b bVar = this.uXR;
                byte[] FI = ((u) kVar).FI();
                bVar.uXd = kVar;
                if (bVar.uUx == null) {
                    bVar.uUx = com.tencent.mm.ui.applet.SecurityImage.a.a(this, R.l.eKg, 0, FI, "", "", new com.tencent.mm.ui.account.b.AnonymousClass1(bVar, this), null, new OnDismissListener(bVar) {
                        final /* synthetic */ b uXe;

                        {
                            this.uXe = r1;
                        }

                        public final void onDismiss(DialogInterface dialogInterface) {
                            this.uXe.uUx = null;
                        }
                    }, bVar);
                } else {
                    bVar.uUx.a(0, FI, "", "");
                }
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -107:
                            com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.eho, R.l.dIO);
                            z = true;
                            break;
                        case -75:
                            m.bo(this.uSU.uTo);
                            z = true;
                            break;
                        case -72:
                            com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.eJZ, R.l.dIO);
                            z = true;
                            break;
                        case -30:
                            if (com.tencent.mm.protocal.d.sYQ) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", this.fWY);
                                intent.putExtra("showShare", false);
                                intent.putExtra("show_bottom", false);
                                intent.putExtra("needRedirect", false);
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                                com.tencent.mm.plugin.c.a.imv.j(intent, this);
                            }
                            z = true;
                            break;
                        case -9:
                            com.tencent.mm.ui.base.g.h(this, R.l.ewM, R.l.ewN);
                            z = true;
                            break;
                        case -7:
                            com.tencent.mm.ui.base.g.h(this.uSU.uTo, R.l.ehn, R.l.dIO);
                            z = true;
                            break;
                        case -1:
                            if (ap.vd().BR() == 5) {
                                com.tencent.mm.ui.base.g.h(this, R.l.eDp, R.l.eDo);
                                z = true;
                                break;
                            }
                        case -4:
                        case -3:
                            com.tencent.mm.ui.base.g.h(this, R.l.efc, R.l.ewN);
                            z = true;
                            break;
                    }
                }
                z = com.tencent.mm.plugin.c.a.imw.a(this.uSU.uTo, i, i2, str);
                if (!z) {
                    if (kVar.getType() == 701) {
                        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
                        if (dn != null && dn.a(this, null, null)) {
                            return;
                        }
                    }
                    Toast.makeText(this, getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        }
    }

    protected final void KC() {
        this.uXO = new com.tencent.mm.ui.g.a.c("290293790992170");
        this.jrX = new OnCancelListener(this) {
            final /* synthetic */ FacebookLoginUI uXT;

            {
                this.uXT = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.uXT.uXQ != null) {
                    ap.vd().c(this.uXT.uXQ);
                }
            }
        };
        bQL();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookLoginUI uXT;

            {
                this.uXT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uXT.goBack();
                return true;
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 0;
        String str = "MicroMsg.FacebookLoginUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Boolean.valueOf(intent == null);
        w.i(str, str2, objArr);
        if (i2 == -1 && i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
            String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
            int intExtra = intent.getIntExtra("KVoiceHelpCode", 0);
            str2 = "MicroMsg.FacebookLoginUI";
            String str3 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d, lastErrCode:%d";
            Object[] objArr2 = new Object[3];
            objArr2[0] = Boolean.valueOf(bg.mA(stringExtra));
            if (!bg.mA(stringExtra)) {
                i3 = stringExtra.length();
            }
            objArr2[1] = Integer.valueOf(i3);
            objArr2[2] = Integer.valueOf(intExtra);
            w.i(str2, str3, objArr2);
            if (intExtra == -217) {
                bQL();
                return;
            }
        }
        this.uXO.e(i, i2, intent);
    }

    public final int ON() {
        return R.o.ftK;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        if (str == null) {
            w.e("MicroMsg.FacebookLoginUI", "onPreferenceTreeClick, key is null");
            return true;
        } else if (!str.equals("facebook_auth_bind_btn")) {
            return false;
        } else {
            bQL();
            return true;
        }
    }
}
