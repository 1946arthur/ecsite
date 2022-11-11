package jp.co.internous.ecsite.model.form;

import java.io.Serializable;

//シリアライズを実装
public class GoodsForm implements Serializable{
	
	private static final long serialVersionUID = 1L;

	//フィールド｜商品登録フォームの入力
	private long id;
	private String goodsName;
	private long price;
	
	//メソッド｜フィールドの開示とセット
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
}
