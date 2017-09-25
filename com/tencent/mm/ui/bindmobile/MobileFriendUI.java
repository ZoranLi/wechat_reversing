package com.tencent.mm.ui.bindmobile;

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
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.modelfriend.aa;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.m.a;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.InviteFriendUI;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.y.e;
import java.util.List;

public class MobileFriendUI extends MMActivity implements e {
    private ListView iss;
    private View isu;
    private ProgressDialog isv = null;
    String isw;
    private TextView jWk = null;
    private TextView uXM = null;
    a vuF;
    private aa vuG;

    static /* synthetic */ void e(MobileFriendUI mobileFriendUI) {
        if (m.Fl() != a.SUCC && m.Fl() != a.SUCC_UNLOAD) {
            mobileFriendUI.isu.setVisibility(0);
            mobileFriendUI.isu.setOnClickListener(new OnClickListener(mobileFriendUI) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void onClick(View view) {
                    MMWizardActivity.z(this.vuH, new Intent(this.vuH, BindMContactIntroUI.class));
                }
            });
            mobileFriendUI.iss.setVisibility(8);
            mobileFriendUI.jWk.setVisibility(8);
        } else if (mobileFriendUI.vuF.getCount() <= 0) {
            mobileFriendUI.jWk.setVisibility(0);
            mobileFriendUI.iss.setVisibility(8);
            mobileFriendUI.isu.setVisibility(8);
        } else {
            mobileFriendUI.jWk.setVisibility(8);
            mobileFriendUI.iss.setVisibility(0);
            mobileFriendUI.isu.setVisibility(8);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.eBc);
        af.FY().hnH.eE("qqlist", "update addr_upload2 set reserved4=0");
        ap.vd().a(32, (e) this);
        ap.vd().a((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
        KC();
        w.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)));
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            aOI();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    aOI();
                    return;
                } else {
                    g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ MobileFriendUI vuH;

                        {
                            this.vuH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vuH.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.vuH.finish();
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ MobileFriendUI vuH;

                        {
                            this.vuH = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.vuH.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    private void aOI() {
        if (!m.Fk()) {
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.eBb), true, new OnCancelListener(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.vuH.vuG != null) {
                        ap.vd().c(this.vuH.vuG);
                    }
                }
            });
            if (this.vuF.getCount() != 0) {
                List Fs = m.Fs();
                List Fr = m.Fr();
                if (Fs.size() == 0 && Fr.size() == 0) {
                    ap.vd().a(new v(), 0);
                    return;
                }
                this.vuG = new aa(m.Fs(), m.Fr());
                ap.vd().a(this.vuG, 0);
            } else if (!com.tencent.mm.modelfriend.a.a(new b(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void bg(boolean z) {
                    w.i("MicroMsg.MobileFriendUI", "syncAddrBookAndUpload onSyncEnd suc:%b", Boolean.valueOf(z));
                    if (z) {
                        System.currentTimeMillis();
                        ap.vd().a(new aa(m.Fs(), m.Fr()), 0);
                    } else if (this.vuH.isv != null) {
                        this.vuH.isv.dismiss();
                        this.vuH.isv = null;
                    }
                }
            }) && this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.vuF.notifyDataSetChanged();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        f.gz("2");
        ap.vd().b(32, (e) this);
        ap.vd().b((int) com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX, (e) this);
        this.vuF.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.djv;
    }

    protected final void KC() {
        boolean z;
        this.jWk = (TextView) findViewById(R.h.cku);
        this.jWk.setText(R.l.eAZ);
        this.uXM = (TextView) findViewById(R.h.bLT);
        this.uXM.setText(R.l.eBe);
        this.isu = findViewById(R.h.ckx);
        this.iss = (ListView) findViewById(R.h.ckw);
        p pVar = new p(true, true);
        pVar.woe = new p.b(this) {
            final /* synthetic */ MobileFriendUI vuH;

            {
                this.vuH = r1;
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                this.vuH.isw = bg.my(str);
                MobileFriendUI mobileFriendUI = this.vuH;
                if (mobileFriendUI.vuF != null) {
                    mobileFriendUI.vuF.yD(mobileFriendUI.isw);
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
        if (com.tencent.mm.u.a.g.Ae().gu("2") != null) {
            String str = com.tencent.mm.u.a.g.Ae().gu("2").value;
            if (str.equals("0")) {
                z = false;
            } else if (str.equals("1")) {
                z = true;
            } else {
                z = true;
            }
            f.gy("2");
        } else {
            z = true;
        }
        w.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", Boolean.valueOf(z));
        if (z) {
            this.vuF = new c(this, new k.a(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void OI() {
                }

                public final void OH() {
                    MobileFriendUI mobileFriendUI = this.vuH;
                    this.vuH.vuF.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        } else {
            this.vuF = new b(this, new k.a(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void OI() {
                }

                public final void OH() {
                    MobileFriendUI mobileFriendUI = this.vuH;
                    this.vuH.vuF.getCount();
                    MobileFriendUI.e(mobileFriendUI);
                }
            });
        }
        this.iss.setAdapter(this.vuF);
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MobileFriendUI vuH;

            {
                this.vuH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.vuH.iss.getHeaderViewsCount()) {
                    com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) this.vuH.vuF.getItem(i - this.vuH.iss.getHeaderViewsCount());
                    if (bVar.status == 1 || bVar.status == 2) {
                        this.vuH.b(bVar);
                    }
                    if (bVar.status == 0) {
                        Intent intent = new Intent(this.vuH, InviteFriendUI.class);
                        intent.putExtra("friend_type", 1);
                        intent.putExtra("friend_user_name", bVar.getUsername());
                        intent.putExtra("friend_num", bVar.EX());
                        intent.putExtra("friend_nick", bVar.ER());
                        intent.putExtra("friend_weixin_nick", bVar.EU());
                        intent.putExtra("friend_scene", 13);
                        this.vuH.startActivity(intent);
                    }
                }
            }
        });
        this.vuF.a(new a.a(this) {
            final /* synthetic */ MobileFriendUI vuH;

            {
                this.vuH = r1;
            }

            public final void zA(int i) {
                if (i > 0) {
                    this.vuH.uXM.setVisibility(8);
                } else {
                    this.vuH.uXM.setVisibility(0);
                }
            }
        });
        if (!(m.Fl() == a.SUCC || m.Fl() == a.SUCC_UNLOAD)) {
            this.isu = findViewById(R.h.ckx);
            this.isu.setVisibility(0);
            this.isu.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.vuH.uSU.uTo, BindMContactIntroUI.class);
                    intent.putExtra("key_upload_scene", 6);
                    MMWizardActivity.z(this.vuH, intent);
                }
            });
            this.iss.setVisibility(8);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileFriendUI vuH;

            {
                this.vuH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vuH.aHf();
                this.vuH.finish();
                return true;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ MobileFriendUI vuH;

            {
                this.vuH = r1;
            }

            public final void onClick(View view) {
                c.a(this.vuH.iss);
            }
        };
        if (!com.tencent.mm.u.m.yo() || m.Fk()) {
            g.a((Context) this, R.l.dNj, R.l.dIO, R.l.dHT, R.l.dGs, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11438, Integer.valueOf(6));
                    w.i("MicroMsg.MobileFriendUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(6));
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12322, Boolean.valueOf(true));
                    com.tencent.mm.platformtools.m.f(true, true);
                    this.vuH.aOI();
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ MobileFriendUI vuH;

                {
                    this.vuH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(12322, Boolean.valueOf(false));
                    com.tencent.mm.platformtools.m.f(false, true);
                    this.vuH.finish();
                }
            });
        }
    }

    public final void b(com.tencent.mm.modelfriend.b bVar) {
        if (bg.mA(bVar.getUsername())) {
            w.e("MicroMsg.MobileFriendUI", "username is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_User", bVar.getUsername());
        intent.putExtra("Contact_Nick", bVar.EU());
        intent.putExtra("Contact_Mobile_MD5", bVar.EP());
        intent.putExtra("Contact_Alias", bVar.hAI);
        intent.putExtra("Contact_Sex", bVar.hAD);
        intent.putExtra("Contact_Signature", bVar.hAG);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(bVar.hAM, bVar.hAE, bVar.hAF));
        intent.putExtra("Contact_Scene", 13);
        intent.putExtra("Contact_ShowUserName", false);
        com.tencent.mm.plugin.c.a.imv.d(intent, (Context) this);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32 && this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!(i == 0 && i2 == 0)) {
            w.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + i + ", errCode = " + i2);
        }
        if (kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.map.e.CTRL_INDEX) {
            ap.vd().a(new v(), 0);
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 32) {
                d.be(getApplicationContext());
            }
            this.vuF.a(null, null);
        } else if (kVar.getType() == 32) {
            Toast.makeText(this, R.l.eBa, 0).show();
        }
    }
}
