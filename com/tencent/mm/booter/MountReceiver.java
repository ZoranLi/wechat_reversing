package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.s;
import java.io.File;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private Context context = null;
    private ae gJP = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ MountReceiver gJQ;

        public final void handleMessage(Message message) {
            boolean z = true;
            String str = "MicroMsg.MountReceiver";
            String str2 = "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b";
            Object[] objArr = new Object[4];
            objArr[0] = this.gJQ.action;
            objArr[1] = Boolean.valueOf(ap.zb());
            if (this.gJQ.context != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(f.sa());
            w.d(str, str2, objArr);
            if (this.gJQ.context != null && f.sa()) {
                s.eQ(this.gJQ.context);
            }
        }
    };

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null && !u.mA(intent.getAction())) {
            this.context = context;
            this.action = intent.getAction();
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            w.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", this.action, Boolean.valueOf(ap.zb()), e.hgs, absolutePath);
            boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
            if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
                Object obj = !e.hgs.equalsIgnoreCase("/dev/null") ? 1 : null;
                if (obj != null) {
                    try {
                        StatFs statFs = new StatFs(e.hgs);
                        w.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", e.hgs, Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
                    } catch (Exception e) {
                        w.e("MicroMsg.MountReceiver", "CheckSD failed :%s", e.getMessage());
                        obj = null;
                    }
                }
                Uri data = intent.getData();
                if (data != null) {
                    String path = data.getPath();
                    if (!e.hgs.equalsIgnoreCase(path)) {
                        if (equals && r0 == null) {
                            g.oUh.a(340, e.hgs.equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                            if (!u.mA(absolutePath) && absolutePath.equalsIgnoreCase(path)) {
                                if (new File(com.tencent.mm.storage.w.hgq + "SdcardInfo.cfg").exists()) {
                                    com.tencent.mm.storage.s sVar = new com.tencent.mm.storage.s(com.tencent.mm.storage.w.hgq + "SdcardInfo.cfg");
                                    String str = (String) sVar.get(1, "");
                                    int intValue = ((Integer) sVar.get(2, Integer.valueOf(0))).intValue();
                                    int i = VERSION.SDK_INT;
                                    String str2 = e.hgs;
                                    sVar.set(1, absolutePath);
                                    sVar.set(2, Integer.valueOf(i));
                                    e.dw(absolutePath);
                                    w.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), str, Integer.valueOf(i), absolutePath, str2, e.hgs);
                                } else {
                                    w.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", e.hgs, absolutePath, Integer.valueOf(VERSION.SDK_INT));
                                    e.hgs = absolutePath;
                                    e.dw(absolutePath);
                                }
                            } else {
                                return;
                            }
                        }
                        return;
                    }
                }
                g.oUh.a(340, equals ? 13 : 14, 1, false);
                if (equals) {
                    ap.vL().D(new Runnable(this) {
                        final /* synthetic */ MountReceiver gJQ;

                        {
                            this.gJQ = r1;
                        }

                        public final void run() {
                            w.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", this.gJQ.action, Boolean.valueOf(ap.zb()));
                            if (ap.zb()) {
                                h.vI().vv();
                                ap.yY();
                                c.vt();
                                this.gJQ.gJP.sendEmptyMessage(0);
                            }
                        }
                    });
                    return;
                }
                s.eP(context);
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ MountReceiver gJQ;

                    {
                        this.gJQ = r1;
                    }

                    public final void run() {
                        w.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", this.gJQ.action, Boolean.valueOf(ap.zb()));
                        if (ap.zb()) {
                            h.vI().vv();
                            ap.yY();
                            c.vt();
                        }
                    }
                });
            }
        }
    }
}
