package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

public class HistoryForm implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//フィールド｜購入履歴
	private String userId;

	//メソッド｜フィールドの開示とセット
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
