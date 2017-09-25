package com.tencent.mm.performance.wxperformancetool;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.os.Looper;
import com.tencent.mm.bl.b;
import com.tencent.mm.performance.c.a;
import com.tencent.mm.performance.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public final class d {
    public static HashMap<String, WeakReference<Object>> ihc = new HashMap();
    public c ihd = new c();

    public d(final Context context) {
        if (this.ihd.Ne()) {
            this.ihd.a(new a());
            if (a.isEnabled() && this.ihd.Nf()) {
                this.ihd.ml(c.TYPE);
                this.ihd.a(new c.c(this) {
                    final /* synthetic */ d ihe;

                    public final void a(final com.tencent.mm.performance.d.d<Object> dVar, boolean z) {
                        Object obj = dVar.get();
                        if (obj != null) {
                            w.e("MicroMsg.WxPerformace", "memoryleak===" + obj.getClass().toString() + "   " + z);
                            if (!obj.getClass().equals(MemoryLeakActivity.class)) {
                                b.bOf();
                                if (dVar.get() != null) {
                                    final String str = new SimpleDateFormat("yyMMdd_HHmmss").format(new Date()) + "_" + dVar.igL.replace('.', '_');
                                    final AlertDialog create = new Builder(context).setTitle("UILeak found!").setMessage("Dumping hprof...").setCancelable(false).create();
                                    create.getWindow().setType(2005);
                                    create.setOnShowListener(new OnShowListener(this) {
                                        final /* synthetic */ AnonymousClass1 ihi;

                                        public final void onShow(DialogInterface dialogInterface) {
                                            af.v(new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 ihj;

                                                {
                                                    this.ihj = r1;
                                                }

                                                public final void run() {
                                                    String Sx = b.Sx(str);
                                                    create.dismiss();
                                                    if (Sx == null || Sx.length() <= 0) {
                                                        w.e("MicroMsg.WxPerformace", "Failed to dump hprof file, do not wake up analyse app.");
                                                    } else {
                                                        a.h(ab.getContext(), Sx, dVar.igL);
                                                    }
                                                }
                                            });
                                        }
                                    });
                                    create.show();
                                }
                            }
                        }
                    }
                });
            }
        }
        if (this.ihd.Ng()) {
            this.ihd.a(new com.tencent.mm.performance.b.a.a(this) {
                final /* synthetic */ d ihe;

                {
                    this.ihe = r1;
                }

                public final void a(long j, long j2, long j3) {
                    w.e("MicroMsg.WxPerformace", "onMemoryDangerLow percentage:" + j + " max:" + j2 + " used:" + j3);
                }

                public final void b(long j, long j2, long j3) {
                    w.e("MicroMsg.WxPerformace", "onMemoryDangerMiddle percentage:" + j + " max:" + j2 + " used:" + j3);
                }

                public final void c(long j, long j2, long j3) {
                    w.e("MicroMsg.WxPerformace", "onMemoryDangerHigh percentage:" + j + " max:" + j2 + " used:" + j3);
                }
            });
        }
        b.igX = 3000;
        c cVar = this.ihd;
        if (cVar.ihb == null) {
            cVar.ihb = new b("MonitorHandlerThread", cVar);
            cVar.ihb.start();
            b bVar = cVar.ihb;
            Looper looper = cVar.ihb.getLooper();
            if (looper == null) {
                throw new IllegalArgumentException("setHandler, threadLooper is null");
            }
            bVar.mHandler = new com.tencent.mm.performance.wxperformancetool.b.AnonymousClass1(bVar, looper);
            bVar.mHandler.sendEmptyMessageDelayed(1, (long) b.igX);
        }
    }
}
