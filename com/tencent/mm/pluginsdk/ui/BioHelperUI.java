package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public class BioHelperUI extends MMActivity {
    private String jia;
    private String kwg;
    private int lav;
    private int mType;
    private String mWA;
    private String sIn;
    private b sIo;

    private interface b {
        void Z(Intent intent);

        String bEb();

        int bEc();

        String bEd();

        String bEe();

        void d(int i, int i2, Intent intent);

        void dC(Context context);
    }

    private class a implements b {
        final /* synthetic */ BioHelperUI sIp;

        public a(BioHelperUI bioHelperUI) {
            this.sIp = bioHelperUI;
        }

        public final void Z(Intent intent) {
        }

        public final String bEb() {
            return this.sIp.getString(R.l.dOK);
        }

        public final int bEc() {
            return R.g.beZ;
        }

        public final String bEd() {
            return this.sIp.getString(R.l.dOL);
        }

        public final String bEe() {
            return this.sIp.getString(R.l.dOI);
        }

        public final void dC(Context context) {
            Intent intent = new Intent();
            intent.putExtra("k_user_name", this.sIp.jia);
            intent.putExtra("k_purpose", 2);
            intent.putExtra("k_need_signature", true);
            intent.putExtra("k_ticket", this.sIp.kwg);
            d.b(this.sIp.uSU.uTo, "facedetect", ".ui.FaceDetectUI", intent, 1025);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == 2) {
                this.sIp.finish();
                String stringExtra = intent.getStringExtra("KFaceLoginAuthPwd");
                String str = "MicroMsg.BioHelperUI";
                String str2 = "hy: secondary check onActivityResult, do faceprint auth, authPwd is null:%b, authPwd.len:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Boolean.valueOf(bg.mA(stringExtra));
                if (!bg.mA(stringExtra)) {
                    i3 = stringExtra.length();
                }
                objArr[1] = Integer.valueOf(i3);
                w.i(str, str2, objArr);
            }
        }
    }

    private class c implements b {
        private int hPi;
        final /* synthetic */ BioHelperUI sIp;

        public c(BioHelperUI bioHelperUI) {
            this.sIp = bioHelperUI;
        }

        public final void Z(Intent intent) {
            if (intent != null) {
                this.hPi = intent.getIntExtra("kscene_type", 73);
            }
        }

        public final String bEb() {
            return this.sIp.getString(R.l.dON);
        }

        public final int bEc() {
            return R.g.bla;
        }

        public final String bEd() {
            return this.sIp.getString(R.l.dOM);
        }

        public final String bEe() {
            return this.sIp.getString(R.l.dOJ);
        }

        public final void dC(Context context) {
            Intent intent = new Intent();
            intent.putExtra("kscene_type", this.hPi);
            intent.putExtra("Kusername", this.sIp.jia);
            intent.putExtra("Kvertify_key", this.sIp.kwg);
            d.b(context, "voiceprint", ".ui.VoiceLoginUI", intent, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }

        public final void d(int i, int i2, Intent intent) {
            int i3 = 0;
            if (i2 == -1) {
                if (i == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT && intent != null) {
                    String stringExtra = intent.getStringExtra("VoiceLoginAuthPwd");
                    String str = "MicroMsg.BioHelperUI";
                    String str2 = "onActivityResult, do voiceprint auth, authPwd is null:%b, authPwd.len:%d";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(bg.mA(stringExtra));
                    if (!bg.mA(stringExtra)) {
                        i3 = stringExtra.length();
                    }
                    objArr[1] = Integer.valueOf(i3);
                    w.d(str, str2, objArr);
                    Intent intent2 = new Intent();
                    intent2.putExtra("VoiceLoginAuthPwd", stringExtra);
                    intent2.putExtra("KVoiceHelpCode", this.sIp.lav);
                    this.sIp.setResult(-1, intent2);
                }
                this.sIp.finish();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        b bVar = null;
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("k_type", 1);
        w.i("MicroMsg.BioHelperUI", "hy: starting to bio helper ui, type: %d", Integer.valueOf(this.mType));
        this.jia = bg.ap(getIntent().getStringExtra("Kusername"), null);
        this.kwg = bg.ap(getIntent().getStringExtra("Kvertify_key"), null);
        this.sIn = bg.ap(getIntent().getStringExtra("KVoiceHelpUrl"), null);
        this.mWA = bg.ap(getIntent().getStringExtra("KVoiceHelpWording"), null);
        this.lav = getIntent().getIntExtra("KVoiceHelpCode", 0);
        if (this.mType == 0) {
            bVar = new c(this);
        } else if (this.mType == 1) {
            bVar = new a(this);
        } else {
            w.e("MicroMsg.BioHelperUI", "hy: invalid type!!!");
        }
        this.sIo = bVar;
        if (this.sIo == null || bg.mA(this.jia) || bg.mA(this.kwg)) {
            w.w("MicroMsg.BioHelperUI", "type or username or ticket is null and finish");
            finish();
            return;
        }
        TextView textView = (TextView) findViewById(R.h.btF);
        if (bg.mA(this.mWA)) {
            textView.setText(this.sIo.bEe());
        } else {
            textView.setText(this.mWA);
        }
        qP(this.sIo.bEb());
        ((ImageView) findViewById(R.h.btD)).setImageResource(this.sIo.bEc());
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BioHelperUI sIp;

            {
                this.sIp = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sIp.finish();
                return true;
            }
        });
        this.sIo.Z(getIntent());
        Button button = (Button) findViewById(R.h.btG);
        button.setText(this.sIo.bEd());
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BioHelperUI sIp;

            {
                this.sIp = r1;
            }

            public final void onClick(View view) {
                this.sIp.sIo.dC(this.sIp);
            }
        });
        findViewById(R.h.btE).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BioHelperUI sIp;

            {
                this.sIp = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", new StringBuilder(this.sIp.sIn).toString());
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                d.b(this.sIp, "webview", ".ui.tools.WebViewUI", intent);
                this.sIp.finish();
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cVJ;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        boolean z = true;
        super.onActivityResult(i, i2, intent);
        String str = "MicroMsg.BioHelperUI";
        String str2 = "onActivityResult, requestCode:%d, resultCode:%d, data==null:%b";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (intent != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        this.sIo.d(i, i2, intent);
    }
}
