package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bv;
import com.tencent.mm.e.a.gn;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@com.tencent.mm.ui.base.a(3)
public abstract class AutoLoginActivity extends MMActivity {

    public static class a {
        long s = System.currentTimeMillis();
        private c<bv> sHZ;
        private final AtomicBoolean sIa = new AtomicBoolean(true);

        public final boolean b(Runnable runnable, final Runnable runnable2) {
            if (h.vG().gXp) {
                runnable2.run();
                return true;
            }
            if (runnable != null) {
                runnable.run();
            }
            this.sHZ = new c<bv>(this) {
                final /* synthetic */ a sIc;

                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 sId;

                        {
                            this.sId = r1;
                        }

                        public final void run() {
                            this.sId.sIc.F(runnable2);
                        }
                    });
                    return true;
                }
            };
            this.sHZ.bIy();
            return F(runnable2);
        }

        public final synchronized boolean F(Runnable runnable) {
            boolean z = false;
            synchronized (this) {
                if (h.vG().gXp && this.sIa.get()) {
                    this.sIa.set(false);
                    runnable.run();
                    if (this.sHZ != null) {
                        this.sHZ.dead();
                        this.sHZ = null;
                    }
                    z = true;
                }
            }
            return z;
        }

        protected final void finalize() {
            super.finalize();
            if (this.sHZ != null) {
                this.sHZ.dead();
                this.sHZ = null;
            }
        }
    }

    public enum b {
        LOGIN_OK,
        LOGIN_FAIL,
        LOGIN_CANCEL
    }

    public abstract void a(b bVar, Intent intent);

    public abstract boolean u(Intent intent);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zg(8);
        final Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.AutoLoginActivity", "onCreate intent is null");
            finish();
            return;
        }
        d.bGP();
        w.i("MicroMsg.AutoLoginActivity", "onCreate, intent action = " + intent.getAction());
        int a = s.a(intent, "wizard_activity_result_code", -2);
        w.i("MicroMsg.AutoLoginActivity", "onCreate, resultCode = " + a);
        if (a != -2) {
            xj(a);
        } else if (!u(intent)) {
            w.e("MicroMsg.AutoLoginActivity", "preLogin fail, no need to process");
            finish();
        } else if (aPd()) {
            finish();
            w.w("MicroMsg.AutoLoginActivity", "not login, go to SimpleLogin");
        } else {
            final Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ AutoLoginActivity sHX;

                public final void run() {
                    this.sHX.a(b.LOGIN_OK, intent);
                }
            };
            if (h.vJ().gYJ.gZf) {
                p(anonymousClass1);
                return;
            }
            com.tencent.mm.kernel.a.b bVar = ((f) h.vF().vj()).gZy.gZq;
            if ((bVar instanceof com.tencent.mm.app.h) && ((com.tencent.mm.app.h) bVar).og()) {
                h.vJ().a(new com.tencent.mm.kernel.api.h(this) {
                    final /* synthetic */ AutoLoginActivity sHX;

                    public final void oh() {
                        this.sHX.p(anonymousClass1);
                        h.vJ().b(this);
                    }

                    public final void ak(boolean z) {
                    }
                });
            }
            w.w("MicroMsg.AutoLoginActivity", "DefaultBootStep was wrong again....");
        }
    }

    protected final void p(Runnable runnable) {
        if (!isFinishing() && !this.uSW) {
            new a().b(new Runnable(this) {
                final /* synthetic */ AutoLoginActivity sHX;

                {
                    this.sHX = r1;
                }

                public final void run() {
                    g.a(this.sHX, this.sHX.getString(R.l.cbS), false, null);
                }
            }, runnable);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected void onNewIntent(Intent intent) {
        if (intent != null) {
            super.onNewIntent(intent);
            setIntent(intent);
            int a = s.a(intent, "wizard_activity_result_code", 0);
            w.i("MicroMsg.AutoLoginActivity", "onNewIntent, resultCode = " + a);
            xj(a);
        }
    }

    private void xj(int i) {
        switch (i) {
            case -1:
                a(b.LOGIN_OK, getIntent());
                return;
            case 0:
                aPd();
                return;
            case 1:
                a(b.LOGIN_CANCEL, getIntent());
                return;
            default:
                w.e("MicroMsg.AutoLoginActivity", "onNewIntent, should not reach here, resultCode = " + i);
                a(b.LOGIN_FAIL, getIntent());
                return;
        }
    }

    public boolean aPd() {
        if (ap.za() && !ap.uP()) {
            return false;
        }
        w.w("MicroMsg.AutoLoginActivity", "not login");
        Intent intent = new Intent(this, getClass());
        intent.putExtras(getIntent());
        intent.addFlags(67108864);
        intent.setDataAndType(getIntent().getData(), getIntent().getType());
        intent.setAction(getIntent().getAction());
        Intent intent2 = new Intent();
        intent2.putExtras(getIntent());
        d.a((Context) this, "accountsync", "com.tencent.mm.ui.account.SimpleLoginUI", intent2, intent);
        return true;
    }

    public static void a(Context context, com.tencent.mm.pluginsdk.model.app.f fVar, String str, int i) {
        Signature[] aR = p.aR(context, str);
        Object obj = "";
        if (aR != null && aR.length > 0) {
            int length = aR.length;
            int i2 = 0;
            while (i2 < length) {
                i2++;
                String str2 = obj + p.Mj(com.tencent.mm.a.g.n(aR[i2].toByteArray())) + "|";
            }
        }
        if (obj.length() > 1) {
            obj = obj.substring(0, obj.length() - 1);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("raw_package_name", bg.ap(str, ""));
            jSONObject.put("package_name", bg.ap(fVar.field_packageName, ""));
            jSONObject.put("raw_signature", obj);
            jSONObject.put("signature", bg.ap(fVar.field_signature, ""));
            jSONObject.put("scene", i);
        } catch (Exception e) {
            w.i("MicroMsg.AutoLoginActivity", "doIfAppInValid, jsonException = " + e.getMessage());
        }
        com.tencent.mm.sdk.b.b gnVar = new gn();
        gnVar.fLN.appId = fVar.field_appId;
        gnVar.fLN.opType = 3;
        gnVar.fLN.fFs = jSONObject.toString();
        com.tencent.mm.sdk.b.a.urY.m(gnVar);
    }

    public int getLayoutId() {
        return -1;
    }

    protected final boolean bDZ() {
        return true;
    }
}
