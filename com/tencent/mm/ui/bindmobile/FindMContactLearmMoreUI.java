package com.tencent.mm.ui.bindmobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.pluginsdk.i.a;
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

public class FindMContactLearmMoreUI extends MMWizardActivity {
    private String fOI;
    private List<String[]> hBa = null;
    private e hUh = null;
    private ProgressDialog isv = null;
    private String kwg = null;
    private String vdU = "";
    private int vdV = 2;
    private y vua;
    private Button vuo;
    private TextView vup;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kwg = getIntent().getStringExtra("regsetinfo_ticket");
        this.vdU = getIntent().getStringExtra("regsetinfo_NextStep");
        this.vdV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        KC();
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
        b.mM("R300_100_phone");
        b.b(true, ap.uY() + "," + getClass().getName() + ",RE300_600," + ap.ec("RE300_600") + ",1");
    }

    protected void onPause() {
        super.onPause();
        b.b(false, ap.uY() + "," + getClass().getName() + ",RE300_600," + ap.ec("RE300_600") + ",2");
    }

    protected final void KC() {
        zi(R.l.ekK);
        this.vuo = (Button) findViewById(R.h.cpm);
        this.vup = (TextView) findViewById(R.h.bvK);
        this.vuo.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FindMContactLearmMoreUI vuq;

            {
                this.vuq = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                c.vr().set(12322, Boolean.valueOf(true));
                m.f(true, false);
                this.vuq.bTk();
            }
        });
        this.vup.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FindMContactLearmMoreUI vuq;

            {
                this.vuq = r1;
            }

            public final void onClick(View view) {
                ap.yY();
                c.vr().set(12322, Boolean.valueOf(false));
                m.f(false, false);
                this.vuq.aXS();
            }
        });
        ap.yY();
        c.vr().set(12323, Boolean.valueOf(true));
        ap.yY();
        this.fOI = (String) c.vr().get(6, null);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(4097, null);
        }
    }

    private void bTk() {
        w.i("MicroMsg.FindMContactLearmMoreUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ());
        if (a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            n vd = ap.vd();
            e anonymousClass3 = new e(this) {
                final /* synthetic */ FindMContactLearmMoreUI vuq;

                {
                    this.vuq = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.vuq.isv != null) {
                        this.vuq.isv.dismiss();
                        this.vuq.isv = null;
                    }
                    if (this.vuq.hUh != null) {
                        ap.vd().b(431, this.vuq.hUh);
                        this.vuq.hUh = null;
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
                        String str2 = "MicroMsg.FindMContactLearmMoreUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(FK == null ? 0 : FK.size());
                        objArr[1] = Integer.valueOf(i3);
                        w.d(str2, str3, objArr);
                        if (this.vuq.vdU == null || !this.vuq.vdU.contains("1") || r0 == 0) {
                            this.vuq.aXS();
                            return;
                        }
                        b.mN("R300_300_phone");
                        Intent intent = new Intent(this.vuq, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.vuq.kwg);
                        intent.putExtra("regsetinfo_NextStep", this.vuq.vdU);
                        intent.putExtra("regsetinfo_NextStyle", this.vuq.vdV);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.z(this.vuq, intent);
                        return;
                    }
                    Toast.makeText(this.vuq, this.vuq.getString(R.l.dGU, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    this.vuq.aXS();
                }
            };
            this.hUh = anonymousClass3;
            vd.a(431, anonymousClass3);
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.fnL), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactLearmMoreUI vuq;

                {
                    this.vuq = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.vuq.hUh != null) {
                        ap.vd().b(431, this.vuq.hUh);
                        this.vuq.hUh = null;
                    }
                }
            });
            ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                final /* synthetic */ FindMContactLearmMoreUI vuq;

                {
                    this.vuq = r1;
                }

                public final boolean Bo() {
                    if (this.vuq.hBa == null || this.vuq.hBa.size() == 0) {
                        if (this.vuq.isv != null) {
                            this.vuq.isv.dismiss();
                            this.vuq.isv = null;
                        }
                        this.vuq.aXS();
                    } else {
                        this.vuq.vua = new y(this.vuq.kwg, this.vuq.hBa);
                        ap.vd().a(this.vuq.vua, 0);
                    }
                    return false;
                }

                public final boolean Bn() {
                    try {
                        this.vuq.hBa = com.tencent.mm.pluginsdk.a.dn(this.vuq);
                        w.d("MicroMsg.FindMContactLearmMoreUI", "tigerreg mobileList size " + (this.vuq.hBa == null ? 0 : this.vuq.hBa.size()));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FindMContactLearmMoreUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            m.f(true, false);
            com.tencent.mm.modelfriend.a.EL();
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
        aHf();
        zu(1);
    }

    protected final int getLayoutId() {
        return R.i.dcZ;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FindMContactLearmMoreUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bTk();
                    return;
                } else {
                    g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FindMContactLearmMoreUI vuq;

                        {
                            this.vuq = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.vuq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ FindMContactLearmMoreUI vuq;

                        {
                            this.vuq = r1;
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
