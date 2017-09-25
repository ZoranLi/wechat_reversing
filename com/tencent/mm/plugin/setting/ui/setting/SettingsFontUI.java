package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.e.a.gb;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.d;
import com.tencent.mm.ui.v;

public class SettingsFontUI extends MMActivity {
    private int pkV = 0;
    private int pkW = 2;
    private int pkX = a.fromDPToPix(ab.getContext(), R.f.aZh);
    final float pkY = SetTextSizeUI.cN(this.uSU.uTo);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dob;
    }

    protected final void KC() {
        zi(R.l.eUq);
        w.i("MicroMsg.SettingsFontUI", "fontSizeBefore=" + this.pkY);
        final TextView textView = (TextView) findViewById(R.h.cDk);
        final TextView textView2 = (TextView) findViewById(R.h.cDi);
        final TextView textView3 = (TextView) findViewById(R.h.cDj);
        b.a((ImageView) findViewById(R.h.bzV), m.xL());
        FontSelectorView fontSelectorView = (FontSelectorView) findViewById(R.h.bQT);
        float cN = SetTextSizeUI.cN(this.uSU.uTo);
        if (cN < 0.875f || cN > 2.025f) {
            cN = 1.0f;
        }
        int i = cN == 0.875f ? 0 : cN == 1.125f ? 2 : cN == 1.25f ? 3 : cN == 1.375f ? 4 : cN == 1.625f ? 5 : cN == 1.875f ? 6 : cN == 2.025f ? 7 : 1;
        fontSelectorView.pnI = i;
        fontSelectorView.pnJ = new FontSelectorView.a(this) {
            final /* synthetic */ SettingsFontUI plc;

            public final void sq(int i) {
                float f = 1.0f;
                switch (i) {
                    case 0:
                        f = 0.875f;
                        break;
                    case 2:
                        f = 1.125f;
                        break;
                    case 3:
                        f = 1.25f;
                        break;
                    case 4:
                        f = 1.375f;
                        break;
                    case 5:
                        f = 1.625f;
                        break;
                    case 6:
                        f = 1.875f;
                        break;
                    case 7:
                        f = 2.025f;
                        break;
                }
                if (f != this.plc.pkY) {
                    this.plc.pkV = 1;
                } else {
                    this.plc.pkV = 0;
                }
                a.e(this.plc.uSU.uTo, f);
                v.e(this.plc.uSU.uTo, f);
                Editor edit = this.plc.uSU.uTo.getSharedPreferences(ab.bIX(), 0).edit();
                edit.putFloat("current_text_size_scale_key", f);
                edit.commit();
                this.plc.pkW = a.dJ(this.plc.uSU.uTo);
                float dI = a.dI(this.plc.uSU.uTo);
                Context context = this.plc.uSU.uTo;
                if (dI == 0.875f) {
                    this.plc.pkX = a.U(context, R.f.aZi);
                } else if (dI == 1.125f) {
                    this.plc.pkX = a.U(context, R.f.aZe);
                } else if (dI == 1.25f) {
                    this.plc.pkX = a.U(context, R.f.aZj);
                } else if (dI == 1.375f) {
                    this.plc.pkX = a.U(context, R.f.aZc);
                } else if (dI == 1.625f || dI == 1.875f || dI == 2.025f) {
                    this.plc.pkX = a.U(context, R.f.aZd);
                }
                textView.setTextSize(1, SetTextSizeUI.af(f));
                textView2.setTextSize(1, SetTextSizeUI.af(f));
                textView3.setTextSize(1, SetTextSizeUI.af(f));
                float U = ((float) a.U(context, R.f.aWy)) * a.dK(context);
                this.plc.uSU.uTv.setTextSize(0, U);
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsFontUI plc;

            {
                this.plc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.oUh.i(11609, new Object[]{Integer.valueOf(this.plc.pkV), Integer.valueOf(this.plc.pkW), Integer.valueOf(0)});
                w.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(this.plc.pkV), Integer.valueOf(this.plc.pkW)});
                this.plc.finish();
                this.plc.ag(this.plc.pkY);
                return true;
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        g.oUh.i(11609, new Object[]{Integer.valueOf(this.pkV), Integer.valueOf(this.pkW), Integer.valueOf(0)});
        w.i("MicroMsg.SettingsFontUI", "choose font size kvReport logID:%d , changeFontSize: %d, curFontSize:%d", new Object[]{Integer.valueOf(11609), Integer.valueOf(this.pkV), Integer.valueOf(this.pkW)});
        finish();
        ag(this.pkY);
        return true;
    }

    private void ag(float f) {
        float f2 = this.uSU.uTo.getSharedPreferences(ab.bIX(), 0).getFloat("current_text_size_scale_key", 1.0f);
        w.i("MicroMsg.SettingsFontUI", "fontSizeAfter=" + f2);
        if (f != f2) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            com.tencent.mm.plugin.setting.a.imv.t(intent, this.uSU.uTo);
            com.tencent.mm.sdk.b.b gbVar = new gb();
            gbVar.fLp.fLq = f;
            gbVar.fLp.fLr = f2;
            com.tencent.mm.sdk.b.a.urY.m(gbVar);
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent2.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ab.getContext().sendBroadcast(intent2);
        }
    }
}
