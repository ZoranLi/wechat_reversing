package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.appbrand.g.m;

public interface y {

    public interface a {
        void Zq();
    }

    public interface b {
        void YS();
    }

    boolean YP();

    boolean YQ();

    String Yi();

    View Yq();

    com.tencent.mm.plugin.appbrand.widget.input.autofill.b Zi();

    void Zk();

    void Zl();

    void Zm();

    boolean Zp();

    void a(OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(b bVar);

    void addTextChangedListener(TextWatcher textWatcher);

    void b(OnFocusChangeListener onFocusChangeListener);

    void cA(boolean z);

    void destroy();

    Context getContext();

    CharSequence getText();

    View getView();

    int iW(int i);

    void l(float f, float f2);

    void m(m mVar);

    void n(m mVar);

    void rp(String str);
}
