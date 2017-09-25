package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.r;

public class EmojiStoreV2HotBarView extends LinearLayout {
    View kXe;
    private TextView kXf;
    View kXg;
    private TextView kXh;
    private OnClickListener kXi = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2HotBarView kXj;

        {
            this.kXj = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.kXj.getContext(), EmojiStoreV2RankUI.class);
            this.kXj.getContext().startActivity(intent);
        }
    };
    private View khv;

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        init();
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.khv = ((ViewGroup) r.eC(getContext()).inflate(R.i.daG, this)).findViewById(R.h.czn);
        this.kXe = this.khv.findViewById(R.h.bKZ);
        this.kXf = (TextView) this.khv.findViewById(R.h.bLn);
        this.kXf.setText(getResources().getText(R.l.eds) + " ");
        this.kXg = this.khv.findViewById(R.h.bIk);
        this.kXg.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2HotBarView kXj;

            {
                this.kXj = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.kXj.getContext(), EmojiStoreV2SingleProductUI.class);
                this.kXj.getContext().startActivity(intent);
            }
        });
        this.kXh = (TextView) this.khv.findViewById(R.h.cnS);
        aoC();
        OnClickListener onClickListener = this.kXi;
        if (this.kXf != null) {
            this.kXf.setOnClickListener(onClickListener);
        }
    }

    public final void aoC() {
        ap.yY();
        boolean booleanValue = ((Boolean) c.vr().get(a.uzN, Boolean.valueOf(false))).booleanValue();
        if (this.kXh != null) {
            this.kXh.setVisibility(booleanValue ? 0 : 8);
        }
    }

    public View getRootView() {
        return this.khv;
    }

    public void setVisibility(int i) {
        if (this.khv != null) {
            this.khv.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }
}
