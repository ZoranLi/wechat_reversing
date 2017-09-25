package com.tencent.mm.ui.bindmobile;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.y;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.c.b;
import com.tencent.mm.protocal.c.ajm;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.friend.FindMContactAddUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FindMContactAlertUI extends MMWizardActivity {
    private String fOI;
    private List<String[]> hBa = null;
    private e hUh = null;
    private String iZg;
    private String iZh;
    private ProgressDialog isv = null;
    private String kwg = null;
    private String oVk;
    private int qlL = 0;
    private String vdU = "";
    private int vdV = 2;
    private String vtX = null;
    private String vtY = null;
    private boolean vtZ = false;
    private y vua;
    private int vub = 0;
    private final int vuc = m.CTRL_INDEX;
    private int vud = 0;
    private int vue = 0;
    private int vuf = 0;
    private int vug = 0;
    private int vuh = 0;

    static /* synthetic */ void a(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.vud = i;
        findMContactAlertUI.vue = i2;
        if (findMContactAlertUI.vuf > 0 && findMContactAlertUI.qlL > 0) {
            findMContactAlertUI.bTj();
        }
    }

    static /* synthetic */ void b(FindMContactAlertUI findMContactAlertUI, int i, int i2) {
        findMContactAlertUI.vuf = i;
        findMContactAlertUI.qlL = i2;
        if (findMContactAlertUI.vud > 0 && findMContactAlertUI.vue > 0) {
            findMContactAlertUI.bTj();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.bPL);
        a.imw.ox();
        this.kwg = getIntent().getStringExtra("regsetinfo_ticket");
        this.vdU = getIntent().getStringExtra("regsetinfo_NextStep");
        this.vdV = getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        this.vtX = getIntent().getStringExtra("alert_title");
        this.vtY = getIntent().getStringExtra("alert_message");
        this.vtZ = com.tencent.mm.modelfriend.m.Fl() != com.tencent.mm.modelfriend.m.a.SUCC;
        this.oVk = b.Oz();
        w.d("MicroMsg.FindMContactAlertUI", "tigerreg mNextStep %s  mNextStyle %s ", this.vdU, Integer.valueOf(this.vdV));
        if (!isFinishing()) {
            KC();
            bTi();
        }
    }

    public void onDestroy() {
        w.d("MicroMsg.FindMContactAlertUI", "ondestroy");
        if (this.hUh != null) {
            ap.vd().b(431, this.hUh);
            this.hUh = null;
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (this.vtZ) {
            b.mM("R300_100_QQ");
            b.b(true, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",1");
            return;
        }
        b.mM("R300_100_phone");
        b.b(true, ap.uY() + "," + getClass().getName() + ",RE300_100," + ap.ec("RE300_100") + ",1");
    }

    protected void onPause() {
        super.onPause();
        if (this.vtZ) {
            b.b(false, ap.uY() + "," + getClass().getName() + ",R300_100_QQ," + ap.ec("R300_100_QQ") + ",2");
        } else {
            b.b(false, ap.uY() + "," + getClass().getName() + ",RE300_100," + ap.ec("RE300_100") + ",2");
        }
    }

    protected final void KC() {
        this.iZg = getString(R.l.ekw);
        this.iZh = getString(R.l.ekv);
        if (!bg.mA(this.vtX)) {
            this.iZg = this.vtX;
        }
        if (!bg.mA(this.vtY)) {
            this.iZh = this.vtY;
        }
        ap.yY();
        this.fOI = (String) c.vr().get(6, null);
        if (this.fOI == null || this.fOI.equals("")) {
            ap.yY();
            this.fOI = (String) c.vr().get(4097, null);
        }
    }

    private void bTi() {
        if (this.vtZ) {
            b.mO(ap.uY() + "," + getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",1");
            g.a((Context) this, false, getString(R.l.ekv), getString(R.l.dIO), getString(R.l.dHT), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(true));
                    b.mN("R200_100");
                    Intent intent = new Intent();
                    intent.putExtra("mobile_input_purpose", 4);
                    intent.putExtra("regsetinfo_ticket", this.vui.kwg);
                    intent.putExtra("regsetinfo_NextStep", this.vui.vdU);
                    intent.putExtra("regsetinfo_NextStyle", this.vui.vdV);
                    a.imv.a(this.vui, intent);
                    b.mN("R300_300_phone");
                    b.b(false, ap.uY() + "," + this.vui.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",2");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(false));
                    b.mO(ap.uY() + "," + this.vui.getClass().getName() + ",R300_200_phone," + ap.ec("R300_200_phone") + ",2");
                    this.vui.aXS();
                }
            });
        } else if (com.tencent.mm.modelfriend.m.Fk()) {
            CharSequence charSequence = this.iZh;
            CharSequence charSequence2 = this.iZg;
            int i = R.l.ekJ;
            int i2 = R.l.ekI;
            OnClickListener anonymousClass5 = new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ap.yY();
                    c.vr().set(12322, Boolean.valueOf(true));
                    this.vui.bTk();
                    dialogInterface.dismiss();
                }
            };
            OnClickListener anonymousClass6 = new OnClickListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(this.vui, FindMContactLearmMoreUI.class);
                    intent.putExtra("regsetinfo_ticket", this.vui.kwg);
                    intent.putExtra("regsetinfo_NextStep", this.vui.vdU);
                    intent.putExtra("regsetinfo_NextStyle", this.vui.vdV);
                    MMWizardActivity.z(this.vui, intent);
                }
            };
            final Dialog hVar = new h(this);
            hVar.setTitle(charSequence2);
            hVar.setMessage(charSequence);
            hVar.a(i, anonymousClass5);
            hVar.b(i2, anonymousClass6);
            hVar.rMX.setVisibility(0);
            hVar.setCancelable(false);
            hVar.show();
            hVar.getWindow().clearFlags(2);
            a(hVar);
            hVar.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                public final void onGlobalLayout() {
                    int measuredWidth;
                    hVar.getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredWidth2 = hVar.getWindow().getDecorView().getMeasuredWidth();
                    int measuredHeight = hVar.getWindow().getDecorView().getMeasuredHeight();
                    View a = this.vui.j((ViewGroup) hVar.getWindow().getDecorView());
                    if (a != null) {
                        measuredWidth = a.getMeasuredWidth() * 2;
                    } else {
                        measuredWidth = measuredWidth2;
                    }
                    w.d("MicroMsg.FindMContactAlertUI", "dialog width: %s height: %s", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.a(this.vui, measuredWidth, measuredHeight);
                }
            });
            final View findViewById = findViewById(R.h.background);
            findViewById.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                public final void onGlobalLayout() {
                    findViewById.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    int measuredHeight = findViewById.getMeasuredHeight();
                    w.d("MicroMsg.FindMContactAlertUI", "bg width: %s height: %s", Integer.valueOf(findViewById.getMeasuredWidth()), Integer.valueOf(measuredHeight));
                    FindMContactAlertUI.b(this.vui, r1, measuredHeight);
                }
            });
        } else {
            bTk();
        }
    }

    private View j(ViewGroup viewGroup) {
        if (this.vub >= m.CTRL_INDEX) {
            return null;
        }
        this.vub++;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof Button) {
                return childAt;
            }
            if (childAt instanceof ViewGroup) {
                childAt = j((ViewGroup) childAt);
                if (childAt != null) {
                    return childAt;
                }
            }
        }
        return null;
    }

    private void bTj() {
        int height = getWindowManager().getDefaultDisplay().getHeight();
        int dimensionPixelSize = this.vuf - (getResources().getDimensionPixelSize(R.f.aXK) + com.tencent.mm.bg.a.fromDPToPix(this, 48));
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this, 20) + (((height / 2) + (this.vue / 2)) - (height - this.qlL));
        if (dimensionPixelSize != this.vug || fromDPToPix != this.vuh) {
            this.vug = dimensionPixelSize;
            this.vuh = fromDPToPix;
            View findViewById = findViewById(R.h.bPM);
            findViewById.setVisibility(0);
            LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
            layoutParams.setMargins(dimensionPixelSize - (findViewById.getMeasuredWidth() / 2), fromDPToPix, 0, 0);
            w.d("MicroMsg.FindMContactAlertUI", "attachArrow x: %s y: %s view.width: %s", Integer.valueOf(dimensionPixelSize), Integer.valueOf(fromDPToPix), Integer.valueOf(findViewById.getMeasuredWidth()));
            findViewById.setLayoutParams(layoutParams);
            findViewById.startAnimation(AnimationUtils.loadAnimation(this, R.a.aQN));
        }
    }

    private void bTk() {
        w.i("MicroMsg.FindMContactAlertUI", "summerper checkPermission checkContacts[%b],stack[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)), bg.bJZ());
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.READ_CONTACTS", 48, null, null)) {
            View findViewById = findViewById(R.h.bPM);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            n vd = ap.vd();
            e anonymousClass9 = new e(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.vui.isv != null) {
                        this.vui.isv.dismiss();
                        this.vui.isv = null;
                    }
                    if (this.vui.hUh != null) {
                        ap.vd().b(431, this.vui.hUh);
                        this.vui.hUh = null;
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
                        String str2 = "MicroMsg.FindMContactAlertUI";
                        String str3 = "tigerreg data size=%d, addcount=%s";
                        Object[] objArr = new Object[2];
                        objArr[0] = Integer.valueOf(FK == null ? 0 : FK.size());
                        objArr[1] = Integer.valueOf(i3);
                        w.d(str2, str3, objArr);
                        if (this.vui.vdU == null || !this.vui.vdU.contains("1") || r0 == 0) {
                            this.vui.aXS();
                            return;
                        }
                        b.mN("R300_300_phone");
                        Intent intent = new Intent(this.vui, FindMContactAddUI.class);
                        intent.putExtra("regsetinfo_ticket", this.vui.kwg);
                        intent.putExtra("regsetinfo_NextStep", this.vui.vdU);
                        intent.putExtra("regsetinfo_NextStyle", this.vui.vdV);
                        intent.putExtra("login_type", 0);
                        MMWizardActivity.z(this.vui, intent);
                        return;
                    }
                    Toast.makeText(this.vui, this.vui.getString(R.l.dGU, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
                    this.vui.aXS();
                }
            };
            this.hUh = anonymousClass9;
            vd.a(431, anonymousClass9);
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.fnL), true, new OnCancelListener(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.vui.hUh != null) {
                        ap.vd().b(431, this.vui.hUh);
                        this.vui.hUh = null;
                        this.vui.bTi();
                    }
                }
            });
            ap.vL().a(new com.tencent.mm.sdk.platformtools.af.a(this) {
                final /* synthetic */ FindMContactAlertUI vui;

                {
                    this.vui = r1;
                }

                public final boolean Bo() {
                    if (this.vui.hBa == null || this.vui.hBa.size() == 0) {
                        if (this.vui.isv != null) {
                            this.vui.isv.dismiss();
                            this.vui.isv = null;
                        }
                        this.vui.aXS();
                    } else {
                        this.vui.vua = new y(this.vui.kwg, this.vui.hBa);
                        ap.vd().a(this.vui.vua, 0);
                    }
                    return false;
                }

                public final boolean Bn() {
                    try {
                        this.vui.hBa = com.tencent.mm.pluginsdk.a.dn(this.vui);
                        w.d("MicroMsg.FindMContactAlertUI", "tigerreg mobileList size " + (this.vui.hBa == null ? 0 : this.vui.hBa.size()));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.FindMContactAlertUI", e, "", new Object[0]);
                    }
                    return true;
                }

                public final String toString() {
                    return super.toString() + "|doUpload";
                }
            });
            com.tencent.mm.platformtools.m.f(true, false);
            com.tencent.mm.modelfriend.a.EL();
            com.tencent.mm.plugin.report.service.g.oUh.i(11438, Integer.valueOf(1));
            w.i("MicroMsg.FindMContactAlertUI", "[cpan] kv report logid:%d scene:%d", Integer.valueOf(11438), Integer.valueOf(1));
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
        return R.i.dda;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.FindMContactAlertUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 48:
                if (iArr[0] == 0) {
                    bTk();
                    return;
                } else {
                    g.a((Context) this, getString(R.l.eFH), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ FindMContactAlertUI vui;

                        {
                            this.vui = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.vui.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ FindMContactAlertUI vui;

                        {
                            this.vui = r1;
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
