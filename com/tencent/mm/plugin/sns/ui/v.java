package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import java.util.List;

public interface v {

    public static abstract class a {
        public OnClickListener que = new OnClickListener(this) {
            final /* synthetic */ a quf;

            {
                this.quf = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() != null) {
                    this.quf.tL(((Integer) view.getTag()).intValue());
                }
            }
        };

        public abstract void tL(int i);
    }

    void a(a aVar);

    void biV();

    void bz(List<String> list);

    void clean();

    View getView();
}
