package com.tencent.mm.plugin.emoji.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.emoji.a.a.c;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.f.q;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2RewardUI;
import com.tencent.mm.protocal.c.pn;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ak;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import java.util.ArrayList;

public final class g {
    private final String TAG = "MicroMsg.emoji.PayOrDownloadComponent";
    public com.tencent.mm.plugin.emoji.a.a.a kLV;
    public boolean kLW = false;
    public Context kLX;
    public Fragment kLY;
    public int kLZ;
    public long kMa = 0;
    public String kMb = "";
    public b kMc;
    private String kMd;
    private com.tencent.mm.plugin.emoji.h.b kMe = new com.tencent.mm.plugin.emoji.h.b(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
    public String kMf;
    private Context ty = ab.getContext();

    public interface a {
        void a(com.tencent.mm.plugin.emoji.a.a aVar);
    }

    public interface b {
        void E(String str, String str2, String str3);

        void alT();
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        if (aVar != null && aVar.kHz != null && this.kLV != null && this.kLV.kIP != null) {
            pn pnVar = aVar.kHz.kJb;
            if (pnVar != null) {
                String str;
                String str2 = pnVar.tgW;
                String str3 = pnVar.tuV;
                String str4 = pnVar.tvg;
                String str5 = pnVar.tvh;
                int alc = aVar.alc();
                (aVar.kHz == null ? null : Integer.valueOf(aVar.kHz.kJd)).intValue();
                c cVar = this.kLV.kIP;
                boolean z = cVar.kIY;
                boolean z2 = aVar.kHz.kJf;
                String str6 = "MicroMsg.emoji.PayOrDownloadComponent";
                String str7 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
                Object[] objArr = new Object[3];
                objArr[0] = str2;
                if (TextUtils.isEmpty(str4)) {
                    str = "";
                } else {
                    str = str4;
                }
                objArr[1] = str;
                objArr[2] = Integer.valueOf(alc);
                w.i(str6, str7, objArr);
                this.kMd = str2;
                int i;
                ak tX;
                switch (alc) {
                    case -1:
                        if (e.a(pnVar)) {
                            i = 3;
                        } else if (e.b(pnVar) || (!z && TextUtils.isEmpty(pnVar.tuY))) {
                            i = 3;
                        } else if (z) {
                            tX = cVar.tX(str2);
                            if (TextUtils.isEmpty(tX.uJv)) {
                                i = tX.uJt;
                            } else {
                                i = 4;
                            }
                        } else {
                            i = 4;
                        }
                        this.kLV.aH(str2, i);
                        return;
                    case 0:
                        if (this.kLV != null) {
                            this.kLV.aH(str2, 3);
                            return;
                        }
                        return;
                    case 3:
                    case 5:
                        if (com.tencent.mm.plugin.emoji.h.a.d(pnVar)) {
                            com.tencent.mm.plugin.emoji.f.a.amh();
                            com.tencent.mm.plugin.emoji.f.a.ami();
                            return;
                        }
                        E(str2, null, str3);
                        if (this.kLV != null) {
                            this.kLV.aI(str2, 0);
                        }
                        w.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str2});
                        com.tencent.mm.plugin.report.service.g.oUh.i(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(this.kLZ), "", str2, Long.valueOf(this.kMa), this.kMb});
                        return;
                    case 4:
                    case 12:
                        if (!this.kLW) {
                            Intent intent = new Intent();
                            intent.putExtra("key_product_id", str2);
                            if (z) {
                                intent.putExtra("key_currency_type", "");
                                intent.putExtra("key_price", str4);
                            } else {
                                intent.putExtra("key_currency_type", str5);
                                intent.putExtra("key_price", str4);
                            }
                            d.b(this.kLX, "wallet_index", ".ui.WalletIapUI", intent, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
                            this.kLW = true;
                            com.tencent.mm.plugin.report.service.g.oUh.i(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.kLZ), "", str2, Long.valueOf(this.kMa), this.kMb});
                            return;
                        }
                        return;
                    case 7:
                        if (z2) {
                            if ((this.kLY != null ? 1 : null) != null) {
                                com.tencent.mm.plugin.emoji.h.b bVar = this.kMe;
                                Fragment fragment = this.kLY;
                                w.d("MicroMsg.emoji.UseSmileyTool", "jacks sendToFriend emoji");
                                Intent intent2 = new Intent();
                                intent2.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                                intent2.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                                d.a(fragment, ".ui.transmit.SelectConversationUI", intent2, bVar.jiv);
                                fragment.aG().overridePendingTransition(R.a.aRq, R.a.aQY);
                            } else {
                                this.kMe.u((Activity) this.kLX);
                            }
                            this.kMe.kZN = str2;
                            com.tencent.mm.plugin.report.service.g.oUh.i(12069, new Object[]{Integer.valueOf(1), str2});
                            return;
                        } else if (aVar.kHz.kJh) {
                            str4 = aVar.kHz.kJb.tgW;
                            String str8 = aVar.kHz.kJb.tuV;
                            str2 = this.kMf;
                            if (this.kLX != null) {
                                i = this.kLZ == 9 ? 3 : 4;
                                Intent intent3 = new Intent();
                                intent3.setClass(this.kLX, EmojiStoreV2RewardUI.class);
                                intent3.putExtra("extra_id", str4);
                                intent3.putExtra("extra_name", str8);
                                intent3.putExtra("name", str2);
                                intent3.putExtra("scene", this.kLZ);
                                intent3.putExtra("pageType", i);
                                intent3.putExtra("searchID", this.kMa);
                                this.kLX.startActivity(intent3);
                                com.tencent.mm.plugin.report.service.g.oUh.i(12738, new Object[]{str4, Integer.valueOf(i), Integer.valueOf(this.kLZ), Integer.valueOf(0)});
                                return;
                            }
                            w.i("MicroMsg.emoji.PayOrDownloadComponent", "start reward ui faild. context is null");
                            return;
                        } else {
                            return;
                        }
                    case 9:
                        ap.vd().a(new q(str2, 2), 0);
                        return;
                    case 10:
                        tX = cVar.tX(str2);
                        if (tX != null) {
                            switch (tX.uJu) {
                                case 10233:
                                    str = getString(R.l.ecK);
                                    break;
                                case 10234:
                                    str = getString(R.l.ecE);
                                    break;
                                case 10235:
                                    str = getString(R.l.eek);
                                    break;
                                default:
                                    str = getString(R.l.eeo);
                                    break;
                            }
                            com.tencent.mm.ui.base.g.b(this.kLX, str, null, true);
                            return;
                        }
                        return;
                    case 11:
                        w.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] cannot action when loading.");
                        return;
                    default:
                        w.w("MicroMsg.emoji.PayOrDownloadComponent", "[onProductClick] unkonw product status");
                        return;
                }
            }
        }
    }

    private void E(String str, String str2, String str3) {
        if (this.kMc != null) {
            this.kMc.E(str, str2, str3);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        w.d("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        String str = "";
        int i3 = 0;
        if (intent != null) {
            i3 = intent.getIntExtra("key_err_code", 0);
            w.w("MicroMsg.emoji.PayOrDownloadComponent", "errCode:" + i3);
            str = intent.getStringExtra("key_err_msg");
            w.w("MicroMsg.emoji.PayOrDownloadComponent", "errMsg:" + str);
        }
        String str2 = str;
        this.kLW = false;
        if (i2 == -1) {
            switch (i) {
                case MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN /*2001*/:
                    if (this.kLV != null && this.kLV.kIP != null) {
                        if (intent != null && r0 == 0) {
                            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                            Object obj = null;
                            int size = stringArrayListExtra.size();
                            int i4 = 0;
                            while (i4 < size) {
                                Object obj2;
                                String str3 = (String) stringArrayListExtra.get(i4);
                                str = (String) stringArrayListExtra2.get(i4);
                                ak tX = this.kLV.kIP.tX(str3);
                                if (this.kMd.equals(str3)) {
                                    obj = 1;
                                    E(str3, str, tX.kSV);
                                    this.kLV.aI(this.kMd, 0);
                                    com.tencent.mm.ui.base.g.bl(this.kLX, str2);
                                    w.i("MicroMsg.emoji.PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{str3});
                                    if (stringArrayListExtra.size() > 1) {
                                        w.i("MicroMsg.emoji.PayOrDownloadComponent", "some other product verify.");
                                        if (this.kMc != null) {
                                            this.kMc.alT();
                                            obj2 = 1;
                                        }
                                    }
                                    obj2 = obj;
                                } else {
                                    this.kLV.aH(this.kMd, 5);
                                    obj2 = obj;
                                }
                                i4++;
                                obj = obj2;
                            }
                            if (obj == null) {
                                uw(str2);
                            }
                            if (m.xX()) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 4, 1, false);
                                return;
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 0, 1, false);
                                return;
                            }
                        } else if (intent != null && r0 == 103) {
                            E(this.kMd, null, this.kLV.kIP.tX(this.kMd).kSV);
                            this.kLV.aI(this.kMd, 0);
                            w.i("MicroMsg.emoji.PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[]{this.kMd});
                            uw(str2);
                            if (m.xX()) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 7, 1, false);
                                return;
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 3, 1, false);
                                return;
                            }
                        } else if (intent == null || r0 != 100000000) {
                            if (!(this.kMd == null || this.kLV == null || this.kLV.kIP == null)) {
                                this.kLV.kIP.tV(this.kMd);
                                com.tencent.mm.plugin.emoji.a.a tT = this.kLV.tT(this.kMd);
                                if (tT != null) {
                                    tT.alh();
                                }
                            }
                            uw(str2);
                            if (m.xX()) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 5, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 1, 1, false);
                            }
                            w.i("MicroMsg.emoji.PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[]{str2});
                            return;
                        } else {
                            if (m.xX()) {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 6, 1, false);
                            } else {
                                com.tencent.mm.plugin.report.service.g.oUh.a(166, 2, 1, false);
                            }
                            w.i("MicroMsg.emoji.PayOrDownloadComponent", "user cancel pay emoji.");
                            return;
                        }
                    }
                    return;
                case MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK /*2003*/:
                    str = this.kMe.kZN;
                    if (!bg.mA(str)) {
                        com.tencent.mm.plugin.emoji.h.b.a(intent, str, (Activity) this.kLX);
                        com.tencent.mm.plugin.report.service.g.oUh.i(12069, new Object[]{Integer.valueOf(3), str});
                        return;
                    }
                    return;
                default:
                    w.e("MicroMsg.emoji.PayOrDownloadComponent", "onActivityResult unknow request");
                    return;
            }
        } else if (i != MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN) {
        } else {
            if (m.xX()) {
                com.tencent.mm.plugin.report.service.g.oUh.a(166, 6, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.oUh.a(166, 2, 1, false);
            }
        }
    }

    private void uw(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.ecO);
        }
        com.tencent.mm.ui.base.g.a(this.kLX, str, "", new OnClickListener(this) {
            final /* synthetic */ g kMg;

            {
                this.kMg = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private String getString(int i) {
        return this.ty.getString(i);
    }
}
