package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.g.b;
import com.tencent.mm.plugin.t.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ba;
import com.tencent.mm.ui.base.s;

public final class j {
    static int lvH;
    public static boolean nCI = true;
    private static boolean nCJ = false;
    private static boolean nCK = false;
    public static o nCL;
    static double nCM;

    public static boolean b(Point point) {
        if (nCJ) {
            String str;
            Context context = ab.getContext();
            Resources resources = ab.getResources();
            int i = a.nNy;
            Object[] objArr = new Object[1];
            if (nCL == null) {
                str = "";
            } else {
                str = Integer.valueOf(nCL.nCU);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(i, objArr), 1).show();
            return false;
        }
        w.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(p.gRj.gRq), Integer.valueOf(p.gRj.gRx), Boolean.valueOf(nCK)});
        if (nCK) {
            return false;
        }
        if (p.gRj.gRq != -1) {
            return true;
        }
        if (nCL != null && 1 == nCL.gRq) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (d.pA(point.x) && d.pA(point.y)) {
            return true;
        }
        if (nCL != null) {
            w.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[]{point.toString()});
            nCL.gRq = 1;
        }
        return false;
    }

    public static void a(Parameters parameters, boolean z) {
        if (nCJ) {
            String str;
            Context context = ab.getContext();
            Resources resources = ab.getResources();
            int i = a.nNy;
            Object[] objArr = new Object[1];
            if (nCL == null) {
                str = "";
            } else {
                str = Integer.valueOf(nCL.nCU);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(i, objArr), 1).show();
            return;
        }
        w.i("MicroMsg.MMSightRecorderConfig", "autoConfig, recorderOption: %s, isUseRecorderOption: %s", new Object[]{Integer.valueOf(p.gRj.gRx), Boolean.valueOf(nCK)});
        if (!nCK) {
            boolean z2;
            o oVar;
            Point aKG = d.aKG();
            int i2 = bg.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
            w.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(bg.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(bg.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19))});
            if (p.gRj.gRw == -1 || (p.gRj.gRw & 1) != 0) {
                if (p.gRj.gRw != -1 && (p.gRj.gRw & 1) != 0) {
                    nCL.aKU().nCW = true;
                    z2 = true;
                    if (p.gRj.gRr != -1) {
                        nCL.nCV = false;
                    } else {
                        if (p.gRj.gRr == 1) {
                        }
                        nCL.nCV = p.gRj.gRr == 1;
                    }
                    if (p.gRj.gRw == -1) {
                    }
                    oVar = nCL;
                    oVar.nCY = g.a(parameters, d.aKG(), 720, oVar.nAE.width + 16, z);
                    if (oVar.nCY != null) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        oVar = nCL.aKS();
                        oVar.nCW = false;
                        oVar.aKT();
                    }
                    nCL.nCU = -1;
                    w.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{nCL.toString()});
                } else if (com.tencent.mm.compatible.util.d.eo(r3) && lvH >= 512 && nCM >= 1725.0d && Math.min(aKG.x, aKG.y) >= 1080) {
                    oVar = nCL;
                    oVar.nCY = g.a(parameters, d.aKG(), oVar.nAE.width * 2, oVar.nAE.width * 2, z);
                    if (oVar.nCY != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        nCL.aKU().nCW = true;
                        z2 = true;
                        if (p.gRj.gRr != -1) {
                            nCL.nCV = p.gRj.gRr == 1;
                        } else {
                            nCL.nCV = false;
                        }
                        if (p.gRj.gRw == -1 || (p.gRj.gRw & 2) != 0) {
                            if (p.gRj.gRw == -1 && (p.gRj.gRw & 2) != 0) {
                                oVar = nCL.aKS();
                                oVar.nCW = false;
                                oVar.aKT();
                            } else if (!z2 && com.tencent.mm.compatible.util.d.eo(r5) && lvH >= 512 && nCM >= 1725.0d && Math.min(aKG.x, aKG.y) >= 720) {
                                oVar = nCL;
                                oVar.nCY = g.a(parameters, d.aKG(), 720, oVar.nAE.width + 16, z);
                                if (oVar.nCY != null) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                if (z2) {
                                    oVar = nCL.aKS();
                                    oVar.nCW = false;
                                    oVar.aKT();
                                }
                            }
                        }
                        nCL.nCU = -1;
                        w.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{nCL.toString()});
                    }
                }
            }
            z2 = false;
            if (p.gRj.gRr != -1) {
                if (p.gRj.gRr == 1) {
                }
                nCL.nCV = p.gRj.gRr == 1;
            } else {
                nCL.nCV = false;
            }
            if (p.gRj.gRw == -1) {
            }
            oVar = nCL;
            oVar.nCY = g.a(parameters, d.aKG(), 720, oVar.nAE.width + 16, z);
            if (oVar.nCY != null) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                oVar = nCL.aKS();
                oVar.nCW = false;
                oVar.aKT();
            }
            nCL.nCU = -1;
            w.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{nCL.toString()});
        }
    }

    public static void b(VideoTransPara videoTransPara) {
        boolean z = true;
        nCJ = false;
        nCK = false;
        lvH = ((ActivityManager) ab.getContext().getSystemService("activity")).getLargeMemoryClass();
        nCM = (double) d.cz(ab.getContext());
        String bMW = ba.bMW();
        w.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[]{Integer.valueOf(bg.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19))});
        if (CaptureMMProxy.getInstance() != null) {
            p.du(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        w.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[]{Integer.valueOf(lvH), Double.valueOf(nCM), bMW, p.gRj});
        nCL = o.a(((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFd, Integer.valueOf(-1))).intValue(), videoTransPara);
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFg, Integer.valueOf(1))).intValue();
        if (nCL != null) {
            if (intValue == 1) {
                nCL.nCX = true;
            } else {
                nCL.nCX = false;
            }
            nCJ = true;
            Context context = ab.getContext();
            Resources resources = ab.getResources();
            int i = a.nNy;
            Object[] objArr = new Object[1];
            if (nCL == null) {
                bMW = "";
            } else {
                bMW = Integer.valueOf(nCL.nCU);
            }
            objArr[0] = bMW;
            s.makeText(context, resources.getString(i, objArr), 1).show();
            return;
        }
        int i2 = p.gRj.gRx;
        w.i("MicroMsg.MMSightRecorderConfig", "recorderOption: %s", new Object[]{Integer.valueOf(i2)});
        if (i2 != -1) {
            nCL = o.a(i2, videoTransPara);
        }
        if (nCL != null) {
            if (intValue == 1) {
                nCL.nCX = true;
            } else {
                nCL.nCX = false;
            }
            nCK = true;
            return;
        }
        nCL = o.a(1, videoTransPara);
        if (intValue == 1) {
            nCL.nCX = true;
        } else {
            nCL.nCX = false;
        }
        if (p.gRj.gRq != -1) {
            nCL.gRq = p.gRj.gRq;
        } else if (com.tencent.mm.compatible.util.d.eo(r3)) {
            nCL.gRq = 2;
        } else {
            nCL.gRq = 1;
        }
        if (p.gRj.gRt != -1) {
            boolean z2;
            if (p.gRj.gRt == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            nCI = z2;
        }
        if (p.gRj.gRr != -1) {
            o oVar = nCL;
            if (p.gRj.gRr != 1) {
                z = false;
            }
            oVar.nCV = z;
            return;
        }
        nCL.nCV = false;
    }

    public static void a(b bVar) {
        if (bVar.nCz == null) {
            w.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[]{bVar.toString()});
            bVar.nCz = bVar.nCC;
            bVar.nCA = bVar.nCD;
            bVar.nCB = bVar.nCE;
            if (Math.min(bVar.nCA.y, bVar.nCA.x) >= nCL.nAE.width + 16) {
                nCL.aKT();
                nCL.nCW = false;
                nCL.nCV = false;
                w.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[]{bVar.toString()});
            }
        }
    }
}
