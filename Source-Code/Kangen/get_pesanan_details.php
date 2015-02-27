<?php
// kode untuk single pesanan
$response = array();
	
	require_once __DIR__ . '/db_connect.php';
	
	//konekin ke db
	$db = new DB_CONNECT();
	//cek data
	if(isset($_GET["id"])){
			$id = $_GET['id'];
			$result = mysql_query("SELECT *FROM pesanan WHERE id = $id");
		if(!empty($result)){
			if(mysql_num_rows($result) > 0 ){
					$result = mysql_fetch_array($result);
					
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
					//maka
					$response["success"] = 1;
					//node
					$response["pesanan"] = array();
					array_push($response["pesanan"], $pesanan);
					//enchoing json response
					echo json_encode($response);
			}	else{
					//jika kosong
					$response["success"] = 0;
					$response["message"] = "Tidak ada data";
				
					echo json_encode($response);
			}
		} 
		else{
					$response["success"] = 0;
					$response["message"] = "Tidak ada data";
				
					echo json_encode($response);
			}
		} 
?>