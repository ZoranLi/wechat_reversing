package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.view.d.b;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
final class j extends i {

    class a extends a implements VisibilityListener {
        b Re;
        final /* synthetic */ j Rf;

        public a(j jVar, Context context, ActionProvider actionProvider) {
            this.Rf = jVar;
            super(jVar, context, actionProvider);
        }

        public final View onCreateActionView(MenuItem menuItem) {
            return this.Rb.onCreateActionView(menuItem);
        }

        public final boolean overridesItemVisibility() {
            return this.Rb.overridesItemVisibility();
        }

        public final boolean isVisible() {
            return this.Rb.isVisible();
        }

        public final void a(b bVar) {
            this.Re = bVar;
            this.Rb.setVisibilityListener(this);
        }

        public final void onActionProviderVisibilityChanged(boolean z) {
            if (this.Re != null) {
                this.Re.bJ();
            }
        }
    }

    j(Context context, android.support.v4.c.a.b bVar) {
        super(context, bVar);
    }

    final a a(ActionProvider actionProvider) {
        return new a(this, this.mContext, actionProvider);
    }
}
