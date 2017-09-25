package com.tencent.mm.plugin.wenote.b;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class a {
    public static ArrayList<String> Lt(String str) {
        if (bg.mA(str) || str.length() == 0) {
            return null;
        }
        String[] split = Kn(Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#")).split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList();
        for (Object add : split) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static ArrayList<String> Lu(String str) {
        if (bg.mA(str) || str.length() == 0) {
            return null;
        }
        String[] split = Pattern.compile("\n", 2).matcher(Pattern.compile("<[/]?div>", 2).matcher(Pattern.compile("</object>", 2).matcher(Pattern.compile("<object[^>]*>", 2).matcher(str).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#")).replaceAll("")).replaceAll("")).replaceAll("").replaceAll("<br>", "<br/>").trim().split("#WNNoteNode#");
        ArrayList<String> arrayList = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static String Kn(String str) {
        if (bg.mA(str) || str.length() == 0) {
            return str;
        }
        return Pattern.compile("&nbsp;", 2).matcher(Pattern.compile("<[^>]*>", 2).matcher(Pattern.compile("</p>", 2).matcher(Pattern.compile("<p [^>]*>", 2).matcher(Pattern.compile("<div>", 2).matcher(Pattern.compile("<br[^>]*>", 2).matcher(str).replaceAll("\n")).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll("")).replaceAll(" ");
    }
}
