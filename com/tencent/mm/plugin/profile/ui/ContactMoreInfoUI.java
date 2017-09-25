package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.g;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class ContactMoreInfoUI extends MMActivity implements j {
    private String gLD;
    private ae handler = new ae(Looper.getMainLooper());
    private x kWy;
    q ktr;
    private String kuC;
    boolean kuU = false;
    private String mKf;
    private ProfileNormalItemView otn;
    private ProfileNormalItemView oto;
    private ProfileNormalItemView otp;
    private ProfileNormalItemView otq;
    private ProfileNormalItemView otr;
    private ProfileNormalItemView ots;
    private ProfileNormalItemView ott;
    private String otu;
    private String otv;
    private String otw;
    private long otx;
    private String oty;
    String otz = null;

    protected final int getLayoutId() {
        return R.i.cZx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        aTw();
        KC();
    }

    protected final void KC() {
        ProfileNormalItemView profileNormalItemView;
        boolean z = false;
        super.KC();
        this.otn = (ProfileNormalItemView) findViewById(R.h.cbo);
        this.oto = (ProfileNormalItemView) findViewById(R.h.bVu);
        this.otp = (ProfileNormalItemView) findViewById(R.h.ctC);
        this.ots = (ProfileNormalItemView) findViewById(R.h.cFw);
        this.ots.oqx.setSingleLine(false);
        this.ott = (ProfileNormalItemView) findViewById(R.h.bSc);
        this.otr = (ProfileNormalItemView) findViewById(R.h.cSP);
        this.otq = (ProfileNormalItemView) findViewById(R.h.bEq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactMoreInfoUI otA;

            {
                this.otA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.otA.finish();
                return true;
            }
        });
        aTw();
        ap.yY();
        this.ktr = c.xa().fV(this.kuC);
        String value = g.sV().getValue("LinkedinPluginClose");
        boolean z2 = bg.mA(value) || Integer.valueOf(value).intValue() == 0;
        boolean z3;
        if (!z2 || bg.mA(this.kWy.gkM)) {
            this.otn.setVisibility(8);
            z3 = false;
        } else {
            this.otn.setVisibility(0);
            if (bg.mA(this.otu)) {
                this.otu = this.kWy.gkN;
            }
            profileNormalItemView = this.otn;
            profileNormalItemView.owe = this.otu;
            profileNormalItemView.owf = new OnClickListener(this) {
                final /* synthetic */ ContactMoreInfoUI otA;

                {
                    this.otA = r1;
                }

                public final void onClick(View view) {
                    if (bg.mA(this.otA.otv)) {
                        this.otA.otv = this.otA.kWy.gkO;
                    }
                    if (!bg.mA(this.otA.otv)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.otA.otv);
                        intent.putExtra("geta8key_username", m.xL());
                        d.b(this.otA, "webview", ".ui.tools.WebViewUI", intent);
                    }
                }
            };
            z3 = profileNormalItemView.rw(getResources().getColor(R.e.aVs)).aTR();
        }
        this.oto.setVisibility(0);
        profileNormalItemView = this.oto;
        profileNormalItemView.owe = this.mKf;
        boolean aTR = profileNormalItemView.aTR();
        ap.yY();
        int f = bg.f((Integer) c.vr().get(9, null));
        this.otx = getIntent().getLongExtra("Contact_Uin", 0);
        this.oty = getIntent().getStringExtra("Contact_QQNick");
        boolean z4;
        if (this.otx == 0 || f == 0) {
            this.otp.setVisibility(8);
            z4 = false;
        } else {
            if (this.oty == null || this.oty.length() == 0) {
                ad af = af.Gd().af(this.otx);
                if (af == null) {
                    af = null;
                }
                if (af != null) {
                    this.oty = af.getDisplayName();
                }
            }
            CharSequence charSequence = bg.mz(this.oty) + " " + new o(this.otx).longValue();
            this.otp.setVisibility(0);
            ProfileNormalItemView profileNormalItemView2 = this.otp;
            profileNormalItemView2.owe = charSequence;
            profileNormalItemView2.owf = new OnClickListener(this) {
                final /* synthetic */ ContactMoreInfoUI otA;

                {
                    this.otA = r1;
                }

                public final void onClick(View view) {
                }
            };
            z4 = profileNormalItemView2.aTR();
        }
        profileNormalItemView = this.ots;
        profileNormalItemView.owe = h.a(this, this.kWy.signature);
        boolean aTR2 = profileNormalItemView.aTR();
        switch (this.kWy.getSource()) {
            case 1:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.eaa);
                    break;
                } else {
                    this.ott.rv(R.l.eab);
                    break;
                }
            case 3:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.eac);
                    break;
                } else {
                    this.ott.rv(R.l.ead);
                    break;
                }
            case 4:
            case 12:
                this.ott.rv(R.l.ekX);
                break;
            case 8:
            case 14:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZP);
                    break;
                } else {
                    this.ott.rv(R.l.dZQ);
                    break;
                }
            case 10:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.eag);
                    break;
                } else {
                    this.ott.rv(R.l.eah);
                    break;
                }
            case 13:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.eag);
                    break;
                } else {
                    this.ott.rv(R.l.eah);
                    break;
                }
            case 15:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZY);
                    break;
                } else {
                    this.ott.rv(R.l.dZZ);
                    break;
                }
            case 17:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZM);
                    break;
                } else {
                    this.ott.rv(R.l.dZO);
                    break;
                }
            case 18:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZS);
                    break;
                } else {
                    this.ott.rv(R.l.dZT);
                    break;
                }
            case 22:
            case 23:
            case 24:
            case 26:
            case 27:
            case 28:
            case JsApiChooseImage.CTRL_INDEX /*29*/:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.eae);
                    break;
                } else {
                    this.ott.rv(R.l.eaf);
                    break;
                }
            case 25:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZK);
                    break;
                } else {
                    this.ott.rv(R.l.dZL);
                    break;
                }
            case 30:
                if (this.kWy.tN() <= Constants.MAX_BUFFER_SIZE) {
                    this.ott.rv(R.l.dZV);
                    break;
                } else {
                    this.ott.rv(R.l.dZW);
                    break;
                }
            case 34:
                this.ott.rv(R.l.dZJ);
                break;
            case 48:
                this.ott.rv(R.l.dZX);
                break;
            case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
            case bc.CTRL_INDEX /*59*/:
            case 60:
                this.ott.rv(R.l.epO);
                break;
            case 76:
                this.ott.rv(R.l.dZU);
                break;
            default:
                this.ott.owe = null;
                break;
        }
        boolean aTR3 = this.ott.aTR();
        boolean G = G(this.kWy);
        if (!this.kWy.field_username.equals(m.xL())) {
            com.tencent.mm.e.b.af afVar = this.kWy;
            if (afVar.field_username.equals(m.xL())) {
                this.otq.setVisibility(8);
            } else {
                if (afVar.gkr == 1) {
                    this.otq.ru(R.l.dXT);
                } else if (afVar.gkr == 2) {
                    this.otq.ru(R.l.dXS);
                } else {
                    this.otq.ru(R.l.dXV);
                }
                this.otq.aTR();
                f fVar = new f();
                fVar.fRM = afVar.field_username;
                fVar.mag = this;
                fVar.handler = this.handler;
                fVar.lZZ = 5;
                ((l) com.tencent.mm.kernel.h.j(l.class)).search(2, fVar);
                z = true;
            }
        }
        if (!aTR2 && !aTR3 && !G && !r1 && !aTR && !r3 && !r2) {
            finish();
        }
    }

    private boolean G(x xVar) {
        String str;
        CharSequence optString;
        if (m.xL().equals(xVar.field_username)) {
            ap.yY();
            str = (String) c.vr().get(a.uCg, null);
        } else {
            str = xVar.gkP;
        }
        if (!bg.mA(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.otz = jSONObject.optString("ShopUrl");
                optString = jSONObject.optString("ShopName");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ContactMoreInfoUI", e, "", new Object[0]);
            }
            if (bg.mA(this.otz)) {
                this.otr.setVisibility(0);
                this.otr.owe = optString;
                this.otr.rw(getResources().getColor(R.e.aVs));
                ProfileNormalItemView profileNormalItemView = this.otr;
                profileNormalItemView.owf = new OnClickListener(this) {
                    final /* synthetic */ ContactMoreInfoUI otA;

                    {
                        this.otA = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", this.otA.otz);
                        intent.putExtra("geta8key_username", m.xL());
                        d.b(this.otA, "webview", ".ui.tools.WebViewUI", intent);
                    }
                };
                profileNormalItemView.aTR();
                return true;
            }
            this.otr.setVisibility(8);
            return false;
        }
        optString = null;
        if (bg.mA(this.otz)) {
            this.otr.setVisibility(8);
            return false;
        }
        this.otr.setVisibility(0);
        this.otr.owe = optString;
        this.otr.rw(getResources().getColor(R.e.aVs));
        ProfileNormalItemView profileNormalItemView2 = this.otr;
        profileNormalItemView2.owf = /* anonymous class already generated */;
        profileNormalItemView2.aTR();
        return true;
    }

    private void aTw() {
        this.kuU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.kuC = getIntent().getStringExtra("Contact_ChatRoomId");
        this.gLD = getIntent().getStringExtra("Contact_User");
        ap.yY();
        this.kWy = c.wR().Rc(this.gLD);
        this.otu = getIntent().getStringExtra("KLinkedInAddFriendNickName");
        this.otv = getIntent().getStringExtra("KLinkedInAddFriendPubUrl");
        this.mKf = getIntent().getStringExtra("verify_gmail");
        this.otw = getIntent().getStringExtra("profileName");
    }

    public final void a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        if (gVar.aMA == 0) {
            int intValue = ((Integer) ((i) gVar.maj.get(0)).userData).intValue();
            this.otq.owe = getString(R.l.dXU, new Object[]{Integer.valueOf(intValue)});
            if (intValue > 0) {
                this.otq.owf = new OnClickListener(this) {
                    final /* synthetic */ ContactMoreInfoUI otA;

                    {
                        this.otA = r1;
                    }

                    public final void onClick(View view) {
                        Intent intent = new Intent(this.otA, CommonChatroomInfoUI.class);
                        intent.putExtra("Select_Talker_Name", this.otA.kWy.field_username);
                        this.otA.startActivity(intent);
                    }
                };
            }
        } else {
            this.otq.owe = getString(R.l.dXU, new Object[]{Integer.valueOf(0)});
        }
        this.otq.aTR();
    }
}
