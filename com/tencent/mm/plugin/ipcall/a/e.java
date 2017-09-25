package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.e.a.bb;
import com.tencent.mm.plugin.ipcall.a.g.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Map;

public final class e {
    private static e mMK = null;
    c irS = new c<bb>(this) {
        final /* synthetic */ e mMM;

        {
            this.mMM = r2;
            this.usg = bb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bb bbVar = (bb) bVar;
            if (bbVar.fEA.fEB == 39) {
                w.i("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener callback");
                byte[] d = com.tencent.mm.a.e.d(bbVar.fEA.filePath, 0, -1);
                if (d != null) {
                    this.mMM.av(d);
                } else {
                    w.e("MicroMsg.IPCallFeedbackConfigUpdater", "checkResUpdateListener file not exist");
                }
            }
            return false;
        }
    };
    public ArrayList<f> mML = null;

    private e() {
    }

    public static e aEa() {
        if (mMK == null) {
            mMK = new e();
        }
        return mMK;
    }

    public final boolean av(byte[] bArr) {
        try {
            try {
                Map q = bh.q(new String(bArr), "feedbackconfig");
                if (q != null) {
                    String str = ".feedbackconfig.resourceslist.resources";
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    while (true) {
                        String str2 = str + (i == 0 ? "" : Integer.valueOf(i));
                        String str3 = (String) q.get(str2 + ".$langid");
                        if (str3 != null) {
                            int i2 = i + 1;
                            f fVar = new f();
                            fVar.mRa = str3;
                            fVar.mRb = new ArrayList();
                            String str4 = str2 + ".string";
                            int i3 = 0;
                            while (true) {
                                com.tencent.mm.plugin.ipcall.a.g.e eVar = new com.tencent.mm.plugin.ipcall.a.g.e();
                                String str5 = str4 + (i3 == 0 ? "" : Integer.valueOf(i3));
                                str3 = (String) q.get(str5);
                                if (str3 == null) {
                                    break;
                                }
                                str5 = (String) q.get(str5 + ".$id");
                                if (str5 == null) {
                                    break;
                                }
                                i3++;
                                eVar.mQY = str5;
                                eVar.mQZ = str3;
                                fVar.mRb.add(eVar);
                            }
                            w.d("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse id:%s,wording count:%d", new Object[]{fVar.mRa, Integer.valueOf(fVar.mRb.size())});
                            arrayList.add(fVar);
                            i = i2;
                        } else {
                            w.i("MicroMsg.IPCallFeedbackConfigUpdater", "feedbackResource parse finished count:%d", new Object[]{Integer.valueOf(arrayList.size())});
                            this.mML = arrayList;
                            return true;
                        }
                    }
                }
                w.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse xml feedbackconfig error");
                return false;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e, "", new Object[0]);
                w.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config error: %s", new Object[]{e.getMessage()});
                return false;
            }
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.IPCallFeedbackConfigUpdater", e2, "", new Object[0]);
            w.e("MicroMsg.IPCallFeedbackConfigUpdater", "parse ipcall feedback config new string error: %s", new Object[]{e2.getMessage()});
            return false;
        }
    }
}
