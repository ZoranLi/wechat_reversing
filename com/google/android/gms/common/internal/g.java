package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class g {
    public static final g apQ = k("\t\n\u000b\f\r     　 ᠎ ").a(a(' ', ' '));
    public static final g apR = k("\t\n\u000b\f\r     　").a(a(' ', ' ')).a(a(' ', ' '));
    public static final g apS = a('\u0000', '');
    public static final g apT;
    public static final g apU = a('\t', '\r').a(a('\u001c', ' ')).a(a(' ')).a(a('᠎')).a(a(' ', ' ')).a(a(' ', '​')).a(a(' ', ' ')).a(a(' ')).a(a('　'));
    public static final g apV = new g() {
        public final boolean b(char c) {
            return Character.isDigit(c);
        }
    };
    public static final g apW = new g() {
        public final boolean b(char c) {
            return Character.isLetter(c);
        }
    };
    public static final g apX = new g() {
        public final boolean b(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final g apY = new g() {
        public final boolean b(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final g apZ = new g() {
        public final boolean b(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final g aqa = a('\u0000', '\u001f').a(a('', ''));
    public static final g aqb = a('\u0000', ' ').a(a('', ' ')).a(a('­')).a(a('؀', '؃')).a(k("۝܏ ឴឵᠎")).a(a(' ', '‏')).a(a(' ', ' ')).a(a(' ', '⁤')).a(a('⁪', '⁯')).a(a('　')).a(a('?', '')).a(k("﻿￹￺￻"));
    public static final g aqc = a('\u0000', 'ӹ').a(a('־')).a(a('א', 'ת')).a(a('׳')).a(a('״')).a(a('؀', 'ۿ')).a(a('ݐ', 'ݿ')).a(a('฀', '๿')).a(a('Ḁ', '₯')).a(a('℀', '℺')).a(a('ﭐ', '﷿')).a(a('ﹰ', '﻿')).a(a('｡', 'ￜ'));
    public static final g aqd = new g() {
        public final g a(g gVar) {
            w.Z(gVar);
            return this;
        }

        public final boolean b(char c) {
            return true;
        }

        public final boolean l(CharSequence charSequence) {
            w.Z(charSequence);
            return true;
        }
    };
    public static final g aqe = new g() {
        public final g a(g gVar) {
            return (g) w.Z(gVar);
        }

        public final boolean b(char c) {
            return false;
        }

        public final boolean l(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    };

    private static class a extends g {
        List<g> aql;

        a(List<g> list) {
            this.aql = list;
        }

        public final g a(g gVar) {
            List arrayList = new ArrayList(this.aql);
            arrayList.add(w.Z(gVar));
            return new a(arrayList);
        }

        public final boolean b(char c) {
            for (g b : this.aql) {
                if (b.b(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        g a = a('0', '9');
        g gVar = a;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            gVar = gVar.a(a(c, (char) (c + 9)));
        }
        apT = gVar;
    }

    private static g a(final char c) {
        return new g() {
            public final g a(g gVar) {
                return gVar.b(c) ? gVar : super.a(gVar);
            }

            public final boolean b(char c) {
                return c == c;
            }
        };
    }

    private static g a(final char c, final char c2) {
        w.ad(c2 >= c);
        return new g() {
            public final boolean b(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    private static g k(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return aqe;
            case 1:
                return a(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new g() {
                    public final boolean b(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new g() {
                    public final boolean b(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public g a(g gVar) {
        return new a(Arrays.asList(new g[]{this, (g) w.Z(gVar)}));
    }

    public abstract boolean b(char c);

    public boolean l(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!b(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
