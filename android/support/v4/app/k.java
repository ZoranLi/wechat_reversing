package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.e.i;
import android.view.LayoutInflater;
import android.view.View;
import java.io.PrintWriter;

public abstract class k<E> extends i {
    final Context mContext;
    final Handler mHandler;
    boolean pA;
    final m pg;
    t py;
    boolean pz;
    final Activity qb;
    final int qc;
    i<String, s> qd;
    boolean qe;

    k(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, fragmentActivity.mHandler);
    }

    private k(Activity activity, Context context, Handler handler) {
        this.pg = new m();
        this.qb = activity;
        this.mContext = context;
        this.mHandler = handler;
        this.qc = 0;
    }

    public void a(String str, PrintWriter printWriter, String[] strArr) {
    }

    public boolean aS() {
        return true;
    }

    public LayoutInflater onGetLayoutInflater() {
        return (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    public void aT() {
    }

    public void b(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.mContext.startActivity(intent);
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public int onGetWindowAnimations() {
        return this.qc;
    }

    public View onFindViewById(int i) {
        return null;
    }

    public boolean onHasView() {
        return true;
    }

    final void j(String str) {
        if (this.qd != null) {
            t tVar = (t) this.qd.get(str);
            if (tVar != null && !tVar.pp) {
                tVar.bi();
                this.qd.remove(str);
            }
        }
    }

    final t a(String str, boolean z, boolean z2) {
        if (this.qd == null) {
            this.qd = new i();
        }
        t tVar = (t) this.qd.get(str);
        if (tVar != null) {
            tVar.ph = this;
            return tVar;
        } else if (!z2) {
            return tVar;
        } else {
            tVar = new t(str, this, z);
            this.qd.put(str, tVar);
            return tVar;
        }
    }

    final i<String, s> aU() {
        int i;
        int i2 = 0;
        if (this.qd != null) {
            int size = this.qd.size();
            t[] tVarArr = new t[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                tVarArr[i3] = (t) this.qd.valueAt(i3);
            }
            i = 0;
            while (i2 < size) {
                t tVar = tVarArr[i2];
                if (tVar.pp) {
                    i = 1;
                } else {
                    tVar.bi();
                    this.qd.remove(tVar.oV);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        if (i != 0) {
            return this.qd;
        }
        return null;
    }
}
