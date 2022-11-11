package jp.co.internous.ecsite.model.dto;

import jp.co.internous.ecsite.model.entity.User;

public class LoginDto {
	
	//フィールド｜ユーザー情報
	private long id;
	private String userName;
	private String password;
	private String fullName;
	
	//コンストラクタ３つ
	//1.初期化せず、別途フィールドを設定
	public LoginDto() {}
	
	//2.Userエンティティを受け取り、フィールドをセット
	public LoginDto(User user) { 
		this.id = user.getId();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this. fullName = user.getFullName();
	}
	
	//3.個別に引数を受け取り、フィールドをセット
	public LoginDto(long id, String userName, String password, String fullName) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
	}

	//メソッド｜フィールドの開示/セット
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
	
