package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.l.b;

public class SetTextSizeUI extends MMPreference {
    private f isJ;
    private float pjm;
    private int pjn = 1;

    private class a extends Preference {
        private float pjm;
        final /* synthetic */ SetTextSizeUI pjo;

        public a(SetTextSizeUI setTextSizeUI, Context context, float f) {
            this.pjo = setTextSizeUI;
            super(context);
            this.pjm = f;
        }

        protected final void onBindView(View view) {
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setTextSize(1, SetTextSizeUI.af(this.pjm));
            }
        }
    }

    public final int ON() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final void KC() {
        this.pjm = cN(this);
        this.isJ = this.vrv;
        zi(R.l.eUq);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SetTextSizeUI pjo;

            {
                this.pjo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pjo.aHf();
                this.pjo.finish();
                return true;
            }
        });
        a(0, getString(R.l.eSG), new OnMenuItemClickListener(this) {
            final /* synthetic */ SetTextSizeUI pjo;

            {
                this.pjo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.bg.a.e(this.pjo, this.pjo.pjm);
                this.pjo.finish();
                return true;
            }
        }, b.uTY);
        refresh();
    }

    public static float cN(Context context) {
        float dI = com.tencent.mm.bg.a.dI(context);
        if (dI == 1.0f || dI == 0.875f || dI == 1.125f || dI == 1.25f || dI == 1.375f || dI == 1.625f || dI == 1.875f || dI == 2.025f) {
            return dI;
        }
        return 1.0f;
    }

    public static int cO(Context context) {
        float cN = cN(context);
        if (cN == 0.875f) {
            return R.l.eRy;
        }
        if (cN == 1.125f) {
            return R.l.eRw;
        }
        if (cN == 1.25f) {
            return R.l.eRz;
        }
        if (cN == 1.375f) {
            return R.l.eRv;
        }
        return R.l.eRx;
    }

    public static float af(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        if (f == 1.625f) {
            return 26.0f;
        }
        if (f == 1.875f) {
            return 28.0f;
        }
        if (f == 2.025f) {
            return 30.0f;
        }
        return 16.0f;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.igL;
        this.pjn = 1;
        if (str.equals("setting_text_size_small")) {
            this.pjm = 0.875f;
            this.pjn = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.pjm = 1.0f;
            this.pjn = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.pjm = 1.125f;
            this.pjn = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.pjm = 1.25f;
            this.pjn = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.pjm = 1.375f;
            this.pjn = 4;
        } else if (str.equals("setting_text_size_huger")) {
            this.pjm = 1.625f;
            this.pjn = 5;
        } else if (str.equals("setting_text_size_hugers")) {
            this.pjm = 1.625f;
            this.pjn = 6;
        } else if (str.equals("setting_text_size_hugerss")) {
            this.pjm = 1.625f;
            this.pjn = 7;
        }
        refresh();
        return false;
    }

    private void refresh() {
        this.isJ.removeAll();
        Preference aVar = new a(this, this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(R.i.diC);
        if (this.pjm == 0.875f) {
            aVar.setWidgetLayoutResource(R.i.dji);
        } else {
            aVar.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(aVar);
        aVar = new a(this, this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(R.i.diC);
        if (this.pjm == 1.0f) {
            aVar.setWidgetLayoutResource(R.i.dji);
        } else {
            aVar.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(aVar);
        aVar = new a(this, this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(R.i.diC);
        if (this.pjm == 1.125f) {
            aVar.setWidgetLayoutResource(R.i.dji);
        } else {
            aVar.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(aVar);
        aVar = new a(this, this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(R.i.diC);
        if (this.pjm == 1.25f) {
            aVar.setWidgetLayoutResource(R.i.dji);
        } else {
            aVar.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(aVar);
        aVar = new a(this, this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(R.i.diC);
        if (this.pjm == 1.375f) {
            aVar.setWidgetLayoutResource(R.i.dji);
        } else {
            aVar.setWidgetLayoutResource(R.i.djj);
        }
        this.isJ.a(aVar);
        this.isJ.a(new PreferenceCategory(this));
        this.isJ.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.uSU.uTa;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                w.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
    }
}
