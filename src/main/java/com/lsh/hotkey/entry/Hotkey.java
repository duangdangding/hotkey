package com.lsh.hotkey.entry;    

import java.io.Serializable;

public class Hotkey implements Serializable {

    //private static final long serialVersionUID = 1L;

    private Integer kId;
    private String hotkey;
    private String kaction;//内容
    private String explain;//注释
    //private Integer keycode;
    private Integer encrypt;//是否加密 0是1否
    
    public void setKId(Integer kId) {
        this.kId = kId;
    }
    public Integer getKId() {
        return this.kId;
    }
    public void setHotkey(String hotkey) {
        this.hotkey = hotkey;
    }
    public String getHotkey() {
        return this.hotkey;
    }
    public void setKaction(String kaction) {
        this.kaction = kaction;
    }
    public String getKaction() {
        return this.kaction;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
    public String getExplain() {
        return this.explain;
    }
	//public Integer getKeycode() {
	//	return keycode;
	//}
	//public void setKeycode(Integer keycode) {
	//	this.keycode = keycode;
	//}
	public Integer getEncrypt() {
		return encrypt;
	}
	public void setEncrypt(Integer encrypt) {
		this.encrypt = encrypt;
	}

	@Override
	public String toString() {
		return "Hotkey{" +
				"kId=" + kId +
				", hotkey='" + hotkey + '\'' +
				", kaction='" + kaction + '\'' +
				", explain='" + explain + '\'' +
				//", keycode=" + keycode +
				", encrypt=" + encrypt +
				'}';
	}
}