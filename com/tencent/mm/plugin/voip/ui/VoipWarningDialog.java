package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.x;

public class VoipWarningDialog extends MMBaseActivity {
    public static int rnY = 1234;
    private static a rnZ;
    private h ihw = null;

    public interface a {
        void a(VoipWarningDialog voipWarningDialog);

        void b(VoipWarningDialog voipWarningDialog);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        Nj();
    }

    protected void onResume() {
        super.onResume();
        x.a(true, null);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (this.ihw != null) {
            this.ihw.dismiss();
            this.ihw = null;
        }
        Nj();
    }

    protected void onPause() {
        super.onPause();
        x.a(false, null);
    }

    private void Nj() {
        if (getIntent() == null) {
            w.e("MicroMsg.VoipWarningDialog", "Intent is null");
            return;
        }
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            w.e("MicroMsg.VoipWarningDialog", "invalid params");
            return;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(this);
        aVar.SW(getString(R.l.fcb));
        aVar.SX(extras.getString("warning_content"));
        aVar.d(new OnCancelListener(this) {
            final /* synthetic */ VoipWarningDialog roa;

            {
                this.roa = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.roa.finish();
            }
        });
        aVar.zZ(d.eo(23) ? R.l.fca : R.l.fbZ).a(new OnClickListener(this) {
            final /* synthetic */ VoipWarningDialog roa;

            {
                this.roa = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.eo(23)) {
                    try {
                        if (!bg.mA((String) Settings.class.getField("ACTION_MANAGE_OVERLAY_PERMISSION").get(Settings.class))) {
                            this.roa.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + ab.getPackageName())), VoipWarningDialog.rnY);
                            return;
                        }
                    } catch (Exception e) {
                        w.e("MicroMsg.VoipWarningDialog", "getField:ACTION_MANAGE_OVERLAY_PERMISSION! Error:%s, etype:%s", new Object[]{e.getMessage(), e.getClass().getCanonicalName()});
                    }
                }
                String string = this.roa.getString(R.l.fcc);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", string);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                com.tencent.mm.bb.d.b(this.roa, "webview", ".ui.tools.WebViewUI", intent);
                this.roa.finish();
            }
        });
        this.ihw = aVar.WJ();
        this.ihw.setCanceledOnTouchOutside(false);
        this.ihw.show();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (rnZ != null) {
            if (i != rnY) {
                rnZ.b(this);
            } else if (b.aA(ab.getContext())) {
                rnZ.a(this);
            } else {
                rnZ.b(this);
            }
        }
    }

    public static void a(Context context, a aVar) {
        rnZ = aVar;
        Intent intent = new Intent(context, VoipWarningDialog.class);
        intent.putExtra("warning_content", ab.getContext().getString(R.l.fbY));
        intent.addFlags(805306368);
        context.startActivity(intent);
    }
}
