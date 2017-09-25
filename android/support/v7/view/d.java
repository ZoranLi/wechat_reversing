package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.a.a.j;
import android.view.LayoutInflater;

public final class d extends ContextWrapper {
    private LayoutInflater Du;
    public int OC;
    private Theme OD;

    public d(Context context, int i) {
        super(context);
        this.OC = i;
    }

    public final void setTheme(int i) {
        if (this.OC != i) {
            this.OC = i;
            dg();
        }
    }

    public final Theme getTheme() {
        if (this.OD != null) {
            return this.OD;
        }
        if (this.OC == 0) {
            this.OC = j.KW;
        }
        dg();
        return this.OD;
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.Du == null) {
            this.Du = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.Du;
    }

    private void dg() {
        if (this.OD == null) {
            this.OD = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.OD.setTo(theme);
            }
        }
        this.OD.applyStyle(this.OC, true);
    }
}
