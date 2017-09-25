package com.tencent.mm.plugin.backup.backupui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.a.f;
import com.tencent.mm.plugin.backup.backuppcmodel.c;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMWizardActivity;
import java.lang.ref.WeakReference;

public final class a extends b {
    public static String TAG = "MicroMsg.BackupChatBanner";
    private View jIM = null;
    private com.tencent.mm.plugin.backup.a.b.a jIN = new a(this);

    private static class a implements com.tencent.mm.plugin.backup.a.b.a {
        private final WeakReference<a> jIP;

        a(a aVar) {
            this.jIP = new WeakReference(aVar);
        }

        public final void ZZ() {
            a aVar = (a) this.jIP.get();
            if (aVar != null) {
                aVar.Xj();
            } else {
                w.e(a.TAG, "BackupChatBanner WeakReference is null!");
            }
        }
    }

    public a(Context context) {
        super(context);
        w.i(TAG, "BackupChatBanner");
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu = -100;
        com.tencent.mm.plugin.backup.c.b.aaD().aae().jBu = -100;
        w.i(TAG, "initialize");
        if (this.view != null) {
            this.jIM = this.view.findViewById(R.h.brA);
            this.jIM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a jIO;

                {
                    this.jIO = r1;
                }

                public final void onClick(View view) {
                    w.i(a.TAG, "backupbanner onclick, backupMode[%d]", new Object[]{Integer.valueOf(e.aah())});
                    switch (e.aah()) {
                        case 1:
                            w.i(a.TAG, "backupbanner onclick, backupPcState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu)});
                            switch (com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu) {
                                case -4:
                                case 12:
                                case 14:
                                case 15:
                                case 22:
                                case 23:
                                    w.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu)});
                                    this.jIO.cM(false);
                                    return;
                                case 24:
                                case 25:
                                    w.i(a.TAG, "click backup banner skipToBackupPcUI,BackupPcState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu)});
                                    this.jIO.cM(true);
                                    return;
                                default:
                                    w.i(a.TAG, "click backup banner, BackupPcState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae().jBu)});
                                    return;
                            }
                        case 22:
                            w.i(a.TAG, "backupbanner onclick, backupMoveState[%d]", new Object[]{Integer.valueOf(com.tencent.mm.plugin.backup.c.b.aaD().aae().jBu)});
                            switch (com.tencent.mm.plugin.backup.c.b.aaD().aae().jBu) {
                                case -4:
                                case 12:
                                case 22:
                                case 23:
                                    w.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                                    this.jIO.cN(false);
                                    return;
                                case 24:
                                case 25:
                                    w.i(a.TAG, "click backup banner skipToBackupMoveRecoverUI, backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                                    this.jIO.cN(true);
                                    return;
                                default:
                                    w.i(a.TAG, "click backup banner,backupMoveState[%d]", new Object[]{Integer.valueOf(r0)});
                                    return;
                            }
                        default:
                            return;
                    }
                }
            });
        }
        Xj();
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abf().jGC = this.jIN;
        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abg().jGC = this.jIN;
        com.tencent.mm.plugin.backup.c.b.aaD().aaG().jDF = this.jIN;
    }

    public final int getLayoutId() {
        return R.i.brA;
    }

    public final void cM(boolean z) {
        w.i(TAG, "jumpToBackupPcUI");
        Intent className = new Intent().setClassName((Context) this.sNB.get(), "com.tencent.mm.plugin.backup.backuppcui.BackupPcUI");
        className.putExtra("isRecoverTransferFinishFromBanner", z);
        MMWizardActivity.z((Context) this.sNB.get(), className);
    }

    public final void cN(boolean z) {
        w.i(TAG, "jumpToBackupMoveRecoverUI, isRecoverTransferFinishFromBanner[%b]", new Object[]{Boolean.valueOf(z)});
        Intent className = new Intent().setClassName((Context) this.sNB.get(), "com.tencent.mm.plugin.backup.backupmoveui.BackupMoveRecoverUI");
        className.putExtra("isRecoverTransferFinishFromBanner", z);
        MMWizardActivity.z((Context) this.sNB.get(), className);
    }

    public final boolean Xj() {
        w.d(TAG, "refreshAndReturnIsVisible, backupMode[%d]", new Object[]{Integer.valueOf(e.aah())});
        f aae;
        TextView textView;
        Context context;
        int i;
        Object[] objArr;
        switch (e.aah()) {
            case 1:
                aae = com.tencent.mm.plugin.backup.backuppcmodel.b.abd().aae();
                w.i(TAG, "refreshPcState backupPcState[%d]", new Object[]{Integer.valueOf(aae.jBu)});
                switch (aae.jBu) {
                    case -4:
                        this.jIM.setVisibility(0);
                        if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt) {
                            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.duh);
                            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dKM));
                        } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt) {
                            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dul);
                            ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dKN));
                        }
                        return true;
                    case 12:
                    case 22:
                        this.jIM.setVisibility(0);
                        if (1 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt || 3 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt) {
                            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.duh);
                        } else if (2 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt || 4 == com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe().jGt) {
                            ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dul);
                        }
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLf));
                        return true;
                    case 14:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.duh);
                        textView = (TextView) this.view.findViewById(R.h.brC);
                        context = ab.getContext();
                        i = R.l.dLG;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aae.jBv);
                        objArr[1] = Integer.valueOf(aae.jBw);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe();
                        objArr[2] = c.abj();
                        textView.setText(context.getString(i, objArr));
                        return true;
                    case 15:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.duh);
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dKC));
                        return true;
                    case 23:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dul);
                        textView = (TextView) this.view.findViewById(R.h.brC);
                        context = ab.getContext();
                        i = R.l.dLp;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(aae.jBv);
                        objArr[1] = Integer.valueOf(aae.jBw);
                        com.tencent.mm.plugin.backup.backuppcmodel.b.abd().abe();
                        objArr[2] = c.abj();
                        textView.setText(context.getString(i, objArr));
                        return true;
                    case 24:
                        cM(true);
                        return true;
                    case 25:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dul);
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dLr));
                        return true;
                    case 26:
                    case 27:
                        this.jIM.setVisibility(8);
                        if (bg.bp((Context) this.sNB.get())) {
                            cM(true);
                        }
                        return true;
                    default:
                        this.jIM.setVisibility(8);
                        return false;
                }
            case 22:
                aae = com.tencent.mm.plugin.backup.c.b.aaD().aae();
                w.i(TAG, "refreshMoveRecoverState backupMoveState[%d]", new Object[]{Integer.valueOf(aae.jBu)});
                switch (aae.jBu) {
                    case -4:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dua);
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dJD));
                        return true;
                    case 22:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dua);
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dKl));
                        return true;
                    case 23:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dua);
                        textView = (TextView) this.view.findViewById(R.h.brC);
                        context = ab.getContext();
                        i = R.l.dKq;
                        objArr = new Object[3];
                        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.backup.c.b.aaD().aae().jBv);
                        objArr[1] = Integer.valueOf(aae.jBw);
                        com.tencent.mm.plugin.backup.c.b.aaD().aaG();
                        objArr[2] = com.tencent.mm.plugin.backup.c.c.aaL();
                        textView.setText(context.getString(i, objArr));
                        return true;
                    case 24:
                        if (bg.bp((Context) this.sNB.get())) {
                            cN(true);
                        }
                        return true;
                    case 25:
                        this.jIM.setVisibility(0);
                        ((ImageView) this.view.findViewById(R.h.brB)).setImageResource(R.k.dua);
                        ((TextView) this.view.findViewById(R.h.brC)).setText(ab.getContext().getString(R.l.dKs));
                        return true;
                    case 26:
                    case 27:
                        this.jIM.setVisibility(8);
                        if (bg.bp((Context) this.sNB.get())) {
                            cN(true);
                        }
                        return true;
                    default:
                        this.jIM.setVisibility(8);
                        return false;
                }
            default:
                this.jIM.setVisibility(8);
                return false;
        }
    }

    public final void destroy() {
    }

    public final int getOrder() {
        return 3;
    }
}
