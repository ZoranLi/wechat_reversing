package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class SafeDeviceListPreference extends Preference implements e {
    public Context context;
    public ProgressDialog isv;
    private Button kzq;
    private int mode;
    c oUZ;
    private boolean oVa;
    a oVb;
    b oVc;

    public interface a {
        void DD(String str);
    }

    public interface b {
        void DC(String str);
    }

    public SafeDeviceListPreference(Context context) {
        this(context, null);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = -2;
        this.oVa = false;
        this.context = context;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.h.content);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(R.i.djc, viewGroup2);
        }
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.oVa = true;
        this.kzq = (Button) view.findViewById(R.h.bHT);
        KC();
        super.onBindView(view);
    }

    public final void sb(int i) {
        this.mode = i;
        KC();
    }

    public final void LM() {
        ap.vd().b(362, this);
    }

    private void KC() {
        if (this.oVa) {
            switch (this.mode) {
                case -2:
                    setWidgetLayoutResource(R.i.djm);
                    return;
                case 1:
                    setWidgetLayoutResource(R.i.dae);
                    if (this.kzq != null) {
                        this.kzq.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SafeDeviceListPreference oVd;

                            {
                                this.oVd = r1;
                            }

                            public final void onClick(View view) {
                                SafeDeviceListPreference safeDeviceListPreference = this.oVd;
                                g.a(safeDeviceListPreference.context, safeDeviceListPreference.context.getString(R.l.eNQ, new Object[]{safeDeviceListPreference.oUZ.field_name}), "", com.tencent.mm.bg.a.V(safeDeviceListPreference.context, R.l.eNR), com.tencent.mm.bg.a.V(safeDeviceListPreference.context, R.l.dGs), new DialogInterface.OnClickListener(safeDeviceListPreference) {
                                    final /* synthetic */ SafeDeviceListPreference oVd;

                                    {
                                        this.oVd = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ap.vd().a(362, this.oVd);
                                        final k aVar = new com.tencent.mm.plugin.safedevice.a.a(this.oVd.oUZ.field_uid);
                                        ap.vd().a(aVar, 0);
                                        this.oVd.isv = g.a(this.oVd.context, com.tencent.mm.bg.a.V(this.oVd.context, R.l.dJd), true, new OnCancelListener(this) {
                                            final /* synthetic */ AnonymousClass1 oVf;

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                ap.vd().c(aVar);
                                                this.oVf.oVd.LM();
                                            }
                                        });
                                    }
                                }, new DialogInterface.OnClickListener(safeDeviceListPreference) {
                                    final /* synthetic */ SafeDeviceListPreference oVd;

                                    {
                                        this.oVd = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            }
                        });
                        return;
                    }
                    return;
                default:
                    setWidgetLayoutResource(R.i.djm);
                    return;
            }
        }
        w.d("MicroMsg.SafeDeviceListPreference", "has not binded");
    }

    public final void a(int i, int i2, String str, k kVar) {
        LM();
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (i2 == 0 && i2 == 0) {
            f.aXP().a(this.oUZ, new String[0]);
            if (this.oVc != null) {
                this.oVc.DC(this.igL);
            }
        } else if (!com.tencent.mm.plugin.c.a.imw.a(this.context, i, i2, str)) {
            Toast.makeText(this.context, this.context.getString(R.l.eNS, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.oVb != null) {
                this.oVb.DD(this.oUZ.field_uid);
            }
        }
    }
}
