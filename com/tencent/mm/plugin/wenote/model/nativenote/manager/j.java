package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spanned;
import com.tencent.mm.plugin.wenote.model.nativenote.a.c;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j implements Serializable {
    private static final Pattern swm = Pattern.compile("\\r\\n|\\r|\\n");
    private int swn = 0;
    public final ArrayList<c> swo = new ArrayList();

    public j(Spanned spanned) {
        boolean z = false;
        if (spanned != null) {
            Object obj = spanned.toString();
            this.swn = 1;
            Matcher matcher = swm.matcher(obj);
            int i = 0;
            while (matcher.find()) {
                boolean z2;
                int end = matcher.end();
                if (this.swn == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.swo.add(new c(i, end, z2, false));
                i = matcher.end();
                this.swn++;
            }
            if (this.swo.size() < this.swn) {
                int length = obj.length();
                if (this.swn == 1) {
                    z = true;
                }
                this.swo.add(new c(i, length, z, true));
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.swo.iterator();
        int i = 1;
        while (it.hasNext()) {
            c cVar = (c) it.next();
            int i2 = i + 1;
            stringBuilder.append(i).append(": ").append(cVar.abH).append("-").append(cVar.wd).append(cVar.sve ? "" : ", ");
            i = i2;
        }
        return stringBuilder.toString();
    }
}
