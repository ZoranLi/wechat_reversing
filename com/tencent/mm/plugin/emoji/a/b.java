package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public View kHP;
    public String kHX;
    public ImageView kHY;
    public ImageView kHZ;
    public TextView kmZ;
    public Context mContext;

    public b(Context context, int i) {
        this.mContext = context;
        this.kHP = r.eC(this.mContext).inflate(i, null);
        alk();
    }

    public b(Context context, View view) {
        this.mContext = context;
        this.kHP = view;
        alk();
    }

    private void alk() {
        if (this.kHP == null) {
            w.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            return;
        }
        this.kHY = (ImageView) this.kHP.findViewById(R.h.bZl);
        this.kmZ = (TextView) this.kHP.findViewById(R.h.bZN);
        this.kHZ = (ImageView) this.kHP.findViewById(R.h.bZj);
    }
}
