package com.tencent.mm.ui.account;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.plugin.accountsync.ui.InviteFacebookFriendsUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.mm.x.d.a;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;

@Deprecated
public class FacebookFriendUI extends MMActivity implements a, e {
    private ListView iss;
    private View isu;
    private ProgressDialog isv = null;
    String isw;
    private boolean nhO = false;
    d uXL;
    private TextView uXM = null;

    static /* synthetic */ void f(FacebookFriendUI facebookFriendUI) {
        w.e("MicroMsg.FacebookFriendUI", "dealWithRefreshTokenFail");
        facebookFriendUI.av(facebookFriendUI.getString(R.l.dIO), facebookFriendUI.getString(R.l.ehf));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eka);
        ap.vd().a(32, (e) this);
        KC();
    }

    protected void onResume() {
        super.onResume();
        n.Bl().d(this);
        this.uXL.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
        n.Bl().e(this);
    }

    public void onDestroy() {
        ap.vd().b(32, (e) this);
        this.uXL.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dcQ;
    }

    protected final void KC() {
        this.iss = (ListView) findViewById(R.h.ckw);
        this.uXM = (TextView) findViewById(R.h.bLP);
        this.uXM.setText(R.l.ehg);
        final TextView textView = (TextView) findViewById(R.h.bLU);
        textView.setText(R.l.ehe);
        p pVar = new p(true, true);
        pVar.woe = new b(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                this.uXN.isw = bg.my(str);
                FacebookFriendUI facebookFriendUI = this.uXN;
                if (facebookFriendUI.uXL != null) {
                    facebookFriendUI.uXL.yD(facebookFriendUI.isw);
                }
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final void OF() {
            }

            public final void OG() {
            }
        };
        a(pVar);
        this.uXL = new d(this, new k.a(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            public final void OH() {
                if (m.ym() && this.uXN.nhO) {
                    if (this.uXN.uXL.getCount() == 0) {
                        textView.setVisibility(0);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                this.uXN.nhO = false;
            }

            public final void OI() {
            }
        });
        this.uXL.uXH = new d.a(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final void zA(int i) {
                if (i > 0) {
                    this.uXN.uXM.setVisibility(8);
                } else {
                    this.uXN.uXM.setVisibility(0);
                }
            }
        };
        this.iss.setAdapter(this.uXL);
        this.isu = findViewById(R.h.ckx);
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                h hVar = (h) this.uXN.uXL.getItem(i - this.uXN.iss.getHeaderViewsCount());
                if (hVar.status == 100 || hVar.status == 101) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", hVar.getUsername());
                    intent.putExtra("Contact_Nick", hVar.EU());
                    intent.putExtra("Contact_KFacebookId", hVar.gkt);
                    intent.putExtra("Contact_KFacebookName", hVar.Fd());
                    intent.putExtra("Contact_Scene", 31);
                    com.tencent.mm.plugin.c.a.imv.d(intent, this.uXN);
                }
                if (hVar.status != 102) {
                }
            }
        });
        w.d("MicroMsg.FacebookFriendUI", "isBindForFacebookApp:" + m.ym());
        if (m.ym()) {
            this.iss.setVisibility(0);
            this.isu.setVisibility(8);
            ap.yY();
            long c = bg.c((Long) c.vr().get(65831, null));
            ap.yY();
            String mz = bg.mz((String) c.vr().get(65830, null));
            if (bg.aA(c) > 86400000 && mz.length() > 0) {
                com.tencent.mm.ui.g.a.c cVar = new com.tencent.mm.ui.g.a.c("290293790992170");
                cVar.TX(mz);
                new h(cVar, new com.tencent.mm.v.a(this) {
                    final /* synthetic */ FacebookFriendUI uXN;

                    {
                        this.uXN = r1;
                    }

                    public final void m(Bundle bundle) {
                        super.m(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            FacebookFriendUI.f(this.uXN);
                        }
                    }
                }).bQS();
            }
            final com.tencent.mm.y.k vVar = new v();
            vVar.FH();
            final aj ajVar = new aj(new aj.a(this) {
                final /* synthetic */ FacebookFriendUI uXN;

                public final boolean oQ() {
                    ap.yY();
                    c.vr().set(65829, Integer.valueOf(1));
                    ap.vd().a(vVar, 0);
                    return false;
                }
            }, false);
            ap.yY();
            if (bg.f((Integer) c.vr().get(65829, null)) > 0) {
                ap.yY();
                c.vr().set(65829, Integer.valueOf(1));
                ap.vd().a(vVar, 0);
            } else {
                ajVar.v(5000, 5000);
            }
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.eHh), true, new OnCancelListener(this) {
                final /* synthetic */ FacebookFriendUI uXN;

                public final void onCancel(DialogInterface dialogInterface) {
                    ajVar.KH();
                    ap.vd().c(vVar);
                }
            });
            a(0, getString(R.l.ekb), new OnMenuItemClickListener(this) {
                final /* synthetic */ FacebookFriendUI uXN;

                {
                    this.uXN = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.uXN.startActivity(new Intent(this.uXN, InviteFacebookFriendsUI.class));
                    return true;
                }
            });
        } else {
            this.iss.setVisibility(8);
            this.isu.setVisibility(0);
            ((TextView) findViewById(R.h.cky)).setText(R.l.ejU);
            this.isu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FacebookFriendUI uXN;

                {
                    this.uXN = r1;
                }

                public final void onClick(View view) {
                    this.uXN.startActivity(new Intent(this.uXN, FacebookAuthUI.class));
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uXN.aHf();
                this.uXN.finish();
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.uXN.iss);
            }
        };
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.FacebookFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 4 && i2 == -68) {
                if (bg.mA(str)) {
                    str = "error";
                }
                av(getString(R.l.dIO), str);
            } else if (i == 0 && i2 == 0) {
                this.uXL.a(null, null);
            } else {
                Toast.makeText(this, R.l.eBa, 0).show();
            }
        }
    }

    private void av(String str, String str2) {
        g.a((Context) this, str2, str, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ FacebookFriendUI uXN;

            {
                this.uXN = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.uXN.uSU.uTo, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.uXN.uSU.uTo.startActivity(intent);
                this.uXN.finish();
            }
        }, null);
    }

    public final void ho(String str) {
        this.uXL.notifyDataSetChanged();
    }
}
