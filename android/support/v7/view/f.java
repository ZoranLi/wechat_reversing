package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.c.a.b;
import android.support.v4.e.i;
import android.support.v7.view.menu.n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public final class f extends ActionMode {
    final b OF;
    final Context mContext;

    public static class a implements android.support.v7.view.b.a {
        final Callback OG;
        final ArrayList<f> OH = new ArrayList();
        final i<Menu, Menu> OI = new i();
        final Context mContext;

        public a(Context context, Callback callback) {
            this.mContext = context;
            this.OG = callback;
        }

        public final boolean a(b bVar, Menu menu) {
            return this.OG.onCreateActionMode(b(bVar), b(menu));
        }

        public final boolean b(b bVar, Menu menu) {
            return this.OG.onPrepareActionMode(b(bVar), b(menu));
        }

        public final boolean a(b bVar, MenuItem menuItem) {
            return this.OG.onActionItemClicked(b(bVar), n.a(this.mContext, (b) menuItem));
        }

        public final void a(b bVar) {
            this.OG.onDestroyActionMode(b(bVar));
        }

        private Menu b(Menu menu) {
            Menu menu2 = (Menu) this.OI.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = n.a(this.mContext, (android.support.v4.c.a.a) menu);
            this.OI.put(menu, menu2);
            return menu2;
        }

        public final ActionMode b(b bVar) {
            int size = this.OH.size();
            for (int i = 0; i < size; i++) {
                f fVar = (f) this.OH.get(i);
                if (fVar != null && fVar.OF == bVar) {
                    return fVar;
                }
            }
            ActionMode fVar2 = new f(this.mContext, bVar);
            this.OH.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.mContext = context;
        this.OF = bVar;
    }

    public final Object getTag() {
        return this.OF.OA;
    }

    public final void setTag(Object obj) {
        this.OF.OA = obj;
    }

    public final void setTitle(CharSequence charSequence) {
        this.OF.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.OF.setSubtitle(charSequence);
    }

    public final void invalidate() {
        this.OF.invalidate();
    }

    public final void finish() {
        this.OF.finish();
    }

    public final Menu getMenu() {
        return n.a(this.mContext, (android.support.v4.c.a.a) this.OF.getMenu());
    }

    public final CharSequence getTitle() {
        return this.OF.getTitle();
    }

    public final void setTitle(int i) {
        this.OF.setTitle(i);
    }

    public final CharSequence getSubtitle() {
        return this.OF.getSubtitle();
    }

    public final void setSubtitle(int i) {
        this.OF.setSubtitle(i);
    }

    public final View getCustomView() {
        return this.OF.getCustomView();
    }

    public final void setCustomView(View view) {
        this.OF.setCustomView(view);
    }

    public final MenuInflater getMenuInflater() {
        return this.OF.getMenuInflater();
    }

    public final boolean getTitleOptionalHint() {
        return this.OF.OB;
    }

    public final void setTitleOptionalHint(boolean z) {
        this.OF.setTitleOptionalHint(z);
    }

    public final boolean isTitleOptional() {
        return this.OF.isTitleOptional();
    }
}
