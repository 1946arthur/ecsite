package jp.co.internous.ecsite.model.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //エンティティ(実体)として振舞うようにする
@Table(name="purchase") //どのテーブルの実体なのか指定
public class Purchase {
	
	//フィールド｜各カラム
	@Id //プライマリキーであることを指定
	@Column(name="id") //カラムとマッピング
	@GeneratedValue(strategy=GenerationType.IDENTITY) //振る舞いの指定（Auto_increment）
	private long id;
	
	@Column(name="user_id")
	private long userId;
	
	@Column(name="goods_id")
	private long goodsId;
	
	@Column(name="goods_name")
	private String goodsName;
	
	@Column(name="item_count")
	private long itemCount;
	
	@Column(name="total")
	private long total;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	//メソッド｜フィールドのセット/開示
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}
		
	public void setUserId(long userId) {
		this.userId = userId;
	}
		
	public long getGoodsId() { 
		return goodsId;
	}
		
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}
		
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName; 
	}
		
	public long getItemCount() {
		return itemCount;
	}
		
	public void setItemCount(long itemCount) { 
		this.itemCount = itemCount;
	}
	
	public long getTotal() { 
		return total;
	}
	
	public void setTotal(long total) { 
		this.total = total;
	}
		
	public Timestamp getCreatedAt() { 
		return createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
}
