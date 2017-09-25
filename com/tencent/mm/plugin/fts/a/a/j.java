package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public final class j extends i {
    public final j e(Cursor cursor) {
        this.mak = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.hPr = cursor.getInt(2);
        this.mam = cursor.getLong(3);
        this.lZO = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.mao = cursor.getString(7);
        }
        return this;
    }

    private void a(Pattern pattern) {
        int i = 0;
        this.mas = pattern.split(this.content);
        this.mat = new int[this.mas.length];
        int i2 = 0;
        while (i < this.mat.length) {
            this.mat[i] = i2;
            i2 += this.mas[i].length() + 1;
            i++;
        }
    }

    public final void axK() {
        if (!bg.mA(this.mao)) {
            switch (this.type) {
                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                case 131073:
                case 131074:
                case 131076:
                case 262144:
                case 327680:
                    String[] split;
                    switch (this.hPr) {
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                            try {
                                split = a.lZy.split(this.mao);
                                a(a.lZC);
                                this.maq = Arrays.binarySearch(this.mat, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                                if (this.maq < 0) {
                                    this.maq = (-this.maq) - 2;
                                }
                                this.mar = this.mas[this.maq];
                                return;
                            } catch (Exception e) {
                                this.maq = Integer.MAX_VALUE;
                                this.mar = "";
                                return;
                            }
                        case 11:
                            try {
                                split = a.lZy.split(this.mao);
                                a(a.lZz);
                                int length = new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length();
                                int binarySearch = Arrays.binarySearch(this.mat, length);
                                if (binarySearch < 0) {
                                    binarySearch = (-binarySearch) - 2;
                                }
                                this.maq = length - this.mat[binarySearch];
                                this.mar = this.mas[binarySearch];
                                return;
                            } catch (Exception e2) {
                                this.maq = Integer.MAX_VALUE;
                                this.mar = "";
                                return;
                            }
                        default:
                            try {
                                this.maq = new String(this.content.getBytes(), 0, Integer.valueOf(a.lZy.split(this.mao)[1]).intValue()).length();
                                this.mar = this.content;
                                return;
                            } catch (Exception e3) {
                                this.maq = Integer.MAX_VALUE;
                                this.mar = "";
                                return;
                            }
                    }
                case 131075:
                    axL();
                    return;
                default:
                    return;
            }
        }
    }

    private void axL() {
        switch (this.hPr) {
            case 38:
                List arrayList = new ArrayList();
                a(a.lZz);
                String[] split = a.lZy.split(this.mao);
                byte[] bytes = this.content.getBytes();
                for (int i = 0; i < split.length; i += 2) {
                    String str;
                    int intValue = Integer.valueOf(split[i]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.mat, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String[] split2 = a.lZA.split(this.mas[binarySearch]);
                    int i2 = length - this.mat[binarySearch];
                    length = 0;
                    while (length < split2.length) {
                        i2 = (i2 - split2[length].length()) - 1;
                        if (i2 < 0) {
                            str = split2[length];
                            i2 = c.lZr[length];
                            if (i2 > 0) {
                                arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                            }
                        } else {
                            length++;
                        }
                    }
                    i2 = -1;
                    str = null;
                    if (i2 > 0) {
                        arrayList.add(new d(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                    }
                }
                this.mau = arrayList;
                return;
            default:
                return;
        }
    }

    public final void d(String[] strArr, String str) {
        if (strArr.length > 1) {
            this.maw = 1;
        } else {
            this.maw = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.lZT += 50;
                String xL = m.xL();
                if (this.hPr == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.mau != null) {
                        for (d dVar : this.mau) {
                            if (!xL.equals(dVar.gtR)) {
                                hashSet.add(Integer.valueOf(dVar.lZP));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.mam - 1) {
                        this.lZT += 20;
                        this.may = true;
                    }
                    if (strArr.length > 1 && this.content.contains(str)) {
                        this.maw = 2;
                        this.lZT += 5;
                    }
                    if (this.mam <= 15) {
                        this.maA = 1;
                    }
                }
                if ((this.hPr == 5 || this.hPr == 1) && this.content.contains(str)) {
                    if (strArr.length > 1) {
                        this.maw = 2;
                    }
                    this.lZT += 10;
                }
            }
        } else if (this.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.lZT += 50;
            }
            if ((this.hPr == 5 || this.hPr == 1) && this.content.contains(str)) {
                if (strArr.length > 1) {
                    this.maw = 2;
                }
                this.lZT += 10;
            }
        }
    }
}
