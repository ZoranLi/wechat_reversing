package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ClickableSpan;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class h {
    static LinkedList<e> sTx = new LinkedList();
    private static boolean sTy = bg.Hp();

    public static void a(e eVar) {
        sTx.add(eVar);
    }

    public static void b(e eVar) {
        sTx.remove(eVar);
    }

    public static SpannableString a(TextView textView, Object obj) {
        return a(textView, 1, true, obj);
    }

    public static SpannableString a(TextView textView, int i, boolean z, Object obj) {
        if (textView == null) {
            w.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        n nVar = new n(textView.getContext());
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUk = true;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        n j = nVar.j(textView);
        j.sUh = true;
        j.sUj = true;
        if (obj != null) {
            j.sUr = obj;
        }
        return j.a(textView.getText(), textSize, z);
    }

    public static SpannableString d(TextView textView, int i) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), true, i);
        }
        w.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }

    public static SpannableString b(TextView textView, Object obj) {
        if (textView == null) {
            w.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
            return new SpannableString("");
        }
        int textSize = (int) textView.getTextSize();
        n nVar = new n(textView.getContext());
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        n j = nVar.j(textView);
        j.sUr = obj;
        j.iCS = null;
        j.sUh = true;
        j.sUj = true;
        return j.a(textView.getText(), textSize, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj, String str) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        nVar = nVar.j(null);
        nVar.sUr = obj;
        nVar.iCS = str;
        nVar.sUh = true;
        nVar.sUj = true;
        return nVar.a(charSequence, i, true);
    }

    private static SpannableString a(Context context, TextView textView, int i, boolean z, int i2) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUo = i2;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        nVar = nVar.j(textView);
        if (i2 == 1) {
            nVar.sUh = true;
            nVar.sUj = true;
        } else if (i2 == 2) {
            nVar.sUh = false;
            nVar.sUj = false;
        }
        return nVar.a(textView.getText(), i, z);
    }

    public static SpannableString c(Context context, CharSequence charSequence, int i) {
        return e(context, charSequence, i);
    }

    public static SpannableString b(Context context, CharSequence charSequence, float f) {
        return e(context, charSequence, (int) f);
    }

    public static SpannableString d(Context context, CharSequence charSequence, int i) {
        n nVar = new n(context);
        nVar.sUg = false;
        nVar.sUh = false;
        nVar.sUd = false;
        nVar.sUi = false;
        nVar.sUo = i;
        nVar.sUf = false;
        nVar.sUq = false;
        CharSequence a = nVar.a(charSequence, 0, true);
        c(a);
        return a;
    }

    private static void c(Spannable spannable) {
        int i = 0;
        ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(0, spannable.length(), ClickableSpan.class);
        while (i < clickableSpanArr.length) {
            spannable.removeSpan(clickableSpanArr[i]);
            i++;
        }
    }

    public static SpannableString a(Context context, CharSequence charSequence) {
        return e(context, charSequence, 0);
    }

    private static SpannableString e(Context context, CharSequence charSequence, int i) {
        n nVar = new n(context);
        nVar.sUg = false;
        nVar.sUh = false;
        nVar.sUd = false;
        nVar.sUi = false;
        nVar.sUf = false;
        nVar.sUq = false;
        CharSequence a = nVar.a(charSequence, i, true);
        c(a);
        return a;
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, int i2) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUo = i2;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        if (i2 == 1) {
            nVar.sUh = true;
            nVar.sUj = true;
        } else if (i2 == 2) {
            nVar.sUh = false;
            nVar.sUj = false;
        }
        return nVar.a(charSequence, i, true);
    }

    public static SpannableString f(Context context, CharSequence charSequence, int i) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        nVar.sUr = null;
        nVar.sUh = true;
        nVar.sUj = true;
        return nVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, String str, Object obj) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        nVar.sUr = obj;
        nVar.iCS = str;
        nVar.sUh = true;
        nVar.sUj = true;
        return nVar.a(charSequence, i, true);
    }

    public static SpannableString a(Context context, CharSequence charSequence, int i, Object obj) {
        n nVar = new n(context);
        nVar.sUf = true;
        nVar.sUd = true;
        nVar.sUe = sTy;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = true;
        nVar.sUi = false;
        nVar.sUq = true;
        nVar.sUr = obj;
        nVar.sUh = true;
        nVar.sUj = true;
        return nVar.a(charSequence, i, false);
    }

    public static SpannableString g(Context context, CharSequence charSequence, int i) {
        return a(context, charSequence, i, true);
    }

    public static SpannableString c(Context context, CharSequence charSequence, float f) {
        return a(context, charSequence, (int) f, false);
    }

    private static SpannableString a(Context context, CharSequence charSequence, int i, boolean z) {
        n nVar = new n(context);
        nVar.sUf = false;
        nVar.sUd = true;
        nVar.sUk = true;
        nVar.sUl = z;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = false;
        nVar.sUi = false;
        nVar.sUh = false;
        nVar.sUj = false;
        nVar.sUq = false;
        return nVar.a(charSequence, i, true);
    }

    public static String Ng(String str) {
        if (bg.mA(str)) {
            return str;
        }
        n nVar = new n(ab.getContext());
        nVar.sUf = false;
        nVar.sUd = true;
        nVar.sUk = true;
        nVar.sUl = true;
        nVar.sUm = true;
        nVar.sUo = 1;
        nVar.sUg = false;
        nVar.sUi = false;
        nVar.sUh = false;
        nVar.sUj = false;
        nVar.sUn = false;
        nVar.sUq = false;
        return nVar.a(str, 0, false).toString();
    }

    public static void clearCache() {
        w.i("MicroMsg.MMSpanManager", "clear MMSpanManager cache");
        n.clearCache();
    }

    public static SpannableString i(TextView textView) {
        if (textView != null) {
            return a(textView.getContext(), textView, (int) textView.getTextSize(), false, 1);
        }
        w.e("MicroMsg.MMSpanManager", "spanForTextView, textView cannot be null!");
        return new SpannableString("");
    }
}
