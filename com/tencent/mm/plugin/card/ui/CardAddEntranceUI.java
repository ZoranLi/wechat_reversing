package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelbiz.AddCardToWXCardPackage.Resp;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.model.e;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@a(3)
public class CardAddEntranceUI extends MMActivity {
    private String appId;
    private int fVn = 8;
    LinkedList<iu> kjR = new LinkedList();
    private String kkc = "";
    private String kkd;
    private int kke = 0;

    protected final int getLayoutId() {
        return R.i.cWf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onCreate() intent == null");
            setResult(0);
            finish();
            return;
        }
        w.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI doRediect() handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.fVn = intent.getIntExtra("key_from_scene", 8);
        this.kke = intent.getIntExtra("key_stastic_scene", 0);
        w.i("MicroMsg.CardAddEntranceUI", "doRediect() from_scene:" + this.fVn + "  from_origin_scene:" + this.kke);
        this.kkc = intent.getStringExtra("key_package_name");
        String stringExtra2 = intent.getStringExtra("key_sign");
        String stringExtra3 = getIntent().getStringExtra("src_username");
        w.i("MicroMsg.CardAddEntranceUI", "doRediect() src_username:" + stringExtra3);
        String stringExtra4 = getIntent().getStringExtra("js_url");
        this.appId = getIntent().getStringExtra("key_app_id");
        this.kkd = getIntent().getStringExtra("key_transaction");
        String stringExtra5 = getIntent().getStringExtra("key_consumed_card_id");
        w.i("MicroMsg.CardAddEntranceUI", "doRediect() consumedCardId:" + stringExtra5);
        String stringExtra6 = getIntent().getStringExtra("key_template_id");
        List aC = h.aC(stringExtra, this.fVn);
        if (aC == null || aC.size() == 0) {
            w.e("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI initView () tempList == null || tempList.size() == 0");
            setResult(0);
            finish();
            return;
        }
        this.kjR.clear();
        this.kjR.addAll(aC);
        Intent intent2 = new Intent();
        intent2.putExtra("key_from_scene", this.fVn);
        intent2.putExtra("key_stastic_scene", this.kke);
        if (aC.size() == 1) {
            iu iuVar = (iu) aC.get(0);
            intent2.putExtra("key_card_id", iuVar.kdE);
            intent2.putExtra("key_card_ext", iuVar.fVm);
            intent2.putExtra("src_username", stringExtra3);
            intent2.putExtra("js_url", stringExtra4);
            intent2.putExtra("key_consumed_card_id", stringExtra5);
            intent2.putExtra("key_template_id", stringExtra6);
            intent2.putExtra("key_from_appbrand_type", intent.getIntExtra("key_from_appbrand_type", 0));
            intent2.setClass(this, CardDetailUI.class);
            startActivityForResult(intent2, 1);
            return;
        }
        intent2.putExtra("key_in_card_list", stringExtra);
        intent2.putExtra("key_package_name", this.kkc);
        intent2.putExtra("key_sign", stringExtra2);
        intent2.putExtra("src_username", stringExtra3);
        intent2.putExtra("js_url", stringExtra4);
        intent2.putExtra("key_consumed_card_id", stringExtra5);
        intent2.putExtra("key_template_id", stringExtra6);
        intent2.setClass(this, CardAcceptCardListUI.class);
        startActivityForResult(intent2, 2);
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.v("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI onActivityResult");
        if (i2 == -1) {
            w.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_OK");
        } else {
            w.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI RESULT_CANCELED");
        }
        LinkedList linkedList = new LinkedList();
        Iterator it = this.kjR.iterator();
        while (it.hasNext()) {
            iu iuVar = (iu) it.next();
            e eVar = new e();
            eVar.kdE = iuVar.kdE;
            eVar.fVm = iuVar.fVm;
            linkedList.add(eVar);
        }
        Intent intent2;
        if (i != 1) {
            if (i == 2) {
                w.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_ACCEPT_CARD_LIST");
                Object obj = "";
                if (intent != null) {
                    obj = intent.getStringExtra("card_list");
                }
                if (this.fVn != 7 && this.fVn != 16) {
                    if (this.fVn != 26) {
                        switch (i2) {
                            case -1:
                                if (!TextUtils.isEmpty(obj)) {
                                    I(-1, obj);
                                    break;
                                } else {
                                    I(-1, h.a(linkedList, true, this.fVn));
                                    break;
                                }
                            case 0:
                                if (!TextUtils.isEmpty(obj)) {
                                    I(0, obj);
                                    break;
                                } else {
                                    I(0, h.a(linkedList, false, this.fVn));
                                    break;
                                }
                            default:
                                break;
                        }
                    }
                    intent2 = new Intent();
                    switch (i2) {
                        case -1:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.aD(obj, this.fVn));
                                setResult(-1, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, true, this.fVn));
                            setResult(-1, intent2);
                            break;
                        case 0:
                            if (intent != null && !TextUtils.isEmpty(obj)) {
                                intent.putExtra("card_list", h.aD(obj, this.fVn));
                                setResult(0, intent);
                                break;
                            }
                            intent2.putExtra("card_list", h.a(linkedList, false, this.fVn));
                            intent2.putExtra("result_code", 1);
                            setResult(0, intent2);
                            break;
                        default:
                            break;
                    }
                }
                intent2 = new Intent();
                switch (i2) {
                    case -1:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.aD(obj, this.fVn));
                            setResult(-1, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, true, this.fVn));
                        setResult(-1, intent2);
                        break;
                        break;
                    case 0:
                        if (intent != null && !TextUtils.isEmpty(obj)) {
                            intent.putExtra("card_list", h.aD(obj, this.fVn));
                            setResult(0, intent);
                            break;
                        }
                        intent2.putExtra("card_list", h.a(linkedList, false, this.fVn));
                        intent2.putExtra("result_code", 1);
                        setResult(0, intent2);
                        break;
                    default:
                        break;
                }
            }
        }
        w.i("MicroMsg.CardAddEntranceUI", "CardAddEntranceUI REQUEST_CARD_DETAIL");
        if (this.fVn != 7 && this.fVn != 16) {
            if (this.fVn != 26) {
                switch (i2) {
                    case -1:
                        if (intent != null && linkedList.size() > 0) {
                            ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                        }
                        I(-1, h.a(linkedList, true, this.fVn));
                        break;
                    case 0:
                        I(0, h.a(linkedList, false, this.fVn));
                        break;
                    default:
                        break;
                }
            }
            intent2 = new Intent();
            switch (i2) {
                case -1:
                    if (intent != null && linkedList.size() > 0) {
                        ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                    }
                    intent2.putExtra("card_list", h.a(linkedList, true, this.fVn));
                    setResult(-1, intent2);
                    break;
                case 0:
                    intent2.putExtra("card_list", h.a(linkedList, false, this.fVn));
                    setResult(0, intent2);
                    break;
                default:
                    break;
            }
        }
        intent2 = new Intent();
        switch (i2) {
            case -1:
                if (intent != null && linkedList.size() > 0) {
                    ((e) linkedList.get(0)).code = intent.getStringExtra("key_code");
                }
                intent2.putExtra("card_list", h.a(linkedList, true, this.fVn));
                setResult(-1, intent2);
                break;
            case 0:
                intent2.putExtra("card_list", h.a(linkedList, false, this.fVn));
                setResult(0, intent2);
                break;
        }
        finish();
    }

    private void I(int i, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("_wxapi_add_card_to_wx_card_list", str);
        f aJ = g.aJ(this.appId, true);
        Resp resp = new Resp(bundle);
        if (aJ != null) {
            resp.openId = aJ.field_openId;
        }
        resp.transaction = this.kkd;
        String str2 = "MicroMsg.CardAddEntranceUI";
        String str3 = "setResultToSDK, appid : %s, appname : %s, openid : %s, transcation : %s";
        Object[] objArr = new Object[4];
        objArr[0] = this.appId;
        objArr[1] = aJ == null ? "null appinfo" : aJ.field_appName;
        objArr[2] = aJ == null ? "null appinfo" : aJ.field_openId;
        objArr[3] = this.kkd;
        w.i(str2, str3, objArr);
        resp.toBundle(bundle);
        w.i("MicroMsg.CardAddEntranceUI", "setResultToSDK result:" + i);
        if (i == -1) {
            resp.errCode = 0;
        } else {
            resp.errCode = -2;
        }
        Args args = new Args();
        args.targetPkgName = this.kkc;
        args.bundle = bundle;
        p.aa(bundle);
        p.ab(bundle);
        MMessageActV2.send(ab.getContext(), args);
    }
}
