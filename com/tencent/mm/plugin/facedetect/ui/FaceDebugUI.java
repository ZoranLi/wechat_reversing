package com.tencent.mm.plugin.facedetect.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.facedetect.a.b;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.h;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.s;
import java.io.File;

public class FaceDebugUI extends MMPreference {
    private f isJ;
    private View kQt;
    private CheckBoxPreference lyk = null;
    private CheckBoxPreference lyl = null;
    private CheckBoxPreference lym = null;
    private CheckBoxPreference lyn = null;
    private CheckBoxPreference lyo = null;
    private CheckBoxPreference lyp = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kQt = findViewById(e.cki);
        this.kQt.setBackgroundResource(b.white);
        asj();
        qP(getString(h.ltH));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FaceDebugUI lyq;

            {
                this.lyq = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lyq.finish();
                return false;
            }
        });
    }

    private void asj() {
        this.isJ = this.vrv;
        this.lyk = (CheckBoxPreference) this.isJ.Td("face_debug_switch");
        this.lyl = (CheckBoxPreference) this.isJ.Td("face_debug_save_pic_switch");
        this.lym = (CheckBoxPreference) this.isJ.Td("face_debug_save_final_switch");
        this.lyn = (CheckBoxPreference) this.isJ.Td("face_debug_save_lipreading_switch");
        this.lyo = (CheckBoxPreference) this.isJ.Td("face_debug_save_voice_switch");
        this.lyp = (CheckBoxPreference) this.isJ.Td("face_debug_force_upload_video");
        this.isJ.notifyDataSetChanged();
    }

    protected void onResume() {
        super.onResume();
        ask();
    }

    protected void onStop() {
        super.onStop();
    }

    private void ask() {
        boolean arx = com.tencent.mm.plugin.facedetect.model.e.arx();
        boolean arz = com.tencent.mm.plugin.facedetect.model.e.arz();
        boolean arA = com.tencent.mm.plugin.facedetect.model.e.arA();
        boolean arB = com.tencent.mm.plugin.facedetect.model.e.arB();
        boolean arC = com.tencent.mm.plugin.facedetect.model.e.arC();
        boolean ary = com.tencent.mm.plugin.facedetect.model.e.ary();
        if (arx) {
            this.lyk.kX(true);
            this.isJ.aV("face_debug_save_pic_switch", false);
            this.isJ.aV("face_debug_save_final_switch", false);
            this.isJ.aV("face_debug_save_lipreading_switch", false);
            this.isJ.aV("face_debug_save_voice_switch", false);
            this.isJ.aV("face_debug_force_upload_video", false);
            this.lyl.kX(arz);
            this.lym.kX(arA);
            this.lyn.kX(arB);
            this.lyo.kX(arC);
            this.lyp.kX(ary);
        } else {
            this.lyk.kX(false);
            this.isJ.aV("face_debug_save_pic_switch", true);
            this.isJ.aV("face_debug_save_final_switch", true);
            this.isJ.aV("face_debug_save_lipreading_switch", true);
            this.isJ.aV("face_debug_save_voice_switch", true);
            this.isJ.aV("face_debug_force_upload_video", true);
        }
        this.isJ.notifyDataSetChanged();
    }

    public final int ON() {
        return i.lut;
    }

    public final boolean a(f fVar, Preference preference) {
        asj();
        if ("face_debug_switch".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dP(this.lyk.isChecked());
            ask();
            return true;
        } else if ("face_debug_save_pic_switch".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dQ(this.lyl.isChecked());
            ask();
            return true;
        } else if ("face_debug_save_final_switch".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dR(this.lym.isChecked());
            ask();
            return true;
        } else if ("face_debug_save_lipreading_switch".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dS(this.lyn.isChecked());
            ask();
            return true;
        } else if ("face_debug_save_voice_switch".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dT(this.lyo.isChecked());
            ask();
            return true;
        } else if ("face_debug_force_upload_video".equals(preference.igL)) {
            com.tencent.mm.plugin.facedetect.model.e.dU(this.lyp.isChecked());
            ask();
            return true;
        } else if ("face_debug_clear_resource".equals(preference.igL)) {
            r2 = new File(o.mm(0));
            if (r2.exists()) {
                r2.delete();
            }
            File file = new File(o.mm(1));
            if (file.exists()) {
                file.delete();
            }
            ao.hlW.L("LAST_LOGIN_FACE_MODEL_DETECT_VERSION", "-1");
            ao.hlW.L("LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION", "-1");
            return true;
        } else if (!"face_debug_check_resource".equals(preference.igL)) {
            return false;
        } else {
            r2 = new File(o.mm(0));
            File file2 = new File(o.mm(1));
            s.makeText(this.uSU.uTo, String.format("is detect model exists: %b, is alignment model exists: %b", new Object[]{Boolean.valueOf(r2.exists()), Boolean.valueOf(file2.exists())}), 0).show();
            w.i("MicroMsg.FaceDebugUI", "hy: detect bin md5: %s", new Object[]{g.f(r2)});
            w.i("MicroMsg.FaceDebugUI", "hy: alignment bin md5: %s", new Object[]{g.f(file2)});
            return true;
        }
    }
}
