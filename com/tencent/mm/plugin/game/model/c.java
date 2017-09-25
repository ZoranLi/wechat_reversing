package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.bb;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;

public final class c extends f {
    public String fDE = "";
    public int fLG = 0;
    public int fTL = 0;
    public String jhe = "";
    public String moA = "#929292";
    public String moB = "";
    public String moC = "";
    public boolean moD = false;
    public String moE = "";
    public String moF = "";
    public String moG = "";
    public LinkedList<String> moH = new LinkedList();
    public String moI = "";
    public LinkedList<String> moJ = new LinkedList();
    public boolean moK = false;
    public boolean moL = false;
    public String moM = "";
    public String moN = "#fca28a";
    public String moO = "";
    public String moP = "#222222";
    public String moQ = "";
    public boolean moR = false;
    public String moS = "";
    public long moT = 0;
    public int moU = 0;
    public bb moV;
    public String moy = "";
    public String moz = "";
    public String name = "";
    public int position = 1;
    public int scene = 0;
    public int status = 0;
    public int type = 0;
    public int versionCode = 0;

    public final boolean aAy() {
        return ((this.moU != 1 && this.moU != 2) || this.moV == null || bg.mA(this.moV.muR)) ? false : true;
    }
}
