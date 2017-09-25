package com.tencent.mm.plugin.wenote.model.nativenote.a;

import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public final class b {
    public static String a(Spanned spanned) {
        if (spanned == null || bg.mA(spanned.toString())) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        a(spanned, stringBuilder);
        return stringBuilder.toString();
    }

    private static void a(final Spanned spanned, StringBuilder stringBuilder) {
        ArrayList arrayList = new j(spanned).swo;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            c cVar = (c) arrayList.get(i);
            int i2 = cVar.abH;
            int i3 = cVar.wd;
            SortedSet treeSet = new TreeSet(new Comparator<CharacterStyle>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    CharacterStyle characterStyle = (CharacterStyle) obj;
                    CharacterStyle characterStyle2 = (CharacterStyle) obj2;
                    int spanStart = spanned.getSpanStart(characterStyle);
                    int spanStart2 = spanned.getSpanStart(characterStyle2);
                    if (spanStart != spanStart2) {
                        return spanStart - spanStart2;
                    }
                    spanStart = spanned.getSpanEnd(characterStyle);
                    spanStart2 = spanned.getSpanEnd(characterStyle2);
                    return spanStart != spanStart2 ? spanStart2 - spanStart : characterStyle.getClass().getName().compareTo(characterStyle2.getClass().getName());
                }
            });
            treeSet.addAll(Arrays.asList(spanned.getSpans(i2, i3, CharacterStyle.class)));
            a(spanned, stringBuilder, i2, i3, treeSet);
        }
    }

    private static void a(Spanned spanned, StringBuilder stringBuilder, int i, int i2, SortedSet<CharacterStyle> sortedSet) {
        int i3 = i;
        while (i3 < i2) {
            CharacterStyle characterStyle = sortedSet.isEmpty() ? null : (CharacterStyle) sortedSet.first();
            int spanStart = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanStart(characterStyle);
            int spanEnd = characterStyle == null ? Integer.MAX_VALUE : spanned.getSpanEnd(characterStyle);
            if (i3 < spanStart) {
                int min = Math.min(i2, spanStart);
                int i4 = i3;
                while (i4 < min) {
                    char charAt = spanned.charAt(i4);
                    if (charAt == '\n') {
                        stringBuilder.append("<br/>");
                    } else if (charAt == '<') {
                        stringBuilder.append("&lt;");
                    } else if (charAt == '>') {
                        stringBuilder.append("&gt;");
                    } else if (charAt == '&') {
                        stringBuilder.append("&amp;");
                    } else if (charAt == ' ') {
                        while (i4 + 1 < min && spanned.charAt(i4 + 1) == ' ') {
                            stringBuilder.append("&nbsp;");
                            i4++;
                        }
                        stringBuilder.append(' ');
                    } else if (charAt < ' ') {
                        stringBuilder.append("&#" + charAt + ";");
                    } else {
                        stringBuilder.append(charAt);
                    }
                    i4++;
                }
                i3 = spanStart;
            } else {
                sortedSet.remove(characterStyle);
                a(characterStyle, stringBuilder);
                a(spanned, stringBuilder, Math.max(spanStart, i3), Math.min(spanEnd, i2), sortedSet);
                if (characterStyle instanceof ForegroundColorSpan) {
                    stringBuilder.append("</font>");
                } else if (characterStyle instanceof BackgroundColorSpan) {
                    stringBuilder.append("</font>");
                } else if (characterStyle instanceof AbsoluteSizeSpan) {
                    stringBuilder.append("</font>");
                } else if (characterStyle instanceof StyleSpan) {
                    if (((StyleSpan) characterStyle).getStyle() == 1) {
                        stringBuilder.append("</b>");
                    } else if (((StyleSpan) characterStyle).getStyle() == 2) {
                        stringBuilder.append("</i>");
                    }
                } else if (characterStyle instanceof UnderlineSpan) {
                    stringBuilder.append("</u>");
                }
                i3 = spanEnd;
            }
        }
    }

    private static boolean a(CharacterStyle characterStyle, StringBuilder stringBuilder) {
        if (characterStyle instanceof AbsoluteSizeSpan) {
            stringBuilder.append("<font style=\"font-size:");
            stringBuilder.append(com.tencent.mm.plugin.wenote.model.nativenote.manager.b.wR(((AbsoluteSizeSpan) characterStyle).getSize()));
            stringBuilder.append("px\">");
        } else if (characterStyle instanceof ForegroundColorSpan) {
            stringBuilder.append("<font style=\"color:#");
            r0 = Integer.toHexString(((ForegroundColorSpan) characterStyle).getForegroundColor() + 16777216);
            while (r0.length() < 6) {
                r0 = "0" + r0;
            }
            stringBuilder.append(r0);
            stringBuilder.append("\">");
        } else if (characterStyle instanceof BackgroundColorSpan) {
            stringBuilder.append("<font style=\"background-color:#");
            r0 = Integer.toHexString(((BackgroundColorSpan) characterStyle).getBackgroundColor() + 16777216);
            while (r0.length() < 6) {
                r0 = "0" + r0;
            }
            stringBuilder.append(r0);
            stringBuilder.append("\">");
        } else if (characterStyle instanceof StyleSpan) {
            if (((StyleSpan) characterStyle).getStyle() == 1) {
                stringBuilder.append("<b>");
            } else if (((StyleSpan) characterStyle).getStyle() == 2) {
                stringBuilder.append("<i>");
            }
        } else if (characterStyle instanceof UnderlineSpan) {
            stringBuilder.append("<u>");
        }
        return true;
    }
}
