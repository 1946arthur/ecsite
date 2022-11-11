package jp.co.internous.ecsite.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //エンティティ(実体)として振舞うようにする
@Table(name="goods") //どのテーブルの実体なのか指定
public class Goods {
	
	//フィールド｜各カラム
	@Id //プライマリキーであることを指定
	@Column(name="id") //カラムとマッピング
	@GeneratedValue(strategy=GenerationType.IDENTITY) //振る舞いの指定（Auto_increment）
	private long id;
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="price")
	private long price;
	
	@Column(name="updated_at")
	private Timestamp updatedAt;
	
	//メソッド｜フィールドのセット/開示
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getGoodsName() {
		return goodsName;
	}
	
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	
	public long getPrice() {
		return price;
	}
	
	public void setPrice(long price) {
		this.price = price;
	}
	
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
}
