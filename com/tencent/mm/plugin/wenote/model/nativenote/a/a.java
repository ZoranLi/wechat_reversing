package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Html;
import android.text.Spanned;
import com.tencent.mm.a.f;
import java.util.regex.Pattern;

public final class a {
    private static f<String, Spanned> svb = new f(30);

    public static Spanned Lq(String str) {
        if (str == null) {
            str = "";
        }
        if (svb.aV(str) && svb.get(str) != null) {
            return (Spanned) svb.get(str);
        }
        String replaceAll = Pattern.compile("\n", 2).matcher(Pattern.compile("<[/]?p>", 2).matcher(Pattern.compile("<[/]?div>", 2).matcher(str).replaceAll("")).replaceAll("")).replaceAll("<br/>");
        Spanned fromHtml = Html.fromHtml(replaceAll);
        if (fromHtml.toString().length() <= 400) {
            return fromHtml;
        }
        svb.put(replaceAll, fromHtml);
        return fromHtml;
    }
}
