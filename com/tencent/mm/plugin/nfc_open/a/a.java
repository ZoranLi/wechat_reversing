package com.tencent.mm.plugin.nfc_open.a;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

public final class a extends c<k> {
    public a() {
        this.usg = k.class.getName().hashCode();
    }

    private static boolean a(k kVar) {
        if ((kVar instanceof k) && kVar.fCy != null) {
            int i = kVar.fCy.actionCode;
            Context context = kVar.fCy.context;
            Bundle bundle = new Bundle();
            String str;
            switch (i) {
                case 4001:
                    bundle.putInt(DownloadInfo.STATUS, com.tencent.mm.plugin.nfc.b.a.a.aOZ().cE(context));
                    break;
                case 4002:
                    bundle.putInt(DownloadInfo.STATUS, com.tencent.mm.plugin.nfc.b.a.a.aOZ().cF(context));
                    break;
                case 4003:
                    str = kVar.fCy.fCA;
                    if (!bg.mA(str)) {
                        try {
                            bundle.putString("result", com.tencent.mm.plugin.nfc.b.a.a.aOZ().a(new com.tencent.mm.plugin.nfc.a.a(str)).toString());
                            break;
                        } catch (Throwable e) {
                            w.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                            w.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e, "", new Object[0]);
                            bundle.putString("result", null);
                            break;
                        }
                    }
                    w.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                    break;
                case 4004:
                    try {
                        str = kVar.fCy.fCA;
                        boolean z = kVar.fCy.fCB;
                        boolean z2 = kVar.fCy.fCC;
                        if (bg.mA(str)) {
                            w.e("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu is null");
                            break;
                        }
                        String[] split = str.split("\\|");
                        List<com.tencent.mm.plugin.nfc.b.a> arrayList = new ArrayList();
                        for (String str2 : split) {
                            if (bg.mA(str2)) {
                                w.w("MicroMsg.ApduEngineFuncListener", "[NFC] batch transceive apduStr is null");
                            } else {
                                String[] split2 = str2.split(":");
                                if (split2 == null || split2.length < 2) {
                                    w.w("MicroMsg.ApduEngineFuncListener", "[NFC] transceive apdu's size is wrong");
                                } else {
                                    int i2 = bg.getInt(split2[0], 0);
                                    arrayList.add(new com.tencent.mm.plugin.nfc.b.a(i2, String.valueOf(i2), new com.tencent.mm.plugin.nfc.a.a(split2[1])));
                                }
                            }
                        }
                        com.tencent.mm.plugin.nfc.b.a.a.aOZ().a(arrayList, z, z2);
                        StringBuilder stringBuilder = new StringBuilder();
                        for (com.tencent.mm.plugin.nfc.b.a aVar : arrayList) {
                            if (aVar.nZf == null) {
                                bundle.putString("result", stringBuilder.toString());
                                break;
                            }
                            stringBuilder.append(aVar.id);
                            stringBuilder.append(":");
                            stringBuilder.append(aVar.nZf.toString());
                            stringBuilder.append("|");
                        }
                        bundle.putString("result", stringBuilder.toString());
                    } catch (Throwable e2) {
                        w.e("MicroMsg.ApduEngineFuncListener", "alex: exec nfc command exception");
                        w.printErrStackTrace("MicroMsg.ApduEngineFuncListener", e2, "", new Object[0]);
                        bundle.putString("result", null);
                        break;
                    }
                    break;
                case 4005:
                    bundle.putString(SlookAirButtonFrequentContactAdapter.ID, com.tencent.mm.plugin.nfc.c.a.aB(com.tencent.mm.plugin.nfc.b.a.a.aOZ().nZh));
                    break;
                case 4008:
                    bundle.putString("info", com.tencent.mm.plugin.nfc.b.a.a.aOZ().getInfo());
                    break;
            }
            kVar.fCz.fCD = bundle;
        }
        return false;
    }
}
