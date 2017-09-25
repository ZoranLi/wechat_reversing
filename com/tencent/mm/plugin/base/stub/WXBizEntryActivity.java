package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsimple.ah;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.protocal.c.bfs;
import com.tencent.mm.protocal.c.ch;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public class WXBizEntryActivity extends AutoLoginActivity {
    private int jPj;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zg(0);
    }

    protected final int getLayoutId() {
        return R.i.cVO;
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected final void a(b bVar, Intent intent) {
        Uri uri = null;
        w.i("MicroMsg.WXBizEntryActivity", "postLogin, loginResult = " + bVar);
        if (getIntent() != null) {
            this.jPj = getIntent().getIntExtra("key_command_id", 0);
        }
        switch (bVar) {
            case LOGIN_OK:
                w.i("MicroMsg.WXBizEntryActivity", "req type = %d", Integer.valueOf(this.jPj));
                Intent intent2;
                Uri data;
                switch (this.jPj) {
                    case 7:
                    case 8:
                        intent2 = getIntent();
                        intent2.setClassName(this, "com.tencent.mm.ui.CheckCanSubscribeBizUI");
                        startActivity(intent2);
                        finish();
                        return;
                    case 9:
                        d.a((Context) this, "card", ".ui.CardAddEntranceUI", getIntent(), false);
                        finish();
                        return;
                    case 11:
                        intent2 = getIntent();
                        intent2.putExtra("device_type", 1);
                        d.a((Context) this, "exdevice", ".ui.ExdeviceRankInfoUI", intent2, false);
                        finish();
                        return;
                    case 12:
                        try {
                            uri = getIntent().getData();
                        } catch (Exception e) {
                            w.e("MicroMsg.WXBizEntryActivity", "post login get url from intent failed : %s", e.getMessage());
                        }
                        if (uri != null && com.tencent.mm.pluginsdk.d.LE(uri.toString())) {
                            q.yC().fP("key_data_center_session_id");
                            com.tencent.mm.pluginsdk.d.a((Context) this, uri.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(this) {
                                final /* synthetic */ WXBizEntryActivity jPk;

                                {
                                    this.jPk = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    w.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ah))) {
                                        bfs Jz = ((ah) kVar).Jz();
                                        if (!(Jz == null || this.jPk.isFinishing())) {
                                            s.makeText(this.jPk, this.jPk.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                                        }
                                    }
                                    this.jPk.finish();
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    case 13:
                        intent2 = getIntent();
                        intent2.putExtra("key_static_from_scene", 100001);
                        d.a((Context) this, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent2, false);
                        finish();
                        return;
                    case 14:
                    case 15:
                        new a(this, getIntent().getStringExtra("key_app_id"), getIntent().getStringExtra("open_id"), new d.a(this) {
                            final /* synthetic */ WXBizEntryActivity jPk;

                            {
                                this.jPk = r1;
                            }

                            public final void cR(boolean z) {
                                if (z) {
                                    d.a(this.jPk, "game", ".ui.CreateOrJoinChatroomUI", this.jPk.getIntent(), false);
                                } else {
                                    w.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
                                }
                                this.jPk.finish();
                            }
                        }).acH();
                        return;
                    case 16:
                        d.a((Context) this, "card", ".ui.CardListSelectedUI", getIntent(), false);
                        finish();
                        return;
                    case 17:
                        try {
                            data = getIntent().getData();
                            Runnable anonymousClass2 = new Runnable(this) {
                                final /* synthetic */ WXBizEntryActivity jPk;

                                {
                                    this.jPk = r1;
                                }

                                public final void run() {
                                    this.jPk.findViewById(R.h.ckm).setVisibility(8);
                                }
                            };
                            String stringExtra = getIntent().getStringExtra("key_package_name");
                            String stringExtra2 = getIntent().getStringExtra("key_package_signature");
                            int intExtra = getIntent().getIntExtra("translate_link_scene", 1);
                            w.d("MicroMsg.WXBizLogic", "dealWithHandleScanResult: callPackage=%s, packageSignature=%s", stringExtra, stringExtra2);
                            if (bg.mA(stringExtra) || bg.mA(stringExtra2)) {
                                w.e("MicroMsg.WXBizLogic", "dealWithHandleScanResult:packageName or signature null");
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            ch chVar = new ch();
                            w.i("MicroMsg.WXBizLogic", "dealWithHandleScanResult package name = %s", stringExtra);
                            chVar.tfA = stringExtra;
                            chVar.signature = stringExtra2;
                            linkedList.add(chVar);
                            k ahVar = new ah(data.toString(), intExtra, linkedList);
                            ap.vd().a(1200, new com.tencent.mm.plugin.base.stub.e.AnonymousClass1(this, anonymousClass2));
                            ap.vd().a(ahVar, 0);
                            return;
                        } catch (Exception e2) {
                            w.e("MicroMsg.WXBizEntryActivity", "get url from intent failed : %s", e2.getMessage());
                            return;
                        }
                    case 19:
                        try {
                            data = getIntent().getData();
                        } catch (Exception e22) {
                            w.e("MicroMsg.WXBizEntryActivity", "get data from intent for launch wxminiprogram failed : %s", e22.getMessage());
                            data = uri;
                        }
                        if (data != null) {
                            com.tencent.mm.pluginsdk.d.a((Context) this, data.toString(), getIntent().getIntExtra("translate_link_scene", 1), new a(this) {
                                final /* synthetic */ WXBizEntryActivity jPk;

                                {
                                    this.jPk = r1;
                                }

                                public final void a(int i, int i2, String str, k kVar, boolean z) {
                                    w.i("MicroMsg.WXBizEntryActivity", "launchWXMiniprogram, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z));
                                    if (!(kVar == null || i == 0 || i2 == 0 || !(kVar instanceof ah))) {
                                        bfs Jz = ((ah) kVar).Jz();
                                        if (!(Jz == null || this.jPk.isFinishing())) {
                                            s.makeText(this.jPk, this.jPk.getString(R.l.dIO) + " : " + bg.mz(Jz.ugf), 0).show();
                                        }
                                    }
                                    this.jPk.finish();
                                }
                            }, getIntent().getStringExtra("key_package_name"), getIntent().getStringExtra("key_package_signature"));
                            return;
                        }
                        return;
                    default:
                        finish();
                        return;
                }
            case LOGIN_CANCEL:
            case LOGIN_FAIL:
                w.e("MicroMsg.WXBizEntryActivity", "postLogin fail, loginResult = " + bVar);
                break;
            default:
                w.e("MicroMsg.WXBizEntryActivity", "postLogin, unknown login result = " + bVar);
                break;
        }
        finish();
    }
}
