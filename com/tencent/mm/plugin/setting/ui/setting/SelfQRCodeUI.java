package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.FileObserver;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.y.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class SelfQRCodeUI extends MMActivity implements e {
    private static final String pjd = (h.getExternalStorageDirectory().toString() + "/Pictures/Screenshots/");
    private Bitmap hqW = null;
    private ProgressDialog isv = null;
    private ImageView jbU = null;
    private long kBQ;
    private TextView piZ = null;
    private ImageView piu = null;
    private byte[] piv = null;
    private TextView pja = null;
    private boolean pjb = false;
    private a pjc;
    private String userName = "";

    public class a extends FileObserver {
        final /* synthetic */ SelfQRCodeUI pje;
        private MMActivity pjf;
        private String pjg;

        public a(SelfQRCodeUI selfQRCodeUI, MMActivity mMActivity) {
            this.pje = selfQRCodeUI;
            super(SelfQRCodeUI.pjd, 8);
            this.pjf = mMActivity;
        }

        public final void onEvent(int i, String str) {
            if (str != null && i == 8) {
                if (this.pjg == null || !str.equalsIgnoreCase(this.pjg)) {
                    this.pjg = str;
                    Uri.fromFile(new File(SelfQRCodeUI.pjd + str));
                    SelfQRCodeUI.aZQ();
                    w.i("MicroMsg.SelfQRCodeNewUI$ScreenshotObserver", "Send event to listener.");
                }
            }
        }

        public final void start() {
            super.startWatching();
        }

        public final void stop() {
            super.stopWatching();
        }
    }

    static /* synthetic */ void b(SelfQRCodeUI selfQRCodeUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(selfQRCodeUI, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new c(selfQRCodeUI) {
            final /* synthetic */ SelfQRCodeUI pje;

            {
                this.pje = r1;
            }

            public final void a(l lVar) {
                boolean dH = o.dH(this.pje.userName);
                boolean ib = com.tencent.mm.modelbiz.e.ib(this.pje.userName);
                if (!(ib || dH)) {
                    lVar.dX(2, R.l.eQF);
                }
                lVar.dX(1, R.l.eQJ);
                if (!ib) {
                    lVar.dX(3, R.l.eQU);
                }
                if (this.pje.pjb) {
                    lVar.dX(4, R.l.eQT);
                }
            }
        };
        eVar.qJg = new d(selfQRCodeUI) {
            final /* synthetic */ SelfQRCodeUI pje;

            {
                this.pje = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        SelfQRCodeUI.e(this.pje);
                        return;
                    case 2:
                        this.pje.sp(0);
                        return;
                    case 3:
                        if (!com.tencent.mm.n.a.aI(this.pje.uSU.uTo) && !com.tencent.mm.n.a.aH(this.pje.uSU.uTo)) {
                            com.tencent.mm.bb.d.w(this.pje.uSU.uTo, "scanner", ".ui.BaseScanUI");
                            return;
                        }
                        return;
                    case 4:
                        g.a((Context) this.pje, true, this.pje.getString(R.l.eLM), this.pje.getString(R.l.eLN), this.pje.getString(R.l.eLO), this.pje.getString(R.l.cancel), new OnClickListener(this.pje) {
                            final /* synthetic */ SelfQRCodeUI pje;

                            {
                                this.pje = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.pje.sp(2);
                            }
                        }, null);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    static /* synthetic */ void e(SelfQRCodeUI selfQRCodeUI) {
        byte[] toByteArray;
        FileOutputStream fileOutputStream;
        Throwable e;
        if (o.dH(selfQRCodeUI.userName) || com.tencent.mm.modelbiz.e.ib(selfQRCodeUI.userName)) {
            com.tencent.mm.plugin.report.service.g.oUh.a(219, 10, 1, true);
            Bitmap cV = com.tencent.mm.sdk.platformtools.d.cV(selfQRCodeUI.findViewById(R.h.cur));
            if (cV != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                cV.compress(CompressFormat.PNG, 90, byteArrayOutputStream);
                toByteArray = byteArrayOutputStream.toByteArray();
            } else {
                toByteArray = null;
            }
            if (toByteArray == null) {
                toByteArray = selfQRCodeUI.piv;
            }
        } else {
            toByteArray = selfQRCodeUI.piv;
        }
        if (toByteArray != null && toByteArray.length > 0) {
            String str = k.bGD() + "mmqrcode" + System.currentTimeMillis() + ".png";
            try {
                fileOutputStream = new FileOutputStream(str);
                try {
                    fileOutputStream.write(toByteArray);
                    Toast.makeText(selfQRCodeUI, selfQRCodeUI.getString(R.l.eaX, new Object[]{k.bGD()}), 1).show();
                    k.b(str, selfQRCodeUI);
                    try {
                        fileOutputStream.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        w.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                    } catch (Throwable th) {
                        e = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        throw e;
                    }
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                w.printErrStackTrace("MicroMsg.SelfQRCodeNewUI", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th2) {
                e = th2;
                fileOutputStream = null;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dnO;
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pjc = new a(this, this);
        this.pjc.start();
        ap.vd().a((int) bw.CTRL_INDEX, (e) this);
        KC();
        this.piu.post(new Runnable(this) {
            final /* synthetic */ SelfQRCodeUI pje;

            {
                this.pje = r1;
            }

            public final void run() {
                int width = this.pje.piu.getWidth();
                LayoutParams layoutParams = (LayoutParams) this.pje.piu.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                this.pje.piu.setLayoutParams(layoutParams);
            }
        });
    }

    public void onDestroy() {
        ap.vd().b((int) bw.CTRL_INDEX, (e) this);
        if (this.pjc != null) {
            this.pjc.stop();
        }
        if (!(this.hqW == null || this.hqW.isRecycled())) {
            this.hqW.recycle();
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        if (!o.dH(this.userName) && !com.tencent.mm.modelbiz.e.ib(this.userName)) {
            View findViewById = findViewById(R.h.cCr);
            this.kBQ = m.xQ();
            w.d("MicroMsg.SelfQRCodeNewUI", (this.kBQ & 2) + ",extstatus:" + this.kBQ);
            if ((this.kBQ & 2) != 0) {
                findViewById.setVisibility(0);
                this.piu.setAlpha(0.1f);
                findViewById(R.h.cCq).setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ SelfQRCodeUI pje;

                    {
                        this.pje = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.bb.d.w(this.pje, "setting", ".ui.setting.SettingsAddMeUI");
                    }
                });
                return;
            }
            findViewById.setVisibility(8);
            this.piu.setAlpha(1.0f);
        }
    }

    protected final void KC() {
        this.userName = getIntent().getStringExtra("from_userName");
        if (bg.mA(this.userName)) {
            this.userName = m.xL();
        }
        if (m.xL().equals(this.userName)) {
            this.pjb = true;
        }
        if (o.dH(this.userName)) {
            zi(R.l.eTU);
            ((TextView) findViewById(R.h.cuA)).setText("");
            kr(false);
        } else if (com.tencent.mm.modelbiz.e.ib(this.userName)) {
            zi(R.l.eeQ);
            ((TextView) findViewById(R.h.cuA)).setText(R.l.eeR);
            kr(false);
        } else {
            zi(R.l.eTN);
        }
        this.piu = (ImageView) findViewById(R.h.cCo);
        this.jbU = (ImageView) findViewById(R.h.bWa);
        this.piZ = (TextView) findViewById(R.h.coc);
        this.pja = (TextView) findViewById(R.h.bJD);
        CharSequence charSequence;
        if (!o.dH(this.userName) && !com.tencent.mm.modelbiz.e.ib(this.userName)) {
            ap.yY();
            String str = (String) com.tencent.mm.u.c.vr().get(42, null);
            String string = getString(R.l.dHi);
            if (bg.mA(str)) {
                ap.yY();
                str = (String) com.tencent.mm.u.c.vr().get(2, null);
                string = string + str;
                x.QQ(str);
                str = string;
            } else {
                str = string + str;
            }
            w.d("MicroMsg.SelfQRCodeNewUI", "display user name = %s", str);
            if (this.hqW == null) {
                w.d("MicroMsg.SelfQRCodeNewUI", "%s", "bitmap == null");
                sp(1);
            } else {
                this.piu.setImageBitmap(this.hqW);
            }
            b.a(this.jbU, m.xL());
            ap.yY();
            w.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", (String) com.tencent.mm.u.c.vr().get(4, null));
            this.piZ.setText(com.tencent.mm.pluginsdk.ui.d.h.c((Context) this, charSequence, com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXs)));
            com.tencent.mm.u.bg zL = com.tencent.mm.u.bg.zL();
            string = bg.mz(zL.getProvince());
            w.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", n.eM(string) + " " + bg.mz(zL.getCity()));
            this.pja.setText(charSequence);
            ap.yY();
            switch (bg.a((Integer) com.tencent.mm.u.c.vr().get(12290, null), 0)) {
                case 1:
                    this.piZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this, R.k.dxs), null);
                    break;
                case 2:
                    this.piZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bg.a.a(this, R.k.dxr), null);
                    break;
                default:
                    break;
            }
        }
        sp(1);
        b.a(this.jbU, this.userName);
        ap.yY();
        af Rc = com.tencent.mm.u.c.wR().Rc(this.userName);
        this.piZ.setSingleLine(false);
        this.piZ.setMaxLines(3);
        this.piZ.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        if (Rc != null) {
            charSequence = Rc.field_nickname;
            if (bg.mA(charSequence)) {
                ap.yY();
                charSequence = com.tencent.mm.u.c.xa().fW(this.userName).field_displayname;
            }
            this.piZ.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this, charSequence, this.piZ.getTextSize()));
        } else {
            this.piZ.setVisibility(8);
        }
        this.pja.setVisibility(8);
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ SelfQRCodeUI pje;

            {
                this.pje = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SelfQRCodeUI.b(this.pje);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelfQRCodeUI pje;

            {
                this.pje = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pje.aHf();
                this.pje.finish();
                return true;
            }
        });
    }

    private void sp(int i) {
        int f;
        if (this.pjb) {
            ap.yY();
            f = bg.f((Integer) com.tencent.mm.u.c.vr().get(66561, null));
        } else {
            f = 0;
        }
        final com.tencent.mm.y.k aVar = new com.tencent.mm.aq.a(this.userName, f, i);
        ap.vd().a(aVar, 0);
        Context context = this.uSU.uTo;
        getString(R.l.dIO);
        this.isv = g.a(context, getString(R.l.eQI), true, new OnCancelListener(this) {
            final /* synthetic */ SelfQRCodeUI pje;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(aVar);
                if (o.dH(this.pje.userName) || com.tencent.mm.modelbiz.e.ib(this.pje.userName)) {
                    this.pje.finish();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        com.tencent.mm.aq.a aVar = (com.tencent.mm.aq.a) kVar;
        if (kVar.getType() == bw.CTRL_INDEX && !com.tencent.mm.plugin.setting.a.imw.b(this.uSU.uTo, i, i2, str)) {
            if (i == 0 && i2 == 0) {
                this.piv = aVar.hOD;
                this.hqW = com.tencent.mm.sdk.platformtools.d.bd(this.piv);
                if (o.dH(this.userName) || com.tencent.mm.modelbiz.e.ib(this.userName)) {
                    kr(true);
                    CharSequence charSequence = aVar.hOB;
                    if (!bg.mA(charSequence)) {
                        ((TextView) findViewById(R.h.cuA)).setText(charSequence);
                    }
                } else if (this.pjb) {
                    CharSequence charSequence2 = aVar.hOC;
                    TextView textView = (TextView) findViewById(R.h.cIQ);
                    View view = (View) textView.getParent();
                    if (bg.mA(charSequence2)) {
                        view.setVisibility(8);
                    } else {
                        textView.setText(charSequence2);
                        view.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ SelfQRCodeUI pje;

                            {
                                this.pje = r1;
                            }

                            public final void onClick(View view) {
                                g.a((Context) this.pje, true, this.pje.getString(R.l.eLM), this.pje.getString(R.l.eLN), this.pje.getString(R.l.eLO), this.pje.getString(R.l.cancel), /* anonymous class already generated */, null);
                            }
                        });
                        view.setVisibility(0);
                    }
                }
                this.piu.setImageBitmap(this.hqW);
                return;
            }
            Toast.makeText(this, getString(R.l.elS, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
        }
    }

    public static void aZQ() {
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 14, 1, true);
    }
}
