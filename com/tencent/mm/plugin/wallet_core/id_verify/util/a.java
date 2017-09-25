package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class a implements e {
    public int hPi = -1;
    private a rDs = null;
    public WeakReference<MMActivity> rDt;
    public WeakReference<b> rDu;
    private boolean rDv = false;
    public h rDw;

    public interface a {
        boolean a(int i, int i2, String str, boolean z);
    }

    public final boolean a(MMActivity mMActivity, int i, b bVar, a aVar, boolean z, int i2, boolean z2) {
        this.rDv = false;
        ap.yY();
        long longValue = ((Long) c.vr().get(com.tencent.mm.storage.w.a.uDK, Long.valueOf(0))).longValue();
        if (longValue > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.ui.e.a(5, bg.Ny(), i2);
            if (currentTimeMillis < longValue) {
                w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query is not expired. expiredTime = " + longValue);
                return false;
            }
            w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimer query had expired. expiredTime = " + longValue);
        }
        if (mMActivity == null) {
            w.e("MicroMsg.RealnameVerifyUtil", "context is null");
            return false;
        } else if (bVar == null) {
            w.e("MicroMsg.RealnameVerifyUtil", "netmgr is null");
            return false;
        } else {
            this.rDt = new WeakReference(mMActivity);
            this.rDu = new WeakReference(bVar);
            this.hPi = i;
            this.rDs = aVar;
            if (i < 0 || aVar == null) {
                w.e("MicroMsg.RealnameVerifyUtil", "scene = " + i + ";callback is null?" + (aVar == null));
                this.rDs = null;
                return false;
            }
            com.tencent.mm.wallet_core.ui.e.a(4, bg.Ny(), i2);
            ap.vd().a(385, this);
            bVar.a(new com.tencent.mm.plugin.wallet_core.id_verify.model.e(i, i2), z2);
            return true;
        }
    }

    private void aHV() {
        if (this.rDu != null && this.rDu.get() != null) {
            ((b) this.rDu.get()).aHV();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            ap.vd().b(385, this);
            aHV();
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.wallet_core.id_verify.model.e eVar = (com.tencent.mm.plugin.wallet_core.id_verify.model.e) kVar;
                boolean equals = eVar.rDe.equals("1");
                if (equals) {
                    w.i("MicroMsg.RealnameVerifyUtil", "user had agreed");
                    b(0, i2, str, equals);
                    return;
                }
                b((MMActivity) this.rDt.get(), (b) this.rDu.get(), eVar.title, eVar.rDf, eVar.rDg, eVar.rDh, this.rDs, false, eVar.rDi);
                return;
            }
            b(2, i2, str, false);
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.a) {
            ap.vd().a(385, this);
            aHV();
            if (i == 0 && i2 == 0) {
                b(0, i2, str, true);
            } else {
                b(3, i2, str, false);
            }
        }
    }

    public static void a(MMActivity mMActivity, b bVar, String str, String str2, String str3, String str4, a aVar, boolean z, int i) {
        new a().b(mMActivity, bVar, str, str2, str3, str4, aVar, z, i);
    }

    private void b(final MMActivity mMActivity, b bVar, String str, String str2, final String str3, String str4, a aVar, boolean z, int i) {
        this.rDt = new WeakReference(mMActivity);
        this.rDu = new WeakReference(bVar);
        this.rDv = z;
        if (this.rDt != null && this.rDt.get() != null) {
            this.rDs = aVar;
            CharSequence charSequence = str + str2;
            f fVar = new f(mMActivity);
            final int i2 = i;
            fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
                final /* synthetic */ a rDz;

                public final void onClick(View view) {
                    com.tencent.mm.wallet_core.ui.e.a(3, bg.Ny(), i2);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str3);
                    intent.putExtra("showShare", false);
                    d.b(mMActivity, "webview", ".ui.tools.WebViewUI", intent);
                }
            };
            charSequence = com.tencent.mm.pluginsdk.ui.d.h.a(mMActivity, charSequence);
            CharSequence spannableString = new SpannableString(charSequence);
            spannableString.setSpan(fVar, charSequence.length() - str2.length(), charSequence.length(), 33);
            View textView = new TextView(mMActivity);
            textView.setText(spannableString);
            textView.setTextSize(0, (float) com.tencent.mm.bg.a.T(mMActivity, R.f.aXs));
            textView.setTextColor(mMActivity.getResources().getColorStateList(R.e.aVo));
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            com.tencent.mm.wallet_core.ui.e.a(0, bg.Ny(), i);
            String string = mMActivity.getString(R.l.cancel);
            i2 = i;
            OnClickListener anonymousClass3 = new OnClickListener(this) {
                final /* synthetic */ a rDz;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.a(2, bg.Ny(), i2);
                    if (this.rDz.rDu != null && this.rDz.rDu.get() != null) {
                        ap.vd().a(385, this.rDz);
                        ((b) this.rDz.rDu.get()).a(new com.tencent.mm.plugin.wallet_core.id_verify.model.a(this.rDz.hPi), true);
                    }
                }
            };
            i2 = i;
            this.rDw = g.a(mMActivity, "", textView, str4, string, anonymousClass3, new OnClickListener(this) {
                final /* synthetic */ a rDz;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.wallet_core.ui.e.a(1, bg.Ny(), i2);
                    this.rDz.b(1, -1, "cancel", false);
                }
            });
        }
    }

    public final void b(int i, int i2, String str, boolean z) {
        w.i("MicroMsg.RealnameVerifyUtil", "doGetDisclaimerCallback call");
        if (this.rDs != null) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uDL, Integer.valueOf(z ? 0 : 1));
            this.rDs.a(i, i2, str, z);
            if (this.rDw != null) {
                this.rDw.dismiss();
            }
            this.rDv = false;
            if (this.rDw != null) {
                w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : close mDisclaimerDialog");
                this.rDw = null;
            }
            if (this.rDu != null) {
                w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mNetSceneMgr");
                this.rDu.clear();
                this.rDu = null;
            }
            if (this.rDt != null) {
                w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear mContextReference");
                this.rDt.clear();
                this.rDt = null;
            }
            w.i("MicroMsg.RealnameVerifyUtil", "getDisclaimerCallback : clear getDisclaimerCallback");
            this.rDs = null;
        }
    }

    private static JSONObject o(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.f.a.h)) {
            com.tencent.mm.y.b bVar = ((com.tencent.mm.wallet_core.f.a.h) kVar).gUA;
            if (bVar != null) {
                bez com_tencent_mm_protocal_c_bez = (bez) bVar.hsk.hsr;
                if (com_tencent_mm_protocal_c_bez.tKn != null) {
                    try {
                        return new JSONObject(n.b(com_tencent_mm_protocal_c_bez.tKn));
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.RealnameVerifyUtil", e, "", new Object[0]);
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, int i2) {
        if (i != 416) {
            w.i("MicroMsg.RealnameVerifyUtil", "don't need realname verify");
            return false;
        }
        w.i("MicroMsg.RealnameVerifyUtil", "need realname verify");
        return a(activity, kVar, bundle, false, null, i2, 2);
    }

    public static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i, int i2) {
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        JSONObject o = o(kVar);
        if (o != null) {
            if (o.has("real_name_info")) {
                o = o.optJSONObject("real_name_info");
            }
            str2 = o.optString("guide_flag", "0");
            str3 = o.optString("guide_wording");
            str4 = o.optString("left_button_wording", activity.getString(R.l.cancel));
            str5 = o.optString("right_button_wording", activity.getString(R.l.dHT));
            str6 = o.optString("upload_credit_url", "");
            str = str2;
        } else {
            str = str2;
        }
        w.i("MicroMsg.RealnameVerifyUtil", "guide_flag = " + str + ";upload_credit_url=" + str6);
        if ("1".equals(str)) {
            w.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog");
            return a(activity, bundle, i);
        } else if (!"2".equals(str) || bg.mA(str6)) {
            w.e("MicroMsg.RealnameVerifyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bg.mA(str6));
            return false;
        } else {
            w.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog");
            return a(activity, str3, str6, str4, str5, z, null);
        }
    }

    public static boolean a(Activity activity, Bundle bundle, int i) {
        w.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog call %d", new Object[]{Integer.valueOf(0)});
        w.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog click OK");
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("real_name_verify_mode", 0);
        bundle.putInt("entry_scene", i);
        com.tencent.mm.wallet_core.a.a(activity, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle);
        com.tencent.mm.wallet_core.ui.e.a(19, bg.Ny(), i);
        return true;
    }

    public static boolean a(final Activity activity, String str, final String str2, String str3, String str4, final boolean z, OnClickListener onClickListener) {
        String string;
        String string2;
        OnClickListener anonymousClass5;
        if (bg.mA(str3)) {
            string = activity.getString(R.l.dGs);
        } else {
            string = str3;
        }
        if (bg.mA(str4)) {
            string2 = activity.getString(R.l.dHT);
        } else {
            string2 = str4;
        }
        if (onClickListener == null) {
            w.i("MicroMsg.RealnameVerifyUtil", "showRealnameDialog use default calcel listener");
            anonymousClass5 = new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click cancel");
                    dialogInterface.dismiss();
                    if (z) {
                        activity.finish();
                    }
                }
            };
        } else {
            anonymousClass5 = onClickListener;
        }
        h a = g.a(activity, str, "", string2, string, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                w.i("MicroMsg.RealnameVerifyUtil", "showUploadCreditDialog click OK");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                intent.putExtra("showShare", false);
                d.b(activity, "webview", ".ui.tools.WebViewUI", intent);
                dialogInterface.dismiss();
                if (z) {
                    activity.finish();
                }
            }
        }, anonymousClass5, R.e.aWu);
        if (a != null) {
            a.setOnCancelListener(new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
            a.setOnDismissListener(new OnDismissListener() {
                public final void onDismiss(DialogInterface dialogInterface) {
                    if (z) {
                        activity.finish();
                    }
                }
            });
        }
        return true;
    }
}
