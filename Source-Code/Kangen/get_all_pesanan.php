<?php
	//kode untuk tampilkan semua produk, pada halaman home
	$response = array();
	
	require_once __DIR__ . '/db_connect.php';
	
	//konekin ke db
	$db = new DB_CONNECT();
	
	//get by pesanan
	$result = mysql_query("SELECT *FROM pesanan") or die(mysql_error());
	
	//cek
	if(mysql_num_rows($result) > 0 ){
		//looping hasil
		//pesanan node
		$response["pesanan"] = array();
		while($row = mysql_fetch_array($result)){
			$pesanan = array();
			$pesanan["id"] = $row["id"];
			$pesanan["nama_pemesan"] = $row["nama_pemesan"];
			$pesanan["alamat"] = $row["alamat"];
			$pesanan["nama_produk"] = $row["nama_produk"];
			$pesanan["ukuran"] = $row["ukuran"];
			$pesanan["harga"] = $row["harga"];
			$pesanan["jumlah"] = $row["jumlah"];
			$pesanan["total_harga"] = $row["total_harga"];
			$pesanan["created_at"] = $row["created_at"];
			$pesanan["updated_at"] = $row["updated_at"];
			//masukan pesanan pada $response
			array_push($response["pesanan"], $pesanan);
		}
		//sukses
		$response["success"] = 1;
		//echo json response
		echo json_encode($response);
	}
	else{
			$response["success"] = 0;
			$response["message"] = "Tidak ada data yang ditemukan";
			//echo no users json
			echo json_encode($response);
		}
?>