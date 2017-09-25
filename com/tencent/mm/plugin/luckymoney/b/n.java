package com.tencent.mm.plugin.luckymoney.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.ah.a.a.c.a;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.ai;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.luckymoney.ui.SelectLuckyMoneyContactUI;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.afb;
import com.tencent.mm.protocal.c.ame;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.k;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONObject;

public final class n {
    private static f<String, Bitmap> lGm = new f(10);
    public static int nnb = Integer.MAX_VALUE;

    public static String h(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis > 0 && timeInMillis <= 86400000) {
            return new SimpleDateFormat("HH:mm:ss").format(new Date(j));
        }
        Time time = new Time();
        time.set(j);
        return com.tencent.mm.pluginsdk.j.n.a(context.getString(R.l.elq, new Object[]{" "}), time).toString();
    }

    public static void a(ImageView imageView, String str, boolean z) {
        a(imageView, str, null, true);
    }

    public static void a(ImageView imageView, String str, String str2, boolean z) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bg.mA(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aHG();
                aVar.hIO = com.tencent.mm.plugin.luckymoney.a.a.aHI();
                aVar.hIL = true;
                aVar.hJh = true;
                aVar.hJi = z;
                if (z) {
                    aVar.hJj = 0.0f;
                }
                if (bg.mA(str2)) {
                    aVar.hIT = false;
                } else {
                    aVar.fFW = str2;
                    aVar.hIT = true;
                }
                com.tencent.mm.ah.n.GW().a(str, imageView, aVar.Hg());
            }
        }
    }

    public static void f(ImageView imageView, String str) {
        a(imageView, str, null, false);
    }

    public static void d(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bg.mA(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aHG();
                aVar.hIO = com.tencent.mm.plugin.luckymoney.a.a.aHI();
                aVar.hIL = true;
                aVar.hJh = true;
                aVar.hJi = false;
                if (i != 0) {
                    aVar.hJa = i;
                }
                com.tencent.mm.ah.n.GW().a(str, imageView, aVar.Hg());
            }
        }
    }

    public static void a(ImageView imageView, String str, String str2) {
        if (imageView != null) {
            if (bg.mA(str2)) {
                str2 = com.tencent.mm.x.n.Bz().hi(str);
            }
            b.a(imageView, str2, 0.1f, false);
        }
    }

    public static void e(ImageView imageView, String str, int i) {
        if (imageView != null) {
            imageView.setImageBitmap(null);
            if (!bg.mA(str)) {
                a aVar = new a();
                com.tencent.mm.plugin.luckymoney.a.a.aHG();
                aVar.hIO = com.tencent.mm.plugin.luckymoney.a.a.aHI();
                aVar.hIL = true;
                aVar.hJh = true;
                aVar.hJi = true;
                aVar.hIQ = 1;
                if (i != 0) {
                    aVar.hJa = i;
                }
                com.tencent.mm.ah.n.GW().a(str, imageView, aVar.Hg());
            }
        }
    }

    public static void a(Context context, TextView textView, String str) {
        if (textView != null) {
            textView.setText(h.b(context, str, textView.getTextSize()));
        }
    }

    public static void a(MMActivity mMActivity, int i, int i2, boolean z) {
        if (i != 0 || i2 <= 1) {
            a(mMActivity, 2, z);
            return;
        }
        Intent intent = new Intent();
        intent.setClass(mMActivity, SelectLuckyMoneyContactUI.class);
        intent.putExtra("key_friends_num", i2);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        mMActivity.startActivityForResult(intent, 2);
    }

    public static void a(MMActivity mMActivity, int i, boolean z) {
        Intent intent = new Intent();
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Select_Conv_Type", 3);
        if (z) {
            intent.putExtra("scene_from", 5);
        }
        d.a(mMActivity, ".ui.transmit.SelectConversationUI", intent, i);
    }

    public static String aHX() {
        ap.yY();
        return (String) c.vr().get(w.a.uAi, null);
    }

    public static String zL(String str) {
        com.tencent.mm.x.h hs = com.tencent.mm.x.n.Bm().hs(str);
        if (hs != null) {
            return hs.Bt();
        }
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc == null || !Rc.field_username.equals(str) || Rc.gkq == 4) {
            return null;
        }
        ap.yY();
        byte[] Rg = c.wR().Rg(str);
        if (bg.bm(Rg)) {
            return null;
        }
        String str2;
        try {
            str2 = ((ame) new ame().aD(Rg)).tqc;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "exception:%s", new Object[]{bg.g(e)});
            str2 = null;
        }
        return str2;
    }

    public static String eJ(String str) {
        ap.yY();
        af Rc = c.wR().Rc(str);
        if (Rc == null || !Rc.field_username.equals(str)) {
            return null;
        }
        return Rc.field_nickname;
    }

    public static int cw(Context context) {
        if (nnb == Integer.MAX_VALUE) {
            nnb = context.getResources().getColor(R.e.aUF);
        }
        return nnb;
    }

    public static void a(final View view, AnimationListener animationListener) {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.96f, 0.0f, 0.96f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setFillAfter(true);
        final ScaleAnimation scaleAnimation2 = new ScaleAnimation(0.96f, 1.0f, 0.96f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                view.startAnimation(scaleAnimation2);
            }
        });
        if (animationListener != null) {
            scaleAnimation2.setAnimationListener(animationListener);
        }
        if (view != null) {
            view.startAnimation(scaleAnimation);
        }
    }

    public static void a(Button button) {
        b(button);
    }

    public static void b(Button button) {
        if (button != null) {
            button.setBackgroundResource(R.g.bfe);
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.start();
            }
        }
    }

    public static void c(Button button) {
        if (button != null && (button.getBackground() instanceof AnimationDrawable)) {
            AnimationDrawable animationDrawable = (AnimationDrawable) button.getBackground();
            if (animationDrawable != null) {
                animationDrawable.stop();
            }
        }
    }

    public static boolean z(String str, String str2, int i) {
        if (bg.mA(str) || bg.mA(str2)) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.LuckyMoneyUtil", bg.mz(str) + ", " + bg.mz(str2));
            return false;
        }
        ce auVar = new au();
        auVar.setContent(str);
        auVar.dv(2);
        auVar.cH(str2);
        auVar.z(ay.gk(str2));
        auVar.dw(1);
        if (i == 3) {
            auVar.setType(469762097);
        } else {
            auVar.setType(436207665);
        }
        ap.yY();
        long L = c.wT().L(auVar);
        if (L < 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", g.sd() + "insert msg failed :" + L);
            return false;
        }
        if (auVar.axO()) {
            com.tencent.mm.modelstat.b.hUp.a(auVar, com.tencent.mm.t.g.g(auVar));
        } else {
            com.tencent.mm.modelstat.b.hUp.f(auVar);
        }
        auVar.x(L);
        com.tencent.mm.sdk.e.c fVar = new com.tencent.mm.t.f();
        fVar.field_xml = auVar.field_content;
        String PX = bg.PX(str);
        com.tencent.mm.t.f.a aVar = null;
        if (PX != null) {
            aVar = com.tencent.mm.t.f.a.B(PX, auVar.field_reserved);
            if (aVar != null) {
                fVar.field_title = aVar.title;
                fVar.field_description = aVar.description;
            }
        }
        fVar.field_type = MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN;
        fVar.field_msgId = L;
        if (aVar != null && aVar.type == MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN && aVar.showType == 1) {
            if (TextUtils.isEmpty(aVar.hiZ) || TextUtils.isEmpty(aVar.hja) || aVar.hjb <= 0) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! don't send predownload image event, because image preload data is illegal!");
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "ljd:sendLocalMsg() this is new year msg! send predownload image event!");
                com.tencent.mm.sdk.b.b aiVar = new ai();
                aiVar.fDF = new ai.a();
                aiVar.fDF.fDH = aVar.hja;
                aiVar.fDF.fDG = aVar.hiZ;
                aiVar.fDF.fDI = aVar.hjb;
                com.tencent.mm.sdk.b.a.urY.m(aiVar);
            }
        }
        com.tencent.mm.t.f ec = an.bDk().ec(L);
        if (ec != null && ec.field_msgId == L) {
            return an.bDk().c(fVar, new String[0]);
        }
        boolean b = an.bDk().b(fVar);
        if (b) {
            return b;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "SubCorePluginBase.getAppMsgStg().insert msg failed id:" + L);
        return b;
    }

    public static boolean a(Activity activity, int i, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, com.tencent.mm.wallet_core.b.a aVar, int i2) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr call");
        if (i == 416) {
            return a(activity, kVar, bundle, z, onClickListener, i2);
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "don't need realname verify");
        return false;
    }

    private static boolean a(Activity activity, k kVar, Bundle bundle, boolean z, OnClickListener onClickListener, int i) {
        JSONObject jSONObject;
        String str;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        String str6 = "";
        if (kVar != null && (kVar instanceof p)) {
            com.tencent.mm.y.b bVar = ((p) kVar).gUA;
            if (bVar != null) {
                afb com_tencent_mm_protocal_c_afb = (afb) bVar.hsk.hsr;
                if (com_tencent_mm_protocal_c_afb.tKn != null) {
                    try {
                        jSONObject = new JSONObject(com.tencent.mm.platformtools.n.b(com_tencent_mm_protocal_c_afb.tKn));
                    } catch (Throwable e) {
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.LuckyMoneyUtil", e, "", new Object[0]);
                    }
                    if (jSONObject == null) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
                        if (jSONObject.has("real_name_info")) {
                            jSONObject = jSONObject.optJSONObject("real_name_info");
                        }
                        str2 = jSONObject.optString("guide_flag", "");
                        str3 = jSONObject.optString("guide_wording");
                        str4 = jSONObject.optString("left_button_wording", activity.getString(R.l.cancel));
                        str5 = jSONObject.optString("right_button_wording", activity.getString(R.l.dHT));
                        str6 = jSONObject.optString("upload_credit_url", "");
                        str = str2;
                    } else {
                        str = str2;
                    }
                    if ("1".equals(str)) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
                    } else if ("2".equals(str) || bg.mA(str6)) {
                        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bg.mA(str6));
                        return false;
                    } else {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "showUploadCreditDialog");
                        return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, str3, str6, str4, str5, z, null);
                    }
                }
            }
        }
        jSONObject = null;
        if (jSONObject == null) {
            str = str2;
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "dealWithRealNameVerifyErr json is not null");
            if (jSONObject.has("real_name_info")) {
                jSONObject = jSONObject.optJSONObject("real_name_info");
            }
            str2 = jSONObject.optString("guide_flag", "");
            str3 = jSONObject.optString("guide_wording");
            str4 = jSONObject.optString("left_button_wording", activity.getString(R.l.cancel));
            str5 = jSONObject.optString("right_button_wording", activity.getString(R.l.dHT));
            str6 = jSONObject.optString("upload_credit_url", "");
            str = str2;
        }
        if ("1".equals(str)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.LuckyMoneyUtil", "showRealnameDialog");
            return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(activity, bundle, i);
        }
        if ("2".equals(str)) {
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "guide_flag=" + str + ";upload_credit_url=null?" + bg.mA(str6));
        return false;
    }

    public static String zM(String str) {
        if (bg.mA(str) || !ap.zb()) {
            return "";
        }
        r2 = new Object[2];
        ap.yY();
        r2[0] = c.xv();
        r2[1] = "LuckyMoney";
        File file = new File(String.format("%s/%s/", r2));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return new File(file, str).getAbsolutePath();
    }

    public static Bitmap aa(String str, boolean z) {
        Bitmap bitmap;
        int i = 960;
        boolean z2 = true;
        if (z) {
            bitmap = (Bitmap) lGm.get(str);
            if (bitmap != null) {
                return bitmap;
            }
        }
        if (com.tencent.mm.compatible.util.f.rZ()) {
            int i2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap != null) {
                bitmap.recycle();
            }
            boolean z3 = com.tencent.mm.sdk.platformtools.d.bh(options.outWidth, options.outHeight) && options.outWidth > 480;
            boolean z4;
            if (!com.tencent.mm.sdk.platformtools.d.bg(options.outWidth, options.outHeight) || options.outHeight <= 480) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (z3 || r4) {
                i2 = options.outHeight;
                i = options.outWidth;
                while (i * i2 > 2764800) {
                    i >>= 1;
                    i2 >>= 1;
                }
                i = Math.max(1, i);
                i2 = Math.max(1, i2);
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.LuckyMoneyUtil", "fit long picture, beg %d*%d, after %d*%d", new Object[]{Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight), Integer.valueOf(i), Integer.valueOf(i2)});
            } else {
                i2 = 960;
            }
            int Pc = ExifHelper.Pc(str);
            if (Pc == 90 || Pc == 270) {
                int i3 = i;
                i = i2;
                i2 = i3;
            }
            if (MMNativeJpeg.IsJpegFile(str) && MMNativeJpeg.isProgressive(str)) {
                bitmap = MMNativeJpeg.decodeAsBitmap(str);
                String str2 = "MicroMsg.LuckyMoneyUtil";
                String str3 = "Progressive jpeg, result isNull:%b";
                Object[] objArr = new Object[1];
                if (bitmap != null) {
                    z2 = false;
                }
                objArr[0] = Boolean.valueOf(z2);
                com.tencent.mm.sdk.platformtools.w.i(str2, str3, objArr);
            } else {
                bitmap = com.tencent.mm.sdk.platformtools.d.d(str, i2, i, false);
            }
            if (bitmap == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "getSuitableBmp fail, temBmp is null, filePath = " + str);
                return null;
            }
            bitmap = com.tencent.mm.sdk.platformtools.d.b(bitmap, (float) Pc);
            if (!z) {
                return bitmap;
            }
            lGm.put(str, bitmap);
            return bitmap;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "sdcard is not avail!");
        return BitmapFactory.decodeResource(ab.getContext().getResources(), R.g.bhP);
    }

    public static String aO(List<ag> list) {
        if (list == null || list.size() == 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.LuckyMoneyUtil", "splitOperationField is empty!");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            ag agVar = (ag) list.get(i);
            if (agVar != null) {
                if (i != 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(agVar.type);
                stringBuilder.append("|");
                stringBuilder.append(agVar.name);
            }
        }
        return stringBuilder.toString();
    }

    public static void cJ(String str, String str2) {
        if (!bg.mA(str) && !bg.mA(str2)) {
            au auVar = new au();
            auVar.dw(0);
            auVar.cH(str2);
            auVar.dv(3);
            auVar.setContent(str);
            auVar.z(ay.i(str2, System.currentTimeMillis() / 1000));
            auVar.setType(10000);
            ap.yY();
            c.wT().L(auVar);
        }
    }
}
