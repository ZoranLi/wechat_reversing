package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.m.h;
import com.tencent.mm.plugin.appbrand.widget.g;
import com.tencent.mm.sdk.platformtools.bg;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void a(m mVar, ImageView imageView, JSONObject jSONObject) {
        Bitmap bitmap = null;
        if (imageView != null && jSONObject != null) {
            try {
                String string = jSONObject.getString("iconPath");
                if (!TextUtils.isEmpty(string)) {
                    if (string.startsWith("wxfile://")) {
                        AppBrandLocalMediaObject aH = c.aH(mVar.ivH, string);
                        if (!(aH == null || TextUtils.isEmpty(aH.hos))) {
                            String str = aH.hos;
                            if (!str.startsWith("file://")) {
                                str = "file://" + str;
                            }
                            bitmap = b.AY().gN(str);
                        }
                    } else if (string.startsWith("https://") || string.startsWith("http://")) {
                        bitmap = b.AY().gN(string);
                        if (bitmap == null) {
                            b.AY().a(imageView, string, null, null);
                        }
                    } else {
                        bitmap = l.g(mVar.ixr, string);
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        imageView.setImageBitmap(null);
                    } else {
                        imageView.setImageBitmap(bitmap);
                    }
                }
            } catch (JSONException e) {
            }
        }
    }

    public static void a(TextView textView, JSONObject jSONObject) {
        if (textView != null && jSONObject != null) {
            String string;
            try {
                string = jSONObject.getString("color");
                if (!bg.mA(string)) {
                    textView.setTextColor(h.qV(string));
                }
            } catch (JSONException e) {
            }
            try {
                textView.setTextSize(0, (float) h.iD(jSONObject.getInt("fontSize")));
            } catch (JSONException e2) {
            }
            try {
                string = jSONObject.getString("textAlign");
                if ("left".equals(string)) {
                    textView.setGravity(3);
                } else if ("center".equals(string)) {
                    textView.setGravity(17);
                } else if ("right".equals(string)) {
                    textView.setGravity(5);
                }
            } catch (JSONException e3) {
            }
            try {
                string = jSONObject.getString("fontWeight");
                if ("bold".equals(string)) {
                    textView.getPaint().setFakeBoldText(true);
                } else if ("normal".equals(string)) {
                    textView.getPaint().setFakeBoldText(false);
                }
            } catch (JSONException e4) {
            }
            int iD = h.iD(jSONObject.optInt("lineHeight", Math.round(textView.getTextSize() * 1.2f)));
            if (textView instanceof g) {
                g gVar = (g) textView;
                if (gVar.jrg == null) {
                    gVar.jrg = new com.tencent.mm.plugin.appbrand.widget.e.a((float) iD);
                }
                if (gVar.jrg.Q((float) iD)) {
                    gVar.invalidate();
                }
            }
            try {
                string = jSONObject.getString("lineBreak");
                if ("ellipsis".equals(string)) {
                    textView.setEllipsize(TruncateAt.END);
                    textView.setSingleLine(true);
                } else if ("clip".equals(string)) {
                    textView.setSingleLine(true);
                } else if ("break-word".equals(string)) {
                    textView.setSingleLine(false);
                } else if ("break-all".equals(string)) {
                    textView.setSingleLine(false);
                }
            } catch (JSONException e5) {
            }
            try {
                textView.setText(jSONObject.getString("content"));
            } catch (JSONException e6) {
            }
        }
    }
}
