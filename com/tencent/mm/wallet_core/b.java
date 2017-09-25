package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public abstract class b {
    public Bundle lHw = new Bundle();
    protected a wDO;

    public interface a {
        Intent j(int i, Bundle bundle);
    }

    public abstract void a(Activity activity, int i, Bundle bundle);

    public abstract String avB();

    public abstract void c(Activity activity, int i);

    public abstract void d(Activity activity, Bundle bundle);

    public abstract boolean e(Activity activity, Bundle bundle);

    public final b ah(Bundle bundle) {
        this.lHw.putAll(bundle);
        return this;
    }

    private static String bQ(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof Bundle) {
            return String.format("Bundle: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Context) {
            return String.format("Context: %s, ", new Object[]{obj.toString()});
        } else if (obj instanceof Class) {
            return String.format("Class: %s, ", new Object[]{((Class) obj).getSimpleName()});
        } else {
            return String.format("Value: %s, ", new Object[]{obj.toString()});
        }
    }

    public final void v(Object... objArr) {
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(String.format("this %s, procname %s", new Object[]{this, avB()}));
        if (objArr.length <= 0) {
            w.w("MicroMsg.ProcessManager", "vals is null, use '' as value");
            stringBuilder = stringBuilder2.toString();
        } else {
            int length = objArr.length - 1;
            for (int i = 0; i < length; i++) {
                stringBuilder2.append(bQ(objArr[i])).append(',');
            }
            stringBuilder2.append(bQ(objArr[length]));
            stringBuilder = stringBuilder2.toString();
        }
        w.i("MicroMsg.ProcessManager", "__CURRENT__ %s", new Object[]{stringBuilder});
    }

    public final void b(Activity activity, Class<?> cls, Bundle bundle) {
        v("startActivity1", activity, cls, bundle);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        activity.startActivity(intent);
        if (bundle != null) {
            this.lHw.putAll(bundle);
        }
        w.d("MicroMsg.ProcessManager", "bankcard tag :" + cbP());
    }

    public final void a(Activity activity, String str, String str2, Bundle bundle) {
        v("startActivity3", activity, str, str2, bundle);
        Class es = d.es(str, str2);
        if (es != null) {
            b(activity, es, bundle);
        } else {
            w.e("MicroMsg.ProcessManager", " Class Not Found! can't startActivity to " + str + str2);
        }
    }

    public final void a(Activity activity, Class<?> cls, Bundle bundle, int i) {
        v("startActivityForResult1", activity, cls, bundle, Integer.valueOf(i));
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivityForResult(intent, i);
        if (bundle != null) {
            this.lHw.putAll(bundle);
        }
    }

    public void J(Activity activity) {
        v("finishActivity", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
    }

    public final void a(Activity activity, Class<?> cls, int i) {
        v("finishActivity", activity, cls, "errCode " + i);
        Intent intent = new Intent(activity, cls);
        intent.putExtra("process_id", getClass().hashCode());
        intent.addFlags(67108864);
        activity.startActivity(intent);
        this.lHw.putInt("key_err_code", i);
    }

    public b c(Activity activity, Bundle bundle) {
        return this;
    }

    public final void a(a aVar) {
        this.wDO = aVar;
    }

    public final void aj(Activity activity) {
        v("endProcess1", activity);
        if (!activity.isFinishing() && (activity instanceof MMActivity)) {
            ((MMActivity) activity).finish();
        }
        if (this.lHw != null) {
            this.lHw.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, int i, Intent intent, boolean z) {
        Intent j;
        v("endProcess2", activity, cls, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.wDO != null) {
            j = this.wDO.j(i, this.lHw);
        } else {
            j = intent;
        }
        if (j == null) {
            j = new Intent(activity, cls);
            j.putExtra("key_process_is_stay", z);
        } else if (!(j.getExtras() == null || j.getExtras().containsKey("key_process_is_stay"))) {
            j.putExtra("key_process_is_stay", true);
        }
        j.addFlags(67108864);
        j.putExtra("key_process_is_end", true);
        activity.startActivity(j);
        if (this.lHw != null) {
            this.lHw.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, String str, String str2, int i, boolean z) {
        a(activity, str, str2, i, null, z);
    }

    public final void a(Activity activity, String str, String str2, int i, Intent intent, boolean z) {
        Intent j;
        v("endProcess3", activity, str, str2, Integer.valueOf(i), intent, Boolean.valueOf(z));
        if (this.wDO != null) {
            j = this.wDO.j(i, this.lHw);
        } else {
            j = intent;
        }
        if (j == null) {
            j = new Intent();
            j.putExtra("key_process_is_stay", z);
        } else if (!(j.getExtras() == null || j.getExtras().containsKey("key_process_is_stay"))) {
            j.putExtra("key_process_is_stay", true);
        }
        j.addFlags(67108864);
        j.putExtra("key_process_is_end", true);
        d.b(activity, str, str2, j);
        if (this.lHw != null) {
            this.lHw.clear();
        }
        a.remove(getClass().hashCode());
    }

    public final void a(Activity activity, Class<?> cls, Intent intent) {
        a(activity, (Class) cls, -1, intent, true);
    }

    public final void a(Activity activity, Class<?> cls, int i, boolean z) {
        a(activity, (Class) cls, i, null, z);
    }

    public final void c(Activity activity, Class<?> cls) {
        a(activity, (Class) cls, -1, null, true);
    }

    public final void d(Activity activity, String str, String str2) {
        a(activity, str, str2, -1, true);
    }

    public final int cbP() {
        return this.lHw.getInt("key_support_bankcard", 1);
    }

    public final boolean cbQ() {
        return this.lHw.getBoolean("key_is_oversea", false);
    }

    public final boolean cbR() {
        return this.lHw.getInt("key_pay_flag", 0) == 2;
    }

    public final boolean cbS() {
        return this.lHw.getInt("key_pay_flag", 0) == 1;
    }

    public final boolean cbT() {
        return this.lHw.getInt("key_pay_flag", 0) == 3;
    }

    public com.tencent.mm.wallet_core.d.d a(MMActivity mMActivity, f fVar) {
        return null;
    }

    public boolean i(Activity activity, Bundle bundle) {
        return false;
    }

    public final boolean cbU() {
        String string = this.lHw.getString("key_bank_username");
        w.i("MicroMsg.ProcessManager", "follow bank account : isFollow " + this.lHw.getBoolean("key_is_follow_bank_username", false) + ", username : " + string);
        if (!this.lHw.getBoolean("key_is_follow_bank_username", false) || bg.mA(string)) {
            return false;
        }
        ap.vd().a(new h(string), 0);
        return true;
    }

    public int b(MMActivity mMActivity, int i) {
        return -1;
    }

    public boolean a(WalletBaseUI walletBaseUI, int i, String str) {
        return false;
    }
}
