package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.wallet_index.c.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletSendC2CMsgUI extends WalletBaseUI {
    private int hPi;
    private Map<String, String> rQA = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(8);
        this.hPi = getIntent().getIntExtra("key_scene", 0);
        w.i("MicroMsg.WalletSendC2CMsgUI", "scene:" + this.hPi);
        if (this.hPi == 0) {
            hn(580);
            if (getIntent() == null) {
                w.e("MicroMsg.WalletSendC2CMsgUI", "func[doCheckPayNetscene] intent null");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
                return;
            }
            q(new com.tencent.mm.plugin.wallet_core.b.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 6));
        } else if (!Ix(null)) {
            w.d("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ho(580);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
                w.i("MicroMsg.WalletSendC2CMsgUI", "Check jsapi suc & Go Select Contact");
                w.i("MicroMsg.WalletSendC2CMsgUI", "doCallSelectConversationUI");
                Map bvz = bvz();
                if (bvz != null && bvz.containsKey("togroup") && "0".equals(bvz.get("togroup"))) {
                    z = true;
                }
                Intent intent = new Intent();
                int i3 = z ? 7 : 3;
                intent.putExtra("select_is_ret", true);
                intent.putExtra("Select_Conv_Type", i3);
                d.a(this, ".ui.transmit.SelectConversationUI", intent, 1);
                return true;
            } else if (kVar instanceof c) {
                w.i("MicroMsg.WalletSendC2CMsgUI", "Send c2c msg suc");
                if (this.hPi == 1) {
                    g.bl(this, getString(R.l.fki));
                } else {
                    g.bl(this, getString(R.l.esl));
                    setResult(-1);
                }
                finish();
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.b.a) {
            w.e("MicroMsg.WalletSendC2CMsgUI", "Check jsapi fail");
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
            return true;
        } else if (kVar instanceof c) {
            if (this.hPi == 1) {
                g.bl(this, str);
            } else {
                setResult(DownloadResult.CODE_UNDEFINED);
            }
            finish();
            return true;
        } else {
            setResult(DownloadResult.CODE_UNDEFINED);
            finish();
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            w.d("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = " + intent.toString());
        } else {
            w.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, requestCode = " + i + ", resultCode = " + i2 + ", data = null");
        }
        if (i != 1) {
            w.e("MicroMsg.WalletSendC2CMsgUI", "onActivityResult, unknown requestCode = " + i);
        } else if (i2 != -1 || intent == null) {
            w.e("MicroMsg.WalletSendC2CMsgUI", "cancel select contact fail");
            setResult(0);
            finish();
        } else {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            w.d("MicroMsg.WalletSendC2CMsgUI", "Select user , " + bg.mz(stringExtra));
            if (!Ix(stringExtra)) {
                w.e("MicroMsg.WalletSendC2CMsgUI", "doSendC2CMsg fail");
                setResult(DownloadResult.CODE_UNDEFINED);
                finish();
            }
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    private boolean Ix(String str) {
        String stringExtra;
        String stringExtra2;
        String encode;
        String stringExtra3;
        String stringExtra4;
        String stringExtra5;
        String str2;
        String str3 = null;
        if (this.hPi == 1) {
            str = getIntent().getStringExtra("key_receiver");
            stringExtra = getIntent().getStringExtra("key_sender_des");
            stringExtra2 = getIntent().getStringExtra("key_receiver_des");
            encode = URLEncoder.encode(getIntent().getStringExtra("key_url"));
            stringExtra3 = getIntent().getStringExtra("key_templateid");
            str3 = getIntent().getStringExtra("key_sceneid");
            stringExtra4 = getIntent().getStringExtra("key_receivertitle");
            stringExtra5 = getIntent().getStringExtra("key_sendertitle");
            str2 = str;
        } else {
            Map bvz = bvz();
            if (bvz == null || bg.mA(str)) {
                stringExtra3 = null;
                encode = null;
                stringExtra2 = null;
                stringExtra = null;
                stringExtra5 = null;
                stringExtra4 = null;
                str2 = str;
            } else {
                stringExtra4 = URLDecoder.decode(bg.mz((String) bvz.get("receivertitle")));
                stringExtra5 = URLDecoder.decode(bg.mz((String) bvz.get("sendertitle")));
                stringExtra = URLDecoder.decode(bg.mz((String) bvz.get("senderdes")));
                stringExtra2 = URLDecoder.decode(bg.mz((String) bvz.get("receiverdes")));
                encode = bg.mz((String) bvz.get(SlookSmartClipMetaTag.TAG_TYPE_URL));
                stringExtra3 = URLDecoder.decode(bg.mz((String) bvz.get("templateid")));
                str3 = URLDecoder.decode(bg.mz((String) bvz.get("senceid")));
                str2 = str;
            }
        }
        if (bg.mA(encode) || bg.mA(stringExtra3)) {
            w.w("MicroMsg.WalletSendC2CMsgUI", "url = " + bg.mA(encode) + "templateId=" + bg.mA(stringExtra3));
            return false;
        }
        w.d("MicroMsg.WalletSendC2CMsgUI", "send c2c msg to" + str2);
        k(new c(str2, stringExtra4, stringExtra5, stringExtra3, stringExtra, stringExtra2, encode, str3));
        return true;
    }

    private Map<String, String> bvz() {
        if (this.rQA == null) {
            String stringExtra = getIntent().getStringExtra("packageExt");
            w.d("MicroMsg.WalletSendC2CMsgUI", "func[getPackageData] packageExt: " + stringExtra);
            if (!bg.mA(stringExtra)) {
                String[] split = stringExtra.split("&");
                this.rQA = new HashMap();
                if (split != null && split.length > 0) {
                    for (int i = 0; i < split.length; i++) {
                        if (!bg.mA(split[i])) {
                            String[] split2 = split[i].split("=");
                            if (split2.length == 2 && !bg.mA(split2[0])) {
                                this.rQA.put(split2[0], split2[1]);
                            }
                        }
                    }
                }
            }
        }
        return this.rQA;
    }
}
