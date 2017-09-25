package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rr;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.List;

public class VoipAddressUI extends MMBaseSelectContactUI {
    private String fJL = "";
    private List<String> jBA;
    private boolean waf = false;
    private boolean wag = false;
    private c wah = new c<rr>(this) {
        final /* synthetic */ VoipAddressUI wai;

        {
            this.wai = r2;
            this.usg = rr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((rr) bVar).fYI.fJK) {
                case 7:
                    this.wai.finish();
                    break;
                case 8:
                    this.wai.finish();
                    break;
            }
            return false;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.urY.b(this.wah);
    }

    public final void hf(int i) {
        com.tencent.mm.ui.contact.a.a aVar = (com.tencent.mm.ui.contact.a.a) this.oCR.getAdapter().getItem(i);
        if (aVar != null && aVar.jiL != null) {
            this.fJL = aVar.jiL.field_username;
            if (this.wag) {
                aTG();
            } else {
                aTF();
            }
        }
    }

    private void aTF() {
        w.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")), bg.bJZ(), this);
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 82, "", "")) {
            b rrVar = new rr();
            rrVar.fYI.fJK = 5;
            rrVar.fYI.fJL = this.fJL;
            rrVar.fYI.context = this;
            int i = this.waf ? 2 : 1;
            rrVar.fYI.fYD = 3;
            g.oUh.i(11033, Integer.valueOf(i), Integer.valueOf(2), Integer.valueOf(0));
            a.urY.m(rrVar);
            aHf();
        }
    }

    private void aTG() {
        w.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")), bg.bJZ(), this);
        if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.CAMERA", 19, "", "")) {
            w.i("MicroMsg.VoipAddressUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")), bg.bJZ(), this);
            if (com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 19, "", "")) {
                b rrVar = new rr();
                rrVar.fYI.fJK = 5;
                rrVar.fYI.fJL = this.fJL;
                rrVar.fYI.context = this;
                int i = this.waf ? 2 : 1;
                rrVar.fYI.fYD = 2;
                g.oUh.i(11033, Integer.valueOf(i), Integer.valueOf(1), Integer.valueOf(0));
                a.urY.m(rrVar);
                aHf();
            }
        }
    }

    protected final void Oe() {
        super.Oe();
        String stringExtra = getIntent().getStringExtra("LauncherUI.Shortcut.LaunchType");
        this.wag = getIntent().getBooleanExtra("voip_video", true);
        if (stringExtra != null) {
            this.waf = true;
            if (stringExtra.equals("launch_type_voip")) {
                this.wag = true;
            } else if (stringExtra.equals("launch_type_voip_audio")) {
                this.wag = false;
            }
        }
        this.jBA = new ArrayList();
        this.jBA.addAll(s.bYl());
        this.jBA.addAll(s.bYm());
    }

    protected final o Oi() {
        c.a aVar = new c.a();
        aVar.vWe = true;
        aVar.vWd = true;
        return new c(this, this.jBA, false, aVar);
    }

    protected final m Oj() {
        return new q(this, this.jBA, false, this.scene);
    }

    public static void eY(Context context) {
        int i = 0;
        boolean z = 1 == bg.getInt(com.tencent.mm.i.g.sV().getValue("VOIPCallType"), 0);
        Intent intent = new Intent(context, VoipAddressUI.class);
        intent.putExtra("Add_address_titile", context.getString(R.l.dCT));
        intent.putExtra("voip_video", z);
        context.startActivity(intent);
        g gVar = g.oUh;
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(1);
        if (!z) {
            i = 1;
        }
        objArr[1] = Integer.valueOf(i);
        gVar.i(11034, objArr);
    }

    protected final boolean Og() {
        return true;
    }

    public final int[] aIO() {
        return new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
    }

    public void onDestroy() {
        a.urY.c(this.wah);
        super.onDestroy();
    }

    protected final void aIP() {
        if (this.waf) {
            Intent intent = new Intent(this, LauncherUI.class);
            intent.addFlags(67108864);
            startActivity(intent);
        }
        aHf();
        finish();
    }

    protected final String Oh() {
        String stringExtra = getIntent().getStringExtra("Add_address_titile");
        if (bg.mA(stringExtra)) {
            return stringExtra;
        }
        return getString(R.l.dCT);
    }

    protected final boolean Of() {
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.VoipAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i) {
            case 19:
                if (iArr[0] == 0) {
                    aTG();
                    return;
                }
                int i2 = "android.permission.CAMERA".equals(strArr[0]) ? R.l.eFG : R.l.eFJ;
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(i2), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI wai;

                        {
                            this.wai = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.wai.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI wai;

                        {
                            this.wai = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                if (iArr[0] == 0) {
                    aTF();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a((Context) this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ VoipAddressUI wai;

                        {
                            this.wai = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.wai.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }
}
