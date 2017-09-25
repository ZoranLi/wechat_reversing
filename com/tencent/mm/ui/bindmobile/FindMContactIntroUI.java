package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactIntroUI extends MMWizardActivity {
    private String fOI;
    private List<String[]> hBa = null;
    private e hUh = null;
    private ProgressDialog isv = null;
    private String kwg = null;
    private String oVk;
    private TextView oZt;
    private String vdU = "";
    private int vdV = 2;
    private boolean vtZ = false;
    private y vua;
    private Button vuk;
    private TextView vul;

    static /* synthetic */ void a(FindMContactIntroUI findMContactIntroUI) {
        if (findMContactIntroUI.vtZ) {
            b.mO(ap.uY() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",1");
            g.a((Context) findMContactIntroUI, R.l.ekv, R.l.dIO, R.l.dHT, R.l.dGs, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(true));
                    b.mN("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", this.vum.kwg);
                    intent.putExtra("regsetinfo_NextStep", this.vum.vdU);
                    intent.putExtra("regsetinfo_NextStyle", this.vum.vdV);
                    a.imv.a(this.vum, intent);
                    b.mN("R300_300_phone");
                    b.b(false, ap.uY() + "," + this.vum.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",2");
                }
            }, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(false));
                }
            });
        } else if (m.Fk()) {
            b.mO(ap.uY() + "," + findMContactIntroUI.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",1");
            g.a((Context) findMContactIntroUI, R.l.ekv, R.l.dIO, R.l.dHT, R.l.dGs, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(true));
                    this.vum.bTk();
                }
            }, new OnClickListener(findMContactIntroUI) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(false));
                }
            });
        } else {
            findMContactIntroUI.bTk();
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        zi(R.l.bPL);
        a.imw.ox();
        this.kwg = getIntent().getStringExtra("regsetinfo_ticket");
        this.vdU = getIntent().getStringExtra("regsetinfo_NextStep");
        this.vdV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        if (m.Fl() != m.a.SUCC) {
            z = true;
        } else {
            z = false;
        }
        this.vtZ = z;
        this.oVk = b.Oz();
        w.d("MicroMsg.FindMContactIntroUI", "tigerreg mNextStep %s  mNextStyle %s ", this.vdU, Integer.valueOf(this.vdV));
    }

    public void onDestroy() {
        if (this.hUh != null) {
            ap.vd().b(431, this.hUh);
            this.hUh = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        KC();
        if (this.vtZ) {
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",1");
            b.mM("R300_100_QQ");
            return;
        }
        b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_phone," + ap.ec("R300_100_phone") + ",1");
        b.mM("R300_100_phone");
    }

    protected void onPause() {
        super.onPause();
        b.mN("RE900_100");
        if (this.vtZ) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",4");
        } else {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_phone," + ap.ec("R300_100_phone") + ",4");
        }
    }

    protected final void KC() {
        this.vuk = (Button) findViewById(R.h.cCU);
        this.vul = (TextView) findViewById(R.h.bPP);
        this.oZt = (TextView) findViewById(R.h.bPO);
        if (this.vdU == null || !this.vdU.contains("2")) {
            this.oZt.setText(getString(R.l.ekt));
        } else {
            this.oZt.setText(getString(R.l.eks));
        }
        ap.yY();
        this.fOI = (String) c.vr().get(6, null);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(4097, null);
        }
        this.vuk.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactIntroUI vum;

            {
                this.vum = r1;
            }

            public final void onClick(View view) {
                FindMContactIntroUI.a(this.vum);
            }
        });
        this.vul.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ FindMContactIntroUI vum;

            {
                this.vum = r1;
            }

            public final void onClick(View view) {
                g.a(this.vum, this.vum.getString(R.l.ekF), null, this.vum.getString(R.l.ekG), this.vum.getString(R.l.ekE), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 vun;

                    {
                        this.vun = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.vun.vum.aXS();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 vun;

                    {
                        this.vun = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
    }

    private void bTk() {
        w.i("MicroMsg.FindMContactIntroUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ());
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n vd = ap.vd();
            e anonymousClass9 = new e(this) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.vum.isv != null) {
                        this.vum.isv.dismiss();
                        this.vum.isv = null;
                    }
                    if (this.vum.hUh != null) {
                        ap.vd().b(431, this.vum.hUh);
                        this.vum.hUh = null;
                    }
                    if (i == 0 && i2 == 0) {
                        int i3;
                        LinkedList FK = ((y) kVar).FK();
                        af.f(FK);
                        int i4;
                        if (FK == null || FK.size() <= 0) {
                            i4 = 0;
                            i3 = 0;
                        } else {
                            Iterator it = FK.iterator();
                            i3 = 0;
                            while (it.hasNext()) {
                                ajm com_tencent_mm_protocal_c_ajm = (ajm) it.next();
                                if (com_tencent_mm_protocal_c_ajm != null) {
                                    if (com_tencent_mm_protocal_c_ajm.jNB == 1) {
                                        i4 = i3 + 1;
                                    } else {
                                        i4 = i3;
                                    }
                                    i3 = i4;
                                }
                            }
                            i4 = i3 > 0 ? 1 : 0;
                        }
                        String str2 = "MicroMsg.FindMContactIntroUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(FK == null ? 0 : FK.size());
                        objArr[1] = Integer.valueOf(i3);
                        w.d(str2, str3, objArr);
                        if (this.vum.vdU == null || !this.vum.vdU.contains("1") || r0 == 0) {
                            this.vum.aXS();
                            return;
                        }
                        b.mN("R300_300_phone");
                        Intent intent = new Intent(this.vum, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.vum.kwg);
                        intent.putExtra("regsetinfo_NextStep", this.vum.vdU);
                        intent.putExtra("regsetinfo_NextStyle", this.vum.vdV);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.z(this.vum, intent);
                        return;
                    }
                    Toast.makeText(this.vum, this.vum.getString(R.l.dGU, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                }
            };
            this.hUh = anonymousClass9;
            vd.a(431, anonymousClass9);
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.fnL), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.vum.hUh != null) {
                        ap.vd().b(431, this.vum.hUh);
                        this.vum.hUh = null;
                    }
                }
            });
            ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                final /* synthetic */ FindMContactIntroUI vum;

                {
                    this.vum = r1;
                }

                public final boolean Bo() {
                    if (this.vum.hBa == null || this.vum.hBa.size() == 0) {
                        if (this.vum.isv != null) {
                            this.vum.isv.dismiss();
                            this.vum.isv = null;
                        }
                        this.vum.aXS();
                    } else {
                        this.vum.vua = new y(this.vum.kwg, this.vum.hBa);
                        ap.vd().a(this.vum.vua, 0);
                    }
                    return false;
                }

                public final boolean Bn() {
                    try {
                        this.vum.hBa = com.tencent.mm.pluginsdk.a.dn(this.vum);
                        w.d("MicroMsg.FindMContactIntroUI", "tigerreg mobileList size " + (this.vum.hBa == null ? 0 : this.vum.hBa.size()));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FindMContactIntroUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        aXS();
        return true;
    }

    private void aXS() {
        b.mN(this.oVk);
        aHf();
        zu(1);
    }

    protected final int getLayoutId() {
        return R.i.dcY;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FindMContactIntroUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bTk();
                    return;
                } else {
                    g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ FindMContactIntroUI vum;

                        {
                            this.vum = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.vum.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ FindMContactIntroUI vum;

                        {
                            this.vum = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
