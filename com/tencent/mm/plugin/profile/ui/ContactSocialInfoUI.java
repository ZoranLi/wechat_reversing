package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.i.g;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.x.d;
import com.tencent.mm.x.e;
import com.tencent.mm.x.n;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.json.JSONObject;

public class ContactSocialInfoUI extends MMPreference {
    private String fSf;
    private f jid;
    private x kWy;
    private b otG;
    private String otH;
    private String otI;
    private String otJ;
    private String otK;
    private String otL;
    private String otM;
    private String otN;
    private JSONObject otO;
    private long otx;
    private String oty;

    static /* synthetic */ void a(ContactSocialInfoUI contactSocialInfoUI, final String str, final String str2) {
        if (bg.mA(str) || bg.mA(str2)) {
            Toast.makeText(contactSocialInfoUI.uSU.uTo, contactSocialInfoUI.uSU.uTo.getString(R.l.dZt), 0).show();
            return;
        }
        n.Bl();
        Bitmap hl = d.hl(str);
        if (hl == null) {
            Toast.makeText(contactSocialInfoUI.uSU.uTo, contactSocialInfoUI.uSU.uTo.getString(R.l.dZu), 0).show();
            final e eVar = new e();
            eVar.a(str, new e.b(contactSocialInfoUI) {
                final /* synthetic */ ContactSocialInfoUI otP;

                public final int aM(int i, int i2) {
                    eVar.Bp();
                    w.i("MicroMsg.ContactSocialInfoUI", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        n.Bl();
                        if (this.otP.p(str2, d.hl(str))) {
                            Toast.makeText(this.otP.uSU.uTo, this.otP.uSU.uTo.getString(R.l.dZv), 0).show();
                            return 0;
                        }
                    }
                    Toast.makeText(this.otP.uSU.uTo, this.otP.uSU.uTo.getString(R.l.dZt), 0).show();
                    return 0;
                }
            });
        } else if (contactSocialInfoUI.p(str2, hl)) {
            Toast.makeText(contactSocialInfoUI.uSU.uTo, contactSocialInfoUI.uSU.uTo.getString(R.l.dZv), 0).show();
        } else {
            Toast.makeText(contactSocialInfoUI.uSU.uTo, contactSocialInfoUI.uSU.uTo.getString(R.l.dZt), 0).show();
        }
    }

    public final int ON() {
        return R.o.ftG;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSf = bg.mz(getIntent().getStringExtra("Contact_User"));
        ap.yY();
        this.kWy = c.wR().Rc(this.fSf);
        KC();
    }

    protected final void KC() {
        zi(R.l.dZH);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactSocialInfoUI otP;

            {
                this.otP = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.otP.finish();
                return true;
            }
        });
        this.jid = this.vrv;
        String stringExtra = getIntent().getStringExtra("Contact_Mobile_MD5");
        String stringExtra2 = getIntent().getStringExtra("Contact_full_Mobile_MD5");
        if (bg.mA(stringExtra) && bg.mA(stringExtra2)) {
            if (bg.mA(this.kWy.field_username)) {
                this.otG = af.FY().iZ(this.fSf);
            } else {
                this.otG = af.FY().iZ(this.kWy.field_username);
            }
        } else if ((stringExtra != null && stringExtra.length() > 0) || (stringExtra2 != null && stringExtra2.length() > 0)) {
            this.otG = af.FY().ja(stringExtra);
            if (this.otG == null || this.otG.EP() == null || this.otG.EP().length() <= 0) {
                this.otG = af.FY().ja(stringExtra2);
                if (!(this.otG == null || this.otG.EP() == null)) {
                    this.otG.EP().length();
                }
            }
        }
        if (this.otG == null || this.otG.EP() == null || this.otG.EP().length() <= 0) {
            w.e("MicroMsg.ContactSocialInfoUI", "error : this is not the mobile contact, MD5 = " + this.otH);
        } else {
            this.otI = bg.mz(this.otG.ER()) + " " + bg.mz(this.otG.EX()).replace(" ", "");
        }
        l("contact_info_social_mobile", this.otI, true);
        ap.yY();
        int f = bg.f((Integer) c.vr().get(9, null));
        this.otx = getIntent().getLongExtra("Contact_Uin", 0);
        this.oty = getIntent().getStringExtra("Contact_QQNick");
        if (!(this.otx == 0 || f == 0)) {
            if (this.oty == null || this.oty.length() == 0) {
                ad af = af.Gd().af(this.otx);
                if (af == null) {
                    af = null;
                }
                if (af != null) {
                    this.oty = af.getDisplayName();
                }
            }
            this.otJ = bg.mz(this.oty);
            this.otJ += " " + new o(this.otx).longValue();
        }
        l("contact_info_social_qq", this.otJ, true);
        stringExtra = g.sV().getValue("LinkedinPluginClose");
        boolean z = bg.mA(stringExtra) || Integer.valueOf(stringExtra).intValue() == 0;
        if (!z || bg.mA(this.kWy.gkM)) {
            this.otK = "";
        } else {
            this.otK = this.kWy.gkN;
        }
        l("contact_info_social_linkedin", this.otK, true);
        l("contact_info_social_facebook", this.otL, false);
        this.otN = bg.ap(getIntent().getStringExtra("verify_gmail"), "");
        this.otM = bg.ap(getIntent().getStringExtra("profileName"), bg.Qi(this.otN));
        if (bg.mA(this.otN) || bg.mA(this.otM)) {
            l("contact_info_social_googlecontacts", "", false);
        } else {
            l("contact_info_social_googlecontacts", this.otM + '\n' + this.otN, false);
        }
        if (m.xL().equals(this.kWy.field_username)) {
            ap.yY();
            stringExtra = (String) c.vr().get(a.uCg, null);
            w.i("MicroMsg.ContactSocialInfoUI", "in self social info page, weishop info:%s", new Object[]{stringExtra});
        } else {
            stringExtra = this.kWy.gkP;
            w.i("MicroMsg.ContactSocialInfoUI", "weiShopInfo:%s", new Object[]{stringExtra});
        }
        if (!bg.mA(stringExtra)) {
            try {
                this.otO = new JSONObject(stringExtra);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ContactSocialInfoUI", e, "", new Object[0]);
                this.otO = null;
            }
        }
        if (this.otO != null) {
            l("contact_info_social_weishop", this.otO.optString("ShopName"), true);
        } else {
            l("contact_info_social_weishop", "", false);
        }
    }

    private void l(String str, String str2, boolean z) {
        if (bg.mA(str2) || bg.mA(str)) {
            this.jid.Te(str);
            return;
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) this.jid.Td(str);
        if (keyValuePreference != null) {
            keyValuePreference.vro = true;
            keyValuePreference.vrq = 5;
            if (z) {
                keyValuePreference.krt = getResources().getColor(R.e.aUA);
            }
            keyValuePreference.setSummary(str2);
            keyValuePreference.kZ(false);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        w.i("MicroMsg.ContactSocialInfoUI", str + " item has been clicked!");
        if (str.equals("contact_info_social_mobile")) {
            if (!(this.otG == null || this.kWy == null)) {
                ap.yY();
                if (c.wR().QY(this.otG.getUsername())) {
                    String[] stringArray = (this.otG == null || bg.mA(this.otG.hrv)) ? getResources().getStringArray(R.c.aSn) : getResources().getStringArray(R.c.aSm);
                    if (com.tencent.mm.plugin.profile.a.imw.oz()) {
                        List f = bg.f(stringArray);
                        f.add(getResources().getString(R.l.dUX));
                        stringArray = (String[]) f.toArray(new String[f.size()]);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                    }
                    com.tencent.mm.ui.base.g.a(this, null, stringArray, null, new com.tencent.mm.ui.base.g.c(this) {
                        final /* synthetic */ ContactSocialInfoUI otP;

                        public final void hq(int i) {
                            switch (i) {
                                case 0:
                                    if (this.otP.otI != null && this.otP.otI.length() != 0) {
                                        int lastIndexOf = this.otP.otI.lastIndexOf(32) + 1;
                                        if (lastIndexOf > 0) {
                                            this.otP.CC(this.otP.otI.substring(lastIndexOf));
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 1:
                                    if (this.otP.otI != null && this.otP.otI.length() != 0) {
                                        String substring = this.otP.otI.substring(0, this.otP.otI.lastIndexOf(32));
                                        if (substring != null && substring.length() != 0) {
                                            com.tencent.mm.u.o.b(this.otP.kWy, substring.trim());
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                case 2:
                                    if (stringArray != null && stringArray.length > 2 && this.otP.otG != null && this.otP.kWy != null) {
                                        if (!(this.otP.otG == null || bg.mA(this.otP.otG.hrv))) {
                                            ContactSocialInfoUI.a(this.otP, this.otP.kWy.field_username, this.otP.otG.hrv);
                                            return;
                                        }
                                    }
                                    return;
                                    break;
                                case 3:
                                    break;
                                default:
                                    return;
                            }
                            Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putInt("fromScene", 2);
                            intent.putExtra("reportArgs", bundle);
                            com.tencent.mm.plugin.profile.a.imv.k(intent, this.otP);
                        }
                    });
                } else if (!(this.otI == null || this.otI.length() == 0)) {
                    int lastIndexOf = this.otI.lastIndexOf(32) + 1;
                    if (lastIndexOf > 0) {
                        CC(this.otI.substring(lastIndexOf));
                    }
                }
            }
        } else if (!str.equals("contact_info_social_qq")) {
            if (str.equals("contact_info_social_linkedin")) {
                str = this.kWy.gkO;
                if (bg.mA(str)) {
                    w.e("MicroMsg.ContactSocialInfoUI", "this liurl is null!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("geta8key_username", m.xL());
                    com.tencent.mm.bb.d.b(this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                }
            } else if (!(str.equals("contact_info_social_facebook") || str.equals("contact_info_social_googlecontacts") || !str.equals("contact_info_social_weishop") || this.otO == null)) {
                ap.yY();
                if (c.vr().get(a.uCH, null) == null) {
                    com.tencent.mm.ui.base.g.a(this, R.l.dZI, R.l.dIO, new OnClickListener(this) {
                        final /* synthetic */ ContactSocialInfoUI otP;

                        {
                            this.otP = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.otP.aTx();
                            ap.yY();
                            c.vr().a(a.uCH, Integer.valueOf(1));
                        }
                    }, null);
                } else {
                    aTx();
                }
            }
        }
        return false;
    }

    private boolean p(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return com.tencent.mm.modelfriend.m.a(str, this.uSU.uTo, byteArrayOutputStream.toByteArray());
    }

    private void CC(String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
        startActivity(intent);
    }

    private void aTx() {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", this.otO.optString("ShopUrl"));
        intent.putExtra("geta8key_username", m.xL());
        com.tencent.mm.bb.d.b(this.uSU.uTo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }
}
