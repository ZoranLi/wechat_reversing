package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.f.a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public final class e extends b implements a {
    private b.a IE;
    private WeakReference<View> IF;
    private ActionBarContextView Ig;
    private boolean OE;
    private f dW;
    private Context mContext;
    private boolean mFinished;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z) {
        this.mContext = context;
        this.Ig = actionBarContextView;
        this.IE = aVar;
        f fVar = new f(actionBarContextView.getContext());
        this.dW = fVar;
        this.dW.a((a) this);
        this.OE = z;
    }

    public final void setTitle(CharSequence charSequence) {
        this.Ig.setTitle(charSequence);
    }

    public final void setSubtitle(CharSequence charSequence) {
        this.Ig.setSubtitle(charSequence);
    }

    public final void setTitle(int i) {
        setTitle(this.mContext.getString(i));
    }

    public final void setSubtitle(int i) {
        setSubtitle(this.mContext.getString(i));
    }

    public final void setTitleOptionalHint(boolean z) {
        super.setTitleOptionalHint(z);
        this.Ig.K(z);
    }

    public final boolean isTitleOptional() {
        return this.Ig.RW;
    }

    public final void setCustomView(View view) {
        this.Ig.setCustomView(view);
        this.IF = view != null ? new WeakReference(view) : null;
    }

    public final void invalidate() {
        this.IE.b(this, this.dW);
    }

    public final void finish() {
        if (!this.mFinished) {
            this.mFinished = true;
            this.Ig.sendAccessibilityEvent(32);
            this.IE.a(this);
        }
    }

    public final Menu getMenu() {
        return this.dW;
    }

    public final CharSequence getTitle() {
        return this.Ig.uI;
    }

    public final CharSequence getSubtitle() {
        return this.Ig.uJ;
    }

    public final View getCustomView() {
        return this.IF != null ? (View) this.IF.get() : null;
    }

    public final MenuInflater getMenuInflater() {
        return new g(this.Ig.getContext());
    }

    public final boolean a(f fVar, MenuItem menuItem) {
        return this.IE.a((b) this, menuItem);
    }

    public final void b(f fVar) {
        invalidate();
        this.Ig.showOverflowMenu();
    }
}
