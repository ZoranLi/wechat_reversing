package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final e CREATOR = new e();
    public static final PasswordSpecification alp = new a().jd().P("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").Q("abcdefghijkmnopqrstxyz").Q("ABCDEFGHJKLMNPQRSTXY").Q("3456789").je();
    public static final PasswordSpecification alq = new a().jd().P("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").Q("abcdefghijklmnopqrstuvwxyz").Q("ABCDEFGHIJKLMNOPQRSTUVWXYZ").Q("1234567890").je();
    final String alr;
    final List<String> als;
    final List<Integer> alt;
    final int alu;
    final int alv;
    private final int[] alw = jc();
    private final Random alx = new SecureRandom();
    final int mVersionCode;

    public static class a {
        private final List<String> als = new ArrayList();
        private final List<Integer> alt = new ArrayList();
        private int alu = 12;
        private int alv = 16;
        private final TreeSet<Character> aly = new TreeSet();

        private static TreeSet<Character> h(String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                throw new b(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.bM(c)) {
                    throw new b(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public final a P(String str) {
            this.aly.addAll(h(str, "allowedChars"));
            return this;
        }

        public final a Q(String str) {
            this.als.add(PasswordSpecification.b(h(str, "requiredChars")));
            this.alt.add(Integer.valueOf(1));
            return this;
        }

        public final a jd() {
            this.alu = 12;
            this.alv = 16;
            return this;
        }

        public final PasswordSpecification je() {
            if (this.aly.isEmpty()) {
                throw new b("no allowed characters specified");
            }
            int i = 0;
            for (Integer intValue : this.alt) {
                i = intValue.intValue() + i;
            }
            if (i > this.alv) {
                throw new b("required character count cannot be greater than the max password size");
            }
            boolean[] zArr = new boolean[95];
            for (String toCharArray : this.als) {
                for (char c : toCharArray.toCharArray()) {
                    if (zArr[c - 32]) {
                        throw new b("character " + c + " occurs in more than one required character set");
                    }
                    zArr[c - 32] = true;
                }
            }
            return new PasswordSpecification(1, PasswordSpecification.b(this.aly), this.als, this.alt, this.alu, this.alv);
        }
    }

    public static class b extends Error {
        public b(String str) {
            super(str);
        }
    }

    PasswordSpecification(int i, String str, List<String> list, List<Integer> list2, int i2, int i3) {
        this.mVersionCode = i;
        this.alr = str;
        this.als = Collections.unmodifiableList(list);
        this.alt = Collections.unmodifiableList(list2);
        this.alu = i2;
        this.alv = i3;
    }

    public static String b(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        for (Character charValue : collection) {
            int i2 = i + 1;
            cArr[i] = charValue.charValue();
            i = i2;
        }
        return new String(cArr);
    }

    public static boolean bM(int i) {
        return i < 32 || i > 126;
    }

    private int[] jc() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String toCharArray : this.als) {
            for (char c : toCharArray.toCharArray()) {
                iArr[c - 32] = i;
            }
            i++;
        }
        return iArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
