package com.tencent.mm.ui.chatting;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class bl {
    private static final LayoutParams vDA = new LayoutParams(-1, -2);

    private static class a implements Comparable<a> {
        public int color;
        public boolean fWb;
        public int offset;
        public int vDB;
        public boolean vDC;
        public String vDD;

        private a() {
        }

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            if (aVar != null) {
                return this.offset - aVar.offset;
            }
            w.e("MicroMsg.LineNode", "compareTo fail, should not be null");
            return 1;
        }

        public static a r(Map<String, String> map, String str) {
            a aVar = new a();
            try {
                aVar.offset = bg.getInt((String) map.get(str + ".offset"), 0);
                String str2 = (String) map.get(str + ".font");
                if (bg.mA(str2)) {
                    w.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    str2 = "m";
                } else {
                    str2 = str2.toLowerCase();
                }
                aVar.fWb = bl.Ts(str2);
                aVar.vDC = bl.Tt(str2);
                aVar.vDB = bl.Tr(str2);
                aVar.color = bl.Tu((String) map.get(str + ".color"));
                aVar.vDD = (String) map.get(str + ".chars");
                if (!bg.mA(aVar.vDD)) {
                    return aVar;
                }
                w.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                return null;
            } catch (Exception e) {
                w.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e.getMessage());
                return null;
            }
        }
    }

    private static class b {
        public int color;
        public boolean fWb;
        public int vDB;
        public boolean vDC;
        public int vDE;
        public int vDF;

        private b() {
        }

        public static b s(Map<String, String> map, String str) {
            String str2 = (String) map.get(str + ".range");
            if (bg.mA(str2)) {
                w.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
                return null;
            } else if (str2.length() >= 5 && str2.charAt(0) == '{' && str2.charAt(str2.length() - 1) == '}' && str2.contains(",")) {
                w.d("MicroMsg.StyleNode", "parseFrom, range = " + str2);
                String[] split = str2.substring(1, str2.length() - 1).split(",");
                if (split == null || split.length != 2) {
                    w.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.vDE = Integer.parseInt(split[0]);
                    bVar.vDF = Integer.parseInt(split[1]) + bVar.vDE;
                    str2 = (String) map.get(str + ".font");
                    if (bg.mA(str2)) {
                        w.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                        str2 = "m";
                    } else {
                        str2 = str2.toLowerCase();
                    }
                    bVar.fWb = bl.Ts(str2);
                    bVar.vDC = bl.Tt(str2);
                    bVar.vDB = bl.Tr(str2);
                    bVar.color = bl.Tu((String) map.get(str + ".color"));
                    return bVar;
                } catch (Exception e) {
                    w.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e.getMessage());
                    return null;
                }
            } else {
                w.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = " + str2);
                return null;
            }
        }
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        if (linearLayout == null) {
            w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            return false;
        }
        String str = (String) map.get(".msg.appmsg.mmreader.category.item.digest");
        if (bg.mA(str)) {
            w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            return false;
        }
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(WebView.NIGHT_MODE_COLOR), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e) {
            w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", e.getMessage());
        }
        int i = 0;
        while (true) {
            String str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i == 0 ? "" : String.valueOf(i));
            if (!map.containsKey(str2)) {
                break;
            }
            b s = b.s(map, str2);
            if (s == null) {
                w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = " + str2);
            } else if (s.vDE >= s.vDF) {
                w.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + s.vDE + ", rangeTo = " + s.vDF);
            } else {
                int length;
                int i2 = s.vDE;
                int i3 = s.vDF;
                int i4 = s.vDB;
                boolean z = s.fWb;
                boolean z2 = s.vDC;
                w.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", fontSize = " + i4 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i2 < 0) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    length = spannableString.length();
                } else {
                    length = i3;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i2, length, 17);
                    } catch (IndexOutOfBoundsException e2) {
                        w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e2.getMessage());
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i2, length, 17);
                    } catch (IndexOutOfBoundsException e22) {
                        w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e22.getMessage());
                    }
                }
                if (i4 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i4), i2, length, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e3.getMessage());
                    }
                }
                i2 = s.vDE;
                i3 = s.vDF;
                length = s.color;
                w.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i2 + ", rangeTo = " + i3 + ", color = " + length);
                if (i2 < 0) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i2 = 0;
                }
                if (i3 > spannableString.length()) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i2), Integer.valueOf(i3));
                    i3 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(length), i2, i3, 17);
                } catch (IndexOutOfBoundsException e32) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e32.getMessage());
                }
            }
            i++;
        }
        w.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = " + i);
        i = 0;
        List arrayList = new ArrayList();
        while (true) {
            str2 = ".msg.appmsg.mmreader.category.item.styles.line" + (i == 0 ? "" : String.valueOf(i));
            if (map.containsKey(str2)) {
                a r = a.r(map, str2);
                if (r == null) {
                    w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = " + str2);
                } else {
                    arrayList.add(r);
                }
                i++;
            } else {
                w.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = " + i);
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                return true;
            }
        }
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        w.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i = 0;
        for (a aVar : list) {
            if (aVar.offset > i) {
                View textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, vDA);
            }
            View textView2 = new TextView(linearLayout.getContext());
            textView2.setText(Tq(aVar.vDD));
            textView2.setSingleLine(true);
            if (aVar.vDB != 14) {
                textView2.setTextSize((float) aVar.vDB);
            }
            if (aVar.fWb) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.vDC) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(aVar.color);
            linearLayout.addView(textView2, vDA);
            i = aVar.offset;
        }
        if (i >= length) {
            w.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i + ", maxLength = " + length);
        } else {
            View textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) com.tencent.mm.bg.a.T(textView3.getContext(), R.f.aXs));
            textView3.setText(spannableString.subSequence(i, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, vDA);
        }
        return true;
    }

    private static String Tq(String str) {
        StringBuilder stringBuilder = new StringBuilder(str);
        while (stringBuilder.length() < 80) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static int Tr(String str) {
        if (str.contains("m")) {
            return 18;
        }
        if (str.contains("l")) {
            return 21;
        }
        return 14;
    }

    public static boolean Ts(String str) {
        return str.contains("b");
    }

    public static boolean Tt(String str) {
        return str.contains("u");
    }

    public static int Tu(String str) {
        int i = WebView.NIGHT_MODE_COLOR;
        if (!bg.mA(str)) {
            try {
                i = Color.parseColor(str);
            } catch (Exception e) {
                w.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e.getMessage());
            }
        }
        return i;
    }
}
