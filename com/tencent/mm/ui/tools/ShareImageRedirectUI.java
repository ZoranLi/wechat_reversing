package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.transmit.ShareImageSelectorUI;
import java.util.ArrayList;

@a(7)
public class ShareImageRedirectUI extends MMBaseActivity {
    private String imagePath;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.ShareImageRedirectUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this});
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 16, "", "")) {
            adG();
        }
    }

    private void adG() {
        k.c(this, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 0);
        getWindow().getDecorView().setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ShareImageRedirectUI wot;

            {
                this.wot = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                Toast.makeText(this.wot, R.l.eWo, 1).show();
                this.wot.finish();
                return false;
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.ShareImageRedirectUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ ShareImageRedirectUI wot;

                        {
                            this.wot = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.wot.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                            this.wot.finish();
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ ShareImageRedirectUI wot;

                        {
                            this.wot = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.wot.finish();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList = null;
        getWindow().getDecorView().setOnTouchListener(null);
        if (i2 != -1) {
            finish();
            return;
        }
        Intent intent2;
        switch (i) {
            case 0:
                Context applicationContext = getApplicationContext();
                ap.yY();
                this.imagePath = k.b(applicationContext, intent, c.xb());
                if (this.imagePath != null) {
                    intent2 = new Intent(this, ShareImageSelectorUI.class);
                    intent2.putExtra("intent_extra_image_path", this.imagePath);
                    startActivityForResult(intent2, 2);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    arrayList = intent.getStringArrayListExtra("Select_Contact");
                }
                if (arrayList != null && arrayList.size() == 1) {
                    Intent intent3 = new Intent(this, En_5b8fbb1e.class);
                    intent3.putExtra("Chat_User", (String) arrayList.get(0));
                    startActivity(intent3);
                    finish();
                    return;
                } else if (arrayList == null || arrayList.size() <= 1) {
                    intent2 = new Intent();
                    intent2.putExtra("Ksnsupload_type", 0);
                    intent2.putExtra("sns_kemdia_path", this.imagePath);
                    d.b(this, "sns", ".ui.En_c4f742e5", intent2);
                    finish();
                    return;
                } else {
                    finish();
                    return;
                }
            default:
                return;
        }
    }
}
