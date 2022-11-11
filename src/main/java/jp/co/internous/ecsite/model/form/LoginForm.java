package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

//シリアライズを実装
public class LoginForm implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//フィールド｜ログインフォームの入力
	private String userName;
	private String password;
	
	//メソッド｜フィールドの開示/セット
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) { 
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}