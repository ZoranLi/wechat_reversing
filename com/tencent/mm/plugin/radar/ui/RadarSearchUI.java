package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.qm;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.radar.a.c;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.plugin.radar.ui.RadarViewController.b;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.e;
import java.util.HashMap;
import junit.framework.Assert;

@a(19)
public class RadarSearchUI extends MMBaseActivity {
    private RadarViewController oHZ = null;
    private boolean oIa = true;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        requestWindowFeature(1);
        setContentView(R.i.dlG);
        this.oHZ = (RadarViewController) findViewById(R.h.cuP);
        RadarViewController radarViewController = this.oHZ;
        RelativeLayout relativeLayout = (RelativeLayout) radarViewController.findViewById(R.h.cuH);
        LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) radarViewController.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        layoutParams.width = displayMetrics.widthPixels;
        relativeLayout.setLayoutParams(layoutParams);
        radarViewController.oIW = (RadarTipsView) radarViewController.findViewById(R.h.cuZ);
        RadarTipsView radarTipsView = radarViewController.oIW;
        Context context = radarTipsView.getContext();
        if (radarTipsView.oIx == null) {
            radarTipsView.oIx = AnimationUtils.loadAnimation(context, R.a.aRx);
        }
        if (radarTipsView.oIy == null) {
            radarTipsView.oIy = AnimationUtils.loadAnimation(context, R.a.aRy);
            radarTipsView.oIy.setAnimationListener(new AnimationListener(radarTipsView) {
                final /* synthetic */ RadarTipsView oIS;

                {
                    this.oIS = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    if (!this.oIS.oII) {
                        this.oIS.oIw.sendEmptyMessage(0);
                    }
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
        }
        radarTipsView.oIz = (TextView) radarTipsView.findViewById(R.h.cva);
        radarTipsView.oIA = radarTipsView.findViewById(R.h.cuY);
        radarTipsView.oIB = (LinearLayout) radarTipsView.findViewById(R.h.cvb);
        radarTipsView.oIB.setOnClickListener(new OnClickListener(radarTipsView) {
            final /* synthetic */ RadarTipsView oIS;

            {
                this.oIS = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.RadarTipsView", "noviceEducationTips onclick");
                this.oIS.aVR();
            }
        });
        RadarTipsView radarTipsView2 = radarViewController.oIW;
        radarTipsView2.oIR = 1;
        radarTipsView2.oIH.sendEmptyMessageDelayed(2, 1000);
        radarTipsView2.oIH.sendEmptyMessageDelayed(1, 9000);
        radarTipsView2 = radarViewController.oIW;
        if (radarTipsView2.oIN != 0) {
            radarTipsView2.oIR = 0;
            radarTipsView2.aVT();
            radarTipsView2.aVS();
            radarTipsView2.oIA.setVisibility(8);
            radarTipsView2.oIB.setVisibility(8);
            radarTipsView2.setVisibility(8);
        }
        radarTipsView2.oIL = true;
        radarTipsView2.oIN = bg.NA();
        radarTipsView2.oIO = true;
        radarTipsView2.oIM++;
        radarViewController.oIY = (TextView) radarViewController.findViewById(R.h.cuN);
        radarViewController.oIZ = (ProgressBar) radarViewController.findViewById(R.h.cuO);
        radarViewController.oJa = (Button) radarViewController.findViewById(R.h.cuR);
        radarViewController.oJa.setOnClickListener(radarViewController.oJi);
        radarViewController.oJb = radarViewController.findViewById(R.h.cuE);
        radarViewController.oIT = (RadarWaveView) ((Activity) radarViewController.getContext()).findViewById(R.h.cvc);
        RadarWaveView radarWaveView = radarViewController.oIT;
        radarWaveView.oJI = radarWaveView.findViewById(R.h.cuV);
        radarWaveView.oJJ = AnimationUtils.loadAnimation(radarWaveView.getContext(), R.a.aRA);
        radarWaveView.oJJ.setInterpolator(new LinearInterpolator());
        b.a.a((ImageView) radarViewController.findViewById(R.h.cCs), m.xL());
        radarViewController.oIU = (RadarMemberView) radarViewController.findViewById(R.h.cuI);
        radarViewController.oIU.oHR = new RadarMemberView.a(radarViewController) {
            final /* synthetic */ RadarViewController oJm;

            {
                this.oJm = r1;
            }

            public final void b(ati com_tencent_mm_protocal_c_ati, d dVar) {
                String b = c.b(com_tencent_mm_protocal_c_ati);
                switch (dVar) {
                    case Stranger:
                        this.oJm.oJc.aVF().put(Long.valueOf(this.oJm.oJd.De(b)), new com.tencent.mm.plugin.radar.a.e.b(com_tencent_mm_protocal_c_ati, dVar));
                        this.oJm.d(b, d.Verifying);
                        return;
                    case NeedVerify:
                        long j;
                        com.tencent.mm.plugin.radar.a.c e = this.oJm.oJd;
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(b);
                        String str = bg.mz(Rc.field_username).equals("") ? b : Rc.field_username;
                        String str2 = (String) e.oGw.get(str);
                        if (str2 == null || str2.equals("")) {
                            w.e("MicroMsg.RadarAddContact", "Verify Contact username(%s) error, verifyTicket is null", new Object[]{str});
                            e.De(str);
                            j = -1;
                        } else {
                            au.d RI = au.d.RI(str2);
                            long currentTimeMillis = System.currentTimeMillis();
                            a aVar = new a(e, new com.tencent.mm.plugin.radar.a.c.AnonymousClass4(e, str2, currentTimeMillis));
                            String str3 = RI.osP;
                            String str4 = "username is null";
                            boolean z = str != null && str.length() > 0;
                            Assert.assertTrue(str4, z);
                            aVar.onStart();
                            ap.vd().a(new n(str, str3, 48), 0);
                            j = currentTimeMillis;
                        }
                        this.oJm.oJc.aVF().put(Long.valueOf(j), new com.tencent.mm.plugin.radar.a.e.b(com_tencent_mm_protocal_c_ati, dVar));
                        this.oJm.d(b, d.Verifying);
                        return;
                    default:
                        return;
                }
            }

            public final void c(ati com_tencent_mm_protocal_c_ati, d dVar) {
                View view = (View) this.oJm.oJe.oJz.get(c.b(com_tencent_mm_protocal_c_ati));
                if (view != null) {
                    a aVar = (a) view.getTag();
                    if (dVar != d.Stranger) {
                        aVar.oJE.aVP();
                    }
                }
                this.oJm.oIT.aVW();
            }
        };
        radarViewController.oIV = (RadarSpecialGridView) radarViewController.findViewById(R.h.cuX);
        radarViewController.oJe = new b(radarViewController, radarViewController.oIV, radarViewController.getContext());
        radarViewController.oIV.a(new RadarSpecialGridView.a(radarViewController) {
            final /* synthetic */ RadarViewController oJm;

            {
                this.oJm = r1;
            }

            public final void e(int i, final View view) {
                final ati com_tencent_mm_protocal_c_ati = this.oJm.oJe.oJu[i];
                if (com_tencent_mm_protocal_c_ati != null) {
                    switch (this.oJm.oJf) {
                        case SEARCHING:
                        case SEARCH_RETRUN:
                            String b = c.b(com_tencent_mm_protocal_c_ati);
                            if (!b.d(com_tencent_mm_protocal_c_ati)) {
                                View view2 = (View) this.oJm.oJe.oJz.get(b);
                                final d a = this.oJm.oJc.a(com_tencent_mm_protocal_c_ati, false);
                                if (view2 == null || a == d.Stranger) {
                                    this.oJm.oIU.a(view, com_tencent_mm_protocal_c_ati, a);
                                    this.oJm.oIT.aVX();
                                    return;
                                }
                                ((a) view2.getTag()).oJE.aVQ();
                                new ae().postDelayed(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass4 oJo;

                                    public final void run() {
                                        this.oJo.oJm.oIU.a(view, com_tencent_mm_protocal_c_ati, a);
                                        this.oJo.oJm.oIT.aVX();
                                    }
                                }, 300);
                                return;
                            }
                            return;
                        case RALATIONCHAIN_RETRUN:
                            if (!b.d(com_tencent_mm_protocal_c_ati)) {
                                int i2;
                                b b2 = this.oJm.oJe;
                                if (b2.oJv == null) {
                                    b2.oJv = new HashMap();
                                }
                                if (com_tencent_mm_protocal_c_ati != null) {
                                    Object b3 = c.b(com_tencent_mm_protocal_c_ati);
                                    if (b2.oJm.oJc.aVE().containsKey(b3)) {
                                        b3 = (String) b2.oJm.oJc.aVE().get(b3);
                                    }
                                    if (b2.oJv.containsKey(b3)) {
                                        i2 = 1;
                                        if (i2 != 0) {
                                            this.oJm.oJe.e(com_tencent_mm_protocal_c_ati);
                                        } else {
                                            this.oJm.oJe.f(com_tencent_mm_protocal_c_ati);
                                        }
                                    }
                                }
                                boolean z = false;
                                if (i2 != 0) {
                                    this.oJm.oJe.f(com_tencent_mm_protocal_c_ati);
                                } else {
                                    this.oJm.oJe.e(com_tencent_mm_protocal_c_ati);
                                }
                            }
                            this.oJm.oJc.a(com_tencent_mm_protocal_c_ati);
                            this.oJm.aVU();
                            this.oJm.oJe.aVJ();
                            return;
                        default:
                            w.d("MicroMsg.Radar.RadarViewController", "unknow status for grid view %s", new Object[]{this.oJm.oJf});
                            return;
                    }
                }
            }
        });
        RadarViewController radarViewController2 = this.oHZ;
        c cVar = radarViewController2.oJd;
        ap.yY();
        com.tencent.mm.u.c.wR().a(cVar);
        com.tencent.mm.sdk.b.a.urY.b(cVar.oGy);
        ap.getSysCmdMsgExtension().a("addcontact", cVar.lew, true);
        e eVar = radarViewController2.oJc;
        ap.vd().a(425, eVar);
        ap.vd().a(602, eVar);
        ap.yY();
        int intValue = ((Integer) com.tencent.mm.u.c.vr().get(229377, Integer.valueOf(0))).intValue() + 1;
        ap.yY();
        com.tencent.mm.u.c.vr().set(229377, Integer.valueOf(intValue));
    }

    public void onResume() {
        super.onResume();
        if (this.oIa) {
            w.i("MicroMsg.RadarSearchUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                aVK();
            }
        }
    }

    private void aVK() {
        gw(true);
        com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.oGP;
        dVar.fOw = 0;
        dVar.oGT = 0;
        dVar.oGT = com.tencent.mm.plugin.radar.a.d.aVA();
        dVar = com.tencent.mm.plugin.radar.a.d.oGP;
        dVar.oGU = 0;
        dVar.oGS = 0;
        dVar.oGQ = 0;
        dVar.oGR = 0;
        dVar.oGS = com.tencent.mm.plugin.radar.a.d.aVA();
        if (this.oHZ.oJf == com.tencent.mm.plugin.radar.a.e.d.SEARCHING || this.oHZ.oJf == com.tencent.mm.plugin.radar.a.e.d.SEARCH_RETRUN) {
            com.tencent.mm.plugin.radar.a.e eVar = this.oHZ.oJc;
            if (eVar.hvP != null) {
                eVar.hvP.a(eVar.gKp, true);
            }
            this.oHZ.oJc.aVB();
            this.oHZ.oIT.aVW();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.RadarSearchUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 64:
                if (iArr[0] == 0) {
                    aVK();
                    return;
                }
                this.oIa = false;
                g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RadarSearchUI oIb;

                    {
                        this.oIb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oIb.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        this.oIb.oIa = true;
                        this.oIb.finish();
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ RadarSearchUI oIb;

                    {
                        this.oIb = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oIb.oIa = true;
                        this.oIb.finish();
                    }
                });
                return;
            default:
                return;
        }
    }

    public void onPause() {
        long aVA;
        int i;
        super.onPause();
        gw(false);
        com.tencent.mm.plugin.radar.a.d dVar = com.tencent.mm.plugin.radar.a.d.oGP;
        if (dVar.oGT != 0) {
            boolean z;
            aVA = com.tencent.mm.plugin.radar.a.d.aVA() - dVar.oGT;
            if (aVA <= 500) {
                i = 1;
            } else {
                z = false;
            }
            if (i == 0) {
                i = 1;
            } else {
                z = false;
            }
            if (i != 0) {
                i = dVar.fOw;
                w.d("MicroMsg.RadarKvStatReport", "FoundFriendsCnt %d", new Object[]{Integer.valueOf(i)});
                com.tencent.mm.plugin.report.service.g.oUh.A(10679, String.format("%d", new Object[]{Integer.valueOf(i)}));
                dVar.oGQ++;
                dVar.oGR = aVA + dVar.oGR;
                dVar.oGT = 0;
            }
        }
        com.tencent.mm.plugin.radar.a.d dVar2 = com.tencent.mm.plugin.radar.a.d.oGP;
        if (dVar2.oGS != 0) {
            aVA = System.currentTimeMillis() - dVar2.oGS;
            int i2 = dVar2.oGQ;
            float f = (((float) dVar2.oGR) * 1.0f) / 1000.0f;
            i = dVar2.oGU;
            float f2 = (((float) aVA) * 1.0f) / 1000.0f;
            w.d("MicroMsg.RadarKvStatReport", "RadarAddFriendStat %d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2)});
            com.tencent.mm.plugin.report.service.g.oUh.A(10676, String.format("%d,%d,%s,%d,%s", new Object[]{Integer.valueOf(1), Integer.valueOf(i2), Float.valueOf(f), Integer.valueOf(i), Float.valueOf(f2)}));
        }
        if (this.oHZ.oJf == com.tencent.mm.plugin.radar.a.e.d.SEARCHING || this.oHZ.oJf == com.tencent.mm.plugin.radar.a.e.d.SEARCH_RETRUN) {
            this.oHZ.oJc.aVC();
            com.tencent.mm.plugin.radar.a.e eVar = this.oHZ.oJc;
            if (eVar.hvP != null) {
                eVar.hvP.c(eVar.gKp);
            }
            this.oHZ.oIT.aVX();
        }
    }

    public void onDestroy() {
        if (this.oHZ != null) {
            RadarViewController radarViewController = this.oHZ;
            c cVar = radarViewController.oJd;
            ap.yY();
            com.tencent.mm.u.c.wR().b(cVar);
            com.tencent.mm.sdk.b.a.urY.c(cVar.oGy);
            ap.getSysCmdMsgExtension().b("addcontact", cVar.lew, true);
            com.tencent.mm.plugin.radar.a.e eVar = radarViewController.oJc;
            ap.vd().b(425, eVar);
            ap.vd().b(602, eVar);
            eVar.stop();
            if (eVar.hvP != null) {
                eVar.hvP.c(eVar.gKp);
            }
            RadarWaveView radarWaveView = radarViewController.oIT;
            try {
                if (radarWaveView.oJH != null) {
                    radarWaveView.oJH.stop();
                    radarWaveView.oJH.release();
                    radarWaveView.oJH = null;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.RadarWaveView", e, "", new Object[0]);
                w.e("MicroMsg.RadarWaveView", "stop() crash, because of the native mediaplay is null.");
                radarWaveView.oJH = null;
            }
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = false;
        if (this.oHZ != null) {
            z = this.oHZ.onKeyDown(i, keyEvent);
        }
        return z ? z : super.onKeyDown(i, keyEvent);
    }

    private static void gw(boolean z) {
        com.tencent.mm.sdk.b.b qmVar = new qm();
        qmVar.fXC.fXD = z;
        com.tencent.mm.sdk.b.a.urY.m(qmVar);
    }

    public Object getSystemService(String str) {
        Object systemService = super.getSystemService(str);
        if ("layout_inflater".equals(str)) {
            return r.b((LayoutInflater) systemService);
        }
        return systemService;
    }
}
