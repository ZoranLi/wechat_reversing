package android.support.v4.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Iterator;

public final class am implements Iterable<Intent> {
    private static final b ti;
    public final ArrayList<Intent> tj = new ArrayList();
    public final Context tk;

    public interface a {
        Intent bo();
    }

    interface b {
    }

    static class c implements b {
        c() {
        }
    }

    static class d implements b {
        d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            ti = new d();
        } else {
            ti = new c();
        }
    }

    private am(Context context) {
        this.tk = context;
    }

    public static am j(Context context) {
        return new am(context);
    }

    public final am a(ComponentName componentName) {
        int size = this.tj.size();
        try {
            Intent a = u.a(this.tk, componentName);
            while (a != null) {
                this.tj.add(size, a);
                a = u.a(this.tk, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final Iterator<Intent> iterator() {
        return this.tj.iterator();
    }
}
