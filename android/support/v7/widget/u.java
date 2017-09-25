package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ai;
import android.support.v7.view.menu.f;
import android.support.v7.view.menu.l.a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

public interface u {
    void N(boolean z);

    void a(a aVar, f.a aVar2);

    void a(Menu menu, a aVar);

    void b(ai aiVar);

    void b(Callback callback);

    ai c(int i, long j);

    void collapseActionView();

    boolean dT();

    boolean dU();

    void dV();

    void dismissPopupMenus();

    void e(CharSequence charSequence);

    ViewGroup eI();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getTitle();

    int getVisibility();

    boolean hasExpandedActionView();

    boolean hideOverflowMenu();

    boolean isOverflowMenuShowing();

    void setBackgroundDrawable(Drawable drawable);

    void setCustomView(View view);

    void setDisplayOptions(int i);

    void setIcon(int i);

    void setLogo(Drawable drawable);

    void setVisibility(int i);

    boolean showOverflowMenu();
}
