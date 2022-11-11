//ログイン機能（ユーザー専用topページに遷移）
//関数eventを変数loginに代入する
let login = (event) => {
	//submitイベントの本来の動作を止める
	event.preventDefault();
	//ログインフォームの入力からJSONデータの下準備
	let jsonString = {
		'userName': $('input[name=userName]').val(),
		'password': $('input[name=password]').val()				
	};
	//jqueryのajaxを呼び出す（通信実行）
	$.ajax({
		type: 'POST',
		url: '/ecsite/api/login',
		data: JSON.stringify(jsonString), //送るデータ（下準備しているフォームデータをJSON変換）
		contentType: 'application/json', //送るデータJSONと設定
		datatype: 'json', //受け取るデータをJSONと設定
		scriptCharset: 'utf-8'
	})
	//画面（ヘッダー部）表示
	.then((result) => {
			let user = JSON.parse(result); //JavaScriptオブジェクトに変換
			$('#welcome').text(` -- ようこそ！ ${user.fullName} さん`);
			$('#hiddenUserId').val(user.id);
			$('input[name=userName]').val('');
			$('input[name=password]').val('');
		}, () => {
			//エラーメッセージをコンソールに出力
			console.error('Error: ajax connection failed.');
		}
	);
};

//カート機能（カートに商品追加）
let addCart = (event) => {
	let tdList = $(event.target).parent().parent().find('td');
	
	let id = $(tdList[0]).text();
	let goodsName = $(tdList[1]).text();
	let price = $(tdList[2]).text();
	let count = $(tdList[3]).find('input').val();

	if(count === '0' || count === ''){
		alert('注文数が0または空欄です。');
		return;
	}
		
	let cart = {
		'id': id,
		'goodsName': goodsName,
		'price': price,
		'count': count
	};
	cartList.push(cart);
							
	let tbody = $('#cart').find('tbody');
	$(tbody).children().remove();
	cartList.forEach(function(cart, index) {
		let tr = $('<tr />');
					
		$('<td />', { 'text': cart.id }).appendTo(tr);
		$('<td />', { 'text': cart.goodsName }).appendTo(tr);
		$('<td />', { 'text': cart.price }).appendTo(tr);
		$('<td />', { 'text': cart.count }).appendTo(tr);
		let tdButton = $('<td />');
		$('<button />', {
			'text': 'カート削除',
			'class':'removeBtn',
		}).appendTo(tdButton);
					
		$(tdButton).appendTo(tr);
		$(tr).appendTo(tbody);
	});
	$('.removeBtn').on('click', removeCart);
};

//カート削除
let removeCart = (event) => {
	const tdList = $(event.target).parent().parent().find('td');
	let id = $(tdList[0]).text();
	cartList = cartList.filter(function(cart) {
		return cart.id !== id;
	});
	$(event.target).parent().parent().remove();
};

//購入機能
let buy = (event) => {
	//jqueryのajaxを呼び出す（通信実行）
	$.ajax({
		type: 'POST',
		url: '/ecsite/api/purchase',
		data: JSON.stringify({
			'userId': $('#hiddenUserId').val(),
			'cartList': cartList			
		}), //送るデータ（JSON変換）
		contentType: 'application/json', //送るデータJSONと設定
		datatype: 'json', //受け取るデータをJSONと設定
		scriptCharset: 'utf-8'
	})
	//アラート表示
	.then((result) => {
			alert('購入しました。');
		}, () => {
			//エラーメッセージをコンソールに出力
			console.error('Error: ajax connection failed.');
		}
	);
};

//購入履歴
let showHistory = () => {
	//jqueryのajaxを呼び出す（通信実行）
	$.ajax({
		type: 'POST',
		url: '/ecsite/api/history',
		data: JSON.stringify({ "userId": $('#hiddenUserId').val() }), //送るデータ（JSON変換）
		contentType: 'application/json', //送るデータJSONと設定
		datatype: 'json', //受け取るデータをJSONと設定
		scriptCharset: 'utf-8'
	})
	//画面表示
	.then((result) => {
		let historyList = JSON.parse(result); //JavaScriptオブジェクトに変換
		let tbody = $('#historyTable').find('tbody');
		$(tbody).children().remove();
		historyList.forEach((history, index) => {
			let tr = $('<tr />');
				
			$('<td />', { 'text': history.goodsName }).appendTo(tr);
			$('<td />', { 'text': history.itemCount }).appendTo(tr);
			$('<td />', { 'text': history.createdAt }).appendTo(tr);
				
			$(tr).appendTo(tbody);
		});
		$("#history").dialog("open");
	}, () => {
		//エラーメッセージをコンソールに出力
		console.error('Error: ajax connection failed.');
		}
	);
};