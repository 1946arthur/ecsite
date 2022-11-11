package jp.co.internous.ecsite.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //エンティティ(実体)として振舞うようにする
@Table(name="user") //どのテーブルの実体なのか指定
public class User {
	
	//フィールド｜各カラム
	@Id //プライマリキーであることを指定
	@Column(name="id") //カラムとマッピング
	@GeneratedValue(strategy=GenerationType.IDENTITY) //振る舞いの指定（Auto_increment）
	private long id;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="is_admin")
	private int isAdmin;
	
	//メソッド｜フィールドのセット/開示
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
		this. fullName = fullName;
	}
	
	public int getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
}
