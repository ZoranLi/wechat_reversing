package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.i.a;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.x.b;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;

public class BottleWizardStep1 extends MMActivity {
    private ImageView jWN = null;

    static /* synthetic */ boolean a(BottleWizardStep1 bottleWizardStep1) {
        ap.yY();
        if (c.isSDCardAvailable()) {
            g.a(bottleWizardStep1, "", bottleWizardStep1.getResources().getStringArray(R.c.aRY), "", new g.c(bottleWizardStep1) {
                final /* synthetic */ BottleWizardStep1 jWO;

                {
                    this.jWO = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            w.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.jWO.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.jWO.uSU.uTo});
                            if (a.a(this.jWO.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                                this.jWO.adG();
                                return;
                            }
                            return;
                        case 1:
                            k.a(this.jWO, 2, null);
                            return;
                        default:
                            return;
                    }
                }
            });
            return true;
        }
        s.eP(bottleWizardStep1);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    private void adF() {
        Bitmap a;
        Bitmap a2 = b.a(x.QR(m.xL()), false, -1);
        if (a2 == null) {
            a = b.a(m.xL(), false, -1);
        } else {
            a = a2;
        }
        this.jWN = (ImageView) findViewById(R.h.bWT);
        if (a != null) {
            this.jWN.setImageBitmap(a);
        }
    }

    protected void onResume() {
        super.onResume();
        KC();
        adF();
    }

    protected final int getLayoutId() {
        return R.i.cVY;
    }

    protected final void KC() {
        zi(R.l.dPj);
        ((LinearLayout) findViewById(R.h.bWU)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BottleWizardStep1 jWO;

            {
                this.jWO = r1;
            }

            public final void onClick(View view) {
                BottleWizardStep1.a(this.jWO);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep1 jWO;

            {
                this.jWO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jWO.aHf();
                this.jWO.finish();
                return true;
            }
        });
        a(0, getString(R.l.dHP), new OnMenuItemClickListener(this) {
            final /* synthetic */ BottleWizardStep1 jWO;

            {
                this.jWO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jWO.startActivity(new Intent().setClass(this.jWO, BottleWizardStep2.class));
                this.jWO.finish();
                return true;
            }
        });
    }

    private void adG() {
        if (!k.c(this, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eQD), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.BottleWizardStep1", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ BottleWizardStep1 jWO;

                        {
                            this.jWO = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.jWO.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Context applicationContext;
        String b;
        Intent intent2;
        switch (i) {
            case 2:
                if (intent != null) {
                    applicationContext = getApplicationContext();
                    ap.yY();
                    b = k.b(applicationContext, intent, c.xb());
                    if (b != null) {
                        intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 1);
                        intent2.putExtra("CropImage_ImgPath", b);
                        StringBuilder stringBuilder = new StringBuilder();
                        n.Bl();
                        intent2.putExtra("CropImage_OutputPath", stringBuilder.append(d.r(x.QR(m.xL()), true)).append(".crop").toString());
                        com.tencent.mm.plugin.bottle.a.imv.a(intent2, 4, this, intent);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                applicationContext = getApplicationContext();
                ap.yY();
                b = k.b(applicationContext, intent, c.xb());
                if (b != null) {
                    intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 1);
                    intent2.putExtra("CropImage_OutputPath", b);
                    intent2.putExtra("CropImage_ImgPath", b);
                    com.tencent.mm.plugin.bottle.a.imv.a(this, intent2, 4);
                    return;
                }
                return;
            case 4:
                if (intent != null) {
                    b = intent.getStringExtra("CropImage_OutputPath");
                    if (b == null) {
                        w.e("MicroMsg.BottleWizardStep1", "crop picture failed");
                        return;
                    } else {
                        new o(this.uSU.uTo, b).b(2, new Runnable(this) {
                            final /* synthetic */ BottleWizardStep1 jWO;

                            {
                                this.jWO = r1;
                            }

                            public final void run() {
                                this.jWO.adF();
                            }
                        });
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }
}
