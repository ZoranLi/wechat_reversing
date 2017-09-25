package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.a.a.a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class i extends Dialog implements c {
    private d Gp;

    public i(Context context, int i) {
        if (i == 0) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(a.dialogTheme, typedValue, true);
            i = typedValue.resourceId;
        }
        super(context, i);
        cO().onCreate(null);
        cO().cS();
    }

    public void onCreate(Bundle bundle) {
        cO().cR();
        super.onCreate(bundle);
        cO().onCreate(bundle);
    }

    public void setContentView(int i) {
        cO().setContentView(i);
    }

    public void setContentView(View view) {
        cO().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        cO().setContentView(view, layoutParams);
    }

    public View findViewById(int i) {
        return cO().findViewById(i);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        cO().setTitle(charSequence);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        cO().setTitle(getContext().getString(i));
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        cO().addContentView(view, layoutParams);
    }

    protected void onStop() {
        super.onStop();
        cO().onStop();
    }

    public final boolean cZ() {
        return cO().requestWindowFeature(1);
    }

    public void invalidateOptionsMenu() {
        cO().invalidateOptionsMenu();
    }

    private d cO() {
        if (this.Gp == null) {
            this.Gp = d.a((Dialog) this, (c) this);
        }
        return this.Gp;
    }
}
