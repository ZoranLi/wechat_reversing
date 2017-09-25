package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public class GameMediaList extends LinearLayout implements OnClickListener {
    String appId = "";
    int lvp = -1;
    int mAG = 0;
    int mCE;
    private LinkedList<String> mCF;
    Context mContext;

    public static class a {
        public String mCG;
        public int type;
        public String url;
    }

    public GameMediaList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void R(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            setVisibility(8);
            return;
        }
        this.mCF = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            a aVar = (a) linkedList.get(i);
            if (!bg.mA(aVar.url) && aVar.type == 0) {
                this.mCF.add(aVar.url);
            }
        }
        removeAllViews();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService("layout_inflater");
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            a aVar2 = (a) linkedList.get(i2);
            if (!bg.mA(aVar2.mCG)) {
                View inflate = layoutInflater.inflate(this.mCE, this, false);
                ImageView imageView = (ImageView) inflate.findViewById(R.h.cjz);
                com.tencent.mm.ah.a.a GW = n.GW();
                String str = aVar2.mCG;
                com.tencent.mm.ah.a.a.c.a aVar3 = new com.tencent.mm.ah.a.a.c.a();
                aVar3.hIK = true;
                GW.a(str, imageView, aVar3.Hg());
                if (aVar2.type == 1) {
                    inflate.findViewById(R.h.cjv).setVisibility(0);
                }
                addView(inflate);
                imageView.setTag(aVar2);
                imageView.setOnClickListener(this);
            }
        }
        setVisibility(0);
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof a)) {
            w.i("MicroMsg.GameMediaList", "Invalid tag");
            return;
        }
        a aVar = (a) view.getTag();
        switch (aVar.type) {
            case 0:
                int indexOf = this.mCF.indexOf(aVar.url);
                if (indexOf < 0) {
                    indexOf = 0;
                }
                Intent intent = new Intent(getContext(), GameGalleryUI.class);
                String[] strArr = new String[this.mCF.size()];
                this.mCF.toArray(strArr);
                intent.putExtra("URLS", strArr);
                intent.putExtra("CURRENT", indexOf);
                intent.putExtra("REPORT_APPID", this.appId);
                intent.putExtra("REPORT_SCENE", this.lvp);
                intent.putExtra("SOURCE_SCENE", this.mAG);
                getContext().startActivity(intent);
                return;
            case 1:
                c.aa(getContext(), aVar.url);
                ai.a(this.mContext, this.lvp, 1202, 1, 13, this.appId, this.mAG, null);
                return;
            default:
                return;
        }
    }
}
