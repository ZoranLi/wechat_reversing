package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.mm.R;
import com.tencent.mm.ui.MMActivity;

public final class j {
    MMActivity iwk;
    int nuH;
    int nuI;

    public static final class a {
        public int jza;
        public Drawable nuJ;
        public int nuK;
        public int nuL;
        public int nuM;
        public int nuN;
    }

    public j(MMActivity mMActivity) {
        this.iwk = mMActivity;
        if (aIJ()) {
            Window window = mMActivity.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            this.nuI = window.getStatusBarColor();
        }
    }

    private static boolean aIJ() {
        return VERSION.SDK_INT >= 21;
    }

    final void pd(int i) {
        if (aIJ()) {
            Window window = this.iwk.getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i);
        }
    }

    static a A(Context context, int i) {
        a aVar = new a();
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                aVar.nuJ = new ColorDrawable(resources.getColor(R.e.aUG));
                aVar.jza = resources.getColor(R.e.aUH);
                aVar.nuK = resources.getColor(R.e.aUL);
                aVar.nuL = resources.getColor(R.e.aUL);
                aVar.nuM = R.g.bgt;
                aVar.nuN = resources.getColor(R.e.aUN);
                break;
            default:
                aVar.nuJ = resources.getDrawable(R.g.bgs);
                aVar.jza = -1;
                aVar.nuL = resources.getColor(R.e.aUR);
                aVar.nuN = resources.getColor(R.e.aUE);
                break;
        }
        return aVar;
    }
}
