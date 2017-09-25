package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.il;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.v;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j.a;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.DisasterUI;
import com.tencent.mm.ui.account.RegByMobileRegAIOUI;
import com.tencent.mm.ui.account.RegByMobileSetPwdUI;
import com.tencent.mm.ui.account.RegSetInfoUI;
import com.tencent.mm.ui.account.f;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class MobileLoginOrForceReg extends MMActivity implements e {
    private String fFa;
    private String fGV;
    private String fOI;
    private String fWY;
    private int hSN;
    private ae handler = new ae(this) {
        final /* synthetic */ MobileLoginOrForceReg vdJ;

        {
            this.vdJ = r1;
        }

        public final void handleMessage(Message message) {
            if (message.obj != null) {
                this.vdJ.ipv.setImageBitmap((Bitmap) message.obj);
            }
        }
    };
    private String iMn;
    private ImageView ipv;
    protected ProgressDialog isv = null;
    private TextView jWd;
    private String lOq;
    private String uUj;
    private SecurityImage uUx = null;
    private c uXF = new c<il>(this) {
        final /* synthetic */ MobileLoginOrForceReg vdJ;

        {
            this.vdJ = r2;
            this.usg = il.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            il ilVar = (il) bVar;
            if (ilVar == null || ilVar.fOj == null) {
                return false;
            }
            w.i("MicorMsg.MobileLoginOrForceReg", "summerdiz loginDisasterListener callback content[%s], url[%s]", ilVar.fOj.content, ilVar.fOj.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", ilVar.fOj.content);
            intent.putExtra("key_disaster_url", ilVar.fOj.url);
            intent.setClass(ab.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            ab.getContext().startActivity(intent);
            return true;
        }
    };
    private f uYk = null;
    private a uYs;
    private String username;
    private Button vdA;
    private LinearLayout vdB;
    private LinearLayout vdC;
    private TextView vdD;
    private int vdE;
    private boolean vdF = true;
    private boolean vdG;
    private String vdH;
    private String vdI;
    private a vdc = null;
    private Button vdz;

    static /* synthetic */ void j(MobileLoginOrForceReg mobileLoginOrForceReg) {
        final k wVar = new com.tencent.mm.modelsimple.w("", mobileLoginOrForceReg.vdI, mobileLoginOrForceReg.vdH, 0, "", mobileLoginOrForceReg.fOI, "", "", mobileLoginOrForceReg.fGV, mobileLoginOrForceReg.hSN, "", "", "", true, mobileLoginOrForceReg.vdG);
        ap.vd().a(wVar, 0);
        Context context = mobileLoginOrForceReg.uSU.uTo;
        mobileLoginOrForceReg.getString(R.l.dIO);
        mobileLoginOrForceReg.isv = g.a(context, mobileLoginOrForceReg.getString(R.l.eKf), true, new OnCancelListener(mobileLoginOrForceReg) {
            final /* synthetic */ MobileLoginOrForceReg vdJ;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(wVar);
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uUj = com.tencent.mm.plugin.c.b.Oz();
        ap.vd().a(701, (e) this);
        ap.vd().a(126, (e) this);
        ap.vd().a(255, (e) this);
        this.fGV = getIntent().getStringExtra("ticket");
        this.fOI = getIntent().getStringExtra("moble");
        this.vdE = getIntent().getIntExtra("next_controll", 0);
        this.username = getIntent().getStringExtra("username");
        this.lOq = getIntent().getStringExtra("password");
        this.fFa = getIntent().getStringExtra("nickname");
        this.iMn = getIntent().getStringExtra("avatar_url");
        this.vdG = getIntent().getBooleanExtra("kintent_hasavatar", false);
        this.vdH = getIntent().getStringExtra("kintent_nickname");
        this.vdI = getIntent().getStringExtra("kintent_password");
        if (this.vdI == null || this.vdI.length() < 8) {
            this.hSN = 4;
        } else {
            this.hSN = 1;
        }
        KC();
        this.uYs = new a();
    }

    public final void KC() {
        String yU;
        CharSequence charSequence;
        this.vdz = (Button) findViewById(R.h.bGG);
        this.vdA = (Button) findViewById(R.h.bQY);
        this.vdB = (LinearLayout) findViewById(R.h.bVM);
        this.vdC = (LinearLayout) findViewById(R.h.cog);
        this.ipv = (ImageView) findViewById(R.h.bqM);
        this.jWd = (TextView) findViewById(R.h.cof);
        this.vdD = (TextView) findViewById(R.h.bto);
        an anVar = new an();
        if (this.fOI.startsWith("+")) {
            yU = an.yU(this.fOI);
            if (bg.mA(yU)) {
                charSequence = this.fOI;
            } else {
                charSequence = "+" + yU + " " + an.formatNumber(yU, this.fOI.substring(yU.length() + 1));
            }
        } else {
            charSequence = "+86 " + an.formatNumber("86", this.fOI);
        }
        this.vdD.setText(charSequence);
        if (bg.mA(this.fFa) && bg.mA(this.iMn)) {
            this.vdC.setVisibility(0);
            this.vdB.setVisibility(8);
        } else {
            this.vdC.setVisibility(8);
            this.vdB.setVisibility(0);
            if (bg.mA(this.fFa)) {
                this.jWd.setVisibility(8);
            } else {
                this.jWd.setText(this.fFa);
            }
            Bitmap nZ = com.tencent.mm.pluginsdk.ui.a.b.bEa().nZ();
            if (nZ != null) {
                this.ipv.setImageBitmap(nZ);
            }
            if (!bg.mA(this.iMn)) {
                yU = this.iMn;
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ MobileLoginOrForceReg vdJ;

                    public final void run() {
                        Object obj = null;
                        try {
                            obj = d.decodeStream(com.tencent.mm.network.b.k(yU, 10000, 20000));
                        } catch (Throwable e) {
                            w.e("MicorMsg.MobileLoginOrForceReg", "download avatar failed");
                            w.printErrStackTrace("MicorMsg.MobileLoginOrForceReg", e, "", new Object[0]);
                        }
                        this.vdJ.handler.sendMessage(this.vdJ.handler.obtainMessage(0, obj));
                    }

                    public final String toString() {
                        return super.toString() + "|loadBitmap";
                    }
                });
            }
        }
        this.vdz.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg vdJ;

            {
                this.vdJ = r1;
            }

            public final void onClick(View view) {
                this.vdJ.vdc = new a(new a.a(this) {
                    final /* synthetic */ AnonymousClass14 vdO;

                    {
                        this.vdO = r1;
                    }

                    public final void a(ProgressDialog progressDialog) {
                        this.vdO.vdJ.isv = progressDialog;
                    }
                }, this.vdJ.username, this.vdJ.lOq, this.vdJ.fOI);
                this.vdJ.vdc.h(this.vdJ);
            }
        });
        this.vdA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg vdJ;

            {
                this.vdJ = r1;
            }

            public final void onClick(View view) {
                if (this.vdJ.vdH == null) {
                    Intent intent = new Intent();
                    com.tencent.mm.plugin.c.b.mN("R200_900_phone");
                    intent.putExtra("regsetinfo_ticket", this.vdJ.fGV);
                    intent.putExtra("regsetinfo_user", this.vdJ.fOI);
                    intent.putExtra("regsetinfo_ismobile", 1);
                    intent.putExtra("regsetinfo_isForce", true);
                    intent.putExtra("regsetinfo_NextControl", this.vdJ.vdE);
                    intent.setClass(this.vdJ, RegSetInfoUI.class);
                    this.vdJ.startActivity(intent);
                    return;
                }
                MobileLoginOrForceReg.j(this.vdJ);
            }
        });
        zi(R.l.eBd);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MobileLoginOrForceReg vdJ;

            {
                this.vdJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vdJ.goBack();
                return false;
            }
        });
    }

    public void onResume() {
        com.tencent.mm.sdk.b.a.urY.b(this.uXF);
        super.onResume();
        com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",1");
        com.tencent.mm.plugin.c.b.mM("R200_600");
    }

    public void onPause() {
        super.onPause();
        com.tencent.mm.sdk.b.a.urY.c(this.uXF);
    }

    public void onDestroy() {
        ap.vd().b(701, (e) this);
        ap.vd().b(126, (e) this);
        ap.vd().b(255, (e) this);
        if (this.uYs != null) {
            this.uYs.close();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.djy;
    }

    private void goBack() {
        com.tencent.mm.plugin.c.b.mN("R200_100");
        bf.zK();
        Intent intent = new Intent(this, RegByMobileRegAIOUI.class);
        intent.putExtra("mobile_input_purpose", 2);
        intent.addFlags(67108864);
        startActivity(intent);
        com.tencent.mm.plugin.c.b.mM(this.uUj);
        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",2");
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        goBack();
        return true;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (this.uYk == null) {
            this.uYk = new f();
        }
        if (kVar.getType() == 255) {
            if (i != 0 || i2 != 0) {
                boolean z = this.vdF;
                Intent intent = new Intent(this, RegByMobileSetPwdUI.class);
                intent.putExtra("kintent_hint", getString(R.l.eSZ));
                intent.putExtra("kintent_cancelable", z);
                startActivityForResult(intent, 0);
            }
        } else if (kVar.getType() != 701 || this.vdc == null) {
            com.tencent.mm.f.a dn;
            Object obj;
            if (kVar.getType() == 126) {
                if (i2 == -6 || i2 == -311 || i2 == -310) {
                    final Boolean valueOf = Boolean.valueOf(this.vdG);
                    final String str2 = this.vdI;
                    final String str3 = this.vdH;
                    if (this.uUx == null) {
                        final k kVar2 = kVar;
                        final String str4 = str2;
                        final String str5 = str3;
                        final k kVar3 = kVar;
                        final Boolean bool = valueOf;
                        this.uUx = SecurityImage.a.a(this, R.l.eKg, 0, ((com.tencent.mm.modelsimple.w) kVar).FI(), ((com.tencent.mm.modelsimple.w) kVar).FJ(), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                final k wVar = new com.tencent.mm.modelsimple.w("", str2, str3, 0, "", this.vdJ.fOI, "", "", this.vdJ.fGV, this.vdJ.hSN, "", ((com.tencent.mm.modelsimple.w) kVar2).FJ(), this.vdJ.uUx.bRz(), true, valueOf.booleanValue());
                                ap.vd().a(wVar, 0);
                                MobileLoginOrForceReg mobileLoginOrForceReg = this.vdJ;
                                Context context = this.vdJ.uSU.uTo;
                                this.vdJ.getString(R.l.dIO);
                                mobileLoginOrForceReg.isv = g.a(context, this.vdJ.getString(R.l.eKf), true, new OnCancelListener(this) {
                                    final /* synthetic */ AnonymousClass2 vdN;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        ap.vd().c(wVar);
                                    }
                                });
                            }
                        }, null, new OnDismissListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            {
                                this.vdJ = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                this.vdJ.uUx = null;
                            }
                        }, new SecurityImage.b(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            public final void bQI() {
                                this.vdJ.aHf();
                                ap.vd().a(new com.tencent.mm.modelsimple.w("", str4, str5, 0, "", this.vdJ.fOI, "", "", this.vdJ.fGV, this.vdJ.hSN, "", ((com.tencent.mm.modelsimple.w) kVar3).FJ(), "", true, bool.booleanValue()), 0);
                            }
                        });
                        return;
                    }
                    this.uUx.a(0, ((com.tencent.mm.modelsimple.w) kVar).FI(), ((com.tencent.mm.modelsimple.w) kVar).FJ(), "");
                    return;
                }
                if (i == 0 && i2 == 0) {
                    final String str6 = this.fOI;
                    Boolean valueOf2 = Boolean.valueOf(this.vdG);
                    ap.unhold();
                    ap.aT(true);
                    if (valueOf2.booleanValue()) {
                        String str7 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar";
                        String str8 = com.tencent.mm.compatible.util.e.gSG + "temp.avatar.hd";
                        new File(str7).renameTo(new File(str8));
                        com.tencent.mm.loader.stub.b.deleteFile(str7);
                        d.b(str8, 96, 96, CompressFormat.JPEG, 90, str7);
                        o oVar = new o(this, com.tencent.mm.compatible.util.e.gSG + "temp.avatar");
                        final k kVar4 = kVar;
                        Runnable anonymousClass5 = new Runnable(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            public final void run() {
                                this.vdJ.fGV = ((com.tencent.mm.modelsimple.w) kVar4).Jq();
                                ao.hlW.L("login_user_name", str6);
                                com.tencent.mm.loader.stub.b.deleteFile(com.tencent.mm.compatible.util.e.gSG + "temp.avatar");
                                Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdJ);
                                ak.addFlags(67108864);
                                this.vdJ.startActivity(ak);
                                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
                                this.vdJ.finish();
                            }
                        };
                        kVar4 = kVar;
                        oVar.a(anonymousClass5, new Runnable(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            public final void run() {
                                this.vdJ.fGV = ((com.tencent.mm.modelsimple.w) kVar4).Jq();
                                ao.hlW.L("login_user_name", str6);
                                Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this.vdJ);
                                ak.addFlags(67108864);
                                this.vdJ.startActivity(ak);
                                com.tencent.mm.plugin.c.b.mO(ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
                                this.vdJ.finish();
                            }
                        });
                    } else {
                        this.fGV = ((com.tencent.mm.modelsimple.w) kVar).Jq();
                        ao.hlW.L("login_user_name", str6);
                        Intent ak = com.tencent.mm.plugin.c.a.imv.ak(this);
                        ak.addFlags(67108864);
                        ak.putExtra("LauncherUI.enter_from_reg", true);
                        startActivity(ak);
                        finish();
                        com.tencent.mm.plugin.c.b.mN("RE900_100");
                        com.tencent.mm.plugin.c.b.b(false, ap.uY() + "," + getClass().getName() + ",R200_600," + ap.ec("R200_600") + ",4");
                    }
                }
                dn = com.tencent.mm.f.a.dn(str);
                if (dn != null) {
                    dn.a(this, null, null);
                    return;
                }
            }
            if (!this.uYs.a(this, new p(i, i2, str))) {
                obj = null;
                switch (i2) {
                    case -140:
                        if (!bg.mA(this.fWY)) {
                            m.j(this.uSU.uTo, str, this.fWY);
                        }
                        obj = 1;
                        break;
                    case -100:
                        ap.hold();
                        g.a(this.uSU.uTo, TextUtils.isEmpty(ap.uI()) ? com.tencent.mm.bg.a.V(this.uSU.uTo, R.l.ezi) : ap.uI(), this.uSU.uTo.getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            {
                                this.vdJ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        }, new OnCancelListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            {
                                this.vdJ = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                            }
                        });
                        obj = 1;
                        break;
                    case -75:
                        g.h(this, R.l.dDf, R.l.eJb);
                        obj = 1;
                        break;
                    case -43:
                        Toast.makeText(this, R.l.dNv, 0).show();
                        obj = 1;
                        break;
                    case -41:
                        Toast.makeText(this, R.l.dNx, 0).show();
                        obj = 1;
                        break;
                    case -36:
                        Toast.makeText(this, R.l.dNA, 0).show();
                        obj = 1;
                        break;
                    case -34:
                        Toast.makeText(this, R.l.dNy, 0).show();
                        obj = 1;
                        break;
                    case -33:
                        g.a((Context) this, R.l.dOf, R.l.btr, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            {
                                this.vdJ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                    case -32:
                        g.a((Context) this, getString(R.l.dOh), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ MobileLoginOrForceReg vdJ;

                            {
                                this.vdJ = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                        obj = 1;
                        break;
                    default:
                        break;
                }
            }
            obj = 1;
            if (obj == null) {
                if (kVar.getType() == 701) {
                    dn = com.tencent.mm.f.a.dn(str);
                    if (dn != null && dn.a(this.uSU.uTo, null, null)) {
                        return;
                    }
                }
                if (i != 0 || i2 != 0) {
                    Toast.makeText(this.uSU.uTo, getString(R.l.dOe, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            }
        } else if (i2 == -6 || i2 == -311 || i2 == -310) {
            this.uYk.hSs = this.username;
            this.uYk.uYT = this.vdI;
            this.uYk.uYU = ((u) kVar).FJ();
            this.uYk.uYW = ((u) kVar).FI();
            this.uYk.uYV = ((u) kVar).Jj();
            this.uYk.uYX = ((u) kVar).Ji();
            if (this.uUx == null) {
                this.uUx = SecurityImage.a.a(this, R.l.eKg, this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg vdJ;

                    {
                        this.vdJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.d("MicorMsg.MobileLoginOrForceReg", "imgSid:" + this.vdJ.uYk.uYU + " img len" + this.vdJ.uYk.uYW.length + " " + com.tencent.mm.compatible.util.g.sd());
                        final k uVar = new u(this.vdJ.uYk.hSs, this.vdJ.uYk.uYT, this.vdJ.uYk.uYX, this.vdJ.uUx.bRz(), this.vdJ.uUx.uYU, this.vdJ.uUx.uYV, 1, "", false, true);
                        ap.vd().a(uVar, 0);
                        Context context = this.vdJ;
                        this.vdJ.getString(R.l.dIO);
                        g.a(context, this.vdJ.getString(R.l.ewX), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass17 vdP;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ap.vd().c(uVar);
                            }
                        });
                    }
                }, null, new OnDismissListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg vdJ;

                    {
                        this.vdJ = r1;
                    }

                    public final void onDismiss(DialogInterface dialogInterface) {
                        this.vdJ.uUx = null;
                    }
                }, this.uYk);
            } else {
                this.uUx.a(this.uYk.uYX, this.uYk.uYW, this.uYk.uYU, this.uYk.uYV);
            }
        } else {
            this.fWY = ((u) kVar).Jh();
            this.vdc.a(this, i, i2, str, kVar);
            if (kVar instanceof u) {
                this.vdF = ((u) kVar).Jp();
            }
            if (i == 0 && i2 == 0) {
                final k vVar = new v(1);
                ap.vd().a(vVar, 0);
                getString(R.l.dIO);
                this.isv = g.a((Context) this, getString(R.l.eSL), true, new OnCancelListener(this) {
                    final /* synthetic */ MobileLoginOrForceReg vdJ;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(vVar);
                    }
                });
            }
        }
    }
}
