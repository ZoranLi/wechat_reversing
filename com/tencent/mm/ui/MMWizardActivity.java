package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class MMWizardActivity extends MMActivity {
    public static final Map<String, Intent> uVi = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.MMWizardActivity", "onCreate()");
        Assert.assertFalse("MMWizardActivity Should Start By startWizardActivity or startWizardNextStep", bg.mA(getIntent().getExtras().getString("WizardRootClass")));
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            super.finish();
            w.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
            exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
        }
    }

    public static void z(Context context, Intent intent) {
        String stringExtra;
        String str = null;
        w.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
        Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + context.toString(), context instanceof Activity);
        Intent intent2 = ((Activity) context).getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("WizardRootClass");
            stringExtra = intent2.getStringExtra("WizardTransactionId");
        } else {
            stringExtra = null;
        }
        if (bg.mA(str)) {
            try {
                str = intent.getComponent().getClassName();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMWizardActivity", e, "", new Object[0]);
            }
        }
        Assert.assertFalse("startWizardActivity: ERROR in Get Root Class :[" + intent + "][ " + intent.getComponent() + " ]", bg.mA(str));
        intent.putExtra("WizardRootClass", str);
        if (stringExtra != null) {
            intent.putExtra("WizardTransactionId", stringExtra);
        }
        context.startActivity(intent);
    }

    public static void b(Context context, Intent intent, Intent intent2) {
        try {
            String str = "trans." + bg.NA() + "." + intent2.hashCode();
            uVi.put(str, intent2);
            intent.putExtra("WizardTransactionId", str);
            Intent intent3 = ((Activity) context).getIntent();
            if (intent3 != null) {
                intent3.putExtra("WizardTransactionId", str);
            }
            z(context, intent);
        } catch (Throwable e) {
            w.e("MicroMsg.MMWizardActivity", "%s", bg.g(e));
        }
    }

    public final void exit(int i) {
        w.i("MicroMsg.MMWizardActivity", "exit()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) uVi.get(stringExtra);
        uVi.remove(stringExtra);
        if (intent != null) {
            w.d("MicroMsg.MMWizardActivity", "doing post exit for transaction=" + stringExtra + ", intent=" + intent);
            intent.putExtra("wizard_activity_result_code", i);
            startActivity(intent);
        }
    }

    public final void cancel() {
        w.i("MicroMsg.MMWizardActivity", "cancel()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) uVi.get(stringExtra);
        uVi.remove(stringExtra);
        if (intent != null) {
            w.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + stringExtra + ", intent=" + intent);
        }
    }

    public final void zu(int i) {
        w.i("MicroMsg.MMWizardActivity", "finishWizard()");
        String string = getIntent().getExtras().getString("WizardRootClass");
        Assert.assertFalse("finishWizard: ERROR in Get Root Class :[" + string + "]", bg.mA(string));
        Intent className = new Intent().setClassName(this, string);
        className.putExtra("WizardRootClass", getIntent().getStringExtra("WizardRootClass"));
        className.putExtra("WizardTransactionId", getIntent().getStringExtra("WizardTransactionId"));
        className.putExtra("WizardRootKillSelf", true);
        className.putExtra("wizard_activity_result_code", i);
        className.addFlags(67108864);
        startActivity(className);
    }

    public void finish() {
        w.i("MicroMsg.MMWizardActivity", "finish()");
        if (getComponentName().getClassName().equals(getIntent().getStringExtra("WizardRootClass"))) {
            w.d("MicroMsg.MMWizardActivity", "root wizard activity");
            exit(-1);
        }
        super.finish();
    }
}
